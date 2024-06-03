package com.miraeasset.biz.in.in.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ININ1000V0In00VO {
	
	@ApiModelProperty(notes = "사원번호")
	private String epno; /* 사원번호 */
	
	@ApiModelProperty(notes = "조직코드")
	private String blngOrzCd; /* 조직코드 */
	
	@ApiModelProperty(notes = "직급코드")
	private String hrOsdtCd; /* 직급코드 */
	
	@ApiModelProperty(notes = "업무구분")
	private String aprvPcd; /* 업무구분 */
	
	@ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;      // 페이지사이즈
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;     // 페이지순번
    
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getBlngOrzCd() {
		return blngOrzCd;
	}
	public void setBlngOrzCd(String blngOrzCd) {
		this.blngOrzCd = blngOrzCd;
	}
	public String getHrOsdtCd() {
		return hrOsdtCd;
	}
	public void setHrOsdtCd(String hrOsdtCd) {
		this.hrOsdtCd = hrOsdtCd;
	}
	public String getAprvPcd() {
		return aprvPcd;
	}
	public void setAprvPcd(String aprvPcd) {
		this.aprvPcd = aprvPcd;
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
