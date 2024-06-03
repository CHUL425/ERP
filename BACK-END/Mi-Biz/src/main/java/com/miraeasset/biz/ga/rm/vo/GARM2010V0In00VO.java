package com.miraeasset.biz.ga.rm.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class GARM2010V0In00VO {

    @ApiModelProperty(notes= "정산년월", required = true, example="202306")
    private String exccYm;            // 정산년월
        
	public String getExccYm() {
		return exccYm;
	}
	public void setExccYm(String exccYm) {
		this.exccYm = exccYm;
	}
    
}
