package com.miraeasset.biz.sh.an.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.dao.CommonDao;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.sh.an.dao.SHAN2000U0Dao;
import com.miraeasset.biz.sh.an.vo.SHAN2000U0In00VO;
import com.miraeasset.biz.sh.an.vo.SHAN2000U0Out00VO;

@Service
@Transactional
public class SHAN2000U0ServiceImpl implements SHAN2000U0Service {

	@Autowired
	SHAN2000U0Dao SHAN2000U0Dao;
	
	@Autowired
	CommonDao commonDao;
			
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/* 안전보건공지 현황 조회 */	
	@Override
	public List<SHAN2000U0Out00VO> selectShanPsttList(SHAN2000U0In00VO vo, HttpServletRequest request){
		
		LoginOutVO loginVO = (LoginOutVO) request.getSession().getAttribute("loginOutVO"); 
		vo.setEpno(loginVO.getEpno());
		
		if(StringUtils.isBlank(vo.getCfmtEpBlngOrzCd())) {
		    /* [2023-10-19]: 총무팀 제외하고는 자기팀에서 신청한 내역만 보이게 수정 */
		    String epOrzCd = loginVO.getBlngOrzCd();
		    boolean isManager = loginVO.getUserGrpCdList().contains("001") || loginVO.getUserGrpCdList().contains("999");
		    if(!isManager) {
		        vo.setCfmtEpBlngOrzCd(epOrzCd);
		    }
		}
		
		SHAN2000U0Out00VO cntVO = SHAN2000U0Dao.selectShanPsttList_CNT(vo);
		vo.setTotCnt(cntVO.getTotCnt());
		
		List<SHAN2000U0Out00VO> rtnList = SHAN2000U0Dao.selectShanPsttList(vo);
		
		return rtnList;
	}
}
