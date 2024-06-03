/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: BM
*	03. 파    일   명	: GA01N505OutQ1VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA01N505 인장신청_인감증명서 인감기준 원장 항목
*	07. 주  요  사  항	: 
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;


@Component
public class GA01N505OutQ1VO extends BaseVO {
	
	@ApiModelProperty(notes= "인감증명서신청시퀀스번호 ")
	private String sealCtfwRqsSqncNo ; /*인감증명서신청시퀀스번호     */
	@ApiModelProperty(notes= "접수번호")
	private String rctNo      ; /*접수번호    */
	@ApiModelProperty(notes= "제출처내용")
	private String smitpCn    ; /*제출처내용  */
	@ApiModelProperty(notes= "제출용도내용")
	private String smitUsgeCn ; /*제출용도내용*/
	@ApiModelProperty(notes= "인장관리번호")
	private String salMtNo    ; /*인장관리번호*/
	@ApiModelProperty(notes= "인감관리명")
	private String salMtNm    ;  /*인감관리명*/
	@ApiModelProperty(notes= "신청수량", example="0")
	private BigDecimal rqsQ  ;
	@ApiModelProperty(notes= "증명서번호내용")
	private String srnoCn  ; 
	@ApiModelProperty(notes= "사용기간")
	private String useTerm     ; 
	@ApiModelProperty(notes= "출력/재출력 구분", example="OPUT: 출력, REOPUT:재출력")
	private String oputDiv; 
	
	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

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
	public String getUseTerm() {
		return useTerm;
	}

	public void setUseTerm(String useTerm) {
		this.useTerm = useTerm;
	}

	public String getSrnoCn() {
		return srnoCn;
	}

	public void setSrnoCn(String srnoCn) {
		this.srnoCn = srnoCn;
	}

	public BigDecimal getRqsQ() {
		return rqsQ;
	}

	public void setRqsQ(BigDecimal rqsQ) {
		this.rqsQ = rqsQ;
	}

	public String getOputDiv() {
		return oputDiv;
	}

	public void setOputDiv(String oputDiv) {
		this.oputDiv = oputDiv;
	}

	public String getSealCtfwRqsSqncNo() {
		return sealCtfwRqsSqncNo;
	}

	public void setSealCtfwRqsSqncNo(String sealCtfwRqsSqncNo) {
		this.sealCtfwRqsSqncNo = sealCtfwRqsSqncNo;
	}
}
