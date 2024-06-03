package com.miraeasset.biz.common.basic.service;

import java.util.List;

import com.miraeasset.biz.common.basic.vo.AprvOrg00VO;
import com.miraeasset.biz.common.basic.vo.BasicLoginHisInVO;
import com.miraeasset.biz.common.basic.vo.BasicLoginHisOutVO;
import com.miraeasset.biz.common.basic.vo.BasicOrg00In00VO;
import com.miraeasset.biz.common.basic.vo.BasicOrg00Out00VO;
import com.miraeasset.biz.common.basic.vo.BasicOrg01In00VO;
import com.miraeasset.biz.common.basic.vo.BasicOrg01Out00VO;
import com.miraeasset.biz.common.basic.vo.BasicPost00In00VO;
import com.miraeasset.biz.common.basic.vo.BasicPost00In01VO;
import com.miraeasset.biz.common.basic.vo.BasicPost00Out00VO;
import com.miraeasset.biz.common.basic.vo.BasicPost00Out01VO;
import com.miraeasset.biz.common.basic.vo.BasicUser00In00VO;
import com.miraeasset.biz.common.basic.vo.BasicUser00Out00VO;

public interface BasicService {

    List<BasicOrg00Out00VO> selectListOrg00(BasicOrg00In00VO vo);
    List<BasicOrg01Out00VO> selectOrg01(BasicOrg01In00VO vo);

    List<BasicUser00Out00VO> selectListUser00(BasicUser00In00VO vo);
    List<BasicLoginHisOutVO> selectListLoginHis(BasicLoginHisInVO vo);
    
    List<BasicPost00Out00VO> selectPreSchw(BasicPost00In00VO vo);
    List<BasicPost00Out01VO> selectUnifAdr(BasicPost00In01VO vo);    
    
    /* 결재선 조직도 조회 */
    List<AprvOrg00VO> selectAprvOrgList(AprvOrg00VO vo);
}
