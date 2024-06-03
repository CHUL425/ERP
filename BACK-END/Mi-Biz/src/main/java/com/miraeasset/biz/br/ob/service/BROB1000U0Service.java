package com.miraeasset.biz.br.ob.service;

import com.miraeasset.biz.br.ob.dao.BROB1000U0Dao;
import com.miraeasset.biz.br.ob.vo.BROB1000U0In00VO;
import com.miraeasset.biz.br.ob.vo.BROB1000U0Out00VO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BROB1000U0Service {

    private final BROB1000U0Dao brob1000U0Dao;

    public BROB1000U0Service(BROB1000U0Dao brob1000U0Dao) {
        this.brob1000U0Dao = brob1000U0Dao;
    }


    public List<Map<String, String>> getOfficeCode() {
        List<Map<String, String>> codeNameMapList = new ArrayList<>();
        List<BROB1000U0Out00VO> brob1000U0Out00VOList = this.getAllOfficeOverview();

        for(BROB1000U0Out00VO brob1000U0Out00VO : brob1000U0Out00VOList) {
            Map<String, String> codeNameMap = new HashMap<>();

            String ofcbldTcd = brob1000U0Out00VO.getOfcbldTcd();
            String ofcbldTcdNm = brob1000U0Out00VO.getOfcbldTcdNm();

            codeNameMap.put("ofcbldTcd", ofcbldTcd);
            codeNameMap.put("ofcbldTcdNm", ofcbldTcdNm);

            codeNameMapList.add(codeNameMap);
        }

        return codeNameMapList;
    }

    public List<BROB1000U0Out00VO> getAllOfficeOverview() {
        return brob1000U0Dao.selectList00GA02N101();
    }

    public BROB1000U0Out00VO getOfficeOverview(BROB1000U0In00VO brob1000U0In00VO) {
        return brob1000U0Dao.selectOne00GA02N101(brob1000U0In00VO);
    }

    public int saveOfficeOverview(BROB1000U0Out00VO brob1000U0Out00VO) {
        return brob1000U0Dao.merge00GA02N101(brob1000U0Out00VO);
    }
}
