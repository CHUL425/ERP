/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: SSBS7000U0Service.java
*	04. 작  성  일  자	: 2023.10.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹별 화면관리 service
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.service;

import java.util.List;

import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In04VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In05VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In11VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out01VO;

public interface SSBS7000U0Service {
	
	/* 사용자그룹_화면 목록조회*/
	List<SSBS7000U0Out00VO> selectListGA09N205(SSBS7000U0In00VO vo);    
	
	/* 사용자그룹_화면 상세조회*/
	SSBS7000U0Out01VO selectGA09N205Pk(SSBS7000U0In01VO vo);
	
	/* 사용자그룹_화면 상세조회(접수번호기준)*/
	SSBS7000U0Out01VO selectGA09N205ByRecNo(SSBS7000U0In05VO vo);    
	
	/* 사용자그룹_화면 정상건 목록조회*/
	List<SSBS7000U0Out00VO> selectListGA09N205ByNrml(SSBS7000U0In11VO vo);

	/* 사용자그룹_화면 임시저장(수정)/상신 다건 */	
    String reqRegiListGA09N205(SSBS7000U0In03VO vo);
    
	/* 사용자그룹_화면 임시저장(수정)/상신 단건 */	
    String reqRegiGA09N205(SSBS7000U0In04VO vo);    
    
	/* 사용자그룹_화면 재상신 */	
    String reApplyByRctNo(SSBS7000U0In05VO vo,LoginOutVO loginVo);    

}
