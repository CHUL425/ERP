package com.miraeasset.biz.br.rb.dao;

import com.miraeasset.biz.br.rb.vo.BRRB1000U0In00VO;
import com.miraeasset.biz.br.rb.vo.BRRB1000U0In01VO;
import com.miraeasset.biz.br.rb.vo.BRRB1000U0Out00VO;
import com.miraeasset.biz.br.rb.vo.BRRB1000U0Out01VO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BRRB1000U0Dao {
    @Resource(name="sqlSessionTemplate")
    private final SqlSessionTemplate sqlSession;

    public BRRB1000U0Dao(@Qualifier("sqlSessionTemplate") SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<BRRB1000U0Out00VO> selectListAT08N101(BRRB1000U0In00VO brrb1000U0In00VO) {
        return sqlSession.selectList("brrb_1000_mapper.selectListAT08N101", brrb1000U0In00VO);
    }

    public List<BRRB1000U0Out00VO> selectListGA02N201(BRRB1000U0In00VO brrb1000U0In00VO) {
        return sqlSession.selectList("brrb_1000_mapper.selectListGA02N201", brrb1000U0In00VO);
    }

    public BRRB1000U0Out01VO selectOneGA02N201(BRRB1000U0In01VO brrb1000U0In01VO) {
        return sqlSession.selectOne("brrb_1000_mapper.selectOneGA02N201", brrb1000U0In01VO);
    }

    public int mergeGA02N201(BRRB1000U0Out01VO brrb1000U0Out01VO) {
        return sqlSession.insert("brrb_1000_mapper.mergeGA02N201", brrb1000U0Out01VO);
    }

    public int deleteGA02N201(BRRB1000U0In01VO brrb1000U0In01VO) {
        return sqlSession.delete("brrb_1000_mapper.deleteGA02N201", brrb1000U0In01VO);
    }
    
    public List<BRRB1000U0Out00VO> selectGA02N201Rcen(BRRB1000U0In00VO brrb1000U0In00VO) {
        return sqlSession.selectList("brrb_1000_mapper.selectGA02N201Rcen", brrb1000U0In00VO);
    }
    
}
