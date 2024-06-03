package com.miraeasset.biz.rq.nr.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQNR1000U0In00VO {
	
	@ApiModelProperty(notes= "사번")
	private String epno;
	
	@ApiModelProperty(notes= "주소조회조건")
	private String cond;
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;   
    @ApiModelProperty(notes= "페이지사이즈", example="50")
    private BigDecimal pageSize;
    
	@ApiModelProperty(notes= "총건수")
	private int totCnt;
	
	public String getEpno() {
		return epno;
	}

	public void setEpno(String epno) {
		this.epno = epno;
	}

	public String getCond() {
		return cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
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

	public int getTotCnt() {
		return totCnt;
	}

	public void setTotCnt(int totCnt) {
		this.totCnt = totCnt;
	}

}
