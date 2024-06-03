package com.miraeasset.biz.ga.em.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.meta.vo.GA01N301VO;
import com.miraeasset.biz.common.meta.vo.GA01N302VO;
import com.miraeasset.biz.common.util.CryptoUtil;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out01VO;
import com.miraeasset.biz.ga.em.dao.GAEM1000U0Dao;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In00VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In01VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In02VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In03VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In10VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In11VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In12VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In13VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In14VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out00VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out01VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out10VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out11VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out12VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out01VO;

@Service
@Transactional
public class GAEM1000U0ServiceImpl implements GAEM1000U0Service {

	@Autowired
	GAEM1000U0Dao GAEM1000U0Dao;

	
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
	
	/* 거래처 팝업 조회 */	
	@Override
	public List<GAEM1000U0Out10VO> selectAT05C010(GAEM1000U0In10VO vo) {
		return GAEM1000U0Dao.selectAT05C010(vo);
	}	

	/* 업체관리 목록조회 */	
	@Override
	public List<GAEM1000U0Out00VO> selectListGA01N301(GAEM1000U0In00VO vo) {
		return GAEM1000U0Dao.selectListGA01N301(vo);
	}	
	
	/* 업체관리 업체계약현황조회  */	
	@Override
	public List<GAEM1000U0Out11VO> selLstGA01N301ByDelpCd(GAEM1000U0In11VO vo) {
		return GAEM1000U0Dao.selLstGA01N301ByDelpCd(vo);
	}	
		
