package com.miraeasset.biz.common.auth.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraeasset.biz.common.auth.service.AuthService;
import com.miraeasset.biz.common.auth.vo.Auth00In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N200In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N201In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N202In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N203In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N203Out00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N204In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N204Out00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N205In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N207In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N207Out00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N208In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N208Out00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N502In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N502Out00VO;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.vo.CommonResponse;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/api/common/auth")
public class AuthController extends CustomRequestException{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AuthService AuthService;

	/**
	 * API TEST
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse testGet(@RequestParam String text) {
		CommonResponse response = new CommonResponse();
		response.addData("HELLO Auth [" + text + "] WORLD!!!");

		return response;
	}

//	/**
//	 * 사용자의 화면별처리가능내역조회
//	 */
//	[20231024] 삭제 테이블 주석처리
//	@ApiIgnore
//	@ApiOperation(value="사용자의 화면별처리가능내역조회")
//	@RequestMapping(value= "/auth00/selList", method = RequestMethod.POST)
//	@ResponseBody
//	public List<Auth00In00VO> selectListAuth00(@RequestBody Auth00In00VO vo, HttpServletRequest request) {
////		CommonResponse response = new CommonResponse();
////		response.addData(AuthService.selectListAuth00(vo));
////		return response;
//		List<Auth00In00VO> list = AuthService.selectListAuth00(vo);
//		return list;
//	}
	
	/**
	 * 사용자그룹 기본조회
	 */
	@ApiIgnore
	@ApiOperation(value="사용자그룹 기본조회")
	@RequestMapping(value= "/GA09N200/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<AuthGA09N200In00VO> selectListGA09N200(@RequestBody AuthGA09N200In00VO vo, HttpServletRequest request) {
//		CommonResponse response = new CommonResponse();
//		response.addData(AuthService.selectListGA09N200(vo));
//		return response;
		List<AuthGA09N200In00VO> list = AuthService.selectListGA09N200(vo);
		return list;
	}			
	
	/**
	 * 사원별사용자그룹 기본조회
	 */
	@ApiIgnore
	@ApiOperation(value="사원별사용자그룹 기본조회")
	@RequestMapping(value= "/GA09N201/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<AuthGA09N201In00VO> selectListGA09N201(@RequestBody AuthGA09N201In00VO vo, HttpServletRequest request) {
//		CommonResponse response = new CommonResponse();
//		response.addData(AuthService.selectListGA09N201(vo));
//		return response;
		List<AuthGA09N201In00VO> list = AuthService.selectListGA09N201(vo);
		return list;
	}	
	
//	/**
//	 * 조직별사용자그룹 기본조회
//	 */
//	[20231024] 삭제 테이블 주석처리
//	@ApiIgnore
//	@ApiOperation(value="조직별사용자그룹 기본조회")
//	@RequestMapping(value= "/GA09N202/selList", method = RequestMethod.POST)
//	@ResponseBody
//	public List<AuthGA09N202In00VO> selectListGA09N202(@RequestBody AuthGA09N202In00VO vo, HttpServletRequest request) {
////		CommonResponse response = new CommonResponse();
////		response.addData(AuthService.selectListGA09N202(vo));
////		return response;
//		List<AuthGA09N202In00VO> list = AuthService.selectListGA09N202(vo);
//		return list;
//	}
	
	/**
	 * 사용자그룹별화면 기본조회
	 */
	@ApiIgnore
	@ApiOperation(value="사용자그룹별화면 기본조회")
	@RequestMapping(value= "/GA09N205/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<AuthGA09N205In00VO> selectListGA09N205(@RequestBody AuthGA09N205In00VO vo, HttpServletRequest request) {
//		CommonResponse response = new CommonResponse();
//		response.addData(AuthService.selectListGA09N205(vo));
//		return response;
		List<AuthGA09N205In00VO> list = AuthService.selectListGA09N205(vo);
		return list;
	}	
	
//	/**
//	 * 권한별 상위메뉴리스트 조회
//	 */
//	[20231024] 삭제 테이블 주석처리
//	@ApiIgnore
//	@ApiOperation(value="권한별 상위메뉴리스트 조회")
//	@RequestMapping(value= "/GA09N203/selList", method = RequestMethod.POST)
//	@ResponseBody
//	public List<AuthGA09N203Out00VO> selectListGA09N203(@RequestBody AuthGA09N203In00VO vo, HttpServletRequest request) {
//
////		HttpSession session = request.getSession();
////
////		LoginOutVO loginVo;
////		loginVo = (LoginOutVO)session.getAttribute("loginOutVO");
////		if (loginVo == null) {
////			if (vo.getEpno() == null || vo.getEpno().equals("")) {
////				vo.setEpno("s1213617");
////			}
////		} else {
////			vo.setEpno(loginVo.getEpno());
////		}
//
//		List<AuthGA09N203Out00VO> list = AuthService.selectList00GA09N203(vo);
//
//		return list;
//	}
	
//	/**
//	 * 권한별 메뉴리스트 조회
//	 */
//	[20231024] 삭제 테이블 주석처리
//	@ApiIgnore
//	@ApiOperation(value="권한별 메뉴리스트 조회")
//	@RequestMapping(value= "/GA09N204/selList", method = RequestMethod.POST)
//	@ResponseBody
//	public List<AuthGA09N204Out00VO> selectListGA09N204(@RequestBody AuthGA09N204In00VO vo, HttpServletRequest request) {
//
////		HttpSession session = request.getSession();
////
////		LoginOutVO loginVo;
////		loginVo = (LoginOutVO)session.getAttribute("loginOutVO");
////		if (loginVo == null) {
////			if (vo.getEpno() == null || vo.getEpno().equals("")) {
////				vo.setEpno("s1213617");
////			}
////		} else {
////			vo.setEpno(loginVo.getEpno());
////		}
//
//		List<AuthGA09N204Out00VO> list = AuthService.selectList00GA09N204(vo);
//
//		return list;
//	}
	
