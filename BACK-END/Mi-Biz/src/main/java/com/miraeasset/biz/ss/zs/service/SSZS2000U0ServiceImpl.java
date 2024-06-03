/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: SSBS7000U0ServiceImpl.java
*	04. 작  성  일  자	: 2023.10.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹별 화면관리 ServiceImpl
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.zs.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.meta.vo.GA09N204VO;
import com.miraeasset.biz.common.meta.vo.GA09N501VO;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out01VO;
import com.miraeasset.biz.ss.zs.dao.SSZS2000U0Dao;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0In00VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0In01VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0In02VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0Out00VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0Out01VO;

@Service
@Transactional
public class SSZS2000U0ServiceImpl implements SSZS2000U0Service {
	
	@Autowired
	SSZS2000U0Dao SSZS2000U0Dao;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
		
	/* 알림관리 목록조회*/
	@Override
	public List<SSZS2000U0Out00VO> selectListGA09N501(SSZS2000U0In00VO vo) {
		// TODO Auto-generated method stub
		return SSZS2000U0Dao.selectListGA09N501(vo);
	}	
	
	/* 알림관리 상세조회 */
	@Override
	public SSZS2000U0Out01VO selectGA09N501(SSZS2000U0In01VO vo) {
		// TODO Auto-generated method stub
		GA09N501VO GA09N501VO = new GA09N501VO();
		SSZS2000U0Out01VO outVo = new SSZS2000U0Out01VO();
		// 입력 데이터 카피
		ObjectCopyUtil.copyFields(vo, GA09N501VO);	
		
		GA09N501VO = SSZS2000U0Dao.selectGA09N501(GA09N501VO);

		// 출력 데이터 카피
		ObjectCopyUtil.copyFields(GA09N501VO, outVo);	
		
		return outVo;
	}	
	
	/* 알림관리 신규등록 */	
	@Override
	public int insertGA09N501(SSZS2000U0In02VO vo) {
		// TODO Auto-generated method stub
		int cnt = 0;
		GA09N501VO GA09N501VO = null; /* 알림메시지코드 */
		String iprtMsgCd     = null;   /*알림메시지코드        */     
		String iprtMsgTtlNm  = null;   /*알림메시지제목명      */     
		String bzAreaTcd     = null;   /*업무영역구분코드      */     
		String msgSndCn      = null;   /*메시지발송내용        */     
		String useYn         = null;   /*사용여부              */     
		String sndHm         = null;   /*발송시분              */     
		String msgSndMdaTcd  = null;   /*메시지발송매체구분코드*/     
		String nteCn         = null;   /*비고내용              */   
		
		// 전처리 : 입력값 체크
		{
			iprtMsgCd = vo.getIprtMsgCd(); /* 알림메시지코드 */
			iprtMsgTtlNm  = vo.getIprtMsgTtlNm();   /*알림메시지제목명      */     
			bzAreaTcd     = vo.getBzAreaTcd();   /*업무영역구분코드      */     
			msgSndCn      = vo.getMsgSndCn();   /*메시지발송내용        */     
			useYn         = vo.getUseYn();   /*사용여부              */     
			sndHm         = vo.getSndHm();   /*발송시분              */     
			msgSndMdaTcd  = vo.getMsgSndMdaTcd();   /*메시지발송매체구분코드*/     
			nteCn         = vo.getNteCn();   /*비고내용              */
			
			
			if(iprtMsgCd == null || "".equals(iprtMsgCd) ) {
		        throw new CustomBadRequestException("필수입력항목 알림관리[알림메시지코드] 오류. 입력값을 확인하세요["+iprtMsgCd+"]", ErrorCode.BAD_REQUEST);		
			}
				
			if(iprtMsgTtlNm == null || "".equals(iprtMsgTtlNm) ) {
		        throw new CustomBadRequestException("필수입력항목 알림관리[알림메시지제목명] 오류. 입력값을 확인하세요["+iprtMsgTtlNm+"]", ErrorCode.BAD_REQUEST);		
			}
			
			if(useYn == null || "".equals(useYn) ) {
		        throw new CustomBadRequestException("필수입력항목 알림관리[사용여부] 오류. 입력값을 확인하세요["+useYn+"]", ErrorCode.BAD_REQUEST);		
			}
			
			if(sndHm != null && !"".equals(sndHm) ) {
				if(sndHm.trim().length() != 4) {
			        throw new CustomBadRequestException("정합성 검증 오류. 입력값을 발송시분은 4자리만 입력가능합니다. 입력값을 확인하세요["+sndHm+"]", ErrorCode.BAD_REQUEST);		
				}
				
				// 숫자형식 체크
				boolean chekYn = sndHm.trim().matches("\\d+");
				
				if(!chekYn) {
			        throw new CustomBadRequestException("정합성 검증 오류(숫자). 입력값을 확인하세요["+sndHm+"]", ErrorCode.BAD_REQUEST);		
				}
				
				// 시간분 형식 체크 (0000-2359)
				chekYn = sndHm.trim().matches("([01][0-9]|2[0-3])[0-5][0-9]");
				
				if(!chekYn) {
			        throw new CustomBadRequestException("정합성 검증 오류(시간분 형식 오류). 입력값을 확인하세요["+sndHm+"]", ErrorCode.BAD_REQUEST);		
				}
				
			}
			
			
			// 기등록 중복 체크
			{
				GA09N501VO = new GA09N501VO();
				ObjectCopyUtil.copyFields(vo, GA09N501VO);
				
				GA09N501VO = SSZS2000U0Dao.selectGA09N501(GA09N501VO);
				
				if(GA09N501VO != null) {
			        throw new CustomBadRequestException("신규등록 대상건이 이미 존재합니다. 입력값을 확인하세요["+iprtMsgCd+"]", ErrorCode.BAD_REQUEST);		
				}
			}

		}
		
		// 신규등록 처리
		{
			GA09N501VO = new GA09N501VO();
			ObjectCopyUtil.copyFields(vo, GA09N501VO);
			
			cnt = SSZS2000U0Dao.insertGA09N501(GA09N501VO);		
			
			if(cnt <= 0 ){
		        throw new CustomBadRequestException("알림관리 신규등록 오류. 입력값을 확인하세요["+GA09N501VO+"]", ErrorCode.BAD_REQUEST);		
			}			
		}
		

		return cnt;
	}	
    
