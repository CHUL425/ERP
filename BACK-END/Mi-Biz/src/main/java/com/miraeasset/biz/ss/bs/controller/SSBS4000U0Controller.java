/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS4000U0Controller.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 메뉴관리 컨트롤러
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
import com.miraeasset.biz.ss.bs.service.SSBS4000U0Service;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In02VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0Out01VO;

import io.swagger.annotations.ApiOperation;


@Controller
@RequestMapping("/api/ssbs/ssbs4000u0")
public class SSBS4000U0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SSBS4000U0Service SVC;
   
	/**
	 * 메뉴관리 목록조회
	 */
	@ApiOperation(value="메뉴관리 목록조회")
	@RequestMapping(value= "/selectListGA09N203", method = RequestMethod.POST)
	@ResponseBody
	public List<SSBS4000U0Out00VO> selectListGA09N203(@RequestBody SSBS4000U0In00VO vo, HttpServletRequest request) {
		return SVC.selectListGA09N203(vo);
	}

	/**
	 * 메뉴관리 상세조회 PK
	 */
	@ApiOperation(value="메뉴관리 상세조회 PK")
	@RequestMapping(value= "/selectGA09N203PK", method = RequestMethod.POST)
	@ResponseBody
	public SSBS4000U0Out01VO selectGA09N203PK(@RequestBody SSBS4000U0In01VO vo, HttpServletRequest request) {
		return SVC.selectGA09N203PK(vo);
	}	
	
	/**
	 * 메뉴관리 신규등록
	 */
	@ApiOperation(value="메뉴관리 신규등록")
	@RequestMapping(value= "/insertGA09N203", method = RequestMethod.POST)
	@ResponseBody
	public int insertGA09N203(@RequestBody SSBS4000U0In02VO vo, HttpServletRequest request) {
		return SVC.insertGA09N203(vo);
	}		
	
	/**
	 * 메뉴관리 수정처리
	 */
	@ApiOperation(value="메뉴관리 수정처리")
	@RequestMapping(value= "/updateGA09N203", method = RequestMethod.POST)
	@ResponseBody
	public int updateGA09N203(@RequestBody SSBS4000U0In02VO vo, HttpServletRequest request) {
		return SVC.updateGA09N203(vo);
	}		
	
	/**
	 * 메뉴관리 수정처리
	 */
	@ApiOperation(value="메뉴관리 삭제처리")
	@RequestMapping(value= "/deleteGA09N203", method = RequestMethod.POST)
	@ResponseBody
	public int deleteGA09N203(@RequestBody SSBS4000U0In01VO vo, HttpServletRequest request) {
		return SVC.deleteGA09N203(vo);
	}		

}
