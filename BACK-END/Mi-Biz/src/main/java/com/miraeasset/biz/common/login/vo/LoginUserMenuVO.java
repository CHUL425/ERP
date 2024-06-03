package com.miraeasset.biz.common.login.vo;

import com.miraeasset.biz.ss.bs.vo.SSBS4000U0Out00VO;
import io.swagger.annotations.ApiModelProperty;

public class LoginUserMenuVO extends SSBS4000U0Out00VO {
    public LoginUserMenuVO() {}
    public LoginUserMenuVO(SSBS4000U0Out00VO menu) {
    }

    @ApiModelProperty(notes = "조회권한")
    private String qryAblYn;
    @ApiModelProperty(notes = "처리권한")
    private String prcAblYn;
    @ApiModelProperty(notes = "전사권한")
    private String enpAccsAblYn;
    @ApiModelProperty(notes = "즐겨찾기 여부")
    private String favoriteYn;

    public String getQryAblYn() {
        return qryAblYn;
    }

    public void setQryAblYn(String qryAblYn) {
        this.qryAblYn = qryAblYn;
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

    public String getFavoriteYn() {
        return favoriteYn;
    }

    public void setFavoriteYn(String favoriteYn) {
        this.favoriteYn = favoriteYn;
    }
}
