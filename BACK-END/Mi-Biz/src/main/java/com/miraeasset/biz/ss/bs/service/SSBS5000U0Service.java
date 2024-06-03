/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: SSBS5000U0Service.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 화면관리 컨트롤러
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.service;

import java.util.List;

import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out01VO;

public interface SSBS5000U0Service {
	    
    /* 화면관리 목록조회*/
	List<SSBS5000U0Out00VO> selectListGA09N204(SSBS5000U0In00VO vo);
	
    /* 화면관리 상세조회*/
	SSBS5000U0Out01VO selectGA09N204(SSBS5000U0In01VO vo);    	

	/* 화면관리 신규/수정/삭제 다건 */	
    int reqRegiListGA09N204(SSBS5000U0In03VO vo);	
    

}
