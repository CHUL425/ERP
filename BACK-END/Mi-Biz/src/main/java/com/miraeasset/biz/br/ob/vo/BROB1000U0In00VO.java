package com.miraeasset.biz.br.ob.vo;

import io.swagger.annotations.ApiModelProperty;

public class BROB1000U0In00VO {
    @ApiModelProperty(notes = "사옥구분코드")
    private String ofcbldTcd;

    public void setOfcbldTcd(String ofcbldTcd) {
        this.ofcbldTcd = ofcbldTcd;
    }

    public String getOfcbldTcd() {
        return ofcbldTcd;
    }
}
