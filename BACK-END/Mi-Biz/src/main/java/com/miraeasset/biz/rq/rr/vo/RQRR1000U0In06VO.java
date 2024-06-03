/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: RQRR1000U0In06VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 렌탈신청 철회 Input
*	07. 주  요  사  항	: 
*******************************************************************************************************/

package com.miraeasset.biz.rq.rr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQRR1000U0In06VO {
	
    @ApiModelProperty(notes= "접수번호", required = true)
    private String rctNo;            // 접수번호

    @ApiModelProperty(notes= "철회사유내용")
    private String aprvRsnCn          ; /* 결재사유내용 */

    
    @ApiModelProperty(notes= "처리사원번호-철회요청자")
    private String prcEpno;            // 처리사번

    @ApiModelProperty(notes= "처리사원조직-철회요청자조직")
    private String prcOrzCd;            // 처리사번조직
    
    @Override
    public String toString() {
        return "RQRR1000U0In06VO{" +
        		"rctNo          ='" + rctNo        + "'" +
        		"aprvRsnCn      ='" + aprvRsnCn    + "'" +
        		"prcEpno        ='" + prcEpno      + "'" +
                '}';   	
    }

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public String getAprvRsnCn() {
		return aprvRsnCn;
	}

	public void setAprvRsnCn(String aprvRsnCn) {
		this.aprvRsnCn = aprvRsnCn;
	}

	public String getPrcEpno() {
		return prcEpno;
	}

	public void setPrcEpno(String prcEpno) {
		this.prcEpno = prcEpno;
	}

	public String getPrcOrzCd() {
		return prcOrzCd;
	}

	public void setPrcOrzCd(String prcOrzCd) {
		this.prcOrzCd = prcOrzCd;
	}	
	
}
