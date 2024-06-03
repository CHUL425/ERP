/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS9000V0Service.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 판관비계정관리 Service
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
import com.miraeasset.biz.common.meta.vo.GA01C001VO;
import com.miraeasset.biz.common.util.aprvWrrpt.AprvWrrpt;
import com.miraeasset.biz.rq.sr.dao.RQSR1000U0Dao;
import com.miraeasset.biz.ss.bs.dao.SSBS9000V0Dao;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In02VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0Out02VO;

@Service
@Transactional
public class SSBS9000V0ServiceImpl implements SSBS9000V0Service {
	
	@Autowired
	SSBS9000V0Dao SSBS9000V0Dao;
	
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
		
	/* 판관비판관비계정과목관리 조회*/
	@Override
	public List<SSBS9000V0Out00VO> selectList00GA01C001(SSBS9000V0In00VO vo) {
		// TODO Auto-generated method stub
		return SSBS9000V0Dao.selectList00GA01C001(vo);
	}
	
	/* 판관비판관비계정과목관리 상세조회 */
	@Override
	public SSBS9000V0Out02VO selectGA01C001(SSBS9000V0In02VO vo) {
		// TODO Auto-generated method stub
		return SSBS9000V0Dao.selectGA01C001(vo);
	}
	
	/* 판관비판관비계정과목관리 신규등록 */	
	@Override
	public int insertGA01C001(SSBS9000V0In01VO vo) {
		String acsjCd = null ;  /*계정과목코드*/     
		String prjtNm = null;  /*프로젝트명  */  		
		
		int cnt = 0;
		int mCnt = 0;
		
		GA01C001VO GA01C001VO = null; /* 판관비계정과목관리 */
		List<GA01C001VO> gridGA01C001 = null;    /* 판관비계정과목관리 다건내역 */				
		
		// 전처리 : 입력값 체크
		{
			gridGA01C001 = vo.getGridGA01C001();
			if(gridGA01C001 != null && gridGA01C001.size() > 0) {
				for(int i=0;i<gridGA01C001.size();i++) {
					GA01C001VO = gridGA01C001.get(i);
					
					acsjCd = GA01C001VO.getAcsjCd();
					prjtNm = GA01C001VO.getPrjtNm();

					// 계정과목코드 필수 체크
					if(acsjCd == null || "".equals(acsjCd) ) {
				        throw new CustomBadRequestException("필수입력항목 판관비계정과목관리[계정과목코드] 오류. 입력값을 확인하세요["+acsjCd+"]", ErrorCode.BAD_REQUEST);		
					}
					// 프로젝트명 필수 체크
					if(prjtNm == null || "".equals(prjtNm) ) {
				        throw new CustomBadRequestException("필수입력항목 판관비계정과목관리[프로젝트명] 오류. 입력값을 확인하세요["+prjtNm+"]", ErrorCode.BAD_REQUEST);		
					}

				}
			}else {
		        throw new CustomBadRequestException("신규 대상이 존재하지않습니다. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);		
			
			}
		}

		// 신규등록 처리
		{
			
			for(int i=0;i<gridGA01C001.size();i++) {
				GA01C001VO = gridGA01C001.get(i);
				acsjCd = GA01C001VO.getAcsjCd();
				prjtNm = GA01C001VO.getPrjtNm();
				GA01C001VO.setOptrId(vo.getOptrId());
				GA01C001VO.setOprtChnlCd(vo.getOprtChnlCd());
				GA01C001VO.setOprtIpAdr(vo.getOprtIpAdr());
				GA01C001VO.setOprtOrzCd(vo.getOprtOrzCd());
				
				mCnt = SSBS9000V0Dao.insertGA01C001(GA01C001VO);
				if(mCnt <= 0 ){
			        throw new CustomBadRequestException("판관비계정과목관리 등록처리 내역을 확인하세요. ["+acsjCd+"]["+prjtNm+"]", ErrorCode.BAD_REQUEST);		
				}
				cnt++;				
			}

		}

		return cnt;
	}	       
	
	/* 판관비판관비계정과목관리 수정 */	
	@Override
	public int updateGA01C001(SSBS9000V0In03VO vo) {
		String acsjCd = null ;  /*계정과목코드*/     
		String prjtNm = null;  /*프로젝트명  */  		
		
		int cnt = 0;
		int mCnt = 0;
		
		GA01C001VO GA01C001VO = null; /* 판관비계정과목관리 */
		
		// 전처리 : 입력값 체크
		{
			acsjCd = vo.getAcsjCd();
			prjtNm = vo.getPrjtNm();
			
			// 계정과목코드 필수 체크
			if(acsjCd == null || "".equals(acsjCd) ) {
		        throw new CustomBadRequestException("필수입력항목 판관비계정과목관리[계정과목코드] 오류. 입력값을 확인하세요["+acsjCd+"]", ErrorCode.BAD_REQUEST);		
			}
			// 프로젝트명 필수 체크
			if(prjtNm == null || "".equals(prjtNm) ) {
		        throw new CustomBadRequestException("필수입력항목 판관비계정과목관리[프로젝트명] 오류. 입력값을 확인하세요["+prjtNm+"]", ErrorCode.BAD_REQUEST);		
			}
		}

		// 수정 처리
		{
			
			GA01C001VO = new GA01C001VO();
			GA01C001VO.setAcsjCd(acsjCd);
			GA01C001VO.setPrjtNm(prjtNm);
			
			//GA01C001VO.setOptrId(vo.getOptrId());
			//GA01C001VO.setOprtChnlCd(vo.getOprtChnlCd());
			//GA01C001VO.setOprtIpAdr(vo.getOprtIpAdr());
			//GA01C001VO.setOprtOrzCd(vo.getOprtOrzCd());
			
			cnt = SSBS9000V0Dao.updateGA01C001(GA01C001VO);
			if(cnt <= 0 ){
		        throw new CustomBadRequestException("판관비계정과목관리 수정 내역을 확인하세요. ["+acsjCd+"]["+prjtNm+"]", ErrorCode.BAD_REQUEST);		
			}

		}

		return cnt;
	}	           
	
	/* 판관비판관비계정과목관리 삭제 */	
	@Override
	public int deleteGA01C001(SSBS9000V0In01VO vo) {
		String acsjCd = null ;  /*계정과목코드*/     
		
		int cnt = 0;
		int mCnt = 0;
		
		GA01C001VO GA01C001VO = null; /* 판관비계정과목관리 */
		List<GA01C001VO> gridGA01C001 = null;    /* 판관비계정과목관리 다건내역 */				
		
		// 전처리 : 입력값 체크
		{
			gridGA01C001 = vo.getGridGA01C001();
			if(gridGA01C001 != null && gridGA01C001.size() > 0) {
				for(int i=0;i<gridGA01C001.size();i++) {
					GA01C001VO = gridGA01C001.get(i);
					
					acsjCd = GA01C001VO.getAcsjCd();

					// 계정과목코드 필수 체크
					if(acsjCd == null || "".equals(acsjCd) ) {
				        throw new CustomBadRequestException("필수입력항목 판관비계정과목관리[계정과목코드] 오류. 입력값을 확인하세요["+acsjCd+"]", ErrorCode.BAD_REQUEST);		
					}

				}
			}else {
		        throw new CustomBadRequestException("삭제 대상이 존재하지않습니다. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);		
			
			}
		}

		// 삭제처리
		{
			
			for(int i=0;i<gridGA01C001.size();i++) {
				GA01C001VO = gridGA01C001.get(i);
				acsjCd = GA01C001VO.getAcsjCd();
				
				mCnt = SSBS9000V0Dao.deleteGA01C001(GA01C001VO);
				if(mCnt <= 0 ){
			        throw new CustomBadRequestException("판관비계정과목관리 삭제처리 오류입니다. 내역을 확인하세요. ["+acsjCd+"]", ErrorCode.BAD_REQUEST);		
				}
				cnt++;				
			}

		}

		return cnt;
	}	
}
