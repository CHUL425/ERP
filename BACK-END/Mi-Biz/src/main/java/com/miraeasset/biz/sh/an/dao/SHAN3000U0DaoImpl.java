package com.miraeasset.biz.sh.an.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.sh.an.vo.SHAN3000U0In00VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In01VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In02VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0Out00VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0Out01VO;


@Repository
public class SHAN3000U0DaoImpl implements SHAN3000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* 안전보건공지 확인 전체조회 */	
	@Override
	public List<SHAN3000U0Out00VO> selectShanCfmtList(SHAN3000U0In00VO vo) {
		return sqlSession.selectList("shan_mapper.selectShanCfmtList", vo);
	}
	
	
	/* 안전보건공지 확인 상세조회(확인용) */	
	@Override
	public SHAN3000U0Out01VO selectShanCfmtDlCn(SHAN3000U0In01VO vo) {
		return sqlSession.selectOne("shan_mapper.selectShanCfmtDlCn", vo);
	}

	
	/* 안전보건공지 확인처리 */
	@Override
	public int insertShanCfmtDlCn(SHAN3000U0In02VO vo) {
		return sqlSession.update("shan_mapper.insertShanCfmtDlCn", vo);
	}
	
}
