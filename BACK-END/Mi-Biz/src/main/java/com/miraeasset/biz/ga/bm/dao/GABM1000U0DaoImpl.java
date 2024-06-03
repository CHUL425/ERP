package com.miraeasset.biz.ga.bm.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.ga.bm.vo.GABM1000U0In00VO;
import com.miraeasset.biz.ga.bm.vo.GABM1000U0In01VO;
import com.miraeasset.biz.ga.bm.vo.GABM1000U0Out00VO;

@Repository
public class GABM1000U0DaoImpl implements GABM1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* 예산관리 조회 */
	@Override
	public List<GABM1000U0Out00VO> selectList00GA01N401(GABM1000U0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gabm_mapper.selectList00GA01N401", vo);
	}

	/* 편성금액 관리 */
	@Override
	public int insert00GA01N401(GABM1000U0In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("gabm_mapper.insert00GA01N401", vo);
	}
}
