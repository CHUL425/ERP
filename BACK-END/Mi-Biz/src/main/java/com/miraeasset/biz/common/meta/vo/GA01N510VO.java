/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA01N510VO.java
*	04. 작  성  일  자	: 2023.12.11
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 인감신청_인감증명서관리
*	07. 주  요  사  항	: 
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;


@Component
public class GA01N510VO extends BaseVO {

	@ApiModelProperty(notes= "인감증명서시퀀스번호")
	private String sealCtfwSqncNo        ; 
	@ApiModelProperty(notes= "인감증명서신청시퀀스번호")
	private String sealCtfwRqsSqncNo        ; 
	@ApiModelProperty(notes= "발급일자")
	private String issDt        ; 
	@ApiModelProperty(notes= "인감증명서구분코드")
	private String sealCtfwTcd        ; 
	@ApiModelProperty(notes= "인장관리번호")
	private String salMtNo        ; 
	@ApiModelProperty(notes= "인감증명서상태코드")
	private String sealCtfwScd        ; 
	@ApiModelProperty(notes= "인감증명서상세상태코드")
	private String sealCtfwDlScd        ; 
	@ApiModelProperty(notes= "입고일자")
	private String inqDt        ; 
	@ApiModelProperty(notes= "출고일자")
	private String outqDt        ; 
	@ApiModelProperty(notes= "폐기일자")
	private String dsusDt        ; 
	@ApiModelProperty(notes= "만료일자")
	private String xpirDt        ; 
	@ApiModelProperty(notes= "인감증명서폐기사유내용")
	private String sealCtfwDsusRsnCn        ; 
	@ApiModelProperty(notes= "인감증명서id내용")
	private String sealCtfwIdCn        ; 
	@ApiModelProperty(notes= "처리자사원번호")
	private String prcrEpno        ;
	
	@ApiModelProperty(notes= "인감증명서 MAX 시퀀스번호")
	private String sealCtfwSqncNoMax        ; 
	@ApiModelProperty(notes= "인감증명서 MIN 시퀀스번호")
	private String sealCtfwSqncNoMin        ; 
	
	@ApiModelProperty(notes= "신청수량", example="0")
	private Integer rqsQ  ;
	
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
	public String getInqDt() {
		return inqDt;
	}
	public void setInqDt(String inqDt) {
		this.inqDt = inqDt;
	}
	public String getOutqDt() {
		return outqDt;
	}
	public void setOutqDt(String outqDt) {
		this.outqDt = outqDt;
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
	public String getSealCtfwDsusRsnCn() {
		return sealCtfwDsusRsnCn;
	}
	public void setSealCtfwDsusRsnCn(String sealCtfwDsusRsnCn) {
		this.sealCtfwDsusRsnCn = sealCtfwDsusRsnCn;
	}
	public String getSealCtfwIdCn() {
		return sealCtfwIdCn;
	}
	public void setSealCtfwIdCn(String sealCtfwIdCn) {
		this.sealCtfwIdCn = sealCtfwIdCn;
	}
	public String getPrcrEpno() {
		return prcrEpno;
	}
	public void setPrcrEpno(String prcrEpno) {
		this.prcrEpno = prcrEpno;
	}
	public String getSealCtfwSqncNoMax() {
		return sealCtfwSqncNoMax;
	}
	public void setSealCtfwSqncNoMax(String sealCtfwSqncNoMax) {
		this.sealCtfwSqncNoMax = sealCtfwSqncNoMax;
	}
	public String getSealCtfwSqncNoMin() {
		return sealCtfwSqncNoMin;
	}
	public void setSealCtfwSqncNoMin(String sealCtfwSqncNoMin) {
		this.sealCtfwSqncNoMin = sealCtfwSqncNoMin;
	}
	public Integer getRqsQ() {
		return rqsQ;
	}
	public void setRqsQ(Integer rqsQ) {
		this.rqsQ = rqsQ;
	} 
}
