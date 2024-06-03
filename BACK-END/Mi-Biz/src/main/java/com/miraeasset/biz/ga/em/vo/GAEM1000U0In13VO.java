/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GAEM1000U0In13VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 업체관리 업체메모 신규등록 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.em.vo;

import com.miraeasset.biz.common.vo.BaseVO;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAEM1000U0In13VO extends BaseVO {

    @ApiModelProperty(notes= "거래처코드")
    private String delpCd            ; /*거래처코드              */
	
    @ApiModelProperty(notes= "등록사원번호")
    private String regiEpno        ; /*등록사원번호*/

    @ApiModelProperty(notes= "메모내용")
    private String memoCn          ; /*메모내용    */

	public String getDelpCd() {
		return delpCd;
	}
	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}
	public String getRegiEpno() {
		return regiEpno;
	}
	public void setRegiEpno(String regiEpno) {
		this.regiEpno = regiEpno;
	}
	public String getMemoCn() {
		return memoCn;
	}
	public void setMemoCn(String memoCn) {
		this.memoCn = memoCn;
	}
}

    
