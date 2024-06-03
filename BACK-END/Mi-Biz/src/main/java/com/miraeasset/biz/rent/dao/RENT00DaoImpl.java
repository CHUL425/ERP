package com.miraeasset.biz.rent.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.rent.vo.RENT00In00VO;
import com.miraeasset.biz.rent.vo.RENT02In00VO;
import com.miraeasset.biz.rent.vo.RENT04In00VO;

@Repository
public class RENT00DaoImpl implements RENT00Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* 렌탈관리 조회 */
	@Override
	public List<RENT00In00VO> selectList00GA01N001(RENT00In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper.selectList00GA01N001", vo);
	}
	
	/* 렌탈관리요약정보조회 */
	@Override
	public List<RENT00In00VO> selectList01GA01N001(RENT00In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper.selectList01GA01N001", vo);
	}
	
	/* 연간렌탈료 조회 */
	@Override
	public List<RENT02In00VO> selectList02GA01N001(RENT02In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper.selectList02GA01N001", vo);
	}
	
	/* 연간렌탈료요약정보 조회*/
	@Override
	public List<RENT02In00VO> selectList03GA01N001(RENT02In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper.selectList03GA01N001", vo);
	}

	/* 렌탈제품조회(신청지점의 렌탈관리 조회) */
	@Override
	public List<RENT04In00VO> selectList04GA01N001(RENT04In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rent_mapper.selectList04GA01N001", vo);
	}

}
