<script setup lang="ts">
import { ref, onMounted } from 'vue';
import api from '@/api';
import AprvDetail from '@/components/mobile/AprvDetail.vue';
import { formatDate } from '@/composables/useGlobal';
import { useRoute } from 'vue-router';

const route = useRoute();
const emit = defineEmits(['cntUpdate']);

const INIT_SEARCH_PARAM = {
    rqsTtlNm: '',
    aprvWrrptOrzCd: '',
    dcfcPcd: '09',
    selTyp: 'rqsr',
    bizTcd: '05',
    pageSize: 99999,
    pageNum: 1
};

const INIT_UI_DATA = {
    listData: [],
    selectItem: {}
};

const dataParam: any = ref({ ...INIT_SEARCH_PARAM });
const dataUI: any = ref({ ...INIT_UI_DATA });

const userCd = ref('');
const token: any = ref('');
const userId: any = ref('');
const isOpen = ref(false);

onMounted(() => {
    route.query.mnTyp = '09';
    token.value = route.query.CAUTK;
    userId.value = route.query.ID;
    tryLogin();
    searchData();
});

async function tryLogin() {
    if (token.value) {
        const param = {
            CAUTK: token.value
        };
        const res: any = await api.mobile.mobileLogin(param);
        if (res?.data?.data?.length) {
            userCd.value = res.data.data[0].epno;
        }
    }

    if (userId.value) {
        const param = {
            userId: userId.value
        };
        const res: any = await api.mobile.pcLogin(param);
        if (res?.data?.data?.length) {
            userCd.value = res.data.data[0].epno;
        }
    }
}

import router from '@/router';
async function searchData() {
    const res: any = await api.mobile.getSleApvRef(dataParam.value);

    if (res?.data?.length) {
        dataUI.value.listData = res.data;
        dataUI.value.listData.forEach((item: any) => {
            item.isActive = false;
            item.state = 'preRfr';
        });

        if (route.query.rctNo) {
            const check = dataUI.value.listData.some((element: any) => {
                if (element.rctNo === route.query.rctNo) {
                    element.isActive = !element.isActive;
                    isOpen.value = !isOpen.value;
                    dataUI.value.selectItem = element;
                    return element.rctNo === route.query.rctNo;
                }
            });
            if (check === false) {
                if (token.value) {
                    router.replace({ name: 'rot', query: { CAUTK: userCd.value, mnTyp: '09', rctNo: '' } });
                }
                if (userId.value) {
                    router.replace({ name: 'rot', query: { ID: userCd.value, mnTyp: '09', rctNo: '' } });
                }

                isOpen.value = false;
            }
        } else {
            isOpen.value = false;
        }
    } else {
        dataUI.value.listData = [];
    }
    emit('cntUpdate');
}

function toggleAccordion(item: any) {
    dataUI.value.listData.some((element: any) => {
        if (element.isActive === true) {
            element.isActive = false;
            dataUI.value.listData.some((element: any) => {
                if (element.rctNo === item.rctNo) {
                    item.isActive = !item.isActive;
                    element.isActive = !element.isActive;
                    isOpen.value = !isOpen.value;
                    dataUI.value.selectItem = item;
                    return element.rctNo === item.rctNo;
                }
            });
        } else {
            if (element.rctNo === item.rctNo) {
                element.isActive = !element.isActive;
                isOpen.value = !isOpen.value;
                dataUI.value.selectItem = item;
            }
        }
    });
}
</script>

<template>
    <div class="mb_table">
        <table>
            <thead>
                <tr>
                    <th>신청일</th>
                    <th>신청명</th>
                    <th>진행상태</th>
                </tr>
            </thead>
            <template v-if="dataUI.listData.length > 0">
                <tbody v-for="(item, idx) in dataUI.listData" :key="idx">
                    <tr @click="toggleAccordion(item)">
                        <td class="tac">{{ formatDate(item.rqsDt) }}</td>
                        <td class="pl8" style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap">{{ item.rqsTtlNm }}</td>
                        <td class="tac">
                            <span
                                class="status_caption"
                                :class="{
                                    ing: item.rqsScdNm === '승인중',
                                    succ: item.rqsScdNm === '승인완료',
                                    return: item.rqsScdNm === '반려',
                                    retract: item.rqsScdNm === '철회',
                                    temporary: item.rqsScdNm === '임시저장',
                                    finish: item.rqsScdNm === '완료'
                                }"
                                >{{ item.rqsScdNm }}</span
                            >
                        </td>
                    </tr>

                    <AprvDetail v-if="isOpen && dataUI.listData[idx].isActive" :data="dataUI.selectItem" @onChange="searchData()" />
                </tbody>
            </template>
            <template v-else>
                <tbody>
                    <tr class="emptyTb">
                        <td colspan="3"><strong class="emptyMsg">표기할 데이터가 없어요.</strong></td>
                    </tr>
                </tbody>
            </template>
        </table>
    </div>
</template>

<style scoped>
.mb_table {
    display: flex;
    width: 100%;
    padding: 24px;

    .status_caption {
        display: inline-block;
        line-height: 25px;
        width: 65px;
        height: 25px;
        border-radius: 100px;
        text-align: center;
    }
    .succ {
        background: #f58228;
        border: 1px solid #d4d4d4;
        color: #fff;
    }
    .return {
        background: rgba(233, 32, 32, 0.1);
        border: 1px solid #e92090;
        color: #e92090;
    }

    .ing {
        background: rgba(255, 158, 30, 0.1);
        border: 1px solid #ff9e1e;
        color: #ff9e1e;
    }

    .retract {
        background: rgba(194, 172, 151, 0.1);
        border: 1px solid #c2ac97;
        color: #c2ac97;
    }

    .temporary {
        background: #f1f1f1;
        border: 1px solid #d4d4d4;
        color: #999999;
    }

    .finish {
        background: #999;
        color: #fff;
    }

    table {
        width: 100%;
        table-layout: fixed;
    }
    th {
        text-align: center;
        font-size: 14px;
        padding-bottom: 16px;
        border-bottom: 1px solid #f1f1f1;
    }
    td {
        color: #666666;
        padding-top: 16px;
        padding-bottom: 16px;
        border-bottom: 1px solid #f1f1f1;
        font-size: 12px;
    }

    .tac {
        text-align: center;
    }
}

.emptyTb {
    height: 200px;
    width: 100%;
    text-align: center;

    .emptyMsg {
        line-height: 180px;
    }
}
</style>