	/* 업체관리 상세조회(PK) */	
	@Override
	public List<GAEM1000U0Out01VO> selectGA01N301PK(GAEM1000U0In01VO vo) {
		
		// 전처리 : 입력값 체크
		{
			if(vo.getDelpCd() == null || vo.getDelpCd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[거래처코드] 오류. 입력값을 확인하세요["+vo.getDelpCd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getBztpTcd() == null || vo.getBztpTcd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[업종구분코드] 오류. 입력값을 확인하세요["+vo.getBztpTcd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getBztpDlTcd() == null || vo.getBztpDlTcd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[업종상세구분코드] 오류. 입력값을 확인하세요["+vo.getBztpDlTcd()+"]", ErrorCode.BAD_REQUEST);		
			}
		}

		return GAEM1000U0Dao.selectGA01N301PK(vo);
	}	
	
	/* 업체관리 업체메모 내역조회 */	
	@Override
	public List<GAEM1000U0Out12VO> selectMemoInfo(GAEM1000U0In12VO vo) {
		
		int cnt = 0;
		BigDecimal alCnt = new BigDecimal("0");
		GA01N302VO GA01N302VO = new GA01N302VO();
	    List<GA01N302VO> dataOutList = null;      // 계약서별기안문서 

	    GAEM1000U0Out12VO outVo = new GAEM1000U0Out12VO();
		List<GAEM1000U0Out12VO> outList = new ArrayList<GAEM1000U0Out12VO>();

		GAEM1000U0In10VO GAEM1000U0In10VO = new GAEM1000U0In10VO();
		GAEM1000U0Out10VO dataOutVo = null;
		List<GAEM1000U0Out10VO> dataOutList2 = null;
		
		// 전처리 : 입력값 체크
		{
			if(vo.getDelpCd() == null || vo.getDelpCd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[거래처코드] 오류. 입력값을 확인하세요["+vo.getDelpCd()+"]", ErrorCode.BAD_REQUEST);		
			}
		}
		
		// 업체멸 메모내역 세팅
		{
			
			ObjectCopyUtil.copyFields(vo, GA01N302VO);			
			dataOutList = GAEM1000U0Dao.selLstGA01N302ByDelpCd(GA01N302VO);
			
			// 메모 내역세팅 
			if(dataOutList != null && dataOutList.size() > 0) {
				alCnt = new BigDecimal(dataOutList.size());
				outVo.setGridGA01N302(dataOutList);
			}
		}
		
		// 업체정보세팅
		{
			//ObjectCopyUtil.copyFields(vo, GAEM1000U0In10VO);	
			GAEM1000U0In10VO.setDelpCd(vo.getDelpCd());
			dataOutList2 = GAEM1000U0Dao.selectAT05C010(GAEM1000U0In10VO);
			
			// 업체정보 세팅
			if(dataOutList2 != null && dataOutList2.size() > 0) {
				dataOutVo = dataOutList2.get(0);
				ObjectCopyUtil.copyFields(dataOutVo, outVo);
				outVo.setAlCnt(alCnt);
			}
		}	
		
		outList.add(outVo);

		return outList;
	}	
	
	/* 업체관리 수정(PK) */	
	@Override
	public int updateGA01N301(GAEM1000U0In02VO vo) {
		
		int cnt = 0;
		GA01N301VO GA01N301VO = new GA01N301VO();
		GAEM1000U0In01VO GAEM1000U0In01VO = new GAEM1000U0In01VO();
		List<GAEM1000U0Out01VO> outList = null;
		
		// 전처리 : 입력값 체크
		{
			if(vo.getDelpCd() == null || vo.getDelpCd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[거래처코드] 오류. 입력값을 확인하세요["+vo.getDelpCd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getBztpTcd() == null || vo.getBztpTcd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[업종구분코드] 오류. 입력값을 확인하세요["+vo.getBztpTcd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getBztpDlTcd() == null || vo.getBztpDlTcd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[업종상세구분코드] 오류. 입력값을 확인하세요["+vo.getBztpDlTcd()+"]", ErrorCode.BAD_REQUEST);		
			}

			ObjectCopyUtil.copyFields(vo, GAEM1000U0In01VO);
			outList = GAEM1000U0Dao.selectGA01N301PK(GAEM1000U0In01VO);
			
			if(outList != null && outList.size() > 0 ) {
				ObjectCopyUtil.copyFields(outList.get(0), GA01N301VO);
				
				if(GA01N301VO.getDelpCd() == null || GA01N301VO.getDelpCd().equals("") ) {
		            throw new CustomBadRequestException("변경할 대상건이 없습니다2. 입력항목을 확인하세요["+vo.getDelpCd()+"]["+vo.getBztpTcd()+"]["+vo.getBztpDlTcd()+"]", ErrorCode.BAD_REQUEST);		
				}
			}else {
	            throw new CustomBadRequestException("변경할 대상건이 없습니다1. 입력항목을 확인하세요["+vo.getDelpCd()+"]["+vo.getBztpTcd()+"]["+vo.getBztpDlTcd()+"]", ErrorCode.BAD_REQUEST);		
			}			
		}
		
		// 수정처리
		{
			// 데이터 카피
			ObjectCopyUtil.copyFields(vo, GA01N301VO);		
			
			// 암호화값 처리 
			if(!StringUtils.isBlank(GA01N301VO.getChprEmalAdr())){
				log.info("getChprEmalAdr ["+GA01N301VO.getChprEmalAdr()+"]");
				log.info("Enc ["+CryptoUtil.getEncryption(GA01N301VO.getChprEmalAdr())+"]");
				
				GA01N301VO.setChprEmalAdrEcpVl(CryptoUtil.getEncryption(GA01N301VO.getChprEmalAdr()));
				
			}
			if(!StringUtils.isBlank(GA01N301VO.getChprTlno())){
				log.info("getChprTlno ["+GA01N301VO.getChprTlno()+"]");
				log.info("Enc ["+CryptoUtil.getEncryption(GA01N301VO.getChprTlno())+"]");
				
				GA01N301VO.setChprTlnoEcpVl(CryptoUtil.getEncryption(GA01N301VO.getChprTlno()));
			}
			
//			GA01N301VO.setOptrId("000000");
//			GA01N301VO.setOprtChnlCd("000");
//			GA01N301VO.setOprtOrzCd("000000");
//			GA01N301VO.setOprtIpAdr("000000");
			
			cnt = GAEM1000U0Dao.updateGA01N301(GA01N301VO);
			
			if(cnt == 0) {
		        throw new CustomBadRequestException("업체관리정보 수정오류. 입력값을 확인하세요["+vo.getDelpCd()+"]["+vo.getBztpTcd()+"]["+vo.getBztpDlTcd()+"]", ErrorCode.BAD_REQUEST);		
			}			
		}

		return cnt;
	}	

	/* 업체관리 수정(PK) */	
	@Override
	public int deleteGA01N301(GAEM1000U0In02VO vo) {
		
		int cnt = 0;
		GA01N301VO GA01N301VO = new GA01N301VO();
		GAEM1000U0In01VO GAEM1000U0In01VO = new GAEM1000U0In01VO();
		List<GAEM1000U0Out01VO> outList = null;
		
		// 전처리 : 입력값 체크
		{
			if(vo.getDelpCd() == null || vo.getDelpCd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[거래처코드] 오류. 입력값을 확인하세요["+vo.getDelpCd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getBztpTcd() == null || vo.getBztpTcd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[업종구분코드] 오류. 입력값을 확인하세요["+vo.getBztpTcd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getBztpDlTcd() == null || vo.getBztpDlTcd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[업종상세구분코드] 오류. 입력값을 확인하세요["+vo.getBztpDlTcd()+"]", ErrorCode.BAD_REQUEST);		
			}

			ObjectCopyUtil.copyFields(vo, GAEM1000U0In01VO);
			outList = GAEM1000U0Dao.selectGA01N301PK(GAEM1000U0In01VO);
			
			if(outList != null && outList.size() > 0 ) {
				ObjectCopyUtil.copyFields(outList.get(0), GA01N301VO);
				
				if(GA01N301VO.getDelpCd() == null || GA01N301VO.getDelpCd().equals("") ) {
		            throw new CustomBadRequestException("삭제할 대상건이 없습니다2. 입력항목을 확인하세요["+vo.getDelpCd()+"]["+vo.getBztpTcd()+"]["+vo.getBztpDlTcd()+"]", ErrorCode.BAD_REQUEST);		
				}
			}else {
	            throw new CustomBadRequestException("삭제할 대상건이 없습니다1. 입력항목을 확인하세요["+vo.getDelpCd()+"]["+vo.getBztpTcd()+"]["+vo.getBztpDlTcd()+"]", ErrorCode.BAD_REQUEST);		
			}			
		}
		
		// 삭제처리
		{
			// 데이터 카피
			ObjectCopyUtil.copyFields(vo, GA01N301VO);		
			
//			GA01N301VO.setOptrId("000000");
//			GA01N301VO.setOprtChnlCd("000");
//			GA01N301VO.setOprtOrzCd("000000");
//			GA01N301VO.setOprtIpAdr("000000");
			
			cnt = GAEM1000U0Dao.deleteGA01N301(GA01N301VO);
			
			if(cnt == 0) {
		        throw new CustomBadRequestException("업체관리정보 삭제오류. 입력값을 확인하세요["+vo.getDelpCd()+"]["+vo.getBztpTcd()+"]["+vo.getBztpDlTcd()+"]", ErrorCode.BAD_REQUEST);		
			}			
		}

		return cnt;
	}	    
		
	/* 업체관리 업체메모 삭제수정(PK) */	
	@Override
	public int updateDelGA01N302(GAEM1000U0In14VO vo) {
		
		int cnt = 0;
		GA01N302VO GA01N302VO = new GA01N302VO();
		
		// 전처리 : 입력값 체크
		{
			if(vo.getDelpCd() == null || vo.getDelpCd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[거래처코드] 오류. 입력값을 확인하세요["+vo.getDelpCd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getRegiSrno() == null || vo.getRegiSrno().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[업종구분코드] 오류. 입력값을 확인하세요["+vo.getRegiSrno()+"]", ErrorCode.BAD_REQUEST);		
			}

		}
		
		// 삭제 수정처리
		{
			// 데이터 카피
			ObjectCopyUtil.copyFields(vo, GA01N302VO);		
			

			GA01N302VO.setDelYn("1"); // 삭제
//			GA01N302VO.setOptrId("000000");
//			GA01N302VO.setOprtChnlCd("000");
//			GA01N302VO.setOprtOrzCd("000000");
//			GA01N302VO.setOprtIpAdr("000000");
			
			cnt = GAEM1000U0Dao.updateDelGA01N302(GA01N302VO);
			
			if(cnt == 0) {
		        throw new CustomBadRequestException("업체별메모 수정오류. 입력값을 확인하세요["+GA01N302VO.getDelpCd()+"]["+GA01N302VO.getRegiSrno()+"]", ErrorCode.BAD_REQUEST);		
			}			
		}

		return cnt;
	}	    

	
	/* 업체관리 신규등록 */		
	@Override
	public int insertGA01N301(GAEM1000U0In03VO vo) {
		
		int cnt = 0;
		GA01N301VO GA01N301VO = new GA01N301VO();
		GAEM1000U0In01VO GAEM1000U0In01VO = new GAEM1000U0In01VO();
		List<GAEM1000U0Out01VO> outList = null;
		
		GAEM1000U0In10VO GAEM1000U0In10VO = new GAEM1000U0In10VO();
		List<GAEM1000U0Out10VO> outList2 = null;
		
		// 전처리 : 입력값 체크
		{
			if(vo.getDelpCd() == null || vo.getDelpCd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[거래처코드] 오류. 입력값을 확인하세요["+vo.getDelpCd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getBztpTcd() == null || vo.getBztpTcd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[업종구분코드] 오류. 입력값을 확인하세요["+vo.getBztpTcd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getBztpDlTcd() == null || vo.getBztpDlTcd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[업종상세구분코드] 오류. 입력값을 확인하세요["+vo.getBztpDlTcd()+"]", ErrorCode.BAD_REQUEST);		
			}
			
			ObjectCopyUtil.copyFields(vo, GAEM1000U0In01VO);
			outList = GAEM1000U0Dao.selectGA01N301PK(GAEM1000U0In01VO);
			
			if(outList != null && outList.size() > 0 ) {
	            throw new CustomBadRequestException("신규등록할 대상이 이미 존재합니다. 입력항목을 확인하세요["+vo.getDelpCd()+"]["+vo.getBztpTcd()+"]["+vo.getBztpDlTcd()+"]", ErrorCode.BAD_REQUEST);		
			}else {

				// 거래처코드 조회
				GAEM1000U0In10VO.setDelpCd(vo.getDelpCd());
				outList2 = GAEM1000U0Dao.selectAT05C010(GAEM1000U0In10VO);
				
				if(outList2 == null || outList2.size() == 0 ) {
		            throw new CustomBadRequestException("ERP 거래처 내역에 존재하지않는 거래처코드입니다. ERP 거래처관리에서 거래처코드를 확인하세요["+vo.getDelpCd()+"]["+vo.getBztpTcd()+"]["+vo.getBztpDlTcd()+"]", ErrorCode.BAD_REQUEST);		
				}				
			}				
			
		}
		
		// 신규등록처리
		{

			// 데이터 카피
			ObjectCopyUtil.copyFields(vo, GA01N301VO);	
			
			// 암호화값 처리 
			if(!StringUtils.isBlank(GA01N301VO.getChprEmalAdr())){			
				GA01N301VO.setChprEmalAdrEcpVl(CryptoUtil.getEncryption(GA01N301VO.getChprEmalAdr()));
				
			}
			if(!StringUtils.isBlank(GA01N301VO.getChprTlno())){			
				GA01N301VO.setChprTlnoEcpVl(CryptoUtil.getEncryption(GA01N301VO.getChprTlno()));
			}			
			
//			GA01N301VO.setOptrId("000000");
//			GA01N301VO.setOprtChnlCd("000");
//			GA01N301VO.setOprtOrzCd("000000");
//			GA01N301VO.setOprtIpAdr("000000");
			
			cnt = GAEM1000U0Dao.insertGA01N301(GA01N301VO);
			
			if(cnt == 0) {
		        throw new CustomBadRequestException("신규등록 생성오류. 입력값을 확인하세요["+vo.getDelpCd()+"]["+vo.getBztpTcd()+"]["+vo.getBztpDlTcd()+"]", ErrorCode.BAD_REQUEST);		
			}
		}

		return cnt;
	}	
	
	/* 업체관리 업체메모 신규등록 */		
	@Override
	public int insertGA01N302(GAEM1000U0In13VO vo) {
		
		int cnt = 0;
		GA01N302VO GA01N302VO = new GA01N302VO();
		
		String regiDt = DateUtil.getTodayString("yyyyMMdd");		
		
		// 전처리 : 입력값 체크
		{
			if(vo.getDelpCd() == null || vo.getDelpCd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[거래처코드] 오류. 입력값을 확인하세요["+vo.getDelpCd()+"]", ErrorCode.BAD_REQUEST);		
			}
		}
		
		// 신규등록처리
		{
			// 데이터 카피
			ObjectCopyUtil.copyFields(vo, GA01N302VO);	
			
			// 암호화값 처리 
			GA01N302VO.setRegiDt(regiDt);
			GA01N302VO.setDelYn("0");
//			GA01N302VO.setOptrId("000000");
//			GA01N302VO.setOprtChnlCd("000");
//			GA01N302VO.setOprtOrzCd("000000");
//			GA01N302VO.setOprtIpAdr("000000");
			
			cnt = GAEM1000U0Dao.insertGA01N302(GA01N302VO);
			
			if(cnt == 0) {
		        throw new CustomBadRequestException("업체별메모 신규등록 생성오류. 입력값을 확인하세요["+GA01N302VO.getDelpCd()+"]["+GA01N302VO.getRegiSrno()+"]", ErrorCode.BAD_REQUEST);		
			}
		}

		return cnt;
	}	    
	
	
	
}
