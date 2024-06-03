package com.miraeasset.biz.common.aprv.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraeasset.biz.common.aprv.service.AprvService;
import com.miraeasset.biz.common.aprv.vo.Aprv00In00VO;
import com.miraeasset.biz.common.aprv.vo.Aprv00In01VO;
import com.miraeasset.biz.common.aprv.vo.Aprv00In02VO;
import com.miraeasset.biz.common.aprv.vo.Aprv00Out00VO;
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.vo.CommonResponse;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/common/aprv")
public class AprvController extends CustomRequestException{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AprvService AprvService;

	/**
	 * 승인관리 대기목록조회
	 */
	@ApiOperation(value="승인관리 대기목록조회")
	@RequestMapping(value= "/aprv00/selList", method = RequestMethod.POST)
	@ResponseBody
	public  List<Aprv00Out00VO> selectAprvList(@RequestBody Aprv00In00VO vo, HttpServletRequest request) {
		return AprvService.selectAprvList(vo);
	}		
	
	
	
	/**
	 * 승인/반려 처리 - 단건
	 */
	@ApiOperation(value="승인/반려 처리 - 단건")
	@RequestMapping(value= "/aprv00/aprv", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse updateAprv(@RequestBody Aprv00In02VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(AprvService.updateAprv(vo));
		return response;
	}			
	
	/**
	 * 승인 처리 - 다건
	 */
	@ApiOperation(value="승인 처리 - 다건")
	@RequestMapping(value= "/aprv00/aprvList", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse updateAprvList(@RequestBody Aprv00In01VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(AprvService.updateAprvList(vo));
		return response;
	}	

}

