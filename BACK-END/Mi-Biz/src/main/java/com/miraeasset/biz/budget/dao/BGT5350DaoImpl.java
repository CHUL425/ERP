package com.miraeasset.biz.budget.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.budget.vo.BGT5350In00VO;

@Repository
public class BGT5350DaoImpl implements BGT5350Dao {

	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BGT5350In00VO> selectList00AT05N121(BGT5350In00VO vo) {
		return sqlSession.selectList("budget_5350_mapper.selectList00AT05N121", vo);
	}

}
