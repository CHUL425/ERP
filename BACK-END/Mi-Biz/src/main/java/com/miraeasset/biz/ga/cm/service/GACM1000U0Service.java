package com.miraeasset.biz.ga.cm.service;

import java.util.List;

import com.miraeasset.biz.ga.cm.vo.GACM1000U0In00VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In01VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In02VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In03VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In04VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In10VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In11VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out00VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out01VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out10VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out11VO;

public interface GACM1000U0Service {

	/* 계약서관리 내역조회 */	
    List<GACM1000U0Out00VO> selectListGA01N303(GACM1000U0In00VO vo);
    
	/* 계약서관리 상세조회(PK) */	
    List<GACM1000U0Out01VO> selectGA01N303PK(GACM1000U0In01VO vo);

	/* 계약서관리 기안문서내역조회 */	
    List<GACM1000U0Out11VO> selectListGA01N306(GACM1000U0In11VO vo);
    
	/* 계약서관리 수정(PK) */	
    int updateGA01N303(GACM1000U0In02VO vo);
    
	/* 계약서관리 삭제수정(PK) */	
    int updateDelGA01N303(GACM1000U0In04VO vo);      
    
	/* 계약서관리 신규등록 */	
    int insertGA01N303(GACM1000U0In03VO vo);       

	/* 계약서관리 업체계약현황조회 */	
    List<GACM1000U0Out10VO> selLstGA01N303ByDelpCd(GACM1000U0In10VO vo);
    
    

    
}
