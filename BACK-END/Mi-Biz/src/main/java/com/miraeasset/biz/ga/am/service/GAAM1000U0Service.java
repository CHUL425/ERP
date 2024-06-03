package com.miraeasset.biz.ga.am.service;

import java.util.List;

import com.miraeasset.biz.common.meta.vo.GA03N101VO;
import com.miraeasset.biz.ga.am.vo.GAAM1000U0In00VO;
import com.miraeasset.biz.ga.am.vo.GAAM1000U0In01VO;

public interface GAAM1000U0Service {
	
	/* 구매물품코드별 조회 */
	GA03N101VO selectAtclInfo(GAAM1000U0In00VO vo);
	/* 물품리스트 조회 */
	List<GA03N101VO> selectAtclList(GAAM1000U0In01VO vo);
}