	/* 알림관리 수정 */	
	@Override
	public int updateGA09N501(SSZS2000U0In02VO vo) {
		// TODO Auto-generated method stub
		int cnt = 0;
		GA09N501VO GA09N501VO = null; /* 알림메시지코드 */
		String iprtMsgCd     = null;   /*알림메시지코드        */     
		String iprtMsgTtlNm  = null;   /*알림메시지제목명      */     
		String bzAreaTcd     = null;   /*업무영역구분코드      */     
		String msgSndCn      = null;   /*메시지발송내용        */     
		String useYn         = null;   /*사용여부              */     
		String sndHm         = null;   /*발송시분              */     
		String msgSndMdaTcd  = null;   /*메시지발송매체구분코드*/     
		String nteCn         = null;   /*비고내용              */   
		
		// 전처리 : 입력값 체크
		{
			iprtMsgCd = vo.getIprtMsgCd(); /* 알림메시지코드 */
			iprtMsgTtlNm  = vo.getIprtMsgTtlNm();   /*알림메시지제목명      */     
			bzAreaTcd     = vo.getBzAreaTcd();   /*업무영역구분코드      */     
			msgSndCn      = vo.getMsgSndCn();   /*메시지발송내용        */     
			useYn         = vo.getUseYn();   /*사용여부              */     
			sndHm         = vo.getSndHm();   /*발송시분              */     
			msgSndMdaTcd  = vo.getMsgSndMdaTcd();   /*메시지발송매체구분코드*/     
			nteCn         = vo.getNteCn();   /*비고내용              */
			
			
			if(iprtMsgCd == null || "".equals(iprtMsgCd) ) {
		        throw new CustomBadRequestException("필수입력항목 알림관리[알림메시지코드] 오류. 입력값을 확인하세요["+iprtMsgCd+"]", ErrorCode.BAD_REQUEST);		
			}
				
			if(iprtMsgTtlNm == null || "".equals(iprtMsgTtlNm) ) {
		        throw new CustomBadRequestException("필수입력항목 알림관리[알림메시지제목명] 오류. 입력값을 확인하세요["+iprtMsgTtlNm+"]", ErrorCode.BAD_REQUEST);		
			}
			
			if(useYn == null || "".equals(useYn) ) {
		        throw new CustomBadRequestException("필수입력항목 알림관리[사용여부] 오류. 입력값을 확인하세요["+useYn+"]", ErrorCode.BAD_REQUEST);		
			}
			
			if(sndHm != null && !"".equals(sndHm) ) {
				if(sndHm.trim().length() != 4) {
			        throw new CustomBadRequestException("정합성 검증 오류. 입력값을 발송시분은 4자리만 입력가능합니다. 입력값을 확인하세요["+sndHm+"]", ErrorCode.BAD_REQUEST);		
				}
				
				// 숫자형식 체크
				boolean chekYn = sndHm.trim().matches("\\d+");
				
				if(!chekYn) {
			        throw new CustomBadRequestException("정합성 검증 오류(숫자). 입력값을 확인하세요["+sndHm+"]", ErrorCode.BAD_REQUEST);		
				}
				
				// 시간분 형식 체크 (0000-2359)
				chekYn = sndHm.trim().matches("([01][0-9]|2[0-3])[0-5][0-9]");
				
				if(!chekYn) {
			        throw new CustomBadRequestException("정합성 검증 오류(시간분 형식 오류). 입력값을 확인하세요["+sndHm+"]", ErrorCode.BAD_REQUEST);		
				}
				
			}
			
			// 기등록 중복 체크
			{
				GA09N501VO = new GA09N501VO();
				ObjectCopyUtil.copyFields(vo, GA09N501VO);
				
				GA09N501VO = SSZS2000U0Dao.selectGA09N501(GA09N501VO);
				
				if(GA09N501VO == null) {
			        throw new CustomBadRequestException("수정 대상건이 존재하지 않습니다. 입력값을 확인하세요["+iprtMsgCd+"]", ErrorCode.BAD_REQUEST);		
				}
			}

		}
		
		// 신규등록 처리
		{
			GA09N501VO = new GA09N501VO();
			ObjectCopyUtil.copyFields(vo, GA09N501VO);
			
			cnt = SSZS2000U0Dao.updateGA09N501(GA09N501VO);	
			
			if(cnt <= 0 ){
		        throw new CustomBadRequestException("알림관리 수정처리 오류. 입력값을 확인하세요["+GA09N501VO+"]", ErrorCode.BAD_REQUEST);		
			}			
		}
		

		return cnt;	
	}	  
	
