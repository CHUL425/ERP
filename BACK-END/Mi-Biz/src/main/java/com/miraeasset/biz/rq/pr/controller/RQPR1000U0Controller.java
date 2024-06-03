package com.miraeasset.biz.rq.pr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.rq.pr.service.RQPR1000U0Service;
import com.miraeasset.biz.rq.pr.vo.RQPR1000U0In00VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/rqpr/rqpr1000u0")
public class RQPR1000U0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RQPR1000U0Service svc;
	
	/**
	 * 구매신청-임시저장/상신
	 */
	@ApiOperation(value="구매신청-임시저장/상신")
	@RequestMapping(value= "/reqRegi", method = RequestMethod.POST)
	@ResponseBody
	public String reqRegi(@RequestBody RQPR1000U0In00VO vo) {
		return svc.reqRegi(vo);
	}
	
}
