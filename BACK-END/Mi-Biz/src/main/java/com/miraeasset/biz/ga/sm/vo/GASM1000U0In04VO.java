/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GASM1000U0In04VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: RE100계약관리 삭제수정(PK) IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.sm.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GASM1000U0In04VO {

	@ApiModelProperty(notes= "계약서관리번호")
	private String cnrtMtNo        	; /*계약서관리번호 */

    @ApiModelProperty(notes= "조작자ID ")
    private String optrId            ; /*조작자ID                */
    @ApiModelProperty(notes= "조작채널코드")
    private String oprtChnlCd        ; /*조작채널코드            */
    @ApiModelProperty(notes= "조작조직코드")
    private String oprtOrzCd         ; /*조작조직코드            */
    @ApiModelProperty(notes= "조작IP주소")
    private String oprtIpAdr         ; /*조작IP주소              */
    @ApiModelProperty(notes= "조작일시")
    private String oprtDttm          ; /*조작일시                */
	public String getCnrtMtNo() {
		return cnrtMtNo;
	}
	public void setCnrtMtNo(String cnrtMtNo) {
		this.cnrtMtNo = cnrtMtNo;
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

    
