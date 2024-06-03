package com.miraeasset.biz.common.basic.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class BasicLoginHisInVO {

    @ApiModelProperty(notes= "사용자ID" )
    private String epno        ; /*사원번호    */
    @ApiModelProperty(notes= "조회시작일자", required = true, example ="20210101")
    private String strtDt        ; /* 조회시작일자    */
    @ApiModelProperty(notes= "조회종료일자", required = true, example ="20210123")
    private String endDt         ; /* 조회종료일자    */
    
    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;
    
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getStrtDt() {
		return strtDt;
	}
	public void setStrtDt(String strtDt) {
		this.strtDt = strtDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
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
