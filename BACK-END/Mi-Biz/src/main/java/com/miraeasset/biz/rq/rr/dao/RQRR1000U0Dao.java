package com.miraeasset.biz.rq.rr.dao;

import java.util.List;
import java.util.Map;

import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA01N102VO;
import com.miraeasset.biz.common.meta.vo.GA01N102Vf01InVO;
import com.miraeasset.biz.common.meta.vo.GA01N102Vf01OutVO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0In00VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0Out01VO;

public interface RQRR1000U0Dao {
	
	/* 렌탈신청목록 조회 */
	List<RQRR1000U0VO> selectListRentRqs(RQRR1000U0VO vo); 	
	
	/* 렌탈신청목록 상태조회 */
	List<Map<String, Object>> selecRentRqsScdInfo(RQRR1000U0VO vo);
	
	/* 렌탈신청상세(임대신청상세) 조회(PK) */
	List<GA01N102VO> selectGA01N004(GA01N102VO vo); 	
	
	/* 렌탈신청삭제(임대신청) delete(PK) */
	int deleteGA01N003(RQRR1000U0VO vo);	

	/* 렌탈신청상세삭제(임대신청상새) 같은접수번호 delete */
	int deleteGA01N004WithRctNo(RQRR1000U0VO vo);	
	
	/* 렌탈신청상세삭제(임대신청상새) 같은접수번호 delete */
	int deleteGA01N004WithRctNo(GA01N102VO vo);	
	
	/* 렌탈신청(임대신청) 신청상태변경 */
	int updateRqsScd(RQRR1000U0VO vo);	
	
	/* 렌탈신청상세목록 조회 */
	List<RQRR1000U0VO> selectListRentRqsDtl(RQRR1000U0VO vo);

	/* 렌탈신청상세목록 조회 */
	List<GA01N102Vf01OutVO> selectListRentRqsDtl(GA01N102Vf01InVO vo);
	
	/* 렌탈신청(임대신청) 조회(PK) */
	List<GA01N101VO> selectGA01N101(GA01N101VO vo);	

	/* 렌탈신청(임대신청) 조회(PK) */
	List<RQRR1000U0VO> selectGA01N101(RQRR1000U0VO vo);
	
	/* 렌탈신청 반려 건 자동 재신청 */
	int insertGA01N102ReApplyByRctNo(Map<String,Object> map);
	
}
