package com.miraeasset.biz.common.cm.ps.service;

import java.util.List;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.cm.ps.dao.CMPS1000V0Dao;
import com.miraeasset.biz.common.cm.ps.vo.CMPS1000V0In00VO;
import com.miraeasset.biz.common.cm.ps.vo.CMPS1000V0Out00VO;

@Service
@Transactional
public class CMPS1000V0ServiceImpl implements CMPS1000V0Service {
	
	@Autowired
	CMPS1000V0Dao dao;
	
	/* 거래처조회 팝업 */
	@Override
	public List<CMPS1000V0Out00VO> select00AT05C010List(CMPS1000V0In00VO vo) {
		// TODO Auto-generated method stub
		return dao.select00AT05C010List(vo);
	}

	@Override
	public List<CMPS1000V0Out00VO> select00AT05C010ListPK(CMPS1000V0In00VO vo) {
		if(vo.getSrchKwrd() == null || vo.getSrchKwrd().equals("")) {
			throw new CustomBadRequestException("거래처코드를 입력해주세요.", ErrorCode.BAD_REQUEST);
		} else if(vo.getSrchKwrd().length() != 9) {
			throw new CustomBadRequestException("거래처코드 형식이 아니에요", ErrorCode.BAD_REQUEST);
		}

		return dao.select00AT05C010ListPK(vo);
	}

}
