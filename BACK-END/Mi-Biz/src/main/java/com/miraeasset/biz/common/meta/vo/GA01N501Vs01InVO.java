/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA01N501Vs01InVO.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인장조제관리 원장 PK IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;


@Component
public class GA01N501Vs01InVO extends BaseVO {

	@ApiModelProperty(notes= "인장관리번호")
	private String salMtNo        ; /*인장관리번호  */ 

	public String getSalMtNo() {
		return salMtNo;
	}

}
