/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: BM
*	03. 파    일   명	: GA01N505InQ1VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA01N505 인장신청_인감증명서 인감기준 출고수 입력
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;


@Component
public class GA01N505InQ1VO extends BaseVO {

	@ApiModelProperty(notes= "접수번호")
	private String rctNo      ; /*접수번호    */
	@ApiModelProperty(notes= "접수상세번호")
	private String rctDlNo    ; /*접수상세번호*/

	@ApiModelProperty(notes= "인장관리번호")
	private String salMtNo    ; /*인장관리번호*/

	@ApiModelProperty(notes= "신청수량1", example="0")
	private BigDecimal rqsQ1  ; /*신청수량1   */

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public String getRctDlNo() {
		return rctDlNo;
	}

	public void setRctDlNo(String rctDlNo) {
		this.rctDlNo = rctDlNo;
	}

	public String getSalMtNo() {
		return salMtNo;
	}

	public void setSalMtNo(String salMtNo) {
		this.salMtNo = salMtNo;
	}

	public BigDecimal getRqsQ1() {
		return rqsQ1;
	}

	public void setRqsQ1(BigDecimal rqsQ1) {
		this.rqsQ1 = rqsQ1;
	}


	
}
