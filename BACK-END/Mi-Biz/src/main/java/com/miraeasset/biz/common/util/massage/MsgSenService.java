package com.miraeasset.biz.common.util.massage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.code.service.CodeService;
import com.miraeasset.biz.common.code.vo.GaCode01In00VO;
import com.miraeasset.biz.common.code.vo.GaCode01Out00VO;
import com.miraeasset.biz.common.dao.CommonDao;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.util.CommonUtil;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.altok.AltokService;

@Service
public class MsgSenService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());


	private final String strSysNm = "Mi-support";

	private final String strMsgSvrUrl = "http://172.23.1.61:12591";

	/* [운영 반영시 삭제 대상]: 개발, 검증 테스트시 알림톡 추가 발송 */
	private final String strTestEpNos = "s1214298,3306629,3340801,3322799,3337613";  // [20240405] 3360135,삭제 요청
	/* [운영 반영시 삭제 대상]: 개발, 검증 테스트시 알림톡 추가 발송 */


	@Autowired
	CommonDao comDao;

	@Autowired
	CodeDao codeDao;

	@Autowired
	CodeService codeService;

	@Autowired
	AltokService altokService;


	@Value("${SYSTEM_NAME}")
	private String SYSTEM_NAME;


	/**
	 * 메신저 상태 체크
	 * @throws ParseException 
	 */
	public String msgState(String cmd, String userIds) throws ParseException {
		String strRtn = "";
		String xmlResp = "";

		RequestConfig conf = RequestConfig.custom()
			.setConnectTimeout(15, TimeUnit.SECONDS)
			.setConnectionRequestTimeout(15, TimeUnit.SECONDS)
			.build();

		CloseableHttpClient CHC = HttpClientBuilder.create().setDefaultRequestConfig(conf).build();

		HttpPost httpPost = new HttpPost(strMsgSvrUrl);
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		ArrayList<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("SystemName",strSysNm));
		params.add(new BasicNameValuePair("CMD", cmd));
		params.add(new BasicNameValuePair("UserIDS", userIds));

		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));
			CloseableHttpResponse resp = CHC.execute(httpPost);
			if(resp.getCode() == 200) {
				xmlResp = EntityUtils.toString(resp.getEntity());
			}
			resp.close();
		}
		catch (IOException e) {
			String strErr = e.getMessage();
			log.error("메신저 상태 체크 에러 : " + strErr);
			if(strErr.contains("timed out")) {
				throw new CustomBadRequestException("Connect timed out", ErrorCode.BAD_REQUEST);
			}
			else {
				throw new CustomBadRequestException(strErr, ErrorCode.BAD_REQUEST);
			}
		}

		try {
			CHC.close();
		} catch (IOException ignored) {}

		if(xmlResp.length() > 4) {
			try {
				JSONObject jObj = XML.toJSONObject(xmlResp);
				strRtn = jObj.toString();
			} catch (JSONException e) {
				log.error("메신저 상태 체크 에러 : " + e.getMessage());
			}
		}

		return strRtn;
	}


	/*
	* 메신저 전송 비동기 호출 - 파라미터는 sendMessage 와 동일
	* */
	public void sendMessageAsync(String cmd, String sReceiveUserId, String sTitle, String sContent, String sLink, String sSenderName,
								 String strIprtMsgCd, String strRqsOrzCd, String strRqsEpno, String strRctNo, String strMsgSndSrno)
	 {
		//try {

			if( StringUtils.isBlank(strMsgSndSrno) ) {
				strMsgSndSrno = codeService.prbzSrnoGnoCrn("MSG_SND_SRNO");
			}

			String finalStrMsgSndSrno = strMsgSndSrno;
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			LoginOutVO loginVO= (LoginOutVO)session.getAttribute("loginOutVO");

			CompletableFuture.runAsync(() -> {
				String strRtn = null;
				try {
					strRtn = sendMessage(cmd, sReceiveUserId, sTitle, sContent, "", "");
				} catch (ParseException e) {
					log.error("sendMessageAsync 실행 시 에러1");
				} catch (IOException e) {
					log.error("sendMessageAsync 실행 시 에러2");
				}

				// 로그 저장
				CommonUtil.insertGA09N502(strIprtMsgCd, sContent, strRqsOrzCd, strRqsEpno, strRctNo, strRtn, loginVO, finalStrMsgSndSrno);
			});

			/*
			CompletableFuture.supplyAsync(() -> {
					return sendMessage(cmd, sReceiveUserId, sTitle, sContent, "", "");
				}).thenAcceptAsync(s -> {
					// 로그 저장
					codeService.insertGA09N502(strIprtMsgCd, sContent, strRqsOrzCd, strRqsEpno, strRctNo, s);
				});
			*/

			/*
			CompletableFuture<String> CF = CompletableFuture.supplyAsync(() -> {
				return sendMessage(cmd, sReceiveUserId, sTitle, sContent, "", "");
			});
			CF.thenAcceptAsync(s -> {
				codeService.insertGA09N502(strIprtMsgCd, sContent, strRqsOrzCd, strRqsEpno, strRctNo, s);
			});
			*/

		//} catch (IOException ex) {
		//	log.error("sendMessageAsync 실행 시 에러 : " + ex.getMessage());
		//}
	}
	
	/**
     * 메신저 전송
     * @param sReceiveUserId
     * @param sTitle
     * @param sContent
     * @param sLink
     * @param sSenderName
     * @return
	 * @throws IOException 
	 * @throws ParseException 
     */
	public String sendMessage(String cmd, String sReceiveUserId, String sTitle, String sContent, String sLink, String sSenderName) throws ParseException, IOException {
		String strRtn = "";
		String jsonResp = "";

		if (StringUtils.isBlank(cmd)) {
			// Set - Default
			cmd = "ALERT";
		}

		RequestConfig conf = RequestConfig.custom()
							.setConnectTimeout(15, TimeUnit.SECONDS)
							.setConnectionRequestTimeout(15, TimeUnit.SECONDS)
							.build();
		
		CloseableHttpClient CHC = HttpClientBuilder.create().setDefaultRequestConfig(conf).build();
		      
		HttpPost httpPost = new HttpPost(strMsgSvrUrl);
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		ArrayList<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("CMD", cmd)); // 쪽지(MSG), 알림(ALERT)
		params.add(new BasicNameValuePair("SystemName",strSysNm));
