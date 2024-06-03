/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0Out15VO.java
*	04. 작  성  일  자	: 2023.12.11
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 입고/폐기관리 증명서잔고현황 OUT
*	07. 주  요  사  항	: 
*******************************************************************************************************/

package com.miraeasset.biz.rq.sr.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0Out18VO {
	 
	@ApiModelProperty(notes= "인감증명서구분코드")
	private String sealCtfwTcd; 
	@ApiModelProperty(notes= "인장관리번호")
	private String salMtNo;
	
	@ApiModelProperty(notes= "증명서발급일자")
	private String issDt; 
	@ApiModelProperty(notes= "금일잔고") 
	private BigDecimal tdyRqsQ; 
	@ApiModelProperty(notes= "입고") 
	private BigDecimal inqRqsQ; 
	@ApiModelProperty(notes= "출고") 
	private BigDecimal outqRqsQ; 
	@ApiModelProperty(notes= "폐기") 
	private BigDecimal dsusRqsQ; 
	@ApiModelProperty(notes= "증명서만료일자")
	private String xpirDt;

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
	public String getIssDt() {
		return issDt;
	}
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
	public BigDecimal getTdyRqsQ() {
		return tdyRqsQ;
	}
	public void setTdyRqsQ(BigDecimal tdyRqsQ) {
		this.tdyRqsQ = tdyRqsQ;
	}
	public BigDecimal getInqRqsQ() {
		return inqRqsQ;
	}
	public void setInqRqsQ(BigDecimal inqRqsQ) {
		this.inqRqsQ = inqRqsQ;
	}
	public BigDecimal getOutqRqsQ() {
		return outqRqsQ;
	}
	public void setOutqRqsQ(BigDecimal outqRqsQ) {
		this.outqRqsQ = outqRqsQ;
	}
	public BigDecimal getDsusRqsQ() {
		return dsusRqsQ;
	}
	public void setDsusRqsQ(BigDecimal dsusRqsQ) {
		this.dsusRqsQ = dsusRqsQ;
	}
	public String getXpirDt() {
		return xpirDt;
	}
	public void setXpirDt(String xpirDt) {
		this.xpirDt = xpirDt;
	} 
}
