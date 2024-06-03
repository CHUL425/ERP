/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GACM1000U0In00VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 계약서관리 목록조회 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.bm.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GABM1000U0VO {
	
	@ApiModelProperty(notes = "편성금액관리", example = "회계일자, 소계정코드 필수")
    List<GABM1000U0In01VO> inputList;

	public List<GABM1000U0In01VO> getInputList() {
		return inputList;
	}

	public void setInputList(List<GABM1000U0In01VO> inputList) {
		this.inputList = inputList;
	}
    
}
    
