/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0Out25VO.java
*	04. 작  성  일  자	: 2023.12.15
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 출고 - 재출력/폐기 조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0Out25VO {
	
	@ApiModelProperty(notes= "접수번호")
	private String rctNo        ; 
	@ApiModelProperty(notes= "인감증명서구분코드")
	private String sealCtfwTcd        ; 
	@ApiModelProperty(notes= "인장관리번호")
	private String salMtNo        ; 
	@ApiModelProperty(notes= "발급증명서")
	private String salMtNm        ; 
	@ApiModelProperty(notes= "인감증명서신청시퀀스번호")
	private String sealCtfwRqsSqncNo     ; ; 
	
	@ApiModelProperty(notes= "재출력/폐기 다건내역")
	List<RQSR1000U0Out23VO> gridGA01N510ReOput;  
	
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	public String getSealCtfwTcd() {
		return sealCtfwTcd;
	}
	public void setSealCtfwTcd(String sealCtfwTcd) {
		this.sealCtfwTcd = sealCtfwTcd;
	}
	public String getSalMtNo() {
		return salMtNo;
	}
	public void setSalMtNo(String salMtNo) {
		this.salMtNo = salMtNo;
	}
	public String getSalMtNm() {
		return salMtNm;
	}
	public void setSalMtNm(String salMtNm) {
		this.salMtNm = salMtNm;
	}
	public List<RQSR1000U0Out23VO> getGridGA01N510ReOput() {
		return gridGA01N510ReOput;
	}
	public void setGridGA01N510ReOput(List<RQSR1000U0Out23VO> gridGA01N510ReOput) {
		this.gridGA01N510ReOput = gridGA01N510ReOput;
	}
	public String getSealCtfwRqsSqncNo() {
		return sealCtfwRqsSqncNo;
	}
	public void setSealCtfwRqsSqncNo(String sealCtfwRqsSqncNo) {
		this.sealCtfwRqsSqncNo = sealCtfwRqsSqncNo;
	}
	
}
