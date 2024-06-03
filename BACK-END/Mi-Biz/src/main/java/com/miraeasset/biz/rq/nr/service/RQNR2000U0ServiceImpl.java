package com.miraeasset.biz.rq.nr.service;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
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
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA03N102VO;
import com.miraeasset.biz.common.meta.vo.GA03N104VO;
import com.miraeasset.biz.common.meta.vo.GA03N105VO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02InVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02OutVO;
import com.miraeasset.biz.common.util.massage.MsgSenService;
import com.miraeasset.biz.rq.am.dao.RQAM1000U0Dao;
import com.miraeasset.biz.rq.nr.dao.RQNR1000U0Dao;
import com.miraeasset.biz.rq.nr.dao.RQNR2000U0Dao;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0In00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0In01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out02VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out03VO;
import com.miraeasset.biz.rq.rr.dao.RQRR1000U0Dao;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;
import com.miraeasset.biz.rq.sr.dao.RQSR1000U0Dao;

@Service
@Transactional
public class RQNR2000U0ServiceImpl implements RQNR2000U0Service {

	@Autowired
	RQNR1000U0Dao RQNR1000U0Dao;
	
	@Autowired
	RQNR2000U0Dao RQNR2000U0Dao;
	
	@Autowired
	RQRR1000U0Dao RQRR1000U0Dao;
	
	@Autowired
	RQSR1000U0Dao RQSR1000U0Dao;
	
	@Autowired
	CodeDao CodeDao;

	@Autowired
	RQAM1000U0Dao rqamDao;	
	
