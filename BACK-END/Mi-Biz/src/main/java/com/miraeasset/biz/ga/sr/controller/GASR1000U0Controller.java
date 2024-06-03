/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GASR1000U0Controller.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인장조제관리 컨트롤러
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.sr.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.common.vo.CommonResponse;
import com.miraeasset.biz.ga.sr.service.GASR1000U0Service;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0In00VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0In01VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0In02VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0In03VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0In04VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out00VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out01VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out11VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out12VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out13VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/main/gasr1000u0")
public class GASR1000U0Controller extends CustomRequestException{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	GASR1000U0Service GASR1000U0Service;

	/**
	 * 인장조제관리 목록조회	
	 */
	@ApiOperation(value="인장조제관리 목록조회")
	@RequestMapping(value= "/selectListGA01N501", method = RequestMethod.POST)
	@ResponseBody
	public  List<GASR1000U0Out00VO> selectListGA01N501(@RequestBody GASR1000U0In00VO vo, HttpServletRequest request) {
		return GASR1000U0Service.selectListGA01N501(vo);
	}
	
	/**
	 * 인장조제관리 인장유형 통계정보조회	
	 */
	@ApiOperation(value="인장조제관리 인장유형 통계정보조회")
	@RequestMapping(value= "/selectInfoGA01N501BySalPcd", method = RequestMethod.POST)
	@ResponseBody
	public  GASR1000U0Out11VO selectInfoGA01N501BySalPcd(@RequestBody GASR1000U0In00VO vo, HttpServletRequest request) {
		return GASR1000U0Service.selectInfoGA01N501BySalPcd(vo);
	}
	
	/**
	 * 인장조제관리 인장상태 통계정보조회	
	 */
	@ApiOperation(value="인장조제관리 인장상태 통계정보조회")
	@RequestMapping(value= "/selectInfoGA01N501BySalScd", method = RequestMethod.POST)
	@ResponseBody
	public  GASR1000U0Out13VO selectInfoGA01N501BySalScd(@RequestBody GASR1000U0In00VO vo, HttpServletRequest request) {
		return GASR1000U0Service.selectInfoGA01N501BySalScd(vo);
	}
	
	/**
	 * 인감날인 인감 콤보박스 	
	 */
	@ApiOperation(value="인감날인 인감 콤보박스")
	@RequestMapping(value= "/selectListSealSalg", method = RequestMethod.POST)
	@ResponseBody
	@AllAuth /* 전체 허용 */
	public  List<GASR1000U0Out12VO> selectListSealSalg(HttpServletRequest request) {
		return GASR1000U0Service.selectListSealSalg();
	}

	/**
	 * 인감증명서 인감 콤보박스	
	 */
	@ApiOperation(value="인감증명서 인감 콤보박스")
	@RequestMapping(value= "/selectListSealDoc", method = RequestMethod.POST)
	@ResponseBody
	@AllAuth /* 전체 허용 */
	public  List<GASR1000U0Out12VO> selectListSealDoc(HttpServletRequest request) {
		return GASR1000U0Service.selectListSealDoc();
	}

	/**
	 * 인장조제관리 엑셀다운로드
	 */
	@ApiOperation(value="인장조제관리 엑셀다운로드")
	@RequestMapping(value= "/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(GASR1000U0In00VO vo, HttpServletResponse response) throws IOException {

		String fileName = "인장조제관리_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		
		List<GASR1000U0Out00VO> list = GASR1000U0Service.selectListGA01N501(vo);
		ExcelFile<GASR1000U0Out00VO> excelFile = new OneSheetExcelFile<>(list, GASR1000U0Out00VO.class);
		excelFile.write2(response, downFileName);
	}	
	

	/**
	 * 인장조제관리 상세정보조회(PK)	
	 */
	@ApiOperation(value="인장조제관리 상세정보조회(PK)")
	@RequestMapping(value= "/selectGA01N501PK", method = RequestMethod.POST)
	@ResponseBody
	public  GASR1000U0Out01VO selectGA01N501PK(@RequestBody GASR1000U0In01VO vo, HttpServletRequest request) {
		return GASR1000U0Service.selectGA01N501PK(vo);
	}	
	
