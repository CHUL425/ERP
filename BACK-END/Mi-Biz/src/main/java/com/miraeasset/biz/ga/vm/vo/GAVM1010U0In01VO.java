package com.miraeasset.biz.ga.vm.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAVM1010U0In01VO {
	
	@ApiModelProperty(notes = "차량번호", required = true, example = "178허1167")
    private String vhcNo;             // 차량번호

	public String getVhcNo() {
		return vhcNo;
	}

	public void setVhcNo(String vhcNo) {
		this.vhcNo = vhcNo;
	}
	
}
