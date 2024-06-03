package com.miraeasset.biz.rq.pr.dao;

import java.util.List;

import com.miraeasset.biz.rq.pr.vo.RQPR2000U0Out01VO;

public interface RQPR2000U0Dao {
	
	List<RQPR2000U0Out01VO> selectListGA03N103Dtl(String rctNo);
}
