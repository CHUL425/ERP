package com.miraeasset.biz.ss.bs.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * GA09N205
 */
public class SSBS7000VOOut00VO {
    @ApiModelProperty(notes = "사용자그룹코드")
    private String userGrpCd;
    @ApiModelProperty(notes = "접수번호")
    private String rctNo;
    @ApiModelProperty(notes = "화면ID")
    private String psitMenuId;
    @ApiModelProperty(notes = "처리가능여부")
    private String prcAblYn;
    @ApiModelProperty(notes = "전사권한여부")
    private String enpAccsAblYn;

    public String getUserGrpCd() {
        return userGrpCd;
    }

    public void setUserGrpCd(String userGrpCd) {
        this.userGrpCd = userGrpCd;
    }

    public String getRctNo() {
        return rctNo;
    }

    public void setRctNo(String rctNo) {
        this.rctNo = rctNo;
    }

    public String getPsitMenuId() {
        return psitMenuId;
    }

    public void setPsitMenuId(String psitMenuId) {
        this.psitMenuId = psitMenuId;
    }

    public String getPrcAblYn() {
        return prcAblYn;
    }

    public void setPrcAblYn(String prcAblYn) {
        this.prcAblYn = prcAblYn;
    }

    public String getEnpAccsAblYn() {
        return enpAccsAblYn;
    }

    public void setEnpAccsAblYn(String enpAccsAblYn) {
        this.enpAccsAblYn = enpAccsAblYn;
    }
}
