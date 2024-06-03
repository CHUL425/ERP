package com.miraeasset.biz.ga.vm.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class GAVM1000U0In01VO {

	@ApiModelProperty(notes= "업체명")
    private String entpNm;            // 업체명
    
    @ApiModelProperty(notes= "이용자명")
    private String userNm;            // 이용자명
    
    @ApiModelProperty(notes= "조직명")
    private String orzNm;             // 조직코드, 조직명
    
    @ApiModelProperty(notes = "차종구분")
    private String vhcKndNm;          // 차종구분코드
    
    @ApiModelProperty(notes = "차량번호")
    private String vhcNo;             // 차량번호
    
    @ApiModelProperty(notes = "만기조회시작일자")
    private String qryStrtDt;         // 조회시작일자
    @ApiModelProperty(notes = "만기조회종료일자")
    private String qryEndDt;          // 조회종료일자
	public String getEntpNm() {
		return entpNm;
	}
	public void setEntpNm(String entpNm) {
		this.entpNm = entpNm;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getOrzNm() {
		return orzNm;
	}
	public void setOrzNm(String orzNm) {
		this.orzNm = orzNm;
	}
	public String getVhcKndNm() {
		return vhcKndNm;
	}
	public void setVhcKndNm(String vhcKndNm) {
		this.vhcKndNm = vhcKndNm;
	}
	public String getVhcNo() {
		return vhcNo;
	}
	public void setVhcNo(String vhcNo) {
		this.vhcNo = vhcNo;
	}
	public String getQryStrtDt() {
		return qryStrtDt;
	}
	public void setQryStrtDt(String qryStrtDt) {
		this.qryStrtDt = qryStrtDt;
	}
	public String getQryEndDt() {
		return qryEndDt;
	}
	public void setQryEndDt(String qryEndDt) {
		this.qryEndDt = qryEndDt;
	}
	
}
