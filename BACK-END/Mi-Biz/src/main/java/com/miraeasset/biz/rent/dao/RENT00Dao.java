package com.miraeasset.biz.rent.dao;

import java.util.List;

import com.miraeasset.biz.rent.vo.RENT00In00VO;
import com.miraeasset.biz.rent.vo.RENT02In00VO;
import com.miraeasset.biz.rent.vo.RENT04In00VO;

public interface RENT00Dao {
	
	/* 렌탈관리 조회 */
	List<RENT00In00VO> selectList00GA01N001(RENT00In00VO vo); 
	/* 렌탈관리요약정보 조회 */
	List<RENT00In00VO> selectList01GA01N001(RENT00In00VO vo);
	/* 연간렌탈료 조회 */
	List<RENT02In00VO> selectList02GA01N001(RENT02In00VO vo);
	/* 연간렌탈료요약정보 조회 */
	List<RENT02In00VO> selectList03GA01N001(RENT02In00VO vo);
	/* 렌탈제품조회(신청지점의 렌탈관리 조회) */
	List<RENT04In00VO> selectList04GA01N001(RENT04In00VO vo);
}
