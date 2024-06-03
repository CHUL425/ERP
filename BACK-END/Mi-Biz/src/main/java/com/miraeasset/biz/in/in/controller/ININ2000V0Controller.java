package com.miraeasset.biz.in.in.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.miraeasset.biz.common.annotation.ScrnAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraeasset.biz.br.rb.vo.BRRB2000V0Out00VO;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.in.in.service.ININ1000V0Service;
import com.miraeasset.biz.in.in.service.ININ2000V0Service;
import com.miraeasset.biz.in.in.vo.ININ1000V0In00VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0In01VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0In02VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out00VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out01VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out02VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out03VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out04VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out05VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0Out00VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0Out02VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0VO2;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/inin/inin2000v0")
public class ININ2000V0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ININ2000V0Service svc;
	
	/**
	 * 연간 예산집행
	 */
	@ApiOperation(value="연간 예산집행 - 차트")
	@RequestMapping(value= "/YlyBdgt", method = RequestMethod.POST)
	@ResponseBody
	@ScrnAuth("DADA1000m0") /* 연결된 화면에서만 보여야하는 API면 화면권한 체크 */
	ININ2000V0Out02VO ylyBdgt(@RequestBody ININ1000V0In02VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		return svc.ylyBdgt(vo);
	}
	
	
	/**
	 * 연간 예산집행 추이
	 */
	@ApiOperation(value="연간 예산집행 추이 - 차트")
	@RequestMapping(value= "/YlyBdgtEnfc", method = RequestMethod.POST)
	@ResponseBody
	@ScrnAuth("DADA1000m0")
	public ININ2000V0VO selectYlyBdgtEnfc(HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		return svc.selectYlyBdgtEnfc();
	}
	
	/**
	 * 총무예산관리 리스트조회
	 */
	@ApiOperation(value="총무예산관리 리스트조회")
	@RequestMapping(value= "/GeafBusiBdgt", method = RequestMethod.POST)
	@ResponseBody
	@ScrnAuth("DADA1000m0")
	public  List<ININ2000V0Out00VO> selectGeafBusiBdgt(@RequestBody ININ1000V0In02VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return svc.selectGeafBusiBdgt(vo);
	}
	
	/**
	 * 임직원 초기화면 - 승인현황
	 */
	@ApiOperation(value="임직원 초기화면 - 승인현황")
	@RequestMapping(value= "/XempApvPstt", method = RequestMethod.POST)
	@ResponseBody
	public List<ININ2000V0VO2> selectXempApvPstt(@RequestBody ININ2000V0VO2 vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setEpno(loginVo.getEpno());
			vo.setHrOsdtCd(loginVo.getHrOsdtCd());
			vo.setBlngOrzCd(loginVo.getBlngOrzCd());
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		return svc.selectXempApvPstt(vo);
	}
}
