/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GASM1000U0Controller.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: RE100계약관리 컨트롤러
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.sm.controller;

import java.io.File;
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

import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.common.util.excel.resource.DefaultDataFormatDecider;
import com.miraeasset.biz.common.vo.CommonResponse;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In00VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out00VO;
import com.miraeasset.biz.ga.sm.service.GASM1000U0Service;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In00VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In01VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In02VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In03VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In04VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In11VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out00VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out01VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out11VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out12VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/main/gasm1000u0")
public class GASM1000U0Controller extends CustomRequestException{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	GASM1000U0Service GASM1000U0Service;

	/**
	 * RE100 계약관리 목록조회	
	 */
	@ApiOperation(value="RE100 계약관리 목록조회")
	@RequestMapping(value= "/selectListGA01N305", method = RequestMethod.POST)
	@ResponseBody
	public  List<GASM1000U0Out00VO> selectListGA01N305(@RequestBody GASM1000U0In00VO vo, HttpServletRequest request) {
		return GASM1000U0Service.selectListGA01N305(vo);
	}	

	/**
	 * RE100 상세정보조회(PK)
	 */
	@ApiOperation(value="RE100 상세정보조회(PK)")
	@RequestMapping(value= "/selectGA01N305PK", method = RequestMethod.POST)
	@ResponseBody
	public  List<GASM1000U0Out01VO> selectGA01N305PK(@RequestBody GASM1000U0In01VO vo, HttpServletRequest request) {
		return GASM1000U0Service.selectGA01N305PK(vo);
	}	
	
	/**
	 * RE100 전력구매계약정보
	 */
	@ApiOperation(value="RE100 전력구매계약정보")
	@RequestMapping(value= "/selectCapaInfo", method = RequestMethod.POST)
	@ResponseBody
	public  GASM1000U0Out12VO selectCapaInfo(HttpServletRequest request) {
		return GASM1000U0Service.selectCapaInfo();
	}		
	
	/**
	 * RE100 기안문서내역조회
	 */
	@ApiOperation(value="RE100 기안문서내역조회")
	@RequestMapping(value= "/selectListGA01N306", method = RequestMethod.POST)
	@ResponseBody
	public  List<GASM1000U0Out11VO> selectListGA01N306(@RequestBody GASM1000U0In11VO vo, HttpServletRequest request) {
		return GASM1000U0Service.selectListGA01N306(vo);
	}		

	
	/**
	 * RE100 수정(PK) 
	 */
	@ApiOperation(value="RE100 수정(PK)")
	@RequestMapping(value= "/updateGA01N305", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse updateGA01N305(@RequestBody GASM1000U0In02VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(GASM1000U0Service.updateGA01N305(vo));
		return response;
	}	
	
	/**
	 * RE100 신규등록
	 */
	@ApiOperation(value="RE100 신규등록")
	@RequestMapping(value= "/insertGA01N305", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse insertGA01N305(@RequestBody GASM1000U0In03VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(GASM1000U0Service.insertGA01N305(vo));
		return response;
	}		
	
	/**
	 * RE100 삭제수정(PK)
	 */
	@ApiOperation(value="RE100 삭제수정(PK)")
	@RequestMapping(value= "/updateDelGA01N305", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse updateDelGA01N305(@RequestBody GASM1000U0In04VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(GASM1000U0Service.updateDelGA01N305(vo));
		return response;
	}	

	/**
	 * RE100 엑셀다운로드
	 */
	@ApiOperation(value="RE100 엑셀다운로드")
	@RequestMapping(value= "/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(GASM1000U0In00VO vo, HttpServletResponse response) throws IOException {

		String fileName = "RE100계약관리내역_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		
		List<GASM1000U0Out00VO> list = GASM1000U0Service.selectListGA01N305(vo);
		ExcelFile<GASM1000U0Out00VO> excelFile = new OneSheetExcelFile<>(list, GASM1000U0Out00VO.class, new DefaultDataFormatDecider());
		excelFile.write2(response, downFileName);
	}	
	
}

