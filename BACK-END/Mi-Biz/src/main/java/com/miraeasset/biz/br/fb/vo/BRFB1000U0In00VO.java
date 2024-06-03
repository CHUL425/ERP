package com.miraeasset.biz.br.fb.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class BRFB1000U0In00VO {
    @ApiModelProperty(notes = "페이지사이즈", example = "0")
    private BigDecimal pageSize;      // 페이지사이즈
    @ApiModelProperty(notes = "페이지순번", example = "0")
    private BigDecimal pageIndex;     // 페이지순번
    @ApiModelProperty(notes = "조직코드", example = "200001")
    private String orzCd;
    @ApiModelProperty(notes = "조직구분(01:본부 / 02:WM팀)", example = "01")
    private String orzTcd;

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

    public String getOrzCd() {
        return orzCd;
    }

    public void setOrzCd(String orzCd) {
        this.orzCd = orzCd;
    }

    public String getOrzTcd() {
        return orzTcd;
    }

    public void setOrzTcd(String orzTcd) {
        this.orzTcd = orzTcd;
    }
}
