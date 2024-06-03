package com.miraeasset.biz.ss.bs.service;

import java.util.Arrays;
import java.util.List;

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
import com.miraeasset.biz.common.meta.vo.GA01C001VO;
import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA01N109VO;
import com.miraeasset.biz.common.meta.vo.GA09N200VO;
import com.miraeasset.biz.common.meta.vo.GA09N201VO;
import com.miraeasset.biz.common.meta.vo.GA09N203VO;
import com.miraeasset.biz.common.meta.vo.GA09N204VO;
import com.miraeasset.biz.common.meta.vo.GA09N205VO;
import com.miraeasset.biz.common.meta.vo.GA09N208VO;
import com.miraeasset.biz.common.meta.vo.GA09N209VO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.aprvWrrpt.AprvWrrpt;
import com.miraeasset.biz.rq.sr.dao.RQSR1000U0Dao;
import com.miraeasset.biz.ss.bs.dao.SSBS1000V0Dao;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In02VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In02VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In04VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In11VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0In04VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0Out00VO;

@Service
@Transactional
public class SSBS1000V0ServiceImpl implements SSBS1000V0Service {
	
	@Autowired
	SSBS1000V0Dao SSBS1000V0Dao;
	
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
		
	/* 사용자그룹 조회*/
	@Override
	public List<SSBS6000U0Out00VO> selectListGA09N200(SSBS6000U0In00VO vo) {
		// TODO Auto-generated method stub
		return SSBS1000V0Dao.selectListGA09N200(vo);
	}
		
