package com.miraeasset.biz.common.aprv.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class Aprv00In02VO {

    @ApiModelProperty(notes= "결재상신조직코드")
    private String aprvWrrptOrzCd          ; /* 결재상신조직코드 */
	@ApiModelProperty(notes= "결재상신번호")
	private String aprvWrrptNo       ; /*결재상신번호 */
	@ApiModelProperty(notes= "결재순위")
	private String aprvRnk       ; /*결재순위 */
	@ApiModelProperty(notes= "결재상세순위")
	private String aprvDlRnk     ; /*결재상세순위 */	
	
	@ApiModelProperty(notes= "접수번호")
	private String rctNo             ; /*접수번호*/

    @ApiModelProperty(notes= "결재자사원번호")
    private String aprvEpno          ; /* 결재자사원번호 */
    
    @ApiModelProperty(notes= "결재반려구분코드")
    private String aprvRtrnTcd          ; /* 결재반려구분코드 */

    @ApiModelProperty(notes= "결재사유내용")
    private String aprvRsnCn          ; /* 결재사유내용 */
    
	@ApiModelProperty(notes= "결재유형코드")
	private String aprvPcd           ; /*결재유형코드 */    

	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}

	public void setAprvWrrptOrzCd(String aprvWrrptOrzCd) {
		this.aprvWrrptOrzCd = aprvWrrptOrzCd;
	}

	public String getAprvWrrptMtNo() {
		return aprvWrrptNo;
	}

	public void setAprvWrrptMtNo(String aprvWrrptNo) {
		this.aprvWrrptNo = aprvWrrptNo;
	}

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public String getAprvEpno() {
		return aprvEpno;
	}

	public void setAprvEpno(String aprvEpno) {
		this.aprvEpno = aprvEpno;
	}

	public String getAprvRtrnTcd() {
		return aprvRtrnTcd;
	}

	public void setAprvRtrnTcd(String aprvRtrnTcd) {
		this.aprvRtrnTcd = aprvRtrnTcd;
	}

	public String getAprvRsnCn() {
		return aprvRsnCn;
	}

	public void setAprvRsnCn(String aprvRsnCn) {
		this.aprvRsnCn = aprvRsnCn;
	}

	public String getAprvPcd() {
		return aprvPcd;
	}

	public void setAprvPcd(String aprvPcd) {
		this.aprvPcd = aprvPcd;
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

	
}
    
