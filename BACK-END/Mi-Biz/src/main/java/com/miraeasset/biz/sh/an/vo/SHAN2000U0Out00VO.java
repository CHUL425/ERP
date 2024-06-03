/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SH
*	03. 파    일   명	: SHAN2000U0Out00VO.java
*	04. 작  성  일  자	: 2024.02.07
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 안전보건공지 현황 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.sh.an.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SHAN2000U0Out00VO {
	
	@ApiModelProperty(notes= "작성일자")
	private String madeDt; 
	@ApiModelProperty(notes= "일련번호")
	private BigDecimal srno; 
	@ApiModelProperty(notes= "공지구분코드")
	private String cmklTcd; 
	@ApiModelProperty(notes= "제목명")
	private String ttlNm;
	
	@ApiModelProperty(notes= "소속조직코드")
	private String orzCd;
	@ApiModelProperty(notes= "소속조직명")
	private String orzNm;
	
	@ApiModelProperty(notes= "직책코드")
	private String hrOsdtCd;
	@ApiModelProperty(notes= "직책명")
	private String hrOsdtNm;
	
	@ApiModelProperty(notes= "확인자 사번")
	private String cfmtEpno;
	@ApiModelProperty(notes= "확인자")
	private String cfmtEpnm;
	@ApiModelProperty(notes= "확인일")
	private String cfmtDt;
	@ApiModelProperty(notes= "확인여부 확인:Y, 기타:공백")
	private String cfmtYn;
	
	@ApiModelProperty(notes= "총건수-결과값세팅용")
	private long totCnt; 
	
	public String getMadeDt() {
		return madeDt;
	}
	public void setMadeDt(String madeDt) {
		this.madeDt = madeDt;
	}
	public BigDecimal getSrno() {
		return srno;
	}
	public void setSrno(BigDecimal srno) {
		this.srno = srno;
	}
	public String getCmklTcd() {
		return cmklTcd;
	}
	public void setCmklTcd(String cmklTcd) {
		this.cmklTcd = cmklTcd;
	}
	public String getTtlNm() {
		return ttlNm;
	}
	public void setTtlNm(String ttlNm) {
		this.ttlNm = ttlNm;
	}
	public String getOrzCd() {
		return orzCd;
	}
	public void setOrzCd(String orzCd) {
		this.orzCd = orzCd;
	}
	public String getOrzNm() {
		return orzNm;
	}
	public void setOrzNm(String orzNm) {
		this.orzNm = orzNm;
	}
	public String getCfmtEpno() {
		return cfmtEpno;
	}
	public void setCfmtEpno(String cfmtEpno) {
		this.cfmtEpno = cfmtEpno;
	}
	public String getCfmtYn() {
		return cfmtYn;
	}
	public void setCfmtYn(String cfmtYn) {
		this.cfmtYn = cfmtYn;
	}
	public String getHrOsdtCd() {
		return hrOsdtCd;
	}
	public void setHrOsdtCd(String hrOsdtCd) {
		this.hrOsdtCd = hrOsdtCd;
	}
	public String getHrOsdtNm() {
		return hrOsdtNm;
	}
	public void setHrOsdtNm(String hrOsdtNm) {
		this.hrOsdtNm = hrOsdtNm;
	}
	public String getCfmtEpnm() {
		return cfmtEpnm;
	}
	public void setCfmtEpnm(String cfmtEpnm) {
		this.cfmtEpnm = cfmtEpnm;
	}
	public String getCfmtDt() {
		return cfmtDt;
	}
	public void setCfmtDt(String cfmtDt) {
		this.cfmtDt = cfmtDt;
	}
	public long getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(long totCnt) {
		this.totCnt = totCnt;
	}
	
}
