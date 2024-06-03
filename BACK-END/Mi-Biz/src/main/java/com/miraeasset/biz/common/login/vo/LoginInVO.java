package com.miraeasset.biz.common.login.vo;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@Component
public class LoginInVO {

    @ApiModelProperty(notes= "사용자ID", required = true, example ="3360135")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
