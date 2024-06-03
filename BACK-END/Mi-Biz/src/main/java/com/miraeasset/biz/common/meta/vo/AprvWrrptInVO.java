/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: AprvWrrptInVO.java
*	04. 작  성  일  자	: 2023.09.12
*	05. 작   성   자	: JSS
*	06. 관 련 기 능	: GA09N606, GA09N607 결재선 생성 데이터 처리
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class AprvWrrptInVO {
	
	@ApiModelProperty(notes= "결재선 관리번호")
	private String aprvlMtNo;
	@ApiModelProperty(notes= "결재순위")
	private String aprvRnk        ; /*결재순위          */
	@ApiModelProperty(notes= "결재상신조직코드")
    private String aprvWrrptOrzCd ; /*결재상신조직코드  */
	@ApiModelProperty(notes= "결재상신구분코드")
    private String aprvWrrptTcd   ; /*결재상신구분코드  */
    @ApiModelProperty(notes= "결재반려구분코드")
    private String aprvRtrnTcd    ; /*결재반려구분코드  */
    @ApiModelProperty(notes= "결재자유형코드", example = "InputIO - 00:상신, 01:결재, 02:참조")
    private String dcfcPcd        ; /*결재자유형코드    */
    @ApiModelProperty(notes= "결재단위구분코드")
    private String aprvUnitTcd	  ; /* 결재단위구분코드 */
    @ApiModelProperty(notes= "결재단위그룹코드")
	private String aprvUnitGrpCd    ; /* 결재단위그룹코드    */
    @ApiModelProperty(notes= "결재단위인사직책코드")
    private String aprvUnitHrOsdtCd ; /* 결재단위인사직책코드 */
	@ApiModelProperty(notes= "결재단위상세값")
	private String aprvUnitDlVl     ; /* 결재단위상세값      */
	@ApiModelProperty(notes= "결재조직코드")
	private String aprvOrzCd      ; /*결재조직코드      */
	
	@ApiModelProperty(notes= "결재사원번호")
	private String aprvEpno       ; /*결재사원번호      */

	public String getAprvlMtNo() {
		return aprvlMtNo;
	}

	public void setAprvlMtNo(String aprvlMtNo) {
		this.aprvlMtNo = aprvlMtNo;
	}

	public String getAprvRnk() {
		return aprvRnk;
	}

	public void setAprvRnk(String aprvRnk) {
		this.aprvRnk = aprvRnk;
	}

	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}

	public void setAprvWrrptOrzCd(String aprvWrrptOrzCd) {
		this.aprvWrrptOrzCd = aprvWrrptOrzCd;
	}

	public String getAprvWrrptTcd() {
		return aprvWrrptTcd;
	}

	public void setAprvWrrptTcd(String aprvWrrptTcd) {
		this.aprvWrrptTcd = aprvWrrptTcd;
	}

	public String getAprvRtrnTcd() {
		return aprvRtrnTcd;
	}

	public void setAprvRtrnTcd(String aprvRtrnTcd) {
		this.aprvRtrnTcd = aprvRtrnTcd;
	}

	public String getDcfcPcd() {
		return dcfcPcd;
	}

	public void setDcfcPcd(String dcfcPcd) {
		this.dcfcPcd = dcfcPcd;
	}

	public String getAprvUnitTcd() {
		return aprvUnitTcd;
	}

	public void setAprvUnitTcd(String aprvUnitTcd) {
		this.aprvUnitTcd = aprvUnitTcd;
	}

	public String getAprvUnitGrpCd() {
		return aprvUnitGrpCd;
	}

	public void setAprvUnitGrpCd(String aprvUnitGrpCd) {
		this.aprvUnitGrpCd = aprvUnitGrpCd;
	}

	public String getAprvUnitHrOsdtCd() {
		return aprvUnitHrOsdtCd;
	}

	public void setAprvUnitHrOsdtCd(String aprvUnitHrOsdtCd) {
		this.aprvUnitHrOsdtCd = aprvUnitHrOsdtCd;
	}

	public String getAprvUnitDlVl() {
		return aprvUnitDlVl;
	}

	public void setAprvUnitDlVl(String aprvUnitDlVl) {
		this.aprvUnitDlVl = aprvUnitDlVl;
	}

	public String getAprvOrzCd() {
		return aprvOrzCd;
	}

	public void setAprvOrzCd(String aprvOrzCd) {
		this.aprvOrzCd = aprvOrzCd;
	}

	public String getAprvEpno() {
		return aprvEpno;
	}

	public void setAprvEpno(String aprvEpno) {
		this.aprvEpno = aprvEpno;
	}
	
}
