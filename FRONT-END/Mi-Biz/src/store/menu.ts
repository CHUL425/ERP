import { defineStore } from 'pinia';
import { ref } from 'vue';
import api from '@/api';

export const useMenuStore = defineStore('favorite', () => {
    interface Menu {
        psitMenuId: string;
        menuNm: string;
        hrkMenuId: string; // 최상위 null
        menuDpthVl?: string; // 최상위 ?
        urlAdr?: string;
        useYn?: string;
        scrnOputSqn?: string;
        psitScrnId: string;
        scrnNm: string;
        enpAccsAblYn: string;
        favoriteYn: string;
        qryAblYn?: string; // 문의 대기
        prcAblYn?: string; // 문의 대기
        children?: Array<Menu>;
        icon?: string; // TODO 문의필요
    }

    const treeOrigin = ref<Array<Menu>>([]);
    const treeMenu = ref<Array<Menu>>([]);
    const treeFavorite = ref<Array<Menu>>([]);

    async function getMenuTree() {
        const res = await api.common.getMenuList();
        // const res = { data: TEST_RESULT };
        if (res?.data?.length) {
            treeOrigin.value = res.data;
            setMenuTree(res.data);
        }
    }

    function clearMenuList() {
        treeOrigin.value = [];
        treeMenu.value = [];
        treeFavorite.value = [];
    }

    function setMenuTree(result: Array<Menu>) {
        result.sort((a, b) => Number(a?.scrnOputSqn || '0') - Number(b?.scrnOputSqn || '0'));
        treeMenu.value = treeFormatter(result.filter((item) => item.qryAblYn === '1'));
        treeFavorite.value = treeFormatter(
            result.filter((item) => item.qryAblYn === '1' && (item.favoriteYn === '1' || item.menuDpthVl === '1'))
        );
        console.log('treeMenu', treeMenu.value);
        console.log('treeFavorite', treeFavorite.value);
    }

    function treeFormatter(origin: Menu[]): Menu[] {
        let originTree = JSON.parse(JSON.stringify(origin));
        let biggestDepth = getDeepDepth(originTree);

        for (biggestDepth; 1 < biggestDepth; biggestDepth--) {
            pushToParent(originTree, biggestDepth);
            filterUsedMenu(biggestDepth);
        }
        return originTree;

        function filterUsedMenu(usedDepth: number) {
            originTree = originTree.filter((item: any) => item.menuDpthVl !== usedDepth.toString());
        }

        function pushToParent(menuList: Menu[], biggestDepth: number) {
            menuList.forEach((item) => {
                if (item.menuDpthVl === biggestDepth.toString()) {
                    const parent = menuList.find((tempParent) => tempParent.psitMenuId === item.hrkMenuId);
                    if (parent) {
                        if (parent.children) {
                            parent.children.push(item);
                        } else {
                            parent.children = [item];
                        }
                    }
                }
            });
        }

        function getDeepDepth(menuList: Menu[]): number {
            let biggestDepth = 0;
            menuList.forEach((item) => {
                if (item.menuDpthVl) {
                    const depth = Number(item.menuDpthVl);
                    if (depth > biggestDepth) {
                        biggestDepth = depth;
                    }
                }
            });

            return biggestDepth;
        }
    }

    return { getMenuTree, setMenuTree, clearMenuList, treeOrigin, treeMenu, treeFavorite };
});
