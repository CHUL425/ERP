package com.miraeasset.biz.rq.cr.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U01VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U02VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U03VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U04VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U05VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U06VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0In00VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0In01VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0In02VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out00VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out01VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U0Out02VO;

@Repository
public class RQCR1000U0DaoImpl implements RQCR1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<RQCR1000U0Out00VO> selectList(RQCR1000U0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rqcr_mapper.selectList", vo);
	}

	@Override
	public List<RQCR1000U0Out01VO> selectRqsStat(RQCR1000U0In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rqcr_mapper.selectRqsStat", vo);
	}

	@Override
	public List<RQCR1000U0Out02VO> selectDtlList(RQCR1000U0In02VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rqcr_mapper.selectDtlList", vo);
	}

	@Override
	public int insertRqcr(RQCR1000U01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("rqcr_mapper.insertRqcr", vo);
	}

	@Override
	public int insertRqcrDtl(RQCR1000U02VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("rqcr_mapper.insertRqcrDtl", vo);
	}

	@Override
	public int updateRqcr(RQCR1000U03VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("rqcr_mapper.updateRqcr", vo);
	}

	@Override
	public int updateRqcrDtl(RQCR1000U04VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("rqcr_mapper.updateRqcrDtl", vo);
	}

	@Override
	public int deleteRqcr(RQCR1000U05VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("rqcr_mapper.deleteRqcr", vo);
	}

	@Override
	public int deleteRqcrDtl(RQCR1000U05VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("rqcr_mapper.deleteRqcrDtl", vo);
	}
	
	/* 공사신청 반려 건 자동 재신청 */
	@Override
	public int insertGA01N103ReApplyByRctNo(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.insert("rqcr_mapper.insertGA01N103ReApplyByRctNo", map);
	}

}
