package com.miraeasset.biz.in.in.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ININ2000V0VO2 {
	
	/* INPUT */
	@JsonIgnore
	@ApiModelProperty(notes = "사원번호", hidden = true)
    private String epno			; /* 로그인 사원번호 */
	
	@JsonIgnore
	@ApiModelProperty(notes = "로그인 사원 직책", hidden = true)
	private String hrOsdtCd		; /* 로그인 사원 직책 */
	
	@JsonIgnore
	@ApiModelProperty(notes = "로그인 사원 조직", hidden = true)
	private String blngOrzCd	; /* 로그인 사원 조직 */
	
	@ApiModelProperty(notes = "업무구분", example = "1.신청현황, 2.승인현황, 3.사전참조")
	private String bzTp			;	/* 업무 구분 */
	
	@ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize	;	// 페이지사이즈
	
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;	// 페이지순번
	
	/* OUTPUT */
	@ApiModelProperty(notes= "진행상태")
	private String rqsScdNm		; /* 진행상태 */
	@ApiModelProperty(notes= "신청서")
	private String unifRqsPcdNm	; /* 신청서 */
	@ApiModelProperty(notes= "신청명")
	private String rqsTtlNm		; /* 신청명 */
	@ApiModelProperty(notes= "승인자 OR 신청자")
	private String aprvEpnm		; /* 승인자 OR 신청자 */
	@ApiModelProperty(notes= "신청일자")
	private String rqsDt		; /* 신청일자 */
	@ApiModelProperty(notes= "승인일자")
	private String aprvDt		; /* 승인일자 */
	
	/* 2023.10.31 요건 변경 */
    @ApiModelProperty(notes= "접수번호")
    private String rctNo			; /*접수번호*/
	@ApiModelProperty(notes= "결재상신관리번호")
    private String aprvWrrptMtNo	; /*결재상신관리번호  */
	@ApiModelProperty(notes= "결재상신조직코드")
    private String aprvWrrptOrzCd	; /*결재상신조직코드  */
	
	/* 2023.11.08 요건 변경 */
	@ApiModelProperty(notes= "결재순위")
	private String aprvRnk			; /*결재순위  */
	@ApiModelProperty(notes= "결재상세순위")
	private String aprvDlRnk		; /*결재상세순위  */

	/* 2023.11.14 요건 변경 */
	@ApiModelProperty(notes= "결재유형코드")
	private String aprvPcd 			; /*결재유형코드  */
	
	@ApiModelProperty(notes = "대결여부")
	private String sbapYn;
	
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getHrOsdtCd() {
		return hrOsdtCd;
	}
	public void setHrOsdtCd(String hrOsdtCd) {
		this.hrOsdtCd = hrOsdtCd;
	}
	public String getBlngOrzCd() {
		return blngOrzCd;
	}
	public void setBlngOrzCd(String blngOrzCd) {
		this.blngOrzCd = blngOrzCd;
	}
	
	public String getBzTp() {
		return bzTp;
	}
	public void setBzTp(String bzTp) {
		this.bzTp = bzTp;
	}
	public BigDecimal getPageSize() {
		return pageSize;
	}
	public void setPageSize(BigDecimal pageSize) {
		this.pageSize = pageSize;
	}
	public BigDecimal getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(BigDecimal pageIndex) {
		this.pageIndex = pageIndex;
	}
	public String getRqsScdNm() {
		return rqsScdNm;
	}
	public void setRqsScdNm(String rqsScdNm) {
		this.rqsScdNm = rqsScdNm;
	}
	public String getUnifRqsPcdNm() {
		return unifRqsPcdNm;
	}
	public void setUnifRqsPcdNm(String unifRqsPcdNm) {
		this.unifRqsPcdNm = unifRqsPcdNm;
	}
	public String getRqsTtlNm() {
		return rqsTtlNm;
	}
	public void setRqsTtlNm(String rqsTtlNm) {
		this.rqsTtlNm = rqsTtlNm;
	}
	public String getAprvEpnm() {
		return aprvEpnm;
	}
	public void setAprvEpnm(String aprvEpnm) {
		this.aprvEpnm = aprvEpnm;
	}
	public String getRqsDt() {
		return rqsDt;
	}
	public void setRqsDt(String rqsDt) {
		this.rqsDt = rqsDt;
	}
	public String getAprvDt() {
		return aprvDt;
	}
	public void setAprvDt(String aprvDt) {
		this.aprvDt = aprvDt;
	}
	
	
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
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

	public String getAprvPcd() {
		return aprvPcd;
	}
	public void setAprvPcd(String aprvPcd) {
		this.aprvPcd = aprvPcd;
	}

	public String getSbapYn() {
		return sbapYn;
	}

	public void setSbapYn(String sbapYn) {
		this.sbapYn = sbapYn;
	}
}