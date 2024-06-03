package com.miraeasset.biz.in.in.service;

import java.util.List;

import com.miraeasset.biz.in.in.vo.ININ1000V0In02VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0Out00VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0Out02VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0VO2;

public interface ININ2000V0Service {
	
	/* 연간 예산집행 */
	ININ2000V0Out02VO ylyBdgt(ININ1000V0In02VO vo);
	
	/* 연간 예산집행 추이 */
	ININ2000V0VO selectYlyBdgtEnfc();
	
	/* 총무사업 예산 */
	List<ININ2000V0Out00VO> selectGeafBusiBdgt(ININ1000V0In02VO vo);
	
	/* 임직원 초기화면 - 승인현황 */
	List<ININ2000V0VO2> selectXempApvPstt(ININ2000V0VO2 vo);
}
