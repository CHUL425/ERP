package com.miraeasset.biz.in.in.dao;

import java.util.List;

import com.miraeasset.biz.in.in.vo.ININ1000V0In02VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0Out00VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0Out01VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0VO2;

public interface ININ2000V0Dao {
	
	/* 연간 예산집행 추이 */
	List<ININ2000V0Out01VO> selectYlyBdgtEnfc(ININ1000V0In02VO vo);
	
	/* 총무사업 예산 */
	List<ININ2000V0Out00VO> selectGeafBusiBdgt(ININ1000V0In02VO vo);
	ININ2000V0Out00VO selectGeafBusiBdgt2(ININ1000V0In02VO vo);
	
	/* 현재 시스템일자기준 이전 분기일자 조회 */
	List<ININ1000V0In02VO> selectBfQtrDt();
	
	/* 임직원 초기화면 - 승인현황 */
	List<ININ2000V0VO2> selectXempApvPstt(ININ2000V0VO2 vo);
}
