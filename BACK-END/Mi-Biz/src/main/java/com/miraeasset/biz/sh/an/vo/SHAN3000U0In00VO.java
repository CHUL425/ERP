/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SH
*	03. 파    일   명	: SHAN3000U0In00VO.java
*	04. 작  성  일  자	: 2024.02.07
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 안전보건공지 확인 전체조회 In
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.sh.an.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SHAN3000U0In00VO {
	
	@ApiModelProperty(notes= "공지구분코드", required=true)
	private String cmklTcd; 
	@ApiModelProperty(notes= "제목명", required=true)
	private String ttlNm            ;
	
	@ApiModelProperty(notes= "로그인정보-사원번호")
	private String epno;
	
	public String getCmklTcd() {
		return cmklTcd;
	}

	public void setCmklTcd(String cmklTcd) {
		this.cmklTcd = cmklTcd;
	}

	public String getTtlNm() {
		return ttlNm;
	}

	public void setTtlNm(String ttlNm) {
		this.ttlNm = ttlNm;
	}

	public String getEpno() {
		return epno;
	}

	public void setEpno(String epno) {
		this.epno = epno;
	}
	
}
