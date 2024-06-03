package com.miraeasset.biz.rq.pr.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.apache.tika.utils.StringUtils;
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
import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA03N102VO;
import com.miraeasset.biz.common.meta.vo.GA03N103VO;
import com.miraeasset.biz.common.meta.vo.GA03N104VO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.aprvWrrpt.AprvWrrpt;
import com.miraeasset.biz.common.util.massage.MsgSenService;
import com.miraeasset.biz.rq.am.dao.RQAM1000U0Dao;
import com.miraeasset.biz.rq.nr.dao.RQNR1000U0Dao;
import com.miraeasset.biz.rq.pr.dao.RQPR1000U0Dao;
import com.miraeasset.biz.rq.pr.vo.RQPR1000U0In00VO;
import com.miraeasset.biz.rq.sr.dao.RQSR1000U0Dao;

@Service
@Transactional
public class RQPR1000U0ServiceImpl implements RQPR1000U0Service {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RQPR1000U0Dao RQPR1000U0Dao;
	
	@Autowired
	RQNR1000U0Dao RQNR1000U0Dao;
	
	@Autowired
	RQSR1000U0Dao RQSR1000U0Dao;
	
	@Autowired
	CodeDao CodeDao;

	@Autowired
	RQAM1000U0Dao rqamDao;
	
	@Autowired
	CommonDao CommonDao;
	
	@Autowired
	AprvWrrpt aprvWrrpt;
	
	@Autowired
	MsgSenService msg;
	
	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "00"; // 임시저장 
	private final String CD_RQS_SCD_APV_ING  = "05"; // 승인중 
	private final String CD_RQS_SCD_APV_CMPN = "10"; // 승인완료 
	private final String CD_RQS_SCD_EMAL     = "15"; // 메일전송완료
	private final String CD_RQS_SCD_RTRN     = "30"; // 반려 
	private final String CD_RQS_SCD_WDRAL    = "35"; // 철회
	private final String CD_RQS_SCD_CMPN     = "99"; // 완료

	/* APRV_PCD 코드값 정의 */
	private final String CD_APRV_PCD_PCH = "02"; // 구매
	
	private final String CD_UNIF_RQS_PCD_PCH  = "02"; // 신청유형코 02 구매

	private final String PSIT_MENU_ID = "RQPR1000m0";

