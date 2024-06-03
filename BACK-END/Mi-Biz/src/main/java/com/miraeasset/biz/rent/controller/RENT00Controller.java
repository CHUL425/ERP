package com.miraeasset.biz.rent.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
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

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.CustomNotFoundException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.vo.CommonResponse;
import com.miraeasset.biz.rent.service.RENT00Service;
import com.miraeasset.biz.rent.vo.RENT00In00VO;
import com.miraeasset.biz.rent.vo.RENT02In00VO;
import com.miraeasset.biz.rent.vo.RENT04In00VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/main")
public class RENT00Controller {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RENT00Service RENT00Service;
	/**
	 * 렌탈관리조회
	 */
	@ApiOperation(value="렌탈관리내역 조회")
	@RequestMapping(value= "/rent/mt/sel", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse rent00Sel(@RequestBody RENT00In00VO vo, HttpServletRequest request) {
		
//		String nvlChk = RENT00Service.nvl(vo.getExccYm(), "");
		
//		if(nvlChk.equals("")) {
//			throw new CustomBadRequestException("정산년월을 입력해주세요.", ErrorCode.BAD_REQUEST);
//		}
		
//		List<RENT00In00VO> RENT00Out00VO = RENT00Service.selectList00GA01N001(vo);
		
//		if (RENT00Out00VO == null) {
//			throw new CustomNotFoundException("조회데이터가 존재하지 않습니다.", ErrorCode.RESOURCE_NOT_FOUND);
//		}
		
		CommonResponse response = new CommonResponse();
		response.addData(RENT00Service.selectList00GA01N001(vo));

		return response;
	}

	/**
	 * 렌탈관리요약정보조회
	 */
	@ApiOperation(value="렌탈관리요약정보 조회")
	@RequestMapping(value= "/rent/smar/sel", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse rent01Sel(@RequestBody RENT00In00VO vo, HttpServletRequest request) {
		
		CommonResponse response = new CommonResponse();
		response.addData(RENT00Service.selectList01GA01N001(vo));

		return response;
	}
	
	/**
	 * 연간렌탈료조회
	 */
	@ApiOperation(value="연간렌탈료 조회")
	@RequestMapping(value= "/rent/yle_rentc/sel", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse rent02Sel(@RequestBody RENT02In00VO vo, HttpServletRequest request) {
		
		CommonResponse response = new CommonResponse();
		response.addData(RENT00Service.selectList02GA01N001(vo));
		
		return response;
	}
	
	/**
	 * 연간렌탈료요약정보조회
	 */
	@ApiOperation(value="연간렌탈료요약정보 조회")
	@RequestMapping(value= "/rent/yle_smar/sel", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse rent03Sel(@RequestBody RENT02In00VO vo, HttpServletRequest request) {
		
		CommonResponse response = new CommonResponse();
		response.addData(RENT00Service.selectList03GA01N001(vo));
		
		return response;
	}
	
	/**
	 * 렌탈제품조회(신청지점의 렌탈관리 조회)
	 */
	@ApiOperation(value="렌탈제품조회(신청지점의 렌탈관리 조회)")
	@RequestMapping(value= "/rent/rent_gds/sel", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse rent04Sel(@RequestBody RENT04In00VO vo, HttpServletRequest request) {
		
		CommonResponse response = new CommonResponse();
		response.addData(RENT00Service.selectList04GA01N001(vo));
		
		return response;
	}
	
	
	
}