	@Autowired
	MsgSenService msg;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "00"; // 임시저장 
	private final String CD_RQS_SCD_APV_ING  = "05"; // 승인중 
	private final String CD_RQS_SCD_APV_CMPN = "10"; // 승인완료 
	private final String CD_RQS_SCD_EMAL     = "15"; // 메일전송완료
	private final String CD_RQS_SCD_RTRN     = "30"; // 반려 
	private final String CD_RQS_SCD_WDRAL    = "35"; // 철회
	private final String CD_RQS_SCD_CMPN     = "99"; // 완료
	
	
	/* 명함신청내역-조회  */
	@Override
	public List<RQNR2000U0Out00VO> selectListGA03N102(RQNR2000U0In00VO vo, HttpServletRequest request) {
		
		if (vo.getQryStrtDt() == null || vo.getQryStrtDt().equals("")) {
			throw new CustomBadRequestException("신청일자 조회시작일을 확인하세요. ["+vo.getQryStrtDt()+"]", ErrorCode.BAD_REQUEST);
		}
		
		if (vo.getQryEndDt() == null || vo.getQryEndDt().equals("")) {
			throw new CustomBadRequestException("신청일자 조회종료일을 확인하세요. ["+vo.getQryEndDt()+"]", ErrorCode.BAD_REQUEST);
		}
		
		HttpSession session = request.getSession();
		LoginOutVO loginVO = (LoginOutVO)session.getAttribute("loginOutVO");
		
		/*[2024-01-24] 조직대표자는 전체하위조직 조회*/
		//String orzRptvYn = loginVO.getOrzRptvYn();  // 대표자여부
		//if("Y".equals(orzRptvYn)) {
		//	vo.setOrzRptvYn(orzRptvYn);   // 직책
		//	vo.setRqsOrzCd(loginVO.getBlngOrzCd()); // 소속조직
		//	vo.setEpno(loginVO.getEpno());
		//} else 
			
		if(StringUtils.isBlank(vo.getRqsOrzCd())) {
			
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
		
		return RQNR2000U0Dao.selectListGA03N102(vo);
	}
	
	
	/* 명함신청내역-상태조회  */
	@Override
	public RQNR2000U0Out01VO selectInfoGA03N102(RQNR2000U0In00VO vo, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		LoginOutVO loginVO = (LoginOutVO)session.getAttribute("loginOutVO");
		
		/*[2024-01-24] 조직대표자는 전체하위조직 조회*/
		//String orzRptvYn = loginVO.getOrzRptvYn();  // 대표자여부
		//if("Y".equals(orzRptvYn)) {
		//	vo.setOrzRptvYn(orzRptvYn);   // 직책
		//	vo.setRqsOrzCd(loginVO.getBlngOrzCd()); // 소속조직
		//	vo.setEpno(loginVO.getEpno());
		//} else 
		
		if(StringUtils.isBlank(vo.getRqsOrzCd())) {
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

		return RQNR2000U0Dao.selectInfoGA03N102(vo);
	}

	/* 명함신청내역-완료처리 */
	@Override
	public int rqsListCmpn(RQNR2000U0In01VO vo) {
		
		int cnt = 0;
		
		String sReceiveUserId = "";
		String sRctNo         = "";
		
		// 전처리 
		if(vo == null) {
            throw new CustomBadRequestException("완료처리할 신청대상건이 없습니다. 입력값을 확인하세요.", ErrorCode.BAD_REQUEST);					
		}	
		
		RQRR1000U0VO chkvo = new RQRR1000U0VO();
		chkvo.setRctNo(vo.getRctNo());
		
		List<RQRR1000U0VO>  rctNoList = RQRR1000U0Dao.selectGA01N101(chkvo);
		if( rctNoList == null || rctNoList.size() == 0 ) {
			throw new CustomBadRequestException("명함신청 완료처리 대상건이 존재하지않습니다. 접수번호를 확인하세요["+chkvo.getRctNo()+"]", ErrorCode.BAD_REQUEST);					
		} else {
			RQRR1000U0VO rctNoVo = rctNoList.get(0);
			
			if(rctNoVo.getRqsScd() != null 
			&& (!rctNoVo.getRqsScd().equals(CD_RQS_SCD_APV_CMPN))) {
	            throw new CustomBadRequestException("명함신청 완료처리는 승인완료 상태일경우만 처리가능합니다. 신청상태를 확인하세요["+rctNoVo.getRqsScd()+"]["+rctNoVo.getRctNo()+"]", ErrorCode.BAD_REQUEST);					
			}
			
			sReceiveUserId = rctNoVo.getRqsEpno();
			sRctNo = rctNoVo.getRctNo();
			
			/* 명함신청 완료처리 */
			rctNoVo.setCmpnDt(vo.getCmpnDt()); // 완료일자 
			rctNoVo.setRqsScd(CD_RQS_SCD_CMPN);

			// 해당 업무 화면 조회
			GaCode01In00VO rqsPcdVo = new GaCode01In00VO();
			rqsPcdVo.setCdKndNo("PSIT_MENU_ID_TCD");
			rqsPcdVo.setCmnCdVl(rctNoVo.getUnifRqsPcd());
			List<GaCode01Out00VO> rqsPcdList = CodeDao.selectBzMtCode(rqsPcdVo); 
			String psitMenuId = rqsPcdList.get(0).getCmnCdVlDefCn();
			cnt = RQRR1000U0Dao.updateRqsScd(rctNoVo);
			
			if (cnt > 0) {
				// 담당자 완료 처리일경우
				GA09N602Vf02InVO GA09N602Vf02InVO = new GA09N602Vf02InVO();
				GA09N602Vf02OutVO GA09N602Vf02OutVO = null;
				GA09N602Vf02InVO.setEpno(vo.getRqsEpno());
				GA09N602Vf02InVO.setScrnNo(psitMenuId);
				
				// 화면 담당자가 없는 화면 체크
				GA09N602Vf02OutVO = rqamDao.selectBzChprYn(GA09N602Vf02InVO);
				if (GA09N602Vf02OutVO != null && "Y".equals(GA09N602Vf02OutVO.getBzChprYn())) {
					msg.sendMsgEnrollNoti(sReceiveUserId, sRctNo, "PROC_COMP", "", "");
				}
			}
		}
		return cnt;
	}

	
	/* 명함신청내역-상세정보 조회 */
	@Override
	public RQNR2000U0Out02VO selectDlInfo(RQNR2000U0In01VO vo) {
		
		RQNR2000U0Out02VO rtnVo = new RQNR2000U0Out02VO();
		
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
			rtnVo = RQNR2000U0Dao.selectDlInfo(vo);
			
			if(rtnVo == null) {
		        throw new CustomBadRequestException("통합신청 대상건이 존재하지않습니다. 접수번호를 확인하세요["+rctNo+"]", ErrorCode.BAD_REQUEST);						
			}
			
			List<RQNR2000U0Out03VO> listVo = RQNR2000U0Dao.selectListGA03N102Dtl(vo);
			rtnVo.setGridGA03N102(listVo);
		}
		return rtnVo;
	}

	
	/* 명함상세 주문내역(엑셀다운로드) */
	@Override
	public List<RQNR2000U0Out03VO> selectListGA03N102Dtl(RQNR2000U0In01VO vo){
		List<RQNR2000U0Out03VO> listVo = RQNR2000U0Dao.selectListGA03N102Dtl(vo);
		return listVo;
	}
	
	
	/* 명함상세 사용자별 미리보기 */
	@Override
	public GA03N105VO selectDtlGA03N105(RQNR2000U0In01VO vo) {
		return RQNR2000U0Dao.selectDtlGA03N105(vo);
	}

	/* 명함신청내역-상세정보 삭제 */
	@Override
	public int deleteDlInfo(RQNR2000U0In01VO vo) {
		
		RQNR2000U0Out02VO rtnVo = new RQNR2000U0Out02VO();
		
		String rctNo = null; //접수번호
		int cnt = 0;
		
		// 전처리 : 입력값 체크
		{
			rctNo = vo.getRctNo();
			if(rctNo == null || rctNo.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[접수번호] 오류. 입력값을 확인하세요["+rctNo+"]", ErrorCode.BAD_REQUEST);		
			}
		}
		
		// 조회
		{
			rtnVo = RQNR2000U0Dao.selectDlInfo(vo);
			
			if(rtnVo == null) {
		        throw new CustomBadRequestException("통합신청 대상건이 존재하지않습니다. 접수번호를 확인하세요["+rctNo+"]", ErrorCode.BAD_REQUEST);						
			}
			
			if(rtnVo.getRqsScd() == null ) {
		        throw new CustomBadRequestException("통합신청 신청상태코드를 확인하세요. ["+rtnVo.getRqsScd()+"]", ErrorCode.BAD_REQUEST);						
			}else {
				if(!CD_RQS_SCD_TMP_STRG.equals(rtnVo.getRqsScd()) ){
			        throw new CustomBadRequestException("통합신청 신청상태코드를 확인하세요. 임시저장상태(00)일경우만 삭제처리 가능합니다. ["+rtnVo.getRqsScd()+"]["+rtnVo.getRqsScdNm()+"]", ErrorCode.BAD_REQUEST);						
				}
			}
			
			if(rtnVo.getRqsEpno() == null ) {
		        throw new CustomBadRequestException("통합신청 신청사번을 확인하세요. ["+rtnVo.getRqsEpno()+"]", ErrorCode.BAD_REQUEST);						
			}else {
				if(!vo.getRqsEpno().equals(rtnVo.getRqsEpno()) ){
			        throw new CustomBadRequestException("신청자만 삭제처리 가능합니다. ["+vo.getRqsEpno()+"]["+rtnVo.getRqsEpno()+"]", ErrorCode.BAD_REQUEST);						
				}
			}
		}
		
		
		// 삭제처리 
		{
			// 1.통합신청  
			GA01N101VO GA01N101VO = new GA01N101VO();
			GA01N101VO.setRctNo(rctNo);
			cnt = RQSR1000U0Dao.deleteGA01N101ByRctNo(GA01N101VO);		
			log.info("통합신청 삭제 (GA01N101) {} ",cnt);
			if(cnt == 0) {
		        throw new CustomBadRequestException("인감신청_인감날인신청 통합신청 삭제오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
			}
			
			// 2.명함신청 (GA03N104)
			cnt = RQNR1000U0Dao.deleteGA03N104ByRctNo(rctNo);
			log.info("명함신청 (GA03N104) {} ",cnt);
			if(cnt == 0) {
		        throw new CustomBadRequestException("명함신청 삭제오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
			}
			
			// 3.명함신청내역 (GA03N102)
			cnt = RQNR1000U0Dao.deleteGA03N102ByRctNo(rctNo);
			log.info("명함 신청내역 (GA03N102) {} ",cnt);
			if(cnt == 0) {
		        throw new CustomBadRequestException("명함신청내역 삭제오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
			}
			
			// 4.명함신청상세 (GA03N105)
			cnt = RQNR1000U0Dao.deleteGA03N105ByRctNo(rctNo);
			log.info("명함 신청상세(GA03N105) {} ",cnt);
			if(cnt == 0) {
		        throw new CustomBadRequestException("명함신청상세 삭제오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
			}
		}
		
		return cnt;
	}
	
}
