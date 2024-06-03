package com.miraeasset.biz.ga.rm.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class GARM2010V0In01VO {

    @ApiModelProperty(notes= "정산년월", required = true, example="202306")
    private String exccYm;            // 정산년월
    
    @ApiModelProperty(notes= "컬러(추가)단가")
    private String colrUpr;           // 컬러단가 
    
    @ApiModelProperty(notes= "흑백(추가)단가")
    private String blakUpr;           // 흑백단가 
    
	public String getExccYm() {
		return exccYm;
	}
	public void setExccYm(String exccYm) {
		this.exccYm = exccYm;
	}
	public String getColrUpr() {
		return colrUpr;
	}
	public void setColrUpr(String colrUpr) {
		this.colrUpr = colrUpr;
	}
	public String getBlakUpr() {
		return blakUpr;
	}
	public void setBlakUpr(String blakUpr) {
		this.blakUpr = blakUpr;
	}
    
}
