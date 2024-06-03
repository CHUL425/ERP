/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: SSBS6000U0Controller.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹관리 컨트롤러
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.bs.controller;

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
import com.miraeasset.biz.ss.bs.service.SSBS6000U0Service;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In02VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out01VO;

import io.swagger.annotations.ApiOperation;


@Controller
@RequestMapping("/api/ssbs/ssbs6000u0")
public class SSBS6000U0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SSBS6000U0Service SVC;

	/**
	 * 사용자그룹 조회
	 */
	@ApiOperation(value="사용자그룹 조회")
	@RequestMapping(value= "/selectListGA09N200", method = RequestMethod.POST)
	@ResponseBody
	public List<SSBS6000U0Out00VO> selectListGA09N200(@RequestBody SSBS6000U0In00VO vo, HttpServletRequest request) {
		return SVC.selectListGA09N200(vo);
	}
	
	/**
	 * 사용자그룹 상세조회
	 */
	@ApiOperation(value="사용자그룹 상세조회")
	@RequestMapping(value= "/selectGA09N200", method = RequestMethod.POST)
	@ResponseBody
	public SSBS6000U0Out01VO selectGA09N200(@RequestBody SSBS6000U0In01VO vo, HttpServletRequest request) {
		return SVC.selectGA09N200(vo);
	}

	/**
	 * 사용자그룹 신규등록
	 */
	@ApiOperation(value="사용자그룹 신규등록")
	@RequestMapping(value= "/insertGA09N200", method = RequestMethod.POST)
	@ResponseBody
	public  int insertGA09N200(@RequestBody SSBS6000U0In02VO vo, HttpServletRequest request) {
		return SVC.insertGA09N200(vo);
	}
		
	/* 사용자그룹 수정 */	
	@RequestMapping(value= "/updaeGA09N200", method = RequestMethod.POST)
	@ResponseBody
	public  int updaeGA09N200(@RequestBody SSBS6000U0In02VO vo, HttpServletRequest request) {
		return SVC.updaeGA09N200(vo);
	}    

	/* 사용자그룹 삭제 */	
	@RequestMapping(value= "/deleteGA09N200", method = RequestMethod.POST)
	@ResponseBody
	public  int deleteGA09N200(@RequestBody SSBS6000U0In01VO vo, HttpServletRequest request) {
		return SVC.deleteGA09N200(vo);
	}      
	
}
