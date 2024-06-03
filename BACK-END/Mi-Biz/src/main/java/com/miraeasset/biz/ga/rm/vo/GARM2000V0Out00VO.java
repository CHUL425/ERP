package com.miraeasset.biz.ga.rm.vo;

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
public class GARM2000V0Out00VO {
	
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ;    /* 전체건수 */
	
	@ExcelColumnInfo(notes= "정산년월")
    @ApiModelProperty(notes= "정산년월")
    private String exccYm         ;    /* 정산년월 */
	
    @ApiModelProperty(notes= "거래처코드")
    private String delpCd         ;    /* 거래처코드 */
    
    @ExcelColumnInfo(notes= "조직코드")
    @ApiModelProperty(notes= "조직코드")
    private String mtOrzCd        ;    /* 관리조직코드 - 조직코드  */
    
    @ExcelColumnInfo(notes= "조직명")
    @ApiModelProperty(notes= "조직명")
    private String mtOrzNm        ;    /* 관리조직명 - 조직명 */
    
    @ExcelColumnInfo(notes= "장비구분코드")
    @ApiModelProperty(notes= "장비구분코드")
    private String eqmtTcd        ;    /* 장비구분코드 */
    
    @ExcelColumnInfo(notes= "장비구분명")
    @ApiModelProperty(notes= "장비구분명")
    private String eqmtTcdNm      ;    /* 장비구분명 */
    
    @ExcelColumnInfo(notes= "기계번호")
    @ApiModelProperty(notes= "기계번호")
    private String rentCntcNo     ;    /* 임대계약번호 - 기계번호 */
    
    @ExcelColumnInfo(notes= "제품명")
    @ApiModelProperty(notes= "제품명")
    private String gdsNm          ;    /* 제품명 */
    
    @ExcelColumnInfo(notes= "기본요금")
    @ApiModelProperty(notes= "기본요금")
    private String mlyRentc       ;    /* 월간임대료 = 기본요금 */
    
    @ExcelColumnInfo(notes= "흑백사용량")
    @ApiModelProperty(notes= "흑백사용량")
    private String blakUvol       ;    /* 흑백사용량 = 흑백_청구매수 */
    
    @ExcelColumnInfo(notes= "흑백기본매수")
    @ApiModelProperty(notes= "흑백기본매수")
    private String blakBaseUvol   ;    /* 흑백기본사용량 = 흑백기본매수 */
    
    @ExcelColumnInfo(notes= "흑백추가단가")
    @ApiModelProperty(notes= "흑백추가단가")
    private String blakUpr        ;    /* 흑백단가 = 흑백추가단가 */
    
    @ExcelColumnInfo(notes= "흑백추가매수")
    @ApiModelProperty(notes= "흑백추가매수")
    private String blakAdBuy      ;    /* 흑백추가매수 */

    @ExcelColumnInfo(notes= "흑백추가요금")
    @ApiModelProperty(notes= "흑백추가요금")
    private String blakAdCrga     ;    /* 흑백추가요금 */
    
    @ExcelColumnInfo(notes= "흑백금액")
    @ApiModelProperty(notes= "흑백금액")
    private String blakA          ;    /* 흑백금액 */
    
    @ExcelColumnInfo(notes= "칼라사용량")
    @ApiModelProperty(notes= "칼라사용량")
    private String colrUvol       ;    /* 컬러사용량 = 칼라_청구매수 */
    
    @ExcelColumnInfo(notes= "칼라기본매수")
    @ApiModelProperty(notes= "칼라기본매수")
    private String colrBaseUvol   ;    /* 컬러기본사용량 = 칼라기본매수 */
    
    @ExcelColumnInfo(notes= "칼라추가단가")
    @ApiModelProperty(notes= "칼라추가단가")
    private String colrUpr        ;    /* 컬러단가 = 추가단가 */

    @ExcelColumnInfo(notes= "칼라추가매수")
    @ApiModelProperty(notes= "칼라추가매수")
    private String colrAdBuy      ;    /* 컬러추가매수 */
    
    @ExcelColumnInfo(notes= "칼라추가요금")
    @ApiModelProperty(notes = "칼라추가요금")
    private String colrAdCrga     ;    /* 칼라추가요금 */
    
    @ExcelColumnInfo(notes= "칼라금액")
    @ApiModelProperty(notes= "칼라금액")
    private String colrA          ;    /* 칼라금액 */
    
    @ExcelColumnInfo(notes= "설치장소명")
    @ApiModelProperty(notes= "설치장소명")
    private String istPlcNm       ;    /* 설치장소명 */
    
