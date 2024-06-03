package com.miraeasset.biz.common.meta.vo;

public class GA09N602KeyVO {
    public GA09N602KeyVO(String aprvlMtNo, String aprvRnk) {
        this.aprvlMtNo = aprvlMtNo;
        this.aprvRnk = aprvRnk;
    }
    private String aprvlMtNo;
    private String aprvRnk;

    public String getAprvlMtNo() {
        return aprvlMtNo;
    }

    public void setAprvlMtNo(String aprvlMtNo) {
        this.aprvlMtNo = aprvlMtNo;
    }

    public String getAprvRnk() {
        return aprvRnk;
    }

    public void setAprvRnk(String aprvRnk) {
        this.aprvRnk = aprvRnk;
    }
}
