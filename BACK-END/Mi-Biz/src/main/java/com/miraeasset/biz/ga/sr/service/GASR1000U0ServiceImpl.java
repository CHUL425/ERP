package com.miraeasset.biz.ga.sr.service;

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
import com.miraeasset.biz.common.meta.vo.GA01H502VO;
import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA01N501VO;
import com.miraeasset.biz.common.meta.vo.GA01N501Vs01InVO;
import com.miraeasset.biz.common.meta.vo.GA01N503VO;
import com.miraeasset.biz.common.meta.vo.GA01N509VO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.aprvWrrpt.AprvWrrpt;
import com.miraeasset.biz.ga.cm.dao.GACM1000U0Dao;
import com.miraeasset.biz.ga.em.dao.GAEM1000U0Dao;
import com.miraeasset.biz.ga.sr.dao.GASR1000U0Dao;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0In00VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0In01VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0In02VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0In03VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0In04VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out00VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out01VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out11VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out12VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out13VO;
import com.miraeasset.biz.rq.ur.dao.RQUR1000U0Dao;

@Service
@Transactional
public class GASR1000U0ServiceImpl implements GASR1000U0Service {

	@Autowired
	GASR1000U0Dao GASR1000U0Dao;

	@Autowired
	GAEM1000U0Dao GAEM1000U0Dao;

	@Autowired
	GACM1000U0Dao GACM1000U0Dao;

	@Autowired
	RQUR1000U0Dao RQUR1000U0Dao;

	@Autowired
	CodeDao CodeDao;

	@Autowired
	AprvWrrpt aprvWrrpt;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/* APRV_PCD 코드값 정의 */
	private final String CD_APRV_PCD_RENT = "01"; // 렌탈신청
	private final String CD_APRV_PCD_PCH  = "02"; // 구매신청
	private final String CD_APRV_PCD_SALG = "05"; // 인감날인
	private final String CD_APRV_PCD_SAL  = "06"; // 인장조제관리

	/* RQS_SCD 코드값 정의 - 인장조제관리 */	
	private final String CD_RQS_SCD_APV_ING  = "05"; // 승인중
	private final String CD_RQS_SCD_APV_CMPN = "10"; // 승인완료
	private final String CD_RQS_SCD_RTRN     = "30"; // 반려
	
	/* SEAL_SCD 코드값 정의 */
	private final String CD_SEAL_SCD_RCT_ING   = "02"; // 접수중(NEW)
	private final String CD_SEAL_SCD_RQS_ING   = "05"; // 조제신청중
	private final String CD_SEAL_SCD_USED      = "10"; // 사용중
	private final String CD_SEAL_SCD_CHNG_ING  = "15"; // 내용변경중(NEW)
	private final String CD_SEAL_SCD_WDRAL_ING = "25"; // 회수신청중
	private final String CD_SEAL_SCD_WDRAL     = "30"; // 회수
	private final String CD_SEAL_SCD_DSUS_ING  = "35"; // 폐기신청중
	private final String CD_SEAL_SCD_DSUS      = "40"; // 폐기
	private final String CD_SEAL_SCD_CHPR_CNCL = "90"; // 담당자취소
	
	private final String CD_UNIF_RQS_PCD_SAL = "06"; // 신청유형코드 06:인장조제관리

	private final String PSIT_MENU_ID = "GASR1000m0";

	private final String UNIF_RQS_TCD_RCT   = "060101"; // 인장조제 접수
	private final String UNIF_RQS_TCD_REG   = "060102"; // 인장조제 신청
	private final String UNIF_RQS_TCD_CHNG  = "060103"; // 인장조제 내용변경
	private final String UNIF_RQS_TCD_WDRAL = "060104"; // 인장조제 회수
	private final String UNIF_RQS_TCD_DSUS  = "060105"; // 인장조제 폐기
	
	/* 인장조제관리 목록조회 */
	@Override
	public List<GASR1000U0Out00VO> selectListGA01N501(GASR1000U0In00VO vo) {
		if (!StringUtils.isBlank(vo.getSalPcd())) {
			vo.setArrSalPcd(Arrays.asList(vo.getSalPcd().split("\\s*,\\s*")));
		}

		if (!StringUtils.isBlank(vo.getStrArrSealScd())) {
			vo.setArrSealScd(Arrays.asList(vo.getStrArrSealScd().split("\\s*,\\s*")));
		}
		GASR1000U0Out00VO tmp = GASR1000U0Dao.selectListGA01N501_Cnt(vo); 
		vo.setTotCnt(tmp.getTotCnt());
		
		return GASR1000U0Dao.selectListGA01N501(vo);
	}

	/* 인장조제관리 인장유형 통계정보조회 */
	@Override
	public GASR1000U0Out11VO selectInfoGA01N501BySalPcd(GASR1000U0In00VO vo) {
		vo.setArrSalPcd(Arrays.asList(vo.getSalPcd().split("\\s*,\\s*")));

		if (!StringUtils.isBlank(vo.getStrArrSealScd())) {
			vo.setArrSealScd(Arrays.asList(vo.getStrArrSealScd().split("\\s*,\\s*")));
		}

		return GASR1000U0Dao.selectInfoGA01N501BySalPcd(vo);
	}
	
	/* 인장조제관리 인장유형 통계정보조회 */
	@Override
	public GASR1000U0Out13VO selectInfoGA01N501BySalScd(GASR1000U0In00VO vo) {
		vo.setArrSalPcd(Arrays.asList(vo.getSalPcd().split("\\s*,\\s*")));

		if (!StringUtils.isBlank(vo.getStrArrSealScd())) {
			vo.setArrSealScd(Arrays.asList(vo.getStrArrSealScd().split("\\s*,\\s*")));
		}

		return GASR1000U0Dao.selectInfoGA01N501BySalScd(vo);
	}
	
	/* 인감날인 인감 콤보박스 */
	@Override
	public List<GASR1000U0Out12VO> selectListSealSalg() {
		return GASR1000U0Dao.selectListSealSalg();
	}

	/* 인감증명서 인감 콤보박스 */
	public List<GASR1000U0Out12VO> selectListSealDoc() {
		return GASR1000U0Dao.selectListSealDoc();
	}

	/* 인장조제관리 상세정보조회(PK) */
	@Override
	public GASR1000U0Out01VO selectGA01N501PK(GASR1000U0In01VO vo) {

		// 변수 초기화
		GA01N501VO GA01N501VO = new GA01N501VO();
		GASR1000U0Out01VO outVo = new GASR1000U0Out01VO();
		String salMtNo = null; // 인장조제관리번호

		// 전처리 : 입력값 체크
		{
			salMtNo = vo.getSalMtNo();
			if (salMtNo == null || salMtNo.equals("")) {
				throw new CustomBadRequestException("필수입력항목[인장조제관리] 오류. 입력값을 확인하세요[" + salMtNo + "]",
						ErrorCode.BAD_REQUEST);
			}
		}

		// 조회
		{
			// 데이터 카피
			ObjectCopyUtil.copyFields(vo, GA01N501VO);
			GA01N501VO = GASR1000U0Dao.selectGA01N501PK(GA01N501VO);

			if (GA01N501VO == null) {
				throw new CustomBadRequestException("조회 대상건이 존재하지않습니다. 인장조제관리번호를 확인하세요[" + salMtNo + "]",
						ErrorCode.BAD_REQUEST);
			}

			// 출력데이터 카피
			ObjectCopyUtil.copyFields(GA01N501VO, outVo);
		}

		return outVo;
	}

