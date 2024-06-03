package com.miraeasset.biz.ga.vm.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAVM1010U0Out00VO {
	
	@ApiModelProperty(notes = "계약일수")
	private String cntcDys; /* 계약일수 */ 
	
	@ApiModelProperty(notes = "잔여일수")
	private String rmndDys; /* 잔여일수 */
	
	@ApiModelProperty(notes = "일렌트료")
	private String dtRentc; /* 일렌트료 */
    
	@ApiModelProperty(notes = "중도해지위약금")
	private String mclcBprmA; /* 중도해지위약금 = 잔여일수 * 일렌트료 * 10% */

	public String getCntcDys() {
		return cntcDys;
	}

	public void setCntcDys(String cntcDys) {
		this.cntcDys = cntcDys;
	}

	public String getRmndDys() {
		return rmndDys;
	}

	public void setRmndDys(String rmndDys) {
		this.rmndDys = rmndDys;
	}

	public String getDtRentc() {
		return dtRentc;
	}

	public void setDtRentc(String dtRentc) {
		this.dtRentc = dtRentc;
	}

	public String getMclcBprmA() {
		return mclcBprmA;
	}

	public void setMclcBprmA(String mclcBprmA) {
		this.mclcBprmA = mclcBprmA;
	}

	@Override
	public String toString() {
		return "GAVM1010U0Out00VO [cntcDys=" + cntcDys + ", rmndDys=" + rmndDys + ", dtRentc=" + dtRentc
				+ ", mclcBprmA=" + mclcBprmA + "]";
	}
	
}
