package com.miraeasset.biz.budget.dao;

import com.miraeasset.biz.budget.vo.BGT5320In00VO;
import com.miraeasset.biz.budget.vo.Main01VO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BGT5320DaoImpl implements BGT5320Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BGT5320In00VO> selectList00AT05N129(BGT5320In00VO vo) {
		return sqlSession.selectList("budget_5320_mapper.selectList00AT05N129", vo);
	}


//	@Override
//	public List<Main01VO> selectList00AT05N121(Main01VO vo) {
//		return sqlSession.selectList("budget_5350_mapper.selectList00AT05N121", vo);
//	}

}
