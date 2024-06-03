/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SH
*	03. 파    일   명	: SHAN3000U0In01VO.java
*	04. 작  성  일  자	: 2024.02.07
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 안전보건공지 확인 상세조회 In
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.sh.an.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SHAN3000U0In01VO {

	@ApiModelProperty(notes= "로그인정보-사원번호")
	private String epno;
	
	@ApiModelProperty(notes= "작성일자", required=true)
	private String madeDt; 
	@ApiModelProperty(notes= "일련번호", required=true)
	private BigDecimal srno; 
	@ApiModelProperty(notes= "공지구분코드", required=true)
	private String cmklTcd; 
	
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public BigDecimal getSrno() {
		return srno;
	}
	public void setSrno(BigDecimal srno) {
		this.srno = srno;
	}
	public String getMadeDt() {
		return madeDt;
	}
	public void setMadeDt(String madeDt) {
		this.madeDt = madeDt;
	}
	public String getCmklTcd() {
		return cmklTcd;
	}
	public void setCmklTcd(String cmklTcd) {
		this.cmklTcd = cmklTcd;
	} 
	
}
