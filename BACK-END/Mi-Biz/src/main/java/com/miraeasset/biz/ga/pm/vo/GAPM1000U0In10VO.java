/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GAPM1000U0In10VO.java
*	04. 작  성  일  자	: 2023.07.03
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 정기주차권관리 유무료 주차대수 수정 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.pm.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAPM1000U0In10VO {

	@ApiModelProperty(notes= "무료주차대수")
	private BigDecimal freeParkCnt      ; /* 무료주차대수 */		   

	@ApiModelProperty(notes= "유료주차대수")
	private BigDecimal paidParkCnt      ; /* 유료주차대수 */

	public BigDecimal getFreeParkCnt() {
		return freeParkCnt;
	}

	public void setFreeParkCnt(BigDecimal freeParkCnt) {
		this.freeParkCnt = freeParkCnt;
	}

	public BigDecimal getPaidParkCnt() {
		return paidParkCnt;
	}

	public void setPaidParkCnt(BigDecimal paidParkCnt) {
		this.paidParkCnt = paidParkCnt;
	}
	
	
}
    
