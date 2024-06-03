/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0In19VO.java
*	04. 작  성  일  자	: 2023.12.12
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 입고/폐기관리 조회
*	07. 주  요  사  항	: 
*******************************************************************************************************/

package com.miraeasset.biz.rq.sr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0In19VO {
	
	@ApiModelProperty(notes= "증명서코드")
	private String salMtNo        ;
	@ApiModelProperty(notes= "인감증명서구분코드", example = "인감증명서:10,  등기부등본:20")
	private String sealCtfwTcd; 
	@ApiModelProperty(notes= "구분")
	private String sealCtfwScd; 
	@ApiModelProperty(notes= "유형")
	private String sealCtfwDlScd ; 
	@ApiModelProperty(notes= "구분", example = "발급일자:I, 실시간:R")
	private String selTyp; 
	@ApiModelProperty(notes= "발급일자 FROM")
	private String issDtFrom;  
	@ApiModelProperty(notes= "발급일자 TO")
	private String issDtTo;   

	public String getIssDtFrom() {
		return issDtFrom;
	}
	public void setIssDtFrom(String issDtFrom) {
		this.issDtFrom = issDtFrom;
	}
	public String getIssDtTo() {
		return issDtTo;
	}
	public void setIssDtTo(String issDtTo) {
		this.issDtTo = issDtTo;
	}
	public String getSalMtNo() {
		return salMtNo;
	}
	public void setSalMtNo(String salMtNo) {
		this.salMtNo = salMtNo;
	}
	public String getSealCtfwTcd() {
		return sealCtfwTcd;
	}
	public void setSealCtfwTcd(String sealCtfwTcd) {
		this.sealCtfwTcd = sealCtfwTcd;
	}
	public String getSelTyp() {
		return selTyp;
	}
	public void setSelTyp(String selTyp) {
		this.selTyp = selTyp;
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
}
