package com.miraeasset.biz.in.in.vo;


import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ININ1000V0Out04VO {
	
	@ApiModelProperty(notes = "전체건수", hidden = true)
	private BigDecimal alCnt			; /* 전체건수 */
	
	@ApiModelProperty(notes = "통합신청유형코드", hidden = true)
	private String unifRqsPcd			; /* 통합신청유형코드  */
	
	@ApiModelProperty(notes = "통합신청유형명", hidden = true)
	private String unifRqsPcdNm			; /* 통합신청유형명  */

	@ApiModelProperty(notes = "통합신청건수", hidden = true)
	private BigDecimal unifRqsCnt		; /* 통합신청건수 */

	public BigDecimal getAlCnt() {
		return alCnt;
	}

	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}

	public String getUnifRqsPcd() {
		return unifRqsPcd;
	}

	public void setUnifRqsPcd(String unifRqsPcd) {
		this.unifRqsPcd = unifRqsPcd;
	}

	public String getUnifRqsPcdNm() {
		return unifRqsPcdNm;
	}

	public void setUnifRqsPcdNm(String unifRqsPcdNm) {
		this.unifRqsPcdNm = unifRqsPcdNm;
	}

	public BigDecimal getUnifRqsCnt() {
		return unifRqsCnt;
	}

	public void setUnifRqsCnt(BigDecimal unifRqsCnt) {
		this.unifRqsCnt = unifRqsCnt;
	}
	
}