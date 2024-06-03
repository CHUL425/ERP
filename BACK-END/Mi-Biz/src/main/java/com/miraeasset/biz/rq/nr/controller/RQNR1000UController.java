package com.miraeasset.biz.rq.nr.controller;

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
import com.miraeasset.biz.rq.nr.service.RQNR1000U0Service;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0In00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0In01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0Out00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0Out01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0Out02VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/rqnr/rqnr1000u0")
public class RQNR1000UController extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RQNR1000U0Service svc;
	
	/**
	 * 명함신청-사용자 정보 조회 
	 */
	@ApiOperation(value="명함신청-사용자 정보 조회")
	@RequestMapping(value= "/selectEpInfo", method = RequestMethod.POST)
	@ResponseBody
	public RQNR1000U0Out00VO selectEpInfo(@RequestBody RQNR1000U0In00VO vo) {
		return svc.selectEpInfo(vo);
	}
	
	/**
	 * 명함신청-사용자 자격증 조회 
	 */
	@ApiOperation(value="명함신청-사용자 자격증 조회")
	@RequestMapping(value= "/selectEpLcnsList", method = RequestMethod.POST)
	@ResponseBody
	public List<RQNR1000U0Out01VO> selectEpLcnsList(@RequestBody RQNR1000U0In00VO vo) {
		return svc.selectEpLcnsList(vo);
	}
	
	/**
	 * 명함신청-주소 조회 
	 */
	@ApiOperation(value="명함신청-주소 조회")
	@RequestMapping(value= "/selectAdrList", method = RequestMethod.POST)
	@ResponseBody
	public List<RQNR1000U0Out02VO> selectAdrList(@RequestBody RQNR1000U0In00VO vo) {
		return svc.selectAdrList(vo);
	}
	
	/**
	 * 명함신청-임시저장/상신
	 * */
	@ApiOperation(value="명함신청-임시저장/상신")
	@RequestMapping(value="/reqRegi" , method=RequestMethod.POST)
	@ResponseBody
	public String reqRegi(@RequestBody RQNR1000U0In01VO vo) {
		return svc.reqRegi(vo);
	}
}