    @ExcelColumnInfo(notes= "설치장소상세명")
    @ApiModelProperty(notes= "설치장소상세명")
    private String istPlcDlNm     ;    /* 설치장소상세명 */
    
    @ApiModelProperty(notes= "조작자ID")
    private String optrId         ;    /* 조작자ID */
    @ApiModelProperty(notes= "조작채널코드")
    private String oprtChnlCd     ;    /* 조작채널코드 */
    @ApiModelProperty(notes= "조작조직코드")
    private String oprtOrzCd      ;    /* 조작조직코드 */
    @ApiModelProperty(notes= "조작IP주소")
    private String oprtIpAdr      ;    /* 조작IP주소 */
    @ApiModelProperty(notes= "조작일시")
    private String oprtDttm       ;    /* 조작일시 */
    
	public BigDecimal getAlCnt() {
		return alCnt;
	}
	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}
	public String getExccYm() {
		return exccYm;
	}
	public void setExccYm(String exccYm) {
		this.exccYm = exccYm;
	}
	public String getDelpCd() {
		return delpCd;
	}
	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}
	public String getMtOrzCd() {
		return mtOrzCd;
	}
	public void setMtOrzCd(String mtOrzCd) {
		this.mtOrzCd = mtOrzCd;
	}
	public String getMtOrzNm() {
		return mtOrzNm;
	}
	public void setMtOrzNm(String mtOrzNm) {
		this.mtOrzNm = mtOrzNm;
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
	public String getMlyRentc() {
		return mlyRentc;
	}
	public void setMlyRentc(String mlyRentc) {
		this.mlyRentc = mlyRentc;
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
	public String getBlakAdBuy() {
		return blakAdBuy;
	}
	public void setBlakAdBuy(String blakAdBuy) {
		this.blakAdBuy = blakAdBuy;
	}
	public String getBlakAdCrga() {
		return blakAdCrga;
	}
	public void setBlakAdCrga(String blakAdCrga) {
		this.blakAdCrga = blakAdCrga;
	}
	public String getBlakA() {
		return blakA;
	}
	public void setBlakA(String blakA) {
		this.blakA = blakA;
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
	public String getColrAdBuy() {
		return colrAdBuy;
	}
	public void setColrAdBuy(String colrAdBuy) {
		this.colrAdBuy = colrAdBuy;
	}
	public String getColrAdCrga() {
		return colrAdCrga;
	}
	public void setColrAdCrga(String colrAdCrga) {
		this.colrAdCrga = colrAdCrga;
	}
	public String getColrA() {
		return colrA;
	}
	public void setColrA(String colrA) {
		this.colrA = colrA;
	}
	public String getIstPlcNm() {
		return istPlcNm;
	}
	public void setIstPlcNm(String istPlcNm) {
		this.istPlcNm = istPlcNm;
	}
	public String getIstPlcDlNm() {
		return istPlcDlNm;
	}
	public void setIstPlcDlNm(String istPlcDlNm) {
		this.istPlcDlNm = istPlcDlNm;
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
	public String getOprtDttm() {
		return oprtDttm;
	}
	public void setOprtDttm(String oprtDttm) {
		this.oprtDttm = oprtDttm;
	}
	
	@Override
	public String toString() {
		return "GARM2000V0Out00VO [alCnt=" + alCnt + ", exccYm=" + exccYm + ", delpCd=" + delpCd + ", mtOrzCd="
				+ mtOrzCd + ", mtOrzNm=" + mtOrzNm + ", eqmtTcd=" + eqmtTcd + ", eqmtTcdNm=" + eqmtTcdNm
				+ ", rentCntcNo=" + rentCntcNo + ", gdsNm=" + gdsNm + ", mlyRentc=" + mlyRentc + ", blakUvol="
				+ blakUvol + ", blakBaseUvol=" + blakBaseUvol + ", blakUpr=" + blakUpr + ", blakAdBuy=" + blakAdBuy
				+ ", blakAdCrga=" + blakAdCrga + ", blakA=" + blakA + ", colrUvol=" + colrUvol + ", colrBaseUvol="
				+ colrBaseUvol + ", colrUpr=" + colrUpr + ", colrAdBuy=" + colrAdBuy + ", colrAdCrga=" + colrAdCrga
				+ ", colrA=" + colrA + ", istPlcNm=" + istPlcNm + ", istPlcDlNm=" + istPlcDlNm + ", optrId=" + optrId
				+ ", oprtChnlCd=" + oprtChnlCd + ", oprtOrzCd=" + oprtOrzCd + ", oprtIpAdr=" + oprtIpAdr + ", oprtDttm="
				+ oprtDttm + "]";
	}
	
}
