package com.miraeasset.biz.common.auth.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class AuthGA09N201In00VO {

    @ApiModelProperty(notes= "사원번호")
    private String epno        ;  /*사원번호      */
    @ApiModelProperty(notes= "사용자그룹코드")
    private String userGrpCd   ;  /*사용자그룹코드*/

    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getUserGrpCd() {
		return userGrpCd;
	}
	public void setUserGrpCd(String userGrpCd) {
		this.userGrpCd = userGrpCd;
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
