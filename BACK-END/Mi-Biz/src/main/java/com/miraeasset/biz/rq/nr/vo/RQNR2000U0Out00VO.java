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
public class RQNR2000U0Out00VO {
	
	@ExcelColumnInfo(notes= "신청번호")
	@ApiModelProperty(notes= "신청번호")
	private String rctNo                ; 
	@ApiModelProperty(notes= "통합신청구분코드")
	private String unifRqsTcd           ; /*통합신청구분코드*/
	@ApiModelProperty(notes= "통합신청구분명")
	private String unifRqsTcdNm         ; /*통합신청구분명*/
	
	@ExcelColumnInfo(notes= "신청물품")
	@ApiModelProperty(notes= "신청물품/명함물품")
	private String atclNm           ;
	@ExcelColumnInfo(notes= "수량")
	@ApiModelProperty(notes= "수량")
	private BigDecimal pchQ      ;
	@ExcelColumnInfo(notes= "주문금액")
	@ApiModelProperty(notes= "주문금액")
	private BigDecimal pchSmtlA      ;
	
	@ExcelColumnInfo(notes= "신청조직코드")
	@ApiModelProperty(notes= "신청조직코드")
	private String rqsOrzCd             ; /*신청조직코드*/
	@ExcelColumnInfo(notes= "신청조직명")
	@ApiModelProperty(notes= "신청조직명")
	private String rqsOrzNm             ; /*신청조직명*/
	@ExcelColumnInfo(notes= "신청사원번호")
	@ApiModelProperty(notes= "신청사원번호")
	private String rqsEpno              ; /*신청사원번호*/ 
	@ExcelColumnInfo(notes= "신청사원명")
	@ApiModelProperty(notes= "신청사원명")
	private String rqsEpNm              ; /*신청사원명*/
	@ExcelColumnInfo(notes= "신청일자")
	@ApiModelProperty(notes= "신청일자")
	private String rqsDt                ; /*신청일자*/ 
	@ApiModelProperty(notes= "결재상신관리번호")
	private String aprvWrrptMtNo        ; /*결재상신관리번호*/
	@ApiModelProperty(notes= "결재상신조직코드")
	private String aprvWrrptOrzCd		; /*결재상신조직코드*/ 
	@ExcelColumnInfo(notes= "신청상태코드")
	@ApiModelProperty(notes= "신청상태코드")
	private String rqsScd               ; /*신청상태코드*/ 
	@ExcelColumnInfo(notes= "신청상태코드명")
	@ApiModelProperty(notes= "신청상태코드명")
	private String rqsScdNm             ; /*신청상태코드명*/
	
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	public String getUnifRqsTcd() {
		return unifRqsTcd;
	}
	public void setUnifRqsTcd(String unifRqsTcd) {
		this.unifRqsTcd = unifRqsTcd;
	}
	public String getUnifRqsTcdNm() {
		return unifRqsTcdNm;
	}
	public void setUnifRqsTcdNm(String unifRqsTcdNm) {
		this.unifRqsTcdNm = unifRqsTcdNm;
	}
	public String getAtclNm() {
		return atclNm;
	}
	public void setAtclNm(String atclNm) {
		this.atclNm = atclNm;
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
	public String getRqsOrzCd() {
		return rqsOrzCd;
	}
	public void setRqsOrzCd(String rqsOrzCd) {
		this.rqsOrzCd = rqsOrzCd;
	}
	public String getRqsOrzNm() {
		return rqsOrzNm;
	}
	public void setRqsOrzNm(String rqsOrzNm) {
		this.rqsOrzNm = rqsOrzNm;
	}
	public String getRqsEpno() {
		return rqsEpno;
	}
	public void setRqsEpno(String rqsEpno) {
		this.rqsEpno = rqsEpno;
	}
	public String getRqsEpNm() {
		return rqsEpNm;
	}
	public void setRqsEpNm(String rqsEpNm) {
		this.rqsEpNm = rqsEpNm;
	}
	public String getRqsDt() {
		return rqsDt;
	}
	public void setRqsDt(String rqsDt) {
		this.rqsDt = rqsDt;
	}
	public String getAprvWrrptMtNo() {
		return aprvWrrptMtNo;
	}
	public void setAprvWrrptMtNo(String aprvWrrptMtNo) {
		this.aprvWrrptMtNo = aprvWrrptMtNo;
	}
	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}
	public void setAprvWrrptOrzCd(String aprvWrrptOrzCd) {
		this.aprvWrrptOrzCd = aprvWrrptOrzCd;
	}
	public String getRqsScd() {
		return rqsScd;
	}
	public void setRqsScd(String rqsScd) {
		this.rqsScd = rqsScd;
	}
	public String getRqsScdNm() {
		return rqsScdNm;
	}
	public void setRqsScdNm(String rqsScdNm) {
		this.rqsScdNm = rqsScdNm;
	}
}
