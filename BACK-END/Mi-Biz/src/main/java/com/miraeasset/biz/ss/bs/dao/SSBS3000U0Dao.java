package com.miraeasset.biz.ss.bs.dao;

import com.miraeasset.biz.common.meta.vo.GA09N602VO;
import com.miraeasset.biz.common.meta.vo.GA09N607VO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class SSBS3000U0Dao {

    @Autowired
    @Resource(name="sqlSessionTemplate")
    private SqlSessionTemplate sqlSession;

    public List<GA09N607VO> findGA09N607(GA09N607VO ga09N607VO) {
        return sqlSession.selectList("ssbs_3000_mapper.findGA09N607", ga09N607VO);
    }

    public int saveGA09N607(GA09N607VO ga09N607VO) {
        return sqlSession.update("ssbs_3000_mapper.saveGA09N607", ga09N607VO);
    }

    public List<GA09N602VO> findGA09N602(GA09N602VO ga09N602VO) {
        return sqlSession.selectList("ssbs_3000_mapper.findGA09N602", ga09N602VO);
    }

    public int saveGA09N602(GA09N602VO ga09N602VO) {
        return sqlSession.insert("ssbs_3000_mapper.saveGA09N602", ga09N602VO);
    }

}
