package com.miraeasset.biz.br.rb.dao;

import com.miraeasset.biz.br.rb.vo.BRRB2000V0In00VO;
import com.miraeasset.biz.br.rb.vo.BRRB3000V0In00VO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Repository
public class BRRB3000V0Dao {
    @Resource(name="sqlSessionTemplate")
    private final SqlSessionTemplate sqlSession;

    public BRRB3000V0Dao(@Qualifier("sqlSessionTemplate") SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    /* 임대차보증금합계(홍천제외) */
    public BigDecimal selectOne00AT08N123(BRRB2000V0In00VO brrb2000V0In00VO) {
        return sqlSession.selectOne("brrb_3000_mapper.selectOne00AT08N123", brrb2000V0In00VO);
    }

    /* 내부이전금리 */
    public BigDecimal selectOne00AT03N332(BRRB2000V0In00VO brrb2000V0In00VO) {
        return sqlSession.selectOne("brrb_3000_mapper.selectOne00AT03N332", brrb2000V0In00VO);
    }

    /* 계산서 조회(매출세금계산서, 매출계산서) */
    public BigDecimal selectOne00AT05N401(BRRB3000V0In00VO brrb3000V0In00VO) {
        return sqlSession.selectOne("brrb_3000_mapper.selectOne00AT05N401", brrb3000V0In00VO);
    }

    /* 결의서 조회 */
    public BigDecimal selectOne00AT05N200(BRRB3000V0In00VO brrb3000V0In00VO) {
        return sqlSession.selectOne("brrb_3000_mapper.selectOne00AT05N200", brrb3000V0In00VO);
    }

    /* [3420] 보전금액합계 (5270060101 계정 199212 발신조직으로 검색 */
    public BigDecimal selectOne00AT03N531(BRRB2000V0In00VO brrb2000V0In00VO) {
        return sqlSession.selectOne("brrb_3000_mapper.selectOne00AT03N531", brrb2000V0In00VO);
    }
}
