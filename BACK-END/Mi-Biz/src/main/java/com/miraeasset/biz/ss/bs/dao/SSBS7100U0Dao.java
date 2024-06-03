/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS7100U0Dao.java
*	04. 작  성  일  자	: 2023.10.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹별 사용자관리 DAO
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.dao;

import java.util.List;
import java.util.Map;

import com.miraeasset.biz.common.meta.vo.GA09N201VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0Out01VO;


public interface SSBS7100U0Dao {

    /* 사용자그룹별 사용자관리 목록조회 */
	List<SSBS7100U0Out00VO> selectListGA09N201(SSBS7100U0In00VO vo);

    /* 사용자그룹별 사용자관리 정상기등록건 목록조회 */
	List<SSBS7100U0Out00VO> selectListGA09N201ByNrml(SSBS7100U0In00VO vo);
	
    /* 사용자그룹별 사용자관리 상세조회 PK */
	GA09N201VO selectGA09N201PK(GA09N201VO vo);
	
    /* 사용자그룹별 사용자관리 상세조회(접수번호기준)*/
	GA09N201VO selectGA09N201ByRecNo(GA09N201VO vo);	
	
	/* 사용자그룹별 사용자 신규등록 */	
    int insertGA09N201(GA09N201VO vo);
    
	/* 사용자그룹별 사용자 수정 */	
    int updateGA09N201(GA09N201VO vo);       

	/* 사용자그룹별 사용자관리 반려 건 자동 재신청 */
	int reApplyByRctNo(Map<String,Object> map);
}