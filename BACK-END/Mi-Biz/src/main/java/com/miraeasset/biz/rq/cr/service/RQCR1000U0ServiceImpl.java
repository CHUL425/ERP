package com.miraeasset.biz.rq.cr.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
import com.miraeasset.biz.common.dao.CommonDao;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.meta.vo.AprvWrrptInVO;
import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA09N411VO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf01InVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf01OutVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02InVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02OutVO;
import com.miraeasset.biz.common.meta.vo.GA09N606VO;
import com.miraeasset.biz.common.meta.vo.GA09N607InVO;
import com.miraeasset.biz.common.meta.vo.GA09N607VO;
import com.miraeasset.biz.common.meta.vo.GA09N607aprvVO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.aprvWrrpt.AprvWrrpt;
import com.miraeasset.biz.common.util.massage.MsgSenService;
import com.miraeasset.biz.rq.am.dao.RQAM1000U0Dao;
import com.miraeasset.biz.rq.cr.dao.RQCR1000U0Dao;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U00VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U01VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U02VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U03VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U04VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U05VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U06VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0In00VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0In01VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0In02VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out00VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out01VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out02VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000UVO;
import com.miraeasset.biz.rq.rr.dao.RQRR1000U0Dao;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In05VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In06VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;

import io.swagger.annotations.ApiModelProperty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@Transactional
public class RQCR1000U0ServiceImpl implements RQCR1000U0Service {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RQCR1000U0Dao dao;
	
	@Autowired
	RQRR1000U0Dao RQRR1000U0Dao;
	
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
	
	private final String UNIF_RQS_DL_PCD_01 = "11"; //인테리어(유지보수)
	private final String UNIF_RQS_DL_PCD_02 = "12"; //조명/전등
	private final String UNIF_RQS_DL_PCD_03 = "13"; //냉난방기구류
	private final String UNIF_RQS_DL_PCD_04 = "14"; //간판류(사인물)
	private final String UNIF_RQS_DL_PCD_05 = "15"; //전자제품류
	private final String UNIF_RQS_DL_PCD_06 = "16"; //가구류
	private final String UNIF_RQS_DL_PCD_07 = "17"; //기타

	private final String PSIT_MENU_ID = "RQCR1000m0";
	
	
	/* 공사신청 목록조회 엑셀다운로드용 */
	@Override
	public List<RQCR1000U0Out00VO> selectList(RQCR1000U0In00VO vo) {
		// TODO Auto-generated method stub
		return dao.selectList(vo);
	}
	
	/* 공사신청 상태요약정보 */
	/* 공사신청목록 및 요약정보 조회 */
	@Override
	public RQCR1000U00VO selectRqsList(RQCR1000U0In00VO vo, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		if (vo.getQryStrtDt() == null || vo.getQryStrtDt().equals("")) {
			throw new CustomBadRequestException("신청일자 조회시작일을 확인하세요. ["+vo.getQryStrtDt()+"]", ErrorCode.BAD_REQUEST);
		}
		
		if (vo.getQryEndDt() == null || vo.getQryEndDt().equals("")) {
			throw new CustomBadRequestException("신청일자 조회종료일을 확인하세요. ["+vo.getQryEndDt()+"]", ErrorCode.BAD_REQUEST);
		}
		RQCR1000U00VO gridList = new RQCR1000U00VO();
		List<RQCR1000U0Out00VO> list = null;
		
		/* 입려값 셋팅시 해당 조직 조회 */
		if (StringUtils.isBlank(vo.getRqsOrzNm())) {
			/* [2023-10-19]: 총무팀 제외하고는 자기팀에서 신청한 내역만 보이게 수정 */
			HttpSession session = request.getSession();
			LoginOutVO loginVO= (LoginOutVO)session.getAttribute("loginOutVO");
			String epOrzCd = loginVO.getBlngOrzCd();
			boolean isManager = loginVO.getUserGrpCdList().contains("001") || loginVO.getUserGrpCdList().contains("999");
			if(!!!isManager) {
				vo.setRqsOrzNm(epOrzCd);
			}
			/* 수정 끝 */
		}
		vo.setArrRqsScd(Arrays.asList(vo.getRqsScd().split("\\s*,\\s*")));
		list = dao.selectList(vo);
		if(list == null || list.size() == 0 ) {
		} else {
			
			gridList.setGridList(list);
			
			RQCR1000U0In01VO tot_vo = new RQCR1000U0In01VO();
			ObjectCopyUtil.copyFields(vo, tot_vo);
			List<RQCR1000U0Out01VO> subList = dao.selectRqsStat(tot_vo);
			subList = dao.selectRqsStat(tot_vo);
			if (subList == null || subList.size() == 0) {
			} else {
				gridList.setRqsStat(subList);
			}
		}
		
		return gridList;
	}
	
