package com.miraeasset.biz.common.basic.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class BasicPost00Out01VO {

	@ApiModelProperty(notes= "우편번호")
	private String zpcd    ; /*우편번호*/              
	@ApiModelProperty(notes= "우편번호순번")
	private String zpcdSeq ; /*우편번호순번*/
	@ApiModelProperty(notes= "주소")
	private String adr     ; /*주소*/
	@ApiModelProperty(notes= "세부주소")
	private String dtlAdr  ; /*세부주소*/
	
	@ApiModelProperty(notes= "순번", example="0")          
	private BigDecimal rnum        ; /* 순번              */                                           
	@ApiModelProperty(notes= "전체건수", example="0")          
	private BigDecimal alCnt       ; /* 전체건수               */                                                                       
	
	
	
    @Override
    public String toString() {
        return  "  BasicPost00Out00VO{ "+
        		", zpcd           = '" + zpcd           + "'" +
        		", zpcdSeq        = '" + zpcdSeq            + "'" +
        		", adr            = '" + adr            + "'" +
        		", dtlAdr         = '" + dtlAdr            + "'" +
        		", rnum           = '" + rnum            + "'" +
        		", alCnt           = '" + alCnt            + "'" +
        		"}";
    }



	public String getZpcd() {
		return zpcd;
	}



	public void setZpcd(String zpcd) {
		this.zpcd = zpcd;
	}



	public String getZpcdSeq() {
		return zpcdSeq;
	}



	public void setZpcdSeq(String zpcdSeq) {
		this.zpcdSeq = zpcdSeq;
	}



	public String getAdr() {
		return adr;
	}



	public void setAdr(String adr) {
		this.adr = adr;
	}



	public String getDtlAdr() {
		return dtlAdr;
	}



	public void setDtlAdr(String dtlAdr) {
		this.dtlAdr = dtlAdr;
	}



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
    
    
    
    
		
}
