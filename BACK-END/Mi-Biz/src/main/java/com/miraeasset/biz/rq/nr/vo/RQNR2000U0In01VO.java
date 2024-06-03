package com.miraeasset.biz.rq.nr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQNR2000U0In01VO {
	
    @ApiModelProperty(notes= "접수번호", required = true)
    private String rctNo;           
    @ApiModelProperty(notes= "완료일자")
    private String cmpnDt;            
    @ApiModelProperty(notes= "신청사원번호", hidden = true)
    private String rqsEpno;
    
	@ApiModelProperty(notes= "구매신청물품순번(미리보기)")
	private String pchRqsAtclSeq;
	
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
	public String getPchRqsAtclSeq() {
		return pchRqsAtclSeq;
	}
	public void setPchRqsAtclSeq(String pchRqsAtclSeq) {
		this.pchRqsAtclSeq = pchRqsAtclSeq;
	}
}
