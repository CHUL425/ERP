package com.miraeasset.biz.rq.pr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQPR2000U0In00VO {
	
    @ApiModelProperty(notes= "접수번호", required = true)
    private String rctNo;           
    @ApiModelProperty(notes= "완료일자")
    private String cmpnDt;
    @ApiModelProperty(notes= "신청사원번호", hidden = true)
    private String rqsEpno;
    
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
	public String getRqsEpno() {
		return rqsEpno;
	}
	public void setRqsEpno(String rqsEpno) {
		this.rqsEpno = rqsEpno;
	}            
    
}
