package com.miraeasset.biz.rent.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.rent.vo.RENT11In00VO;
import com.miraeasset.biz.rent.vo.RENT11In01VO;
import com.miraeasset.biz.rent.vo.RENT11In02VO;
import com.miraeasset.biz.rent.vo.RENT11Out00VO;
import com.miraeasset.biz.rent.vo.RENT11Out01VO;
import com.miraeasset.biz.rent.vo.RENT11Out02VO;
import com.miraeasset.biz.rent.vo.RENT12In00VO;
import com.miraeasset.biz.rent.vo.RENT12In01VO;
import com.miraeasset.biz.rent.vo.RENT12Out00VO;
import com.miraeasset.biz.rent.vo.RENT12Out01VO;

@Repository
public class RENT11DaoImpl implements RENT11Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* 렌탈신청상세목록 조회 */
	@Override
	public List<RENT11Out00VO> selectListRentRqsDtl(RENT11In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper.selectListRentRqsDtl", vo);
	}
	
	/* 렌탈신청목록 조회 */
	@Override
	public List<RENT12Out00VO> selectListRentRqs(RENT12In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper.selectListRentRqs", vo);
	}
	
	/* 렌탈신청목록 상태조회 */
	@Override
	public List<RENT12Out01VO> selecRentRqsScdInfo(RENT12In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper.selecRentRqsScdInfo", vo);
	}
		
	/* 렌탈신청(임대신청) 조회(PK) */
	@Override
	public List<RENT11Out01VO> selectGA01N003(RENT11In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper.selectGA01N003", vo);
	}

	/* 렌탈신청상세(임대신청상세) 조회(PK) */
	@Override
	public List<RENT11Out02VO> selectGA01N004(RENT11In02VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper.selectGA01N004", vo);
	}


	/* 렌탈신청(임대신청) update(PK) */
	@Override
	public int updateGA01N003(RENT11In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("rent_mapper.updateGA01N003", vo);
	}	
	
	/* 렌탈신청상세(임대신청상세) update(PK) */
	@Override
	public int updateGA01N004(RENT11In02VO vo){
		// TODO Auto-generated method stub
		return sqlSession.update("rent_mapper.updateGA01N004", vo);
	}	
	
	/* 렌탈신청(임대신청) insert(PK) */
	@Override
	public int insertGA01N003(RENT11In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("rent_mapper.insertGA01N003", vo);
	}	
	
	/* 렌탈신청상세(임대신청상세) insert(PK) */
	@Override
	public int insertGA01N004(RENT11In02VO vo){
		// TODO Auto-generated method stub
		return sqlSession.update("rent_mapper.insertGA01N004", vo);
	}		
	
	/* 렌탈신청(임대신청) 신청상태변경 */
	@Override
	public int updateRqsScd(RENT11In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("rent_mapper.updateRqsScd", vo);
	}	
	
	/* 렌탈신청삭제(임대신청) delete(PK) */
	@Override
	public int deleteGA01N003(RENT11In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("rent_mapper.deleteGA01N003", vo);
	}	
	
	/* 렌탈신청상세삭제(임대신청상새) delete(PK) */
	@Override
	public int deleteGA01N004(RENT11In02VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("rent_mapper.deleteGA01N004", vo);
	}		
	
	/* 렌탈신청상세삭제(임대신청상새) 같은접수번호 delete */
	@Override
	public int deleteGA01N004WithRctNo(RENT11In02VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("rent_mapper.deleteGA01N004WithRctNo", vo);
	}			
	
}
