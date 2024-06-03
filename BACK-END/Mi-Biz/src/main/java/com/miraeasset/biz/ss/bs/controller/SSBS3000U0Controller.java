package com.miraeasset.biz.ss.bs.controller;

import com.miraeasset.biz.common.annotation.GrpAuth;
import com.miraeasset.biz.common.meta.vo.GA09N602VO;
import com.miraeasset.biz.common.meta.vo.GA09N607VO;
import com.miraeasset.biz.ss.bs.service.SSBS3000U0Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 결재 관련 테이블 조작
 * GA09N600
 * GA09N601
 * GA09N602
 * GA09N606
 * GA09N607
 * */
@RestController
@RequestMapping("api/ss/bs/3000")
public class SSBS3000U0Controller {
    private final SSBS3000U0Service ssbs3000U0Service;

    public SSBS3000U0Controller(SSBS3000U0Service ssbs3000U0Service) {
        this.ssbs3000U0Service = ssbs3000U0Service;
    }

    @RequestMapping(value = "ga09n607/find", method = RequestMethod.POST)
    @GrpAuth("999")
    public List<GA09N607VO> findGA09N607(@RequestBody GA09N607VO ga09N607VO) {
        return ssbs3000U0Service.findGA09N607(ga09N607VO);
    }

    @RequestMapping(value = "ga09n607/save", method = RequestMethod.POST)
    @GrpAuth("999")
    public int saveGA09N607(@RequestBody GA09N607VO ga09N607VO) {
        return ssbs3000U0Service.saveGA09N607(ga09N607VO);
    }

    @RequestMapping(value = "ga09n602/find", method = RequestMethod.POST)
    @GrpAuth("999")
    public List<GA09N602VO> findGA09N607(@RequestBody GA09N602VO ga09N602VO) {
        return ssbs3000U0Service.findGA09N602(ga09N602VO);
    }

    @RequestMapping(value = "ga09n602/save", method = RequestMethod.POST)
    @GrpAuth("999")
    public int saveGA09N602(@RequestBody GA09N602VO ga09N602VO) {
        return ssbs3000U0Service.saveGA09N602(ga09N602VO);
    }
}
