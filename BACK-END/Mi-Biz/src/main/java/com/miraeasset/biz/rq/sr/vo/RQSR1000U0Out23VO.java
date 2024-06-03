/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0Out23VO.java
*	04. 작  성  일  자	: 2023.12.15
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 인감날인증명서신청 사전참조 내역조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0Out23VO {

	@ApiModelProperty(notes= "제출처내용")
	private String smitpCn    ;
	@ApiModelProperty(notes= "제출용도내용")
	private String smitUsgeCn ; 
	
	@ApiModelProperty(notes= "인감증명서시퀀스번호")
	private String sealCtfwSqncNo        ; 
	@ApiModelProperty(notes= "인감증명서신청시퀀스번호")
	private String sealCtfwRqsSqncNo     ; 
	@ApiModelProperty(notes= "발급일자")
	private String issDt        ;
	@ApiModelProperty(notes= "인감증명서구분코드")
	private String sealCtfwTcd        ; 
	@ApiModelProperty(notes= "인장관리번호")
	private String salMtNo        ; 
	@ApiModelProperty(notes= "발급증명서")
	private String salMtNm        ; 
	@ApiModelProperty(notes= "접수번호")
	private String rctNo        ; 
	
	public String getSmitpCn() {
		return smitpCn;
	}
	public void setSmitpCn(String smitpCn) {
		this.smitpCn = smitpCn;
	}
	public String getSmitUsgeCn() {
		return smitUsgeCn;
	}
	public void setSmitUsgeCn(String smitUsgeCn) {
		this.smitUsgeCn = smitUsgeCn;
	}
	public String getSealCtfwSqncNo() {
		return sealCtfwSqncNo;
	}
	public void setSealCtfwSqncNo(String sealCtfwSqncNo) {
		this.sealCtfwSqncNo = sealCtfwSqncNo;
	}
	public String getSealCtfwRqsSqncNo() {
		return sealCtfwRqsSqncNo;
	}
	public void setSealCtfwRqsSqncNo(String sealCtfwRqsSqncNo) {
		this.sealCtfwRqsSqncNo = sealCtfwRqsSqncNo;
	}
	public String getIssDt() {
		return issDt;
	}
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
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
	public String getSalMtNm() {
		return salMtNm;
	}
	public void setSalMtNm(String salMtNm) {
		this.salMtNm = salMtNm;
	}
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	
}
