package com.miraeasset.biz.common.cm.bs.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class CMBS1000V0In00VO {
	
	@ApiModelProperty(notes= "계정코드/명")
	private String acsjCd	; 			 /* 계정코드/명 */
	@ApiModelProperty(notes= "계정과목등급코드 ", example = "특정레벨계정과목 조회시(4,5,6만 가능)")
	private String acsjGcd	; 			 /* 계정과목등급코드  */
	
	@ApiModelProperty(notes= "페이지사이즈", example="0")
	private BigDecimal pageSize	; 			 /* 페이지사이즈 */
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;            /* 페이지순번 */
    
	public String getAcsjCd() {
		return acsjCd;
	}
	public void setAcsjCd(String acsjCd) {
		this.acsjCd = acsjCd;
	}
	public String getAcsjGcd() {
		return acsjGcd;
	}
	public void setAcsjGcd(String acsjGcd) {
		this.acsjGcd = acsjGcd;
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
