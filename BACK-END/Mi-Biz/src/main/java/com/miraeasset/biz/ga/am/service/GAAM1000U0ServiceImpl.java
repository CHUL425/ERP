package com.miraeasset.biz.ga.am.service;

import java.util.Arrays;
import java.util.List;

import org.apache.tika.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.meta.vo.GA03N101VO;
import com.miraeasset.biz.ga.am.dao.GAAM1000U0Dao;
import com.miraeasset.biz.ga.am.vo.GAAM1000U0In00VO;
import com.miraeasset.biz.ga.am.vo.GAAM1000U0In01VO;

@Service
@Transactional
public class GAAM1000U0ServiceImpl implements GAAM1000U0Service {
	
	@Autowired
	GAAM1000U0Dao dao;

	/**
	 * 구매물품코드별 조회
	 */
	@Override
	public GA03N101VO selectAtclInfo(GAAM1000U0In00VO vo) {
		return dao.selectAtclInfo(vo);
	}

	@Override
	public List<GA03N101VO> selectAtclList(GAAM1000U0In01VO vo) {
		if(!StringUtils.isBlank(vo.getAtclTcd())) {
			vo.setArrAtclTcd(Arrays.asList(vo.getAtclTcd().split(",")));
		}
		
		GA03N101VO tmp = dao.selectAtclList_CNT(vo);
		vo.setTotCnt(tmp.getTotCnt());
		
		return dao.selectAtclList(vo);
	}
	
}
