/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: BM
*	03. 파    일   명	: GA01N507VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA01N507 인장승인관리_인감증명서잔고 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;


@Component
public class GA01N507VO extends BaseVO {

	@ApiModelProperty(notes= "인장유형코드")
	private String salPcd  ;  /*인장유형코드*/
	@ApiModelProperty(notes= "잔고수량")
	private BigDecimal balQ    ;  /*잔고수량    */

	
    public String toString() {
        return "GA01N507VO{" +
        		"salPcd      ='" + salPcd   + "'" +
        		"balQ    ='" + balQ + "'" +
                '}';    	
    }


	public String getSalPcd() {
		return salPcd;
	}


	public void setSalPcd(String salPcd) {
		this.salPcd = salPcd;
	}


	public BigDecimal getBalQ() {
		return balQ;
	}


	public void setBalQ(BigDecimal balQ) {
		this.balQ = balQ;
	}
    

	
	
}
