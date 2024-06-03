package com.miraeasset.biz.rq.cr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQCR1000U05VO {
	
	@ApiModelProperty(notes= "접수번호", required = true)
    private String rctNo;            // 접수번호
	
	@ApiModelProperty(notes= "신청일자")
	private String rqsDt;            // 신청일자
	
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	public String getRqsDt() {
		return rqsDt;
	}
	public void setRqsDt(String rqsDt) {
		this.rqsDt = rqsDt;
	}
	
	
	
}
