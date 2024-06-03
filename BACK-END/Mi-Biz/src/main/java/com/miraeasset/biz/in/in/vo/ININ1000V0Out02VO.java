package com.miraeasset.biz.in.in.vo;


import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ININ1000V0Out02VO {
	
	@ApiModelProperty(notes = "연간집행률")
	private String ylYenfcr		; /* 연간집행률 */
	
	@ApiModelProperty(notes = "누적배정금액")
	private String accmAsnA;   /* 누적배정금액 */
	
	@ApiModelProperty(notes = "배정대비집행율")
	private String asnCmpEnfcr; /* 배정대비집행율 */
	
	@ApiModelProperty(notes = "집행금액")
	private String enfcA		; /* 집행금액 */
	
	@ApiModelProperty(notes = "편성금액")
	private String bdgtFmtnA	; /* 편성금액 */

	public String getYlYenfcr() {
		return ylYenfcr;
	}

	public void setYlYenfcr(String ylYenfcr) {
		this.ylYenfcr = ylYenfcr;
	}

	public String getAccmAsnA() {
		return accmAsnA;
	}

	public void setAccmAsnA(String accmAsnA) {
		this.accmAsnA = accmAsnA;
	}

	public String getAsnCmpEnfcr() {
		return asnCmpEnfcr;
	}

	public void setAsnCmpEnfcr(String asnCmpEnfcr) {
		this.asnCmpEnfcr = asnCmpEnfcr;
	}

	public String getEnfcA() {
		return enfcA;
	}

	public void setEnfcA(String enfcA) {
		this.enfcA = enfcA;
	}

	public String getBdgtFmtnA() {
		return bdgtFmtnA;
	}

	public void setBdgtFmtnA(String bdgtFmtnA) {
		this.bdgtFmtnA = bdgtFmtnA;
	}
	
}
