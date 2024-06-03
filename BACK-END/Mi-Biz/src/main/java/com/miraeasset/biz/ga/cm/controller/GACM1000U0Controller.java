package com.miraeasset.biz.ga.cm.controller;


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
import com.miraeasset.biz.ga.cm.service.GACM1000U0Service;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In00VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In01VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In02VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In03VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In04VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In10VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In11VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out00VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out01VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out10VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out11VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In00VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out00VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In00VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out00VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/main/gacm1000u0")
public class GACM1000U0Controller extends CustomRequestException{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	GACM1000U0Service GACM1000U0Service;
	
	/**
	 * 계약서관리 내역조회	
	 */
	@ApiOperation(value="계약서관리 내역조회")
	@RequestMapping(value= "/selectListGA01N303", method = RequestMethod.POST)
	@ResponseBody
	public  List<GACM1000U0Out00VO> selectListGA01N303(@RequestBody GACM1000U0In00VO vo, HttpServletRequest request) {
		return GACM1000U0Service.selectListGA01N303(vo);
	}	
	
	/**
	 * 계약서관리 업체계약현황조회	
	 */
	@ApiOperation(value="계약서관리 업체계약현황조회")
	@RequestMapping(value= "/selLstGA01N303ByDelpCd", method = RequestMethod.POST)
	@ResponseBody
	public  List<GACM1000U0Out10VO> selLstGA01N303ByDelpCd(@RequestBody GACM1000U0In10VO vo, HttpServletRequest request) {
		return GACM1000U0Service.selLstGA01N303ByDelpCd(vo);
	}		
	

	/**
	 * 계약서관리 업체계약현황조회 엑셀다운로드
	 */
	@ApiOperation(value="계약서관리 업체계약현황조회 엑셀다운로드")
	@RequestMapping(value= "/excel2", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel2(GACM1000U0In10VO vo, HttpServletResponse response) throws IOException {

		String fileName = "업체계약현황조회_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		
		List<GACM1000U0Out10VO> list = GACM1000U0Service.selLstGA01N303ByDelpCd(vo);
		ExcelFile<GACM1000U0Out10VO> excelFile = new OneSheetExcelFile<>(list, GACM1000U0Out10VO.class, new DefaultDataFormatDecider());
		excelFile.write2(response, downFileName);
	}		
		
	
	/**
	 * 계약서관리 기안문서내역조회	
	 */
	@ApiOperation(value="계약서관리 기안문서내역조회")
	@RequestMapping(value= "/selectListGA01N306", method = RequestMethod.POST)
	@ResponseBody
	public  List<GACM1000U0Out11VO> selectListGA01N306(@RequestBody GACM1000U0In11VO vo, HttpServletRequest request) {
		return GACM1000U0Service.selectListGA01N306(vo);
	}		
	
		

	/**
	 * 계약서관리 상세조회(PK)	
	 */
	@ApiOperation(value="계약서관리 상세조회(PK)")
	@RequestMapping(value= "/selectGA01N303PK", method = RequestMethod.POST)
	@ResponseBody
	public  List<GACM1000U0Out01VO> selectGA01N303PK(@RequestBody GACM1000U0In01VO vo, HttpServletRequest request) {
		return GACM1000U0Service.selectGA01N303PK(vo);
	}	


	/**
	 * 계약서관리 수정(PK)	
	 */
	@ApiOperation(value="계약서관리 수정(PK)")
	@RequestMapping(value= "/updateGA01N303", method = RequestMethod.POST)
	@ResponseBody
	public  CommonResponse updateGA01N303(@RequestBody GACM1000U0In02VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(GACM1000U0Service.updateGA01N303(vo));
		return response;		
	}	

	/**
	 * 계약서관리 삭제수정(PK)
	 */
	@ApiOperation(value="계약서관리 삭제수정(PK)")
	@RequestMapping(value= "/updateDelGA01N303", method = RequestMethod.POST)
	@ResponseBody
	public  CommonResponse updateDelGA01N303(@RequestBody GACM1000U0In04VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(GACM1000U0Service.updateDelGA01N303(vo));
		return response;		
	}		
     
	/**
	 * 계약서관리 신규등록
	 */
	@ApiOperation(value="계약서관리 신규등록")
	@RequestMapping(value= "/insertGA01N303", method = RequestMethod.POST)
	@ResponseBody
	public  CommonResponse insertGA01N303(@RequestBody GACM1000U0In03VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(GACM1000U0Service.insertGA01N303(vo));
		return response;		
	}
	
	/**
	 * 계약서관리 엑셀다운로드
	 */
	@ApiOperation(value="계약서관리 엑셀다운로드")
	@RequestMapping(value= "/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(GACM1000U0In00VO vo, HttpServletResponse response) throws IOException {

		String fileName = "계약서관리내역_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		
		List<GACM1000U0Out00VO> list = GACM1000U0Service.selectListGA01N303(vo);
		ExcelFile<GACM1000U0Out00VO> excelFile = new OneSheetExcelFile<>(list, GACM1000U0Out00VO.class, new DefaultDataFormatDecider());
		excelFile.write2(response, downFileName);
	}		
	
}

