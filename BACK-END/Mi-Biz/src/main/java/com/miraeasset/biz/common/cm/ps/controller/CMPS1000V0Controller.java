package com.miraeasset.biz.common.cm.ps.controller;

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

import com.miraeasset.biz.common.cm.ps.service.CMPS1000V0Service;
import com.miraeasset.biz.common.cm.ps.vo.CMPS1000V0In00VO;
import com.miraeasset.biz.common.cm.ps.vo.CMPS1000V0Out00VO;
import com.miraeasset.biz.common.exception.CustomRequestException;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/common/cmps")
public class CMPS1000V0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CMPS1000V0Service svc;
	
	/**
	 * 거래처조회 팝업
	 */
	@ApiOperation(value="거래처조회 팝업")
	@RequestMapping(value= "/cmps1000v0/sel00", method = RequestMethod.POST)
	@ResponseBody
	public List<CMPS1000V0Out00VO> cmps1000v0sel00(@RequestBody CMPS1000V0In00VO vo, HttpServletRequest request) {
		return svc.select00AT05C010List(vo);
	}

	/**
	 * 거래처조회 팝업(PK)
	 */
	@ApiOperation(value="거래처조회 팝업(PK)")
	@RequestMapping(value= "/cmps1000v0/sel01", method = RequestMethod.POST)
	@ResponseBody
	public List<CMPS1000V0Out00VO> cmps1000v0sel01(@RequestBody CMPS1000V0In00VO vo, HttpServletRequest request) {
		return svc.select00AT05C010ListPK(vo);
	}
}
