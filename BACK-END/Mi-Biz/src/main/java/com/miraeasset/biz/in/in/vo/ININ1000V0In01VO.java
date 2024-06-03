package com.miraeasset.biz.in.in.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ININ1000V0In01VO {
	
	@ApiModelProperty(notes = "년시작일자", hidden = true)
	private String yrDyStrtDt; /* 년시작일자 */
	
	@ApiModelProperty(notes = "년종료일자", hidden = true)
	private String yrDyEndDt; /* 년종료일자 */

	public String getYrDyStrtDt() {
		return yrDyStrtDt;
	}

	public void setYrDyStrtDt(String yrDyStrtDt) {
		this.yrDyStrtDt = yrDyStrtDt;
	}

	public String getYrDyEndDt() {
		return yrDyEndDt;
	}

	public void setYrDyEndDt(String yrDyEndDt) {
		this.yrDyEndDt = yrDyEndDt;
	}
	
	
}
