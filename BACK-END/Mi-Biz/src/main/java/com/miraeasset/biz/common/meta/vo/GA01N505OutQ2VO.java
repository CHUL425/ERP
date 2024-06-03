/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: BM
*	03. 파    일   명	: GA01N505OutQ2VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA01N505 인장신청_등기부등본 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA01N505OutQ2VO extends BaseVO {

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
	@ApiModelProperty(notes= "인감증명서ID내용")
	private String sealCtfwIdCn  ; 

	public String getSealCtfwRqsSqncNo() {
		return sealCtfwRqsSqncNo;
	}
	public void setSealCtfwRqsSqncNo(String sealCtfwRqsSqncNo) {
		this.sealCtfwRqsSqncNo = sealCtfwRqsSqncNo;
	}
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
	public BigDecimal getRqsQ() {
		return rqsQ;
	}
	public void setRqsQ(BigDecimal rqsQ) {
		this.rqsQ = rqsQ;
	}
	public String getSealCtfwIdCn() {
		return sealCtfwIdCn;
	}
	public void setSealCtfwIdCn(String sealCtfwIdCn) {
		this.sealCtfwIdCn = sealCtfwIdCn;
	}
}
