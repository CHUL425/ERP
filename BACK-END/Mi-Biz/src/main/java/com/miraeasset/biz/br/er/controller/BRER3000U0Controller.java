package com.miraeasset.biz.br.er.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.miraeasset.biz.br.er.service.BRER3000U0Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraeasset.biz.br.er.vo.BRER3000U0In00VO;
import com.miraeasset.biz.br.er.vo.BRER3000U0Out00VO;
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/br/er/3000")
public class BRER3000U0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final BRER3000U0Service brer3000U0Service;

	public BRER3000U0Controller(BRER3000U0Service brer3000U0Service) {
		this.brer3000U0Service = brer3000U0Service;
	}


	/**
	 * 지점실내/외관리 무인경비 조회 
	 */
	@ApiOperation(value="무인경비 조회")
	@RequestMapping(value= "/get", method = RequestMethod.POST)
	@ResponseBody
	public  List<BRER3000U0Out00VO> selectList00GA02N004(@RequestBody BRER3000U0In00VO brer3000U0In00VO) {
		return brer3000U0Service.selectList00GA02N004(brer3000U0In00VO);
	}

	
	/**
	 * 지점실내/외관리 무인경비 관리
	 */
	@ApiOperation(value="무인경비 관리")
	@RequestMapping(value= "/save", method = RequestMethod.POST)
	@ResponseBody
	public int merge00GA02N004(@RequestBody List<BRER3000U0Out00VO> brer3000U0Out00VOList) {
		for(BRER3000U0Out00VO brer3000U0Out00VO : brer3000U0Out00VOList) {
			System.out.println("#############################" + brer3000U0Out00VO.getOptrId());
		}


		return brer3000U0Service.merge00GA02N004(brer3000U0Out00VOList);
	}
	
	
	/**
	 * 지점실내/외관리 무인경비 삭제
	 */
	@ApiOperation(value="무인경비 삭제")
	@RequestMapping(value= "/delet", method = RequestMethod.POST)
	@ResponseBody
	public int delete00GA02N004 (@RequestBody List<BRER3000U0In00VO> brer3000U0In00VOList) {
		return brer3000U0Service.delete00GA02N004(brer3000U0In00VOList);
	}	
	
	/**
	 * 무인경비 엑셀다운로드
	 */
	@ApiOperation(value="무인경비 엑셀다운로드")
	@RequestMapping(value= "/BRER3000U0/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(BRER3000U0In00VO vo, HttpServletResponse response) throws IOException {
		
		String fileName     = "지점실내외관리_무인경비_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		
		List<BRER3000U0Out00VO> list = brer3000U0Service.selectList00GA02N004(vo);
		ExcelFile<BRER3000U0Out00VO> excelFile = new OneSheetExcelFile<>(list, BRER3000U0Out00VO.class);
		
		excelFile.write2(response, downFileName);
	}

}
