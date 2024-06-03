/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GAAM1000U0In01VO.java
*	04. 작  성  일  자	: 2024.05.22
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 물품리스트 조회 IN
*	07. 주  요  사  항	: 
*******************************************************************************************************/
package com.miraeasset.biz.ga.am.vo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAAM1000U0In01VO {

    @ApiModelProperty(notes= "물품구분", required = true, example = "02,03")
    private String atclTcd;
    @ApiModelProperty(hidden=true)
    private List<String> arrAtclTcd; 
    
    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex; 
	@ApiModelProperty(notes= "총건수-결과값세팅용")
	private long totCnt ;
    
	public String getAtclTcd() {
		return atclTcd;
	}

	public void setAtclTcd(String atclTcd) {
		this.atclTcd = atclTcd;
	}

	public List<String> getArrAtclTcd() {
		return arrAtclTcd;
	}

	public void setArrAtclTcd(List<String> arrAtclTcd) {
		this.arrAtclTcd = arrAtclTcd;
	}

	public BigDecimal getPageSize() {
		return pageSize;
	}

	public void setPageSize(BigDecimal pageSize) {
		this.pageSize = pageSize;
	}

	public BigDecimal getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(BigDecimal pageIndex) {
		this.pageIndex = pageIndex;
	}

	public long getTotCnt() {
		return totCnt;
	}

	public void setTotCnt(long totCnt) {
		this.totCnt = totCnt;
	}
}
    
