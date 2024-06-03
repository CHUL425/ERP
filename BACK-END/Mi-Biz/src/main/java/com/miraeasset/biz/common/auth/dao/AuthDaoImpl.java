package com.miraeasset.biz.common.auth.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.auth.vo.Auth00In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N200In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N201In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N202In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N203In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N203Out00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N204In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N204Out00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N205In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N207In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N207Out00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N208In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N208Out00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N502In00VO;
import com.miraeasset.biz.common.auth.vo.AuthGA09N502Out00VO;


@Repository
public class AuthDaoImpl implements AuthDao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

//	[20231024] 삭제 테이블 주석처리
//	@Override
//	public List<Auth00In00VO> selectListAuth00(Auth00In00VO vo) {
//		return sqlSession.selectList("auth_mapper.selectAuth00List", vo);
//	}
	
	@Override
	public List<AuthGA09N200In00VO> selectListGA09N200(AuthGA09N200In00VO vo) {
		return sqlSession.selectList("auth_mapper.selectListGA09N200", vo);
	}	
	
	@Override
	public List<AuthGA09N201In00VO> selectListGA09N201(AuthGA09N201In00VO vo) {
		return sqlSession.selectList("auth_mapper.selectListGA09N201", vo);
	}	

//	[20231024] 삭제 테이블 주석처리
//	@Override
//	public List<AuthGA09N202In00VO> selectListGA09N202(AuthGA09N202In00VO vo) {
//		return sqlSession.selectList("auth_mapper.selectListGA09N202", vo);
//	}
	
	@Override
	public List<AuthGA09N205In00VO> selectListGA09N205(AuthGA09N205In00VO vo) {
		return sqlSession.selectList("auth_mapper.selectListGA09N205", vo);
	}
	
//	/* 권한별 상위메뉴리스트 조회 */
//	[20231024] 삭제 테이블 주석처리
//	@Override
//	public List<AuthGA09N203Out00VO> selectList00GA09N203(AuthGA09N203In00VO vo) {
//		// TODO Auto-generated method stub
//		return sqlSession.selectList("auth_mapper.selectList00GA09N203", vo);
//	}

//	/* 권한별 메뉴리스트 조회 */
//	[20231024] 삭제 테이블 주석처리
//	@Override
//	public List<AuthGA09N204Out00VO> selectList00GA09N204(AuthGA09N204In00VO vo) {
//		// TODO Auto-generated method stub
//		return sqlSession.selectList("auth_mapper.selectList00GA09N204", vo);
//	}
	
	/* 즐겨찾기조회 */
	@Override
	public List<AuthGA09N207Out00VO> selectList00GA09N207(AuthGA09N207In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("auth_mapper.selectList00GA09N207", vo);
	}
	
	/* 즐겨찾기등록 */
	@Override
	public int insert00GA09N207(AuthGA09N207In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("auth_mapper.insert00GA09N207", vo);
	}
	
	/* 즐겨찾기삭제 */
	@Override
	public int delete00GA09N207(AuthGA09N207In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("auth_mapper.delete00GA09N207", vo);
	}
	
	/* 태그 검색 조회 */
	@Override
	public List<AuthGA09N208Out00VO> selectSrch(AuthGA09N208In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("auth_mapper.selectSrch", vo);
	}
	
	/* 알림벨 리스트 조회 */
	@Override
	public List<AuthGA09N502Out00VO> selectIprtList(AuthGA09N502In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("auth_mapper.selectIprtList", vo);
	}
	
	/* 알림벨 읽기여부 업데이트 */
	@Override
	public int updateIprtReadYn(AuthGA09N502In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("auth_mapper.updateIprtReadYn", vo);
	}
	
	/* 알림읽음상태 조회 */
	@Override
	public AuthGA09N502Out00VO selectIprtReadStat(AuthGA09N502In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("auth_mapper.selectIprtReadStat", vo);
	}

}