	/* 공사신청 상태요약정보 */
	@Override
	public List<RQCR1000U0Out01VO> selectRqsStat(RQCR1000U0In00VO vo, HttpServletRequest request) {
		
		/* 입려값 셋팅시 해당 조직 조회 */
		if (StringUtils.isBlank(vo.getRqsOrzNm())) {
			/* [2023-10-19]: 총무팀 제외하고는 자기팀에서 신청한 내역만 보이게 수정 */
			HttpSession session = request.getSession();
			LoginOutVO loginVO= (LoginOutVO)session.getAttribute("loginOutVO");
			String epOrzCd = loginVO.getBlngOrzCd();
			boolean isManager = loginVO.getUserGrpCdList().contains("001") || loginVO.getUserGrpCdList().contains("999");
			if(!!!isManager) {
				vo.setRqsOrzNm(epOrzCd);
			}
			/* 수정 끝 */
		}
		
		RQCR1000U0In01VO tot_vo = new RQCR1000U0In01VO();
		ObjectCopyUtil.copyFields(vo, tot_vo);
		List<RQCR1000U0Out01VO> subList = dao.selectRqsStat(tot_vo);
		return subList;
	}
	
	/* 공사신청목록상세 조회 */
	@Override
	public List<RQCR1000U0Out02VO> selectDtlList(RQCR1000U0In02VO vo) {
		// TODO Auto-generated method stub

		List<RQCR1000U0Out02VO> dtllist = null;
		RQCR1000U0Out02VO dlVo  = null;
		
		
		List<GA09N411VO> FileList = null;    /* 첨부파일 다건내역 */		
		GA09N411VO FileVo = new GA09N411VO(); /* 첨부파일 */
		
		List<RQCR1000U0Out02VO> list = dao.selectDtlList(vo);
		
		dtllist = new ArrayList<RQCR1000U0Out02VO>();
		
		if (list != null && list.size() > 0) {
			for(int i=0; i < list.size(); i++) {
				dlVo = list.get(i);
				if (!StringUtils.isBlank(dlVo.getFileNo())) { 
					FileVo = new GA09N411VO();
					FileVo.setFileNo(dlVo.getFileNo());
					FileList = CommonDao.selectListGA09N411(FileVo); // 첨부파일 목록조회
					dlVo.setFileList(FileList);
				}
				dtllist.add(dlVo);
			}
		}
		
		return dtllist;
	}
	
