package com.miraeasset.biz.rq.rr.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA01N102VO;
import com.miraeasset.biz.common.meta.vo.GA01N102Vf01InVO;
import com.miraeasset.biz.common.meta.vo.GA01N102Vf01OutVO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;

@Repository
public class RQRR1000U0DaoImpl implements RQRR1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")

	private SqlSessionTemplate sqlSession;
	
	
	/* 렌탈신청목록 조회 */
	@Override
	public List<RQRR1000U0VO> selectListRentRqs(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper11.selectListRentRqs", vo);
	}
	
	/* 렌탈신청목록 상태조회 */
	@Override
	public List<Map<String, Object>> selecRentRqsScdInfo(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper11.selecRentRqsScdInfo", vo);
	}
		

	/* 렌탈신청삭제(임대신청) delete(PK) */
	@Override
	public int deleteGA01N003(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("rent_mapper11.deleteGA01N003", vo);
	}	
	
	/* 렌탈신청상세삭제(임대신청상새) 같은접수번호 delete */
	@Override
	public int deleteGA01N004WithRctNo(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("rent_mapper11.deleteGA01N004WithRctNo", vo);
	}	

	/* 렌탈신청상세삭제(임대신청상새) 같은접수번호 delete */
	@Override
	public int deleteGA01N004WithRctNo(GA01N102VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("rent_mapper11.deleteGA01N004WithRctNo_1", vo);
	}		
	
	
	/* 렌탈신청(임대신청) 신청상태변경 */
	@Override
	public int updateRqsScd(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("rent_mapper11.updateRqsScd", vo);
	}	

	/* 렌탈신청상세목록 조회 */
	@Override
	public List<RQRR1000U0VO> selectListRentRqsDtl(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper11.selectListRentRqsDtl_1", vo);
	}	
	
	/* 렌탈신청상세목록 조회 */
	@Override
	public List<GA01N102Vf01OutVO> selectListRentRqsDtl(GA01N102Vf01InVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper11.selectListRentRqsDtl", vo);
	}	
		

	/* 렌탈신청(임대신청) 조회(PK) */
	@Override
	public List<GA01N101VO> selectGA01N101(GA01N101VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper11.selectGA01N101", vo);
	}		
	/* 렌탈신청(임대신청) 조회(PK) */
	@Override
	public List<RQRR1000U0VO> selectGA01N101(RQRR1000U0VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper11.selectGA01N101_1", vo);
	}
	
	/* 렌탈신청상세(임대신청상세) 조회(PK) */
	@Override
	public List<GA01N102VO> selectGA01N004(GA01N102VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper11.selectGA01N004_1", vo);
	}	
	
	/* 렌탈신청 반려 건 자동 재신청 */
	@Override
	public int insertGA01N102ReApplyByRctNo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.insert("rent_mapper11.insertGA01N102ReApplyByRctNo", map);
	}
	
}
