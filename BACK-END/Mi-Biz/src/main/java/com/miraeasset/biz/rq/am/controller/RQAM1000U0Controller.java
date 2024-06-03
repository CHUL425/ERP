package com.miraeasset.biz.rq.am.controller;


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
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA09N607InVO;
import com.miraeasset.biz.common.meta.vo.GA09N607VO;
import com.miraeasset.biz.common.meta.vo.GA09N607aprvVO;
import com.miraeasset.biz.common.util.aprvWrrpt.AprvWrrpt;
import com.miraeasset.biz.common.vo.CommonResponse;
import com.miraeasset.biz.rq.am.service.RQAM1000U0Service;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In00VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In01VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In02VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0Out00VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In06VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/main/rqam1000u0")
public class RQAM1000U0Controller extends CustomRequestException{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	/* RQS_CD 코드값 정의 2023.08.21 */
	private final String CD_RQS_SCD_TMP_STRG = "00"; // 임시저장
	
	@Autowired
	RQAM1000U0Service RQAM1000U0Service;
	
	@Autowired
	AprvWrrpt aprvWrrpt;
	
	
	/*
	 * 기본 결재선 조회
	 * 
	 */
	@ApiOperation(value="기본 결재선 조회")
	@RequestMapping(value= "/baseAprvl", method = RequestMethod.POST)
	@ResponseBody
	public List<GA09N607aprvVO> selectBaseAprvLineList(@RequestBody GA09N607aprvVO vo, HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setAprvWrrptOrzCd(loginVo.getBlngOrzCd());
			vo.setEpno(loginVo.getEpno());
			vo.setBlngOrzCd(loginVo.getBlngOrzCd());
			vo.setHobrTcd(loginVo.getHobrTcd());
		}
		
		return RQAM1000U0Service.selectBaseAprvLineList(vo);
	}
	
	/*
	 * 결재 상신처리
	 * 
	 * */
	@ApiOperation(value="결재 상신처리")
	@RequestMapping(value= "/aprvWrrpt", method = RequestMethod.POST)
	@ResponseBody
	public String aprvWrrpt(@RequestBody GA09N607InVO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") == null ){
			/* 결재 상신 실패시 임시저장건으로 변경 */
			{
				GA01N101VO failVo = new GA01N101VO();
				failVo.setRctNo(vo.getRctNo());
				failVo.setRqsScd(CD_RQS_SCD_TMP_STRG);
				RQAM1000U0Service.updateAprvRqsScd(failVo);
			}
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return aprvWrrpt.aprvWrrpt(vo);
	}
	
	/**
	 * 승인관리 대기목록조회
	 */
	@ApiOperation(value="승인관리 대기목록조회")
	@RequestMapping(value= "/selList", method = RequestMethod.POST)
	@ResponseBody
	public  List<RQAM1000U0Out00VO> selectAprvList(@RequestBody RQAM1000U0In00VO vo, HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setEpno(loginVo.getEpno()); // 로그인사번
			vo.setBlngOrzCd(loginVo.getBlngOrzCd()); // 로그인조직
			vo.setHrOsdtCd(loginVo.getHrOsdtCd()); // 로그인직책
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		
		return RQAM1000U0Service.selectAprvList(vo);
	}		
	
	/**
	 * 반려 처리 - 단건
	 */
	@ApiOperation(value="반려 처리 - 단건")
	@RequestMapping(value= "/rtrn", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse updateAprvRtrn(@RequestBody RQAM1000U0In02VO vo, HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setAprvEpno(loginVo.getEpno()); // 로그인사번
			vo.setAprvOrzCd(loginVo.getBlngOrzCd()); // 로그인조직
			vo.setHrOsdtCd(loginVo.getHrOsdtCd()); // 로그인직책
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		CommonResponse response = new CommonResponse();
		response.addData(RQAM1000U0Service.updateAprvRtrn(vo));
		return response;
	}			
	
	/**
	 * 승인 처리 - 다건
	 */
	@ApiOperation(value="승인 처리 - 다건")
	@RequestMapping(value= "/aprvList", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse updateAprvList(@RequestBody RQAM1000U0In01VO vo, HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setAprvEpno(loginVo.getEpno()); // 로그인사번
			vo.setBlngOrzCd(loginVo.getBlngOrzCd()); // 로그인조직
			vo.setHrOsdtCd(loginVo.getHrOsdtCd()); // 로그인직책
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		CommonResponse response = new CommonResponse();
		response.addData(RQAM1000U0Service.updateAprvList(vo));
		return response;
	}	
	
	/*
	 * 일반신청 - 철회 처리
	 */
	@ApiOperation(value="일반신청 철회")
	@RequestMapping(value= "/rqsWdral", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse rqsWdral(@RequestBody RQRR1000U0In06VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setPrcEpno(loginVo.getEpno());
			vo.setPrcOrzCd(loginVo.getBlngOrzCd());
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		CommonResponse response = new CommonResponse();
		response.addData(RQAM1000U0Service.rqsWdral(vo));
		return response;
	}
	
	/*
	 * 회수 처리 
	 */
	@ApiOperation(value="회수 처리 - 단건")
	@RequestMapping(value= "/rqsWtdw", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse rqsWtdw(@RequestBody RQAM1000U0In02VO vo, HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setAprvEpno(loginVo.getEpno()); // 로그인사번
			vo.setAprvOrzCd(loginVo.getBlngOrzCd()); // 로그인조직
			vo.setHrOsdtCd(loginVo.getHrOsdtCd()); // 로그인직책
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		CommonResponse response = new CommonResponse();
		response.addData(RQAM1000U0Service.rqsWtdw(vo));
		return response;
	}			
}

