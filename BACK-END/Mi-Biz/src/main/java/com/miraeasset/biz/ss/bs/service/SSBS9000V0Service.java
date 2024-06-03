/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS9000V0Service.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 판관비계정관리 Service
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.service;

import java.util.List;

import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In02VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0Out02VO;

public interface SSBS9000V0Service {
	
	/* 판관비판관비계정과목관리 조회 */
	List<SSBS9000V0Out00VO> selectList00GA01C001(SSBS9000V0In00VO vo);
	
	/* 판관비판관비계정과목관리 상세조회 */
	SSBS9000V0Out02VO selectGA01C001(SSBS9000V0In02VO vo);	
	
	/* 판관비판관비계정과목관리 신규등록 */	
    int insertGA01C001(SSBS9000V0In01VO vo);    
    
	/* 판관비판관비계정과목관리 수정 */	
    int updateGA01C001(SSBS9000V0In03VO vo);    

    /* 판관비판관비계정과목관리 삭제 */	
    int deleteGA01C001(SSBS9000V0In01VO vo);  
    

}
