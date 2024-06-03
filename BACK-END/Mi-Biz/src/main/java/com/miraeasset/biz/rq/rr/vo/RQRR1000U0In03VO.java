package com.miraeasset.biz.rq.rr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQRR1000U0In03VO {

    @ApiModelProperty(notes= "접수번호", required = true)
    private String rctNo;            // 접수번호

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

    @Override
    public String toString() {
        return "RQRR1000U0In03VO{" +
        		"rctNo          ='" + rctNo        + "'" +
                '}';    	
    }	
	
}
