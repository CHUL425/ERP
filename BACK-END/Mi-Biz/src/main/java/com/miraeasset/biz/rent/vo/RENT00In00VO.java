package com.miraeasset.biz.rent.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class RENT00In00VO {

    @ApiModelProperty(notes= "정산년월", required = true, example="202306")
    private String exccYm;            // 정산년월
    @ApiModelProperty(notes= "장비구분코드([EQMT_TCD] 01: 정수기, 02: 공기청정기, ...)", required = true, example = "01")
    private String eqmtTcd;           // 장비구분
    @ApiModelProperty(notes= "부점명")
    private String orzNm;             // 부점명
    @ApiModelProperty(notes= "관리업체", example = "100261023")
    private String delpCd;            // 관리업체
    @ApiModelProperty(notes= "계약번호")
    private String rentCntcNo;        // 계약번호
    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;      // 페이지사이즈
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;     // 페이지순번
    
	public String getExccYm() {
		return exccYm;
	}
	public void setExccYm(String exccYm) {
		this.exccYm = exccYm;
	}
	public String getEqmtTcd() {
		return eqmtTcd;
	}
	public void setEqmtTcd(String eqmtTcd) {
		this.eqmtTcd = eqmtTcd;
	}
	public String getOrzNm() {
		return orzNm;
	}
	public void setOrzNm(String orzNm) {
		this.orzNm = orzNm;
	}
	public String getDelpCd() {
		return delpCd;
	}
	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}
	public String getRentCntcNo() {
		return rentCntcNo;
	}
	public void setRentCntcNo(String rentCntcNo) {
		this.rentCntcNo = rentCntcNo;
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
