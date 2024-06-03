/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: BN
*	03. 파    일   명	: BNGN1000U0Controller.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 총무공지 컨트롤러
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.bn.gn.controller;

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

import com.miraeasset.biz.bn.gn.service.BNGN1000U0Service;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0In00VO;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0In01VO;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0In02VO;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0Out00VO;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0Out01VO;
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.common.vo.CommonResponse;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/main/bngn1000u0")
public class BNGN1000U0Controller extends CustomRequestException{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BNGN1000U0Service BNGN1000U0Service;

	/**
	 * 총무공지 목록조회	
	 */
	@ApiOperation(value="총무공지 목록조회")
	@RequestMapping(value= "/selectListGA09N421", method = RequestMethod.POST)
	@ResponseBody
	public  List<BNGN1000U0Out00VO> selectListGA09N421(@RequestBody BNGN1000U0In00VO vo, HttpServletRequest request) {
		return BNGN1000U0Service.selectListGA09N421(vo);
	}
	
	/**
	 * 총무공지 엑셀다운로드
	 */
	@ApiOperation(value="총무공지 엑셀다운로드")
	@RequestMapping(value= "/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(BNGN1000U0In00VO vo, HttpServletResponse response) throws IOException {

		String fileName = "총무공지_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		
		List<BNGN1000U0Out00VO> list = BNGN1000U0Service.selectListGA09N421(vo);
		ExcelFile<BNGN1000U0Out00VO> excelFile = new OneSheetExcelFile<>(list, BNGN1000U0Out00VO.class);
		excelFile.write2(response, downFileName);
	}	
		
	
	/**
	 * 총무공지 상세조회(PK)	
	 */
	@ApiOperation(value="총무공지 상세조회(PK)")
	@RequestMapping(value= "/selectGA09N421PK", method = RequestMethod.POST)
	@ResponseBody
	public  BNGN1000U0Out01VO selectGA09N421PK(@RequestBody BNGN1000U0In01VO vo, HttpServletRequest request) {
		return BNGN1000U0Service.selectGA09N421PK(vo);
	}		
	
	/**
	 * 총무공지 신규/수정(PK)	
	 */
	@ApiOperation(value="총무공지 신규/수정(PK)")
	@RequestMapping(value= "/updateGA09N421", method = RequestMethod.POST)
	@ResponseBody
	public  CommonResponse updateGA09N421(@RequestBody BNGN1000U0In02VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(BNGN1000U0Service.updateGA09N421(vo));
		return response;		
	}	
	
	/**
	 * 총무공지 삭제(PK)	
	 */
	@ApiOperation(value="총무공지 삭제(PK)")
	@RequestMapping(value= "/updateDelGA09N421", method = RequestMethod.POST)
	@ResponseBody
	public  CommonResponse updateDelGA09N421(@RequestBody BNGN1000U0In01VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(BNGN1000U0Service.updateDelGA09N421(vo));
		return response;		
	}		
}

