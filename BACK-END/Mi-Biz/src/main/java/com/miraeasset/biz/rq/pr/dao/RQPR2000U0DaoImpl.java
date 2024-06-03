package com.miraeasset.biz.rq.pr.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.rq.pr.vo.RQPR2000U0Out01VO;

@Repository
public class RQPR2000U0DaoImpl implements RQPR2000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public List<RQPR2000U0Out01VO> selectListGA03N103Dtl(String rctNo) {
		return sqlSession.selectList("rqpr_mapper.selectListGA03N103Dtl", rctNo);
	}

}
