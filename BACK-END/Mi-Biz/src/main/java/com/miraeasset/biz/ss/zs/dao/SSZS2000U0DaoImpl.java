/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSZS2000U0DaoImpl.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 알림관리 DaoImpl
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.zs.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA01C001VO;
import com.miraeasset.biz.common.meta.vo.GA09N501VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In02VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0Out02VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0In00VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0In01VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0Out00VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0Out01VO;

@Repository
public class SSZS2000U0DaoImpl implements SSZS2000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	

	/* 알림관리 목록조회*/
	@Override
	public List<SSZS2000U0Out00VO> selectListGA09N501(SSZS2000U0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("sszs_mapper.selectListGA09N501", vo);
	}

	/* 알림관리 상세조회 */
	@Override
	public GA09N501VO selectGA09N501(GA09N501VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("sszs_mapper.selectGA09N501", vo);
	}
	
	/* 알림관리 신규등록 */	
	@Override
	public int insertGA09N501(GA09N501VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("sszs_mapper.insertGA09N501", vo);
	}    
    
	/* 알림관리 수정 */	
	@Override
	public int updateGA09N501(GA09N501VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("sszs_mapper.updateGA09N501", vo);
	}   
	
	/* 알림관리 삭제 */	
	@Override
	public int deleteGA09N501(GA09N501VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("sszs_mapper.deleteGA09N501", vo);
	}       

}
