package com.miraeasset.biz.ga.vm.vo;

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
public class GAVM1000U0Out00VO {
	
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt;

	@ApiModelProperty(notes = "순번", example = "0")
	private BigDecimal rnum;
	
	@ExcelColumnInfo(notes= "차량번호")
    @ApiModelProperty(notes= "차량번호")
    private String vhcNo;
	
	@ExcelColumnInfo(notes = "차종")
    @ApiModelProperty(notes = "차종")
    private String vhcKndNm;
	
	@ExcelColumnInfo(notes = "이용자명")
    @ApiModelProperty(notes = "이용자명")
    private String userNm;
	
	
	@ApiModelProperty(notes = "조직코드")
    private String blngOrzCd;
    
    @ExcelColumnInfo(notes = "조직")
    @ApiModelProperty(notes = "조직명")
    private String blngOrzNm;
	
    @ExcelColumnInfo(notes = "직위")
    @ApiModelProperty(notes = "직위")
    private String pstNm;
    
    @ExcelColumnInfo(notes= "업체명")
	@ApiModelProperty(notes= "업체명")
	private String trOtptNm;
    
    @ExcelColumnInfo(notes = "지급일")
    @ApiModelProperty(notes = "지급일")
    private String lsOpDt;
    
    @ExcelColumnInfo(notes = "만기일")
    @ApiModelProperty(notes = "만기일")
    private String lsEndDt;
    
    @ExcelColumnInfo(notes = "렌트요금")
    @ApiModelProperty(notes = "렌트요금")
    private String surtExpPyLsA;
    
    @ExcelColumnInfo(notes = "주유카드")
    @ApiModelProperty(notes = "주유카드")
    private String reflCard;

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

	public String getVhcNo() {
		return vhcNo;
	}

	public void setVhcNo(String vhcNo) {
		this.vhcNo = vhcNo;
	}

	public String getVhcKndNm() {
		return vhcKndNm;
	}

	public void setVhcKndNm(String vhcKndNm) {
		this.vhcKndNm = vhcKndNm;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getBlngOrzCd() {
		return blngOrzCd;
	}

	public void setBlngOrzCd(String blngOrzCd) {
		this.blngOrzCd = blngOrzCd;
	}

	public String getBlngOrzNm() {
		return blngOrzNm;
	}

	public void setBlngOrzNm(String blngOrzNm) {
		this.blngOrzNm = blngOrzNm;
	}

	public String getPstNm() {
		return pstNm;
	}

	public void setPstNm(String pstNm) {
		this.pstNm = pstNm;
	}

	public String getTrOtptNm() {
		return trOtptNm;
	}

	public void setTrOtptNm(String trOtptNm) {
		this.trOtptNm = trOtptNm;
	}

	public String getLsOpDt() {
		return lsOpDt;
	}

	public void setLsOpDt(String lsOpDt) {
		this.lsOpDt = lsOpDt;
	}

	public String getLsEndDt() {
		return lsEndDt;
	}

	public void setLsEndDt(String lsEndDt) {
		this.lsEndDt = lsEndDt;
	}

	public String getSurtExpPyLsA() {
		return surtExpPyLsA;
	}

	public void setSurtExpPyLsA(String surtExpPyLsA) {
		this.surtExpPyLsA = surtExpPyLsA;
	}

	public String getReflCard() {
		return reflCard;
	}

	public void setReflCard(String reflCard) {
		this.reflCard = reflCard;
	}

	@Override
	public String toString() {
		return "GAVM1000U0Out00VO [alCnt=" + alCnt + ", vhcNo=" + vhcNo + ", vhcKndNm=" + vhcKndNm + ", userNm="
				+ userNm + ", blngOrzCd=" + blngOrzCd + ", blngOrzNm=" + blngOrzNm + ", pstNm=" + pstNm + ", trOtptNm="
				+ trOtptNm + ", lsOpDt=" + lsOpDt + ", lsEndDt=" + lsEndDt + ", surtExpPyLsA=" + surtExpPyLsA
				+ ", reflCard=" + reflCard + "]";
	}
    
}
