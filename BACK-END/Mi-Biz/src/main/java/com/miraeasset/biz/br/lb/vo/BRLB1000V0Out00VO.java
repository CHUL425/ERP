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
public class BRLB1000V0Out00VO {
    @ApiModelProperty(notes = "순번", example = "1")
    private BigDecimal rnum;
    @ApiModelProperty(notes = "총건수", example = "100")
    private BigDecimal alCnt;
    @ApiModelProperty(notes = "조직명", example = "삼성역WM")
    @ExcelColumnInfo(notes = "조직명")
    private String orzNm;
    @ApiModelProperty(notes = "임대인명", example = "")
    @ExcelColumnInfo(notes = "임대인명")
    private String lesorNm;
    //@ApiModelProperty(notes = "최초리스개시일자", example = "20180417")
    //@ExcelColumnInfo(notes = "최초리스개시일자")
    //private String fstLsOpDt;
    @ApiModelProperty(notes = "리스개시일자", example = "20250531")
    @ExcelColumnInfo(notes = "리스개시일자")
    private String lsOpDt;
    @ApiModelProperty(notes = "리스종료일자", example = "20250531")
    @ExcelColumnInfo(notes = "리스종료일자")
    private String lsEndDt;
    @ApiModelProperty(notes = "임차면적(평)", example = "301.83")
    @ExcelColumnInfo(notes = "임차면적(평)")
    private double leasAr2;
    @ApiModelProperty(notes = "전용면적(평)", example = "168.38")
    @ExcelColumnInfo(notes = "전용면적(평)")
    private double onlyAr2;
    @ApiModelProperty(notes = "임차보증금", example = "2000000000")
    @ExcelColumnInfo(notes = "임차보증금")
    private String leasGrtA;
    @ApiModelProperty(hidden = true)
    private String surtExpPyLsA;
    @ApiModelProperty(hidden = true)
    private String lsAVat;
    @ApiModelProperty(notes = "리스료", example = "23100000")
    @ExcelColumnInfo(notes ="리스료")
    private String lsA;
    @ApiModelProperty(notes = "평당 임차료", example = "23100000")
    @ExcelColumnInfo(notes ="평당 임차료")
    private String perpLeasA;
    @ApiModelProperty(notes = "월관리비", example = "10564050")
    @ExcelColumnInfo(notes = "월관리비")
    private String mnMcst;
    @ApiModelProperty(notes = "평당관리비", example = "10564050")
    @ExcelColumnInfo(notes = "평당관리비")
    private String perpMcst;
    @ApiModelProperty(notes = "렌트프리", example = "10564050")
    @ExcelColumnInfo(notes = "렌트프리")
    private String focLsTermMmcnt; 
    @ApiModelProperty(notes = "월 임차비용", example = "10564050")
    @ExcelColumnInfo(notes = "월 임차비용")
    private String monLeasA;
    @ApiModelProperty(notes = "연 임차비용", example = "10564050")
    @ExcelColumnInfo(notes = "연 임차비용")
    private String yLeasA;
    @ApiModelProperty(hidden = true)
    @ExcelColumnInfo(notes = "주소")
    private String adrEcpVl;
    @ApiModelProperty(notes = "중도해지가능여부")
    @ExcelColumnInfo(notes = "중도해지가능여부")
    private String mclcAblYn;
    @ApiModelProperty(notes = "중도해지통보개월수")
    @ExcelColumnInfo(notes = "중도해지통보개월수")
    private String mclcInfmMmcnt;
    @ApiModelProperty(hidden = true)
    @ExcelColumnInfo(notes = "채권보전")
    private String bdPrsvCdNm;
    @ApiModelProperty(hidden = true)
    @ExcelColumnInfo(notes = "채권보전율")
    private double bdPrsvR;
    @ApiModelProperty(notes = "파일번호")
    private String atcFileNo;
    @ApiModelProperty(notes = "계약건수")
    private int atcFileCnt = 0;
    @ApiModelProperty(notes = "특이사항")
    private String lsCntcCn;
    
    @ApiModelProperty(notes = "계약명", example = "삼성역WM")
    @ExcelColumnInfo(notes = "계약명")
    private String cntcNm;
    
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

    public String getOrzNm() {
        return orzNm;
    }

    public void setOrzNm(String orzNm) {
        this.orzNm = orzNm;
    }

