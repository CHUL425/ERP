package com.miraeasset.biz.common.cm.ps.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class CMPS1000V0Out00VO {
	
	@ApiModelProperty(notes= "총건수")
	private BigDecimal alCnt	; 		/* 총건수 */
	
	@ApiModelProperty(notes= "거래처코드")
	private String delpCd		; 		/* 거래처코드 */
	@ApiModelProperty(notes= "거래처명")
	private String delpNm		; 		/* 거래처명 */
	@ApiModelProperty(notes= "사업자등록번호")
	private String blno			;   	/* 사업자등록번호 */
	@ApiModelProperty(notes= "거래처대표자명")
	private String delpRptvNm	; 		/* 거래처대표자명 */
	@ApiModelProperty(notes= "법인등록번호")
	private String cono			; 		/* 법인등록번호 */
	@ApiModelProperty(notes= "거래처구분코드")
	private String delpTcd		; 		/* 거래처구분코드 */
	
	public BigDecimal getAlCnt() {
		return alCnt;
	}
	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}
	public String getDelpCd() {
		return delpCd;
	}
	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}
	public String getDelpNm() {
		return delpNm;
	}
	public void setDelpNm(String delpNm) {
		this.delpNm = delpNm;
	}
	public String getBlno() {
		return blno;
	}
	public void setBlno(String blno) {
		this.blno = blno;
	}
	public String getDelpRptvNm() {
		return delpRptvNm;
	}
	public void setDelpRptvNm(String delpRptvNm) {
		this.delpRptvNm = delpRptvNm;
	}
	public String getCono() {
		return cono;
	}
	public void setCono(String cono) {
		this.cono = cono;
	}
	public String getDelpTcd() {
		return delpTcd;
	}
	public void setDelpTcd(String delpTcd) {
		this.delpTcd = delpTcd;
	}
	
	@Override
	public String toString() {
		return "CMPS1000V0Out00VO [alCnt=" + alCnt + ", delpCd=" + delpCd + ", delpNm=" + delpNm + ", blno=" + blno
				+ ", delpRptvNm=" + delpRptvNm + ", cono=" + cono + ", delpTcd=" + delpTcd + "]";
	}
	
}
