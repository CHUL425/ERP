package com.miraeasset.biz.common.cm.cs.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class CMCS1000V0In00VO {
	
	@ApiModelProperty(notes = "계약번호")
	private String lsCntcNo			; /* 계약번호 */
	
	@ApiModelProperty(notes = "계약부가번호")
	private String lsCntcAdtnSrno	; /* 계약부가번호 */
	
	@ApiModelProperty(notes = "조직코드")
	private String orzCd			; /* 조직코드 */
	
	@ApiModelProperty(notes = "계약명")
	private String cntcNm			; /* 계약명 */
	
	@ApiModelProperty(notes = "계약구분코드")
	private String cntcTcd			; /* 계약구분코드 */
	
	@ApiModelProperty(notes = "사용권리자산구분코드")
	private String useRgtAstTcd		; /* 사용권리자산구분코드 */
	
	@ApiModelProperty(notes = "최종계약여부")
	private String lstCntcYn		; /* 최종계약여부 */
	
	@ApiModelProperty(notes = "결재상태코드")
	private String aprvScd			; /* 결재상태코드 */
	
	@ApiModelProperty(notes = "기안문서번호")
	private String drftDocNo		; /* 기안문서번호 */
	
	@ApiModelProperty(notes = "계약해지구분코드")
	private String cntcCclcTcd		; /* 계약해지구분코드 */
	
	@ApiModelProperty(notes = "임대인명암호화값")
	private String lesorNmEcpVl		; /* 임대인명암호화값 */
	
	@ApiModelProperty(notes= "페이지사이즈", example="0")
	private BigDecimal pageSize		; /* 페이지사이즈 */
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex	; /* 페이지순번 */
    
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
	public String getOrzCd() {
		return orzCd;
	}
	public void setOrzCd(String orzCd) {
		this.orzCd = orzCd;
	}
	public String getCntcNm() {
		return cntcNm;
	}
	public void setCntcNm(String cntcNm) {
		this.cntcNm = cntcNm;
	}
	public String getCntcTcd() {
		return cntcTcd;
	}
	public void setCntcTcd(String cntcTcd) {
		this.cntcTcd = cntcTcd;
	}
	public String getUseRgtAstTcd() {
		return useRgtAstTcd;
	}
	public void setUseRgtAstTcd(String useRgtAstTcd) {
		this.useRgtAstTcd = useRgtAstTcd;
	}
	public String getLstCntcYn() {
		return lstCntcYn;
	}
	public void setLstCntcYn(String lstCntcYn) {
		this.lstCntcYn = lstCntcYn;
	}
	public String getAprvScd() {
		return aprvScd;
	}
	public void setAprvScd(String aprvScd) {
		this.aprvScd = aprvScd;
	}
	public String getDrftDocNo() {
		return drftDocNo;
	}
	public void setDrftDocNo(String drftDocNo) {
		this.drftDocNo = drftDocNo;
	}
	public String getCntcCclcTcd() {
		return cntcCclcTcd;
	}
	public void setCntcCclcTcd(String cntcCclcTcd) {
		this.cntcCclcTcd = cntcCclcTcd;
	}
	public String getLesorNmEcpVl() {
		return lesorNmEcpVl;
	}
	public void setLesorNmEcpVl(String lesorNmEcpVl) {
		this.lesorNmEcpVl = lesorNmEcpVl;
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
    
}
