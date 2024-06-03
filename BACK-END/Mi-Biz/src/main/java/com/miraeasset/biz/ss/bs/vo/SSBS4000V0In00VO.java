package com.miraeasset.biz.ss.bs.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class SSBS4000V0In00VO {

    @ApiModelProperty(notes= "사원번호", required = true, example="s1213617")
    private String epno;            // 사원번호

	public String getEpno() {
		return epno;
	}

	public void setEpno(String epno) {
		this.epno = epno;
	}
    
}
