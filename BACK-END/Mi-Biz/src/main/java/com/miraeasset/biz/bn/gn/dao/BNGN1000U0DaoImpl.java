package com.miraeasset.biz.bn.gn.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.bn.gn.vo.BNGN1000U0In00VO;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0In01VO;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0Out00VO;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0Out01VO;
import com.miraeasset.biz.common.meta.vo.GA09N411VO;
import com.miraeasset.biz.common.meta.vo.GA09N421VO;


@Repository
public class BNGN1000U0DaoImpl implements BNGN1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;


	/* 총무공지 내역조회 */
	@Override
	public List<BNGN1000U0Out00VO> selectListGA09N421(BNGN1000U0In00VO vo){
		return sqlSession.selectList("bngn_mapper.selectListGA09N421", vo);
	}	
	
	/* 총무공지 상세조회(PK) */
	@Override
	public BNGN1000U0Out01VO selectGA09N421PK(BNGN1000U0In01VO vo){
		return sqlSession.selectOne("bngn_mapper.selectGA09N421PK", vo);
	}		
	
	/* 총무공지 신규/수정(PK) */	
	@Override
	public int updateGA09N421(GA09N421VO vo){
		return sqlSession.update("bngn_mapper.updateGA09N421", vo);
	}	
	
	/* 총무공지 삭제수정  */	
	@Override
	public int updateDelGA09N421(GA09N421VO vo){
		return sqlSession.update("bngn_mapper.updateDelGA09N421", vo);
	}
	
	/* 총무공지 조회수 증가   */	
	@Override
	public int updateQryCnt(GA09N421VO vo){
		return sqlSession.update("bngn_mapper.updateQryCnt", vo);
	}
	
	/* 총무공지 신규 일련번호 채번 */
	@Override
	public BigDecimal selectNewSrno(GA09N421VO vo){
		return sqlSession.selectOne("bngn_mapper.selectNewSrno", vo);
	}	
   
}
