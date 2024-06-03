package com.miraeasset.biz.common.code.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class TeamCode00In00VO {
	
    @ApiModelProperty(notes= "조직명")
	private String orzNm        ;    /* 조직명 */                  

    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;

	//@ApiModelProperty(notes = "전체포함여부(1: 전체조회 / 0: 접근가능조직조회)", example = "1")
	//private String alIcldYn;
     
    @ApiModelProperty(notes = "폐쇄조직포함(1:포함 / 0: 미포함)", example = "1")
	private String orzUseYn;
    
	public String getOrzNm() {
		return orzNm;
	}
	public void setOrzNm(String orzNm) {
		this.orzNm = orzNm;
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
	public String getOrzUseYn() {
		return orzUseYn;
	}
	public void setOrzUseYn(String orzUseYn) {
		this.orzUseYn = orzUseYn;
	}
	
}
