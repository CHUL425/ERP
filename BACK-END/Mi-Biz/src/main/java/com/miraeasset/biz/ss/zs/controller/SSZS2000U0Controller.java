/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSZS2000U0Controller.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 알림관리 컨트롤러
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.zs.controller;

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
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out00VO;
import com.miraeasset.biz.ss.zs.service.SSZS2000U0Service;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0In00VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0In01VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0In02VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0Out00VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0Out01VO;

import io.swagger.annotations.ApiOperation;


@Controller
@RequestMapping("/api/sszs/sszs2000u0")
public class SSZS2000U0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SSZS2000U0Service SVC;
   
	/**
	 * 알림관리 목록조회
	 */
	@ApiOperation(value="알림관리 목록조회")
	@RequestMapping(value= "/selectListGA09N501", method = RequestMethod.POST)
	@ResponseBody
	public List<SSZS2000U0Out00VO> selectListGA09N501(@RequestBody SSZS2000U0In00VO vo, HttpServletRequest request) {
		return SVC.selectListGA09N501(vo);
	}
	
	/**
	 * 알림관리 상세조회
	 */
	@ApiOperation(value="알림관리 상세조회")
	@RequestMapping(value= "/selectGA09N501", method = RequestMethod.POST)
	@ResponseBody
	public SSZS2000U0Out01VO selectGA09N501(@RequestBody SSZS2000U0In01VO vo, HttpServletRequest request) {
		return SVC.selectGA09N501(vo);
	}	

	/**
	 * 알림관리 신규등록
	 */
	@ApiOperation(value="알림관리 신규등록")
	@RequestMapping(value= "/insertGA09N501", method = RequestMethod.POST)
	@ResponseBody
	public int insertGA09N501(@RequestBody SSZS2000U0In02VO vo, HttpServletRequest request) {
		return SVC.insertGA09N501(vo);
	}	    
    
	/**
	 * 알림관리 수정
	 */
	@ApiOperation(value="알림관리 수정")
	@RequestMapping(value= "/updateGA09N501", method = RequestMethod.POST)
	@ResponseBody
	public int updateGA09N501(@RequestBody SSZS2000U0In02VO vo, HttpServletRequest request) {
		return SVC.updateGA09N501(vo);
	}	    
    
	/**
	 * 알림관리 삭제
	 */
	@ApiOperation(value="알림관리 삭제")
	@RequestMapping(value= "/deleteGA09N501", method = RequestMethod.POST)
	@ResponseBody
	public int deleteGA09N501(@RequestBody SSZS2000U0In01VO vo, HttpServletRequest request) {
		return SVC.deleteGA09N501(vo);
	}    
}
