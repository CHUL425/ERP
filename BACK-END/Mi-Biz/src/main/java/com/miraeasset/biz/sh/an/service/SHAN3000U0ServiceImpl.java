package com.miraeasset.biz.sh.an.service;

import java.util.List;

import org.apache.tika.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.dao.CommonDao;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.sh.an.dao.SHAN3000U0Dao;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In00VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In01VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In02VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0Out00VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0Out01VO;

@Service
@Transactional
public class SHAN3000U0ServiceImpl implements SHAN3000U0Service {

	@Autowired
	SHAN3000U0Dao SHAN3000U0Dao;
	
	@Autowired
	CommonDao commonDao;
			
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/* 안전보건공지 확인 전체조회 */	
	@Override
	public List<SHAN3000U0Out00VO> selectShanCfmtList(SHAN3000U0In00VO vo){
		
		List<SHAN3000U0Out00VO> rtnList = null;
		
		// 2024.02.23 겸직사번에 직책 공백일경우 있음.
		// 직책코드 존재시 조회 
		//if(!StringUtils.isBlank(vo.getOsdtCd())){
		rtnList = SHAN3000U0Dao.selectShanCfmtList(vo);
		//} 
		
		return rtnList;
	}
	
	
	/* 안전보건공지 확인 상세조회(확인용) */	
	@Override
	public SHAN3000U0Out01VO selectShanCfmtDlCn(SHAN3000U0In01VO vo) {
		return SHAN3000U0Dao.selectShanCfmtDlCn(vo);
	}
	
	/* 안전보건공지 확인 */
	@Override
	public int insertShanCfmtDlCn(SHAN3000U0In02VO vo) {
		
		if(StringUtils.isBlank(vo.getCfmtYn()) ||"0".equals(vo.getCfmtYn())){
			throw new CustomBadRequestException("저장실패. 체크박스 체크 후 저장버튼 클릭하십시오", ErrorCode.BAD_REQUEST);	
		}
		
		return SHAN3000U0Dao.insertShanCfmtDlCn(vo);
	}
	
}
