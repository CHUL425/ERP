package com.miraeasset.biz.ga.rm.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GARM1000V0Out03VO {
	
	@ApiModelProperty(notes= "총건수")
	private BigDecimal totCnt     ;    /* 총건수 */
	
	@ApiModelProperty(notes= "1월")
	private String janMlyRetc     ;    /* 1월 */
    @ApiModelProperty(notes= "2월")
    private String febMlyRetc     ;    /* 2월 */
    @ApiModelProperty(notes= "3월")
    private String machMlyRetc    ;    /* 3월 */
    @ApiModelProperty(notes= "4월")
    private String aprMlyRetc     ;    /* 4월 */
    @ApiModelProperty(notes= "5월")
    private String mayMlyRetc     ;    /* 5월 */
    @ApiModelProperty(notes= "6월")
    private String juneMlyRetc    ;    /* 6월 */
    @ApiModelProperty(notes= "7월")
    private String julyMlyRetc    ;    /* 7월 */
    @ApiModelProperty(notes= "8월")
    private String augMlyRetc     ;    /* 8월 */
    @ApiModelProperty(notes= "9월")
    private String sepMlyRetc     ;    /* 9월 */
    @ApiModelProperty(notes= "10월")
    private String octMlyRetc     ;    /* 10월 */
    @ApiModelProperty(notes= "11월")
    private String novMlyRetc     ;    /* 11월 */
    @ApiModelProperty(notes= "12월")
    private String decMlyRetc     ;    /* 12월 */
    
	public BigDecimal getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(BigDecimal totCnt) {
		this.totCnt = totCnt;
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
		return "GARM1000V0Out03VO [totCnt=" + totCnt + ", janMlyRetc=" + janMlyRetc + ", febMlyRetc=" + febMlyRetc
				+ ", machMlyRetc=" + machMlyRetc + ", aprMlyRetc=" + aprMlyRetc + ", mayMlyRetc=" + mayMlyRetc
				+ ", juneMlyRetc=" + juneMlyRetc + ", julyMlyRetc=" + julyMlyRetc + ", augMlyRetc=" + augMlyRetc
				+ ", sepMlyRetc=" + sepMlyRetc + ", octMlyRetc=" + octMlyRetc + ", novMlyRetc=" + novMlyRetc
				+ ", decMlyRetc=" + decMlyRetc + "]";
	}
    
}
