package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N601InVO {
	
	@ApiModelProperty(notes= "결재선관리번호")
	private String aprvlMtNo; /*결재선관리번호 */

	public String getAprvlMtNo() {
		return aprvlMtNo;
	}

	public void setAprvlMtNo(String aprvlMtNo) {
		this.aprvlMtNo = aprvlMtNo;
	}
	
}
