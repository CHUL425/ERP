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

import com.miraeasset.biz.common.meta.vo.GA09N421VO;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0In01VO;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0Out01VO;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0Out02VO;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0Out03VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In01VO;

public interface SHAN1000U0Dao {
    
	/* 안전보건공지 신규등록 */	
    int insertGA09N421Sh(GA09N421VO vo);
    /* 안전보건공지 조회 */	
    List<SHAN1000U0Out01VO> selectListGA09N421Sh(SHAN1000U0In01VO vo);
    /* 안전보건공지 삭제전 확인이력존재여부 조회*/	
    SHAN1000U0Out02VO selectShanCfmtHst(SHAN3000U0In01VO vo);
    /* 안전보건공지 초기화면 팝업조회	 */
    SHAN1000U0Out03VO selectShanInitPopup(String epno);
}
