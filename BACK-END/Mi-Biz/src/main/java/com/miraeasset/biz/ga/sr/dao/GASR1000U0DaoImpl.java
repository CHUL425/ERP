package com.miraeasset.biz.ga.sr.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA01H502VO;
import com.miraeasset.biz.common.meta.vo.GA01N501VO;
import com.miraeasset.biz.common.meta.vo.GA01N503VO;
import com.miraeasset.biz.common.meta.vo.GA01N509VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0In00VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out00VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out11VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out12VO;
import com.miraeasset.biz.ga.sr.vo.GASR1000U0Out13VO;


@Repository
public class GASR1000U0DaoImpl implements GASR1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	
	/* 인장조제관리 목록조회 */
	@Override
	public List<GASR1000U0Out00VO> selectListGA01N501(GASR1000U0In00VO vo) {
		return sqlSession.selectList("gasr_mapper.selectListGA01N501", vo);
	}	
	
	/* 인장조제관리 목록조회 - 전체건수 */
	@Override
	public GASR1000U0Out00VO selectListGA01N501_Cnt(GASR1000U0In00VO vo) { 
		return sqlSession.selectOne("gasr_mapper.selectListGA01N501_Cnt", vo); 
	}
	
	/* 인장조제관리 인장유형 통계정보조회 */	
	@Override
	public GASR1000U0Out11VO selectInfoGA01N501BySalPcd(GASR1000U0In00VO vo) {
		return sqlSession.selectOne("gasr_mapper.selectInfoGA01N501BySalPcd", vo);
	}	
	
	/* 인장조제관리 인장상태 통계정보조회 */	
	@Override
	public GASR1000U0Out13VO selectInfoGA01N501BySalScd(GASR1000U0In00VO vo) {
		return sqlSession.selectOne("gasr_mapper.selectInfoGA01N501BySalScd", vo);
	}
	
	/* 인감날인 인감 콤보박스 */	
	public List<GASR1000U0Out12VO> selectListSealSalg() {
		return sqlSession.selectList("gasr_mapper.selectListSealSalg");
	}	

    /* 인감증명서 인감 콤보박스 */	
	public List<GASR1000U0Out12VO> selectListSealDoc() {
		return sqlSession.selectList("gasr_mapper.selectListSealDoc");
	}	
	
	/* 인장조제관리 상세정보조회(PK) */
	@Override
	public GA01N501VO selectGA01N501PK(GA01N501VO vo) {
		return sqlSession.selectOne("gasr_mapper.selectGA01N501PK", vo);
	}	
	
	/* 인장조제관리 접수 */
	@Override
	public int insertGA01N501(GA01N501VO vo) {
		return sqlSession.insert("gasr_mapper.insertGA01N501", vo);
	}	
	
	/* 인장조제관리_인장조제별기안문서 등록 */
	@Override
	public int insertGA01N509(GA01N509VO vo) {
		return sqlSession.insert("gasr_mapper.insertGA01N509", vo);
	}
	
	/* 인장조제관리 신청 */
	@Override
	public int insertGA01N101(GA01N501VO vo) {
		return sqlSession.insert("gasr_mapper.insertGA01N101", vo);
	}
	
	/* 인장조제관리_인장조제관리신청 신규등록 */	
	@Override
	public int insertGA01N503(GA01N503VO vo) {
		return sqlSession.insert("gasr_mapper.insertGA01N503", vo);
	}
	
	/* 인장조제관리_인장조제관리이력 신규등록 */
	@Override
	public int insertGA01H502(GA01H502VO vo) {
		return sqlSession.insert("gasr_mapper.insertGA01H502", vo);
	}
	
	/* 인장조제관리 수정 - 제작 */
	@Override
	public int updateGA01N501ByMAKG(GA01N501VO vo)  {
		return sqlSession.update("gasr_mapper.updateGA01N501ByMAKG", vo);
	}	
	
	/* 인장조제관리 수정 - 회수 */
	@Override
	public int updateGA01N501ByWTDW(GA01N501VO vo)  {
		return sqlSession.update("gasr_mapper.updateGA01N501ByWTDW", vo);
	}	
	
	/* 인장조제관리 수정 - 폐기 */
	@Override
	public int updateGA01N501ByDSUS(GA01N501VO vo)  {
		return sqlSession.update("gasr_mapper.updateGA01N501ByDSUS", vo);
	}	

	/* 인장조제관리 수정 - 변경 */
	@Override
	public int updateGA01N501ByCHNG(GA01N501VO vo)  {
		return sqlSession.update("gasr_mapper.updateGA01N501ByCHNG", vo);
	}
	
	/* 인장조제관리 수정 - 내용수정 */
	@Override
	public int updateGA01N501ByUPD(GA01N501VO vo)  {
		return sqlSession.update("gasr_mapper.updateGA01N501ByUPD", vo);
	}
	
	/* 인장조제관리 승인 */
	@Override
	public int updateGA01N501Aprv(GA01N501VO vo) {
		return sqlSession.update("gasr_mapper.updateGA01N501Aprv", vo);
	}	
	
	/* 인장조제관리 승인 - 기안문 수정 */
	@Override
	public int updateGA01N509Aprv(GA01N503VO vo) {
		return sqlSession.update("gasr_mapper.updateGA01N509Aprv", vo);
	}
	
	/* 인장조제관리 반려 */
	@Override
	public int updateGA01N501SealScd(GA01N501VO vo) {
		return sqlSession.update("gasr_mapper.updateGA01N501SealScd", vo);
	}
	/* 인장조제관리 반려 */
	@Override
	public int updateGA09N411UseYn(GA01N503VO vo) {
		return sqlSession.update("gasr_mapper.updateGA09N411UseYn", vo);
	}
	
	/* 인장조제관리 반려 - 데이터 롤백*/
	@Override
	public int updateGA01N501Rtrn(GA01N503VO vo) {
		return sqlSession.update("gasr_mapper.updateGA01N501Rtrn", vo);
	}
	/* 인장조제관리 반려 - 인장조제별기안문서 삭제*/
	@Override
	public int deleteGA01N509(GA01N509VO vo) {
		return sqlSession.update("gasr_mapper.deleteGA01N509", vo);
	}
	
    /* 인장조제관리 상태코드 조회 */
	public GA01N501VO selectGA01N501Scd(GA01N501VO vo) {
		return sqlSession.selectOne("gasr_mapper.selectGA01N501Scd", vo);
	} 
	
	/* 인장조제관리 상세정보조회(승인관리-상세) */
	@Override
	public GA01N501VO selectGA01N501Aprv(GA01N501VO vo) {
		return sqlSession.selectOne("gasr_mapper.selectGA01N501Aprv", vo);
	}

	 /* 인장관리번호 최신화(임시) */	
	@Override
	public List<GA01N501VO> selectGA01N501MaxNo() {
		return sqlSession.selectList("gasr_mapper.selectGA01N501MaxNo");
	}

	@Override
	public int updateCmnByGA01N501(List<GA01N501VO> list) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("list", list);
		return sqlSession.update("gasr_mapper.updateCmnByGA01N501", map);
	}
}

