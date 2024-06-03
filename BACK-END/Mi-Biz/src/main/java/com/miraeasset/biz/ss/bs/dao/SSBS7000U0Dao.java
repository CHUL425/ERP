/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: SSBS7000U0Dao.java
*	04. 작  성  일  자	: 2023.10.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹별 화면관리 DAO
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.dao;

import java.util.List;
import java.util.Map;

import com.miraeasset.biz.common.meta.vo.GA09N205VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In05VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In11VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out01VO;


public interface SSBS7000U0Dao {
	
	/* 사용자그룹_화면 목록조회*/
	List<SSBS7000U0Out00VO> selectListGA09N205(SSBS7000U0In00VO vo);
    
	/* 사용자그룹_화면 정상건 목록조회*/
	List<SSBS7000U0Out00VO> selectListGA09N205ByNrml(SSBS7000U0In11VO vo);
	
	/* 사용자그룹_화면 상세조회 PK */
	GA09N205VO selectGA09N205Pk(GA09N205VO vo);
	
	/* 사용자그룹_화면 상세조회(접수번호기준)*/
	GA09N205VO selectGA09N205ByRecNo(GA09N205VO vo);    	
	
	/* 사용자그룹_화면 신규등록 */	
    int insertGA09N205(GA09N205VO vo);    
		
	/* 사용자그룹_화면 수정 */	
    int updateGA09N205(GA09N205VO vo);    	
    
	/* 사용자그룹_화면 반려 건 자동 재신청 */
	int reApplyByRctNo(Map<String,Object> map);

}