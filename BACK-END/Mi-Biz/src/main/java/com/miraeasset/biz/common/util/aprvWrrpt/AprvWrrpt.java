package com.miraeasset.biz.common.util.aprvWrrpt;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.basic.dao.BasicDao;
import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.code.vo.GaCode01In00VO;
import com.miraeasset.biz.common.code.vo.GaCode01Out00VO;
import com.miraeasset.biz.common.code.vo.GaSrno00In00VO;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.dao.LoginDao;
import com.miraeasset.biz.common.meta.vo.AprvWrrptInVO;
import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02InVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02OutVO;
import com.miraeasset.biz.common.meta.vo.GA09N606Pu01InVO;
import com.miraeasset.biz.common.meta.vo.GA09N606VO;
import com.miraeasset.biz.common.meta.vo.GA09N607InVO;
import com.miraeasset.biz.common.meta.vo.GA09N607Pu01InVO;
import com.miraeasset.biz.common.meta.vo.GA09N607VO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.massage.MsgSenService;
import com.miraeasset.biz.ga.sr.dao.GASR1000U0Dao;
import com.miraeasset.biz.ga.sr.service.GASR1000U0Service;
import com.miraeasset.biz.rq.am.dao.RQAM1000U0Dao;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In01VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In02VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In11VO;
import com.miraeasset.biz.rq.dr.service.RQDR1000U0Service;
import com.miraeasset.biz.rq.rr.dao.RQRR1000U0Dao;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;
import com.miraeasset.biz.rq.sr.service.RQSR1000U0Service;

@Service
@Transactional
public class AprvWrrpt {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/* APRV_SCD 코드값 정의 */
	private final String CD_APRV_SCD_RCT      = "01"; // 접수 
	private final String CD_APRV_SCD_APRVING  = "02"; // 결재중 
	private final String CD_APRV_SCD_RTRN     = "03"; // 반려
	private final String CD_APRV_SCD_APV      = "04"; // 승인완료 

	/* APRV_RTRN_TCD  코드값 정의 */
	private final String CD_APRV_RTRN_TCD_APV  = "1"; // 승인 
	private final String CD_APRV_RTRN_TCD_RTRN = "2"; // 반려 
	private final String CD_APRV_RTRN_TCD_REF  = "3"; // 참조 
	
	/* DCFC_PCD  코드값 정의 */
	private final String CD_DCFC_PCD_WRRPT = "00"; // 상신
	private final String CD_DCFC_PCD_APRV  = "01"; // 결재
	private final String CD_DCFC_PCD_CP    = "02"; // 협조
	private final String CD_DCFC_PCD_REF   = "09"; // 참조 
	
	/* APRV_WRRPT_TCD   코드값 정의 */
	private final String APRV_WRRPT_TCD_DRWR  = "0"; // 작성자 	
	private final String APRV_WRRPT_TCD_DCFC  = "1"; // 결제자 	
	private final String APRV_WRRPT_TCD_APVR  = "4"; // 승인자
	
	/* RQS_CD 코드값 정의 2023.08.21 */
	private final String CD_RQS_SCD_TMP_STRG = "00"; // 임시저장 
	private final String CD_RQS_SCD_APV_ING  = "05"; // 승인중 
	private final String CD_RQS_SCD_APV_CMPN = "10"; // 승인완료 
	private final String CD_RQS_SCD_EMAL     = "15"; // 메일전송완료
	private final String CD_RQS_SCD_RTRN     = "30"; // 반려 
	private final String CD_RQS_SCD_WDRAL    = "35"; // 철회
	private final String CD_RQS_SCD_PRC_CMPN = "40"; // 처리완료
	private final String CD_RQS_SCD_CMPN     = "99"; // 완료
	
	private final String APRV_SCD_01 = "01"; //승인대기
	private final String APRV_SCD_02 = "02"; //결재중
	private final String APRV_SCD_03 = "03"; //반려
	private final String APRV_SCD_04 = "04"; //승인완료
	
	private final String APRV_PCD_01 = "01"; //공사신청
	private final String APRV_PCD_02 = "02"; //구매신청
	private final String APRV_PCD_03 = "03"; //렌탈신청
	private final String APRV_PCD_04 = "04"; //명함신청
	private final String APRV_PCD_05 = "05"; //인감신청
	private final String APRV_PCD_06 = "06"; //인장신청
	private final String APRV_PCD_09 = "09"; //문서신청
	private final String APRV_PCD_91 = "91"; //사용자그룹
	private final String APRV_PCD_92 = "91"; //화면권한
	
	@Autowired
	LoginDao login;
	
	@Autowired
	RQRR1000U0Dao RQRR1000U0Dao;
	
	@Autowired
	CodeDao CodeDao;
	
	@Autowired
	BasicDao BasicDao;
	
	@Autowired
	RQAM1000U0Dao rqamDao;
	
	@Autowired
	MsgSenService msg;

	@Autowired
	RQDR1000U0Service serviceRQDR1000U0;
	
	@Autowired
	GASR1000U0Service serviceGASR1000U0;
	
	@Autowired
	GASR1000U0Dao GASR1000U0Dao;

	@Autowired
	RQSR1000U0Service serviceRQSR1000U0;
	
	
	/*
	 * 결재상신처리 
	 * 승인
     * 반려
	 * 철회 
	 * */
	
	// 포탈관리, 인장조제 전용 상신 처리 2023.09.12
	public String aprvWrrpt(String newRctNo, String rqsEpno, String rqsOrzCd, String rqsPcd, String psitMenuId) {
		
		String bzChprYn   = "N" ; // 업무담당자
		String bzAuthYn   = "N" ; // 업무담당자
		String rqsScd = CD_RQS_SCD_TMP_STRG;
		String baseAprvl  = ""  ; // 디폴트결재선관리번호
		String horbTcd    = ""  ; // 본지점구분
		String newApprtNo = "";
		String rqsDt = DateUtil.getTodayString("yyyyMMdd");
		
		try {
			// 유저 정보 조회 및 화면권한 체크
			GA09N602Vf02InVO GA09N602Vf02InVO = new GA09N602Vf02InVO();
			GA09N602Vf02OutVO GA09N602Vf02OutVO = null;
			
			GA09N602Vf02InVO.setEpno(rqsEpno);
			GA09N602Vf02InVO.setOrzCd(rqsOrzCd);
			GA09N602Vf02InVO.setScrnNo(psitMenuId);
			List<GA09N602Vf02OutVO> userList = rqamDao.selectAprvWrrptUserInfoList(GA09N602Vf02InVO);
			bzChprYn = userList.get(0).getBzChprYn();
			bzAuthYn = userList.get(0).getBzAuthYn();
			horbTcd  = userList.get(0).getHobrTcd();
			 
			GA09N602Vf02OutVO = new GA09N602Vf02OutVO();
				
			// 결재선관리번호 필터링
			GA09N602Vf02OutVO.setHobrTcd(horbTcd); 			// 본지점구분
			GA09N602Vf02OutVO.setUnifRqsPcd(rqsPcd);	// 통합신청유형코드
			GA09N602Vf02OutVO.setBzChprYn(bzChprYn);	// 업무담당자여부
			GA09N602Vf02OutVO.setBzAuthYn(bzAuthYn);	// 화면권한여부
			GA09N602Vf02OutVO.setOrzCd(rqsOrzCd);		// 조직
			GA09N602Vf02OutVO.setAprvlTpVl2("CUS_CODE1");
			GA09N602Vf02OutVO = rqamDao.baseAprvLine(GA09N602Vf02OutVO);

			// 결재선관리번호 
			baseAprvl = GA09N602Vf02OutVO.getAprvlMtNo();
			if (StringUtils.isBlank(baseAprvl)) {
				throw new Exception("결재선이 존재하지않습니다. IT운영담당자에게 문의바랍니다.");
			}
			
			/* 2023.08.22 신규채번룰 */
			GaSrno00In00VO rctVo = new GaSrno00In00VO();
			rctVo.setCdKndNo("CHAEBUN");
			rctVo.setCmnCdVl("APRV");
			rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
			newApprtNo = rctVo.getRpbzGnoSrno();
			if (StringUtils.isBlank(newApprtNo)) {
				throw new Exception("결재상신관리번호. 채번오류.");
			} else {
				GA09N607VO GA09N607VO = new GA09N607VO();
				GA09N607VO.setAprvWrrptMtNo(newApprtNo);
				GA09N607VO.setAprvWrrptOrzCd(rqsOrzCd);
				GA09N607VO.setAprvScd(APRV_SCD_01);
				GA09N607VO.setWrrptEpno(rqsEpno);
				GA09N607VO.setWrrptDt(rqsDt);
				GA09N607VO.setAprvPcd(rqsPcd);
				GA09N607VO.setAprvUnitGrpCd(rqsOrzCd);
				GA09N607VO.setPsitMenuId(psitMenuId);
				GA09N607VO.setAprvMtNo(baseAprvl);
				GA09N607VO.setRqsScd(CD_RQS_SCD_APV_ING);
				GA09N607VO.setRctNo(newRctNo);
				rqamDao.insertAprvLine(GA09N607VO);

				if( GA09N607VO.getRqsScd().equals(CD_RQS_SCD_APV_ING) ) {
					// [다음 승인자 알림] 결재 승인 요청 시 알림 발송
					sendMsgEnrollApv(GA09N607VO.getAprvWrrptMtNo(), "2", "2", "");
				}
			}
		} catch (Exception e) {
			{
				GA01N101VO failVo = new GA01N101VO();
				failVo.setRctNo(newRctNo);
				failVo.setRqsScd(rqsScd);
				rqamDao.updateAprvRqsScd(failVo);
			}
			log.error("aprvWrrpt Exception = {}", e.getMessage());
		}
		return newApprtNo;
	}
	
