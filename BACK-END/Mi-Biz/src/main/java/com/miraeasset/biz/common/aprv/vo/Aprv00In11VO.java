package com.miraeasset.biz.common.aprv.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class Aprv00In11VO {

    @ApiModelProperty(notes= "결재상신조직코드")
    private String aprvWrrptOrzCd          ; /* 결재상신조직코드 */

	@ApiModelProperty(notes= "결재상신번호")
	private String aprvWrrptNo       ; /*결재상신번호 */

	@ApiModelProperty(notes= "접수번호")
	private String rctNo             ; /*접수번호*/

	@ApiModelProperty(notes= "결재순위")
	private String aprvRnk       ; /*결재순위 */
	
	@ApiModelProperty(notes= "결재상세순위")
	private String aprvDlRnk     ; /*결재상세순위 */		
	
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
    
