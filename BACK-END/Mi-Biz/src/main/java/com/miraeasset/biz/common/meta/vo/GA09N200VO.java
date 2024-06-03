/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA09N200VO.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA09N200	사용자그룹 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N200VO extends BaseVO {
	
    @ApiModelProperty(notes= "사용자그룹코드")
    private String userGrpCd    ;  /*사용자그룹코드*/
    @ApiModelProperty(notes= "그룹명")
    private String grpNm        ;  /*그룹명        */
    @ApiModelProperty(notes= "사용자그룹설명")
    private String userGrpDesc  ;  /*사용자그룹설명*/
    @ApiModelProperty(notes= "사용여부")
    private String useYn        ;  /*사용여부      */
    
    
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

    
}
