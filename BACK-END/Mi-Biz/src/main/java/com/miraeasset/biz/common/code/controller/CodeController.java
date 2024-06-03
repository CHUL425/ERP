package com.miraeasset.biz.common.code.controller;


import java.io.*;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.CommonErrorResponse;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.util.CommonUtil;
import com.miraeasset.biz.common.util.DateUtil;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraeasset.biz.common.code.service.CodeService;
import com.miraeasset.biz.common.code.vo.Code00In00VO;
import com.miraeasset.biz.common.code.vo.Code00Out00VO;
import com.miraeasset.biz.common.code.vo.Code01In00VO;
import com.miraeasset.biz.common.code.vo.Code01Out00VO;
import com.miraeasset.biz.common.code.vo.GaCode00In00VO;
import com.miraeasset.biz.common.code.vo.GaCode00Out00VO;
import com.miraeasset.biz.common.code.vo.GaCode01In00VO;
import com.miraeasset.biz.common.code.vo.GaCode01Out00VO;
import com.miraeasset.biz.common.code.vo.TeamCode00In00VO;
import com.miraeasset.biz.common.code.vo.TeamCode00Out00VO;
import com.miraeasset.biz.common.code.vo.TeamCode01In00VO;
import com.miraeasset.biz.common.code.vo.TeamCode01Out00VO;
import com.miraeasset.biz.common.code.vo.UserCode00In00VO;
import com.miraeasset.biz.common.code.vo.UserCode00Out00VO;
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.vo.CommonResponse;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/common/code")
public class CodeController extends CustomRequestException{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CodeService CodeService;


	@Value("${SEV_DOWNLOAD_PATH}")
	private String SEV_DOWNLOAD_PATH;


	/**
	 * API TEST
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse testGet(@RequestParam String text) {
		CommonResponse response = new CommonResponse();
		response.addData("HELLO Code [" + text + "] WORLD!!!");

		return response;
	}

	/**
	 * 총무공통코드 검색용 API
	 * */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse CodeSearch(@RequestParam(value = "cdKndNo", required = false) String cdKndNo) {
		CommonResponse response = new CommonResponse();


		if(cdKndNo == null || cdKndNo.equals("")) {
			GaCode00In00VO vo = new GaCode00In00VO();
			response.addData(CodeService.selectListGaCode00(vo));
		} else {
			GaCode01In00VO vo = new GaCode01In00VO();
			vo.setCdKndNo(cdKndNo);
			response.addData(CodeService.selectListGaCode01(vo));
		}

		return response;
	}


	/**
	 * 기초정보 공통코드정보조회
	 */
	@ApiOperation(value="공통코드정보조회")
	@RequestMapping(value= "/code00/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<Code00Out00VO> code00SelList(@RequestBody Code00In00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		return CodeService.selectListCode00(vo);
	}		

	/**
	 * 기초정보 공통코드값정보조회
	 */
	@ApiOperation(value="공통코드R값정보조회")
	@RequestMapping(value= "/code01/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<Code01Out00VO> code01SelList(@RequestBody Code01In00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		return CodeService.selectListCode01(vo);
	}

	
	/**
	 * 총무 공통코드정보조회
	 */
	@ApiOperation(value="총무 공통코드정보조회")
	@RequestMapping(value= "/gacode00/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<GaCode00Out00VO> gaCode00SelList(@RequestBody GaCode00In00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		return CodeService.selectListGaCode00(vo);
	}	
	
	/**
	 * 총무 공통코드값정보조회
	 */
	@ApiOperation(value="총무 공통코드R값정보조회")
	@RequestMapping(value= "/gacode01/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<GaCode01Out00VO> gaCode01SelList(@RequestBody GaCode01In00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		//response.addData(CodeService.selectListGaCode01(vo));
		return CodeService.selectListGaCode01(vo);
	}

	/**
	 * 총무 팀점코드팝업조회
	 */
	@ApiOperation(value="총무 팀점코드팝업조회")
	@RequestMapping(value= "/teamcode00/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<TeamCode00Out00VO> teamCode00SelList(@RequestBody TeamCode00In00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		//response.addData(CodeService.selectListTeamCode00(vo));

		/* 세션 획득 및 로그인 정보 전달 */
		HttpSession session = request.getSession();
		LoginOutVO loginOutVO;
		loginOutVO = (LoginOutVO)session.getAttribute("loginOutVO");

		return CodeService.selectListTeamCode00(vo, loginOutVO);
	}
	
	/**
	 * 총무 팀점코드팝업조회(검색일자) - 사용안함
	 */
	@ApiOperation(value="총무 팀점코드팝업조회(검색일자)")
	@RequestMapping(value= "/teamcode01/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<TeamCode01Out00VO> teamCode01SelList(@RequestBody TeamCode01In00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		//response.addData(CodeService.selectListTeamCode01(vo));
		return CodeService.selectListTeamCode01(vo);
	}

