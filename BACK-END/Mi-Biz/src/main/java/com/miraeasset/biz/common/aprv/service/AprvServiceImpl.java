package com.miraeasset.biz.common.aprv.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.aprv.dao.AprvDao;
import com.miraeasset.biz.common.aprv.vo.Aprv00In00VO;
import com.miraeasset.biz.common.aprv.vo.Aprv00In01VO;
import com.miraeasset.biz.common.aprv.vo.Aprv00In02VO;
import com.miraeasset.biz.common.aprv.vo.Aprv00In11VO;
import com.miraeasset.biz.common.aprv.vo.Aprv00Out00VO;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.meta.vo.GA09N606Pu01InVO;
import com.miraeasset.biz.common.meta.vo.GA09N607Pu01InVO;
import com.miraeasset.biz.common.meta.vo.GA09N607VO;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.rq.rr.dao.RQRR1000U0Dao;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;

@Service
@Transactional
public class AprvServiceImpl implements AprvService {

	@Autowired
	AprvDao AprvDao;

	@Autowired
	RQRR1000U0Dao RQRR1000U0Dao; // 렌탈신청
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/* APRV_PCD 코드값 정의 */
	private final String CD_APRV_PCD_RENT  = "01"; // 렌탈신청 
	private final String CD_APRV_PCD_PCH   = "02"; // 구매신청 
	
	/* APRV_SCD 코드값 정의 */
	private final String CD_APRV_SCD_RCT   = "01"; // 접수 
	private final String CD_APRV_SCD_APRVING  = "02"; // 결재중 
	private final String CD_APRV_SCD_RTRN  = "03"; // 반려
	private final String CD_APRV_SCD_APV   = "04"; // 승인완료 

	/* APRV_RTRN_TCD  코드값 정의 */
	private final String CD_APRV_RTRN_TCD_RCT   = "1"; // 접수/승인 
	private final String CD_APRV_RTRN_TCD_RTRN  = "2"; // 반려 
	private final String CD_APRV_RTRN_TCD_REF   = "3"; // 참조 
	
	/* DCFC_PCD  코드값 정의 */
	private final String CD_DCFC_PCD_APRV  = "01"; // 결재 
	private final String CD_DCFC_PCD_REF   = "02"; // 참조 
	
	/* APRV_WRRPT_TCD   코드값 정의 */
	private final String APRV_WRRPT_TCD_DRWR  = "0"; // 작성자 	
	private final String APRV_WRRPT_TCD_DCFC  = "1"; // 결제자 	
	private final String APRV_WRRPT_TCD_RCTR  = "2"; // 접수자 	
	private final String APRV_WRRPT_TCD_STDY  = "3"; // 검토자 	
	private final String APRV_WRRPT_TCD_APVR  = "4"; // 승인자
	
	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "01"; // 임시저장 
	private final String CD_RQS_SCD_APV_ING  = "02"; // 승인중 
	private final String CD_RQS_SCD_APV_CMPN = "03"; // 승인완료 
	private final String CD_RQS_SCD_CMPN     = "04"; // 완료 
	private final String CD_RQS_SCD_RTRN     = "05"; // 반려
	private final String CD_RQS_SCD_WDRAL    = "06"; // 철회
	
	/* 승댄대기 내역조회 */	
	@Override
	public List<Aprv00Out00VO> selectAprvList(Aprv00In00VO vo) {
		return AprvDao.selectAprvList(vo);
	}	
	
