package com.miraeasset.biz.common.basic.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraeasset.biz.common.basic.service.BasicService;
import com.miraeasset.biz.common.basic.vo.AprvOrg00VO;
import com.miraeasset.biz.common.basic.vo.BasicLoginHisInVO;
import com.miraeasset.biz.common.basic.vo.BasicLoginHisOutVO;
import com.miraeasset.biz.common.basic.vo.BasicOrg00In00VO;
import com.miraeasset.biz.common.basic.vo.BasicOrg00Out00VO;
import com.miraeasset.biz.common.basic.vo.BasicOrg01In00VO;
import com.miraeasset.biz.common.basic.vo.BasicOrg01Out00VO;
import com.miraeasset.biz.common.basic.vo.BasicPost00In00VO;
import com.miraeasset.biz.common.basic.vo.BasicPost00In01VO;
import com.miraeasset.biz.common.basic.vo.BasicPost00Out00VO;
import com.miraeasset.biz.common.basic.vo.BasicPost00Out01VO;
import com.miraeasset.biz.common.basic.vo.BasicUser00In00VO;
import com.miraeasset.biz.common.basic.vo.BasicUser00Out00VO;
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.vo.CommonResponse;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/common/basic")
public class BasicController extends CustomRequestException{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BasicService BasicService;

	/**
	 * API TEST
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse testGet(@RequestParam String text) {
		CommonResponse response = new CommonResponse();
		response.addData("HELLO [" + text + "] WORLD!!!");

		return response;
	}
	
    /*
     * 결재 조직조회
     * 
     */
	@ApiOperation(value="결재조직조회")
	@RequestMapping(value= "/aprvOrg/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<AprvOrg00VO> selectAprvOrgList(@RequestBody AprvOrg00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		return BasicService.selectAprvOrgList(vo);
	}
	
	/**
	 * 기초정보 조직조회
	 */
	@ApiOperation(value="조직목록조회")
	@RequestMapping(value= "/org00/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<BasicOrg00Out00VO> org00SelList(@RequestBody BasicOrg00In00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		return BasicService.selectListOrg00(vo);
	}
	
	

	/**
	 * 기초정보 조직조회
	 */
	@ApiOperation(value="조직조회단건(PK)")
	@RequestMapping(value= "/org01/sel", method = RequestMethod.POST)
	@ResponseBody
	public List<BasicOrg01Out00VO> org01Sel(@RequestBody BasicOrg01In00VO vo, HttpServletRequest request) {
		log.info("조직조회단건");
		CommonResponse response = new CommonResponse();
		return BasicService.selectOrg01(vo);
	}	
	

	
	/**
	 * 기초정보 직원조회
	 */
	@ApiOperation(value="직원조회")
	@RequestMapping(value= "/user00/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<BasicUser00Out00VO> user00SelList(@RequestBody BasicUser00In00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		return BasicService.selectListUser00(vo);
	}	
    
	
	/**
	 * 기초정보 로그인이려조회
	 */
	@ApiOperation(value="로그인이려조회")
	@RequestMapping(value= "/login_his/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<BasicLoginHisOutVO> loginHisList(@RequestBody BasicLoginHisInVO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		return BasicService.selectListLoginHis(vo);
	}	

	
	/**
	 * 기초정보 다량주소조회
	 */
	@ApiOperation(value="다량주소조회")
	@RequestMapping(value= "/post00/selList", method = RequestMethod.POST)
	@ResponseBody
	public List<BasicPost00Out01VO> post00SelList(@RequestBody BasicPost00In00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		List<BasicPost00Out00VO> schwList = new ArrayList();
		
		schwList = BasicService.selectPreSchw(vo);
		
		BasicPost00Out00VO post00out = new BasicPost00Out00VO();

		log.info("다량주소조회 시작 schwList.size="+schwList.size());
		StringBuffer schWhere1 = new StringBuffer();
		StringBuffer schWhere2 = new StringBuffer();
		String schw = vo.getSchw();
		
		for(int i=0;i<schwList.size();i++) {
			post00out = (BasicPost00Out00VO)schwList.get(i);
			log.info("post00out["+i+"]=" + post00out);
			
			if(i==0) {
				schWhere1.append("EMDG_ADR LIKE SUBSTR('"+schw+"', 1, 1) || '%%'").append("\n");
				schWhere2.append("AND STET_NM LIKE SUBSTR('"+schw+"', 1, 1) || '%%'").append("\n");
			}else {
				schWhere1.append("AND SUBSTR(EMDG_ADR, "+(i+1)+") LIKE SUBSTR('"+schw+"', "+(i+1)+", 1) || '%%'").append("\n");
				schWhere2.append("AND SUBSTR(STET_NM, "+(i+1)+") LIKE SUBSTR('"+schw+"', "+(i+1)+", 1) || '%%'").append("\n");
			}

		}
	    
		log.info("조건절1 \n"+schWhere1+"\n");
		log.info("조건절2 \n"+schWhere2+"\n");
		
		BasicPost00In01VO vo1 = new BasicPost00In01VO();		
		vo1.setSchWhere1(new String(schWhere1));
		vo1.setSchWhere2(new String(schWhere2));
		vo1.setPageIndex(vo.getPageIndex());
		vo1.setPageSize(vo.getPageSize());

		//log.info("vo1 \n"+vo1+"\n");
		
		//response.addData();
		return BasicService.selectUnifAdr(vo1);
	}
	
}
