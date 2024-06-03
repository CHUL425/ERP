package com.miraeasset.biz.br.lb.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class BRLB1000V0In02VO {
    @ApiModelProperty(notes = "조회타입(D: 일별 / M: 월별", example = "M")
    private String qryType;
    @ApiModelProperty(notes = "조회시작일자", example = "20220101")
    private String qryStartDt;
    @ApiModelProperty(notes = "조회종료일자", example = "20221231")
    private String qryEndDt;
    @ApiModelProperty(notes = "조직코드", example = "000000")
    private String orzCd;
    @ApiModelProperty(notes = "계정과목레벨코드", example = "6")
    private String acsjGcd;
    @ApiModelProperty(notes = "계정과목코드", example = "5270060101")
    private String acsjCd;
    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;

    public String getQryType() {
        return qryType;
    }

    public void setQryType(String qryType) {
        this.qryType = qryType;
    }

    public String getQryStartDt() {
        return qryStartDt;
    }

    public void setQryStartDt(String qryStartDt) {
        this.qryStartDt = qryStartDt;
    }

    public String getQryEndDt() {
        return qryEndDt;
    }

    public void setQryEndDt(String qryEndDt) {
        this.qryEndDt = qryEndDt;
    }

    public String getOrzCd() {
        return orzCd;
    }

    public void setOrzCd(String orzCd) {
        this.orzCd = orzCd;
    }

    public String getAcsjGcd() {
        return acsjGcd;
    }

    public void setAcsjGcd(String acsjGcd) {
        this.acsjGcd = acsjGcd;
    }

    public String getAcsjCd() {
        return acsjCd;
    }

    public void setAcsjCd(String acsjCd) {
        this.acsjCd = acsjCd;
    }

    public BigDecimal getPageSize() {
        return pageSize;
    }

    public void setPageSize(BigDecimal pageSize) {
        this.pageSize = pageSize;
    }

    public BigDecimal getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(BigDecimal pageIndex) {
        this.pageIndex = pageIndex;
    }
}
