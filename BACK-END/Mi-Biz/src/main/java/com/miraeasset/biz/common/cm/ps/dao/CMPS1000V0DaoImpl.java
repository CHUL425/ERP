package com.miraeasset.biz.common.cm.ps.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.cm.ps.vo.CMPS1000V0In00VO;
import com.miraeasset.biz.common.cm.ps.vo.CMPS1000V0Out00VO;

@Repository
public class CMPS1000V0DaoImpl implements CMPS1000V0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* 거래처조회 팝업 */
	@Override
	public List<CMPS1000V0Out00VO> select00AT05C010List(CMPS1000V0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("cmps_mapper.select00AT05C010List", vo);
	}

	@Override
	public List<CMPS1000V0Out00VO> select00AT05C010ListPK(CMPS1000V0In00VO vo) {
		return sqlSession.selectList("cmps_mapper.select00AT05C010ListPK", vo);
	}


}
