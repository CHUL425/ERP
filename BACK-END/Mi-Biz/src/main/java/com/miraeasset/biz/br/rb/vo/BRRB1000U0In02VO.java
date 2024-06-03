package com.miraeasset.biz.br.rb.vo;

import io.swagger.annotations.ApiModelProperty;

public class BRRB1000U0In02VO {
    @ApiModelProperty(notes = "자가지점기준년월", example = "202309")
    private String basYm;
    @ApiModelProperty(notes = "사옥구분코드", example = "01")
    private String ofcbldTcd;

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
}
