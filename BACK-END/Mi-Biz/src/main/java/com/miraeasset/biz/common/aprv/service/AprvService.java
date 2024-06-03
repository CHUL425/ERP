package com.miraeasset.biz.common.aprv.service;

import java.util.List;

import com.miraeasset.biz.common.aprv.vo.Aprv00In00VO;
import com.miraeasset.biz.common.aprv.vo.Aprv00In01VO;
import com.miraeasset.biz.common.aprv.vo.Aprv00In02VO;
import com.miraeasset.biz.common.aprv.vo.Aprv00Out00VO;

public interface AprvService {

	/* 승댄대기 내역조회 */	
    List<Aprv00Out00VO> selectAprvList(Aprv00In00VO vo);
    
	/* 승인/반려 처리 - 단건*/	
    int updateAprv(Aprv00In02VO vo);
    
	/* 승인 처리 - 다건*/	
    int updateAprvList(Aprv00In01VO vo);        

}
