package com.miraeasset.biz.common.code.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class Code01In00VO {

    @ApiModelProperty(notes= "공통코드" , required = true)
	private String cmnCd          ; 
    @ApiModelProperty(notes= "공통코드분류")
	private String cmnCdClsfId    ; 
    @ApiModelProperty(notes= "공통코드값")
	private String cmnCdVl        ; 
    @ApiModelProperty(notes= "공통코드갑명")
	private String cmnCdVlNm      ; 
             
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
	public String getCmnCdClsfId() {
		return cmnCdClsfId;
	}
	public void setCmnCdClsfId(String cmnCdClsfId) {
		this.cmnCdClsfId = cmnCdClsfId;
	}
	public String getCmnCdVl() {
		return cmnCdVl;
	}
	public void setCmnCdVl(String cmnCdVl) {
		this.cmnCdVl = cmnCdVl;
	}
	public String getCmnCdVlNm() {
		return cmnCdVlNm;
	}
	public void setCmnCdVlNm(String cmnCdVlNm) {
		this.cmnCdVlNm = cmnCdVlNm;
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
