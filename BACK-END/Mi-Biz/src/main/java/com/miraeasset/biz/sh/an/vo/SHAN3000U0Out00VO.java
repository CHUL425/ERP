/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SH
*	03. 파    일   명	: SHAN3000U0Out00VO.java
*	04. 작  성  일  자	: 2024.02.07
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 안전보건공지 확인 전체조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.sh.an.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SHAN3000U0Out00VO {
	
	@ApiModelProperty(notes= "작성일자")
	private String madeDt; 
	@ApiModelProperty(notes= "일련번호")
	private BigDecimal srno; 
	@ApiModelProperty(notes= "공지구분코드")
	private String cmklTcd; 
	@ApiModelProperty(notes= "제목명")
	private String ttlNm;
	
	@ApiModelProperty(notes= "게시시작일자")
	private String pstupStrtDt; 
	@ApiModelProperty(notes= "게시종료일자")
	private String pstupEndDt;
	
	@ApiModelProperty(notes= "확인여부")
	private String cfmtYn;
	@ApiModelProperty(notes= "확인일자")
	private String cfmtDt;
	
	public BigDecimal getSrno() {
		return srno;
	}
	public void setSrno(BigDecimal srno) {
		this.srno = srno;
	}
	public String getTtlNm() {
		return ttlNm;
	}
	public void setTtlNm(String ttlNm) {
		this.ttlNm = ttlNm;
	}
	public String getPstupStrtDt() {
		return pstupStrtDt;
	}
	public void setPstupStrtDt(String pstupStrtDt) {
		this.pstupStrtDt = pstupStrtDt;
	}
	public String getPstupEndDt() {
		return pstupEndDt;
	}
	public void setPstupEndDt(String pstupEndDt) {
		this.pstupEndDt = pstupEndDt;
	}
	public String getCfmtYn() {
		return cfmtYn;
	}
	public void setCfmtYn(String cfmtYn) {
		this.cfmtYn = cfmtYn;
	}
	public String getCfmtDt() {
		return cfmtDt;
	}
	public void setCfmtDt(String cfmtDt) {
		this.cfmtDt = cfmtDt;
	}
	public String getMadeDt() {
		return madeDt;
	}
	public void setMadeDt(String madeDt) {
		this.madeDt = madeDt;
	}
	public String getCmklTcd() {
		return cmklTcd;
	}
	public void setCmklTcd(String cmklTcd) {
		this.cmklTcd = cmklTcd;
	}
	
}
