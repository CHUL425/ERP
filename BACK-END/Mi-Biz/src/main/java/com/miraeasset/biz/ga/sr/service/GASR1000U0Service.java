/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GASR1000U0Service.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인장조제관리 서비스
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.sr.service;

import java.util.List;

import com.miraeasset.biz.ga.sr.vo.GASR1000U0In00VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0In01VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0In02VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0In03VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0In04VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out00VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out01VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out11VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out12VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out13VO;

public interface GASR1000U0Service {

	/* 인장조제관리 목록조회 */	
    List<GASR1000U0Out00VO> selectListGA01N501(GASR1000U0In00VO vo);
    
	/* 인장조제관리 인장유형 통계정보조회 */	
    GASR1000U0Out11VO selectInfoGA01N501BySalPcd(GASR1000U0In00VO vo);
    
	/* 인장조제관리 인장상태 통계정보조회 */	
    GASR1000U0Out13VO selectInfoGA01N501BySalScd(GASR1000U0In00VO vo);
    
	/* 인감날인 인감 콤보박스 */	
    List<GASR1000U0Out12VO> selectListSealSalg();

    /* 인감증명서 인감 콤보박스 */	
    List<GASR1000U0Out12VO> selectListSealDoc();
    
	/* 인장조제관리 상세정보조회(PK) */	
    GASR1000U0Out01VO selectGA01N501PK(GASR1000U0In01VO vo); 

	/* 인장조제관리 접수 */	
    String insertGA01N501(GASR1000U0In03VO vo);
    
	/* 인장조제관리 신청 */	
    int insertGA01N101(GASR1000U0In03VO vo);
    
	/* 인장조제관리 변경/회수/폐기 단건 */	
    int updateGA01N501ByTrTcd (GASR1000U0In02VO vo);
    
	/* 인장조제관리 승인 */	
    int updateGA01N501Aprv (String strRctNo);  
    
	/* 인장조제관리 반려 */	
    int updateGA01N501Rtrn (String strRctNo);  
    
	/* 인장조제관리 폐기 일괄신청 */	
    int updateListGA01N501ByDSUS (GASR1000U0In04VO vo);   
    
	/* 인장조제관리 상세정보조회(승인관리-상세) */	
    GASR1000U0Out01VO selectGA01N501Aprv(GASR1000U0In02VO vo);
    
    /* 인장관리번호 최신화(임시) */	
    int updateCmnByGA01N501 (); 
}
