package com.miraeasset.biz.rq.rr.service;

import java.util.List;
import java.util.Map;

import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In03VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In06VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In07VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0Out03VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0Out07VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;

import javax.servlet.http.HttpServletRequest;

public interface RQRR1000U0Service {

	/* 렌탈신청목록 조회 */
	List<RQRR1000U0VO> selectListRentRqs(RQRR1000U0VO vo, HttpServletRequest request);
	
	/* 렌탈신청목록 상태조회 */
	List<Map<String, Object>> selecRentRqsScdInfo(RQRR1000U0VO vo, HttpServletRequest request);
	
	/* 렌탈신청(임대신청) 조회(PK) */
	List<RQRR1000U0VO> selectGA01N003(RQRR1000U0VO vo);
	
	/* 렌탈신청상세(임대신청상세) 조회(PK) */
	List<RQRR1000U0Out07VO> selectGA01N004(RQRR1000U0In07VO vo); 		
	
	/* 렌탈신청삭제(임대신청) delete(PK) */
	int deleteGA01N003(RQRR1000U0VO vo);	
	
	/* 렌탈신청상세삭제(임대신청상새) 같은접수번호 delete */
	int deleteGA01N004WithRctNo(RQRR1000U0VO vo);		
	
	/* 렌탈신청(임대신청) 신청상태변경 */
	int updateRqsScd(RQRR1000U0VO vo);
	
	/* 렌탈신청상세목록 조회 */
	List<RQRR1000U0VO> selectListRentRqsDtl(RQRR1000U0VO vo); 	
	
	/* 렌탈신청상세목록 조회 */
	List<RQRR1000U0Out03VO> selectListRentRqsDtl(RQRR1000U0In03VO vo); 		

	/* 렌탈신청 대량삭제(임대신청) */
	int deleteRqsList(RQRR1000U0VO vo);
	
	/* 렌탈신청내역완료 */
	int rqsListCmpn(RQRR1000U0VO vo);
	
	/* 렌탈신청 반려 건 자동 재신청 */
	Map<String, Object> insertGA01N102ReApplyByRctNo(String strRctNo, LoginOutVO loginVo);
	
}
