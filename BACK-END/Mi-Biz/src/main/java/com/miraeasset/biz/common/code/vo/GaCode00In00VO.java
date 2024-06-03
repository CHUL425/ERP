package com.miraeasset.biz.common.code.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GaCode00In00VO {

    @ApiModelProperty(notes= "코드종류번호", example = "")
	private String cdKndNo          ;    /* 코드종류번호 */                    
    @ApiModelProperty(notes= "코드종류명")
	private String cdKndNm          ;    /* 코드종류명 */                  

    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;

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
	public String getCdKndNo() {
		return cdKndNo;
	}
	public void setCdKndNo(String cdKndNo) {
		this.cdKndNo = cdKndNo;
	}
	public String getCdKndNm() {
		return cdKndNm;
	}
	public void setCdKndNm(String cdKndNm) {
		this.cdKndNm = cdKndNm;
	}

	
}
