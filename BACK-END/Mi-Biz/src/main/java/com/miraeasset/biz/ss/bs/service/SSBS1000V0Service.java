package com.miraeasset.biz.ss.bs.service;

import java.util.List;

import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In02VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In02VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In04VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In11VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0In04VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0Out00VO;

public interface SSBS1000V0Service {
	
	/* 사용자그룹 조회*/
	List<SSBS6000U0Out00VO> selectListGA09N200(SSBS6000U0In00VO vo);    
	
	/* 사용자그룹 상세조회*/
	SSBS6000U0Out01VO selectGA09N200(SSBS6000U0In01VO vo);      

	/* 사용자그룹 신규등록 */	
    int insertGA09N200(SSBS6000U0In02VO vo);    
		
	/* 사용자그룹 수정 */	
    int updaeGA09N200(SSBS6000U0In02VO vo);    

	/* 사용자그룹 삭제 */	
    int deleteGA09N200(SSBS6000U0In01VO vo);    
    
	/* 사용자그룹_화면 목록조회*/
	List<SSBS7000U0Out00VO> selectListGA09N205(SSBS7000U0In00VO vo);    
	
	/* 사용자그룹_화면 상세조회*/
	SSBS7000U0Out01VO selectGA09N205Pk(SSBS7000U0In01VO vo);    

	/* 사용자그룹_화면 정상건 목록조회*/
	List<SSBS7000U0Out00VO> selectListGA09N205ByNrml(SSBS7000U0In11VO vo);

	/* 사용자그룹_화면 임시저장(수정)/상신 다건 */	
    String reqRegiListGA09N205(SSBS7000U0In03VO vo);
    
	/* 사용자그룹_화면 임시저장(수정)/상신 단건 */	
    String reqRegiGA09N205(SSBS7000U0In04VO vo);    
    
    /* 화면관리 목록조회*/
	List<SSBS5000U0Out00VO> selectListGA09N204(SSBS5000U0In00VO vo);
	
    /* 화면관리 상세조회*/
	SSBS5000U0Out01VO selectGA09N204(SSBS5000U0In01VO vo);    	

	/* 화면관리 신규/수정/삭제 다건 */	
    int reqRegiListGA09N204(SSBS5000U0In03VO vo);	
    
    /* 사용자그룹별_사용자관리 목록조회 */
	List<SSBS7100U0Out00VO> selectListGA09N201(SSBS7100U0In00VO vo);  
	
    /* 사용자그룹별 사용자관리 상세조회 PK */
	SSBS7100U0Out01VO selectGA09N201PK(SSBS7100U0In01VO vo);
	
	/* 사용자그룹_사용자관리 임시저장(수정)/상신 다건 */	
    String reqRegiListGA09N201(SSBS7100U0In03VO vo);	
    
	/* 사용자그룹_사용자관리 임시저장(수정)/상신 단건 */	
    String reqRegiGA09N201(SSBS7100U0In04VO vo);       
    

}