	/* 알림관리 삭제 */	
	@Override
	public int deleteGA09N501(SSZS2000U0In01VO vo) {
		// TODO Auto-generated method stub
		int cnt = 0;
		GA09N501VO GA09N501VO = null; /* 알림메시지코드 */
		String iprtMsgCd     = null;   /*알림메시지코드        */     

		// 전처리 : 입력값 체크
		{
			iprtMsgCd = vo.getIprtMsgCd(); /* 알림메시지코드 */

			
			if(iprtMsgCd == null || "".equals(iprtMsgCd) ) {
		        throw new CustomBadRequestException("필수입력항목 알림관리[알림메시지코드] 오류. 입력값을 확인하세요["+iprtMsgCd+"]", ErrorCode.BAD_REQUEST);		
			}
				
			
			// 기등록 체크
			{
				GA09N501VO = new GA09N501VO();
				ObjectCopyUtil.copyFields(vo, GA09N501VO);
				
				GA09N501VO = SSZS2000U0Dao.selectGA09N501(GA09N501VO);
				
				if(GA09N501VO == null) {
			        throw new CustomBadRequestException("삭제 대상건이 존재하지 않습니다. 입력값을 확인하세요["+iprtMsgCd+"]", ErrorCode.BAD_REQUEST);		
				}
			}

		}
		
		// 삭제 처리
		{
			GA09N501VO = new GA09N501VO();
			ObjectCopyUtil.copyFields(vo, GA09N501VO);
			
			cnt = SSZS2000U0Dao.deleteGA09N501(GA09N501VO);	
			
			if(cnt <= 0 ){
		        throw new CustomBadRequestException("알림관리 삭제처리 오류. 입력값을 확인하세요["+GA09N501VO+"]", ErrorCode.BAD_REQUEST);		
			}			
		}

		return cnt;	
	}	  		

}
