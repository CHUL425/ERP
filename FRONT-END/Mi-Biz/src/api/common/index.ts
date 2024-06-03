import { fnAxios, axiosBaseConfig } from '../module/index';
import Axios from 'axios';
import { urls } from '@/api/common/url';
import { commonModel1, commonModel2, commonModel4, commonModel5, commonModel6, commonModel7, commonModel8 } from '@/api/common/type';

const common = {
    getMenuList: () => {
        return fnAxios('POST', urls.getMenuList, '');
    },
    addFavorite: (data: any) => {
        return fnAxios('POST', 'api/common/auth/ga09n207/ins', '', data);
    },
    deleteFavorite: (data: any) => {
        return fnAxios('POST', 'api/common/auth/ga09n207/del', '', data);
    },
    showFavorite: () => {
        return fnAxios('POST', 'api/common/auth/ga09n207/sel', '');
    },
    getMsgState: (data: any) => {
        return fnAxios('POST', 'api/common/msg/state', '', data);
    },
    getCommonCode: (data: commonModel1) => {
        return fnAxios('POST', urls.commonSelList, '', data);
    },
    getATCommonCode: (data: any) => {
        return fnAxios('POST', urls.commonATcodeList, '', data);
    },
    getGroupList: (data: commonModel2) => {
        return fnAxios('POST', urls.getGroupList, '', data);
    },
    getUserList: (data: commonModel5) => {
        return fnAxios('POST', urls.getUserList, '', data);
    },
    getCmdsList: (data: commonModel6) => {
        return fnAxios('POST', urls.getCmdsList, '', data);
    },
    getCmps1000List: (data: commonModel7) => {
        return fnAxios('POST', urls.getCmps1000List, '', data);
    },
    getCmbs1000List: (data: commonModel8) => {
        return fnAxios('POST', urls.getCmbs1000List, '', data);
    },
    getCmbs1000Detail: (data: any) => {
        return fnAxios('POST', '/api/ssbs/ssbs9000v0/selectGA01C001', '', data);
    },
    rentalApply: (data: any) => {
        return fnAxios('POST', urls.rentalApply, '', data);
    },
    getAddrList: (data: any) => {
        return fnAxios('POST', urls.getAddrList, '', data);
    },
    getSearchList: (data: any) => {
        return fnAxios('POST', '/api/common/auth/selectSrch', '', data);
    },
    getAlarmList: (data: any) => {
        return fnAxios('POST', '/api/common/auth/IprtList', '', data);
    },
    readAlarm: (data: any) => {
        return fnAxios('POST', '/api/common/auth/IprtReadYn', '', data);
    },
    filesViewer: (data: any) => {
        const { fileKey, userId } = data;
        return Axios(axiosBaseConfig<any>('GET', urls.filesViewer(fileKey, userId)));
    },
    filesDownload: (fileKey: any, userId: any) => {
        return Axios(axiosBaseConfig<any>('GET', urls.filesDownload(fileKey, userId)));
    }
};

export { common };
