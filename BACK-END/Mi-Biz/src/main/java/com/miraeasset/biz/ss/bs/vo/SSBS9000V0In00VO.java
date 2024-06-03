package com.miraeasset.biz.ss.bs.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class SSBS9000V0In00VO {

    @ApiModelProperty(notes= "계정과목검색", example="5270100100")
    private String acsjSrch	;            // 계정과목검색
    @ApiModelProperty(notes= "프로젝트명", example="감가상각비")
    private String prjtNm	;            // 프로젝트명
    
    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;      // 페이지사이즈
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;     // 페이지순번
    
	public String getAcsjSrch() {
		return acsjSrch;
	}
	public void setAcsjSrch(String acsjSrch) {
		this.acsjSrch = acsjSrch;
	}
	public String getPrjtNm() {
		return prjtNm;
	}
	public void setPrjtNm(String prjtNm) {
		this.prjtNm = prjtNm;
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
