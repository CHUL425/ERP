/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SH
*	03. 파    일   명	: SHAN1000U0Out02VO.java
*	04. 작  성  일  자	: 2024.02.14
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 안전보건공지 삭제전 확인이력존재여부 조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.sh.an.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SHAN1000U0Out02VO extends BaseVO{
	
	@ApiModelProperty(notes= "작성일자")
	private String madeDt; 
	@ApiModelProperty(notes= "일련번호")
	private BigDecimal srno; 
	@ApiModelProperty(notes= "공지구분코드")
	private String cmklTcd; 
	@ApiModelProperty(notes= "확인이력존재여부")
	private String cfmtHstXistYn; 
	
	public BigDecimal getSrno() {
		return srno;
	}
	public void setSrno(BigDecimal srno) {
		this.srno = srno;
	}
	public String getMadeDt() {
		return madeDt;
	}
	public void setMadeDt(String madeDt) {
		this.madeDt = madeDt;
	}
	public String getCmklTcd() {
		return cmklTcd;
	}
	public void setCmklTcd(String cmklTcd) {
		this.cmklTcd = cmklTcd;
	}
	public String getCfmtHstXistYn() {
		return cfmtHstXistYn;
	}
	public void setCfmtHstXistYn(String cfmtHstXistYn) {
		this.cfmtHstXistYn = cfmtHstXistYn;
	}
}
