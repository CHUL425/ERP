package com.miraeasset.biz.br.fb.vo;

import com.miraeasset.biz.br.er.vo.BRER1000U0Out00VO;
import com.miraeasset.biz.br.er.vo.BRER2000U0Out00VO;
import com.miraeasset.biz.br.er.vo.BRER3000U0Out00VO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 지점개요 - 지점현황(렌탈제품 / CCTV / UPS / 무인경비)
 * */
public class BRFB1000U0Out03VO {
    @ApiModelProperty(notes = "지점개요")
    BRFB1000U0Out00VO branchOverview;
    @ApiModelProperty(notes = "지점개요 상세")
    BRFB1000U0Out01VO branchOverviewManagement;
    @ApiModelProperty(notes = "렌탈제품")
    List<BRFB1000U0Out02VO> rental;
    @ApiModelProperty(notes = "CCTV")
    BRER1000U0Out00VO cctv;
    @ApiModelProperty(notes = "UPS")
    BRER2000U0Out00VO ups;
    @ApiModelProperty(notes = "무인경비")
    List<BRER3000U0Out00VO> security;

    public BRFB1000U0Out00VO getBranchOverview() {
        return branchOverview;
    }

    public void setBranchOverview(BRFB1000U0Out00VO branchOverview) {
        this.branchOverview = branchOverview;
    }

    public BRFB1000U0Out01VO getBranchOverviewManagement() {
        return branchOverviewManagement;
    }

    public void setBranchOverviewManagement(BRFB1000U0Out01VO branchOverviewManagement) {
        this.branchOverviewManagement = branchOverviewManagement;
    }

    public List<BRFB1000U0Out02VO> getRental() {
        return rental;
    }

    public void setRental(List<BRFB1000U0Out02VO> rental) {
        this.rental = rental;
    }

    public BRER1000U0Out00VO getCctv() {
        return cctv;
    }

    public void setCctv(BRER1000U0Out00VO cctv) {
        this.cctv = cctv;
    }

    public BRER2000U0Out00VO getUps() {
        return ups;
    }

    public void setUps(BRER2000U0Out00VO ups) {
        this.ups = ups;
    }

    public List<BRER3000U0Out00VO> getSecurity() {
        return security;
    }

    public void setSecurity(List<BRER3000U0Out00VO> security) {
        this.security = security;
    }
}
