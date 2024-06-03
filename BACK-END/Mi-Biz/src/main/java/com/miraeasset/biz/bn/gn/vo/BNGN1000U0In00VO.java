/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: BN
*	03. 파    일   명	: BNGN1000U0In00VO.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 총무공지 목록조회 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.bn.gn.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class BNGN1000U0In00VO {

    @ApiModelProperty(notes= "조회시작일자", required = true)
    private String qryStrtDt;            // 조회시작일자
    @ApiModelProperty(notes= "조회종료일자", required = true)
    private String qryEndDt;            // 조회종료일자
    @ApiModelProperty(notes= "제목명" )
    private String ttlNm            ; /*제목명              */ 
    
    @ApiModelProperty(notes= "공지구분코드", required = true, example="01")
	private String cmklTcd          ; /*공지구분코드        */    
    
    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;      // 페이지사이즈
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;     // 페이지순번
	public String getQryStrtDt() {
		return qryStrtDt;
	}
	public void setQryStrtDt(String qryStrtDt) {
		this.qryStrtDt = qryStrtDt;
	}
	public String getQryEndDt() {
		return qryEndDt;
	}
	public void setQryEndDt(String qryEndDt) {
		this.qryEndDt = qryEndDt;
	}
	public String getTtlNm() {
		return ttlNm;
	}
	public void setTtlNm(String ttlNm) {
		this.ttlNm = ttlNm;
	}
	public String getCmklTcd() {
		return cmklTcd;
	}
	public void setCmklTcd(String cmklTcd) {
		this.cmklTcd = cmklTcd;
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
    
    
}

    
