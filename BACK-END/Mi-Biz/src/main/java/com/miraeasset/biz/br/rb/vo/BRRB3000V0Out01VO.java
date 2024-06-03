package com.miraeasset.biz.br.rb.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class BRRB3000V0Out01VO {
    @ApiModelProperty(notes = "기준년월", example = "202301")
    private String basYm;
    @ApiModelProperty(notes = "임대매출-보증금 운용수익", example = "0")
    private BigDecimal rentalDepositInterest;
    @ApiModelProperty(notes = "임대매출-임대료", example = "0")
    private BigDecimal rentalRentalFee;
    @ApiModelProperty(notes = "자가지점 환산매출-보증금 운용수익", example = "0")
    private BigDecimal selfDepositInterest;
    @ApiModelProperty(notes = "자가지점 환산매출-임대료", example = "0")
    private BigDecimal selfRentalFee;
    @ApiModelProperty(notes = "합계")
    private BigDecimal summation;

    public String getBasYm() {
        return basYm;
    }

    public void setBasYm(String basYm) {
        this.basYm = basYm;
    }

    public BigDecimal getRentalDepositInterest() {
        return rentalDepositInterest;
    }

    public void setRentalDepositInterest(BigDecimal rentalDepositInterest) {
        this.rentalDepositInterest = rentalDepositInterest;
    }

    public BigDecimal getRentalRentalFee() {
        return rentalRentalFee;
    }

    public void setRentalRentalFee(BigDecimal rentalRentalFee) {
        this.rentalRentalFee = rentalRentalFee;
    }

    public BigDecimal getSelfDepositInterest() {
        return selfDepositInterest;
    }

    public void setSelfDepositInterest(BigDecimal selfDepositInterest) {
        this.selfDepositInterest = selfDepositInterest;
    }

    public BigDecimal getSelfRentalFee() {
        return selfRentalFee;
    }

    public void setSelfRentalFee(BigDecimal selfRentalFee) {
        this.selfRentalFee = selfRentalFee;
    }

    public BigDecimal getSummation() {
        BigDecimal summation = BigDecimal.valueOf(0);
        summation = summation.add(rentalDepositInterest);
        summation = summation.add(rentalRentalFee);
        summation = summation.add(selfDepositInterest);
        summation = summation.add(selfRentalFee);
        return summation;
    }

    public void setSummation(BigDecimal summation) {
        this.summation = summation;
    }
}