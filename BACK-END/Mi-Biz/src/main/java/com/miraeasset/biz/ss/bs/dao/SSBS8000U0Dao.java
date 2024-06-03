package com.miraeasset.biz.ss.bs.dao;

import com.miraeasset.biz.ss.bs.vo.SSBS8000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS8000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS8000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS8000U0Out01VO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class SSBS8000U0Dao {
    @Resource(name="sqlSessionTemplate")
    private SqlSessionTemplate sqlSession;

    public List<SSBS8000U0Out00VO> selectList00GA09C301(SSBS8000U0In00VO ssbs8000U0In00VO) {
        return sqlSession.selectList("ssbs_8000_mapper.selectList00GA09C301", ssbs8000U0In00VO);
    }

    public int merge00GA09C301(SSBS8000U0Out00VO ssbs8000U0Out00VO) {
        return sqlSession.insert("ssbs_8000_mapper.merge00GA09C301", ssbs8000U0Out00VO);
    }

    public int delete00GA09C301(SSBS8000U0In00VO ssbs8000U0In00VO) {
        return sqlSession.delete("ssbs_8000_mapper.delete00GA09C301", ssbs8000U0In00VO);
    }

    public List<SSBS8000U0Out01VO> selectList00GA09C302(SSBS8000U0In01VO ssbs8000U0In01VO) {
        return sqlSession.selectList("ssbs_8000_mapper.selectList00GA09C302", ssbs8000U0In01VO);
    }

    public int merge00GA09C302(SSBS8000U0Out01VO ssbs8000U0Out01VO) {
        return sqlSession.insert("ssbs_8000_mapper.merge00GA09C302", ssbs8000U0Out01VO);
    }

    public int delete00GA09C302(SSBS8000U0In01VO ssbs8000U0In01VO) {
        return sqlSession.delete("ssbs_8000_mapper.delete00GA09C302", ssbs8000U0In01VO);
    }
}
