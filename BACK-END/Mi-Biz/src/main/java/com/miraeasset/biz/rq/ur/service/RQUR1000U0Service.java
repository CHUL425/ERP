package com.miraeasset.biz.rq.ur.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0In00VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0In01VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0In02VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0OUT02VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0OUT12VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0Out00VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0Out01VO;

public interface RQUR1000U0Service {

	/* 렌탈신청상세목록 조회 */
	List<RQRR1000U0VO> selectListRentRqsDtl(RQRR1000U0VO vo); 
	
	/* 렌탈신청상세목록 조회 */
	List<RQUR1000U0Out01VO> selectListRentRqsDtl(RQUR1000U0In00VO vo); 	

	/* 렌탈신청(임대신청) 조회(PK) */
	List<RQUR1000U0Out00VO> selectGA01N003(RQUR1000U0In02VO vo);	
	
	/* 렌탈신청 임시저장/상신 */
	String reqRegi(RQUR1000U0In01VO vo);	
	
	/* 렌탈신청 상세조회 */
	RQUR1000U0OUT02VO selInfo(RQUR1000U0In02VO vo); 
	
	/* 렌탈신청 제폼목록조회(detail)*/
	public List<RQUR1000U0OUT12VO> selectListRentRqsDtl(RQUR1000U0In02VO inVo);	
}
