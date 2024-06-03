/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA09N607Pu01InVO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA09N607	결재정보상세 정보업데이트
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N607Pu01InVO extends BaseVO {

    @ApiModelProperty(notes= "결재상신구분코드")
    private String aprvWrrptTcd   ; /*결재상신구분코드  */
    @ApiModelProperty(notes= "결재반려구분코드")
    private String aprvRtrnTcd    ; /*결재반려구분코드  */
    @ApiModelProperty(notes= "결재일시")
    private String aprvDttm       ; /*결재일시          */
    @ApiModelProperty(notes= "결재사유내용")
    private String aprvRsnCn      ; /*결재사유내용      */
    @ApiModelProperty(notes= "대결여부")
    private String sbapYn         ; /*대결여부          */
    @ApiModelProperty(notes= "대결사원번호")
    private String sbapEpno       ; /*대결사원번호      */
    
    @ApiModelProperty(notes= "결재상신관리번호", required = true)
    private String aprvWrrptMtNo    ; /*결재상신관리번호      */
    @ApiModelProperty(notes= "결재상신조직코드", required = true)
    private String aprvWrrptOrzCd ; /*결재상신조직코드  */
    @ApiModelProperty(notes= "결재순위")
    private String aprvRnk        ; /*결재순위          */
    @ApiModelProperty(notes= "결재상세순위")
    private String aprvDlRnk      ; /*결재상세순위      */
    @ApiModelProperty(notes= "결재사원번호")
    private String aprvEpno     ; /*결재사원번호      */
    
    @ApiModelProperty(notes= "결재조직코드 ")
    private String aprvOrzCd     ; /* 결재조직코드  */
    
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
	public String getAprvDttm() {
		return aprvDttm;
	}
	public void setAprvDttm(String aprvDttm) {
		this.aprvDttm = aprvDttm;
	}
	public String getAprvRsnCn() {
		return aprvRsnCn;
	}
	public void setAprvRsnCn(String aprvRsnCn) {
		this.aprvRsnCn = aprvRsnCn;
	}
	public String getSbapYn() {
		return sbapYn;
	}
	public void setSbapYn(String sbapYn) {
		this.sbapYn = sbapYn;
	}
	public String getSbapEpno() {
		return sbapEpno;
	}
	public void setSbapEpno(String sbapEpno) {
		this.sbapEpno = sbapEpno;
	}
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
	public String getAprvRnk() {
		return aprvRnk;
	}
	public void setAprvRnk(String aprvRnk) {
		this.aprvRnk = aprvRnk;
	}
	public String getAprvDlRnk() {
		return aprvDlRnk;
	}
	public void setAprvDlRnk(String aprvDlRnk) {
		this.aprvDlRnk = aprvDlRnk;
	}
	public String getAprvEpno() {
		return aprvEpno;
	}
	public void setAprvEpno(String aprvEpno) {
		this.aprvEpno = aprvEpno;
	}
	public String getAprvOrzCd() {
		return aprvOrzCd;
	}
	public void setAprvOrzCd(String aprvOrzCd) {
		this.aprvOrzCd = aprvOrzCd;
	}
	
}