	/* 공사신청 등록/임시저장 */
	/* 공사신청상세 등록/임시저장 */
	/* 공사신청 임시저장 -> 신청 */
	/* 공사신청상세 임시저장 -> 신청 */
	@Override
	public String insertRqcr(RQCR1000UVO vo) {
		// TODO Auto-generated method stub
		
		/* 공사신청 */
		RQCR1000U01VO setData = new RQCR1000U01VO();
		List<RQCR1000U0Out00VO> chkList = null; 
		
		/* 공사신청 상세 */
		RQCR1000U02VO setDtlData = new RQCR1000U02VO(); 
		
		int mCnt = 0;
		int dCnt = 0;
		String prcTp = "";
		boolean bfRegiYn = false; /* 기등록 여부 : false-신규등록 true-대상update */
		
		String newRctNo = "0";	
//		long newApprtNo = vo.getAprvWrrptMtNo();
//		String ApprvOrzCd = vo.getAprvWrrptOrzCd();
		
		String rctNo      = ""; // 접수번호 key
		String rqsDt      = ""; // 신청일자 key
		String rqsOrzCd   = ""; // 신청조직코드
		String rqsEpno    = ""; // 신청사원번호
		String rqsScd     = ""; // 신청상태코드
		String unifRqsTcd     = ""; /* 신청구분코드 신규/as/철거/기타 */
		String unifRqsPcd     = ""; /* 신청유형코드 공사/구매/렌탈/ */
		String unifRqsDlPcd   = ""; /* 신청상세유형코드 */
		String rqsTtlNm   = ""; /* 신청제목명 */
		String rqsRsnCn   = ""; /* 신청사유내용  */
		String hopeDt     = ""; /* 희망일자 */
		
		String pbcoOrzCd   = ""; /* 공사조직코드 */
		String pbcoLocNm   = ""; /* 공사위치명 */
		String pbcoDlLocNm = ""; /* 공사상세위치명 */
		
		String fileNo      = ""; /*파일번호    */
		
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
			rqsTtlNm = vo.getRqsTtlNm(); 
			rqsRsnCn = vo.getRqsRsnCn();
			hopeDt = vo.getHopeDt();
			
			pbcoOrzCd = vo.getPbcoOrzCd();
			pbcoLocNm = vo.getPbcoLocNm();
			pbcoDlLocNm = vo.getPbcoDlLocNm();
			
			fileNo = vo.getFileNo();
			
			if(rctNo !=null && !rctNo.equals("")) {
				bfRegiYn = true; // 기등록 데이터 -> update 처리
			}
			
			// 필수항목 체크
			{
				// 신청유형 신규/as/철거/기타
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
				// 희망일자
//				if(vo.getHopeDt() == null || vo.getHopeDt().equals("")) {
//		            throw new CustomBadRequestException("[필수항목 체크] 희망일자가 입력되지않았습니다.", ErrorCode.BAD_REQUEST);					
//				}
				// 공사조직코드
				if(vo.getPbcoOrzCd() == null || vo.getPbcoOrzCd().equals("")) {
					throw new CustomBadRequestException("[필수항목 체크] 공사조직코드가 입력되지않았습니다.", ErrorCode.BAD_REQUEST);
				}
				// 공사신청명
				if (!DateUtil.byteCheck(vo.getRqsTtlNm(), 50)) {
					throw new CustomBadRequestException("신청명을 20자 내로 입력해주세요.", ErrorCode.BAD_REQUEST);
				}
//				// 공사위치명
//				if (!DateUtil.byteCheck(vo.getPbcoLocNm(), 50)) {
//					throw new CustomBadRequestException("신청명을 20자 내로 입력해주세요.", ErrorCode.BAD_REQUEST);
//				}
//				// 공사상세위치명
//				if (!DateUtil.byteCheck(vo.getPbcoDlLocNm(), 50)) {
//					throw new CustomBadRequestException("신청명을 20자 내로 입력해주세요.", ErrorCode.BAD_REQUEST);
//				}
				// 공사위치명
				if(vo.getPbcoLocNm() == null || vo.getPbcoLocNm().equals("")) {
					throw new CustomBadRequestException("[필수항목 체크] 공사위치명이 입력되지않았습니다.", ErrorCode.BAD_REQUEST);
				}
				// 공사상세위치명
				if(vo.getPbcoDlLocNm() == null || vo.getPbcoDlLocNm().equals("")) {
					throw new CustomBadRequestException("[필수항목 체크] 공사상세위치명이 입력되지않았습니다.", ErrorCode.BAD_REQUEST);
				}
			}
			
			// 공사신청 정보 등록 / 임시저장 
			{
				// 임시저장건 조회
				if(bfRegiYn) {
					RQCR1000U0In00VO rqsVo = new RQCR1000U0In00VO();
					rqsVo.setRctNo(rctNo);
					rqsVo.setQryStrtDt(rqsDt);
					rqsVo.setQryEndDt(rqsDt);
					chkList = dao.selectList(rqsVo);
					
					if(chkList == null || chkList.size() == 0) {
						throw new CustomBadRequestException("공사신청 정보가 존재하지않습니다. 접수번호를 확인하세요["+chkList.get(0).getRctNo()+"]", ErrorCode.BAD_REQUEST);
					} else {
						if(!chkList.get(0).getUnifRqsPcd().equals(unifRqsPcd)) {
							throw new CustomBadRequestException("기등록된 공사신청 신청정보의 신청유형이 입력값과 상이합니다. 입력항목을 확인하세요 ["+chkList.get(0).getUnifRqsPcd()+"] 입력["+unifRqsPcd+"]", ErrorCode.BAD_REQUEST);								
						}
						if(!chkList.get(0).getRqsScd().equals(CD_RQS_SCD_TMP_STRG)) {
							throw new CustomBadRequestException("기등록된 공사신청상태가 임시저장 상태가 아닙니다. 신청상태를 확인하세요 ["+chkList.get(0).getRqsScd()+"]", ErrorCode.BAD_REQUEST);								
						}
					}
				}
				
				if ( prcTp.equals("00")) { // 임시저장
					setData.setRqsScd(CD_RQS_SCD_TMP_STRG);
					rqsScd = CD_RQS_SCD_TMP_STRG;
				}else if(prcTp.equals("01")) { // 상신
					setData.setRqsScd(CD_RQS_SCD_APV_ING);
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
				
				RQCR1000UVO setVo = new RQCR1000UVO();
				
				// 공사신청 데이터 셋팅
				{
					// 기등록건 수정
					if(bfRegiYn) {
						newRctNo = rctNo;
					}
					
					setVo.setRqsDt(rqsDt);
					setVo.setRctNo(newRctNo);
					setVo.setUnifRqsPcd(unifRqsPcd);
					setVo.setUnifRqsDlPcd(unifRqsDlPcd);
					setVo.setUnifRqsTcd(unifRqsTcd);
					setVo.setRqsOrzCd(rqsOrzCd);
					setVo.setRqsEpno(rqsEpno);
					setVo.setRqsTtlNm(rqsTtlNm);
					setVo.setRqsRsnCn(rqsRsnCn);
					setVo.setHopeDt(hopeDt);
					setVo.setCmpnDt("");
//					setVo.setAprvWrrptMtNo(newApprtNo);
//					setVo.setAprvWrrptOrzCd(ApprvOrzCd);
					setVo.setRqsScd(rqsScd);
					
					setVo.setPbcoOrzCd(pbcoOrzCd);
					setVo.setPbcoLocNm(pbcoLocNm);
					setVo.setPbcoDlLocNm(pbcoDlLocNm);
					
					setVo.setFileNo(fileNo);
				}
				
				// 임시저장건 수정
				if(bfRegiYn) {
					newRctNo = rctNo;

					log.info("상신자정보["+rqsOrzCd+"]["+rqsEpno+"]" );
					RQCR1000U03VO uptVo = new RQCR1000U03VO();
					ObjectCopyUtil.copyFields(setVo, uptVo);
					mCnt = dao.updateRqcr(uptVo);
					log.info("mCnt  ============"+mCnt);
					
					if (mCnt > 0) {
						RQCR1000U04VO upDtlVo = new RQCR1000U04VO();
						ObjectCopyUtil.copyFields(setVo, upDtlVo);
						dCnt = dao.updateRqcrDtl(upDtlVo);
						log.info("dCnt  ============"+dCnt);
					} else {
						throw new CustomBadRequestException("공사신청정보를 등록하지 못했습니다. 신청정보를 확인하세요", ErrorCode.BAD_REQUEST);
					}
				// 신규 등록
				} else {
					log.info("상신자정보["+rqsOrzCd+"]["+rqsEpno+"]" );
					ObjectCopyUtil.copyFields(setVo, setData);
					mCnt = dao.insertRqcr(setData);
					log.info("mCnt  ============"+mCnt);
					
					if(mCnt > 0 ) {
						ObjectCopyUtil.copyFields(setVo, setDtlData);
						dCnt = dao.insertRqcrDtl(setDtlData);
						log.info("dCnt  ============"+dCnt);
					} else {
						throw new CustomBadRequestException("공사신청정보를 등록하지 못했습니다. 신청정보를 확인하세요", ErrorCode.BAD_REQUEST);
					}
				}
				
			}
			
			// 결재 등록
			{
				List<AprvWrrptInVO> aprvlList =  vo.getAprvl();
				GA09N607InVO aprvVo = new GA09N607InVO();
				aprvVo.setRctNo(newRctNo);
				aprvVo.setAprvl(aprvlList);
				aprvWrrpt.aprvWrrpt(aprvVo);
			}
			
		}
		
		return newRctNo;
	}
	
