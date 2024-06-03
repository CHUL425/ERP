/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS5000U0DaoImpl.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 화면관리 DaoImpl
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA09N204VO;
import com.miraeasset.biz.common.meta.vo.GA09N208VO;
import com.miraeasset.biz.common.meta.vo.GA09N209VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out00VO;

@Repository
public class SSBS5000U0DaoImpl implements SSBS5000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	

    /* 화면관리 목록조회*/
	@Override
	public List<SSBS5000U0Out00VO> selectListGA09N204(SSBS5000U0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ssbs_mapper.selectListGA09N204", vo);
	}
	
    /* 화면관리 상세조회PK*/
	@Override
	public GA09N204VO selectGA09N204PK(GA09N204VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ssbs_mapper.selectGA09N204PK", vo);
	}
	
	/* 화면관리 신규등록 */	
	public int insertGA09N204(GA09N204VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("ssbs_mapper.insertGA09N204", vo);
	}      
		
	/* 화면관리 수정 */	
	public int updateGA09N204(GA09N204VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("ssbs_mapper.updateGA09N204", vo);
	}    
	
	/* 화면관리 삭제 */	
	public int deleteGA09N204(GA09N204VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("ssbs_mapper.deleteGA09N204", vo);
	}      
	
    /* 화면_담당사원 목록조회 화면ID 기준*/
	@Override
	public List<GA09N209VO> selectListGA09N209ByMenuId(GA09N209VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ssbs_mapper.selectListGA09N209ByMenuId", vo);
	}
	
	/* 화면_담당사원 신규등록 */	
	public int insertGA09N209(GA09N209VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("ssbs_mapper.insertGA09N209", vo);
	}      
    
	/* 화면_담당사원 삭제 화면ID 기준 */	
	public int deleteGA09N209ByMenuId(GA09N209VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("ssbs_mapper.deleteGA09N209ByMenuId", vo);
	}       
 
    /* 화면_검색키워드 내역조회  */
	@Override
	public List<GA09N208VO> selectListGA09N208VOByMenuId(GA09N208VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ssbs_mapper.selectListGA09N208VOByMenuId", vo);
	}	
	
    /* 화면_검색키워드 신규등록*/
	@Override
	public int insertGA09N208(GA09N208VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("ssbs_mapper.insertGA09N208", vo);
	}	

	/* 화면_검색키워드 삭제*/
	@Override
	public int deleteGA09N208(GA09N208VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("ssbs_mapper.deleteGA09N208", vo);
	}	

    /* 화면_검색키워드 삭제(화면id기준)*/
	@Override
	public int deleteGA09N208ByMenuId(GA09N208VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("ssbs_mapper.deleteGA09N208ByMenuId", vo);
	}	
    
	

}
