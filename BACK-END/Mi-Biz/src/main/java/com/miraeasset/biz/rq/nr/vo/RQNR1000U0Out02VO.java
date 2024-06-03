package com.miraeasset.biz.rq.nr.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQNR1000U0Out02VO {
	
	@ApiModelProperty(notes= "도로명주소코드")
	private String zpcdSeq;
	@ApiModelProperty(notes= "우편번호")
	private String zpcd;
	@ApiModelProperty(notes= "주소")
	private String adr;
	@ApiModelProperty(notes= "총건수")
	private BigDecimal totCnt;
	
	public String getZpcdSeq() {
		return zpcdSeq;
	}
	public void setZpcdSeq(String zpcdSeq) {
		this.zpcdSeq = zpcdSeq;
	}
	public String getZpcd() {
		return zpcd;
	}
	public void setZpcd(String zpcd) {
		this.zpcd = zpcd;
	}
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}
	public BigDecimal getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(BigDecimal totCnt) {
		this.totCnt = totCnt;
	}
	
}
