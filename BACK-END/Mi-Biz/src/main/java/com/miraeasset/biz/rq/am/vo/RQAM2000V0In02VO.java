package com.miraeasset.biz.rq.am.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQAM2000V0In02VO {

    @ApiModelProperty(notes= "결재상신조직코드")
    private String aprvWrrptOrzCd          ; /* 결재상신조직코드 */

	@ApiModelProperty(notes= "결재상신관리번호")
	private String aprvWrrptMtNo       ; /*결재상신번호 */

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

	public String getAprvWrrptMtNo() { return aprvWrrptMtNo; }
	public void setAprvWrrptMtNo(String aprvWrrptMtNo) { this.aprvWrrptMtNo = aprvWrrptMtNo; }

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
    
