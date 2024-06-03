package com.miraeasset.biz.rq.dr.service;

import java.util.List;
import java.util.Map;

import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.rq.dr.vo.GA01N601SchVO;
import com.miraeasset.biz.rq.dr.vo.GA01N601VO;
import com.miraeasset.biz.rq.dr.vo.GA01N602SchVO;
import com.miraeasset.biz.rq.dr.vo.GA01N602VO;

public interface RQDR1000U0Service {

    GA01N601VO insertGA01N601AndN604(GA01N601VO vo, LoginOutVO loginVo);

    int updateGA01N601AndN604(GA01N601VO vo);

    int updateGA01N602byList(List<GA01N602VO> lstVo);

    List<GA01N601SchVO> selectGA01N601AndN101(GA01N601SchVO vo);

    Map<String, Object> selectGA01N601AndN101_RqsStat(GA01N601SchVO vo);

    Map<String, Object> selectGA01N602Sch_RqsStat(GA01N602SchVO vo);

    List<GA01N602SchVO> selectGA01N602Sch(GA01N602SchVO vo);

    List<GA01N602SchVO> selectGA01N604SchByRctNo(GA01N602SchVO vo);

    List<GA01N602VO> selectGA01N602byRctNo(GA01N602VO vo);


    String sendDocMailWithExcel(String strRctNo);

    String sendDocMailWithExcel(String strRctNo, String updFlag);

    int updateGA01N602RejectByDocNo(String strRctNo);

    int updateGA01N602WithDrawByDocNo(String strRctNo);

    int deleteGA01N601(GA01N601VO vo);

    Map<String, Object> insertGA01N601ReApplyByRctNo(String strRctNo, LoginOutVO loginVo);
}
