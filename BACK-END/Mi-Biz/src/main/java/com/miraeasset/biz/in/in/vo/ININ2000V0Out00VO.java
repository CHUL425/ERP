package com.miraeasset.biz.in.in.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ININ2000V0Out00VO {
	
	@ApiModelProperty(notes= "업무구분명")
	private String bzTpNm           ; /*업무구분명 */
	
	@ApiModelProperty(notes= "연간예산")
	private BigDecimal ylyBdgtA	        ; /*연간예산 */
	
	@ApiModelProperty(notes= "배정")
	private BigDecimal asnA				;	/* 배정 */
	
	@ApiModelProperty(notes= "집행")
	private BigDecimal enfcA				; /* 집행 */
	
	@ApiModelProperty(notes= "배정대비")
	private BigDecimal asnCmpR			; /* 배정대비 */
	
	@ApiModelProperty(notes= "연간대비")
	private BigDecimal ylyCmpR			; /* 연간대비 */
	
	@ApiModelProperty(notes= "예산잔액")
	private BigDecimal bdgtBala			; /* 예산잔액 */

	public String getBzTpNm() {
		return bzTpNm;
	}

	public void setBzTpNm(String bzTpNm) {
		this.bzTpNm = bzTpNm;
	}

	public BigDecimal getYlyBdgtA() {
		return ylyBdgtA;
	}

	public void setYlyBdgtA(BigDecimal ylyBdgtA) {
		this.ylyBdgtA = ylyBdgtA;
	}

	public BigDecimal getAsnA() {
		return asnA;
	}

	public void setAsnA(BigDecimal asnA) {
		this.asnA = asnA;
	}

	public BigDecimal getEnfcA() {
		return enfcA;
	}

	public void setEnfcA(BigDecimal enfcA) {
		this.enfcA = enfcA;
	}

	public BigDecimal getAsnCmpR() {
		return asnCmpR;
	}

	public void setAsnCmpR(BigDecimal asnCmpR) {
		this.asnCmpR = asnCmpR;
	}

	public BigDecimal getYlyCmpR() {
		return ylyCmpR;
	}

	public void setYlyCmpR(BigDecimal ylyCmpR) {
		this.ylyCmpR = ylyCmpR;
	}

	public BigDecimal getBdgtBala() {
		return bdgtBala;
	}

	public void setBdgtBala(BigDecimal bdgtBala) {
		this.bdgtBala = bdgtBala;
	}
	
}