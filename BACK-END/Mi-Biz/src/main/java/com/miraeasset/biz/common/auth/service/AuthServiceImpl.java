package com.miraeasset.biz.common.auth.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.auth.dao.AuthDao;
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
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.CustomNotFoundException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

	@Autowired
	AuthDao AuthDao;
	
//	/* 사용자의 화면별처리가능내역조회 */
//	[20231024] 삭제 테이블 주석처리
//	@Override
//	public List<Auth00In00VO> selectListAuth00(Auth00In00VO vo) {
//
//		if (vo.getEpno() == null || vo.getEpno().equals("")) {
//			throw new CustomBadRequestException("사원번호를 확인해주세요. 입력된 사원번호: ["+vo.getEpno()+"]", ErrorCode.BAD_REQUEST);
//		}
//
//		return AuthDao.selectListAuth00(vo);
//	}
	
	/* 사용자그룹 기본조회 */
	@Override
	public List<AuthGA09N200In00VO> selectListGA09N200(AuthGA09N200In00VO vo) {
		
		return AuthDao.selectListGA09N200(vo);
	}	
	
	/* 사원별사용자그룹 기본조회 */
	@Override
	public List<AuthGA09N201In00VO> selectListGA09N201(AuthGA09N201In00VO vo) {
		return AuthDao.selectListGA09N201(vo); 
	}		
	
//	/* 조직별사용자그룹 기본조회 */
//	[20231024] 삭제 테이블 주석처리
//	@Override
//	public List<AuthGA09N202In00VO> selectListGA09N202(AuthGA09N202In00VO vo) {
//		return AuthDao.selectListGA09N202(vo);
//	}
	
	/* 사용자그룹별화면 기본조회 */
	@Override
	public List<AuthGA09N205In00VO> selectListGA09N205(AuthGA09N205In00VO vo) {
		return AuthDao.selectListGA09N205(vo);
	}
	
//	/* 권한별 상위메뉴리스트 조회 */
//	[20231024] 삭제 테이블 주석처리
//	@Override
//	public List<AuthGA09N203Out00VO> selectList00GA09N203(AuthGA09N203In00VO vo) {
//		// TODO Auto-generated method stub
//		return AuthDao.selectList00GA09N203(vo);
//	}
	
//	/* 권한별 메뉴리스트 조회 */
//	[20231024] 삭제 테이블 주석처리
//	@Override
//	public List<AuthGA09N204Out00VO> selectList00GA09N204(AuthGA09N204In00VO vo) {
//		// TODO Auto-generated method stub
//		return AuthDao.selectList00GA09N204(vo);
//	}
	
	/* 즐겨찾기조회 */
	@Override
	public List<AuthGA09N207Out00VO> selectList00GA09N207(AuthGA09N207In00VO vo) {
		// TODO Auto-generated method stub
		return AuthDao.selectList00GA09N207(vo);
	}
	
	/* 즐겨찾기등록 */
	@Override
	public List<AuthGA09N207Out00VO> insert00GA09N207(AuthGA09N207In00VO vo) {
		// TODO Auto-generated method stub
		int cnt = 0;
		cnt = AuthDao.insert00GA09N207(vo);
		
		List<AuthGA09N207Out00VO> list = new ArrayList<AuthGA09N207Out00VO>();
		if (cnt > 0) {
			list = AuthDao.selectList00GA09N207(vo);
		}
		return list;
	}
	
	/* 즐겨찾기삭제 */
	@Override
	public List<AuthGA09N207Out00VO> delete00GA09N207(AuthGA09N207In00VO vo) {
		// TODO Auto-generated method stub
		
		/* 삭세 대상건 조회 */
		AuthGA09N207In00VO selVo = new AuthGA09N207In00VO();
		selVo.setEpno(vo.getEpno());
		List<AuthGA09N207Out00VO> list;
		list = AuthDao.selectList00GA09N207(selVo);
		/* 삭제 대상건 체크*/
		AuthGA09N207Out00VO chkList = new AuthGA09N207Out00VO();;
		int cnt = 0;

		for( int i = 0; i < list.size(); i++) {
			chkList = list.get(i);
			
			if (chkList.getPsitMenuId().equals(vo.getPsitMenuId())) {
				cnt = 1;
			}
		}
		
		list = new ArrayList<AuthGA09N207Out00VO>();
		/* 삭제 대상건이 있으면 삭제 처리 */
		if (cnt > 0) {
			AuthDao.delete00GA09N207(vo);
			list = AuthDao.selectList00GA09N207(selVo);
		} else {
//			throw new CustomNotFoundException("즐겨찾기 삭제대상건이 존재하지않습니다.", ErrorCode.RESOURCE_NOT_FOUND);
		}
		return list;
	}
	
	/* 태그 검색 조회 */
	@Override
	public List<AuthGA09N208Out00VO> selectSrch(AuthGA09N208In00VO vo) {
		// TODO Auto-generated method stub
		return AuthDao.selectSrch(vo);
	}
	
	/* 알림벨 조회 */
	@Override
	public List<AuthGA09N502Out00VO> selectIprtList(AuthGA09N502In00VO vo) {
		// TODO Auto-generated method stub
		return AuthDao.selectIprtList(vo);
	}
	
	/* 알림 읽음 상태 변경 */
	@Override
	public List<AuthGA09N502Out00VO> updateIprtReadYn(AuthGA09N502In00VO vo) {
		// TODO Auto-generated method stub
		int cnt = 0;
		
		cnt = AuthDao.updateIprtReadYn(vo);
		
		List<AuthGA09N502Out00VO> list;
		list = new ArrayList<AuthGA09N502Out00VO>();
		if (cnt > 0) {
			list = AuthDao.selectIprtList(vo);
		}
		
		return list;
	}
	
	/* 알림읽음상태 조회 */
	@Override
	public AuthGA09N502Out00VO selectIprtReadStat(AuthGA09N502In00VO vo) {
		// TODO Auto-generated method stub
		return AuthDao.selectIprtReadStat(vo);
	}
	
	

}
