/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GAEM1000U0In14VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 업체관리 업체메모 삭제수정 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.em.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAEM1000U0In14VO {

    @ApiModelProperty(notes= "거래처코드")
    private String delpCd            ; /*거래처코드              */
    @ApiModelProperty(notes= "등록일련번호")
    private String regiSrno        ; /*등록일련번호*/
	
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
	public String getDelpCd() {
		return delpCd;
	}
	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}
	public String getRegiSrno() {
		return regiSrno;
	}
	public void setRegiSrno(String regiSrno) {
		this.regiSrno = regiSrno;
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

    
