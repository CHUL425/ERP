package com.miraeasset.biz.rq.rr.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.common.util.excel.resource.DefaultDataFormatDecider;
import com.miraeasset.biz.common.vo.CommonResponse;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In00VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out00VO;
import com.miraeasset.biz.rq.rr.service.RQRR1000U0Service;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In01VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In02VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In03VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In04VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In06VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In07VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0Out00VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0Out01VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0Out03VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0Out07VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0In02VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/main/rqrr1000u0")
public class RQRR1000U0Controller extends CustomRequestException {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "00"; // 임시저장
	private final String CD_RQS_SCD_APV_ING = "05"; // 승인중
	private final String CD_RQS_SCD_APV_CMPN = "10"; // 승인완료
	private final String CD_RQS_SCD_EMAL = "15"; // 메일전송완료
	private final String CD_RQS_SCD_RTRN = "30"; // 반려
	private final String CD_RQS_SCD_WDRAL = "35"; // 철회
	private final String CD_RQS_SCD_CMPN = "99"; // 완료

	@Autowired
	RQRR1000U0Service RQRR1000U0Service;

	/**
	 * 렌탈신청목록조회
	 */
	@ApiOperation(value = "렌탈신청목록 조회")
	@RequestMapping(value = "/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<RQRR1000U0Out00VO> selectListRentRqs(@RequestBody RQRR1000U0In01VO inVo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();

		// 변수선언
		RQRR1000U0VO vo = new RQRR1000U0VO();
		RQRR1000U0Out00VO outVo = null;
		List<RQRR1000U0VO> listVo = null;
		List<RQRR1000U0Out00VO> outListVo = (List<RQRR1000U0Out00VO>) new ArrayList();

		// 전처리 : Invo -> vo 카피
		{
			ObjectCopyUtil.copyFields(inVo, vo);
		}

		// 메인로직
		{
			vo.setArrRqsScd(Arrays.asList(vo.getRqsScd().split("\\s*,\\s*")));
			listVo = RQRR1000U0Service.selectListRentRqs(vo, request);
		}

		// 후처리 : vo -> outVo 카피
		{
			// 각 필의에 대해 값을 복사합니다.
			for (RQRR1000U0VO avo : listVo) {
				outVo = new RQRR1000U0Out00VO();
				ObjectCopyUtil.copyFields(avo, outVo);
				outListVo.add(outVo);
			}
			// response.addData(outListVo);
		}

		return outListVo;
	}

