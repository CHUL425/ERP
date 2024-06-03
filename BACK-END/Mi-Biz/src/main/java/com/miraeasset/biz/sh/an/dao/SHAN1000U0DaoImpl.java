package com.miraeasset.biz.sh.an.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA09N421VO;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0In01VO;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0Out01VO;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0Out02VO;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0Out03VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In01VO;


@Repository
public class SHAN1000U0DaoImpl implements SHAN1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	/* 안전보건공지 신규등록 */	
	@Override
	public int insertGA09N421Sh(GA09N421VO vo){
		return sqlSession.update("shan_mapper.insertGA09N421Sh", vo);
	}
	
	
	/* 안전보건공지 조회 */	
	@Override
	public List<SHAN1000U0Out01VO> selectListGA09N421Sh(SHAN1000U0In01VO vo){
		return sqlSession.selectList("shan_mapper.selectListGA09N421Sh", vo);
	}

	
	/* 안전보건공지 삭제전 확인이력존재여부 조회*/	
	@Override
	public SHAN1000U0Out02VO selectShanCfmtHst(SHAN3000U0In01VO vo) {
		return sqlSession.selectOne("shan_mapper.selectShanCfmtHst", vo);
	}
	
	
	/* 안전보건공지 초기화면 팝업조회	 */
	@Override
	public SHAN1000U0Out03VO selectShanInitPopup(String epno) {
		return sqlSession.selectOne("shan_mapper.selectShanInitPopup", epno);
	}	
	
}
