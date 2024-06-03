/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA09N501VO.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA09N501	알림관리_메시지관리 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N501VO extends BaseVO {
	
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

    public String toString() {
        return "GA09N501VO{" +
        		"iprtMsgCd" + iprtMsgCd   + "'" +
        		"iprtMsgTtlNm    ='" + iprtMsgTtlNm + "'" +
        		"bzAreaTcd    ='" + bzAreaTcd + "'" +
        		"msgSndCn    ='" + msgSndCn + "'" +
        		"useYn    ='" + useYn + "'" +
        		"msgSndMdaTcd    ='" + msgSndMdaTcd + "'" +
        		"nteCn    ='" + nteCn + "'" +
                '}';    	
    }
	
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

    

    
}
