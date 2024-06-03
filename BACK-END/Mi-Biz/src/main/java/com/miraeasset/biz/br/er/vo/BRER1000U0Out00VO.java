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
public class BRER1000U0Out00VO extends BaseVO {

    @ApiModelProperty(notes = "전체건수", example = "0")
    private BigDecimal alCnt; /* 전체건수 */
    @ApiModelProperty(notes = "순번", example = "0")
    private BigDecimal rnum; /* 순번            */
    @ExcelColumnInfo(notes = "조직코드")
    @ApiModelProperty(notes = "조직코드", required = true)
    private String orzCd;            // 조직코드
    @ExcelColumnInfo(notes = "조직명")
    @ApiModelProperty(notes = "조직명")
    private String orzNm;            // 지점명    
    @ExcelColumnInfo(notes = "구분명")
    @ApiModelProperty(notes = "구분명", required = true)
    private String tpNm;             // 구분명
    @ExcelColumnInfo(notes = "총개수")
    @ApiModelProperty(notes = "총개수")
    private int istQAll;            // 총개수
    @ExcelColumnInfo(notes = "창구")
    @ApiModelProperty(notes = "청구")
    private int istQ1 = 0;            // 설치수량1
    @ExcelColumnInfo(notes = "출입문")
    @ApiModelProperty(notes = "출입문")
    private int istQ2 = 0;            // 설치수량2
    @ExcelColumnInfo(notes = "서고")
    @ApiModelProperty(notes = "서고")
    private int istQ3 = 0;            // 설치수량3
    @ExcelColumnInfo(notes = "금고")
    @ApiModelProperty(notes = "금고")
    private int istQ4 = 0;            // 설치수량4
    @ExcelColumnInfo(notes = "기계실")
    @ApiModelProperty(notes = "기계실")
    private int istQ5 = 0;            // 설치수량5
    @ExcelColumnInfo(notes = "기타")
    @ApiModelProperty(notes = "기타")
    private int istQ6 = 0;            // 설치수량6/

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

    public int getIstQAll() {
        int istQAll = 0;
        istQAll += istQ1;
        istQAll += istQ2;
        istQAll += istQ3;
        istQAll += istQ4;
        istQAll += istQ5;
        istQAll += istQ6;
        return istQAll;
    }

    public void setIstQAll(int istQAll) {
        this.istQAll = istQAll;
    }

    public int getIstQ1() {
        return istQ1;
    }

    public void setIstQ1(int istQ1) {
        this.istQ1 = istQ1;
    }

    public int getIstQ2() {
        return istQ2;
    }

    public void setIstQ2(int istQ2) {
        this.istQ2 = istQ2;
    }

    public int getIstQ3() {
        return istQ3;
    }

    public void setIstQ3(int istQ3) {
        this.istQ3 = istQ3;
    }

    public int getIstQ4() {
        return istQ4;
    }

    public void setIstQ4(int istQ4) {
        this.istQ4 = istQ4;
    }

    public int getIstQ5() {
        return istQ5;
    }

    public void setIstQ5(int istQ5) {
        this.istQ5 = istQ5;
    }

    public int getIstQ6() {
        return istQ6;
    }

    public void setIstQ6(int istQ6) {
        this.istQ6 = istQ6;
    }
}
    