	/* 인장조제관리 접수 */
	@Override
	public String insertGA01N501(GASR1000U0In03VO vo) {
		
		// 변수 초기화
		int cnt = 0;
		GA01N501VO GA01N501VO = new GA01N501VO();
		String salPcd = null; // 인장유형
		String salTcd = null; // 인장구분
		String newSalMtNo = null; // 신규인장관리번호
		String rctDrftDocNo = vo.getRctDrftDocNo(); // 협조문서
		
		// 채번vo
		GaSrno00In00VO rctVo = new GaSrno00In00VO();		
		
		// 전처리 : 입력값 체크
		{		
			
			if(vo.getHobrTcd() == null || vo.getHobrTcd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[본지점코드] 오류. 입력값을 확인하세요["+vo.getHobrTcd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getSalTcd() == null || vo.getSalTcd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[인장구분코드] 오류. 입력값을 확인하세요["+vo.getSalTcd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getSalPcd() == null || vo.getSalPcd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[인장유형코드] 오류. 입력값을 확인하세요["+vo.getSalPcd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getMtOrzCd() == null || vo.getMtOrzCd().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[관리조직명] 오류. 입력값을 확인하세요["+vo.getMtOrzCd()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getRctDt() == null || vo.getRctDt().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[접수일자] 오류. 입력값을 확인하세요["+vo.getRctDt()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getRctDrftDocNo() == null || vo.getRctDrftDocNo().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[협조문서] 오류. 입력값을 확인하세요["+vo.getRctDrftDocNo()+"]", ErrorCode.BAD_REQUEST);		
			}
			
			salPcd = vo.getSalPcd(); // 인장유형
			salTcd = vo.getSalTcd(); // 인장구분			

			// 인장코드 정합성체크
			{
				/* 인감유형별 사용가능 인장유형 코드 맵핑
				 * A : 법인이감 - 01 : 대표이사인 
				 * B : 사용인감 - 01 : 대표이사인
				 * C : 직인 - 02 ~ 09 
				 * D : 계인 - 10 ~ 14
				 * E : 사인 - 15 : 회사인 사각  
				 */
				
				if("A".equals(salPcd)) {
					if (!Arrays.asList("01").contains(salTcd)) {
				        throw new CustomBadRequestException("인장 구분 입력오류 ["+salPcd+"]["+salTcd+"] - (A : 법인인감 - 01 : 대표이사인)", ErrorCode.BAD_REQUEST);								
					}

				}else if("B".equals(salPcd)) {
					if (!Arrays.asList("01").contains(salTcd)) {
				        throw new CustomBadRequestException("인장 구분 입력오류 ["+salPcd+"]["+salTcd+"] - (B : 사용인감 - 01 : 대표이사인) ", ErrorCode.BAD_REQUEST);								
					}

				}else if("C".equals(salPcd)) {
					if (!Arrays.asList("02","03","04","05","06","07","08","09").contains(salTcd)) {
				        throw new CustomBadRequestException("인장 구분 입력오류 ["+salPcd+"]["+salTcd+"] - (C : 직인 - 02 ~ 09) ", ErrorCode.BAD_REQUEST);								
					}

				}else if("D".equals(salPcd)) {
					if (!Arrays.asList("10","11","12","13","14").contains(salTcd)) {
				        throw new CustomBadRequestException("인장 구분 입력오류 ["+salPcd+"]["+salTcd+"] - (D : 계인 - 10 ~ 14) ", ErrorCode.BAD_REQUEST);								
					}
				}else if("E".equals(salPcd)) {
					if(!salTcd.equals("15")) {
				        throw new CustomBadRequestException("인장 구분 입력오류 ["+salPcd+"]["+salTcd+"] - (E : 사인 - 15 : 회사인 사각) ", ErrorCode.BAD_REQUEST);								
					}					
				}
			}		
		}
		
		// 신규등록처리
		{
			// 신규 인장조제관리 등록
			{
				rctVo.setCdKndNo("SAL_MT_NO");
				rctVo.setCmnCdVl( salPcd + salTcd );
				rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
				
				newSalMtNo = rctVo.getRpbzGnoSrno();
				
				if(newSalMtNo == null || "".equals(newSalMtNo)) {
			        throw new CustomBadRequestException("인장조제관리 채번오류 ["+salPcd+"]["+salTcd+"]", ErrorCode.BAD_REQUEST);	
				}

				log.info("인잔관리번호 채번 ============["+newSalMtNo+"] = ["+salPcd+"][" + salTcd +"]");	
				
				// 데이터 카피
				ObjectCopyUtil.copyFields(vo, GA01N501VO);	
				
				GA01N501VO.setSalMtNo(newSalMtNo);
				GA01N501VO.setSealScd(CD_SEAL_SCD_RCT_ING);
				
				cnt = GASR1000U0Dao.insertGA01N501(GA01N501VO);
				
				if(cnt == 0) {
			        throw new CustomBadRequestException("신규등록 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);		
				}				
			}

			// 인장관리번호 기준 기안문서정보 테이블 (GA01N509) 등록
			if(true){
				GA01N509VO GA01N509VO = new GA01N509VO();
				GA01N509VO.setSalMtNo(newSalMtNo);
				GA01N509VO.setUnifRqsTcd(UNIF_RQS_TCD_RCT);
				GA01N509VO.setDrftDocNo(rctDrftDocNo);
				
				cnt = GASR1000U0Dao.insertGA01N509(GA01N509VO);
				if(cnt == 0) {
			        throw new CustomBadRequestException("기안문서 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);							
				}				
			}

		}

		return newSalMtNo;
	}

	/* 인장조제관리 신청 */
	@Override
	public int insertGA01N101(GASR1000U0In03VO vo) {
		
		// 변수 초기화
		int cnt = 0;

		String newRctNo = "0";	// 신규신청번호
		String rqsEpno = null; // 신청사원번호
		String rqsOrzCd = null; // 신청조직코드
		String newAprvWrrptMtNo = null; // 신규결재관리번호
		String salMtNo = null; // 인형번호
		
		GA01N101VO GA01N101VO = null; // 통합신청
		// 채번vo
		GaSrno00In00VO rctVo = new GaSrno00In00VO();		
		
		// 전처리 : 입력값 체크
		{		
			if(vo.getSalNm() == null || vo.getSalNm().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[인영명] 오류. 입력값을 확인하세요["+vo.getSalNm()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getSalDlNm() == null || vo.getSalDlNm().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[인영명상세명] 오류. 입력값을 확인하세요["+vo.getSalDlNm()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getMakgDt() == null || vo.getMakgDt().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[조제일자] 오류. 입력값을 확인하세요["+vo.getMakgDt()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getSalMakgRsnCn() == null || vo.getSalMakgRsnCn().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[조제사유] 오류. 입력값을 확인하세요["+vo.getSalMakgRsnCn()+"]", ErrorCode.BAD_REQUEST);		
			} 
			if(vo.getRegDrftDocNo() == null || vo.getRegDrftDocNo().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[조제기안문] 오류. 입력값을 확인하세요["+vo.getRegDrftDocNo()+"]", ErrorCode.BAD_REQUEST);		
			} 
			if(vo.getFileNo() == null || vo.getFileNo().equals("") ) {
				throw new CustomBadRequestException("필수입력항목[이미지] 오류. 입력값을 확인하세요["+vo.getFileNo()+"]", ErrorCode.BAD_REQUEST);		
			}
			salMtNo = vo.getSalMtNo();		
			if (salMtNo == null || salMtNo.equals("")) {
				throw new CustomBadRequestException("필수입력항목[인영번호] 오류. 입력값을 확인하세요[" + salMtNo + "]",ErrorCode.BAD_REQUEST);
			}
		}	

		// 인장조제 신청 처리
		{
			String rqsDt = DateUtil.getTodayString("yyyyMMdd");

			// 인장조제 상태코드(접수 -> 조제신청중)
			if(true){
				// 데이터 카피
				GA01N501VO GA01N501VO = new GA01N501VO();
				ObjectCopyUtil.copyFields(vo, GA01N501VO);
				
				// 기등록 데이터 정합성 체크
				{
					GA01N501VO chkVo = null;
					/* 인장조제관리 상세정보조회(PK) */
					chkVo = GASR1000U0Dao.selectGA01N501PK(GA01N501VO);
					if (chkVo == null) {
						throw new CustomBadRequestException("수정 대상건이 존재하지않습니다. 인장조제관리번호를 확인하세요[" + salMtNo + "]",
								ErrorCode.BAD_REQUEST);
					}
					if(!chkVo.getSealScd().equals(CD_SEAL_SCD_RCT_ING)) { // 접수중
						throw new CustomBadRequestException("신청 대상건 인감상태코드를 확인하세요. 인감상태코드는 접수중 일경우만 신청처리 가능합니다. ["
								+ chkVo.getSealScd() + "][" + chkVo.getSealScdNm() + "]", ErrorCode.BAD_REQUEST);
					}
				}
				
				// 인장조제 상태 수정
				GA01N501VO.setSealScd(CD_SEAL_SCD_RQS_ING); // 조제신청중
				cnt = GASR1000U0Dao.updateGA01N501ByMAKG(GA01N501VO);
				
				if (cnt == 0) {
					throw new CustomBadRequestException("수정처리 오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);
				}
			}	
			
			
			
			// 통합신청 데이터 세팅
			if(true){

				// 통합신청 신규접수번호 채번
				rctVo.setCdKndNo("CHAEBUN");
				rctVo.setCmnCdVl(CD_UNIF_RQS_PCD_SAL);
				rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
				newRctNo = rctVo.getRpbzGnoSrno();
			
				rqsEpno  = vo.getRqsEpno();
				rqsOrzCd = vo.getRqsOrzCd();
				
				GA01N101VO = new GA01N101VO();
				
				GA01N101VO.setRctNo(newRctNo);
				GA01N101VO.setUnifRqsTcd(UNIF_RQS_TCD_REG);  //인장조제신청
				GA01N101VO.setUnifRqsPcd(CD_UNIF_RQS_PCD_SAL); // 06 인장
				GA01N101VO.setUnifRqsDlPcd("0601");
				GA01N101VO.setRqsOrzCd(rqsOrzCd);
				GA01N101VO.setRqsEpno(rqsEpno);
				GA01N101VO.setRqsTtlNm(vo.getSalNm());
				//GA01N101VO.setRqsRsnCn(vo.getSalDlNm());
				GA01N101VO.setHopeDt(rqsDt);
				GA01N101VO.setRqsDt(rqsDt);	
				GA01N101VO.setRqsScd(CD_RQS_SCD_APV_ING); // 승인중			
				
				cnt = RQUR1000U0Dao.insertGA01N003(GA01N101VO);		
				if(cnt == 0) {
			        throw new CustomBadRequestException("신규등록 생성오류(통합신청). 입력값을 확인하세요", ErrorCode.BAD_REQUEST);							
				}
			}
			
			// 인장신청_인장조제관리신청 테이블 (GA01N503) 등록
			if(true){
				GA01N503VO GA01N503VO = new GA01N503VO();
				GA01N503VO.setRctNo(newRctNo);
				GA01N503VO.setRqsDt(rqsDt);
				GA01N503VO.setSalMtNo(salMtNo);
				
				cnt = GASR1000U0Dao.insertGA01N503(GA01N503VO);
				if(cnt == 0) {
			        throw new CustomBadRequestException("신규등록 생성오류(인장조제관리신청). 입력값을 확인하세요", ErrorCode.BAD_REQUEST);							
				}				
			}	
			
			// 인장관리번호 기준 기안문서정보 테이블 (GA01N509) 등록
			if(true){
				String regDrftDocNo = vo.getRegDrftDocNo();
				GA01N509VO GA01N509VO = new GA01N509VO();
				GA01N509VO.setSalMtNo(salMtNo);
				GA01N509VO.setUnifRqsTcd(UNIF_RQS_TCD_REG);
				GA01N509VO.setDrftDocNo(regDrftDocNo);
				
				cnt = GASR1000U0Dao.insertGA01N509(GA01N509VO);
				if(cnt == 0) {
			        throw new CustomBadRequestException("기안문서 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);							
				}				
			}
			
			// 결재상신처리
			if(true){
				log.info("결재 모듈 ============["+newRctNo+"] ["+rqsEpno+"][" + rqsOrzCd +"] ["+CD_APRV_PCD_SAL+"]");				
				 
				// 상신 결재 등록 --> 여기서 결재선 모듈 호출
				newAprvWrrptMtNo = aprvWrrpt.aprvWrrpt(newRctNo, rqsEpno, rqsOrzCd, CD_APRV_PCD_SAL, PSIT_MENU_ID);

				log.info("newAprvWrrptMtNo ["+newAprvWrrptMtNo+"]");
			}
			
		}

		return cnt;
	}
	
	/* 인장조제관리 담당자취소/내용수정/회수/폐기 단건
	 * 주의: 폐기는 화면에서 일괄폐기 updateListGA01N501ByDSUS 메소드 사용.
	 *  */
	@Override
	public int updateGA01N501ByTrTcd(GASR1000U0In02VO vo) {

		// 변수 초기화
		int cnt = 0;
		GA01N501VO GA01N501VO = new GA01N501VO();
		
		String trTcd = null; // 거래구분코드 C:내용수정(접수중) W:회수 D:폐기 CNCL:담당자취소, CHNG:내용변경(신청후)
		
		String salMtNo = null; // 인장조제관리번호
		String salNm = null; // 인장명
		
		String newRctNo = "0"; // 신규신청번호
		String rqsEpno = null; // 신청사원번호
		String rqsOrzCd = null; // 신청조직코드
		String newAprvWrrptMtNo = null; // 신규결재관리번호
		GA01N101VO GA01N101VO = null; // 통합신청
		// 채번vo
		GaSrno00In00VO rctVo = new GaSrno00In00VO();

		// 전처리 : 입력값 체크
		{
			trTcd = vo.getTrTcd();
			salMtNo = vo.getSalMtNo();

			log.info("거래구분코드 ============ trTcd [" + trTcd + "] ");

			if (trTcd == null || trTcd.equals("")) {				throw new CustomBadRequestException("필수입력항목[거래구분코드] 오류. 입력값을 확인하세요[" + trTcd + "]",
						ErrorCode.BAD_REQUEST);
			}
			if (salMtNo == null || salMtNo.equals("")) {
				throw new CustomBadRequestException("필수입력항목[인장조제관리번호] 오류. 입력값을 확인하세요[" + salMtNo + "]",
						ErrorCode.BAD_REQUEST);
			}

			if (!Arrays.asList("C", "W", "D", "CNCL", "CHNG").contains(trTcd)) {
				throw new CustomBadRequestException("정합성오류[거래구분코드], 입력값을 확인하세요[" + trTcd + "] - C:수정(접수중) W:회수 D:폐기 CNCL:담당자취소 CHNG:내용수정(사용중)",
						ErrorCode.BAD_REQUEST);
			}

			// 거래구분 C:내용수정(접수중)
			if (trTcd.equals("C")) {	
				if(vo.getHobrTcd() == null || vo.getHobrTcd().equals("") ) {
			        throw new CustomBadRequestException("필수입력항목[본지점코드] 오류. 입력값을 확인하세요["+vo.getHobrTcd()+"]", ErrorCode.BAD_REQUEST);		
				}
				if(vo.getSalTcd() == null || vo.getSalTcd().equals("") ) {
			        throw new CustomBadRequestException("필수입력항목[인장구분코드] 오류. 입력값을 확인하세요["+vo.getSalTcd()+"]", ErrorCode.BAD_REQUEST);		
				}
				if(vo.getSalPcd() == null || vo.getSalPcd().equals("") ) {
			        throw new CustomBadRequestException("필수입력항목[인장유형코드] 오류. 입력값을 확인하세요["+vo.getSalPcd()+"]", ErrorCode.BAD_REQUEST);		
				}
				if(vo.getMtOrzCd() == null || vo.getMtOrzCd().equals("") ) {
			        throw new CustomBadRequestException("필수입력항목[관리조직명] 오류. 입력값을 확인하세요["+vo.getMtOrzCd()+"]", ErrorCode.BAD_REQUEST);		
				}
				if(vo.getSalChngRsnCn() == null || vo.getSalChngRsnCn().equals("") ) {
			        throw new CustomBadRequestException("필수입력항목[변경사유] 오류. 입력값을 확인하세요["+vo.getSalChngRsnCn()+"]", ErrorCode.BAD_REQUEST);		
				}
				if(vo.getRctDrftDocNo() == null || vo.getRctDrftDocNo().equals("") ) {
			        throw new CustomBadRequestException("필수입력항목[협조문서] 오류. 입력값을 확인하세요["+vo.getRctDrftDocNo()+"]", ErrorCode.BAD_REQUEST);		
				}
			}
			
			// 거래구분 W:회수 정합성체크
			if (trTcd.equals("W")) {

				if (vo.getWtdwDt() == null || vo.getWtdwDt().equals("")) {
					throw new CustomBadRequestException("필수입력항목[회수일자] 오류. 입력값을 확인하세요[" + vo.getWtdwDt() + "]",
							ErrorCode.BAD_REQUEST);
				}
				if (vo.getSalWtdwRsnCn() == null || vo.getSalWtdwRsnCn().equals("")) {
					throw new CustomBadRequestException("필수입력항목[회수사유] 오류. 입력값을 확인하세요[" + vo.getSalWtdwRsnCn() + "]",
							ErrorCode.BAD_REQUEST);
				}
				if (vo.getWtdwDrftDocNo() == null || vo.getWtdwDrftDocNo().equals("")) {
					throw new CustomBadRequestException("필수입력항목[회수기안문서] 오류. 입력값을 확인하세요[" + vo.getWtdwDrftDocNo() + "]",
							ErrorCode.BAD_REQUEST);
				}
			}

			// 거래구분 D:폐기 정합성체크
			if (trTcd.equals("D")) {

				if (vo.getDsusDt() == null || vo.getDsusDt().equals("")) {
					throw new CustomBadRequestException("필수입력항목[폐기일자] 오류. 입력값을 확인하세요[" + vo.getDsusDt() + "]",
							ErrorCode.BAD_REQUEST);
				}
				if (vo.getDsusDrftDocNo() == null || vo.getDsusDrftDocNo().equals("")) {
					throw new CustomBadRequestException("필수입력항목[폐기기안문서] 오류. 입력값을 확인하세요[" + vo.getDsusDrftDocNo() + "]",
							ErrorCode.BAD_REQUEST);
				}
			}
			
			// 거래구분 CHNG:내용수정(사용중) 정합성체크
			if (trTcd.equals("CHNG")) {	
				if(vo.getSalNm() == null || vo.getSalNm().equals("") ) {
			        throw new CustomBadRequestException("필수입력항목[인영명] 오류. 입력값을 확인하세요["+vo.getSalNm()+"]", ErrorCode.BAD_REQUEST);		
				}
				if(vo.getSalDlNm() == null || vo.getSalDlNm().equals("") ) {
			        throw new CustomBadRequestException("필수입력항목[인영명상세명] 오류. 입력값을 확인하세요["+vo.getSalDlNm()+"]", ErrorCode.BAD_REQUEST);		
				}
				if(vo.getMakgDt() == null || vo.getMakgDt().equals("") ) {
			        throw new CustomBadRequestException("필수입력항목[조제일자] 오류. 입력값을 확인하세요["+vo.getMakgDt()+"]", ErrorCode.BAD_REQUEST);		
				}
				if(vo.getSalMakgRsnCn() == null || vo.getSalMakgRsnCn().equals("") ) {
			        throw new CustomBadRequestException("필수입력항목[조제사유] 오류. 입력값을 확인하세요["+vo.getSalMakgRsnCn()+"]", ErrorCode.BAD_REQUEST);		
				} 
				if(vo.getRegDrftDocNo() == null || vo.getRegDrftDocNo().equals("") ) {
			        throw new CustomBadRequestException("필수입력항목[조제기안문] 오류. 입력값을 확인하세요["+vo.getRegDrftDocNo()+"]", ErrorCode.BAD_REQUEST);		
				} 
				if(vo.getFileNo() == null || vo.getFileNo().equals("") ) {
					throw new CustomBadRequestException("필수입력항목[이미지] 오류. 입력값을 확인하세요["+vo.getFileNo()+"]", ErrorCode.BAD_REQUEST);		
				}
				if(vo.getSalChngRsnCn() == null || vo.getSalChngRsnCn().equals("") ) {
			        throw new CustomBadRequestException("필수입력항목[변경사유] 오류. 입력값을 확인하세요["+vo.getSalChngRsnCn()+"]", ErrorCode.BAD_REQUEST);		
				}
			}
		}

		// 데이터 카피
		ObjectCopyUtil.copyFields(vo, GA01N501VO);

		// 기등록 데이터 정합성 체크
		{
			GA01N501VO chkVo = null;
			/* 인장조제관리 상세정보조회(PK) */
			chkVo = GASR1000U0Dao.selectGA01N501PK(GA01N501VO);
			if (chkVo == null) {
				throw new CustomBadRequestException("수정 대상건이 존재하지않습니다. 인장조제관리번호를 확인하세요[" + salMtNo + "]",
						ErrorCode.BAD_REQUEST);
			} else {
				salNm = chkVo.getSalNm(); // 2023.11.30 신청명을 인영명으로 설정	
			}
			
			// 내용수정 
			if (trTcd.equals("CHNG")) {
				if (!chkVo.getSealScd().equals(CD_SEAL_SCD_USED)) {
					throw new CustomBadRequestException("내용수정 대상건 인감상태코드를 확인하세요. 인감상태코드는 사용중(승인완료) 일경우만 회수처리 가능합니다. ["
							+ chkVo.getSealScd() + "][" + chkVo.getSealScdNm() + "]", ErrorCode.BAD_REQUEST);
				}
			}
			
			// 회수 처리전 기등록체크
			if (trTcd.equals("W")) {
				if (!chkVo.getSealScd().equals(CD_SEAL_SCD_USED)) {
					throw new CustomBadRequestException("회수 대상건 인감상태코드를 확인하세요. 인감상태코드는 사용중(승인완료) 일경우만 회수처리 가능합니다. ["
							+ chkVo.getSealScd() + "][" + chkVo.getSealScdNm() + "]", ErrorCode.BAD_REQUEST);
				}
			}

			// 변경 처리전 기등록체크
			if (trTcd.equals("C") || trTcd.equals("CNCL")) {
				if (!chkVo.getSealScd().equals(CD_SEAL_SCD_RCT_ING)) { // 접수중
					throw new CustomBadRequestException("내용수정 대상건 인감상태코드를 확인하세요. 인감상태코드는 접수중 일경우만 변경처리 가능합니다. ["
							+ chkVo.getSealScd() + "][" + chkVo.getSealScdNm() + "]", ErrorCode.BAD_REQUEST);
				}
			}
			
			// 폐기 처리전 기등록체크
			if (trTcd.equals("D")) {
				if (!chkVo.getSealScd().equals(CD_SEAL_SCD_WDRAL)) {
					throw new CustomBadRequestException("폐기 대상건 인감상태코드를 확인하세요. 인감상태코드는 회수후 365+1일 초과건만 폐기가능합니다. ["
							+ chkVo.getSealScd() + "][" + chkVo.getSealScdNm() + "]", ErrorCode.BAD_REQUEST);
				}

				String dsusDt = GA01N501VO.getDsusDt(); // 폐기예정일자
				String wtdwDt = chkVo.getWtdwDt();
				String minDsusDt = DateUtil.getAddDay(wtdwDt, 365 + 1); // 폐기가능 최소 일자 = 회수일자 + (365+1)

				// 입력받은 폐기일자 >= 폐기가능 최소일자 (회수일 + 365 + 1)
				if (Integer.parseInt(dsusDt) < Integer.parseInt(minDsusDt)) {
					throw new CustomBadRequestException("폐기 대상건 회수일자를 확인하세요. 회수후 365+1일 초과건만 폐기가능합니다. 회수일자[" + wtdwDt
							+ "] 최소폐기가능일자[" + minDsusDt + "]", ErrorCode.BAD_REQUEST);
				}
			}
		}

		// 인감상태 수정처리
		{	
			// 회수 수정처리
			if (trTcd.equals("W")) {
				GA01N501VO.setSealScd(CD_SEAL_SCD_WDRAL_ING); // 회수신청중
				cnt = GASR1000U0Dao.updateGA01N501ByWTDW(GA01N501VO);
				// 폐기 수정처리
			} else if (trTcd.equals("D")) {
				GA01N501VO.setSealScd(CD_SEAL_SCD_DSUS_ING); // 폐기처리중
				cnt = GASR1000U0Dao.updateGA01N501ByDSUS(GA01N501VO);
				// 변경 수정처리
			} else if (trTcd.equals("C")) {
				GA01N501VO.setSealScd(CD_SEAL_SCD_RCT_ING); // 접수중(인감상태는 접수중)
				cnt = GASR1000U0Dao.updateGA01N501ByCHNG(GA01N501VO);
			} else if (trTcd.equals("CNCL")) {
				GA01N501VO.setSealScd(CD_SEAL_SCD_CHPR_CNCL); // 담당자취소(인감상태는 접수중)
				cnt = GASR1000U0Dao.updateGA01N501ByCHNG(GA01N501VO);
			} else if (trTcd.equals("CHNG")) {
				
				// 인장조제관리_인장조제관리이력 (GA01H502) 등록
				if(true){
					GA01H502VO GA01H502VO = new GA01H502VO();
					GA01H502VO.setSalMtNo(salMtNo);
					cnt = GASR1000U0Dao.insertGA01H502(GA01H502VO);
					if(cnt == 0) {
				        throw new CustomBadRequestException("인장조제관리이력 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);							
					}				
				}
				
				GA01N501VO.setSealScd(CD_SEAL_SCD_CHNG_ING); // 내용변경중(사용중)
				cnt = GASR1000U0Dao.updateGA01N501ByUPD(GA01N501VO);
			} 

			if (cnt == 0) {
				throw new CustomBadRequestException("수정처리 오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);
			}
			
			if(trTcd.equals("CNCL")) { // 접수중 내용수정 or 담당자취소일때 통합신청 데이터 생성하지 않음.
				return cnt; 
			} else if (trTcd.equals("C")) {	
				// 인장관리번호 기준 기안문서정보 테이블 (GA01N509) 등록
				String docNo = vo.getRctDrftDocNo();
				String rqsTcd = UNIF_RQS_TCD_RCT;

				GA01N509VO GA01N509VO = new GA01N509VO();
				GA01N509VO.setSalMtNo(salMtNo);
				GA01N509VO.setUnifRqsTcd(rqsTcd);
				GA01N509VO.setDrftDocNo(docNo);
				
				cnt = GASR1000U0Dao.insertGA01N509(GA01N509VO);
				if(cnt == 0) {
			        throw new CustomBadRequestException("기안문서 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);							
				}				
				return cnt; 
			}

			String rqsDt = DateUtil.getTodayString("yyyyMMdd");
			//String rqsScd = "";
			String unifRqsPcd = CD_UNIF_RQS_PCD_SAL;
			String unifRqsTcd = "";

			String rqsRsnCn = "";

			// 통합신청 데이터 세팅
			if (true) {

				// 통합신청 신규접수번호 채번
				rctVo.setCdKndNo("CHAEBUN");
				rctVo.setCmnCdVl(CD_UNIF_RQS_PCD_SAL);
				rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
				newRctNo = rctVo.getRpbzGnoSrno();

				rqsEpno = vo.getRqsEpno();
				rqsOrzCd = vo.getRqsOrzCd();

				// 회수 수정처리
				if (trTcd.equals("W")) {
					unifRqsTcd = UNIF_RQS_TCD_WDRAL;
					rqsRsnCn = vo.getSalWtdwRsnCn();
					// 폐기 수정처리
				} else if (trTcd.equals("D")) {
					unifRqsTcd = UNIF_RQS_TCD_DSUS;
					//rqsTtlNm = vo.getSalDsusRsnCn(); // 폐기사유 사용안함
				} else if (trTcd.equals("CHNG")) {
					unifRqsTcd = UNIF_RQS_TCD_CHNG; 
					rqsRsnCn = vo.getSalChngRsnCn();
				}
				
				GA01N101VO = new GA01N101VO();

				GA01N101VO.setRctNo(newRctNo);
				// GA01N101VO.setRqsScd(rqsScd);
				GA01N101VO.setRqsEpno(rqsEpno);
				GA01N101VO.setRqsOrzCd(rqsOrzCd);
				GA01N101VO.setUnifRqsPcd(unifRqsPcd);
				GA01N101VO.setUnifRqsTcd(unifRqsTcd);
				GA01N101VO.setUnifRqsDlPcd("01");
				GA01N101VO.setHopeDt(rqsDt);
				//GA01N101VO.setRqsTtlNm("인장조제[" + unifRqsTcd + "]");
				GA01N101VO.setRqsTtlNm(salNm); // 2023.11.30 신청명을 인영명으로 설정	
				GA01N101VO.setRqsRsnCn(rqsRsnCn);

				GA01N101VO.setRqsDt(rqsDt);
				// 결재선 생성후
				// GA01N101VO.setAprvWrrptMtNo(newAprvWrrptMtNo);

				cnt = RQUR1000U0Dao.insertGA01N003(GA01N101VO);
				if (cnt == 0) {
					throw new CustomBadRequestException("신규등록 생성오류(통합신청). 입력값을 확인하세요", ErrorCode.BAD_REQUEST);
				}
			}

			// 인장신청_인장조제관리신청 등록
			if (true) {
				GA01N503VO GA01N503VO = new GA01N503VO();
				GA01N503VO.setRctNo(newRctNo);
				GA01N503VO.setRqsDt(rqsDt);
				GA01N503VO.setSalMtNo(salMtNo);

				cnt = GASR1000U0Dao.insertGA01N503(GA01N503VO);
				if (cnt == 0) {
					throw new CustomBadRequestException("신규등록 생성오류(인장조제관리신청). 입력값을 확인하세요", ErrorCode.BAD_REQUEST);
				}
			}
			
			// 인장관리번호 기준 기안문서정보 테이블 (GA01N509) 등록
			if(true){
				
				String docNo = null;
				String rqsTcd = null;
				
				if (trTcd.equals("W")) {
					docNo = vo.getWtdwDrftDocNo();
					rqsTcd = UNIF_RQS_TCD_WDRAL;  // 인장조제 회수
				} else if (trTcd.equals("D")) {
					docNo = vo.getDsusDrftDocNo();
					rqsTcd = UNIF_RQS_TCD_DSUS;  // 인장조제 폐기
				} else if (trTcd.equals("CHNG")) {
					docNo = vo.getRegDrftDocNo(); 
					rqsTcd = UNIF_RQS_TCD_CHNG;  // 내용변경
					//rqsTcd = UNIF_RQS_TCD_REG;  // 내용변경
				} 

				GA01N509VO GA01N509VO = new GA01N509VO();
				GA01N509VO.setSalMtNo(salMtNo);
				GA01N509VO.setUnifRqsTcd(rqsTcd);
				GA01N509VO.setDrftDocNo(docNo);
				
				cnt = GASR1000U0Dao.insertGA01N509(GA01N509VO);
				if(cnt == 0) {
			        throw new CustomBadRequestException("기안문서 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);							
				}				
			}
			
			// 결재상신처리
			if (true) {

				log.info("결재 모듈 ============[" + newRctNo + "] [" + rqsEpno + "][" + rqsOrzCd + "] [" + CD_APRV_PCD_SAL
						+ "]");

				// 상신 결재 등록 --> 여기서 결재선 모듈 호출
				newAprvWrrptMtNo = aprvWrrpt.aprvWrrpt(newRctNo, rqsEpno, rqsOrzCd, CD_APRV_PCD_SAL, PSIT_MENU_ID);

				log.info("newAprvWrrptMtNo [" + newAprvWrrptMtNo + "]");
			}

		}

		return cnt;
	}
	
	/* 인장조제관리 승인 */
	@Override
	public int updateGA01N501Aprv(String strRctNo) {
		
		GA01N503VO rctNoVo = new GA01N503VO();
		rctNoVo.setRctNo(strRctNo);
		
		// 내용변경 -> 사용중 기안문 수정
		int rctNoVoCnt = GASR1000U0Dao.updateGA01N509Aprv(rctNoVo);
		log.info("인장조제별기안문서 변경 건수 ============ rctNoVoCnt [" + rctNoVoCnt + "] ");
		
		int pCnt;
		GA01N501VO GA01N501VO = new GA01N501VO();
		GA01N501VO.setRctNo(strRctNo);
		pCnt = GASR1000U0Dao.updateGA01N501Aprv(GA01N501VO);
		return pCnt;
	}
	
	/* 인장조제관리 반려 */
	@Override
	public int updateGA01N501Rtrn(String strRctNo) {
		
		GA01N501VO paramVo = new GA01N501VO();
		paramVo.setRctNo(strRctNo);
		
		GA01N501VO rtnVo = GASR1000U0Dao.selectGA01N501Scd(paramVo);
		if (rtnVo == null) {
			throw new CustomBadRequestException("대상건이 존재하지않습니다. 인장조제관리번호를 확인하세요[" + strRctNo + "]",
					ErrorCode.BAD_REQUEST);
		}
		
		// 인장조제별기안문서
		int docCnt = 0;
		GA01N509VO docVo = new GA01N509VO();
		docVo.setSalMtNo(rtnVo.getSalMtNo());
		
		if(CD_SEAL_SCD_CHNG_ING.equals(rtnVo.getSealScd())) { // 내용변경중 
			
			GA01N503VO rctNoVo = new GA01N503VO();
			rctNoVo.setRctNo(strRctNo);
			rctNoVo.setSalMtNo(rtnVo.getSalMtNo());
			
			int fileVoCnt = GASR1000U0Dao.updateGA09N411UseYn(rctNoVo);
			log.info("파일수정 건수 ============ fileVoCnt [" + fileVoCnt + "] ");
			
			// 내용변경 -> 사용중 데이터 롤백  
			int rctNoVoCnt = GASR1000U0Dao.updateGA01N501Rtrn(rctNoVo);
			log.info("데이터 롤백 건수 ============ rctNoVoCnt [" + rctNoVoCnt + "] ");
			
		} else if(CD_SEAL_SCD_RQS_ING.equals(rtnVo.getSealScd())) { // 조제신청중 20231227
			
			docVo.setUnifRqsTcd(UNIF_RQS_TCD_REG);
			docCnt = GASR1000U0Dao.deleteGA01N509(docVo);
			log.info("문서 롤백 건수 ============ docCnt [" + docCnt + "] ");
			
		} else if(CD_SEAL_SCD_WDRAL_ING.equals(rtnVo.getSealScd())) { // 회수신청중 20231227

			docVo.setUnifRqsTcd(UNIF_RQS_TCD_WDRAL);
			docCnt = GASR1000U0Dao.deleteGA01N509(docVo);
			log.info("문서 롤백 건수 ============ docCnt [" + docCnt + "] ");
			
		} else if(CD_SEAL_SCD_DSUS_ING.equals(rtnVo.getSealScd())) { // 조제신청중 20231227

			docVo.setUnifRqsTcd(UNIF_RQS_TCD_DSUS);
			docCnt = GASR1000U0Dao.deleteGA01N509(docVo);
			log.info("문서 롤백 건수 ============ docCnt [" + docCnt + "] ");
		}


		int iRtn = 0;
		//반려 대상 데이터 조회
		GA01N501VO vo = new GA01N501VO();
		vo.setRctNo(strRctNo);
		vo.setSealScd(rtnVo.getSealScd());
		vo.setSalMtNo(rtnVo.getSalMtNo());
		iRtn = GASR1000U0Dao.updateGA01N501SealScd(vo);
		return iRtn;
		
	}
	
	/* 인장조제관리 폐기 일괄신청 */
	@Override
	public int updateListGA01N501ByDSUS(GASR1000U0In04VO vo) {

		// 변수 초기화
		int cnt = 0;

		GA01N501VO GA01N501VO = null;
		String salMtNo = null; // 인장조제관리번호
		String salNm = null; // 인장명
		List<GA01N501Vs01InVO> gridGA01N501 = null; /* 폐기신청 다건내역 */
		GA01N501Vs01InVO inDataVo = null;

		String dsusDt = null; // 폐기일자
		//String dsusRsnCn = null; // 폐기사유
		//String drftDocNo3 = null; // 폐기기안문서
		String drftDocNo = null; // 폐기기안문서
		
		String newRctNo = "0"; // 신규신청번호
		String rqsEpno = null; // 신청사원번호
		String rqsOrzCd = null; // 신청조직코드
		String newAprvWrrptMtNo = null; // 신규결재관리번호
		GA01N101VO GA01N101VO = null; // 통합신청
		// 채번vo
		GaSrno00In00VO rctVo = new GaSrno00In00VO();

		// 전처리 : 입력값 체크
		{
			dsusDt = vo.getDsusDt();
			//dsusRsnCn = vo.getSalDsusRsnCn(); // 폐기사유 사용안함
			//drftDocNo3 = vo.getDrftDocNo3();
			drftDocNo = vo.getDsusDrftDocNo();
			gridGA01N501 = vo.getGridGA01N501();

			if (dsusDt == null || dsusDt.equals("")) {
				throw new CustomBadRequestException("필수입력항목[폐기일자] 오류. 입력값을 확인하세요[" + dsusDt + "]",
						ErrorCode.BAD_REQUEST);
			}
//			if (dsusRsnCn == null || dsusRsnCn.equals("")) {
//				throw new CustomBadRequestException("필수입력항목[폐기사유] 오류. 입력값을 확인하세요[" + dsusRsnCn + "]",
//						ErrorCode.BAD_REQUEST);
//			}
			if (drftDocNo == null || drftDocNo.equals("")) {
				throw new CustomBadRequestException("필수입력항목[폐기기안문서] 오류. 입력값을 확인하세요[" + drftDocNo + "]",
						ErrorCode.BAD_REQUEST);
			}

			if (gridGA01N501 == null || gridGA01N501.size() <= 0) {
				throw new CustomBadRequestException("필수입력항목[페기대상건] 입력 오류. 폐기대상건이 포함되지 않았습니다. [" + gridGA01N501 + "]",
						ErrorCode.BAD_REQUEST);
			}

		}

		for (int i = 0; i < gridGA01N501.size(); i++) {
			inDataVo = gridGA01N501.get(i);
			salMtNo = inDataVo.getSalMtNo();

			GA01N501VO = new GA01N501VO();
			GA01N501VO.setSalMtNo(salMtNo);
			GA01N501VO.setDsusDt(dsusDt);
			//GA01N501VO.setSalDsusRsnCn(dsusRsnCn);
			
			// 기등록 데이터 정합성 체크
			{
				GA01N501VO chkVo = null;
				/* 인장조제관리 상세정보조회(PK) */
				chkVo = GASR1000U0Dao.selectGA01N501PK(GA01N501VO);
				if (chkVo == null) {
					throw new CustomBadRequestException("폐기 대상건이 존재하지않습니다. 인장조제관리번호를 확인하세요[" + salMtNo + "]",
							ErrorCode.BAD_REQUEST);
				} else {
					salNm = chkVo.getSalNm(); // 2023.11.30 신청명을 인영명으로 설정	
				}

				// 폐기 처리전 기등록체크
				//if (!chkVo.getSealScd().equals("04")) {
				if (!chkVo.getSealScd().equals(CD_SEAL_SCD_WDRAL)) { // CD_SEAL_WDRAL = "05";       // 회수
					throw new CustomBadRequestException(
							"폐기 대상건[" + salMtNo + "] 인감상태코드를 확인하세요. 인감상태코드는 회수후 365+1일 초과건만 폐기가능합니다. ["
									+ chkVo.getSealScd() + "][" + chkVo.getSealScdNm() + "]",
							ErrorCode.BAD_REQUEST);
				}
				// 폐기
				if (chkVo.getWtdwDt() == null || chkVo.getWtdwDt().equals("")) {
					throw new CustomBadRequestException("폐기 대상건[" + salMtNo
							+ "] 회수일자를 확인하세요. 인감상태코드는 회수후 365+1일 초과건만 폐기가능합니다. [" + chkVo.getWtdwDt() + "]",
							ErrorCode.BAD_REQUEST);
				}

				String wtdwDt = chkVo.getWtdwDt();
				String minDsusDt = DateUtil.getAddDay(wtdwDt, 365 + 1); // 폐기가능 최소 일자 = 회수일자 + (365+1)

				// 입력받은 폐기일자 >= 폐기가능 최소일자 (회수일 + 365 + 1)
				if (Integer.parseInt(dsusDt) < Integer.parseInt(minDsusDt)) {
					throw new CustomBadRequestException(
							"폐기 대상건[" + salMtNo + "] 회수일자를 확인하세요. 회수후 365+1일 초과건만 폐기가능합니다. 회수일자[" + wtdwDt + "]폐기요청일["
									+ dsusDt + "] 최소폐기가능일자[" + minDsusDt + "]",
							ErrorCode.BAD_REQUEST);
				}
			}

			// 폐기 신청 처리
			{
				GA01N501VO.setSealScd(CD_SEAL_SCD_DSUS_ING); // 인감상태코드 05:폐기신청중 -> 상신올릴경우 상태표시??
				int updateCnt = GASR1000U0Dao.updateGA01N501ByDSUS(GA01N501VO);

				if (updateCnt == 0) {
					throw new CustomBadRequestException("폐기처리 오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);
				}

				String rqsDt = DateUtil.getTodayString("yyyyMMdd");
				//String rqsScd = "";
				String unifRqsPcd = CD_UNIF_RQS_PCD_SAL;
				String unifRqsTcd = "";

				// 통합신청 데이터 세팅
				if (true) {
					// 통합신청 신규접수번호 채번
					rctVo.setCdKndNo("CHAEBUN");
					rctVo.setCmnCdVl(CD_UNIF_RQS_PCD_SAL);
					rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
					newRctNo = rctVo.getRpbzGnoSrno();

					rqsEpno = vo.getRqsEpno();
					rqsOrzCd = vo.getRqsOrzCd();

					// 폐기 수정처리
					unifRqsTcd = UNIF_RQS_TCD_DSUS;
					GA01N101VO = new GA01N101VO();

					GA01N101VO.setRctNo(newRctNo);
					// GA01N101VO.setRqsScd(rqsScd);
					GA01N101VO.setRqsEpno(rqsEpno);
					GA01N101VO.setRqsOrzCd(rqsOrzCd);
					GA01N101VO.setUnifRqsPcd(unifRqsPcd);
					GA01N101VO.setUnifRqsTcd(unifRqsTcd);
					GA01N101VO.setUnifRqsDlPcd("01");
					GA01N101VO.setHopeDt(rqsDt);
					//GA01N101VO.setRqsTtlNm("인장조제[" + unifRqsTcd + "]");
					GA01N101VO.setRqsTtlNm(salNm); // 2023.11.30 신청명을 인영명으로 설정	
					//GA01N101VO.setRqsRsnCn(dsusRsnCn);

					GA01N101VO.setRqsDt(rqsDt);

					cnt = RQUR1000U0Dao.insertGA01N003(GA01N101VO);
					if (cnt == 0) {
						throw new CustomBadRequestException("신규등록 생성오류(통합신청). 입력값을 확인하세요", ErrorCode.BAD_REQUEST);
					}
				}

				// 인장신청_인장조제관리신청 등록
				if (true) {
					GA01N503VO GA01N503VO = new GA01N503VO();
					GA01N503VO.setRctNo(newRctNo);
					GA01N503VO.setRqsDt(rqsDt);
					GA01N503VO.setSalMtNo(salMtNo);

					cnt = GASR1000U0Dao.insertGA01N503(GA01N503VO);
					if (cnt == 0) {
						throw new CustomBadRequestException("신규등록 생성오류(인장조제관리신청). 입력값을 확인하세요", ErrorCode.BAD_REQUEST);
					}
				}
				
				// 인장관리번호 기준 기안문서정보 테이블 (GA01N509) 등록
				if(true){
					GA01N509VO GA01N509VO = new GA01N509VO();
					GA01N509VO.setSalMtNo(salMtNo);
					GA01N509VO.setUnifRqsTcd(UNIF_RQS_TCD_DSUS);
					GA01N509VO.setDrftDocNo(drftDocNo);
					
					cnt = GASR1000U0Dao.insertGA01N509(GA01N509VO);
					if(cnt == 0) {
				        throw new CustomBadRequestException("기안문서 생성오류(인장조제관리접수). 입력값을 확인하세요", ErrorCode.BAD_REQUEST);							
					}				
				}

				// 결재상신처리
				if (true) {
					log.info("결재 모듈 ============[" + newRctNo + "] [" + rqsEpno + "][" + rqsOrzCd + "] ["
							+ CD_APRV_PCD_SAL + "]");

					// 상신 결재 등록 --> 여기서 결재선 모듈 호출
					newAprvWrrptMtNo = aprvWrrpt.aprvWrrpt(newRctNo, rqsEpno, rqsOrzCd, CD_APRV_PCD_SAL, PSIT_MENU_ID);

					log.info("newAprvWrrptMtNo [" + newAprvWrrptMtNo + "]");
				}

			}

			cnt++;
		}

		return cnt;
	}

	/* 인장조제관리 상세정보조회(승인관리-상세) */
	@Override
	public GASR1000U0Out01VO selectGA01N501Aprv(GASR1000U0In02VO vo) {

		// 변수 초기화
		GA01N501VO GA01N501VO = new GA01N501VO();
		GASR1000U0Out01VO outVo = new GASR1000U0Out01VO();
		String rctNo = null; // 접수번호

		// 전처리 : 입력값 체크
		{
			rctNo = vo.getRctNo();
			if (rctNo == null || rctNo.equals("")) {
				throw new CustomBadRequestException("필수입력항목[접수번호] 오류. 입력값을 확인하세요[" + rctNo + "]",
						ErrorCode.BAD_REQUEST);
			}
		}

		// 조회
		{
			// 데이터 카피
			ObjectCopyUtil.copyFields(vo, GA01N501VO);
			GA01N501VO = GASR1000U0Dao.selectGA01N501Aprv(GA01N501VO);

			if (GA01N501VO == null) {
				throw new CustomBadRequestException("조회 대상건이 존재하지않습니다. 접수번호를 확인하세요[" + rctNo + "]",
						ErrorCode.BAD_REQUEST);
			}

			// 출력데이터 카피
			ObjectCopyUtil.copyFields(GA01N501VO, outVo);
		}

		return outVo;
	}

	
	/* 인장관리번호 최신화(임시) */	
	@Override
	public int updateCmnByGA01N501() {
		
		List<GA01N501VO> maxNoList = GASR1000U0Dao.selectGA01N501MaxNo();
		int cnt=0;
		if(maxNoList != null && maxNoList.size()>0) {
			cnt = GASR1000U0Dao.updateCmnByGA01N501(maxNoList);
		}
		return cnt;
	}
	
}
