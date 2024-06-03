package com.miraeasset.biz.rent.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RENT02Out00VO {
	
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ;    /* 전체건수 */
	
	@ApiModelProperty(notes= "장비구분코드")
    private String eqmtTcd        ;    /* 장비구분코드 */
    @ApiModelProperty(notes= "장비구분명")
    private String eqmtTcdNm      ;    /* 장비구분명 */
    @ApiModelProperty(notes= "사용조직코드")
    private String useOrzCd       ;    /* 사용조직코드 */
    @ApiModelProperty(notes= "조직명")
    private String OrzNm          ;    /* 조직명 */
    @ApiModelProperty(notes= "임대계약번호")
	private String rentCntcNo     ;    /* 임대계약번호 */
    @ApiModelProperty(notes= "제품명")
    private String gdsNm          ;    /* 제품명 */
    @ApiModelProperty(notes= "1월")
	private String val01       ;    /* 1월 */
    @ApiModelProperty(notes= "2월")
    private String val02       ;    /* 2월 */
    @ApiModelProperty(notes= "3월")
    private String val03       ;    /* 3월 */
    @ApiModelProperty(notes= "4월")
    private String val04       ;    /* 4월 */
    @ApiModelProperty(notes= "5월")
    private String val05       ;    /* 5월 */
    @ApiModelProperty(notes= "6월")
    private String val06       ;    /* 6월 */
    @ApiModelProperty(notes= "7월")
    private String val07       ;    /* 7월 */
    @ApiModelProperty(notes= "8월")
    private String val08       ;    /* 8월 */
    @ApiModelProperty(notes= "9월")
    private String val09       ;    /* 9월 */
    @ApiModelProperty(notes= "10월")
    private String val10       ;    /* 10월 */
    @ApiModelProperty(notes= "11월")
    private String val11       ;    /* 11월 */
    @ApiModelProperty(notes= "12월")
    private String val12       ;    /* 12월 */
    
	public BigDecimal getAlCnt() {
		return alCnt;
	}
	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}
	public String getEqmtTcd() {
		return eqmtTcd;
	}
	public void setEqmtTcd(String eqmtTcd) {
		this.eqmtTcd = eqmtTcd;
	}
	public String getEqmtTcdNm() {
		return eqmtTcdNm;
	}
	public void setEqmtTcdNm(String eqmtTcdNm) {
		this.eqmtTcdNm = eqmtTcdNm;
	}
	public String getUseOrzCd() {
		return useOrzCd;
	}
	public void setUseOrzCd(String useOrzCd) {
		this.useOrzCd = useOrzCd;
	}
	public String getOrzNm() {
		return OrzNm;
	}
	public void setOrzNm(String orzNm) {
		OrzNm = orzNm;
	}
	public String getRentCntcNo() {
		return rentCntcNo;
	}
	public void setRentCntcNo(String rentCntcNo) {
		this.rentCntcNo = rentCntcNo;
	}
	public String getGdsNm() {
		return gdsNm;
	}
	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}
	public String getVal01() {
		return val01;
	}
	public void setVal01(String val01) {
		this.val01 = val01;
	}
	public String getVal02() {
		return val02;
	}
	public void setVal02(String val02) {
		this.val02 = val02;
	}
	public String getVal03() {
		return val03;
	}
	public void setVal03(String val03) {
		this.val03 = val03;
	}
	public String getVal04() {
		return val04;
	}
	public void setVal04(String val04) {
		this.val04 = val04;
	}
	public String getVal05() {
		return val05;
	}
	public void setVal05(String val05) {
		this.val05 = val05;
	}
	public String getVal06() {
		return val06;
	}
	public void setVal06(String val06) {
		this.val06 = val06;
	}
	public String getVal07() {
		return val07;
	}
	public void setVal07(String val07) {
		this.val07 = val07;
	}
	public String getVal08() {
		return val08;
	}
	public void setVal08(String val08) {
		this.val08 = val08;
	}
	public String getVal09() {
		return val09;
	}
	public void setVal09(String val09) {
		this.val09 = val09;
	}
	public String getVal10() {
		return val10;
	}
	public void setVal10(String val10) {
		this.val10 = val10;
	}
	public String getVal11() {
		return val11;
	}
	public void setVal11(String val11) {
		this.val11 = val11;
	}
	public String getVal12() {
		return val12;
	}
	public void setVal12(String val12) {
		this.val12 = val12;
	}
	
	@Override
	public String toString() {
		return "RENT02Out00VO [alCnt=" + alCnt + ", eqmtTcd=" + eqmtTcd + ", eqmtTcdNm=" + eqmtTcdNm + ", useOrzCd="
				+ useOrzCd + ", OrzNm=" + OrzNm + ", rentCntcNo=" + rentCntcNo + ", gdsNm=" + gdsNm + ", val01=" + val01
				+ ", val02=" + val02 + ", val03=" + val03 + ", val04=" + val04 + ", val05=" + val05 + ", val06=" + val06
				+ ", val07=" + val07 + ", val08=" + val08 + ", val09=" + val09 + ", val10=" + val10 + ", val11=" + val11
				+ ", val12=" + val12 + "]";
	}
    
}
