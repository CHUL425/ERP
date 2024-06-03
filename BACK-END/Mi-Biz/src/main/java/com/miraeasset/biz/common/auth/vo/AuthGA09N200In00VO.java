package com.miraeasset.biz.common.auth.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class AuthGA09N200In00VO {

    @ApiModelProperty(notes= "사용자그룹코드")
    private String userGrpCd    ; /* 사용자그룹코드*/
    @ApiModelProperty(notes= "그룹명" )
    private String grpNm        ; /* 그룹명        */
    @ApiModelProperty(notes= "관리그룹여부" )
    private String mtGrpYn      ; /* 관리그룹여부  */
    
    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;    

	public String getUserGrpCd() {
		return userGrpCd;
	}
	public void setUserGrpCd(String userGrpCd) {
		this.userGrpCd = userGrpCd;
	}
	public String getGrpNm() {
		return grpNm;
	}
	public void setGrpNm(String grpNm) {
		this.grpNm = grpNm;
	}
	public String getMtGrpYn() {
		return mtGrpYn;
	}
	public void setMtGrpYn(String mtGrpYn) {
		this.mtGrpYn = mtGrpYn;
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
