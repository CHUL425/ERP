package com.miraeasset.biz.ga.pm.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA01N203VO;
import com.miraeasset.biz.common.meta.vo.GA01N301VO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf01InVO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf01OutVO;
import com.miraeasset.biz.common.meta.vo.GA09N606Pu01InVO;
import com.miraeasset.biz.common.meta.vo.GA09N606VO;
import com.miraeasset.biz.common.meta.vo.GA09N607Pu01InVO;
import com.miraeasset.biz.common.meta.vo.GA09N607VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In00VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In01VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out00VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out01VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out11VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In00VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0Out00VO;


@Repository
public class GAPM1000U0DaoImpl implements GAPM1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	/* 정기주차권관리 목록조회 */	
	@Override
	public List<GAPM1000U0Out00VO> selectListGA01N203(GAPM1000U0In00VO vo) {
		return sqlSession.selectList("gapm_mapper.selectListGA01N203", vo);
	}	
	
	/* 정기주차권관리 상세정보조회(PK) */	
	@Override
	public List<GAPM1000U0Out01VO> selectGA01N203PK(GAPM1000U0In01VO vo) {
		return sqlSession.selectList("gapm_mapper.selectGA01N203PK", vo);
	}	
		
	/* 정기주차권관리 주차대수요약정보 */
	@Override
	public List<GAPM1000U0Out11VO> selectParkCntInfo() {
		return sqlSession.selectList("gapm_mapper.selectParkCntInfo");
	}	
		
	/* 정기주차권관리 수정(PK) */	
	@Override
	public int updateGA01N203(GA01N203VO vo) {
		return sqlSession.update("gapm_mapper.updateGA01N203", vo);
	}		
	
	/* 정기주차권관리 삭제 */	
	@Override
	public int deleteGA01N203(GA01N203VO vo) {
		return sqlSession.delete("gapm_mapper.deleteGA01N203", vo);
	}		

	/* 정기주차권관리 신규등록 */	
	@Override
	public int insertGA01N203(GA01N203VO vo){
		return sqlSession.insert("gapm_mapper.insertGA01N203", vo);
	}

	/* [2023-09-06] 전체 DELETE 후 INSERT로 변경 요청 */
	@Override
	public int deleteAllGA01N203() {
		return sqlSession.delete("gapm_mapper.deleteAllGA01N203");
	}
	
}
