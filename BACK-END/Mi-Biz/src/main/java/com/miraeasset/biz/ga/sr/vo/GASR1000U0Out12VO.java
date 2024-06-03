/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GASR1000U0Out12VO.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인장조제관리 일반인감 인장유형/상세 콤보 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ga.sr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GASR1000U0Out12VO {
	
	@ApiModelProperty(notes= "인장관리번호")
	private String salMtNo        ; /*인장관리번호  */ 
	@ApiModelProperty(notes= "인장관리명")
	private String salMtNm        ; /*인장관리명  */
	public String getSalMtNo() {
		return salMtNo;
	}
	public void setSalMtNo(String salMtNo) {
		this.salMtNo = salMtNo;
	}
	public String getSalMtNm() {
		return salMtNm;
	}
	public void setSalMtNm(String salMtNm) {
		this.salMtNm = salMtNm;
	} 
	

}
