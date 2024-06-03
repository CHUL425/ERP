/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA09N602Vf01OutVO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA09N602	결재선관리내역조회 out
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N602Vf01OutVO {
	

	@ApiModelProperty(notes= "결재선관리번호")
	private String aprvlMtNo        ; /*결재선관리번호      */
	@ApiModelProperty(notes= "결재순위")
	private String aprvRnk          ; /*결재순위            */
	@ApiModelProperty(notes= "결재단위구분코드")
	private String aprvUnitTcd      ; /*결재단위구분코드    */
	@ApiModelProperty(notes= "결재단위그룹구분코드")
	private String aprvUnitGrpTcd   ; /*결재단위그룹구분코드*/
	@ApiModelProperty(notes= "결재단위인사직책코드 ")
	private String aprvUnitHrOsdtCd ; /*결재단위인사직책코드 */
	@ApiModelProperty(notes= "결재상신구분코드")
	private String aprvWrrptTcd     ; /*결재상신구분코드    */
	@ApiModelProperty(notes= "결재단위그룹코드")
	private String aprvUnitGrpCd    ; /*결재단위그룹코드    */
	@ApiModelProperty(notes= "결재단위상세값")
	private String aprvUnitDlVl     ; /*결재단위상세값      */
	@ApiModelProperty(notes= "결재자유형코드")
	private String dcfcPcd          ; /*결재자유형코드      */

	@ApiModelProperty(notes= "결재유형코드")
	private String aprvPcd     ;  /*결재유형코드*/     
	@ApiModelProperty(notes= "결재관리명")
	private String aprvlMtNm   ;  /*결재관리명*/
	@ApiModelProperty(notes= "결재최종순위")
	private String aprvLstRnk  ;  /*결재최종순위*/  
	@ApiModelProperty(notes= "결재자사원번호")
	private String dcfcEpno    ;  /*결재자사원번호*/
	
	

    @Override
    public String toString() {
        return "GA09N602Vf01OutVO{" +
        		"aprvlMtNo          ='" + aprvlMtNo        + "'" +
        		"aprvRnk          ='" + aprvRnk        + "'" +
        		"aprvWrrptTcd          ='" + aprvWrrptTcd        + "'" +
        		"dcfcEpno          ='" + dcfcEpno        + "'" +
        		        		
                '}';    	
    }

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

	public String getAprvUnitTcd() {
		return aprvUnitTcd;
	}

	public void setAprvUnitTcd(String aprvUnitTcd) {
		this.aprvUnitTcd = aprvUnitTcd;
	}

	public String getAprvUnitGrpTcd() {
		return aprvUnitGrpTcd;
	}

	public void setAprvUnitGrpTcd(String aprvUnitGrpTcd) {
		this.aprvUnitGrpTcd = aprvUnitGrpTcd;
	}

	public String getAprvUnitHrOsdtCd() {
		return aprvUnitHrOsdtCd;
	}

	public void setAprvUnitHrOsdtCd(String aprvUnitHrOsdtCd) {
		this.aprvUnitHrOsdtCd = aprvUnitHrOsdtCd;
	}

	public String getAprvWrrptTcd() {
		return aprvWrrptTcd;
	}

	public void setAprvWrrptTcd(String aprvWrrptTcd) {
		this.aprvWrrptTcd = aprvWrrptTcd;
	}

	public String getAprvUnitGrpCd() {
		return aprvUnitGrpCd;
	}

	public void setAprvUnitGrpCd(String aprvUnitGrpCd) {
		this.aprvUnitGrpCd = aprvUnitGrpCd;
	}

	public String getAprvUnitDlVl() {
		return aprvUnitDlVl;
	}

	public void setAprvUnitDlVl(String aprvUnitDlVl) {
		this.aprvUnitDlVl = aprvUnitDlVl;
	}

	public String getDcfcPcd() {
		return dcfcPcd;
	}

	public void setDcfcPcd(String dcfcPcd) {
		this.dcfcPcd = dcfcPcd;
	}

	public String getAprvPcd() {
		return aprvPcd;
	}

	public void setAprvPcd(String aprvPcd) {
		this.aprvPcd = aprvPcd;
	}

	public String getAprvlMtNm() {
		return aprvlMtNm;
	}

	public void setAprvlMtNm(String aprvlMtNm) {
		this.aprvlMtNm = aprvlMtNm;
	}

	public String getAprvLstRnk() {
		return aprvLstRnk;
	}

	public void setAprvLstRnk(String aprvLstRnk) {
		this.aprvLstRnk = aprvLstRnk;
	}

	public String getDcfcEpno() {
		return dcfcEpno;
	}

	public void setDcfcEpno(String dcfcEpno) {
		this.dcfcEpno = dcfcEpno;
	}        		
	
}
