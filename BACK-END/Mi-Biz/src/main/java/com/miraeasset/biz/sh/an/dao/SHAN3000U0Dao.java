/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SH
*	03. 파    일   명	: SHAN1000U0Dao.java
*	04. 작  성  일  자	: 2024.02.05
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 안전보건공지 DAO
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.sh.an.dao;

import java.util.List;

import com.miraeasset.biz.sh.an.vo.SHAN3000U0In00VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In01VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In02VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0Out00VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0Out01VO;

public interface SHAN3000U0Dao {
    
	/* 안전보건공지 확인 전체조회 */	
	List<SHAN3000U0Out00VO> selectShanCfmtList(SHAN3000U0In00VO vo);
	/* 안전보건공지 확인 상세조회(확인용) */	
	SHAN3000U0Out01VO selectShanCfmtDlCn(SHAN3000U0In01VO vo);
	/* 안전보건공지 확인 */
	int insertShanCfmtDlCn(SHAN3000U0In02VO vo);

}
