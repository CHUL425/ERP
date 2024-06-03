package com.miraeasset.biz.rq.am.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.miraeasset.biz.rq.am.service.RQAM2000V0Service;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0In00VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0In01VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0In02VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0Out00VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0Out01VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0Out02VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/main/rqam2000v0")
public class RQAM2000V0Controller extends CustomRequestException{
	
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
	RQAM2000V0Service RQAM2000V0Service;

	@ApiOperation(value="승인완료 내역조회")
	@RequestMapping(value= "/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<RQAM2000V0Out00VO> selList(@RequestBody RQAM2000V0In00VO inVo, HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			inVo.setAprvEpno(loginVo.getEpno()); // 로그인사번
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return RQAM2000V0Service.selList(inVo);
	}	
	
	@ApiOperation(value="승인현황 조회")
	@RequestMapping(value= "/selAprvPstt", method = RequestMethod.POST)
	@ResponseBody
	public List<RQAM2000V0Out01VO> selAprvPstt(@RequestBody RQAM2000V0In01VO inVo, HttpServletRequest request) {
		return RQAM2000V0Service.selectAprvPstt(inVo);
	}
	
	@ApiOperation(value="결재정보상세-PK")
	@RequestMapping(value= "/selectAprvDtlInfo", method = RequestMethod.POST)
	@ResponseBody
	public List<RQAM2000V0Out02VO> selectAprvDtlInfo(@RequestBody RQAM2000V0In02VO inVo, HttpServletRequest request) {
		return RQAM2000V0Service.selectAprvDtlInfo(inVo);
	}		
	
}
