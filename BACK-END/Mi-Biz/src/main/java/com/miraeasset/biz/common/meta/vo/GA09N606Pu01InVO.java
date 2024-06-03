/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA09N606Pu01InVO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA09N606	결재정보 정보업데이트
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N606Pu01InVO extends BaseVO {

    @ApiModelProperty(notes= "결재상신관리번호", required = true)
    private String aprvWrrptMtNo    ; /*결재상신관리번호      */
    @ApiModelProperty(notes= "결재상신조직코드", required = true)
    private String aprvWrrptOrzCd ; /*결재상신조직코드  */
    @ApiModelProperty(notes= "결재상태코드", required = true)
    private String aprvScd ; /*결재상태코드  */
	public String getAprvWrrptMtNo() {
		return aprvWrrptMtNo;
	}
	public void setAprvWrrptMtNo(String aprvWrrptMtNo) {
		this.aprvWrrptMtNo = aprvWrrptMtNo;
	}
	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}
	public void setAprvWrrptOrzCd(String aprvWrrptOrzCd) {
		this.aprvWrrptOrzCd = aprvWrrptOrzCd;
	}
	public String getAprvScd() {
		return aprvScd;
	}
	public void setAprvScd(String aprvScd) {
		this.aprvScd = aprvScd;
	}
    

}