	// 결재 상신(접수번호, 결재선)
	public String aprvWrrpt(GA09N607InVO vo) {

		int mCnt  = 0; // 606 insert
		int dCnt  = 0; // 607 insert
		int cnt   = 0; // 101 update
		
		String newApprtNo = "";
		String newRctNo   = vo.getRctNo();
		String rqsOrzCd   = "";
		String rqsEpno    = "";
		String unifRqsPcd = "";
		//String unifRqsPcdNm = "";
		String aprvWrrptMtNo = ""; 
		
//		String aprvRtrnTcd = "";
//		String aprvUnitDlVl = ""; 
		
		/* 메시저 알림 */
//		String unifRqsDlPcdNm = ""; // 메신저 알림 신청구분
//		String unifRqsTcdNm = "";   // 메신저 알림 신청유형 
//		String rqsTtlNm = "";       // 메신저 알림 신청명
		
		String rqsDt = DateUtil.getTodayString("yyyyMMdd");
		String rqsScd = "";
		
		String psitMenuId = "";
		
		try {
			/* 결재 정보 리스트 */
			List<AprvWrrptInVO> aprvlList = vo.getAprvl(); // 결재선 정보
			
			if (aprvlList == null || aprvlList.size() == 0) {
				throw new Exception("결제선리스트 정보가 존재하지 않습니다. 결재선정보를 확인해주세요.");
			}
			
			AprvWrrptInVO aprvlVO = null;
			
			// 임대신청 정보 조회
			GA01N101VO selVo = new GA01N101VO();
			selVo.setRctNo(newRctNo);
			selVo = rqamDao.selectGA01N101Pk(selVo);
			
			if (StringUtils.isBlank(selVo.getRctNo())) {
				throw new Exception("임대신청 정보가 존재하지 않습니다 접수번호를 확인해주세요. 접수번호 : ["+newRctNo+"]");
			} else {
				rqsOrzCd   = selVo.getRqsOrzCd();
				rqsEpno    = selVo.getRqsEpno();
				unifRqsPcd = selVo.getUnifRqsPcd();
				rqsScd     = selVo.getRqsScd();
				
				aprvWrrptMtNo = selVo.getAprvWrrptMtNo(); 
				
				/* 메세지 알림 용 */
//				unifRqsDlPcdNm = selVo.getUnifRqsDlPcdNm();
//				unifRqsTcdNm   = selVo.getUnifRqsTcdNm();
//				rqsTtlNm	   = selVo.getRqsTtlNm();
				
				// 해당 업무 화면 조회
				GaCode01In00VO rqsPcdVo = new GaCode01In00VO();
				rqsPcdVo.setCdKndNo("PSIT_MENU_ID_TCD");
				rqsPcdVo.setCmnCdVl(unifRqsPcd);
				List<GaCode01Out00VO> rqsPcdList = CodeDao.selectBzMtCode(rqsPcdVo); 
				psitMenuId = rqsPcdList.get(0).getCmnCdVlDefCn();
			}
			
			// 결재정보
			GA09N606VO GA09N606VO = new GA09N606VO();
			GA09N607VO GA09N607VO = new GA09N607VO();
			GA09N607VO aprvlInVO = new GA09N607VO();
			//GA09N607VO aprvlOutVO = new GA09N607VO();
			log.info("aprvWrrptMtNo = {}", aprvWrrptMtNo);
			// 결재상신관리번호 체크
			if (StringUtils.isBlank(aprvWrrptMtNo)) {
				/* 2023.08.22 신규채번룰 */
				GaSrno00In00VO rctVo = new GaSrno00In00VO();
				rctVo.setCdKndNo("CHAEBUN");
				rctVo.setCmnCdVl("APRV");
				rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
				newApprtNo = rctVo.getRpbzGnoSrno();
			} else {
				newApprtNo = aprvWrrptMtNo;
				// 기존 결재선 삭제
				rqamDao.deleteAprvl(newApprtNo);
			}
			
			// 상신 결재정보 셋팅
			{
				GA09N606VO.setAprvWrrptMtNo(newApprtNo); /* 결재상신관리번호 */
				GA09N606VO.setAprvWrrptOrzCd(rqsOrzCd);  /* 결재상신조직코드 */
				GA09N606VO.setAprvScd(CD_APRV_SCD_RCT);  /* 결재상태코드 */
				GA09N606VO.setWrrptEpno(rqsEpno);        /* 상신사원번호 */
				GA09N606VO.setWrrptDt(rqsDt);            /* 상신일자 */
				GA09N606VO.setAprvPcd(unifRqsPcd);		 /* 결재유형코드 */
				mCnt = rqamDao.insertGA09N606(GA09N606VO);
				log.info("insertGA09N606 = {}", mCnt);
			}
			if (mCnt > 0) {
				// 결재상세정보 셋팅
				{
					// 결재 및 참조
//					String nextAprvOrzCd = "";
//					String nextAprvHrOsdtCd = "";
					
					for( int i = 0; i < aprvlList.size(); i++) {
						aprvlVO = aprvlList.get(i);
						
//						if (aprvlVO.getAprvRtrnTcd().equals("null") || aprvlVO.getAprvRtrnTcd().equals("undefined")) {
//							aprvlVO.setAprvRtrnTcd(aprvRtrnTcd);
//						}
//						
//						if (aprvlVO.getAprvUnitDlVl().equals("null") || aprvlVO.getAprvUnitDlVl().equals("undefined")) {
//							aprvlVO.setAprvUnitDlVl(aprvUnitDlVl);
//						}
						
						ObjectCopyUtil.copyFields(aprvlVO, aprvlInVO);
						aprvlInVO.setAprvWrrptMtNo(newApprtNo);
						aprvlInVO.setAprvDlRnk(aprvlVO.getAprvRnk());
						// 화면 담당자 구분일 경우 화면ID 셋팅 - 현재 필요없을시 제외예정  
						if (aprvlVO.getAprvUnitTcd().equals("10")) {
							// 업무담당자가 총무팀이 아닐수도 있음.. (정,부 조직코드 맞춰야됨)
							aprvlInVO.setAprvUnitGrpCd("");
							aprvlInVO.setAprvOrzCd("");
							
							aprvlInVO.setAprvUnitDlVl(psitMenuId);
						//} else if (aprvlVO.getAprvUnitTcd().equals("06")) {
						//	if (aprvlVO.getAprvWrrptTcd().equals("1")) {
//								nextAprvOrzCd = aprvlInVO.getAprvOrzCd();
//								nextAprvHrOsdtCd = aprvlInVO.getAprvUnitHrOsdtCd();
						//	}
						} else if (aprvlVO.getAprvUnitTcd().equals("09")) { /* 참조 */
							aprvlInVO.setAprvWrrptTcd("3");
						}
						
						dCnt = rqamDao.insertGA09N607(aprvlInVO);
						log.info("insertGA09N607(결제) = {}", dCnt);
						
						if (dCnt > 0) {
							// 참조일경우
							if (aprvlInVO != null && aprvlInVO.getDcfcPcd().equals("09")) {
//								msg.sendMsgEnrollNoti("", newRctNo, "PROC_COMP", "", "");
							}
						} else {
							throw new Exception("GA09N607 등록 오류");	
						}
					}
					
					if (dCnt > 0) {
						GA09N607VO.setAprvWrrptMtNo(newApprtNo);
						GA09N607VO.setAprvWrrptOrzCd(rqsOrzCd);
						GA09N607VO.setRqsScd(rqsScd);
						GA09N607VO.setRctNo(newRctNo);
						
						cnt = rqamDao.updateAprvWrrptStat(GA09N607VO);
						
						/* 2023.10.25 임시 주석 처리(다음결재대상자 발송처리 미개발) */
						if (cnt > 0) {

							if( GA09N607VO.getRqsScd().equals(CD_RQS_SCD_APV_ING) ) {
								// [다음 승인자 알림] 결재 승인 요청 시 알림 발송
								sendMsgEnrollApv(GA09N607VO.getAprvWrrptMtNo(), "2", "2", "");

								sendMsgEnrollApv(GA09N607VO.getAprvWrrptMtNo(), "2", "2", "09");
							}

						} else {
							throw new Exception("GA01N101 수정 오류");	
						}
					} else {
						throw new Exception("GA09N607 결재선 생성 오류");
					}
				}
			} else {
				throw new Exception("GA09N606 결재선 생성 오류");
			}
		} catch (Exception e) {
			/* 결재 상신 실패시 임시저장건으로 변경 */
			{
				GA01N101VO failVo = new GA01N101VO();
				failVo.setRctNo(newRctNo);
				failVo.setRqsScd(CD_RQS_SCD_TMP_STRG);
				rqamDao.updateAprvRqsScd(failVo);
			}
			log.error("aprvWrrpt Exception = {}", e.getMessage());
		}
		
		return newApprtNo;
	}
	
