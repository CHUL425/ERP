package com.miraeasset.biz.rq.nr.dao;

import java.util.List;

import com.miraeasset.biz.common.meta.vo.GA03N105VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0In00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0In01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out02VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out03VO;

public interface RQNR2000U0Dao {
	
	/* 명함신청내역-조회  */
	List<RQNR2000U0Out00VO> selectListGA03N102(RQNR2000U0In00VO vo);
	/* 명함신청내역-상태조회  */
	RQNR2000U0Out01VO selectInfoGA03N102(RQNR2000U0In00VO vo);
	/* 명함신청내역-상세정보조회  */
	RQNR2000U0Out02VO selectDlInfo(RQNR2000U0In01VO vo);
	/* 명함신청내역-명함상세 신청내역  */
	List<RQNR2000U0Out03VO> selectListGA03N102Dtl(RQNR2000U0In01VO vo);
	/* 명함상세 사용자별 미리보기 */
	GA03N105VO selectDtlGA03N105(RQNR2000U0In01VO vo);
}
