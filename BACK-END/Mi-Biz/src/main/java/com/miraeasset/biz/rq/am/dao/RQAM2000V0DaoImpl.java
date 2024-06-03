package com.miraeasset.biz.rq.am.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.rq.am.vo.RQAM2000V0In00VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0In01VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0In02VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0Out00VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0Out01VO;
import com.miraeasset.biz.rq.am.vo.RQAM2000V0Out02VO;

@Repository
public class RQAM2000V0DaoImpl implements RQAM2000V0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* 렌탈신청(임대신청) 조회(PK) */
	@Override
	public List<RQAM2000V0Out00VO> selList(RQAM2000V0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rqam_mapper.selectList", vo);
	}
	
	/* 승인현황 조회 */
	@Override
	public List<RQAM2000V0Out01VO> selectAprvPstt(RQAM2000V0In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rqam_mapper.selectAprvPstt", vo);
	}

	/* 결제상세내역-pk */
	@Override
	public List<RQAM2000V0Out02VO> selectAprvDtlInfo(RQAM2000V0In02VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rqam_mapper.selectAprvDtlInfo", vo);
	}	
	
}
