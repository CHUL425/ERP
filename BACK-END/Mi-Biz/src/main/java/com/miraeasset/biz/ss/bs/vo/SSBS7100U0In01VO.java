/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS7100U0In01VO.java
*	04. 작  성  일  자	: 2023.09.27
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹_사용자관리 상세조회 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.bs.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SSBS7100U0In01VO {
	
    
    @ApiModelProperty(notes = "사용자그룹코드")
    private String userGrpCd     ;  /*사용자그룹코드*/      

    @ApiModelProperty(notes = "접수번호")
    private String rctNo         ;  /*접수번호 */

	public String getUserGrpCd() {
		return userGrpCd;
	}

	public void setUserGrpCd(String userGrpCd) {
		this.userGrpCd = userGrpCd;
	}

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
    
    

    
}

    
