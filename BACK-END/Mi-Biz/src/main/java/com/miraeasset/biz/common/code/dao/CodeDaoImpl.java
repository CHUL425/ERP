package com.miraeasset.biz.common.code.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.code.vo.Code00In00VO;
import com.miraeasset.biz.common.code.vo.Code00Out00VO;
import com.miraeasset.biz.common.code.vo.Code01In00VO;
import com.miraeasset.biz.common.code.vo.Code01Out00VO;
import com.miraeasset.biz.common.code.vo.GaCode00In00VO;
import com.miraeasset.biz.common.code.vo.GaCode00Out00VO;
import com.miraeasset.biz.common.code.vo.GaCode01In00VO;
import com.miraeasset.biz.common.code.vo.GaCode01Out00VO;
import com.miraeasset.biz.common.code.vo.GaSrno00In00VO;
import com.miraeasset.biz.common.code.vo.GaSrno00Out00VO;
import com.miraeasset.biz.common.code.vo.TeamCode00In00VO;
import com.miraeasset.biz.common.code.vo.TeamCode00Out00VO;
import com.miraeasset.biz.common.code.vo.TeamCode01In00VO;
import com.miraeasset.biz.common.code.vo.TeamCode01Out00VO;
import com.miraeasset.biz.common.code.vo.UserCode00In00VO;
import com.miraeasset.biz.common.code.vo.UserCode00Out00VO;


@Repository
public class CodeDaoImpl implements CodeDao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Code00Out00VO> selectListCode00(Code00In00VO vo) {
		return sqlSession.selectList("code_mapper.selectCode00List", vo);
	}	
	
	@Override
	public List<Code01Out00VO> selectListCode01(Code01In00VO vo) {
		return sqlSession.selectList("code_mapper.selectCode01List", vo);
	}		

	@Override
	public List<GaCode00Out00VO> selectListGaCode00(GaCode00In00VO vo) {
		return sqlSession.selectList("code_mapper.selectGaCode00List", vo);
	}
	
	@Override
	public List<GaCode01Out00VO> selectListGaCode01(GaCode01In00VO vo) {
		return sqlSession.selectList("code_mapper.selectGaCode01List", vo);
	}		
	
	/* 팀점코드팝업조회 */
	@Override
	public List<TeamCode00Out00VO> selectListTeamCode00(TeamCode00In00VO vo) {
		return sqlSession.selectList("code_mapper.selectTeamCode00List", vo);
	}

	/* 팀점코드팝업조회(검색일자) - 사용안함 */
	@Override
	public List<TeamCode01Out00VO> selectListTeamCode01(TeamCode01In00VO vo) {
		return sqlSession.selectList("code_mapper.selectTeamCode01List", vo);
	}
	
	/* 사원코드팝업 조회 */
	@Override
	public List<UserCode00Out00VO> selectListUserCode00(UserCode00In00VO vo) {
		return sqlSession.selectList("code_mapper.selectUserCode00List", vo);
	}
	
	/* 업무별 신규채번 조회 */
	@Override
	public List<GaCode01Out00VO> selectChaebun(GaCode01In00VO vo) {
		return sqlSession.selectList("code_mapper.selectChaebun", vo);
	}	
	
	/* 업무별 관리항목 조회 */ 
	@Override
	public List<GaCode01Out00VO> selectBzMtCode(GaCode01In00VO vo) {
		return sqlSession.selectList("code_mapper.selectBzMtCode", vo);
	}	

	/* 업무별 신규채번 수정 */
	@Override
	public int updateChaebun(GaCode01In00VO vo) {
		return sqlSession.update("code_mapper.updateChaebun", vo);
	}

	@Override
	public List<GaCode00Out00VO> selectListAtCode00(GaCode00In00VO vo) {
		return sqlSession.selectList("code_mapper.selectAtCode00List", vo);
	}

	@Override
	public List<GaCode01Out00VO> selectListAtCode01(GaCode01In00VO vo) {
		return sqlSession.selectList("code_mapper.selectAtCode01List", vo);
	}

	/* 업무별 관리항목코드 수정 */
	@Override
	public int updateBzMtCode(GaCode01In00VO vo) {
		return sqlSession.update("code_mapper.updateBzMtCode", vo);
	}
	
	/* 업무별 일련번호 채번 생성 2023.08.21 추가 */
	@Override
	public GaSrno00In00VO prbzSrnoGnoCrn(GaSrno00In00VO vo) {
		sqlSession.update("code_mapper.prbzSrnoGnoCrn", vo);
		return vo;
	}

	/* 알림 전송에 사용 할 메시지 조회 */
	@Override
	public Map<String, Object> selectMsgEnrollNotiTxt(Map<String, Object> map) {
		return sqlSession.selectOne("code_mapper.selectMsgEnrollNotiTxt", map);
	}


	/* 초기 화면 좋은(?) 문구 랜덤 출력 */
	@Override
	public GaCode01Out00VO selectGA09C302OrderRandom1Row(GaCode01In00VO vo) {
		return sqlSession.selectOne("code_mapper.selectGA09C302OrderRandom1Row", vo);
	}



}
