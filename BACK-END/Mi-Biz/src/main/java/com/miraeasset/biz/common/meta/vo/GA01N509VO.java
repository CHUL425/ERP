/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA01N509VO.java
*	04. 작  성  일  자	: 2023.11.21
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 인장조제관리_인장조제별기안문서
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;


@Component
public class GA01N509VO extends BaseVO {
	
	@ApiModelProperty(notes= "인장관리번호")
	private String salMtNo   ;  /*인장관리번호    */
	@ApiModelProperty(notes= "통합신청구분코드")
	private String unifRqsTcd   ;  /*통합신청구분코드    */
	@ApiModelProperty(notes= "기안문서번호")
	private String drftDocNo ;  /*기안문서번호*/
	
	public String getSalMtNo() {
		return salMtNo;
	}
	public void setSalMtNo(String salMtNo) {
		this.salMtNo = salMtNo;
	}
	public String getUnifRqsTcd() {
		return unifRqsTcd;
	}
	public void setUnifRqsTcd(String unifRqsTcd) {
		this.unifRqsTcd = unifRqsTcd;
	}
	public String getDrftDocNo() {
		return drftDocNo;
	}
	public void setDrftDocNo(String drftDocNo) {
		this.drftDocNo = drftDocNo;
	}
	
}
