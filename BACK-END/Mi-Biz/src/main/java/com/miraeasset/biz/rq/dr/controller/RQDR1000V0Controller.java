package com.miraeasset.biz.rq.dr.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.common.vo.CommonResponse;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0In00VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out00VO;
import com.miraeasset.biz.rq.dr.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.*;

import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.rq.dr.service.RQDR1000U0Service;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/api/main/rqdr1000v0")
public class RQDR1000V0Controller extends CustomRequestException {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private final RQDR1000U0Service serviceRQDR1000U0;

	@Autowired
	public RQDR1000V0Controller(RQDR1000U0Service serviceRQDR1000U0) { this.serviceRQDR1000U0 = serviceRQDR1000U0; }


	/**
	 * 문서 신청 - 신청 목록 조회, 상세 조회
	 */
	@ApiOperation(value="[문서신청] 신청 목록 조회, 상세 조회")
	@ApiImplicitParams(
		@ApiImplicitParam(
			name = "vo",
			dataType = "application/json",
			value = "{ \"rqsDtSt\": \"20230905\", \"rqsDtEd\": \"20231005\", \"unifRqsPcd\": \"09\", \"unifRqsDlPcd\": \"\", \"unifRqsTcd\": \"\", \"rqsOrzCd\": \"\", \"rqsEpno\": \"\", \"rqsTtlNm\": \"신청\", \"rqsScd\": \"\", \"rctNo\": \"\", \"pageNum\": 1, \"pageSize\": 50 }"
	))
	@RequestMapping(value= "/doc/list", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<GA01N601SchVO> selectGA01N601AndN101(@RequestBody GA01N601SchVO vo) {

		String tmp = vo.getRqsScd();
		if(!StringUtils.isBlank(tmp)){
			vo.setArrRqsScd(Arrays.asList(vo.getRqsScd().split("\\s*,\\s*")));
		}

		log.debug("selectGA01N601AndN101 시작");
		return serviceRQDR1000U0.selectGA01N601AndN101(vo);
	}


	/**
	 * 문서 신청 - 신청 리스트 Status 요약 목록 조회
	 */
	@ApiOperation(value="[문서신청] 신청 리스트 Status 요약 목록 조회")
	@RequestMapping(value= "/doc/listStat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectGA01N601AndN101_RqsStat(@RequestBody GA01N601SchVO vo) {
		String tmp = vo.getRqsScd();
		if(!StringUtils.isBlank(tmp)){
			vo.setArrRqsScd(Arrays.asList(vo.getRqsScd().split("\\s*,\\s*")));
		}
		return serviceRQDR1000U0.selectGA01N601AndN101_RqsStat(vo);
	}


	/**
	 * 문서 신청 - 문서(Box) 목록 조회, 상세 조회
	 */
	@ApiOperation(value="[문서신청] 문서(Box) 목록 조회, 상세 조회")
	@RequestMapping(value= "/doc/boxList", method = RequestMethod.POST)
	@ResponseBody
	public List<GA01N602SchVO> selectGA01N602Sch(@RequestBody GA01N602SchVO vo) {
		return serviceRQDR1000U0.selectGA01N602Sch(vo);
	}


	/**
	 * 특정 접수 건의 박스 정보, 수정 예정 정보 조회
	 */
	@ApiOperation(value="[문서신청] 특정 접수 건의 박스 정보, 수정 예정 정보 조회")
	@RequestMapping(value= "/doc/boxListMod", method = RequestMethod.POST)
	@ResponseBody
	public List<GA01N602SchVO> selectGA01N604SchByRctNo(@RequestBody GA01N602SchVO vo) {
		return serviceRQDR1000U0.selectGA01N604SchByRctNo(vo);
	}



	/**
	 * 문서 신청 - 문서(Box) 목록 Status 요약
	 */
	@ApiOperation(value="[문서신청] 문서(Box) 리스트 Status 요약 목록 조회")
	@RequestMapping(value= "/doc/boxListStat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectGA01N602Sch_RqsStat(@RequestBody GA01N602SchVO vo) {
		String tmp = vo.getDocBoxScd();
		if(!StringUtils.isBlank(tmp)){
			vo.setArrDocBoxScd(Arrays.asList(vo.getDocBoxScd().split("\\s*,\\s*")));
		}

		tmp = vo.getNotDocBoxScd();
		if(!StringUtils.isBlank(tmp)){
			vo.setArrNotDocBoxScd(Arrays.asList(vo.getNotDocBoxScd().split("\\s*,\\s*")));
		}

		return serviceRQDR1000U0.selectGA01N602Sch_RqsStat(vo);
	}



	@ApiOperation(value="[문서신청] 문서(Box) 리스트 메일 발송")
	@RequestMapping(value= "/doc/boxSendMail", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse selectGA01N602Sch(@RequestBody GA01N601VO vo) {
		CommonResponse response = new CommonResponse();
		MultiValueMap<String, String> mapRtn = new LinkedMultiValueMap<>();

		String rtn = serviceRQDR1000U0.sendDocMailWithExcel(vo.getRctNo(), "1");

		mapRtn.add("result", rtn);

		// 프론트 에서 사용 할 코드 값 리턴
		if( rtn.contains("success") ){
			mapRtn.add("rtnCode", "1");
		}
		else {
			mapRtn.add("rtnCode", "0");
		}
		response.addData(mapRtn);
		return response;
	}



	/**
	 * 문서(Box) 리스트 엑셀다운로드
	 */
	@ApiOperation(value="[문서신청] 문서(Box) 리스트 엑셀다운로드")
	@RequestMapping(value= "/doc/boxExcelDown", method = RequestMethod.POST)
	@ResponseBody
	public void boxExcelDown(@RequestBody GA01N602SchVO vo, HttpServletResponse response) throws IOException {
		String tmp = vo.getDocBoxScd();
		if(!StringUtils.isBlank(tmp)){
			vo.setArrDocBoxScd(Arrays.asList(vo.getDocBoxScd().split("\\s*,\\s*")));
		}

		tmp = vo.getNotDocBoxScd();
		if(!StringUtils.isBlank(tmp)){
			vo.setArrNotDocBoxScd(Arrays.asList(vo.getNotDocBoxScd().split("\\s*,\\s*")));
		}

		// 엑셀은 전체 데이터 다운로드
		vo.setPageNum(1);
		vo.setPageSize(99999999);
		vo.setSelTyp("EXCEL");

		// 엑셀 데이터 조회
		List<GA01N602SchVO> lst = serviceRQDR1000U0.selectGA01N602Sch(vo);
		List<GA01N602VO> lstN602 = new ArrayList<>();
		for (GA01N602SchVO schVo : lst) {
			GA01N602VO n602 = new GA01N602VO();
			ObjectCopyUtil.copyFields(schVo, n602);
			lstN602.add(n602);
		}

		String fileName = "문서보관목록_" + DateUtil.getDate() + ".xlsx";
		String encFileName = URLEncoder.encode(fileName, "UTF-8");
		// String encFileName = new String(fileName.getBytes(StandardCharsets.ISO_8859_1), "EUC-KR");
		// encFileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);

		ExcelFile<GA01N602VO> excelFile = new OneSheetExcelFile<>(lstN602, GA01N602VO.class);
		excelFile.write2(response, encFileName);
	}



	/**
	 * 신청 리스트 엑셀다운로드
	 */
	@ApiOperation(value="[문서신청] 신청 리스트 엑셀다운로드")
	@RequestMapping(value= "/doc/lstExcelDown", method = RequestMethod.POST)
	@ResponseBody
	public void lstExcelDown(@RequestBody GA01N601SchVO vo, HttpServletResponse response) throws IOException {
		String tmp = vo.getRqsScd();
		if(!StringUtils.isBlank(tmp)){
			vo.setArrRqsScd(Arrays.asList(vo.getRqsScd().split("\\s*,\\s*")));
		}

		// 엑셀은 전체 데이터 다운로드
		vo.setPageNum(1);
		vo.setPageSize(99999999);

		// 엑셀 데이터 조회
		List<GA01N601SchVO> lst = serviceRQDR1000U0.selectGA01N601AndN101(vo);
		List<GA01N601VO> lstN601 = new ArrayList<>();
		for (GA01N601SchVO schVo : lst) {
			GA01N601VO n601 = new GA01N601VO();
			ObjectCopyUtil.copyFields(schVo, n601);
			lstN601.add(n601);
		}

		String fileName = "문서신청목록_" + DateUtil.getDate() + ".xlsx";
		String encFileName = URLEncoder.encode(fileName, "UTF-8");
		// String encFileName = new String(fileName.getBytes(StandardCharsets.ISO_8859_1), "EUC-KR");
		// encFileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);

		ExcelFile<GA01N601VO> excelFile = new OneSheetExcelFile<>(lstN601, GA01N601VO.class);
		excelFile.write2(response, encFileName);
	}



		
}
