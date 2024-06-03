package com.miraeasset.biz.br.ob.dao;

import com.miraeasset.biz.br.ob.vo.BROB1000U0In00VO;
import com.miraeasset.biz.br.ob.vo.BROB1000U0Out00VO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BROB1000U0Dao {
    @Resource(name="sqlSessionTemplate")
    private final SqlSessionTemplate sqlSession;

    public BROB1000U0Dao(@Qualifier("sqlSessionTemplate") SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<BROB1000U0Out00VO> selectList00GA02N101() {
        return sqlSession.selectList("brob_mapper.selectList00GA02N101");
    }

    public BROB1000U0Out00VO selectOne00GA02N101(BROB1000U0In00VO brob1000U0In00VO) {
        return sqlSession.selectOne("brob_mapper.selectOne00GA02N101", brob1000U0In00VO);
    }

    public int merge00GA02N101(BROB1000U0Out00VO brob1000U0Out00VO) {
        return sqlSession.insert("brob_mapper.merge00GA02N101", brob1000U0Out00VO);
    }
}
