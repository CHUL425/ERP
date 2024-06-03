package com.miraeasset.biz.rq.am.dao;

import java.util.List;

import com.miraeasset.biz.rq.am.vo.RQAM2000V0In00VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0In01VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0In02VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0Out00VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0Out01VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0Out02VO;

public interface RQAM2000V0Dao {
	
	/* 승인완료 목록조회 */
	List<RQAM2000V0Out00VO> selList(RQAM2000V0In00VO vo); 
	
	/* 승인현황 조회 */
	List<RQAM2000V0Out01VO> selectAprvPstt(RQAM2000V0In01VO vo);
	
	/* 결제상세내역-pk */
	List<RQAM2000V0Out02VO> selectAprvDtlInfo(RQAM2000V0In02VO vo); 	
}
