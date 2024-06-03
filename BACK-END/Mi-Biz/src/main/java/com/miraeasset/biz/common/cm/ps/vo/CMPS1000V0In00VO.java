package com.miraeasset.biz.common.cm.ps.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class CMPS1000V0In00VO {
	
	@ApiModelProperty(notes = "검색키워드", required = true)
	private String srchKwrd;

	@ApiModelProperty(notes= "페이지사이즈", example="0")
	private BigDecimal pageSize	; 			 /* 페이지사이즈 */
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;            /* 페이지순번 */
    
	public String getSrchKwrd() {
		return srchKwrd;
	}
	public void setSrchKwrd(String srchKwrd) {
		this.srchKwrd = srchKwrd;
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
