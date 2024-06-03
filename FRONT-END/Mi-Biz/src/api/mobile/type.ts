export interface RQSR1000U0In04VO {
    rctNo: string;
    // 접수번호
}

export interface RQSR1000U0In03VO {
    gridGA01N109: Array<any>;
    // 기안문서 다건내역

    gridGA01N504: Array<any>;
    // 인장신청_인감날인신청 다건내역

    gridGA01N505: Array<any>;
    // 인장신청_인감증명서신청 다건내역

    prcTp: string;
    // 처리구분 : 00 - 임시저장, 01 - 상신

    rctNo: string;
    // 접수번호:기데이터 수정일경우 필수입력

    rqsEpno: string;
    // 신청사원번호

    rqsOrzCd: string;
    // 신청조직코드

    rqsTtlNm: string;
    // 신청제목명

    unifRqsPcd: string;
    // 신청유형코드 05 - 인감날인신청
}

export interface RQSR1000U0In00VO {
    pageIndex: number;
    // 페이지순번

    pageSize: number;
    // 페이지사이즈

    qryEndDt: string;
    // 조회종료일자

    qryStrtDt: string;
    // 조회시작일자

    rqsEpno: string;
    // 신청사원번호

    rqsOrzCd: string;
    // 신청조직코드

    rqsTtlNm: string;
    // 신청제목명
}

export interface RQSR1000U0In20VO {
    lginEpno: string;
    // 로그인사번 입력세팅안해도됨

    lginOrzCd: string;
    // 로그인조직코드 입력세팅안해도됨

    pageIndex: number;
    // 페이지순번

    pageSize: number;
    // 페이지사이즈

    qryEndDt: string;
    // 조회종료일자

    qryStrtDt: string;
    // 조회시작일자

    rqsOrzCd: string;
    // 신청조직코드

    rqsScd: string;
    // 신청상태코드
}

export interface RQSR1000U0In21VO {
    aprvWrrptOrzCd: string;
    // 결재상신조직코드

    hrOsdtCd: string;
    // 로그인직책코드 입력세팅안해도됨

    lginEpno: string;
    // 로그인사번 입력세팅안해도됨

    lginOrzCd: string;
    // 로그인조직코드 입력세팅안해도됨

    pageIndex: number;
    // 페이지순번

    pageSize: number;
    // 페이지사이즈

    rqsTtlNm: string;
    // 신청제목명
}

export interface RQSR1000U0In01VO {
    rctNo: string;
    // 접수번호
}

export interface RQAM2000V0Out01VO {
    aprvWrrptMtNo: string;
    aprvWrrptOrzCd: string;
}

export interface RQAM1000U0In00VO {
    //결재자사원번호
    aprvEpno: string;
    //결재상신조직코드
    aprvWrrptOrzCd: string;
    //업무구분
    bizTcd: string;
    //페이지순번
    pageIndex: number;
    //페이지사이즈
    pageSize: number;
    //상신자명
    wrrptEpNm: string;
    //상신자사원번호
    wrrptEpno: string;
}

export interface RQAM1000U0In01VO {
    aprvEpno: string;
    grid11: Array<any>;
}

export interface RQAM1000U0In02VO {
    aprvDlRnk: string;
    //결재상세순위
    aprvEpno: string;
    //결재자사원번호
    aprvPcd: string;
    //결재유형코드
    aprvRnk: string;
    //결재순위
    aprvRsnCn: string;
    //결재사유내용
    aprvRtrnTcd: string;
    //결재반려구분코드
    aprvWrrptMtNo: string;
    //결재상신관리번호
    rctNo: string;
    //접수번호
}

export interface RQAM2000V0Out00VO {
    qryStrtDt: string;
    qryEndDt: string;
    bizTcd: string;
    rqsOrzCd: string;
    pageSize: number;
    pageIndex: number;
}

export interface RQAM2000V0Out01VO {
    aprvWrrptNo: string;
}

export interface RENTInVo {
    rctNo: string;
}
