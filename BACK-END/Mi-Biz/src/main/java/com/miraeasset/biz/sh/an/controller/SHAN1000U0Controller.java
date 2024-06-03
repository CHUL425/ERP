/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SH
*	03. 파    일   명	: SHAN1000U0Controller.java
*	04. 작  성  일  자	: 2024.02.05
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 안전보건공지 컨트롤러
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.sh.an.controller;

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
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.common.vo.CommonResponse;
import com.miraeasset.biz.sh.an.service.SHAN1000U0Service;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0In00VO;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0In01VO;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0Out01VO;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0Out02VO;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0Out03VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In01VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0Out01VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/main/shan1000u0")
public class SHAN1000U0Controller extends CustomRequestException{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SHAN1000U0Service SHAN1000U0Service;

	/**
	 * 안전보건공지 신규등록	
	 */
	@ApiOperation(value="안전보건공지 신규등록")
	@RequestMapping(value= "/insertGA09N421Sh", method = RequestMethod.POST)
	@ResponseBody
	public  CommonResponse insertGA09N421Sh(@RequestBody SHAN1000U0In00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(SHAN1000U0Service.insertGA09N421Sh(vo));
		return response;		
	}
	
	/**
	 * 안전보건공지 조회	
	 */
	@ApiOperation(value="안전보건공지 조회")
	@RequestMapping(value= "/selectListGA09N421Sh", method = RequestMethod.POST)
	@ResponseBody
	public List<SHAN1000U0Out01VO> selectListGA09N421Sh(@RequestBody SHAN1000U0In01VO vo) {
		return SHAN1000U0Service.selectListGA09N421Sh(vo);		
	}
	
	/**
	 * 안전보건공지 상세조회	
	 */
	@ApiOperation(value="안전보건공지 상세조회")
	@RequestMapping(value= "/selectInfoGA09N421Sh", method = RequestMethod.POST)
	@ResponseBody
	public SHAN3000U0Out01VO selectInfoGA09N421Sh(@RequestBody SHAN3000U0In01VO vo) {
		return SHAN1000U0Service.selectInfoGA09N421Sh(vo);		
	}
	
	/**
	 * 안전보건공지 삭제전 확인이력존재여부 조회
	 */
	@ApiOperation(value="안전보건공지 삭제전 확인이력존재여부 조회")
	@RequestMapping(value= "/selectShanCfmtHst", method = RequestMethod.POST)
	@ResponseBody
	public SHAN1000U0Out02VO selectShanCfmtHst(@RequestBody SHAN3000U0In01VO vo) {
		return SHAN1000U0Service.selectShanCfmtHst(vo);		
	}
	
	/**
	 * 안전보건공지 초기화면 팝업조회	
	 */
	@ApiOperation(value="안전보건공지 초기화면 팝업조회")
	@RequestMapping(value= "/selectShanInitPopup", method = RequestMethod.POST)
	@ResponseBody
	@AllAuth /* 전체 허용 */
	public SHAN1000U0Out03VO selectShanInitPopup(HttpServletRequest request) {
		return SHAN1000U0Service.selectShanInitPopup(request);	
	}
	
	
	/**
	 * 안전보건공지 엑셀다운로드
	 */
	@ApiOperation(value="안전보건공지 엑셀다운로드")
	@RequestMapping(value= "/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(SHAN1000U0In01VO vo, HttpServletResponse response) throws IOException {

		String fileName = "안전보건공지_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		
		List<SHAN1000U0Out01VO> list = SHAN1000U0Service.selectListGA09N421Sh(vo);
		ExcelFile<SHAN1000U0Out01VO> excelFile = new OneSheetExcelFile<>(list, SHAN1000U0Out01VO.class);
		excelFile.write2(response, downFileName);
	}	
		
}

