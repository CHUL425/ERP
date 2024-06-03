package com.miraeasset.biz.ss.bs.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class SSBS9000V0Out00VO {
	
	@ApiModelProperty(notes= "총건수")
	private BigDecimal totCnt      	;		/* 총건수 */
	
    @ApiModelProperty(notes= "계정과목코드")
    private String acsjCd			;		/* 계정과목코드 */
    @ApiModelProperty(notes= "계정과목명")
    private String acsjCdNm			;       /* 계정과목명 */
    @ApiModelProperty(notes= "통제여부")
    private String ctrnYn			;       /* 통제여부 */
    @ApiModelProperty(notes= "프로젝트명")
    private String prjtNm			;		/* 프로젝트명 */
    @ApiModelProperty(notes= "5레벨계정과목코드")
    private String levl5AcsjCd		;       /* 5레벨계정과목코드 */
    @ApiModelProperty(notes= "5레벨계정과목명")
    private String levl5AcsjCdNm	;	    /* 5레벨계정과목명 */
    @ApiModelProperty(notes= "4레벨계정과목코드")
    private String levl4AcsjCd		;    	/* 4레벨계정과목코드 */
    @ApiModelProperty(notes= "4레벨계정과목명")
    private String levl4AcsjCdNm	;	    /* 4레벨계정과목명 */
    
	public BigDecimal getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(BigDecimal totCnt) {
		this.totCnt = totCnt;
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
	public String getCtrnYn() {
		return ctrnYn;
	}
	public void setCtrnYn(String ctrnYn) {
		this.ctrnYn = ctrnYn;
	}
	public String getPrjtNm() {
		return prjtNm;
	}
	public void setPrjtNm(String prjtNm) {
		this.prjtNm = prjtNm;
	}
	public String getLevl5AcsjCd() {
		return levl5AcsjCd;
	}
	public void setLevl5AcsjCd(String levl5AcsjCd) {
		this.levl5AcsjCd = levl5AcsjCd;
	}
	public String getLevl5AcsjCdNm() {
		return levl5AcsjCdNm;
	}
	public void setLevl5AcsjCdNm(String levl5AcsjCdNm) {
		this.levl5AcsjCdNm = levl5AcsjCdNm;
	}
	public String getLevl4AcsjCd() {
		return levl4AcsjCd;
	}
	public void setLevl4AcsjCd(String levl4AcsjCd) {
		this.levl4AcsjCd = levl4AcsjCd;
	}
	public String getLevl4AcsjCdNm() {
		return levl4AcsjCdNm;
	}
	public void setLevl4AcsjCdNm(String levl4AcsjCdNm) {
		this.levl4AcsjCdNm = levl4AcsjCdNm;
	}
	
	@Override
	public String toString() {
		return "SSBS9000V0Out00VO [totCnt=" + totCnt + ", acsjCd=" + acsjCd + ", acsjCdNm=" + acsjCdNm + ", ctrnYn="
				+ ctrnYn + ", prjtNm=" + prjtNm + ", levl5AcsjCd=" + levl5AcsjCd + ", levl5AcsjCdNm=" + levl5AcsjCdNm
				+ ", levl4AcsjCd=" + levl4AcsjCd + ", levl4AcsjCdNm=" + levl4AcsjCdNm + "]";
	}
    
}
