package com.miraeasset.biz.br.lb.vo;

import io.swagger.annotations.ApiModelProperty;

public class BRLB1000V0In01VO {
    @ApiModelProperty(notes = "계정과목등급코드", example = "5")
    private String acsjGcd;

    public String getAcsjGcd() {
        return acsjGcd;
    }

    public void setAcsjGcd(String acsjGcd) {
        this.acsjGcd = acsjGcd;
    }
}
