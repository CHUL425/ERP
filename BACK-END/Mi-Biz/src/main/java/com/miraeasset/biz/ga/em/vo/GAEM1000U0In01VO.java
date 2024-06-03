/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GAEM1000U0In01VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 업체관리 상세정보(PK) IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.em.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAEM1000U0In01VO {


    @ApiModelProperty(notes= "거래처코드", required = true)
    private String delpCd            ; /*거래처코드              */
    
    @ApiModelProperty(notes= "업종구분코드", required = true)
    private String bztpTcd           ; /*업종구분코드            */

    @ApiModelProperty(notes= "업종상세구분코드", required = true)
    private String bztpDlTcd         ; /*업종상세구분코드        */

	public String getDelpCd() {
		return delpCd;
	}

	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}

	public String getBztpTcd() {
		return bztpTcd;
	}

	public void setBztpTcd(String bztpTcd) {
		this.bztpTcd = bztpTcd;
	}

	public String getBztpDlTcd() {
		return bztpDlTcd;
	}

	public void setBztpDlTcd(String bztpDlTcd) {
		this.bztpDlTcd = bztpDlTcd;
	}

    
}

    
