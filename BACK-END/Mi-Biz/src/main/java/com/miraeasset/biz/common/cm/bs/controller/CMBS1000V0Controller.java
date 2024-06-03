package com.miraeasset.biz.common.cm.bs.controller;

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

import com.miraeasset.biz.common.cm.bs.service.CMBS1000V0Service;
import com.miraeasset.biz.common.cm.bs.vo.CMBS1000V0In00VO;
import com.miraeasset.biz.common.cm.bs.vo.CMBS1000V0Out00VO;
import com.miraeasset.biz.common.exception.CustomRequestException;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/common/cmbs")
public class CMBS1000V0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CMBS1000V0Service SVC;
	
	/**
	 * 계정과목조회 팝업
	 */
	@ApiOperation(value="계정과목조회 팝업")
	@RequestMapping(value= "/cmbs1000v0/sel00", method = RequestMethod.POST)
	@ResponseBody
	public List<CMBS1000V0Out00VO> cmbs1000v0sel00(@RequestBody CMBS1000V0In00VO vo, HttpServletRequest request) {
		return SVC.select00AT01C001List(vo);
	}
}
