package com.miraeasset.biz.common.cm.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.cm.cs.dao.CMCS1000V0Dao;
import com.miraeasset.biz.common.cm.cs.vo.CMCS1000V0In00VO;
import com.miraeasset.biz.common.cm.cs.vo.CMCS1000V0Out00VO;

@Service
@Transactional
public class CMCS1000V0ServiceImpl implements CMCS1000V0Service {
	
	@Autowired
	CMCS1000V0Dao dao;
	
	/* 계약번호팝업리스트조회 */
	@Override
	public List<CMCS1000V0Out00VO> selectList00AT08N100(CMCS1000V0In00VO vo) {
		// TODO Auto-generated method stub
		return dao.selectList00AT08N100(vo);
	}

}
