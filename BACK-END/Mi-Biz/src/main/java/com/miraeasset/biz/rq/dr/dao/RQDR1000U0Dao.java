package com.miraeasset.biz.rq.dr.dao;

import java.util.List;
import java.util.Map;

import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U01VO;
import com.miraeasset.biz.rq.dr.vo.*;

public interface RQDR1000U0Dao {

    RQCR1000U01VO selectGA01N101(GA01N601VO vo);

    int insertGA01N601(GA01N601VO vo);

    int updateGA01N601(GA01N601VO vo);

    GA01N601VO selectGA01N601(GA01N601VO vo);

    int insertGA01N602(GA01N602VO vo);

    int updateGA01N602BcdByBoxNo(GA01N602VO vo);

    int updateGA01N602BoxScdByRctNo(GA01N601VO vo);

    int updateGA01N602byList(List<GA01N602VO> lstVo);

    int insertGA01N603(GA01N601VO vo);

    int insertGA01N603byGA01N602(GA01N601VO vo);

    int deleteGA01N603n602(GA01N601VO vo);

    int insertGA01N604byGA01N603(GA01N601VO vo);

    int updateGA01N604(GA01N602ModVO vo);

    int updateGA01N604byGA01N602(GA01N601VO vo);

    GA01N601SchVO selectGA01N601AndN101_Cnt(GA01N601SchVO vo);

    List<GA01N601SchVO> selectGA01N601AndN101(GA01N601SchVO vo);

    Map<String, Object> selectGA01N601AndN101_RqsStat(GA01N601SchVO vo);

    GA01N602SchVO selectGA01N602Sch_Cnt(GA01N602SchVO vo);

    Map<String, Object> selectGA01N602Sch_RqsStat(GA01N602SchVO vo);

    List<GA01N602SchVO> selectGA01N602Sch(GA01N602SchVO vo);

    List<GA01N602VO> selectGA01N602byRctNo(GA01N602VO vo);


    List<GA01N602VO> selectGA01N602byRctNoToExcel(GA01N602VO vo);


    Map<String,Object> selectCB01N310byMenuId(Map<String,Object> map);

    int insertGA01N601ReApplyByRctNo(Map<String,Object> map);

    int deleteGA01N603n604(GA01N601VO vo);

    int deleteGA01N601(GA01N601VO vo);

    List<GA01N602SchVO> selectGA01N604SchByRctNo(GA01N602SchVO vo);

    Map<String,Object> selectGA01N603ValidationCnt(GA01N601VO vo);
}
