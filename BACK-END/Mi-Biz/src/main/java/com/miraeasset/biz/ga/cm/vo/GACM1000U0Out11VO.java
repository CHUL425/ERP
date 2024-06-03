/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GACM1000U0Out11VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 계약서관리 관련기안내역조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.cm.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GACM1000U0Out11VO {
	
	
    @ApiModelProperty(notes= "기안문서번호")
    private String drftDocNo        ; /*기안문서번호 */
    
    @ApiModelProperty(notes= "기안문서제목명")
    private String drftDocTtlNm     ; /*기안문서제목명 */

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
