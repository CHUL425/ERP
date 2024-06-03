package com.miraeasset.biz.br.er.vo;

import java.math.BigDecimal;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;


import com.miraeasset.biz.common.dao.ExcelColumnStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultBodyStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultExcelCellStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultHeaderStyle;
import com.miraeasset.biz.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

@DefaultHeaderStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "GREY_HEADER"))
@DefaultBodyStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BODY"))
public class BRER2000U0Out00VO extends BaseVO {

    @ApiModelProperty(notes = "전체건수", example = "0")
    private BigDecimal alCnt; /* 전체건수 */
    @ApiModelProperty(notes = "순번", example = "0")
    private BigDecimal rnum; /* 순번            */
    @ExcelColumnInfo(notes = "조직코드")
    @ApiModelProperty(notes = "조직코드")
    private String orzCd;            // 조직코드
    @ExcelColumnInfo(notes = "조직명")
    @ApiModelProperty(notes = "조직명")
    private String orzNm;            // 지점명
    @ExcelColumnInfo(notes = "구분명")
    @ApiModelProperty(notes = "구분명")
    private String tpNm;             // 구분명
    @ExcelColumnInfo(notes = "거래처코드")
    @ApiModelProperty(notes = "거래처코드")
    private String delpCd;
    @ExcelColumnInfo(notes = "관리업체")// 거래처코드
    @ApiModelProperty(notes = "관리업체")
    private String delpNm;            // 관리업체
    @ExcelColumnInfo(notes = "UPS본체_설치년월")
    @ApiModelProperty(notes = "UPS본체_설치년월")
    private String istYm;             //UPS본체_설치년월
    @ExcelColumnInfo(notes = "UPS본체_용량 VKA")
    @ApiModelProperty(notes = "UPS본체_용량 VKA")
    private int cntcCapa;           // UPS본체_용량 VKA
    @ExcelColumnInfo(notes = "배터리 제조년월")
    @ApiModelProperty(notes = "배터리 제조년월")
    private String makgYm;            //배터리 제조년월
    @ExcelColumnInfo(notes = "배터리 용량및수량")
    @ApiModelProperty(notes = "배터리 용량및수량")
    private String capaQCn;           //배터리 용량및수량
    @ExcelColumnInfo(notes = "비고")
    @ApiModelProperty(notes = "비고")
    private String nteCn;             //비고 

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

    public String getTpNm() {
        return tpNm;
    }

    public void setTpNm(String tpNm) {
        this.tpNm = tpNm;
    }

    public String getDelpCd() {
        return delpCd;
    }

    public void setDelpCd(String delpCd) {
        this.delpCd = delpCd;
    }

    public String getDelpNm() {
        return delpNm;
    }

    public void setDelpNm(String delpNm) {
        this.delpNm = delpNm;
    }

    public String getIstYm() {
        return istYm;
    }

    public void setIstYm(String istYm) {
        this.istYm = istYm;
    }

    public int getCntcCapa() {
        return cntcCapa;
    }

    public void setCntcCapa(int cntcCapa) {
        this.cntcCapa = cntcCapa;
    }

    public String getMakgYm() {
        return makgYm;
    }

    public void setMakgYm(String makgYm) {
        this.makgYm = makgYm;
    }

    public String getCapaQCn() {
        return capaQCn;
    }

    public void setCapaQCn(String capaQCn) {
        this.capaQCn = capaQCn;
    }

    public String getNteCn() {
        return nteCn;
    }

    public void setNteCn(String nteCn) {
        this.nteCn = nteCn;
    }
}
    
