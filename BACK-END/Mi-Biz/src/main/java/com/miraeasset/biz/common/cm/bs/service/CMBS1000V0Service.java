package com.miraeasset.biz.common.cm.bs.service;

import java.util.List;

import com.miraeasset.biz.common.cm.bs.vo.CMBS1000V0In00VO;
import com.miraeasset.biz.common.cm.bs.vo.CMBS1000V0Out00VO;

public interface CMBS1000V0Service {
	
	/* 계정과목조회 팝업 */
	List<CMBS1000V0Out00VO> select00AT01C001List(CMBS1000V0In00VO vo);
}
