package com.miraeasset.biz.common.login.vo;

import com.miraeasset.biz.common.vo.BaseVO;

public class LoginUserPracticeHistoryVO extends BaseVO {

    public LoginUserPracticeHistoryVO(String psitMenuId, String ctrlNm) {
        this.psitMenuId = psitMenuId;
        this.ctrlNm = ctrlNm;
    }

    private String psitMenuId;
    private String ctrlNm;

    public String getPsitMenuId() {
        return psitMenuId;
    }

    public void setPsitMenuId(String psitMenuId) {
        this.psitMenuId = psitMenuId;
    }

    public String getCtrlNm() {
        return ctrlNm;
    }

    public void setCtrlNm(String ctrlNm) {
        this.ctrlNm = ctrlNm;
    }
}
