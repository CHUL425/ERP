package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N602InVO {
	
	@ApiModelProperty(notes= "결재선관리번호")
	private String aprvlMtNo		; /*결재선관리번호 */
	@ApiModelProperty(notes= "결재순위")
	private String aprvRnk			; /*결재순위 */
	@ApiModelProperty(notes= "결재단위구분코드")
	private String aprvUnitTcd		; /*결재단위구분코드 */
	@ApiModelProperty(notes= "결재단위인사직책코드 ")
	private String aprvUnitHrOsdtCd	; /*결재단위인사직책코드  */
	@ApiModelProperty(notes= "결재상신구분코드")
	private String aprvWrrptTcd		; /*결재상신구분코드 */
	@ApiModelProperty(notes= "결재단위그룹코드")
	private String aprvUnitGrpCd	; /*결재단위그룹코드 */
	@ApiModelProperty(notes= "결재단위상세값")
	private String aprvUnitDlVl		; /*결재단위상세값 */
	@ApiModelProperty(notes= "결재자유형코드")
	private String dcfcPcd			; /*결재자유형코드 */
	@ApiModelProperty(notes= "사용여부")
	private String useYn			; /*사용여부 */
	@ApiModelProperty(notes= "조작자")
	private String optrId			; /*조작자 */
	@ApiModelProperty(notes= "조작채널코드")
	private String oprtChnlCd		; /*조작채널코드 */
	@ApiModelProperty(notes= "조작조직코드")
	private String oprtOrzCd		; /*조작조직코드 */
	@ApiModelProperty(notes= "조작IP주소")
	private String oprtIpAdr		; /*조작IP주소 */
	@ApiModelProperty(notes= "조작일시")
	private String oprtDttm			; /*조작일시 */
	
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
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getOptrId() {
		return optrId;
	}
	public void setOptrId(String optrId) {
		this.optrId = optrId;
	}
	public String getOprtChnlCd() {
		return oprtChnlCd;
	}
	public void setOprtChnlCd(String oprtChnlCd) {
		this.oprtChnlCd = oprtChnlCd;
	}
	public String getOprtOrzCd() {
		return oprtOrzCd;
	}
	public void setOprtOrzCd(String oprtOrzCd) {
		this.oprtOrzCd = oprtOrzCd;
	}
	public String getOprtIpAdr() {
		return oprtIpAdr;
	}
	public void setOprtIpAdr(String oprtIpAdr) {
		this.oprtIpAdr = oprtIpAdr;
	}
	public String getOprtDttm() {
		return oprtDttm;
	}
	public void setOprtDttm(String oprtDttm) {
		this.oprtDttm = oprtDttm;
	}
	
}
