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
public class GARM1000V0Out02VO {
	
	@ApiModelProperty(notes= "총건수")
	private BigDecimal totCnt     ;    /* 총건수 */
	
	@ExcelColumnInfo(notes = "장비구분코드")
	@ApiModelProperty(notes= "장비구분코드")
    private String eqmtTcd        ;    /* 장비구분코드 */
	@ExcelColumnInfo(notes = "장비구분명")
	@ApiModelProperty(notes= "장비구분명")
    private String eqmtTcdNm      ;    /* 장비구분명 */
	
	@ExcelColumnInfo(notes = "조직코드")
    @ApiModelProperty(notes= "관리조직코드 ")
    private String mtOrzCd        ;    /* 관리조직코드  */
	@ExcelColumnInfo(notes = "조직명")
	@ApiModelProperty(notes= "조직명")
    private String OrzNm          ;    /* 조직명 */
	
	@ExcelColumnInfo(notes = "주문번호")
    @ApiModelProperty(notes= "임대계약번호")
	private String rentCntcNo     ;    /* 임대계약번호 */
	
	@ExcelColumnInfo(notes = "제품명")
    @ApiModelProperty(notes= "제품명")
    private String gdsNm          ;    /* 제품명 */
	
	@ExcelColumnInfo(notes = "1월")
    @ApiModelProperty(notes= "1월")
	private String janMlyRetc     ;    /* 1월 */
	@ExcelColumnInfo(notes = "2월")
	@ApiModelProperty(notes= "2월")
    private String febMlyRetc     ;    /* 2월 */
	@ExcelColumnInfo(notes = "3월")
	@ApiModelProperty(notes= "3월")
    private String machMlyRetc    ;    /* 3월 */
	@ExcelColumnInfo(notes = "4월")
    @ApiModelProperty(notes= "4월")
    private String aprMlyRetc     ;    /* 4월 */
	@ExcelColumnInfo(notes = "5월")
    @ApiModelProperty(notes= "5월")
    private String mayMlyRetc     ;    /* 5월 */
	@ExcelColumnInfo(notes = "6월")
    @ApiModelProperty(notes= "6월")
    private String juneMlyRetc    ;    /* 6월 */
	@ExcelColumnInfo(notes = "7월")
    @ApiModelProperty(notes= "7월")
    private String julyMlyRetc    ;    /* 7월 */
	@ExcelColumnInfo(notes = "8월")
    @ApiModelProperty(notes= "8월")
    private String augMlyRetc     ;    /* 8월 */
	@ExcelColumnInfo(notes = "9월")
    @ApiModelProperty(notes= "9월")
    private String sepMlyRetc     ;    /* 9월 */
	@ExcelColumnInfo(notes = "10월")
    @ApiModelProperty(notes= "10월")
    private String octMlyRetc     ;    /* 10월 */
	@ExcelColumnInfo(notes = "11월")
    @ApiModelProperty(notes= "11월")
    private String novMlyRetc     ;    /* 11월 */
	@ExcelColumnInfo(notes = "12월")
    @ApiModelProperty(notes= "12월")
    private String decMlyRetc     ;    /* 12월 */
    
	public BigDecimal getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(BigDecimal totCnt) {
		this.totCnt = totCnt;
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
	public String getMtOrzCd() {
		return mtOrzCd;
	}
	public void setMtOrzCd(String mtOrzCd) {
		this.mtOrzCd = mtOrzCd;
	}
	public String getOrzNm() {
		return OrzNm;
	}
	public void setOrzNm(String orzNm) {
		OrzNm = orzNm;
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
	public String getJanMlyRetc() {
		return janMlyRetc;
	}
	public void setJanMlyRetc(String janMlyRetc) {
		this.janMlyRetc = janMlyRetc;
	}
	public String getFebMlyRetc() {
		return febMlyRetc;
	}
	public void setFebMlyRetc(String febMlyRetc) {
		this.febMlyRetc = febMlyRetc;
	}
	public String getMachMlyRetc() {
		return machMlyRetc;
	}
	public void setMachMlyRetc(String machMlyRetc) {
		this.machMlyRetc = machMlyRetc;
	}
	public String getAprMlyRetc() {
		return aprMlyRetc;
	}
	public void setAprMlyRetc(String aprMlyRetc) {
		this.aprMlyRetc = aprMlyRetc;
	}
	public String getMayMlyRetc() {
		return mayMlyRetc;
	}
	public void setMayMlyRetc(String mayMlyRetc) {
		this.mayMlyRetc = mayMlyRetc;
	}
	public String getJuneMlyRetc() {
		return juneMlyRetc;
	}
	public void setJuneMlyRetc(String juneMlyRetc) {
		this.juneMlyRetc = juneMlyRetc;
	}
	public String getJulyMlyRetc() {
		return julyMlyRetc;
	}
	public void setJulyMlyRetc(String julyMlyRetc) {
		this.julyMlyRetc = julyMlyRetc;
	}
	public String getAugMlyRetc() {
		return augMlyRetc;
	}
	public void setAugMlyRetc(String augMlyRetc) {
		this.augMlyRetc = augMlyRetc;
	}
	public String getSepMlyRetc() {
		return sepMlyRetc;
	}
	public void setSepMlyRetc(String sepMlyRetc) {
		this.sepMlyRetc = sepMlyRetc;
	}
	public String getOctMlyRetc() {
		return octMlyRetc;
	}
	public void setOctMlyRetc(String octMlyRetc) {
		this.octMlyRetc = octMlyRetc;
	}
	public String getNovMlyRetc() {
		return novMlyRetc;
	}
	public void setNovMlyRetc(String novMlyRetc) {
		this.novMlyRetc = novMlyRetc;
	}
	public String getDecMlyRetc() {
		return decMlyRetc;
	}
	public void setDecMlyRetc(String decMlyRetc) {
		this.decMlyRetc = decMlyRetc;
	}
	
	@Override
	public String toString() {
		return "GARM1000V0Out02VO [totCnt=" + totCnt + ", eqmtTcd=" + eqmtTcd + ", eqmtTcdNm=" + eqmtTcdNm
				+ ", mtOrzCd=" + mtOrzCd + ", OrzNm=" + OrzNm + ", rentCntcNo=" + rentCntcNo + ", gdsNm=" + gdsNm
				+ ", janMlyRetc=" + janMlyRetc + ", febMlyRetc=" + febMlyRetc + ", machMlyRetc=" + machMlyRetc
				+ ", aprMlyRetc=" + aprMlyRetc + ", mayMlyRetc=" + mayMlyRetc + ", juneMlyRetc=" + juneMlyRetc
				+ ", julyMlyRetc=" + julyMlyRetc + ", augMlyRetc=" + augMlyRetc + ", sepMlyRetc=" + sepMlyRetc
				+ ", octMlyRetc=" + octMlyRetc + ", novMlyRetc=" + novMlyRetc + ", decMlyRetc=" + decMlyRetc + "]";
	}
    
}
