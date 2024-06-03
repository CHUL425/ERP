package com.miraeasset.biz.br.fb.service;

import com.miraeasset.biz.br.er.service.BRER1000U0Service;
import com.miraeasset.biz.br.er.service.BRER2000U0Service;
import com.miraeasset.biz.br.er.service.BRER3000U0Service;
import com.miraeasset.biz.br.er.vo.*;
import com.miraeasset.biz.br.fb.dao.BRFB1000U0Dao;
import com.miraeasset.biz.br.fb.vo.*;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.ss.bs.service.SSBS8000U0Service;
import com.miraeasset.biz.ss.bs.vo.SSBS8000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS8000U0Out01VO;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.support.JdbcUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BRFB1000U0Service {

    private final BRFB1000U0Dao brfb1000U0Dao;
    private final SSBS8000U0Service ssbs8000U0Service;
    private final BRER1000U0Service brer1000U0Service;
    private final BRER2000U0Service brer2000U0Service;
    private final BRER3000U0Service brer3000U0Service;

    public BRFB1000U0Service(BRFB1000U0Dao brfb1000U0Dao, SSBS8000U0Service ssbs8000U0Service, BRER1000U0Service brer1000U0Service, BRER2000U0Service brer2000U0Service, BRER3000U0Service brer3000U0Service) {
        this.brfb1000U0Dao = brfb1000U0Dao;
        this.ssbs8000U0Service = ssbs8000U0Service;
        this.brer1000U0Service = brer1000U0Service;
        this.brer2000U0Service = brer2000U0Service;
        this.brer3000U0Service = brer3000U0Service;
    }

    /* 지점개요 - 지점리스트 조회 */
    public List<Map<String, String>> getBranchList() {
        List<Map<String, String>> result = brfb1000U0Dao.selectList00CB01N210();
        for (int i = 0; i < result.size(); i++) {
            Map<String, String> newKeyMap = new HashMap<>(result.get(i));
            for (String key : result.get(i).keySet()) {
                newKeyMap.put(JdbcUtils.convertUnderscoreNameToPropertyName(key), newKeyMap.remove(key));
            }
            result.set(i, newKeyMap);
        }
        return result;
    }

    /* 지점개요 - 지점전체조회 */
    public List<BRFB1000U0Out00VO> getBranchOverviewAll(BRFB1000U0In00VO brfb1000U0In00VO) {
        brfb1000U0In00VO.setOrzCd(null);
        return brfb1000U0Dao.selectList01CB01N210(brfb1000U0In00VO);
    }

    /* 지점개요 - 지점조회 */
    public BRFB1000U0Out00VO getBranchOverviewOne(BRFB1000U0In00VO brfb1000U0In00VO) {
        List<BRFB1000U0Out00VO> brfb1000U0Out00VOList = brfb1000U0Dao.selectList01CB01N210(brfb1000U0In00VO);

        if(brfb1000U0Out00VOList == null || brfb1000U0Out00VOList.size() < 1) {
            throw new CustomBadRequestException("조회된 데이터가 없어요. 조직코드가 지점인지 확인해주세요.", ErrorCode.BAD_REQUEST);
        }
        return brfb1000U0Out00VOList.get(0);
    }

    /* 지점개요관리 - 지점개요관리 조회 */
    public BRFB1000U0Out01VO getBranchOverviewManagement(BRFB1000U0In00VO brfb1000U0In00VO) {
        return brfb1000U0Dao.selectOne00GA02N001(brfb1000U0In00VO);
    }

    /* 지점개요관리 - 지점개요관리 저장 */
    public int saveBranchOverviewManagement(BRFB1000U0Out01VO brfb1000U0Out01VO) {
        // 입력 검증
        if (brfb1000U0Out01VO.getOrzCd() == null || brfb1000U0Out01VO.getOrzCd().equals("")) {
            throw new CustomBadRequestException("조직코드를 입력해주세요.", ErrorCode.BAD_REQUEST);
        } else if (brfb1000U0Out01VO.getLeasPcd() == null || brfb1000U0Out01VO.getLeasPcd().equals("")) {
            throw new CustomBadRequestException("임차유형을 입력해주세요.", ErrorCode.BAD_REQUEST);
        }
        // 임차유형코드 검증
        SSBS8000U0In01VO ssbs8000U0In01VO = new SSBS8000U0In01VO();
        ssbs8000U0In01VO.setCdKndNo("LEAS_PCD");
        List<SSBS8000U0Out01VO> ssbs8000U0Out01VOList = ssbs8000U0Service.getCmnCdVl(ssbs8000U0In01VO);
        boolean flag = true;
        for (SSBS8000U0Out01VO ssbs8000U0Out01VO : ssbs8000U0Out01VOList) {
            if (ssbs8000U0Out01VO.getCmnCdVl().equals(brfb1000U0Out01VO.getLeasPcd())) {
                flag = false;
                break;
            }
        }
        if (flag) {
            throw new CustomBadRequestException("존재하지 않는 임차유형 코드예요.", ErrorCode.BAD_REQUEST);
        }

        return brfb1000U0Dao.merge00GA02N001(brfb1000U0Out01VO);
    }

    public BRFB1000U0Out03VO getBranchOverviewDetail(BRFB1000U0In00VO brfb1000U0In00VO) {
        if (brfb1000U0In00VO.getOrzCd() == null || brfb1000U0In00VO.getOrzCd().equals("")) {
            throw new CustomBadRequestException("조직코드를 입력해주세요.", ErrorCode.BAD_REQUEST);
        }

        // 선언
        BRFB1000U0Out03VO result = new BRFB1000U0Out03VO();

        BRFB1000U0Out00VO branchOverview;
        BRFB1000U0Out01VO branchOverviewManagement;
        List<BRFB1000U0Out02VO> rental;
        BRER1000U0Out00VO cctv = new BRER1000U0Out00VO();
        BRER2000U0Out00VO ups = new BRER2000U0Out00VO();
        List<BRER3000U0Out00VO> security;

        // 데이터 획득
        branchOverview = this.getBranchOverviewOne(brfb1000U0In00VO);
        branchOverviewManagement = this.getBranchOverviewManagement(brfb1000U0In00VO);
        rental = brfb1000U0Dao.selectList00GA01N001(brfb1000U0In00VO);
        List<BRER1000U0Out00VO> brer1000U0Out00VOList = brer1000U0Service.selectList00GA02N002(
                new BRER1000U0In00VO(brfb1000U0In00VO.getOrzCd()));
        List<BRER2000U0Out00VO> brer2000U0Out00VOList = brer2000U0Service.selectList00GA02N003(
                new BRER2000U0In00VO(brfb1000U0In00VO.getOrzCd()));
        List<BRER3000U0Out00VO> brer3000U0Out00VOList = brer3000U0Service.selectList00GA02N004(
                new BRER3000U0In00VO(brfb1000U0In00VO.getOrzCd()));

        // CCTV
        for (BRER1000U0Out00VO brer1000U0Out00VO : brer1000U0Out00VOList) {
            cctv.setIstQ1(cctv.getIstQ1() + brer1000U0Out00VO.getIstQ1());
            cctv.setIstQ2(cctv.getIstQ2() + brer1000U0Out00VO.getIstQ2());
            cctv.setIstQ3(cctv.getIstQ3() + brer1000U0Out00VO.getIstQ3());
            cctv.setIstQ4(cctv.getIstQ4() + brer1000U0Out00VO.getIstQ4());
            cctv.setIstQ5(cctv.getIstQ5() + brer1000U0Out00VO.getIstQ5());
            cctv.setIstQ6(cctv.getIstQ6() + brer1000U0Out00VO.getIstQ6());
        }
        cctv.setIstQAll(cctv.getIstQAll());

        // UPS
        if (brer2000U0Out00VOList != null && brer2000U0Out00VOList.size() > 0) {
            ups = brer2000U0Out00VOList.get(0);
        }

        // 무인경비
        security = brer3000U0Out00VOList;


        // 결과 세팅
        result.setBranchOverview(branchOverview);
        result.setBranchOverviewManagement(branchOverviewManagement);
        result.setRental(rental);
        result.setCctv(cctv);
        result.setUps(ups);
        result.setSecurity(security);


        return result;
    }
}
