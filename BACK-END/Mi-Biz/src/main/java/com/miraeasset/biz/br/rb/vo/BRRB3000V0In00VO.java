package com.miraeasset.biz.br.rb.vo;

/**
 * 계산서 조회용 INPUT VO
 * */
public class BRRB3000V0In00VO extends BRRB2000V0In00VO {
    private String pchsSalsTcd;
    private String evdnPcd;
    private String rsnTcd;
    private String dscptSmryCn;
    private String ocrrAcsjCd;

    public String getPchsSalsTcd() {
        return pchsSalsTcd;
    }

    public void setPchsSalsTcd(String pchsSalsTcd) {
        this.pchsSalsTcd = pchsSalsTcd;
    }

    public String getEvdnPcd() {
        return evdnPcd;
    }

    public void setEvdnPcd(String evdnPcd) {
        this.evdnPcd = evdnPcd;
    }

    public String getRsnTcd() {
        return rsnTcd;
    }

    public void setRsnTcd(String rsnTcd) {
        this.rsnTcd = rsnTcd;
    }

    public String getDscptSmryCn() {
        return dscptSmryCn;
    }

    public void setDscptSmryCn(String dscptSmryCn) {
        this.dscptSmryCn = dscptSmryCn;
    }

    public String getOcrrAcsjCd() {
        return ocrrAcsjCd;
    }

    public void setOcrrAcsjCd(String ocrrAcsjCd) {
        this.ocrrAcsjCd = ocrrAcsjCd;
    }
}
