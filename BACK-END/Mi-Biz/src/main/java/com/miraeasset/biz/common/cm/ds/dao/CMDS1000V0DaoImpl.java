package com.miraeasset.biz.common.cm.ds.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.cm.ds.vo.CMDS1000V0In00VO;
import com.miraeasset.biz.common.cm.ds.vo.CMDS1000V0Out00VO;

@Repository
public class CMDS1000V0DaoImpl implements CMDS1000V0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* 기안문서조회 팝업 */
	@Override
	public List<CMDS1000V0Out00VO> select00AT09N401List(CMDS1000V0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("cmds_mapper.select00AT09N401List", vo);
	}	

}
