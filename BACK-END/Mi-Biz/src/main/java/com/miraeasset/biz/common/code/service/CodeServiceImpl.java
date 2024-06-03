package com.miraeasset.biz.common.code.service;


import java.util.List;

import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.util.StringUtils;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.code.dao.CodeDao;
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

@Service
@Transactional
public class CodeServiceImpl implements CodeService {

	@Autowired
	CodeDao CodeDao;

	@Override
	public List<Code00Out00VO> selectListCode00(Code00In00VO vo) {
		return CodeDao.selectListCode00(vo);
	}	
	
	@Override
	public List<Code01Out00VO> selectListCode01(Code01In00VO vo) {
		return CodeDao.selectListCode01(vo);
	}
	
	@Override
	public List<GaCode00Out00VO> selectListGaCode00(GaCode00In00VO vo) {
		return CodeDao.selectListGaCode00(vo);
	}
	
	@Override
	public List<GaCode01Out00VO> selectListGaCode01(GaCode01In00VO vo) {
		return CodeDao.selectListGaCode01(vo);
	}
	
	/* 팀점코드팝업조회 */
	@Override
	public List<TeamCode00Out00VO> selectListTeamCode00(TeamCode00In00VO vo, LoginOutVO loginOutVO) {
	
		/**	
		 * List<TeamCode00Out00VO> teamCode00Out00VOList = CodeDao.selectListTeamCode00(vo);

		// 로그인된 사원정보가 있고, 전체포함여부가 empty. 또는 "1"이 아닌 경우에, 필터링된 조직만 전송
		if(loginOutVO != null
				&& (StringUtils.isEmpty(vo.getAlIcldYn()) || !vo.getAlIcldYn().equals("1"))) {
			List<String> accsAblOrzCd = loginOutVO.getAccsAblOrzCd();

			int index = 0;
			while(index < teamCode00Out00VOList.size()) {
				String orzCd = teamCode00Out00VOList.get(index).getOrzCd();

				if(!accsAblOrzCd.contains(orzCd)) {
					teamCode00Out00VOList.remove(index);
				} else {
					index += 1;
				}
			}
		}
		*/
		
		// [2024.03.11] AlIcldYn 컬럼 삭제, 폐쇠조직포함여부 추가
		return CodeDao.selectListTeamCode00(vo);
	}
	
	/* 팀점코드팝업조회(검색일자) - 사용안함 */
	@Override
	public List<TeamCode01Out00VO> selectListTeamCode01(TeamCode01In00VO vo) {
		return CodeDao.selectListTeamCode01(vo);
	}
	
	/* 사원코드팝업 조회 */
	@Override
	public List<UserCode00Out00VO> selectListUserCode00(UserCode00In00VO vo) {
		return CodeDao.selectListUserCode00(vo);
	}
	
	@Override
	public List<GaCode01Out00VO> selectChaebun(GaCode01In00VO vo) {
		return CodeDao.selectChaebun(vo);
	}
	
	/* 업무별 관리항목 조회 */  
	@Override
	public List<GaCode01Out00VO> selectBzMtCode(GaCode01In00VO vo) {
		return CodeDao.selectBzMtCode(vo);
	}
	
	/* 업무별 관리항목 수정 */ 
	@Override
	public int updateBzMtCode(GaCode01In00VO vo) {
		return CodeDao.updateBzMtCode(vo);
	}

	@Override
	public List<GaCode00Out00VO> selectListAtCode00(GaCode00In00VO vo) {
		return CodeDao.selectListAtCode00(vo);
	}

	@Override
	public List<GaCode01Out00VO> selectListAtCode01(GaCode01In00VO vo) {
		return CodeDao.selectListAtCode01(vo);
	}

	/* 업무별 일련번호 채번 생성 2023.08.21 추가 */
	@Override
	public GaSrno00In00VO prbzSrnoGnoCrn(GaSrno00In00VO vo) {
		return CodeDao.prbzSrnoGnoCrn(vo);
	}

	/*
	* 파라미터 String 버전 추가_2023.10.13
	* */
	@Override
	public String prbzSrnoGnoCrn(String cmnCdVl) {
		GaSrno00In00VO vo = new GaSrno00In00VO();
		vo.setCdKndNo("CHAEBUN");
		vo.setCmnCdVl(cmnCdVl);
		GaSrno00In00VO rtnVo = CodeDao.prbzSrnoGnoCrn(vo);
		return rtnVo.getRpbzGnoSrno();
	}


	/* 초기 화면 좋은(?) 문구 랜덤 출력 */
	@Override
	public GaCode01Out00VO selectGA09C302OrderRandom1Row(GaCode01In00VO vo) {
		return CodeDao.selectGA09C302OrderRandom1Row(vo);
	}

	
}
