package com.miraeasset.biz.rq.dr.controller;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.miraeasset.biz.common.vo.CommonResponse;
import com.miraeasset.biz.rq.dr.vo.GA01N602VO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.ApiOperation;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;

import com.miraeasset.biz.rq.dr.service.RQDR1000U0Service;
import com.miraeasset.biz.rq.dr.vo.GA01N601VO;


/**
 * <b> 문서 신청 등록, 수정, 삭제 </b>
 * @implNote
<pre>
문서(Box) 신청 등록, 수정, 삭제
</pre>
 * @since
<pre>
2023.08.21 - 신규 작성
</pre>
 */
@Controller
@RequestMapping("/api/main/rqdr1000u0")
public class RQDR1000U0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private final RQDR1000U0Service serviceRQDR1000U0;

	@Autowired
	public RQDR1000U0Controller(RQDR1000U0Service serviceRQDR1000U0) { this.serviceRQDR1000U0 = serviceRQDR1000U0; }

	/**
	 * 문서 신청 - 등록, 수정 with Json
	 */
	@ApiOperation(value = "[문서신청] <등록,수정> with Json")
	@RequestMapping(value = "/doc/mod", method = RequestMethod.POST)
	@ResponseBody
	public GA01N601VO modifyGA01N601(@RequestBody GA01N601VO vo, HttpServletRequest request) {
		LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		vo.setRqsEpno(loginVo.getEpno());
		vo.setRqsOrzCd(loginVo.getBlngOrzCd());

		String tmp = vo.getStrArrDocBoxSqncNo();
		if(!StringUtils.isBlank(tmp)){
			vo.setArrDocBoxSqncNo(Pattern.compile("\\s*,\\s*").splitAsStream(tmp).map(Long::parseLong).collect(Collectors.toList()));
		}

		return serviceRQDR1000U0.insertGA01N601AndN604(vo, loginVo);
	}


	/**
	 * 문서 신청 - 등록, 수정 with 엑셀 업로드
	 */
	@ApiOperation(value="[문서신청] <등록,수정> with 엑셀 업로드")
	@PostMapping(value= "/doc/modExcel")
	@ResponseBody
	public GA01N601VO modifyGA01N601WithExcel(@ModelAttribute GA01N601VO vo, HttpServletRequest request) {
		LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		vo.setRqsEpno(loginVo.getEpno());
		vo.setRqsOrzCd(loginVo.getBlngOrzCd());

		return serviceRQDR1000U0.insertGA01N601AndN604(vo, loginVo);
	}


	/**
	 * [문서 신청] 바코드, 디바이스, 보관장소 Update
	 */
	@ApiOperation(value = "[문서신청] 바코드, 디바이스, 보관장소 Update - Grid Call")
	@RequestMapping(value = "/doc/updDvc", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse updateGA01N602byList(@RequestBody List<GA01N602VO> lstVo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(serviceRQDR1000U0.updateGA01N602byList(lstVo));
		return response;
	}


	/**
	 * 문서 신청 - 완료 처리 with 엑셀 업로드
	 */
	@ApiOperation(value="[문서신청] <완료> 처리 with 엑셀 업로드")
	@PostMapping(value= "/doc/lastUpdExcel")
	@ResponseBody
	public CommonResponse updateGA01N601AndN604WithExcel(@ModelAttribute GA01N601VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(serviceRQDR1000U0.updateGA01N601AndN604(vo));
		return response;
	}


	/**
	 * 문서 신청 - 완료 처리 with Json
	 */
	@ApiOperation(value = "[문서신청] <완료> 처리 with Json")
	@RequestMapping(value = "/doc/lastUpd", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse updateGA01N601AndN604WithJson(@RequestBody GA01N601VO vo, HttpServletRequest request) {

		String tmp = vo.getStrArrDocBoxSqncNo();
		if(!StringUtils.isBlank(tmp)){
			vo.setArrDocBoxSqncNo(Pattern.compile("\\s*,\\s*").splitAsStream(tmp).map(Long::parseLong).collect(Collectors.toList()));
		}

		CommonResponse response = new CommonResponse();
		response.addData(serviceRQDR1000U0.updateGA01N601AndN604(vo));
		return response;

	}


	/**
	 * [문서 신청] 반려 건 재신청 - 임시저장 으로 신규 생성
	 */
	@ApiOperation(value = "[문서신청] 반려 건 재신청 - 임시저장 으로 신규 생성")
	@RequestMapping(value = "/doc/reApply", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse updateGA01N602byList(@RequestBody GA01N601VO vo, HttpServletRequest request) {
		LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");

		CommonResponse response = new CommonResponse();
		response.addData(serviceRQDR1000U0.insertGA01N601ReApplyByRctNo(vo.getRctNo(), loginVo));
		return response;
	}


	/**
	 * 문서 신청 - 임시 저장 건 삭제
	 */
	@ApiOperation(value = "[문서신청] 임시 저장 건 삭제")
	@RequestMapping(value = "/doc/del", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse deleteGA01N601(@RequestBody GA01N601VO vo) {
		CommonResponse response = new CommonResponse();
		response.addData(serviceRQDR1000U0.deleteGA01N601(vo));
		return response;
	}



	/* *
	 * [문서 신청] 철회 처리
	 */
	/* *
	@ApiOperation(value = "[문서신청] <철회> 처리")
	@RequestMapping(value = "/doc/withDraw", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse updateGA01N602WithDrawByDocNo(@RequestBody GA01N601VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(serviceRQDR1000U0.updateGA01N602WithDrawByDocNo(vo));
		return response;
	}
	*/



}
