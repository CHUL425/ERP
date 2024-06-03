import { fnAxios } from '../module/index';
import { RQSR1000U0In20VO, RQSR1000U0In21VO, RQAM2000V0Out01VO, RQAM1000U0In01VO, RQAM1000U0In02VO } from './type';

const mobile = {
    selectCmpn: (data: RQSR1000U0In20VO) => {
        // 인감날인증명서 승인완료 목록조회
        return fnAxios('POST', '/api/main/rqsr1000u0/selectListApvCmpn', '', data);
    },
    selectIng: (data: RQSR1000U0In21VO) => {
        // 인감날인증명서 승인대기 목록조회
        return fnAxios('POST', '/api/main/rqsr1000u0/selectListApvIng', '', data);
    },
    getSleApvRef: (data: RQAM2000V0Out01VO) => {
        // 인감날인증명서 사전참조 조회
        return fnAxios('POST', '/api/main/rqsr1000u0/selectListApvRef', '', data);
    },
    //승인 처리 - 다건
    getAprvList: (data: RQAM1000U0In01VO) => {
        return fnAxios('POST', '/api/main/rqam1000u0/aprvList', '', data);
    },
    //승인/반려 처리 - 단건
    getAprv: (data: RQAM1000U0In02VO) => {
        return fnAxios('POST', '/api/main/rqam1000u0/aprv', '', data);
    },
    //반려 처리 - 단건
    getRtrn: (data: any) => {
        return fnAxios('POST', '/api/main/rqam1000u0/rtrn', '', data);
    },
    updateCfmt: (data: any) => {
        // 인감날인증명서 사전참조 다건 확인처리
        return fnAxios('POST', '/api/main/rqsr1000u0/updateGA09N607ForCfmt', '', data);
    },
    mobileLogin: (data: any) => {
        return fnAxios('POST', '/api/common/login/ssoMobile', '', data);
    },
    pcLogin: (data: any) => {
        return fnAxios('POST', '/api/common/login/sso', '', data);
    },
    selectDetailList: (data: any) => {
        // 인감날인증명서신청 상세조회
        return fnAxios('POST', '/api/main/rqsr1000u0/selectUnifRqsBySeal', '', data);
    },
    selectFilePath: (data: any) => {
        // 파일 경로 조회
        return fnAxios('POST', '/api/common/file/downFileNew', '', data);
    }
};

export { mobile };
