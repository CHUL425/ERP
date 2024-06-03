/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0In17VO.java
*	04. 작  성  일  자	: 2023.12.11
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 입고/폐기관리 IN
*	07. 주  요  사  항	: 입고/폐기
*******************************************************************************************************/

package com.miraeasset.biz.rq.sr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0In17VO {
	
	@ApiModelProperty(notes= "증명서유형", example = "")
	private String salMtNo; 
	@ApiModelProperty(notes= "인감증명서구분코드", example="인감증명서:10,등기부등본:20", required=true)
	private String sealCtfwTcd; 
	@ApiModelProperty(notes= "구분", required=true)
	private String sealCtfwScd; 
	@ApiModelProperty(notes= "유형", required=true)
	private String sealCtfwDlScd ; 
	@ApiModelProperty(notes= "발급일자", required=true)
	private String issDt; 
	@ApiModelProperty(notes= "폐기사유")
	private String sealCtfwDsusRsnCn;
	@ApiModelProperty(notes= "수량")
	private Integer rqsQty;  
	@ApiModelProperty(notes= "로그인사번:백앤드에서 입력")
	private String epno;
	
	public String getSealCtfwTcd() {
		return sealCtfwTcd;
	}
	public void setSealCtfwTcd(String sealCtfwTcd) {
		this.sealCtfwTcd = sealCtfwTcd;
	}
	
	public String getSalMtNo() {
		return salMtNo;
	}
	public void setSalMtNo(String salMtNo) {
		this.salMtNo = salMtNo;
	}
	public String getSealCtfwScd() {
		return sealCtfwScd;
	}
	public void setSealCtfwScd(String sealCtfwScd) {
		this.sealCtfwScd = sealCtfwScd;
	}
	public String getSealCtfwDlScd() {
		return sealCtfwDlScd;
	}
	public void setSealCtfwDlScd(String sealCtfwDlScd) {
		this.sealCtfwDlScd = sealCtfwDlScd;
	}
	public String getIssDt() {
		return issDt;
	}
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
	public String getSealCtfwDsusRsnCn() {
		return sealCtfwDsusRsnCn;
	}
	public void setSealCtfwDsusRsnCn(String sealCtfwDsusRsnCn) {
		this.sealCtfwDsusRsnCn = sealCtfwDsusRsnCn;
	}
	
	public Integer getRqsQty() {
		return rqsQty;
	}
	public void setRqsQty(Integer rqsQty) {
		this.rqsQty = rqsQty;
	}
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	
}