	// 결재 승인(단건, 다건처리)
	public int aprvPrc(RQAM1000U0In01VO vo) {
		// 결재상신번호 / 승인 반려 구분
		// 결재상신번호 해당 정보 조회
		// 승인시 대결여부 확인 -> 처리사원이 대결사원인지 판단
		int cnt = 0;
		int mCnt = 0;
		int dCnt = 0;
		int pCnt = 0;
		
		//String newApprtNo = "";
		String newRctNo   = "";
//		String rqsOrzCd   = "";
//		String rqsEpno    = "";
//		String unifRqsPcd = "";
//		String unifRqsPcdNm = "";
		
		/* 메시저 알림 */
//		String unifRqsDlPcdNm = ""; // 메신저 알림 신청구분
//		String unifRqsTcdNm = "";   // 메신저 알림 신청유형 
//		String rqsTtlNm = "";       // 메신저 알림 신청명
		
//		String rqsDt = DateUtil.getTodayString("yyyyMMdd");
//		String rqsScd = CD_RQS_SCD_TMP_STRG;
//		
//		String psitMenuId = "";
		
	    String aprvEpno = ""; /* 결재자사원번호 */
	    String sbapEpno = ""; /* 대결자사원번호 */
	    String aprvOrzCd = vo.getBlngOrzCd();
	    
//	    if (StringUtils.isBlank()) {
//			throw new Exception("임대신청 정보가 존재하지 않습니다 접수번호를 확인해주세요. 접수번호 : ["+newRctNo+"]");
//	    }
	    
	    
		GA09N607VO GA09N607VO = new GA09N607VO();
		List<GA09N607VO> GA09N607VOList = null;
		
	    List<RQAM1000U0In11VO> grid11 = vo.getGrid11();    // 결제대상내역
	    RQAM1000U0In11VO datavo = null;
	    		
		if(grid11 == null || grid11.size() == 0 ) {
            throw new CustomBadRequestException("결재대상 내역이 없습니다.", ErrorCode.BAD_REQUEST);					
		}		
		
		// 결재선 사용자 정보 조회
		List<GA09N602Vf02OutVO> userInfo = null;
		GA09N602Vf02InVO GA09N602Vf02InVO = null;
		
		GA09N607Pu01InVO GA09N607Pu01InVO = new GA09N607Pu01InVO();
		GA09N606Pu01InVO GA09N606Pu01InVO = new GA09N606Pu01InVO();
		RQRR1000U0VO RQRR1000U0VO = null;
		
		boolean bizPrcYn = false;   // 후처리 업무 여부
		boolean rsnCnPrcYn = false; // 결재사유처리 여부
		boolean bizChprYn = false;  // 담당사원 여부 
		String  sbapYn    = "0";  // 대결여부
		
		String RQS_SCD       = CD_RQS_SCD_APV_ING; // 신청상태코드 00.임시저장, 05.승인중, 10.승인완료, 15.메일전송완료, 30.반려, 35.철회, 99.완료
		String APRV_RSN_CN = "[승인완료]["+vo.getAprvEpno()+"]["+vo.getBlngOrzCd()+"]["+DateUtil.getTodayString("yyyyMMdd")+"]";; // 결재사유내용
		
		// 승인 단건처리인경우
		if(grid11.size() > 1) {
			rsnCnPrcYn = true;
		}
		
		for( int i = 0;i<grid11.size();i++) {
			
			// 기초값 초기화
			{
				bizPrcYn = false;
			}
			
			datavo = grid11.get(i);
			datavo.setAprvOrzCd(aprvOrzCd);
			
			if (rsnCnPrcYn) {
				datavo.setAprvRsnCn(APRV_RSN_CN);
			}
			
			log.info("datavo  ============"+datavo);
			mCnt++;
			
			{
				// 결재상세 등록정보 체크
				{
					aprvEpno = vo.getAprvEpno();
					// 결재상세정보 조회(PK)
					ObjectCopyUtil.copyFields(datavo, GA09N607VO);	
					GA09N607VO.setAprvEpno(aprvEpno);
					GA09N607VOList = rqamDao.selectAprvDtlPk(GA09N607VO);
					
					if(GA09N607VOList != null && GA09N607VOList.size() > 0 ) {
						// 대결여부 체크
						List<GA09N607VO> sbapList = null;
						GA09N607VO sbapVo = new GA09N607VO();
						sbapList = rqamDao.selectSbapCfmtYn(GA09N607VOList.get(0));
						if (sbapList.size() > 0) {
							sbapVo = sbapList.get(0);
							// 로그인사원 = 대결사원 동일한경우
							if (sbapVo.getSbapEpno().equals(aprvEpno)) {
								sbapYn = "1";
								aprvEpno = sbapVo.getAprvEpno();
								sbapEpno = sbapVo.getSbapEpno(); 
							}
						}
						
						/* 사원정보 체크 */
						{
							ObjectCopyUtil.copyFields(GA09N607VOList.get(0), GA09N607VO);
							
							GA09N602Vf02InVO = new GA09N602Vf02InVO();
							GA09N602Vf02InVO.setEpno(aprvEpno);
							
							// 업무담당자의 경우 승인조직 체크
							if(!StringUtils.isBlank(GA09N607VO.getAprvOrzCd())) {
								aprvOrzCd = GA09N607VO.getAprvOrzCd(); 
							}
							
							GA09N602Vf02InVO.setOrzCd(aprvOrzCd);
							GA09N602Vf02InVO.setScrnNo(GA09N607VO.getAprvUnitDlVl());
							userInfo = rqamDao.selectAprvWrrptUserInfoList(GA09N602Vf02InVO);
							
							if (userInfo == null || userInfo.size() == 0) {
								throw new CustomBadRequestException("사원정보가 존재하지않습니다. 사원정보를 확인하세요 사원번호["+aprvEpno+"]", ErrorCode.BAD_REQUEST);
							}
							
							if (!sbapYn.equals("1")) {
								
								// 승인사원이 직책이 존재할 경우 체크
								if (userInfo.get(0).getHrOsdtCd() != null && !userInfo.get(0).getHrOsdtCd().isEmpty()) {
									
									// 현재 직책코드가 2자리코드밖에 존재하지 않음
									if(GA09N607VO != null && GA09N607VO.getAprvUnitHrOsdtCd().length() < 3) {
										log.info("userInfo.get(0).getHrOsdtCd() = {} GA09N607VO.getAprvUnitHrOsdtCd() = {}", GA09N607VO.getAprvUnitHrOsdtCd());
										if (userInfo.get(0).getHrOsdtCd().equals(GA09N607VO.getAprvUnitHrOsdtCd())) {
											aprvEpno = userInfo.get(0).getEpno(); 
										} else {
											throw new CustomBadRequestException("해당사원은 결재권한이 없습니다. 사원정보를 확인하세요 사원번호["+userInfo.get(0).getEpno()+"] 사원명["+userInfo.get(0).getEpNm()+"] 직책코드["+userInfo.get(0).getHrOsdtCd()+"] 직책명["+userInfo.get(0).getHrOsdtNm()+"] ==> 가능 직책["+GA09N607VO.getAprvUnitHrOsdtCd()+"]", ErrorCode.BAD_REQUEST);
										}
									} else if(GA09N607VO != null && GA09N607VO.getAprvUnitHrOsdtCd().length() > 3) {
										if (GA09N607VO != null && GA09N607VO.getAprvUnitHrOsdtCd().contains(",")) {
											String [] osdtCd = GA09N607VO.getAprvUnitHrOsdtCd().split(",");
											String s_osdtCd = "";
											for (int j=0; j < osdtCd.length; j++) {
												log.info("userInfo.get(0).getHrOsdtCd()2 = {} osdtCd[j] = {}",userInfo.get(0).getHrOsdtCd(),  osdtCd[j]);
												if (userInfo.get(0).getHrOsdtCd().equals(s_osdtCd)) {
													aprvEpno = userInfo.get(0).getEpno(); 
												}
												log.info("aprvEpno = {}",aprvEpno);
											}
										} else {
											throw new CustomBadRequestException("해당사원은 결재권한이 없습니다. 사원정보를 확인하세요 사원번호["+userInfo.get(0).getEpno()+"] 사원명["+userInfo.get(0).getEpNm()+"]", ErrorCode.BAD_REQUEST);
										}
									} else {
										if (userInfo.get(0).getEpno().equals(GA09N607VO.getAprvEpno())) {
											aprvEpno = GA09N607VO.getAprvEpno();
										} else {
											throw new CustomBadRequestException("해당사원은 결재권한이 없습니다. 사원정보를 확인하세요 사원번호["+userInfo.get(0).getEpno()+"] 사원명["+userInfo.get(0).getEpNm()+"]", ErrorCode.BAD_REQUEST);
										}
									}
								}
							}
							
							// 승인사원이 업무담당자일 경우
							if (userInfo.get(0).getBzChprYn().equals("Y")) {
								aprvEpno = userInfo.get(0).getEpno();
								bizChprYn = true;
							}
							
							if(GA09N607VO.getAprvRtrnTcd() !=null && !GA09N607VO.getAprvRtrnTcd().equals("") ) {
					            throw new CustomBadRequestException("이미 결재처리된 내역입니다. 결재정보를 확인하세요["+GA09N607VO.getAprvWrrptMtNo()+"]["+GA09N607VO.getAprvWrrptOrzCd()+"]["+GA09N607VO.getAprvRnk()+"]["+GA09N607VO.getAprvDlRnk()+"]==>["+GA09N607VO.getAprvRtrnTcd()+"]", ErrorCode.BAD_REQUEST);		
							}
						}
					}else {
			            throw new CustomBadRequestException("결재대상이 존재하지않습니다. 결재정보를 확인하세요["+GA09N607VO.getAprvWrrptMtNo()+"]["+GA09N607VO.getAprvWrrptOrzCd()+"]["+GA09N607VO.getAprvRnk()+"]["+GA09N607VO.getAprvDlRnk()+"]", ErrorCode.BAD_REQUEST);		
					}
				}
				
				log.info("진행  ========================================================== ");
				
				GA09N607Pu01InVO = new GA09N607Pu01InVO();
				ObjectCopyUtil.copyFields(datavo, GA09N607Pu01InVO);
				GA09N607Pu01InVO.setAprvRtrnTcd(CD_APRV_RTRN_TCD_APV);	// 접수/승인
				GA09N607Pu01InVO.setSbapYn(sbapYn);
				GA09N607Pu01InVO.setSbapEpno(sbapEpno);
				GA09N607Pu01InVO.setAprvEpno(aprvEpno);
				// 승인처리
				{
					cnt = rqamDao.updateGA09N607Aprv(GA09N607Pu01InVO);
					log.info("cnt  ============"+cnt);
					if(cnt == 0) {
			            throw new CustomBadRequestException("결재처리 대상이 맞지않습니다. 결재대상정보를 확인하세요["+GA09N607Pu01InVO.getAprvWrrptMtNo()+"]["+GA09N607Pu01InVO.getAprvWrrptOrzCd()+"]["+GA09N607Pu01InVO.getAprvRnk()+"]["+GA09N607Pu01InVO.getAprvDlRnk()+"]", ErrorCode.BAD_REQUEST);		
					}
				}
				
				// 초기화전 상신조직 값 저장
				String AprvWrrptOrzCd = GA09N607VO.getAprvWrrptOrzCd();
				
				// 다음결재정보 조회 후처리
				GA09N607VO = new GA09N607VO();
				// 다음결재정보 조회
				ObjectCopyUtil.copyFields(GA09N607Pu01InVO, GA09N607VO);
				
				// 상신조직을 넣어서 체크
				GA09N607VO.setAprvWrrptOrzCd(AprvWrrptOrzCd);
				GA09N607VOList = rqamDao.selectAprvNext(GA09N607VO);
				
				if(GA09N607VOList == null || GA09N607VOList.size() == 0 ) {
					// 다음 결재건없음 => 완료처리
					GA09N606Pu01InVO = new GA09N606Pu01InVO();
					GA09N606Pu01InVO.setAprvWrrptMtNo(GA09N607Pu01InVO.getAprvWrrptMtNo());
					
					// 상신조직으로 업데이트 처리
					GA09N606Pu01InVO.setAprvWrrptOrzCd(AprvWrrptOrzCd);
					GA09N606Pu01InVO.setAprvScd(CD_APRV_SCD_APV); // 승인완료
					
					cnt = rqamDao.updateGA09N606Aprv(GA09N606Pu01InVO);
					
					if(cnt == 0) {
			            throw new CustomBadRequestException("결재대상건(마스터)이 없습니다 결재상신번호를 확인하세요["+datavo.getAprvWrrptMtNo()+"]["+datavo.getAprvWrrptOrzCd()+"]", ErrorCode.BAD_REQUEST);		
					}
					
					bizPrcYn = true; // 업무 후처리
					RQS_SCD = CD_RQS_SCD_APV_CMPN;	// 승인완료
				} else {
					
					GA09N607VO = new GA09N607VO(); 
					ObjectCopyUtil.copyFields(GA09N607VOList.get(0), GA09N607VO);
					
					log.info("next 결재정보 =======["+GA09N607VO +"]");
					
					// 다음결제정보 결재상신구분코드 접수자일경우 신청상태 승인대기->승인중 으로 변경
					if((CD_APRV_RTRN_TCD_APV).equals(GA09N607VO.getAprvWrrptTcd())){
						bizPrcYn = true; // 업무 후처리
						RQS_SCD = CD_RQS_SCD_APV_ING;	// 승인중 				
					}
					
					// 다음결재정보 참조
					if(GA09N607VO != null && GA09N607VO.getDcfcPcd().equals(CD_DCFC_PCD_REF)) {
						bizPrcYn = true; // 업무 후처리
						RQS_SCD = CD_RQS_SCD_APV_CMPN;	// 승인완료
					}
				}

				// [다음 승인자 알림] 승인 중 상태 인 경우 알림, 알림톡 발송_2023-12-11
				if ( RQS_SCD.equals(CD_RQS_SCD_APV_ING) && !StringUtils.isBlank(GA09N607VO.getAprvWrrptMtNo()) && !StringUtils.isBlank(GA09N607VO.getAprvRnk()) ) {
					sendMsgEnrollApv(GA09N607VO.getAprvWrrptMtNo(), GA09N607VO.getAprvRnk(), GA09N607VO.getAprvDlRnk(), "");
				}


				// 후처리(업무반영) 
				if(bizPrcYn || cnt > 0) {
					
					// 접수번호
					newRctNo   = datavo.getRctNo();
					
					boolean msgSend = false; 
					
					// 임대신청 정보 조회
					GA01N101VO selVo = new GA01N101VO();
					selVo.setRctNo(newRctNo);
					selVo = rqamDao.selectGA01N101Pk(selVo);
					
					if(selVo == null) {
			            throw new CustomBadRequestException("접수번호가 존재하지않습니다. 접수번호를 확인하세요["+newRctNo+"]", ErrorCode.BAD_REQUEST);		
					}

					// [후처리] 인감 신청 이면서 다음 승인자가 총무팀 담당자 인 경우
					if (selVo.getUnifRqsPcd().equals(APRV_PCD_05) 
						&& !StringUtils.isBlank(GA09N607VO.getAprvUnitTcd())
						&& "10".equals(GA09N607VO.getAprvUnitTcd())) {
						//총무팀 방문 알림
						msg.sendMsgEnrollNoti(selVo.getRqsEpno(), newRctNo, "IPRT_MSG_CD", "AL0006", "");
					}

					/* 문서 */
					if (selVo.getUnifRqsPcd().equals(APRV_PCD_09) && RQS_SCD.equals(CD_RQS_SCD_APV_CMPN)) {
						String strRtn = serviceRQDR1000U0.sendDocMailWithExcel(datavo.getRctNo());

						RQRR1000U0VO = new RQRR1000U0VO();
						if(strRtn.contains("success")){
							// 메일 전송 성공
							// Status Update
							RQRR1000U0VO.setRctNo(datavo.getRctNo());
							RQRR1000U0VO.setRqsScd(CD_RQS_SCD_EMAL);
						}
						else
						{
							// [20231026S] 메일 발송 실패해도 승인은 되어야한다고 함. 그래서 일단 주석처리 + 승인완료로 업뎃
							RQRR1000U0VO.setRctNo(datavo.getRctNo());
							RQRR1000U0VO.setRqsScd(CD_RQS_SCD_APV_CMPN);

							// 에러 케이스 처리 예정 - sendDocMailWithExcel 쪽 에서 처리 하는 걸로 변경
							// msg.sendMessage("","3329432", "[Mi-SUPPORT] 문서 신청 승인 완료 후 메일 전송 실패.<br>", "▶ 접수번호 : " + newRctNo, "", "");
						}
						dCnt = RQRR1000U0Dao.updateRqsScd(RQRR1000U0VO);
					
					} else if (selVo.getUnifRqsPcd().equals(APRV_PCD_06) && RQS_SCD.equals(CD_RQS_SCD_APV_CMPN)) {
						/* 인장조제 */	
						pCnt = serviceGASR1000U0.updateGA01N501Aprv(datavo.getRctNo());
						
						if ( pCnt > 0) {
							/* 임대신청 신청상태변경 */
							RQRR1000U0VO = new RQRR1000U0VO();
							RQRR1000U0VO.setRctNo(newRctNo);
							RQRR1000U0VO.setRqsScd(RQS_SCD);
							
							dCnt = RQRR1000U0Dao.updateRqsScd(RQRR1000U0VO);
						} else {
							throw new CustomBadRequestException("인영번호가 존재하지않습니다. 인영번호를 확인하세요.", ErrorCode.BAD_REQUEST);
						}
					
					}  else if (selVo.getUnifRqsPcd().equals(APRV_PCD_02) && RQS_SCD.equals(CD_RQS_SCD_APV_CMPN)) {
						/* 구매 */
						
						/* TODO 메일전송 처리 */
						String strRtn = "success";
						// serviceRQDR1000U0.sendDocMailWithExcel(datavo.getRctNo());
						RQRR1000U0VO = new RQRR1000U0VO();
						if(strRtn.contains("success")){
							// 메일 전송 성공
							// Status Update
							RQRR1000U0VO.setRctNo(datavo.getRctNo());
							RQRR1000U0VO.setRqsScd(CD_RQS_SCD_EMAL);
						}
						else
						{
							RQRR1000U0VO.setRctNo(datavo.getRctNo());
							RQRR1000U0VO.setRqsScd(CD_RQS_SCD_APV_CMPN);
						}
						dCnt = RQRR1000U0Dao.updateRqsScd(RQRR1000U0VO);
						
					} else if (selVo.getUnifRqsPcd().equals(APRV_PCD_04) && RQS_SCD.equals(CD_RQS_SCD_APV_CMPN)) {
						/* 명함 */
						
						/* TODO 메일전송 처리 */
						String strRtn = "success";
						// serviceRQDR1000U0.sendDocMailWithExcel(datavo.getRctNo());
						RQRR1000U0VO = new RQRR1000U0VO();
						if(strRtn.contains("success")){
							// 메일 전송 성공
							// Status Update
							RQRR1000U0VO.setRctNo(datavo.getRctNo());
							RQRR1000U0VO.setRqsScd(CD_RQS_SCD_EMAL);
						}
						else
						{
							RQRR1000U0VO.setRctNo(datavo.getRctNo());
							RQRR1000U0VO.setRqsScd(CD_RQS_SCD_APV_CMPN);
						}
						dCnt = RQRR1000U0Dao.updateRqsScd(RQRR1000U0VO);
						
					} else {
						/* 임대신청 신청상태변경 */
						RQRR1000U0VO = new RQRR1000U0VO();
						RQRR1000U0VO.setRctNo(newRctNo);
						RQRR1000U0VO.setRqsScd(RQS_SCD);
						
						dCnt = RQRR1000U0Dao.updateRqsScd(RQRR1000U0VO);	
					}
				
					if(dCnt == 0) {
			            throw new CustomBadRequestException("접수번호가 존재하지않습니다. 접수번호를 확인하세요["+datavo.getRctNo()+"]", ErrorCode.BAD_REQUEST);		
					} else {
						msgSend = true;
					}
					log.info("msgSend = {}, bizChprYn = {}", msgSend, bizChprYn);
					// 메신저 알림 전송
					if(msgSend) {
//						// 업무 당당자승인시 신청자 알림 <- 메신저알림 변경 진행중 총무팀장만 제외 
//						// 신청자 메신저 전송 -> 다음 승인진행자
						if (RQS_SCD.equals(CD_RQS_SCD_APV_CMPN)) {
							// 최종 승인 완료 : 메신저 알림 발송
							msg.sendMsgEnrollNoti(selVo.getRqsEpno(), newRctNo, "APV_CMPN", "", "");
						}
					}
					
					// 인감증명서: 인감날인만 신청한 경우 자동완료처리
					if(msgSend && selVo.getUnifRqsPcd().equals(APRV_PCD_05) && RQS_SCD.equals(CD_RQS_SCD_APV_CMPN)) {
						boolean exist05Yn = serviceRQSR1000U0.selectGA01N505ExistYn(datavo.getRctNo()); 
						if(!exist05Yn) { // 인감증명서 신청 건수 0일때 자동완료처리
							// 인감 처리 완료 처리
							RQRR1000U0VO.setRqsScd(CD_RQS_SCD_PRC_CMPN);
							RQRR1000U0VO.setCmpnDt(DateUtil.getTodayString("yyyyMMdd"));
							int sealCnt = RQRR1000U0Dao.updateRqsScd(RQRR1000U0VO);
						}
					}
				}
			}			
		}					
		log.info("mCnt  ============"+mCnt);

		return mCnt;
	}
	