	/* 공사신청 임시저장인경우 -> 삭제 */
	/* 공사신청상세 임시저장인경우 -> 삭제 */
	@Override
	public int deleteRqcr(RQCR1000U05VO vo) {
		// TODO Auto-generated method stub
		int mCnt = 0; 
		int dCnt = 0;
		
		RQCR1000U0In00VO rqsVo = new RQCR1000U0In00VO();
		rqsVo.setRctNo(vo.getRctNo());
		rqsVo.setQryStrtDt(vo.getRqsDt());
		rqsVo.setQryEndDt(vo.getRqsDt());
		/* 공사신청 */
		List<RQCR1000U0Out00VO> chkList = null; 
		chkList = dao.selectList(rqsVo);
		
		if(chkList == null || chkList.size() == 0) {
			throw new CustomBadRequestException("삭제대상 공사신청정보를 찾지 못했습니다. 신청정보를 확인하세요", ErrorCode.BAD_REQUEST);
		} else {
			if(chkList.get(0).getRqsScd().equals(CD_RQS_SCD_TMP_STRG)) {
				
				mCnt = dao.deleteRqcr(vo);
				log.info("mCnt  ============"+mCnt);
				if (mCnt > 0) {
					dCnt = dao.deleteRqcrDtl(vo);
					log.info("dCnt  ============"+dCnt);
					
					// 2023.10.25 기존 결재선 삭제
					rqamDao.deleteAprvl(chkList.get(0).getAprvWrrptMtNo());
				} else {
					throw new CustomBadRequestException("공사신청정보를 삭제하지 못했습니다. 신청정보를 확인하세요", ErrorCode.BAD_REQUEST);
				}
			} else {
				throw new CustomBadRequestException("기등록된 공사신청상태가 임시저장 상태가 아닙니다. 신청상태를 확인하세요 ["+chkList.get(0).getRqsScd()+"]", ErrorCode.BAD_REQUEST);
			}
		}
		return mCnt;
	}
	
