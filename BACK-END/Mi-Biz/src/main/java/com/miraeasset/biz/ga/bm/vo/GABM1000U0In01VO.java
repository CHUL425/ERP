/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GACM1000U0In00VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 계약서관리 목록조회 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.bm.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GABM1000U0In01VO extends BaseVO {

    @ApiModelProperty(notes= "회계일자", required = true, example = "202306")
    private String actgDt;            // 회계일자
    
    @ApiModelProperty(notes= "소계정코드", required = true, example = "5270100101")
	private String sAcsjCd		  ; /* 소계정코드 */
    
    @ApiModelProperty(notes= "편성금액")
	private String bdgtFmtnA	  ; /* 편성금액 */ 
    
//    @ApiModelProperty(notes= "조작자사번")
//	private String optrId		;            // 조작자사번
//	@ApiModelProperty(notes= "조작채널코드")
//	private String oprtChnlCd	;            // 조작채널코드
//	@ApiModelProperty(notes= "조작조직코드")
//	private String oprtOrzCd	;            // 조작조직코드
//	@ApiModelProperty(notes= "조작IP주소")
//	private String oprtIpAdr	;            // 조작IP주소
	
	public String getActgDt() {
		return actgDt;
	}
	public void setActgDt(String actgDt) {
		this.actgDt = actgDt;
	}
	public String getsAcsjCd() {
		return sAcsjCd;
	}
	public void setsAcsjCd(String sAcsjCd) {
		this.sAcsjCd = sAcsjCd;
	}
	public String getBdgtFmtnA() {
		return bdgtFmtnA;
	}
	public void setBdgtFmtnA(String bdgtFmtnA) {
		this.bdgtFmtnA = bdgtFmtnA;
	}
//	public String getOptrId() {
//		return optrId;
//	}
//	public void setOptrId(String optrId) {
//		this.optrId = optrId;
//	}
//	public String getOprtChnlCd() {
//		return oprtChnlCd;
//	}
//	public void setOprtChnlCd(String oprtChnlCd) {
//		this.oprtChnlCd = oprtChnlCd;
//	}
//	public String getOprtOrzCd() {
//		return oprtOrzCd;
//	}
//	public void setOprtOrzCd(String oprtOrzCd) {
//		this.oprtOrzCd = oprtOrzCd;
//	}
//	public String getOprtIpAdr() {
//		return oprtIpAdr;
//	}
//	public void setOprtIpAdr(String oprtIpAdr) {
//		this.oprtIpAdr = oprtIpAdr;
//	}
    
}
    
