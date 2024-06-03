package com.miraeasset.biz.rq.nr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQNR1000U0Out01VO {
	
	@ApiModelProperty(notes= "사번")
	private String epno;
	@ApiModelProperty(notes= "자격증코드")
	private String lcnsCd;
	@ApiModelProperty(notes= "자격증명")
	private String lcnsNm;
	
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getLcnsCd() {
		return lcnsCd;
	}
	public void setLcnsCd(String lcnsCd) {
		this.lcnsCd = lcnsCd;
	}
	public String getLcnsNm() {
		return lcnsNm;
	}
	public void setLcnsNm(String lcnsNm) {
		this.lcnsNm = lcnsNm;
	}
	
	
}
