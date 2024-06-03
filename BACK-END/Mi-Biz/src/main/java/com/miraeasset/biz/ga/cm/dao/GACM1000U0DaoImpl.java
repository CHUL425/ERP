package com.miraeasset.biz.ga.cm.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.AT01C001VO;
import com.miraeasset.biz.common.meta.vo.AT09N401VO;
import com.miraeasset.biz.common.meta.vo.GA01N303VO;
import com.miraeasset.biz.common.meta.vo.GA01N304VO;
import com.miraeasset.biz.common.meta.vo.GA01N306VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In00VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In01VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In10VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out00VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out01VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out10VO;


@Repository
public class GACM1000U0DaoImpl implements GACM1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	/* 계약서관리 내역조회 */
	@Override
	public List<GACM1000U0Out00VO> selectListGA01N303(GACM1000U0In00VO vo){
		return sqlSession.selectList("gacm_mapper.selectListGA01N303", vo);
	}	
	
	/* 계약서별계정과목코드 내역조회 */	
	@Override
	public List<GA01N304VO> selectListGA01N304(GA01N304VO vo){
		return sqlSession.selectList("gacm_mapper.selectListGA01N304", vo);
	}	
	
	/* 계약서별기안문서 내역조회  */	
	@Override
	public List<GA01N306VO> selectListGA01N306(GA01N306VO vo) {
		return sqlSession.selectList("gacm_mapper.selectListGA01N306", vo);
	}	
	
	/* 계약서관리 상세조회(PK) */		
	@Override
	public List<GACM1000U0Out01VO> selectGA01N303PK(GACM1000U0In01VO vo){
		return sqlSession.selectList("gacm_mapper.selectGA01N303PK", vo);
	}		
	
	/* 계약서별계정과목코드 상세조회(PK) */		
	@Override
	public List<GA01N304VO> selectGA01N304PK(GA01N304VO vo){
		return sqlSession.selectList("gacm_mapper.selectGA01N304PK", vo);
	}		
	
	/* 계약서별기안문서 상세조회(PK)  */		
	@Override
	public List<GA01N306VO> selectGA01N306PK(GA01N306VO vo){
		return sqlSession.selectList("gacm_mapper.selectGA01N306PK", vo);
	}		
	
	/* 기안문서 상세조회(PK) */	
	@Override
	public List<AT09N401VO> selectAT09N401PK(AT09N401VO vo) {
		return sqlSession.selectList("cmds_mapper.select00AT09N401PK", vo);
	}		
	
	/* 계정과목코드 상세조회(PK) */
	@Override
	public List<AT01C001VO> selectAT01C001PK(AT01C001VO vo) {
		return sqlSession.selectList("gacm_mapper.selectAT01C001PK", vo);
	}		
	   
	/* 계약서관리 수정(PK) */	
	@Override
	public int updateGA01N303(GA01N303VO vo){
		return sqlSession.update("gacm_mapper.updateGA01N303", vo);
	}			
	
	/* 계약서관리 삭제수정(PK) */	
	@Override
	public int updateDelGA01N303(GA01N303VO vo){
		return sqlSession.update("gacm_mapper.updateDelGA01N303", vo);
	}			
    
	/* 계약서관리 신규등록 */	
	@Override
	public int insertGA01N303(GA01N303VO vo){
		return sqlSession.insert("gacm_mapper.insertGA01N303", vo);
	}			
    
	/* 계약서별계정과목코드 신규등록 */	
	@Override
	public int insertGA01N304(GA01N304VO vo){
		return sqlSession.insert("gacm_mapper.insertGA01N304", vo);
	}		
	
	/* 계약서별기안문서 신규등록 */	
	@Override
	public int insertGA01N306(GA01N306VO vo){
		return sqlSession.insert("gacm_mapper.insertGA01N306", vo);
	}			
		
	
	/* 계약서별계정과목코드 삭제(부모키연계) */	
	@Override
	public int deleteGA01N304WithGA01N303(GA01N304VO vo) {
		return sqlSession.delete("gacm_mapper.deleteGA01N304WithGA01N303", vo);
	}			
	
	
	/* 계약서별기안문서 삭제(부모키연계) */	
	@Override
	public int deleteGA01N306WithGA01N303(GA01N306VO vo) {
		return sqlSession.delete("gacm_mapper.deleteGA01N306WithGA01N303", vo);
	}			

	/* 계약서관리 업체계약현황조회 */	
	@Override
	public List<GACM1000U0Out10VO> selLstGA01N303ByDelpCd(GACM1000U0In10VO vo) {
		return sqlSession.selectList("gacm_mapper.selLstGA01N303ByDelpCd", vo);
	}
	

}
