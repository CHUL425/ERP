package com.miraeasset.biz.ga.sm.service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.code.vo.GaCode01In00VO;
import com.miraeasset.biz.common.code.vo.GaCode01Out00VO;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.meta.vo.AT09N401VO;
import com.miraeasset.biz.common.meta.vo.GA01N305VO;
import com.miraeasset.biz.common.meta.vo.GA01N306VO;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.ga.cm.dao.GACM1000U0Dao;
import com.miraeasset.biz.ga.em.dao.GAEM1000U0Dao;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In10VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out10VO;
import com.miraeasset.biz.ga.sm.dao.GASM1000U0Dao;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In00VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In01VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In02VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In03VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In04VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In11VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out00VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out01VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out02VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out11VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out12VO;

@Service
@Transactional
public class GASM1000U0ServiceImpl implements GASM1000U0Service {

	@Autowired
	GASM1000U0Dao GASM1000U0Dao;
	
	@Autowired
	GAEM1000U0Dao GAEM1000U0Dao;
	
	@Autowired
	GACM1000U0Dao GACM1000U0Dao;	
	
	@Autowired
	CodeDao CodeDao;	
			
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/* CNRT_KCD 코드값 정의 */
	private final String CD_CNRT_KCD_CM  = "01"; // 계약서관리 
	private final String CD_CNRT_KCD_SM  = "02"; // ESG(RE100) 
	
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
	
	/* RE100 계약관리 목록조회 */	
	@Override
	public List<GASM1000U0Out00VO> selectListGA01N305(GASM1000U0In00VO vo) {
		return GASM1000U0Dao.selectListGA01N305(vo);
	}	
		
	/* RE100 상세정보조회(PK) */	
	@Override
	public List<GASM1000U0Out01VO> selectGA01N305PK(GASM1000U0In01VO vo) {
		
		GASM1000U0Out01VO outVo = null;
		List<GASM1000U0Out01VO> dataListVo = null;
		List<GASM1000U0Out01VO> outListVo = new ArrayList<GASM1000U0Out01VO>();		
		
		GA01N306VO GA01N306VO = null;
	    List<GA01N306VO> gridGA01N306 = null;    // 기안문서 다건내역		
	    
	    dataListVo = GASM1000U0Dao.selectGA01N305PK(vo);

	    // 입력건 확인
	    if(dataListVo == null || dataListVo.size() == 0) {
	        throw new CustomBadRequestException("대상건이 없습니다. 입력항목을 확인하세요["+vo.getCnrtMtNo()+"]", ErrorCode.BAD_REQUEST);		
	    }else {
		    outVo = dataListVo.get(0);
		    
		    // 기안문서 다건 세팅
		    {
			    GA01N306VO = new GA01N306VO();
			    GA01N306VO.setCnrtMtNo(outVo.getCnrtMtNo());
			    GA01N306VO.setCnrtKcd(CD_CNRT_KCD_SM);

			    gridGA01N306 = GACM1000U0Dao.selectListGA01N306(GA01N306VO) ;
		    	outVo.setGridGA01N306(gridGA01N306);		    	
		    	
		    }
	    	outListVo.add(outVo);
	    }
	    
		return outListVo;
	}	

	/* RE100 기안문서내역조회 */	
	@Override
	public List<GASM1000U0Out11VO> selectListGA01N306(GASM1000U0In11VO vo) {
		
		GASM1000U0Out11VO outVo = null;
		List<GASM1000U0Out11VO> outListVo = new ArrayList<GASM1000U0Out11VO>();		
		
		GA01N306VO GA01N306VO = null;
	    List<GA01N306VO> gridGA01N306 = null;    // 기안문서 다건내역		
	    
	    GA01N306VO = new GA01N306VO();
	    GA01N306VO.setCnrtMtNo(vo.getCnrtMtNo());
	    GA01N306VO.setCnrtKcd(CD_CNRT_KCD_SM);

	    gridGA01N306 = GACM1000U0Dao.selectListGA01N306(GA01N306VO) ;
    	
	    for(int i=0;i<gridGA01N306.size();i++) {
	    	GA01N306VO =  gridGA01N306.get(i);
	    	outVo = new GASM1000U0Out11VO();
			ObjectCopyUtil.copyFields(GA01N306VO, outVo);	    	
			outListVo.add(outVo);
	    }
		
		return outListVo;
	}	    	
	