	/**
	 * 인장조제관리 접수
	 */
	@ApiOperation(value="인장조제관리 접수")
	@RequestMapping(value= "/insertGA01N501", method = RequestMethod.POST)
	@ResponseBody
	public  CommonResponse insertGA01N501(@RequestBody GASR1000U0In03VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setRqsEpno(loginVo.getEpno()); // 로그인사번
			vo.setRqsOrzCd(loginVo.getBlngOrzCd()); // 로그인사번
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		CommonResponse response = new CommonResponse();
		response.addData(GASR1000U0Service.insertGA01N501(vo));		
		return response;
	}
	
	/**
	 * 인장조제관리 신청
	 */
	@ApiOperation(value="인장조제관리 신청")
	@RequestMapping(value= "/insertGA01N101", method = RequestMethod.POST)
	@ResponseBody
	public  CommonResponse insertGA01N101(@RequestBody GASR1000U0In03VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setRqsEpno(loginVo.getEpno()); // 로그인사번
			vo.setRqsOrzCd(loginVo.getBlngOrzCd()); // 로그인사번
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		CommonResponse response = new CommonResponse();
		response.addData(GASR1000U0Service.insertGA01N101(vo));		
		return response;
	}
	
	/**
	 * 인장조제관리 담당자취소/내용수정/회수/폐기 단건처리
	 */
	@ApiOperation(value="인장조제관리 담당자취소/내용수정/회수/폐기 단건처리")
	@RequestMapping(value= "/updateGA01N501ByTrTcd", method = RequestMethod.POST)
	@ResponseBody
	public  CommonResponse updateGA01N501ByTrTcd(@RequestBody GASR1000U0In02VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setRqsEpno(loginVo.getEpno()); // 로그인사번
			vo.setRqsOrzCd(loginVo.getBlngOrzCd()); // 로그인사번
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
				
		CommonResponse response = new CommonResponse();
		response.addData(GASR1000U0Service.updateGA01N501ByTrTcd(vo));		
		return response;
	}		
	

	/**
	 * 인장조제관리 폐기신청 일괄처리
	 */
	@ApiOperation(value="인장조제관리 폐기신청 일괄처리")
	@RequestMapping(value= "/updateListGA01N501ByDSUS", method = RequestMethod.POST)
	@ResponseBody
	public  CommonResponse updateListGA01N501ByDSUS(@RequestBody GASR1000U0In04VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setRqsEpno(loginVo.getEpno()); // 로그인사번
			vo.setRqsOrzCd(loginVo.getBlngOrzCd()); // 로그인사번
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}		
		CommonResponse response = new CommonResponse();
		response.addData(GASR1000U0Service.updateListGA01N501ByDSUS(vo));		
		return response;
	}	
	
	/**
	 * 인장조제관리 상세정보조회(승인관리-상세)	
	 */
	@ApiOperation(value="인장조제관리 상세정보조회(승인관리-상세)")
	@RequestMapping(value= "/selectGA01N501Aprv", method = RequestMethod.POST)
	@ResponseBody
	public  GASR1000U0Out01VO selectGA01N501Aprv(@RequestBody GASR1000U0In02VO vo, HttpServletRequest request) {
		return GASR1000U0Service.selectGA01N501Aprv(vo);
	}	
	
	/**
	 * 인장관리번호 최신화(임시)
	 */
	@ApiOperation(value="인장관리번호 최신화(임시)")
	@RequestMapping(value= "/updateCmnByGA01N501", method = RequestMethod.POST)
	@ResponseBody
	public  CommonResponse updateCmnByGA01N501() {
		CommonResponse response = new CommonResponse();
		response.addData(GASR1000U0Service.updateCmnByGA01N501());		
		return response;
	}
	
}

