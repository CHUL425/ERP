package com.miraeasset.biz.budget.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class BGT5350In00VO {

    @ApiModelProperty(notes= "회기", required = true, example ="49")
    private String sesnTcd     ;   /* 회기구분코드 */
    @ApiModelProperty(notes= "예산조직코드")
    private String bdgtOrzCd   ;   /* 예산조직코드 */
    @ApiModelProperty(notes= "시작일자")
    private String fromDt      ;   /* 시작일자 */
    @ApiModelProperty(notes= "종료일자")
    private String toDt        ;   /* 종료일자 */
    @ApiModelProperty(notes= "예산계정과목코드")
    private String bdgtAcsjCd  ;   /* 예산계정과목코드 */
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex   ;   /* 페이지순번 */
    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize    ;   /* 페이지사이즈 */
    @ApiModelProperty(notes= "일자구분코드")
    private String dtTcd       ;   /* 일자구분코드*/
    @ApiModelProperty(notes= "사용승인구분코드")
    private String useApvTcd   ;   /* 사용승인구분코드 */
    

    @Override
    public String toString() {
        return "BGT5350In00VO{" +
                "sesnTcd     ='" + sesnTcd    + "'" +
                "bdgtOrzCd     ='" + bdgtOrzCd    + "'" +
                "fromDt     ='" + fromDt    + "'" +
                "toDt     ='" + toDt    + "'" +
                "bdgtAcsjCd     ='" + bdgtAcsjCd    + "'" +
                "dtTcd     ='" + dtTcd    + "'" +
                "useApvTcd     ='" + useApvTcd    + "'" +
                "pageIndex     ='" + pageIndex    + "'" +
                "pageSize     ='" + pageSize    + "'" +
                '}';
    }
    
	public String getSesnTcd() {
		return sesnTcd;
	}
	public void setSesnTcd(String sesnTcd) {
		this.sesnTcd = sesnTcd;
	}
	public String getBdgtOrzCd() {
		return bdgtOrzCd;
	}
	public void setBdgtOrzCd(String bdgtOrzCd) {
		this.bdgtOrzCd = bdgtOrzCd;
	}
	public String getFromDt() {
		return fromDt;
	}
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	public String getToDt() {
		return toDt;
	}
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	public String getBdgtAcsjCd() {
		return bdgtAcsjCd;
	}
	public void setBdgtAcsjCd(String bdgtAcsjCd) {
		this.bdgtAcsjCd = bdgtAcsjCd;
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
	public String getDtTcd() {
		return dtTcd;
	}
	public void setDtTcd(String dtTcd) {
		this.dtTcd = dtTcd;
	}
	public String getUseApvTcd() {
		return useApvTcd;
	}
	public void setUseApvTcd(String useApvTcd) {
		this.useApvTcd = useApvTcd;
	}


}
