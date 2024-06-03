/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GASM1000U0Out12VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: RE100계약관리 전체계약용량 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.sm.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GASM1000U0Out12VO {
	
    @ApiModelProperty(notes= "전력구매계약용량 (전체설정계약용량)")
    private String allCntcCapa ; /*전체계약용량 */
    
    @ApiModelProperty(notes= "이행계약용량")
    private String achvCntcCapa ; /*이행계약용량 */
    
    @ApiModelProperty(notes= "이행율")
    private String achvRt      ; /*이행율 */

	public String getAllCntcCapa() {
		return allCntcCapa;
	}

	public void setAllCntcCapa(String allCntcCapa) {
		this.allCntcCapa = allCntcCapa;
	}

	public String getAchvCntcCapa() {
		return achvCntcCapa;
	}

	public void setAchvCntcCapa(String achvCntcCapa) {
		this.achvCntcCapa = achvCntcCapa;
	}

	public String getAchvRt() {
		return achvRt;
	}

	public void setAchvRt(String achvRt) {
		this.achvRt = achvRt;
	}
    
}
