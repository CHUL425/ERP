package com.miraeasset.biz.ga.rm.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GARM2010V0Out00VO {
	
    @ApiModelProperty(notes= "정산년월")
    private String exccYm         ;    /* 정산년월 */
	
    @ApiModelProperty(notes= "구분")
    private String colrTcd        ;    /* 컬러구분 */
    
    @ApiModelProperty(notes= "청구매수")
    private String uvol           ;    /* 청구매수 */
    
    @ApiModelProperty(notes= "기본매수")
    private String baseUvol       ;    /* 기본매수 */
    
    @ApiModelProperty(notes= "기본요금")
    private String baseCrga       ;    /* 기본요금 */
    
    @ApiModelProperty(notes= "추가매수")
    private String adBuy          ;    /* 추가매수 */
    
    @ApiModelProperty(notes= "추가단가")
    private String adUpr          ;    /* 추가단가 */
    
    @ApiModelProperty(notes= "추가요금")
    private String adCrga   ;    /* 추가요금 */

	public String getExccYm() {
		return exccYm;
	}

	public void setExccYm(String exccYm) {
		this.exccYm = exccYm;
	}

	public String getColrTcd() {
		return colrTcd;
	}

	public void setColrTcd(String colrTcd) {
		this.colrTcd = colrTcd;
	}

	public String getUvol() {
		return uvol;
	}

	public void setUvol(String uvol) {
		this.uvol = uvol;
	}

	public String getBaseUvol() {
		return baseUvol;
	}

	public void setBaseUvol(String baseUvol) {
		this.baseUvol = baseUvol;
	}

	public String getBaseCrga() {
		return baseCrga;
	}

	public void setBaseCrga(String baseCrga) {
		this.baseCrga = baseCrga;
	}

	public String getAdBuy() {
		return adBuy;
	}

	public void setAdBuy(String adBuy) {
		this.adBuy = adBuy;
	}

	public String getAdUpr() {
		return adUpr;
	}

	public void setAdUpr(String adUpr) {
		this.adUpr = adUpr;
	}

	public String getAdCrga() {
		return adCrga;
	}

	public void setAdCrga(String adCrga) {
		this.adCrga = adCrga;
	}

	@Override
	public String toString() {
		return "GARM2010V0Out00VO [exccYm=" + exccYm + ", colrTcd=" + colrTcd + ", uvol=" + uvol + ", baseUvol="
				+ baseUvol + ", baseCrga=" + baseCrga + ", adBuy=" + adBuy + ", adUpr=" + adUpr + ", adCrga=" + adCrga
				+ "]";
	}
	
}
