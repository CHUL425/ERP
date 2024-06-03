package com.miraeasset.biz.rq.am.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQAM1000U0Out01VO {

	@ApiModelProperty(notes= "접수번호")
	private String rctNo;
	
	@ApiModelProperty(notes= "통합신청유형코드")
	private String unifRqsPcd;
	
	@ApiModelProperty(notes= "신청상태코드")
	private String rqsScd;

	@ApiModelProperty(notes= "팀장승인구분")
	private String aprvRtrnTcd;
	
	@ApiModelProperty(notes= "사전참조 승인구분")
	private String aprvRtrnTcdRef;
	
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	public String getUnifRqsPcd() {
		return unifRqsPcd;
	}
	public void setUnifRqsPcd(String unifRqsPcd) {
		this.unifRqsPcd = unifRqsPcd;
	}
	public String getRqsScd() {
		return rqsScd;
	}
	public void setRqsScd(String rqsScd) {
		this.rqsScd = rqsScd;
	}
	public String getAprvRtrnTcd() {
		return aprvRtrnTcd;
	}
	public void setAprvRtrnTcd(String aprvRtrnTcd) {
		this.aprvRtrnTcd = aprvRtrnTcd;
	}
	public String getAprvRtrnTcdRef() {
		return aprvRtrnTcdRef;
	}
	public void setAprvRtrnTcdRef(String aprvRtrnTcdRef) {
		this.aprvRtrnTcdRef = aprvRtrnTcdRef;
	}

}
