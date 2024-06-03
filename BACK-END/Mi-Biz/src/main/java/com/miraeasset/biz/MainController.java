package com.miraeasset.biz;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.util.*;

import com.fasoo.adk.packager.WorkPackager;
import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.code.service.CodeService;
import com.miraeasset.biz.common.code.service.CodeServiceImpl;
import com.miraeasset.biz.common.code.vo.GaSrno00In00VO;
import com.miraeasset.biz.common.util.CommonUtil;
import com.miraeasset.biz.common.util.CryptoUtil;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.altok.AltokService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.miraeasset.biz.common.util.massage.MsgSenService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.penta.scpdb.DamoManager;

import java.util.Base64;


@Controller
@RequestMapping("/api/main")
public class MainController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MsgSenService msg;

	@Autowired
	CodeService codeService;

	@Autowired
	AltokService altokService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public void home(HttpServletRequest request, HttpServletResponse response) {
		
		// Date date = new Date();
		// DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		// String formattedDate = dateFormat.format(date);
		// model.addAttribute("serverTime", formattedDate );
		// model.addAttribute("name","");
		// model.addAttribute("firstYn","");

		// msg.sendMessage("s1214060", "[Mi-SUPPORT] #{메뉴} 승인요청 안내<br>", "\"#{신청자팀점장/직책}님<br>▶ 신청구분 : #{신청구분}<br>▶ 신청유형 : #{신청유형}<br>▶ 접수번호 : #{접수번호}<br>#{▶ 신청명: 신청명}<br>Mi-SUPPORT 시스템에 접속하여 승인화면에서 처리해주세요.\"", "", "");
			
		// 알림 메시지 전송 - 완료
		// msg.sendMsgEnrollNoti("s1214060", "20230919-05-00000001", "PROC_COMP", "", "");

		try{
			// log.info("jeongjun.lee@miraeassetdev.com : {}", CryptoUtil.getEncryption("jeongjun.lee@miraeassetdev.com"));
			// log.info("010-7629-7512 : {}", CryptoUtil.getEncryption("010-7629-7512"));
		} catch(Exception ignored) {}
		
		//String url = "https://weeklytest2.miraeassetsecurities.com:50000/api/common/file/vwKey?nm=F3891FF7695A02DCE0530ADCC8268999&id=3357223";
		//url = url.replaceAll("/vwKey", "/dn");
		//url = url.replace(":50000",":8082");

		String strRtn = "home";

		// GaSrno00In00VO rctVo = new GaSrno00In00VO();
		// rctVo.setCdKndNo("CHAEBUN");
		// rctVo.setCmnCdVl("MSG_SND_SRNO");
		// rctVo.setCmnCdVl("APRV");
		// rctVo.setCmnCdVl("VHCSRNO");
		// rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
		// strRtn = rctVo.getRpbzGnoSrno();
		// strRtn = codeService.prbzSrnoGnoCrn("MSG_SND_SRNO");

		// strRtn = "jeongjun.lee@miraeassetdev.com : " + CryptoUtil.getEncryption("jeongjun.lee@miraeassetdev.com") + " / " + "010-7629-7512 : " + CryptoUtil.getEncryption("010-7629-7512");
		// strRtn = msg.msgState("FETCH_USER","s1214060,s1213750,3360135");
		log.info("호출 시작");
		// msg.sendMessageAsync("","s1213750", "비동기 전송 테스트", "\"#{신청자팀점장/직책}님<br>▶ 신청구분 : #{신청구분}<br>▶ 신청유형 : #{신청유형}<br>▶ 접수번호 : #{접수번호}<br>#{▶ 신청명: 신청명}<br>Mi-SUPPORT 시스템에 접속하여 승인화면에서 처리해주세요.\"", "", "");
		log.info("호출 종료");

		// CommonUtil.insertGA09N502("MsgCd", "MsgSndCn", "OrzCd", "Epno", "20230925-09-00000003", "MsgSndRespCn");

		// log.info(strRtn);

		String tmpTxt = "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";

		strRtn = CryptoUtil.getDecryption(tmpTxt);

		/*
		strRtn = CryptoUtil.getDecryption(tmpTxt);
		String decrypt = "";
		try{
			decrypt = new String(DamoManager.sDecrypt(tmpTxt.getBytes("MS949"), tmpTxt.getBytes("MS949").length),"euc-kr");
		} catch(Exception ext) {}

		log.info(" ============= CryptoUtil.getDecryption : ");
		log.info(decrypt);
		*/

/*
		try {
			log.info(" ============= DamoManager.sDecrypt : ============= ");
			strRtn = new String(DamoManager.sDecrypt(tmpTxt.getBytes("MS949"), tmpTxt.getBytes("MS949").length),"euc-kr");
			log.info(strRtn);
		} catch(Exception ext) {
			log.error(ext.getMessage());
		}

		try {
			log.info(" ============= DamoManager.sDecrypt_B64 : ============= ");
			strRtn = DamoManager.sDecrypt_B64(tmpTxt);
			log.info(strRtn);
		} catch(Exception ext) {
			log.error(ext.getMessage());
		}

		try {
			log.info(" ============= DamoManager.sDecrypt_B64_Sub8 : ============= ");
			strRtn = DamoManager.sDecrypt_B64_Sub8(tmpTxt);
			log.info(strRtn);
		} catch(Exception ext) {
			log.error(ext.getMessage());
		}
*/
		// Base64.Decoder dec = Base64.getDecoder();
		// byte[] tmpByt = dec.decode(tmpTxt);

/*
		//byte[] tmpByt = strRtn.getBytes();
		log.info(" ============= new String : UTF_8 ");
		log.info(new String(tmpByt, StandardCharsets.UTF_8));

		log.info(" ============= new String : ISO_8859_1 ");
		log.info(new String(tmpByt, StandardCharsets.ISO_8859_1));

		log.info(" ============= new String : UTF_16 ");
		log.info(new String(tmpByt, StandardCharsets.UTF_16));

		log.info(" ============= new String : EUC-KR ");
		log.info(new String(tmpByt, Charset.forName("EUC-KR")));

		log.info(" ============= new String : MS949 ");
		log.info(new String(tmpByt, Charset.forName("MS949")));

		log.info(" ============= new String : KSC5601 ");
		log.info(new String(tmpByt, Charset.forName("KSC5601")));
*/

		byte[] tmpByt = strRtn.getBytes();

		log.info(" ============= new String : MS949 ");
		log.info(new String(tmpByt, Charset.forName("MS949")));


		// log.info(" ============= getBytes : ");
		// log.info("{}", tmpByt);


		/*
		strRtn = CryptoUtil.getDecryption(tmpTxt);

		log.info(" getDecryption ============================================== ");

		log.info("getDecryption : ");
		log.info(strRtn);

		log.info(" sDecrypt_B64 ============================================== ");

		log.info("sDecrypt_B64 : ");
		log.info(DamoManager.sDecrypt_B64(strRtn));

		log.info(" sDecrypt_B64_Sub8 ============================================== ");

		log.info("sDecrypt_B64_Sub8 : ");
		log.info(DamoManager.sDecrypt_B64_Sub8(strRtn));
		*/


		response.setContentType("application/octer-stream");
		response.setHeader("Content-Transfer-Encoding", "binary;");
		response.setCharacterEncoding("UTF-8");

		try {
			String downFileName = URLEncoder.encode("aaaa.png", "UTF-8");
			response.setHeader("Content-Disposition", "attachment; fileName=\"" +downFileName+ "\"");

			InputStream in = new ByteArrayInputStream(tmpByt);
			ServletOutputStream sos = response.getOutputStream();
			int ncount = 0;
			byte[] bytes = new byte[4096];
			while ((ncount = in.read(bytes)) != -1 ) {
				sos.write(bytes, 0, ncount);
			}
			if(sos != null) sos.close();
			if(in  != null) in.close();
		} catch (Exception ex) {
		}


		// return String.format("{ \"test\" : \"%s\" }",strRtn);
	}
}