	/* 공사신청 다건 삭제 */
	@Override
	public int deleteList(RQCR1000U06VO vo) {
		// TODO Auto-generated method stub
		int mCnt = 0; 
		int dCnt = 0;
		int cnt = 0; 
		int arryCnt = 0;
		
		List<RQCR1000U05VO> delList = vo.getDelList();
		RQCR1000U05VO setVo = null;
		
		/* 공사신청 - 임시저장건 체크 */
		RQCR1000U0In00VO rqsVo = new RQCR1000U0In00VO();
		List<RQCR1000U0Out00VO> chkList = null;
		
		if(delList == null || delList.size() == 0) {
			throw new CustomBadRequestException("삭제할 공사신청 내역이 없습니다.", ErrorCode.BAD_REQUEST);
		} else {
			for( int i = 0; i < delList.size(); i++) {
				arryCnt++;
				
				setVo = delList.get(i);
				
				rqsVo.setRctNo(setVo.getRctNo());
				rqsVo.setQryStrtDt(setVo.getRqsDt());
				rqsVo.setQryEndDt(setVo.getRqsDt());
				chkList = dao.selectList(rqsVo);
				
				if(chkList.get(0).getRqsScd().equals(CD_RQS_SCD_TMP_STRG)) {
					mCnt = dao.deleteRqcr(setVo);
					if(mCnt > 0) {
						dCnt = dao.deleteRqcrDtl(setVo);
					}
				}
			}
		}
		return arryCnt;
	}
	
