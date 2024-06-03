/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA01C001VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA01C001	판관비계정과목관리 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA01C001VO extends BaseVO {
	
    
	@ApiModelProperty(notes= "계정과목코드")
	private String acsjCd ;  /*계정과목코드*/     
    
	@ApiModelProperty(notes= "프로젝트명")
	private String prjtNm ;  /*프로젝트명  */     

    @Override
    public String toString() {
        return "GA01C001VO{" +
        		"acsjCd    ='" + acsjCd   + "'" +
        		"prjtNm     ='" + prjtNm    + "'" +
                '}';    	
    }

	public String getAcsjCd() {
		return acsjCd;
	}

	public void setAcsjCd(String acsjCd) {
		this.acsjCd = acsjCd;
	}

	public String getPrjtNm() {
		return prjtNm;
	}

	public void setPrjtNm(String prjtNm) {
		this.prjtNm = prjtNm;
	}
		
}