	/* 승인/반려 처리 - 단건 */	
	@Override
	public int updateAprv(Aprv00In02VO vo) {
		int cnt = 0;
		int dCnt = 0;
		GA09N607Pu01InVO GA09N607Pu01InVO = new GA09N607Pu01InVO();
		GA09N606Pu01InVO GA09N606Pu01InVO = new GA09N606Pu01InVO();
		GA09N607VO GA09N607VO = new GA09N607VO();
		List<GA09N607VO> GA09N607VOList = null;
		boolean bizPrcYn = false; // 후처리 업무 여부
		String APRV_PCD      = "";
		String APRV_RTRN_TCD = "";
		
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
			if( vo.getAprvWrrptOrzCd() == null || vo.getAprvWrrptOrzCd().equals("")) {
	            throw new CustomBadRequestException("입력항목을 확인하세요 getAprvWrrptOrzCd["+vo.getAprvWrrptOrzCd()+"]", ErrorCode.BAD_REQUEST);		
			}
			
			if( vo.getAprvRnk() == null || vo.getAprvRnk().equals("")) {
	            throw new CustomBadRequestException("입력항목을 확인하세요 getAprvRnk["+vo.getAprvRnk()+"]", ErrorCode.BAD_REQUEST);		
			}
			if( vo.getAprvDlRnk() == null || vo.getAprvDlRnk().equals("")) {
	            throw new CustomBadRequestException("입력항목을 확인하세요 getAprvDlRnk["+vo.getAprvDlRnk()+"]", ErrorCode.BAD_REQUEST);		
			}
			
			APRV_PCD = vo.getAprvPcd();
			APRV_RTRN_TCD = vo.getAprvRtrnTcd();
			
			// 결재상세 등록정보 체크
			{
				// 결재상세정보 조회(PK)
				ObjectCopyUtil.copyFields(vo, GA09N607VO);				
				GA09N607VOList = AprvDao.selectAprvDtlPk(GA09N607VO);
				
				if(GA09N607VOList != null && GA09N607VOList.size() > 0 ) {
					ObjectCopyUtil.copyFields(GA09N607VOList.get(0), GA09N607VO);

					//log.info("결재상세정보조회(PK) getAprvRtrnTcd()=======["+GA09N607VO.getAprvRtrnTcd() +"]");					
					
					if(GA09N607VO.getAprvRtrnTcd() !=null && !GA09N607VO.getAprvRtrnTcd().equals("") ) {
			            throw new CustomBadRequestException("이미 결재처리된 내역입니다. 결재정보를 확인하세요["+GA09N607VO.getAprvWrrptMtNo()+"]["+GA09N607VO.getAprvWrrptOrzCd()+"]["+GA09N607VO.getAprvRnk()+"]["+GA09N607VO.getAprvDlRnk()+"]==>["+GA09N607VO.getAprvRtrnTcd()+"]", ErrorCode.BAD_REQUEST);		
					}
				}
			}
		}

