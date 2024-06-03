package com.miraeasset.biz.budget.controller;


import javax.servlet.http.HttpServletRequest;

import com.miraeasset.biz.common.util.altok.AltokService;
import com.miraeasset.biz.common.util.altok.vo.AltokOut01VO;
import com.miraeasset.biz.common.util.mail.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraeasset.biz.budget.service.BGT5320Service;
import com.miraeasset.biz.budget.service.BGT5350Service;
import com.miraeasset.biz.budget.vo.BGT5320In00VO;
import com.miraeasset.biz.budget.vo.BGT5350In00VO;
import com.miraeasset.biz.common.vo.CommonResponse;

import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/main")
public class BGT5320Controller {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BGT5320Service BGT53200Service;
	@Autowired
	BGT5350Service BGT53500Service;

	@Autowired
	MailUtil mailUtil;

	@Autowired
	AltokService altokService;

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

	
	/**
	 * Budget 예산관리 5320화면
	 */
	@ApiOperation(value="예산관리_5320_예산팀점별 예실대비_조회")
	@RequestMapping(value= "/budget/53200/sel", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse budget53200Sel(@RequestBody BGT5320In00VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(BGT53200Service.selectList00AT05N129(vo));

		return response;
	}


	/**
	 * Budget 예산관리 5350화면
	 */
	@ApiOperation(value="예산관리_5350_예산집행내역_조회")
	@RequestMapping(value= "/budget/53500/sel", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse budget53500Sel(@RequestBody BGT5350In00VO vo, HttpServletRequest request) {
		
		log.info("budget53500Sel ============"+vo.toString());
		
		CommonResponse response = new CommonResponse();
		response.addData(BGT53500Service.selectList00AT05N121(vo));

		return response;
	}

	@RequestMapping(value= "/mailtest", method = RequestMethod.GET)
	@ResponseBody
	public String mailTest(@RequestParam(required = false) String sendId,
						   @RequestParam(required = false) String sendPw,
						   @RequestParam(required = false) String receiveId) {
		mailUtil.setDefaultProperties();

		if(sendId == null) {
			sendId = "jeongjun.lee@miraeassetdev.com";
		}
		if(sendPw == null) {
			sendPw = "wjdwns03#";
		}
		if(receiveId == null) {
			receiveId = sendId;
		}
		String subject = "this is subject";
		String content = "<h1>this is content</h1> <h2>this is content</h2>";

		List<String> filePathList = new ArrayList<>();
		filePathList.add("/biz/WAS/nas/common/excel/down/테스트.txt");
//		return mailUtil.sendMail(sendId, sendPw, receiveId, subject, content);

		return mailUtil.sendMailWithFiles(sendId,sendPw,sendId,subject,content,filePathList);
	}

	@RequestMapping(value= "/altokTest", method = RequestMethod.GET)
	@ResponseBody
	public AltokOut01VO altokTest(@RequestParam(required = false) String letrMsgCd,
								  @RequestParam(required = false) String altokFwdCn,
								  @RequestParam(required = false) String dpmsgObjTlno,
								  @RequestParam(required = false) String rvObjTlno) {


		return altokService.sendAltok(letrMsgCd, altokFwdCn, dpmsgObjTlno, rvObjTlno);

	}
}
