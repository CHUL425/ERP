package com.miraeasset.biz.rq.ur.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component 
public class RQUR1000U0In02VO {
	
    @ApiModelProperty(notes= "접수번호", required = true)
    private String rctNo;            // 접수번호

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

    
}
