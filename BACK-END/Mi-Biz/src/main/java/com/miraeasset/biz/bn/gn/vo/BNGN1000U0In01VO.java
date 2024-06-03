/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: BN
*	03. 파    일   명	: BNGN1000U0In00VO.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 총무공지 상세조회 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.bn.gn.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;

import io.swagger.annotations.ApiModelProperty;

@Component
public class BNGN1000U0In01VO {

	@ApiModelProperty(notes= "작성일자", required = true)
	private String madeDt           ; /*작성일자            */
	@ApiModelProperty(notes= "일련번호", required = true, example="0")
	private BigDecimal srno             ; /*일련번호            */
	public String getMadeDt() {
		return madeDt;
	}
	public void setMadeDt(String madeDt) {
		this.madeDt = madeDt;
	}
	public BigDecimal getSrno() {
		return srno;
	}
	public void setSrno(BigDecimal srno) {
		this.srno = srno;
	}
}

    