	/* 공사신청목록 완료처리 */
	public int rqsListCmpn(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		int cnt = 0;
		int dtlCnt = 0;
		
		/* 메시저 알림(임시) */
		String unifRqsDlPcdNm = ""; // 메신저 알림 신청구분
		String unifRqsTcdNm = "";   // 메신저 알림 신청유형 
		String rqsTtlNm = "";       // 메신저 알림 신청명
		
		String sReceiveUserId = "";
		String sRctNo         = "";
		
		RQRR1000U0In05VO datavo = null;
		List<RQRR1000U0In05VO> listvo;
		
		List<RQRR1000U0VO> chkListVo;
		RQRR1000U0VO chkvo = new RQRR1000U0VO();
		
		listvo = (ArrayList)vo.getGrid5();	
		
		log.info("listvo ============"+listvo);
		if( listvo == null || listvo.size() == 0) {
            throw new CustomBadRequestException("완료처리할 신청대상건이 없습니다. 입력값을 확인하세요.", ErrorCode.BAD_REQUEST);					
		}		
		
		for( int i = 0;i<listvo.size();i++) {
			datavo = listvo.get(i);
			chkvo.setRctNo(datavo.getRctNo());

			// [20231026] 완료일자 입력받은 일자로 설정. NULL 또는 빈 값이면 오늘 날짜
			if(datavo.getCmpnDt() != null && !!!datavo.getCmpnDt().equals("")) {
				chkvo.setCmpnDt(datavo.getCmpnDt());
			} else {
				chkvo.setCmpnDt(DateUtil.getTodayString("yyyyMMdd"));
			}

			log.info("datavo  ============"+datavo);
			
			chkListVo = (ArrayList)RQRR1000U0Dao.selectGA01N101(chkvo);	
			
			if(chkListVo == null || chkListVo.size() == 0 ) {
	            throw new CustomBadRequestException("공사신청 완료처리 대상건이 존재하지않습니다. 접수번호를 확인하세요["+chkvo.getRctNo()+"]", ErrorCode.BAD_REQUEST);					
			}			
			
			if(chkListVo != null && chkListVo.size() > 0) {
				chkvo = (RQRR1000U0VO)chkListVo.get(0);
				
				sReceiveUserId = chkvo.getRqsEpno();
				sRctNo = chkvo.getRctNo();
				
				log.info("chkvo  ============"+chkvo.getRctNo());
				
				if(chkvo.getRqsScd() != null && !chkvo.getRqsScd().equals(CD_RQS_SCD_APV_CMPN) ) {
		            throw new CustomBadRequestException("공사신청 완료처리는 승인완료태일경우만 처리가능합니다. 신청상태를 확인하세요["+chkvo.getRqsScd()+"]["+chkvo.getRctNo()+"]", ErrorCode.BAD_REQUEST);					
				}
			}
			
			{ /* 공사신청 완료처리 */
				
				unifRqsDlPcdNm = chkvo.getUnifRqsDlPcdNm();
				unifRqsTcdNm   = chkvo.getUnifRqsTcdNm();
				rqsTtlNm       = chkvo.getRqsTtlNm();
				
				// 해당 업무 화면 조회
				GaCode01In00VO rqsPcdVo = new GaCode01In00VO();
				rqsPcdVo.setCdKndNo("PSIT_MENU_ID_TCD");
				rqsPcdVo.setCmnCdVl(chkvo.getUnifRqsPcd());
				List<GaCode01Out00VO> rqsPcdList = CodeDao.selectBzMtCode(rqsPcdVo); 
				String psitMenuId = rqsPcdList.get(0).getCmnCdVlDefCn();
				
				ObjectCopyUtil.copyFields(datavo, chkvo);
				
				chkvo.setRqsScd(CD_RQS_SCD_CMPN);
				//log.info("getTodayString  ============"+DateUtil.getTodayString("yyyyMMdd"));
				//vo.setCmpnDt(DateUtil.getTodayString("yyyyMMdd"));
				cnt = RQRR1000U0Dao.updateRqsScd(chkvo);
				
				if (cnt > 0) {
					// 담당자 완료 처리일경우
					GA09N602Vf02InVO GA09N602Vf02InVO = new GA09N602Vf02InVO();
					GA09N602Vf02OutVO GA09N602Vf02OutVO = null;
					GA09N602Vf02InVO.setEpno(vo.getRqsEpno());
					GA09N602Vf02InVO.setScrnNo(psitMenuId);
					
					// 화면 담당자가 없는 화면 체크
					GA09N602Vf02OutVO = rqamDao.selectBzChprYn(GA09N602Vf02InVO);
					if (GA09N602Vf02OutVO.getBzChprYn().equals("Y")) {
						msg.sendMsgEnrollNoti(sReceiveUserId, sRctNo, "PROC_COMP", "", "");
					}
				}
				
			}			
		}		
		
		return cnt;
	}
	
	/* 공사신청 반려 건 자동 재신청 */
	@Override
	public Map<String, Object> insertGA01N103ReApplyByRctNo(String prevRctNo, LoginOutVO loginVo) {
		GaSrno00In00VO rctVo = new GaSrno00In00VO();
		rctVo.setCdKndNo("CHAEBUN");
		rctVo.setCmnCdVl(APRV_PCD_01);
		rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
		String strRctNo = rctVo.getRpbzGnoSrno();

		Map<String, Object> map = new HashMap<>();
		map.put("rctNo", strRctNo);
		map.put("prevRctNo", prevRctNo);

		map.put("optrId"    , loginVo.getEpno());
		map.put("oprtChnlCd", loginVo.getOprtChnlCd());
		map.put("oprtOrzCd" , loginVo.getOprtOrzCd());
		map.put("oprtIpAdr" , loginVo.getOprtIpAdr());

		int rtn = dao.insertGA01N103ReApplyByRctNo(map);

		return map;
	}
}
