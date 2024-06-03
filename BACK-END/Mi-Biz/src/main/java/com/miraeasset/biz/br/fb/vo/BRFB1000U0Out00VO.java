package com.miraeasset.biz.br.fb.vo;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.dao.ExcelColumnStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultBodyStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultExcelCellStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultHeaderStyle;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 지점개요 - 지점전체
 */
@DefaultHeaderStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "GREY_HEADER"))
@DefaultBodyStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BODY"))
public class BRFB1000U0Out00VO {
    @ExcelColumnInfo(notes = "조직코드")
    @ApiModelProperty(notes = "조직코드")
    private String orzCd;
    @ExcelColumnInfo(notes = "조직명")
    @ApiModelProperty(notes = "조직명")
    private String orzNm;
    @ExcelColumnInfo(notes = "조직구분")
    @ApiModelProperty(notes = "조직구분")
    private String orzTcdNm;
    @ExcelColumnInfo(notes = "상위조직코드")
    @ApiModelProperty(notes = "상위조직코드")
    private String hrkOrzCd;
    @ExcelColumnInfo(notes = "상위조직명")
    @ApiModelProperty(notes = "상위조직명")
    private String hrkOrzNm;
    @ExcelColumnInfo(notes = "개설일자")
    @ApiModelProperty(notes = "개설일자")
    private String opnDt;
    @ExcelColumnInfo(notes = "임차유형")
    @ApiModelProperty(notes = "임차유형")
    private String leasePcdNm;
    @ExcelColumnInfo(notes = "주소")
    @ApiModelProperty(notes = "주소")
    private String adr;
    @ExcelColumnInfo(notes = "보증금")
    @ApiModelProperty(notes = "보증금")
    private BigDecimal leasGrtA;
    @ExcelColumnInfo(notes = "임대료")
    @ApiModelProperty(notes = "임대료")
    private BigDecimal lsA;
    @ApiModelProperty(notes = "ERP 파일번호")
    private String atcFileNo;

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

    public String getOrzTcdNm() {
        return orzTcdNm;
    }

    public void setOrzTcdNm(String orzTcdNm) {
        this.orzTcdNm = orzTcdNm;
    }

    public String getHrkOrzCd() {
        return hrkOrzCd;
    }

    public void setHrkOrzCd(String hrkOrzCd) {
        this.hrkOrzCd = hrkOrzCd;
    }

    public String getHrkOrzNm() {
        return hrkOrzNm;
    }

    public void setHrkOrzNm(String hrkOrzNm) {
        this.hrkOrzNm = hrkOrzNm;
    }

    public String getOpnDt() {
        return opnDt;
    }

    public void setOpnDt(String opnDt) {
        this.opnDt = opnDt;
    }

    public String getLeasePcdNm() {
        return leasePcdNm;
    }

    public void setLeasePcdNm(String leasePcdNm) {
        this.leasePcdNm = leasePcdNm;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public BigDecimal getLeasGrtA() {
        return leasGrtA;
    }

    public void setLeasGrtA(BigDecimal leasGrtA) {
        this.leasGrtA = leasGrtA;
    }

    public BigDecimal getLsA() {
        return lsA;
    }

    public void setLsA(BigDecimal lsA) {
        this.lsA = lsA;
    }

    public String getAtcFileNo() {
        return atcFileNo;
    }

    public void setAtcFileNo(String atcFileNo) {
        this.atcFileNo = atcFileNo;
    }
}
