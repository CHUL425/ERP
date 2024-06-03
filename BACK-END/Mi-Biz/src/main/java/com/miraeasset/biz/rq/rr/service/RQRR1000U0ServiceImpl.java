package com.miraeasset.biz.rq.rr.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out00VO;

import org.apache.commons.lang3.StringUtils;
import org.apache.hc.core5.http.HttpRequest;
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
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA01N102VO;
import com.miraeasset.biz.common.meta.vo.GA01N102Vf01InVO;
import com.miraeasset.biz.common.meta.vo.GA01N102Vf01OutVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02InVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02OutVO;
import com.miraeasset.biz.common.meta.vo.GA09N606VO;
import com.miraeasset.biz.common.meta.vo.GA09N607VO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.aprvWrrpt.AprvWrrpt;
import com.miraeasset.biz.common.util.massage.MsgSenService;
import com.miraeasset.biz.rq.am.dao.RQAM1000U0Dao;
import com.miraeasset.biz.rq.rr.dao.RQRR1000U0Dao;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In03VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In05VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In06VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In07VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0Out03VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0Out07VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@Transactional
public class RQRR1000U0ServiceImpl implements RQRR1000U0Service {
	
	@Autowired
	RQRR1000U0Dao RQRR1000U0Dao;
	
	@Autowired
	CodeDao CodeDao;

	@Autowired
	RQAM1000U0Dao rqamDao;	
	
	@Autowired
	MsgSenService msg;
	
	@Autowired
	AprvWrrpt aprvWrrpt;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "00"; // 임시저장 
	private final String CD_RQS_SCD_APV_ING  = "05"; // 승인중 
	private final String CD_RQS_SCD_APV_CMPN = "10"; // 승인완료 
	private final String CD_RQS_SCD_EMAL     = "15"; // 메일전송완료
	private final String CD_RQS_SCD_RTRN     = "30"; // 반려 
	private final String CD_RQS_SCD_WDRAL    = "35"; // 철회
	private final String CD_RQS_SCD_CMPN     = "99"; // 완료
	
	private final String APRV_PCD_01 = "01"; //공사신청
	private final String APRV_PCD_02 = "02"; //구매신청
	private final String APRV_PCD_03 = "03"; //렌탈신청
	private final String APRV_PCD_04 = "04"; //명함신청
	private final String APRV_PCD_05 = "05"; //인감신청
	private final String APRV_PCD_06 = "06"; //인장신청
	private final String APRV_PCD_09 = "09"; //문서신청
	private final String APRV_PCD_91 = "91"; //사용자그룹
	private final String APRV_PCD_92 = "91"; //화면권한
	
	/* 렌탈신청목록 조회 */
	@Override
	public List<RQRR1000U0VO> selectListRentRqs(RQRR1000U0VO vo, HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<RQRR1000U0VO> result = null;
		
		/* 입려값 셋팅시 해당 조직 조회 */
		if (StringUtils.isBlank(vo.getRqsOrzCd())) {
			/* [2023-10-19]: 총무팀 제외하고는 자기팀에서 신청한 내역만 보이게 수정 */
			HttpSession session = request.getSession();
			LoginOutVO loginVO= (LoginOutVO)session.getAttribute("loginOutVO");
			String epOrzCd = loginVO.getBlngOrzCd();
			boolean isManager = loginVO.getUserGrpCdList().contains("001") || loginVO.getUserGrpCdList().contains("999");
			if(!!!isManager) {
				vo.setRqsOrzCd(epOrzCd);
			}
		}
		/* 수정 끝 */
		result = RQRR1000U0Dao.selectListRentRqs(vo);


		return result;
	}

	/* 렌탈신청목록 상태조회 */
	@Override
	public List<Map<String, Object>> selecRentRqsScdInfo(RQRR1000U0VO vo, HttpServletRequest request) {
		// TODO Auto-generated method stub
		/* 입려값 셋팅시 해당 조직 조회 */
		if (StringUtils.isBlank(vo.getRqsOrzCd())) {
		}
		/* [2023-10-19]: 총무팀 제외하고는 자기팀에서 신청한 내역만 보이게 수정 */
		HttpSession session = request.getSession();
		LoginOutVO loginVO= (LoginOutVO)session.getAttribute("loginOutVO");
		String epOrzCd = loginVO.getBlngOrzCd();
		boolean isManager = loginVO.getUserGrpCdList().contains("001") || loginVO.getUserGrpCdList().contains("999");
		if(!!!isManager) {
			vo.setRqsOrzCd(epOrzCd);
		}
		return RQRR1000U0Dao.selecRentRqsScdInfo(vo);
	}
	
	/* 렌탈신청(임대신청) 조회(PK)  */
	@Override
	public List<RQRR1000U0VO> selectGA01N003(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		return RQRR1000U0Dao.selectGA01N101(vo);
	}
	
