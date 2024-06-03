package com.miraeasset.biz.rq.pr.dao;

import com.miraeasset.biz.common.meta.vo.GA03N103VO;

public interface RQPR1000U0Dao {
	
	/* 개인명패상세_GA03N103 접수번호기준 삭제 */	
    int deleteGA03N103ByRctNo(String rctNo);
    /* 개인명패상세_GA03N103 신규등록 */	
    int insertGA03N103(GA03N103VO vo);
    
}
