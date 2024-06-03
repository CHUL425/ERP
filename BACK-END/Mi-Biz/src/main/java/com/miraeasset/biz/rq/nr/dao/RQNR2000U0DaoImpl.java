package com.miraeasset.biz.rq.nr.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA03N105VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0In00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0In01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out02VO;
import com.miraeasset.biz.rq.nr.vo.RQNR2000U0Out03VO;

@Repository
public class RQNR2000U0DaoImpl implements RQNR2000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	
	@Override
	public List<RQNR2000U0Out00VO> selectListGA03N102(RQNR2000U0In00VO vo) {
		return sqlSession.selectList("rqnr_mapper.selectListGA03N102", vo);
	}


	@Override
	public RQNR2000U0Out01VO selectInfoGA03N102(RQNR2000U0In00VO vo) {
		return sqlSession.selectOne("rqnr_mapper.selectInfoGA03N102", vo);
	}


	@Override
	public RQNR2000U0Out02VO selectDlInfo(RQNR2000U0In01VO vo) {
		return sqlSession.selectOne("rqnr_mapper.selectDlInfo", vo);
	}

	
	@Override
	public List<RQNR2000U0Out03VO> selectListGA03N102Dtl(RQNR2000U0In01VO vo) {
		return sqlSession.selectList("rqnr_mapper.selectListGA03N102Dtl", vo);
	}


	@Override
	public GA03N105VO selectDtlGA03N105(RQNR2000U0In01VO vo) {
		return sqlSession.selectOne("rqnr_mapper.selectDtlGA03N105", vo);
	}
}
