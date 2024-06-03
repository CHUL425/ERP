package com.miraeasset.biz.ga.rm.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.ga.rm.vo.GARM2000ExcelVO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0In00VO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0In01VO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0Out00VO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0Out01VO;
import com.miraeasset.biz.ga.rm.vo.GARM2010V0In00VO;
import com.miraeasset.biz.ga.rm.vo.GARM2010V0In01VO;
import com.miraeasset.biz.ga.rm.vo.GARM2010V0Out00VO;

@Repository
public class GARM2000V0DaoImpl implements GARM2000V0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* 렌탈관리(복합기) 조회 */
	@Override
	public List<GARM2000V0Out00VO> selectList00GA01N003(GARM2000V0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("garm_mapper.selectList00GA01N003", vo);
	}
	
	/* 렌탈관리요약정보(복합기) 조회 */
	@Override
	public List<GARM2000V0Out01VO> selectList01GA01N003(GARM2000V0In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("garm_mapper.selectList01GA01N003", vo);
	}
	
	/* 연간렌탈료 정산(계산) 조회 */
	@Override
	public List<GARM2010V0Out00VO> selectList02GA01N003(GARM2010V0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("garm_mapper.selectList02GA01N003", vo);
	}
	
	/* 연간렌탈료 정산(계산) 수정 */
	@Override
	public int update00GA01N003(GARM2010V0In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("garm_mapper.update00GA01N003", vo);
	}
	
	/* 렌탈관리 엑셀업로드 - 복합기 */
	@Override
	public int insert00GA01N003(GARM2000ExcelVO vo){
		// TODO Auto-generated method stub
		return sqlSession.insert("garm_mapper.insert00GA01N003", vo);
	}
	
	/* 렌탈관리 삭제 - 복합기 */
	@Override
	public int delete00GA01N003(GARM2000ExcelVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("garm_mapper.delete00GA01N003", vo);
	}

	/* 렌탈관리 삭제 - 복합기 정산년월 전체 삭제 */
	@Override
	public int delete01GA01N003(GARM2000ExcelVO vo) {
		return sqlSession.delete("garm_mapper.delete01GA01N003", vo);
	}

	/* 복합기 정산년월 단가 조회 */
	@Override
	public GARM2010V0In01VO selectOne00GA01N003(GARM2010V0In01VO garm2010V0In01VO) {
		return sqlSession.selectOne("garm_mapper.selectOne00GA01N003", garm2010V0In01VO);
	}

}
