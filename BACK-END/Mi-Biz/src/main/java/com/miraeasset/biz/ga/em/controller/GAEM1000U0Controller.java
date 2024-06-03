/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GAEM1000U0Controller.java
*	04. 작  성  일  자	: 2023.07.03
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 업체관리 컨트롤러
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.em.controller;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.util.CryptoUtil;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.common.vo.CommonResponse;
import com.miraeasset.biz.ga.em.service.GAEM1000U0Service;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Excel00VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In00VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In01VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In02VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In03VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In10VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In12VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In13VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In14VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out00VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out01VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out10VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out12VO;
import com.miraeasset.biz.rq.dr.vo.GA01N601SchVO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/main/gaem1000u0")
public class GAEM1000U0Controller extends CustomRequestException{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	GAEM1000U0Service GAEM1000U0Service;

	/**
	 * 거래처 팝업 조회 	
	 */
	@ApiOperation(value="거래처 팝업 조회")
	@RequestMapping(value= "/selectAT05C010", method = RequestMethod.POST)
	@ResponseBody
	public  List<GAEM1000U0Out10VO> selectAT05C010(@RequestBody GAEM1000U0In10VO vo, HttpServletRequest request) {
		return GAEM1000U0Service.selectAT05C010(vo);
	}	

	/**
	 * 업체관리 목록조회 	
	 */
	@ApiOperation(value="업체관리 목록조회")
	@RequestMapping(value= "/selectListGA01N301", method = RequestMethod.POST)
	@ResponseBody
	public  List<GAEM1000U0Out00VO> selectListGA01N301(@RequestBody GAEM1000U0In00VO vo, HttpServletRequest request) {
		return GAEM1000U0Service.selectListGA01N301(vo);
	}	
	

	/**
	 * 업체관리 상세조회(PK)
	 */
	@ApiOperation(value="업체관리 상세조회(PK)")
	@RequestMapping(value= "/selectGA01N301PK", method = RequestMethod.POST)
	@ResponseBody
	public  List<GAEM1000U0Out01VO> selectGA01N301PK(@RequestBody GAEM1000U0In01VO vo, HttpServletRequest request) {
		return GAEM1000U0Service.selectGA01N301PK(vo);
	}	
	
	/**
	 * 업체관리 업체메모 정보조회
	 */
	@ApiOperation(value="업체관리 업체메모 정보조회")
	@RequestMapping(value= "/selectMemoInfo", method = RequestMethod.POST)
	@ResponseBody
	public  List<GAEM1000U0Out12VO> selectMemoInfo(@RequestBody GAEM1000U0In12VO vo, HttpServletRequest request) {
		return GAEM1000U0Service.selectMemoInfo(vo);
	}	
    
	
	/**
	 * 업체관리 수정(PK)
	 */
	@ApiOperation(value="업체관리 수정(PK)")
	@RequestMapping(value= "/updateGA01N301", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse updateGA01N301(@RequestBody GAEM1000U0In02VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(GAEM1000U0Service.updateGA01N301(vo));
		return response;
	}	
	
	/**
	 * 업체관리 삭제(PK)
	 */
	@ApiOperation(value="업체관리 삭제(PK)")
	@RequestMapping(value= "/deleteGA01N301", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse deleteGA01N301(@RequestBody GAEM1000U0In02VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(GAEM1000U0Service.deleteGA01N301(vo));
		return response;
	}		
	
	/**
	 * 업체메모 삭제수정(PK)
	 */
	@ApiOperation(value="업체메모 삭제수정(PK)")
	@RequestMapping(value= "/updateDelGA01N302", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse updateDelGA01N302(@RequestBody GAEM1000U0In14VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(GAEM1000U0Service.updateDelGA01N302(vo));
		return response;
	}		
  

	/**
	 * 업체관리 신규등록
	 */
	@ApiOperation(value="업체관리 신규등록")
	@RequestMapping(value= "/insertGA01N301", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse insertGA01N301(@RequestBody GAEM1000U0In03VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(GAEM1000U0Service.insertGA01N301(vo));
		return response;
	}		
	
	/**
	 * 업체메모 신규등록 
	 */
	@ApiOperation(value="업체메모 신규등록")
	@RequestMapping(value= "/insertGA01N302", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse insertGA01N302(@RequestBody GAEM1000U0In13VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(GAEM1000U0Service.insertGA01N302(vo));
		return response;
	}
	
	/**
	 * 업체관리 엑셀다운로드
	 */
	@ApiOperation(value="업체관리 엑셀다운로드")
	@RequestMapping(value= "/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(GAEM1000U0In00VO vo, HttpServletResponse response) throws IOException {		
				
		// 엑셀 데이터 조회
		List<GAEM1000U0Out00VO> lst = GAEM1000U0Service.selectListGA01N301(vo);
		List<GAEM1000U0Excel00VO> lstN601 = new ArrayList<>();
		for (GAEM1000U0Out00VO schVo : lst) {
			GAEM1000U0Excel00VO n601 = new GAEM1000U0Excel00VO();
			//log.info("111 ["+schVo.getChprEmalAdr() +"["+schVo.getChprTlno()+"]");
			ObjectCopyUtil.copyFields(schVo, n601);
			//log.info("222 ["+n601.getChprEmalAdr() +"["+n601.getChprTlno()+"]");
			n601.setChprTlno(schVo.getChprTlno());
			n601.setChprEmalAdr(schVo.getChprEmalAdr());
			//log.info("333 ["+n601.getChprEmalAdr() +"["+n601.getChprTlno()+"]");
			lstN601.add(n601);
		}

		/*
		String tempStr = "D8gL65BzzR3xvkOso2Mq5Q==";
		
		if(!StringUtils.isBlank(tempStr)){
			log.info("tempStr["+tempStr+"["+CryptoUtil.getDecryption(tempStr)+"]");			
			tempStr = CryptoUtil.getDecryption(tempStr);
			log.info("==========> tempStr111 ["+tempStr+"]");			
			tempStr = CryptoUtil.getDecryption(tempStr);
			log.info("==========> tempStr222 ["+tempStr+"]");			
		}
		*/
		
		String fileName = "업체관리내역_"+DateUtil.getDate()+".xlsx";
		String encFileName = URLEncoder.encode(fileName, "UTF-8");
		// String encFileName = new String(fileName.getBytes(StandardCharsets.ISO_8859_1), "EUC-KR");
		// encFileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);

		ExcelFile<GAEM1000U0Excel00VO> excelFile = new OneSheetExcelFile<>(lstN601, GAEM1000U0Excel00VO.class);
		excelFile.write2(response, encFileName);

	}		
	
}

