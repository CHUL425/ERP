package com.miraeasset.biz.rq.sr.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.miraeasset.biz.rq.am.service.RQAM2000V0Service;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0In00VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0In01VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0Out01VO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.code.vo.GaCode01In00VO;
import com.miraeasset.biz.common.code.vo.GaCode01Out00VO;
import com.miraeasset.biz.common.code.vo.GaSrno00In00VO;
import com.miraeasset.biz.common.dao.CommonDao;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.meta.vo.AprvWrrptInVO;
import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA01N109VO;
import com.miraeasset.biz.common.meta.vo.GA01N504VO;
import com.miraeasset.biz.common.meta.vo.GA01N505OutQ1VO;
import com.miraeasset.biz.common.meta.vo.GA01N505OutQ2VO;
import com.miraeasset.biz.common.meta.vo.GA01N505VO;
import com.miraeasset.biz.common.meta.vo.GA01N510VO;
import com.miraeasset.biz.common.meta.vo.GA09N411VO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02InVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02OutVO;
import com.miraeasset.biz.common.meta.vo.GA09N607InVO;
import com.miraeasset.biz.common.meta.vo.GA09N607VO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.aprvWrrpt.AprvWrrpt;
import com.miraeasset.biz.common.util.massage.MsgSenService;
import com.miraeasset.biz.ga.sr.dao.GASR1000U0Dao;
import com.miraeasset.biz.rq.am.dao.RQAM1000U0Dao;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In00VO;
import com.miraeasset.biz.rq.rr.dao.RQRR1000U0Dao;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;
import com.miraeasset.biz.rq.sr.dao.RQSR1000U0Dao;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In00VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In01VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In03VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In04VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In05VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In17VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In19VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In20VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In21VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In23VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In24VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In25VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In26VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out00VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out01VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out02VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out05VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out11VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out15VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out17VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out18VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out19VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out20VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out21VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out23VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out24VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out25VO;

@Service
@Transactional
public class RQSR1000U0ServiceImpl implements RQSR1000U0Service {

	@Autowired
	RQSR1000U0Dao RQSR1000U0Dao;
	
	@Autowired
	RQRR1000U0Dao RQRR1000U0Dao;

	@Autowired
	GASR1000U0Dao GASR1000U0Dao;

	@Autowired
	RQAM1000U0Dao RQAM1000U0Dao;

	@Autowired
	CommonDao CommonDao;

	@Autowired
	CodeDao CodeDao;	
	
	@Autowired
	RQAM1000U0Dao rqamDao;
	
	@Autowired
	AprvWrrpt aprvWrrpt;	
	
	@Autowired
	MsgSenService msg;

