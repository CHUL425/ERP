/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SH
*	03. 파    일   명	: SHAN2000U0Service.java
*	04. 작  성  일  자	: 2024.02.05
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 안전보건공지 현황 서비스
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.sh.an.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.miraeasset.biz.sh.an.vo.SHAN2000U0In00VO;
import com.miraeasset.biz.sh.an.vo.SHAN2000U0Out00VO;

public interface SHAN2000U0Service {

	/* 안전보건공지 확인 전체조회 */	
	List<SHAN2000U0Out00VO> selectShanPsttList(SHAN2000U0In00VO vo, HttpServletRequest request);
}
