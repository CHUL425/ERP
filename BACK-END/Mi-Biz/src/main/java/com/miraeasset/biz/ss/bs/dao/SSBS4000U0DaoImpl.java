/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS4000U0DaoImpl.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 메뉴관리 DAO
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA09N203VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0Out00VO;

@Repository
public class SSBS4000U0DaoImpl implements SSBS4000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
		
    /* 메뉴관리 목록조회 */
	@Override
	public List<SSBS4000U0Out00VO> selectListGA09N203(SSBS4000U0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ssbs_mapper.selectListGA09N203", vo);
	}

    /* 메뉴관리 상세조회 PK */
	@Override
	public GA09N203VO selectGA09N203PK(GA09N203VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ssbs_mapper.selectGA09N203PK", vo);
	}
	
    /* 메뉴관리 매뉴ID 채번 */
	@Override
	public GA09N203VO selectNewMenuIdGA09N203() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ssbs_mapper.selectNewMenuIdGA09N203");
	}
	
	
	/* 메뉴관리 신규등록 */	
	public int insertGA09N203(GA09N203VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("ssbs_mapper.insertGA09N203", vo);
	}    	    
    
	/* 메뉴관리 수정 */	
	public int updateGA09N203(GA09N203VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("ssbs_mapper.updateGA09N203", vo);
	}

    /* 메뉴관리 화면툴력순서 재설정내역조회  */
	@Override
	public List<GA09N203VO> selectListGA09N203NewSqn(GA09N203VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ssbs_mapper.selectListGA09N203NewSqn", vo);
	}	
	
	/* 메뉴관리 화면툴력순서 변경 */	
	@Override
	public int updateGA09N203NewSqn(GA09N203VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("ssbs_mapper.updateGA09N203NewSqn", vo);
	}    
	
	/* 메뉴관리 삭제 */	
	@Override
	public int deleteGA09N203(GA09N203VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("ssbs_mapper.deleteGA09N203", vo);
	} 
	

}
