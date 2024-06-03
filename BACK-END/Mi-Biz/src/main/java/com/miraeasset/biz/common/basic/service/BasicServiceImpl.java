package com.miraeasset.biz.common.basic.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.basic.dao.BasicDao;
import com.miraeasset.biz.common.basic.vo.AprvOrg00VO;
import com.miraeasset.biz.common.basic.vo.BasicLoginHisInVO;
import com.miraeasset.biz.common.basic.vo.BasicLoginHisOutVO;
import com.miraeasset.biz.common.basic.vo.BasicOrg00In00VO;
import com.miraeasset.biz.common.basic.vo.BasicOrg00Out00VO;
import com.miraeasset.biz.common.basic.vo.BasicOrg01In00VO;
import com.miraeasset.biz.common.basic.vo.BasicOrg01Out00VO;
import com.miraeasset.biz.common.basic.vo.BasicPost00In00VO;
import com.miraeasset.biz.common.basic.vo.BasicPost00In01VO;
import com.miraeasset.biz.common.basic.vo.BasicPost00Out00VO;
import com.miraeasset.biz.common.basic.vo.BasicPost00Out01VO;
import com.miraeasset.biz.common.basic.vo.BasicUser00In00VO;
import com.miraeasset.biz.common.basic.vo.BasicUser00Out00VO;

@Service
@Transactional
public class BasicServiceImpl implements BasicService {

	@Autowired
	BasicDao BasicDao;

	@Override
	public List<BasicOrg00Out00VO> selectListOrg00(BasicOrg00In00VO vo) {
		return BasicDao.selectListOrg00(vo);
	}

	@Override
	public List<BasicOrg01Out00VO> selectOrg01(BasicOrg01In00VO vo) {
		return BasicDao.selectOrg01(vo);
	}
	
	@Override
	public List<BasicUser00Out00VO> selectListUser00(BasicUser00In00VO vo) {
		return BasicDao.selectListUser00(vo);
	}

	@Override
	public List<BasicLoginHisOutVO> selectListLoginHis(BasicLoginHisInVO vo) {
		return BasicDao.selectListLoginHis(vo);
	}
	
	@Override
	public List<BasicPost00Out00VO> selectPreSchw(BasicPost00In00VO vo) {
		return BasicDao.selectPreSchw(vo);
	}	
	
	@Override
	public List<BasicPost00Out01VO> selectUnifAdr(BasicPost00In01VO vo) {
		return BasicDao.selectUnifAdr(vo);
	}
	
	/* 결재선 조직도 조회 */
	@Override
	public List<AprvOrg00VO> selectAprvOrgList(AprvOrg00VO vo) {
		// TODO Auto-generated method stub
		return BasicDao.selectAprvOrgList(vo);
	}	
	
	
}
