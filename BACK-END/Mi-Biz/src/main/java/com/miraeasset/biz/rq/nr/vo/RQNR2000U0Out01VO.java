package com.miraeasset.biz.rq.nr.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQNR2000U0Out01VO {
	
	@ApiModelProperty(notes= "임시저장건수")
	private BigDecimal rqsScd00Cnt      ; /* 임시저장건수 */	
	@ApiModelProperty(notes= "승인중건수")
	private BigDecimal rqsScd05Cnt      ; /* 승인중건수 */	
	@ApiModelProperty(notes= "승인완료건수")
	private BigDecimal rqsScd10Cnt      ; /* 승인완료건수 */
	@ApiModelProperty(notes= "메일전송완료건수")
	private BigDecimal rqsScd15Cnt      ;
	@ApiModelProperty(notes= "반려건수")
	private BigDecimal rqsScd30Cnt      ; 
	@ApiModelProperty(notes= "철회건수")
	private BigDecimal rqsScd35Cnt      ;	
	@ApiModelProperty(notes= "완료")
	private BigDecimal rqsScd99Cnt      ;
	
	public BigDecimal getRqsScd00Cnt() {
		return rqsScd00Cnt;
	}
	public void setRqsScd00Cnt(BigDecimal rqsScd00Cnt) {
		this.rqsScd00Cnt = rqsScd00Cnt;
	}
	public BigDecimal getRqsScd05Cnt() {
		return rqsScd05Cnt;
	}
	public void setRqsScd05Cnt(BigDecimal rqsScd05Cnt) {
		this.rqsScd05Cnt = rqsScd05Cnt;
	}
	public BigDecimal getRqsScd10Cnt() {
		return rqsScd10Cnt;
	}
	public void setRqsScd10Cnt(BigDecimal rqsScd10Cnt) {
		this.rqsScd10Cnt = rqsScd10Cnt;
	}
	public BigDecimal getRqsScd15Cnt() {
		return rqsScd15Cnt;
	}
	public void setRqsScd15Cnt(BigDecimal rqsScd15Cnt) {
		this.rqsScd15Cnt = rqsScd15Cnt;
	}
	public BigDecimal getRqsScd30Cnt() {
		return rqsScd30Cnt;
	}
	public void setRqsScd30Cnt(BigDecimal rqsScd30Cnt) {
		this.rqsScd30Cnt = rqsScd30Cnt;
	}
	public BigDecimal getRqsScd35Cnt() {
		return rqsScd35Cnt;
	}
	public void setRqsScd35Cnt(BigDecimal rqsScd35Cnt) {
		this.rqsScd35Cnt = rqsScd35Cnt;
	}
	public BigDecimal getRqsScd99Cnt() {
		return rqsScd99Cnt;
	}
	public void setRqsScd99Cnt(BigDecimal rqsScd99Cnt) {
		this.rqsScd99Cnt = rqsScd99Cnt;
	}	
}
