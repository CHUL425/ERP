package com.miraeasset.biz.rq.am.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.rq.am.dao.RQAM2000V0Dao;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0In00VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0In01VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0In02VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0Out00VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0Out01VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0Out02VO;
import com.miraeasset.biz.rq.rr.dao.RQRR1000U0Dao;

@Service
@Transactional
public class RQAM2000V0ServiceImpl implements RQAM2000V0Service {
	
	@Autowired
	RQAM2000V0Dao RQAM2000V0Dao;

	private final Logger log = LoggerFactory.getLogger(this.getClass());	
	
	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "01"; // 임시저장 
	private final String CD_RQS_SCD_APV_ING  = "02"; // 승인중 
	private final String CD_RQS_SCD_APV_CMPN = "03"; // 승인완료 
	private final String CD_RQS_SCD_CMPN     = "04"; // 완료 
	private final String CD_RQS_SCD_RTRN     = "05"; // 반려/철회 	
	
	private final String APRV_SCD_01 = "01"; //접수
	private final String APRV_SCD_02 = "02"; //결재중
	private final String APRV_SCD_03 = "03"; //반려
	private final String APRV_SCD_04 = "04"; //승인
	
	private final String APRV_PCD_01 = "01"; //렌탈신청
	private final String APRV_PCD_02 = "02"; //구매등록
	 
	/* 일반신청 조회 */
	@Override
	public List<RQAM2000V0Out00VO> selList(RQAM2000V0In00VO vo) {
		// TODO Auto-generated method stub
		// 전처리 : 입력값 체크 
		{
			if( vo.getAprvEpno() == null || vo.getAprvEpno().equals("")) {
	            throw new CustomBadRequestException("입력항목을 확인하세요 결재자사원번호["+vo.getAprvEpno()+"]", ErrorCode.BAD_REQUEST);		
			}
			
			if( vo.getQryStrtDt() == null || vo.getQryStrtDt().equals("")) {
	            throw new CustomBadRequestException("입력항목을 확인하세요 조회시작일자["+vo.getQryStrtDt()+"]", ErrorCode.BAD_REQUEST);		
			}

			if( vo.getQryEndDt() == null || vo.getQryEndDt().equals("")) {
	            throw new CustomBadRequestException("입력항목을 확인하세요 조회종료일자["+vo.getQryEndDt()+"]", ErrorCode.BAD_REQUEST);		
			}
			
		}
		return RQAM2000V0Dao.selList(vo);
	}

	/* 승인현황 조회 */
	@Override
	public List<RQAM2000V0Out01VO> selectAprvPstt(RQAM2000V0In01VO vo) {
		// TODO Auto-generated method stub
		return RQAM2000V0Dao.selectAprvPstt(vo);
	}
	
	/* 결제상세내역-pk */
	@Override
	public List<RQAM2000V0Out02VO> selectAprvDtlInfo(RQAM2000V0In02VO vo){
		// TODO Auto-generated method stub
		return RQAM2000V0Dao.selectAprvDtlInfo(vo);
	}


}
