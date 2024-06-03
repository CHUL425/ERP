package com.miraeasset.biz.rq.nr.service;

import java.util.List;

import com.miraeasset.biz.rq.nr.vo.RQNR1000U0In00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0In01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0Out00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0Out01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0Out02VO;

public interface RQNR1000U0Service {
	
	/* 명함신청-사용자 정보 조회  */
	RQNR1000U0Out00VO selectEpInfo(RQNR1000U0In00VO vo);
	/* 명함신청-사용자 자격증 조회  */
	List<RQNR1000U0Out01VO> selectEpLcnsList(RQNR1000U0In00VO vo);
	/* 명함신청-주소 조회  */
	List<RQNR1000U0Out02VO> selectAdrList(RQNR1000U0In00VO vo);
	/* 명함신청-임시저장/상신  */
	String reqRegi(RQNR1000U0In01VO vo);
}
