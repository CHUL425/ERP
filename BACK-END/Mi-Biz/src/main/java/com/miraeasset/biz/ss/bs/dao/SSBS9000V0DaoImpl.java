/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS9000V0DaoImpl.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 판관비계정관리 DAO
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA01C001VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In02VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0Out02VO;

@Repository
public class SSBS9000V0DaoImpl implements SSBS9000V0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* 판관비판관비계정과목관리 조회 */
	@Override
	public List<SSBS9000V0Out00VO> selectList00GA01C001(SSBS9000V0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ssbs_mapper.selectList00GA01C001", vo);
	}

	/* 판관비판관비계정과목관리 상세조회 */
	@Override
	public SSBS9000V0Out02VO selectGA01C001(SSBS9000V0In02VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ssbs_mapper.selectGA01C001", vo);
	}
	
	/* 판관비판관비계정과목관리 신규등록 */	
	@Override
	public int insertGA01C001(GA01C001VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("ssbs_mapper.insertGA01C001", vo);
	}
	
	/* 판관비판관비계정과목관리 수정 */	
	@Override
	public int updateGA01C001(GA01C001VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("ssbs_mapper.updateGA01C001", vo);
	}
	
	/* 판관비판관비계정과목관리 삭제 */	
	@Override
	public int deleteGA01C001(GA01C001VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("ssbs_mapper.deleteGA01C001", vo);
	}

	

}