//		params.add(new BasicNameValuePair("SystemName_Encode","UTF-8")); Default
		params.add(new BasicNameValuePair("SendName_Encode","UTF-8"));
		params.add(new BasicNameValuePair("Subject_Encode","UTF-8"));
		params.add(new BasicNameValuePair("Contents_Encode","UTF-8"));
		
        params.add(new BasicNameValuePair("S", ""));
//        params.add(new BasicNameValuePair("SendName", "TEST_SendName"));
        params.add(new BasicNameValuePair("ReceverID", sReceiveUserId));
        params.add(new BasicNameValuePair("Subject", sTitle));
        params.add(new BasicNameValuePair("Contents", sContent));
//        params.add(new BasicNameValuePair("Option", "UM=GET,WB=NEW")); Default
//        params.add(new BasicNameValuePair("submit", "TEST")); Default
		      
		try {
		     httpPost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));
		         
		     CloseableHttpResponse resp = CHC.execute(httpPost);
		
		     if(resp.getCode() == 200) {
		    	 jsonResp = EntityUtils.toString(resp.getEntity());
		            
		         // Json 에러 방지
		         jsonResp = jsonResp.replace("\"", "`");
		     }
		         
		     resp.close();
		     } catch (FileNotFoundException e) {
		     	String strErr = e.getMessage();
		     	log.error("메신저 발송 에러 : " + strErr);
		         
		        if(strErr.contains("timed out")) {
		        	strRtn = "Connect timed out";
		        }
		     } try {
		    	 CHC.close();
		     } catch (IOException ignored) {}
		      
		     //결과 값 중 result 안의 값만 리턴
		     if(jsonResp.contains("<result>")) {
		     	strRtn = jsonResp.substring(jsonResp.indexOf("<result>")+8, jsonResp.indexOf("</result>"));
		     }
		
		/*
		String vResult = "N";
		try {
			
			String strRtn = "";   String jsonResp = "";      //임원 여부 체크   Map<String, Object> map = myOfficeService.selectOfficeEmpExHandleByEmpNo(reqMap);   if(Integer.parseInt(map.get("CNT").toString()) > 0) {      //임원 케이스      strRtn = "메신저 발송 불가 대상 입니다. (사유 : 임원)";   }   else {      RequestConfig conf = RequestConfig.custom()            .setConnectTimeout(15, TimeUnit.SECONDS)            .setConnectionRequestTimeout(15, TimeUnit.SECONDS)            .build();      CloseableHttpClient CHC = HttpClientBuilder.create().setDefaultRequestConfig(conf).build();            HttpPost httpPost = new HttpPost(msgSvr);      httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");            ArrayList<NameValuePair> params = new ArrayList<>();      params.add(new BasicNameValuePair("CMD","MSG"));      params.add(new BasicNameValuePair("SystemName","Mi-Office"));      params.add(new BasicNameValuePair("SendName_Encode","UTF-8"));      params.add(new BasicNameValuePair("Subject_Encode","UTF-8"));      params.add(new BasicNameValuePair("Contents_Encode","UTF-8"));      params.add(new BasicNameValuePair("SendID", reqMap.get("SendID")));      params.add(new BasicNameValuePair("ReceverID", reqMap.get("ReceverID")));      params.add(new BasicNameValuePair("Subject", reqMap.get("Subject")));      params.add(new BasicNameValuePair("Contents", reqMap.get("Contents")));            try {         httpPost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));                  CloseableHttpResponse resp = CHC.execute(httpPost);         if(resp.getCode() == 200) {            jsonResp = EntityUtils.toString(resp.getEntity());                        //Json 에러 방지            jsonResp = jsonResp.replace("\"", "'");         }                  resp.close();      }      catch (Exception e) {         String strErr = e.getMessage();         log.error("메신저 발송 에러 : " + strErr);                  if(strErr.contains("timed out")) {            strRtn = "Connect timed out";         }      }            try {         CHC.close();      } catch (Exception ignored) {}            //결과 값 중 result 안의 값만 리턴      if(jsonResp.contains("<result>")) {         strRtn = jsonResp.substring(jsonResp.indexOf("<result>")+8, jsonResp.indexOf("</result>"));      }   }      Map<String, String> mapRtn = new HashMap<>();   mapRtn.put("result", strRtn);
			
			vResult = "Y";
			
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/

		return strRtn;
	}


	/*
	* 메신저 알림 전송 + 알림톡 전송 - 일반적인 케이스
	* */
	public String sendMsgEnrollNoti(String sReceiveUserId, String strRctNo, String strCmnCdVl, String strUserDefVl1, String strUserDefVl2) {
		String strMsg;
		String strTit;

		String strMsgSend = "";
		String strTitSend;

		Map<String,Object> map = new HashMap<>();
		map.put("rctNo", strRctNo);
		map.put("msgTyp", strCmnCdVl);
		map.put("epNo", sReceiveUserId);

		// 알림코드 기준 발송 하는 경우
		if( strCmnCdVl.equals("IPRT_MSG_CD") ) {
			map.put("iprtMsgCd", strUserDefVl1);
		}

		try {
			map = codeDao.selectMsgEnrollNotiTxt(map);

			if( strCmnCdVl.equals("IPRT_MSG_CD") ) {
				strTit = map.get("msgIprtTit").toString();
				strMsg = DateUtil.getCLOB((Clob)map.get("msgIprt"));
			}
			else {
				strMsg = DateUtil.getCLOB((Clob)map.get("msg"));
				strTit = map.get("msgTit").toString();
			}

		} catch(Exception ex) {
			log.error(ex.getMessage());
			log.error(" === 전송 메시지 로딩 실패, rctNo : " + strRctNo);
			return "";
		}

		// [20240417] 테스트용 사번 주석처리 - 검증에서 실제 전송여부 확인중
		if (SYSTEM_NAME.equals("local") || SYSTEM_NAME.equals("dev") || SYSTEM_NAME.equals("test")) {
			// 테스트 때 알림 발송 사번
			sReceiveUserId = strTestEpNos;
		}

		// 임시로 고정 - 오후에 제거 예정
		// sReceiveUserId = "s1214060,s1213750,3360135";

		try {

			// Set - 제목
			strTitSend = String.format(strTit, map.get("menuNm").toString());

			// 알림코드 기준 발송 하는 경우
			if( strCmnCdVl.equals("IPRT_MSG_CD") ) {
				switch (strUserDefVl1)
				{
					case "AL0006" :
						strMsgSend = String.format(strMsg,map.get("epNmSt").toString());
					break;
				}
			}
			else
			{
				// Set - 내용
				strMsgSend = String.format(strMsg
						, map.get("menuNm").toString()
						, map.get("epNmSt").toString()
						, map.get("enrollCategory").toString() + " -"
						, map.get("enrollType").toString()
						, map.get("rqsTtlNm").toString()
						, map.get("rctNo").toString()
				);
			}

			String strMsgSndSrno = codeService.prbzSrnoGnoCrn("MSG_SND_SRNO");

			sendMessageAsync("", sReceiveUserId, strTitSend, strMsgSend, "", "",
					map.get("iprtMsgCd").toString(), map.get("rqsOrzCd").toString(), map.get("rqsEpno").toString(), map.get("rctNo").toString(), strMsgSndSrno
			);

			if (strCmnCdVl.equals("APV_CMPN")) {
				// 신청자 에게 완료 알림 톡 발송
				altokService.sendAltokByRctNo(sReceiveUserId, strRctNo, strCmnCdVl, strUserDefVl1, strUserDefVl2);
			}

			strMsgSend = "";
		} catch(Exception ex) {
			strMsgSend = ex.getMessage();
		}

		return strMsgSend;
	}



	/*
	 * 메신저 알림 전송 + 알림톡 전송 - 다음 승인자 알림 전송
	 * */
	public String sendMsgEnrollNotiApv(String sAprvWrrptMtNo, String sAprvRnk, String sAprvDlRnk, String strDcfcPcd) {
		String strRtn = "";

		Map<String,Object> map = new HashMap<>();
		map.put("aprvWrrptMtNo", sAprvWrrptMtNo);
		map.put("aprvRnk", sAprvRnk);
		map.put("aprvDlRnk", sAprvDlRnk);
		map.put("aptmDt", DateUtil.getTodayString("yyyyMMdd"));
		map.put("iprtMsgCd", strDcfcPcd.equals("09") ? "AT0003" : "AT0002");
		map.put("dcfcPcd", strDcfcPcd);

		List<Map<String, Object>> lstMap = new ArrayList<Map<String,Object>>();
		String strAlmTit;
		String strAlmMsg;
		//String strAltTit = "";
		String strAltMsg = "";
		String strHrOsdtcd = "";
		String strOrzCd = "";
		String strEpNo = "";
		String strHndpTlno = "";
		String strMsgSend = "";
		
		boolean bProc;

		boolean bAlt = true; // 사전참조: 알림톡 발송
		boolean bMsg = true; // 사전참조: 메신저 알림 발송
		
		boolean bSndAlt = true; // 다음승인자: 알림톡 발송
		boolean bSndMsg = true; // 다음승인자: 메신저 알림 발송
		
		String strBzCd = "";  // [20240424]업무구분 추가,05 인감날인증명서의 승인요청/사전참조확인 내용 설정
		boolean bSealYn = false; 
		
		try {
			lstMap = comDao.selectApvNotiAlmAlt(map);

			for (Map<String, Object> tmpMap : lstMap) {
				
				// 업무구분 : 05 인감날인증명서 or 기타 
				strBzCd = tmpMap.get("unifRqsPcd").toString(); 
				if("05".equals(strBzCd)) {
					bSealYn = true;
				}
				
				// 메신저
				strAlmTit = tmpMap.get("almTit").toString(); 
				strAlmMsg = DateUtil.getCLOB((Clob)tmpMap.get("almMsg"));
				
				// 알림톡
				//strAltTit = tmpMap.get("altTit").toString();
				if(tmpMap.get("altMsg") != null) {
					strAltMsg = DateUtil.getCLOBnBR((Clob)tmpMap.get("altMsg"));
				} else {
					strAltMsg = "";
				}
				
				// 직위,소속조직,송신사번,휴대폰번호 
				if(tmpMap.get("hrOsdtcd") != null) {
					strHrOsdtcd = tmpMap.get("hrOsdtcd").toString();
				} else {
					strHrOsdtcd = "";
				}
					
				strOrzCd    = tmpMap.get("blngOrzCd").toString();
				strEpNo     = tmpMap.get("sndEpno").toString();
				strHndpTlno = tmpMap.get("hndpTlno").toString();
				
				String strEpNo2     = tmpMap.get("sndEpno").toString();
				
				// test 사번 
				if (SYSTEM_NAME.equals("local") || SYSTEM_NAME.equals("dev") || SYSTEM_NAME.equals("test")) {
					strEpNo = strTestEpNos;
					strEpNo2 = strTestEpNos.substring(0,8);
				}
				
				bProc = true;
				bAlt  = true; // 알림톡 발송
				bMsg  = true; // 메신저 발송
				
				// [20240423] 사전참조&인감 일림메신저/알림톡 발송여부 설정
				if( strDcfcPcd.equals("09") && bSealYn){
					GaCode01Out00VO refRjtYn = new GaCode01Out00VO();
					GaCode01In00VO refRjtVo = new GaCode01In00VO();
					refRjtVo.setCdKndNo("REF_SND_TCD"); 
					refRjtYn = codeDao.selectGA09C302OrderRandom1Row(refRjtVo);
					
					/* 사전참조 
					 * 0	알림톡 / 메신저 전체발송		전체발송
					 * 1	알림톡 발송 / 메신저 미발송		알림톡만 발송
					 * 2	알림톡 미발송 / 메신저 발송		메신저만 발송
					 * 3	알림톡 미발송 / 메신저 미발송	전체 미발송
					 * */
					String refSendDiv = "3";
					if(refRjtYn == null) {
						continue;
					} else {
						refSendDiv = refRjtYn.getCmnCdVl();
					}
					
					if("0".equals(refSendDiv)) {
						bAlt = true; // 알림톡 발송
						bMsg = true; // 메신저 알림 발송
					} else if("1".equals(refSendDiv)) {
						bAlt = true; // 알림톡 발송
						bMsg = false; // 메신저 알림 발송
					}  else if("2".equals(refSendDiv)) {
						bAlt = false; // 알림톡 발송
						bMsg = true; // 메신저 알림 발송
					}  else if("3".equals(refSendDiv)) {
						bAlt = false; // 알림톡 발송
						bMsg = false; // 메신저 알림 발송
					} 
				} else if (!strDcfcPcd.equals("09") && bSealYn) { // [20240507] 다음승인자한테 보내는 일림메신저/알림톡 발송여부 설정
					
					GaCode01Out00VO sndRjtYn = new GaCode01Out00VO();
					GaCode01In00VO sndRjtVo = new GaCode01In00VO();
					sndRjtVo.setCdKndNo("SND_TCD"); 
					sndRjtYn = codeDao.selectGA09C302OrderRandom1Row(sndRjtVo);
					
					/* 다음승인자  
					 * 0	알림톡 / 메신저 전체발송		전체발송
					 * 1	알림톡 발송 / 메신저 미발송		알림톡만 발송
					 * 2	알림톡 미발송 / 메신저 발송		메신저만 발송
					 * 3	알림톡 미발송 / 메신저 미발송	전체 미발송
					 * */
					String sendDiv = "3";
					if(sndRjtYn == null) {
						continue;
					} else {
						sendDiv = sndRjtYn.getCmnCdVl();
					}
					
					if("0".equals(sendDiv)) {
						bSndAlt = true; // 알림톡 발송
						bSndMsg = true; // 메신저 알림 발송
					} else if("1".equals(sendDiv)) {
						bSndAlt = true; // 알림톡 발송
						bSndMsg = false; // 메신저 알림 발송
					}  else if("2".equals(sendDiv)) {
						bSndAlt = false; // 알림톡 발송
						bSndMsg = true; // 메신저 알림 발송
					}  else if("3".equals(sendDiv)) {
						bSndAlt = false; // 알림톡 발송
						bSndMsg = false; // 메신저 알림 발송
					} 
				}
				
				
				if ( strOrzCd.equals("S03001") && strHrOsdtcd.equals("39") ) {
					bProc = false;
				}
				
				// 일림메신저
				if(bProc 
					&& bSealYn 
					&& ((strDcfcPcd.equals("09") && bMsg) || (!strDcfcPcd.equals("09") && bSndMsg))
					&& (tmpMap.get("almTitSeal") != null || tmpMap.get("almMsgRef") != null)) { // 인감 일림메신저 발송일때
					
					String strAlmTitSeal    = ""; 
					String strAlmMsgSeal    = "";
					String almIprtMsgCdSeal =  "";
					
					String strAlmMsgRef    = "";
					String almIprtMsgCdRef = "";
					
					
					if(tmpMap.get("almTitSeal") != null) {
						 strAlmTitSeal    = tmpMap.get("almTitSeal").toString(); 
						 strAlmMsgSeal    = DateUtil.getCLOB((Clob)tmpMap.get("almMsgSeal"));
						 almIprtMsgCdSeal =  tmpMap.get("almIprtMsgCdSeal").toString(); 
					} 
					
					if(tmpMap.get("almMsgRef") != null) {
						//String strAlmTitRef    = tmpMap.get("strAlmTitRef").toString(); // 제목은 동일하여 삭제 
						 strAlmMsgRef    = DateUtil.getCLOB((Clob)tmpMap.get("almMsgRef"));
						 almIprtMsgCdRef =  tmpMap.get("almIprtMsgCdRef").toString(); 
					} 
					
					
					String strMsgSealCd = "";
					
					if(strDcfcPcd.equals("09") && bMsg && tmpMap.get("almMsgRef") != null) { // 사전참조
						
						strMsgSealCd = almIprtMsgCdRef;
								
						// AL0006 = [Mi-support]
						// <br>법인인감날인및증명서 확인 안내
						// <br>%s 님
						// <br>▶ 신청명 : %s
						// <br>▶ 신청자 : %s %s %s
						// <br>▶ 신청일 : %s
						// <br>Mi-support 시스템 → 일반신청관리 → 법인인감날인&증명서 승인관리 → 참조대기에서 확인 가능합니다. 
						
						// Set - 알림 메시지
						strMsgSend = String.format(strAlmMsgRef
								, tmpMap.get("epNmSt").toString()   // 영도도 부문대표
								, tmpMap.get("rqsTtlNm").toString() // 신청명
								, tmpMap.get("rqsOrzNm").toString() // 신청자 팀명
								, tmpMap.get("rqsEpNm").toString()  // 신청자 명
								, tmpMap.get("rqEpNmSt").toString() // 신청자 직위
								, tmpMap.get("rqDt").toString() // 신청일
						);
						
					} else if(!strDcfcPcd.equals("09") && bSndMsg && tmpMap.get("almTitSeal") != null) { // 일반결재
						
						strMsgSealCd = almIprtMsgCdSeal;
						
						// AL0007 =[Mi-support]
						// <br>법인인감날인및증명서 확인 안내
						// <br>%s 님
						// <br>▶ 신청명 : %s
						// <br>▶ 신청자 : %s %s
						// <br>▶ 신청일 : %s
						// <br>Mi-support 시스템 → 일반신청관리 → 법인인감날인&증명서 승인관리에서 결재 확인 바랍니다. 
						
						// Set - 알림 메시지
						strMsgSend = String.format(strAlmMsgSeal
								, tmpMap.get("epNmSt").toString()   // 오조영 본부장
								, tmpMap.get("rqsTtlNm").toString() // 신청명
								, tmpMap.get("rqsEpNm").toString()  // 신청자 명
								, tmpMap.get("rqEpNmSt").toString() // 신청자 직위
								, tmpMap.get("rqDt").toString() // 신청일
						);
					}
					
					// [20240417] 메신저 알림 거부 사번일때 알림전송안함.
					List<GaCode01Out00VO> mesRjtResult = new ArrayList<GaCode01Out00VO>();
					GaCode01In00VO mesRjtVo = new GaCode01In00VO();
					mesRjtVo.setCdKndNo("MES_RJT_EPNO");
					mesRjtVo.setCmnCdVl(strEpNo);
					mesRjtResult = codeDao.selectListGaCode01(mesRjtVo);
					
					if(mesRjtResult == null || mesRjtResult.size() == 0) {
						String strMsgSndSrno = codeService.prbzSrnoGnoCrn("MSG_SND_SRNO");
						// 알림 전송
						sendMessageAsync("", strEpNo, strAlmTitSeal, strMsgSend, "", "", strMsgSealCd, strOrzCd
								, strEpNo2, tmpMap.get("rctNo").toString(), strMsgSndSrno);
					}
					
				} else if(bProc && !bSealYn) { // 인감외
					
					// Set - 알림 메시지
					strMsgSend = String.format(strAlmMsg
							, tmpMap.get("unifRqsPcdNm").toString() 
							, tmpMap.get("epNmSt").toString()       
							, tmpMap.get("unifRqsDlPcdNm").toString() + " -"  
							, tmpMap.get("unifRqsTcdNm").toString() 
							, tmpMap.get("rqsTtlNm").toString()
							, tmpMap.get("rctNo").toString()
					);
					
					String strMsgSndSrno = codeService.prbzSrnoGnoCrn("MSG_SND_SRNO");
					// 알림 전송
					sendMessageAsync("", strEpNo, String.format(strAlmTit,tmpMap.get("unifRqsPcdNm").toString()), strMsgSend,"", "",
							  tmpMap.get("almIprtMsgCd").toString(), strOrzCd
							, strEpNo2, tmpMap.get("rctNo").toString(), strMsgSndSrno);
				}
				
				
				
				// [20240417] 알림톡 거부 사번 조회결과 없을때 실행
				List<GaCode01Out00VO> altokRjtResult = new ArrayList<GaCode01Out00VO>();
				GaCode01In00VO altokRjtVo = new GaCode01In00VO();
				altokRjtVo.setCdKndNo("ALTOK_RJT_EPNO");
				altokRjtVo.setCmnCdVl(strEpNo);
				altokRjtResult = codeDao.selectListGaCode01(altokRjtVo);
				
				// 인감날인증명서 일때만 알림톡 발송
				if((altokRjtResult == null || altokRjtResult.size() == 0) 
					&& ( (strDcfcPcd.equals("09")&&bAlt) || (!strDcfcPcd.equals("09")&&bSndAlt) ) 
					&& bSealYn) {
					
					/* 알림톡 대상 직책코드 */
					List<String> altokObjrHrOsdtCd = new ArrayList<>();
	
					GaCode01In00VO gaCode01In00VO = new GaCode01In00VO();
					gaCode01In00VO.setCdKndNo("ALTOK_OBJR_HR_OSDT_CD"); // 알림톡 대상자 인사 직책 코드
					List<GaCode01Out00VO> gaCode01Out00VOList = new ArrayList<>();
					List<GaCode01Out00VO> tmpGaCode01Out00V0List = codeService.selectListGaCode01(gaCode01In00VO);
	
					if(tmpGaCode01Out00V0List != null && tmpGaCode01Out00V0List.size() > 0) {
						gaCode01Out00VOList = tmpGaCode01Out00V0List;
					}
					
					if(gaCode01Out00VOList.size() != 0) { // 코드 정의되어 있으면 코드 사용
						for(GaCode01Out00VO gaCode01Out00VO : gaCode01Out00VOList) {
							if(gaCode01Out00VO != null) {
								altokObjrHrOsdtCd.add( gaCode01Out00VO.getCmnCdVl() );
							}
						}
					} else { // 코드 정의되어 있지 않으면 하드코딩된 내용 사용. 조정원 수석 정의
						altokObjrHrOsdtCd = new ArrayList<>(Arrays.asList(
								"14", "38", "26", "35", "21", "36", "70", "50"
						));
					}
					
					// 다음 승인자 - 알림 톡 전송
					if(!StringUtils.isBlank(strHrOsdtcd)) {
						// 본부장 이상 직책 인 경우
						if( altokObjrHrOsdtCd.contains(strHrOsdtcd) ){
							// Set - 알림톡 메시지
							strMsgSend = String.format(strAltMsg
								, tmpMap.get("epNmSt").toString()
								, tmpMap.get("rqsOrzNm").toString()
								, tmpMap.get("rqsEpNm").toString()
								, tmpMap.get("unifRqsTcdNm").toString()
							);
							
							String letrMsgCd = strDcfcPcd.equals("09") ? "GA012" : "GA011"; // 운영용 알림톡
							
							// 주의: strHndpTlno 값이 null 일때 오류 발생함.
							altokService.sendAltok(letrMsgCd, strMsgSend, "15886800", strHndpTlno);
						}
					}
					
					// 사전 참조 인 경우 확인 - 사전 참조는 신청 때 파라미터 추가 해서 호출 하는 걸로 정리
					if( sAprvRnk.equals("2") ) {
						log.info(" === 사전 참조 대상 유저 조회 예정 === ");
					}
				}
			}
		} catch(Exception ex) {
			strRtn = ex.getMessage();
		}

		return strRtn;
	}
	
}
