package com.miraeasset.biz.ga.bm.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.ga.bm.dao.GABM1000U0Dao;
import com.miraeasset.biz.ga.bm.vo.GABM1000U0In00VO;
import com.miraeasset.biz.ga.bm.vo.GABM1000U0In01VO;
import com.miraeasset.biz.ga.bm.vo.GABM1000U0Out00VO;
import com.miraeasset.biz.ga.bm.vo.GABM1000U0VO;

@Service
@Transactional
public class GABM1000U0ServiceImpl implements GABM1000U0Service {
	
	@Autowired
	GABM1000U0Dao dao;
	
	/* 예산관리 조회 */
	@Override
	public List<GABM1000U0Out00VO> selectList00GA01N401(GABM1000U0In00VO vo) {
		// TODO Auto-generated method stub
		if(vo.getActgDt() == null || vo.getActgDt().equals("") ) {
	        throw new CustomBadRequestException("회계일자 입력값을 확인하세요["+vo.getActgDt()+"]", ErrorCode.BAD_REQUEST);		
		}
		
		String basYm	  	 = vo.getActgDt().substring(0, 4); /* 기준년월 */
//		String yrDyEndDt 	 = DateUtil.getAddDay(vo.getActgDt(), -1); /* 년시작일자 */
		String yrDyEndDt     = vo.getActgDt();
		String yrDyStrtDt 	 = DateUtil.getAddDay(yrDyEndDt, -1); /* 년시작일자 */
		String yrbfBasYm     = DateUtil.getAddDay(vo.getActgDt(), -365).substring(0, 4); /* 이전년월 */
		String yr1DybfEndDt	 = yrbfBasYm+"1231"; /* 1년전종료일자 */
		String yr1DybfStrtDt = DateUtil.getAddDay(yr1DybfEndDt, -1); /* 1년전시작일자 */
		
		vo.setBasYm(basYm);
		vo.setYrDyEndDt(yrDyEndDt);
		vo.setYrDyStrtDt(yrDyStrtDt);
		vo.setYrbfBasYm(yrbfBasYm);
		vo.setYr1DybfStrtDt(yr1DybfStrtDt);
		vo.setYr1DybfEndDt(yr1DybfEndDt);
		return dao.selectList00GA01N401(vo);
	}
	
	/* 편성금액 관리 */
	@Override
	public int insert00GA01N401(GABM1000U0VO vo) {
		// TODO Auto-generated method stub
		
		int arryCnt = 0;
		
		List<GABM1000U0In01VO> inputList = vo.getInputList();
		GABM1000U0In01VO setVo = null;
		
		if (inputList == null || inputList.size() == 0) {
			throw new CustomBadRequestException("편성금액 처리할 내역이 없습니다.", ErrorCode.BAD_REQUEST);
		}
		
		for( int i = 0; i < inputList.size(); i++) {
			arryCnt++;
			setVo = inputList.get(i);
			
			if (StringUtils.isBlank(setVo.getActgDt())) {
				setVo.setActgDt(DateUtil.getTodayString("yyyyMMdd"));
			}
			
//			setVo.setOptrId("000000");
//			setVo.setOprtChnlCd("000");
//			setVo.setOprtOrzCd("000000");
//			setVo.setOprtIpAdr("000000");
			dao.insert00GA01N401(setVo);
		}
		
		return arryCnt;
	}

}
