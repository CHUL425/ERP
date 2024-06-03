package com.miraeasset.biz.rq.nr.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.miraeasset.biz.common.meta.vo.GA03N105VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0In00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0In01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out02VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out03VO;

public interface RQNR2000U0Service {
	
	/* 명함신청내역-조회 */
	List<RQNR2000U0Out00VO> selectListGA03N102(RQNR2000U0In00VO vo, HttpServletRequest request);
	/* 명함신청내역-상태조회 */
	RQNR2000U0Out01VO selectInfoGA03N102(RQNR2000U0In00VO vo, HttpServletRequest request);
	/* 명함신청내역-완료 */
	int rqsListCmpn(RQNR2000U0In01VO vo);
	/* 명함신청내역-상세정보 조회 */
	RQNR2000U0Out02VO selectDlInfo(RQNR2000U0In01VO vo);
	/* 명함상세 주문내역(엑셀다운로드) */
	List<RQNR2000U0Out03VO> selectListGA03N102Dtl(RQNR2000U0In01VO vo);
	/* 명함상세 사용자별 미리보기 */
	GA03N105VO selectDtlGA03N105(RQNR2000U0In01VO vo);
	/* 명함신청내역-상세정보 삭제 */
	int deleteDlInfo(RQNR2000U0In01VO vo);
}
