package com.miraeasset.biz.rent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.rent.dao.RENT00Dao;
import com.miraeasset.biz.rent.vo.RENT00In00VO;
import com.miraeasset.biz.rent.vo.RENT02In00VO;
import com.miraeasset.biz.rent.vo.RENT04In00VO;

@Service
@Transactional
public class RENT00ServiceImpl implements RENT00Service {
	
	@Autowired
	RENT00Dao RENT00Dao;
	
	/* 렌탈관리 조회 */
	@Override
	public List<RENT00In00VO> selectList00GA01N001(RENT00In00VO vo) {
		// TODO Auto-generated method stub
		return RENT00Dao.selectList00GA01N001(vo);
	}

	/* 렌탈관리요약정보조회 */
	@Override
	public List<RENT00In00VO> selectList01GA01N001(RENT00In00VO vo) {
		// TODO Auto-generated method stub
		return RENT00Dao.selectList01GA01N001(vo);
	}
	
	public String nvl(String str, String nvlStr) {
        if(str == null || str.trim().equals("")) {
            return nvlStr;
        } else {
            return str;
        }
    }
	
	/* 연간렌탈료 조회 */
	@Override
	public List<RENT02In00VO> selectList02GA01N001(RENT02In00VO vo) {
		// TODO Auto-generated method stub
		return RENT00Dao.selectList02GA01N001(vo);
	}
	
	/* 연간렌탈료요약정보 조회 */
	@Override
	public List<RENT02In00VO> selectList03GA01N001(RENT02In00VO vo) {
		// TODO Auto-generated method stub
		return RENT00Dao.selectList03GA01N001(vo);
	}
	
	/* 렌탈제품조회(신청지점의 렌탈관리 조회) */
	@Override
	public List<RENT04In00VO> selectList04GA01N001(RENT04In00VO vo) {
		// TODO Auto-generated method stub
		return RENT00Dao.selectList04GA01N001(vo);
	}
}
