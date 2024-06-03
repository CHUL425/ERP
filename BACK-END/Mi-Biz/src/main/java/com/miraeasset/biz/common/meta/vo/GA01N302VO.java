/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA01N302VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA01N302	업체별메모 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA01N302VO extends BaseVO {
	
    @ApiModelProperty(notes= "거래처코드")
    private String delpCd            ; /*거래처코드              */
	@ApiModelProperty(notes= "업체명")
	private String delpNm                ; /*업체명*/     
	
    @ApiModelProperty(notes= "등록일련번호")
    private String regiSrno        ; /*등록일련번호*/
    @ApiModelProperty(notes= "등록사원번호")
    private String regiEpno        ; /*등록사원번호*/
    @ApiModelProperty(notes= "등록사원명")
    private String regiEpNm        ; /*등록사원명*/
	@ApiModelProperty(notes= "직위명")
	private String hrPstNm     ; /*직위명*/      

    @ApiModelProperty(notes= "등록일자")
    private String regiDt          ; /*등록일자    */
    @ApiModelProperty(notes= "메모내용")
    private String memoCn          ; /*메모내용    */
    @ApiModelProperty(notes= "삭제여부")
    private String delYn           ; /*삭제여부    */

    
//    @ApiModelProperty(notes= "조작자ID ")
//    private String optrId            ; /*조작자ID                */
//    @ApiModelProperty(notes= "조작채널코드")
//    private String oprtChnlCd        ; /*조작채널코드            */
//    @ApiModelProperty(notes= "조작조직코드")
//    private String oprtOrzCd         ; /*조작조직코드            */
//    @ApiModelProperty(notes= "조작IP주소")
//    private String oprtIpAdr         ; /*조작IP주소              */
//    @ApiModelProperty(notes= "조작일시")
//    private String oprtDttm          ; /*조작일시                */    

    @Override
    public String toString() {
        return "GA01N301VO{" +
        		"delpCd      ='" + delpCd     + "'" +
        		"regiSrno    ='" + regiSrno   + "'" +
        		"regiEpno    ='" + regiEpno   + "'" +
                '}';    	
    }

	public String getDelpCd() {
		return delpCd;
	}

	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}

	public String getDelpNm() {
		return delpNm;
	}

	public void setDelpNm(String delpNm) {
		this.delpNm = delpNm;
	}

	public String getRegiSrno() {
		return regiSrno;
	}

	public void setRegiSrno(String regiSrno) {
		this.regiSrno = regiSrno;
	}

	public String getRegiEpno() {
		return regiEpno;
	}

	public void setRegiEpno(String regiEpno) {
		this.regiEpno = regiEpno;
	}

	public String getRegiEpNm() {
		return regiEpNm;
	}

	public void setRegiEpNm(String regiEpNm) {
		this.regiEpNm = regiEpNm;
	}

	public String getHrPstNm() {
		return hrPstNm;
	}

	public void setHrPstNm(String hrPstNm) {
		this.hrPstNm = hrPstNm;
	}

	public String getRegiDt() {
		return regiDt;
	}

	public void setRegiDt(String regiDt) {
		this.regiDt = regiDt;
	}

	public String getMemoCn() {
		return memoCn;
	}

	public void setMemoCn(String memoCn) {
		this.memoCn = memoCn;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

//	public String getOptrId() {
//		return optrId;
//	}
//
//	public void setOptrId(String optrId) {
//		this.optrId = optrId;
//	}
//
//	public String getOprtChnlCd() {
//		return oprtChnlCd;
//	}
//
//	public void setOprtChnlCd(String oprtChnlCd) {
//		this.oprtChnlCd = oprtChnlCd;
//	}
//
//	public String getOprtOrzCd() {
//		return oprtOrzCd;
//	}
//
//	public void setOprtOrzCd(String oprtOrzCd) {
//		this.oprtOrzCd = oprtOrzCd;
//	}
//
//	public String getOprtIpAdr() {
//		return oprtIpAdr;
//	}
//
//	public void setOprtIpAdr(String oprtIpAdr) {
//		this.oprtIpAdr = oprtIpAdr;
//	}
//
//	public String getOprtDttm() {
//		return oprtDttm;
//	}
//
//	public void setOprtDttm(String oprtDttm) {
//		this.oprtDttm = oprtDttm;
//	}
    
}
