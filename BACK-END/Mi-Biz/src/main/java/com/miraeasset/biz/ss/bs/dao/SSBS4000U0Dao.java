/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS4000U0Dao.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 메뉴관리 DAO
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.dao;

import java.util.List;

import com.miraeasset.biz.common.meta.vo.GA09N203VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0Out00VO;


public interface SSBS4000U0Dao {
	
    /* 메뉴관리 목록조회 */
	List<SSBS4000U0Out00VO> selectListGA09N203(SSBS4000U0In00VO vo);
	
    /* 메뉴관리 상세조회 PK */
	GA09N203VO selectGA09N203PK(GA09N203VO vo);
	
    /* 메뉴관리 매뉴ID 채번 */
	GA09N203VO selectNewMenuIdGA09N203();
	
	/* 메뉴관리 신규등록 */	
    int insertGA09N203(GA09N203VO vo);
    
	/* 메뉴관리 수정 */	
    int updateGA09N203(GA09N203VO vo);     
    
    /* 메뉴관리 화면툴력순서 재설정내역조회  */
	List<GA09N203VO> selectListGA09N203NewSqn(GA09N203VO vo);    
	
	/* 메뉴관리 화면툴력순서 변경 */	
    int updateGA09N203NewSqn(GA09N203VO vo);     
    
	/* 메뉴관리 삭제 */	
    int deleteGA09N203(GA09N203VO vo);    

}