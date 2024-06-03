/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS6000U0ServiceImpl.java
*	04. 작  성  일  자	: 2023.10.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹관리 ServiceImpl
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.dao.CommonDao;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.meta.vo.GA09N200VO;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.aprvWrrpt.AprvWrrpt;
import com.miraeasset.biz.rq.sr.dao.RQSR1000U0Dao;
import com.miraeasset.biz.ss.bs.dao.SSBS6000U0Dao;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In02VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out01VO;

@Service
@Transactional
public class SSBS6000U0ServiceImpl implements SSBS6000U0Service {
	
	@Autowired
	SSBS6000U0Dao SSBS6000U0Dao;
	
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
		return SSBS6000U0Dao.selectListGA09N200(vo);
	}
		
	/* 사용자그룹 상세조회*/
	@Override
	public SSBS6000U0Out01VO selectGA09N200(SSBS6000U0In01VO vo) {
		// TODO Auto-generated method stub
		return SSBS6000U0Dao.selectGA09N200(vo);
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
			SSBS6000U0Out01VO = SSBS6000U0Dao.selectGA09N200(SSBS6000U0In01VO);
			
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
			
			cnt = SSBS6000U0Dao.insertGA09N200(GA09N200VO);
			
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
			SSBS6000U0Out01VO = SSBS6000U0Dao.selectGA09N200(SSBS6000U0In01VO);
			
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
			
			cnt = SSBS6000U0Dao.updateGA09N200(GA09N200VO);
			
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

			SSBS6000U0Out01VO = SSBS6000U0Dao.selectGA09N200(vo);
			
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
			
			cnt = SSBS6000U0Dao.deleteGA09N200(GA09N200VO);
			
			if(cnt == 0) {
		        throw new CustomBadRequestException("사용자그룹관리 삭제처리오류. 입력값을 확인하세요["+vo.getUserGrpCd()+"]", ErrorCode.BAD_REQUEST);		
			}			
		}

		return cnt;
	}		     
	

 
	
}
