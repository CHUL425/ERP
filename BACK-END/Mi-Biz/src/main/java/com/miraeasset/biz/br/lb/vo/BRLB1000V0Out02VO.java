package com.miraeasset.biz.br.lb.vo;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.dao.ExcelColumnStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultBodyStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultExcelCellStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultHeaderStyle;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@DefaultHeaderStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "GREY_HEADER"))
@DefaultBodyStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BODY"))
public class BRLB1000V0Out02VO {
    @ApiModelProperty(notes = "순번", example = "1")
    private BigDecimal rnum;
    @ApiModelProperty(notes = "총건수", example = "100")
    private BigDecimal alCnt;
    @ApiModelProperty(notes = "전표일자", example = "100")
    @ExcelColumnInfo(notes= "전표일자")
    private String spDt;
    @ApiModelProperty(notes = "회계단위코드", example = "000000")
    @ExcelColumnInfo(notes = "회계단위코드")
    private String actgUnitCd;
    @ApiModelProperty(notes = "조직명", example = "100")
    @ExcelColumnInfo(notes= "조직명")
    private String orzNm;
    @ApiModelProperty(hidden = true)
    private String acsjCd;
    @ApiModelProperty(notes = "계정과목명", example = "건물임차료")
    @ExcelColumnInfo(notes= "계정과목명")
    private String acsjCdNm;
    @ApiModelProperty(notes = "당월잔액", example = "100")
    @ExcelColumnInfo(notes= "당월잔액")
    private BigDecimal tdayBala;
    @ApiModelProperty(notes = "전월잔액", example = "100")
    @ExcelColumnInfo(notes= "전월잔액")
    private BigDecimal dybfBala;
    @ApiModelProperty(notes = "증감액", example = "100")
    @ExcelColumnInfo(notes= "증감액")
    private BigDecimal iccdA;

    public BigDecimal getRnum() {
        return rnum;
    }

    public void setRnum(BigDecimal rnum) {
        this.rnum = rnum;
    }

    public BigDecimal getAlCnt() {
        return alCnt;
    }

    public void setAlCnt(BigDecimal alCnt) {
        this.alCnt = alCnt;
    }

    public String getSpDt() {
        return spDt;
    }

    public void setSpDt(String spDt) {
        this.spDt = spDt;
    }

    public String getActgUnitCd() {
        return actgUnitCd;
    }

    public void setActgUnitCd(String actgUnitCd) {
        this.actgUnitCd = actgUnitCd;
    }

    public String getOrzNm() {
        return orzNm;
    }

    public void setOrzNm(String orzNm) {
        this.orzNm = orzNm;
    }

    public String getAcsjCd() {
        return acsjCd;
    }

    public void setAcsjCd(String acsjCd) {
        this.acsjCd = acsjCd;
    }

    public String getAcsjCdNm() {
        return acsjCdNm;
    }

    public void setAcsjCdNm(String acsjCdNm) {
        this.acsjCdNm = acsjCdNm;
    }

    public BigDecimal getTdayBala() {
        return tdayBala;
    }

    public void setTdayBala(BigDecimal tdayBala) {
        this.tdayBala = tdayBala;
    }

    public BigDecimal getDybfBala() {
        return dybfBala;
    }

    public void setDybfBala(BigDecimal dybfBala) {
        this.dybfBala = dybfBala;
    }

    public BigDecimal getIccdA() {
        return iccdA;
    }

    public void setIccdA(BigDecimal iccdA) {
        this.iccdA = iccdA;
    }
}
