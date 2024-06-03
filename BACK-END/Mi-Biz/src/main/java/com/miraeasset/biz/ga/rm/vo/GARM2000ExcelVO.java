package com.miraeasset.biz.ga.rm.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.vo.BaseVO;

@Component
public class GARM2000ExcelVO extends BaseVO {
    
	@ExcelColumnInfo(notes= "정산년월")
    @ApiModelProperty(notes= "정산년월")
    private String exccYm;            // 정산년월
    
	@ExcelColumnInfo(notes= "장비구분코드")
    @ApiModelProperty(notes= "장비구분코드")
    private String eqmtTcd        ;    /* 장비구분코드 */
    
	@ExcelColumnInfo(notes= "제품명")
    @ApiModelProperty(notes= "제품명")
    private String gdsNm          ;    /* 제품명 */
	
	@ExcelColumnInfo(notes= "기계번호")
	@ApiModelProperty(notes= "기계번호")
	private String rentCntcNo     ;    /* 임대계약번호 - 기계번호 */
	
	
	@ExcelColumnInfo(notes= "조직코드")
	@ApiModelProperty(notes= "조직코드")
	private String mtOrzCd        ;    /* 관리조직코드 - 조직코드  */
	
//	@ApiModelProperty(notes= "설치장소명")
//    private String istPlcNm       ;    /* 설치장소명 */
	@ExcelColumnInfo(notes= "상세위치")
    @ApiModelProperty(notes= "상세위치")
    private String istPlcDlNm     ;    /* 설치장소상세명 - 상세위치 */
    
	@ExcelColumnInfo(notes= "칼라사용량")
    @ApiModelProperty(notes= "칼라사용량")
    private String colrUvol       ;    /* 컬러사용량 = 칼라_청구매수 */
	@ExcelColumnInfo(notes= "칼라기본매수")
	@ApiModelProperty(notes= "칼라기본매수")
    private String colrBaseUvol   ;    /* 컬러기본사용량 = 칼라기본매수 */
	@ExcelColumnInfo(notes= "칼라추가단가")
	@ApiModelProperty(notes= "칼라추가단가")
    private String colrUpr        ;    /* 컬러단가 = 추가단가 */

	@ExcelColumnInfo(notes= "흑백사용량")
    @ApiModelProperty(notes= "흑백사용량")
    private String blakUvol       ;    /* 흑백사용량 = 흑백_청구매수 */
	@ExcelColumnInfo(notes= "흑백기본매수")
    @ApiModelProperty(notes= "흑백기본매수")
    private String blakBaseUvol   ;    /* 흑백기본사용량 = 흑백기본매수 */
	@ExcelColumnInfo(notes= "흑백추가단가")
	@ApiModelProperty(notes= "흑백추가단가")
    private String blakUpr        ;    /* 흑백단가 = 흑백추가단가 */
    
	@ExcelColumnInfo(notes= "기본요금")
    @ApiModelProperty(notes= "기본요금")
    private String mlyRentc       ;    /* 월간임대료 = 기본요금 */

	@ApiModelProperty(notes = "설치장소(조직주소)")
	private String istPlcNm;

	public String getExccYm() {
		return exccYm;
	}

	public void setExccYm(String exccYm) {
		this.exccYm = exccYm;
	}

	public String getEqmtTcd() {
		return eqmtTcd;
	}

	public void setEqmtTcd(String eqmtTcd) {
		this.eqmtTcd = eqmtTcd;
	}

	public String getGdsNm() {
		return gdsNm;
	}

	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}

	public String getRentCntcNo() {
		return rentCntcNo;
	}

	public void setRentCntcNo(String rentCntcNo) {
		this.rentCntcNo = rentCntcNo;
	}

	public String getMtOrzCd() {
		return mtOrzCd;
	}

	public void setMtOrzCd(String mtOrzCd) {
		this.mtOrzCd = mtOrzCd;
	}

	public String getIstPlcDlNm() {
		return istPlcDlNm;
	}

	public void setIstPlcDlNm(String istPlcDlNm) {
		this.istPlcDlNm = istPlcDlNm;
	}

	public String getColrUvol() {
		return colrUvol;
	}

	public void setColrUvol(String colrUvol) {
		this.colrUvol = colrUvol;
	}

	public String getColrBaseUvol() {
		return colrBaseUvol;
	}

	public void setColrBaseUvol(String colrBaseUvol) {
		this.colrBaseUvol = colrBaseUvol;
	}

	public String getColrUpr() {
		return colrUpr;
	}

	public void setColrUpr(String colrUpr) {
		this.colrUpr = colrUpr;
	}

	public String getBlakUvol() {
		return blakUvol;
	}

	public void setBlakUvol(String blakUvol) {
		this.blakUvol = blakUvol;
	}

	public String getBlakBaseUvol() {
		return blakBaseUvol;
	}

	public void setBlakBaseUvol(String blakBaseUvol) {
		this.blakBaseUvol = blakBaseUvol;
	}

	public String getBlakUpr() {
		return blakUpr;
	}

	public void setBlakUpr(String blakUpr) {
		this.blakUpr = blakUpr;
	}

	public String getMlyRentc() {
		return mlyRentc;
	}

	public void setMlyRentc(String mlyRentc) {
		this.mlyRentc = mlyRentc;
	}

	public String getIstPlcNm() {
		return istPlcNm;
	}

	public void setIstPlcNm(String istPlcNm) {
		this.istPlcNm = istPlcNm;
	}
}
