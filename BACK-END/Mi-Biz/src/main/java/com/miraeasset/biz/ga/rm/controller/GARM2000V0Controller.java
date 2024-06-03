package com.miraeasset.biz.ga.rm.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.meta.vo.GA09N411VO;
import com.miraeasset.biz.common.service.CommonService;
import com.miraeasset.biz.common.util.CryptoUtil;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.ExcelUpload;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.ga.rm.service.GARM2000V0Service;
import com.miraeasset.biz.ga.rm.vo.GARM2000ExcelVO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0In00VO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0Out00VO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0Out02VO;
import com.miraeasset.biz.ga.rm.vo.GARM2010V0In00VO;
import com.miraeasset.biz.ga.rm.vo.GARM2010V0In01VO;
import com.miraeasset.biz.ga.rm.vo.GARM2010V0Out00VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/garm")
public class GARM2000V0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	GARM2000V0Service SVC;
	@Autowired
	ExcelUpload exl;
	
	/**
	 * 렌탈관리내역(복합기) 조회
	 */
	@ApiOperation(value="렌탈관리내역(복합기) 조회")
	@RequestMapping(value= "/garm2000v0/sel00", method = RequestMethod.POST)
	@ResponseBody
	public GARM2000V0Out02VO garm2000v0sel00(@RequestBody GARM2000V0In00VO vo, HttpServletRequest request) {
		GARM2000V0Out02VO list = SVC.selectList04GA01N003(vo);
		return list;
	}
	
	/**
	 * 렌탈관리내역 엑셀다운로드
	 */
	@ApiOperation(value="렌탈관리내역(복합기) 엑셀다운로드")
	@RequestMapping(value= "/garm2000v0/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(GARM2000V0In00VO vo, HttpServletResponse response) throws IOException {
		String fileName = "렌탈관리내역(복합기)_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		List<GARM2000V0Out00VO> list = SVC.selectList00GA01N003(vo);
		ExcelFile<GARM2000V0Out00VO> excelFile = new OneSheetExcelFile<>(list, GARM2000V0Out00VO.class);
		excelFile.write2(response, downFileName);
	}
	
	/*
	 * 엑셀 업로드
	 */
	@RequestMapping(value= "/garm2000v0/excelup", method = RequestMethod.POST)
	public @ResponseBody int uploadExcel(MultipartHttpServletRequest request) throws Exception {
		MultipartFile excelFile = request.getFile("excelFile");
		// pk column dupChk
		String[] chkCol = { "exccYm", "mtOrzCd", "rentCntcNo"};
		
//		String email = "jasdas@naver.com"; 
//		
//		CryptoUtil.getDecryption(email);
//		
//		log.info(" getDecryption {}", email);
//		
//		CryptoUtil.getEncryption(email);
//		
//		log.info(" getEncryption {}", email);
		
		List<Map<String, Object>>list = exl.excelFileUpload(excelFile, chkCol, 1, GARM2000ExcelVO.class);
		
		return SVC.excelUpload(list);
	}
	
	/**
	 * 연간렌탈료 정산(계산) 조회
	 */
	@ApiOperation(value="연간렌탈료 정산(계산) 조회")
	@RequestMapping(value= "/garm2010v0/sel00", method = RequestMethod.POST)
	@ResponseBody
	public List<GARM2010V0Out00VO> garm2010v0sel00(@RequestBody GARM2010V0In00VO vo, HttpServletRequest request) {
		List<GARM2010V0Out00VO> list = SVC.selectList02GA01N003(vo);
		return list; 
	}
	
	/**
	 * 연간렌탈료 정산(계산) 수정
	 */
	@ApiOperation(value="연간렌탈료 정산(계산) 수정")
	@RequestMapping(value= "/garm2010v0/up00", method = RequestMethod.POST)
	@ResponseBody
	public int garm2010v0up00(@RequestBody GARM2010V0In01VO vo, HttpServletRequest request) {
		int update = SVC.update00GA01N003(vo);
		return update;
	}

	@ApiOperation(value="복합기 정산년월 단가 조회")
	@RequestMapping(value= "/garm2010v0/sel01", method = RequestMethod.POST)
	@ResponseBody
	public GARM2010V0In01VO garm2010v0sel01(@RequestBody GARM2010V0In01VO garm2010V0In01VO) {
		return SVC.selectOne00GA01N003(garm2010V0In01VO);
	}
}
