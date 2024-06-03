package com.miraeasset.biz.br.rb.service;

import com.miraeasset.biz.br.ob.service.BROB1000U0Service;
import com.miraeasset.biz.br.ob.vo.BROB1000U0In00VO;
import com.miraeasset.biz.br.ob.vo.BROB1000U0Out00VO;
import com.miraeasset.biz.br.rb.dao.BRRB1000U0Dao;
import com.miraeasset.biz.br.rb.vo.*;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class BRRB1000U0Service {
    private final BRRB1000U0Dao brrb1000U0Dao;
    private final BROB1000U0Service brob1000U0Service;

    @Autowired
    public BRRB1000U0Service(BRRB1000U0Dao brrb1000U0Dao, BROB1000U0Service brob1000U0Service) {
        this.brrb1000U0Dao = brrb1000U0Dao;
        this.brob1000U0Service = brob1000U0Service;
    }

    public List<BRRB1000U0Out00VO> getOfficeOccupancyManagement(BRRB1000U0In00VO brrb1000U0In00VO) {
        List<BRRB1000U0Out00VO> brrb1000U0Out00VOList = new ArrayList<>();
        String lsSfTcd = brrb1000U0In00VO.getLsSfTcd();
        if(lsSfTcd == null) {
            brrb1000U0Out00VOList.addAll(brrb1000U0Dao.selectListAT08N101(brrb1000U0In00VO));
            brrb1000U0Out00VOList.addAll(brrb1000U0Dao.selectListGA02N201(brrb1000U0In00VO));
        } else if(lsSfTcd.equals("00")) {
            brrb1000U0Out00VOList.addAll(brrb1000U0Dao.selectListAT08N101(brrb1000U0In00VO));
            brrb1000U0Out00VOList.addAll(brrb1000U0Dao.selectListGA02N201(brrb1000U0In00VO));
        } else if(lsSfTcd.equals("01")) {
            brrb1000U0Out00VOList.addAll(brrb1000U0Dao.selectListAT08N101(brrb1000U0In00VO));
        } else if(lsSfTcd.equals("02")) {
            brrb1000U0Out00VOList.addAll(brrb1000U0Dao.selectListGA02N201(brrb1000U0In00VO));
        }

        // [20231030] 절사 추가
        for(BRRB1000U0Out00VO brrb1000U0Out00VO : brrb1000U0Out00VOList) {
            brrb1000U0Out00VO.setOnlyAr(brrb1000U0Out00VO.getOnlyAr().setScale(2, RoundingMode.HALF_UP)); // 전용면적
            brrb1000U0Out00VO.setRentAr(brrb1000U0Out00VO.getRentAr().setScale(2, RoundingMode.HALF_UP)); // 임차면적

            // [20231122] 금액 소숫점 이하 절사 추가
            brrb1000U0Out00VO.setMlyMcst(brrb1000U0Out00VO.getMlyMcst().setScale(0, RoundingMode.HALF_UP)); // 관리비
            brrb1000U0Out00VO.setMlyRentc(brrb1000U0Out00VO.getMlyRentc().setScale(0, RoundingMode.HALF_UP)); // 임대료
            brrb1000U0Out00VO.setGrtA(brrb1000U0Out00VO.getGrtA().setScale(0, RoundingMode.HALF_UP)); // 보증금
        }


        return brrb1000U0Out00VOList;
    }

    public BRRB1000U0Out01VO getSelfBranchManagementDetail(BRRB1000U0In01VO brrb1000U0In01VO) {
        if(brrb1000U0In01VO.getOfcbldTcd() == null || brrb1000U0In01VO.getOfcbldTcd().isEmpty()) {
            throw new CustomBadRequestException("사옥구분코드를 입력해주세요.", ErrorCode.BAD_REQUEST);
        } else if(brrb1000U0In01VO.getOrzCd() == null || brrb1000U0In01VO.getOrzCd().isEmpty()) {
            throw new CustomBadRequestException("조직코드를 입력해주세요.", ErrorCode.BAD_REQUEST);
        } else if(false) {
            //미구현 통합공통코드 개발 후 진행
        }
        return brrb1000U0Dao.selectOneGA02N201(brrb1000U0In01VO);
    }

    public int saveSelfBranchManagementDetail(BRRB1000U0Out01VO brrb1000U0Out01VO) {


        if(brrb1000U0Out01VO.getOfcbldTcd() == null || brrb1000U0Out01VO.getOfcbldTcd().isEmpty()) {
            throw new CustomBadRequestException("사옥구분코드를 입력해주세요.", ErrorCode.BAD_REQUEST);
        } else if(false) {
            //미구현 통합공통코드 개발 후 진행
        }
        return brrb1000U0Dao.mergeGA02N201(brrb1000U0Out01VO);
    }

    public int deleteSelfBranchManagementDetail(BRRB1000U0In01VO brrb1000U0In01VO) {
        return brrb1000U0Dao.deleteGA02N201(brrb1000U0In01VO);
    }

    public BRRB1000U0Out02VO getOfficeRentalStatus(BRRB1000U0In02VO brrb1000U0In02VO) {
    	
    	if(StringUtils.isBlank(brrb1000U0In02VO.getOfcbldTcd())) {
    		throw new CustomBadRequestException("[사옥명]을 선택해주세요.", ErrorCode.BAD_REQUEST);
    	}
    	
        BRRB1000U0Out02VO brrb1000U0Out02VO = new BRRB1000U0Out02VO();

        BRRB1000U0In00VO brrb1000U0In00VO = new BRRB1000U0In00VO();
        //brrb1000U0In00VO.setLsSfTcd("00"); // 전체
        brrb1000U0In00VO.setLsSfTcd("01");   // [2024.03.08] 자가지점현황 가장 최근데이터 사용
        brrb1000U0In00VO.setBasYm(brrb1000U0In02VO.getBasYm()); // 입력한 기준년월
        brrb1000U0In00VO.setOfcbldTcd(brrb1000U0In02VO.getOfcbldTcd()); // 입력한 사옥구분코드

        List<BRRB1000U0Out00VO> brrb1000U0Out00VOList = this.getOfficeOccupancyManagement(brrb1000U0In00VO);
        
        // [2024.03.08] 자가지점현황 가장 최근데이터를 가지고 와서 사옥임대현황 팝업의 당사(자가지점)면적에 표기
        brrb1000U0Out00VOList.addAll(brrb1000U0Dao.selectGA02N201Rcen(brrb1000U0In00VO));
        
        BigDecimal rentAr = BigDecimal.valueOf(0); // 임대면적
        BigDecimal selfAr = BigDecimal.valueOf(0); // 당사(자가지점)면적
        BigDecimal selfEtcAr = BigDecimal.valueOf(0); // 당사기타사용면적
        BigDecimal vcnAr = BigDecimal.valueOf(0); // 공실면적
        BigDecimal ofcGar = BigDecimal.valueOf(0); // 사옥연면적

        // 임대면적, 당사(자가지점)면적
        for(BRRB1000U0Out00VO brrb1000U0Out00VO : brrb1000U0Out00VOList) {
            if(brrb1000U0Out00VO.getLsSfTcd().equals("01")) { // 임대
                rentAr = rentAr.add(brrb1000U0Out00VO.getRentAr());
            } else if(brrb1000U0Out00VO.getLsSfTcd().equals("02")) { // 자가
                selfAr = selfAr.add(brrb1000U0Out00VO.getRentAr());
            }
        }


        BROB1000U0In00VO brob1000U0In00VO = new BROB1000U0In00VO();
        brob1000U0In00VO.setOfcbldTcd(brrb1000U0In02VO.getOfcbldTcd());
        BROB1000U0Out00VO brob1000U0Out00VO = brob1000U0Service.getOfficeOverview(brob1000U0In00VO);
        if(brob1000U0Out00VO != null) {
            // 당사기타사용면적.
            selfEtcAr = brob1000U0Out00VO.getEtcUseAr();
            // 사옥연면적
            ofcGar = brob1000U0Out00VO.getBldGar();
        }

        // 공실면적 = 사옥연면적 - (임대면적 + 자가지점면적 + 기타사용면적)
        ofcGar = ofcGar.divide(BigDecimal.valueOf(3.305785), 2, BigDecimal.ROUND_HALF_UP); // 평으로 나오게 해주세요
        vcnAr = ofcGar.subtract(rentAr.add(selfAr).add(selfEtcAr));

        brrb1000U0Out02VO.setRentAr(rentAr);
        brrb1000U0Out02VO.setSelfAr(selfAr);
        brrb1000U0Out02VO.setSelfEtcAr(selfEtcAr);
        brrb1000U0Out02VO.setOfcGar(ofcGar);
        brrb1000U0Out02VO.setVcnAr(vcnAr);

        return brrb1000U0Out02VO;
    }
}
