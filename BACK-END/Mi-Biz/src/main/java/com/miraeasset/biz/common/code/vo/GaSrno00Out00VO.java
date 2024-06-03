package com.miraeasset.biz.common.code.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GaSrno00Out00VO {
	
	@ApiModelProperty(notes= "업무별채번일련번호")
	private String rpbzGnoSrno	;    /* 업무별채번일련번호 */

	public String getRpbzGnoSrno() {
		return rpbzGnoSrno;
	}

	public void setRpbzGnoSrno(String rpbzGnoSrno) {
		this.rpbzGnoSrno = rpbzGnoSrno;
	}
	
}
