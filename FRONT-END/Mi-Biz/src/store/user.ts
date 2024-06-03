import { defineStore } from 'pinia';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

export const useUserStore = defineStore('user', () => {
    const userInfo = ref(<UserInfo>{});

    function getUserInfo() {
        if (!userInfo.value.epno) {
            const localUserInfo = localStorage.getItem('userInfo');
            if (localUserInfo) {
                userInfo.value = JSON.parse(localUserInfo);
            }
        }
        return userInfo;
    }

    function setUserInfo(newUserInfo: UserInfo) {
        userInfo.value = newUserInfo;
        localStorage.setItem('userInfo', JSON.stringify(newUserInfo));
    }

    function loginInfo(page: any) {}

    function deleteUserInfo() {
        userInfo.value = {
            accsAblOrzCd: [],
            userGrpCdList: [],
            accsAblMenu: []
        };
        localStorage.removeItem('userInfo');
    }

    const router = useRouter();
    function logout() {
        deleteUserInfo();
        router.push({ name: '로그인' });
    }

    function hasAuthGroup(authName: string) {
        return userInfo.value.accsAblOrzCd?.includes(authName) || false;
    }
    function hasGroupCd(menuName: string) {
        return userInfo.value.userGrpCdList?.includes(menuName) || false;
    }

    return { userInfo, setUserInfo, getUserInfo, logout, hasAuthGroup, hasGroupCd, loginInfo };
});

interface UserInfo {
    epno?: string; // 사번 (3360135)
    epNm?: string;
    epEngNm?: string;
    jncoDt?: string;
    rtmtDt?: string;
    blngOrzCd?: string;
    aptmNowWrkpOrzCd?: string;
    nowWrkpOrzCd?: string;
    hrOrzCd?: string;
    hrHldoCd?: string;
    epIdfyTcd?: string;
    rpsrEpno?: string;
    epBzTcd?: string;
    sexTcd?: string;
    xempIdfyNoEcpVl?: string;
    hrEpTcd?: string;
    hrPstCd?: string;
    hrPstYrord?: string;
    hrOsdtCd?: string;
    hrOcgrpCd?: string;
    ctno?: string;
    rtn?: string;
    mtno?: string;
    itno?: string;
    intaTlno?: string;
    hndpBzprTlno?: string;
    hndpMtno?: string;
    hndpItno?: string;
    emalAdr?: string;
    zpcd?: string;
    adr?: string;
    pwdEcpVl?: string;
    pwdErrNc?: string;
    pwdLstChngDt?: string;
    bzPwdEcpVl?: string;
    bzPwdErrNc?: string;
    bzPwdLstChngDt?: string;
    drtBrBzPrcAblYn?: string;
    empSortSeq?: string;
    csCntrEmpMtCd?: string;
    csCntrRpsrYn?: string;
    csCntrRpsrEpno?: string;
    apvrTcd?: string;
    chbfEpno?: string;
    empOfcTlno?: string;
    hrLstAltrDt?: string;
    hrRflcDt?: string;
    optrId?: string;
    oprtChnlCd?: string;
    oprtOrzCd?: string;
    oprtIpAdr?: string;
    oprtDttm?: string;
    connIp?: string;
    orzNm?: string;
    admnYn?: string;
    accsAblOrzCd: Array<string>;
    userGrpCdList: Array<any>;
    accsAblMenu: Array<any>;
}
