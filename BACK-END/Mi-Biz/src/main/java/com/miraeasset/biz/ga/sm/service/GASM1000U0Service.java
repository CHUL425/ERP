/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GASM1000U0Service.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: RE100계약관리 서비스
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.sm.service;

import java.util.List;

import com.miraeasset.biz.ga.sm.vo.GASM1000U0In00VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In01VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In02VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In03VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In04VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In11VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out00VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out01VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out11VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out12VO;

public interface GASM1000U0Service {

	/* RE100 계약관리 목록조회 */	
    List<GASM1000U0Out00VO> selectListGA01N305(GASM1000U0In00VO vo);

	/* RE100 상세정보조회(PK) */	
    List<GASM1000U0Out01VO> selectGA01N305PK(GASM1000U0In01VO vo);
    
	/* RE100 기안문서내역조회 */	
    List<GASM1000U0Out11VO> selectListGA01N306(GASM1000U0In11VO vo);
    
	/* RE100 전력구매계약정보 */	
    GASM1000U0Out12VO selectCapaInfo();    
   
	/* RE100 수정(PK) */	
    int updateGA01N305(GASM1000U0In02VO vo);
    
	/* RE100 삭제수정(PK) */	
    int updateDelGA01N305(GASM1000U0In04VO vo);    

	/* RE100 신규등록 */	
    int insertGA01N305(GASM1000U0In03VO vo);        
}
