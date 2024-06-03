package com.miraeasset.biz.common.code.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GaCode01In00VO {

    @ApiModelProperty(notes= "코드종류번호")
	private String cdKndNo          ;    /* 코드종류번호 */                    

    @ApiModelProperty(notes= "공통코드값")
	private String cmnCdVl        ;    /* 공통코드값 */    
    
    @ApiModelProperty(notes= "신규번호")
	private String newNo        ;    /* 신규번호-업무별 채번 */       
    
    @ApiModelProperty(notes= "업무관리코드값")
	private String bzMtCdVl      ;    /* 업무관리코드값 */        
    
    @ApiModelProperty(notes= "사용자정의값1")
    private String userDefVl1	; /* 사용자정의값1 */
    @ApiModelProperty(notes= "사용자정의값2")
    private String userDefVl2	; /* 사용자정의값2 */
    
	@ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;

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
	public String getCdKndNo() {
		return cdKndNo;
	}
	public void setCdKndNo(String cdKndNo) {
		this.cdKndNo = cdKndNo;
	}
	public String getCmnCdVl() {
		return cmnCdVl;
	}
	public void setCmnCdVl(String cmnCdVl) {
		this.cmnCdVl = cmnCdVl;
	}
	public String getNewNo() {
		return newNo;
	}
	public void setNewNo(String newNo) {
		this.newNo = newNo;
	}
	public String getBzMtCdVl() {
		return bzMtCdVl;
	}
	public void setBzMtCdVl(String bzMtCdVl) {
		this.bzMtCdVl = bzMtCdVl;
	}
	public String getUserDefVl1() {
		return userDefVl1;
	}
	public void setUserDefVl1(String userDefVl1) {
		this.userDefVl1 = userDefVl1;
	}
	public String getUserDefVl2() {
		return userDefVl2;
	}
	public void setUserDefVl2(String userDefVl2) {
		this.userDefVl2 = userDefVl2;
	}
}
