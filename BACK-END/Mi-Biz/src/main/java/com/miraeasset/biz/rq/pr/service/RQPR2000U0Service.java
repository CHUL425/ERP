package com.miraeasset.biz.rq.pr.service;

import java.util.List;

import com.miraeasset.biz.rq.pr.vo.RQPR2000U0In00VO;
import com.miraeasset.biz.rq.pr.vo.RQPR2000U0Out00VO;
import com.miraeasset.biz.rq.pr.vo.RQPR2000U0Out01VO;

public interface RQPR2000U0Service {
	/* 구매신청내역-완료 */
	int rqsListCmpn(RQPR2000U0In00VO vo);
	/* 구매신청내역 - 상세정보 조회 */
	RQPR2000U0Out00VO selectDlInfo(RQPR2000U0In00VO vo);
	/* 구매신청내역 주문내역(엑셀다운로드) */
	List<RQPR2000U0Out01VO> selectListGA03N103Dtl(String rctNo);	
}
