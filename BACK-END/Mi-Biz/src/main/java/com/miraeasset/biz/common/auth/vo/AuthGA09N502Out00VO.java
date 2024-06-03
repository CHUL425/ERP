package com.miraeasset.biz.common.auth.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;


import io.swagger.annotations.ApiModelProperty;

@Component
public class AuthGA09N502Out00VO {
	
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt    	; /* 전체건수 */
	@ApiModelProperty(notes= "읽음건수")
	private BigDecimal readCnt    	; /* 읽음건수 */
	
	@ApiModelProperty(notes= "메시지발송일련번호")
	private String 	msgSndSrno		; /* 메시지발송일련번호 */
	@ApiModelProperty(notes= "알림메시지코드")
	private String 	iprtMsgCd		; /* 알림메시지코드 */
	@ApiModelProperty(notes= "메시지발송내용")
	private String msgSndCn 		; /* 메시지발송내용 */
	@ApiModelProperty(notes= "알림수신시간")
	private String iprtRvDttm		; /* 알림수신시간 */
	@ApiModelProperty(notes= "확인여부")
	private String cfmtYn			; /* 확인여부 */
	public BigDecimal getAlCnt() {
		return alCnt;
	}
	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}
	public BigDecimal getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(BigDecimal readCnt) {
		this.readCnt = readCnt;
	}
	public String getMsgSndSrno() {
		return msgSndSrno;
	}
	public void setMsgSndSrno(String msgSndSrno) {
		this.msgSndSrno = msgSndSrno;
	}
	public String getIprtMsgCd() {
		return iprtMsgCd;
	}
	public void setIprtMsgCd(String iprtMsgCd) {
		this.iprtMsgCd = iprtMsgCd;
	}
	public String getMsgSndCn() {
		return msgSndCn;
	}
	public void setMsgSndCn(String msgSndCn) {
		this.msgSndCn = msgSndCn;
	}
	public String getIprtRvDttm() {
		return iprtRvDttm;
	}
	public void setIprtRvDttm(String iprtRvDttm) {
		this.iprtRvDttm = iprtRvDttm;
	}
	public String getCfmtYn() {
		return cfmtYn;
	}
	public void setCfmtYn(String cfmtYn) {
		this.cfmtYn = cfmtYn;
	}
	
}