	/* 사용자그룹 상세조회*/
	@Override
	public SSBS6000U0Out01VO selectGA09N200(SSBS6000U0In01VO vo) {
		// TODO Auto-generated method stub
		return SSBS1000V0Dao.selectGA09N200(vo);
	}

	
	/* 사용자그룹 신규등록 */	
	@Override
	public int insertGA09N200(SSBS6000U0In02VO vo) {
		int cnt = 0;
		GA09N200VO GA09N200VO = new GA09N200VO();
		SSBS6000U0In01VO SSBS6000U0In01VO = new SSBS6000U0In01VO();
		SSBS6000U0Out01VO SSBS6000U0Out01VO = null;
		
		// 전처리 : 입력값 체크
		{
			if(vo.getUserGrpCd() == null || vo.getUserGrpCd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[사용자그룹코드] 오류. 입력값을 확인하세요["+vo.getUserGrpCd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getGrpNm() == null || vo.getGrpNm().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[그룹명] 오류. 입력값을 확인하세요["+vo.getGrpNm()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getUseYn() == null || vo.getUseYn().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[사용여부] 오류. 입력값을 확인하세요["+vo.getUseYn()+"]", ErrorCode.BAD_REQUEST);		
			}			

			
			ObjectCopyUtil.copyFields(vo, SSBS6000U0In01VO);
			SSBS6000U0Out01VO = SSBS1000V0Dao.selectGA09N200(SSBS6000U0In01VO);
			
			if(SSBS6000U0Out01VO != null  ) {
	            throw new CustomBadRequestException("신규등록 대상이 이미 존재합니다. 사용자그룹코드 확인하세요["+vo.getUserGrpCd()+"]", ErrorCode.BAD_REQUEST);		
			}			
		}
		
		// 신규등록
		{
			// 데이터 카피
			ObjectCopyUtil.copyFields(vo, GA09N200VO);		
			
//			GA01N203VO.setOptrId("000000");
//			GA01N203VO.setOprtChnlCd("000");
//			GA01N203VO.setOprtOrzCd("000000");
//			GA01N203VO.setOprtIpAdr("000000");
			
			cnt = SSBS1000V0Dao.insertGA09N200(GA09N200VO);
			
			if(cnt == 0) {
		        throw new CustomBadRequestException("사용자그룹관리 신규등록오류. 입력값을 확인하세요["+vo.getUserGrpCd()+"]", ErrorCode.BAD_REQUEST);		
			}			
		}

		return cnt;
	}		    
		
	/* 사용자그룹 수정 */	
	public int updaeGA09N200(SSBS6000U0In02VO vo) {
		int cnt = 0;
		GA09N200VO GA09N200VO = new GA09N200VO();
		SSBS6000U0In01VO SSBS6000U0In01VO = new SSBS6000U0In01VO();
		SSBS6000U0Out01VO SSBS6000U0Out01VO = null;
		
		// 전처리 : 입력값 체크
		{
			if(vo.getUserGrpCd() == null || vo.getUserGrpCd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[사용자그룹코드] 오류. 입력값을 확인하세요["+vo.getUserGrpCd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getGrpNm() == null || vo.getGrpNm().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[그룹명] 오류. 입력값을 확인하세요["+vo.getGrpNm()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getUseYn() == null || vo.getUseYn().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[사용여부] 오류. 입력값을 확인하세요["+vo.getUseYn()+"]", ErrorCode.BAD_REQUEST);		
			}			

			
			ObjectCopyUtil.copyFields(vo, SSBS6000U0In01VO);
			SSBS6000U0Out01VO = SSBS1000V0Dao.selectGA09N200(SSBS6000U0In01VO);
			
			if(SSBS6000U0Out01VO == null  ) {
	            throw new CustomBadRequestException("수정 대상이 존재하지않습니다. 사용자그룹코드 확인하세요["+vo.getUserGrpCd()+"]", ErrorCode.BAD_REQUEST);		
			}			
		}
		
		// 수정처리
		{
			// 데이터 카피
			ObjectCopyUtil.copyFields(vo, GA09N200VO);		
			
//			GA01N203VO.setOptrId("000000");
//			GA01N203VO.setOprtChnlCd("000");
//			GA01N203VO.setOprtOrzCd("000000");
//			GA01N203VO.setOprtIpAdr("000000");
			
			cnt = SSBS1000V0Dao.updateGA09N200(GA09N200VO);
			
			if(cnt == 0) {
		        throw new CustomBadRequestException("사용자그룹관리 수정처리오류. 입력값을 확인하세요["+vo.getUserGrpCd()+"]", ErrorCode.BAD_REQUEST);		
			}			
		}

		return cnt;
	}		       

	/* 사용자그룹 삭제 */	
	public int deleteGA09N200(SSBS6000U0In01VO vo){
		int cnt = 0;
		GA09N200VO GA09N200VO = new GA09N200VO();
		//SSBS6000U0In01VO SSBS6000U0In01VO = new SSBS6000U0In01VO();
		SSBS6000U0Out01VO SSBS6000U0Out01VO = null;
		
		// 전처리 : 입력값 체크
		{
			if(vo.getUserGrpCd() == null || vo.getUserGrpCd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[사용자그룹코드] 오류. 입력값을 확인하세요["+vo.getUserGrpCd()+"]", ErrorCode.BAD_REQUEST);		
			}

			SSBS6000U0Out01VO = SSBS1000V0Dao.selectGA09N200(vo);
			
			if(SSBS6000U0Out01VO == null  ) {
	            throw new CustomBadRequestException("삭제 대상이 존재하지않습니다. 사용자그룹코드 확인하세요["+vo.getUserGrpCd()+"]", ErrorCode.BAD_REQUEST);		
			}			
		}
		
		// 수정처리
		{
			// 데이터 카피
			ObjectCopyUtil.copyFields(vo, GA09N200VO);		
			
//			GA01N203VO.setOptrId("000000");
//			GA01N203VO.setOprtChnlCd("000");
//			GA01N203VO.setOprtOrzCd("000000");
//			GA01N203VO.setOprtIpAdr("000000");
			
			cnt = SSBS1000V0Dao.deleteGA09N200(GA09N200VO);
			
			if(cnt == 0) {
		        throw new CustomBadRequestException("사용자그룹관리 삭제처리오류. 입력값을 확인하세요["+vo.getUserGrpCd()+"]", ErrorCode.BAD_REQUEST);		
			}			
		}

		return cnt;
	}		     
	
	/* 사용자그룹_화면 목록조회*/
	@Override
	public List<SSBS7000U0Out00VO> selectListGA09N205(SSBS7000U0In00VO vo) {
		// TODO Auto-generated method stub
		return SSBS1000V0Dao.selectListGA09N205(vo);
	}	
	
	/* 사용자그룹_화면 상세조회*/
	@Override
	public SSBS7000U0Out01VO selectGA09N205Pk(SSBS7000U0In01VO vo) {
		// TODO Auto-generated method stub
		GA09N205VO GA09N205VO = new GA09N205VO();
		SSBS7000U0Out01VO outVo = new SSBS7000U0Out01VO();
		// 입력 데이터 카피
		ObjectCopyUtil.copyFields(vo, GA09N205VO);	

		GA09N205VO = SSBS1000V0Dao.selectGA09N205Pk(GA09N205VO);
		
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
		return SSBS1000V0Dao.selectListGA09N205ByNrml(vo);
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
						
						outList = SSBS1000V0Dao.selectListGA09N205ByNrml(SSBS7000U0In11VO);
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
						    
						    cnt = SSBS1000V0Dao.insertGA09N205(GA09N205VO);
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
				
				outList = SSBS1000V0Dao.selectListGA09N205ByNrml(SSBS7000U0In11VO);
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
			    
			    cnt = SSBS1000V0Dao.insertGA09N205(GA09N205VO);
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
	
    /* 화면관리 목록조회*/
	@Override
	public List<SSBS5000U0Out00VO> selectListGA09N204(SSBS5000U0In00VO vo) {
		// TODO Auto-generated method stub
		return SSBS1000V0Dao.selectListGA09N204(vo);
	}
	
    /* 화면관리 상세조회*/
	@Override
	public SSBS5000U0Out01VO selectGA09N204(SSBS5000U0In01VO vo) {
		// TODO Auto-generated method stub
		GA09N204VO GA09N204VO = new GA09N204VO();
		SSBS5000U0Out01VO outVo = new SSBS5000U0Out01VO();
		// 입력 데이터 카피
		ObjectCopyUtil.copyFields(vo, GA09N204VO);	

		GA09N204VO = SSBS1000V0Dao.selectGA09N204PK(GA09N204VO);
		
		if(GA09N204VO != null ) {
			// 출력 데이터 카피
			ObjectCopyUtil.copyFields(GA09N204VO,outVo);	
		}
		
		return outVo;
	}
	
	
	/* 화면관리 신규/수정/삭제 다건 */	
	@Override
	public int reqRegiListGA09N204(SSBS5000U0In03VO vo) {
		// 변수 초기화
		String prcTp = ""; /* 처리구분 N-신규 U-수정 D-삭제 */
	    String psitMenuId  = null;  /*포털사이트메뉴ID*/
	    String scrnNm      = null;  /*화면명          */
	    String scrnPcd     = null;  /*화면유형코드    */
	    String urlAdr      = null;  /*URL주소         */
	    String useYn       = null;  /*사용여부        */
	    String scrnOputSqn = null;  /*화면출력순서    */
	    String epno1 = null;  /*화면담당자1  */
	    String epno2 = null;  /*화면담당자2    */
	    String epno3 = null;  /*화면담당자3    */
	    String mchprYn1 = null; /*정담당자여부1 */	    
	    String mchprYn2 = null; /*정담당자여부2 */	    
	    String mchprYn3 = null; /*정담당자여부3 */	    
	    String kwrdCn = null; /*키워드내용 */	    

		// 채번vo
		String rqsEpno = null; // 신청사원번호
		String rqsOrzCd = null; // 신청조직코드		
		int cnt = 0;
		int mCnt = 0;
		
		List<GA09N204VO> gridGA09N204 = null;    /* 화면관리 다건내역 */		
		GA09N204VO GA09N204VO = null; /* 화면관리 */
		GA09N209VO GA09N209VO = null; /* 화면_담당사원 */
		GA09N208VO GA09N208VO = null; /* 화면_키워드 */
		
		// 전처리 : 입력값 체크
		{
			rqsEpno  = vo.getRqsEpno();
			rqsOrzCd = vo.getRqsOrzCd();

			if(rqsEpno == null || rqsEpno.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[신청사원번호] 오류. 입력값을 확인하세요["+rqsEpno+"]", ErrorCode.BAD_REQUEST);		
			}			
			if(rqsOrzCd == null || rqsOrzCd.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[신청조직코드] 오류. 입력값을 확인하세요["+rqsOrzCd+"]", ErrorCode.BAD_REQUEST);		
			}
			
			// 입력값 체크
			gridGA09N204 = vo.getGridGA09N204();
			if(gridGA09N204 != null && gridGA09N204.size() > 0) {
				for(int i=0;i<gridGA09N204.size();i++) {
					GA09N204VO = gridGA09N204.get(i);
					
					prcTp = GA09N204VO.getPrcTp(); /* 처리구분 N-신규 U-수정 D-삭제 */
					
				    psitMenuId  = GA09N204VO.getPsitMenuId();  /*포털사이트메뉴ID*/
				    scrnNm      = GA09N204VO.getScrnNm();  /*화면명          */
				    scrnPcd     = GA09N204VO.getScrnPcd();  /*화면유형코드    */
				    urlAdr      = GA09N204VO.getUrlAdr();  /*URL주소         */
				    useYn       = GA09N204VO.getUseYn();  /*사용여부        */
				    scrnOputSqn = GA09N204VO.getScrnOputSqn();  /*화면출력순서    */
				    epno1 = GA09N204VO.getEpno1();  /*화면담당자1  */
				    epno2 = GA09N204VO.getEpno2();  /*화면담당자2  */
				    epno3 = GA09N204VO.getEpno3();  /*화면담당자3  */
				    mchprYn1 = GA09N204VO.getMchprYn1(); /*정담당자여부1 */
				    mchprYn2 = GA09N204VO.getMchprYn2(); /*정담당자여부2 */
				    mchprYn3 = GA09N204VO.getMchprYn3(); /*정담당자여부3 */
				    
					if(prcTp == null || prcTp.equals("") ) {
				        throw new CustomBadRequestException("필수입력항목[처리구분코드] 오류. 입력값을 확인하세요["+prcTp+"]", ErrorCode.BAD_REQUEST);		
					}

					if (!Arrays.asList("N","U","D").contains(prcTp)) {
				        throw new CustomBadRequestException("처리구분코드 입력오류 ["+prcTp+"] - (N:신규 U:수정 D:삭제) ", ErrorCode.BAD_REQUEST);								
					}					    

					
					// 화면id 필수 체크
					if(psitMenuId == null || "".equals(psitMenuId) ) {
				        throw new CustomBadRequestException("필수입력항목 화면관리[화면id] 오류. 입력값을 확인하세요["+psitMenuId+"]", ErrorCode.BAD_REQUEST);		
					}
					
					// 신규/수정시 내용 필수 입력체크
					if (Arrays.asList("N","U").contains(prcTp)) {
						// 화면명 필수 체크
						if(scrnNm == null || "".equals(scrnNm) ) {
					        throw new CustomBadRequestException("필수입력항목 화면관리[화면명] 오류. 입력값을 확인하세요["+scrnNm+"]", ErrorCode.BAD_REQUEST);		
						}

						// 화면유형코드 필수 체크
						if(scrnPcd == null || "".equals(scrnPcd) ) {
					        throw new CustomBadRequestException("필수입력항목 화면관리[화면유형코드] 오류. 입력값을 확인하세요["+scrnPcd+"]", ErrorCode.BAD_REQUEST);		
						}
						// 사용여부 필수 체크
						if(useYn == null || "".equals(useYn) ) {
					        throw new CustomBadRequestException("필수입력항목 화면관리[사용여부] 오류. 입력값을 확인하세요["+useYn+"]", ErrorCode.BAD_REQUEST);		
						}
						
						// 화면담당자1 필수 체크
						if(epno1 == null || "".equals(epno1) ) {
					        throw new CustomBadRequestException("필수입력항목 화면관리[화면담당자1] 오류. 입력값을 확인하세요["+epno1+"]", ErrorCode.BAD_REQUEST);		
						}else {
							// 정담당자여부1 필수 체크
							if(mchprYn1 == null || "".equals(mchprYn1) ) {
						        throw new CustomBadRequestException("필수입력항목 화면관리[정담당자여부1] 오류. 입력값을 확인하세요["+mchprYn1+"]", ErrorCode.BAD_REQUEST);	
							}
						}
						
						// 화면담당자2 정합성체크
						if(epno2 != null && !epno2.equals("")) {
							// 정담당자여부2 필수 체크
							if(mchprYn2 == null || "".equals(mchprYn2) ) {
						        throw new CustomBadRequestException("화면담당자2 에 대한 정담당자여부2는 필수항목입니다. 입력값을 확인하세요["+mchprYn2+"]", ErrorCode.BAD_REQUEST);	
							}
						}
						
						// 화면담당자3 정합성체크
						if(epno3 != null && !epno3.equals("")) {
							// 정담당자여부3 필수 체크
							if(mchprYn3 == null || "".equals(mchprYn3) ) {
						        throw new CustomBadRequestException("화면담당자3 에 대한 정담당자여부3는 필수항목입니다. 입력값을 확인하세요["+mchprYn3+"]", ErrorCode.BAD_REQUEST);	
							}
						}						
					}

					// 기등록 중복 체크
					{
	
						GA09N204VO = SSBS1000V0Dao.selectGA09N204PK(GA09N204VO);
						
						// 신규체크 -> 기등록건체크
						if(prcTp.equals("N")){
							if(GA09N204VO != null) {
						        throw new CustomBadRequestException("[신규등록체크] 기등록 데이터가 존재합니다. 입력값을 확인하세요["+psitMenuId+"]", ErrorCode.BAD_REQUEST);		
							}
						}

						// 수정/삭제 -> 기등록건체크
						if(prcTp.equals("U") || prcTp.equals("D")){
							if(GA09N204VO == null) {
						        throw new CustomBadRequestException("[수정/삭제ㅔ체크] 기등록 데이터가 존재하지않습니다. 입력값을 확인하세요["+psitMenuId+"]", ErrorCode.BAD_REQUEST);		
							}
						}
					}
				}
			}else {
		        throw new CustomBadRequestException("처리대상 입력 건수가 없습니다. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);		
			}

		}

		// 등록/수정/삭제처리 
		{
			cnt = 0;
			gridGA09N204 = vo.getGridGA09N204();
			if(gridGA09N204 != null && gridGA09N204.size() > 0) {
				for(int i=0;i<gridGA09N204.size();i++) {
					GA09N204VO = gridGA09N204.get(i);
					
					prcTp = GA09N204VO.getPrcTp(); /* 처리구분 N-신규 U-수정 D-삭제 */
					
				    psitMenuId  = GA09N204VO.getPsitMenuId();  /*포털사이트메뉴ID*/
				    scrnNm      = GA09N204VO.getScrnNm();  /*화면명          */
				    scrnPcd     = GA09N204VO.getScrnPcd();  /*화면유형코드    */
				    urlAdr      = GA09N204VO.getUrlAdr();  /*URL주소         */
				    useYn       = GA09N204VO.getUseYn();  /*사용여부        */
				    scrnOputSqn = GA09N204VO.getScrnOputSqn();  /*화면출력순서    */
				    epno1 = GA09N204VO.getEpno1();  /*화면담당자1  */
				    epno2 = GA09N204VO.getEpno2();  /*화면담당자2  */
				    epno3 = GA09N204VO.getEpno3();  /*화면담당자3  */
				    mchprYn1 = GA09N204VO.getMchprYn1(); /*정담당자여부1 */	    
				    mchprYn2 = GA09N204VO.getMchprYn2(); /*정담당자여부2 */	    
				    mchprYn3 = GA09N204VO.getMchprYn3(); /*정담당자여부3 */	  
				    kwrdCn = GA09N204VO.getKwrdCn(); /*키워드내용 태그*/
				    
					// 신규등록처리
					if(prcTp.equals("N")){
						mCnt = SSBS1000V0Dao.insertGA09N204(GA09N204VO);
					// 수정처리
					}else if(prcTp.equals("U")){
						mCnt = SSBS1000V0Dao.updateGA09N204(GA09N204VO);
						
					// 삭제처리
					}else if(prcTp.equals("D")){
						mCnt = SSBS1000V0Dao.deleteGA09N204(GA09N204VO);
						
						GA09N209VO = new GA09N209VO();
						GA09N209VO.setPsitMenuId(psitMenuId);
						// 화면담당자 화면번호기준 삭제
						mCnt = SSBS1000V0Dao.deleteGA09N209ByMenuId(GA09N209VO);
					}
					if(mCnt == 0) {
				        throw new CustomBadRequestException("화면관리 신규등록/수정/삭제 오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
					}		
					
					// 화면담당자 삭제등록 처리
					if(mCnt > 0 ) {
						if(prcTp.equals("N") || prcTp.equals("U")){
							GA09N209VO = new GA09N209VO();
							GA09N209VO.setPsitMenuId(psitMenuId);
							
							// 화면담당자 화면번호기준 삭제
							mCnt = SSBS1000V0Dao.deleteGA09N209ByMenuId(GA09N209VO);
							if(epno1 != null && !epno1.equals(""))
							{
								GA09N209VO.setEpno(epno1);
								GA09N209VO.setMchprYn(mchprYn1);
								mCnt = SSBS1000V0Dao.insertGA09N209(GA09N209VO);
							}
							if(epno2 != null && !epno2.equals(""))
							{
								GA09N209VO.setEpno(epno2);
								GA09N209VO.setMchprYn(mchprYn2);
								mCnt = SSBS1000V0Dao.insertGA09N209(GA09N209VO);
							}
							if(epno3 != null && !epno3.equals(""))
							{
								GA09N209VO.setEpno(epno3);
								GA09N209VO.setMchprYn(mchprYn3);
								mCnt = SSBS1000V0Dao.insertGA09N209(GA09N209VO);
							}
							
						}
						
					}
					
					// 화면_키워드 삭제등록 처리
					{
						if(kwrdCn !=null && !kwrdCn.equals("")) {
							String[] kwrdLst = null;
							kwrdLst = kwrdCn.split(";");
							GA09N208VO = new GA09N208VO();
							GA09N208VO.setPsitMenuId(psitMenuId);
							
							// 화면id 기준 키워드 삭제
							mCnt = SSBS1000V0Dao.deleteGA09N208ByMenuId(GA09N208VO);
							
							log.info("kwrdCn ["+kwrdCn+"]");
							log.info("kwrdLst.length ["+kwrdLst.length+"]");
							for(int j=0;j<kwrdLst.length;j++) {
								//log.info("kwrdLst[j] ["+kwrdLst[j]+"]");
								if(!"".equals(kwrdLst[j].trim()) ){
									GA09N208VO = new GA09N208VO();
									GA09N208VO.setPsitMenuId(psitMenuId);
									GA09N208VO.setScrnSrchKwrdVl(kwrdLst[j]);

									// 화면키워드 신규등록
									mCnt = SSBS1000V0Dao.insertGA09N208(GA09N208VO);
								}
							}
						}
					}
				}
				cnt++;
			}
		}
		return cnt;
	}	 
	
    /* 사용자그룹별 사용자관리 목록조회 */
	@Override
	public List<SSBS7100U0Out00VO> selectListGA09N201(SSBS7100U0In00VO vo) {
		// TODO Auto-generated method stub
		return SSBS1000V0Dao.selectListGA09N201(vo);
	}
	
    /* 사용자그룹별 사용자관리 상세조회 PK */
	@Override
	public SSBS7100U0Out01VO selectGA09N201PK(SSBS7100U0In01VO vo) {
		// TODO Auto-generated method stub
		GA09N201VO GA09N201VO = new GA09N201VO();
		SSBS7100U0Out01VO outVo = new SSBS7100U0Out01VO();
		// 입력 데이터 카피
		ObjectCopyUtil.copyFields(vo, GA09N201VO);	

		GA09N201VO = SSBS1000V0Dao.selectGA09N201PK(GA09N201VO);
		
		if(GA09N201VO != null ) {
			// 출력 데이터 카피
			ObjectCopyUtil.copyFields(GA09N201VO,outVo);	
		}
		
		return outVo;
	}
	
	
	/* 사용자그룹_사용자관리 임시저장(수정)/상신 다건 */	
	@Override
	public String reqRegiListGA09N201(SSBS7100U0In03VO vo) {
		// 변수 초기화
		String prcTp = "";
		boolean bfRegiYn = false; /* 기등록 여부 : false-신규등록 true-대상update */
	    String userGrpCd     = null;  /*사용자그룹코드*/      
	    String empOrzTcd     = null;  /*직원조직구분코드 */
	    String orzCd         = null;  /*조직코드 */
	    String epno          = null;  /*사원번호 */ 
	    String rqsScd        = null;  /*신청상태코드 */
	    String rctNo         = null;  /*접수번호 */
	    //String rqsDt         = null;  /*신청일자 */
	    String strtDt        = null;  /*시작일자 */
	    String endDt         = null;  /*종료일자 */
	    String drftDocNo     = null;  /*기안문서번호 */
	    
		// 채번vo
		GaSrno00In00VO rctVo = new GaSrno00In00VO();
		String rqsEpno = null; // 신청사원번호
		String rqsOrzCd = null; // 신청조직코드		
		String unifRqsPcd = "91"; // 통합신청유형코드 : 91(사용자관리)
		int cnt = 0;
		int rctDlNo = 0;
		
		GA01N101VO GA01N101VO = null; /* 통합신청 */
		
		List<GA09N201VO> gridGA09N201 = null;    /* 사용자그룹_사용자 다건내역 */		
		GA09N201VO GA09N201VO = null; /* 사용자그룹_사용자_화면 */
		
		SSBS7100U0In00VO SSBS7100U0In00VO = null; /* 기등록 중복체크 용 */
		SSBS7100U0Out00VO SSBS7100U0Out00VO = null; /* 기등록 중복체크 용 */
		List<SSBS7100U0Out00VO> outList = null;    /* 기등록 중복체크 다건내역 */		
		
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
			
			// 사용자그룹_사용자 입력값 체크
			gridGA09N201 = vo.getGridGA09N201();
			if(gridGA09N201 != null && gridGA09N201.size() > 0) {
				for(int i=0;i<gridGA09N201.size();i++) {
					GA09N201VO = gridGA09N201.get(i);
				    userGrpCd = GA09N201VO.getUserGrpCd()  ;  /*사용자그룹코드*/
				    rctNo = GA09N201VO.getRctNo()    ;  /*접수번호*/
				    drftDocNo = GA09N201VO.getDrftDocNo(); /* 기안문서 */
				    empOrzTcd = GA09N201VO.getEmpOrzTcd(); /*사원조직구분코드 */
				    orzCd = GA09N201VO.getOrzCd();
				    epno = GA09N201VO.getEpno();
				    strtDt = GA09N201VO.getStrtDt();
				    endDt = GA09N201VO.getEndDt();
				    
					// 사용자그룹코드 필수 체크
					if(userGrpCd == null || "".equals(userGrpCd) ) {
				        throw new CustomBadRequestException("필수입력항목 사용자그룹_사용자[사용자그룹코드] 오류. 입력값을 확인하세요["+userGrpCd+"]", ErrorCode.BAD_REQUEST);		
					}
					
					// 사원조직구분코드 필수 체크
					if(empOrzTcd == null || "".equals(empOrzTcd) ) {
				        throw new CustomBadRequestException("필수입력항목 사용자그룹_사용자[사원조직구분코드] 오류. 입력값을 확인하세요["+empOrzTcd+"]", ErrorCode.BAD_REQUEST);		
					}else {
						// 사원조직구분코드 01:사원 02:조직
						if("01".equals(empOrzTcd) ) {
							if(epno == null || "".equals(epno) ) {
						        throw new CustomBadRequestException("필수입력항목 사원조직구분코드 01:사원 사용자그룹_사용자[사원번호] 오류. 입력값을 확인하세요["+epno+"]", ErrorCode.BAD_REQUEST);		
							}	
						}
						// 사원조직구분코드 01:사원 02:조직
						if("02".equals(empOrzTcd) ) {
							if(orzCd == null || "".equals(orzCd) ) {
						        throw new CustomBadRequestException("필수입력항목 사원조직구분코드 02:조직 사용자그룹_사용자[조직코드] 오류. 입력값을 확인하세요["+orzCd+"]", ErrorCode.BAD_REQUEST);		
							}	
						}					
					}
					
					// 시작일자 필수 체크
					if(strtDt == null || "".equals(strtDt) ) {
				        throw new CustomBadRequestException("필수입력항목 사용자그룹_사용자[시작일자] 오류. 입력값을 확인하세요["+strtDt+"]", ErrorCode.BAD_REQUEST);		
					}					
					// 종료일자 필수 체크
					if(endDt == null || "".equals(endDt) ) {
				        throw new CustomBadRequestException("필수입력항목 사용자그룹_사용자[종료일자] 오류. 입력값을 확인하세요["+endDt+"]", ErrorCode.BAD_REQUEST);		
					}					
					
					/*
					// 기안문서 필수 체크
					if(GA09N205VO.getDrftDocNo() == null || "".equals(GA09N205VO.getDrftDocNo()) ) {
				        throw new CustomBadRequestException("필수입력항목 사용자그룹별 화면관리[기안문서] 오류. 입력값을 확인하세요["+GA09N205VO.getDrftDocNo()+"]", ErrorCode.BAD_REQUEST);		
					}
					*/
					
					// 기등록 체크
					if(rctNo != null && !"".equals(rctNo)){
						GA09N201VO = SSBS1000V0Dao.selectGA09N201PK(GA09N201VO);
						
						if(GA09N201VO == null ) {
					        throw new CustomBadRequestException("기등록 데이터가 존재하지않습니다.. 입력값을 확인하세요["+userGrpCd+"]["+rctNo+"]", ErrorCode.BAD_REQUEST);		
						}
						
						// 기등록 상태체크 
						if (!Arrays.asList("00").contains(GA09N201VO.getRqsScd())) {
					        throw new CustomBadRequestException("기등록 데이터 상태체크 오류. 임시저장상태만 상신/저장 가능합니다. 신청상태["+GA09N201VO.getRqsScd()+"]를 확인하세요 ["+userGrpCd+"]["+rctNo+"]", ErrorCode.BAD_REQUEST);								
						}									
						
					}else{
						/* 기등록 중복 체크 */
						
						/* 사용자그룹_사용자 정상건 목록조회*/
						SSBS7100U0In00VO = new SSBS7100U0In00VO();
						SSBS7100U0In00VO.setUserGrpCd(userGrpCd);
						SSBS7100U0In00VO.setEmpOrzTcd(empOrzTcd);
						SSBS7100U0In00VO.setEpno(epno);
						SSBS7100U0In00VO.setOrzCd(orzCd);
						SSBS7100U0In00VO.setQryStrtDt(strtDt);
						SSBS7100U0In00VO.setQryEndDt(endDt);
						
						outList = SSBS1000V0Dao.selectListGA09N201ByNrml(SSBS7100U0In00VO);
						if(outList != null && outList.size() > 0) {
					        throw new CustomBadRequestException("기등록 데이터가 존재합니다. 입력값을 확인하세요["+userGrpCd+"]["+empOrzTcd+"]["+epno+"]["+orzCd+"]["+strtDt+"]["+endDt+"]", ErrorCode.BAD_REQUEST);		
						}						
					}
					
				}
			}else {
		        throw new CustomBadRequestException("신규 대상건이 입력 건수가 없습니다. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);		
			}

		}

		// 임시저장/상신 -> 등록/수정 
		{
			// 사용자그룹_사용자 GA09N201VO : INSERT 처리
			{
				// 사용자그룹_사용자 입력값 체크
				gridGA09N201 = vo.getGridGA09N201();
				if(gridGA09N201 != null && gridGA09N201.size() > 0) {
					for(int i=0;i<gridGA09N201.size();i++) {
						GA09N201VO = gridGA09N201.get(i);
					    userGrpCd = GA09N201VO.getUserGrpCd()  ;  /*사용자그룹코드*/
					    rctNo = GA09N201VO.getRctNo()    ;  /*접수번호*/
					    drftDocNo = GA09N201VO.getDrftDocNo(); /* 기안문서 */
					    empOrzTcd = GA09N201VO.getEmpOrzTcd(); /*사원조직구분코드 */
					    orzCd = GA09N201VO.getOrzCd();
					    epno = GA09N201VO.getEpno();
					    strtDt = GA09N201VO.getStrtDt();
					    endDt = GA09N201VO.getEndDt();
					    
						// 기등록 접수번호 채번
						if(rctNo == null || "".equals(rctNo)){
							bfRegiYn = false;
						}else {
							bfRegiYn = true;
						}

						// 기등록 접수번호 채번
						if(!bfRegiYn){
							// 통합신청 신규접수번호 채번
							rctVo.setCdKndNo("CHAEBUN");
							rctVo.setCmnCdVl(unifRqsPcd); // 화면권한:91
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
							GA01N101VO.setRqsRsnCn("사용자그룹_사용자");
							GA01N101VO.setRqsDt(rqsDt);
							
							if(prcTp.equals("00")) { // 임시저장
								GA01N101VO.setRqsScd(CD_RQS_SCD_TMP_STRG);
							}
							if(prcTp.equals("01")) { // 상신
								GA01N101VO.setRqsScd(CD_RQS_SCD_APV_ING);
							}
	
						}						
						
						// 통합신청 데이터 세팅 (GA01N101)
						if(bfRegiYn){ // 기등록 수정
							// 수정
							cnt = RQSR1000U0Dao.updateGA01N101(GA01N101VO);		
							if(cnt == 0) {
						        throw new CustomBadRequestException("신규등록 생성오류(통합신청). 입력값을 확인하세요", ErrorCode.BAD_REQUEST);							
							}
						}else{ // 신규등록
							// 신규등록
							cnt = RQSR1000U0Dao.insertGA01N101(GA01N101VO);		
							if(cnt == 0) {
						        throw new CustomBadRequestException("신규등록 생성오류(통합신청). 입력값을 확인하세요", ErrorCode.BAD_REQUEST);							
							}
						}

						// 사용자그룹_사용자
						{
						    GA09N201VO.setRctNo(rctNo);

						    if(bfRegiYn){ // 기등록 수정
							    cnt = SSBS1000V0Dao.updateGA09N201(GA09N201VO);
								if(cnt == 0) {
							        throw new CustomBadRequestException("사용자그룹_사용자 수정오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
								}
						    	
						    }else { // 신규등록 
						    	
							    cnt = SSBS1000V0Dao.insertGA09N201(GA09N201VO);
								if(cnt == 0) {
							        throw new CustomBadRequestException("사용자그룹_사용자 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
								}
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
						if(prcTp.equals("01")) {
							if(true) {
								
								log.info("결재 모듈 ============["+rctNo+"] ["+rqsEpno+"][" + rqsOrzCd +"] ["+unifRqsPcd+"] ["+PSIT_MENU_ID_91+"]");				
								// 상신 결재 등록 --> 여기서 결재선 모듈 호출
								newAprvWrrptMtNo = aprvWrrpt.aprvWrrpt(rctNo, rqsEpno, rqsOrzCd, unifRqsPcd, PSIT_MENU_ID_91);

								log.info("newAprvWrrptMtNo ["+newAprvWrrptMtNo+"]");
							}						
						}
					}
				}
			}
		}

		log.info("rctNo ["+rctNo+"]");
		
		return rctNo;
	}	  
	
	/* 사용자그룹_사용자관리 임시저장(수정)/상신 단건 */	
	@Override
	public String reqRegiGA09N201(SSBS7100U0In04VO vo) {
		// 변수 초기화
		String prcTp = "";
		boolean bfRegiYn = false; /* 기등록 여부 : false-신규등록 true-대상update */
	    String userGrpCd     = null;  /*사용자그룹코드*/      
	    String empOrzTcd     = null;  /*직원조직구분코드 */
	    String orzCd         = null;  /*조직코드 */
	    String epno          = null;  /*사원번호 */ 
	    String rqsScd        = null;  /*신청상태코드 */
	    String rctNo         = null;  /*접수번호 */
	    //String rqsDt         = null;  /*신청일자 */
	    String strtDt        = null;  /*시작일자 */
	    String endDt         = null;  /*종료일자 */
	    String drftDocNo     = null;  /*기안문서번호 */
	    
		// 채번vo
		GaSrno00In00VO rctVo = new GaSrno00In00VO();
		String rqsEpno = null; // 신청사원번호
		String rqsOrzCd = null; // 신청조직코드		
		String unifRqsPcd = "91"; // 통합신청유형코드 : 91(사용자관리)
		int cnt = 0;
		
		GA01N101VO GA01N101VO = null; /* 통합신청 */
		GA09N201VO GA09N201VO = null; /* 사용자그룹_사용자 */
		
		SSBS7100U0In00VO SSBS7100U0In00VO = null;  /* 기등록 중복체크 입력 */
		List<SSBS7100U0Out00VO> outList = null;    /* 기등록 중복체크 다건내역 */

		GA01N109VO GA01N109VO = null; // 통합기안문서
		
	    String newAprvWrrptMtNo = null; // 결재상신관리번호
		
		// 전처리 : 입력값 체크
		{
			rqsEpno  = vo.getRqsEpno();
			rqsOrzCd = vo.getRqsOrzCd();
			prcTp = vo.getPrcTp();
			
		    userGrpCd = vo.getUserGrpCd()  ;  /*사용자그룹코드*/
		    rctNo = vo.getRctNo()    ;  /*접수번호*/
		    drftDocNo = vo.getDrftDocNo(); /* 기안문서 */
		    empOrzTcd = vo.getEmpOrzTcd(); /*사원조직구분코드 */
		    orzCd = vo.getOrzCd();
		    epno = vo.getEpno();
		    strtDt = vo.getStrtDt();
		    endDt = vo.getEndDt();
		    
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
			if(userGrpCd == null || "".equals(userGrpCd) ) {
		        throw new CustomBadRequestException("필수입력항목 사용자그룹_사용자[사용자그룹코드] 오류. 입력값을 확인하세요["+userGrpCd+"]", ErrorCode.BAD_REQUEST);		
			}
			// 사원조직구분코드 필수 체크
			if(empOrzTcd == null || "".equals(empOrzTcd) ) {
		        throw new CustomBadRequestException("필수입력항목 사용자그룹_사용자[사원조직구분코드] 오류. 입력값을 확인하세요["+empOrzTcd+"]", ErrorCode.BAD_REQUEST);		
			}else {
				// 사원조직구분코드 01:사원 02:조직
				if("01".equals(empOrzTcd) ) {
					if(epno == null || "".equals(epno) ) {
				        throw new CustomBadRequestException("필수입력항목 사원조직구분코드 01:사원 사용자그룹_사용자[사원번호] 오류. 입력값을 확인하세요["+epno+"]", ErrorCode.BAD_REQUEST);		
					}	
				}
				// 사원조직구분코드 01:사원 02:조직
				if("02".equals(empOrzTcd) ) {
					if(orzCd == null || "".equals(orzCd) ) {
				        throw new CustomBadRequestException("필수입력항목 사원조직구분코드 02:조직 사용자그룹_사용자[조직코드] 오류. 입력값을 확인하세요["+orzCd+"]", ErrorCode.BAD_REQUEST);		
					}	
				}					
			}
			// 시작일자 필수 체크
			if(strtDt == null || "".equals(strtDt) ) {
		        throw new CustomBadRequestException("필수입력항목 사용자그룹_사용자[시작일자] 오류. 입력값을 확인하세요["+strtDt+"]", ErrorCode.BAD_REQUEST);		
			}					
			// 종료일자 필수 체크
			if(endDt == null || "".equals(endDt) ) {
		        throw new CustomBadRequestException("필수입력항목 사용자그룹_사용자[종료일자] 오류. 입력값을 확인하세요["+endDt+"]", ErrorCode.BAD_REQUEST);		
			}					
			
		
			
			/*
			// 기안문서 필수 체크
			if(GA09N205VO.getDrftDocNo() == null || "".equals(GA09N205VO.getDrftDocNo()) ) {
		        throw new CustomBadRequestException("필수입력항목 사용자그룹별 화면관리[기안문서] 오류. 입력값을 확인하세요["+GA09N205VO.getDrftDocNo()+"]", ErrorCode.BAD_REQUEST);		
			}
			*/
			
			// 기등록 체크
			if(rctNo != null && !"".equals(rctNo)){
				// 시용자그룹_사용자 객체복사
				GA09N201VO = new GA09N201VO();
				ObjectCopyUtil.copyFields(vo, GA09N201VO);
				
				GA09N201VO = SSBS1000V0Dao.selectGA09N201PK(GA09N201VO);
				
				if(GA09N201VO == null ) {
			        throw new CustomBadRequestException("기등록 데이터가 존재하지않습니다.. 입력값을 확인하세요["+userGrpCd+"]["+rctNo+"]", ErrorCode.BAD_REQUEST);		
				}
				
				// 기등록 상태체크 
				if (!Arrays.asList("00").contains(GA09N201VO.getRqsScd())) {
			        throw new CustomBadRequestException("기등록 데이터 상태체크 오류. 임시저장상태만 상신/저장 가능합니다. 신청상태["+GA09N201VO.getRqsScd()+"]를 확인하세요 ["+userGrpCd+"]["+rctNo+"]", ErrorCode.BAD_REQUEST);								
				}									
				
			}else{
				/* 기등록 중복 체크 */
				
				/* 사용자그룹_사용자 정상건 목록조회*/
				SSBS7100U0In00VO = new SSBS7100U0In00VO();
				SSBS7100U0In00VO.setUserGrpCd(userGrpCd);
				SSBS7100U0In00VO.setEmpOrzTcd(empOrzTcd);
				SSBS7100U0In00VO.setEpno(epno);
				SSBS7100U0In00VO.setOrzCd(orzCd);
				SSBS7100U0In00VO.setQryStrtDt(strtDt);
				SSBS7100U0In00VO.setQryEndDt(endDt);
				
				outList = SSBS1000V0Dao.selectListGA09N201ByNrml(SSBS7100U0In00VO);
				if(outList != null && outList.size() > 0) {
			        throw new CustomBadRequestException("기등록 데이터가 존재합니다. 입력값을 확인하세요["+userGrpCd+"]["+empOrzTcd+"]["+epno+"]["+orzCd+"]["+strtDt+"]["+endDt+"]", ErrorCode.BAD_REQUEST);		
				}						
			}
			
		}

		// 임시저장/상신 -> 등록/수정 
		{
			// 기등록 접수번호 채번
			if(rctNo == null || "".equals(rctNo)){
				bfRegiYn = false;
			}else {
				bfRegiYn = true;
			}

			// 기등록 접수번호 채번
			if(!bfRegiYn){
				// 통합신청 신규접수번호 채번
				rctVo.setCdKndNo("CHAEBUN");
				rctVo.setCmnCdVl(unifRqsPcd); // 화면권한:91
				rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
				rctNo = rctVo.getRpbzGnoSrno();

				log.info("접수번호 채번 rctNo ============["+rctNo+"]");								
			}

			// 통합신청 데이터 세팅 (GA01N101)
			{
				String rqsDt = DateUtil.getTodayString("yyyyMMdd");
				
				// 통합신청  
				GA01N101VO = new GA01N101VO();
				GA01N101VO.setRctNo(rctNo);
				GA01N101VO.setRqsEpno(rqsEpno);
				GA01N101VO.setRqsOrzCd(rqsOrzCd);
				GA01N101VO.setUnifRqsPcd(unifRqsPcd);
				GA01N101VO.setUnifRqsTcd(unifRqsPcd+"0101");
				GA01N101VO.setUnifRqsDlPcd(unifRqsPcd+"01");
				//GA01N101VO.setHopeDt();
				GA01N101VO.setRqsRsnCn("사용자그룹_사용자");
				GA01N101VO.setRqsDt(rqsDt);
				
				if(prcTp.equals("00")) { // 임시저장
					GA01N101VO.setRqsScd(CD_RQS_SCD_TMP_STRG);
				}
				if(prcTp.equals("01")) { // 상신
					GA01N101VO.setRqsScd(CD_RQS_SCD_APV_ING);
				}

			}						
			
			// 통합신청 데이터 처리 (GA01N101)
			if(bfRegiYn){ // 기등록 수정
				// 수정
				cnt = RQSR1000U0Dao.updateGA01N101(GA01N101VO);		
				if(cnt == 0) {
			        throw new CustomBadRequestException("기등록 수정오류(통합신청). 입력값을 확인하세요", ErrorCode.BAD_REQUEST);							
				}
			}else{ // 신규등록
				// 신규등록
				cnt = RQSR1000U0Dao.insertGA01N101(GA01N101VO);		
				if(cnt == 0) {
			        throw new CustomBadRequestException("신규등록 생성오류(통합신청). 입력값을 확인하세요", ErrorCode.BAD_REQUEST);							
				}
			}

			// 사용자그룹_사용자
			{
				GA09N201VO =  new GA09N201VO();
				ObjectCopyUtil.copyFields(vo, GA09N201VO);
				
			    GA09N201VO.setRctNo(rctNo);

			    if(bfRegiYn){ // 기등록 수정
				    cnt = SSBS1000V0Dao.updateGA09N201(GA09N201VO);
					if(cnt == 0) {
				        throw new CustomBadRequestException("사용자그룹_사용자 수정오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
					}
			    	
			    }else { // 신규등록 
			    	
				    cnt = SSBS1000V0Dao.insertGA09N201(GA09N201VO);
					if(cnt == 0) {
				        throw new CustomBadRequestException("사용자그룹_사용자 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
					}
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
			if(prcTp.equals("01")) {
				if(true) {
					
					log.info("결재 모듈 ============["+rctNo+"] ["+rqsEpno+"][" + rqsOrzCd +"] ["+unifRqsPcd+"] ["+PSIT_MENU_ID_91+"]");				
					// 상신 결재 등록 --> 여기서 결재선 모듈 호출
					newAprvWrrptMtNo = aprvWrrpt.aprvWrrpt(rctNo, rqsEpno, rqsOrzCd, unifRqsPcd, PSIT_MENU_ID_91);

					log.info("newAprvWrrptMtNo ["+newAprvWrrptMtNo+"]");
				}						
			}
		}

		log.info("rctNo ["+rctNo+"]");
		
		return rctNo;
	}	     
	
}
