package com.miraeasset.biz.common.basic.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.basic.vo.AprvOrg00VO;
import com.miraeasset.biz.common.basic.vo.BasicLoginHisInVO;
import com.miraeasset.biz.common.basic.vo.BasicLoginHisOutVO;
import com.miraeasset.biz.common.basic.vo.BasicOrg00In00VO;
import com.miraeasset.biz.common.basic.vo.BasicOrg00Out00VO;
import com.miraeasset.biz.common.basic.vo.BasicOrg01In00VO;
import com.miraeasset.biz.common.basic.vo.BasicOrg01Out00VO;
import com.miraeasset.biz.common.basic.vo.BasicPost00In00VO;
import com.miraeasset.biz.common.basic.vo.BasicPost00In01VO;
import com.miraeasset.biz.common.basic.vo.BasicPost00Out00VO;
import com.miraeasset.biz.common.basic.vo.BasicPost00Out01VO;
import com.miraeasset.biz.common.basic.vo.BasicUser00In00VO;
import com.miraeasset.biz.common.basic.vo.BasicUser00Out00VO;


@Repository
public class BasicDaoImpl implements BasicDao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BasicOrg00Out00VO> selectListOrg00(BasicOrg00In00VO vo) {
		return sqlSession.selectList("org_mapper.selectOrg00List", vo);
	}
	
	@Override
	public List<BasicOrg01Out00VO> selectOrg01(BasicOrg01In00VO vo) {
		return sqlSession.selectList("org_mapper.selectOrg01", vo);
	}
	
	@Override
	public List<BasicUser00Out00VO> selectListUser00(BasicUser00In00VO vo) {
		return sqlSession.selectList("user_mapper.selectUser00List", vo);
	}	
	
	@Override
	public List<BasicLoginHisOutVO> selectListLoginHis(BasicLoginHisInVO vo) {
		return sqlSession.selectList("login_mapper.selectListLoginHis", vo);
	}		

	@Override
	public List<BasicPost00Out00VO> selectPreSchw(BasicPost00In00VO vo) {
		return sqlSession.selectList("post_mapper.selectPreSchw", vo);
	}
	
	@Override
	public List<BasicPost00Out01VO> selectUnifAdr(BasicPost00In01VO vo) {
		return sqlSession.selectList("post_mapper.selectUnifAdr", vo);
	}
	
	/* 결재선 조직도 조회 */
	@Override
	public List<AprvOrg00VO> selectAprvOrgList(AprvOrg00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("org_mapper.selectAprvOrgList", vo);
	}	
	
	
}
