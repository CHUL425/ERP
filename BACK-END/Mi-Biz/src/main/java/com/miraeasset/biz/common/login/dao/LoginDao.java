package com.miraeasset.biz.common.login.dao;

import com.miraeasset.biz.common.login.vo.LoginInVO;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.login.vo.LoginUserMenuVO;
import com.miraeasset.biz.common.login.vo.LoginUserPracticeHistoryVO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000VOOut00VO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class LoginDao {
	
	@Resource(name="sqlSessionTemplate")
	private final SqlSessionTemplate sqlSession;

	@Autowired
	public LoginDao(@Qualifier("sqlSessionTemplate") SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public LoginOutVO selectOneUserInfo(LoginInVO vo) {
		LoginOutVO result = sqlSession.selectOne("login_mapper.selectOneUserInfo", vo);

		if(result == null) {
			return null;
		}

		if(result.getHrOsdtCdNm() == null || result.getHrOsdtCdNm().equals("")) {
			result.setHrOsdtPstNm(result.getHrPstCdNm());
		} else {
			result.setHrOsdtPstNm(result.getHrOsdtCdNm());
		}

		return result;
	}

	public List<String> selelctListAccsAblOrzCd(LoginOutVO loginOutVO) {
		return sqlSession.selectList("login_mapper.selelctListAccsAblOrzCd", loginOutVO);
	}

	public List<String> selectListUserGrpCd(LoginOutVO loginOutVO) {
		return sqlSession.selectList("login_mapper.selectListUserGrpCd", loginOutVO);
	}

	public List<SSBS7000VOOut00VO> selectListAccsAblMenu(String usrGrpCd) {
		return sqlSession.selectList("login_mapper.selectListAccsAblMenu", usrGrpCd);
	}

	public String selectOneLkMtOrzCd(String blngOrzCd) {
		return sqlSession.selectOne("login_mapper.selectOneLnkMtOrzCd", blngOrzCd);
	}

	public String selectOneHobrTcd(String lnkMtMorzCd) {
		return sqlSession.selectOne("login_mapper.selectOneHobrTcd", lnkMtMorzCd);
	}

	public List<LoginUserMenuVO> selectListLoginUserMenu(LoginOutVO loginOutVO) {
		return sqlSession.selectList("login_mapper.selectListLoginUserMenu", loginOutVO);
	}

	public int insertLoginUserHistory(LoginOutVO loginOutVO) {
		return sqlSession.insert("login_mapper.insertLoginUserHistory", loginOutVO);
	}

	public int updateLoginUserHistory(LoginOutVO loginOutVO) {
		return sqlSession.update("login_mapper.updateLoginUserHistory", loginOutVO);
	}

	public int insertLoginUserPracticeHistory(LoginUserPracticeHistoryVO loginUserPracticeHistoryVO) {
		return sqlSession.insert("login_mapper.insertLoginUserPracticeHistory", loginUserPracticeHistoryVO);
	}

	// [20231214] 사용자그룹 없으면 일반사용자 권한 추가, 시스템 권한 팀점이면 시스템관리자 권한 추가
	public List<String> selectSysAuthOrzCd() {
		return sqlSession.selectList("login_mapper.selectSysAuthOrzCd");
	}
}
