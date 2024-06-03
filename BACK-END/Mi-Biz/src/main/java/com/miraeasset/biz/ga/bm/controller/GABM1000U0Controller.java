package com.miraeasset.biz.ga.bm.controller;

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
import com.miraeasset.biz.ga.bm.service.GABM1000U0Service;
import com.miraeasset.biz.ga.bm.vo.GABM1000U0In00VO;
import com.miraeasset.biz.ga.bm.vo.GABM1000U0Out00VO;
import com.miraeasset.biz.ga.bm.vo.GABM1000U0VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/gabm")
public class GABM1000U0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	GABM1000U0Service svc;
	
	/**
	 * 예산관리 내역조회	
	 */
	@ApiOperation(value="예산관리 내역조회")
	@RequestMapping(value= "/gabm1000u0/sel00", method = RequestMethod.POST)
	@ResponseBody
	public  List<GABM1000U0Out00VO> selectList00GA01N401(@RequestBody GABM1000U0In00VO vo, HttpServletRequest request) {
		return svc.selectList00GA01N401(vo);
	}
	
	/**
	 * 예산관리 내역 엑셀다운로드	
	 */
	@ApiOperation(value="예산관리 내역 엑셀다운로드")
	@RequestMapping(value= "/gabm1000u0/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(GABM1000U0In00VO vo, HttpServletResponse response) throws IOException {
		String fileName = "예산관리내역_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		List<GABM1000U0Out00VO> list = svc.selectList00GA01N401(vo);
		ExcelFile<GABM1000U0Out00VO> excelFile = new OneSheetExcelFile<>(list, GABM1000U0Out00VO.class);
		excelFile.write2(response, downFileName);
	}
	
	/**
	 * 편성금액 관리	
	 */
	@ApiOperation(value="편성금액 관리")
	@RequestMapping(value= "/gabm1000u0/ins00", method = RequestMethod.POST)
	@ResponseBody
	public int insert00GA01N401 (@RequestBody GABM1000U0VO vo, HttpServletRequest request) {
		
		return svc.insert00GA01N401(vo);
	}
}
