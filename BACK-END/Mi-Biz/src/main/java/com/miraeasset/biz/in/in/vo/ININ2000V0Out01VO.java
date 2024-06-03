package com.miraeasset.biz.in.in.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ININ2000V0Out01VO {
	
	@ApiModelProperty(notes = "년도")
	private String yr		; /* 년도 */
	@ApiModelProperty(notes = "분기")
	private String qtr		; /* 분기 */
	@ApiModelProperty(notes = "계정과목코드")
	private String acsjCd	; /* 계정과목코드 */
	@ApiModelProperty(notes = "계정과목코드명")
	private String acsjCdNm	; /* 계정과목코드명 */
	@ApiModelProperty(notes = "집행률")
	private String enfcR	; /* 집행률 */
	
	public String getYr() {
		return yr;
	}
	public void setYr(String yr) {
		this.yr = yr;
	}
	public String getQtr() {
		return qtr;
	}
	public void setQtr(String qtr) {
		this.qtr = qtr;
	}
	public String getAcsjCd() {
		return acsjCd;
	}
	public void setAcsjCd(String acsjCd) {
		this.acsjCd = acsjCd;
	}
	public String getAcsjCdNm() {
		return acsjCdNm;
	}
	public void setAcsjCdNm(String acsjCdNm) {
		this.acsjCdNm = acsjCdNm;
	}
	public String getEnfcR() {
		return enfcR;
	}
	public void setEnfcR(String enfcR) {
		this.enfcR = enfcR;
	}
	
}