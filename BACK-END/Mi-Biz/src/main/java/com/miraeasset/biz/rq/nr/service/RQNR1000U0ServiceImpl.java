package com.miraeasset.biz.rq.nr.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.code.vo.GaSrno00In00VO;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA03N102VO;
import com.miraeasset.biz.common.meta.vo.GA03N104VO;
import com.miraeasset.biz.common.meta.vo.GA03N105VO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.aprvWrrpt.AprvWrrpt;
import com.miraeasset.biz.rq.nr.dao.RQNR1000U0Dao;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0In00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0In01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0Out00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0Out01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0Out02VO;
import com.miraeasset.biz.rq.sr.dao.RQSR1000U0Dao;

@Service
@Transactional
public class RQNR1000U0ServiceImpl implements RQNR1000U0Service {

	@Autowired
	RQNR1000U0Dao dao;
	
	@Autowired
	RQSR1000U0Dao RQSR1000U0Dao;
	
	@Autowired
	CodeDao CodeDao;	
	
	@Autowired
	AprvWrrpt aprvWrrpt;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/* APRV_PCD 코드값 정의 */
	private final String CD_APRV_PCD_NMCRD = "04"; // 명함
	
	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "00"; // 임시저장 
	private final String CD_RQS_SCD_APV_ING  = "05"; // 승인중 
	private final String CD_RQS_SCD_APV_CMPN = "10"; // 승인완료 
	
	private final String CD_UNIF_RQS_PCD_NMCRD  = "04"; // 신청유형코드: 04 명함
	
	private final String CD_ATCL_TCD_NMCRD  = "01"; // 물품구분코드: 01 명함 
	
	private final String PSIT_MENU_ID = "RQNR1000m0";
	