	@Autowired
	RQAM2000V0Service rqam2000V0Service;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass()); 
	
	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "00"; // 임시저장 
	private final String CD_RQS_SCD_APV_ING  = "05"; // 승인중 
	private final String CD_RQS_SCD_APV_CMPN = "10"; // 승인완료 
	private final String CD_RQS_SCD_RTRN     = "30"; // 반려
	private final String CD_RQS_SCD_PRC_CMPN = "40"; // 처리완료
	private final String CD_RQS_SCD_USP_SMIT = "90"; // 사용처제출
	private final String CD_RQS_SCD_ORG_DSUS = "91"; // 원본폐기
	
	private final String CD_UNIF_RQS_PCD_SALG  = "05"; // 신청유형코드 05:인감날인
	
	/* 신청시퀀스번호 채번 상세코드*/
	private final String SEAL_RQS_SALG = "SEAL_RQS_SALG"; // 인감날인신청
	private final String SEAL_RQS_CERT = "SEAL_RQS_CERT"; // 인감증명서신청_등기부등본
	private final String SEAL_RQS_SEAL = "SEAL_RQS_SEAL"; // 인감증명서신청_인감증명서
	
	/* SEAL_CTFW_SCD 인감증명서상태코드*/
	private final String SEAL_CTFW_SCD_INQ  = "10"; // 입고 
	private final String SEAL_CTFW_SCD_OUTQ = "20"; // 출고
	private final String SEAL_CTFW_SCD_DSUS = "30"; // 폐기
	
	/* SEAL_CTFW_DL_SCD 인감증명서상세상태코드*/
	private final String SEAL_CTFW_DL_SCD_INQ       = "1010"; // 입고      
	private final String SEAL_CTFW_DL_SCD_USE_ING   = "2010"; // 사용중     
	private final String SEAL_CTFW_DL_SCD_USE_CMPN  = "2020"; // 사용완료    
	private final String SEAL_CTFW_DL_SCD_DSUS_CMPN = "2030"; // 원본폐기완료  
	private final String SEAL_CTFW_DL_SCD_INQ_DSUS  = "3010"; // 입고폐기    
	private final String SEAL_CTFW_DL_SCD_XPIR_DSUS = "3020"; // 만료폐기    
	private final String SEAL_CTFW_DL_SCD_ERR_DSUS  = "3030"; // 오류폐기    
	private final String SEAL_CTFW_DL_SCD_DRCT_DSUS = "3040"; // 직접폐기    
	
	/* SEAL_CTFW_TCD 인감증명서구분코드*/
	private final String SEAL_CTFW_TCD_SEAL = "10"; // 인감증명서
	private final String SEAL_CTFW_TCD_CERT = "20"; // 등기부등본
	
	/* UNIF_RQS_DL_PCD 통합신청상세유형코드*/
	private final String UNIF_RQS_DL_PCD_ALL  = "0501"; // 인감날인&증명서신청
	private final String UNIF_RQS_DL_PCD_SALG = "0502"; // 인감날인신청
	private final String UNIF_RQS_DL_PCD_SEAL = "0503"; // 증명서신청
	
	private final String PSIT_MENU_ID = "RQSR1000m0";
	
	/* 인감날인증명서신청 목록조회 */	
	@Override
	public List<RQSR1000U0Out00VO> selectListGA01N101BySeal(RQSR1000U0In00VO vo, HttpServletRequest request) {

		if (vo.getQryStrtDt() == null || vo.getQryStrtDt().equals("")) {
			throw new CustomBadRequestException("신청일자 조회시작일을 확인하세요. ["+vo.getQryStrtDt()+"]", ErrorCode.BAD_REQUEST);
		}
		
		if (vo.getQryEndDt() == null || vo.getQryEndDt().equals("")) {
			throw new CustomBadRequestException("신청일자 조회종료일을 확인하세요. ["+vo.getQryEndDt()+"]", ErrorCode.BAD_REQUEST);
		}
		
		HttpSession session = request.getSession();
		LoginOutVO loginVO = (LoginOutVO)session.getAttribute("loginOutVO");
		
		/*[2024-01-24] 조직대표자는 전체하위조직 조회*/
		String orzRptvYn = loginVO.getOrzRptvYn();  // 대표자여부
		
		if("Y".equals(orzRptvYn)) {
			vo.setOrzRptvYn(orzRptvYn);   // 직책
			vo.setRqsOrzCd(loginVO.getBlngOrzCd()); // 소속조직
			vo.setEpno(loginVO.getEpno());
			
		} else if(StringUtils.isBlank(vo.getRqsOrzCd())) {
			
			/* [2023-10-19]: 총무팀 제외하고는 자기팀에서 신청한 내역만 보이게 수정 */
			String epOrzCd = loginVO.getBlngOrzCd();
			boolean isManager = loginVO.getUserGrpCdList().contains("001") || loginVO.getUserGrpCdList().contains("999");
			if(!!!isManager) { 
				vo.setRqsOrzCd(epOrzCd);
			}
			/* 수정 끝 */
		}
		
		if (!StringUtils.isBlank(vo.getRqsScd())) {
			vo.setArrRqsScd(Arrays.asList(vo.getRqsScd().split(",")));
		}

		/* 사전참조 대상이 없으면 "대상아님" */
		List<RQSR1000U0Out00VO> resultList = RQSR1000U0Dao.selectListGA01N101BySeal(vo);

		for(RQSR1000U0Out00VO result : resultList) {
			String aprvWrrptMtNo = result.getAprvWrrptMtNo();

			RQAM2000V0In01VO rqam2000V0In01VO = new RQAM2000V0In01VO();
			List<RQAM2000V0Out01VO> rqam2000V0Out01VOList;
			rqam2000V0In01VO.setAprvWrrptMtNo(aprvWrrptMtNo);
			rqam2000V0In01VO.setSelTyp("rqsr");
			rqam2000V0Out01VOList = rqam2000V0Service.selectAprvPstt(rqam2000V0In01VO);

			if(rqam2000V0Out01VOList.size() > 0) continue;
			result.setRefDt("대상아님");
		}

		return RQSR1000U0Dao.selectListGA01N101BySeal(vo);
	}
	
	/* 인감날인증명서신청 목록조회 - 엑셀*/	
	//@Override
	//public List<RQSR1000U0Out00VO> selectListGA01N101BySeal(RQSR1000U0In00VO vo) {
	//	return RQSR1000U0Dao.selectListGA01N101BySeal(vo);
	//}
	
	/* 인감날인증명서신청 상세조회 */	
	@Override
	public RQSR1000U0Out01VO selectUnifRqsBySeal(RQSR1000U0In01VO vo) {
		// 변수 초기화
		
		
		GA01N101VO GA01N101VO = null; /* 통합신청 */

		List<GA01N504VO> gridGA01N504 = null;    /* 인감신청_인감날인신청 다건내역 */		
		GA01N504VO GA01N504VO = null; /* 인감신청_인감날인신청 */
		List<GA09N411VO> gridGA09N411 = null;    /* 첨부파일 다건내역 */		
		GA09N411VO GA09N411VO = new GA09N411VO(); /* 첨부파일 */		

		List<GA01N505VO> gridGA01N505 = null;    /* 인감신청_인감증명서신청 다건내역 */		
		GA01N505VO GA01N505VO = null; /* 인감신청_인감증명서신청*/
		
	    List<GA01N109VO> gridGA01N109 = null;    /* 기안문서 다건내역 */		
	    GA01N109VO GA01N109VO = null; /* 기안문서 */
		
		RQSR1000U0Out01VO outVo = new RQSR1000U0Out01VO();
		
		
		String rctNo = null; //접수번호
		
		// 전처리 : 입력값 체크
		{
			rctNo = vo.getRctNo();
			if(rctNo == null || rctNo.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[접수번호] 오류. 입력값을 확인하세요["+rctNo+"]", ErrorCode.BAD_REQUEST);		
			}
		}

		// 조회
		{
			// 데이터 카피
			GA01N101VO = new GA01N101VO();
			GA01N101VO.setRctNo(rctNo);
			GA01N101VO.setEpno(vo.getEpno());
			
			GA01N101VO = RQSR1000U0Dao.selectGA01N101(GA01N101VO);
			
			if(GA01N101VO == null) {
		        throw new CustomBadRequestException("통합신청 대상건이 존재하지않습니다. 접수번호를 확인하세요["+rctNo+"]", ErrorCode.BAD_REQUEST);						
			}
			
			// 통합신청내역 데이터 카피
			ObjectCopyUtil.copyFields(GA01N101VO, outVo);	
			
			GA01N504VO = new GA01N504VO();
			GA01N504VO.setRctNo(rctNo);
			List<GA01N504VO> gridGA01N504_data = null;	
			
			// 데이터 조회후 첨부파일목록 재세팅위해 
			gridGA01N504_data = RQSR1000U0Dao.selectListGA01N504(GA01N504VO);

			gridGA01N504 = new ArrayList<GA01N504VO>();    /* 인감신청_인감날인신청 다건내역 */
			
			for(int i=0;i<gridGA01N504_data.size();i++) {
				GA01N504VO = gridGA01N504_data.get(i);
				if(GA01N504VO.getFileNo() != null && !"".equals(GA01N504VO.getFileNo())) {
					GA09N411VO = new GA09N411VO();
					GA09N411VO.setFileNo(GA01N504VO.getFileNo());
					gridGA09N411 = CommonDao.selectListGA09N411(GA09N411VO); // 첨부파일 목록조회
					GA01N504VO.setGridGA09N411(gridGA09N411);
				}
				gridGA01N504.add(GA01N504VO); 
			}
			outVo.setGridGA01N504(gridGA01N504);
			
			GA01N505VO = new GA01N505VO();
			GA01N505VO.setRctNo(rctNo);
			gridGA01N505 = RQSR1000U0Dao.selectListGA01N505(GA01N505VO);
			outVo.setGridGA01N505(gridGA01N505);
		
			GA01N109VO = new GA01N109VO();
			GA01N109VO.setRctNo(rctNo);
			gridGA01N109 = RQSR1000U0Dao.selectListGA01N109(GA01N109VO);
			outVo.setGridGA01N109(gridGA01N109);
			
		}
		
		return outVo;
	}	
	
	/* 인감신청_인감날인신청신청상태 정보조회 */	
    @Override
	public RQSR1000U0Out11VO selectInfoGA01N101BySeal(RQSR1000U0In00VO vo, HttpServletRequest request){
    	
		HttpSession session = request.getSession();
		LoginOutVO loginVO = (LoginOutVO)session.getAttribute("loginOutVO");
		
		/*[2024-01-24] 조직대표자는 전체하위조직 조회*/
		String orzRptvYn = loginVO.getOrzRptvYn();  // 대표자여부
		
		if("Y".equals(orzRptvYn)) {
			vo.setOrzRptvYn(orzRptvYn);   // 직책
			vo.setRqsOrzCd(loginVO.getBlngOrzCd()); // 소속조직
			vo.setEpno(loginVO.getEpno());
		} else if(StringUtils.isBlank(vo.getRqsOrzCd())) {
			
			/* [2023-10-19]: 총무팀 제외하고는 자기팀에서 신청한 내역만 보이게 수정 */
			String epOrzCd = loginVO.getBlngOrzCd();
			boolean isManager = loginVO.getUserGrpCdList().contains("001") || loginVO.getUserGrpCdList().contains("999");
			if(!!!isManager) { 
				vo.setRqsOrzCd(epOrzCd);
			}
			/* 수정 끝 */
		}

    	if (!StringUtils.isBlank(vo.getRqsScd())) {
    		vo.setArrRqsScd(Arrays.asList(vo.getRqsScd().split(",")));
    	}

		return RQSR1000U0Dao.selectInfoGA01N101BySeal(vo);
	}	
    
    /* 인감날인증명서신청 임시저장/상신 */	
	@Override
	public String reqRegi(RQSR1000U0In03VO vo) {
		// 변수 초기화
		String prcTp = "";
		boolean bfRegiYn = false; /* 기등록 여부 : false-신규등록 true-대상update */

		// 채번vo
		GaSrno00In00VO rctVo = new GaSrno00In00VO();
		String rctNo = null; //접수번호(신규접수일자)
		String rqsEpno = null; // 신청사원번호
		String rqsOrzCd = null; // 신청조직코드		
		String unifRqsPcd = CD_UNIF_RQS_PCD_SALG; // 통합신청유형코드 : 05(인감날인)
		int cnt = 0;
		int rctDlNo = 0;
		
		GA01N101VO GA01N101VO = null; /* 통합신청 */
		GA01N504VO GA01N504VO = null; /* 인감신청_인감날인신청 */
		List<GA01N504VO> gridGA01N504 = null;    /* 인감신청_인감날인신청 다건내역 */		
		GA01N505VO GA01N505VO = null; /* 인감신청_인감증명서신청*/
		List<GA01N505VO> gridGA01N505 = null;    /* 인감신청_인감증명서신청 다건내역 */		
	    GA01N109VO GA01N109VO = null; /* 기안문서 */
	    List<GA01N109VO> gridGA01N109 = null;    /* 기안문서 다건내역 */		
		
	    //String newAprvWrrptMtNo = null; // 결재상신관리번호
		String unifDlPcd = ""; // 상세조회_구분
		
		// 전처리 : 입력값 체크
		{
			rctNo = vo.getRctNo();
			rqsEpno  = vo.getRqsEpno();
			rqsOrzCd = vo.getRqsOrzCd();
			prcTp = vo.getPrcTp();
			
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
			
			gridGA01N504 = vo.getGridGA01N504();
			gridGA01N505 = vo.getGridGA01N505();
			if((gridGA01N504==null||gridGA01N504.size()==0) && (gridGA01N505==null || gridGA01N505.size()==0)) {
				throw new CustomBadRequestException("필수입력항목 날인신청/증명서신청 내역 없음", ErrorCode.BAD_REQUEST);
			}

			// 구분 설정
			if(gridGA01N504.size() > 0 && gridGA01N505.size()==0) { // 인감날인신청
				unifDlPcd = UNIF_RQS_DL_PCD_SALG;
			} else if (gridGA01N504.size()==0 && gridGA01N505.size()>0) { // 증명서신청
				unifDlPcd = UNIF_RQS_DL_PCD_SEAL;
			} else if (gridGA01N504.size()>0 && gridGA01N505.size()>0) { // 인감날인&증명서신청
				unifDlPcd = UNIF_RQS_DL_PCD_ALL;
			}
			
			// 인감날인 입력값 체크
			if(gridGA01N504 != null && gridGA01N504.size() > 0) {
				for(int i=0;i<gridGA01N504.size();i++) {
					GA01N504VO = gridGA01N504.get(i);
					if(GA01N504VO.getUseSealYn() == null || "".equals(GA01N504VO.getUseSealYn()) ) {
				        throw new CustomBadRequestException("필수입력항목 인감신청_인감날인신청[인감날인유형] 오류. 입력값을 확인하세요["+GA01N504VO.getUseSealYn()+"]", ErrorCode.BAD_REQUEST);		
					}
					
					// 인장관리번호 필수 체크
					if(GA01N504VO.getSalMtNo() == null || "".equals(GA01N504VO.getSalMtNo()) ) {
				        throw new CustomBadRequestException("필수입력항목 인감신청_인감날인신청[인장선택] 오류. 입력값을 확인하세요["+GA01N504VO.getSalMtNo()+"]", ErrorCode.BAD_REQUEST);		
					}

					// 문건명(사유)
					if(GA01N504VO.getRqsRsnCn() == null || "".equals(GA01N504VO.getRqsRsnCn()) ) {
				        throw new CustomBadRequestException("필수입력항목 인감신청_인감날인신청[문건명(사유)] 오류. 입력값을 확인하세요["+GA01N504VO.getRqsRsnCn()+"]", ErrorCode.BAD_REQUEST);		
					}

					// 제출처
					if(GA01N504VO.getSmitpCn() == null || "".equals(GA01N504VO.getSmitpCn()) ) {
				        throw new CustomBadRequestException("필수입력항목 인감신청_인감날인신청[제출처] 오류. 입력값을 확인하세요["+GA01N504VO.getSmitpCn()+"]", ErrorCode.BAD_REQUEST);		
					}
					
					// 날인부수
					if(GA01N504VO.getRqsQ() == null || GA01N504VO.getRqsQ().compareTo(BigDecimal.ZERO) <= 0 ) {
				        throw new CustomBadRequestException("필수입력항목 인감신청_인감날인신청[날인부수] 오류. 입력값을 확인하세요["+GA01N504VO.getRqsQ()+"]", ErrorCode.BAD_REQUEST);		
					}	
					
					// 사용계인감 체크
					if(GA01N504VO.getUseSealYn().equals("1")) {
						// 첨부파일 필수체크
						if(GA01N504VO.getFileNo() == null || "".equals(GA01N504VO.getFileNo()) ) {
					        throw new CustomBadRequestException("필수입력항목 인감신청_인감날인신청[첨부파일] 오류. 입력값을 확인하세요["+GA01N504VO.getFileNo()+"]", ErrorCode.BAD_REQUEST);		
						}
					}
					
				}
			}
			
			// 인감증명서신청 입력값 체크
			if(gridGA01N505 != null && gridGA01N505.size() > 0) {
				for(int i=0;i<gridGA01N505.size();i++) {
					GA01N505VO = gridGA01N505.get(i);
					
					if(SEAL_CTFW_TCD_SEAL.equals(GA01N505VO.getSealCtfwTcd())) { // 인감증명서
						// 인장관리번호 필수 체크
						if(GA01N505VO.getSalMtNo() == null || "".equals(GA01N505VO.getSalMtNo()) ) {
					        throw new CustomBadRequestException("필수입력항목 인감신청_인감증명서신청[인장선택] 오류. 입력값을 확인하세요["+GA01N505VO.getSalMtNo()+"]", ErrorCode.BAD_REQUEST);		
						}
					}
					
					// 신청수량
					if(GA01N505VO.getRqsQ() == null || GA01N505VO.getRqsQ().compareTo(BigDecimal.ZERO) <= 0 ) {
				        throw new CustomBadRequestException("필수입력항목 인감신청_인감증명서신청[신청수량] 오류. 입력값을 확인하세요["+GA01N505VO.getRqsQ()+"]", ErrorCode.BAD_REQUEST);		
					}	
					
					// 제출처
					if(GA01N505VO.getSmitpCn() == null || "".equals(GA01N505VO.getSmitpCn()) ) {
				        throw new CustomBadRequestException("필수입력항목 인감신청_인감증명서신청[제출처] 오류. 입력값을 확인하세요["+GA01N505VO.getSmitpCn()+"]", ErrorCode.BAD_REQUEST);		
					}
					
					// 용도
					if(GA01N505VO.getSmitUsgeCn() == null || "".equals(GA01N505VO.getSmitUsgeCn()) ) {
				        throw new CustomBadRequestException("필수입력항목 인감신청_인감증명서신청[제출용도] 오류. 입력값을 확인하세요["+GA01N505VO.getSmitUsgeCn()+"]", ErrorCode.BAD_REQUEST);		
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
				GA01N101VO.setUnifRqsTcd(unifRqsPcd+"0101"); // 고정값 
				//GA01N101VO.setUnifRqsDlPcd(unifRqsPcd+"01");
				GA01N101VO.setUnifRqsDlPcd(unifDlPcd);
				//GA01N101VO.setHopeDt();
				GA01N101VO.setRqsRsnCn("인감날인증명서신청");
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
			
			// 인감신청_인감날인신청 GA01N504VO : DELETE INSERT 처리
			{
				GA01N504VO = new GA01N504VO();
				GA01N504VO.setRctNo(rctNo);
				
				cnt = RQSR1000U0Dao.deleteGA01N504ByRctNo(GA01N504VO);
				
				gridGA01N504 = vo.getGridGA01N504();
				
				rctDlNo = 1;
				for(int i=0;i<gridGA01N504.size();i++) {
					
					String salgSqncNo = "";
					{
						// 인감날인신청시퀀스번호 채번
						rctVo.setCdKndNo("CHAEBUN");
						rctVo.setCmnCdVl(SEAL_RQS_SALG);
						rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
						salgSqncNo = rctVo.getRpbzGnoSrno();

						log.info("인감날인신청시퀀스번호 채번 salgSqncNo ============["+salgSqncNo+"]");	
					}
					
					GA01N504VO = gridGA01N504.get(i);
					GA01N504VO.setSealSalgRqsSqncNo(salgSqncNo);
					GA01N504VO.setRctNo(rctNo);
					GA01N504VO.setRctDlNo(rctDlNo+"");
					
					cnt = RQSR1000U0Dao.insertGA01N504(GA01N504VO);
					if(cnt == 0) {
				        throw new CustomBadRequestException("인감신청_인감날인신청 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
					}

					rctDlNo++;
				}
			}
			
			// 인감신청_인감증명서신청 GA01N505VO : DELETE INSERT 처리
			{
				GA01N505VO = new GA01N505VO();
				GA01N505VO.setRctNo(rctNo);
				
				cnt = RQSR1000U0Dao.deleteGA01N505ByRctNo(GA01N505VO);
				
				gridGA01N505 = vo.getGridGA01N505();
				
				rctDlNo = 1;
				for(int i=0;i<gridGA01N505.size();i++) {
					
					GA01N505VO = gridGA01N505.get(i);
					
					String strTcd = ""; // 채번구분값
					if(SEAL_CTFW_TCD_SEAL.equals(GA01N505VO.getSealCtfwTcd())) { // 인감증명서
						strTcd = SEAL_RQS_SEAL;
					} else if (SEAL_CTFW_TCD_CERT.equals(GA01N505VO.getSealCtfwTcd())) { // 등기부등본
						strTcd = SEAL_RQS_CERT;
					} 
					
					
					String ctfwSqncNo = "";
					{
						// 인감날인신청시퀀스번호 채번
						rctVo.setCdKndNo("CHAEBUN");
						rctVo.setCmnCdVl(strTcd);
						rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
						ctfwSqncNo = rctVo.getRpbzGnoSrno();

						log.info("인감증명서신청시퀀스번호 채번 ctfwSqncNo ============["+ctfwSqncNo+"]");	
					}
					
					
					GA01N505VO.setSealCtfwRqsSqncNo(ctfwSqncNo);
					GA01N505VO.setRctNo(rctNo);
					GA01N505VO.setRctDlNo(rctDlNo+"");
					cnt = RQSR1000U0Dao.insertGA01N505(GA01N505VO);
					if(cnt == 0) {
				        throw new CustomBadRequestException("인감신청_인감증명서신청 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
					}

					rctDlNo++;
				}
			}
			
			// 통합신청기안문서 GA01N109VO : DELETE INSERT 처리
			{
				GA01N109VO = new GA01N109VO();
				GA01N109VO.setRctNo(rctNo);
				
				cnt = RQSR1000U0Dao.deleteGA01N109ByRctNo(GA01N109VO);
				
				gridGA01N109 = vo.getGridGA01N109();
				
				for(int i=0;i<gridGA01N109.size();i++) {
					GA01N109VO = gridGA01N109.get(i);
					GA01N109VO.setRctNo(rctNo);
					
					cnt = RQSR1000U0Dao.insertGA01N109(GA01N109VO);
					if(cnt == 0) {
				        throw new CustomBadRequestException("통합신청기안문서 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
					}
				}
			}			
			
			// 상신:결재상신처리
//			if(prcTp.equals("01")) {
				
				// 상신 결재 등록
				{
					List<AprvWrrptInVO> aprvlList =  vo.getAprvl();
					GA09N607InVO aprvVo = new GA09N607InVO();
					aprvVo.setRctNo(rctNo);
					aprvVo.setAprvl(aprvlList);
					aprvWrrpt.aprvWrrpt(aprvVo);
				}
				
				//log.info("결재 모듈 ============["+rctNo+"] ["+rqsEpno+"][" + rqsOrzCd +"] ["+CD_APRV_PCD_SALG+"] ["+PSIT_MENU_ID+"]");				
				// 상신 결재 등록 --> 여기서 결재선 모듈 호출
				//newAprvWrrptMtNo = aprvWrrpt.aprvWrrpt(rctNo, rqsEpno, rqsOrzCd, CD_APRV_PCD_SALG, PSIT_MENU_ID);
				//log.info("newAprvWrrptMtNo ["+newAprvWrrptMtNo+"]");
//			}
			
		}
		
		return rctNo;
	}	
	
	/* 인감날인증명서신청 삭제 */	
	@Override
	public int deleteUnifRqsBySeal(RQSR1000U0In04VO vo) {
		String rctNo = null; //접수번호(신규접수일자)
		int cnt = 0;
		int mCnt = 0;
		
		GA01N101VO GA01N101VO = null; /* 통합신청 */
		GA01N504VO GA01N504VO = null; /* 인감신청_인감날인신청 */
		GA01N505VO GA01N505VO = null; /* 인감신청_인감증명서신청*/
	    GA01N109VO GA01N109VO = null; /* 기안문서 */
		
		// 전처리 : 입력값 체크
		{
			rctNo = vo.getRctNo();
			
			log.info("입력접수번호 rctNo ============["+rctNo+"]");	
			if(rctNo == null || "".equals(rctNo)) {
		        throw new CustomBadRequestException("필수입력항목[접수번호] 오류. 입력값을 확인하세요["+rctNo+"]", ErrorCode.BAD_REQUEST);		
			}

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
			        throw new CustomBadRequestException("통합신청 신청상태코드를 확인하세요. 임시저장상태(00)일경우만 삭제처리 가능합니다. ["+GA01N101VO.getRqsScd()+"]["+GA01N101VO.getRqsScdNm()+"]", ErrorCode.BAD_REQUEST);						
				}
			}
		}

		// 삭제처리 
		{
			// 통합신청 삭제 (GA01N101)
			{
				// 통합신청  
				GA01N101VO = new GA01N101VO();
				GA01N101VO.setRctNo(rctNo);

				cnt = RQSR1000U0Dao.deleteGA01N101ByRctNo(GA01N101VO);		
				log.info("통합신청 삭제 (GA01N101) {} ",cnt);
				
				if(cnt == 0) {
			        throw new CustomBadRequestException("인감신청_인감날인신청 통합신청 삭제오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
				}
				
				// 인감신청_인감날인신청 GA01N504VO 삭제
				{
					GA01N504VO = new GA01N504VO();
					GA01N504VO.setRctNo(rctNo);
					
					mCnt = RQSR1000U0Dao.deleteGA01N504ByRctNo(GA01N504VO);
					log.info("인감신청_인감날인신청 GA01N504 삭제 {} ",mCnt);	
				}
				
				// 인감신청_인감증명서신청 GA01N505VO 삭제
				{
					GA01N505VO = new GA01N505VO();
					GA01N505VO.setRctNo(rctNo);
					
					mCnt = RQSR1000U0Dao.deleteGA01N505ByRctNo(GA01N505VO);
					log.info("인감신청_인감증명서신청 GA01N505 삭제 {} ",mCnt);	
				}
				
				// 통합신청기안문서 GA01N109VO 삭제
				{
					GA01N109VO = new GA01N109VO();
					GA01N109VO.setRctNo(rctNo);
					
					mCnt = RQSR1000U0Dao.deleteGA01N109ByRctNo(GA01N109VO);
					log.info("통합신청기안문서 GA01N109 삭제 {} ",mCnt);	
					
				}
			}
		}

		return cnt;
	}	
    
	/* 인감날인증명서신청 재상신 */	
	@Override
	public String reApplyByRctNo(RQSR1000U0In05VO vo, LoginOutVO loginVo) {

		// 채번vo
		GaSrno00In00VO rctVo = new GaSrno00In00VO();
		String preRctNo = null; //접수번호(기접수번호)
		String newRctNo = null; //접수번호(신규접수번호)
		String rqsEpno = null; // 신청사원번호
		String rqsOrzCd = null; // 신청조직코드		
		String unifRqsPcd = CD_UNIF_RQS_PCD_SALG; // 통합신청유형코드 : 05(인감날인)
		
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
				rctVo.setCmnCdVl(unifRqsPcd); // 인감날인신청:05
				rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
				newRctNo = rctVo.getRpbzGnoSrno();

				log.info("접수번호 채번 newRctNo ============["+newRctNo+"]");	
			}
			
			// 통합신청 데이터 세팅 (GA01N101)
			{
				// GA01N101 GA01N109
				Map<String, Object> map = new HashMap<>();
				map.put("rctNo", newRctNo);
				map.put("prevRctNo", preRctNo);

				map.put("optrId"    , loginVo.getEpno());
				map.put("oprtChnlCd", loginVo.getOprtChnlCd());
				map.put("oprtOrzCd" , loginVo.getOprtOrzCd());
				map.put("oprtIpAdr" , loginVo.getOprtIpAdr());

				int rtn = RQSR1000U0Dao.reApplyByRctNo(map);	
				if(rtn == 0) {
			        throw new CustomBadRequestException("통합신청 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
				}
				
				// 인감날인증명서신청 건수
				RQSR1000U0Out05VO outCntVo = RQSR1000U0Dao.selectSalgSealDocCnt(vo.getRctNo());
				int salgCnt = outCntVo.getSalgRqsCnt();
				int sealCnt = outCntVo.getSealRqsCnt();
				int ctfwCnt = outCntVo.getCtfwRqsCnt();

				// 인감신청_인감날인신청 GA01N504VO
				{
					int rctDlNo=1;
					int cnt=0;
					for(int i=0;i<salgCnt;i++) {
						
						//rctDlNo++;
						
						String salgSqncNo = "";
						{
							// 인감날인신청시퀀스번호 채번
							rctVo.setCdKndNo("CHAEBUN");
							rctVo.setCmnCdVl(SEAL_RQS_SALG);
							rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
							salgSqncNo = rctVo.getRpbzGnoSrno();

							log.info("인감날인신청시퀀스번호 채번 salgSqncNo ============["+salgSqncNo+"]");	
						}
						
						Map<String, Object> map504 = new HashMap<>();
						
						map504.put("sealSalgRqsSqncNo", salgSqncNo);
						map504.put("prevDlNo", rctDlNo);
						
						map504.put("rctNo", newRctNo);
						map504.put("prevRctNo", preRctNo);
						
						map504.put("optrId"    , loginVo.getEpno());
						map504.put("oprtChnlCd", loginVo.getOprtChnlCd());
						map504.put("oprtOrzCd" , loginVo.getOprtOrzCd());
						map504.put("oprtIpAdr" , loginVo.getOprtIpAdr());
						
						cnt = RQSR1000U0Dao.reApplyGA01N504(map504);
						if(cnt == 0) {
					        throw new CustomBadRequestException("인감신청_인감날인신청 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
						}

						rctDlNo++;
					}
				}
				
				// 인감신청_인감증명서신청 GA01N505VO - 인감증명서
				{
					int rctDlNo=1;
					int cnt=0;
					
					for(int j=0;j<sealCnt;j++) {
						
						String ctfwSqncNo = "";
						{
							// 인감날인신청시퀀스번호 채번
							rctVo.setCdKndNo("CHAEBUN");
							rctVo.setCmnCdVl(SEAL_RQS_SEAL); // 인감증명서
							rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
							ctfwSqncNo = rctVo.getRpbzGnoSrno();

							log.info("인감증명서신청시퀀스번호 채번 ctfwSqncNo ============["+ctfwSqncNo+"]");	
						}

						Map<String, Object> map505 = new HashMap<>();
						
						map505.put("sealCtfwRqsSqncNo", ctfwSqncNo);
						map505.put("prevDlNo", rctDlNo);
						
						map505.put("rctNo", newRctNo);
						map505.put("prevRctNo", preRctNo);

						map505.put("optrId"    , loginVo.getEpno());
						map505.put("oprtChnlCd", loginVo.getOprtChnlCd());
						map505.put("oprtOrzCd" , loginVo.getOprtOrzCd());
						map505.put("oprtIpAdr" , loginVo.getOprtIpAdr());
						
						cnt = RQSR1000U0Dao.reApplyGA01N505(map505);
						
						if(cnt == 0) {
					        throw new CustomBadRequestException("인감신청_인감증명서신청 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
						}
						rctDlNo++;
					}
					
					// 인감신청_인감증명서신청 GA01N505VO - 등기부등본
					cnt=0;
					for(int k=0;k<ctfwCnt;k++) {
						
						String ctfwSqncNo = "";
						{
							// 인감날인신청시퀀스번호 채번
							rctVo.setCdKndNo("CHAEBUN");
							rctVo.setCmnCdVl(SEAL_RQS_CERT); // 등기부등본
							rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
							ctfwSqncNo = rctVo.getRpbzGnoSrno();

							log.info("인감증명서신청시퀀스번호 채번 ctfwSqncNo ============["+ctfwSqncNo+"]");	
						}

						Map<String, Object> map505 = new HashMap<>();
						
						map505.put("sealCtfwRqsSqncNo", ctfwSqncNo);
						map505.put("prevDlNo", rctDlNo);
						
						map505.put("rctNo", newRctNo);
						map505.put("prevRctNo", preRctNo);
						
						map505.put("optrId"    , loginVo.getEpno());
						map505.put("oprtChnlCd", loginVo.getOprtChnlCd());
						map505.put("oprtOrzCd" , loginVo.getOprtOrzCd());
						map505.put("oprtIpAdr" , loginVo.getOprtIpAdr());
						
						cnt = RQSR1000U0Dao.reApplyGA01N505(map505);
						
						if(cnt == 0) {
					        throw new CustomBadRequestException("인감신청_인감증명서신청 생성오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
						}
						rctDlNo++;
					}
				}
			}
		}

		return newRctNo;
	}	    

	/* 인감날인증명서 승인대기 목록조회 */	
	@Override
	public List<RQSR1000U0Out21VO> selectListApvIng(RQSR1000U0In21VO vo) {
		
		RQAM1000U0In00VO inVo = new RQAM1000U0In00VO();
		inVo.setEpno(vo.getEpno());  
		inVo.setSelTyp(vo.getSelTyp());                 // 임감:rqsr
		inVo.setDcfcPcd(vo.getDcfcPcd());               // 참조:09
		inVo.setBizTcd(vo.getBizTcd());                 // 05 인감
		inVo.setAprvWrrptOrzCd(vo.getAprvWrrptOrzCd()); // 신청조직
		inVo.setRqsTtlNm(vo.getRqsTtlNm());             // 신청명
		
		int totCnt = RQAM1000U0Dao.selectSealAprvListTotCnt(inVo); 
		inVo.setTotCnt(totCnt);
		
		inVo.setPageNum(vo.getPageNum());
		inVo.setPageSize(vo.getPageSize());
		
		return  RQAM1000U0Dao.selectSealAprvList(inVo);	
	}	    
	
	/* 인감날인증명서 사전참조 목록조회 */	
	@Override
	public List<RQSR1000U0Out21VO> selectListApvRef(RQSR1000U0In21VO vo) {
		//return RQSR1000U0Dao.selectListApvRef(vo);
		
		RQAM1000U0In00VO inVo = new RQAM1000U0In00VO();
		inVo.setEpno(vo.getEpno());
		inVo.setSelTyp(vo.getSelTyp());                 // 임감:rqsr
		inVo.setDcfcPcd(vo.getDcfcPcd());               // 참조:09
		inVo.setBizTcd(vo.getBizTcd());                 // 05 인감
		inVo.setAprvWrrptOrzCd(vo.getAprvWrrptOrzCd()); // 신청조직
		inVo.setRqsTtlNm(vo.getRqsTtlNm());             // 신청명
		
		int totCnt = RQAM1000U0Dao.selectSealAprvListTotCnt(inVo); 
		inVo.setTotCnt(totCnt);
		
		inVo.setPageNum(vo.getPageNum());
		inVo.setPageSize(vo.getPageSize());
					
		return  RQAM1000U0Dao.selectSealAprvList(inVo);	
	}	    

	/* 인감날인 사전참조 다건 확인처리 */	
	@Override
	public int updateGA09N607ForCfmt(RQSR1000U0In23VO vo, HttpServletRequest request) {
		String aprvWrrptMtNo = null; /*결재상신관리번호  */
		String aprvRnk = null; /*결재순위  */
		String aprvDlRnk = null; /*결재상세순위  */
		
		int cnt = 0;
		int mCnt = 0;
		
		HttpSession session = request.getSession();
		LoginOutVO loginVO= (LoginOutVO)session.getAttribute("loginOutVO");
		String epNo = loginVO.getEpno();
		
		GA09N607VO GA09N607VO = null; /* 결재정보상세 */
		List<GA09N607VO> gridGA09N607 = null;    /* 결재정보상세 다건내역 */				
		
		// 전처리 : 입력값 체크
		{
			gridGA09N607 = vo.getGridGA09N607();
			if(gridGA09N607 != null && gridGA09N607.size() > 0) {
				for(int i=0;i<gridGA09N607.size();i++) {
					GA09N607VO = gridGA09N607.get(i);
					
					aprvWrrptMtNo = GA09N607VO.getAprvWrrptMtNo();
					aprvRnk = GA09N607VO.getAprvRnk();
					aprvDlRnk = GA09N607VO.getAprvDlRnk();

					// 결재상신관리번호 필수 체크
					if(aprvWrrptMtNo == null || "".equals(aprvWrrptMtNo) ) {
				        throw new CustomBadRequestException("필수입력항목 결재정보상세[결재상신관리번호] 오류. 입력값을 확인하세요["+aprvWrrptMtNo+"]", ErrorCode.BAD_REQUEST);		
					}
					// 결재순위 필수 체크
					if(aprvRnk == null || "".equals(aprvRnk) ) {
				        throw new CustomBadRequestException("필수입력항목 결재정보상세[결재순위] 오류. 입력값을 확인하세요["+aprvRnk+"]", ErrorCode.BAD_REQUEST);		
					}
					// 결재상세순위 필수 체크
					if(aprvDlRnk == null || "".equals(aprvDlRnk) ) {
				        throw new CustomBadRequestException("필수입력항목 결재정보상세[결재상세순위] 오류. 입력값을 확인하세요["+aprvDlRnk+"]", ErrorCode.BAD_REQUEST);		
					}
				}
			}else {
		        throw new CustomBadRequestException("확인처리 대상이 존재하지않습니다. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);		
			
			}
		}

		// 사전참조 확인처리 
		{
			if(gridGA09N607 != null && gridGA09N607.size() > 0) {
				cnt = 1;
				for(int i=0;i<gridGA09N607.size();i++) {
					GA09N607VO = gridGA09N607.get(i);
					aprvWrrptMtNo = GA09N607VO.getAprvWrrptMtNo();
					aprvRnk = GA09N607VO.getAprvRnk();
					aprvDlRnk = GA09N607VO.getAprvDlRnk();

					/* [20240125] 대결여부 추가 */
					List<GA09N607VO> aprvList = rqamDao.selectAprvDtlPk(GA09N607VO);
					if(aprvList.size() <= 0) {
						throw new CustomBadRequestException("사전참조 확인처리 대상이 존재하지않습니다. 대상건을 확인하세요["+aprvWrrptMtNo+"]["+aprvRnk+"]["+aprvDlRnk+"]", ErrorCode.BAD_REQUEST);
					}
					GA09N607VO = aprvList.get(0);
					List<GA09N607VO> sbapList = rqamDao.selectSbapCfmtYn(GA09N607VO);
					if(sbapList.size() > 0) {
						GA09N607VO sbapVo = sbapList.get(0);
						if(!!!sbapVo.getAprvEpno().equals(epNo)) {
							GA09N607VO.setAprvEpno(sbapVo.getAprvEpno());	// 원결재자사원번호
							GA09N607VO.setSbapYn("1");						// 대결여부
							GA09N607VO.setSbapEpno(epNo);					// 대결사원번호
						} else {
							GA09N607VO.setAprvEpno(epNo);					// 원결재자사원번호
							GA09N607VO.setSbapYn("0");						// 대결여부
							GA09N607VO.setSbapEpno(null);					// 대결사원번호
						}
					} else {
						/* 2023.11.06 추가 */
						GA09N607VO.setAprvEpno(epNo);						// 원결재자사원번호
						GA09N607VO.setSbapYn("0");							// 대결여부
						GA09N607VO.setSbapEpno(null);						// 대결사원번호
					}

					System.out.println(GA09N607VO.toString());



					
					mCnt = RQSR1000U0Dao.updateGA09N607ForCfmt(GA09N607VO);
					if(mCnt <= 0 ){
				        throw new CustomBadRequestException("사전참조 확인처리 대상이 존재하지않습니다. 대상건을 확인하세요["+aprvWrrptMtNo+"]["+aprvRnk+"]["+aprvDlRnk+"]", ErrorCode.BAD_REQUEST);		
					}
					cnt++;
				}
			}
		}

		return cnt;
	}	   
	
	/* 인감날인증명서 승인완료 목록조회 */	
	@Override
	public List<RQSR1000U0Out20VO> selectListApvCmpn(RQSR1000U0In20VO vo) {
		
    	if (!StringUtils.isBlank(vo.getRqsScd())) {
    		vo.setArrRqsScd(Arrays.asList(vo.getRqsScd().split(",")));
    	}
    	
    	RQSR1000U0In20VO cntVo = new RQSR1000U0In20VO();
    	ObjectCopyUtil.copyFields(vo, cntVo);
    	
		int totCnt = RQSR1000U0Dao.selectListApvCmpnTotCnt(cntVo); 
		vo.setTotCnt(totCnt);

		/* 사전참조 대상이 없으면 "대상아님" */
		List<RQSR1000U0Out20VO> resultList = RQSR1000U0Dao.selectListApvCmpn(vo);

		for(RQSR1000U0Out20VO result : resultList) {
			String aprvWrrptMtNo = result.getAprvWrrptMtNo();

			RQAM2000V0In01VO rqam2000V0In01VO = new RQAM2000V0In01VO();
			List<RQAM2000V0Out01VO> rqam2000V0Out01VOList;
			rqam2000V0In01VO.setAprvWrrptMtNo(aprvWrrptMtNo);
			rqam2000V0In01VO.setSelTyp("rqsr");
			rqam2000V0Out01VOList = rqam2000V0Service.selectAprvPstt(rqam2000V0In01VO);

			if(rqam2000V0Out01VOList.size() > 0) continue;
			result.setRefDt("대상아님");
		}

		return resultList;
	}
	
    /* 인감날인증명서 승인완료 신청상태 정보조회 */	
    @Override
	public RQSR1000U0Out11VO selectListApvCmpnBySeal(RQSR1000U0In20VO vo){
    	if (!StringUtils.isBlank(vo.getRqsScd())) {
    		vo.setArrRqsScd(Arrays.asList(vo.getRqsScd().split(",")));
    	}
		
		return RQSR1000U0Dao.selectListApvCmpnBySeal(vo);
	}
	
	/* 완료 당일잔여수량 조회 */
	@Override
	public List<RQSR1000U0Out17VO> selectInfoGA01N510BalPstt() {
		
		 List<RQSR1000U0Out17VO> list = RQSR1000U0Dao.selectInfoGA01N510BalPstt();
		 return list;
	}
	
	/* 인감날인증명서신청 사용처제출, 원본폐기 처리 */
	@Override
	public int rqspBzPrc(RQSR1000U0In01VO vo, LoginOutVO loginVo) {
		
		int cnt = 0;
		int mCnt = 0;

		GA01N101VO GA01N101VO = null; // 통합신청
		
		String rctNo    = vo.getRctNo();          //접수번호(접수번호)
		String rqsEpno  = loginVo.getEpno();      // 신청사원번호
		String rqsOrzCd = loginVo.getBlngOrzCd(); // 신청조직코드		
		String rqsScd   = vo.getRqsScd();         // 신청상태
		log.info("입력접수번호 rctNo ============["+rctNo+"]");	
		
		String dlScd = ""; // 인감증명서상세상태코드 
		
		// 전처리 : 입력값 체크
		{
		
			if(rctNo == null || rctNo.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[접수번호] 오류. 입력값을 확인하세요["+rctNo+"]", ErrorCode.BAD_REQUEST);		
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
				GA01N101VO.setRctNo(rctNo);

				GA01N101VO = RQSR1000U0Dao.selectGA01N101(GA01N101VO);
				
				if(GA01N101VO == null) {
			        throw new CustomBadRequestException("통합신청 대상건이 존재하지않습니다. 접수번호를 확인하세요["+rctNo+"]", ErrorCode.BAD_REQUEST);						
				}
				
				if(!GA01N101VO.getRqsEpno().equals(rqsEpno)) {
					throw new CustomBadRequestException("통합신청 신청사원번호를 확인하세요. 신청자인경우만 처리 가능합니다. ["+GA01N101VO.getRqsEpno()+"]["+rqsEpno+"]", ErrorCode.BAD_REQUEST);
				}
				
				if(GA01N101VO.getRqsScd() == null ) {
			        throw new CustomBadRequestException("통합신청 신청상태코드를 확인하세요. ["+GA01N101VO.getRqsScd()+"]", ErrorCode.BAD_REQUEST);						
				}else {
					if(!CD_RQS_SCD_PRC_CMPN.equals(GA01N101VO.getRqsScd())){
				        throw new CustomBadRequestException("신청상태를 확인하세요 [처리완료]일 경우만 처리가능합니다. ["+GA01N101VO.getRqsScd()+"]["+GA01N101VO.getRqsScdNm()+"]", ErrorCode.BAD_REQUEST);						
					}
				}
				
				if (rqsScd.equals(CD_RQS_SCD_USP_SMIT)) {
					dlScd = SEAL_CTFW_DL_SCD_USE_CMPN; // 사용완료    
		 		} else if (rqsScd.equals(CD_RQS_SCD_ORG_DSUS)){
		 			dlScd = SEAL_CTFW_DL_SCD_DSUS_CMPN; // 원본폐기완료    
		 		} else {
		 			throw new CustomBadRequestException("접수내역의 신청구분값 오류. IT운영담당자에게 문의바랍니다.", ErrorCode.BAD_REQUEST);
		 		}
			}
		}

		// 1.신청상태 변경 
		{
			// 통합신청 데이터 세팅 (GA01N101)
			{
				RQRR1000U0VO RQRR1000U0VO = new RQRR1000U0VO();
				RQRR1000U0VO.setRctNo(rctNo);
				RQRR1000U0VO.setRqsScd(rqsScd);
				
				cnt = RQRR1000U0Dao.updateRqsScd(RQRR1000U0VO);
				if(cnt == 0) {
		            throw new CustomBadRequestException("신청상태 변경시 오류입니다. ["+rctNo+"]", ErrorCode.BAD_REQUEST);		
				}
			}
		}
		
		// 2.인감신청_인감증명서관리 인감증명서상세상태코드 수정
		if(selectGA01N505ExistYn(vo.getRctNo())) {
			vo.setSealCtfwDlScd(dlScd); 
			int dlCnt = RQSR1000U0Dao.updateGA01N510DlScd(vo);
			if(dlCnt == 0) {
	            throw new CustomBadRequestException("인감증명서상세상태 변경시 오류입니다. ["+rctNo+"]", ErrorCode.BAD_REQUEST);		
			}
		}

		return mCnt;
	}
	
	/* 출고 - 조회 */	
	@Override
	public RQSR1000U0Out02VO selectUnifRqsBySealForCmpn(RQSR1000U0In01VO vo) {
		// 변수 초기화
		GA01N101VO GA01N101VO = null; /* 통합신청 */

		List<GA01N504VO> gridGA01N504 = null;    /* 인감신청_인감날인신청 다건내역 */		
		GA01N504VO GA01N504VO = null; /* 인감신청_인감날인신청 */

		List<GA01N505OutQ1VO> gridGA01N505WithQ1 = null;    /* 인감신청_인감증명서_인감기준 다건내역 */		
		List<GA01N505OutQ2VO> gridGA01N505WithQ2 = null;    /* 인감신청_등기부등본 다건내역 */		
		GA01N505VO GA01N505VO = null; /* 인감신청_인감증명서신청*/
		
		RQSR1000U0Out02VO outVo = new RQSR1000U0Out02VO();
		
		String rctNo = null; //접수번호
		
		// 전처리 : 입력값 체크
		{
			rctNo = vo.getRctNo();
			if(rctNo == null || rctNo.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[접수번호] 오류. 입력값을 확인하세요["+rctNo+"]", ErrorCode.BAD_REQUEST);		
			}
			
			// 데이터 카피
			GA01N101VO = new GA01N101VO();
			GA01N101VO.setRctNo(rctNo);
			// 기등록 데이터 체크
			{
				GA01N101VO = RQSR1000U0Dao.selectGA01N101(GA01N101VO);
				
				if(GA01N101VO == null) {
			        throw new CustomBadRequestException("통합신청 대상건이 존재하지않습니다. 접수번호를 확인하세요["+rctNo+"]", ErrorCode.BAD_REQUEST);						
				}
				
				if (!Arrays.asList(CD_RQS_SCD_APV_CMPN,CD_RQS_SCD_PRC_CMPN,CD_RQS_SCD_USP_SMIT,CD_RQS_SCD_ORG_DSUS).contains(GA01N101VO.getRqsScd())) {
			        throw new CustomBadRequestException("통합신청 승인완료/처리완료/사용처제출/원본폐기 대상건만 조회 가능합니다. 신청상태를 확인하세요["
			        		+ ""+rctNo+"]["+GA01N101VO.getRqsScd()+"]", ErrorCode.BAD_REQUEST);						
				}
				// 2024.03.13 삭제
				//if (!Arrays.asList(CD_RQS_SCD_APV_CMPN,CD_RQS_SCD_PRC_CMPN).contains(GA01N101VO.getRqsScd())) {
			    //    throw new CustomBadRequestException("통합신청 승인완료/처리완료 대상건만 조회 가능합니다. 신청상태를 확인하세요["
			    //    		+ ""+rctNo+"]["+GA01N101VO.getRqsScd()+"]", ErrorCode.BAD_REQUEST);						
				//}	
				// 통합신청내역 데이터 카피
				ObjectCopyUtil.copyFields(GA01N101VO, outVo);					
			}
		}

		// 조회
		{

			GA01N504VO = new GA01N504VO();
			GA01N504VO.setRctNo(rctNo);

			// 인감날인 목록 세팅 
			gridGA01N504 = RQSR1000U0Dao.selectListGA01N504(GA01N504VO);
			outVo.setGridGA01N504(gridGA01N504);
			
			GA01N505VO = new GA01N505VO();
			GA01N505VO.setRctNo(rctNo);
			
			// 인감증명서 인감기준 세팅
			gridGA01N505WithQ1 = RQSR1000U0Dao.selectListGA01N505BySalMtNoWithQ1(GA01N505VO);
			outVo.setGridGA01N505WithQ1(gridGA01N505WithQ1);

			// 등기부등본 세팅
			gridGA01N505WithQ2 = RQSR1000U0Dao.selectListGA01N505BySmtpCnWithQ2(GA01N505VO);
			outVo.setGridGA01N505WithQ2(gridGA01N505WithQ2);
		
		}
		
		return outVo;
	}	    

	/* 출고 - 인감증명서 출력 */
	@Override
	public int updateGA01N510Oput(RQSR1000U0In24VO vo, HttpServletRequest request) {
		
		// 승인일 기준 당일만 출력/재출력 
		boolean sameDayYn = RQSR1000U0Dao.selectGA01N101SameDayYn(vo.getRctNo());
		if(!sameDayYn) {
			throw new CustomBadRequestException("출력/재출력은 총무담당자 승인 당일만 가능해요", ErrorCode.BAD_REQUEST);
		}
		
		HttpSession session = request.getSession();
		LoginOutVO loginVO= (LoginOutVO)session.getAttribute("loginOutVO");
		String epNo = loginVO.getEpno();
		
		// 처리자 설정
		vo.setEpno(epNo);
		
		// 전처리 : 입력값 체크
		{
			if (vo.getSealCtfwRqsSqncNo() == null || vo.getSealCtfwRqsSqncNo().equals("")) {
				throw new CustomBadRequestException("인감증명서신청시퀀스번호 확인하세요. ["+vo.getSealCtfwRqsSqncNo()+"]", ErrorCode.BAD_REQUEST);
			}
			
			if (vo.getRqsQ() == null) {
				throw new CustomBadRequestException("신청수량을 확인하세요. ["+vo.getRqsQ()+"]", ErrorCode.BAD_REQUEST);
			}
			
			if (vo.getSalMtNo() == null || vo.getSalMtNo().equals("")) {
				throw new CustomBadRequestException("인장관리번호 확인하세요. ["+vo.getSalMtNo()+"]", ErrorCode.BAD_REQUEST);
			}
		}
		
		// 출력할수있는 인감증명서 수량 체크 
		int rqsQ = vo.getRqsQ();
		if(rqsQ<=0) {
			throw new CustomBadRequestException("인감증명서 신청수량 오류.["+rqsQ+"]", ErrorCode.BAD_REQUEST);
		}
		int vCnt =  RQSR1000U0Dao.selectGA01N510AblCnt(vo);
		if(rqsQ>vCnt) {
			throw new CustomBadRequestException("출력할수있는 인감증명서 수량 부족합니다. 신청수량:["+rqsQ+"], 인감증명서 수량:["+vCnt+"]", ErrorCode.BAD_REQUEST);
		}
		
		// 출고 처리
		vo.setSealCtfwScd(SEAL_CTFW_SCD_OUTQ);
		vo.setSealCtfwDlScd(SEAL_CTFW_DL_SCD_USE_ING);
		int cnt = RQSR1000U0Dao.updateGA01N510Oput(vo);
		return cnt;
	}
	
	/* 출고 - 출력후 미리보기 */
    public List<RQSR1000U0Out24VO> selectGA01N510Oput(RQSR1000U0In24VO vo){

    	 List<RQSR1000U0Out24VO> rtnList = RQSR1000U0Dao.selectGA01N510Oput(vo);
    	 
    	 // O:출력, R:재출력
    	 if("O".equals(vo.getSelTyp())) {
    		 return rtnList;
    	 } else if("R".equals(vo.getSelTyp())) {
    		 int cnt = vo.getReOputCnt();
    		 if(cnt<1 && cnt>rtnList.size()){
    			 throw new CustomBadRequestException("재출력 수량 오류. ["+cnt+"] ", ErrorCode.BAD_REQUEST);
    		 }
    		 return rtnList.subList(rtnList.size() - cnt, rtnList.size());
    	 } else {
    		 throw new CustomBadRequestException("출력/재출력 구분코드 확인하세요. ["+vo.getSelTyp()+"] - (O:출력, R:재출력)", ErrorCode.BAD_REQUEST);
    	 }
    	
    }
	
	
	/* 출고상세 재출력/폐기 조회 */
	@Override
	public RQSR1000U0Out25VO selectListGA01N510Oput(RQSR1000U0In24VO vo) {
		
		// 전처리 : 입력값 체크
		{
			if (vo.getSealCtfwRqsSqncNo() == null || vo.getSealCtfwRqsSqncNo().equals("")) {
				throw new CustomBadRequestException("인감증명서신청시퀀스번호 확인하세요. ["+vo.getSealCtfwRqsSqncNo()+"]", ErrorCode.BAD_REQUEST);
			}
		}
		
		// 재출력/폐기 리스트 조회
		List<RQSR1000U0Out23VO> list = RQSR1000U0Dao.selectListGA01N510Oput(vo);
		
		RQSR1000U0Out25VO rtnVo = new RQSR1000U0Out25VO();
		
		if(list != null && list.size()>0) {
			rtnVo.setSealCtfwTcd(list.get(0).getSealCtfwTcd()); 
			rtnVo.setSalMtNo(list.get(0).getSalMtNo());                     // 인장관리번호
			rtnVo.setSalMtNm(list.get(0).getSalMtNm());                     // 발급증명서
			rtnVo.setSealCtfwRqsSqncNo(list.get(0).getSealCtfwRqsSqncNo()); // 신청번호
			rtnVo.setRctNo(list.get(0).getRctNo()); 
			
			rtnVo.setGridGA01N510ReOput(list);
		}
		
		return rtnVo; 
	}
		
	/* 출고 - 재출력/폐기 재출력 */
	@Override
	public int updateGA01N510ReOput(RQSR1000U0In26VO vo, HttpServletRequest request) {
		
		// 승인일 기준 당일만 출력/재출력 
		boolean sameDayYn = RQSR1000U0Dao.selectGA01N101SameDayYn(vo.getRctNo());
		if(!sameDayYn) {
			throw new CustomBadRequestException("출력/재출력은 총무담당자 승인 당일만 가능해요", ErrorCode.BAD_REQUEST);
		}
		
		String[] noList = null;
		if (!StringUtils.isBlank(vo.getSealCtfwSqncNoDsus())) {
			noList = vo.getSealCtfwSqncNoDsus().split(",");
		}
		
		//List<RQSR1000U0Out23VO> inList = vo.getGridGA01N510ReOput();
		
		if(noList == null || noList.length== 0) {
			throw new CustomBadRequestException("선택한 증명서번호 없습니다.", ErrorCode.BAD_REQUEST);
		}
		
		HttpSession session = request.getSession();
		LoginOutVO loginVO= (LoginOutVO)session.getAttribute("loginOutVO");
		String epNo = loginVO.getEpno();
		
		// 폐기
		RQSR1000U0In26VO dsusVo = new RQSR1000U0In26VO();
		dsusVo.setEpno(epNo);
		dsusVo.setSalMtNo(vo.getSalMtNo());
		dsusVo.setSealCtfwRqsSqncNo(vo.getSealCtfwRqsSqncNo());
		dsusVo.setSealCtfwScd(SEAL_CTFW_SCD_DSUS); // 폐기
		dsusVo.setSealCtfwDlScd(SEAL_CTFW_DL_SCD_ERR_DSUS); // 재출력시 오류폐기
		dsusVo.setSealCtfwDsusRsnCn("["+vo.getRctNo()+"] 발급 오류 폐기"); // 폐기사유
		dsusVo.setSealCtfwSqncNoArr(Arrays.asList(noList));
		
		int dsusCnt = RQSR1000U0Dao.updateGA01N510ReOputDsus(dsusVo);
		log.info("dsusCnt  ============"+dsusCnt);
		
		// 재출력
		RQSR1000U0In24VO iputVo = new RQSR1000U0In24VO();
		iputVo.setRctNo(vo.getRctNo());
		iputVo.setSalMtNo(vo.getSalMtNo());
		iputVo.setSealCtfwRqsSqncNo(vo.getSealCtfwRqsSqncNo());
		iputVo.setRqsQ(noList.length);
		int iputCnt = updateGA01N510Oput(iputVo, request);
		
		log.info("iputCnt  ============"+iputCnt);
		
		return 0;
	}
	
	/* 입고폐기관리 증명서유형 조회 */
	@Override
	public List<RQSR1000U0Out15VO> selectListSealDocPcd(){
		return RQSR1000U0Dao.selectListSealDocPcd();
	}

	/* 입고/폐기관리 조회 */
	@Override
	public List<RQSR1000U0Out19VO> selectListGA01N510(RQSR1000U0In19VO vo){
		
		if (vo.getIssDtFrom() == null || vo.getIssDtFrom().equals("")) {
			throw new CustomBadRequestException("발급일자 조회시작일을 확인하세요. ["+vo.getIssDtFrom()+"]", ErrorCode.BAD_REQUEST);
		}
		
		if (vo.getIssDtTo() == null || vo.getIssDtTo().equals("")) {
			throw new CustomBadRequestException("발급일자 조회종료일을 확인하세요. ["+vo.getIssDtTo()+"]", ErrorCode.BAD_REQUEST);
		}
		if (!Arrays.asList(SEAL_CTFW_TCD_SEAL,SEAL_CTFW_TCD_CERT).contains(vo.getSealCtfwTcd())) {
			 throw new CustomBadRequestException("증명서유형 입력오류 ["+vo.getSealCtfwTcd()+"] - (10 : 인감증명서, 20 : 등기부등본)", ErrorCode.BAD_REQUEST);
		}
		
		if(SEAL_CTFW_TCD_SEAL.equals(vo.getSealCtfwTcd())) {  // 인감증명서 
			if (vo.getSalMtNo() == null || "".equals(vo.getSalMtNo())) {
		        throw new CustomBadRequestException("증명서유형코드 오류 ["+vo.getSalMtNo()+"]", ErrorCode.BAD_REQUEST);
			}
		}
		if(SEAL_CTFW_TCD_CERT.equals(vo.getSealCtfwTcd())) {  // 등기부등본 
			if (!"".equals(vo.getSalMtNo())) {
		        throw new CustomBadRequestException("등기부등본 유형코드 오류 ["+vo.getSalMtNo()+"]", ErrorCode.BAD_REQUEST);
			}
		}
		
		return RQSR1000U0Dao.selectListGA01N510(vo);
	}
	
	/* 입고/폐기관리 등록 */
	@Override
	public int updateGA01N510(RQSR1000U0In17VO vo) {
		
		String salMtNo = vo.getSalMtNo(); // 증명서유형
		
		String epno = vo.getEpno(); // 로그인사번
		
		String sealCtfwTcd = vo.getSealCtfwTcd(); // 인감증명서구분코드
		
		String sealCtfwScd = vo.getSealCtfwScd(); // 구분
		String sealCtfwDlScd = vo.getSealCtfwDlScd(); // 유형
		
		String issDt = vo.getIssDt(); // 발급일자
		String sealCtfwDsusRsnCn = vo.getSealCtfwDsusRsnCn(); // 폐기사유
		Integer rqsQty = vo.getRqsQty(); // 수량
		
		String currPrcDt = DateUtil.getTodayString("yyyyMMdd");
		
		// 전처리 : 입력값 체크
		{
			if (epno == null || epno.equals("")) {
				throw new CustomBadRequestException("필수입력항목[로그인사번] 오류. 입력값을 확인하세요[" + epno + "]",ErrorCode.BAD_REQUEST);
			}
			if (sealCtfwTcd == null || sealCtfwTcd.equals("")) {
				throw new CustomBadRequestException("필수입력항목[인감증명서구분코드] 오류. 입력값을 확인하세요[" + sealCtfwTcd + "]",ErrorCode.BAD_REQUEST);
			}
			if (sealCtfwScd == null || sealCtfwScd.equals("")) {
				throw new CustomBadRequestException("필수입력항목[구분] 오류. 입력값을 확인하세요[" + sealCtfwScd + "]",ErrorCode.BAD_REQUEST);
			}
			if (sealCtfwDlScd == null || sealCtfwDlScd.equals("")) {
				throw new CustomBadRequestException("필수입력항목[유형] 오류. 입력값을 확인하세요[" + sealCtfwDlScd + "]",ErrorCode.BAD_REQUEST);
			}
			if (rqsQty == null) {
				throw new CustomBadRequestException("필수입력항목[수량] 오류. 입력값을 확인하세요[" + rqsQty + "]",ErrorCode.BAD_REQUEST);
			}
			if (issDt == null || issDt.equals("")) {
				throw new CustomBadRequestException("필수입력항목[발급일자] 오류. 입력값을 확인하세요[" + issDt + "]",ErrorCode.BAD_REQUEST);
			}
			
			if("30".equals(sealCtfwScd)) { // 페기
				if (sealCtfwDsusRsnCn == null || sealCtfwDsusRsnCn.equals("")) {
					throw new CustomBadRequestException("필수입력항목[폐기사유] 오류. 입력값을 확인하세요[" + sealCtfwDsusRsnCn + "]",ErrorCode.BAD_REQUEST);
				}
			}
		}
		
		// 구분/유형 정합성체크
		{
			if (!Arrays.asList(SEAL_CTFW_TCD_SEAL,SEAL_CTFW_TCD_CERT).contains(sealCtfwTcd)) {
				 throw new CustomBadRequestException("증명서유형 입력오류 ["+sealCtfwTcd+"] - (10 : 인감증명서, 20 : 등기부등본)", ErrorCode.BAD_REQUEST);
			}
			
			if(SEAL_CTFW_TCD_SEAL.equals(sealCtfwTcd)) {  // 인감증명서 
				if (salMtNo == null || salMtNo == "") {
			        throw new CustomBadRequestException("증명서유형코드 입력오류 ["+salMtNo+"]", ErrorCode.BAD_REQUEST);
				}
			}
			
			if(SEAL_CTFW_TCD_CERT.equals(sealCtfwTcd)) {  // 등기부등본 
				if (!StringUtils.isBlank(salMtNo)) {
			        throw new CustomBadRequestException("증명서유형코드 입력오류 ["+salMtNo+"]", ErrorCode.BAD_REQUEST);
				}
			}
			
			// 인감증명서상태코드
			if (!Arrays.asList(SEAL_CTFW_SCD_INQ,SEAL_CTFW_SCD_DSUS).contains(sealCtfwScd)) {
				 throw new CustomBadRequestException("구분 입력오류 ["+sealCtfwScd+"] - (10 : 입고, 30 : 폐기)", ErrorCode.BAD_REQUEST);
			}
			if(SEAL_CTFW_SCD_INQ.equals(sealCtfwScd)) {
				if (!SEAL_CTFW_DL_SCD_INQ.equals(sealCtfwDlScd)) {
			        throw new CustomBadRequestException("유형 입력오류 ["+sealCtfwDlScd+"] - (10:입고 - 1010) ", ErrorCode.BAD_REQUEST);
				}
			}
			if(SEAL_CTFW_SCD_DSUS.equals(sealCtfwScd)) {
				if (!Arrays.asList(SEAL_CTFW_DL_SCD_INQ_DSUS,SEAL_CTFW_DL_SCD_XPIR_DSUS,SEAL_CTFW_DL_SCD_DRCT_DSUS).contains(sealCtfwDlScd)) {
			        throw new CustomBadRequestException("유형 입력오류. 오류폐기는 재출력시 사용 ["+sealCtfwDlScd+"] - (30 : 폐기 - 3010,3020,3040) ", ErrorCode.BAD_REQUEST);
				}
			}
			if(rqsQty <= 0) {
				 throw new CustomBadRequestException("수량 입력오류 ["+rqsQty+"]", ErrorCode.BAD_REQUEST);
			}
			
			// 폐기 - 입고폐기 
			if(SEAL_CTFW_SCD_DSUS.equals(sealCtfwScd) && SEAL_CTFW_DL_SCD_INQ_DSUS.equals(sealCtfwDlScd)) {
				if(!currPrcDt.equals(issDt)) {
					throw new CustomBadRequestException("입고폐기는 당일 입고처리분에 한해서 사용 가능 ["+issDt+"] ", ErrorCode.BAD_REQUEST);
				}
			}
			
			// 폐기 - 오류폐기
			if(SEAL_CTFW_SCD_DSUS.equals(sealCtfwScd) && SEAL_CTFW_DL_SCD_ERR_DSUS.equals(sealCtfwDlScd)) {
				throw new CustomBadRequestException("유형 입력오류. 오류폐기는 재출력시 사용 ["+sealCtfwDlScd+"] - (30 : 폐기 - 3010,3020,3040) ", ErrorCode.BAD_REQUEST);
			}
		}
		
		int updCnt = 0; // 업데이트 카운트
		
		if(SEAL_CTFW_SCD_INQ.equals(sealCtfwScd)) { // 입고 
			
			GA01N510VO maxSeqVo = new GA01N510VO();
			maxSeqVo.setIssDt(issDt);
			maxSeqVo.setSealCtfwTcd(sealCtfwTcd);
			
			String maxSeq = RQSR1000U0Dao.selectGA01N510MaxNo(maxSeqVo);
			
			Long nextSeq = null;
			if(StringUtils.isBlank(maxSeq)) {
				nextSeq = (long) 1;
			} else {
				nextSeq = Long.valueOf(maxSeq.substring(11).replace("^0*", "")) + 1;
			}
			
			List<GA01N510VO> list = new ArrayList<GA01N510VO>();
			GA01N510VO subVo = new GA01N510VO();
			for(int c=0;c<rqsQty;c++) {
				subVo = new GA01N510VO();
				subVo.setSealCtfwSqncNo(issDt+sealCtfwTcd+String.format("%08d", nextSeq++));
				subVo.setIssDt(issDt);
				subVo.setSealCtfwTcd(sealCtfwTcd);
				subVo.setSalMtNo(salMtNo);
				subVo.setSealCtfwScd(sealCtfwScd);
				subVo.setSealCtfwDlScd(sealCtfwDlScd);
				subVo.setPrcrEpno(epno);
				
				list.add(subVo);
			}
			
			updCnt = RQSR1000U0Dao.insertGA01N510(list);
		} else { // 폐기
			
			GA01N510VO dsusVo = new GA01N510VO();
			dsusVo.setSealCtfwScd(sealCtfwScd);
			dsusVo.setSealCtfwDlScd(sealCtfwDlScd);
			dsusVo.setSealCtfwDsusRsnCn(sealCtfwDsusRsnCn);
			dsusVo.setPrcrEpno(epno);
			dsusVo.setIssDt(issDt);
			dsusVo.setSalMtNo(salMtNo);
			dsusVo.setRqsQ(rqsQty);
			
			// 폐기할수 있는 인감증명서 수량 체크(MAX,MIN 사용안함)
			GA01N510VO inVo = new GA01N510VO();
			inVo.setIssDt(issDt); 
			inVo.setSealCtfwTcd(sealCtfwTcd); 
			inVo.setSalMtNo(salMtNo); 
			GA01N510VO maxMinNoVo = RQSR1000U0Dao.selectGA01N510MNo(inVo);
			if(maxMinNoVo.getSealCtfwSqncNoMin() == null  || maxMinNoVo.getSealCtfwSqncNoMax() == null) {
				throw new CustomBadRequestException("폐기 신청 오류. 인감증명서 존재하지 않습니다.", ErrorCode.BAD_REQUEST);
			}	
			
			// 폐기처리
			int dustCnt = RQSR1000U0Dao.updateGA01N510Dsus(dsusVo);
			log.info("dustCnt  ============"+dustCnt);
			
		}
		
		return updCnt;
	}
	
	/* 입고/폐기관리 증명서잔고현황 조회 */
	@Override
	public List<RQSR1000U0Out18VO> selectListGA01N510BalPstt(RQSR1000U0In19VO vo){
		
		String selTyp = vo.getSelTyp(); // 구분
		
		if (StringUtils.isBlank(selTyp)) {
			throw new CustomBadRequestException("필수입력항목[구분] 오류. 입력값을 확인하세요["+vo.getSelTyp()+"] - (I:발급일자, R:실시간)", ErrorCode.BAD_REQUEST);
		}
		
		if("I".equals(selTyp)) {
			if (StringUtils.isBlank(vo.getIssDtFrom())) {
				throw new CustomBadRequestException("필수입력항목[발급일자 - 시작일] 오류. 입력값을 확인하세요["+vo.getIssDtFrom()+"]", ErrorCode.BAD_REQUEST);
			}
			if (StringUtils.isBlank(vo.getIssDtTo())) {
				throw new CustomBadRequestException("필수입력항목[발급일자 - 종료일] 오류. 입력값을 확인하세요["+vo.getIssDtTo()+"]", ErrorCode.BAD_REQUEST);
			}
		}
		
		if (!Arrays.asList(SEAL_CTFW_TCD_SEAL,SEAL_CTFW_TCD_CERT).contains(vo.getSealCtfwTcd())) {
			 throw new CustomBadRequestException("증명서유형 입력오류 ["+vo.getSealCtfwTcd()+"] - (10 : 인감증명서, 20 : 등기부등본)", ErrorCode.BAD_REQUEST);
		}
		
		if(SEAL_CTFW_TCD_SEAL.equals(vo.getSealCtfwTcd())) {  // 인감증명서 
			if (vo.getSalMtNo() == null || "".equals(vo.getSalMtNo())) {
		        throw new CustomBadRequestException("발급증명서 입력오류 ["+vo.getSalMtNo()+"]", ErrorCode.BAD_REQUEST);
			}
		}
		
		if(SEAL_CTFW_TCD_CERT.equals(vo.getSealCtfwTcd())) {  // 등기부등본 
			if (!StringUtils.isBlank(vo.getSalMtNo())) {
		        throw new CustomBadRequestException("등기부등본 입력오류 ["+vo.getSalMtNo()+"]", ErrorCode.BAD_REQUEST);
			}
		}
		
		return RQSR1000U0Dao.selectListGA01N510BalPstt(vo);
	}
	
	/* 인감증명서 신청여부 - 승인완료 처리시 사용*/
	@Override
	public boolean selectGA01N505ExistYn(String rctNo) {
		int cnt = RQSR1000U0Dao.selectGA01N505ExistYn(rctNo);
		if(cnt>0) {
			return true;
		} else {
			return false;
		}
	}

	/* 출고 - 완료 */
	public int updateGA01N510Cmpn(RQSR1000U0In25VO vo, LoginOutVO loginVo) {
		
		// 2023.12.08 작성
		String sReceiveUserId = "";
		String sRctNo         = "";
		int cnt = 0;
		
		if( vo == null) {
	      throw new CustomBadRequestException("완료처리할 신청대상건이 없습니다. 입력값을 확인하세요.", ErrorCode.BAD_REQUEST);					
		}	
		
		// 1.등기부등본 출력처리
		{
			List<GA01N505OutQ2VO> certDocList = vo.getCertDocGrid();
			
			for (int c = 0; c < certDocList.size(); c++) {
				
				GA01N505OutQ2VO certDocVo = certDocList.get(c);
				
				// 1.1 필수값체크 
				{
					if (certDocVo.getRqsQ() == null) {
						throw new CustomBadRequestException("필수입력항목[출고수] 오류. 입력값을 확인하세요["+certDocVo.getRqsQ()+"]", ErrorCode.BAD_REQUEST);
					}
					if (StringUtils.isBlank(certDocVo.getSealCtfwRqsSqncNo())) {
						throw new CustomBadRequestException("필수입력항목[인감증명서신청번호] 오류. 입력값을 확인하세요["+certDocVo.getSealCtfwRqsSqncNo()+"]", ErrorCode.BAD_REQUEST);
					}
					if (StringUtils.isBlank(certDocVo.getSealCtfwIdCn())) {
						throw new CustomBadRequestException("필수입력항목[증명서번호] 오류. 입력값을 확인하세요["+certDocVo.getSealCtfwIdCn()+"]", ErrorCode.BAD_REQUEST);
					}
				}
				
				int certDocQty = certDocVo.getRqsQ().intValue();
				String idCn = certDocVo.getSealCtfwIdCn();
				
				// 1.2 수기 입력한 증명서번호 리스트화
				List<String> arrId = Arrays.asList(idCn.split(","));
				if(arrId.size() != certDocQty) {
					throw new CustomBadRequestException("입력항목 [증명서번호]와 출고수가 일치하지 않습니다. 입력값을 확인하세요["+idCn+"]", ErrorCode.BAD_REQUEST);
				}
				
				// 1.3 출력할수있는 수량 체크 
				{
					if(certDocQty<=0) {
						throw new CustomBadRequestException("등기부등본 신청수량 오류.["+certDocQty+"]", ErrorCode.BAD_REQUEST);
					}
					RQSR1000U0In24VO cntVo = new RQSR1000U0In24VO();
					int vCnt =  RQSR1000U0Dao.selectGA01N510AblCnt(cntVo);
					if(certDocQty>vCnt) {
						throw new CustomBadRequestException("출력할수있는 인감증명서 수량 부족합니다. 신청수량:["+certDocQty+"], 인감증명서 수량:["+vCnt+"]", ErrorCode.BAD_REQUEST);
					}
				}
				
				// 1.4 증명서번호 출력
				for(int idCnt = 0; idCnt < arrId.size(); idCnt++) {
					
					RQSR1000U0In24VO oputVo = new RQSR1000U0In24VO();
					
					oputVo.setSealCtfwScd(SEAL_CTFW_SCD_OUTQ);
					oputVo.setSealCtfwDlScd(SEAL_CTFW_DL_SCD_USE_ING);
					oputVo.setSealCtfwRqsSqncNo(certDocVo.getSealCtfwRqsSqncNo());
					oputVo.setEpno(loginVo.getEpno());
					oputVo.setSealCtfwIdCn(arrId.get(idCnt));
					
					RQSR1000U0Dao.updateGA01N510CertDocOput(oputVo);
				}
			}
		}
		
	   // 2.통합신청 완료처리
	   RQRR1000U0VO inVo = new RQRR1000U0VO();
	   inVo.setRctNo(vo.getRctNo());
	   
	   List<RQRR1000U0VO> voList = RQRR1000U0Dao.selectGA01N101(inVo);
	   if(voList == null || voList.size() == 0 ) {
	       throw new CustomBadRequestException("인감신청 완료처리 대상건이 존재하지않습니다. 접수번호를 확인하세요["+vo.getRctNo()+"]", ErrorCode.BAD_REQUEST);					
	   }
		
	   RQRR1000U0VO chkvo = voList.get(0);
	   chkvo.setCmpnDt(DateUtil.getTodayString("yyyyMMdd"));
	   sReceiveUserId = chkvo.getRqsEpno();
	   sRctNo = chkvo.getRctNo();
			
		log.info("chkvo  ============"+chkvo.getRctNo());
		
		if(chkvo.getRqsScd() != null && !chkvo.getRqsScd().equals(CD_RQS_SCD_APV_CMPN) ) {
            throw new CustomBadRequestException("인감신청 완료처리는 승인완료태일경우만 처리가능합니다. 신청상태를 확인하세요["+chkvo.getRqsScd()+"]["+chkvo.getRctNo()+"]", ErrorCode.BAD_REQUEST);					
		} 

		{ /* 인감신청 완료처리 */
			
			// 해당 업무 화면 조회
			GaCode01In00VO rqsPcdVo = new GaCode01In00VO();
			rqsPcdVo.setCdKndNo("PSIT_MENU_ID_TCD");
			rqsPcdVo.setCmnCdVl(chkvo.getUnifRqsPcd());
			List<GaCode01Out00VO> rqsPcdList = CodeDao.selectBzMtCode(rqsPcdVo); 
			String psitMenuId = rqsPcdList.get(0).getCmnCdVlDefCn();
			
			ObjectCopyUtil.copyFields(chkvo, chkvo);
			
			//chkvo.setRqsScd(CD_RQS_SCD_CMPN);
			chkvo.setRqsScd(CD_RQS_SCD_PRC_CMPN);
			cnt = RQRR1000U0Dao.updateRqsScd(chkvo);
			
			if (cnt > 0) {
				// 담당자 완료 처리일경우
				GA09N602Vf02InVO GA09N602Vf02InVO = new GA09N602Vf02InVO();
				GA09N602Vf02OutVO GA09N602Vf02OutVO = null;
				GA09N602Vf02InVO.setEpno(loginVo.getEpno());
				GA09N602Vf02InVO.setScrnNo(psitMenuId);
				
				// 화면 담당자가 없는 화면 체크
				GA09N602Vf02OutVO = rqamDao.selectBzChprYn(GA09N602Vf02InVO);
				if (GA09N602Vf02OutVO.getBzChprYn().equals("Y")) { // 확인 
					// 알림 전송 
					msg.sendMsgEnrollNoti(sReceiveUserId, sRctNo, "PROC_COMP", "", "");
				}
			}
		}
		
		return cnt;
	}

}
