package com.miraeasset.biz.ga.pm.service;

import java.util.List;
import java.util.Map;

import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In00VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In01VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In02VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In03VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In10VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out00VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out01VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out10VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out11VO;

public interface GAPM1000U0Service {

	/* 정기주차권관리 목록조회 */	
    List<GAPM1000U0Out00VO> selectListGA01N203(GAPM1000U0In00VO vo);

	/* 정기주차권관리 상세정보조회(PK) */	
    List<GAPM1000U0Out01VO> selectGA01N203PK(GAPM1000U0In01VO vo);    
    
	/* 정기주차권관리 수정(PK) */	
    int updateGA01N203(GAPM1000U0In02VO vo);
    
	/* 정기주차권관리 삭제 */	
    int deleteGA01N203(GAPM1000U0In02VO vo);
    
	/* 정기주차권관리 신규등록 */	
    int insertGA01N203(GAPM1000U0In03VO vo);   
    
	/* 정기주차권관리 유무료주차대수조회  */	
    List<GAPM1000U0Out10VO> selectParkCnt();      

	/* 정기주차권관리 주차대수요약정보 */	
    List<GAPM1000U0Out11VO> selectParkCntInfo();    
    
	/* 정기주차권관리 유무료주차대수 수정 */	
    int updateParkCnt(GAPM1000U0In10VO vo);    
    
	/* 정기주차권관리 엑셀업로드 */
	int excelUpload(List<Map<String, Object>> list);        
	
    
}
