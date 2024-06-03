package com.miraeasset.biz.common.basic.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class AprvOrg00VO {

	
	@ApiModelProperty(notes= "검색어", required = true, example = "조직코드,조직명,사원번호,사원명")
	private String schwCn		; /* 검색어 내용 */
	
	@ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;
	
    @ApiModelProperty(notes= "조직코드")
    private String orzCd        ; /* 조직코드 */
    
    @ApiModelProperty(notes= "조직명")
    private String orzNm		; /* 조직명 */
    
    @ApiModelProperty(notes= "조직약어명")
    private String orzAbrvNm	; /* 조직약어명 */
    @ApiModelProperty(notes= "조직영문명")
    private String orzEngNm		; /* 조직영문명 */
    @ApiModelProperty(notes= "사원번호")
    private String epno			; /* 사원번호 */
    @ApiModelProperty(notes= "사원명")
    private String epNm			; /* 사원명 */
    
    @ApiModelProperty(notes= "인사직책코드")
    private String hrOsdtcd		; /* 인사직책코드 */
    
    @ApiModelProperty(notes= "인사직책명")
    private String hrOsdtNm		; /* 인사직책명 */
    
	public String getHrOsdtcd() {
		return hrOsdtcd;
	}
	public void setHrOsdtcd(String hrOsdtcd) {
		this.hrOsdtcd = hrOsdtcd;
	}
	public String getHrOsdtNm() {
		return hrOsdtNm;
	}
	public void setHrOsdtNm(String hrOsdtNm) {
		this.hrOsdtNm = hrOsdtNm;
	}
	public String getSchwCn() {
		return schwCn;
	}
	public void setSchwCn(String schwCn) {
		this.schwCn = schwCn;
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
	public String getOrzCd() {
		return orzCd;
	}
	public void setOrzCd(String orzCd) {
		this.orzCd = orzCd;
	}
	public String getOrzNm() {
		return orzNm;
	}
	public void setOrzNm(String orzNm) {
		this.orzNm = orzNm;
	}
	public String getOrzAbrvNm() {
		return orzAbrvNm;
	}
	public void setOrzAbrvNm(String orzAbrvNm) {
		this.orzAbrvNm = orzAbrvNm;
	}
	public String getOrzEngNm() {
		return orzEngNm;
	}
	public void setOrzEngNm(String orzEngNm) {
		this.orzEngNm = orzEngNm;
	}
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getEpNm() {
		return epNm;
	}
	public void setEpNm(String epNm) {
		this.epNm = epNm;
	}
    
}
