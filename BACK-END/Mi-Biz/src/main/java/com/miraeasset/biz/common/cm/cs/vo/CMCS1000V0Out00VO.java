package com.miraeasset.biz.common.cm.cs.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class CMCS1000V0Out00VO {
	
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt   		; /* 전체건수 */
	
	@ApiModelProperty(notes = "계약번호")
	private String lsCntcNo			; /* 계약번호 */
	@ApiModelProperty(notes = "계약부가번호")
	private String lsCntcAdtnSrno	; /* 계약부가번호 */
	@ApiModelProperty(notes = "계약명")
	private String cntcNm			; /* 계약명 */
	@ApiModelProperty(notes = "임대인명암호화값")
	private String lesorNmEcpVl		; /* 임대인명암호화값 */
	@ApiModelProperty(notes = "조직코드")
	private String orzCd			; /* 조직코드 */
	@ApiModelProperty(notes = "조직명")
	private String orzNm			; /* 조직명 */
	@ApiModelProperty(notes = "사용권리자산구분코드")
	private String useRgtAstTcd		; /* 사용권리자산구분코드 */
	@ApiModelProperty(notes = "사용권리자산구분명")
	private String useRgtAstTcdNm	; /* 사용권리자산구분명 */
	@ApiModelProperty(notes = "계약구분코드")
	private String cntcTcd			; /* 계약구분코드 */
	@ApiModelProperty(notes = "계약구분코드명")
	private String cntcTcdNm		; /* 계약구분코드명 */	
	@ApiModelProperty(notes = "결재상태코드")
	private String aprvScd			; /* 결재상태코드 */
	@ApiModelProperty(notes = "결재상태명")
	private String aprvScdNm		; /* 결재상태명 */
	@ApiModelProperty(notes = "최종계약여부")
	private String lstCntcYn        ; /* 최종계약여부 */
	@ApiModelProperty(notes= "결재상신관리번호")
    private String aprvWrrptMtNo    ; /*결재상신관리번호      */
	@ApiModelProperty(notes = "결재상신조직코드")
	private String aprvWrrptOrzCd	; /* 결재상신조직코드  */
	@ApiModelProperty(notes = "기안문서번호")
	private String drftDocNo		; /* 기안문서번호 */
	@ApiModelProperty(notes = "기안문서명")
	private String drftDocNm		; /* 기안문서명 */
	@ApiModelProperty(notes = "해지구분")
	private String cntcCclcTcd		; /* 해지구분 */
	@ApiModelProperty(notes = "해지구분명")
	private String cntcCclcTcdNm	; /* 해지구분명 */
	
	public String getLsCntcNo() {
		return lsCntcNo;
	}
	public void setLsCntcNo(String lsCntcNo) {
		this.lsCntcNo = lsCntcNo;
	}
	public String getLsCntcAdtnSrno() {
		return lsCntcAdtnSrno;
	}
	public void setLsCntcAdtnSrno(String lsCntcAdtnSrno) {
		this.lsCntcAdtnSrno = lsCntcAdtnSrno;
	}
	public String getCntcNm() {
		return cntcNm;
	}
	public void setCntcNm(String cntcNm) {
		this.cntcNm = cntcNm;
	}
	public String getLesorNmEcpVl() {
		return lesorNmEcpVl;
	}
	public void setLesorNmEcpVl(String lesorNmEcpVl) {
		this.lesorNmEcpVl = lesorNmEcpVl;
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
	public String getUseRgtAstTcd() {
		return useRgtAstTcd;
	}
	public void setUseRgtAstTcd(String useRgtAstTcd) {
		this.useRgtAstTcd = useRgtAstTcd;
	}
	public String getUseRgtAstTcdNm() {
		return useRgtAstTcdNm;
	}
	public void setUseRgtAstTcdNm(String useRgtAstTcdNm) {
		this.useRgtAstTcdNm = useRgtAstTcdNm;
	}
	public String getCntcTcd() {
		return cntcTcd;
	}
	public void setCntcTcd(String cntcTcd) {
		this.cntcTcd = cntcTcd;
	}
	public String getCntcTcdNm() {
		return cntcTcdNm;
	}
	public void setCntcTcdNm(String cntcTcdNm) {
		this.cntcTcdNm = cntcTcdNm;
	}
	public String getAprvScd() {
		return aprvScd;
	}
	public void setAprvScd(String aprvScd) {
		this.aprvScd = aprvScd;
	}
	public String getAprvScdNm() {
		return aprvScdNm;
	}
	public void setAprvScdNm(String aprvScdNm) {
		this.aprvScdNm = aprvScdNm;
	}
	public String getLstCntcYn() {
		return lstCntcYn;
	}
	public void setLstCntcYn(String lstCntcYn) {
		this.lstCntcYn = lstCntcYn;
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
	public String getDrftDocNo() {
		return drftDocNo;
	}
	public void setDrftDocNo(String drftDocNo) {
		this.drftDocNo = drftDocNo;
	}
	public String getDrftDocNm() {
		return drftDocNm;
	}
	public void setDrftDocNm(String drftDocNm) {
		this.drftDocNm = drftDocNm;
	}
	public String getCntcCclcTcd() {
		return cntcCclcTcd;
	}
	public void setCntcCclcTcd(String cntcCclcTcd) {
		this.cntcCclcTcd = cntcCclcTcd;
	}
	public String getCntcCclcTcdNm() {
		return cntcCclcTcdNm;
	}
	public void setCntcCclcTcdNm(String cntcCclcTcdNm) {
		this.cntcCclcTcdNm = cntcCclcTcdNm;
	}
	
	@Override
	public String toString() {
		return "CMCS1000V0Out00VO [lsCntcNo=" + lsCntcNo + ", lsCntcAdtnSrno=" + lsCntcAdtnSrno + ", cntcNm=" + cntcNm
				+ ", lesorNmEcpVl=" + lesorNmEcpVl + ", orzCd=" + orzCd + ", orzNm=" + orzNm + ", useRgtAstTcd="
				+ useRgtAstTcd + ", useRgtAstTcdNm=" + useRgtAstTcdNm + ", cntcTcd=" + cntcTcd + ", cntcTcdNm="
				+ cntcTcdNm + ", aprvScd=" + aprvScd + ", aprvScdNm=" + aprvScdNm + ", lstCntcYn=" + lstCntcYn
				+ ", aprvWrrptMtNo=" + aprvWrrptMtNo + ", aprvWrrptOrzCd=" + aprvWrrptOrzCd + ", drftDocNo=" + drftDocNo
				+ ", drftDocNm=" + drftDocNm + ", cntcCclcTcd=" + cntcCclcTcd + ", cntcCclcTcdNm=" + cntcCclcTcdNm
				+ "]";
	}
	
}
