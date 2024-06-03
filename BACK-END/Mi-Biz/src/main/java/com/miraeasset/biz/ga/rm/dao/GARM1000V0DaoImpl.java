package com.miraeasset.biz.ga.rm.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.ga.rm.vo.GARM1000ExcelVO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0In00VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0In01VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0In02VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0In03VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0In04VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out00VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out01VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out02VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out03VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out04VO;

@Repository
public class GARM1000V0DaoImpl implements GARM1000V0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* 렌탈관리 조회 */
	@Override
	public List<GARM1000V0Out00VO> selectList00GA01N001(GARM1000V0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("garm_mapper.selectList00GA01N001", vo);
	}
	
	/* 렌탈관리요약정보조회 */
	@Override
	public List<GARM1000V0Out01VO> selectList01GA01N001(GARM1000V0In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("garm_mapper.selectList01GA01N001", vo);
	}
	
	/* 연간렌탈료 조회 */
	@Override
	public List<GARM1000V0Out02VO> selectList02GA01N001(GARM1000V0In02VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("garm_mapper.selectList02GA01N001", vo);
	}
	
	/* 연간렌탈료요약정보 조회*/
	@Override
	public List<GARM1000V0Out03VO> selectList03GA01N001(GARM1000V0In03VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("garm_mapper.selectList03GA01N001", vo);
	}

	/* 렌탈제품조회(신청지점의 렌탈관리 조회) */
	@Override
	public List<GARM1000V0Out04VO> selectList04GA01N001(GARM1000V0In04VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("garm_mapper.selectList04GA01N001", vo);
	}
	
	/* 렌탈관리 엑셀 업로드 - 정수기 */
	@Override
	public int insert00GA01N001(GARM1000ExcelVO vo) {
		
		return sqlSession.insert("garm_mapper.insert00GA01N001", vo);
	}
	/* 렌탈관리 삭제 - 정수기 */
	@Override
	public int delete00GA01N001(GARM1000ExcelVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("garm_mapper.delete00GA01N001", vo);
	}

	/* 렌탈관리 삭제 - 정수기 정산년월 전체 삭제 */
	@Override
	public int delete01GA01N001(GARM1000ExcelVO vo) {
		return sqlSession.delete("garm_mapper.delete01GA01N001", vo);
	}

}
