package com.miraeasset.biz.ga.bm.dao;

import java.util.List;

import com.miraeasset.biz.ga.bm.vo.GABM1000U0In00VO;
import com.miraeasset.biz.ga.bm.vo.GABM1000U0In01VO;
import com.miraeasset.biz.ga.bm.vo.GABM1000U0Out00VO;

public interface GABM1000U0Dao {
	
	/* 예산관리 조회 */
	List<GABM1000U0Out00VO> selectList00GA01N401(GABM1000U0In00VO vo);
	
	/* 편성금액 관리 */
	int insert00GA01N401(GABM1000U0In01VO vo);
	
}
