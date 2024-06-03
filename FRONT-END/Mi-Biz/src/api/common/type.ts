export interface commonModel1 {
    cdKndNo: string;
    cmnCdVl: string;
    pageIndex: number;
    pageSize: number;
}

export interface commonModel2 {
    hobrTcd?: string;
    //본지점구분코드

    orzCd?: string;
    //조직코드

    orzLevlVl?: string;
    //조직레벨값

    orzNm?: string;
    //조직명

    orzUseYn?: string;
    //조직사용여부

    pageIndex: number;
    //페이지순번

    pageSize: number;
    //페이지사이즈
}

export interface commonModel5 {
    epNm?: string;
    //사원명

    epno?: string;
    //사원번호

    nextEpno?: string;
    //다음사원번호

    nextHrHldoCd?: string;
    //다음인사제직코드

    orzCd?: string;
    //조직코드

    orzNm?: string;
    //조직명

    pageIndex: number;
    //페이지순번

    pageSize: number;
    //페이지사이즈

    rtmprIcldYn?: string;
    //퇴직자제외여부
}

export interface commonModel8 {
    acsjCd: string;
    //계정코드/명

    acsjGcd?: string;
    //example: 특정레벨계정과목 조회시(4,5,6만 가능)
    //계정과목등급코드

    pageIndex: number;
    //페이지순번

    pageSize: number;
    //페이지사이즈
}

export interface commonModel7 {
    pageIndex?: number;
    //페이지순번

    pageSize?: number;
    //페이지사이즈

    srchKwrd?: string;
    //검색키워드
}

export interface commonModel6 {
    aprvEndDt: string;
    //승인종료일자

    aprvStrtDt: string;
    //승인시작일자

    drftDocNo?: string;
    //기안문서번호/명

    drftOrzCd?: string;
    //조직코드/명

    pageIndex: number;
    //페이지순번

    pageSize: number;
    //페이지사이즈

    regiEpno?: string;
    //사원번호/명
}

export interface commonModel3 {
    eqmtTcd?: string;
    //장비구분코드

    gdsNm?: string;
    //제품명

    rctDlNo?: string;
    //접수상세번호;

    rctNo?: string;
    //접수번호

    rentCntcNo?: string;
    //임대계약번호

    rqsRqmPtcrCn?: string;
    //신청요청사항내용
}

export interface commonModel4 {
    grid12?: commonModel3[];
    //렌탈신청 제품정보

    hopeDt?: string;
    //희망일자

    istPlcNm?: string;
    //설치장소명

    prcTp?: string;
    //처리구분: 00-임시저장 01-상신

    rqsEpno?: string;
    //신청사원번호

    rqsEqmtTcd?: string;
    //신청장비구분코드

    rqsOrzCd?: string;
    //신청조직코드

    unifRqsPcd?: string;
    //신청유형코드

    rqsRsnCn?: string;
    //신청사유내용

    rqsScd?: string;
    //신청상태코드

    rqsTtlNm?: string;
    // 신청제목명
}
