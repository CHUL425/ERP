package com.miraeasset.biz.ga.am.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.meta.vo.GA03N101VO;
import com.miraeasset.biz.ga.am.service.GAAM1000U0Service;
import com.miraeasset.biz.ga.am.vo.GAAM1000U0In00VO;
import com.miraeasset.biz.ga.am.vo.GAAM1000U0In01VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/gaam/gaam1000u0")
public class GAAM1000U0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	GAAM1000U0Service svc;
	
	/**
	 * 구매물품코드별 조회
	 */
	@ApiOperation(value="구매물품코드별 조회")
	@RequestMapping(value= "selectAtclInfo", method = RequestMethod.POST)
	@ResponseBody
	public GA03N101VO selectAtclInfo(@RequestBody GAAM1000U0In00VO vo) {
		return svc.selectAtclInfo(vo);
	}
	
	
	/**
	 * 물품리스트 조회
	 */
	@ApiOperation(value="물품리스트 조회")
	@RequestMapping(value= "selectAtclList", method = RequestMethod.POST)
	@ResponseBody
	public List<GA03N101VO> selectAtclList(@RequestBody GAAM1000U0In01VO vo) {
		return svc.selectAtclList(vo);
	}
}
