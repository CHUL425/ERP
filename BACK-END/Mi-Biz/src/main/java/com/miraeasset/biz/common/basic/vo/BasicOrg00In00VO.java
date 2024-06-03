package com.miraeasset.biz.common.basic.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class BasicOrg00In00VO {

    @ApiModelProperty(notes= "본지점구분코드")
    private String hobrTcd     ;  /* 본지점구분코드 */            
    @ApiModelProperty(notes= "조직레벨값")
    private String orzLevlVl   ;  /* 조직레벨값 */
    @ApiModelProperty(notes= "조직명")
    private String orzNm       ;  /* 조직명 */
    @ApiModelProperty(notes= "조직코드")
    private String orzCd       ;  /* 조직코드 */
    @ApiModelProperty(notes= "조직사용여부")
    private String orzUseYn    ;  /* 조직사용여부 */
    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;

	public String getHobrTcd() {
		return hobrTcd;
	}
	public void setHobrTcd(String hobrTcd) {
		this.hobrTcd = hobrTcd;
	}
	public String getOrzLevlVl() {
		return orzLevlVl;
	}
	public void setOrzLevlVl(String orzLevlVl) {
		this.orzLevlVl = orzLevlVl;
	}
	public String getOrzNm() {
		return orzNm;
	}
	public void setOrzNm(String orzNm) {
		this.orzNm = orzNm;
	}
	public String getOrzCd() {
		return orzCd;
	}
	public void setOrzCd(String orzCd) {
		this.orzCd = orzCd;
	}
	public String getOrzUseYn() {
		return orzUseYn;
	}
	public void setOrzUseYn(String orzUseYn) {
		this.orzUseYn = orzUseYn;
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
