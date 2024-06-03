/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SH
*	03. 파    일   명	: SHAN2000U0Controller.java
*	04. 작  성  일  자	: 2024.02.08
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 안전보건공지 현황 컨트롤러
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

import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.sh.an.service.SHAN2000U0Service;
import com.miraeasset.biz.sh.an.vo.SHAN2000U0In00VO;
import com.miraeasset.biz.sh.an.vo.SHAN2000U0Out00VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/main/shan2000u0")
public class SHAN2000U0Controller extends CustomRequestException{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SHAN2000U0Service SHAN2000U0Service;

	/**
	 * 안전보건공지 현황 조회
	 */
	@ApiOperation(value="안전보건공지 현황 조회")
	@RequestMapping(value= "/selectShanPsttList", method = RequestMethod.POST)
	@ResponseBody
	public  List<SHAN2000U0Out00VO> selectShanPsttList(@RequestBody SHAN2000U0In00VO vo, HttpServletRequest request) {
		return SHAN2000U0Service.selectShanPsttList(vo,request);
	}
}

