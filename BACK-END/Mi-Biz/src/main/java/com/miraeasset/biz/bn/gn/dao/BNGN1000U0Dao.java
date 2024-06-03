/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: BN
*	03. 파    일   명	: BNGN1000U0Dao.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 총무공지 DAO
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.bn.gn.dao;

import java.math.BigDecimal;
import java.util.List;

import com.miraeasset.biz.bn.gn.vo.BNGN1000U0In00VO;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0In01VO;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0Out00VO;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0Out01VO;
import com.miraeasset.biz.common.meta.vo.GA09N411VO;
import com.miraeasset.biz.common.meta.vo.GA09N421VO;

public interface BNGN1000U0Dao {

	/* 총무공지 내역조회 */	
    List<BNGN1000U0Out00VO> selectListGA09N421(BNGN1000U0In00VO vo);

	/* 총무공지 상세조회(PK) */
	BNGN1000U0Out01VO selectGA09N421PK(BNGN1000U0In01VO vo);
    
	/* 총무공지 신규/수정(PK) */	
    int updateGA09N421(GA09N421VO vo);
    
	/* 총무공지 삭제수정 */	
    int updateDelGA09N421(GA09N421VO vo);
    
	/* 총무공지 조회수 증가 */	
    int updateQryCnt(GA09N421VO vo);
    
    /* 총무공지 신규 일련번호 채번 */	
    BigDecimal selectNewSrno(GA09N421VO vo);
}
