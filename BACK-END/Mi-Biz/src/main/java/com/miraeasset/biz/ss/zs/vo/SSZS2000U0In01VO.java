/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSZS2000U0In01VO.java
*	04. 작  성  일  자	: 2023.10.16
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 알림관리 상세조회/삭제 in
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.zs.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SSZS2000U0In01VO {
	public SSZS2000U0In01VO() {};

	public SSZS2000U0In01VO(String iprtMsgCd) {
		this.iprtMsgCd = iprtMsgCd;
	}
	    
    @ApiModelProperty(notes= "알림메시지코드")
    private String iprtMsgCd             ;  /*알림메시지코드        */

	public String getIprtMsgCd() {
		return iprtMsgCd;
	}

	public void setIprtMsgCd(String iprtMsgCd) {
		this.iprtMsgCd = iprtMsgCd;
	}

    
}
