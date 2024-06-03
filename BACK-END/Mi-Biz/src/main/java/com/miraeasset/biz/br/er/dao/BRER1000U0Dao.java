package com.miraeasset.biz.br.er.dao;

import java.util.List;
import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.miraeasset.biz.br.er.vo.BRER1000U0In00VO;
import com.miraeasset.biz.br.er.vo.BRER1000U0Out00VO;

@Repository
public class BRER1000U0Dao {
	
	@Resource(name="sqlSessionTemplate")
	private final SqlSessionTemplate sqlSession;

	public BRER1000U0Dao(@Qualifier("sqlSessionTemplate") SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	/* 조회 */
	public List<BRER1000U0Out00VO> selectList00GA02N002(BRER1000U0In00VO brer1000U0In00VO) {
		return sqlSession.selectList("brer_1000_mapper.selectList00GA02N002", brer1000U0In00VO);
	}

	/* 관리 */
	public int merge00GA02N002(BRER1000U0Out00VO brer1000U0Out00VO) {
		return sqlSession.insert("brer_1000_mapper.merge00GA02N002", brer1000U0Out00VO);
	}
	
	/* 삭제 */
	public int delete00GA02N002(BRER1000U0In00VO brer1000U0In00VO) {
		return sqlSession.insert("brer_1000_mapper.delete00GA02N002", brer1000U0In00VO);
	}	
}
