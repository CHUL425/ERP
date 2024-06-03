package com.miraeasset.biz.ga.am.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA03N101VO;
import com.miraeasset.biz.ga.am.vo.GAAM1000U0In00VO;
import com.miraeasset.biz.ga.am.vo.GAAM1000U0In01VO;

@Repository
public class GAAM1000U0DaoImpl implements GAAM1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	/* 구매물품코드별 조회 */
	@Override
	public GA03N101VO selectAtclInfo(GAAM1000U0In00VO vo) {
		return sqlSession.selectOne("gaam_mapper.selectAtclInfo", vo);
	}
	
	/* 물품리스트 조회 */
	@Override
	public List<GA03N101VO> selectAtclList(GAAM1000U0In01VO vo) {
		return sqlSession.selectList("gaam_mapper.selectAtclList", vo);
	}

	@Override
	public GA03N101VO selectAtclList_CNT(GAAM1000U0In01VO vo) {
		return sqlSession.selectOne("gaam_mapper.selectAtclList_CNT", vo);
	}
	
}
