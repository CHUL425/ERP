/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS4000U0In00VO.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 메뉴관리 목록조회 in
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.bs.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SSBS4000U0In00VO {
	    
    @ApiModelProperty(notes= "메뉴명/메뉴ID")
    private String menuSrch    ;  /*메뉴명/id 조회조건   */    

    @ApiModelProperty(notes= "사용여부 1:사용 0:미사용 NULL:전체")
    private String useYn   		;  /*사용여부      */

	public String getMenuSrch() {
		return menuSrch;
	}

	public void setMenuSrch(String menuSrch) {
		this.menuSrch = menuSrch;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
    
    
    
}
