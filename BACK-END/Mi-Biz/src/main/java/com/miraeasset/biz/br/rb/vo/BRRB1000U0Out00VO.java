package com.miraeasset.biz.br.rb.vo;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.dao.ExcelColumnStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultBodyStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultExcelCellStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultHeaderStyle;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@DefaultHeaderStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "GREY_HEADER"))
@DefaultBodyStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BODY"))
public class BRRB1000U0Out00VO {
    @ApiModelProperty(notes= "전체건수", example="0")
    private BigDecimal alCnt;
    @ApiModelProperty(notes = "순번", example = "0")
    private BigDecimal rnum;
    @ApiModelProperty(notes = "임대자가구분코드", hidden = true)
    private String lsSfTcd;
    @ApiModelProperty(notes = "기준년월", example = "202309")
    @ExcelColumnInfo(notes = "기준년월")
    private String basYm;
    @ApiModelProperty(notes = "임대자가구분", example = "사옥")
    @ExcelColumnInfo(notes = "임대자가구분")
    private String lsSfTcdNm;
    @ApiModelProperty(notes = "사옥명", example = "여의도")
    @ExcelColumnInfo(notes = "사옥명")
    private String ofcbldTcdNm;
    @ApiModelProperty(notes = "임대인", example = "삼성역WM")
    @ExcelColumnInfo(notes = "임대인")
    private String lvinCoNm;
    @ApiModelProperty(notes = "조직명", example = "삼성역WM")
    @ExcelColumnInfo(notes = "조직명")
    private String orzNm;
    @ApiModelProperty(notes = "임차면적(평)", example = "301.83")
    @ExcelColumnInfo(notes = "임차면적(평)", bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "DECIMAL2"))
    private BigDecimal rentAr;
    @ApiModelProperty(notes = "전용면적(평)", example = "168.38")
    @ExcelColumnInfo(notes = "전용면적(평)", bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "DECIMAL2"))
    private BigDecimal onlyAr;
    @ApiModelProperty(notes = "보증금", example = "2000000000")
    @ExcelColumnInfo(notes = "보증금", bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
    private BigDecimal grtA;
    @ApiModelProperty(notes = "임대료", example = "23100000")
    @ExcelColumnInfo(notes = "임대료", bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
    private BigDecimal mlyRentc;
    @ApiModelProperty(notes = "관리비", example = "10564050")
    @ExcelColumnInfo(notes = "관리비", bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
    private BigDecimal mlyMcst;
    @ApiModelProperty(notes = "최초입주일자", example = "20181231")
    @ExcelColumnInfo(notes = "최초입주일자")
    private String fstLsOpDt;
    @ApiModelProperty(notes = "계약종료일자", example = "20231130")
    @ExcelColumnInfo(notes = "계약종료일자")
    private String lsEndDt;
    @ApiModelProperty(notes = "계약번호", example = "201912010001")
    @ExcelColumnInfo(notes = "계약번호")
    private String lsCntcNo;
    @ApiModelProperty(notes = "계약부번", example = "3")
    @ExcelColumnInfo(notes = "계약부번")
    private String lsCntcAdtnSrno;

    @ApiModelProperty(notes = "사옥구분코드", example = "01")
    private String ofcbldTcd;

    @ApiModelProperty(notes = "조직코드", example = "F04001")
    private String orzCd;

    public BigDecimal getAlCnt() {
        return alCnt;
    }

    public void setAlCnt(BigDecimal alCnt) {
        this.alCnt = alCnt;
    }

    public BigDecimal getRnum() {
        return rnum;
    }

    public void setRnum(BigDecimal rnum) {
        this.rnum = rnum;
    }

    public String getLsSfTcd() {
        return lsSfTcd;
    }

    public void setLsSfTcd(String lsSfTcd) {
        this.lsSfTcd = lsSfTcd;
    }

    public String getLsSfTcdNm() {
        return lsSfTcdNm;
    }

    public void setLsSfTcdNm(String lsSfTcdNm) {
        this.lsSfTcdNm = lsSfTcdNm;
    }

    public String getOfcbldTcdNm() {
        return ofcbldTcdNm;
    }

    public void setOfcbldTcdNm(String ofcbldTcdNm) {
        this.ofcbldTcdNm = ofcbldTcdNm;
    }

    public String getLvinCoNm() {
        return lvinCoNm;
    }

    public void setLvinCoNm(String lvinCoNm) {
        this.lvinCoNm = lvinCoNm;
    }

    public String getOrzNm() {
        return orzNm;
    }

    public void setOrzNm(String orzNm) {
        this.orzNm = orzNm;
    }

    public BigDecimal getRentAr() {
        return rentAr;
    }

    public void setRentAr(BigDecimal rentAr) {
        this.rentAr = rentAr;
    }

    public BigDecimal getOnlyAr() {
        return onlyAr;
    }

    public void setOnlyAr(BigDecimal onlyAr) {
        this.onlyAr = onlyAr;
    }

    public BigDecimal getGrtA() {
        return grtA;
    }

    public void setGrtA(BigDecimal grtA) {
        this.grtA = grtA;
    }

    public BigDecimal getMlyRentc() {
        return mlyRentc;
    }

    public void setMlyRentc(BigDecimal mlyRentc) {
        this.mlyRentc = mlyRentc;
    }

    public BigDecimal getMlyMcst() {
        return mlyMcst;
    }

    public void setMlyMcst(BigDecimal mlyMcst) {
        this.mlyMcst = mlyMcst;
    }

    public String getFstLsOpDt() {
        return fstLsOpDt;
    }

    public void setFstLsOpDt(String fstLsOpDt) {
        this.fstLsOpDt = fstLsOpDt;
    }

    public String getLsEndDt() {
        return lsEndDt;
    }

    public void setLsEndDt(String lsEndDt) {
        this.lsEndDt = lsEndDt;
    }

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

    public String getBasYm() {
        return basYm;
    }

    public void setBasYm(String basYm) {
        this.basYm = basYm;
    }

    public String getOfcbldTcd() {
        return ofcbldTcd;
    }

    public void setOfcbldTcd(String ofcbldTcd) {
        this.ofcbldTcd = ofcbldTcd;
    }

    public String getOrzCd() {
        return orzCd;
    }

    public void setOrzCd(String orzCd) {
        this.orzCd = orzCd;
    }
}
