/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GASR1000U0Out11VO.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인장조제관리 인장유형 통계정보조회  OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ga.sr.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GASR1000U0Out11VO {
	@ApiModelProperty(notes= "본점 인감유형 총합계")	
	private BigDecimal hoSalPcdCnt   ;  /*본점 인감유형 총합계*/
	@ApiModelProperty(notes= "지점 인감유형 총합계")	
	private BigDecimal brSalPcdCnt   ;  /*지점 인감유형 총합계*/
	@ApiModelProperty(notes= "본점 법인인감 합계")	
	private BigDecimal hoSalPcdACnt  ;  /*본점 법인인감 합계 */
	@ApiModelProperty(notes= "본점 사용인감 합계")	
	private BigDecimal hoSalPcdBCnt  ;  /*본점 사용인감 합계 */
	@ApiModelProperty(notes= "본점 직인 합계")	
	private BigDecimal hoSalPcdCCnt  ;  /*본점 직인 합계 */
	@ApiModelProperty(notes= "본점 계인 합계")	
	private BigDecimal hoSalPcdDCnt  ;  /*본점 계인 합계 */
	@ApiModelProperty(notes= "본점 사인 합계 ")	
	private BigDecimal hoSalPcdECnt  ;  /*본점 사인 합계 */
	@ApiModelProperty(notes= "지점 직인 합계")	
	private BigDecimal brSalPcdCCnt  ;  /*지점 직인 합계 */
	@ApiModelProperty(notes= "지점 계인 합계")	
	private BigDecimal brSalPcdDCnt  ;  /*지점 계인 합계 */
	
	public BigDecimal getHoSalPcdCnt() {
		return hoSalPcdCnt;
	}
	public void setHoSalPcdCnt(BigDecimal hoSalPcdCnt) {
		this.hoSalPcdCnt = hoSalPcdCnt;
	}
	public BigDecimal getBrSalPcdCnt() {
		return brSalPcdCnt;
	}
	public void setBrSalPcdCnt(BigDecimal brSalPcdCnt) {
		this.brSalPcdCnt = brSalPcdCnt;
	}
	public BigDecimal getHoSalPcdACnt() {
		return hoSalPcdACnt;
	}
	public void setHoSalPcdACnt(BigDecimal hoSalPcdACnt) {
		this.hoSalPcdACnt = hoSalPcdACnt;
	}
	public BigDecimal getHoSalPcdBCnt() {
		return hoSalPcdBCnt;
	}
	public void setHoSalPcdBCnt(BigDecimal hoSalPcdBCnt) {
		this.hoSalPcdBCnt = hoSalPcdBCnt;
	}
	public BigDecimal getHoSalPcdCCnt() {
		return hoSalPcdCCnt;
	}
	public void setHoSalPcdCCnt(BigDecimal hoSalPcdCCnt) {
		this.hoSalPcdCCnt = hoSalPcdCCnt;
	}
	public BigDecimal getHoSalPcdDCnt() {
		return hoSalPcdDCnt;
	}
	public void setHoSalPcdDCnt(BigDecimal hoSalPcdDCnt) {
		this.hoSalPcdDCnt = hoSalPcdDCnt;
	}
	public BigDecimal getHoSalPcdECnt() {
		return hoSalPcdECnt;
	}
	public void setHoSalPcdECnt(BigDecimal hoSalPcdECnt) {
		this.hoSalPcdECnt = hoSalPcdECnt;
	}
	public BigDecimal getBrSalPcdCCnt() {
		return brSalPcdCCnt;
	}
	public void setBrSalPcdCCnt(BigDecimal brSalPcdCCnt) {
		this.brSalPcdCCnt = brSalPcdCCnt;
	}
	public BigDecimal getBrSalPcdDCnt() {
		return brSalPcdDCnt;
	}
	public void setBrSalPcdDCnt(BigDecimal brSalPcdDCnt) {
		this.brSalPcdDCnt = brSalPcdDCnt;
	}
}
