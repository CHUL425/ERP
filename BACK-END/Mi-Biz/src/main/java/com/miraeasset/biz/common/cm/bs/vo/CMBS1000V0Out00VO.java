package com.miraeasset.biz.common.cm.bs.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class CMBS1000V0Out00VO {
	
	@ApiModelProperty(notes= "총건수")
	private BigDecimal totCnt	; 			 /* 총건수 */
	
	@ApiModelProperty(notes= "계정코드/명")
	private String chkYn		; 			 /* 체크여부 */
	@ApiModelProperty(notes= "계정과목코드")
	private String acsjCd		; 			 /* 계정과목코드 */
	@ApiModelProperty(notes= "계정과목명")
	private String acsjCdNm		;			 /* 계정과목명 */ 		
	@ApiModelProperty(notes= "상위계정과목코드")
	private String hrkAcsjCd 	;			 /* 상위계정과목코드 */ 		
	@ApiModelProperty(notes= "계정과목등급코드")
	private String acsjGcd		;			 /* 계정과목등급코드 */ 		
	@ApiModelProperty(notes= "기표가능여부")
	private String fbltYn		; 			 /* 기표가능여부 */
	@ApiModelProperty(notes= "회계기준코드 ")
	private String actgBasCd	; 			 /* 회계기준코드  */
	
	public BigDecimal getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(BigDecimal totCnt) {
		this.totCnt = totCnt;
	}
	public String getChkYn() {
		return chkYn;
	}
	public void setChkYn(String chkYn) {
		this.chkYn = chkYn;
	}
	public String getAcsjCd() {
		return acsjCd;
	}
	public void setAcsjCd(String acsjCd) {
		this.acsjCd = acsjCd;
	}
	public String getAcsjCdNm() {
		return acsjCdNm;
	}
	public void setAcsjCdNm(String acsjCdNm) {
		this.acsjCdNm = acsjCdNm;
	}
	public String getHrkAcsjCd() {
		return hrkAcsjCd;
	}
	public void setHrkAcsjCd(String hrkAcsjCd) {
		this.hrkAcsjCd = hrkAcsjCd;
	}
	public String getAcsjGcd() {
		return acsjGcd;
	}
	public void setAcsjGcd(String acsjGcd) {
		this.acsjGcd = acsjGcd;
	}
	public String getFbltYn() {
		return fbltYn;
	}
	public void setFbltYn(String fbltYn) {
		this.fbltYn = fbltYn;
	}
	public String getActgBasCd() {
		return actgBasCd;
	}
	public void setActgBasCd(String actgBasCd) {
		this.actgBasCd = actgBasCd;
	}
	
	@Override
	public String toString() {
		return "CMBS1000V0Out00VO [totCnt=" + totCnt + ", chkYn=" + chkYn + ", acsjCd=" + acsjCd + ", acsjCdNm="
				+ acsjCdNm + ", hrkAcsjCd=" + hrkAcsjCd + ", acsjGcd=" + acsjGcd + ", fbltYn=" + fbltYn + ", actgBasCd="
				+ actgBasCd + "]";
	}
    
}