	@Override
	public String reqRegi(RQPR1000U0In00VO vo) {
		
		String prcTp = "";
		boolean bfRegiYn = false; /* 기등록 여부 : false-신규등록 true-대상update */
		
		// 접수번호 채번vo
		GaSrno00In00VO rctVo = new GaSrno00In00VO();
		String unifRqsPcd = CD_UNIF_RQS_PCD_PCH; // 신청유형코 02 구매
		
		int cnt = 0;
		
		String newAprvWrrptMtNo = null; // 신규결재관리번호
		
		String rctNo = null; //접수번호(신규접수일자)
		String rqsEpno = null; // 신청사원번호
		String rqsOrzCd = null; // 신청조직코드	
		String inqOrzCd = null; // 입고조직코드
		String inqLocNm = null; // 입고부서명	
		String inqDlLocNm = null; // 입고상세위치명	
		
		GA01N101VO GA01N101VO = null; /* 통합신청 */
		GA03N104VO GA03N104VO = null; /* 명함/구매신청 */
		
		List<GA03N102VO> gridGA03N102 = null; // 명함/구매신청내역
		GA03N102VO GA03N102VO = null;
		List<GA03N103VO> gridGA03N103 = null; // 개인명패 상세
		GA03N103VO GA03N103VO = null;
		
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
			if((gridGA03N102==null || gridGA03N102.size()==0)){
				throw new CustomBadRequestException("필수입력항목 구매신청 내역 없음", ErrorCode.BAD_REQUEST);
			}
			
			// 구매신청내역
			if(gridGA03N102 != null && gridGA03N102.size() > 0) {
				for(int i=0;i<gridGA03N102.size();i++) {
					GA03N102VO = gridGA03N102.get(i);
					
					// 물품구분
					if(GA03N102VO.getAtclTcd() == null || "".equals(GA03N102VO.getAtclTcd()) ) {
				        throw new CustomBadRequestException("필수입력항목 명함신청내역[물품구분] 오류. 입력값을 확인하세요["+GA03N102VO.getAtclTcd()+"]", ErrorCode.BAD_REQUEST);		
					}
					
					// 물품코드
					if(GA03N102VO.getAtclCd() == null || "".equals(GA03N102VO.getAtclCd()) ) {
				        throw new CustomBadRequestException("필수입력항목 명함신청내역[물품코드] 오류. 입력값을 확인하세요["+GA03N102VO.getAtclCd()+"]", ErrorCode.BAD_REQUEST);		
					}
					
					// 사용자입력여부  userInptYn 
					if("Y".equals(GA03N102VO.getUserInptYn())) {
						// 사번 
						if(GA03N102VO.getEpno() == null || "".equals(GA03N102VO.getEpno()) ) {
					        throw new CustomBadRequestException("필수입력항목 명함신청내역[사번] 오류. 입력값을 확인하세요["+GA03N102VO.getEpno()+"]", ErrorCode.BAD_REQUEST);		
						}
					}
					
					// 수량
					if(GA03N102VO.getPchQ() == null || GA03N102VO.getPchQ().compareTo(BigDecimal.ZERO) <= 0 ) {
				        throw new CustomBadRequestException("필수입력항목 명함신청내역[신청수량] 오류. 입력값을 확인하세요["+GA03N102VO.getPchQ()+"]", ErrorCode.BAD_REQUEST);		
					}	
					
					// 가격
					if(GA03N102VO.getPchPr() == null || GA03N102VO.getPchPr().compareTo(BigDecimal.ZERO) <= 0 ) {
				        throw new CustomBadRequestException("필수입력항목 명함신청내역[가격] 오류. 입력값을 확인하세요["+GA03N102VO.getPchPr()+"]", ErrorCode.BAD_REQUEST);		
					}	
					
					// 합계
					if(GA03N102VO.getPchSmtlA() == null || GA03N102VO.getPchSmtlA().compareTo(BigDecimal.ZERO) <= 0 ) {
				        throw new CustomBadRequestException("필수입력항목 명함신청내역[합계] 오류. 입력값을 확인하세요["+GA03N102VO.getPchSmtlA()+"]", ErrorCode.BAD_REQUEST);		
					}	
					
					// 거래처코드
					if(GA03N102VO.getDelpCd() == null || "".equals(GA03N102VO.getDelpCd()) ) {
				        throw new CustomBadRequestException("필수입력항목 명함신청내역[거래처코드] 오류. 입력값을 확인하세요["+GA03N102VO.getDelpCd()+"]", ErrorCode.BAD_REQUEST);		
					}
				}
			}
			
			// 개인명패 상세 
			gridGA03N103 = vo.getGridGA03N103();
			if(gridGA03N103 != null && gridGA03N103.size() > 0) {
				for(int j=0;j<gridGA03N103.size();j++) {
					GA03N103VO = gridGA03N103.get(j);
					// 직책/직급
					if(StringUtils.isBlank(GA03N103VO.getNlJrnkNm()) && StringUtils.isBlank(GA03N103VO.getNlOsdtNm())){
				        throw new CustomBadRequestException("필수입력항목 개인명패[직책/직급] 오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);		
					}
					
					if(StringUtils.isBlank(GA03N103VO.getNlJrnkNm())) { // 직급
						gridGA03N103.get(j).setPstOsdtChocTcd("01");
					} else if (StringUtils.isBlank(GA03N103VO.getNlOsdtNm())) {  // 직책
						gridGA03N103.get(j).setPstOsdtChocTcd("02");
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
				rctVo.setCmnCdVl(unifRqsPcd); // 인감날인신청:05
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
				//GA01N101VO.setUnifRqsDlPcd(unifDlPcd);
				//GA01N101VO.setHopeDt();
				//GA01N101VO.setRqsRsnCn("인감날인증명서신청");
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
			
			// 2.구매신청 (GA03N104) 
			{
				GA03N104VO = new GA03N104VO();
				
				ObjectCopyUtil.copyFields(vo, GA03N104VO);
				GA03N104VO.setRctNo(rctNo);
				
				cnt = RQNR1000U0Dao.deleteGA03N104ByRctNo(rctNo);
				cnt = RQNR1000U0Dao.insertGA03N104(GA03N104VO);
				if(cnt == 0) {
			        throw new CustomBadRequestException("구매신청 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
				}
			}
			
			// 3.명함신청내역 (GA03N102)
			{
				GA03N102VO = new GA03N102VO();
				GA03N102VO.setRctNo(rctNo);
				
				cnt = RQNR1000U0Dao.deleteGA03N102ByRctNo(rctNo);
				
				gridGA03N102 = vo.getGridGA03N102();
				
				for(int i=0;i<gridGA03N102.size();i++) {
					
					GA03N102VO = gridGA03N102.get(i);
					//GA03N102VO.setAtclTcd(CD_ATCL_TCD_NMCRD); 
					GA03N102VO.setRctNo(rctNo);
					cnt = RQNR1000U0Dao.insertGA03N102(GA03N102VO);
					if(cnt == 0) {
				        throw new CustomBadRequestException("구매 신청내역 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
					}
				}
			}
			
			// 4.개인명패상세 (GA03N103)
			{
				GA03N103VO = new GA03N103VO();
				GA03N103VO.setRctNo(rctNo);
				
				cnt = RQPR1000U0Dao.deleteGA03N103ByRctNo(rctNo);
				
				gridGA03N103 = vo.getGridGA03N103();
				
				for(int i=0;i<gridGA03N103.size();i++) {
					
					GA03N103VO = gridGA03N103.get(i); 
					GA03N103VO.setRctNo(rctNo);
					
					GA03N103VO.setNlBlngNm(GA03N103VO.getOrzNm());
					GA03N103VO.setEngBlngNm(GA03N103VO.getEngOrzNm());
					
					cnt = RQPR1000U0Dao.insertGA03N103(GA03N103VO);
					if(cnt == 0) {
				        throw new CustomBadRequestException("개인명패상세 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
					}
				}
			}
			
			// 상신:결재상신처리
			if(prcTp.equals("01")) {
				
				log.info("결재 모듈 ============["+rctNo+"] ["+rqsEpno+"][" + rqsOrzCd +"] ["+CD_APRV_PCD_PCH+"]");				
				 
				// 상신 결재 등록 --> 여기서 결재선 모듈 호출
				newAprvWrrptMtNo = aprvWrrpt.aprvWrrpt(rctNo, rqsEpno, rqsOrzCd, CD_APRV_PCD_PCH, PSIT_MENU_ID);

				log.info("newAprvWrrptMtNo ["+newAprvWrrptMtNo+"]");
			}
			
		}
		
		return rctNo;
	}
	
}
