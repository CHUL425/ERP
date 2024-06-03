/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: BM
*	03. 파    일   명	: GA01N508VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA01N508 인장승인관리_입고폐기관리 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;


@Component
public class GA01N508VO extends BaseVO {

	@ApiModelProperty(notes= "처리일자")
	private String prcDt       ;  /*처리일자      */
	@ApiModelProperty(notes= "일련번호")
	private BigDecimal srno    ;  /*일련번호      */
	@ApiModelProperty(notes= "입출고구분코드")
	private String ioqTcd      ;  /*입출고구분코드*/
	@ApiModelProperty(notes= "인감증명서대표1수량")
	private BigDecimal ioqQ1    ;  /*입출고수량1    */
	@ApiModelProperty(notes= "인감증명서대표2수량")
	private BigDecimal ioqQ2    ;  /*입출고수량2    */
	@ApiModelProperty(notes= "등기부등본수량")
	private BigDecimal ioqQ3    ;  /*입출고수량3    */
	
    public String toString() {
        return "GA01N508VO{" +
        		"prcDt      ='" + prcDt   + "'" +
        		"srno    ='" + srno + "'" +
        		"ioqTcd    ='" + ioqTcd + "'" +
        		"ioqQ1    ='" + ioqQ1 + "'" +
        		"ioqQ2    ='" + ioqQ2 + "'" +
        		"ioqQ3    ='" + ioqQ3 + "'" +
                '}';    	
    }

	public String getPrcDt() {
		return prcDt;
	}

	public void setPrcDt(String prcDt) {
		this.prcDt = prcDt;
	}

	public BigDecimal getSrno() {
		return srno;
	}

	public void setSrno(BigDecimal srno) {
		this.srno = srno;
	}

	public String getIoqTcd() {
		return ioqTcd;
	}

	public void setIoqTcd(String ioqTcd) {
		this.ioqTcd = ioqTcd;
	}

	public BigDecimal getIoqQ1() {
		return ioqQ1;
	}

	public void setIoqQ1(BigDecimal ioqQ1) {
		this.ioqQ1 = ioqQ1;
	}

	public BigDecimal getIoqQ2() {
		return ioqQ2;
	}

	public void setIoqQ2(BigDecimal ioqQ2) {
		this.ioqQ2 = ioqQ2;
	}

	public BigDecimal getIoqQ3() {
		return ioqQ3;
	}

	public void setIoqQ3(BigDecimal ioqQ3) {
		this.ioqQ3 = ioqQ3;
	}


}
