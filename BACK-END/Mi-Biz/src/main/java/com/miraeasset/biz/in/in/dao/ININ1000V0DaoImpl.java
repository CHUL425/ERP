package com.miraeasset.biz.in.in.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.ga.cm.vo.GACM1000U0In00VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0In00VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0In01VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0In02VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out00VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out01VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out02VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out04VO;
import com.miraeasset.biz.in.in.vo.ININ1000V0Out05VO;

@Repository
public class ININ1000V0DaoImpl implements ININ1000V0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* Today 업무현황 
	 * 
	 * 오늘까지 접수한 나의 업무현황
	 * 처리완료(당일포함 2주동안 처리한 내역)
	 * 미처리(당일포함 2주동안 미처리한 내역)
	 * */
	@Override
	public ININ1000V0Out00VO selectTodayBzPstt(ININ1000V0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("inin_mapper.selectTodayBzPstt", vo);
	}
	
	/* 예산집행금액 및 집행율 */
	@Override
	public ININ1000V0Out01VO selectBdgtList(ININ1000V0In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("inin_mapper.selectBdgtList", vo);
	}
	
	/* 소모품, 리스료 등  예산 집행금액 */
	@Override
	public ININ1000V0Out02VO selectYlyBdgtList(ININ1000V0In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("inin_mapper.selectYlyBdgtList", vo);
	}
	
	/* Today 나의업무 */
	@Override
	public List<ININ1000V0Out00VO> selectTodayBzChprList(ININ1000V0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("inin_mapper.selectTodayBzChprList", vo);
	}
	
	/* 총무접수현황 */
	@Override
	public List<ININ1000V0Out04VO> selectGeafRctPstt(ININ1000V0In02VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("inin_mapper.selectGeafRctPstt", vo);
	}
	
	/* 신규계약현황 */
	public List<ININ1000V0Out05VO> selectNewCntcPstt(GACM1000U0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("inin_mapper.selectNewCntcPstt", vo);
	}
	
}
