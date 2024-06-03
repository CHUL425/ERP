package com.miraeasset.biz.ga.em.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA01N301VO;
import com.miraeasset.biz.common.meta.vo.GA01N302VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In00VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In01VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In10VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0In11VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out00VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out01VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out10VO;
import com.miraeasset.biz.ga.em.vo.GAEM1000U0Out11VO;


@Repository
public class GAEM1000U0DaoImpl implements GAEM1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	/* 거래처 팝업 조회 */	
	@Override
	public List<GAEM1000U0Out10VO> selectAT05C010(GAEM1000U0In10VO vo){
		return sqlSession.selectList("gaem_mapper.selectAT05C010", vo);
	}	
	
	/* 업체관리 목록조회 */
	@Override
	public List<GAEM1000U0Out00VO> selectListGA01N301(GAEM1000U0In00VO vo){
		return sqlSession.selectList("gaem_mapper.selectListGA01N301", vo);
	}	
	
	/* 업체관리 상세조회(PK) */	
	@Override
	public List<GAEM1000U0Out01VO> selectGA01N301PK(GAEM1000U0In01VO vo){
		return sqlSession.selectList("gaem_mapper.selectGA01N301PK", vo);
	}		
	
	/* 업체관리 업체메모목록조회 */	
	@Override
	public List<GA01N302VO> selLstGA01N302ByDelpCd(GA01N302VO vo){
		return sqlSession.selectList("gaem_mapper.selLstGA01N302ByDelpCd", vo);
	}		
	
	/* 업체관리 수정(PK) */	
	@Override
	public int updateGA01N301(GA01N301VO vo){
		return sqlSession.update("gaem_mapper.updateGA01N301", vo);
	}	
	
	/* 업체관리 삭제(PK) */	
	@Override
	public int deleteGA01N301(GA01N301VO vo){
		return sqlSession.delete("gaem_mapper.deleteGA01N301", vo);
	}	


	/* 업체관리 업체별메모 삭제수정(PK) */	
	@Override
	public int updateDelGA01N302(GA01N302VO vo){
		return sqlSession.update("gaem_mapper.updateDelGA01N302", vo);
	}		
		
	/* 업체관리 신규등록 */
	@Override
	public int insertGA01N301(GA01N301VO vo){
		return sqlSession.insert("gaem_mapper.insertGA01N301", vo);
	}		

	/* 업체관리 업체별메모 신규등록 */
	@Override
	public int insertGA01N302(GA01N302VO vo){
		return sqlSession.insert("gaem_mapper.insertGA01N302", vo);
	}		

	/* 업체관리 업체계약현황조회 */
	@Override
	public List<GAEM1000U0Out11VO> selLstGA01N301ByDelpCd(GAEM1000U0In11VO vo) {
		return sqlSession.selectList("gaem_mapper.selLstGA01N301ByDelpCd", vo);
	}	    

}
