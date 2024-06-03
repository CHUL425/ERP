package com.miraeasset.biz.rq.sr.dao;

import com.miraeasset.biz.rq.sr.vo.RQSRSchedule1000U0Out00VO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class RQSRSchdule1000U0Dao {
    @Autowired
    @Resource(name="sqlSessionTemplate")
    private SqlSessionTemplate sqlSession;

    public List<String> findTargetRctNoList(String targetDate) {
        return sqlSession.selectList("rqsr_schedule_1000_mapper.findTargetRctNoList", targetDate);
    }

    public RQSRSchedule1000U0Out00VO findRqsInfoByRctNo(String rctNo) {
        return sqlSession.selectOne("rqsr_schedule_1000_mapper.findRqsInfoByRctNo", rctNo);
    }
}