	/**
	 * 렌탈신청목록 상태조회
	 */
	@ApiOperation(value = "렌탈신청목록 상태조회")
	@RequestMapping(value = "/selRqsScdInfo", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse selecRentRqsScdInfo(@RequestBody RQRR1000U0In01VO inVo, HttpServletRequest request) {

		/*
		 * CommonResponse response = new CommonResponse(); // 변수선언 RQRR1000U0VO vo = new
		 * RQRR1000U0VO(); RQRR1000U0Out01VO outVo = null; List<Map<String, Object>>
		 * listVo = null; List<RQRR1000U0Out01VO> outListVo = (List<RQRR1000U0Out01VO>)
		 * new ArrayList(); // 전처리 : Invo -> vo 카피 { ObjectCopyUtil.copyFields(inVo,
		 * vo); }
		 * 
		 * // 메인로직 { listVo = RQRR1000U0Service.selecRentRqsScdInfo(vo); }
		 * 
		 * // 후처리 : vo -> outVo 카피 { // 각 필의에 대해 값을 복사합니다. for( RQRR1000U0VO avo :
		 * listVo ) { outVo = new RQRR1000U0Out01VO(); ObjectCopyUtil.copyFields(avo,
		 * outVo); outListVo.add(outVo); } response.addData(outListVo); }
		 */

		RQRR1000U0VO vo = new RQRR1000U0VO();
		ObjectCopyUtil.copyFields(inVo, vo);

		CommonResponse response = new CommonResponse();
		response.addData(RQRR1000U0Service.selecRentRqsScdInfo(vo, request));
		return response;
	}

	@ApiOperation(value = "렌탈신청(임대신청) 삭제")
	@RequestMapping(value = "/deleteRqs", method = RequestMethod.POST)
	@ResponseBody
	public int deleteRqs(@RequestBody RQRR1000U0In03VO inVo, HttpServletRequest request) {

		// 변수선언
		RQRR1000U0VO vo = new RQRR1000U0VO();

		// 전처리 : Invo -> vo 카피
		{
			ObjectCopyUtil.copyFields(inVo, vo);
		}
//		return cnt;
		return RQRR1000U0Service.deleteGA01N003(vo);
	}

	/**
	 * 렌탈신청목록조회
	 */
	@ApiOperation(value = "렌탈신청상세목록 조회")
	@RequestMapping(value = "/selDtlList", method = RequestMethod.POST)
	@ResponseBody
	public List<RQRR1000U0Out03VO> selectListRentRqsDtl(@RequestBody RQRR1000U0In03VO inVo,
			HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		return RQRR1000U0Service.selectListRentRqsDtl(inVo);
	}

	@ApiOperation(value = "렌탈신청(임대신청) 대량 삭제")
	@RequestMapping(value = "/deleteRqsList", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse deleteRqsList(@RequestBody RQRR1000U0In04VO inVo, HttpServletRequest request) {

		CommonResponse response = new CommonResponse();

		log.info("deleteRqsList 1============" + inVo);

		// 변수선언
		RQRR1000U0VO vo = new RQRR1000U0VO();

		// 전처리 : Invo -> vo 카피
		{
			ObjectCopyUtil.copyFields(inVo, vo);
		}
		log.info("deleteRqsList 2============" + vo);
		{ /* 렌탈신청 삭제처리 */
			int cnt = RQRR1000U0Service.deleteRqsList(vo);
		}

		return response;
	}

	@ApiOperation(value = "렌탈신청 완료처리")
	@RequestMapping(value = "/rqsListCmpn", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse rqsListCmpn(@RequestBody RQRR1000U0In02VO inVo, HttpServletRequest request) {

		CommonResponse response = new CommonResponse();
		
		// 변수선언
		RQRR1000U0VO vo = new RQRR1000U0VO();

		// 전처리 : Invo -> vo 카피
		{
			ObjectCopyUtil.copyFields(inVo, vo);
		}

		{ /* 렌탈신청 완료처리 다건 */
			if( request.getSession().getAttribute("loginOutVO") != null ){
				LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
				vo.setRqsEpno(loginVo.getEpno()); // 로그인사번
			} else {
				throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
			}	
			
			int cnt = RQRR1000U0Service.rqsListCmpn(vo);
		}

		return response;
	}

	@ApiOperation(value = "렌탈신청 상신요청")
	@RequestMapping(value = "/wrrptRqm", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse wrrptRqm(@RequestBody RQRR1000U0In02VO inVo, HttpServletRequest request) {

		CommonResponse response = new CommonResponse();

		// 변수선언
		RQRR1000U0VO vo = new RQRR1000U0VO();

		// 전처리 : Invo -> vo 카피
		{
			ObjectCopyUtil.copyFields(inVo, vo);
		}

		{ /* 렌탈신청 완료처리 다건 */
			int cnt = RQRR1000U0Service.rqsListCmpn(vo);
		}

		return response;
	}

	/**
	 * 렌탈신청상세 조회(pk)
	 * 
	 */
	@ApiOperation(value = "렌탈신청상세 조회(pk)")
	@RequestMapping(value = "/selRqsDtl", method = RequestMethod.POST)
	@ResponseBody
	public List<RQRR1000U0Out07VO> selRqsDtl(@RequestBody RQRR1000U0In07VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();

		return RQRR1000U0Service.selectGA01N004(vo);
	}

	/**
	 * 렌탈신청관리 엑셀다운로드
	 */
	@ApiOperation(value = "렌탈신청관리 엑셀다운로드")
	@RequestMapping(value = "/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(RQRR1000U0In01VO inVo, HttpServletResponse response, HttpServletRequest request) throws IOException {

		String fileName = "렌탈신청관리내역_" + DateUtil.getDate() + ".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + downFileName + "\"");

		// 변수선언
		RQRR1000U0VO vo = new RQRR1000U0VO();
		RQRR1000U0Out00VO outVo = null;
		List<RQRR1000U0VO> listVo = null;
		List<RQRR1000U0Out00VO> outListVo = (List<RQRR1000U0Out00VO>) new ArrayList();

		// 전처리 : Invo -> vo 카피
		{
			ObjectCopyUtil.copyFields(inVo, vo);
		}

		// 메인로직
		{
			listVo = RQRR1000U0Service.selectListRentRqs(vo, request);
		}

		// 후처리 : vo -> outVo 카피
		{
			// 각 필의에 대해 값을 복사합니다.
			for (RQRR1000U0VO avo : listVo) {
				outVo = new RQRR1000U0Out00VO();
				ObjectCopyUtil.copyFields(avo, outVo);
				outListVo.add(outVo);
			}
			// response.addData(outListVo);
		}

		// List<RQRR1000U0Out00VO> list = RQRR1000U0Service.selectListRentRqs(vo);
		ExcelFile<RQRR1000U0Out00VO> excelFile = new OneSheetExcelFile<>(outListVo, RQRR1000U0Out00VO.class,
				new DefaultDataFormatDecider());
		excelFile.write2(response, downFileName);
	}
	
	/**
	 * [렌탈신청] 반려 건 재신청 - 임시저장 으로 신규 생성
	 */
	@ApiOperation(value = "[렌탈신청] 반려 건 재신청 - 임시저장 으로 신규 생성")
	@RequestMapping(value = "/reApply", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse reApply(@RequestBody RQRR1000U0In01VO vo, HttpServletRequest request) {
		LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");

		CommonResponse response = new CommonResponse();
		response.addData(RQRR1000U0Service.insertGA01N102ReApplyByRctNo(vo.getRctNo(), loginVo));
		return response;
	}
}