		// 결재처리
		{
			ObjectCopyUtil.copyFields(vo, GA09N607Pu01InVO);
			cnt = AprvDao.updateGA09N607Aprv(GA09N607Pu01InVO);
			
			if(cnt > 0) {
				// 2:반려
				if(vo.getAprvRtrnTcd().equals(CD_APRV_RTRN_TCD_RTRN)) {		
					GA09N606Pu01InVO.setAprvWrrptMtNo(GA09N607Pu01InVO.getAprvWrrptMtNo());										
					GA09N606Pu01InVO.setAprvWrrptOrzCd(GA09N607Pu01InVO.getAprvWrrptOrzCd());
					GA09N606Pu01InVO.setAprvScd(CD_APRV_SCD_RTRN);
					
					dCnt = AprvDao.updateGA09N606Aprv(GA09N606Pu01InVO);
					
					if(cnt == 0) {
			            throw new CustomBadRequestException("결재대상건(마스터)이 없습니다 결재상신번호를 확인하세요["+vo.getAprvWrrptMtNo()+"]["+vo.getAprvWrrptOrzCd()+"]", ErrorCode.BAD_REQUEST);		
					}
					bizPrcYn = true; // 업무 후처리					
				
				}
				
				// 다음결재정보 조회
				ObjectCopyUtil.copyFields(GA09N607Pu01InVO, GA09N607VO);				
				GA09N607VOList = AprvDao.selectAprvNext(GA09N607VO);
				
				if(GA09N607VOList == null || GA09N607VOList.size() == 0 ) {
					// 다음 결재건없음 => 완료처리
					
					GA09N606Pu01InVO.setAprvWrrptMtNo(GA09N607Pu01InVO.getAprvWrrptMtNo());										
					GA09N606Pu01InVO.setAprvWrrptOrzCd(GA09N607Pu01InVO.getAprvWrrptOrzCd());
					GA09N606Pu01InVO.setAprvScd(CD_APRV_SCD_APV); // 승인완료
					
					dCnt = AprvDao.updateGA09N606Aprv(GA09N606Pu01InVO);
					
					if(cnt == 0) {
			            throw new CustomBadRequestException("결재대상건(마스터)이 없습니다 결재상신번호를 확인하세요["+vo.getAprvWrrptMtNo()+"]["+vo.getAprvWrrptOrzCd()+"]", ErrorCode.BAD_REQUEST);		
					}
					
					bizPrcYn = true; // 업무 후처리
					
					
				}else {
					ObjectCopyUtil.copyFields(GA09N607VOList.get(0), GA09N607VO);
					
					log.info("next 결재정보 =======["+GA09N607VO +"]");

					// 다음결재정보 참조
					if(GA09N607VO.getDcfcPcd().equals(CD_DCFC_PCD_REF)) {
						GA09N607Pu01InVO.setAprvWrrptMtNo(GA09N607VO.getAprvWrrptMtNo());
						GA09N607Pu01InVO.setAprvWrrptOrzCd(GA09N607VO.getAprvWrrptOrzCd());
						GA09N607Pu01InVO.setAprvRnk(GA09N607VO.getAprvRnk());
						GA09N607Pu01InVO.setAprvDlRnk(GA09N607VO.getAprvDlRnk());
						GA09N607Pu01InVO.setAprvEpno(GA09N607VO.getAprvEpno());
						
						cnt = AprvDao.updateGA09N607Aprv(GA09N607Pu01InVO);
					}
				}				
				
				
			}else {
	            throw new CustomBadRequestException("결재대상건이 없습니다 결재상신번호를 확인하세요["+vo.getAprvWrrptMtNo()+"]["+vo.getAprvWrrptOrzCd()+"]", ErrorCode.BAD_REQUEST);		
			}
		}
		
		
		// 후처리(업무반영) 
		if(bizPrcYn){
			// 01:렌탈신청
			if(APRV_PCD.equals(CD_APRV_PCD_RENT)) {
				RQRR1000U0VO RQRR1000U0VO = new RQRR1000U0VO();
				
				// 2:반려
				if(APRV_RTRN_TCD.equals(CD_APRV_RTRN_TCD_RTRN)) {
					/* 렌탈신청(임대신청) 신청상태변경 */
					RQRR1000U0VO.setRctNo(vo.getRctNo());
					RQRR1000U0VO.setRqsScd(CD_RQS_SCD_RTRN);
					
//					RQRR1000U0VO.setOptrId("000000");
//					RQRR1000U0VO.setOprtChnlCd("000");
//					RQRR1000U0VO.setOprtOrzCd("000000");
//					RQRR1000U0VO.setOprtIpAdr("000000");	
					
					dCnt = RQRR1000U0Dao.updateRqsScd(RQRR1000U0VO);		
					
					if(dCnt == 0) {
			            throw new CustomBadRequestException("접수번호가 존재하지않습니다. 접수번호를 확인하세요["+vo.getRctNo()+"]", ErrorCode.BAD_REQUEST);		
					}
					
				// 1:접수승인 -> 승인완료처리
				}else if(APRV_RTRN_TCD.equals(CD_APRV_RTRN_TCD_RCT)) {
					
					/* 렌탈신청(임대신청) 신청상태변경 */
					RQRR1000U0VO.setRctNo(vo.getRctNo());
					RQRR1000U0VO.setRqsScd(CD_RQS_SCD_APV_CMPN);
					
//					RQRR1000U0VO.setOptrId("000000");
//					RQRR1000U0VO.setOprtChnlCd("000");
//					RQRR1000U0VO.setOprtOrzCd("000000");
//					RQRR1000U0VO.setOprtIpAdr("000000");	
					
					dCnt = RQRR1000U0Dao.updateRqsScd(RQRR1000U0VO);		
					
					if(dCnt == 0) {
			            throw new CustomBadRequestException("접수번호가 존재하지않습니다. 접수번호를 확인하세요["+vo.getRctNo()+"]", ErrorCode.BAD_REQUEST);		
					}					
				}
			}
		}
		
