package com.miraeasset.biz.common.cm.cs.service;

import java.util.List;

import com.miraeasset.biz.common.cm.cs.vo.CMCS1000V0In00VO;
import com.miraeasset.biz.common.cm.cs.vo.CMCS1000V0Out00VO;

public interface CMCS1000V0Service {
	
	/* 계약번호팝업리스트조회 */
	List<CMCS1000V0Out00VO> selectList00AT08N100(CMCS1000V0In00VO vo);
}
