package com.miraeasset.biz.ga.rm.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miraeasset.biz.common.annotation.AllAuth;
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
import com.miraeasset.biz.common.util.CryptoUtil;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.ExcelUpload;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.ga.rm.service.GARM1000V0Service;
import com.miraeasset.biz.ga.rm.vo.GARM1000ExcelVO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0In00VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0In01VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0In02VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0In03VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0In04VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out00VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out01VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out02VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out03VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out04VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out05VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out06VO;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/api/garm")
public class GARM1000V0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	GARM1000V0Service SVC;
	
	@Autowired
	ExcelUpload exl;
	/**
	 * 렌탈관리조회
	 */
	@ApiIgnore
	@ApiOperation(value="렌탈관리내역 조회")
	@RequestMapping(value= "/garm1000v0/sel00", method = RequestMethod.POST)
	@ResponseBody
	public List<GARM1000V0Out00VO> garm1000v0sel00(@RequestBody GARM1000V0In00VO vo, HttpServletRequest request) {
		
		return SVC.selectList00GA01N001(vo);
	}
	
	/**
	 * 렌탈관리내역 엑셀다운로드
	 */
	@ApiOperation(value="렌탈관리내역 엑셀다운로드")
	@RequestMapping(value= "/garm1000v0/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(GARM1000V0In00VO vo, HttpServletResponse response) throws IOException {
		String fileName = "렌탈관리내역_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		List<GARM1000V0Out00VO> list = SVC.selectList00GA01N001(vo);
		ExcelFile<GARM1000V0Out00VO> excelFile = new OneSheetExcelFile<>(list, GARM1000V0Out00VO.class);
		excelFile.write2(response, downFileName);
	}
	
	/*
	 * 엑셀 업로드
	 */
	@ApiOperation(value="렌탈관리내역 엑셀업로드")
	@RequestMapping(value= "/garm1000v0/excelup", method = RequestMethod.POST)
	public @ResponseBody int uploadExcel(MultipartHttpServletRequest request) throws Exception {
		MultipartFile excelFile = request.getFile("excelFile");
		// pk column dupChk
		String[] chkCol = { "exccYm", "mtOrzCd", "rentCntcNo"};
//		List<Map<String, Object>>list = exl.excelFileUpload(excelFile, GARM1000ExcelVO.class, chkCol);
		
		// 임시 차후 key, seq로 DB에서 가져옴
//		String field = "exccYm,eqmtTcd,eqmtTcdNm,delpCd,delpCdNm,mtOrzNm,mtOrzCd,rentCntcNo,gdsNm,mlyRentc,istDt,dutyUseDt,istPlcNm,istPlcDlNm";
//		String [] fieldName = field.split(",");
//		List<String> fieldNameList = new ArrayList<String>();
//		for (String col : fieldName) {
//			fieldNameList.add(col);
//		}
		
		/*
		 *  1.excelFile, pk col, field(default key(화면ID) = excelFile.getName(), seq = "01", strtRowIdx = 2)
		 *  2.excelFile, pk col, key(화면ID), seq, field, strtRowIdx
		 *  fieldNameList이 없을시 key, seq로 해당 col정보 조회
		 */
//		List<Map<String, Object>>list = exl.excelFileUpload(excelFile, chkCol, "", "", fieldNameList, 5);
		
		// 추가 2023.08.21 어노테이션이 추가된 VO를 읽어서 해당 컬럼정보 셋팅(파일데이터, 체크컬럼(null), 데이터시작 열 인덱스 시작점 0부터 시작, 사용할 vo)
		List<Map<String, Object>>list = exl.excelFileUpload(excelFile, chkCol, 1, GARM1000ExcelVO.class);
		return SVC.excelUpload(list);
	}
	
	/**
	 * 렌탈관리요약정보조회
	 */
	@ApiIgnore
	@ApiOperation(value="렌탈관리요약정보 조회")
	@RequestMapping(value= "/garm1000v0/sel01", method = RequestMethod.POST)
	@ResponseBody
	public List<GARM1000V0Out01VO> garm1000v0sel01(@RequestBody GARM1000V0In01VO vo, HttpServletRequest request) {
		
		List<GARM1000V0Out01VO> list = SVC.selectList01GA01N001(vo); 
		
		log.info(list.toString());
		
		return list;
	}
	
	/**
	 * 렌탈관리내역 조회(합계포함)
	 */
	@ApiOperation(value="렌탈관리내역 조회(합계포함)")
	@RequestMapping(value= "/garm1000v0/sel05", method = RequestMethod.POST)
	@ResponseBody
//	public Map<String, Object> garm1000v0sel05(@RequestBody GARM1000V0In00VO vo, HttpServletRequest request) {
	public GARM1000V0Out05VO garm1000v0sel05(@RequestBody GARM1000V0In00VO vo, HttpServletRequest request) {
		
		GARM1000V0Out05VO list = SVC.selectList05GA01N001(vo); 
		log.info(list.toString());
		return list;
	}
	
	/**
	 * 연간렌탈료조회
	 */
	@ApiIgnore
	@ApiOperation(value="연간렌탈료 조회")
	@RequestMapping(value= "/garm1010v0/sel00", method = RequestMethod.POST)
	@ResponseBody
	public List<GARM1000V0Out02VO> garm1010v0sel00(@RequestBody GARM1000V0In02VO vo, HttpServletRequest request) {
		
		return SVC.selectList02GA01N001(vo);
	}
	
	/**
	 * 연간렌탈료요약정보조회
	 */
	@ApiIgnore
	@ApiOperation(value="연간렌탈료요약정보 조회")
	@RequestMapping(value= "/garm1010v0/sel01", method = RequestMethod.POST)
	@ResponseBody
	public List<GARM1000V0Out03VO> garm1010v0sel01(@RequestBody GARM1000V0In03VO vo, HttpServletRequest request) {
		
		return SVC.selectList03GA01N001(vo);
	}
	
	/**
	 * 연간렌탈료 조회(합계포함)
	 */
	@ApiOperation(value="연간렌탈료 조회(합계포함)")
	@RequestMapping(value= "/garm1010v0/sel06", method = RequestMethod.POST)
	@ResponseBody
	public GARM1000V0Out06VO garm1010v0sel06(@RequestBody GARM1000V0In02VO vo, HttpServletRequest request) {
		
		GARM1000V0Out06VO list = SVC.selectList06GA01N001(vo);
		return list;
	}
	
	/*
	 * 연간렌탈료 엑셀다운로드
	 */
	@ApiOperation(value="연간렌탈료 엑셀다운로드")
	@RequestMapping(value= "/garm1010v0/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(GARM1000V0In02VO vo, HttpServletResponse response) throws IOException {
		String fileName = "연간렌탈료_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		List<GARM1000V0Out02VO> list = SVC.selectList02GA01N001(vo);
		ExcelFile<GARM1000V0Out02VO> excelFile = new OneSheetExcelFile<>(list, GARM1000V0Out02VO.class);
		excelFile.write2(response, downFileName);
	}
	
	/**
	 * 렌탈제품조회(신청지점의 렌탈관리 조회)
	 */
	@ApiOperation(value="렌탈제품조회(신청지점의 렌탈관리 조회)")
	@RequestMapping(value= "/garm1100v0/sel00", method = RequestMethod.POST)
	@ResponseBody
	@AllAuth /* 전체 허용 */
	public List<GARM1000V0Out04VO> garm1000v0sel04(@RequestBody GARM1000V0In04VO vo, HttpServletRequest request) {
		
		return SVC.selectList04GA01N001(vo);
	}
	
	
	
}
