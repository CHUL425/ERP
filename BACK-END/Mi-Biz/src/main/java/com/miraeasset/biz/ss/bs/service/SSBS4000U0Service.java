/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS4000U0Service.java
*	04. 작  성  일  자	: 2023.10.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 메뉴관리 Service
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.service;

import java.util.List;

import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In02VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In02VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In04VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In11VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0In04VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0Out00VO;

public interface SSBS4000U0Service {
	
    /* 메뉴관리 목록조회 */
	List<SSBS4000U0Out00VO> selectListGA09N203(SSBS4000U0In00VO vo);
	
    /* 메뉴관리 상세조회 PK */
	SSBS4000U0Out01VO selectGA09N203PK(SSBS4000U0In01VO vo);
	
	/* 메뉴관리 신규등록 */	
    int insertGA09N203(SSBS4000U0In02VO vo);    	
    
	/* 메뉴관리 수정 */	
    int updateGA09N203(SSBS4000U0In02VO vo);    	    

	/* 메뉴관리 삭제 */	
    int deleteGA09N203(SSBS4000U0In01VO vo);       

}
