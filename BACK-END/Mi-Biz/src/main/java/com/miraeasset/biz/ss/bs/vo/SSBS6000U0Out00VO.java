/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: SSBS6000U0Out00VO.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹관리 목록조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.bs.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class SSBS6000U0Out00VO {
	
    @ApiModelProperty(notes= "사용자그룹코드")
    private String userGrpCd    ;  /*사용자그룹코드*/
    @ApiModelProperty(notes= "그룹명")
    private String grpNm        ;  /*그룹명        */
    @ApiModelProperty(notes= "사용자그룹설명")
    private String userGrpDesc  ;  /*사용자그룹설명*/
    @ApiModelProperty(notes= "사용여부")
    private String useYn        ;  /*사용여부      */

	@ApiModelProperty(notes= "순번", example="0")
	private BigDecimal rnum       ; /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수             */

	@Override
	public String toString() {
		return "SSBS6000V0Out00VO [userGrpCd=" + userGrpCd + ", grpNm=" + grpNm + ", userGrpDesc=" + userGrpDesc + ", useYn="
				+ useYn + "]";
	}

	public String getUserGrpCd() {
		return userGrpCd;
	}

	public void setUserGrpCd(String userGrpCd) {
		this.userGrpCd = userGrpCd;
	}

	public String getGrpNm() {
		return grpNm;
	}

	public void setGrpNm(String grpNm) {
		this.grpNm = grpNm;
	}

	public String getUserGrpDesc() {
		return userGrpDesc;
	}

	public void setUserGrpDesc(String userGrpDesc) {
		this.userGrpDesc = userGrpDesc;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public BigDecimal getRnum() {
		return rnum;
	}

	public void setRnum(BigDecimal rnum) {
		this.rnum = rnum;
	}

	public BigDecimal getAlCnt() {
		return alCnt;
	}

	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}


	
    
}
