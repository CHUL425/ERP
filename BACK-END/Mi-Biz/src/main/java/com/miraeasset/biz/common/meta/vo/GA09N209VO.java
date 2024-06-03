/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA09N209VO.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA09N209	화면_담당사원 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N209VO extends BaseVO {
	
    @ApiModelProperty(notes= "포털사이트메뉴ID")
    private String psitMenuId  ;  /*포털사이트메뉴ID*/

    @ApiModelProperty(notes= "화면담당자")
    private String epno ;  /*화면담당자    */
    
    @ApiModelProperty(notes= "정담당자여부 ")
    private String mchprYn ;  /*정담당자여부     */
        
	public String getPsitMenuId() {
		return psitMenuId;
	}

	public void setPsitMenuId(String psitMenuId) {
		this.psitMenuId = psitMenuId;
	}

	public String getEpno() {
		return epno;
	}

	public void setEpno(String epno) {
		this.epno = epno;
	}

	public String getMchprYn() {
		return mchprYn;
	}

	public void setMchprYn(String mchprYn) {
		this.mchprYn = mchprYn;
	}

	

}
