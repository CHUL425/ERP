package com.miraeasset.biz.ga.em.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAEM1000U0In00VO {

    @ApiModelProperty(notes= "업무구분코드")
    private String bztpTcd         ; /* 업무구분코드 */
    @ApiModelProperty(notes= "업무구분상세코드")
    private String bztpDlTcd         ; /* 업무구분상세코드 */
    @ApiModelProperty(notes= "업체명")
    private String delpNm         ; /* 업체명 */

    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;      // 페이지사이즈
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;     // 페이지순번
	public String getBztpTcd() {
		return bztpTcd;
	}
	public void setBztpTcd(String bztpTcd) {
		this.bztpTcd = bztpTcd;
	}
	public String getBztpDlTcd() {
		return bztpDlTcd;
	}
	public void setBztpDlTcd(String bztpDlTcd) {
		this.bztpDlTcd = bztpDlTcd;
	}
	public String getDelpNm() {
		return delpNm;
	}
	public void setDelpNm(String delpNm) {
		this.delpNm = delpNm;
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

    
