package com.miraeasset.biz.br.rb.vo;

import com.miraeasset.biz.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class BRRB1000U0Out01VO extends BaseVO {
    @ApiModelProperty(notes = "기준년월", required = true)
    private String basYm;
    @ApiModelProperty(notes = "사옥구분코드", required = true)
    private String ofcbldTcd;
    @ApiModelProperty(notes = "조직코드", required = true)
    private String orzCd;
    @ApiModelProperty(notes = "조직명", hidden = true)
    private String orzNm;
    @ApiModelProperty(notes = "입주사")
    private String lvinCoNm;
    @ApiModelProperty(notes = "임대면적")
    private BigDecimal rentAr;
    @ApiModelProperty(notes = "전용면적")
    private BigDecimal onlyAr;
    @ApiModelProperty(notes = "보증금")
    private BigDecimal grtA;
    @ApiModelProperty(notes = "임대료")
    private BigDecimal mlyRentc;
    @ApiModelProperty(notes = "관리비")
    private BigDecimal mlyMcst;

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

    public String getOrzNm() {
        return orzNm;
    }

    public void setOrzNm(String orzNm) {
        this.orzNm = orzNm;
    }

    public String getLvinCoNm() {
        return lvinCoNm;
    }

    public void setLvinCoNm(String lvinCoNm) {
        this.lvinCoNm = lvinCoNm;
    }

    public BigDecimal getRentAr() {
        return rentAr;
    }

    public void setRentAr(BigDecimal rentAr) {
        this.rentAr = rentAr;
    }

    public BigDecimal getOnlyAr() {
        return onlyAr;
    }

    public void setOnlyAr(BigDecimal onlyAr) {
        this.onlyAr = onlyAr;
    }

    public BigDecimal getGrtA() {
        return grtA;
    }

    public void setGrtA(BigDecimal grtA) {
        this.grtA = grtA;
    }

    public BigDecimal getMlyRentc() {
        return mlyRentc;
    }

    public void setMlyRentc(BigDecimal mlyRentc) {
        this.mlyRentc = mlyRentc;
    }

    public BigDecimal getMlyMcst() {
        return mlyMcst;
    }

    public void setMlyMcst(BigDecimal mlyMcst) {
        this.mlyMcst = mlyMcst;
    }
}
