/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: SSBS9000V0Out02VO.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 판관비계정과목관리 상세조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SSBS9000V0Out02VO {
	
	
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
    

	@Override
	public String toString() {
		return "SSBS9000V0Out00VO [ acsjCd=" + acsjCd + ", acsjCdNm=" + acsjCdNm + ", ctrnYn="
				+ ctrnYn + ", prjtNm=" + prjtNm + ", levl5AcsjCd=" + levl5AcsjCd + ", levl5AcsjCdNm=" + levl5AcsjCdNm
				+ ", levl4AcsjCd=" + levl4AcsjCd + ", levl4AcsjCdNm=" + levl4AcsjCdNm + "]";
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
    
	
}
