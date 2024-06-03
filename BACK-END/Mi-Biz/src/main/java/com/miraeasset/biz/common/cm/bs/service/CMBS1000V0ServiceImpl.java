package com.miraeasset.biz.common.cm.bs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.cm.bs.dao.CMBS1000V0Dao;
import com.miraeasset.biz.common.cm.bs.vo.CMBS1000V0In00VO;
import com.miraeasset.biz.common.cm.bs.vo.CMBS1000V0Out00VO;
import com.miraeasset.biz.common.exception.CustomNotFoundException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;

@Service
@Transactional
public class CMBS1000V0ServiceImpl implements CMBS1000V0Service {
	
	@Autowired
	CMBS1000V0Dao CMBS1000V0Dao;
	
	/* 계정과목조회 팝업 */
	@Override
	public List<CMBS1000V0Out00VO> select00AT01C001List(CMBS1000V0In00VO vo) {
		// TODO Auto-generated method stub
		return CMBS1000V0Dao.select00AT01C001List(vo);
	}

}
