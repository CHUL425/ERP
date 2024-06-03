/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA03N105.java
*	04. 작  성  일  자	: 2024.05.10
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 물품구매/명함 신청내역
*	07. 주  요  사  항	: 
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;


@Component
public class GA03N102VO extends BaseVO {
	
	@ApiModelProperty(notes= "접수번호")
	private String rctNo;
	@ApiModelProperty(notes= "구매신청물품순번")
	private String pchRqsAtclSeq;
	@ApiModelProperty(notes= "물품구분코드")
	private String atclTcd;
	@ApiModelProperty(notes= "물품코드")
	private String atclCd;
	@ApiModelProperty(notes= "거래처코드")
	private String delpCd;
	@ApiModelProperty(notes= "사원번호")
	private String epno;
	@ApiModelProperty(notes= "필수요청사항")
	private String rqsRqmPtcrCn;
	@ApiModelProperty(notes= "구매가격")
	private BigDecimal pchPr;
	@ApiModelProperty(notes= "구매수량")
	private BigDecimal pchQ;
	@ApiModelProperty(notes= "구매합계")
	private BigDecimal pchSmtlA;
	
	@ApiModelProperty(notes= "사용자입력여부")
	private String userInptYn;
	
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	public String getPchRqsAtclSeq() {
		return pchRqsAtclSeq;
	}
	public void setPchRqsAtclSeq(String pchRqsAtclSeq) {
		this.pchRqsAtclSeq = pchRqsAtclSeq;
	}
	public String getAtclTcd() {
		return atclTcd;
	}
	public void setAtclTcd(String atclTcd) {
		this.atclTcd = atclTcd;
	}
	public String getAtclCd() {
		return atclCd;
	}
	public void setAtclCd(String atclCd) {
		this.atclCd = atclCd;
	}
	public String getDelpCd() {
		return delpCd;
	}
	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getRqsRqmPtcrCn() {
		return rqsRqmPtcrCn;
	}
	public void setRqsRqmPtcrCn(String rqsRqmPtcrCn) {
		this.rqsRqmPtcrCn = rqsRqmPtcrCn;
	}
	public BigDecimal getPchPr() {
		return pchPr;
	}
	public void setPchPr(BigDecimal pchPr) {
		this.pchPr = pchPr;
	}
	public BigDecimal getPchQ() {
		return pchQ;
	}
	public void setPchQ(BigDecimal pchQ) {
		this.pchQ = pchQ;
	}
	public BigDecimal getPchSmtlA() {
		return pchSmtlA;
	}
	public void setPchSmtlA(BigDecimal pchSmtlA) {
		this.pchSmtlA = pchSmtlA;
	}
	public String getUserInptYn() {
		return userInptYn;
	}
	public void setUserInptYn(String userInptYn) {
		this.userInptYn = userInptYn;
	}
}
