package com.miraeasset.biz.ga.sm.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA01N305VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In00VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0In01VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out00VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out01VO;
import com.miraeasset.biz.ga.sm.vo.GASM1000U0Out02VO;


@Repository
public class GASM1000U0DaoImpl implements GASM1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	/* RE100 계약관리 목록조회 */
	@Override
	public List<GASM1000U0Out00VO> selectListGA01N305(GASM1000U0In00VO vo) {
		return sqlSession.selectList("gasm_mapper.selectListGA01N305", vo);
	}	

	/* RE100 상세정보조회(PK) */
	@Override
	public List<GASM1000U0Out01VO> selectGA01N305PK(GASM1000U0In01VO vo) {
		return sqlSession.selectList("gasm_mapper.selectGA01N305PK", vo);
	}	
	
	/* RE100 상세정보조회(PK) - NUMBER) */
	@Override
	public List<GASM1000U0Out02VO> selectGA01N305PKNew(GASM1000U0In01VO vo) {
		return sqlSession.selectList("gasm_mapper.selectGA01N305PKNew", vo);
	}
	
	/* RE100 전체계약용량  */
	@Override
	public BigDecimal selectAllCapa() {
		return sqlSession.selectOne("gasm_mapper.selectAllCapa");
	}	

	
	/* RE100 수정(PK) */
	@Override
	public int updateGA01N305(GA01N305VO vo){
		return sqlSession.update("gasm_mapper.updateGA01N305", vo);
	}	
	
	/* RE100 삭제수정(PK) */
	@Override
	public int updateDelGA01N305(GA01N305VO vo){
		return sqlSession.update("gasm_mapper.updateDelGA01N305", vo);
	}	
		
	/* RE100 신규등록 */	
	@Override
	public int insertGA01N305(GA01N305VO vo){
		return sqlSession.insert("gasm_mapper.insertGA01N305", vo);
	}	
		

}