	/**
	 * 총무 사원코드팝업 조회
	 */
	@ApiOperation(value="총무 사원코드팝업조회")
	@RequestMapping(value= "/usercode00/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<UserCode00Out00VO> userCode00SelList(@RequestBody UserCode00In00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		//response.addData(CodeService.selectListUserCode00(vo));
		return CodeService.selectListUserCode00(vo);
	}
	
	/**
	 * 업무별 관리항목 조회
	 */
	@ApiOperation(value="업무별 관리항목 조회")
	@RequestMapping(value= "/gacode01/selectBzMtCode", method = RequestMethod.POST)
	@ResponseBody
	public List<GaCode01Out00VO> selectBzMtCode(@RequestBody GaCode01In00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		//response.addData(CodeService.selectListUserCode00(vo));
		return CodeService.selectBzMtCode(vo);
	}
	
	/**
	 * 업무별 관리항목 수정
	 */
	@ApiOperation(value="업무별 관리항목 수정")
	@RequestMapping(value= "/gacode01/updateBzMtCode", method = RequestMethod.POST)
	@ResponseBody
	public int updateBzMtCode(@RequestBody GaCode01In00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		//response.addData(CodeService.selectListUserCode00(vo));
		return CodeService.updateBzMtCode(vo);
	}


	/**
	 * 총무 공통코드정보조회
	 */
	@ApiOperation(value="회계 공통코드정보조회")
	@RequestMapping(value= "/atcode00/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<GaCode00Out00VO> atCode00SelList(@RequestBody GaCode00In00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		return CodeService.selectListAtCode00(vo);
	}

	/**
	 * 총무 공통코드값정보조회
	 */
	@ApiOperation(value="회계 공통코드R값정보조회")
	@RequestMapping(value= "/atcode01/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<GaCode01Out00VO> atCode01SelList(@RequestBody GaCode01In00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		return CodeService.selectListAtCode01(vo);
	}


	/**
	 * 엑셀 템플릿 다운로드
	 */
	@ApiOperation(value="엑셀 템플릿 다운로드")
	@RequestMapping(value= "/excel/template", method = RequestMethod.POST)
	@ResponseBody
	public void selectXlsTemplate(@RequestBody GaCode01In00VO vo, HttpServletResponse response) {
		boolean errFlag = false;
		String tmpErrMsg;

		try {
			GaCode01Out00VO outVo = CodeService.selectBzMtCode(vo).get(0);

			String strLogicNm = outVo.getCmnCdVlDefCn();
			String strPhysNm = outVo.getCmnCdVl();
			String strExt = (strLogicNm.substring(strLogicNm.lastIndexOf(".") + 1).trim()).toLowerCase();
			tmpErrMsg = "해당파일이 서버에 존재하지 않습니다. [" + "template/" + strPhysNm + "." + strExt + "]";

			strPhysNm = SEV_DOWNLOAD_PATH + "template/" + strPhysNm + "." + strExt;
			File oFile = new File(strPhysNm);
			if(!oFile.exists()) {
				errFlag = true;
				log.info(tmpErrMsg);
			}
			else {
				DateUtil.setResponseDownload(response, URLEncoder.encode(strLogicNm, "UTF-8"), strPhysNm);
			}
		} catch(Exception ex) {
			errFlag = true;
			tmpErrMsg = ex.getMessage();
			log.error(tmpErrMsg);
		}

		if(errFlag){
			// Text 방식 샘플
			// response.setContentType("text/plain; charset=utf-8");
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			// response.getWriter().write(tmpErrMsg);

			// Json 리턴
			response.setContentType("application/json; charset=utf-8");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

			CommonErrorResponse CER = new CommonErrorResponse();
			CER.setMessage(tmpErrMsg);
			CER.setCode(ErrorCode.EXCEL_FILE_READ_FAIL.getKey());
			CER.setStatus(ErrorCode.EXCEL_FILE_READ_FAIL.getStatus());
			CER.setDetail(tmpErrMsg);

			try {
				response.getWriter().write((new ObjectMapper()).writeValueAsString(CER));
			} catch(Exception ex) {
				log.error("response.getWriter.err : " + ex.getMessage());
			}
		}
	}




	/**
	 * 초기 화면 코드 문구 랜덤 출력
	 */
	@ApiOperation(value="초기 화면 코드 문구 랜덤 출력")
	@RequestMapping(value= "/code00/selRandom", method = RequestMethod.POST)
	@ResponseBody
	public GaCode01Out00VO selectGA09C302OrderRandom1Row(@RequestBody GaCode01In00VO vo) {
		return CodeService.selectGA09C302OrderRandom1Row(vo);
	}


}

