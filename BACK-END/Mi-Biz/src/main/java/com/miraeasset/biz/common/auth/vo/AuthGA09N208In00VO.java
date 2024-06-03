package com.miraeasset.biz.common.auth.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class AuthGA09N208In00VO {
	
	@ApiModelProperty(notes= "검색어", example = "태그검색")
    private String schw			;            // 검색어
	
	@ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize	;
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;
    
	public String getSchw() {
		return schw;
	}
	public void setSchw(String schw) {
		this.schw = schw;
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
