/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS6000U0Service.java
*	04. 작  성  일  자	: 2023.10.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹관리 Service
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.service;

import java.util.List;

import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In02VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out01VO;

public interface SSBS6000U0Service {
	
	/* 사용자그룹 조회*/
	List<SSBS6000U0Out00VO> selectListGA09N200(SSBS6000U0In00VO vo);    
	
	/* 사용자그룹 상세조회*/
	SSBS6000U0Out01VO selectGA09N200(SSBS6000U0In01VO vo);      

	/* 사용자그룹 신규등록 */	
    int insertGA09N200(SSBS6000U0In02VO vo);    
		
	/* 사용자그룹 수정 */	
    int updaeGA09N200(SSBS6000U0In02VO vo);    

	/* 사용자그룹 삭제 */	
    int deleteGA09N200(SSBS6000U0In01VO vo);    
    

}
