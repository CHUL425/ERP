package com.miraeasset.biz.br.rb.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class BRRB1000U0Out02VO {
    @ApiModelProperty(notes = "임대면적")
    private BigDecimal rentAr = BigDecimal.valueOf(0);
    @ApiModelProperty(notes = "당사(자가지점)면적")
    private BigDecimal selfAr = BigDecimal.valueOf(0);
    @ApiModelProperty(notes = "당사기타사용면적")
    private BigDecimal selfEtcAr = BigDecimal.valueOf(0);
    @ApiModelProperty(notes = "공실면적")
    private BigDecimal vcnAr = BigDecimal.valueOf(0);
    @ApiModelProperty(notes = "사옥연면적")
    private BigDecimal ofcGar = BigDecimal.valueOf(0);

    public BigDecimal getRentAr() {
        return rentAr;
    }

    public void setRentAr(BigDecimal rentAr) {
        this.rentAr = rentAr;
    }

    public BigDecimal getSelfAr() {
        return selfAr;
    }

    public void setSelfAr(BigDecimal selfAr) {
        this.selfAr = selfAr;
    }

    public BigDecimal getSelfEtcAr() {
        return selfEtcAr;
    }

    public void setSelfEtcAr(BigDecimal selfEtcAr) {
        this.selfEtcAr = selfEtcAr;
    }

    public BigDecimal getVcnAr() {
        return vcnAr;
    }

    public void setVcnAr(BigDecimal vcnAr) {
        this.vcnAr = vcnAr;
    }

    public BigDecimal getOfcGar() {
        return ofcGar;
    }

    public void setOfcGar(BigDecimal ofcGar) {
        this.ofcGar = ofcGar;
    }
}
