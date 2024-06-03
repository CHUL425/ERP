/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0Out04VO.java
*	04. 작  성  일  자	: 2023.12.22
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 인감날인증명서신청 건수조회 OUT
*	07. 주  요  사  항	: 재사용후 조회
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.vo;

import org.springframework.stereotype.Component;
import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0Out05VO {

	@ApiModelProperty(notes= "인감날인 신청건수(일반,사용인감계)-백앤드용", example="0")
	private int salgRqsCnt           ; 
	
	@ApiModelProperty(notes= "인감증명서 신청건수-백앤드용", example="0")
	private int sealRqsCnt           ; 
	
	@ApiModelProperty(notes= "등기부등본 신청건수-백앤드용", example="0")
	private int ctfwRqsCnt           ;

	public int getSalgRqsCnt() {
		return salgRqsCnt;
	}

	public void setSalgRqsCnt(int salgRqsCnt) {
		this.salgRqsCnt = salgRqsCnt;
	}

	public int getSealRqsCnt() {
		return sealRqsCnt;
	}

	public void setSealRqsCnt(int sealRqsCnt) {
		this.sealRqsCnt = sealRqsCnt;
	}

	public int getCtfwRqsCnt() {
		return ctfwRqsCnt;
	}

	public void setCtfwRqsCnt(int ctfwRqsCnt) {
		this.ctfwRqsCnt = ctfwRqsCnt;
	}
}
