package com.miraeasset.biz.br.er.vo;

import java.math.BigDecimal;


import io.swagger.annotations.ApiModelProperty;

public class BRER2000U0In00VO {
	public BRER2000U0In00VO() {}
	public BRER2000U0In00VO(String orzCd) {
		this.orzCd = orzCd;
	}
	@ApiModelProperty(notes= "페이지사이즈", example="0")
	private BigDecimal pageSize;      // 페이지사이즈
	@ApiModelProperty(notes= "페이지순번", example="0")
	private BigDecimal pageIndex;     // 페이지순번
    @ApiModelProperty(notes= "조직코드")
    private String orzCd;            // 조직코드
    @ApiModelProperty(notes= "구분명")
    private String tpNm;             // 구분명    

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

	public String getOrzCd() {
		return orzCd;
	}

	public void setOrzCd(String orzCd) {
		this.orzCd = orzCd;
	}

	public String getTpNm() {
		return tpNm;
	}

	public void setTpNm(String tpNm) {
		this.tpNm = tpNm;
	}
}
    
