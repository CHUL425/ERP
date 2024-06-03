/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: BR
*	03. 파    일   명	: BRLB1000V0In03VO.java
*	04. 작  성  일  자	: 2024.03.06
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 지점임차비용 비교 조회조건 IN
*	07. 주  요  사  항	: 조회
*******************************************************************************************************/
package com.miraeasset.biz.br.lb.vo;

import io.swagger.annotations.ApiModelProperty;

public class BRLB1000V0In03VO {
	
    @ApiModelProperty(notes = "첫번째 조직코드")
    private String frstOrzCd;
    @ApiModelProperty(notes = "두번째 조직코드")
    private String scndOrzCd;
    @ApiModelProperty(notes = "세번째 조직코드")
    private String thrdOrzCd;
    
	public String getFrstOrzCd() {
		return frstOrzCd;
	}
	public void setFrstOrzCd(String frstOrzCd) {
		this.frstOrzCd = frstOrzCd;
	}
	public String getScndOrzCd() {
		return scndOrzCd;
	}
	public void setScndOrzCd(String scndOrzCd) {
		this.scndOrzCd = scndOrzCd;
	}
	public String getThrdOrzCd() {
		return thrdOrzCd;
	}
	public void setThrdOrzCd(String thrdOrzCd) {
		this.thrdOrzCd = thrdOrzCd;
	}
}
