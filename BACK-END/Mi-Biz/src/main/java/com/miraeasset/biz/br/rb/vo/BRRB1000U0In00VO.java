package com.miraeasset.biz.br.rb.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class BRRB1000U0In00VO {
    @ApiModelProperty(notes = "임대자가구분코드(00:전체 / 01:임대 / 02:자가)", example = "00")
    private String lsSfTcd;
    @ApiModelProperty(notes = "사옥구분코드", example = "01")
    private String ofcbldTcd;
    @ApiModelProperty(notes = "자가지점기준년월", example = "202309")
    private String basYm;
    @ApiModelProperty(notes = "페이지사이즈", example = "0")
    private BigDecimal pageSize;
    @ApiModelProperty(notes = "페이지순번", example = "0")
    private BigDecimal pageIndex;

    public String getLsSfTcd() {
        return lsSfTcd;
    }

    public void setLsSfTcd(String lsSfTcd) {
        this.lsSfTcd = lsSfTcd;
    }

    public String getBasYm() {
        return basYm;
    }

    public void setBasYm(String basYm) {
        this.basYm = basYm;
    }

    public String getOfcbldTcd() {
        return ofcbldTcd;
    }

    public void setOfcbldTcd(String ofcbldTcd) {
        this.ofcbldTcd = ofcbldTcd;
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
