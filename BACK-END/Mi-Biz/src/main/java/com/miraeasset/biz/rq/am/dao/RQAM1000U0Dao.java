package com.miraeasset.biz.rq.am.dao;

import java.util.List;

import com.miraeasset.biz.common.meta.vo.*;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In00VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0Out00VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0Out01VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out21VO;

public interface RQAM1000U0Dao {

	/* 승댄대기 내역조회 */	
    List<RQAM1000U0Out00VO> selectAprvList(RQAM1000U0In00VO vo);
    
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
	
	/* 2023.09.07 */
	/* 기본결재선 조회 */
	List<GA09N607aprvVO> selectBaseAprvLineList(GA09N607aprvVO vo);
	
	/* 임대신청 상태 수정 */
	int updateAprvRqsScd(GA01N101VO vo);
	
	/* 임대신청 조회(pk) */
	GA01N101VO selectGA01N101Pk(GA01N101VO vo);
	
	/* 임대신청 상태 수정 */
	int updateAprvWrrptStat(GA09N607VO vo);
	
	/* 기본 결재선관리번호 조회 */
	GA09N602Vf02OutVO baseAprvLine(GA09N602Vf02OutVO vo);
	
	/* 대결확인여부 조회 */
	List<GA09N607VO> selectSbapCfmtYn(GA09N607VO vo);
	
	/* 결재선 삭제 */
	int deleteAprvl(String aprvWrrptMtNo);
	
	/* 임시저장 결재선 조회 */
	List<GA09N607aprvVO> selectTmpStrgAprvLineList(GA09N607aprvVO vo);
	
	/* 업무담당자 사원번호 조회 */
	String selectBzChprEpno(String psitMenuId);

	// [20231130] 삭제예정. 결재관리번호 2023110100000006를 철회하기 위해 임시로 생성한 내용
	//int insertGA09N607WdralFor2023110100000006(GA09N607Pu01InVO vo);
	
	/* 인감날인증명서 승인대기목록조회 */	
    List<RQSR1000U0Out21VO> selectSealAprvList(RQAM1000U0In00VO vo);
    int selectSealAprvListTotCnt(RQAM1000U0In00VO vo);

	GA09N602VO selectOneGA09N602ByKey(GA09N602KeyVO ga09N602KeyVO);

	List<GA09N602VO> selectListGA09N602ByAprvlMtNo(String aprvlMtNo);
	
	/* 회수가능여부 조회 */
	RQAM1000U0Out01VO selectGA01N101Wtdw(String rctNo);
}
