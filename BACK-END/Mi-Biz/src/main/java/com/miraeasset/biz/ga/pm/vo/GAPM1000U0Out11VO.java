/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GAPM1000U0Out11VO.java
*	04. 작  성  일  자	: 2023.07.03
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 정기주차권관리 주차대수요약정보 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ga.pm.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAPM1000U0Out11VO {
	
	@ApiModelProperty(notes= "무료주차대수")
	private BigDecimal freeParkCnt      ; /* 무료주차대수 */		   

	@ApiModelProperty(notes= "유료주차대수")
	private BigDecimal paidParkCnt      ; /* 유료주차대수 */
	
	@ApiModelProperty(notes= "전체주차대수")
	private BigDecimal allParkCnt      ; /* 전체주차대수 */
	
	@ApiModelProperty(notes= "무료사용대수")
	private BigDecimal freePsesCnt      ; /* 무료사용대수 */		   

	@ApiModelProperty(notes= "유료사용대수")
	private BigDecimal paidPsesCnt      ; /* 유료사용대수 */

	@ApiModelProperty(notes= "전체사용대수")
	private BigDecimal allPsesCnt      ; /* 전체사용대수 */
	
    @Override
    public String toString() {
        return "GAPM1000U0Out11VO{" +
        		"freeParkCnt   ='" + freeParkCnt + "'" +
        		"paidParkCnt   ='" + paidParkCnt + "'" +
        		"freePsesCnt   ='" + freePsesCnt + "'" +
        		"paidPsesCnt   ='" + paidPsesCnt + "'" +
        		"allParkCnt    ='" + allParkCnt  + "'" +
        		"allPsesCnt    ='" + allPsesCnt  + "'" +
                '}';    	
    }
	

	public BigDecimal getFreeParkCnt() {
		return freeParkCnt;
	}

	public void setFreeParkCnt(BigDecimal freeParkCnt) {
		this.freeParkCnt = freeParkCnt;
	}

	public BigDecimal getPaidParkCnt() {
		return paidParkCnt;
	}

	public void setPaidParkCnt(BigDecimal paidParkCnt) {
		this.paidParkCnt = paidParkCnt;
	}

	public BigDecimal getAllParkCnt() {
		return allParkCnt;
	}

	public void setAllParkCnt(BigDecimal allParkCnt) {
		this.allParkCnt = allParkCnt;
	}

	public BigDecimal getFreePsesCnt() {
		return freePsesCnt;
	}

	public void setFreePsesCnt(BigDecimal freePsesCnt) {
		this.freePsesCnt = freePsesCnt;
	}

	public BigDecimal getPaidPsesCnt() {
		return paidPsesCnt;
	}

	public void setPaidPsesCnt(BigDecimal paidPsesCnt) {
		this.paidPsesCnt = paidPsesCnt;
	}

	public BigDecimal getAllPsesCnt() {
		return allPsesCnt;
	}

	public void setAllPsesCnt(BigDecimal allPsesCnt) {
		this.allPsesCnt = allPsesCnt;
	}
	

}
