/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0Out15VO.java
*	04. 작  성  일  자	: 2023.12.11
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 입고/폐기관리 증명서유형 OUT
*	07. 주  요  사  항	: 
*******************************************************************************************************/

package com.miraeasset.biz.rq.sr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0Out15VO {
	
	@ApiModelProperty(notes= "인장관리번호")
	private String salMtNo        ; /*인장관리번호  */ 
	@ApiModelProperty(notes= "인장관리명")
	private String salMtNm        ; /*인장관리명  */
	@ApiModelProperty(notes= "인감증명서구분코드 ")
	private String sealCtfwTcd    ; /*인감증명서구분코드   */
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
	public String getSealCtfwTcd() {
		return sealCtfwTcd;
	}
	public void setSealCtfwTcd(String sealCtfwTcd) {
		this.sealCtfwTcd = sealCtfwTcd;
	}
}
