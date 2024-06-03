package com.miraeasset.biz.ga.pm.dao;

import java.util.List;

import com.miraeasset.biz.common.meta.vo.GA01N203VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In00VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In01VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out00VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out01VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out11VO;

public interface GAPM1000U0Dao {

	/* 정기주차권관리 목록조회 */	
    List<GAPM1000U0Out00VO> selectListGA01N203(GAPM1000U0In00VO vo);

	/* 정기주차권관리 상세정보조회(PK) */	
    List<GAPM1000U0Out01VO> selectGA01N203PK(GAPM1000U0In01VO vo);
    
	/* 정기주차권관리 주차대수요약정보 */	
    List<GAPM1000U0Out11VO> selectParkCntInfo();
 
	/* 정기주차권관리 수정(PK) */	
    int updateGA01N203(GA01N203VO vo);

	/* 정기주차권관리 삭제 */	
    int deleteGA01N203(GA01N203VO vo);

	/* 정기주차권관리 신규등록 */	
    int insertGA01N203(GA01N203VO vo);

    /* [2023-09-06] 전체 DELETE 후 INSERT로 변경 요청 */
    int deleteAllGA01N203();
}
