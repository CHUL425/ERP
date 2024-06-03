/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GAPM1000U0In01VO.java
*	04. 작  성  일  자	: 2023.07.03
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 정기주차권관리 상세정보 in
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.pm.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAPM1000U0In01VO {

	@ApiModelProperty(notes= "차량번호")
	private String vhcNo      ; /* 차량번호 */		   

	public String getVhcNo() {
		return vhcNo;
	}

	public void setVhcNo(String vhcNo) {
		this.vhcNo = vhcNo;
	}

	
}
    
