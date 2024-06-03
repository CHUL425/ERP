package com.miraeasset.biz.rq.cr.controller;

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

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.common.vo.CommonResponse;
import com.miraeasset.biz.rq.cr.service.RQCR1000U0Service;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U00VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U05VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U06VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0In00VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0In02VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out00VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out01VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out02VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000UVO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/rqcr")
public class RQCR1000UController extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RQCR1000U0Service svc;
	
	/**
	 * 공사신청목록 및 요약정보 조회
	 */
	@ApiOperation(value="공사신청목록 및 요약정보 조회")
	@RequestMapping(value= "/rqcr1000u0/sel00", method = RequestMethod.POST)
	@ResponseBody
	public RQCR1000U00VO selectRqsList(@RequestBody RQCR1000U0In00VO vo, HttpServletRequest request) {
		return svc.selectRqsList(vo, request);
	}
	
	/**
	 * 공사신청 요약정보 조회
	 */
	@ApiOperation(value="공사신청 요약정보 조회")
	@RequestMapping(value= "/rqcr1000u0/selRqsStat", method = RequestMethod.POST)
	@ResponseBody
	public List<RQCR1000U0Out01VO> selectRqsStat(@RequestBody RQCR1000U0In00VO vo, HttpServletRequest request) {
		return svc.selectRqsStat(vo, request);
	}
	
	/**
	 * 공사신청목록상세 조회
	 */
	@ApiOperation(value="공사신청목록상세 조회")
	@RequestMapping(value= "/rqcr1000u0/seldtl00", method = RequestMethod.POST)
	@ResponseBody
	public List<RQCR1000U0Out02VO> selectDtlList(@RequestBody RQCR1000U0In02VO vo, HttpServletRequest request) {
		return svc.selectDtlList(vo);
	}
	
	/**
	 * 공사신청목록 엑셀다운로드
	 */
	@ApiOperation(value="공사신청목록 엑셀다운로드")
	@RequestMapping(value= "/rqcr1000u0/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(RQCR1000U0In00VO vo, HttpServletResponse response) throws IOException {
		String fileName = "공사신청목록_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		List<RQCR1000U0Out00VO> list = svc.selectList(vo);
		ExcelFile<RQCR1000U0Out00VO> excelFile = new OneSheetExcelFile<>(list, RQCR1000U0Out00VO.class);
		excelFile.write2(response, downFileName);
	}
	
	/**
	 * 공사신청신청 임시저장/상신
	 */
	@ApiOperation(value="공사신청신청 임시저장/상신")
	@RequestMapping(value= "/rqcr1000u0/reqRegi", method = RequestMethod.POST)
	@ResponseBody
	public String insertRqcr(@RequestBody RQCR1000UVO vo, HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setRqsEpno(loginVo.getEpno()); // 로그인사번
			vo.setRqsOrzCd(loginVo.getBlngOrzCd()); // 로그인사번
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return svc.insertRqcr(vo);
	}
	
	/**
	 * 공사신청신청 단건 삭제
	 */
	@ApiOperation(value="공사신청신청 단건 삭제")
	@RequestMapping(value= "/rqcr1000u0/delRqcr", method = RequestMethod.POST)
	@ResponseBody
	public int deleteRqcr(@RequestBody RQCR1000U05VO vo, HttpServletRequest request) {
		return svc.deleteRqcr(vo);
	}
	
	/**
	 * 공사신청신청 다건 삭제
	 */
	@ApiOperation(value="공사신청신청 다건 삭제")
	@RequestMapping(value= "/rqcr1000u0/delRqcrList", method = RequestMethod.POST)
	@ResponseBody
	public int deleteList(@RequestBody RQCR1000U06VO vo, HttpServletRequest request) {
		return svc.deleteList(vo);
	}
	
	/**
	 * 공사신청 완료
	 */
	@ApiOperation(value="공사신청 완료")
	@RequestMapping(value= "/rqcr1000u0/rqsListCmpn", method = RequestMethod.POST)
	@ResponseBody
	public int rqsListCmpn(@RequestBody RQRR1000U0VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setRqsEpno(loginVo.getEpno()); // 로그인사번
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return svc.rqsListCmpn(vo);
	}
	
	/**
	 * [공사신청] 반려 건 재신청 - 임시저장 으로 신규 생성
	 */
	@ApiOperation(value = "[공사신청] 반려 건 재신청 - 임시저장 으로 신규 생성")
	@RequestMapping(value = "/reApply", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse reApply(@RequestBody RQCR1000U0In00VO vo, HttpServletRequest request) {
		LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");

		CommonResponse response = new CommonResponse();
		response.addData(svc.insertGA01N103ReApplyByRctNo(vo.getRctNo(), loginVo));
		return response;
	}
	
}
