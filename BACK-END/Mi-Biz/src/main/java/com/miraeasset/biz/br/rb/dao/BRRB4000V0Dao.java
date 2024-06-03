package com.miraeasset.biz.br.rb.dao;

import com.miraeasset.biz.br.rb.vo.BRRB4000V0In00VO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Repository
public class BRRB4000V0Dao {
    @Resource(name="sqlSessionTemplate")
    private final SqlSessionTemplate sqlSession;

    public BRRB4000V0Dao(@Qualifier("sqlSessionTemplate") SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public BigDecimal selectOne00AT01N101(BRRB4000V0In00VO brrb4000V0In00VO) {
        return sqlSession.selectOne("brrb_4000_mapper.selectOne00AT01N101", brrb4000V0In00VO);
    }
}
