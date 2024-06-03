package com.miraeasset.biz.rq.ur.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.aprv.dao.AprvDao;
import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.code.vo.GaCode01In00VO;
import com.miraeasset.biz.common.code.vo.GaCode01Out00VO;
import com.miraeasset.biz.common.code.vo.GaSrno00In00VO;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.meta.vo.AprvWrrptInVO;
import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA01N102VO;
import com.miraeasset.biz.common.meta.vo.GA01N102Vf01InVO;
import com.miraeasset.biz.common.meta.vo.GA01N102Vf01OutVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf01InVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf01OutVO;
import com.miraeasset.biz.common.meta.vo.GA09N606VO;
import com.miraeasset.biz.common.meta.vo.GA09N607InVO;
import com.miraeasset.biz.common.meta.vo.GA09N607VO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.aprvWrrpt.AprvWrrpt;
import com.miraeasset.biz.rq.rr.dao.RQRR1000U0Dao;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0Out03VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;
import com.miraeasset.biz.rq.ur.dao.RQUR1000U0Dao;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0In00VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0In01VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0In02VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0In11VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0OUT02VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0OUT12VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0Out00VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0Out01VO;

@Service
@Transactional
public class RQUR1000U0ServiceImpl implements RQUR1000U0Service {
	
	@Autowired
	RQUR1000U0Dao RQUR1000U0Dao;

	@Autowired
	RQRR1000U0Dao RQRR1000U0Dao;

	@Autowired
	CodeDao CodeDao;

	@Autowired
	AprvDao AprvDao;
	
	@Autowired
	AprvWrrpt aprvWrrpt;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());	
	
	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "00"; // 임시저장 