	/* RE100 전력구매계약정보 */	
	@Override
	public GASM1000U0Out12VO selectCapaInfo() {
		
		GASM1000U0Out12VO outVo = new GASM1000U0Out12VO();
		
	    BigDecimal allCntcCapa  = BigDecimal.ZERO; /*전체계약용량 */
	    BigDecimal achvCntcCapa = BigDecimal.ZERO; /*이행계약용량 */
	    BigDecimal achvRt       = BigDecimal.ZERO; /*이행율 */
		
		GaCode01In00VO codeinvo = new GaCode01In00VO();	  
		GaCode01Out00VO codeoutvo = null;
		List<GaCode01Out00VO> codelistvo = null; 
	    
		// 이행계약용량
		achvCntcCapa = GASM1000U0Dao.selectAllCapa() ;
	    
	    // 전체계약용량 구하기
	    codeinvo.setCdKndNo("TOT_CNTC_CAPA");
	    codeinvo.setCmnCdVl("01");
	    codelistvo = CodeDao.selectBzMtCode(codeinvo);
	    
		if(codelistvo == null || codelistvo.size() == 0 ) {
			allCntcCapa = BigDecimal.ZERO;
		}else {
			codeoutvo = codelistvo.get(0);
			allCntcCapa = new BigDecimal(codeoutvo.getBzMtCdVl());
		}

		log.info("allCntcCapa ["+allCntcCapa+"] achvCntcCapa["+achvCntcCapa+"]");

		// 이행률 구하기 = 전체전력용량 / 전체계약전력용량
		if(allCntcCapa.compareTo(BigDecimal.ZERO) > 0) {
			achvRt = (achvCntcCapa.multiply(new BigDecimal("100"))).divide(allCntcCapa, 2, RoundingMode.HALF_UP);
			
		}else {
			allCntcCapa = BigDecimal.ZERO;
			achvRt = BigDecimal.ZERO;
		}
		log.info("==> achvRt["+achvRt+"]");
		
		// 이행률 보정 
		if(achvRt.compareTo(new BigDecimal("100")) > 0) {
			//achvRt = new BigDecimal("100");
		}
		
		DecimalFormat df = new DecimalFormat("#,##0.00");
		
    	outVo.setAllCntcCapa(df.format(allCntcCapa));
		outVo.setAchvCntcCapa(df.format(achvCntcCapa));
		outVo.setAchvRt(df.format(achvRt));
		
		return outVo;
	}	    		
	
