package com.miraeasset.biz.common.code.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GaSrno00In00VO {

	@ApiModelProperty(notes= "코드종류번호")
	private String cdKndNo          ;    /* 코드종류번호 */

	@ApiModelProperty(notes= "공통코드값")
	private String cmnCdVl        ;    /* 공통코드값 */

	@ApiModelProperty(notes= "업무별채번유형")
	private String rpbzGnoPcd	;    /* 업무별채번유형 */

	@ApiModelProperty(notes= "업무별채번일련번호")
	private String rpbzGnoSrno	;    /* 업무별채번일련번호 */


	public String getCdKndNo() {
	return cdKndNo;
	} public void setCdKndNo(String cdKndNo) {
	this.cdKndNo = cdKndNo;
	}
	public String getCmnCdVl() {
	return cmnCdVl;
	} public void setCmnCdVl(String cmnCdVl) { this.cmnCdVl = cmnCdVl; }
	public String getRpbzGnoPcd() { return rpbzGnoPcd; } public void setRpbzGnoPcd(String rpbzGnoPcd) { this.rpbzGnoPcd = rpbzGnoPcd; }
	public String getRpbzGnoSrno() {
		return rpbzGnoSrno;
	} public void setRpbzGnoSrno(String rpbzGnoSrno) {
		this.rpbzGnoSrno = rpbzGnoSrno;
	}

}
