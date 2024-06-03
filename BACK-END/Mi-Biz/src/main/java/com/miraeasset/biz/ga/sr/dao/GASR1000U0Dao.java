/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GASR1000U0Dao.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인장조제관리 DAO
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.sr.dao;

import java.util.List;

import com.miraeasset.biz.common.meta.vo.GA01H502VO;
import com.miraeasset.biz.common.meta.vo.GA01N501VO;
import com.miraeasset.biz.common.meta.vo.GA01N503VO;
import com.miraeasset.biz.common.meta.vo.GA01N509VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0In00VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out00VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out11VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out12VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out13VO;

public interface GASR1000U0Dao {

	/* 인장조제관리 목록조회 */	
    List<GASR1000U0Out00VO> selectListGA01N501(GASR1000U0In00VO vo);
    /* 인장조제관리 목록조회 - 전체건수 */
    GASR1000U0Out00VO selectListGA01N501_Cnt(GASR1000U0In00VO vo);
    
	/* 인장조제관리 인장유형 통계정보조회 */	
    GASR1000U0Out11VO selectInfoGA01N501BySalPcd(GASR1000U0In00VO vo);
    
	/* 인장조제관리 인장상태 통계정보조회 */	
    GASR1000U0Out13VO selectInfoGA01N501BySalScd(GASR1000U0In00VO vo);
    
	/* 인감날인 인감 콤보박스 */	
    List<GASR1000U0Out12VO> selectListSealSalg();

    /* 인감증명서 인감 콤보박스 */	
    List<GASR1000U0Out12VO> selectListSealDoc();

	/* 인장조제관리 상세정보조회(PK) */	
    GA01N501VO selectGA01N501PK(GA01N501VO vo);    
    
	/* 인장조제관리 접수 */	
    int insertGA01N501(GA01N501VO vo);  
    
	/* 인장조제관리_인장조제별기안문서 등록 */	
    int insertGA01N509(GA01N509VO vo);    
    
    /* 인장조제관리 신청 */	
    int insertGA01N101(GA01N501VO vo); 
    
	/* 인장조제관리_인장조제관리신청 신규등록 */	
    int insertGA01N503(GA01N503VO vo); 
    
	/* 인장조제관리_인장조제관리이력 신규등록 */	
    int insertGA01H502(GA01H502VO vo);  
    
	/* 인장조제관리 수정 - 제작 */	
    int updateGA01N501ByMAKG(GA01N501VO vo);  
    
	/* 인장조제관리 수정 - 회수 */	
    int updateGA01N501ByWTDW(GA01N501VO vo);           

	/* 인장조제관리 수정 - 폐기 */	
    int updateGA01N501ByDSUS(GA01N501VO vo); 
    
	/* 인장조제관리 수정 - 변경 */	
    int updateGA01N501ByCHNG(GA01N501VO vo);   
    
	/* 인장조제관리 수정 - 내용수정 */	
    int updateGA01N501ByUPD(GA01N501VO vo);     
    
    /* 인장조제관리 승인 */
    int updateGA01N501Aprv(GA01N501VO vo);
    int updateGA01N509Aprv(GA01N503VO vo);
    
    /* 인장조제관리 반려 */
    int updateGA01N501SealScd(GA01N501VO vo);
    int updateGA01N501Rtrn(GA01N503VO vo);
    int updateGA09N411UseYn(GA01N503VO vo);
    int deleteGA01N509(GA01N509VO vo);
    
    /* 인장조제관리 상태코드 조회 */
    GA01N501VO selectGA01N501Scd(GA01N501VO vo);   
    
	/* 인장조제관리 상세정보조회(승인관리-상세) */	
    GA01N501VO selectGA01N501Aprv(GA01N501VO vo);
    
    /* 인장관리번호 최신화(임시) */	
    List<GA01N501VO> selectGA01N501MaxNo();
    int updateCmnByGA01N501(List<GA01N501VO> list);
}