		return cnt;
	}
	
	/* 승인 처리 - 다건 */	
	@Override
	public int updateAprvList(Aprv00In01VO vo) {
		int cnt = 0;
		int mCnt = 0;
		
	    String aprvEpno ; /* 결재자사원번호 */
		GA09N607VO GA09N607VO = new GA09N607VO();
		List<GA09N607VO> GA09N607VOList = null;
	    
	    aprvEpno = vo.getAprvEpno();
	    List<Aprv00In11VO> grid11 = vo.getGrid11();    // 결제대상내역
	    Aprv00In11VO datavo = null;
	    		
		if(grid11 == null || grid11.size() == 0 ) {
            throw new CustomBadRequestException("결재대상 내역이 없습니다.", ErrorCode.BAD_REQUEST);					
		}		
		
		GA09N607Pu01InVO GA09N607Pu01InVO = new GA09N607Pu01InVO();
		
		for( int i = 0;i<grid11.size();i++) {
			datavo = grid11.get(i);
			
			log.info("datavo  ============"+datavo);
			mCnt++;
			
			{ /* 렌탈신청 제품등록 */
				
				// 결재상세 등록정보 체크
				{
					// 결재상세정보 조회(PK)
					ObjectCopyUtil.copyFields(datavo, GA09N607VO);				
					GA09N607VOList = AprvDao.selectAprvDtlPk(GA09N607VO);
					
					if(GA09N607VOList != null && GA09N607VOList.size() > 0 ) {
						ObjectCopyUtil.copyFields(GA09N607VOList.get(0), GA09N607VO);

						//log.info("결재상세정보조회(PK) getAprvRtrnTcd()=======["+GA09N607VO.getAprvRtrnTcd() +"]");					
						
						if(GA09N607VO.getAprvRtrnTcd() !=null && !GA09N607VO.getAprvRtrnTcd().equals("") ) {
				            throw new CustomBadRequestException("이미 결재처리된 내역입니다. 결재정보를 확인하세요["+GA09N607VO.getAprvWrrptMtNo()+"]["+GA09N607VO.getAprvWrrptOrzCd()+"]["+GA09N607VO.getAprvRnk()+"]["+GA09N607VO.getAprvDlRnk()+"]==>["+GA09N607VO.getAprvRtrnTcd()+"]", ErrorCode.BAD_REQUEST);		
						}
					}else {
			            throw new CustomBadRequestException("결재대상이 존재하지않습니다. 결재정보를 확인하세요["+GA09N607VO.getAprvWrrptMtNo()+"]["+GA09N607VO.getAprvWrrptOrzCd()+"]["+GA09N607VO.getAprvRnk()+"]["+GA09N607VO.getAprvDlRnk()+"]", ErrorCode.BAD_REQUEST);		
					}
				}
				
				ObjectCopyUtil.copyFields(datavo, GA09N607Pu01InVO);
				GA09N607Pu01InVO.setAprvRtrnTcd("1");
				GA09N607Pu01InVO.setSbapYn("0");
				GA09N607Pu01InVO.setAprvEpno(aprvEpno);
				
				cnt = AprvDao.updateGA09N607Aprv(GA09N607Pu01InVO);
				log.info("cnt  ============"+cnt);
				if(cnt == 0) {
		            throw new CustomBadRequestException("결재처리 대상이 맞지않습니다. 결재대상정보를 확인하세요["+GA09N607Pu01InVO.getAprvWrrptMtNo()+"]["+GA09N607Pu01InVO.getAprvWrrptOrzCd()+"]["+GA09N607Pu01InVO.getAprvRnk()+"]["+GA09N607Pu01InVO.getAprvDlRnk()+"]", ErrorCode.BAD_REQUEST);		
				}					
			}			
		}					

		log.info("mCnt  ============"+mCnt);

		return mCnt;
	}
	

}
