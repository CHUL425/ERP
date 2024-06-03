/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0Dao.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인감날인증명서신청 DAO
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.dao;

import java.util.List;
import java.util.Map;

import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA01N109VO;
import com.miraeasset.biz.common.meta.vo.GA01N504VO;
import com.miraeasset.biz.common.meta.vo.GA01N505OutQ1VO;
import com.miraeasset.biz.common.meta.vo.GA01N505OutQ2VO;
import com.miraeasset.biz.common.meta.vo.GA01N505VO;
import com.miraeasset.biz.common.meta.vo.GA01N510VO;
import com.miraeasset.biz.common.meta.vo.GA09N607VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In00VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In01VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In19VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In20VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In24VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In26VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out00VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out05VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out11VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out15VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out17VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out18VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out19VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out20VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out23VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out24VO;

public interface RQSR1000U0Dao {

	/* 인감날인증명서신청 목록조회 */	
    List<RQSR1000U0Out00VO> selectListGA01N101BySeal(RQSR1000U0In00VO vo);
    
	/* 인장신청_인감날인신청신청상태 정보조회 */	
    RQSR1000U0Out11VO selectInfoGA01N101BySeal(RQSR1000U0In00VO vo);
	
	/* 인장신청_인감날인신청 목록조회 */	
    List<GA01N504VO> selectListGA01N504(GA01N504VO vo);
   
	/* 인장신청_인감증명서신청 목록조회 */	
    List<GA01N505VO> selectListGA01N505(GA01N505VO vo);
    
	/* 출고 - 증명서 목록조회 */	
    List<GA01N505OutQ1VO> selectListGA01N505BySalMtNoWithQ1(GA01N505VO vo);
    
	/* 출고 - 등기부등본 목록조회 */	
    List<GA01N505OutQ2VO> selectListGA01N505BySmtpCnWithQ2(GA01N505VO vo);
    
	/* 통합신청_신청별기안문서 목록조회 */	
    List<GA01N109VO> selectListGA01N109(GA01N109VO vo);    
    
	/* 인감날인증명서 승인완료 목록조회 */	
    List<RQSR1000U0Out20VO> selectListApvCmpn(RQSR1000U0In20VO vo);  
    int selectListApvCmpnTotCnt(RQSR1000U0In20VO vo);
	/* 인감날인증명서 승인완료 신청상태 정보조회 */	
    RQSR1000U0Out11VO selectListApvCmpnBySeal(RQSR1000U0In20VO vo);
	
    /* 통합신청상세조회 */
    GA01N101VO selectGA01N101(GA01N101VO vo);
    
	/* 인장신청_인감날인신청 신규등록 */	
    int insertGA01N504(GA01N504VO vo);
	/* 인장신청_인감날인신청 접수번호기준 삭제 */	
    int deleteGA01N504ByRctNo(GA01N504VO vo);    
    /* 인장신청_인감날인신청 수정 */	
    int updateGA01N504(GA01N504VO vo);
    
	/* 인장신청_인감증명서신청 신규등록 */	
    int insertGA01N505(GA01N505VO vo);      
    /* 인장신청_인감증명서신청 수정 */	
    int updateGA01N505(GA01N505VO vo);  
	/* 인장신청_인감증명서신청 접수번호기준 삭제 */	
    int deleteGA01N505ByRctNo(GA01N505VO vo);    
    
	/* 통합신청기안문서 신규등록 */	
    int insertGA01N109(GA01N109VO vo);      
	/* 통합신청기안문서 접수번호기준 삭제 */	
    int deleteGA01N109ByRctNo(GA01N109VO vo);    
	/* 통합신청기안문서 삭제 */	
    int deleteGA01N109(GA01N109VO vo);  
    
	/* 통합신청_신청관리 신규등록 */	
    int insertGA01N101(GA01N101VO vo);    
	/* 통합신청_신청관리 수정 */	
    int updateGA01N101(GA01N101VO vo);    
	/* 통합신청_신청관리 접수번호기준 삭제 */	
    int deleteGA01N101ByRctNo(GA01N101VO vo);   
    
	/* 인감날인 사전참조 다건 확인처리 */	
    int updateGA09N607ForCfmt(GA09N607VO vo);        
    /* 인감날인증명서신청 건수 조회 */	
    RQSR1000U0Out05VO selectSalgSealDocCnt(String rctNo);
	/* 인장날인 반려 건 자동 재신청 */
	int reApplyByRctNo(Map<String,Object> map);
	/* 인장날인 재신청 - 인장날인 */
	int reApplyGA01N504(Map<String,Object> map);
	/* 인장날인 재신청 - 증명서 */
	int reApplyGA01N505(Map<String,Object> map);	
	
	/* 입고폐기관리 증명서유형 조회 */
	List<RQSR1000U0Out15VO> selectListSealDocPcd();
	
    /* 증명서번호 MAX,MIN값 조회 */
	GA01N510VO selectGA01N510MNo(GA01N510VO vo);
	
	/* 인감신청_인감증명서관리 입고*/
	int insertGA01N510(List<GA01N510VO> list);
	/* 인감신청_인감증명서관리 폐기*/
	int updateGA01N510Dsus(GA01N510VO vo);
	/* 증명서번호 MAX값 조회 */
	String selectGA01N510MaxNo(GA01N510VO vo);
	
	/* 입고/폐기관리 목록조회 */	
    List<RQSR1000U0Out19VO> selectListGA01N510(RQSR1000U0In19VO vo);
    /* 입고/폐기관리 증명서잔고현황 조회 */	
	List<RQSR1000U0Out18VO> selectListGA01N510BalPstt(RQSR1000U0In19VO vo);
	/* 완료 당일잔여수량 조회 */
	List<RQSR1000U0Out17VO> selectInfoGA01N510BalPstt();
	/* 인감증명서 신청여부*/
	int selectGA01N505ExistYn(String rctNo);

    /* 인감증명서 출력가능 여부 */
    boolean selectGA01N101SameDayYn(String rctNo);
    /* 인감증명서 출력가능수량 */
    int selectGA01N510AblCnt(RQSR1000U0In24VO vo);
	/* 인감증명서 출력*/
	int updateGA01N510Oput(RQSR1000U0In24VO vo);
	/* 등기부등본 출력*/
	int updateGA01N510CertDocOput(RQSR1000U0In24VO vo);
	/* 출고 - 출력후 미리보기 */
    List<RQSR1000U0Out24VO> selectGA01N510Oput(RQSR1000U0In24VO vo);
	
	/* 인감증명서 재출력*/
	int updateGA01N510ReOput(RQSR1000U0In24VO vo);
	
	/* 인감증명서상세상태코드 수정 */
	int updateGA01N510DlScd(RQSR1000U0In01VO vo);
	
	/* 출고 - 재출력/폐기 조회  */
	List<RQSR1000U0Out23VO> selectListGA01N510Oput(RQSR1000U0In24VO vo);
	
	/* 재출력/폐기 - 폐기 */
	int updateGA01N510ReOputDsus(RQSR1000U0In26VO vo);
}
