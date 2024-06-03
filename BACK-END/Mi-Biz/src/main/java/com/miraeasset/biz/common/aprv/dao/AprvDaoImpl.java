package com.miraeasset.biz.common.aprv.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.aprv.vo.Aprv00In00VO;
import com.miraeasset.biz.common.aprv.vo.Aprv00Out00VO;
import com.miraeasset.biz.common.meta.vo.GA09N601InVO;
import com.miraeasset.biz.common.meta.vo.GA09N601OutVO;
import com.miraeasset.biz.common.meta.vo.GA09N602InVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf01InVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf01OutVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02InVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02OutVO;
import com.miraeasset.biz.common.meta.vo.GA09N606Pu01InVO;
import com.miraeasset.biz.common.meta.vo.GA09N606VO;
import com.miraeasset.biz.common.meta.vo.GA09N607Pu01InVO;
import com.miraeasset.biz.common.meta.vo.GA09N607VO;


@Repository
public class AprvDaoImpl implements AprvDao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	/* 승댄대기 내역조회 */	
	@Override
	public List<Aprv00Out00VO> selectAprvList(Aprv00In00VO vo){
		return sqlSession.selectList("aprv_mapper.selectAprvList", vo);
	}	
	
	/* 승인처리 단건(승인/반려) */	
	@Override
	public int updateGA09N607Aprv(GA09N607Pu01InVO vo)  {
		return sqlSession.update("aprv_mapper.updateGA09N607Aprv", vo);
	}	
	
	/* 결재사유내용 변경 */	
	@Override
	public int updateGA09N607RsnCn(GA09N607VO vo) {
		return sqlSession.update("aprv_mapper.updateGA09N607RsnCn", vo);
	}	
	
	/* 승인처리 단건(승인/반려) */	
	@Override
	public int updateGA09N606Aprv(GA09N606Pu01InVO vo)  {
		return sqlSession.update("aprv_mapper.updateGA09N606Aprv", vo);
	}		
	
	/* 결재선 조회 */
	@Override
	public List<GA09N601OutVO> selectAprvLine(GA09N601InVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("aprv_mapper.selectAprvLine", vo);
	}
	
	/* 결재선상세정보 등록 */
	@Override
	public int insertAprvLineDl(GA09N602InVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("aprv_mapper.insertAprvLineDl", vo);
	}
	
	/* 결재정보 등록 insert(PK) */	
	@Override
	public int insertGA09N606(GA09N606VO vo)  {
		return sqlSession.insert("aprv_mapper.insertGA09N606", vo);
	}	
			
	/* 결재상세정보 등록 insert(PK) */	
	@Override
	public int insertGA09N607(GA09N607VO vo)  {
		return sqlSession.insert("aprv_mapper.insertGA09N607", vo);
	}	
	
	/* 결재선내역조회 */	
	@Override
	public List<GA09N602Vf01OutVO> selectAprvLineList(GA09N602Vf01InVO vo) {
		return sqlSession.selectList("aprv_mapper.selectAprvLineList", vo);
	}	

	/* 다음결재정보 */	
	@Override
	public List<GA09N607VO> selectAprvNext(GA09N607VO vo) {
		return sqlSession.selectList("aprv_mapper.selectAprvNext", vo);
	}		
	
	/* 결재상세정보조회(PK) */	
	@Override
	public List<GA09N607VO> selectAprvDtlPk(GA09N607VO vo) {
		return sqlSession.selectList("aprv_mapper.selectAprvDtlPk", vo);
	}
	
	/* 결재상세정보조회(PK) */	
	@Override
	public List<GA09N606VO> selectGA09N606Pk(GA09N606VO vo) {
		return sqlSession.selectList("aprv_mapper.selectGA09N606Pk", vo);
	}
	
	/* 결재 - 사용자정보조회 */
	@Override
	public List<GA09N602Vf02OutVO> selectAprvWrrptUserInfoList(GA09N602Vf02InVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("aprv_mapper.selectAprvWrrptUserInfoList", vo);
	}
	
	/* 결재 모듈 - 결재선 생성 처리 */
	@Override
	public int insertAprvLine(GA09N607VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("aprv_mapper.insertAprvLine", vo);
	}
	
	/* 결재 모듈 - 결재 철회 정보 생성 */
	@Override
	public int insertGA09N607Wdral(GA09N607Pu01InVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("aprv_mapper.insertGA09N607Wdral", vo);
	}
	
	/* 업무담당자 여부 조회 */
	@Override
	public GA09N602Vf02OutVO selectBzChprYn(GA09N602Vf02InVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("aprv_mapper.selectBzChprYn", vo);
	}
	
	
	/* 2023.09.05 */
	/* 결재_결재정보상세 조회 */
	@Override
	public List<GA09N607VO> selectAprvWrrptDlList(GA09N607VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("aprv_mapper.selectAprvWrrptDlList", vo);
	}
	/* 참조, 다움대상결재자 조회 */
	@Override
	public GA09N607VO selectNextAprvWrrptList(GA09N607VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("aprv_mapper.selectNextAprvWrrptList", vo);
	}
	/* 결재상세정보 수정 */
	@Override
	public int updateAprvWrrpt(GA09N607VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("aprv_mapper.updateAprvWrrpt", vo);
	}
	
}
