/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS9000V0Controller.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 판관비계정관리 컨트롤러
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

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.ss.bs.service.SSBS9000V0Service;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In02VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0Out02VO;

import io.swagger.annotations.ApiOperation;


@Controller
@RequestMapping("/api/ssbs")
public class SSBS9000V0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SSBS9000V0Service SVC;

	/**
	 * 판관비판관비계정과목관리 조회
	 */
	@ApiOperation(value="판관비판관비계정과목관리 조회")
	@RequestMapping(value= "/ssbs9000v0/sel00", method = RequestMethod.POST)
	@ResponseBody
	public List<SSBS9000V0Out00VO> ssbs9000v0sel00(@RequestBody SSBS9000V0In00VO vo, HttpServletRequest request) {
		List<SSBS9000V0Out00VO> list = SVC.selectList00GA01C001(vo);
		return list;
	}
	
	/**
	 * 판관비판관비계정과목관리 상세조회
	 */
	@ApiOperation(value="판관비판관비계정과목관리 상세조회")
	@RequestMapping(value= "/ssbs9000v0/selectGA01C001", method = RequestMethod.POST)
	@ResponseBody
	public SSBS9000V0Out02VO selectGA01C001(@RequestBody SSBS9000V0In02VO vo, HttpServletRequest request) {
		return SVC.selectGA01C001(vo);
	}	
	
	/**
	 * 판관비판관비계정과목관리 신규등록 다건처리
	 */
	@ApiOperation(value="판관비판관비계정과목관리 신규등록 다건처리")
	@RequestMapping(value= "/ssbs9000v0/insertGA01C001", method = RequestMethod.POST)
	@ResponseBody
	public int insertGA01C001(@RequestBody SSBS9000V0In01VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}		
		return SVC.insertGA01C001(vo);
	}
    
	/**
	 * 판관비판관비계정과목관리 수정
	 */
	@ApiOperation(value="판관비판관비계정과목관리 수정")
	@RequestMapping(value= "/ssbs9000v0/updateGA01C001", method = RequestMethod.POST)
	@ResponseBody
	public int updateGA01C001(@RequestBody SSBS9000V0In03VO vo, HttpServletRequest request) {
		return SVC.updateGA01C001(vo);
	}	
	
	
	/**
	 * 판관비판관비계정과목관리 삭제 다건처리
	 */
	@ApiOperation(value="판관비판관비계정과목관리 삭제 다건처리")
	@RequestMapping(value= "/ssbs9000v0/deleteGA01C001", method = RequestMethod.POST)
	@ResponseBody
	public int deleteGA01C001(@RequestBody SSBS9000V0In01VO vo, HttpServletRequest request) {
		return SVC.deleteGA01C001(vo);
	}    
	
}
