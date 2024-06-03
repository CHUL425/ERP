package com.miraeasset.biz.rq.pr.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA03N103VO;

@Repository
public class RQPR1000U0DaoImpl implements RQPR1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public int deleteGA03N103ByRctNo(String rctNo) {
		return sqlSession.delete("rqpr_mapper.deleteGA03N103ByRctNo", rctNo);
	}

	@Override
	public int insertGA03N103(GA03N103VO vo) {
		return sqlSession.insert("rqpr_mapper.insertGA03N103", vo);
	}

}
