package com.miraeasset.biz.rq.cr.vo;

import org.springframework.stereotype.Component;
import io.swagger.annotations.ApiModelProperty;

@Component
public class RQCR1000U0In02VO {
	
	@ApiModelProperty(notes= "신청일자", hidden = true)
	private String rqsDt           ; /* 신청일자 */
	
	@ApiModelProperty(notes= "접수번호")
	private String rctNo           ; /*접수번호         */

	public String getRqsDt() {
		return rqsDt;
	}

	public void setRqsDt(String rqsDt) {
		this.rqsDt = rqsDt;
	}

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
}
