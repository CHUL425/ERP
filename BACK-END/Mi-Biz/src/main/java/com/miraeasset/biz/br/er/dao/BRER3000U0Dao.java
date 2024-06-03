package com.miraeasset.biz.br.er.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.br.er.vo.BRER3000U0In00VO;
import com.miraeasset.biz.br.er.vo.BRER3000U0Out00VO;

@Repository
public class BRER3000U0Dao {

	@Resource(name="sqlSessionTemplate")
	private final SqlSessionTemplate sqlSession;

	public BRER3000U0Dao(@Qualifier("sqlSessionTemplate") SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	/* 조회 */
	public List<BRER3000U0Out00VO> selectList00GA02N004(BRER3000U0In00VO brer3000U0In00VO) {
		return sqlSession.selectList("brer_3000_mapper.selectList00GA02N004", brer3000U0In00VO);
	}

	/* 관리 */
	public int merge00GA02N004(BRER3000U0Out00VO brer3000U0Out00VO) {
		return sqlSession.insert("brer_3000_mapper.merge00GA02N004", brer3000U0Out00VO);
	}
	
	/* 삭제 */
	public int delete00GA02N004(BRER3000U0In00VO brer3000U0In00VO) {
		return sqlSession.insert("brer_3000_mapper.delete00GA02N004", brer3000U0In00VO);
	}	
}