	// 반려(단건)
	public int aprvRtrn(RQAM1000U0In02VO vo) {
		int cnt = 0;
		int dCnt = 0;
		GA09N607Pu01InVO GA09N607Pu01InVO = new GA09N607Pu01InVO();
		GA09N606Pu01InVO GA09N606Pu01InVO = new GA09N606Pu01InVO();
		GA09N607VO GA09N607VO = new GA09N607VO();
		List<GA09N607VO> GA09N607VOList = null;
		
		RQRR1000U0VO RQRR1000U0VO = null; // 렌탈신청 - 임시셋팅
		
		boolean bizPrcYn = false; // 후처리 업무 여부
//		String APRV_PCD      = "";
//		String APRV_RTRN_TCD = "";
		String RQS_SCD       = ""; // 신청상태코드 00.임시저장, 05.승인중, 10.승인완료, 15.메일전송완료, 30.반려, 35.철회, 99.완료
		String RCT_NO        = "";
		String APRV_WRRPT_ORZ_CD = "";
		/* 메시저 알림 */
//		String unifRqsDlPcdNm = ""; // 메신저 알림 신청구분
//		String unifRqsTcdNm = "";   // 메신저 알림 신청유형 
//		String rqsTtlNm = "";       // 메신저 알림 신청명

		/* [20231201] 반려시 대결여부 추가 */
		String sbapYn = "0";
		String aprvEpno = "";
		String sbapEpno = "";

 		log.info("updateAprv getAprvRtrnTcd()=======["+vo.getAprvRtrnTcd() +"]");
		

		// 전처리 : 입력값 체크 
		{
			if( vo.getAprvEpno() == null || vo.getAprvEpno().equals("")) {
	            throw new CustomBadRequestException("입력항목을 확인하세요 getAprvEpno["+vo.getAprvEpno()+"]", ErrorCode.BAD_REQUEST);		
			}
			if( vo.getAprvPcd() == null || vo.getAprvPcd().equals("")) {
	            throw new CustomBadRequestException("입력항목을 확인하세요 getAprvPcd["+vo.getAprvPcd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if( vo.getAprvRtrnTcd() == null || vo.getAprvRtrnTcd().equals("")) {
	            throw new CustomBadRequestException("입력항목을 확인하세요 getAprvRtrnTcd["+vo.getAprvRtrnTcd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if( vo.getAprvWrrptMtNo() == null || vo.getAprvWrrptMtNo().equals("")) {
	            throw new CustomBadRequestException("입력항목을 확인하세요 getAprvWrrptMtNo["+vo.getAprvWrrptMtNo()+"]", ErrorCode.BAD_REQUEST);		
			}
			if( vo.getAprvOrzCd() == null || vo.getAprvOrzCd().equals("")) {
	            throw new CustomBadRequestException("입력항목을 확인하세요 getAprvOrzCd["+vo.getAprvOrzCd()+"]", ErrorCode.BAD_REQUEST);		
			}
			
			if( vo.getAprvRnk() == null || vo.getAprvRnk().equals("")) {
	            throw new CustomBadRequestException("입력항목을 확인하세요 getAprvRnk["+vo.getAprvRnk()+"]", ErrorCode.BAD_REQUEST);		
			}
			if( vo.getAprvDlRnk() == null || vo.getAprvDlRnk().equals("")) {
	            throw new CustomBadRequestException("입력항목을 확인하세요 getAprvDlRnk["+vo.getAprvDlRnk()+"]", ErrorCode.BAD_REQUEST);		
			}
			
			//APRV_PCD = vo.getAprvPcd();
			//APRV_RTRN_TCD = vo.getAprvRtrnTcd();
			RCT_NO = vo.getRctNo();
			
			// 전처리(업무반영)
			{
				// 임대신청 정보 조회
				GA01N101VO selVo = new GA01N101VO();
				selVo.setRctNo(RCT_NO);
				selVo = rqamDao.selectGA01N101Pk(selVo);
				
				if(selVo == null) {
		            throw new CustomBadRequestException("접수번호가 존재하지않습니다. 접수번호를 확인하세요["+RCT_NO+"]", ErrorCode.BAD_REQUEST);		
				}
				
//				unifRqsDlPcdNm = selVo.getUnifRqsDlPcdNm();
//				unifRqsTcdNm   = selVo.getUnifRqsTcdNm();
//				rqsTtlNm       = selVo.getRqsTtlNm();
				
				// 각 업무별 전처리
				if(selVo.getUnifRqsPcd().equals(APRV_PCD_09)){
					// 문서 반려 처리
					dCnt = serviceRQDR1000U0.updateGA01N602RejectByDocNo(RCT_NO);
				} else if(selVo.getUnifRqsPcd().equals(APRV_PCD_06)){
					// 인장 반려 처리
					dCnt = serviceGASR1000U0.updateGA01N501Rtrn(RCT_NO);
				}  
				/* 신청상태변경 */
				RQRR1000U0VO = new RQRR1000U0VO();
				RQRR1000U0VO.setRctNo(RCT_NO);
				RQRR1000U0VO.setRqsScd(CD_RQS_SCD_RTRN);
				dCnt = RQRR1000U0Dao.updateRqsScd(RQRR1000U0VO);	

				// 해당 업무 화면 조회
				GaCode01In00VO rqsPcdVo = new GaCode01In00VO();
				rqsPcdVo.setCdKndNo("PSIT_MENU_ID_TCD");
				rqsPcdVo.setCmnCdVl(selVo.getUnifRqsPcd());
				List<GaCode01Out00VO> rqsPcdList = CodeDao.selectBzMtCode(rqsPcdVo); 
				String psitMenuId = rqsPcdList.get(0).getCmnCdVlDefCn();
				
				GA09N602Vf02InVO GA09N602Vf02InVO = new GA09N602Vf02InVO();
				//GA09N602Vf02OutVO GA09N602Vf02OutVO = null;
				GA09N602Vf02InVO.setEpno(vo.getAprvEpno());
				GA09N602Vf02InVO.setScrnNo(psitMenuId);
				
				// 화면 담당자가 없는 화면 체크
				//GA09N602Vf02OutVO = rqamDao.selectBzChprYn(GA09N602Vf02InVO);
				
				// 알림메세지 셋팅
				String sReceiveUserId = selVo.getRqsEpno();
				msg.sendMsgEnrollNoti(sReceiveUserId, RCT_NO, "BZ_CHPR_RTRN", "", "");
			}
			
			// 결재상세 등록정보 체크
			{
				// 결재상세정보 조회(PK)
				ObjectCopyUtil.copyFields(vo, GA09N607VO);				
				GA09N607VOList = rqamDao.selectAprvDtlPk(GA09N607VO);
				
				if(GA09N607VOList != null && GA09N607VOList.size() > 0 ) {
					ObjectCopyUtil.copyFields(GA09N607VOList.get(0), GA09N607VO);
					APRV_WRRPT_ORZ_CD = GA09N607VO.getAprvWrrptOrzCd();
					//log.info("결재상세정보조회(PK) getAprvRtrnTcd()=======["+GA09N607VO.getAprvRtrnTcd() +"]");					
					
					if(GA09N607VO.getAprvRtrnTcd() !=null && !GA09N607VO.getAprvRtrnTcd().equals("") ) {
			            throw new CustomBadRequestException("이미 결재처리된 내역입니다. 결재정보를 확인하세요["+GA09N607VO.getAprvWrrptMtNo()+"]["+GA09N607VO.getAprvWrrptOrzCd()+"]["+GA09N607VO.getAprvRnk()+"]["+GA09N607VO.getAprvDlRnk()+"]==>["+GA09N607VO.getAprvRtrnTcd()+"]", ErrorCode.BAD_REQUEST);		
					}

					/* [20231201] 반려시 대결여부 추가 */
					// 대결여부 체크
					List<GA09N607VO> sbapList = null;
					GA09N607VO sbapVo = new GA09N607VO();
					sbapList = rqamDao.selectSbapCfmtYn(GA09N607VOList.get(0));
					aprvEpno = vo.getAprvEpno();

					if (sbapList.size() > 0) {
						sbapVo = sbapList.get(0);
						// 로그인사원 = 대결사원 동일한경우
						if (sbapVo.getSbapEpno().equals(aprvEpno)) {
							sbapYn = "1";
							aprvEpno = sbapVo.getAprvEpno();
							sbapEpno = sbapVo.getSbapEpno();
						}
					}
				}
			}
		}

		// 반려처리
		{
			// 상신조직 셋팅
			vo.setAprvWrrptOrzCd(APRV_WRRPT_ORZ_CD);;
			ObjectCopyUtil.copyFields(vo, GA09N607Pu01InVO);

			/* [20231201] 반려시 대결여부 추가 */
			GA09N607Pu01InVO.setSbapYn(sbapYn);
			GA09N607Pu01InVO.setAprvEpno(aprvEpno);
			GA09N607Pu01InVO.setSbapEpno(sbapEpno);

			cnt = rqamDao.updateGA09N607Aprv(GA09N607Pu01InVO);
			
			if(cnt > 0) {
				// 2:반려
				if(vo.getAprvRtrnTcd().equals(CD_APRV_RTRN_TCD_RTRN)) {		
					GA09N606Pu01InVO.setAprvWrrptMtNo(GA09N607Pu01InVO.getAprvWrrptMtNo());										
					GA09N606Pu01InVO.setAprvWrrptOrzCd(GA09N607Pu01InVO.getAprvWrrptOrzCd());
					GA09N606Pu01InVO.setAprvScd(CD_APRV_SCD_RTRN);
					
					dCnt = rqamDao.updateGA09N606Aprv(GA09N606Pu01InVO);
					
					if(dCnt == 0) {
			            throw new CustomBadRequestException("결재대상건(마스터)이 없습니다 결재상신번호를 확인하세요["+vo.getAprvWrrptMtNo()+"]["+vo.getAprvWrrptOrzCd()+"]", ErrorCode.BAD_REQUEST);		
					}
					bizPrcYn = true; // 업무 후처리
					RQS_SCD = CD_RQS_SCD_RTRN;
				}
				
				// 후처리(업무반영)
				if(bizPrcYn) {
				}
				
			}else {
	            throw new CustomBadRequestException("결재대상건이 없습니다 결재상신번호를 확인하세요["+vo.getAprvWrrptMtNo()+"]["+vo.getAprvWrrptOrzCd()+"]", ErrorCode.BAD_REQUEST);		
			}
		}
		return cnt;
	}
	
	// 결재 철회(접수번호. 철회내용, 철회요청자, 철회요청자 조직)
	public int aprvWdral(String rctNo, String aprvRsnCn, String prcEpno, String prcOrzCd) {
		int cnt = 0;
		int mCnt = 0;
		boolean bizPrcYn = false; // 업무 후처리
		
	    String aprvWrrptMtNo  ; /*결재상신관리번호 	*/
	    String aprvWrrptOrzCd ; /*결재상신조직코드 	*/
	    String aprvRnk        ; /*결재순위      	*/
	    String aprvDlRnk      ; /*결재상세순위		*/
	    
	    GA01N101VO GA01N101VO = new GA01N101VO(); // 임대신청
		GA09N607VO GA09N607VO = new GA09N607VO(); // 결재정보상세

		List<GA01N101VO> GA01N101VOList = null;
		List<GA09N607VO> GA09N607VOList = null;
		
		// 입력값 체크
		{
			if( rctNo == null || rctNo.equals("")) {
	            throw new CustomBadRequestException("접수번호를 확인하세요 rctNo["+rctNo+"]", ErrorCode.BAD_REQUEST);		
			}
		}
		
		// 1. 신청상태 변경 -> 철회
		{
			GA01N101VO.setRctNo(rctNo);
			GA01N101VOList = RQRR1000U0Dao.selectGA01N101(GA01N101VO);
			
			if(GA01N101VOList != null && GA01N101VOList.size() > 0 ) {
				bizPrcYn = true;
				
				GA01N101VO = GA01N101VOList.get(0);

				// 090301 : 박스정보정정, 090403 : 연장신청 - 철회 불가
				if ( GA01N101VO.getUnifRqsTcd().equals("090301") || GA01N101VO.getUnifRqsTcd().equals("090403") ) {
					throw new CustomBadRequestException("[박스정보정정][연장신청] 신청 유형은 철회 하실 수 없어요.", ErrorCode.BAD_REQUEST);
				}
				
				if(GA01N101VO.getRqsScd() == null || GA01N101VO.getRqsScd().equals("") ) {
		            throw new CustomBadRequestException("신청상태를 확인하세요 ["+GA01N101VO.getRctNo()+"]["+GA01N101VO.getRqsScd()+"]", ErrorCode.BAD_REQUEST);		
				}
				
				GA09N607VO wdralChkVo = new GA09N607VO();
				List<GA09N607VO> wdralChk = new ArrayList<GA09N607VO>();
				wdralChkVo.setAprvWrrptMtNo(GA01N101VO.getAprvWrrptMtNo());
				wdralChk = rqamDao.selectAprvWrrptDlList(wdralChkVo);
				
				if ( !GA01N101VO.getRqsScd().equals(CD_RQS_SCD_EMAL) && !GA01N101VO.getRqsScd().equals(CD_RQS_SCD_APV_CMPN) && !GA01N101VO.getRqsScd().equals(CD_RQS_SCD_CMPN) ) {
		            throw new CustomBadRequestException("신청상태를 확인하세요 [승인완료][메일전송완료][완료]일경우만 철회신청가능합니다. ["+GA01N101VO.getRctNo()+"]["+GA01N101VO.getRqsScd()+"]", ErrorCode.BAD_REQUEST);		
				}
				else if (wdralChk.size() > 0 ) {
					throw new CustomBadRequestException("미결재처리건이 존재합니다 승인현황을 확인해주세요. 접수번호=["+GA01N101VO.getRctNo()+"] 미승인건수=["+wdralChk.size()+"]", ErrorCode.BAD_REQUEST);
				}  
				
				// 결재선 사용자 정보 조회
				{
					// 해당 업무 화면 조회
					GaCode01In00VO rqsPcdVo = new GaCode01In00VO();
					rqsPcdVo.setCdKndNo("PSIT_MENU_ID_TCD");
					rqsPcdVo.setCmnCdVl(GA01N101VO.getUnifRqsPcd());
					List<GaCode01Out00VO> rqsPcdList = CodeDao.selectBzMtCode(rqsPcdVo); 
					String psitMenuId = rqsPcdList.get(0).getCmnCdVlDefCn();

					// 상신 하는 사람이 총무팀의 화면 담당자 or 화면 담당자가 없는 화면
					GA09N602Vf02InVO GA09N602Vf02InVO = new GA09N602Vf02InVO();
					GA09N602Vf02OutVO GA09N602Vf02OutVO = null;
					GA09N602Vf02InVO.setEpno(prcEpno);
					GA09N602Vf02InVO.setScrnNo(psitMenuId);
					GA09N602Vf02OutVO = rqamDao.selectBzChprYn(GA09N602Vf02InVO);
				
					// 철회업무는 [승인완료][메일전송완료][완료] 일경우 가능 
					if (GA09N602Vf02OutVO.getBzChprYn().equals("N")) {
						throw new CustomBadRequestException("업무담당자인 경우에만 철회신청가능합니다. ["+prcEpno+"]["+prcOrzCd+"]", ErrorCode.BAD_REQUEST);
					}
				}
				
				// 각 업무단에서 처리
				if (bizPrcYn) {
					// 각 업무단 전처리
					if(GA01N101VO.getUnifRqsPcd().equals(APRV_PCD_09)){
						// 문서 철회 처리
						cnt = serviceRQDR1000U0.updateGA01N602WithDrawByDocNo(rctNo);
					}
					RQRR1000U0VO RQRR1000U0VO = new RQRR1000U0VO();
					RQRR1000U0VO.setRctNo(rctNo);
					RQRR1000U0VO.setRqsScd(CD_RQS_SCD_WDRAL); // 철회상태
					/* 임대신청 신청상태변경 */
					cnt = RQRR1000U0Dao.updateRqsScd(RQRR1000U0VO);
				}
				
				if(cnt == 0) {
		            throw new CustomBadRequestException("신청 신청상태 변경시 오류입니다. ["+rctNo+"]", ErrorCode.BAD_REQUEST);		
				}
				
			}else {
	            throw new CustomBadRequestException("철회 대상이 존재하지 않습니다. 접수번호를 확인하세요["+GA01N101VO.getRctNo()+"]", ErrorCode.BAD_REQUEST);		
			}		
		}
		
		String APRV_RSN_CN = ""; // 결재사유내용
		if (StringUtils.isBlank(aprvRsnCn)) {
			APRV_RSN_CN = "[철회완료]["+prcEpno+"]["+prcOrzCd+"]["+DateUtil.getTodayString("yyyyMMdd")+"]";
		} else {
			APRV_RSN_CN = aprvRsnCn;
		}
		
		// 2. 결재상세정보 철회사유 입력
		{
			int wdraCnt = 0;
		    
		    // 철회시 승인현황 철회부분 등록
		    GA09N607Pu01InVO wdralVo = new GA09N607Pu01InVO();
		    wdralVo.setAprvOrzCd(prcOrzCd);
		    wdralVo.setAprvEpno(prcEpno);
		    wdralVo.setAprvWrrptMtNo(GA01N101VO.getAprvWrrptMtNo());
		    wdralVo.setAprvWrrptOrzCd(GA01N101VO.getRqsOrzCd());

			// [20231130] 삭제예정. 결재관리번호 2023110100000006를 철회하기 위해 임시로 생성한 내용
			//if(GA01N101VO.getAprvWrrptMtNo().equals("2023110100000006")) {
			//	wdraCnt = rqamDao.insertGA09N607WdralFor2023110100000006(wdralVo);
			//} else {
			//	wdraCnt = rqamDao.insertGA09N607Wdral(wdralVo);
			//}
			 wdraCnt = rqamDao.insertGA09N607Wdral(wdralVo);

		    if (wdraCnt > 0) {
		    	//결제상세정보 접수자 항목 조회
		    	aprvWrrptMtNo  = GA01N101VO.getAprvWrrptMtNo();
		    	aprvWrrptOrzCd = GA01N101VO.getRqsOrzCd();
		    	aprvRnk   = wdralVo.getAprvRnk() ; /*결재순위    */
		    	aprvDlRnk = wdralVo.getAprvRnk() ; /*결재상세순위 */		
		    	
		    	GA09N607VO.setAprvWrrptMtNo(aprvWrrptMtNo);
		    	GA09N607VO.setAprvWrrptOrzCd(aprvWrrptOrzCd);
		    	GA09N607VO.setAprvEpno(prcEpno);
		    	GA09N607VO.setAprvOrzCd(prcOrzCd);
		    	GA09N607VO.setAprvRnk(aprvRnk);
		    	GA09N607VO.setAprvDlRnk(aprvDlRnk);
		    	GA09N607VOList = rqamDao.selectAprvDtlPk(GA09N607VO);
		    	
		    	if(GA09N607VOList != null && GA09N607VOList.size() > 0 ) {
		    		GA09N607VO = GA09N607VOList.get(0);
		    		GA09N607VO.setAprvRsnCn(APRV_RSN_CN);
		    		GA09N607VO.setAprvWrrptOrzCd(prcOrzCd);
		    		mCnt = rqamDao.updateGA09N607RsnCn(GA09N607VO);
		    		// 철회완료시 승인현황 철회부분 등록
		    	} else {
		    		throw new CustomBadRequestException("결재내역이 존재하지 않습니다. 결제상세내역을 확인하세요"+aprvWrrptMtNo+"]["+aprvWrrptOrzCd+"]["+aprvRnk+"]["+aprvDlRnk+"]", ErrorCode.BAD_REQUEST);		
		    	}					
		    } else {
		    	throw new CustomBadRequestException("철회 대상이 존재하지 않습니다. 접수번호를 확인하세요["+GA01N101VO.getRctNo()+"]", ErrorCode.BAD_REQUEST);
		    }
		}

		return mCnt;
	}


	public void sendMsgEnrollApv(String sAprvWrrptMtNo, String sAprvRnk, String sAprvDlRnk, String strDcfcPcd){
		msg.sendMsgEnrollNotiApv(sAprvWrrptMtNo, sAprvRnk, sAprvDlRnk, strDcfcPcd);
	}


}
