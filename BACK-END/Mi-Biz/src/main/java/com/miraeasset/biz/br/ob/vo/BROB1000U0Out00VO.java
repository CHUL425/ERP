package com.miraeasset.biz.br.ob.vo;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.dao.ExcelColumnStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultBodyStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultExcelCellStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultHeaderStyle;
import com.miraeasset.biz.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@DefaultHeaderStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "GREY_HEADER"))
@DefaultBodyStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BODY"))
public class BROB1000U0Out00VO extends BaseVO {
    @ExcelColumnInfo(notes = "사옥구분코드")
    @ApiModelProperty(notes = "사옥구분코드")
    private String ofcbldTcd;
    @ExcelColumnInfo(notes = "사옥구분명")
    @ApiModelProperty(notes = "사옥구분코드명")
    private String ofcbldTcdNm;
    @ExcelColumnInfo(notes = "건물명")
    @ApiModelProperty(notes = "건물명")
    private String bldNm;
    @ExcelColumnInfo(notes = "주소")
    @ApiModelProperty(notes = "주소")
    private String adr;
    @ExcelColumnInfo(notes = "지역")
    @ApiModelProperty(notes = "지역")
    private String rgnNm;
    @ExcelColumnInfo(notes = "지하층수")
    @ApiModelProperty(notes = "지하층수", example = "0")
    private int ugrBldflrVl;
    @ExcelColumnInfo(notes = "지상층수")
    @ApiModelProperty(notes = "지상층수", example = "0")
    private int gruBldflrVl;
    @ExcelColumnInfo(notes = "건축구조")
    @ApiModelProperty(notes = "건축구조")
    private String bldStrcNm;
    @ExcelColumnInfo(notes = "승강기수")
    @ApiModelProperty(notes = "승강기수", example = "0")
    private int etcAtclQ;
    @ExcelColumnInfo(notes = "준공일자")
    @ApiModelProperty(notes = "준공일자")
    private String cmpltDt;
    @ExcelColumnInfo(notes = "대지면적")
    @ApiModelProperty(notes = "대지면적")
    private BigDecimal landAr;
    @ExcelColumnInfo(notes = "연면적")
    @ApiModelProperty(notes = "연면적")
    private BigDecimal bldGar;
    @ExcelColumnInfo(notes = "건축면적")
    @ApiModelProperty(notes = "건축면적")
    private BigDecimal bldAr;
    @ExcelColumnInfo(notes = "관리소장(명)")
    @ApiModelProperty(notes = "관리소장(명)", example = "0")
    private int mtEmpTnop1;
    @ExcelColumnInfo(notes = "시설직원(명)")
    @ApiModelProperty(notes = "시설직원(명))", example = "0")
    private int mtEmpTnop2;
    @ExcelColumnInfo(notes = "보안직원(명)")
    @ApiModelProperty(notes = "보안직원(명)", example = "0")
    private int mtEmpTnop3;
    @ExcelColumnInfo(notes = "미화직원(명)")
    @ApiModelProperty(notes = "미화직원(명)", example = "0")
    private int mtEmpTnop4;
    @ExcelColumnInfo(notes = "지하주차대수")
    @ApiModelProperty(notes = "지하주차대수", example = "0")
    private int ugrParkingAblQ;
    @ExcelColumnInfo(notes = "지상주차대수")
    @ApiModelProperty(notes = "지상주차대수", example = "0")
    private int gruParkingAblQ;
    @ExcelColumnInfo(notes = "기타사용면적")
    @ApiModelProperty(notes = "기타사용면적", example = "0")
    private BigDecimal etcUseAr;
    @ExcelColumnInfo(notes = "보증금 기준가")
    @ApiModelProperty(notes = "보증금 기준가", example = "0")
    private BigDecimal grtA;
    @ExcelColumnInfo(notes = "임대료 기준가")
    @ApiModelProperty(notes = "임대료 기준가", example = "0")
    private BigDecimal mlyRentc;
    @ExcelColumnInfo(notes = "관리비 기준가")
    @ApiModelProperty(notes = "관리비 기준가", example = "0")
    private BigDecimal mlyMcst;
    @ApiModelProperty("파일번호")
    private String fileNo;

