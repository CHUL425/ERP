/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS6000U0DaoImpl.java
*	04. 작  성  일  자	: 2023.10.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹관리 DaoImpl
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA09N200VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out01VO;

@Repository
public class SSBS6000U0DaoImpl implements SSBS6000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* 사용자그룹 조회*/
	@Override
	public List<SSBS6000U0Out00VO> selectListGA09N200(SSBS6000U0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ssbs_mapper.selectListGA09N200", vo);
	}   
	
	/* 사용자그룹 상세조회*/
	@Override
	public SSBS6000U0Out01VO selectGA09N200(SSBS6000U0In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ssbs_mapper.selectGA09N200", vo);
	}   
	
	
	/* 사용자그룹 신규등록 */	
	public int insertGA09N200(GA09N200VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("ssbs_mapper.insertGA09N200", vo);
	}    
		
	/* 사용자그룹 수정 */	
	public int updateGA09N200(GA09N200VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("ssbs_mapper.updateGA09N200", vo);
	}    

	/* 사용자그룹 삭제 */	
	public int deleteGA09N200(GA09N200VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("ssbs_mapper.deleteGA09N200", vo);
	}    
	
}
