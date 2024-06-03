package com.miraeasset.biz.rent.dao;

import java.util.List;

import com.miraeasset.biz.rent.vo.RENT11In00VO;
import com.miraeasset.biz.rent.vo.RENT11In01VO;
import com.miraeasset.biz.rent.vo.RENT11In02VO;
import com.miraeasset.biz.rent.vo.RENT11Out00VO;
import com.miraeasset.biz.rent.vo.RENT11Out01VO;
import com.miraeasset.biz.rent.vo.RENT11Out02VO;
import com.miraeasset.biz.rent.vo.RENT12In00VO;
import com.miraeasset.biz.rent.vo.RENT12In01VO;
import com.miraeasset.biz.rent.vo.RENT12Out00VO;
import com.miraeasset.biz.rent.vo.RENT12Out01VO;

public interface RENT11Dao {
	
	/* 렌탈신청상세목록 조회 */
	List<RENT11Out00VO> selectListRentRqsDtl(RENT11In00VO vo); 

	/* 렌탈신청목록 조회 */
	List<RENT12Out00VO> selectListRentRqs(RENT12In00VO vo); 

	/* 렌탈신청목록 상태조회 */
	List<RENT12Out01VO> selecRentRqsScdInfo(RENT12In01VO vo); 
	
	/* 렌탈신청(임대신청) 조회(PK) */
	List<RENT11Out01VO> selectGA01N003(RENT11In01VO vo);
	
	/* 렌탈신청상세(임대신청상세) 조회(PK) */
	List<RENT11Out02VO> selectGA01N004(RENT11In02VO vo); 
	
	/* 렌탈신청(임대신청) update(PK) */
	int updateGA01N003(RENT11In01VO vo);
	
	/* 렌탈신청상세(임대신청상세) update(PK) */
	int updateGA01N004(RENT11In02VO vo);
	
	/* 렌탈신청(임대신청) insert(PK) */
	int insertGA01N003(RENT11In01VO vo);
	
	/* 렌탈신청상세(임대신청상세) insert(PK) */
	int insertGA01N004(RENT11In02VO vo);

	/* 렌탈신청(임대신청) 신청상태변경 */
	int updateRqsScd(RENT11In01VO vo);
	
	/* 렌탈신청삭제(임대신청) delete(PK) */
	int deleteGA01N003(RENT11In01VO vo);	

	/* 렌탈신청상세삭제(임대신청상새) delete(PK) */
	int deleteGA01N004(RENT11In02VO vo);	

	/* 렌탈신청상세삭제(임대신청상새) 같은접수번호 delete */
	int deleteGA01N004WithRctNo(RENT11In02VO vo);		
}
