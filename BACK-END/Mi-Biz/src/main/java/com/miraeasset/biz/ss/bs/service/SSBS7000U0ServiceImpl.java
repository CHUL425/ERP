/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: SSBS7000U0ServiceImpl.java
*	04. 작  성  일  자	: 2023.10.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹별 화면관리 ServiceImpl
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.code.vo.GaSrno00In00VO;
import com.miraeasset.biz.common.dao.CommonDao;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA01N109VO;
import com.miraeasset.biz.common.meta.vo.GA09N205VO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.aprvWrrpt.AprvWrrpt;
import com.miraeasset.biz.rq.sr.dao.RQSR1000U0Dao;
import com.miraeasset.biz.ss.bs.dao.SSBS7000U0Dao;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In04VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In05VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In11VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out01VO;

@Service
@Transactional
public class SSBS7000U0ServiceImpl implements SSBS7000U0Service {
	
	@Autowired
	SSBS7000U0Dao SSBS7000U0Dao;
	
	@Autowired
	RQSR1000U0Dao RQSR1000U0Dao;
	
	@Autowired
	CommonDao CommonDao;	
	
	@Autowired
	CodeDao CodeDao;
	
	@Autowired
	AprvWrrpt aprvWrrpt;		
	
	private final String PSIT_MENU_ID_92 = "SSBS7000m0";
	private final String PSIT_MENU_ID_91 = "SSBS7100m0";

	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "00"; // 임시저장 
	private final String CD_RQS_SCD_APV_ING  = "05"; // 승인중 
	private final String CD_RQS_SCD_APV_CMPN = "10"; // 승인완료 
	private final String CD_RQS_SCD_CMPN     = "99"; // 완료 
	private final String CD_RQS_SCD_RTRN     = "30"; // 반려
	private final String CD_RQS_SCD_WDRAL    = "35"; // 철회
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
		

	
	/* 사용자그룹_화면 목록조회*/
	@Override
	public List<SSBS7000U0Out00VO> selectListGA09N205(SSBS7000U0In00VO vo) {
		// TODO Auto-generated method stub
		return SSBS7000U0Dao.selectListGA09N205(vo);
	}	
	
	/* 사용자그룹_화면 상세조회*/
	@Override
	public SSBS7000U0Out01VO selectGA09N205Pk(SSBS7000U0In01VO vo) {
		// TODO Auto-generated method stub
		GA09N205VO GA09N205VO = new GA09N205VO();
		SSBS7000U0Out01VO outVo = new SSBS7000U0Out01VO();
		// 입력 데이터 카피
		ObjectCopyUtil.copyFields(vo, GA09N205VO);	

		GA09N205VO = SSBS7000U0Dao.selectGA09N205Pk(GA09N205VO);
		
		if(GA09N205VO != null ) {
			// 출력 데이터 카피
			ObjectCopyUtil.copyFields(GA09N205VO,outVo);	
		}
		
		return outVo;
	}		
	
	/* 사용자그룹_화면 상세조회(접수번호기준)*/
	@Override
	public SSBS7000U0Out01VO selectGA09N205ByRecNo(SSBS7000U0In05VO vo){
		// TODO Auto-generated method stub
		GA09N205VO GA09N205VO = new GA09N205VO();
		SSBS7000U0Out01VO outVo = new SSBS7000U0Out01VO();
		// 입력 데이터 카피
		ObjectCopyUtil.copyFields(vo, GA09N205VO);	

		GA09N205VO = SSBS7000U0Dao.selectGA09N205ByRecNo(GA09N205VO);
		
		if(GA09N205VO != null ) {
			// 출력 데이터 카피
			ObjectCopyUtil.copyFields(GA09N205VO,outVo);	
		}
		
		return outVo;
	}			
	
