package com.miraeasset.biz.rq.sr.dao;

import com.miraeasset.biz.rq.sr.vo.RQSRSchedule1000U1Out00VO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class RQSRSchedule1000U1Dao {
    @Autowired
    @Resource(name="sqlSessionTemplate")
    private SqlSessionTemplate sqlSession;

    public RQSRSchedule1000U1Out00VO findRptvEpInfoByOrzCd(String orzCd) {
        return sqlSession.selectOne("rqsr_schedule_1000_mapper.findRptvEpInfoByOrzCd", orzCd);
    }
}
