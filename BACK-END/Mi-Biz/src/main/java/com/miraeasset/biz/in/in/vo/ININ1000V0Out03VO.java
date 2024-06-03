package com.miraeasset.biz.in.in.vo;


import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ININ1000V0Out03VO {

	@ApiModelProperty(notes = "기준년월")
	private String basYm; /* 기준년월 */
	@ApiModelProperty(notes = "사옥임대수익")
	private BigDecimal OfcbldRentErn		; /* 사옥임대수익 */
	
	@ApiModelProperty(notes = "사옥임대비용")
	private BigDecimal OfcbldRentCt			;   /* 사옥임대비용 */
	
	@ApiModelProperty(notes = "전월사옥임대수익")
	private BigDecimal MnbfOfcbldRentErn	; /* 전월사옥임대수익 */
	
	@ApiModelProperty(notes = "전월사옥임대비용")
	private BigDecimal MnbfOfcbldRentCt		; /* 전월사옥임대비용 */

	public String getBasYm() {
		return basYm;
	}

	public void setBasYm(String basYm) {
		this.basYm = basYm;
	}

	public BigDecimal getOfcbldRentErn() {
		return OfcbldRentErn;
	}

	public void setOfcbldRentErn(BigDecimal ofcbldRentErn) {
		OfcbldRentErn = ofcbldRentErn;
	}

	public BigDecimal getOfcbldRentCt() {
		return OfcbldRentCt;
	}

	public void setOfcbldRentCt(BigDecimal ofcbldRentCt) {
		OfcbldRentCt = ofcbldRentCt;
	}

	public BigDecimal getMnbfOfcbldRentErn() {
		return MnbfOfcbldRentErn;
	}

	public void setMnbfOfcbldRentErn(BigDecimal mnbfOfcbldRentErn) {
		MnbfOfcbldRentErn = mnbfOfcbldRentErn;
	}

	public BigDecimal getMnbfOfcbldRentCt() {
		return MnbfOfcbldRentCt;
	}

	public void setMnbfOfcbldRentCt(BigDecimal mnbfOfcbldRentCt) {
		MnbfOfcbldRentCt = mnbfOfcbldRentCt;
	}
	
}