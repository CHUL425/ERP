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

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0Out19VO {
	
	@ApiModelProperty(notes= "발급일자")
	private String issDt; 
	@ApiModelProperty(notes= "인감증명서상태코드")
	private String sealCtfwScd; 
	@ApiModelProperty(notes= "인감증명서상태명")
	private String sealCtfwScdNm; 
	@ApiModelProperty(notes= "인감증명서상세상태코드")
	private String sealCtfwDlScd; 
	@ApiModelProperty(notes= "인감증명서상세상태명")
	private String sealCtfwDlScdNm; 
	@ApiModelProperty(notes= "수량") 
	private BigDecimal rqsQ        ; 
	@ApiModelProperty(notes= "증명서번호구간")
	private String sealCtfwNoSect; 
	@ApiModelProperty(notes= "인감증명서폐기사유내용")
	private String sealCtfwDsusRsnCn; 
	@ApiModelProperty(notes= "폐기일자")
	private String dsusDt        ; 
	@ApiModelProperty(notes= "만료일자")
	private String xpirDt        ;
	
	@ApiModelProperty(notes= "인장관리번호")
	private String salMtNo        ; 
	
	public String getIssDt() {
		return issDt;
	}
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
	public String getSealCtfwScd() {
		return sealCtfwScd;
	}
	public void setSealCtfwScd(String sealCtfwScd) {
		this.sealCtfwScd = sealCtfwScd;
	}
	public String getSealCtfwScdNm() {
		return sealCtfwScdNm;
	}
	public void setSealCtfwScdNm(String sealCtfwScdNm) {
		this.sealCtfwScdNm = sealCtfwScdNm;
	}
	public String getSealCtfwDlScd() {
		return sealCtfwDlScd;
	}
	public void setSealCtfwDlScd(String sealCtfwDlScd) {
		this.sealCtfwDlScd = sealCtfwDlScd;
	}
	public String getSealCtfwDlScdNm() {
		return sealCtfwDlScdNm;
	}
	public void setSealCtfwDlScdNm(String sealCtfwDlScdNm) {
		this.sealCtfwDlScdNm = sealCtfwDlScdNm;
	}
	public BigDecimal getRqsQ() {
		return rqsQ;
	}
	public void setRqsQ(BigDecimal rqsQ) {
		this.rqsQ = rqsQ;
	}
	public String getSealCtfwNoSect() {
		return sealCtfwNoSect;
	}
	public void setSealCtfwNoSect(String sealCtfwNoSect) {
		this.sealCtfwNoSect = sealCtfwNoSect;
	}
	public String getSealCtfwDsusRsnCn() {
		return sealCtfwDsusRsnCn;
	}
	public void setSealCtfwDsusRsnCn(String sealCtfwDsusRsnCn) {
		this.sealCtfwDsusRsnCn = sealCtfwDsusRsnCn;
	}
	public String getDsusDt() {
		return dsusDt;
	}
	public void setDsusDt(String dsusDt) {
		this.dsusDt = dsusDt;
	}
	public String getXpirDt() {
		return xpirDt;
	}
	public void setXpirDt(String xpirDt) {
		this.xpirDt = xpirDt;
	}
	public String getSalMtNo() {
		return salMtNo;
	}
	public void setSalMtNo(String salMtNo) {
		this.salMtNo = salMtNo;
	} 

}
