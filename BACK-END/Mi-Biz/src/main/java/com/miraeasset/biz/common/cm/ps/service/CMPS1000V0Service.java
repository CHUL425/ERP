package com.miraeasset.biz.common.cm.ps.service;

import java.util.List;

import com.miraeasset.biz.common.cm.ps.vo.CMPS1000V0In00VO;
import com.miraeasset.biz.common.cm.ps.vo.CMPS1000V0Out00VO;

public interface CMPS1000V0Service {
	
	/* 거래처조회 팝업 */
	List<CMPS1000V0Out00VO> select00AT05C010List(CMPS1000V0In00VO vo);

	List<CMPS1000V0Out00VO> select00AT05C010ListPK(CMPS1000V0In00VO vo);
}
