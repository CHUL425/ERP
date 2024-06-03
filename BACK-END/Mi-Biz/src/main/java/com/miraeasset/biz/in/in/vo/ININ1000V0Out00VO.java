package com.miraeasset.biz.in.in.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ININ1000V0Out00VO {
	
	@ApiModelProperty(notes = "통합신청유형코드")
	private String unifRqsPcd; /* 통합신청유형코드 */
	
	@ApiModelProperty(notes = "통합신청유형코드명")
	private String unifRqsPcdNm; /* 통합신청유형코드명 */
	
	@ApiModelProperty(notes = "통합신청구분코드")
	private String unifRqsTcd; /* 통합신청구분코드 */
	
	@ApiModelProperty(notes = "통합신청구분코드명")
	private String unifRqsTcdNm; /* 통합신청구분코드명 */
	
	@ApiModelProperty(notes = "신청부서코드")
	private String rqsOrzCd; /* 신청부서코드 */
	@ApiModelProperty(notes = "신청부서명")
	private String rqsOrzNm; /* 신청부서명 */
	
	@ApiModelProperty(notes = "신청사원번호 ")
	private String rqsEpno; /* 신청사원번호 */
	
	@ApiModelProperty(notes = "신청사원명")
	private String rqsEpnm; /* 신청사원명 */
	
	@ApiModelProperty(notes = "신청일자")
	private String rqsDt; /* 신청일자 */
	
	@ApiModelProperty(notes = "전체건수", example = "업무현황용")
	private BigDecimal alCnt; /* 전체건수 */
	
	@ApiModelProperty(notes = "미처리건수", example = "업무현황용")
	private BigDecimal nprcCnt; /* 미처리건수 */
	
	@ApiModelProperty(notes = "처리건수", example = "업무현황용")
	private BigDecimal prcCnt; /* 처리건수 */
	
	@ApiModelProperty(notes = "처리백분위값", example = "업무현황용")
	private String prcPctlVl; /* 처리백분위값 */
	
	@ApiModelProperty(notes= "접수번호")
	private String rctNo             ; /*접수번호*/
	
	@ApiModelProperty(notes= "결재상신관리번호")
    private String aprvWrrptMtNo    ; /*결재상신관리번호      */
	
	@ApiModelProperty(notes = "결재상신조직코드")
	private String aprvWrrptOrzCd	; /* 결재상신조직코드  */
	
	@ApiModelProperty(notes= "결재순위")
	private String aprvRnk       ; /*결재순위 */
	
	/* 2023.11.14 요건 변경 */
	@ApiModelProperty(notes= "결재유형코드")
	private String aprvPcd; /*결재유형코드  */

	public String getUnifRqsPcd() {
		return unifRqsPcd;
	}

	public void setUnifRqsPcd(String unifRqsPcd) {
		this.unifRqsPcd = unifRqsPcd;
	}

	public String getUnifRqsPcdNm() {
		return unifRqsPcdNm;
	}

	public void setUnifRqsPcdNm(String unifRqsPcdNm) {
		this.unifRqsPcdNm = unifRqsPcdNm;
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

	public String getRqsEpno() {
		return rqsEpno;
	}

	public void setRqsEpno(String rqsEpno) {
		this.rqsEpno = rqsEpno;
	}

	public String getRqsEpnm() {
		return rqsEpnm;
	}

	public void setRqsEpnm(String rqsEpnm) {
		this.rqsEpnm = rqsEpnm;
	}

	public String getRqsDt() {
		return rqsDt;
	}

	public void setRqsDt(String rqsDt) {
		this.rqsDt = rqsDt;
	}

	public BigDecimal getAlCnt() {
		return alCnt;
	}

	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}

	public BigDecimal getNprcCnt() {
		return nprcCnt;
	}

	public void setNprcCnt(BigDecimal nprcCnt) {
		this.nprcCnt = nprcCnt;
	}

	public BigDecimal getPrcCnt() {
		return prcCnt;
	}

	public void setPrcCnt(BigDecimal prcCnt) {
		this.prcCnt = prcCnt;
	}

	public String getPrcPctlVl() {
		return prcPctlVl;
	}

	public void setPrcPctlVl(String prcPctlVl) {
		this.prcPctlVl = prcPctlVl;
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
	
	public String getAprvPcd() {
		return aprvPcd;
	}

	public void setAprvPcd(String aprvPcd) {
		this.aprvPcd = aprvPcd;
	}

}
