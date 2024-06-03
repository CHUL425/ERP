package com.miraeasset.biz.rq.nr.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA03N102VO;
import com.miraeasset.biz.common.meta.vo.GA03N104VO;
import com.miraeasset.biz.common.meta.vo.GA03N105VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0In00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0Out00VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0Out01VO;
import com.miraeasset.biz.rq.nr.vo.RQNR1000U0Out02VO;

@Repository
public class RQNR1000U0DaoImpl implements RQNR1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public RQNR1000U0Out00VO selectEpInfo(RQNR1000U0In00VO vo) {
		return sqlSession.selectOne("rqnr_mapper.selectEpInfo", vo);
	}

	@Override
	public List<RQNR1000U0Out01VO> selectEpLcnsList(RQNR1000U0In00VO vo) {
		return sqlSession.selectList("rqnr_mapper.selectEpLcnsList", vo);
	}

	@Override
	public List<RQNR1000U0Out02VO> selectAdrList(RQNR1000U0In00VO vo) {
		return sqlSession.selectList("rqnr_mapper.selectAdrList", vo);
	}

	@Override
	public int selectAdrList_CNT(RQNR1000U0In00VO vo) {
		return sqlSession.selectOne("rqnr_mapper.selectAdrList_CNT", vo);
	}

	@Override
	public int deleteGA03N104ByRctNo(String rctNo) {
		return sqlSession.delete("rqnr_mapper.deleteGA03N104ByRctNo", rctNo);
	}

	@Override
	public int insertGA03N104(GA03N104VO vo) {
		return sqlSession.insert("rqnr_mapper.insertGA03N104", vo);
	}

	@Override
	public int deleteGA03N102ByRctNo(String rctNo) {
		return sqlSession.delete("rqnr_mapper.deleteGA03N102ByRctNo", rctNo);
	}

	@Override
	public int insertGA03N102(GA03N102VO vo) {
		return sqlSession.insert("rqnr_mapper.insertGA03N102", vo);
	}

	@Override
	public int deleteGA03N105ByRctNo(String rctNo) {
		return sqlSession.delete("rqnr_mapper.deleteGA03N105ByRctNo", rctNo);
	}

	@Override
	public int insertGA03N105(GA03N105VO vo) {
		return sqlSession.insert("rqnr_mapper.insertGA03N105", vo);
	}
}
