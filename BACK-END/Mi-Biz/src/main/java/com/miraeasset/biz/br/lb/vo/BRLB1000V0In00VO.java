package com.miraeasset.biz.br.lb.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class BRLB1000V0In00VO {
    @ApiModelProperty(notes = "조직코드", example = "000000")
    private String orzCd;
    @ApiModelProperty(notes = "리스종료일자(조회시작일자)", example = "20180101")
    private String lsEndDtStart;
    @ApiModelProperty(notes = "리스종료일자(조회종료일자)", example = "99991231")
    private String lsEndDtEnd;
    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;

    public String getOrzCd() {
        return orzCd;
    }

    public void setOrzCd(String orzCd) {
        this.orzCd = orzCd;
    }

    public String getLsEndDtStart() {
        return lsEndDtStart;
    }

    public void setLsEndDtStart(String lsEndDtStart) {
        this.lsEndDtStart = lsEndDtStart;
    }

    public String getLsEndDtEnd() {
        return lsEndDtEnd;
    }

    public void setLsEndDtEnd(String lsEndDtEnd) {
        this.lsEndDtEnd = lsEndDtEnd;
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
