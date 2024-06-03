package com.miraeasset.biz.br.rb.vo;

import io.swagger.annotations.ApiModelProperty;

public class BRRB2000V0In00VO {
    public BRRB2000V0In00VO() {}

    public BRRB2000V0In00VO(String basYm) {
        this.basYm = basYm;
    }

    @ApiModelProperty(notes = "기준년월", example = "202305")
    private String basYm;

    public String getBasYm() {
        return basYm;
    }

    public void setBasYm(String basYm) {
        this.basYm = basYm;
    }
}
