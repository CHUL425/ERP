package com.miraeasset.biz.br.rb.vo;

import io.swagger.annotations.ApiModelProperty;

public class BRRB1000U0In01VO {
    @ApiModelProperty(notes = "기준년월")
    private String basYm;
    @ApiModelProperty(notes = "사옥구분코드")
    private String ofcbldTcd;
    @ApiModelProperty(notes = "조직코드")
    private String orzCd;

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

    public String getOrzCd() {
        return orzCd;
    }

    public void setOrzCd(String orzCd) {
        this.orzCd = orzCd;
    }
}
