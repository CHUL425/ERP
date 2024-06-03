package com.miraeasset.biz.rq.rr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQRR1000U0In05VO {

    @ApiModelProperty(notes= "접수번호", required = true)
    private String rctNo;            // 접수번호
    @ApiModelProperty(notes= "완료일자")
    private String cmpnDt;            // 완료일자
    
    @Override
    public String toString() {
        return "RQRR1000U0In05VO{" +
        		"rctNo          ='" + rctNo        + "'" +
        		"cmpnDt         ='" + cmpnDt       + "'" +
                '}';    	
    }

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public String getCmpnDt() {
		return cmpnDt;
	}

	public void setCmpnDt(String cmpnDt) {
		this.cmpnDt = cmpnDt;
	}	

    
}
