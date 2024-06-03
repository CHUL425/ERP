package com.miraeasset.biz.ga.cm.dao;

import java.util.List;

import com.miraeasset.biz.common.meta.vo.AT01C001VO;
import com.miraeasset.biz.common.meta.vo.AT09N401VO;
import com.miraeasset.biz.common.meta.vo.GA01N303VO;
import com.miraeasset.biz.common.meta.vo.GA01N304VO;
import com.miraeasset.biz.common.meta.vo.GA01N306VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In00VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In01VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In10VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out00VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out01VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out10VO;

public interface GACM1000U0Dao {

	/* 계약서관리 내역조회 */	
    List<GACM1000U0Out00VO> selectListGA01N303(GACM1000U0In00VO vo);
    
	/* 계약서별계정과목코드 내역조회 */	
    List<GA01N304VO> selectListGA01N304(GA01N304VO vo);
    
	/* 계약서별기안문서 내역조회 */	
    List<GA01N306VO> selectListGA01N306(GA01N306VO vo);
    
	/* 계약서관리 상세조회(PK) */	
    List<GACM1000U0Out01VO> selectGA01N303PK(GACM1000U0In01VO vo);
    
	/* 계약서별계정과목코드 상세조회(PK) */	
    List<GA01N304VO> selectGA01N304PK(GA01N304VO vo);    
    
	/* 계약서별기안문서 상세조회(PK) */	
    List<GA01N306VO> selectGA01N306PK(GA01N306VO vo);       
    
	/* 기안문서 상세조회(PK) */	
    List<AT09N401VO> selectAT09N401PK(AT09N401VO vo);    
        
	/* 계정과목코드 상세조회(PK) */	
    List<AT01C001VO> selectAT01C001PK(AT01C001VO vo);     
    
	/* 계약서관리 수정(PK) */	
    int updateGA01N303(GA01N303VO vo);
    
	/* 계약서관리 삭제수정(PK) */	
    int updateDelGA01N303(GA01N303VO vo);    

	/* 계약서관리 신규등록 */	
    int insertGA01N303(GA01N303VO vo);        
    
	/* 계약서별계정과목코드 신규등록 */	
    int insertGA01N304(GA01N304VO vo);      
    
	/* 계약서별기안문서 신규등록 */	
    int insertGA01N306(GA01N306VO vo);      
    
	/* 계약서별계정과목코드 삭제(부모키연계) */	
    int deleteGA01N304WithGA01N303(GA01N304VO vo);      

	/* 계약서별기안문서 삭제(부모키연계) */	
    int deleteGA01N306WithGA01N303(GA01N306VO vo); 
    
	/* 계약서관리 업체계약현황조회 */	
    List<GACM1000U0Out10VO> selLstGA01N303ByDelpCd(GACM1000U0In10VO vo);
    

}
