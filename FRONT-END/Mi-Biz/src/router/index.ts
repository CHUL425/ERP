import { createRouter, createWebHashHistory } from 'vue-router';

import temp_ods from '@/views/mobile/ods.vue';
import sample from '@/views/mobile/sample.vue';
import notFound from '@/views/404/index.vue';
import pcPrevention from '@/views/404/pcPrevention.vue';
import detailImg from '@/components/mobile/DetailImg.vue';

const routes = [
    {
        path: '/rot',
        name: 'rot',
        component: temp_ods,
        props: (route: any) => {
            if (route.query.mnTyp === '09' || route.query.mntyp === '09') {
                return { isPreReference: '2' };
            } else {
                return { isPreReference: '1' };
            }
        }
    },
    {
        path: '/:pathMatch(.*)*',
        redirect: '/404'
    },
    {
        path: '/sample',
        name: 'sample',
        component: sample
    },
    {
        path: '/404',
        name: 'notFound',
        component: notFound
    },
    {
        path: '/isMobile',
        name: 'pcPrevention',
        component: pcPrevention
    },
    {
        path: '/detailImg',
        name: 'detailImg',
        component: detailImg
    }
];

// 라우터 생성 -> /#로 설정
const router = createRouter({
    history: createWebHashHistory(),
    routes
});

router.beforeEach(async (to, from, next) => {
    if (!isMobilePage() && to.path !== '/isMobile') {
        if (queryCheck() || hybridCheck()) {
            return next({ path: '/isMobile' });
        } else {
            next();
        }
    } else {
        next();
    }

    // PC 접속 방지
    function isMobilePage() {
        const userAgent = navigator.userAgent;
        if (
            userAgent.match(
                /iPhone|iPod|iPad|Android|Windows CE|BlackBerry|Symbian|Windows Phone|webOS|Opera Mobi|POLARIS|IDMobile|lgtelecom|nokia|SonyEricsson/i
            ) != null ||
            userAgent.match(/LG|SAMSUNG|Samsung/) != null ||
            navigator.maxTouchPoints == 5 ||
            userAgent.match(/like Mac OS X/i)
        ) {
            return true;
        } else {
            return false;
        }
    }

    // 쿼리스트링 여부
    function queryCheck() {
        if (to.path === '/rot') {
            if (to.query.CAUTK === undefined || to.query.ID === undefined) {
                return true;
            } else {
                return false;
            }
        }
    }

    function hybridCheck() {
        const check = /COVI_HYBRID/i.test(window.navigator.userAgent.toUpperCase());
        if (check) {
            return true;
        } else {
            return false;
        }
    }
});

export default router;
