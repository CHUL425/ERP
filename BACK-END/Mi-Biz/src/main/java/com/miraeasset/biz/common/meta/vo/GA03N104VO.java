/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA03N104VO.java
*	04. 작  성  일  자	: 2024.05.10
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 물품/명함신청 
*	07. 주  요  사  항	: 
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;


@Component
public class GA03N104VO extends BaseVO {
	
	@ApiModelProperty(notes= "접수번호")
	private String rctNo;
    @ApiModelProperty(notes = "입고조직코드")
	private String inqOrzCd;
	@ApiModelProperty(notes = "입고위치명")
	private String inqLocNm; 
	@ApiModelProperty(notes = "입고상세위치명")
	private String inqDlLocNm;
	
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	public String getInqOrzCd() {
		return inqOrzCd;
	}
	public void setInqOrzCd(String inqOrzCd) {
		this.inqOrzCd = inqOrzCd;
	}
	public String getInqLocNm() {
		return inqLocNm;
	}
	public void setInqLocNm(String inqLocNm) {
		this.inqLocNm = inqLocNm;
	}
	public String getInqDlLocNm() {
		return inqDlLocNm;
	}
	public void setInqDlLocNm(String inqDlLocNm) {
		this.inqDlLocNm = inqDlLocNm;
	}
	
	
}
