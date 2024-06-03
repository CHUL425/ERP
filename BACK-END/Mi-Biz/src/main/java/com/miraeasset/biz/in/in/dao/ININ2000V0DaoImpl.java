package com.miraeasset.biz.in.in.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.in.in.vo.ININ1000V0In02VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0Out00VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0Out01VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0VO2;

@Repository
public class ININ2000V0DaoImpl implements ININ2000V0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* 연간 예산집행 추이 */
	@Override
	public List<ININ2000V0Out01VO> selectYlyBdgtEnfc(ININ1000V0In02VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("inin_mapper.selectYlyBdgtEnfc", vo);
	}
	
	/* 총무사업 예산 */
	@Override
	public List<ININ2000V0Out00VO> selectGeafBusiBdgt(ININ1000V0In02VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("inin_mapper.selectGeafBusiBdgt", vo);
	}
	
	/* 현재 시스템일자기준 이전 분기일자 조회 */
	@Override
	public List<ININ1000V0In02VO> selectBfQtrDt() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("inin_mapper.selectBfQtrDt", "");
	}
	
	/* 임직원 초기화면 - 승인현황 */
	@Override
	public List<ININ2000V0VO2> selectXempApvPstt(ININ2000V0VO2 vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("inin_mapper.selectXempApvPstt", vo);
	}

	@Override
	public ININ2000V0Out00VO selectGeafBusiBdgt2(ININ1000V0In02VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("inin_mapper.selectGeafBusiBdgt2", vo);
	}
	
}
