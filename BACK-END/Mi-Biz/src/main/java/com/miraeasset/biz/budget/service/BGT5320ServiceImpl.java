package com.miraeasset.biz.budget.service;


import com.miraeasset.biz.budget.vo.BGT5320In00VO;
import com.miraeasset.biz.budget.dao.BGT5320Dao;
import com.miraeasset.biz.budget.vo.Main01VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BGT5320ServiceImpl implements BGT5320Service {

	@Autowired
    BGT5320Dao BGT5320Dao;

	@Override
	public List<BGT5320In00VO> selectList00AT05N129(BGT5320In00VO vo) {
		return BGT5320Dao.selectList00AT05N129(vo);
	}


//	@Override
//	public List<Main01VO> selectList00AT05N121(Main01VO vo) {
//		return BGT5320Dao.selectList00AT05N121(vo);
//	}



}
