package com.miraeasset.biz.common.basic.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class BasicPost00In00VO {

    @ApiModelProperty(notes= "검색어")
    private String schw     ;  /* 검색어 */
    
	@ApiModelProperty(notes= "페이지순번", example="0")          
	private BigDecimal pageIndex  ;  /* 페이지순번 */
	@ApiModelProperty(notes= "페이지사이즈", example="0")          
	private BigDecimal pageSize   ;  /* 페이지사이즈 */
    

	public String getSchw() {
		return schw;
	}

	public void setSchw(String schw) {
		this.schw = schw;
	}

	public BigDecimal getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(BigDecimal pageIndex) {
		this.pageIndex = pageIndex;
	}

	public BigDecimal getPageSize() {
		return pageSize;
	}

	public void setPageSize(BigDecimal pageSize) {
		this.pageSize = pageSize;
	}            

    

}
