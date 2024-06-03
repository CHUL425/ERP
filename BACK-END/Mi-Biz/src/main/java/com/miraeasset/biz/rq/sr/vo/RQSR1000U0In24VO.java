/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0In24VO.java
*	04. 작  성  일  자	: 2023.12.14
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 인감날인증명서 출고/재출고 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0In24VO {
	
	@ApiModelProperty(notes= "접수번호")
	private String rctNo        ; 
	@ApiModelProperty(notes= "인감증명서신청시퀀스번호")
	private String sealCtfwRqsSqncNo        ;
	@ApiModelProperty(notes= "신청수량", example="0")
	private Integer rqsQ  ;
	@ApiModelProperty(notes= "인장관리번호")
	private String salMtNo        ; 
	
	@ApiModelProperty(notes= "인감증명서상태코드")
	private String sealCtfwScd        ; 
	@ApiModelProperty(notes= "인감증명서상세상태코드")
	private String sealCtfwDlScd        ; 
	@ApiModelProperty(notes= "로그인사번")
	private String epno        ;
	
	@ApiModelProperty(notes= "인감증명서ID내용")
	private String sealCtfwIdCn  ; 
	
	@ApiModelProperty(notes= "출력/재출력 구분", example="O:출력, R:재출력")
	private String selTyp        ; 
	@ApiModelProperty(notes= "재출력 선택건수",  example="0")
	private int reOputCnt        ; 
	
	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public String getSealCtfwRqsSqncNo() {
		return sealCtfwRqsSqncNo;
	}

	public void setSealCtfwRqsSqncNo(String sealCtfwRqsSqncNo) {
		this.sealCtfwRqsSqncNo = sealCtfwRqsSqncNo;
	}

	public String getEpno() {
		return epno;
	}

	public void setEpno(String epno) {
		this.epno = epno;
	}

	public Integer getRqsQ() {
		return rqsQ;
	}

	public void setRqsQ(Integer rqsQ) {
		this.rqsQ = rqsQ;
	}

	public String getSealCtfwScd() {
		return sealCtfwScd;
	}

	public void setSealCtfwScd(String sealCtfwScd) {
		this.sealCtfwScd = sealCtfwScd;
	}

	public String getSalMtNo() {
		return salMtNo;
	}

	public void setSalMtNo(String salMtNo) {
		this.salMtNo = salMtNo;
	}

	public String getSealCtfwDlScd() {
		return sealCtfwDlScd;
	}

	public void setSealCtfwDlScd(String sealCtfwDlScd) {
		this.sealCtfwDlScd = sealCtfwDlScd;
	}

	public String getSealCtfwIdCn() {
		return sealCtfwIdCn;
	}

	public void setSealCtfwIdCn(String sealCtfwIdCn) {
		this.sealCtfwIdCn = sealCtfwIdCn;
	}

	public String getSelTyp() {
		return selTyp;
	}

	public void setSelTyp(String selTyp) {
		this.selTyp = selTyp;
	}

	public int getReOputCnt() {
		return reOputCnt;
	}

	public void setReOputCnt(int reOputCnt) {
		this.reOputCnt = reOputCnt;
	}
}

    
