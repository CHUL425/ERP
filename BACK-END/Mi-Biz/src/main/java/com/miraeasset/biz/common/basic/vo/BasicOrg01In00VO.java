package com.miraeasset.biz.common.basic.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class BasicOrg01In00VO {

    @ApiModelProperty(notes= "조직코드", required = true)
    private String orzCd         ; /* 조직코드           */

	public String getOrzCd() {
		return orzCd;
	}

	public void setOrzCd(String orzCd) {
		this.orzCd = orzCd;
	}


    
}