    public String getCntcNm() {
        return cntcNm;
    }

    public void setCntcNm(String cntcNm) {
        this.cntcNm = cntcNm;
    }

    public String getLesorNm() {
        return lesorNm;
    }

    public void setLesorNm(String lesorNm) {
        this.lesorNm = lesorNm;
    }
    public String getLsEndDt() {
        return lsEndDt;
    }

    public void setLsEndDt(String lsEndDt) {
        this.lsEndDt = lsEndDt;
    }

    public double getLeasAr2() {
		return leasAr2;
	}

	public void setLeasAr2(double leasAr2) {
		this.leasAr2 = leasAr2;
	}

	public double getOnlyAr2() {
		return onlyAr2;
	}

	public void setOnlyAr2(double onlyAr2) {
		this.onlyAr2 = onlyAr2;
	}

	public String getLeasGrtA() {
        return leasGrtA;
    }

    public void setLeasGrtA(String leasGrtA) {
        this.leasGrtA = leasGrtA;
    }

    public String getSurtExpPyLsA() {
        return surtExpPyLsA;
    }

    public void setSurtExpPyLsA(String surtExpPyLsA) {
        this.surtExpPyLsA = surtExpPyLsA;
    }

    public String getLsAVat() {
        return lsAVat;
    }

    public void setLsAVat(String lsAVat) {
        this.lsAVat = lsAVat;
    }

    public String getLsA() {
        return lsA;
    }

    public void setLsA(String lsA) {
        this.lsA = lsA;
    }

    public String getMnMcst() {
        return mnMcst;
    }

    public void setMnMcst(String mnMcst) {
        this.mnMcst = mnMcst;
    }

    public String getAdrEcpVl() {
        return adrEcpVl;
    }

    public void setAdrEcpVl(String adrEcpVl) {
        this.adrEcpVl = adrEcpVl;
    }

    public String getMclcAblYn() {
        return mclcAblYn;
    }

    public void setMclcAblYn(String mclcAblYn) {
        this.mclcAblYn = mclcAblYn;
    }

    public String getMclcInfmMmcnt() {
        return mclcInfmMmcnt;
    }

    public void setMclcInfmMmcnt(String mclcInfmMmcnt) {
        this.mclcInfmMmcnt = mclcInfmMmcnt;
    }

    public String getBdPrsvCdNm() {
        return bdPrsvCdNm;
    }

    public void setBdPrsvCdNm(String bdPrsvCdNm) {
        this.bdPrsvCdNm = bdPrsvCdNm;
    }

    public double getBdPrsvR() {
        return bdPrsvR;
    }

    public void setBdPrsvR(double bdPrsvR) {
        this.bdPrsvR = bdPrsvR;
    }

    public String getAtcFileNo() {
        return atcFileNo;
    }

    public void setAtcFileNo(String atcFileNo) {
        this.atcFileNo = atcFileNo;
    }

    public int getAtcFileCnt() {
        return atcFileCnt;
    }

    public void setAtcFileCnt(int atcFileCnt) {
        this.atcFileCnt = atcFileCnt;
    }

	public String getPerpLeasA() {
		return perpLeasA;
	}

	public void setPerpLeasA(String perpLeasA) {
		this.perpLeasA = perpLeasA;
	}

	public String getPerpMcst() {
		return perpMcst;
	}

	public void setPerpMcst(String perpMcst) {
		this.perpMcst = perpMcst;
	}

	public String getMonLeasA() {
		return monLeasA;
	}

	public void setMonLeasA(String monLeasA) {
		this.monLeasA = monLeasA;
	}

	public String getyLeasA() {
		return yLeasA;
	}

	public void setyLeasA(String yLeasA) {
		this.yLeasA = yLeasA;
	}

	public String getLsOpDt() {
		return lsOpDt;
	}

	public void setLsOpDt(String lsOpDt) {
		this.lsOpDt = lsOpDt;
	}

	public String getLsCntcCn() {
		return lsCntcCn;
	}

	public void setLsCntcCn(String lsCntcCn) {
		this.lsCntcCn = lsCntcCn;
	}

	public String getFocLsTermMmcnt() {
		return focLsTermMmcnt;
	}

	public void setFocLsTermMmcnt(String focLsTermMmcnt) {
		this.focLsTermMmcnt = focLsTermMmcnt;
	}
	
}
