/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0In01VO.java
*	04. 작  성  일  자	: 2023.12.07
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 인감날인신청 재상신 IN
*	07. 주  요  사  항	: 재상신
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.vo;

import org.springframework.stereotype.Component;
import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0In05VO {

	@ApiModelProperty(notes= "접수번호")
	private String rctNo           ; 
	
	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
}

    
