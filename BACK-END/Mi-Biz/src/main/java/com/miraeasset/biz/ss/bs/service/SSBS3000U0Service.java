package com.miraeasset.biz.ss.bs.service;

import com.miraeasset.biz.common.meta.vo.GA09N602VO;
import com.miraeasset.biz.common.meta.vo.GA09N607VO;
import com.miraeasset.biz.ss.bs.dao.SSBS3000U0Dao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SSBS3000U0Service {
    private final SSBS3000U0Dao ssbs3000U0Dao;

    public SSBS3000U0Service(SSBS3000U0Dao ssbs3000U0Dao) {
        this.ssbs3000U0Dao = ssbs3000U0Dao;
    }

    public List<GA09N607VO> findGA09N607(GA09N607VO ga09N607VO) {
        return ssbs3000U0Dao.findGA09N607(ga09N607VO);
    }

    public int saveGA09N607(GA09N607VO ga09N607VO) {
        return ssbs3000U0Dao.saveGA09N607(ga09N607VO);
    }

    public List<GA09N602VO> findGA09N602(GA09N602VO ga09N602VO) {
        return ssbs3000U0Dao.findGA09N602(ga09N602VO);
    }

    public int saveGA09N602(GA09N602VO ga09N602VO) {
        return ssbs3000U0Dao.saveGA09N602(ga09N602VO);
    }
}
