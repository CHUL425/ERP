package com.miraeasset.biz.rq.am.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component 
public class RQAM2000V0In01VO {
	
    @ApiModelProperty(notes= "결재상신조직코드")
    private String aprvWrrptOrzCd    ; /* 결재상신조직코드 */
	@ApiModelProperty(notes= "결재상신관리번호")
	private String aprvWrrptMtNo       ; /*결재상신관리번호 */
	@ApiModelProperty(notes= "조회타입", example = " '':전체, rqsr:인감")
	private String selTyp;
	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}
	public void setAprvWrrptOrzCd(String aprvWrrptOrzCd) {
		this.aprvWrrptOrzCd = aprvWrrptOrzCd;
	}
	public String getAprvWrrptMtNo() {
		return aprvWrrptMtNo;
	}
	public void setAprvWrrptMtNo(String aprvWrrptMtNo) {
		this.aprvWrrptMtNo = aprvWrrptMtNo;
	}
	public String getSelTyp() {
		return selTyp;
	}
	public void setSelTyp(String selTyp) {
		this.selTyp = selTyp;
	}

}
