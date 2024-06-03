package com.miraeasset.biz.common.basic.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class BasicUser00In00VO {

	@ApiModelProperty(notes= "사원번호")          
	private String epno           ;  /* 사원번호 */
	@ApiModelProperty(notes= "사원명")          
	private String epNm           ;  /* 사원명 */
	@ApiModelProperty(notes= "조직코드")          
	private String orzCd          ;  /* 조직코드 */
	@ApiModelProperty(notes= "조직명")          
	private String orzNm          ;  /* 조직명 */
	@ApiModelProperty(notes= "퇴직자제외여부")          
	private String rtmprIcldYn    ;  /* 퇴직자제외여부 */
	@ApiModelProperty(notes= "다음인사제직코드")          
	private String nextHrHldoCd   ;  /* 다음인사제직코드  */
	@ApiModelProperty(notes= "다음사원번호")          
	private String nextEpno       ;  /* 다음사원번호 */
	@ApiModelProperty(notes= "페이지순번", example="0")          
	private BigDecimal pageIndex  ;  /* 페이지순번 */
	@ApiModelProperty(notes= "페이지사이즈", example="0")          
	private BigDecimal pageSize   ;  /* 페이지사이즈 */
	
	@ApiModelProperty(notes= "임직원여부", example="0.전체, 1.임직원")
	private String xempYn		  ; /* 임직원 여부 */
	
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
	public String getOrzCd() {
		return orzCd;
	}
	public void setOrzCd(String orzCd) {
		this.orzCd = orzCd;
	}
	public String getRtmprIcldYn() {
		return rtmprIcldYn;
	}
	public void setRtmprIcldYn(String rtmprIcldYn) {
		this.rtmprIcldYn = rtmprIcldYn;
	}
	public String getNextHrHldoCd() {
		return nextHrHldoCd;
	}
	public void setNextHrHldoCd(String nextHrHldoCd) {
		this.nextHrHldoCd = nextHrHldoCd;
	}
	public String getNextEpno() {
		return nextEpno;
	}
	public void setNextEpno(String nextEpno) {
		this.nextEpno = nextEpno;
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
	public String getOrzNm() {
		return orzNm;
	}
	public void setOrzNm(String orzNm) {
		this.orzNm = orzNm;
	}
	public String getXempYn() {
		return xempYn;
	}
	public void setXempYn(String xempYn) {
		this.xempYn = xempYn;
	}
}
