/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA09N606VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA09N606	결재정보 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N606VO extends BaseVO {

    @ApiModelProperty(notes= "결재상신관리번호", required = true)
    private String aprvWrrptMtNo        ; /*결재상신관리번호  */
    @ApiModelProperty(notes= "결재상신조직코", required = true)
    private String aprvWrrptOrzCd     ; /*결재상신조직코*/
    @ApiModelProperty(notes= "결재상태코드")
    private String aprvScd            ; /*결재상태코드  */
    @ApiModelProperty(notes= "상신사원번호")
    private String wrrptEpno          ; /*상신사원번호  */
    @ApiModelProperty(notes= "상신일자")
    private String wrrptDt            ; /*상신일자      */
    @ApiModelProperty(notes= "결재유형코드")
    private String aprvPcd            ; /*결재유형코드  */
//    @ApiModelProperty(notes= "조작자ID")
//    private String optrId             ; /*조작자ID      */
//    @ApiModelProperty(notes= "조작채널코드")
//    private String oprtChnlCd         ; /*조작채널코드  */
//    @ApiModelProperty(notes= "조작조직코드")
//    private String oprtOrzCd          ; /*조작조직코드  */
//    @ApiModelProperty(notes= "조작IP주소")
//    private String oprtIpAdr          ; /*조작IP주소    */
//    @ApiModelProperty(notes= "조작일시")
//    private String oprtDttm           ; /*조작일시      */
	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}
	public String getAprvWrrptMtNo() {
		return aprvWrrptMtNo;
	}
	public void setAprvWrrptMtNo(String aprvWrrptMtNo) {
		this.aprvWrrptMtNo = aprvWrrptMtNo;
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
	public String getWrrptEpno() {
		return wrrptEpno;
	}
	public void setWrrptEpno(String wrrptEpno) {
		this.wrrptEpno = wrrptEpno;
	}
	public String getWrrptDt() {
		return wrrptDt;
	}
	public void setWrrptDt(String wrrptDt) {
		this.wrrptDt = wrrptDt;
	}
	public String getAprvPcd() {
		return aprvPcd;
	}
	public void setAprvPcd(String aprvPcd) {
		this.aprvPcd = aprvPcd;
	}
//	public String getOptrId() {
//		return optrId;
//	}
//	public void setOptrId(String optrId) {
//		this.optrId = optrId;
//	}
//	public String getOprtChnlCd() {
//		return oprtChnlCd;
//	}
//	public void setOprtChnlCd(String oprtChnlCd) {
//		this.oprtChnlCd = oprtChnlCd;
//	}
//	public String getOprtOrzCd() {
//		return oprtOrzCd;
//	}
//	public void setOprtOrzCd(String oprtOrzCd) {
//		this.oprtOrzCd = oprtOrzCd;
//	}
//	public String getOprtIpAdr() {
//		return oprtIpAdr;
//	}
//	public void setOprtIpAdr(String oprtIpAdr) {
//		this.oprtIpAdr = oprtIpAdr;
//	}
//	public String getOprtDttm() {
//		return oprtDttm;
//	}
//	public void setOprtDttm(String oprtDttm) {
//		this.oprtDttm = oprtDttm;
//	}
    
    
    
}
