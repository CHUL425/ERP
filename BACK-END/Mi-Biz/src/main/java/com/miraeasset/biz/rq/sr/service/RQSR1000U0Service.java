/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0Service.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인감날인증명서신청 서비스
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In00VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In01VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In03VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In04VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In05VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In17VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In19VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In20VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In21VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In23VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In24VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In25VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In26VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out00VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out01VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out02VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out11VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out15VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out17VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out18VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out19VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out20VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out21VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out24VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out25VO;

public interface RQSR1000U0Service {

	/* 인감날인증명서신청 목록조회 */
    List<RQSR1000U0Out00VO> selectListGA01N101BySeal(RQSR1000U0In00VO vo, HttpServletRequest request);
	/* 인감날인증명서신청 목록조회 - 엑셀*/
    //List<RQSR1000U0Out00VO> selectListGA01N101BySeal(RQSR1000U0In00VO vo);
    /* 인감날인증명서신청 상세조회 */	
    RQSR1000U0Out01VO selectUnifRqsBySeal(RQSR1000U0In01VO vo);
	/* 인장신청_인감날인신청신청상태 정보조회 */	
    RQSR1000U0Out11VO selectInfoGA01N101BySeal(RQSR1000U0In00VO vo, HttpServletRequest request);    
    
	/* 인감날인증명서신청 임시저장(수정)/상신 */	
    String reqRegi(RQSR1000U0In03VO vo);
	/* 인감날인증명서신청 삭제 */	
    int deleteUnifRqsBySeal(RQSR1000U0In04VO vo);
	/* 인감날인증명서신청 재상신 */	
    String reApplyByRctNo(RQSR1000U0In05VO vo,LoginOutVO loginVo);
    
	/* 인감날인증명서 승인대기 목록조회 */	
    List<RQSR1000U0Out21VO> selectListApvIng(RQSR1000U0In21VO vo);    
	/* 인감날인증명서 사전참조 목록조회 */	   
    List<RQSR1000U0Out21VO> selectListApvRef(RQSR1000U0In21VO vo);  
    /* 인감날인 사전참조 다건 확인처리 */	
    int updateGA09N607ForCfmt(RQSR1000U0In23VO vo, HttpServletRequest request);    
    
	/* 인감날인증명서 승인완료 목록조회 */	
    List<RQSR1000U0Out20VO> selectListApvCmpn(RQSR1000U0In20VO vo);
    /* 인감날인증명서 승인완료 신청상태 정보조회 */	
    RQSR1000U0Out11VO selectListApvCmpnBySeal(RQSR1000U0In20VO vo);
	/* 완료 당일잔여수량 조회 */
	List<RQSR1000U0Out17VO> selectInfoGA01N510BalPstt();
    
    /* 인감날인증명서신청 사용처제출, 원본폐기 처리 */
	int rqspBzPrc(RQSR1000U0In01VO vo, LoginOutVO loginVo);
	
	/* 출고 - 조회 */	
    RQSR1000U0Out02VO selectUnifRqsBySealForCmpn(RQSR1000U0In01VO vo);    
	/* 출고 - 인감증명서 출력 */	
    int updateGA01N510Oput(RQSR1000U0In24VO vo, HttpServletRequest request);
    /* 출고 - 출력후 미리보기 */
    List<RQSR1000U0Out24VO> selectGA01N510Oput(RQSR1000U0In24VO vo);  
    
	/* 출고 - 재출력/폐기 조회 */
    RQSR1000U0Out25VO selectListGA01N510Oput(RQSR1000U0In24VO vo);
	/* 출고 - 재출력/폐기 재출력 */	
    int updateGA01N510ReOput(RQSR1000U0In26VO vo, HttpServletRequest request);
	
    /* 출고 - 완료 */
    int updateGA01N510Cmpn(RQSR1000U0In25VO vo, LoginOutVO loginVo);
    
	/* 입고/폐기관리 증명서유형조회 */
	List<RQSR1000U0Out15VO> selectListSealDocPcd();
	/* 입고/폐기관리 조회 */
	List<RQSR1000U0Out19VO> selectListGA01N510(RQSR1000U0In19VO vo);
	/* 입고/폐기관리 등록 */
	int updateGA01N510(RQSR1000U0In17VO vo);
	/* 입고/폐기관리 증명서잔고현황 조회 */
	List<RQSR1000U0Out18VO> selectListGA01N510BalPstt(RQSR1000U0In19VO vo);
	
	/* 인감증명서 신청여부 - 승인완료 처리시 사용*/
	boolean selectGA01N505ExistYn(String rctNo);

}
