package com.miraeasset.biz.rent.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.vo.CommonResponse;
import com.miraeasset.biz.rent.service.RENT11Service;
import com.miraeasset.biz.rent.vo.RENT11In00VO;
import com.miraeasset.biz.rent.vo.RENT11In01VO;
import com.miraeasset.biz.rent.vo.RENT11In02VO;
import com.miraeasset.biz.rent.vo.RENT11In03VO;
import com.miraeasset.biz.rent.vo.RENT11Out01VO;
import com.miraeasset.biz.rent.vo.RENT12In00VO;
import com.miraeasset.biz.rent.vo.RENT12In01VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/main")
public class RENT11Controller {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "01"; // 임시저장 
	private final String CD_RQS_SCD_APV_ING  = "02"; // 승인중 
	private final String CD_RQS_SCD_APV_CMPN = "03"; // 승인완료 
	private final String CD_RQS_SCD_CMPN     = "04"; // 완료 
	private final String CD_RQS_SCD_RTRN     = "05"; // 반려/철회 
	
	@Autowired
	RENT11Service RENT11Service;

	/**
	 * 렌탈신청상세목록조회
	 */
	@ApiOperation(value="렌탈신청상세목록 조회")
	@RequestMapping(value= "/rent/rqs/selDtlList", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse selectListRentRqsDtl(@RequestBody RENT11In00VO vo, HttpServletRequest request) {
		
		CommonResponse response = new CommonResponse();
		response.addData(RENT11Service.selectListRentRqsDtl(vo));

		return response;
	}
	
	/**
	 * 렌탈신청목록조회
	 */
	@ApiOperation(value="렌탈신청목록 조회")
	@RequestMapping(value= "/rent/rqs/selList", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse selectListRentRqs(@RequestBody RENT12In00VO vo, HttpServletRequest request) {
		
		CommonResponse response = new CommonResponse();
		response.addData(RENT11Service.selectListRentRqs(vo));

		return response;
	}
	
	/**
	 * 렌탈신청목록 상태조회
	 */
	@ApiOperation(value="렌탈신청목록 상태조회")
	@RequestMapping(value= "/rent/rqs/selRqsScdInfo", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse selecRentRqsScdInfo(@RequestBody RENT12In01VO vo, HttpServletRequest request) {
		
		CommonResponse response = new CommonResponse();
		response.addData(RENT11Service.selecRentRqsScdInfo(vo));

		return response;
	}
		
	
	@ApiOperation(value="렌탈신청(임대신청) 조회(PK)")
	@RequestMapping(value= "/rent/rqs/selMstr", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse selectGA01N003(@RequestBody RENT11In01VO vo, HttpServletRequest request) {
		
		CommonResponse response = new CommonResponse();
		response.addData(RENT11Service.selectGA01N003(vo));
		return response;
	}

	@ApiOperation(value="렌탈신청상세(임대신청상세) 조회(PK)")
	@RequestMapping(value= "/rent/rqs/selDtl", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse selectGA01N004(@RequestBody RENT11In02VO vo, HttpServletRequest request) {
		
		CommonResponse response = new CommonResponse();
		response.addData(RENT11Service.selectGA01N004(vo));
		return response;
	}

	@ApiOperation(value="렌탈신청(임대신청) update(PK)")
	@RequestMapping(value= "/rent/rqs/updateMstr", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse updateGA01N003(@RequestBody RENT11In01VO vo, HttpServletRequest request) {
		
		CommonResponse response = new CommonResponse();
		response.addData(RENT11Service.updateGA01N003(vo));
		return response;
	}	

	@ApiOperation(value="렌탈신청상세(임대신청상세) update(PK)")
	@RequestMapping(value= "/rent/rqs/updateDtl", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse updateGA01N004(@RequestBody RENT11In02VO vo, HttpServletRequest request) {
		
		CommonResponse response = new CommonResponse();
		response.addData(RENT11Service.updateGA01N004(vo));
		return response;
	}	
	
	@ApiOperation(value="렌탈신청(임대신청) insert(PK)")
	@RequestMapping(value= "/rent/rqs/insertMstr", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse insertGA01N003(@RequestBody RENT11In01VO vo, HttpServletRequest request) {
		
		CommonResponse response = new CommonResponse();
		response.addData(RENT11Service.insertGA01N003(vo));
		return response;
	}	

	@ApiOperation(value="렌탈신청상세(임대신청상세) insert(PK)")
	@RequestMapping(value= "/rent/rqs/insertDtl", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse insertGA01N004(@RequestBody RENT11In02VO vo, HttpServletRequest request) {
		
		CommonResponse response = new CommonResponse();
		response.addData(RENT11Service.insertGA01N004(vo));
		return response;
	}
	
	@ApiOperation(value="렌탈신청(임대신청) 신청상태변경")
	@RequestMapping(value= "/rent/rqs/updateRqsScd", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse updateRqsScd(@RequestBody RENT11In01VO vo, HttpServletRequest request) {
		
		CommonResponse response = new CommonResponse();
		response.addData(RENT11Service.updateRqsScd(vo));
		return response;
	}
	
	@ApiOperation(value="렌탈신청 대량건 로드테스트")
	@RequestMapping(value= "/rent/rqs/loadTest", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse loadTest(@RequestBody RENT11In03VO vo, HttpServletRequest request) {
		log.info("loadTest ============"+vo);
		RENT11In02VO listVo = null;
		HashMap gridData = new HashMap();
		ArrayList gridVo = new ArrayList();
		/* 그리드 사이즈 존재시 로직출력*/
		if(vo.getGrid() != null && vo.getGrid().size() > 0) {
			log.info("get 0  ============"+vo.getGrid().get(0));
			
			for(int i=0;i<vo.getGrid().get(0).size();i++) {
				//log.info("["+i+"] ============"+vo.getGrid().get(0).get(i));
				gridData = (HashMap)vo.getGrid().get(0).get(i);
				//log.info("gridData ============"+gridData);
				//log.info("rctDlNo ============"+gridData.get("rctDlNo"));
				listVo = new RENT11In02VO();
				listVo.setRctNo      ((String)gridData.get("rctNo"));
				listVo.setRctDlNo    ((String)gridData.get("rctDlNo"));
				listVo.setEqmtTcd    ((String)gridData.get("eqmtTcd"));
				listVo.setRentCntcNo ((String)gridData.get("rentCntcNo"));
				listVo.setGdsNm      ((String)gridData.get("gdsNm"));

				log.info("listVo ============"+listVo);
				
				gridVo.add(listVo);

			}
		}
		
		CommonResponse response = new CommonResponse();
		//response.addData(RENT11Service.updateRqsScd(vo));
		
		
		return response;
	}	
	
	
	@ApiOperation(value="렌탈신청(임대신청) 삭제")
	@RequestMapping(value= "/rent/rqs/deleteRqs", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse deleteRqs(@RequestBody RENT11In01VO vo, HttpServletRequest request) {
		
		CommonResponse response = new CommonResponse();
		
		{ /* 삭제전 정합성 체크 */
			List<RENT11Out01VO> listvo = (ArrayList)RENT11Service.selectGA01N003(vo);

			log.info("listvo ============"+listvo);
			log.info("listvo.size() ============"+listvo.size());
			
			if(listvo == null || listvo.size() == 0 ) {
	            throw new CustomBadRequestException("렌탈신청 삭제대상건이 존재하지않습니다. 접수번호를 확인하세요["+vo.getRctNo()+"]", ErrorCode.BAD_REQUEST);					
			}			
			
			if(listvo != null && listvo.size() > 0) {
				RENT11Out01VO getVo = (RENT11Out01VO)listvo.get(0);
				log.info("getVo  ============"+getVo);
				
				if(getVo.getRqsScd() != null && !getVo.getRqsScd().equals(CD_RQS_SCD_TMP_STRG) ) {
		            throw new CustomBadRequestException("렌탈신청 삭제는 임시저장상태일경우만 삭제가능합니다. 신청상태를 확인하세요["+getVo.getRqsScd()+"]", ErrorCode.BAD_REQUEST);					
				}
			}
		}
		
		{ /* 렌탈신청 삭제처리 */
			int cnt = RENT11Service.deleteGA01N003(vo);
			log.info("cnt  ============"+cnt);

			if( cnt > 0 ) {
				RENT11In02VO dtlVo = new RENT11In02VO();
				dtlVo.setRctNo(vo.getRctNo());
				/* 렌탈신청상세삭제(임대신청상새) 같은접수번호 delete */
				RENT11Service.deleteGA01N004WithRctNo(dtlVo);			
			}
		}
		
		return response;
	}
	
}
