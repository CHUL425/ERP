package com.miraeasset.biz.rq.am.service;

import java.util.List;
import java.util.Map;

import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA09N602VO;
import com.miraeasset.biz.common.meta.vo.GA09N607aprvVO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In00VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In01VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In02VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0Out00VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In06VO;

public interface RQAM1000U0Service {

	/* 승댄대기 내역조회 */	
    List<RQAM1000U0Out00VO> selectAprvList(RQAM1000U0In00VO vo);
    
	/* 반려 처리 - 단건*/	
    int updateAprvRtrn(RQAM1000U0In02VO vo);
    
	/* 승인 처리 - 다건*/	
    int updateAprvList(RQAM1000U0In01VO vo);        
    
    /* 2023.09.07 */
	/* 기본결재선 조회 */
	List<GA09N607aprvVO> selectBaseAprvLineList(GA09N607aprvVO vo);
	
	/* 임대신청 상태 수정 */
	int updateAprvRqsScd(GA01N101VO vo);

	/*****************************************************************************
	 *	1. 메 소 드 명	: rqsWdral
	 *  2. 기      능	: 일반신청 철회
	 *	3. 주 요 사 항	: 1. 임대신청 신청상태 변경
	 *                2. 결재정보상세 접수자 데이터에 결재사유내용 => 철회사유 입력( 철회사번, 철회사유 기입 )
	 ****************************************************************************/
	int rqsWdral(RQRR1000U0In06VO vo);

	List<Map<String, String>> findHrkOrzCdForAprvl(String epno);
	
	/* 회수 처리 - 단건 */	
    int rqsWtdw(RQAM1000U0In02VO vo);
}
