package com.miraeasset.biz.bn.gn.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.bn.gn.dao.BNGN1000U0Dao;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0In00VO;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0In01VO;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0In02VO;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0Out00VO;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0Out01VO;
import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.dao.CommonDao;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.meta.vo.GA09N411VO;
import com.miraeasset.biz.common.meta.vo.GA09N421VO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.ga.cm.dao.GACM1000U0Dao;
import com.miraeasset.biz.ga.em.dao.GAEM1000U0Dao;

@Service
@Transactional
public class BNGN1000U0ServiceImpl implements BNGN1000U0Service {

	@Autowired
	BNGN1000U0Dao BNGN1000U0Dao;
	@Autowired
	CommonDao commonDao;
			
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/* CNRT_KCD 코드값 정의 */
	private final String CD_CNRT_KCD_CM  = "01"; // 계약서관리 
	private final String CD_CNRT_KCD_SM  = "02"; // ESG(RE100) 
	
	/* APRV_PCD 코드값 정의 */
	private final String CD_APRV_PCD_RENT  = "01"; // 렌탈신청 
	private final String CD_APRV_PCD_PCH   = "02"; // 구매신청 
	
	/* APRV_SCD 코드값 정의 */
	private final String CD_APRV_SCD_RCT   = "01"; // 접수 
	private final String CD_APRV_SCD_APRVING  = "02"; // 결재중 
	private final String CD_APRV_SCD_RTRN  = "03"; // 반려
	private final String CD_APRV_SCD_APV   = "04"; // 승인완료 

	/* APRV_RTRN_TCD  코드값 정의 */
	private final String CD_APRV_RTRN_TCD_RCT   = "1"; // 접수/승인 
	private final String CD_APRV_RTRN_TCD_RTRN  = "2"; // 반려 
	private final String CD_APRV_RTRN_TCD_REF   = "3"; // 참조 
	
	/* DCFC_PCD  코드값 정의 */
	private final String CD_DCFC_PCD_APRV  = "01"; // 결재 
	private final String CD_DCFC_PCD_REF   = "02"; // 참조 
	
	/* APRV_WRRPT_TCD   코드값 정의 */
	private final String APRV_WRRPT_TCD_DRWR  = "0"; // 작성자 	
	private final String APRV_WRRPT_TCD_DCFC  = "1"; // 결제자 	
	private final String APRV_WRRPT_TCD_RCTR  = "2"; // 접수자 	
	private final String APRV_WRRPT_TCD_STDY  = "3"; // 검토자 	
	private final String APRV_WRRPT_TCD_APVR  = "4"; // 승인자
	
	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "01"; // 임시저장 
	private final String CD_RQS_SCD_APV_ING  = "02"; // 승인중 
	private final String CD_RQS_SCD_APV_CMPN = "03"; // 승인완료 
	private final String CD_RQS_SCD_CMPN     = "04"; // 완료 
	private final String CD_RQS_SCD_RTRN     = "05"; // 반려
	private final String CD_RQS_SCD_WDRAL    = "06"; // 철회
	

	/* 총무공지 내역조회 */
	@Override
	public List<BNGN1000U0Out00VO> selectListGA09N421(BNGN1000U0In00VO vo) {
	    List<BNGN1000U0Out00VO> outListVo = (List<BNGN1000U0Out00VO>) new ArrayList();	 
	    List<BNGN1000U0Out00VO> outDataList = BNGN1000U0Dao.selectListGA09N421(vo);
	    BNGN1000U0Out00VO outVo = null;
	    
	    // 첨부파일 
		GA09N411VO GA09N411VO = null;
	    List<GA09N411VO> gridGA09N411 = null;    // 파일 다건내역	
	    
	    // 첨부파일 리스트 세팅
	    for(int i=0;i<outDataList.size();i++) {
	    	outVo = outDataList.get(i);
		    
		    // 파일 내역 조회
		    if(outVo !=null && outVo.getFileNo() != null && !"".equals(outVo.getFileNo())) {
		    	GA09N411VO = new GA09N411VO();
		    	GA09N411VO.setFileNo(outVo.getFileNo());
		    	gridGA09N411 = commonDao.selectListGA09N411(GA09N411VO);
		    	outVo.setGridGA09N411(gridGA09N411);
		    }
		    outListVo.add(outVo);
	    }
	    
		return outListVo;
	}	
	
