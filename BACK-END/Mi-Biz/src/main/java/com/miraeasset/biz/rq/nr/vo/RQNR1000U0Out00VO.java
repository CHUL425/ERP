package com.miraeasset.biz.rq.nr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQNR1000U0Out00VO {
	
	@ApiModelProperty(notes= "사번")
	private String epno;
	@ApiModelProperty(notes= "국문명")
	private String nlNm;
	@ApiModelProperty(notes= "영문명")
	private String engNm;
	@ApiModelProperty(notes= "명함구분코드")
	private String nmcrdTcd;
	@ApiModelProperty(notes= "명함구분코드명")
	private String nmcrdTcdNm;
	@ApiModelProperty(notes= "직급코드")
	private String jrnkCd;
	@ApiModelProperty(notes= "국문직급명")
	private String nlJrnkNm;
	@ApiModelProperty(notes= "영문직급명")
	private String engJrnkNm;
	@ApiModelProperty(notes= "직책코드")
	private String osdtCd;
	@ApiModelProperty(notes= "국문직책명")
	private String nlOsdtNm;
	@ApiModelProperty(notes= "영문직책명")
	private String engOsdtNm;
	@ApiModelProperty(notes= "조직코드")
	private String orzCd;
	@ApiModelProperty(notes= "조직명")
	private String orzNm;
	@ApiModelProperty(notes= "영문조직명")
	private String engOrzNm;
	@ApiModelProperty(notes= "우편번호")
	private String zpcd;
	@ApiModelProperty(notes= "국문주소")
	private String wkpAdrEcpVl;
	@ApiModelProperty(notes= "영문주소")
	private String engWkpAdrEcpVl;
	@ApiModelProperty(notes= "Tel")
	private String empOfcTlno;
	@ApiModelProperty(notes= "Fax")
	private String rvFaxTlno;
	@ApiModelProperty(notes= "Mobile")
	private String cellNo;
	@ApiModelProperty(notes= "E-Mail")
	private String emalAdr;
	@ApiModelProperty(notes= "WM영업부문 소속여부(Y/N)")
	private String wmYn;
	
	@ApiModelProperty(notes= "국문부문")
	private String fildOrzNm;
	@ApiModelProperty(notes= "영문부문")
	private String engFildOrzNm;
	
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getNlNm() {
		return nlNm;
	}
	public void setNlNm(String nlNm) {
		this.nlNm = nlNm;
	}
	public String getEngNm() {
		return engNm;
	}
	public void setEngNm(String engNm) {
		this.engNm = engNm;
	}
	public String getNmcrdTcd() {
		return nmcrdTcd;
	}
	public void setNmcrdTcd(String nmcrdTcd) {
		this.nmcrdTcd = nmcrdTcd;
	}
	public String getNmcrdTcdNm() {
		return nmcrdTcdNm;
	}
	public void setNmcrdTcdNm(String nmcrdTcdNm) {
		this.nmcrdTcdNm = nmcrdTcdNm;
	}
	public String getJrnkCd() {
		return jrnkCd;
	}
	public void setJrnkCd(String jrnkCd) {
		this.jrnkCd = jrnkCd;
	}
	public String getNlJrnkNm() {
		return nlJrnkNm;
	}
	public void setNlJrnkNm(String nlJrnkNm) {
		this.nlJrnkNm = nlJrnkNm;
	}
	public String getEngJrnkNm() {
		return engJrnkNm;
	}
	public void setEngJrnkNm(String engJrnkNm) {
		this.engJrnkNm = engJrnkNm;
	}
	public String getOsdtCd() {
		return osdtCd;
	}
	public void setOsdtCd(String osdtCd) {
		this.osdtCd = osdtCd;
	}
	public String getNlOsdtNm() {
		return nlOsdtNm;
	}
	public void setNlOsdtNm(String nlOsdtNm) {
		this.nlOsdtNm = nlOsdtNm;
	}
	public String getEngOsdtNm() {
		return engOsdtNm;
	}
	public void setEngOsdtNm(String engOsdtNm) {
		this.engOsdtNm = engOsdtNm;
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
	public String getEngOrzNm() {
		return engOrzNm;
	}
	public void setEngOrzNm(String engOrzNm) {
		this.engOrzNm = engOrzNm;
	}
	public String getZpcd() {
		return zpcd;
	}
	public void setZpcd(String zpcd) {
		this.zpcd = zpcd;
	}
	public String getWkpAdrEcpVl() {
		return wkpAdrEcpVl;
	}
	public void setWkpAdrEcpVl(String wkpAdrEcpVl) {
		this.wkpAdrEcpVl = wkpAdrEcpVl;
	}
	public String getEngWkpAdrEcpVl() {
		return engWkpAdrEcpVl;
	}
	public void setEngWkpAdrEcpVl(String engWkpAdrEcpVl) {
		this.engWkpAdrEcpVl = engWkpAdrEcpVl;
	}
	public String getEmpOfcTlno() {
		return empOfcTlno;
	}
	public void setEmpOfcTlno(String empOfcTlno) {
		this.empOfcTlno = empOfcTlno;
	}
	public String getRvFaxTlno() {
		return rvFaxTlno;
	}
	public void setRvFaxTlno(String rvFaxTlno) {
		this.rvFaxTlno = rvFaxTlno;
	}
	public String getCellNo() {
		return cellNo;
	}
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}
	public String getEmalAdr() {
		return emalAdr;
	}
	public void setEmalAdr(String emalAdr) {
		this.emalAdr = emalAdr;
	}
	public String getWmYn() {
		return wmYn;
	}
	public void setWmYn(String wmYn) {
		this.wmYn = wmYn;
	}
	public String getFildOrzNm() {
		return fildOrzNm;
	}
	public void setFildOrzNm(String fildOrzNm) {
		this.fildOrzNm = fildOrzNm;
	}
	public String getEngFildOrzNm() {
		return engFildOrzNm;
	}
	public void setEngFildOrzNm(String engFildOrzNm) {
		this.engFildOrzNm = engFildOrzNm;
	}
	
}
