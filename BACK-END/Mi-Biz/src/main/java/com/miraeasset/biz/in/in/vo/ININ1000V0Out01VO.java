package com.miraeasset.biz.in.in.vo;


import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ININ1000V0Out01VO {
	
	@ApiModelProperty(notes = "집행률")
	private String enfcr		; /* 집행률 */
	
	@ApiModelProperty(notes = "편성금액")
	private String bdgtFmtnA	; /* 편성금액 */
	
	@ApiModelProperty(notes = "집행금액")
	private String enfcA		; /* 집행금액 */
	
	@ApiModelProperty(notes = "예산잔액")
    private String bdgtBala		; /* 예산잔액 */

	public String getEnfcr() {
		return enfcr;
	}

	public void setEnfcr(String enfcr) {
		this.enfcr = enfcr;
	}

	public String getBdgtFmtnA() {
		return bdgtFmtnA;
	}

	public void setBdgtFmtnA(String bdgtFmtnA) {
		this.bdgtFmtnA = bdgtFmtnA;
	}

	public String getEnfcA() {
		return enfcA;
	}

	public void setEnfcA(String enfcA) {
		this.enfcA = enfcA;
	}

	public String getBdgtBala() {
		return bdgtBala;
	}

	public void setBdgtBala(String bdgtBala) {
		this.bdgtBala = bdgtBala;
	} 
	
}
