package com.miraeasset.biz.rq.ur.dao;

import java.util.List;

import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA01N102VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;

public interface RQUR1000U0Dao {
	
	/* 렌탈신청(임대신청) 조회(PK) */
	List<RQRR1000U0VO> selectGA01N003(RQRR1000U0VO vo);
	
	/* 렌탈신청(임대신청) insert(PK) */
	int insertGA01N003(GA01N101VO vo);
	
	/* 렌탈신청(임대신청) update(PK) */
	int updateGA01N003(GA01N101VO vo);
	
	/* 렌탈신청상세(임대신청상세) insert(PK) */
	int insertGA01N004(GA01N102VO vo);	
}
