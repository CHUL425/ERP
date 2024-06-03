package com.miraeasset.biz.budget.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.budget.dao.BGT5350Dao;
import com.miraeasset.biz.budget.vo.BGT5350In00VO;

@Service
@Transactional
public class BGT5350ServiceImpl implements BGT5350Service {

	@Autowired
    BGT5350Dao BGT5350Dao;

	@Override
	public List<BGT5350In00VO> selectList00AT05N121(BGT5350In00VO vo) {
		return BGT5350Dao.selectList00AT05N121(vo);
	}

}
