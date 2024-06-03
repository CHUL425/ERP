import router from '@/router';

export default {
    install(Vue: any) {
        Vue.config.globalProperties.$router = router;
    }
};
