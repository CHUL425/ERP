/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA01N109VO.java
*	04. 작  성  일  자	: 2023.08.29
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA01N109	통합신청_신청별기안문서 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA01N109VO extends BaseVO {

    @ApiModelProperty(notes= "접수번호", required = true)
    private String rctNo;            // 접수번호

    @ApiModelProperty(notes= "기안문서번호" )
    private String drftDocNo;        // 기안문서번호
    
    @ApiModelProperty(notes= "기안문서명" )
    private String drftDocTtlNm;     // 기안문서명
    
    @Override
    public String toString() {
        return "GA01N109VO{" +
                "rctNo       = '" + rctNo        + "'"+
                "drftDocNo     = '" + drftDocNo      + "'"+
                '}';    	
    }

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public String getDrftDocNo() {
		return drftDocNo;
	}

	public void setDrftDocNo(String drftDocNo) {
		this.drftDocNo = drftDocNo;
	}

	public String getDrftDocTtlNm() {
		return drftDocTtlNm;
	}

	public void setDrftDocTtlNm(String drftDocTtlNm) {
		this.drftDocTtlNm = drftDocTtlNm;
	}

}
