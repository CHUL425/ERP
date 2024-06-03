/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: SSBS7000U0Controller.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹별 화면관리 컨트롤러
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

import com.miraeasset.biz.common.annotation.AllAuth;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.ss.bs.service.SSBS7000U0Service;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In04VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In05VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In11VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out01VO;

import io.swagger.annotations.ApiOperation;


@Controller
@RequestMapping("/api/ssbs/ssbs7000u0")
public class SSBS7000U0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SSBS7000U0Service SVC;
   
	/**
	 * 사용자그룹_화면 목록조회
	 */
	@ApiOperation(value="사용자그룹_화면 목록조회")
	@RequestMapping(value= "/selectListGA09N205", method = RequestMethod.POST)
	@ResponseBody
	public List<SSBS7000U0Out00VO> ssbs9000v0sel00(@RequestBody SSBS7000U0In00VO vo, HttpServletRequest request) {
		List<SSBS7000U0Out00VO> list = SVC.selectListGA09N205(vo);
		return list;
	}
	
	/**
	 * 사용자그룹_화면 상세조회
	 */
	@ApiOperation(value="사용자그룹_화면 상세조회")
	@RequestMapping(value= "/selectGA09N205Pk", method = RequestMethod.POST)
	@ResponseBody
	public SSBS7000U0Out01VO selectGA09N205Pk(@RequestBody SSBS7000U0In01VO vo, HttpServletRequest request) {
		return SVC.selectGA09N205Pk(vo);
	}
	
	/**
	 * 사용자그룹_화면 상세조회(접수번호기준)
	 */
	@ApiOperation(value="사용자그룹_화면 상세조회(접수번호기준)")
	@RequestMapping(value= "/selectGA09N205ByRecNo", method = RequestMethod.POST)
	@ResponseBody
	public SSBS7000U0Out01VO selectGA09N205ByRecNo(@RequestBody SSBS7000U0In05VO vo, HttpServletRequest request) {
		return SVC.selectGA09N205ByRecNo(vo);
	}
	
  
	/**
	 * 사용자그룹_화면 정상건 목록조회
	 */
	@ApiOperation(value="사용자그룹_화면 정상건 목록조회")
	@RequestMapping(value= "/selectListGA09N205ByNrml", method = RequestMethod.POST)
	@ResponseBody
	public List<SSBS7000U0Out00VO> selectListGA09N205ByNrml(@RequestBody SSBS7000U0In11VO vo, HttpServletRequest request) {
		return SVC.selectListGA09N205ByNrml(vo);
	}
	
	/**
	 * 사용자그룹_화면 임시저장(수정)/상신
	 */
	@ApiOperation(value="사용자그룹_화면 임시저장(수정)/상신 다건")
	@RequestMapping(value= "/reqRegiListGA09N205", method = RequestMethod.POST)
	@ResponseBody
	public String reqRegiListGA09N205(@RequestBody SSBS7000U0In03VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setRqsEpno(loginVo.getEpno()); // 로그인사번
			vo.setRqsOrzCd(loginVo.getBlngOrzCd()); //로그인조직코드
			
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return SVC.reqRegiListGA09N205(vo);
	}	
	
	/**
	 * 사용자그룹_화면 임시저장(수정)/상신
	 */
	@ApiOperation(value="사용자그룹_화면 임시저장(수정)/상신 단건")
	@RequestMapping(value= "/reqRegiGA09N205", method = RequestMethod.POST)
	@ResponseBody
	public String reqRegi(@RequestBody SSBS7000U0In04VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setRqsEpno(loginVo.getEpno()); // 로그인사번
			vo.setRqsOrzCd(loginVo.getBlngOrzCd()); //로그인조직코드
			
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return SVC.reqRegiGA09N205(vo);
	}		
	
	/**
	 * 사용자그룹_화면 반려건 재신청
	 */
	@ApiOperation(value="사용자그룹_화면 반려건 재신청")
	@RequestMapping(value= "/reApplyByRctNo", method = RequestMethod.POST)
	@ResponseBody
	public  String reApplyByRctNo(@RequestBody SSBS7000U0In05VO vo, HttpServletRequest request) {
		LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		return SVC.reApplyByRctNo(vo,loginVo);
	}	
	
	/**
	 * 사용자그룹_화면 목록조회(일반신청 메뉴설정용)
	 */
	@ApiOperation(value="사용자그룹_화면 목록조회(일반신청 메뉴설정용)")
	@RequestMapping(value= "/selectListGA09N205Grp", method = RequestMethod.POST)
	@ResponseBody
	@AllAuth
	public List<SSBS7000U0Out00VO> ssbs9000v0sel01(@RequestBody SSBS7000U0In00VO vo, HttpServletRequest request) {
		List<SSBS7000U0Out00VO> list = SVC.selectListGA09N205(vo);
		return list;
	}

}
