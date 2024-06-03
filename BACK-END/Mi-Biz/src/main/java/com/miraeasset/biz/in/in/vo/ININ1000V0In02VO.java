package com.miraeasset.biz.in.in.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ININ1000V0In02VO {
	
	@ApiModelProperty(notes = "조회시작일자", hidden = true)
	private String qryStrtDt			; /* 조회시작일자 */
	
	@ApiModelProperty(notes = "년종료일자", hidden = true)
	private String qryEndDt				; /* 조회종료일자 */
	
	@ApiModelProperty(notes = "업무구분", example = "총무사업예산 IO 1.예산집행-전체, 2.예산집행-감가제외, 3.차트바, 4.소모품등")
	private String bzTp					; /* 업무 구분 */
	
	public String getQryStrtDt() {
		return qryStrtDt;
	}

	public void setQryStrtDt(String qryStrtDt) {
		this.qryStrtDt = qryStrtDt;
	}

	public String getQryEndDt() {
		return qryEndDt;
	}

	public void setQryEndDt(String qryEndDt) {
		this.qryEndDt = qryEndDt;
	}

	public String getBzTp() {
		return bzTp;
	}

	public void setBzTp(String bzTp) {
		this.bzTp = bzTp;
	}
	
}
