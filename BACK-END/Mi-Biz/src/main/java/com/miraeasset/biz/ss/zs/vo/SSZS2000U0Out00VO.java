/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSZS2000U0In00VO.java
*	04. 작  성  일  자	: 2023.10.16
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 알림관리 목록조회 out
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.zs.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SSZS2000U0Out00VO {
	    
    @ApiModelProperty(notes= "알림메시지코드")
    private String iprtMsgCd             ;  /*알림메시지코드        */
    @ApiModelProperty(notes= "알림메시지제목명")
    private String iprtMsgTtlNm          ;  /*알림메시지제목명*/
    @ApiModelProperty(notes= "업무영역구분코드")
    private String bzAreaTcd             ;  /*업무영역구분코드      */
    @ApiModelProperty(notes= "업무영역구분코드명")
    private String bzAreaTcdNm           ;  /*업무영역구분코드명      */
    @ApiModelProperty(notes= "메시지발송내용")
    private String msgSndCn              ;  /*메시지발송내용        */
    @ApiModelProperty(notes= "사용여부")
    private String useYn                 ;  /*사용여부              */
    @ApiModelProperty(notes= "발송시분")
    private String sndHm                 ;  /*발송시분              */
    @ApiModelProperty(notes= "메시지발송매체구분코드")
    private String msgSndMdaTcd          ;  /*메시지발송매체구분코드*/
    @ApiModelProperty(notes= "메시지발송매체구분코드명")
    private String msgSndMdaTcdNm        ;  /*메시지발송매체구분코드명*/
    @ApiModelProperty(notes= "비고내용")
    private String nteCn                 ;  /*비고내용              */
    
	@ApiModelProperty(notes= "순번", example="0")
	private BigDecimal rnum       ; /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수             */
	
	public String getIprtMsgCd() {
		return iprtMsgCd;
	}
	public void setIprtMsgCd(String iprtMsgCd) {
		this.iprtMsgCd = iprtMsgCd;
	}
	public String getBzAreaTcd() {
		return bzAreaTcd;
	}
	public void setBzAreaTcd(String bzAreaTcd) {
		this.bzAreaTcd = bzAreaTcd;
	}
	public String getBzAreaTcdNm() {
		return bzAreaTcdNm;
	}
	public void setBzAreaTcdNm(String bzAreaTcdNm) {
		this.bzAreaTcdNm = bzAreaTcdNm;
	}
	public String getMsgSndCn() {
		return msgSndCn;
	}
	public void setMsgSndCn(String msgSndCn) {
		this.msgSndCn = msgSndCn;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getSndHm() {
		return sndHm;
	}
	public void setSndHm(String sndHm) {
		this.sndHm = sndHm;
	}
	public String getMsgSndMdaTcd() {
		return msgSndMdaTcd;
	}
	public void setMsgSndMdaTcd(String msgSndMdaTcd) {
		this.msgSndMdaTcd = msgSndMdaTcd;
	}
	public String getNteCn() {
		return nteCn;
	}
	public void setNteCn(String nteCn) {
		this.nteCn = nteCn;
	}
	public String getIprtMsgTtlNm() {
		return iprtMsgTtlNm;
	}
	public void setIprtMsgTtlNm(String iprtMsgTtlNm) {
		this.iprtMsgTtlNm = iprtMsgTtlNm;
	}
	public String getMsgSndMdaTcdNm() {
		return msgSndMdaTcdNm;
	}
	public void setMsgSndMdaTcdNm(String msgSndMdaTcdNm) {
		this.msgSndMdaTcdNm = msgSndMdaTcdNm;
	}
	public BigDecimal getRnum() {
		return rnum;
	}
	public void setRnum(BigDecimal rnum) {
		this.rnum = rnum;
	}
	public BigDecimal getAlCnt() {
		return alCnt;
	}
	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}
	

}
