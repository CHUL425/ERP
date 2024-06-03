package com.miraeasset.biz.ga.em.dao;

import java.util.List;

import com.miraeasset.biz.common.meta.vo.GA01N301VO;
import com.miraeasset.biz.common.meta.vo.GA01N302VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In00VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In01VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In10VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In11VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out00VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out01VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out10VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out11VO;

public interface GAEM1000U0Dao {

	/* 거래처 팝업 조회 */	
    List<GAEM1000U0Out10VO> selectAT05C010(GAEM1000U0In10VO vo);

	/* 업체관리 목록조회 */	
    List<GAEM1000U0Out00VO> selectListGA01N301(GAEM1000U0In00VO vo);
    
	/* 업체관리 상세조회(PK) */	
    List<GAEM1000U0Out01VO> selectGA01N301PK(GAEM1000U0In01VO vo);

	/* 업체관리 업체메모목록조회 */	
    List<GA01N302VO> selLstGA01N302ByDelpCd(GA01N302VO vo);
    
	/* 업체관리 수정(PK) */	
    int updateGA01N301(GA01N301VO vo);
    
	/* 업체관리 삭제(PK) */	
    int deleteGA01N301(GA01N301VO vo);
    
	/* 업체관리 업체별메모 삭제수정(PK)  */	
    int updateDelGA01N302(GA01N302VO vo);
    
	/* 업체관리 신규등록 */	
    int insertGA01N301(GA01N301VO vo);
    
	/* 업체관리 업체별메모 신규등록  */	
    int insertGA01N302(GA01N302VO vo);
    
	/* 업체관리 업체계약현황조회 */
    List<GAEM1000U0Out11VO> selLstGA01N301ByDelpCd(GAEM1000U0In11VO vo);    
    
}
