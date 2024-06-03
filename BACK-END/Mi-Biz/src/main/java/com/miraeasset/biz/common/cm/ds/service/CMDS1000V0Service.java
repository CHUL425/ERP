package com.miraeasset.biz.common.cm.ds.service;

import java.util.List;

import com.miraeasset.biz.common.cm.ds.vo.CMDS1000V0In00VO;
import com.miraeasset.biz.common.cm.ds.vo.CMDS1000V0Out00VO;

public interface CMDS1000V0Service {

    /* 기안문서조회 팝업 */
	List<CMDS1000V0Out00VO> select00AT09N401List(CMDS1000V0In00VO vo);
}
