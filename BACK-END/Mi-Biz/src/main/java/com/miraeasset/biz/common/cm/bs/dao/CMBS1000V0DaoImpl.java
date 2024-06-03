package com.miraeasset.biz.common.cm.bs.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.cm.bs.vo.CMBS1000V0In00VO;
import com.miraeasset.biz.common.cm.bs.vo.CMBS1000V0Out00VO;

@Repository
public class CMBS1000V0DaoImpl implements CMBS1000V0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* 계정과목조회 팝업 */
	@Override
	public List<CMBS1000V0Out00VO> select00AT01C001List(CMBS1000V0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("cmbs_mapper.select00AT01C001List", vo);
	}
}
