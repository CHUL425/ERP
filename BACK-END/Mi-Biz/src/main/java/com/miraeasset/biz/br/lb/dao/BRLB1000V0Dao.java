package com.miraeasset.biz.br.lb.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.br.lb.vo.BRLB1000V0In00VO;
import com.miraeasset.biz.br.lb.vo.BRLB1000V0In02VO;
import com.miraeasset.biz.br.lb.vo.BRLB1000V0Out00VO;
import com.miraeasset.biz.br.lb.vo.BRLB1000V0Out02VO;
import com.miraeasset.biz.common.util.CryptoUtil;

@Repository
public class BRLB1000V0Dao {
    @Resource(name="sqlSessionTemplate")
    private final SqlSessionTemplate sqlSession;

    public BRLB1000V0Dao(@Qualifier("sqlSessionTemplate") SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<BRLB1000V0Out00VO> selectList00AT08N101(BRLB1000V0In00VO in00VO) {
        List<BRLB1000V0Out00VO> resultList = sqlSession.selectList("brlb_mapper.selectList00AT08N101", in00VO);

        /* [20231212] 임대인명 임대인암호화명으로 변경 */
        for(BRLB1000V0Out00VO result : resultList) {
            String encryptedLesorNm = result.getLesorNm();
            String decryptedLesorNm = encryptedLesorNm != null ? CryptoUtil.getDecryption(encryptedLesorNm) : "";

            result.setLesorNm(decryptedLesorNm);
        }

        return resultList;
    }

    public List<BRLB1000V0Out02VO> selectList00AT05N200(BRLB1000V0In02VO in02VO) {
        return sqlSession.selectList("brlb_mapper.selectList00AT05N200", in02VO);
    }
    
    public BRLB1000V0Out00VO selectAT08N101ByOrz(String orzCd) {
        return sqlSession.selectOne("brlb_mapper.selectAT08N101ByOrz", orzCd);
    }

}