	/**
	 * 즐겨찾기조회
	 */
	@ApiOperation(value="즐겨찾기조회")
	@RequestMapping(value= "/ga09n207/sel", method = RequestMethod.POST)
	@ResponseBody
	public List<AuthGA09N207Out00VO> selectListGA09N207(HttpServletRequest request) {
		
		AuthGA09N207In00VO InVo = new AuthGA09N207In00VO();
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			InVo.setEpno(loginVo.getEpno());
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		List<AuthGA09N207Out00VO> list = AuthService.selectList00GA09N207(InVo);
		return list;
	}
	
	/**
	 * 즐겨찾기등록
	 */
	@ApiOperation(value="즐겨찾기등록")
	@RequestMapping(value= "/ga09n207/ins", method = RequestMethod.POST)
	@ResponseBody
	public List<AuthGA09N207Out00VO> insertGA09N207(@RequestBody AuthGA09N207In00VO vo, HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setEpno(loginVo.getEpno());
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		List<AuthGA09N207Out00VO> list = AuthService.insert00GA09N207(vo);
		return list;
	}
	
	/**
	 * 즐겨찾기삭제
	 */
	@ApiOperation(value="즐겨찾기삭제")
	@RequestMapping(value= "/ga09n207/del", method = RequestMethod.POST)
	@ResponseBody
	public List<AuthGA09N207Out00VO> deleteGA09N207(@RequestBody AuthGA09N207In00VO vo, HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setEpno(loginVo.getEpno());
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		List<AuthGA09N207Out00VO> list = AuthService.delete00GA09N207(vo);
		
		return list;
	}
	
	/**
	 * 태그 검색 조회
	 */
	@ApiOperation(value="태그 검색 조회")
	@RequestMapping(value= "/selectSrch", method = RequestMethod.POST)
	@ResponseBody
	public List<AuthGA09N208Out00VO> selectSrch(@RequestBody AuthGA09N208In00VO vo, HttpServletRequest request) {
		return AuthService.selectSrch(vo);
	}
	
	/**
	 * 알림벨 리스트 조회
	 */
	@ApiOperation(value="알림벨 리스트 조회")
	@RequestMapping(value= "/IprtList", method = RequestMethod.POST)
	@ResponseBody
	public List<AuthGA09N502Out00VO> selectIprtList(@RequestBody AuthGA09N502In00VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setEpno(loginVo.getEpno());
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		return AuthService.selectIprtList(vo);
	}
	
	/**
	 * 알림벨 읽음 상태 변경
	 */
	@ApiOperation(value="알림벨 읽음 상태 변경")
	@RequestMapping(value= "/IprtReadYn", method = RequestMethod.POST)
	@ResponseBody
	public List<AuthGA09N502Out00VO> updateIprtReadYn(@RequestBody AuthGA09N502In00VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setEpno(loginVo.getEpno());
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		List<AuthGA09N502Out00VO> list = AuthService.updateIprtReadYn(vo);
		return list;
	}
	
	/**
	 * 알림읽음상태 조회
	 */
	@ApiOperation(value="알림읽음상태 조회")
	@RequestMapping(value= "/IprtReadStat", method = RequestMethod.POST)
	@ResponseBody
	public AuthGA09N502Out00VO selectIprtReadStat(HttpServletRequest request) {
		AuthGA09N502In00VO inVo = new AuthGA09N502In00VO();
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			inVo.setEpno(loginVo.getEpno());
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return AuthService.selectIprtReadStat(inVo);
	}
}

