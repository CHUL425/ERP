package com.miraeasset.biz.rq.pr.service;

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
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02InVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02OutVO;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.massage.MsgSenService;
import com.miraeasset.biz.rq.am.dao.RQAM1000U0Dao;
import com.miraeasset.biz.rq.nr.dao.RQNR2000U0Dao;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0In01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out02VO;
import com.miraeasset.biz.rq.pr.dao.RQPR2000U0Dao;
import com.miraeasset.biz.rq.pr.vo.RQPR2000U0In00VO;
import com.miraeasset.biz.rq.pr.vo.RQPR2000U0Out00VO;
import com.miraeasset.biz.rq.pr.vo.RQPR2000U0Out01VO;
import com.miraeasset.biz.rq.rr.dao.RQRR1000U0Dao;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;

@Service
@Transactional
public class RQPR2000U0ServiceImpl implements RQPR2000U0Service {

	@Autowired
	RQRR1000U0Dao RQRR1000U0Dao;
	
	@Autowired
	CodeDao CodeDao;
	
	@Autowired
	RQAM1000U0Dao rqamDao;	
	
	@Autowired
	MsgSenService msg;
	
	@Autowired
	RQNR2000U0Dao RQNR2000U0Dao;
	
	@Autowired
	RQPR2000U0Dao rqprDao;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "00"; // 임시저장 
	private final String CD_RQS_SCD_APV_ING  = "05"; // 승인중 
	private final String CD_RQS_SCD_APV_CMPN = "10"; // 승인완료 
	private final String CD_RQS_SCD_EMAL     = "15"; // 메일전송완료
	private final String CD_RQS_SCD_RTRN     = "30"; // 반려 
	private final String CD_RQS_SCD_WDRAL    = "35"; // 철회
	private final String CD_RQS_SCD_CMPN     = "99"; // 완료
	
	/* 구매신청내역-완료 */
	@Override
	public int rqsListCmpn(RQPR2000U0In00VO vo) {
		
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
			throw new CustomBadRequestException("구매신청 완료처리 대상건이 존재하지않습니다. 접수번호를 확인하세요["+chkvo.getRctNo()+"]", ErrorCode.BAD_REQUEST);					
		} else {
			RQRR1000U0VO rctNoVo = rctNoList.get(0);
			
			if(rctNoVo.getRqsScd() != null 
			&& (!rctNoVo.getRqsScd().equals(CD_RQS_SCD_APV_CMPN))) {
	            throw new CustomBadRequestException("구매신청 완료처리는 승인완료 상태일경우만 처리가능합니다. 신청상태를 확인하세요["+rctNoVo.getRqsScd()+"]["+rctNoVo.getRctNo()+"]", ErrorCode.BAD_REQUEST);					
			}
			
			sReceiveUserId = rctNoVo.getRqsEpno();
			sRctNo = rctNoVo.getRctNo();
			
			/* 구매신청 완료처리 */
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

	
	/* 구매신청내역 - 상세정보 조회 */
	@Override
	public RQPR2000U0Out00VO selectDlInfo(RQPR2000U0In00VO vo) {
		
		RQNR2000U0Out02VO rctNoRtnVo = new RQNR2000U0Out02VO();
		RQPR2000U0Out00VO rtnVo = new RQPR2000U0Out00VO();
		
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
			RQNR2000U0In01VO rctNoVo = new RQNR2000U0In01VO();
			rctNoVo.setRctNo(rctNo);
			rctNoRtnVo = RQNR2000U0Dao.selectDlInfo(rctNoVo);
			ObjectCopyUtil.copyFields(rctNoRtnVo, rtnVo);
			
			if(rctNoRtnVo == null) {
		        throw new CustomBadRequestException("통합신청 대상건이 존재하지않습니다. 접수번호를 확인하세요["+rctNo+"]", ErrorCode.BAD_REQUEST);						
			}
			
			List<RQPR2000U0Out01VO> listVo = rqprDao.selectListGA03N103Dtl(rctNo);
			rtnVo.setGridGA03N102(listVo);
		}
		return rtnVo;
	}


	@Override
	public List<RQPR2000U0Out01VO> selectListGA03N103Dtl(String rctNo) {
		List<RQPR2000U0Out01VO> listVo = rqprDao.selectListGA03N103Dtl(rctNo);
		return listVo;
	}
}
