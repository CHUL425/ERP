package com.miraeasset.biz.rq.ur.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA01N102VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;

@Repository
public class RQUR1000U0DaoImpl implements RQUR1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* 렌탈신청(임대신청) 조회(PK) */
	@Override
	public List<RQRR1000U0VO> selectGA01N003(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper11.selectGA01N003", vo);
	}
	
	
	/* 렌탈신청(임대신청) insert(PK) */
	@Override
	public int insertGA01N003(GA01N101VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("rent_mapper11.insertGA01N003", vo);
	}	
	
	/* 렌탈신청(임대신청) update(PK) */
	@Override
	public int updateGA01N003(GA01N101VO vo){
		// TODO Auto-generated method stub
		return sqlSession.update("rent_mapper11.updateGA01N003", vo);
	}	
	
	/* 렌탈신청상세(임대신청상세) insert(PK) */
	@Override
	public int insertGA01N004(GA01N102VO vo){
		// TODO Auto-generated method stub
		return sqlSession.insert("rent_mapper11.insertGA01N004", vo);
	}		
		
}
