package com.miraeasset.biz.common.code.vo;

import java.math.BigDecimal;

import com.miraeasset.biz.common.vo.BaseVO;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class UserCode00In00VO extends BaseVO {
	
    @ApiModelProperty(notes= "사원명")
	private String epNm        ;    /* 사원명 */                  

    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;
    
	public String getEpNm() {
		return epNm;
	}
	public void setEpNm(String epNm) {
		this.epNm = epNm;
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
