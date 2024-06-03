/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS5000U0In01VO.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 화면관리 상세조회 in
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.bs.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SSBS5000U0In01VO {

	public SSBS5000U0In01VO() {}

	public SSBS5000U0In01VO(String psitMenuId) {
		this.psitMenuId = psitMenuId;
	}
	    
    @ApiModelProperty(notes= "포털사이트메뉴ID")
    private String psitMenuId  ;  /*포털사이트메뉴ID*/

	public String getPsitMenuId() {
		return psitMenuId;
	}

	public void setPsitMenuId(String psitMenuId) {
		this.psitMenuId = psitMenuId;
	}

    
}
