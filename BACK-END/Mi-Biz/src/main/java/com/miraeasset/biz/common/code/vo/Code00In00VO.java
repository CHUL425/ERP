package com.miraeasset.biz.common.code.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class Code00In00VO {

    @ApiModelProperty(notes= "공통코드")
	private String cmnCd          ;    /* T1.공통코드 */                    
    @ApiModelProperty(notes= "공통코드명")
	private String cmnCdNm        ;    /* T1.공통코드명 */                  

    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;
	public String getCmnCd() {
		return cmnCd;
	}
	public void setCmnCd(String cmnCd) {
		this.cmnCd = cmnCd;
	}
	public String getCmnCdNm() {
		return cmnCdNm;
	}
	public void setCmnCdNm(String cmnCdNm) {
		this.cmnCdNm = cmnCdNm;
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
