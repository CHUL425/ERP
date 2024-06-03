package com.miraeasset.biz.in.in.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ININ2000V0Out02VO {
	
	/* 연간 예산집행 */
	@ApiModelProperty(notes= "연간대비")
	private BigDecimal ylyCmpR			; /* 연간대비 */
	
	@ApiModelProperty(notes= "전년동기대비")
	private BigDecimal bfYlyCmpR		; /* 전년동기대비 */
	
	@ApiModelProperty(notes= "연간예산")
	private BigDecimal ylyBdgtA	        ; /*연간예산 */
	
	@ApiModelProperty(notes= "집행금액")
	private BigDecimal enfcA			; /* 집행금액 */
	
	@ApiModelProperty(notes= "예산잔액")
	private BigDecimal bdgtBala			; /* 예산잔액 */
	
	/* 분기누적 예산집행 */
	@ApiModelProperty(notes= "배정대비")
	private BigDecimal asnCmpR			; /* 배정대비 */
	
	@ApiModelProperty(notes= "전년동기배정대비")
	private BigDecimal bfYlyAsnCmpR		; /* 전년동기배정대비 */
	
	@ApiModelProperty(notes= "분기누적배정")
	private BigDecimal qtrAccmAsnA	    ; /*분기누적배정 */
	
	@ApiModelProperty(notes= "분기집행금액")
	private BigDecimal qtrEnfcA			; /* 분기집행금액 */
	
	@ApiModelProperty(notes= "분기예산잔액")
	private BigDecimal qtrBdgtBala		; /* 분기예산잔액 */

	public BigDecimal getYlyCmpR() {
		return ylyCmpR;
	}

	public BigDecimal getBfYlyCmpR() {
		return bfYlyCmpR;
	}

	public void setBfYlyCmpR(BigDecimal bfYlyCmpR) {
		this.bfYlyCmpR = bfYlyCmpR;
	}

	public BigDecimal getYlyBdgtA() {
		return ylyBdgtA;
	}

	public void setYlyBdgtA(BigDecimal ylyBdgtA) {
		this.ylyBdgtA = ylyBdgtA;
	}

	public BigDecimal getEnfcA() {
		return enfcA;
	}

	public void setEnfcA(BigDecimal enfcA) {
		this.enfcA = enfcA;
	}

	public BigDecimal getBdgtBala() {
		return bdgtBala;
	}

	public void setBdgtBala(BigDecimal bdgtBala) {
		this.bdgtBala = bdgtBala;
	}

	public BigDecimal getAsnCmpR() {
		return asnCmpR;
	}

	public void setAsnCmpR(BigDecimal asnCmpR) {
		this.asnCmpR = asnCmpR;
	}

	public BigDecimal getBfYlyAsnCmpR() {
		return bfYlyAsnCmpR;
	}

	public void setBfYlyAsnCmpR(BigDecimal bfYlyAsnCmpR) {
		this.bfYlyAsnCmpR = bfYlyAsnCmpR;
	}

	public BigDecimal getQtrAccmAsnA() {
		return qtrAccmAsnA;
	}

	public void setQtrAccmAsnA(BigDecimal qtrAccmAsnA) {
		this.qtrAccmAsnA = qtrAccmAsnA;
	}

	public BigDecimal getQtrEnfcA() {
		return qtrEnfcA;
	}

	public void setQtrEnfcA(BigDecimal qtrEnfcA) {
		this.qtrEnfcA = qtrEnfcA;
	}

	public BigDecimal getQtrBdgtBala() {
		return qtrBdgtBala;
	}

	public void setQtrBdgtBala(BigDecimal qtrBdgtBala) {
		this.qtrBdgtBala = qtrBdgtBala;
	}

	public void setYlyCmpR(BigDecimal ylyCmpR) {
		this.ylyCmpR = ylyCmpR;
	}
	
	
}