	/* 렌탈신청상세(임대신청상세) 조회(PK) */
	@Override
	public List<RQRR1000U0Out07VO> selectGA01N004(RQRR1000U0In07VO vo){
		// TODO Auto-generated method stub
		
		GA01N102VO datavo = new GA01N102VO();
		List<GA01N102VO> listDatavo = null;
		List<RQRR1000U0Out07VO> listOutVo = (List<RQRR1000U0Out07VO>) new ArrayList();
		RQRR1000U0Out07VO outVo = new RQRR1000U0Out07VO();
		
		ObjectCopyUtil.copyFields(vo, datavo);
		listDatavo = RQRR1000U0Dao.selectGA01N004(datavo);
		
		if(listDatavo != null && listDatavo.size() > 0 ) {
			
			ObjectCopyUtil.copyFields(listDatavo.get(0), outVo);
			listOutVo.add(outVo);
            					
		}			
		
		return listOutVo;
	}

	
	/* 렌탈신청삭제(임대신청) delete(PK) */
	@Override
	public int deleteGA01N003(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		
		int cnt = 0;
		String aprvWrrptMtNo = "";
		
		/* 삭제전 정합성 체크 */
		List<RQRR1000U0VO> listvo = (ArrayList) RQRR1000U0Dao.selectGA01N101(vo);

		log.info("listvo ============" + listvo);
		log.info("listvo.size() ============" + listvo.size());

		if (listvo == null || listvo.size() == 0) {
			throw new CustomBadRequestException("렌탈신청 삭제대상건이 존재하지않습니다. 접수번호를 확인하세요[" + vo.getRctNo() + "]",
					ErrorCode.BAD_REQUEST);
		}

		if (listvo != null && listvo.size() > 0) {
			RQRR1000U0VO getVo = (RQRR1000U0VO) listvo.get(0);
			log.info("getVo  ============" + getVo);

			log.info("getVo  getRqsScd============[" + getVo.getRqsScd() + "]");

			if (getVo.getRqsScd() != null && !getVo.getRqsScd().equals(CD_RQS_SCD_TMP_STRG)) {
				throw new CustomBadRequestException(
						"렌탈신청 삭제는 임시저장상태일경우만 삭제가능합니다. 신청상태를 확인하세요[" + getVo.getRqsScd() + "]",
						ErrorCode.BAD_REQUEST);
			}
			aprvWrrptMtNo = getVo.getAprvWrrptMtNo();
		}

		/* 렌탈신청 삭제처리 */
		cnt = RQRR1000U0Dao.deleteGA01N003(vo);
		log.info("cnt  ============" + cnt);

		if (cnt > 0) {
			/* 렌탈신청상세삭제(임대신청상새) 같은접수번호 delete */
			RQRR1000U0Dao.deleteGA01N004WithRctNo(vo);
			
			// 2023.10.25 기존 결재선 삭제
			rqamDao.deleteAprvl(aprvWrrptMtNo);
		}
		
		return cnt;
	}	
		
	/* 렌탈신청상세삭제(임대신청상새) 같은접수번호 delete */
	@Override
	public int deleteGA01N004WithRctNo(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		return RQRR1000U0Dao.deleteGA01N004WithRctNo(vo);
	}	
	
	/* 렌탈신청(임대신청) 신청상태변경 */
	@Override
	public int updateRqsScd(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		return RQRR1000U0Dao.updateRqsScd(vo);
	}	

	/* 렌탈신청상세목록 조회 */
	@Override
	public List<RQRR1000U0VO> selectListRentRqsDtl(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		return RQRR1000U0Dao.selectListRentRqsDtl(vo);
	}
	
