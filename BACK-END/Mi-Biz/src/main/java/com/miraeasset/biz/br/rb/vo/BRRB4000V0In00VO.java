package com.miraeasset.biz.br.rb.vo;

import io.swagger.annotations.ApiModelProperty;

public class BRRB4000V0In00VO extends BRRB2000V0In00VO {
    public BRRB4000V0In00VO() {

    }

    public BRRB4000V0In00VO(String basYm, String orzCd, String acsjCd, String dscptSmryCn, String expDscptSmryCn) {
        this.setBasYm(basYm);
        this.orzCd = orzCd;
        this.acsjCd = acsjCd;
        this.dscptSmryCn = dscptSmryCn;
        this.expDscptSmryCn = expDscptSmryCn;
    }

    @ApiModelProperty(notes = "조직코드")
    private String orzCd;
    @ApiModelProperty(notes = "계정과목코드")
    private String acsjCd;
    @ApiModelProperty(notes = "서술적요")
    private String dscptSmryCn;
    @ApiModelProperty(notes = "제외서술적요")
    private String expDscptSmryCn;

    public String getOrzCd() {
        return orzCd;
    }

    public void setOrzCd(String orzCd) {
        this.orzCd = orzCd;
    }

    public String getAcsjCd() {
        return acsjCd;
    }

    public void setAcsjCd(String acsjCd) {
        this.acsjCd = acsjCd;
    }

    public String getDscptSmryCn() {
        return dscptSmryCn;
    }

    public void setDscptSmryCn(String dscptSmryCn) {
        this.dscptSmryCn = dscptSmryCn;
    }

    public String getExpDscptSmryCn() {
        return expDscptSmryCn;
    }

    public void setExpDscptSmryCn(String expDscptSmryCn) {
        this.expDscptSmryCn = expDscptSmryCn;
    }
}