	/**
	 * 명함신청-사용자 정보 조회 
	 */
	@Override
	public RQNR1000U0Out00VO selectEpInfo(RQNR1000U0In00VO vo) {
		return dao.selectEpInfo(vo);
	}
	
	
	/**
	 * 명함신청-사용자 자격증 조회 
	 */
	@Override
	public List<RQNR1000U0Out01VO> selectEpLcnsList(RQNR1000U0In00VO vo) {
		return dao.selectEpLcnsList(vo);
	}
	
	
	/**
	 * 명함신청 - 주소 조회 
	 */
	@Override
	public List<RQNR1000U0Out02VO> selectAdrList(RQNR1000U0In00VO vo) {
		
		int tmp = dao.selectAdrList_CNT(vo); 
		vo.setTotCnt(tmp);
		
		return dao.selectAdrList(vo);
	}

	
	/**
	 * 명함신청-임시저장/상신
	 */
	@Override
	public String reqRegi(RQNR1000U0In01VO vo) {
		
		String prcTp = "";
		boolean bfRegiYn = false; /* 기등록 여부 : false-신규등록 true-대상update */
		
		// 접수번호 채번vo
		GaSrno00In00VO rctVo = new GaSrno00In00VO();
		String unifRqsPcd = CD_UNIF_RQS_PCD_NMCRD;  // 신청유형코드 04:명함
		
		int cnt = 0;
		
		String newAprvWrrptMtNo = null; // 신규결재관리번호
		
		String rctNo = null; //접수번호(신규접수일자)
		String rqsEpno = null; // 신청사원번호
		String rqsOrzCd = null; // 신청조직코드	
		String inqOrzCd = null; // 입고조직코드
		String inqLocNm = null; // 입고상세위치명	
		String inqDlLocNm = null; // 입고상세위치명	
		
		GA01N101VO GA01N101VO = null; /* 통합신청 */
		GA03N104VO GA03N104VO = null; /* 명함신청 */
		
		List<GA03N102VO> gridGA03N102 = null; // 명함신청내역
		GA03N102VO GA03N102VO = null;
		List<GA03N105VO> gridGA03N105 = null; // 명함상세
		GA03N105VO GA03N105VO = null;
		
		
		
		// 전처리 : 입력값 체크
		{
			rctNo = vo.getRctNo();
			rqsEpno  = vo.getRqsEpno();
			rqsOrzCd = vo.getRqsOrzCd();
			prcTp = vo.getPrcTp();
			
			inqOrzCd = vo.getInqOrzCd();
			inqLocNm = vo.getInqLocNm();
			inqDlLocNm = vo.getInqDlLocNm();
			
			log.info("입력접수번호 rctNo ============["+rctNo+"]");	
			if(rctNo != null && !"".equals(rctNo)) {
				bfRegiYn = true; // 기등록 여부 세팅
			}
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
			if(inqOrzCd == null || inqOrzCd.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[입고부서코드] 오류. 입력값을 확인하세요["+inqOrzCd+"]", ErrorCode.BAD_REQUEST);		
			}
			if(inqLocNm == null || inqLocNm.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[입고부서명] 오류. 입력값을 확인하세요["+inqLocNm+"]", ErrorCode.BAD_REQUEST);		
			}
			if(inqDlLocNm == null || inqDlLocNm.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[상세위치] 오류. 입력값을 확인하세요["+inqDlLocNm+"]", ErrorCode.BAD_REQUEST);		
			}
			
			gridGA03N102 = vo.getGridGA03N102();
			gridGA03N105 = vo.getGridGA03N105();
			if((gridGA03N102==null || gridGA03N102.size()==0) 
			|| (gridGA03N105==null || gridGA03N105.size()==0)){
				throw new CustomBadRequestException("필수입력항목 명함신청 내역 없음", ErrorCode.BAD_REQUEST);
			}
			
			// 명함신청내역
			if(gridGA03N102 != null && gridGA03N102.size() > 0) {
				for(int i=0;i<gridGA03N102.size();i++) {
					GA03N102VO = gridGA03N102.get(i);
					
					// 거래처코드
					if(GA03N102VO.getDelpCd() == null || "".equals(GA03N102VO.getDelpCd()) ) {
				        throw new CustomBadRequestException("필수입력항목 명함신청내역[거래처코드] 오류. 입력값을 확인하세요["+GA03N102VO.getDelpCd()+"]", ErrorCode.BAD_REQUEST);		
					}
					// 명함스타일
					if(GA03N102VO.getAtclCd() == null || "".equals(GA03N102VO.getAtclCd()) ) {
				        throw new CustomBadRequestException("필수입력항목 명함신청내역[명함스타일] 오류. 입력값을 확인하세요["+GA03N102VO.getAtclCd()+"]", ErrorCode.BAD_REQUEST);		
					}
					
					// 사번 
					if(GA03N102VO.getEpno() == null || "".equals(GA03N102VO.getEpno()) ) {
				        throw new CustomBadRequestException("필수입력항목 명함신청내역[사번] 오류. 입력값을 확인하세요["+GA03N102VO.getEpno()+"]", ErrorCode.BAD_REQUEST);		
					}
					// 수량
					if(GA03N102VO.getPchQ() == null || GA03N102VO.getPchQ().compareTo(BigDecimal.ZERO) <= 0 ) {
				        throw new CustomBadRequestException("필수입력항목 명함신청내역[신청수량] 오류. 입력값을 확인하세요["+GA03N102VO.getPchQ()+"]", ErrorCode.BAD_REQUEST);		
					}	
					
				}
			}
			
			// 명함상세
			if(gridGA03N105 != null && gridGA03N105.size() > 0) {
				for(int i=0;i<gridGA03N105.size();i++) {
					GA03N105VO = gridGA03N105.get(i);
					// 명함스타일
					if(GA03N105VO.getAtclCd() == null || "".equals(GA03N105VO.getAtclCd()) ) {
				        throw new CustomBadRequestException("필수입력항목 명함상세[명함스타일] 오류. 입력값을 확인하세요["+GA03N105VO.getAtclCd()+"]", ErrorCode.BAD_REQUEST);		
					}
					
					// 직책/직급(국문, 영문)
					//if( (GA03N105VO.getNlJrnkNm() == null   || "".equals(GA03N105VO.getNlJrnkNm()))  // 국문직급명
					//  && (GA03N105VO.getEngJrnkNm() == null || "".equals(GA03N105VO.getEngJrnkNm())) // 영문직급명
					//  && (GA03N105VO.getNlOsdtNm() == null  || "".equals(GA03N105VO.getNlOsdtNm()))  // 국문직책명
					//  && (GA03N105VO.getEngOsdtNm() == null || "".equals(GA03N105VO.getEngOsdtNm())) // 영문직책명
					//  ) {
				    //    throw new CustomBadRequestException("필수입력항목 명함상세[직책/직급(국문, 영문)] 오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);		
					//}
					
					// 이름(국문) 
					if(GA03N105VO.getNlNm() == null || "".equals(GA03N105VO.getNlNm())) {
				        throw new CustomBadRequestException("필수입력항목 명함상세[이름] 오류. 입력값을 확인하세요["+GA03N105VO.getNlNm()+"]", ErrorCode.BAD_REQUEST);		
					}
					// 이름(영문) 
					//if(GA03N105VO.getEngNm() == null || "".equals(GA03N105VO.getEngNm())) {
				    //    throw new CustomBadRequestException("필수입력항목 명함상세[Name] 오류. 입력값을 확인하세요["+GA03N105VO.getEngNm()+"]", ErrorCode.BAD_REQUEST);		
					//}
					
					// 우편번호
					if(GA03N105VO.getZpcd() == null || "".equals(GA03N105VO.getZpcd())) {
				        throw new CustomBadRequestException("필수입력항목 명함상세[우편번호] 오류. 입력값을 확인하세요["+GA03N105VO.getZpcd()+"]", ErrorCode.BAD_REQUEST);		
					}
					// 직장주소
					if(GA03N105VO.getWkpAdrEcpVl() == null || "".equals(GA03N105VO.getWkpAdrEcpVl())) {
				        throw new CustomBadRequestException("필수입력항목 명함상세[직장주소] 오류. 입력값을 확인하세요["+GA03N105VO.getWkpAdrEcpVl()+"]", ErrorCode.BAD_REQUEST);		
					}
					// Address
					if(GA03N105VO.getEngWkpAdrEcpVl() == null || "".equals(GA03N105VO.getEngWkpAdrEcpVl())) {
				        throw new CustomBadRequestException("필수입력항목 명함상세[Address] 오류. 입력값을 확인하세요["+GA03N105VO.getEngWkpAdrEcpVl()+"]", ErrorCode.BAD_REQUEST);		
					}
					// Tel
					if(GA03N105VO.getEmpOfcTlno() == null || "".equals(GA03N105VO.getEmpOfcTlno())) {
				        throw new CustomBadRequestException("필수입력항목 명함상세[Tel] 오류. 입력값을 확인하세요["+GA03N105VO.getEmpOfcTlno()+"]", ErrorCode.BAD_REQUEST);		
					}
					
				}
			}
			
			// 기등록 데이터 체크
			if(bfRegiYn) {
				GA01N101VO = new GA01N101VO();
				GA01N101VO.setRctNo(rctNo);

				GA01N101VO = RQSR1000U0Dao.selectGA01N101(GA01N101VO);
				
				if(GA01N101VO == null) {
			        throw new CustomBadRequestException("통합신청 대상건이 존재하지않습니다. 접수번호를 확인하세요["+rctNo+"]", ErrorCode.BAD_REQUEST);						
				}
				
				if(GA01N101VO.getRqsScd() == null ) {
			        throw new CustomBadRequestException("통합신청 신청상태코드를 확인하세요. ["+GA01N101VO.getRqsScd()+"]", ErrorCode.BAD_REQUEST);						
				}else {
					if(!CD_RQS_SCD_TMP_STRG.equals(GA01N101VO.getRqsScd()) ){
				        throw new CustomBadRequestException("통합신청 신청상태코드를 확인하세요. 임시저장상태일경우만 처리 가능합니다. ["+GA01N101VO.getRqsScd()+"]["+GA01N101VO.getRqsScdNm()+"]", ErrorCode.BAD_REQUEST);						
					}
				}
			}
		}
		
		
		// 임시저장/상신 -> 등록/수정 
		{
			if(!bfRegiYn) {
				// 통합신청 신규접수번호 채번
				rctVo.setCdKndNo("CHAEBUN");
				rctVo.setCmnCdVl(unifRqsPcd);
				rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
				rctNo = rctVo.getRpbzGnoSrno();

				log.info("접수번호 채번 rctNo ============["+rctNo+"]");	
			}
			
			// 1.통합신청 (GA01N101)
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
				GA01N101VO.setUnifRqsTcd(unifRqsPcd+"0101"); // 고정값: 나의업무 구분
				GA01N101VO.setUnifRqsDlPcd(unifRqsPcd+"01"); // 고정값
				GA01N101VO.setRqsDt(rqsDt);
	
				// 임시저장
				if(prcTp.equals("00")) {
					GA01N101VO.setRqsScd(CD_RQS_SCD_TMP_STRG);
				}
				// 상신: 승인중 상태로 변경
				else if(prcTp.equals("01")) {
					GA01N101VO.setRqsScd(CD_RQS_SCD_APV_ING);
				}
				
				if(bfRegiYn) {
					// 기등록 수정
					cnt = RQSR1000U0Dao.updateGA01N101(GA01N101VO);		
					if(cnt == 0) {
				        throw new CustomBadRequestException("총합신청 수정오류(통합신청). 입력값을 확인하세요", ErrorCode.BAD_REQUEST);							
					}						
				}else {
					// 신규등록
					cnt = RQSR1000U0Dao.insertGA01N101(GA01N101VO);		
					if(cnt == 0) {
				        throw new CustomBadRequestException("신규등록 생성오류(통합신청). 입력값을 확인하세요", ErrorCode.BAD_REQUEST);							
					}							
				}
			}
			
			// 2.명함신청 (GA03N104) 
			{
				GA03N104VO = new GA03N104VO();
				
				ObjectCopyUtil.copyFields(vo, GA03N104VO);
				GA03N104VO.setRctNo(rctNo);
				
				cnt = dao.deleteGA03N104ByRctNo(rctNo);
				cnt = dao.insertGA03N104(GA03N104VO);
				if(cnt == 0) {
			        throw new CustomBadRequestException("명함신청 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
				}
			}
			
			// 3.명함신청내역 (GA03N102)
			{
				GA03N102VO = new GA03N102VO();
				GA03N102VO.setRctNo(rctNo);
				
				cnt = dao.deleteGA03N102ByRctNo(rctNo);
				
				gridGA03N102 = vo.getGridGA03N102();
				
				for(int i=0;i<gridGA03N102.size();i++) {
					
					GA03N102VO = gridGA03N102.get(i);
					GA03N102VO.setAtclTcd(CD_ATCL_TCD_NMCRD); 
					GA03N102VO.setRctNo(rctNo);
					cnt = dao.insertGA03N102(GA03N102VO);
					if(cnt == 0) {
				        throw new CustomBadRequestException("명함 신청내역 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
					}
				}
			}
			
			// 4.명함신청상세 (GA03N105)
			{
				GA03N105VO = new GA03N105VO();
				GA03N105VO.setRctNo(rctNo);
				
				cnt = dao.deleteGA03N105ByRctNo(rctNo);
				
				gridGA03N105 = vo.getGridGA03N105();
				
				for(int i=0;i<gridGA03N105.size();i++) {
					
					GA03N105VO = gridGA03N105.get(i);
					GA03N105VO.setAtclTcd(CD_ATCL_TCD_NMCRD);  
					GA03N105VO.setRctNo(rctNo);
					
					String celNo = GA03N105VO.getCellNo();
					if(!StringUtils.isBlank(celNo)) {
						String[] arr1 = celNo.split("-");
						
						if(arr1 != null && arr1.length >2) {
							GA03N105VO.setRtn(arr1[0]);
							GA03N105VO.setMtno(arr1[1]);
							GA03N105VO.setItno(arr1[2]);
						}
					}
					
					String telNo = GA03N105VO.getEmpOfcTlno();
					if(!StringUtils.isBlank(telNo)) {
						String[] arr2 = telNo.split("-");
						
						if(arr2 != null && arr2.length >2) {
							GA03N105VO.setHndpBzprTlno(arr2[0]);
							GA03N105VO.setHndpMtno(arr2[1]);
							GA03N105VO.setHndpItno(arr2[2]);
						}
					}
					
					cnt = dao.insertGA03N105(GA03N105VO);
					if(cnt == 0) {
				        throw new CustomBadRequestException("명함 신청상세 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
					}
				}
			}
			
			// 상신:결재상신처리
			if(prcTp.equals("01")) {
				
				log.info("결재 모듈 ============["+rctNo+"] ["+rqsEpno+"][" + rqsOrzCd +"] ["+CD_APRV_PCD_NMCRD+"]");				
				 
				// 상신 결재 등록 --> 여기서 결재선 모듈 호출
				newAprvWrrptMtNo = aprvWrrpt.aprvWrrpt(rctNo, rqsEpno, rqsOrzCd, CD_APRV_PCD_NMCRD, PSIT_MENU_ID);

				log.info("newAprvWrrptMtNo ["+newAprvWrrptMtNo+"]");
			}
			
		}
		
		return rctNo;
	}
	
}
