package com.miraeasset.biz.sh.an.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.sh.an.vo.SHAN2000U0In00VO;
import com.miraeasset.biz.sh.an.vo.SHAN2000U0Out00VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In00VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In01VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In02VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0Out00VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0Out01VO;


@Repository
public class SHAN2000U0DaoImpl implements SHAN2000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	/* 안전보건공지 현황 조회 */	
	@Override
	public List<SHAN2000U0Out00VO> selectShanPsttList(SHAN2000U0In00VO vo) {
		return sqlSession.selectList("shan_mapper.selectShanPsttList", vo);
	}

	@Override
	public SHAN2000U0Out00VO selectShanPsttList_CNT(SHAN2000U0In00VO vo) {
		return sqlSession.selectOne("shan_mapper.selectShanPsttList_CNT", vo);
	}
}
