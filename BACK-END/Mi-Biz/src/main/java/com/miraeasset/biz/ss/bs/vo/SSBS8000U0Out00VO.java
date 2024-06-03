package com.miraeasset.biz.ss.bs.vo;

import com.miraeasset.biz.common.vo.BaseVO;

public class SSBS8000U0Out00VO extends BaseVO {
    private String cdKndNo;
    private String cdKndNm;
    private String cmnCdDefCn;
    private int cdDgt;
    private int useYn;

    public String getCdKndNo() {
        return cdKndNo;
    }

    public void setCdKndNo(String cdKndNo) {
        this.cdKndNo = cdKndNo;
    }

    public String getCdKndNm() {
        return cdKndNm;
    }

    public void setCdKndNm(String cdKndNm) {
        this.cdKndNm = cdKndNm;
    }

    public String getCmnCdDefCn() {
        return cmnCdDefCn;
    }

    public void setCmnCdDefCn(String cmnCdDefCn) {
        this.cmnCdDefCn = cmnCdDefCn;
    }

    public int getCdDgt() {
        return cdDgt;
    }

    public void setCdDgt(int cdDgt) {
        this.cdDgt = cdDgt;
    }

    public int getUseYn() {
        return useYn;
    }

    public void setUseYn(int useYn) {
        this.useYn = useYn;
    }
}