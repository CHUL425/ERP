/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0Out11VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인감날인증명서신청상태 요약정보 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.rq.sr.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0Out11VO {
	
	@ApiModelProperty(notes= "임시저장건수")
	private BigDecimal rqsScd00Cnt      ; /* 임시저장건수 */	
	@ApiModelProperty(notes= "승인중건수")
	private BigDecimal rqsScd05Cnt      ; /* 승인중건수 */	
	@ApiModelProperty(notes= "승인완료건수")
	private BigDecimal rqsScd10Cnt      ; /* 승인완료건수 */	
	@ApiModelProperty(notes= "반려건수")
	private BigDecimal rqsScd30Cnt      ; /* 반려건수 */	
	@ApiModelProperty(notes= "사용처제출건수")
	private BigDecimal rqsScd90Cnt      ; /* 사용처제출건수 */
	@ApiModelProperty(notes= "원본폐기건수")
	private BigDecimal rqsScd91Cnt      ; /* 원본폐기건수 */
	@ApiModelProperty(notes= "처리완료건수")
	private BigDecimal rqsScd40Cnt      ; /* 처리완료건수 */
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
	public BigDecimal getRqsScd30Cnt() {
		return rqsScd30Cnt;
	}
	public void setRqsScd30Cnt(BigDecimal rqsScd30Cnt) {
		this.rqsScd30Cnt = rqsScd30Cnt;
	}
	public BigDecimal getRqsScd90Cnt() {
		return rqsScd90Cnt;
	}
	public void setRqsScd90Cnt(BigDecimal rqsScd90Cnt) {
		this.rqsScd90Cnt = rqsScd90Cnt;
	}
	public BigDecimal getRqsScd91Cnt() {
		return rqsScd91Cnt;
	}
	public void setRqsScd91Cnt(BigDecimal rqsScd91Cnt) {
		this.rqsScd91Cnt = rqsScd91Cnt;
	}
	public BigDecimal getRqsScd40Cnt() {
		return rqsScd40Cnt;
	}
	public void setRqsScd40Cnt(BigDecimal rqsScd40Cnt) {
		this.rqsScd40Cnt = rqsScd40Cnt;
	}
	
}
