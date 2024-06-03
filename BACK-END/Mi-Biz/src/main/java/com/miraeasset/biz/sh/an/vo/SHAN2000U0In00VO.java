/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SH
*	03. 파    일   명	: SHAN2000U0In00VO.java
*	04. 작  성  일  자	: 2024.02.07
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 안전보건공지 현황 조회 In
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.sh.an.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SHAN2000U0In00VO {
	
	@ApiModelProperty(notes= "공지구분코드", example="03")
	private String cmklTcd; 
	@ApiModelProperty(notes= "제목명")
	private String ttlNm            ;
	@ApiModelProperty(notes= "확인자 소속조직코드")
	private String cfmtEpBlngOrzCd;
	@ApiModelProperty(notes= "확인자 사번")
	private String cfmtEpno;
	@ApiModelProperty(notes= "확인여부 확인:1, 미확인:0, 전체:공백")
	private String cfmtYn;

    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageNum;
    
	@ApiModelProperty(notes= "로그인정보-사원번호")
	private String epno;
	@ApiModelProperty(notes= "로그인정보-소속조직코드")
	private String blngOrzCd;
	
	@ApiModelProperty(notes= "총건수-결과값세팅용")
	private long totCnt; 
	
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
	public String getBlngOrzCd() {
		return blngOrzCd;
	}
	public void setBlngOrzCd(String blngOrzCd) {
		this.blngOrzCd = blngOrzCd;
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
	public BigDecimal getPageSize() {
		return pageSize;
	}
	public void setPageSize(BigDecimal pageSize) {
		this.pageSize = pageSize;
	}
	public BigDecimal getPageNum() {
		return pageNum;
	}
	public void setPageNum(BigDecimal pageNum) {
		this.pageNum = pageNum;
	}
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getCfmtEpBlngOrzCd() {
		return cfmtEpBlngOrzCd;
	}
	public void setCfmtEpBlngOrzCd(String cfmtEpBlngOrzCd) {
		this.cfmtEpBlngOrzCd = cfmtEpBlngOrzCd;
	}
	public long getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(long totCnt) {
		this.totCnt = totCnt;
	}
}
