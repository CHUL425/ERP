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

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GABM1000U0In00VO {

    @ApiModelProperty(notes= "회계일자", required = true, example = "20230630")
    private String actgDt;            // 회계일자
    
    @ApiModelProperty(notes= "기준년월", hidden = true)
    private String basYm; // 기준년월
    
    @ApiModelProperty(notes= "년시작일자", hidden = true)
    private String yrDyStrtDt; // 년시작일자
    
    @ApiModelProperty(notes= "년종료일자", hidden = true)
    private String yrDyEndDt; // 년종료일자
    
    @ApiModelProperty(notes= "이전년월", hidden = true)
    private String yrbfBasYm;
    
    @ApiModelProperty(notes= "1년전시작일자", hidden = true)
    private String yr1DybfStrtDt; // 1년전시작일자
    
    @ApiModelProperty(notes= "1년전종료일자", hidden = true)
    private String yr1DybfEndDt; // 1년전종료일자

	public String getActgDt() {
		return actgDt;
	}

	public String getBasYm() {
		return basYm;
	}

	public void setBasYm(String basYm) {
		this.basYm = basYm;
	}

	public String getYrbfBasYm() {
		return yrbfBasYm;
	}

	public void setYrbfBasYm(String yrbfBasYm) {
		this.yrbfBasYm = yrbfBasYm;
	}

	public void setActgDt(String actgDt) {
		this.actgDt = actgDt;
	}

	public String getYrDyStrtDt() {
		return yrDyStrtDt;
	}

	public void setYrDyStrtDt(String yrDyStrtDt) {
		this.yrDyStrtDt = yrDyStrtDt;
	}

	public String getYrDyEndDt() {
		return yrDyEndDt;
	}

	public void setYrDyEndDt(String yrDyEndDt) {
		this.yrDyEndDt = yrDyEndDt;
	}

	public String getYr1DybfStrtDt() {
		return yr1DybfStrtDt;
	}

	public void setYr1DybfStrtDt(String yr1DybfStrtDt) {
		this.yr1DybfStrtDt = yr1DybfStrtDt;
	}

	public String getYr1DybfEndDt() {
		return yr1DybfEndDt;
	}

	public void setYr1DybfEndDt(String yr1DybfEndDt) {
		this.yr1DybfEndDt = yr1DybfEndDt;
	}
}
    
