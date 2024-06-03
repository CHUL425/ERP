package com.miraeasset.biz.rq.nr.dao;

import java.util.List;

import com.miraeasset.biz.common.meta.vo.GA03N102VO;
import com.miraeasset.biz.common.meta.vo.GA03N104VO;
import com.miraeasset.biz.common.meta.vo.GA03N105VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0In00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0Out00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0Out01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0Out02VO;

public interface RQNR1000U0Dao {
	
	/* 명함신청-사용자 정보 조회  */
	RQNR1000U0Out00VO selectEpInfo(RQNR1000U0In00VO vo);
	/* 명함신청-사용자 자격증 조회  */
	List<RQNR1000U0Out01VO> selectEpLcnsList(RQNR1000U0In00VO vo);
	/* 명함신청-주소 조회  */
	List<RQNR1000U0Out02VO> selectAdrList(RQNR1000U0In00VO vo);
	/* 명함신청-주소 조회(총건수)  */
	int selectAdrList_CNT(RQNR1000U0In00VO vo);
	
	/* 명함신청_GA03N104 접수번호기준 삭제 */	
    int deleteGA03N104ByRctNo(String rctNo);
    /* 명함신청_GA03N104 신규등록 */	
    int insertGA03N104(GA03N104VO vo);
    
	/* 신청물품_GA03N102 접수번호기준 삭제 */	
    int deleteGA03N102ByRctNo(String rctNo);
    /* 신청물품_GA03N102 신규등록 */	
    int insertGA03N102(GA03N102VO vo);
    
	/* 명함상세_GA03N105 접수번호기준 삭제 */	
    int deleteGA03N105ByRctNo(String rctNo);
    /* 명함상세_GA03N105 신규등록 */	
    int insertGA03N105(GA03N105VO vo);
    
}
