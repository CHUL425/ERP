/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0In26VO.java
*	04. 작  성  일  자	: 2023.12.14
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 재출력 - 폐기 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0In26VO {
	
	@ApiModelProperty(notes= "접수번호")
	private String rctNo        ; 
	@ApiModelProperty(notes= "인장관리번호")
	private String salMtNo        ; 
	@ApiModelProperty(notes= "인감증명서신청시퀀스번호")
	private String sealCtfwRqsSqncNo     ; 
	@ApiModelProperty(notes= "증명서번호리스트", example="202312151000000024,202312151000000025")
	private String sealCtfwSqncNoDsus; 
	
	@ApiModelProperty(notes= "백앤드용")
	private List<String> sealCtfwSqncNoArr; 
	
	@ApiModelProperty(notes= "구분")
	private String sealCtfwScd; 
	@ApiModelProperty(notes= "유형")
	private String sealCtfwDlScd ; 
	@ApiModelProperty(notes= "폐기사유")
	private String sealCtfwDsusRsnCn;  
	@ApiModelProperty(notes= "로그인사번:백앤드에서 입력")
	private String epno;

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public String getSalMtNo() {
		return salMtNo;
	}

	public void setSalMtNo(String salMtNo) {
		this.salMtNo = salMtNo;
	}

	public String getSealCtfwRqsSqncNo() {
		return sealCtfwRqsSqncNo;
	}

	public void setSealCtfwRqsSqncNo(String sealCtfwRqsSqncNo) {
		this.sealCtfwRqsSqncNo = sealCtfwRqsSqncNo;
	}

	public List<String> getSealCtfwSqncNoArr() {
		return sealCtfwSqncNoArr;
	}

	public void setSealCtfwSqncNoArr(List<String> sealCtfwSqncNoArr) {
		this.sealCtfwSqncNoArr = sealCtfwSqncNoArr;
	}

	public String getSealCtfwSqncNoDsus() {
		return sealCtfwSqncNoDsus;
	}

	public void setSealCtfwSqncNoDsus(String sealCtfwSqncNoDsus) {
		this.sealCtfwSqncNoDsus = sealCtfwSqncNoDsus;
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

	public String getSealCtfwDsusRsnCn() {
		return sealCtfwDsusRsnCn;
	}

	public void setSealCtfwDsusRsnCn(String sealCtfwDsusRsnCn) {
		this.sealCtfwDsusRsnCn = sealCtfwDsusRsnCn;
	}

	public String getEpno() {
		return epno;
	}

	public void setEpno(String epno) {
		this.epno = epno;
	}
}

    
