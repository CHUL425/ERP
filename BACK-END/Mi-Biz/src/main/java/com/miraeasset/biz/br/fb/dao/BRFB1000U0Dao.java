package com.miraeasset.biz.br.fb.dao;

import com.miraeasset.biz.br.fb.vo.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class BRFB1000U0Dao {

    @Resource(name="sqlSessionTemplate")
    private final SqlSessionTemplate sqlSession;

    public BRFB1000U0Dao(@Qualifier("sqlSessionTemplate") SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    /* 지점개요 - 지점리스트 조회 */
    public List<Map<String, String>> selectList00CB01N210() {
        return sqlSession.selectList("brfb_1000_mapper.selectList00CB01N210");
    }

    /* 지점개요 - 지점전체조회 */
    public List<BRFB1000U0Out00VO> selectList01CB01N210(BRFB1000U0In00VO brfb1000U0In00VO) {
        return sqlSession.selectList("brfb_1000_mapper.selectList01CB01N210", brfb1000U0In00VO);
    }

    /* 지점개요 - 지점상세조회 */
    public BRFB1000U0Out01VO selectOne00GA02N001(BRFB1000U0In00VO brfb1000U0In00VO) {
        return sqlSession.selectOne("brfb_1000_mapper.selectOne00GA02N001", brfb1000U0In00VO);
    }

    public int merge00GA02N001(BRFB1000U0Out01VO brfb1000U0Out01VO) {
        return sqlSession.insert("brfb_1000_mapper.merge00GA02N001", brfb1000U0Out01VO);
    }

    public List<BRFB1000U0Out02VO> selectList00GA01N001(BRFB1000U0In00VO brfb1000U0In00VO) {
        return sqlSession.selectList("brfb_1000_mapper.selectList00GA01N001", brfb1000U0In00VO);
    }
}
