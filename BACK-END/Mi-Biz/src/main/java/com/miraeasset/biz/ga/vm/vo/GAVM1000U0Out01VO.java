package com.miraeasset.biz.ga.vm.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAVM1000U0Out01VO {
	
	@ApiModelProperty(notes = "총차량")
	private String vhcCnt = "0";
	
	@ApiModelProperty(notes = "총합계")
	private String alSmtl = "0";

	public String getVhcCnt() {
		return vhcCnt;
	}

	public void setVhcCnt(String vhcCnt) {
		this.vhcCnt = vhcCnt;
	}

	public String getAlSmtl() {
		return alSmtl;
	}

	public void setAlSmtl(String alSmtl) {
		this.alSmtl = alSmtl;
	}

	@Override
	public String toString() {
		return "GAVM1000U0Out01VO [vhcCnt=" + vhcCnt + ", alSmtl=" + alSmtl + "]";
	}
}
