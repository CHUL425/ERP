package com.miraeasset.biz.common.cm.cs.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.cm.cs.vo.CMCS1000V0In00VO;
import com.miraeasset.biz.common.cm.cs.vo.CMCS1000V0Out00VO;

@Repository
public class CMCS1000V0DaoImpl implements CMCS1000V0Dao  {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* 계약번호팝업리스트조회 */
	@Override
	public List<CMCS1000V0Out00VO> selectList00AT08N100(CMCS1000V0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("cmcs_mapper.selectList00AT08N100", vo);
	}

}
