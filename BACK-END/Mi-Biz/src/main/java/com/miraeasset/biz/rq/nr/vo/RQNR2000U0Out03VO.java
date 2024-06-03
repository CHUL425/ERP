package com.miraeasset.biz.rq.nr.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.dao.ExcelColumnStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultBodyStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultExcelCellStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultHeaderStyle;

import io.swagger.annotations.ApiModelProperty;

@DefaultHeaderStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "GREY_HEADER"))
@DefaultBodyStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BODY"))
@Component
public class RQNR2000U0Out03VO {

	@ApiModelProperty(notes= "접수번호")
	private String rctNo;
	@ApiModelProperty(notes= "구매신청물품순번")
	private String pchRqsAtclSeq;
	@ApiModelProperty(notes= "물품구분코드")
	private String atclTcd;
	@ApiModelProperty(notes= "물품코드")
	private String atclCd;
	@ApiModelProperty(notes= "사원번호")
	private String epno;
	@ApiModelProperty(notes= "사원명")
	private String epNm;
	@ExcelColumnInfo(notes= "사용자")
	@ApiModelProperty(notes= "사용자")
	private String epNmDl;
	@ExcelColumnInfo(notes= "직책/직급")
	@ApiModelProperty(notes= "직책/직급")
	private String nlJrnkOsdtNm;
	
	@ExcelColumnInfo(notes= "단가")
	@ApiModelProperty(notes= "구매가격")
	private BigDecimal pchPr;
	@ExcelColumnInfo(notes= "수량")
	@ApiModelProperty(notes= "구매수량")
	private BigDecimal pchQ;
	@ExcelColumnInfo(notes= "주문금액")
	@ApiModelProperty(notes= "구매합계")
	private BigDecimal pchSmtlA;
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
	public String getEpNm() {
		return epNm;
	}
	public void setEpNm(String epNm) {
		this.epNm = epNm;
	}
	public String getEpNmDl() {
		return epNmDl;
	}
	public void setEpNmDl(String epNmDl) {
		this.epNmDl = epNmDl;
	}
	public String getNlJrnkOsdtNm() {
		return nlJrnkOsdtNm;
	}
	public void setNlJrnkOsdtNm(String nlJrnkOsdtNm) {
		this.nlJrnkOsdtNm = nlJrnkOsdtNm;
	}
	public BigDecimal getPchPr() {
		return pchPr;
	}
	public void setPchPr(BigDecimal pchPr) {
		this.pchPr = pchPr;
	}
	public BigDecimal getPchQ() {
		return pchQ;
	}
	public void setPchQ(BigDecimal pchQ) {
		this.pchQ = pchQ;
	}
	public BigDecimal getPchSmtlA() {
		return pchSmtlA;
	}
	public void setPchSmtlA(BigDecimal pchSmtlA) {
		this.pchSmtlA = pchSmtlA;
	}
}
