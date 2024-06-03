package com.miraeasset.biz.common.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Stream;

import com.miraeasset.biz.br.er.service.BRER1000U0Service;
import com.miraeasset.biz.common.code.service.CodeService;
import com.miraeasset.biz.common.code.service.CodeServiceImpl;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.vo.GA09N503VO;
import com.miraeasset.biz.rq.dr.dao.RQDR1000U0Dao;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.miraeasset.biz.common.dao.CommonDao;
import com.miraeasset.biz.common.dao.CommonDaoImpl;
import com.miraeasset.biz.common.vo.GA09N502VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 공통 유틸
 */
@Component
public class CommonUtil {

	private static final Logger log = LoggerFactory.getLogger(CommonUtil.class);

	private static CommonDao sComDao = null;
	@Autowired
	private CommonDao comDao;
	@PostConstruct
	private void initStaticComDao(){ sComDao = this.comDao; }


	private static CodeService sCodServ = null;
	@Autowired
	private CodeService codServ;
	@PostConstruct
	private void initStaticCodServ(){ sCodServ = this.codServ; }


	/**
	 * Get getCause findFirst
	 */
	public static String getCauseFirst(Exception ex) {
		log.debug(ex.getMessage());

		return Objects.requireNonNull(Stream.iterate(ex, Throwable::getCause)
				.filter(element -> element.getCause() == null)
				.findFirst().orElse(null)).toString();
	}

	/**
	 * Get Date Time
	 */
	public static String getDateTimeFormat(String f) {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(f));
	}



	/*
	 * 메신저, 이메일, 알림톡 발송 로그 등록
	 * */
	public static void insertGA09N502(String strIprtMsgCd, String strMsgSndCn, String strOrzCd, String strEpno,
									  String strDelpCd, String strBztpTcd, String strBztpDlTcd,
									  String strTlnoEcpVl, String strEmalAdrEcpVl, String strRctNo, String strMsgSndRespCn, LoginOutVO loginVO, String strMsgSndSrno) {

		try {
			if(StringUtils.isBlank(strMsgSndSrno)) {
				strMsgSndSrno = sCodServ.prbzSrnoGnoCrn("MSG_SND_SRNO");
			}

			GA09N502VO vo = new GA09N502VO();
			vo.setSmsSndDt((new SimpleDateFormat("yyyyMMdd").format(new Date())));
			vo.setSmsSndTmd((new SimpleDateFormat("HHmmss").format(new Date())));

			vo.setMsgSndSrno(strMsgSndSrno);
			vo.setIprtMsgCd(strIprtMsgCd);
			vo.setMsgSndCn(strMsgSndCn);
			vo.setOrzCd(strOrzCd);
			vo.setEpno(strEpno);
			vo.setDelpCd(strDelpCd);
			vo.setBztpTcd(strBztpTcd);
			vo.setBztpDlTcd(strBztpDlTcd);
			vo.setTlnoEcpVl(strTlnoEcpVl);
			vo.setEmalAdrEcpVl(strEmalAdrEcpVl);
			vo.setRctNo(strRctNo);
			vo.setMsgSndRespCn(strMsgSndRespCn);
			vo.setCfmtYn("0");

			vo.setOptrId(loginVO.getOptrId());
			vo.setOprtOrzCd(loginVO.getOprtOrzCd());
			vo.setOprtChnlCd(loginVO.getOprtChnlCd());
			vo.setOprtIpAdr(loginVO.getOprtIpAdr());

			int iRtn = sComDao.insertGA09N502(vo);
		} catch(Exception ex) {
			String strErr = getCauseFirst(ex);
			log.error(strErr);
			throw new CustomBadRequestException(strErr, ErrorCode.BAD_REQUEST);
		}

	}


	public static void insertGA09N502(String strIprtMsgCd, String strMsgSndCn, String strOrzCd, String strEpno, String strRctNo, String strMsgSndRespCn, LoginOutVO loginVO, String strMsgSndSrno) {

		insertGA09N502(strIprtMsgCd, strMsgSndCn, strOrzCd, strEpno, "", "", "", "", "",
				strRctNo, strMsgSndRespCn, loginVO, strMsgSndSrno);

	}

	public static void insertGA09N503(String strIprtMsgCd, String strMsgSndCn, String strSmsSndDt, String strSmsSndTmd, String strOrzCd, String strEpno,
									  String strDelpCd, String strBztpTcd, String strBztpDlTcd,
									  String strTlnoEcpVl, String strEmalAdrEcpVl, String strRctNo, LoginOutVO loginVO) {

		try {
			GA09N503VO ga09N503VO = new GA09N503VO();

			String crnDt = DateUtil.getDate();
			String crnSrno = sComDao.selectGA09N503CrnSrno(crnDt);

			/* PK */
			ga09N503VO.setCrnDt(crnDt);
			ga09N503VO.setCrnSrno(crnSrno);

			ga09N503VO.setIprtMsgCd(strIprtMsgCd);
			ga09N503VO.setMsgSndCn(strMsgSndCn);
			ga09N503VO.setSmsSndDt(strSmsSndDt);
			ga09N503VO.setSmsSndTmd(strSmsSndTmd);
			ga09N503VO.setOrzCd(strOrzCd);
			ga09N503VO.setEpno(strEpno);
			ga09N503VO.setDelpCd(strDelpCd);
			ga09N503VO.setBztpTcd(strBztpTcd);
			ga09N503VO.setBztpDlTcd(strBztpDlTcd);
			ga09N503VO.setTlnoEcpVl(strTlnoEcpVl);
			ga09N503VO.setEmalAdrEcpVl(strEmalAdrEcpVl);
			ga09N503VO.setRctNo(strRctNo);
			ga09N503VO.setSndYn("0"); /* 발송여부 미발송(0)으로 INSERT */

			if(loginVO != null) {
				ga09N503VO.setOptrId(loginVO.getOptrId());
				ga09N503VO.setOprtOrzCd(loginVO.getOprtOrzCd());
				ga09N503VO.setOprtChnlCd(loginVO.getOprtChnlCd());
				ga09N503VO.setOprtIpAdr(loginVO.getOprtIpAdr());
			} else {
				ga09N503VO.setOptrId("BATCH");
				ga09N503VO.setOprtOrzCd("000000");
				ga09N503VO.setOprtChnlCd("000");
				ga09N503VO.setOprtIpAdr("0.0.0.0");
			}

			int iRtn = sComDao.insertGA09N503(ga09N503VO);

		} catch(Exception ex) {
			String strErr = getCauseFirst(ex);
			log.error(strErr);
			throw new CustomBadRequestException(strErr, ErrorCode.BAD_REQUEST);
		}
	}

	public static void insertGA09N503(String strIprtMsgCd, String strMsgSndCn, String strSmsSndDt, String strSmsSndTmd, String strOrzCd, String strEpno, String strRctNo, LoginOutVO loginOutVO) {
		insertGA09N503(strIprtMsgCd, strMsgSndCn, strSmsSndDt, strSmsSndTmd, strOrzCd, strEpno,"", "", "", "", "", strRctNo, loginOutVO);
	}

	public static boolean checkBzD5Yn(String basDt) {
		String result = sComDao.checkBzD5Yn(basDt);
		return result.equals("1");
	}

	public static String findHrOsdtCdNmOrHrPstCdNmByEpno(String epno) {
		return sComDao.findHrOsdtCdNmOrHrPstCdNmByEpno(epno);
	}

	public static String getEpTlno(String epno) {
		return sComDao.getEpTlno(epno);
	}
}
