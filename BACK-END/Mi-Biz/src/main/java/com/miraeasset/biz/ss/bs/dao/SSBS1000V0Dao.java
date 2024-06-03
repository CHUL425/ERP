package com.miraeasset.biz.ss.bs.dao;

import java.util.List;

import com.miraeasset.biz.common.meta.vo.GA01C001VO;
import com.miraeasset.biz.common.meta.vo.GA09N200VO;
import com.miraeasset.biz.common.meta.vo.GA09N201VO;
import com.miraeasset.biz.common.meta.vo.GA09N203VO;
import com.miraeasset.biz.common.meta.vo.GA09N204VO;
import com.miraeasset.biz.common.meta.vo.GA09N205VO;
import com.miraeasset.biz.common.meta.vo.GA09N208VO;
import com.miraeasset.biz.common.meta.vo.GA09N209VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In11VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0Out00VO;


public interface SSBS1000V0Dao {
	
	/* 사용자그룹 조회*/
	List<SSBS6000U0Out00VO> selectListGA09N200(SSBS6000U0In00VO vo);
	
	/* 사용자그룹 상세조회*/
	SSBS6000U0Out01VO selectGA09N200(SSBS6000U0In01VO vo);	
	
	/* 사용자그룹 신규등록 */	
    int insertGA09N200(GA09N200VO vo);    
		
	/* 사용자그룹 수정 */	
    int updateGA09N200(GA09N200VO vo);    

	/* 사용자그룹 삭제 */	
    int deleteGA09N200(GA09N200VO vo);    

	/* 사용자그룹_화면 목록조회*/
	List<SSBS7000U0Out00VO> selectListGA09N205(SSBS7000U0In00VO vo);
    
	/* 사용자그룹_화면 정상건 목록조회*/
	List<SSBS7000U0Out00VO> selectListGA09N205ByNrml(SSBS7000U0In11VO vo);
	
	/* 사용자그룹_화면 상세조회 PK */
	GA09N205VO selectGA09N205Pk(GA09N205VO vo);
	
	/* 사용자그룹_화면 신규등록 */	
    int insertGA09N205(GA09N205VO vo);    
		
	/* 사용자그룹_화면 수정 */	
    int updateGA09N205(GA09N205VO vo);    	
    

    /* 화면관리 목록조회*/
	List<SSBS5000U0Out00VO> selectListGA09N204(SSBS5000U0In00VO vo);
	
    /* 화면관리 상세조회PK*/
	GA09N204VO selectGA09N204PK(GA09N204VO vo);
	
	/* 화면관리 신규등록 */	
    int insertGA09N204(GA09N204VO vo);    
		
	/* 화면관리 수정 */	
    int updateGA09N204(GA09N204VO vo);    	
    
	/* 화면관리 삭제 */	
    int deleteGA09N204(GA09N204VO vo);    	
        
    /* 화면_담당사원 목록조회 화면ID 기준*/
	List<GA09N209VO> selectListGA09N209ByMenuId(GA09N209VO vo);

	/* 화면_담당사원 신규등록 */	
    int insertGA09N209(GA09N209VO vo);
    
	/* 화면_담당사원 삭제 화면ID 기준 */	
    int deleteGA09N209ByMenuId(GA09N209VO vo);    	
    
    
    /* 사용자그룹별 사용자관리 목록조회 */
	List<SSBS7100U0Out00VO> selectListGA09N201(SSBS7100U0In00VO vo);

    /* 사용자그룹별 사용자관리 정상기등록건 목록조회 */
	List<SSBS7100U0Out00VO> selectListGA09N201ByNrml(SSBS7100U0In00VO vo);
	
    /* 사용자그룹별 사용자관리 상세조회 PK */
	GA09N201VO selectGA09N201PK(GA09N201VO vo);
	
	/* 사용자그룹별 사용자 신규등록 */	
    int insertGA09N201(GA09N201VO vo);
    
	/* 사용자그룹별 사용자 수정 */	
    int updateGA09N201(GA09N201VO vo);       


    /* 화면_검색키워드 내역조회  */
	List<GA09N208VO> selectListGA09N208VOByMenuId(GA09N208VO vo);    
    /* 화면_검색키워드 신규등록*/
    int insertGA09N208(GA09N208VO vo);
    /* 화면_검색키워드 삭제*/
    int deleteGA09N208(GA09N208VO vo);
    /* 화면_검색키워드 삭제(화면id기준)*/
    int deleteGA09N208ByMenuId(GA09N208VO vo);

}