	/* 총무공지 상세조회(PK) */
	@Override
	public BNGN1000U0Out01VO selectGA09N421PK(BNGN1000U0In01VO vo) {

		GA09N411VO GA09N411VO = null;
	    List<GA09N411VO> gridGA09N411 = null;    // 파일 다건내역		
		
	    // 총무공지 상세조회
	    BNGN1000U0Out01VO outVo = BNGN1000U0Dao.selectGA09N421PK(vo);
	    
	    // 파일 내역 조회
	    if(outVo !=null && outVo.getFileNo() != null && !"".equals(outVo.getFileNo())) {
	    	GA09N411VO = new GA09N411VO();
	    	GA09N411VO.setFileNo(outVo.getFileNo());
	    	gridGA09N411 = commonDao.selectListGA09N411(GA09N411VO);
	    	outVo.setGridGA09N411(gridGA09N411);
	    }
	    
	    // 조회수 증가
	    {
	    	GA09N421VO GA09N421VO = new GA09N421VO();
			ObjectCopyUtil.copyFields(vo, GA09N421VO);
		    int cnt = BNGN1000U0Dao.updateQryCnt(GA09N421VO); 
	    }

	    
		return outVo;
	}		
	
	/* 총무공지 신규/수정(PK) */
	@Override
	public int updateGA09N421(BNGN1000U0In02VO vo) {

		int cnt = 0;
		GA09N421VO GA09N421VO = new GA09N421VO(); 
		String regiDt = DateUtil.getTodayString("yyyyMMdd");	
		BigDecimal srno = new BigDecimal("0");
		
		// 전처리 : 입력값 체크
		{
			if(vo.getMadeEpno()== null || vo.getMadeEpno().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[작성자입력] 오류. 입력값을 확인하세요["+vo.getMadeEpno()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getTtlNm()== null || vo.getTtlNm().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[제목입력] 오류. 입력값을 확인하세요["+vo.getTtlNm()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getCmklPtcrCn()== null || vo.getCmklPtcrCn().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[내용입력] 오류. 입력값을 확인하세요["+vo.getCmklPtcrCn()+"]", ErrorCode.BAD_REQUEST);		
			}			
			if(vo.getPstgFxdYn()== null || vo.getPstgFxdYn().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[게시물고정여부] 오류. 입력값을 확인하세요["+vo.getPstgFxdYn()+"]", ErrorCode.BAD_REQUEST);		
			}	
			
			// 공지구분코드 정합성체크
			if (!Arrays.asList("01","02").contains(vo.getCmklTcd())) {
		        throw new CustomBadRequestException("정합성 체크오류. 공지구분코드는 01,02 만 입력가능합니다. 입력값을 확인하세요 ["+vo.getCmklTcd()+"]", ErrorCode.BAD_REQUEST);								
			}
			
			// 정합성체크
			if (!Arrays.asList("0","1").contains(vo.getPstgFxdYn())) {
		        throw new CustomBadRequestException("정합성 체크오류. 여부 항목은 [0,1] 만 입력가능합니다. 입력값을 확인하세요 getPstgFxdYn["+vo.getPstgFxdYn()+"]", ErrorCode.BAD_REQUEST);								
			}			
			// 정합성체크
			if (vo.getCsSptTmlIprtYn() !=null && !Arrays.asList("0","1").contains(vo.getCsSptTmlIprtYn())) {
		        throw new CustomBadRequestException("정합성 체크오류. 여부 항목은 [0,1] 만 입력가능합니다. 입력값을 확인하세요 getCsSptTmlIprtYn ["+vo.getCsSptTmlIprtYn()+"]", ErrorCode.BAD_REQUEST);								
			}				
			// 정합성체크
			if (vo.getWmTmlIprtYn() !=null && !Arrays.asList("0","1").contains(vo.getWmTmlIprtYn())) {
		        throw new CustomBadRequestException("정합성 체크오류. 여부 항목은 [0,1] 만 입력가능합니다. 입력값을 확인하세요 getWmTmlIprtYn["+vo.getWmTmlIprtYn()+"]", ErrorCode.BAD_REQUEST);								
			}				
			// 정합성체크
			if (vo.getBrmgIprtYn() !=null && !Arrays.asList("0","1").contains(vo.getBrmgIprtYn())) {
		        throw new CustomBadRequestException("정합성 체크오류. 여부 항목은 [0,1] 만 입력가능합니다. 입력값을 확인하세요 getBrmgIprtYn["+vo.getBrmgIprtYn()+"]", ErrorCode.BAD_REQUEST);								
			}	
			// 정합성체크
			if (vo.getBrIprtYn() !=null && !Arrays.asList("0","1").contains(vo.getBrIprtYn())) {
		        throw new CustomBadRequestException("정합성 체크오류. 여부 항목은 [0,1] 만 입력가능합니다. 입력값을 확인하세요 getBrIprtYn["+vo.getBrIprtYn()+"]", ErrorCode.BAD_REQUEST);								
			}				
			// 정합성체크
			if (vo.getTmlIprtYn() !=null && !Arrays.asList("0","1").contains(vo.getTmlIprtYn())) {
		        throw new CustomBadRequestException("정합성 체크오류. 여부 항목은 [0,1] 만 입력가능합니다. 입력값을 확인하세요 getTmlIprtYn["+vo.getTmlIprtYn()+"]", ErrorCode.BAD_REQUEST);								
			}				
			// 정합성체크
			if (vo.getHqmgIprtYn() !=null && !Arrays.asList("0","1").contains(vo.getHqmgIprtYn())) {
		        throw new CustomBadRequestException("정합성 체크오류. 여부 항목은 [0,1] 만 입력가능합니다. 입력값을 확인하세요 getTmlIprtYn["+vo.getHqmgIprtYn()+"]", ErrorCode.BAD_REQUEST);								
			}				
			// 정합성체크
			if (vo.getHoIprtYn() !=null && !Arrays.asList("0","1").contains(vo.getHoIprtYn())) {
		        throw new CustomBadRequestException("정합성 체크오류. 여부 항목은 [0,1] 만 입력가능합니다. 입력값을 확인하세요 getTmlIprtYn["+vo.getHoIprtYn()+"]", ErrorCode.BAD_REQUEST);								
			}				
		
			
			ObjectCopyUtil.copyFields(vo, GA09N421VO);
			
			if(vo.getMadeDt() !=null && !vo.getMadeDt().equals("") && vo.getSrno() != null && vo.getSrno().compareTo(BigDecimal.ZERO) > 0) {
				/* 총무공지 상세조회(PK) */
				BNGN1000U0In01VO inVo = new BNGN1000U0In01VO();
				ObjectCopyUtil.copyFields(GA09N421VO, inVo);
				BNGN1000U0Out01VO outVo = BNGN1000U0Dao.selectGA09N421PK(inVo);
				
				GA09N421VO.setDelYn(outVo.getDelYn());
				GA09N421VO.setQryCnt(outVo.getQryCnt());
				
				if(outVo == null) {
		            throw new CustomBadRequestException("변경할 대상건이 없습니다2. 입력항목을 확인하세요["+inVo.getMadeDt()+"]["+inVo.getSrno()+"]", ErrorCode.BAD_REQUEST);	
				}
			}else {
				// 신규 세팅
				GA09N421VO.setMadeDt(regiDt);
				srno = BNGN1000U0Dao.selectNewSrno(GA09N421VO);
				GA09N421VO.setSrno(srno);
				GA09N421VO.setDelYn("0");
				GA09N421VO.setQryCnt(BigDecimal.ZERO);
			}
			
		}
		
		// 신규/수정 처리
		{
			cnt = BNGN1000U0Dao.updateGA09N421(GA09N421VO);
		}
		
		return cnt;
	}		
	
	/* 총무공지 삭제수정 */	
	@Override
	public int updateDelGA09N421(BNGN1000U0In01VO vo) {

		int cnt = 0;
		GA09N421VO GA09N421VO = new GA09N421VO(); 
		
		// 전처리 : 입력값 체크
		{
			if(vo.getMadeDt()== null || vo.getMadeDt().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[작성일자] 오류. 입력값을 확인하세요["+vo.getMadeDt()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getSrno() == null || vo.getSrno().compareTo(BigDecimal.ZERO) <= 0 ) {
		        throw new CustomBadRequestException("필수입력항목[일련번호] 오류. 입력값을 확인하세요["+vo.getSrno()+"]", ErrorCode.BAD_REQUEST);		
			}
			ObjectCopyUtil.copyFields(vo, GA09N421VO);
			
			if(vo.getMadeDt() !=null && !vo.getMadeDt().equals("") && vo.getSrno() != null && vo.getSrno().compareTo(BigDecimal.ZERO) > 0) {
				/* 총무공지 상세조회(PK) */
				BNGN1000U0In01VO inVo = new BNGN1000U0In01VO();
				ObjectCopyUtil.copyFields(GA09N421VO, inVo);
				BNGN1000U0Out01VO outVo = BNGN1000U0Dao.selectGA09N421PK(inVo);
				
				if(outVo == null) {
		            throw new CustomBadRequestException("삭제할 대상건이 없습니다2. 입력항목을 확인하세요["+inVo.getMadeDt()+"]["+inVo.getSrno()+"]", ErrorCode.BAD_REQUEST);	
				}
			}
		}
		
		// 삭제 처리
		{
			// 삭제 세팅
			GA09N421VO.setDelYn("1");
			cnt = BNGN1000U0Dao.updateDelGA09N421(GA09N421VO);
		}
		
		return cnt;
	}		
    
}
