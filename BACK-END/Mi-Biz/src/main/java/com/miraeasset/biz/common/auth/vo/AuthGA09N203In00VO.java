package com.miraeasset.biz.common.auth.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

@Component
public class AuthGA09N203In00VO  extends BaseVO {

    @ApiModelProperty(notes= "사원번호", required = true, example="s1213617")
    private String epno;            // 사원번호

	public String getEpno() {
		return epno;
	}

	public void setEpno(String epno) {
		this.epno = epno;
	}
    
}
