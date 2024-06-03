/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GAAM1000U0In00VO.java
*	04. 작  성  일  자	: 2024.05.22
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 구매물품코드별 조회 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.am.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAAM1000U0In00VO {

    @ApiModelProperty(notes= "물품코드", required = true, example = "0100001")
    private String atclCd;

	public String getAtclCd() {
		return atclCd;
	}

	public void setAtclCd(String atclCd) {
		this.atclCd = atclCd;
	}
    
}
    
