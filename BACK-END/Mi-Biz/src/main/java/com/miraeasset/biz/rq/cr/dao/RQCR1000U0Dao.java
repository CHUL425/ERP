package com.miraeasset.biz.rq.cr.dao;

import java.util.List;
import java.util.Map;

import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U01VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U02VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U03VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U04VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U05VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U06VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0In00VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0In01VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0In02VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out00VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out01VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out02VO;

public interface RQCR1000U0Dao {
	
	/* 공사신청 목록조회 */
	List<RQCR1000U0Out00VO> selectList(RQCR1000U0In00VO vo);
	
	/* 공사신청 상태요약정보 */
	List<RQCR1000U0Out01VO> selectRqsStat(RQCR1000U0In01VO vo);
	
	/* 공사신청목록상세 조회 */
	List<RQCR1000U0Out02VO> selectDtlList(RQCR1000U0In02VO vo);
	
	/* 공사신청 등록/임시저장 */
	int insertRqcr(RQCR1000U01VO vo);
	
	/* 공사신청상세 등록/임시저장 */
	int insertRqcrDtl(RQCR1000U02VO vo);
	
	/* 공사신청 임시저장 -> 신청 */
	int updateRqcr(RQCR1000U03VO vo);
	
	/* 공사신청상세 임시저장 -> 신청 */
	int updateRqcrDtl(RQCR1000U04VO vo);
	
	/* 공사신청 임시저장인경우 -> 삭제 */
	int deleteRqcr(RQCR1000U05VO vo);
	
	/* 공사신청상세 임시저장인경우 -> 삭제 */
	int deleteRqcrDtl(RQCR1000U05VO vo);
	
	/* 공사신청 반려 건 자동 재신청 */
	int insertGA01N103ReApplyByRctNo(Map<String,Object> map);
}