	/* 사용자그룹_화면 정상건 목록조회*/
	@Override
	public List<SSBS7000U0Out00VO> selectListGA09N205ByNrml(SSBS7000U0In11VO vo) {
		// TODO Auto-generated method stub
		return SSBS7000U0Dao.selectListGA09N205ByNrml(vo);
	}	

	
	/* 사용자그룹_화면 임시저장(수정)/상신 다건 */	
	@Override
	public String reqRegiListGA09N205(SSBS7000U0In03VO vo) {
		// 변수 초기화
		String prcTp = "";
		boolean bfRegiYn = false; /* 기등록 여부 : false-신규등록 true-대상update */
	    String userGrpCd = null  ;  /*사용자그룹코드*/
	    String psitMenuId = null    ;  /*포털사이트메뉴ID*/
	    String rctNo = null   ;  /*접수번호*/
	    String drftDocNo = null ; /* 기안문서번호 */
	    
		// 채번vo
		GaSrno00In00VO rctVo = new GaSrno00In00VO();
		String rqsEpno = null; // 신청사원번호
		String rqsOrzCd = null; // 신청조직코드		
		String unifRqsPcd = "92"; // 통합신청유형코드 : 92(화면권한)
		int cnt = 0;
		int rctDlNo = 0;
		
		GA01N101VO GA01N101VO = null; /* 통합신청 */
		
		List<GA09N205VO> gridGA09N205 = null;    /* 사용자그룹_화면 다건내역 */		
		GA09N205VO GA09N205VO = null; /* 사용자그룹_화면 */
		SSBS7000U0In11VO SSBS7000U0In11VO = null; /* 기등록 중복체크 용 */
		SSBS7000U0Out00VO SSBS7000U0Out00VO = null; /* 기등록 중복체크 용 */
		List<SSBS7000U0Out00VO> outList = null;    /* 기등록 중복체크 다건내역 */		
		
		GA01N109VO GA01N109VO = null; // 통합기안문서
		
	    String newAprvWrrptMtNo = null; // 결재상신관리번호
		
		// 전처리 : 입력값 체크
		{
			rqsEpno  = vo.getRqsEpno();
			rqsOrzCd = vo.getRqsOrzCd();
			prcTp = vo.getPrcTp();
			
			if(prcTp == null || prcTp.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[처리구분코드] 오류. 입력값을 확인하세요["+prcTp+"]", ErrorCode.BAD_REQUEST);		
			}

			if (!Arrays.asList("00","01").contains(prcTp)) {
		        throw new CustomBadRequestException("처리구분코드 입력오류 ["+prcTp+"] - (00 : 임시저장 , 01 : 상신) ", ErrorCode.BAD_REQUEST);								
			}			

			if(rqsEpno == null || rqsEpno.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[신청사원번호] 오류. 입력값을 확인하세요["+rqsEpno+"]", ErrorCode.BAD_REQUEST);		
			}			
			if(rqsOrzCd == null || rqsOrzCd.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[신청조직코드] 오류. 입력값을 확인하세요["+rqsOrzCd+"]", ErrorCode.BAD_REQUEST);		
			}
			
			// 인감날인 입력값 체크
			gridGA09N205 = vo.getGridGA09N205();
			if(gridGA09N205 != null && gridGA09N205.size() > 0) {
				for(int i=0;i<gridGA09N205.size();i++) {
					GA09N205VO = gridGA09N205.get(i);
				    userGrpCd = GA09N205VO.getUserGrpCd()  ;  /*사용자그룹코드*/
				    psitMenuId = GA09N205VO.getPsitMenuId()    ;  /*포털사이트메뉴ID*/
				    drftDocNo = GA09N205VO.getDrftDocNo(); /* 기안문서 */
					// 사용자그룹코드 필수 체크
					if(GA09N205VO.getUserGrpCd() == null || "".equals(GA09N205VO.getUserGrpCd()) ) {
				        throw new CustomBadRequestException("필수입력항목 사용자그룹별 화면관리[사용자그룹코드] 오류. 입력값을 확인하세요["+GA09N205VO.getUserGrpCd()+"]", ErrorCode.BAD_REQUEST);		
					}
					
					// 화면 필수 체크
					if(GA09N205VO.getPsitMenuId() == null || "".equals(GA09N205VO.getPsitMenuId()) ) {
				        throw new CustomBadRequestException("필수입력항목 사용자그룹별 화면관리[화면id] 오류. 입력값을 확인하세요["+GA09N205VO.getPsitMenuId()+"]", ErrorCode.BAD_REQUEST);		
					}
					
					/*
					// 기안문서 필수 체크
					if(GA09N205VO.getDrftDocNo() == null || "".equals(GA09N205VO.getDrftDocNo()) ) {
				        throw new CustomBadRequestException("필수입력항목 사용자그룹별 화면관리[기안문서] 오류. 입력값을 확인하세요["+GA09N205VO.getDrftDocNo()+"]", ErrorCode.BAD_REQUEST);		
					}
					*/
					
					// 기등록 중복 체크
					{
						/* 사용자그룹_화면 정상건 목록조회*/
						SSBS7000U0In11VO = new SSBS7000U0In11VO();
						SSBS7000U0In11VO.setPsitMenuId(psitMenuId);
						SSBS7000U0In11VO.setUserGrpCd(userGrpCd);
						
						outList = SSBS7000U0Dao.selectListGA09N205ByNrml(SSBS7000U0In11VO);
						if(outList != null && outList.size() > 0) {
					        throw new CustomBadRequestException("기등록 데이터가 존재합니다. 입력값을 확인하세요["+psitMenuId+"]["+userGrpCd+"]", ErrorCode.BAD_REQUEST);		
						}
						
					}
				}
			}else {
		        throw new CustomBadRequestException("신규 대상건이 입력 건수가 없습니다. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);		
			}

		}

		// 임시저장/상신 -> 등록/수정 
		{
			// 사용자그룹별 화면관리 GA09N205VO : INSERT 처리
			{
				// 사용자그룹별 입력값 체크
				gridGA09N205 = vo.getGridGA09N205();
				if(gridGA09N205 != null && gridGA09N205.size() > 0) {
					for(int i=0;i<gridGA09N205.size();i++) {
						GA09N205VO = gridGA09N205.get(i);
					    userGrpCd = GA09N205VO.getUserGrpCd()  ;  /*사용자그룹코드*/
					    psitMenuId = GA09N205VO.getPsitMenuId()    ;  /*포털사이트메뉴ID*/
					    drftDocNo = GA09N205VO.getDrftDocNo(); /* 기안문서 */
					    
					    // 접수번호 채번
					    {
							// 통합신청 신규접수번호 채번
							rctVo.setCdKndNo("CHAEBUN");
							rctVo.setCmnCdVl(unifRqsPcd); // 화면권한:92
							rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
							rctNo = rctVo.getRpbzGnoSrno();

							log.info("접수번호 채번 rctNo ============["+rctNo+"]");	
					    }
						
						// 통합신청 데이터 세팅 (GA01N101)
						{
							String rqsDt = DateUtil.getTodayString("yyyyMMdd");
							
							// 통합신청  
							GA01N101VO = new GA01N101VO();
							// 통합신청내역 데이터 카피
							ObjectCopyUtil.copyFields(vo, GA01N101VO);	
							GA01N101VO.setRctNo(rctNo);
							GA01N101VO.setRqsEpno(rqsEpno);
							GA01N101VO.setRqsOrzCd(rqsOrzCd);
							GA01N101VO.setUnifRqsPcd(unifRqsPcd);
							GA01N101VO.setUnifRqsTcd(unifRqsPcd+"0101");
							GA01N101VO.setUnifRqsDlPcd(unifRqsPcd+"01");
							//GA01N101VO.setHopeDt();
							GA01N101VO.setRqsRsnCn("사용자그룹별 화면관리");
							GA01N101VO.setRqsDt(rqsDt);
							// 임시저장
							GA01N101VO.setRqsScd("00");

							// 신규등록
							cnt = RQSR1000U0Dao.insertGA01N101(GA01N101VO);		
							if(cnt == 0) {
						        throw new CustomBadRequestException("신규등록 생성오류(통합신청). 입력값을 확인하세요", ErrorCode.BAD_REQUEST);							
							}	
						}
					    
						// 사용자그룹_화면 신규등록
						{
						    GA09N205VO.setRctNo(rctNo);
						    
						    cnt = SSBS7000U0Dao.insertGA09N205(GA09N205VO);
							if(cnt == 0) {
						        throw new CustomBadRequestException("사용자그룹별  생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
							}
							
							// 통합신청기안문서 GA01N109VO : DELETE INSERT 처리
							{
								GA01N109VO = new GA01N109VO();
								GA01N109VO.setRctNo(rctNo);
								GA01N109VO.setDrftDocNo(drftDocNo);
								
								cnt = RQSR1000U0Dao.deleteGA01N109ByRctNo(GA01N109VO);								
								cnt = RQSR1000U0Dao.insertGA01N109(GA01N109VO);
								if(cnt == 0) {
							        throw new CustomBadRequestException("통합신청기안문서 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
								}
							}			
						}
						
						// 상신:결재상신처리
						if(true) {
							log.info("결재 모듈 ============["+rctNo+"] ["+rqsEpno+"][" + rqsOrzCd +"] ["+unifRqsPcd+"] ["+PSIT_MENU_ID_92+"]");				
							 
							// 상신 결재 등록 --> 여기서 결재선 모듈 호출
							newAprvWrrptMtNo = aprvWrrpt.aprvWrrpt(rctNo, rqsEpno, rqsOrzCd, unifRqsPcd, PSIT_MENU_ID_92);

							log.info("newAprvWrrptMtNo ["+newAprvWrrptMtNo+"]");
						}						
					}
				}
			}
			
		}

		log.info("rctNo ["+rctNo+"]");
		
		return rctNo;
	}	    
	
	/* 사용자그룹_화면 임시저장(수정)/상신 단건 */	
	@Override
	public String reqRegiGA09N205(SSBS7000U0In04VO vo) {
		// 변수 초기화
		String prcTp = "";
	    String userGrpCd = null  ;  /*사용자그룹코드*/
	    String psitMenuId = null    ;  /*포털사이트메뉴ID*/
	    String rctNo = null   ;  /*접수번호*/
	    String drftDocNo = null ; /* 기안문서번호 */
	    
		// 채번vo
		GaSrno00In00VO rctVo = new GaSrno00In00VO();
		String rqsEpno = null; // 신청사원번호
		String rqsOrzCd = null; // 신청조직코드		
		String unifRqsPcd = "92"; // 통합신청유형코드 : 92(화면권한)
		int cnt = 0;
		
		GA01N101VO GA01N101VO = null; /* 통합신청 */
		GA09N205VO GA09N205VO = null; /* 사용자그룹_화면 */
		SSBS7000U0In11VO SSBS7000U0In11VO = null; /* 기등록 중복체크 용 */
		List<SSBS7000U0Out00VO> outList = null;    /* 기등록 중복체크 다건내역 */		
		GA01N109VO GA01N109VO = null; // 통합기안문서
		
	    String newAprvWrrptMtNo = null; // 결재상신관리번호
		
		// 전처리 : 입력값 체크
		{
			rqsEpno  = vo.getRqsEpno();
			rqsOrzCd = vo.getRqsOrzCd();
			prcTp = vo.getPrcTp();
		    userGrpCd = vo.getUserGrpCd()  ;  /*사용자그룹코드*/
		    psitMenuId = vo.getPsitMenuId()    ;  /*포털사이트메뉴ID*/
		    drftDocNo = vo.getDrftDocNo(); /* 기안문서 */
			
			if(prcTp == null || prcTp.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[처리구분코드] 오류. 입력값을 확인하세요["+prcTp+"]", ErrorCode.BAD_REQUEST);		
			}

			if (!Arrays.asList("00","01").contains(prcTp)) {
		        throw new CustomBadRequestException("처리구분코드 입력오류 ["+prcTp+"] - (00 : 임시저장 , 01 : 상신) ", ErrorCode.BAD_REQUEST);								
			}			

			if(rqsEpno == null || rqsEpno.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[신청사원번호] 오류. 입력값을 확인하세요["+rqsEpno+"]", ErrorCode.BAD_REQUEST);		
			}			
			if(rqsOrzCd == null || rqsOrzCd.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[신청조직코드] 오류. 입력값을 확인하세요["+rqsOrzCd+"]", ErrorCode.BAD_REQUEST);		
			}
			
			// 사용자그룹코드 필수 체크
			if(vo.getUserGrpCd() == null || "".equals(vo.getUserGrpCd()) ) {
		        throw new CustomBadRequestException("필수입력항목 사용자그룹별 화면관리[사용자그룹코드] 오류. 입력값을 확인하세요["+vo.getUserGrpCd()+"]", ErrorCode.BAD_REQUEST);		
			}
			
			// 화면 필수 체크
			if(vo.getPsitMenuId() == null || "".equals(vo.getPsitMenuId()) ) {
		        throw new CustomBadRequestException("필수입력항목 사용자그룹별 화면관리[화면id] 오류. 입력값을 확인하세요["+vo.getPsitMenuId()+"]", ErrorCode.BAD_REQUEST);		
			}
			
			/*
			// 기안문서 필수 체크
			if(GA09N205VO.getDrftDocNo() == null || "".equals(GA09N205VO.getDrftDocNo()) ) {
		        throw new CustomBadRequestException("필수입력항목 사용자그룹별 화면관리[기안문서] 오류. 입력값을 확인하세요["+GA09N205VO.getDrftDocNo()+"]", ErrorCode.BAD_REQUEST);		
			}
			*/
			
			// 기등록 중복 체크
			{
				/* 사용자그룹_화면 정상건 목록조회*/
				SSBS7000U0In11VO = new SSBS7000U0In11VO();
				SSBS7000U0In11VO.setPsitMenuId(psitMenuId);
				SSBS7000U0In11VO.setUserGrpCd(userGrpCd);
				
				outList = SSBS7000U0Dao.selectListGA09N205ByNrml(SSBS7000U0In11VO);
				if(outList != null && outList.size() > 0) {
			        throw new CustomBadRequestException("기등록 데이터가 존재합니다. 입력값을 확인하세요["+psitMenuId+"]["+userGrpCd+"]", ErrorCode.BAD_REQUEST);		
				}
				
			}
		}

		// 임시저장/상신 -> 등록/수정 
		{
		    // 접수번호 채번
		    {
				// 통합신청 신규접수번호 채번
				rctVo.setCdKndNo("CHAEBUN");
				rctVo.setCmnCdVl(unifRqsPcd); // 화면권한:92
				rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
				rctNo = rctVo.getRpbzGnoSrno();

				log.info("접수번호 채번 rctNo ============["+rctNo+"]");	
		    }
			
			// 통합신청 데이터 세팅 (GA01N101)
			{
				String rqsDt = DateUtil.getTodayString("yyyyMMdd");
				
				// 통합신청  
				GA01N101VO = new GA01N101VO();
				// 통합신청내역 데이터 카피
				ObjectCopyUtil.copyFields(vo, GA01N101VO);	
				GA01N101VO.setRctNo(rctNo);
				GA01N101VO.setRqsEpno(rqsEpno);
				GA01N101VO.setRqsOrzCd(rqsOrzCd);
				GA01N101VO.setUnifRqsPcd(unifRqsPcd);
				GA01N101VO.setUnifRqsTcd(unifRqsPcd+"0101");
				GA01N101VO.setUnifRqsDlPcd(unifRqsPcd+"01");
				//GA01N101VO.setHopeDt();
				GA01N101VO.setRqsRsnCn("사용자그룹별 화면관리");
				GA01N101VO.setRqsDt(rqsDt);
				// 임시저장
				GA01N101VO.setRqsScd("00");

				// 신규등록
				cnt = RQSR1000U0Dao.insertGA01N101(GA01N101VO);		
				if(cnt == 0) {
			        throw new CustomBadRequestException("신규등록 생성오류(통합신청). 입력값을 확인하세요", ErrorCode.BAD_REQUEST);							
				}	
			}
		    
			// 사용자그룹_화면 신규등록
			{
				GA09N205VO = new GA09N205VO();
				ObjectCopyUtil.copyFields(vo, GA09N205VO);
				GA09N205VO.setRctNo(rctNo);
			    
			    cnt = SSBS7000U0Dao.insertGA09N205(GA09N205VO);
				if(cnt == 0) {
			        throw new CustomBadRequestException("사용자그룹별  생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
				}
				
				// 통합신청기안문서 GA01N109VO : DELETE INSERT 처리
				{
					GA01N109VO = new GA01N109VO();
					GA01N109VO.setRctNo(rctNo);
					GA01N109VO.setDrftDocNo(drftDocNo);
					
					cnt = RQSR1000U0Dao.deleteGA01N109ByRctNo(GA01N109VO);
					cnt = RQSR1000U0Dao.insertGA01N109(GA01N109VO);
					if(cnt == 0) {
				        throw new CustomBadRequestException("통합신청기안문서 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
					}
				}			
			}
			
			// 상신:결재상신처리
			if(true) {
				log.info("결재 모듈 ============["+rctNo+"] ["+rqsEpno+"][" + rqsOrzCd +"] ["+unifRqsPcd+"] ["+PSIT_MENU_ID_92+"]");				
				 
				// 상신 결재 등록 --> 여기서 결재선 모듈 호출
				newAprvWrrptMtNo = aprvWrrpt.aprvWrrpt(rctNo, rqsEpno, rqsOrzCd, unifRqsPcd, PSIT_MENU_ID_92);

				log.info("newAprvWrrptMtNo ["+newAprvWrrptMtNo+"]");
			}	
		}

		log.info("rctNo ["+rctNo+"]");
		
		return rctNo;
	}	   
	
	/* 사용자그룹_화면 반려건 재신청 */	
	@Override
	public String reApplyByRctNo(SSBS7000U0In05VO vo, LoginOutVO loginVo) {

		// 채번vo
		GaSrno00In00VO rctVo = new GaSrno00In00VO();
		String preRctNo = null; //접수번호(깆접수번호)
		String newRctNo = null; //접수번호(신규접수번호)
		String rqsEpno = null; // 신청사원번호
		String rqsOrzCd = null; // 신청조직코드		
		String unifRqsPcd = "92"; // 통합신청유형코드 : 92(화면권한)
		
		
		GA01N101VO GA01N101VO = null; /* 통합신청 */
		
		// 전처리 : 입력값 체크
		{
			preRctNo = vo.getRctNo();
			rqsEpno  = loginVo.getEpno();
			rqsOrzCd = loginVo.getBlngOrzCd();
			
			log.info("입력접수번호 preRctNo ============["+preRctNo+"]");	

			if(preRctNo == null || preRctNo.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[접수번호] 오류. 입력값을 확인하세요["+preRctNo+"]", ErrorCode.BAD_REQUEST);		
			}

			if(rqsEpno == null || rqsEpno.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[신청사원번호] 오류. 입력값을 확인하세요["+rqsEpno+"]", ErrorCode.BAD_REQUEST);		
			}			
			if(rqsOrzCd == null || rqsOrzCd.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[신청조직코드] 오류. 입력값을 확인하세요["+rqsOrzCd+"]", ErrorCode.BAD_REQUEST);		
			}
			
			// 기등록 데이터 체크
			{
				GA01N101VO = new GA01N101VO();
				GA01N101VO.setRctNo(preRctNo);

				GA01N101VO = RQSR1000U0Dao.selectGA01N101(GA01N101VO);
				
				if(GA01N101VO == null) {
			        throw new CustomBadRequestException("통합신청 대상건이 존재하지않습니다. 접수번호를 확인하세요["+preRctNo+"]", ErrorCode.BAD_REQUEST);						
				}
				
				if(GA01N101VO.getRqsScd() == null ) {
			        throw new CustomBadRequestException("통합신청 신청상태코드를 확인하세요. ["+GA01N101VO.getRqsScd()+"]", ErrorCode.BAD_REQUEST);						
				}else {
					if(!CD_RQS_SCD_RTRN.equals(GA01N101VO.getRqsScd()) ){
				        throw new CustomBadRequestException("통합신청 신청상태코드를 확인하세요. 반려인데이터만 재상신 처리 가능합니다. ["+GA01N101VO.getRqsScd()+"]["+GA01N101VO.getRqsScdNm()+"]", ErrorCode.BAD_REQUEST);						
					}
				}
			}
		}

		// 임시저장/상신 -> 등록/수정 
		{
			// 통합신청 신규접수번호 채번
			{
				rctVo.setCdKndNo("CHAEBUN");
				rctVo.setCmnCdVl(unifRqsPcd); // 
				rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
				newRctNo = rctVo.getRpbzGnoSrno();

				log.info("접수번호 채번 newRctNo ============["+newRctNo+"]");	
			}
			
			// GA01N101 GA09N205 GA01N109
			// 통합신청 데이터 세팅 (GA01N101)
			{
				Map<String, Object> map = new HashMap<>();
				map.put("rctNo", newRctNo);
				map.put("prevRctNo", preRctNo);

				map.put("optrId"    , loginVo.getEpno());
				map.put("oprtChnlCd", loginVo.getOprtChnlCd());
				map.put("oprtOrzCd" , loginVo.getOprtOrzCd());
				map.put("oprtIpAdr" , loginVo.getOprtIpAdr());

				int rtn = SSBS7000U0Dao.reApplyByRctNo(map);				
			}
		}

		return newRctNo;
	}	 	
 
	
}
