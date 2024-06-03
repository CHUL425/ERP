/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0In24VO.java
*	04. 작  성  일  자	: 2023.12.14
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 출고 - 완료 IN
*	07. 주  요  사  항	: 
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.meta.vo.GA01N505OutQ2VO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0In25VO {

	@ApiModelProperty(notes= "접수번호", required = true)
	private String rctNo        ;
	
	@ApiModelProperty(notes= "인장신청_등기부등본 다건내역")
	List<GA01N505OutQ2VO> certDocGrid;

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public List<GA01N505OutQ2VO> getCertDocGrid() {
		return certDocGrid;
	}

	public void setCertDocGrid(List<GA01N505OutQ2VO> certDocGrid) {
		this.certDocGrid = certDocGrid;
	}
	
}

    
