/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0Out24VO.java
*	04. 작  성  일  자	: 2023.12.18
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 출고 - 내용미리보기 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0Out24VO {

	@ApiModelProperty(notes= "제출처내용")
	private String smitpCn    ;
	@ApiModelProperty(notes= "제출용도내용")
	private String smitUsgeCn ; 
	@ApiModelProperty(notes= "사용기간")
	private String useTerm    ;
	@ApiModelProperty(notes= "증명서번호")
	private String sealCtfwSqncNo ; 
    @ApiModelProperty(notes= "신청조직코드")
    private String rqsOrzCd      ; 
    @ApiModelProperty(notes= "신청조직명")
    private String rqsOrzNm      ; 
    @ApiModelProperty(notes= "신청사원번호")
    private String rqsEpno       ; 
    @ApiModelProperty(notes= "신청사원명")
    private String rqsEpNm       ;
    @ApiModelProperty(notes= "신청직급")
    private String rqsHrPstNm    ; 
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
	public String getUseTerm() {
		return useTerm;
	}
	public void setUseTerm(String useTerm) {
		this.useTerm = useTerm;
	}
	public String getSealCtfwSqncNo() {
		return sealCtfwSqncNo;
	}
	public void setSealCtfwSqncNo(String sealCtfwSqncNo) {
		this.sealCtfwSqncNo = sealCtfwSqncNo;
	}
	public String getRqsOrzCd() {
		return rqsOrzCd;
	}
	public void setRqsOrzCd(String rqsOrzCd) {
		this.rqsOrzCd = rqsOrzCd;
	}
	public String getRqsOrzNm() {
		return rqsOrzNm;
	}
	public void setRqsOrzNm(String rqsOrzNm) {
		this.rqsOrzNm = rqsOrzNm;
	}
	public String getRqsEpno() {
		return rqsEpno;
	}
	public void setRqsEpno(String rqsEpno) {
		this.rqsEpno = rqsEpno;
	}
	public String getRqsEpNm() {
		return rqsEpNm;
	}
	public void setRqsEpNm(String rqsEpNm) {
		this.rqsEpNm = rqsEpNm;
	}
	public String getRqsHrPstNm() {
		return rqsHrPstNm;
	}
	public void setRqsHrPstNm(String rqsHrPstNm) {
		this.rqsHrPstNm = rqsHrPstNm;
	} 
}
