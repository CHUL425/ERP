/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA03N103.java
*	04. 작  성  일  자	: 2024.05.10
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 개인명패 상세 
*	07. 주  요  사  항	: 
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;


@Component
public class GA03N103VO extends BaseVO {
	
	@ApiModelProperty(notes= "접수번호")
	private String rctNo;
	@ApiModelProperty(notes= "구매신청물품순번")
	private String pchRqsAtclSeq;
	@ApiModelProperty(notes= "물품구분코드")
	private String atclTcd;
	@ApiModelProperty(notes= "물품코드")
	private String atclCd;
	@ApiModelProperty(notes= "거래처코드")
	private String delpCd;
	@ApiModelProperty(notes= "사원번호")
	private String epno;
	@ApiModelProperty(notes= "소속조직명(저장)")
	private String nlBlngNm;
	@ApiModelProperty(notes= "소속영문조직명(저장)")
	private String engBlngNm;
	@ApiModelProperty(notes= "국문명")
	private String nlNm;
	@ApiModelProperty(notes= "영문명")
	private String engNm;
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
	
	@ApiModelProperty(notes= "직위직책선택구분코드")
	private String pstOsdtChocTcd;
	@ApiModelProperty(notes= "지점영업직책명")
	private String brBizOsdtNm;
	
	@ApiModelProperty(notes= "자격증1")
	private String lcnsCd1;
	@ApiModelProperty(notes= "자격증2")
	private String lcnsCd2;
	@ApiModelProperty(notes= "자격증3")
	private String lcnsCd3;
	@ApiModelProperty(notes= "자격증4")
	private String lcnsCd4;
	@ApiModelProperty(notes= "자격증5")
	private String lcnsCd5;
	@ApiModelProperty(notes= "자격증6")
	private String lcnsCd6;
	@ApiModelProperty(notes= "자격증7")
	private String lcnsCd7;
	@ApiModelProperty(notes= "자격증8")
	private String lcnsCd8;
	@ApiModelProperty(notes= "자격증9")
	private String lcnsCd9;
	@ApiModelProperty(notes= "자격증10")
	private String lcnsCd10;
	
	@ApiModelProperty(notes= "소속조직명")
	private String orzNm;
	@ApiModelProperty(notes= "소속영문조직명")
	private String engOrzNm;
	
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
	public String getDelpCd() {
		return delpCd;
	}
	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getNlBlngNm() {
		return nlBlngNm;
	}
	public void setNlBlngNm(String nlBlngNm) {
		this.nlBlngNm = nlBlngNm;
	}
	public String getEngBlngNm() {
		return engBlngNm;
	}
	public void setEngBlngNm(String engBlngNm) {
		this.engBlngNm = engBlngNm;
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
	public String getPstOsdtChocTcd() {
		return pstOsdtChocTcd;
	}
	public void setPstOsdtChocTcd(String pstOsdtChocTcd) {
		this.pstOsdtChocTcd = pstOsdtChocTcd;
	}
	public String getBrBizOsdtNm() {
		return brBizOsdtNm;
	}
	public void setBrBizOsdtNm(String brBizOsdtNm) {
		this.brBizOsdtNm = brBizOsdtNm;
	}
	public String getLcnsCd1() {
		return lcnsCd1;
	}
	public void setLcnsCd1(String lcnsCd1) {
		this.lcnsCd1 = lcnsCd1;
	}
	public String getLcnsCd2() {
		return lcnsCd2;
	}
	public void setLcnsCd2(String lcnsCd2) {
		this.lcnsCd2 = lcnsCd2;
	}
	public String getLcnsCd3() {
		return lcnsCd3;
	}
	public void setLcnsCd3(String lcnsCd3) {
		this.lcnsCd3 = lcnsCd3;
	}
	public String getLcnsCd4() {
		return lcnsCd4;
	}
	public void setLcnsCd4(String lcnsCd4) {
		this.lcnsCd4 = lcnsCd4;
	}
	public String getLcnsCd5() {
		return lcnsCd5;
	}
	public void setLcnsCd5(String lcnsCd5) {
		this.lcnsCd5 = lcnsCd5;
	}
	public String getLcnsCd6() {
		return lcnsCd6;
	}
	public void setLcnsCd6(String lcnsCd6) {
		this.lcnsCd6 = lcnsCd6;
	}
	public String getLcnsCd7() {
		return lcnsCd7;
	}
	public void setLcnsCd7(String lcnsCd7) {
		this.lcnsCd7 = lcnsCd7;
	}
	public String getLcnsCd8() {
		return lcnsCd8;
	}
	public void setLcnsCd8(String lcnsCd8) {
		this.lcnsCd8 = lcnsCd8;
	}
	public String getLcnsCd9() {
		return lcnsCd9;
	}
	public void setLcnsCd9(String lcnsCd9) {
		this.lcnsCd9 = lcnsCd9;
	}
	public String getLcnsCd10() {
		return lcnsCd10;
	}
	public void setLcnsCd10(String lcnsCd10) {
		this.lcnsCd10 = lcnsCd10;
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
}
