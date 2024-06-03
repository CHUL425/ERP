package com.miraeasset.biz.common.aprv.dao;

import java.util.List;

import com.miraeasset.biz.common.aprv.vo.Aprv00In00VO;
import com.miraeasset.biz.common.aprv.vo.Aprv00Out00VO;
import com.miraeasset.biz.common.meta.vo.GA09N601InVO;
import com.miraeasset.biz.common.meta.vo.GA09N601OutVO;
import com.miraeasset.biz.common.meta.vo.GA09N602InVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf01InVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf01OutVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02InVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02OutVO;
import com.miraeasset.biz.common.meta.vo.GA09N606Pu01InVO;
import com.miraeasset.biz.common.meta.vo.GA09N606VO;
import com.miraeasset.biz.common.meta.vo.GA09N607Pu01InVO;
import com.miraeasset.biz.common.meta.vo.GA09N607VO;

public interface AprvDao {

	/* 승댄대기 내역조회 */	
    List<Aprv00Out00VO> selectAprvList(Aprv00In00VO vo);
    
	/* 승인처리(승인/반려) */	
    int updateGA09N607Aprv(GA09N607Pu01InVO vo);

	/* 승인처리(승인/반려) */	
    int updateGA09N606Aprv(GA09N606Pu01InVO vo);
    
	/* 결재사유내용 변경 */	
    int updateGA09N607RsnCn(GA09N607VO vo);
    
	/* 결재정보 등록 insert(PK) */
	int insertGA09N606(GA09N606VO vo);
	
	/* 결재상세정보 등록 insert(PK) */
	int insertGA09N607(GA09N607VO vo);   
	
	/* 결재선 조회 */
	List<GA09N601OutVO> selectAprvLine(GA09N601InVO vo);
	
	/* 결재선상세정보 등록 */
	int insertAprvLineDl(GA09N602InVO vo);
	
	/* 결재선내역조회 */	
    List<GA09N602Vf01OutVO> selectAprvLineList(GA09N602Vf01InVO vo);	
	
	/* 다음결재정보 */	
    List<GA09N607VO> selectAprvNext(GA09N607VO vo);
    
	/* 결재상세정보조회(PK) */	
    List<GA09N607VO> selectAprvDtlPk(GA09N607VO vo);

	/* 결재정보조회(PK) */	
    List<GA09N606VO> selectGA09N606Pk(GA09N606VO vo);
    
    /* 결재 - 사용자정보조회 */
    List<GA09N602Vf02OutVO> selectAprvWrrptUserInfoList(GA09N602Vf02InVO vo);
    
    /* 결재 모듈 - 결재선 생성 처리 */
    int insertAprvLine(GA09N607VO vo);
    
    /* 결재 모듈 - 결재 철회 정보 생성 */
	int insertGA09N607Wdral(GA09N607Pu01InVO vo);
	
	/* 업무담당자 여부 조회 */
	GA09N602Vf02OutVO selectBzChprYn(GA09N602Vf02InVO vo);
    
	/* 2023.09.05 */
	/* 결재_결재정보상세 조회 */
	List<GA09N607VO> selectAprvWrrptDlList(GA09N607VO vo);
	
	/* 참조, 다움대상결재자 조회 */
	GA09N607VO selectNextAprvWrrptList(GA09N607VO vo);
	
	/* 결재상세정보 수정 */
	int updateAprvWrrpt(GA09N607VO vo);
}
