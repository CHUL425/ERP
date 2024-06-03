/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SH
*	03. 파    일   명	: SHAN3000U0Controller.java
*	04. 작  성  일  자	: 2024.02.07
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 안전보건공지 확인 컨트롤러
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.sh.an.controller;

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

import com.miraeasset.biz.common.annotation.AllAuth;
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.vo.CommonResponse;
import com.miraeasset.biz.sh.an.service.SHAN3000U0Service;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In00VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In01VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In02VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0Out00VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0Out01VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/main/shan3000u0")
public class SHAN3000U0Controller extends CustomRequestException{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SHAN3000U0Service SHAN3000U0Service;

	/**
	 * 안전보건공지 확인 전체조회
	 */
	@ApiOperation(value="안전보건공지 확인 전체조회")
	@RequestMapping(value= "/selectShanCfmtList", method = RequestMethod.POST)
	@ResponseBody
	@AllAuth /* 전체 허용 */
	public  List<SHAN3000U0Out00VO> selectShanCfmtList(@RequestBody SHAN3000U0In00VO vo, HttpServletRequest request) {
		LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO"); 
		vo.setEpno(loginVo.getEpno());
		//2024.02.23 겸직사번에 직책 공백일경우 있음.
		//vo.setOsdtCd(loginVo.getHrOsdtCd());
		
		return SHAN3000U0Service.selectShanCfmtList(vo);
	}
	
	/**
	 * 안전보건공지 확인 상세조회(확인용)
	 */
	@ApiOperation(value="안전보건공지 확인 상세조회(확인용)")
	@RequestMapping(value= "/selectShanCfmtDlCn", method = RequestMethod.POST)
	@ResponseBody
	public  SHAN3000U0Out01VO selectShanCfmtDlCn(@RequestBody SHAN3000U0In01VO vo, HttpServletRequest request) {
		LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO"); 
		vo.setEpno(loginVo.getEpno());
		
		return SHAN3000U0Service.selectShanCfmtDlCn(vo);
	}
	
	@ApiOperation(value="안전보건공지 확인")
	@RequestMapping(value= "/insertShanCfmtDlCn", method = RequestMethod.POST)
	@ResponseBody
	public  CommonResponse insertShanCfmtDlCn(@RequestBody SHAN3000U0In02VO vo, HttpServletRequest request) {
		LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO"); 
		vo.setCfmtEpno(loginVo.getEpno());
		
		CommonResponse response = new CommonResponse();
		response.addData(SHAN3000U0Service.insertShanCfmtDlCn(vo));
		return response;
	}	
}

