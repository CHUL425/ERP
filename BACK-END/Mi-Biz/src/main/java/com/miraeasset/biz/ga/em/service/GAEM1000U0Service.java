package com.miraeasset.biz.ga.em.service;

import java.util.List;

import com.miraeasset.biz.common.meta.vo.GA01N301VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In00VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In01VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In02VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In03VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In10VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In11VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In12VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In13VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In14VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out00VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out01VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out10VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out11VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out12VO;

public interface GAEM1000U0Service {

	/* 거래처 팝업 조회 */	
    List<GAEM1000U0Out10VO> selectAT05C010(GAEM1000U0In10VO vo);
    
	/* 업체관리 목록조회 */	
    List<GAEM1000U0Out00VO> selectListGA01N301(GAEM1000U0In00VO vo);    

	/* 업체관리 상세조회(PK) */	
    List<GAEM1000U0Out01VO> selectGA01N301PK(GAEM1000U0In01VO vo);    
    
	/* 업체관리 업체메모 내역조회 */	
    List<GAEM1000U0Out12VO> selectMemoInfo(GAEM1000U0In12VO vo);
    
	/* 업체관리 수정(PK) */	
    int updateGA01N301(GAEM1000U0In02VO vo);
    
	/* 업체관리 삭제(PK) */	
    int deleteGA01N301(GAEM1000U0In02VO vo);    
    
	/* 업체관리 업체메모 삭제수정(PK) */	
    int updateDelGA01N302(GAEM1000U0In14VO vo);    

	/* 업체관리 신규등록 */	
    int insertGA01N301(GAEM1000U0In03VO vo);

	/* 업체관리 업체메모 신규등록 */	
    int insertGA01N302(GAEM1000U0In13VO vo);
    
	/* 업체관리 업체계약현황조회 */
    List<GAEM1000U0Out11VO> selLstGA01N301ByDelpCd(GAEM1000U0In11VO vo);        
}
