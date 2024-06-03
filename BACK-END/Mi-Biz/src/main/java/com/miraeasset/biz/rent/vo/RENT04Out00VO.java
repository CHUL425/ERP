package com.miraeasset.biz.rent.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RENT04Out00VO {
	
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ;    /* 전체건수 */
	
	@ApiModelProperty(notes= "사용조직코드")
	private String orzCd          ;    /* 사용조직코드 */
	@ApiModelProperty(notes= "조직명")
	private String orzNm          ;    /* 조직명 */
	@ApiModelProperty(notes= "장비구분코드")
    private String eqmtTcd        ;    /* 장비구분코드 */
    @ApiModelProperty(notes= "장비구분명")
    private String eqmtTcdNm      ;    /* 장비구분명 */
    @ApiModelProperty(notes= "임대계약번호")
	private String rentCntcNo     ;    /* 임대계약번호 */
    @ApiModelProperty(notes= "제품명")
    private String gdsNm          ;    /* 제품명 */
    @ApiModelProperty(notes= "설치장소명")
    private String istPclNm       ;    /* 설치장소명 */
    @ApiModelProperty(notes= "설치장소상세명")
    private String istPclDlNm     ;    /* 설치장소상세명 */
    @ApiModelProperty(notes= "조작자ID")
    private String optrId         ;    /* 조작자ID */
    @ApiModelProperty(notes= "조작채널코드")
    private String oprtChnlCd     ;    /* 조작채널코드 */
    @ApiModelProperty(notes= "조작조직코드")
    private String oprtOrzCd      ;    /* 조작조직코드 */
    @ApiModelProperty(notes= "조작IP주소")
    private String oprtIpAdr      ;    /* 조작IP주소 */
    @ApiModelProperty(notes= "조작일시")
    private String oprrDttm       ;    /* 조작일시 */
    
	public BigDecimal getAlCnt() {
		return alCnt;
	}
	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
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
	public String getEqmtTcd() {
		return eqmtTcd;
	}
	public void setEqmtTcd(String eqmtTcd) {
		this.eqmtTcd = eqmtTcd;
	}
	public String getEqmtTcdNm() {
		return eqmtTcdNm;
	}
	public void setEqmtTcdNm(String eqmtTcdNm) {
		this.eqmtTcdNm = eqmtTcdNm;
	}
	public String getRentCntcNo() {
		return rentCntcNo;
	}
	public void setRentCntcNo(String rentCntcNo) {
		this.rentCntcNo = rentCntcNo;
	}
	public String getGdsNm() {
		return gdsNm;
	}
	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}
	public String getIstPclNm() {
		return istPclNm;
	}
	public void setIstPclNm(String istPclNm) {
		this.istPclNm = istPclNm;
	}
	public String getIstPclDlNm() {
		return istPclDlNm;
	}
	public void setIstPclDlNm(String istPclDlNm) {
		this.istPclDlNm = istPclDlNm;
	}
	public String getOptrId() {
		return optrId;
	}
	public void setOptrId(String optrId) {
		this.optrId = optrId;
	}
	public String getOprtChnlCd() {
		return oprtChnlCd;
	}
	public void setOprtChnlCd(String oprtChnlCd) {
		this.oprtChnlCd = oprtChnlCd;
	}
	public String getOprtOrzCd() {
		return oprtOrzCd;
	}
	public void setOprtOrzCd(String oprtOrzCd) {
		this.oprtOrzCd = oprtOrzCd;
	}
	public String getOprtIpAdr() {
		return oprtIpAdr;
	}
	public void setOprtIpAdr(String oprtIpAdr) {
		this.oprtIpAdr = oprtIpAdr;
	}
	public String getOprrDttm() {
		return oprrDttm;
	}
	public void setOprrDttm(String oprrDttm) {
		this.oprrDttm = oprrDttm;
	}
	
	@Override
	public String toString() {
		return "RENT04Out00VO [alCnt=" + alCnt + ", orzCd=" + orzCd + ", orzNm=" + orzNm + ", eqmtTcd=" + eqmtTcd
				+ ", eqmtTcdNm=" + eqmtTcdNm + ", rentCntcNo=" + rentCntcNo + ", gdsNm=" + gdsNm + ", istPclNm="
				+ istPclNm + ", istPclDlNm=" + istPclDlNm + ", optrId=" + optrId + ", oprtChnlCd=" + oprtChnlCd
				+ ", oprtOrzCd=" + oprtOrzCd + ", oprtIpAdr=" + oprtIpAdr + ", oprrDttm=" + oprrDttm + "]";
	}
    
}
