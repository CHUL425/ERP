package com.miraeasset.biz.rq.sr.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class RQSRSchedule1000U4Dao {
    @Autowired
    @Resource(name="sqlSessionTemplate")
    private SqlSessionTemplate sqlSession;

    public List<String> findTargetRctNoListOver(String targetDate) {
        return sqlSession.selectList("rqsr_schedule_1000_mapper.findTargetRctNoListOver", targetDate);
    }
}
