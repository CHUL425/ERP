/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA09N602Vf01InVO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA09N602	결재선관리내역조회 in
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N602Vf01InVO extends BaseVO {
	
	@ApiModelProperty(notes= "화면번호")
	private String scrnNo           ; /*화면번호         */
	
	@ApiModelProperty(notes= "일련번호")
	private String srno             ; /*일련번호 구분 따른 화면 결재선 ex)1.본사, 2.지점, 3.그외 등등... */
	
	@ApiModelProperty(notes= "결재상신조직코드")
	private String aprvWrrptOrzCd        ; /*결재상신조직코드      */
	
	@ApiModelProperty(notes= "상신사원번호")
	private String wrrptEpno        ; /*상신사원번호      */
	
	/* 2023.08.25 */
	@ApiModelProperty(notes= "접수번호")
	private String rctNo        ; /*접수번호      */
	
	@ApiModelProperty(notes= "본지점구분")
	private String hobrTcd        ; /*본지점구분 */
	
	@ApiModelProperty(notes= "업무담당여부")
	private String bzChprYn    		; /* 업무담당여부 */
	
	@ApiModelProperty(notes= "업무권한여부")
	private String bzAuthYn    		; /* 업무권한여부 */
	
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	public String getHobrTcd() {
		return hobrTcd;
	}
	public void setHobrTcd(String hobrTcd) {
		this.hobrTcd = hobrTcd;
	}

	
	
	public String getScrnNo() {
		return scrnNo;
	}
	
	public void setScrnNo(String scrnNo) {
		this.scrnNo = scrnNo;
	}
	
	public String getSrno() {
		return srno;
	}

	public void setSrno(String srno) {
		this.srno = srno;
	}

	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}

	public void setAprvWrrptOrzCd(String aprvWrrptOrzCd) {
		this.aprvWrrptOrzCd = aprvWrrptOrzCd;
	}

	public String getWrrptEpno() {
		return wrrptEpno;
	}

	public void setWrrptEpno(String wrrptEpno) {
		this.wrrptEpno = wrrptEpno;
	}
	
	public String getBzChprYn() {
		return bzChprYn;
	}
	public void setBzChprYn(String bzChprYn) {
		this.bzChprYn = bzChprYn;
	}
	public String getBzAuthYn() {
		return bzAuthYn;
	}
	public void setBzAuthYn(String bzAuthYn) {
		this.bzAuthYn = bzAuthYn;
	}
	
}
