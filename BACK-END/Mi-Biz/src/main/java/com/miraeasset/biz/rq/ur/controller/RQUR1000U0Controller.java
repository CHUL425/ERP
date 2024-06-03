package com.miraeasset.biz.rq.ur.controller;

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
import com.miraeasset.biz.common.util.excel.resource.DefaultDataFormatDecider;
import com.miraeasset.biz.common.vo.CommonResponse;
import com.miraeasset.biz.rq.ur.service.RQUR1000U0Service;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0In00VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0In01VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0In02VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0OUT02VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0OUT12VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0Out00VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0Out01VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/main/rqur1000u0")
public class RQUR1000U0Controller extends CustomRequestException{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "00"; // 임시저장 
	private final String CD_RQS_SCD_APV_ING  = "05"; // 승인중 
	private final String CD_RQS_SCD_APV_CMPN = "10"; // 승인완료 
	private final String CD_RQS_SCD_EMAL     = "15"; // 메일전송완료
	private final String CD_RQS_SCD_RTRN     = "30"; // 반려 
	private final String CD_RQS_SCD_WDRAL    = "35"; // 철회
	private final String CD_RQS_SCD_CMPN     = "99"; // 완료
	
	@Autowired
	RQUR1000U0Service RQUR1000U0Service;

	
	@ApiOperation(value="렌탈신청(임대신청) 조회(PK)")
	@RequestMapping(value= "/selMstr", method = RequestMethod.POST)
	@ResponseBody
	public List<RQUR1000U0Out00VO> selectGA01N003(@RequestBody RQUR1000U0In02VO inVo, HttpServletRequest request) {
		
		CommonResponse response = new CommonResponse();
		
		return RQUR1000U0Service.selectGA01N003(inVo);
	}	
	
	/**
	 * 렌탈신청목록조회
	 */
	@ApiOperation(value="렌탈신청상세목록 조회")
	@RequestMapping(value= "/selDtlList", method = RequestMethod.POST)
	@ResponseBody
	public List<RQUR1000U0Out01VO> selectListRentRqsDtl(@RequestBody RQUR1000U0In00VO inVo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		return RQUR1000U0Service.selectListRentRqsDtl(inVo);
	}	

	@ApiOperation(value="렌탈신청 임시저장/상신")
	@RequestMapping(value= "/reqRegi", method = RequestMethod.POST)
	@ResponseBody
	public String reqRegi(@RequestBody RQUR1000U0In01VO inVo, HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			inVo.setRqsEpno(loginVo.getEpno()); // 로그인사번
			inVo.setRqsOrzCd(loginVo.getBlngOrzCd()); // 로그인사번
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		CommonResponse response = new CommonResponse();
		return RQUR1000U0Service.reqRegi(inVo);
	}	
		

	@ApiOperation(value="렌탈신청 상세조회")
	@RequestMapping(value= "/selInfo", method = RequestMethod.POST)
	@ResponseBody
	public RQUR1000U0OUT02VO selInfo(@RequestBody RQUR1000U0In02VO inVo, HttpServletRequest request) {
		return RQUR1000U0Service.selInfo(inVo);
	}	
	

	@ApiOperation(value="렌탈신청 제폼목록조회")
	@RequestMapping(value= "/DtlExcel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(RQUR1000U0In02VO vo, HttpServletRequest request, HttpServletResponse response) throws IOException {

		String fileName = "렌탈신청제폼목록_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		
		List<RQUR1000U0OUT12VO> list = RQUR1000U0Service.selectListRentRqsDtl(vo);
		ExcelFile<RQUR1000U0OUT12VO> excelFile = new OneSheetExcelFile<>(list, RQUR1000U0OUT12VO.class, new DefaultDataFormatDecider());
		excelFile.write2(response, downFileName);
	}	
	
}
