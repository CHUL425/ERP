package com.miraeasset.biz.ga.vm.controller;

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
import com.miraeasset.biz.ga.vm.service.GAVM1000U0Service;
import com.miraeasset.biz.ga.vm.vo.GAVM1000U0In00VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1000U0In01VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1000U0Out00VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1000U0Out01VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1000U0VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In00VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In01VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In02VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In03VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In04VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In05VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0Out00VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0Out01VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out00VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/gavm")
public class GAVM1000U0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	GAVM1000U0Service SVC;
	
	/**
	 * 임대차량정보관리 조회
	 */
	@ApiOperation(value="임대차량정보관리 조회")
	@RequestMapping(value= "/gavm1000u0/sel00", method = RequestMethod.POST)
	@ResponseBody
	public List<GAVM1000U0Out00VO> gavm1000u0sel00(@RequestBody GAVM1000U0In00VO vo, HttpServletRequest request) {
		
		List<GAVM1000U0Out00VO> list = SVC.selectList00GA01N201(vo); 
		log.info(list.toString());
		return list;
	}
	
	/**
	 * 임대차량정보관리 조회
	 */
	@ApiOperation(value="임대차량정보관리 엑셀다운로드")
	@RequestMapping(value= "/gavm1000u0/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(GAVM1000U0In00VO vo, HttpServletResponse response) throws IOException {
		String fileName = "임대차량정보관리_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		List<GAVM1000U0Out00VO> list = SVC.selectList00GA01N201(vo); 
		ExcelFile<GAVM1000U0Out00VO> excelFile = new OneSheetExcelFile<>(list, GAVM1000U0Out00VO.class);
		excelFile.write2(response, downFileName);
	}
	
//	/**
//	 * 임대차량정보관리 합계
//	 */
//	@ApiOperation(value="임대차량정보관리 합계")
//	@RequestMapping(value= "/gavm1000u0/sel01", method = RequestMethod.POST)
//	@ResponseBody
//	public List<GAVM1000U0Out01VO> gavm1000u0sel01(@RequestBody GAVM1000U0In01VO vo, HttpServletRequest request) {
//
//		List<GAVM1000U0Out01VO> list = SVC.selectList01GA01N201(vo);
//		log.info(list.toString());
//		return list;
//	}
	
	/**
	 * 임대차량정보관리 조회 + 합계 
	 */
	@ApiOperation(value="임대차량정보관리 조회 + 합계")
	@RequestMapping(value= "/gavm1000u0/sel02", method = RequestMethod.POST)
	@ResponseBody
	public GAVM1000U0VO gavm1000u0sel02(@RequestBody GAVM1000U0In00VO vo, HttpServletRequest request) {
		
		GAVM1000U0VO list = SVC.selectListGA01N201(vo); 
		log.info(list.toString());
		return list;
	}
	
	/**
	 * 임대차량정보관리 = 중도해지위약금 조회
	 */
	@ApiOperation(value="중도해지위약금 조회")
	@RequestMapping(value= "/gavm1010u0/sel00", method = RequestMethod.POST)
	@ResponseBody
	public List<GAVM1010U0Out00VO> selectList02GA01N201(@RequestBody GAVM1010U0In00VO vo, HttpServletRequest request) {
		List<GAVM1010U0Out00VO> list = SVC.selectList02GA01N201(vo);
		log.info(list.toString());
		return list;
	}
	
	/**
	 * 임대차량정보관리 = 차량정보변경 조회 
	 */
	@ApiOperation(value="차량정보변경 조회")
	@RequestMapping(value= "/gavm1010u0/sel01", method = RequestMethod.POST)
	@ResponseBody
	public List<GAVM1010U0Out01VO> selectList03GA01N201(@RequestBody GAVM1010U0In01VO vo, HttpServletRequest request) {
		List<GAVM1010U0Out01VO> list = SVC.selectList03GA01N201(vo);
		log.info(list.toString());
		return list;
	}
	
	/**
	 * 임대차량정보관리 = 차량정보변경 단건등록
	 */
	@ApiOperation(value="차량정보변경 단건등록")
	@RequestMapping(value= "/gavm1010u0/ins00", method = RequestMethod.POST)
	@ResponseBody
	public int insert03GA01N201(@RequestBody GAVM1010U0In02VO vo, HttpServletRequest request) {
		return SVC.insert03GA01N201(vo);
	}
	
	/**
	 * 임대차량정보관리 = 차량정보변경 다건등록
	 */
	@ApiOperation(value="차량정보변경 다건등록")
	@RequestMapping(value= "/gavm1010u0/insList00", method = RequestMethod.POST)
	@ResponseBody
	public int insert05GA01N201(@RequestBody GAVM1010U0In05VO vo, HttpServletRequest request) {
		return SVC.insert05GA01N201(vo);
	}
	
	/**
	 * 임대차량정보관리 = 차량정보변경 삭제
	 */
	@ApiOperation(value="차량정보변경 삭제")
	@RequestMapping(value= "/gavm1010u0/del00", method = RequestMethod.POST)
	@ResponseBody
	public int update03GA01N201(@RequestBody GAVM1010U0In03VO vo, HttpServletRequest request) {
		return SVC.update03GA01N201(vo);
	}
	
	/**
	 * 임대차량정보관리 = 차량정보변경 삭제
	 */
	@ApiOperation(value="차량정보변경 다건삭제")
	@RequestMapping(value= "/gavm1010u0/delList00", method = RequestMethod.POST)
	@ResponseBody
	public int update04GA01N201(@RequestBody GAVM1010U0In04VO vo, HttpServletRequest request) {
		return SVC.update04GA01N201(vo);
	}
	
}
