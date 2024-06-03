package com.miraeasset.biz.rq.pr.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
import com.miraeasset.biz.common.util.excel.resource.DefaultDataFormatDecider;
import com.miraeasset.biz.common.vo.CommonResponse;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0In01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out03VO;
import com.miraeasset.biz.rq.pr.service.RQPR2000U0Service;
import com.miraeasset.biz.rq.pr.vo.RQPR2000U0In00VO;
import com.miraeasset.biz.rq.pr.vo.RQPR2000U0Out00VO;
import com.miraeasset.biz.rq.pr.vo.RQPR2000U0Out01VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/rqpr/rqpr2000u0")
public class RQPR2000U0Controller extends CustomRequestException {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RQPR2000U0Service svc;
	
	
	/**
	 * 구매신청내역 - 완료
	 */
	@ApiOperation(value="구매신청내역 - 완료")
	@RequestMapping(value= "/rqsListCmpn", method = RequestMethod.POST)
	@ResponseBody
	public int rqsListCmpn(@RequestBody RQPR2000U0In00VO vo, HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setRqsEpno(loginVo.getEpno()); // 로그인사번
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}	
		
		return svc.rqsListCmpn(vo);
	}
	
	/**
	 * 구매신청내역 - 업체재전송
	 */
	@ApiOperation(value="구매신청내역 - 업체재전송")
	@RequestMapping(value= "/sendMail", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse sendMail(@RequestBody RQNR2000U0In01VO vo) {
		CommonResponse response = new CommonResponse();
		MultiValueMap<String, String> mapRtn = new LinkedMultiValueMap<>();

		// TODO 임시 설정값
		//String rtn = serviceRQDR1000U0.sendDocMailWithExcel(vo.getRctNo(), "1");
		String rtn = "success";
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
	 * 구매신청내역 - 상세정보 조회 
	 */
	@ApiOperation(value="구매신청내역 - 상세정보 조회")
	@RequestMapping(value= "/selectDlInfo", method = RequestMethod.POST)
	@ResponseBody
	public RQPR2000U0Out00VO selectDlInfo(@RequestBody RQPR2000U0In00VO vo) {
		return svc.selectDlInfo(vo);
	}

	
	/**
	 * 구매신청내역 - 주문내역 엑셀다운로드
	 */
	@ApiOperation(value="구매신청내역 - 주문내역 엑셀다운로드")
	@RequestMapping(value= "/excelDtl", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcelDtl(RQNR2000U0In01VO vo, HttpServletRequest request, HttpServletResponse response) throws IOException {

		String fileName = "주문내역_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		
		List<RQPR2000U0Out01VO> list = svc.selectListGA03N103Dtl(vo.getRctNo());
		ExcelFile<RQPR2000U0Out01VO> excelFile = new OneSheetExcelFile<>(list, RQPR2000U0Out01VO.class, new DefaultDataFormatDecider());
		excelFile.write2(response, downFileName);
	}
}
