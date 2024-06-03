/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSZS2000U0Service.java
*	04. 작  성  일  자	: 2023.10.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 알림관리 service
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.zs.service;

import java.util.List;

import com.miraeasset.biz.common.meta.vo.GA09N501VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0In00VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0In01VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0In02VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0Out00VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0Out01VO;

public interface SSZS2000U0Service {
	
	/* 알림관리 목록조회*/
	List<SSZS2000U0Out00VO> selectListGA09N501(SSZS2000U0In00VO vo);
	
	/* 알림관리 상세조회 */
	SSZS2000U0Out01VO selectGA09N501(SSZS2000U0In01VO vo);	
	
	/* 알림관리 신규등록 */	
    int insertGA09N501(SSZS2000U0In02VO vo);
    
	/* 알림관리 수정 */	
    int updateGA09N501(SSZS2000U0In02VO vo);  		
    
	/* 알림관리 삭제 */	
    int deleteGA09N501(SSZS2000U0In01VO vo);  	    
	
}
