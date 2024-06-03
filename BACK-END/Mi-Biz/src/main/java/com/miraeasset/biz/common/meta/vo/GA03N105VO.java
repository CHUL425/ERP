/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA03N105.java
*	04. 작  성  일  자	: 2024.05.10
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 명함신청 상세
*	07. 주  요  사  항	: 
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;


@Component
public class GA03N105VO extends BaseVO {
	
	@ApiModelProperty(notes= "접수번호")
	private String rctNo;
	@ApiModelProperty(notes= "구매신청물품순번")
	private String pchRqsAtclSeq;
	@ApiModelProperty(notes= "물품구분코드")
	private String atclTcd;
	@ApiModelProperty(notes= "물품코드")
	private String atclCd;
	@ApiModelProperty(notes= "사번")
	private String epno;
	@ApiModelProperty(notes= "명함유형코드", example="01")
	private String nmcrdPcd;
	@ApiModelProperty(notes= "명함구분코드")
	private String nmcrdTcd;
	@ApiModelProperty(notes= "조직코드(입력안함)")
	private String orzCd;
	@ApiModelProperty(notes= "조직명")
	private String orzNm;
	@ApiModelProperty(notes= "영문조직명")
	private String engOrzNm;
	@ApiModelProperty(notes= "직급코드(입력안함)")
	private String jrnkCd;
	@ApiModelProperty(notes= "국문직급명")
	private String nlJrnkNm;
	@ApiModelProperty(notes= "영문직급명")
	private String engJrnkNm;
	@ApiModelProperty(notes= "직책코드(입력안함)")
	private String osdtCd;
	@ApiModelProperty(notes= "국문직책명")
	private String nlOsdtNm;
	@ApiModelProperty(notes= "영문직책명")
	private String engOsdtNm;
	@ApiModelProperty(notes= "호칭명-명패용")
	private String titlNm;
	@ApiModelProperty(notes= "국문명")
	private String nlNm;
	@ApiModelProperty(notes= "영문명")
	private String engNm;
	@ApiModelProperty(notes= "우편번호")
	private String zpcd;
	@ApiModelProperty(notes= "국문주소")
	private String wkpAdrEcpVl;
	@ApiModelProperty(notes= "영문주소")
	private String engWkpAdrEcpVl;
	@ApiModelProperty(notes= "rtn")
	private String rtn;
	@ApiModelProperty(notes= "mtno")
	private String mtno;
	@ApiModelProperty(notes= "itno")
	private String itno;
	@ApiModelProperty(notes= "hndp_bzpr_tlno")
	private String hndpBzprTlno;
	@ApiModelProperty(notes= "hndp_mtno")
	private String hndpMtno;
	@ApiModelProperty(notes= "hndp_itno")
	private String hndpItno;
	@ApiModelProperty(notes= "Fax")
	private String rvFaxTlno;
	@ApiModelProperty(notes= "E-Mail")
	private String emalAdr;
	@ApiModelProperty(notes= "자격증코드")
	private String lcnsCd;
	@ApiModelProperty(notes= "자격증명")
	private String lcnsNm;
	@ApiModelProperty(notes= "비고내용")
	private String nteCn;
	
	
	@ApiModelProperty(notes= "Tel")
	private String empOfcTlno;
	@ApiModelProperty(notes= "Mobile")
	private String cellNo;
	
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	public String getPchRqsAtclSeq() {
		return pchRqsAtclSeq;
	}
	public void setPchRqsAtclSeq(String pchRqsAtclSeq) {
		this.pchRqsAtclSeq = pchRqsAtclSeq;
	}
	public String getAtclTcd() {
		return atclTcd;
	}
	public void setAtclTcd(String atclTcd) {
		this.atclTcd = atclTcd;
	}
	public String getAtclCd() {
		return atclCd;
	}
	public void setAtclCd(String atclCd) {
		this.atclCd = atclCd;
	}
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getNmcrdPcd() {
		return nmcrdPcd;
	}
	public void setNmcrdPcd(String nmcrdPcd) {
		this.nmcrdPcd = nmcrdPcd;
	}
	public String getNmcrdTcd() {
		return nmcrdTcd;
	}
	public void setNmcrdTcd(String nmcrdTcd) {
		this.nmcrdTcd = nmcrdTcd;
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
	public String getTitlNm() {
		return titlNm;
	}
	public void setTitlNm(String titlNm) {
		this.titlNm = titlNm;
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
	public String getRtn() {
		return rtn;
	}
	public void setRtn(String rtn) {
		this.rtn = rtn;
	}
	public String getMtno() {
		return mtno;
	}
	public void setMtno(String mtno) {
		this.mtno = mtno;
	}
	public String getItno() {
		return itno;
	}
	public void setItno(String itno) {
		this.itno = itno;
	}
	public String getHndpBzprTlno() {
		return hndpBzprTlno;
	}
	public void setHndpBzprTlno(String hndpBzprTlno) {
		this.hndpBzprTlno = hndpBzprTlno;
	}
	public String getHndpMtno() {
		return hndpMtno;
	}
	public void setHndpMtno(String hndpMtno) {
		this.hndpMtno = hndpMtno;
	}
	public String getHndpItno() {
		return hndpItno;
	}
	public void setHndpItno(String hndpItno) {
		this.hndpItno = hndpItno;
	}
	public String getRvFaxTlno() {
		return rvFaxTlno;
	}
	public void setRvFaxTlno(String rvFaxTlno) {
		this.rvFaxTlno = rvFaxTlno;
	}
	public String getEmalAdr() {
		return emalAdr;
	}
	public void setEmalAdr(String emalAdr) {
		this.emalAdr = emalAdr;
	}
	public String getLcnsCd() {
		return lcnsCd;
	}
	public void setLcnsCd(String lcnsCd) {
		this.lcnsCd = lcnsCd;
	}
	public String getLcnsNm() {
		return lcnsNm;
	}
	public void setLcnsNm(String lcnsNm) {
		this.lcnsNm = lcnsNm;
	}
	public String getNteCn() {
		return nteCn;
	}
	public void setNteCn(String nteCn) {
		this.nteCn = nteCn;
	}
	public String getEmpOfcTlno() {
		return empOfcTlno;
	}
	public void setEmpOfcTlno(String empOfcTlno) {
		this.empOfcTlno = empOfcTlno;
	}
	public String getCellNo() {
		return cellNo;
	}
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}

}
