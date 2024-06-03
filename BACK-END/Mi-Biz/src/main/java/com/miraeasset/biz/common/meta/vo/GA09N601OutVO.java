package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N601OutVO {
	
	@ApiModelProperty(notes= "결재선관리번호")
	private String aprvlMtNo	; /*결재선관리번호 */
	@ApiModelProperty(notes= "결재선관리명")
	private String aprvlMtN		; /*결재선관리명 */
	@ApiModelProperty(notes= "결재최종순위")
	private String aprvLstRnk	; /*결재최종순위 */
	@ApiModelProperty(notes= "사용여부")
	private String useYn		; /*사용여부 */
	@ApiModelProperty(notes= "결재유형코드")
	private String aprvPcd		; /*결재유형코드 */
	
	public String getAprvlMtNo() {
		return aprvlMtNo;
	}
	public void setAprvlMtNo(String aprvlMtNo) {
		this.aprvlMtNo = aprvlMtNo;
	}
	public String getAprvlMtN() {
		return aprvlMtN;
	}
	public void setAprvlMtN(String aprvlMtN) {
		this.aprvlMtN = aprvlMtN;
	}
	public String getAprvLstRnk() {
		return aprvLstRnk;
	}
	public void setAprvLstRnk(String aprvLstRnk) {
		this.aprvLstRnk = aprvLstRnk;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getAprvPcd() {
		return aprvPcd;
	}
	public void setAprvPcd(String aprvPcd) {
		this.aprvPcd = aprvPcd;
	}
	
}
