/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA09N607VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA09N607	결재정보상세 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In11VO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N607InVO extends BaseVO {
	
	
	@ApiModelProperty(notes= "접수번호")
    private String rctNo              ; /*접수번호*/
	
	@ApiModelProperty(notes= "신청사원번호", hidden = true)
    private String rqsEpno            ; /*신청사원번호*/
	
	@ApiModelProperty(notes= "신청조직코드", hidden = true)
    private String rqsOrzCd           ; /*신청조직코드(상위 포함)*/
	
    @ApiModelProperty(notes= "결재유형코드")
    private String aprvPcd            ; /*결재유형코드  */

    @ApiModelProperty(notes = "결재선리스트")
    List<AprvWrrptInVO> aprvl;

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public String getRqsEpno() {
		return rqsEpno;
	}

	public void setRqsEpno(String rqsEpno) {
		this.rqsEpno = rqsEpno;
	}

	public String getRqsOrzCd() {
		return rqsOrzCd;
	}

	public void setRqsOrzCd(String rqsOrzCd) {
		this.rqsOrzCd = rqsOrzCd;
	}

	public String getAprvPcd() {
		return aprvPcd;
	}

	public void setAprvPcd(String aprvPcd) {
		this.aprvPcd = aprvPcd;
	}

	public List<AprvWrrptInVO> getAprvl() {
		return aprvl;
	}

	public void setAprvl(List<AprvWrrptInVO> aprvl) {
		this.aprvl = aprvl;
	}
}