//	private final String CD_RQS_SCD_APV_REDY = "01"; // 승인대기 
	private final String CD_RQS_SCD_APV_ING  = "05"; // 승인중 
	private final String CD_RQS_SCD_APV_CMPN = "10"; // 승인완료 
	private final String CD_RQS_SCD_RTRN     = "15"; // 반려 
	private final String CD_RQS_SCD_EMAL     = "20"; // 메일전송완료
	private final String CD_RQS_SCD_WDRAL    = "25"; // 철회
	private final String CD_RQS_SCD_CMPN     = "99"; // 완료
	
	private final String APRV_SCD_01 = "01"; //접수
	private final String APRV_SCD_02 = "02"; //결재중
	private final String APRV_SCD_03 = "03"; //반려
	private final String APRV_SCD_04 = "04"; //승인
	
	private final String APRV_PCD_01 = "01"; //공사신청
	private final String APRV_PCD_02 = "02"; //구매신청
	private final String APRV_PCD_03 = "03"; //렌탈신청
	private final String APRV_PCD_04 = "04"; //명함신청
	private final String APRV_PCD_05 = "05"; //인감신청
	private final String APRV_PCD_06 = "06"; //인장신청
	private final String APRV_PCD_09 = "09"; //문서신청
	private final String APRV_PCD_91 = "91"; //사용자그룹
	private final String APRV_PCD_92 = "91"; //화면권한

	
	/* RQS_EQMT_TCD 코드값 정의 */
	private final String RQS_EQMT_TCD_ITG   = "01"; // 정수기 	
	private final String RQS_EQMT_TCD_MFP   = "02"; // 복합기 	

	
	/* RQS_EQMT_TCD 코드값 정의 */
	private final String UNIF_RQS_DL_PCD_ITG   = "0331"; // 정수기외	
	private final String UNIF_RQS_DL_PCD_MFP   = "0332"; // 복합기 	

	/* 렌탈신청(임대신청) 조회(PK)  */
	@Override
	public List<RQUR1000U0Out00VO> selectGA01N003(RQUR1000U0In02VO vo) {
		// TODO Auto-generated method stub
		GA01N101VO GA01N101VO = new GA01N101VO();
		List<GA01N101VO> GA01N101VOList = null;
		
		RQUR1000U0Out00VO outvo = null;
		List<RQUR1000U0Out00VO> listOutVo = (List<RQUR1000U0Out00VO>) new ArrayList();		
		
		ObjectCopyUtil.copyFields(vo, GA01N101VO);

		GA01N101VOList = RQRR1000U0Dao.selectGA01N101(GA01N101VO);
		
		if(GA01N101VOList != null && GA01N101VOList.size() > 0 ) {
			GA01N101VO = GA01N101VOList.get(0);
			outvo = new RQUR1000U0Out00VO();
			ObjectCopyUtil.copyFields(GA01N101VO, outvo);
			listOutVo.add(outvo);
		}
		
		return listOutVo;
	}
	

	/* 렌탈신청상세목록 조회 */
	@Override
	public List<RQRR1000U0VO> selectListRentRqsDtl(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		return RQRR1000U0Dao.selectListRentRqsDtl(vo);
	}	
	
	/* 렌탈신청상세목록 조회 */
	@Override
	public List<RQUR1000U0Out01VO> selectListRentRqsDtl(RQUR1000U0In00VO inVo) {
		// TODO Auto-generated method stub
		// 변수선언 
		GA01N102Vf01InVO datainvo = new GA01N102Vf01InVO();
		GA01N102Vf01OutVO dataoutvo = new GA01N102Vf01OutVO();
		
		RQUR1000U0Out01VO outVo = null;
		List<GA01N102Vf01OutVO> dataList = null;
		List<RQUR1000U0Out01VO> outListVo = (List<RQUR1000U0Out01VO>) new ArrayList();

		// 전처리 : Invo -> vo 카피
		{  
			ObjectCopyUtil.copyFields(inVo, datainvo);
		}

		dataList = RQRR1000U0Dao.selectListRentRqsDtl(datainvo);
		
		// 후처리 : dataList -> outList 카피
		{  
			
			if(dataList != null && dataList.size() > 0 ) {
				
				for(int i=0;i<dataList.size() ;i++) {
					dataoutvo = dataList.get(i);
					//log.info("list ["+i+"] ============["+vo.getRctNo()+"]["+vo.getRctDlNo()+"]");
					outVo = new RQUR1000U0Out01VO();
					ObjectCopyUtil.copyFields(dataoutvo, outVo);
					//log.info("outVo ["+i+"] ============["+outVo.getRctNo()+"]["+outVo.getRctDlNo()+"]");
					outListVo.add(outVo);
				}
			}
		}
		
		return outListVo;

	}		
	

	/* 렌탈신청 임시저장/상신 */
	@Override
	public String reqRegi(RQUR1000U0In01VO vo) {
		// TODO Auto-generated method stub
		
		// 렌탈신청
		GA01N101VO GA01N101VO = new GA01N101VO();
		List<GA01N101VO> GA01N101VOlist = null;
		
		//GA01N004VO GA01N004VO = new GA01N004VO();
		GA01N102VO GA01N102VO = new GA01N102VO();
		
		// 결재정보
		GA09N606VO GA09N606VO = new GA09N606VO();
		GA09N607VO GA09N607VO = new GA09N607VO();
		
		// 채번정보
		GaCode01In00VO codeinvo = new GaCode01In00VO();
		GaCode01Out00VO codeoutvo = null;
		List<GaCode01Out00VO> codelistvo = null;

		int mCnt = 0;
		int dCnt = 0;
		String prcTp = "";
		boolean bfRegiYn = false; /* 기등록 여부 : false-신규등록 true-대상update */
		
		List<RQUR1000U0In11VO> listvo = vo.getGrid12();		
		RQUR1000U0In11VO datavo = null;
		String newRctNo = "0";	
		String newApprtNo = "";
		
		String rctNo      = ""; // 접수번호 key
		String rqsDt      = ""; // 신청일자 key
		String rqsOrzCd   = ""; // 신청조직코드
		String rqsEpno    = ""; // 신청사원번호
		String rqsScd     = ""; // 신청상태코드
		String unifRqsTcd     = ""; /*신청구분코드 신규/이전/as    */
		String unifRqsPcd     = ""; /*신청유형코드 공사/구매/렌탈/     */
		
//		String unifRqsDlPcd  = UNIF_RQS_DL_PCD_ITG    ; /*신청상세유형코드  01:정수기외 02:복합기 */
		
		String unifRqsDlPcd   = ""; /*신청상세유형코드  01:정수기외 02:복합기 */
		String istPlcNm   = ""; /*설치장소명       */
		String rqsRsnCn   = ""; /*신청사유내용  */
		String rqsTtlNm   = ""; /*신청제목명 */
		String hopeDt     = ""; /*희망일자         */
		
		String scrnNo = "RQRR1000m0"; //화면번호


		RQRR1000U0VO chkvo = new RQRR1000U0VO();

		// 입력값 체크
		{

			rctNo = vo.getRctNo();
			if(rctNo != null && !rctNo.equals("") && rctNo.length() > 8) {
				rqsDt = rctNo.substring(0,8);
			}else {
				rqsDt = DateUtil.getTodayString("yyyyMMdd");
			}
			rqsOrzCd = vo.getRqsOrzCd();
			rqsEpno = vo.getRqsEpno();
			prcTp = vo.getPrcTp();
			rqsScd = vo.getRqsScd();
			unifRqsPcd = vo.getUnifRqsPcd();
			unifRqsDlPcd = vo.getUnifRqsDlPcd();
			unifRqsTcd = vo.getUnifRqsTcd();
			rqsRsnCn = vo.getRqsRsnCn();
			hopeDt = vo.getHopeDt();
			rqsTtlNm = vo.getRqsTtlNm();
			
			if(rctNo !=null && !rctNo.equals("")) {
				bfRegiYn = true; // 기등록 데이터 -> update 처리
			}
			
			// 필수항목 체크
			{
				// 신청유형 신규/이전/AS/해지
				if(vo.getUnifRqsTcd() == null || vo.getUnifRqsTcd().equals("")) {
		            throw new CustomBadRequestException("[필수항목 체크] 신청구분이 입력되지않았습니다.", ErrorCode.BAD_REQUEST);					
				}
				// 신청유형 공사/구매/렌탈
				if(vo.getUnifRqsPcd() == null || vo.getUnifRqsPcd().equals("")) {
		            throw new CustomBadRequestException("[필수항목 체크] 신청유형이 입력되지않았습니다.", ErrorCode.BAD_REQUEST);					
				}
				// 신청사원번호
				if(vo.getRqsEpno() == null || vo.getRqsEpno().equals("")) {
		            throw new CustomBadRequestException("[필수항목 체크] 신청사원번호 입력되지않았습니다.", ErrorCode.BAD_REQUEST);					
				}
				// 신청조직코드
				if(vo.getRqsOrzCd() == null || vo.getRqsOrzCd().equals("")) {
		            throw new CustomBadRequestException("[필수항목 체크] 신청조직코드 입력되지않았습니다.", ErrorCode.BAD_REQUEST);					
				}
				// 신청장소
				/*
				if(vo.getIstPlcNm() == null || vo.getIstPlcNm().equals("")) {
		            throw new CustomBadRequestException("[필수항목 체크] 신청장소가 입력되지않았습니다.", ErrorCode.BAD_REQUEST);					
				}
				*/
				// 희망일자
//				if(vo.getHopeDt() == null || vo.getHopeDt().equals("")) {
//		            throw new CustomBadRequestException("[필수항목 체크] 희망일자가 입력되지않았습니다.", ErrorCode.BAD_REQUEST);					
//				}
				
				// 제품정보
				if(listvo == null || listvo.size() == 0 ) {
		            throw new CustomBadRequestException("렌탈신청 제품대상정보가 존재하지않습니다. 입력된 제품정보를 확인하세요", ErrorCode.BAD_REQUEST);					
				}	
								
			}
		}
		
		{ /* 렌탈신청 신청정보등록 */
			
			ObjectCopyUtil.copyFields(vo, GA01N101VO);
			
			// 기등록건 조회
			if(bfRegiYn)
			{
				GA01N101VOlist = RQRR1000U0Dao.selectGA01N101(GA01N101VO);
				if(GA01N101VOlist == null || GA01N101VOlist.size() == 0 ) {
					throw new CustomBadRequestException("렌탈신청 정보가 존재하지않습니다. 접수번호를 확인하세요["+GA01N101VO.getRctNo()+"]", ErrorCode.BAD_REQUEST);								
				}else {
					ObjectCopyUtil.copyFields(GA01N101VOlist.get(0), GA01N101VO);
					
					if(!GA01N101VO.getUnifRqsPcd().equals(unifRqsPcd)) {
						throw new CustomBadRequestException("기등록된 렌탈신청 신청정보의 신청유형이 입력값과 상이합니다. 입력항목을 확인하세요 ["+GA01N101VO.getUnifRqsPcd()+"] 입력["+unifRqsPcd+"]", ErrorCode.BAD_REQUEST);								
					}
					
					if(!GA01N101VO.getRqsScd().equals(CD_RQS_SCD_TMP_STRG)) {
						throw new CustomBadRequestException("기등록된 렌탈신청 신청상태가 임시저장상태가 아닙니다. 신청상태를 확인하세요 ["+GA01N101VO.getRqsScd()+"]", ErrorCode.BAD_REQUEST);								
					}
				}				
				
			}
			
			if ( prcTp.equals("00")) { // 입시저장
				GA01N101VO.setRqsScd(CD_RQS_SCD_TMP_STRG);
				rqsScd = CD_RQS_SCD_TMP_STRG;
			}else if(prcTp.equals("01")) { // 상신
				GA01N101VO.setRqsScd(CD_RQS_SCD_APV_ING);
				rqsScd = CD_RQS_SCD_APV_ING;
			}else {
				throw new CustomBadRequestException("처리구분 값을 확인하세요 00/01 만 입력가능합니다. ["+prcTp+"]", ErrorCode.BAD_REQUEST);								
			}
			log.info("처리구분값 prcTp ============"+prcTp);
			
			// 신규접수번호 채번
			if(!bfRegiYn){ 
				GaSrno00In00VO rctVo = new GaSrno00In00VO();
				rctVo.setCdKndNo("CHAEBUN");
				rctVo.setCmnCdVl(unifRqsPcd);
				rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
				newRctNo = rctVo.getRpbzGnoSrno();
			}
			
			GA01N101VO = new GA01N101VO();

			// 렌탈신청 데이터 세팅
			{
				// 기등록건 수정
				if(bfRegiYn) {
					newRctNo = rctNo;
				}
				
				GA01N101VO.setRctNo(newRctNo);
				GA01N101VO.setRqsScd(rqsScd);
				GA01N101VO.setRqsEpno(rqsEpno);
				GA01N101VO.setRqsOrzCd(rqsOrzCd);
				GA01N101VO.setUnifRqsPcd(unifRqsPcd);
				GA01N101VO.setUnifRqsTcd(unifRqsTcd);
				GA01N101VO.setUnifRqsDlPcd(unifRqsDlPcd);
				GA01N101VO.setHopeDt(hopeDt);
				GA01N101VO.setRqsRsnCn(rqsRsnCn);
				GA01N101VO.setRqsDt(rqsDt);
				GA01N101VO.setRqsTtlNm(rqsTtlNm);
				// 결재선 생성후 
				GA01N101VO.setAprvWrrptMtNo(newApprtNo);			
			}
			
			// 기등록건 수정
			if(bfRegiYn) {
				
				log.info("상신자정보["+rqsOrzCd+"]["+rqsEpno+"]" );
				
				mCnt = RQUR1000U0Dao.updateGA01N003(GA01N101VO);
				
				if(mCnt > 0 ) {
					// 기등록 렌탈신청정보 삭제
					GA01N102VO.setRctNo(rctNo);
					GA01N102VO.setRqsDt(rqsDt);
					dCnt = RQRR1000U0Dao.deleteGA01N004WithRctNo(GA01N102VO);
					
					if(dCnt>0) {
						String rctDlNo = "0";
						for( int i = 0;i<listvo.size();i++) {
							datavo = listvo.get(i);
							chkvo.setRctNo(datavo.getRctNo());
							log.info("datavo  ============"+datavo);
							
							rctDlNo = (i + 1) + "";
							
							{ /* 렌탈신청 제품등록 */
								
								GA01N102VO = new GA01N102VO();
								ObjectCopyUtil.copyFields(datavo, GA01N102VO);
								GA01N102VO.setRqsDt(rqsDt);
								GA01N102VO.setRctNo(newRctNo);
								GA01N102VO.setRctDlNo(rctDlNo);
								
								dCnt = RQUR1000U0Dao.insertGA01N004(GA01N102VO);
								log.info("dCnt  ============"+dCnt);
							}			
						}							
					}
					
				}else {
					throw new CustomBadRequestException("렌탈신청정보를 등록하지 못했습니다. 신청정보를 확인하세요", ErrorCode.BAD_REQUEST);								
				}
				
			// 신규 등록
			}else{
				
				log.info("상신자정보["+rqsOrzCd+"]["+rqsEpno+"]" );
				
				mCnt = RQUR1000U0Dao.insertGA01N003(GA01N101VO);
				
				if(mCnt > 0 ) {
					String rctDlNo = "0";
					for( int i = 0;i<listvo.size();i++) {
						datavo = listvo.get(i);
						chkvo.setRctNo(datavo.getRctNo());
						log.info("datavo  ============"+datavo);
						
						rctDlNo = (i + 1) + "";
						
						{ /* 렌탈신청 제품등록 */
							
							ObjectCopyUtil.copyFields(datavo, GA01N102VO);
							GA01N102VO.setRqsDt(rqsDt);
							GA01N102VO.setRctNo(newRctNo);
							GA01N102VO.setRctDlNo(rctDlNo);
							
							dCnt = RQUR1000U0Dao.insertGA01N004(GA01N102VO);
							log.info("dCnt  ============"+dCnt);
						}			
					}	
					
				}else {
					throw new CustomBadRequestException("렌탈신청정보를 등록하지 못했습니다. 신청정보를 확인하세요", ErrorCode.BAD_REQUEST);								
				}
				
				
			}
		}
		
		// 상신 결재 등록
		{
			List<AprvWrrptInVO> aprvlList =  vo.getAprvl();
			GA09N607InVO aprvVo = new GA09N607InVO();
			aprvVo.setRctNo(newRctNo);
			aprvVo.setAprvl(aprvlList);
			aprvWrrpt.aprvWrrpt(aprvVo);
		}
		
		return newRctNo;
	}		
	
	
	/* 렌탈신청 상세조회*/
	@Override
	public RQUR1000U0OUT02VO selInfo(RQUR1000U0In02VO inVo) {
		// TODO Auto-generated method stub
		
		RQUR1000U0OUT02VO outVo             = new RQUR1000U0OUT02VO();
		List<RQUR1000U0OUT12VO> outGridUr12 = (List<RQUR1000U0OUT12VO>) new ArrayList();
		RQUR1000U0OUT12VO outUr12           = new RQUR1000U0OUT12VO();
		
		// 변수선언 
		RQRR1000U0VO vo = new RQRR1000U0VO();
		List<RQRR1000U0VO> voList = null;
		
		// 전처리 : Invo -> vo 카피
		{  
			ObjectCopyUtil.copyFields(inVo, vo);
			log.info("selInfo rctNo  ============"+vo.getRctNo());
		}
		
		// 렌탈신청 정보조회(master)
		{
			voList = RQRR1000U0Dao.selectGA01N101(vo);
			
			if(voList == null || voList.size() == 0 ) {
				throw new CustomBadRequestException("렌탈신청 정보가 존재하지않습니다. 접수번호를 확인하세요["+vo.getRctNo()+"]", ErrorCode.BAD_REQUEST);								
			}else {
				ObjectCopyUtil.copyFields(voList.get(0), outVo);
				log.info("voList getEqmtTcd  ============"+voList.get(0).getEqmtTcd());				
				log.info("voList getCmpnDt  ============"+voList.get(0).getCmpnDt());				
			}
		}
		
		// 렌탈신청 제폼목록조회(detail)
		{
			voList = RQRR1000U0Dao.selectListRentRqsDtl(vo);
			
			// 각 필의에 대해 값을 복사합니다.
			for( RQRR1000U0VO avo : voList ) {
				outUr12 = new RQUR1000U0OUT12VO();
				ObjectCopyUtil.copyFields(avo, outUr12);
				outGridUr12.add(outUr12);
			}	
			
			log.info("outGridUr12 size  ============"+outGridUr12.size());
			
			outVo.setGridUr12(outGridUr12);
		}
		

		return outVo;
	}
	
	/* 렌탈신청 제폼목록조회(detail)*/
	@Override
	public List<RQUR1000U0OUT12VO> selectListRentRqsDtl(RQUR1000U0In02VO inVo) {	

		RQRR1000U0VO vo = new RQRR1000U0VO();
		
		ObjectCopyUtil.copyFields(inVo, vo);
			
		List<RQRR1000U0VO> voList = RQRR1000U0Dao.selectListRentRqsDtl(vo);
		RQUR1000U0OUT12VO outUr12=null;
		List<RQUR1000U0OUT12VO> rtnList = new ArrayList<RQUR1000U0OUT12VO>();
		
		// 각 필의에 대해 값을 복사합니다.
		for( RQRR1000U0VO avo : voList ) {
			outUr12 = new RQUR1000U0OUT12VO();
			ObjectCopyUtil.copyFields(avo, outUr12);
			rtnList.add(outUr12);
		}	
		return rtnList;
	}
}
