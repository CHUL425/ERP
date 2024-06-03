package com.miraeasset.biz.in.in.dao;

import java.util.List;

import com.miraeasset.biz.ga.cm.vo.GACM1000U0In00VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0In00VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0In01VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0In02VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out00VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out01VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out02VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out04VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out05VO;

public interface ININ1000V0Dao {
	
	/* Today 업무현황 */
	ININ1000V0Out00VO selectTodayBzPstt(ININ1000V0In00VO vo);
	
	/* 예산집행금액 및 집행율 */
	ININ1000V0Out01VO selectBdgtList(ININ1000V0In01VO vo);
	
	/* 소모품, 리스료 등  예산 집행금액 */
	ININ1000V0Out02VO selectYlyBdgtList(ININ1000V0In01VO vo);
	
	/* Today 나의업무 */
	List<ININ1000V0Out00VO> selectTodayBzChprList(ININ1000V0In00VO vo);
	
	/* 총무접수현황 */
	List<ININ1000V0Out04VO> selectGeafRctPstt(ININ1000V0In02VO vo);
	
	/* 신규계약현황 */
	List<ININ1000V0Out05VO> selectNewCntcPstt(GACM1000U0In00VO vo);
}