    public String getOfcbldTcd() {
        return ofcbldTcd;
    }

    public void setOfcbldTcd(String ofcbldTcd) {
        this.ofcbldTcd = ofcbldTcd;
    }

    public String getOfcbldTcdNm() {
        return ofcbldTcdNm;
    }

    public void setOfcbldTcdNm(String ofcbldTcdNm) {
        this.ofcbldTcdNm = ofcbldTcdNm;
    }

    public String getBldNm() {
        return bldNm;
    }

    public void setBldNm(String bldNm) {
        this.bldNm = bldNm;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getRgnNm() {
        return rgnNm;
    }

    public void setRgnNm(String rgnNm) {
        this.rgnNm = rgnNm;
    }

    public int getUgrBldflrVl() {
        return ugrBldflrVl;
    }

    public void setUgrBldflrVl(int ugrBldflrVl) {
        this.ugrBldflrVl = ugrBldflrVl;
    }

    public int getGruBldflrVl() {
        return gruBldflrVl;
    }

    public void setGruBldflrVl(int gruBldflrVl) {
        this.gruBldflrVl = gruBldflrVl;
    }

    public String getBldStrcNm() {
        return bldStrcNm;
    }

    public void setBldStrcNm(String bldStrcNm) {
        this.bldStrcNm = bldStrcNm;
    }

    public int getEtcAtclQ() {
        return etcAtclQ;
    }

    public void setEtcAtclQ(int etcAtclQ) {
        this.etcAtclQ = etcAtclQ;
    }

    public String getCmpltDt() {
        return cmpltDt;
    }

    public void setCmpltDt(String cmpltDt) {
        this.cmpltDt = cmpltDt;
    }

    public BigDecimal getLandAr() {
        return landAr;
    }

    public void setLandAr(BigDecimal landAr) {
        this.landAr = landAr;
    }

    public BigDecimal getBldGar() {
        return bldGar;
    }

    public void setBldGar(BigDecimal bldGar) {
        this.bldGar = bldGar;
    }

    public BigDecimal getBldAr() {
        return bldAr;
    }

    public void setBldAr(BigDecimal bldAr) {
        this.bldAr = bldAr;
    }

    public int getMtEmpTnop1() {
        return mtEmpTnop1;
    }

    public void setMtEmpTnop1(int mtEmpTnop1) {
        this.mtEmpTnop1 = mtEmpTnop1;
    }

    public int getMtEmpTnop2() {
        return mtEmpTnop2;
    }

    public void setMtEmpTnop2(int mtEmpTnop2) {
        this.mtEmpTnop2 = mtEmpTnop2;
    }

    public int getMtEmpTnop3() {
        return mtEmpTnop3;
    }

    public void setMtEmpTnop3(int mtEmpTnop3) {
        this.mtEmpTnop3 = mtEmpTnop3;
    }

    public int getMtEmpTnop4() {
        return mtEmpTnop4;
    }

    public void setMtEmpTnop4(int mtEmpTnop4) {
        this.mtEmpTnop4 = mtEmpTnop4;
    }

    public int getUgrParkingAblQ() {
        return ugrParkingAblQ;
    }

    public void setUgrParkingAblQ(int ugrParkingAblQ) {
        this.ugrParkingAblQ = ugrParkingAblQ;
    }

    public int getGruParkingAblQ() {
        return gruParkingAblQ;
    }

    public void setGruParkingAblQ(int gruParkingAblQ) {
        this.gruParkingAblQ = gruParkingAblQ;
    }

    public BigDecimal getEtcUseAr() {
        return etcUseAr;
    }

    public void setEtcUseAr(BigDecimal etcUseAr) {
        this.etcUseAr = etcUseAr;
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

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }
}