	/* 렌탈신청상세목록 조회 */
	@Override
	public List<RQRR1000U0Out03VO> selectListRentRqsDtl(RQRR1000U0In03VO inVo) {
		// TODO Auto-generated method stub
		
		// 변수선언 
		GA01N102Vf01InVO datainvo = new GA01N102Vf01InVO();
		GA01N102Vf01OutVO dataoutvo = new GA01N102Vf01OutVO();
		
		RQRR1000U0Out03VO outVo = null;
		List<GA01N102Vf01OutVO> dataList = null;
		List<RQRR1000U0Out03VO> outListVo = (List<RQRR1000U0Out03VO>) new ArrayList();

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
					outVo = new RQRR1000U0Out03VO();
					ObjectCopyUtil.copyFields(dataoutvo, outVo);
					//log.info("outVo ["+i+"] ============["+outVo.getRctNo()+"]["+outVo.getRctDlNo()+"]");
					outListVo.add(outVo);
				}
			}
		}
		
		return outListVo;
	}
	
	
	/* 렌탈신청 대량삭제(임대신청) */
	@Override
	public int deleteRqsList(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		int cnt = 0;
		int dtlCnt = 0;
		
		List<RQRR1000U0In03VO> listvo = vo.getGrid();		
		RQRR1000U0In03VO datavo = null;
		List<RQRR1000U0VO> chkListVo;
		RQRR1000U0VO chkvo = new RQRR1000U0VO();
		
		if(listvo == null || listvo.size() == 0 ) {
            throw new CustomBadRequestException("렌탈신청 삭제대상건이 존재하지않습니다. 접수번호를 확인하세요["+vo.getRctNo()+"]", ErrorCode.BAD_REQUEST);					
		}		
		
		for( int i = 0;i<listvo.size();i++) {
			datavo = listvo.get(i);
			chkvo.setRctNo(datavo.getRctNo());
			log.info("datavo  ============"+datavo);
			
			chkListVo = (ArrayList)RQRR1000U0Dao.selectGA01N101(chkvo);	
			
			if(chkListVo == null || chkListVo.size() == 0 ) {
	            throw new CustomBadRequestException("렌탈신청 삭제대상건이 존재하지않습니다. 접수번호를 확인하세요["+chkvo.getRctNo()+"]", ErrorCode.BAD_REQUEST);					
			}			
			
			if(chkListVo != null && chkListVo.size() > 0) {
				chkvo = (RQRR1000U0VO)chkListVo.get(0);
				log.info("chkvo  ============"+chkvo.getRctNo());
				
				if(chkvo.getRqsScd() != null && !chkvo.getRqsScd().equals(CD_RQS_SCD_TMP_STRG) ) {
		            throw new CustomBadRequestException("렌탈신청 삭제는 임시저장상태일경우만 처리가능합니다. 신청상태를 확인하세요["+chkvo.getRqsScd()+"]["+chkvo.getRctNo()+"]", ErrorCode.BAD_REQUEST);					
				}
			}
			
			{ /* 렌탈신청 삭제처리 */
				cnt = RQRR1000U0Dao.deleteGA01N003(chkvo);
				log.info("cnt  ============"+cnt);

				if( cnt > 0 ) {
					/* 렌탈신청상세삭제(임대신청상새) 같은접수번호 delete */
					dtlCnt = RQRR1000U0Dao.deleteGA01N004WithRctNo(chkvo);			
					log.info("dtlCnt  ============"+dtlCnt);					
				}
			}			
		}
		
		return cnt;
	}	

	
	/* 렌탈신청목록 완료처리 */
	public int rqsListCmpn(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		int cnt = 0;
		int dtlCnt = 0;
		
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
			chkvo.setCmpnDt(datavo.getCmpnDt());
			log.info("datavo  ============"+datavo);
			
			chkListVo = (ArrayList)RQRR1000U0Dao.selectGA01N101(chkvo);	
			
			if(chkListVo == null || chkListVo.size() == 0 ) {
	            throw new CustomBadRequestException("렌탈신청 완료처리 대상건이 존재하지않습니다. 접수번호를 확인하세요["+chkvo.getRctNo()+"]", ErrorCode.BAD_REQUEST);					
			}			
			
			if(chkListVo != null && chkListVo.size() > 0) {
				chkvo = (RQRR1000U0VO)chkListVo.get(0);
				
				sReceiveUserId = chkvo.getRqsEpno();
				sRctNo = chkvo.getRctNo();
				
				log.info("chkvo  ============"+chkvo.getRctNo());
				
				if(chkvo.getRqsScd() != null && !chkvo.getRqsScd().equals(CD_RQS_SCD_APV_CMPN) ) {
		            throw new CustomBadRequestException("렌탈신청 완료처리는 승인완료태일경우만 처리가능합니다. 신청상태를 확인하세요["+chkvo.getRqsScd()+"]["+chkvo.getRctNo()+"]", ErrorCode.BAD_REQUEST);					
				}
			}
			
			{ /* 렌탈신청 완료처리 */
				
				ObjectCopyUtil.copyFields(datavo, chkvo);
				
				chkvo.setRqsScd(CD_RQS_SCD_CMPN);
				//log.info("getTodayString  ============"+DateUtil.getTodayString("yyyyMMdd"));
				//vo.setCmpnDt(DateUtil.getTodayString("yyyyMMdd"));
				
				// 해당 업무 화면 조회
				GaCode01In00VO rqsPcdVo = new GaCode01In00VO();
				rqsPcdVo.setCdKndNo("PSIT_MENU_ID_TCD");
				rqsPcdVo.setCmnCdVl(chkvo.getUnifRqsPcd());
				List<GaCode01Out00VO> rqsPcdList = CodeDao.selectBzMtCode(rqsPcdVo); 
				String psitMenuId = rqsPcdList.get(0).getCmnCdVlDefCn();
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
	
	/* 렌탈신청 반려 건 자동 재신청 */
	@Override
	public Map<String, Object> insertGA01N102ReApplyByRctNo(String prevRctNo, LoginOutVO loginVo) {
		// TODO Auto-generated method stub
		GaSrno00In00VO rctVo = new GaSrno00In00VO();
		rctVo.setCdKndNo("CHAEBUN");
		rctVo.setCmnCdVl(APRV_PCD_03);
		rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
		String strRctNo = rctVo.getRpbzGnoSrno();

		Map<String, Object> map = new HashMap<>();
		map.put("rctNo", strRctNo);
		map.put("prevRctNo", prevRctNo);

		map.put("optrId"    , loginVo.getEpno());
		map.put("oprtChnlCd", loginVo.getOprtChnlCd());
		map.put("oprtOrzCd" , loginVo.getOprtOrzCd());
		map.put("oprtIpAdr" , loginVo.getOprtIpAdr());

		int rtn = RQRR1000U0Dao.insertGA01N102ReApplyByRctNo(map);

		return map;
	}
}
