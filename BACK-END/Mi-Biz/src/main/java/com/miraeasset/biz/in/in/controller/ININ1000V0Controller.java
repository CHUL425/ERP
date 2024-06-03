package com.miraeasset.biz.in.in.controller;

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

import com.miraeasset.biz.br.rb.vo.BRRB2000V0Out00VO;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.in.in.service.ININ1000V0Service;
import com.miraeasset.biz.in.in.vo.ININ1000V0In00VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0In01VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0In02VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out00VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out01VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out02VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out03VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out04VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out05VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/inin/inin1000v0")
public class ININ1000V0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ININ1000V0Service svc;
	
	/**
	 * Today 업무현황	
	 */
	@ApiOperation(value="Today 업무현황")
	@RequestMapping(value= "/todayBzPstt", method = RequestMethod.POST)
	@ResponseBody
	public  ININ1000V0Out00VO selectTodayBzPstt(HttpServletRequest request) {
		ININ1000V0In00VO inVo = new ININ1000V0In00VO();
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			inVo.setEpno(loginVo.getEpno());
			inVo.setBlngOrzCd(loginVo.getBlngOrzCd());
			inVo.setHrOsdtCd(loginVo.getHrOsdtCd());
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return svc.selectTodayBzPstt(inVo);
	}
	
	/**
	 * 예산집행금액 및 집행율
	 */
	@ApiOperation(value="예산집행금액 및 집행율")
	@RequestMapping(value= "/selectBdgtList", method = RequestMethod.POST)
	@ResponseBody
	public  ININ1000V0Out01VO selectBdgtList(HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return svc.selectBdgtList();
	}
	
	/**
	 * 소모품, 리스료 등  예산 집행금액
	 */
	@ApiOperation(value="소모품, 리스료 등  예산 집행금액")
	@RequestMapping(value= "/selectYlyBdgtList", method = RequestMethod.POST)
	@ResponseBody
	public  ININ1000V0Out02VO selectYlyBdgtList(HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return svc.selectYlyBdgtList();
	}
	
	/**
	 * ESG(RE 100)
	 * GASM1000U0Controller
	 * /api/main/gasm1000u0/selectCapaInfo	/api/main/gasm1000u0 /selectCapaInfo
	 * allCntcCapa:전력구매계약용량, achvCntcCapa:이행계약용량, achvRt: 이행율
	 */
	
	/**
	 * 사옥임대현황	
	 */
	@ApiOperation(value="사옥임대현황")
	@RequestMapping(value= "/selectOfcbldRentPstt", method = RequestMethod.POST)
	@ResponseBody
	public ININ1000V0Out03VO selectOfcbldRentPstt(HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		String basYm = DateUtil.getTodayString("yyyyMMdd");
		return svc.selectOfcbldRentPstt(basYm);
	}
	
	/**
	 * Today 나의업무	
	 */
	@ApiOperation(value="Today 나의업무")
	@RequestMapping(value= "/todayBzChpr", method = RequestMethod.POST)
	@ResponseBody
	public  List<ININ1000V0Out00VO> selectTodayBzChprList(@RequestBody ININ1000V0In00VO vo, HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setEpno(loginVo.getEpno());
			vo.setBlngOrzCd(loginVo.getBlngOrzCd());
			vo.setHrOsdtCd(loginVo.getHrOsdtCd());
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return svc.selectTodayBzChprList(vo);
	}
	
	/**
	 * 총무접수현황	
	 */
	@ApiOperation(value="총무접수현황")
	@RequestMapping(value= "/selectGeafRctPstt", method = RequestMethod.POST)
	@ResponseBody
	public List<ININ1000V0Out04VO> selectGeafRctPstt(HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return svc.selectGeafRctPstt();
	}
	
	/**
	 * 신규계약현황	
	 */
	@ApiOperation(value="신규계약현황")
	@RequestMapping(value= "/selectNewCntcPstt", method = RequestMethod.POST)
	@ResponseBody
	public List<ININ1000V0Out05VO> selectNewCntcPstt(HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return svc.selectNewCntcPstt();
	}
}
