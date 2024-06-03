package com.miraeasset.biz.br.rb.vo;

import io.swagger.annotations.ApiModelProperty;

public class BRRB2000V0In01VO {
    @ApiModelProperty(notes = "조회년도", example = "2023")
    private String qryYear;

    public String getQryYear() {
        return qryYear;
    }

    public void setQryYear(String qryYear) {
        this.qryYear = qryYear;
    }

    public String getBasYm(int month) {
        return this.qryYear + String.format("%02d", month);
    }
}
