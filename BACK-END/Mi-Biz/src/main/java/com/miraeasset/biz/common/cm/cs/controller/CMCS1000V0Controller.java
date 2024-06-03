package com.miraeasset.biz.common.cm.cs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraeasset.biz.common.cm.cs.service.CMCS1000V0Service;
import com.miraeasset.biz.common.cm.cs.vo.CMCS1000V0In00VO;
import com.miraeasset.biz.common.cm.cs.vo.CMCS1000V0Out00VO;
import com.miraeasset.biz.common.exception.CustomRequestException;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/common/cmcs")
public class CMCS1000V0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CMCS1000V0Service svc;

	/**
	 * 계약번호팝업리스트조회
	 */
	@ApiOperation(value="계약번호팝업리스트조회")
	@RequestMapping(value= "/cmcs1000v0/sel00", method = RequestMethod.POST)
	@ResponseBody
	public List<CMCS1000V0Out00VO> cmcs1000v0sel00(@RequestBody CMCS1000V0In00VO vo, HttpServletRequest request) {
		return svc.selectList00AT08N100(vo);
	}
}
