package com.miraeasset.biz.common.login.service;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.dao.LoginDao;
import com.miraeasset.biz.common.login.vo.LoginInVO;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.login.vo.LoginUserMenuVO;
import com.miraeasset.biz.common.login.vo.LoginUserPracticeHistoryVO;
import com.miraeasset.biz.common.meta.vo.CB01N210VO;
import com.miraeasset.biz.common.service.CommonService;
import com.miraeasset.biz.ss.bs.service.SSBS1000V0Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

	private final LoginDao loginDao;
	private final SSBS1000V0Service ssbs1000V0Service;

	private final CommonService commonService;

	@Autowired
	public LoginService(LoginDao loginDao, SSBS1000V0Service ssbs1000V0Service, CommonService commonService) {
		this.loginDao = loginDao;
		this.ssbs1000V0Service = ssbs1000V0Service;
		this.commonService = commonService;
	}

	public LoginOutVO selectOneUserInfo(LoginInVO vo) {
		// 기본 사원정보 setting
		LoginOutVO result = loginDao.selectOneUserInfo(vo);
//		result.setOptrId(result.getEpno());
//		result.setOprtOrzCd(result.getBlngOrzCd());
//		result.setOprtChnlCd("000");

		// 접근가능조직 setting
		List<String> accsAblOrzCdList = this.selelctListAccsAblOrzCd(result);
		result.setAccsAblOrzCd(accsAblOrzCdList);

		// 사용자그룹코드 setting
		List<String> userGrpCdList = this.selectListUserGrpCd(result);
		result.setUserGrpCdList(userGrpCdList);

		// 메뉴리스트 setting
		List<LoginUserMenuVO> loginUserMenuVOList = this.selectListLoginUserMenu(result);
		result.setLoginUserMenuVOList(loginUserMenuVOList);

		// 사원 BLNG_ORZ_CD의 LK_MT_ORZ_CD 획득
		String lnkMtOrzCd = loginDao.selectOneLkMtOrzCd(result.getBlngOrzCd());
		result.setLnkMtOrzCd(lnkMtOrzCd);

		// 사원 LK_MT_ORZ_CD의 HOBR_TCD 획득
		/**
		 * [20240126]
		 * Sage솔루션팀(200511), 신탁운용팀(200163)의 LNK_MT_ORZ_CD의 HOBR_TCD가 '02'로 WM팀과 마찬가지로 지점임
		 * 하지만 두 팀은 본사와 유사한 조직임(메신저상 조직트리에서 상위조직이 지점이 아님)
		 * 따라서 두 조직의 LNK_MT_ORZ_CD를 가진 경우 본사로 재분류
		 * 현재 하드코딩 되어있으나 차후 좋은 방법이 있으면 수정바람...
		 * */
		String hobrTcd = loginDao.selectOneHobrTcd(result.getLnkMtOrzCd());
		if( (lnkMtOrzCd.equals("200511") && !result.getBlngOrzCd().equals("200511")) ||
				(lnkMtOrzCd.equals("200163") && !result.getBlngOrzCd().equals("200163")) ) {
			hobrTcd = loginDao.selectOneHobrTcd(result.getBlngOrzCd()); // 자기 자신의 본지점구분코드(본사)를 사용
		}
		result.setHobrTcd(hobrTcd);

		// [20240123] 조직 대표자여부 획득
		String orzRptvYn = "N";
		String blngOrzCd = result.getBlngOrzCd();
		CB01N210VO cb01N210VO = commonService.selectOneCB01N210ByOrzCd(blngOrzCd);
		if(cb01N210VO != null) {
			if(vo.getUserId().equals(cb01N210VO.getOrzRptvEpno())) orzRptvYn = "Y";
		}
		result.setOrzRptvYn(orzRptvYn);
		
		return result;
	}

	/**
	 * 접근가능조직 리스트
	 * */
	public List<String> selelctListAccsAblOrzCd(LoginOutVO loginOutVO) {
		if(loginOutVO == null) {
			throw new CustomBadRequestException("로그인 정보가 없어요.", ErrorCode.UNAUTHORIZED);
		}

		List<String> accsAblOrzCdList = loginDao.selelctListAccsAblOrzCd(loginOutVO);
		return accsAblOrzCdList;
	}

	/**
	 * 사용자그룹코드 리스트
	 * */
	public List<String> selectListUserGrpCd(LoginOutVO loginOutVO) {
		if(loginOutVO == null) {
			throw new CustomBadRequestException("로그인 정보가 없어요.", ErrorCode.UNAUTHORIZED);
		}

		List<String> userGrpCdList = loginDao.selectListUserGrpCd(loginOutVO);


		// [20231214] 사용자그룹 없으면 일반사용자 권한 추가, 시스템 권한 팀점이면 시스템관리자 권한 추가
		List<String> sysAuthOrzCd = loginDao.selectSysAuthOrzCd();

		if(userGrpCdList == null || userGrpCdList.size() == 0) {
			userGrpCdList = new ArrayList<>();
			userGrpCdList.add("000"); // 일반사용자
		}

		if(sysAuthOrzCd.contains(loginOutVO.getBlngOrzCd())) {
			if(!!!userGrpCdList.contains("999")) {
				userGrpCdList.add("999"); // 시스템관리자
			}
		}



		return userGrpCdList;
	}

	/**
	 * 접근가능화면 리스트
	 * */
	public List<LoginUserMenuVO> selectListLoginUserMenu(LoginOutVO loginOutVO) {
		if(loginOutVO == null) {
			throw new CustomBadRequestException("로그인 정보가 없어요.", ErrorCode.UNAUTHORIZED);
		}

		if(loginOutVO.getUserGrpCdList() == null || loginOutVO.getUserGrpCdList().size() < 1) {
			List<String> userGrpCdList = loginDao.selectListUserGrpCd(loginOutVO);
			List<String> defaultGrpCdList = new ArrayList<String>(){{ add("000"); }};
			loginOutVO.setUserGrpCdList(userGrpCdList != null && userGrpCdList.size() > 0 ? userGrpCdList : defaultGrpCdList);
		}

		return loginDao.selectListLoginUserMenu(loginOutVO);
	}

	/* 로그인 시간 기록 */
	public int insertLoginUserHistory(LoginOutVO loginOutVO) {
		return loginDao.insertLoginUserHistory(loginOutVO);
	}
	/* 로그아웃 시간 기록 */
	public int updateLoginUserHistory(LoginOutVO loginOutVO) {
		return loginDao.updateLoginUserHistory(loginOutVO);
	}

	/* 화면 실행 이력 */
	public int insertLoginUserPracticeHistory(LoginUserPracticeHistoryVO loginUserPracticeHistoryVO) {
		return loginDao.insertLoginUserPracticeHistory(loginUserPracticeHistoryVO);
	}
}
