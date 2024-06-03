package com.miraeasset.biz.common.login.vo;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@Component
public class LoginInOtpVO extends LoginInVO {

    @ApiModelProperty(notes= "OTP", required = true, example ="123456")
    private String otp;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
