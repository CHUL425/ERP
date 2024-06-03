package com.miraeasset.biz.rq.am.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQAM2000V0Out01VO {

	@ApiModelProperty(notes= "결재정보")
	private String aprvInfo    ; /*결재정보*/       
	
	@ApiModelProperty(notes= "승인반려구분코드 1/3:승인 2:반려")
	private String aprvRtrnTcd ; /*승인반려구분코드*/         
	
	@ApiModelProperty(notes= "결재사원번호")
	private String aprvEpno    ; /*결재사원번호*/
	
	@ApiModelProperty(notes= "결재사원명")
	private String aprvEpNm    ; /*결재사원명*/     

	@ApiModelProperty(notes= "직위명")
	private String hrPstNm     ; /*직위명*/         
	
	@ApiModelProperty(notes= "결재유형코드")
	private String dcfcPcd     ; /*결재유형코드*/   
	
	@ApiModelProperty(notes= "결재유영코드명")
	private String dcfcPcdNm   ; /*결재유영코드명*/
	
	@ApiModelProperty(notes= "결재조직코드")
	private String aprvOrzCd   ; /*결재조직코드*/
	
	@ApiModelProperty(notes= "결재조직명")
	private String aprvOrzNm   ; /*결재조직명*/
	
	@ApiModelProperty(notes= "결재일자")
	private String aprvDt      ; /*결재일자*/       
	
	@ApiModelProperty(notes= "결재상신관리번호")
	private String aprvWrrptMtNo      ; /*결재상신관리번호 */
	@ApiModelProperty(notes= "결재상신조직코드")
	private String aprvWrrptOrzCd   ; /*결재상신조직코드*/
	@ApiModelProperty(notes= "결재순위")
	private String aprvRnk          ; /*결재순위*/
	@ApiModelProperty(notes= "결재상세순위")
	private String aprvDlRnk        ; /*결재상세순위*/
	
	@ApiModelProperty(notes = "승인사유")
	private String aprvRsnCn		; /* 승인사유 */

	@ApiModelProperty(notes = "대결여부")
	private String sbapYn;
	
	public String getAprvInfo() {
		return aprvInfo;
	}
	public void setAprvInfo(String aprvInfo) {
		this.aprvInfo = aprvInfo;
	}
	public String getAprvEpno() {
		return aprvEpno;
	}
	public void setAprvEpno(String aprvEpno) {
		this.aprvEpno = aprvEpno;
	}
	public String getAprvEpNm() {
		return aprvEpNm;
	}
	public void setAprvEpNm(String aprvEpNm) {
		this.aprvEpNm = aprvEpNm;
	}
	public String getHrPstNm() {
		return hrPstNm;
	}
	public void setHrPstNm(String hrPstNm) {
		this.hrPstNm = hrPstNm;
	}
	public String getDcfcPcd() {
		return dcfcPcd;
	}
	public void setDcfcPcd(String dcfcPcd) {
		this.dcfcPcd = dcfcPcd;
	}
	public String getDcfcPcdNm() {
		return dcfcPcdNm;
	}
	public void setDcfcPcdNm(String dcfcPcdNm) {
		this.dcfcPcdNm = dcfcPcdNm;
	}
	public String getAprvOrzCd() {
		return aprvOrzCd;
	}
	public void setAprvOrzCd(String aprvOrzCd) {
		this.aprvOrzCd = aprvOrzCd;
	}
	public String getAprvOrzNm() {
		return aprvOrzNm;
	}
	public void setAprvOrzNm(String aprvOrzNm) {
		this.aprvOrzNm = aprvOrzNm;
	}
	public String getAprvDt() {
		return aprvDt;
	}
	public void setAprvDt(String aprvDt) {
		this.aprvDt = aprvDt;
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
	public String getAprvRnk() {
		return aprvRnk;
	}
	public void setAprvRnk(String aprvRnk) {
		this.aprvRnk = aprvRnk;
	}
	public String getAprvDlRnk() {
		return aprvDlRnk;
	}
	public void setAprvDlRnk(String aprvDlRnk) {
		this.aprvDlRnk = aprvDlRnk;
	}
	public String getAprvRtrnTcd() {
		return aprvRtrnTcd;
	}
	public void setAprvRtrnTcd(String aprvRtrnTcd) {
		this.aprvRtrnTcd = aprvRtrnTcd;
	}
	public String getAprvRsnCn() {
		return aprvRsnCn;
	}
	public void setAprvRsnCn(String aprvRsnCn) {
		this.aprvRsnCn = aprvRsnCn;
	}

	public String getSbapYn() {
		return sbapYn;
	}

	public void setSbapYn(String sbapYn) {
		this.sbapYn = sbapYn;
	}
}
