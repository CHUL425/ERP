package com.miraeasset.biz.common.auth.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class AuthGA09N205In00VO {

    @ApiModelProperty(notes= "사용자그룹코드")
	private String userGrpCd    ; /*사용자그룹코드*/   
    @ApiModelProperty(notes= "화면번호")
	private String scrnNo       ; /*화면번호      */   
    @ApiModelProperty(notes= "사용여부")
	private String useYn        ; /*사용여부      */   
    @ApiModelProperty(notes= "처리가능여부")
	private String prcAblYn     ; /*처리가능여부  */   
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
	public String getScrnNo() {
		return scrnNo;
	}
	public void setScrnNo(String scrnNo) {
		this.scrnNo = scrnNo;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getPrcAblYn() {
		return prcAblYn;
	}
	public void setPrcAblYn(String prcAblYn) {
		this.prcAblYn = prcAblYn;
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