	/* RE100 수정(PK) */	
	@Override
	public int updateGA01N305(GASM1000U0In02VO vo){
		int cnt = 0;
		GA01N305VO GA01N305VO = new GA01N305VO();
		GASM1000U0In01VO GASM1000U0In01VO = new GASM1000U0In01VO();
		List<GASM1000U0Out02VO> outList = null;
		
		GA01N306VO GA01N306VO = null; // 계약서별기안문서
	    //List<GA01N306VO> dataOutList2 = null;      // 계약서별기안문서 		
	    List<GA01N306VO> gridGA01N306 = null;     // 기안문서 다건내역		
	    
	    AT09N401VO AT09N401VO = null; // 기안문서 기등록건 체크용
	    List<AT09N401VO> dataAT09N401List = null;      // 기안문서 
	    
		// 전처리 : 입력값 체크
		{
			if(vo.getCnrtMtNo() == null || vo.getCnrtMtNo().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[계약서관리번호] 오류. 입력값을 확인하세요["+vo.getCnrtMtNo()+"]", ErrorCode.BAD_REQUEST);		
			}

			ObjectCopyUtil.copyFields(vo, GASM1000U0In01VO);
			outList = GASM1000U0Dao.selectGA01N305PKNew(GASM1000U0In01VO);
			
			if(outList != null && outList.size() > 0 ) {
				ObjectCopyUtil.copyFields(outList.get(0), GA01N305VO);
				
				if(GA01N305VO.getCnrtMtNo() == null || GA01N305VO.getCnrtMtNo().equals("") ) {
		            throw new CustomBadRequestException("변경할 대상건이 없습니다2. 입력항목을 확인하세요["+vo.getCnrtMtNo()+"]", ErrorCode.BAD_REQUEST);		
				}
				
				if(GA01N305VO.getDelYn() != null && GA01N305VO.getDelYn().equals("1") ) {
		            throw new CustomBadRequestException("변경할 대상건이 없습니다3. 이미삭제처리된 내역입니다.["+vo.getCnrtMtNo()+"]", ErrorCode.BAD_REQUEST);		
				}				
			}else {
	            throw new CustomBadRequestException("변경할 대상건이 없습니다1. 입력항목을 확인하세요["+vo.getCnrtMtNo()+"]", ErrorCode.BAD_REQUEST);		
			}			
		}
		
		// 수정처리
		{
			// 계약서별기안문서 delete insert
			{
				gridGA01N306 = vo.getGridGA01N306();
				if( gridGA01N306 != null &&  gridGA01N306.size() > 0) {
					
					GA01N306VO = new GA01N306VO();
					// 부모키 세팅
					GA01N306VO.setCnrtMtNo(vo.getCnrtMtNo());
					
					cnt = GACM1000U0Dao.deleteGA01N306WithGA01N303(GA01N306VO);
					log.info("계약서별기안문서 delete cnt ============"+cnt);
					
					for(int i=0;i<gridGA01N306.size() ;i++) {
						GA01N306VO = gridGA01N306.get(i);
						
						// ERP 기안문서 체크 AT09N401
						{
							AT09N401VO = new AT09N401VO();
							AT09N401VO.setDrftDocNo(GA01N306VO.getDrftDocNo());
							dataAT09N401List = GACM1000U0Dao.selectAT09N401PK(AT09N401VO);
							if(dataAT09N401List == null || dataAT09N401List.size() == 0) {
					            throw new CustomBadRequestException("ERP 기안문서 내역에 존재하지않는 기안문서번호입니다. ERP 기안문서번호 확인하세요["+GA01N306VO.getDrftDocNo()+"]", ErrorCode.BAD_REQUEST);		
							}							
						}
						
						if(GA01N306VO.getDrftDocNo() != null && !("").equals(GA01N306VO.getDrftDocNo()) ) {
							// 부모키 세팅
							GA01N306VO.setCnrtMtNo(vo.getCnrtMtNo());
							GA01N306VO.setCnrtKcd(CD_CNRT_KCD_SM);							
//							GA01N306VO.setOptrId("000000");
//							GA01N306VO.setOprtChnlCd("000");
//							GA01N306VO.setOprtOrzCd("000000");
//							GA01N306VO.setOprtIpAdr("000000");
							cnt =  GACM1000U0Dao.insertGA01N306(GA01N306VO);
							log.info("계약서별기안문서 insert cnt ["+i+"}============"+cnt);
						}
					}
				}				
			}	
			
			
			// 데이터 카피
			ObjectCopyUtil.copyFields(vo, GA01N305VO);		
			
//			GA01N305VO.setOptrId("000000");
//			GA01N305VO.setOprtChnlCd("000");
//			GA01N305VO.setOprtOrzCd("000000");
//			GA01N305VO.setOprtIpAdr("000000");
			
			cnt = GASM1000U0Dao.updateGA01N305(GA01N305VO);
			
			if(cnt == 0) {
		        throw new CustomBadRequestException("RE100계약관리 수정오류. 입력값을 확인하세요["+vo.getCnrtMtNo()+"]", ErrorCode.BAD_REQUEST);		
			}			
		}

		return cnt;
	}	

	
	/* RE100 삭제수정(PK) */	
	@Override
	public int updateDelGA01N305(GASM1000U0In04VO vo){
		int cnt = 0;
		GA01N305VO GA01N305VO = new GA01N305VO();
		GASM1000U0In01VO GASM1000U0In01VO = new GASM1000U0In01VO();
		List<GASM1000U0Out02VO> outList = null;
		
		// 전처리 : 입력값 체크
		{
			if(vo.getCnrtMtNo() == null || vo.getCnrtMtNo().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[계약서관리번호 ] 오류. 입력값을 확인하세요["+vo.getCnrtMtNo()+"]", ErrorCode.BAD_REQUEST);		
			}

			ObjectCopyUtil.copyFields(vo, GASM1000U0In01VO);
			outList = GASM1000U0Dao.selectGA01N305PKNew(GASM1000U0In01VO);
			
			if(outList != null && outList.size() > 0 ) {
				ObjectCopyUtil.copyFields(outList.get(0), GA01N305VO);
				
				if(GA01N305VO.getCnrtMtNo() == null || GA01N305VO.getCnrtMtNo().equals("") ) {
		            throw new CustomBadRequestException("삭제할 대상건이 없습니다2. 입력항목을 확인하세요["+vo.getCnrtMtNo()+"]", ErrorCode.BAD_REQUEST);		
				}
				
				if(GA01N305VO.getDelYn() != null && GA01N305VO.getDelYn().equals("1") ) {
		            throw new CustomBadRequestException("삭제할 대상건이 없습니다3. 이미삭제처리된 내역입니다.["+vo.getCnrtMtNo()+"]", ErrorCode.BAD_REQUEST);		
				}
			}else {
	            throw new CustomBadRequestException("삭제할 대상건이 없습니다1. 입력항목을 확인하세요["+vo.getCnrtMtNo()+"]", ErrorCode.BAD_REQUEST);		
			}			
		}
		
		// 삭제수정처리
		{
			// 데이터 카피
			ObjectCopyUtil.copyFields(vo, GA01N305VO);		
			GA01N305VO.setDelYn("1"); // 삭제
			
//			GA01N305VO.setOptrId("000000");
//			GA01N305VO.setOprtChnlCd("000");
//			GA01N305VO.setOprtOrzCd("000000");
//			GA01N305VO.setOprtIpAdr("000000");
			
			cnt = GASM1000U0Dao.updateDelGA01N305(GA01N305VO);
			
			if(cnt == 0) {
		        throw new CustomBadRequestException("RE100계약관리 삭제수정오류. 입력값을 확인하세요["+vo.getCnrtMtNo()+"]", ErrorCode.BAD_REQUEST);		
			}			
		}

		return cnt;
	}	
	
	
	/* RE100 신규등록 */
	@Override
	public int insertGA01N305(GASM1000U0In03VO vo){
		int cnt = 0;
		GA01N305VO GA01N305VO = new GA01N305VO();
		GASM1000U0In01VO GASM1000U0In01VO = new GASM1000U0In01VO();
		List<GASM1000U0Out01VO> outList = null;
		
		GAEM1000U0In10VO GAEM1000U0In10VO = new GAEM1000U0In10VO();
		List<GAEM1000U0Out10VO> outList2 = null;
		
		GA01N306VO GA01N306VO = null; // 계약서별기안문서
	    //List<GA01N306VO> dataOutList2 = null;      // 계약서별기안문서 		
	    List<GA01N306VO> gridGA01N306 = null;     // 기안문서 다건내역		
	    
	    AT09N401VO AT09N401VO = null; // 기안문서 기등록건 체크용
	    List<AT09N401VO> dataAT09N401List = null;      // 기안문서 
	    
		String newCnrtMtNo = "" ; //신규계약서관리번호 
		// 채번정보
		GaCode01In00VO codeinvo = new GaCode01In00VO();
		GaCode01Out00VO codeoutvo = null;
		List<GaCode01Out00VO> codelistvo = null;  
		
		
		// 전처리 : 입력값 체크
		{

			// 거래처코드 조회
			GAEM1000U0In10VO.setDelpCd(vo.getDelpCd());
			outList2 = GAEM1000U0Dao.selectAT05C010(GAEM1000U0In10VO);
			
			if(outList2 == null || outList2.size() == 0 ) {
	            throw new CustomBadRequestException("ERP 거래처 내역에 존재하지않는 거래처코드입니다. ERP 거래처관리에서 거래처코드를 확인하세요["+vo.getDelpCd()+"]", ErrorCode.BAD_REQUEST);		
			}				
			
		}
		
		// 신규계약서관리번호 채번
		{
			codeinvo.setCdKndNo("CHAEBUN");
			codeinvo.setCmnCdVl("CNRT02"); // 재번유형 CNRT01 : 계약서관리번호 CNRT02:ESG(RE100)
			codelistvo = CodeDao.selectChaebun(codeinvo);  
			
			if(codelistvo == null || codelistvo.size() == 0 ) {
				newCnrtMtNo = "0";
			}else {
				codeoutvo = codelistvo.get(0);
				newCnrtMtNo = codeoutvo.getNewNo();
				
			}
			log.info("신규 계약서관리번호  ============"+newCnrtMtNo);
			codeinvo.setNewNo(newCnrtMtNo);
			CodeDao.updateChaebun(codeinvo); 	
			
			vo.setCnrtMtNo(newCnrtMtNo);
		}
		
		// 신규등록처리
		{
			
			// 계약서별기안문서 신규등록(다건)
			{
				gridGA01N306 = vo.getGridGA01N306();
				
				
				if( gridGA01N306 != null &&  gridGA01N306.size() > 0) {
					for(int i=0;i<gridGA01N306.size() ;i++) {
						GA01N306VO = gridGA01N306.get(i);
						
						if(GA01N306VO.getDrftDocNo()!= null && !("").equals(GA01N306VO.getDrftDocNo()) ) {
							// 부모키 세팅
							GA01N306VO.setCnrtMtNo(vo.getCnrtMtNo());
							GA01N306VO.setCnrtKcd(CD_CNRT_KCD_SM);
							
							// ERP 기안문서 체크
							{
								AT09N401VO = new AT09N401VO();
								AT09N401VO.setDrftDocNo(GA01N306VO.getDrftDocNo());
								dataAT09N401List = GACM1000U0Dao.selectAT09N401PK(AT09N401VO);
								if(dataAT09N401List == null || dataAT09N401List.size() == 0) {
						            throw new CustomBadRequestException("ERP 기안문서 내역에 존재하지않는 기안문서번호입니다. ERP 기안문서번호 확인하세요["+GA01N306VO.getDrftDocNo()+"]", ErrorCode.BAD_REQUEST);		
								}
							}	
							
							GA01N306VO.setCnrtKcd(CD_CNRT_KCD_SM);
//							GA01N306VO.setOptrId("000000");
//							GA01N306VO.setOprtChnlCd("000");
//							GA01N306VO.setOprtOrzCd("000000");
//							GA01N306VO.setOprtIpAdr("000000");
							
							cnt = GACM1000U0Dao.insertGA01N306(GA01N306VO);
						}								
					}
				}
			}		
			
			// 데이터 카피
			ObjectCopyUtil.copyFields(vo, GA01N305VO);	
			
			GA01N305VO.setDelYn("0");
			
//			GA01N305VO.setOptrId("000000");
//			GA01N305VO.setOprtChnlCd("000");
//			GA01N305VO.setOprtOrzCd("000000");
//			GA01N305VO.setOprtIpAdr("000000");
			
			cnt = GASM1000U0Dao.insertGA01N305(GA01N305VO);
			
			if(cnt == 0) {
		        throw new CustomBadRequestException("신규등록 생성오류. 입력값을 확인하세요["+vo.getCnrtMtNo()+"]", ErrorCode.BAD_REQUEST);		
			}
		}

		return cnt;
	}		

}
