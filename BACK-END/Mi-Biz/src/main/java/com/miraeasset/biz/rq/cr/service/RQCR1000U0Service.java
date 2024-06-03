package com.miraeasset.biz.rq.cr.service;

import java.util.List;
import java.util.Map;

import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U00VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U05VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U06VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0In00VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0In02VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out00VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out01VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out02VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000UVO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In06VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;

import javax.servlet.http.HttpServletRequest;

public interface RQCR1000U0Service {
	
	/* 공사신청 목록조회 */
	List<RQCR1000U0Out00VO> selectList(RQCR1000U0In00VO vo);
	/* 공사신청 상태요약정보 */
	/* 공사신청목록 및 요약정보 조회 */
	RQCR1000U00VO selectRqsList(RQCR1000U0In00VO vo, HttpServletRequest request);
	
	/* 공사신청 상태요약정보 */
	List<RQCR1000U0Out01VO> selectRqsStat(RQCR1000U0In00VO vo, HttpServletRequest request);
	
	/* 공사신청목록상세 조회 */
	List<RQCR1000U0Out02VO> selectDtlList(RQCR1000U0In02VO vo);
	
	/* 공사신청 등록/임시저장 */
	/* 공사신청상세 등록/임시저장 */
	/* 공사신청 임시저장 -> 신청 */
	/* 공사신청상세 임시저장 -> 신청 */
	String insertRqcr(RQCR1000UVO vo);
	
	/* 공사신청 임시저장인경우 -> 삭제 */
	/* 공사신청상세 임시저장인경우 -> 삭제 */
	int deleteRqcr(RQCR1000U05VO vo);
	
	/* 공사신청 다건 삭제 */
	int deleteList(RQCR1000U06VO vo);

	/* 공사신청 완료 */
	int rqsListCmpn(RQRR1000U0VO vo);
	
	/* 공사신청 반려 건 자동 재신청 */
	Map<String, Object> insertGA01N103ReApplyByRctNo(String strRctNo, LoginOutVO loginVo);
}
