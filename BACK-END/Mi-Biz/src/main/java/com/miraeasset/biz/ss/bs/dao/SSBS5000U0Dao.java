/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS5000U0Dao.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 화면관리 DAO
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.dao;

import java.util.List;

import com.miraeasset.biz.common.meta.vo.GA09N204VO;
import com.miraeasset.biz.common.meta.vo.GA09N208VO;
import com.miraeasset.biz.common.meta.vo.GA09N209VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out00VO;


public interface SSBS5000U0Dao {
	

    /* 화면관리 목록조회*/
	List<SSBS5000U0Out00VO> selectListGA09N204(SSBS5000U0In00VO vo);
	
    /* 화면관리 상세조회PK*/
	GA09N204VO selectGA09N204PK(GA09N204VO vo);
	
	/* 화면관리 신규등록 */	
    int insertGA09N204(GA09N204VO vo);    
		
	/* 화면관리 수정 */	
    int updateGA09N204(GA09N204VO vo);    	
    
	/* 화면관리 삭제 */	
    int deleteGA09N204(GA09N204VO vo);    	
        
    /* 화면_담당사원 목록조회 화면ID 기준*/
	List<GA09N209VO> selectListGA09N209ByMenuId(GA09N209VO vo);

	/* 화면_담당사원 신규등록 */	
    int insertGA09N209(GA09N209VO vo);
    
	/* 화면_담당사원 삭제 화면ID 기준 */	
    int deleteGA09N209ByMenuId(GA09N209VO vo);    	

    /* 화면_검색키워드 내역조회  */
	List<GA09N208VO> selectListGA09N208VOByMenuId(GA09N208VO vo);    
    /* 화면_검색키워드 신규등록*/
    int insertGA09N208(GA09N208VO vo);
    /* 화면_검색키워드 삭제*/
    int deleteGA09N208(GA09N208VO vo);
    /* 화면_검색키워드 삭제(화면id기준)*/
    int deleteGA09N208ByMenuId(GA09N208VO vo);

}