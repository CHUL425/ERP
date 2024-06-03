/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: AT09N401VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: AT09N401	기안문서 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class AT09N401VO {
	
    @ApiModelProperty(notes= "기안문서번호")
    private String drftDocNo       ; /*기안문서번호          */
    
    @ApiModelProperty(notes= "기안문서제목명")
    private String drftDocTtlNm    ; /*기안문서제목명        */
    @ApiModelProperty(notes= "결재여부")
    private String aprvYn          ; /*결재여부              */
    @ApiModelProperty(notes= "문서번호명")
    private String docNoNm         ; /*문서번호명            */
    @ApiModelProperty(notes= "결재일시")
    private String aprvDttm        ; /*결재일시              */
    @ApiModelProperty(notes= "등록사원번호")
    private String regiEpno        ; /*등록사원번호          */
    @ApiModelProperty(notes= "등록조직코드")
    private String regiOrzCd       ; /*등록조직코드          */
    @ApiModelProperty(notes= "등록일시")
    private String regiDttm        ; /*등록일시              */
    @ApiModelProperty(notes= "결의건수")
    private String rslnCnt         ; /*결의건수              */
    @ApiModelProperty(notes= "취소여부")
    private String cnclYn          ; /*취소여부              */
    @ApiModelProperty(notes= "취소일자")
    private String cnclDt          ; /*취소일자              */
    @ApiModelProperty(notes= "취소사유내용")
    private String cnclRsnCn       ; /*취소사유내용          */
    @ApiModelProperty(notes= "직전기안문서번호")
    private String jbfDrftDocNo    ; /*직전기안문서번호      */
    @ApiModelProperty(notes= "조작자ID")
    private String optrId          ; /*조작자ID              */
    @ApiModelProperty(notes= "조작채널코드")
    private String oprtChnlCd      ; /*조작채널코드          */
    @ApiModelProperty(notes= "조작조직코드")
    private String oprtOrzCd       ; /*조작조직코드          */
    @ApiModelProperty(notes= "조작IP주소")
    private String oprtIpAdr       ; /*조작IP주소            */
    @ApiModelProperty(notes= "조작일시")
    private String oprtDttm        ; /*조작일시              */
    @ApiModelProperty(notes= "기안문서송수신구분코드")
    private String drftDocSnrTcd   ; /*기안문서송수신구분코드*/
    
    @Override
    public String toString() {
        return "AT09N401VO{" +
        		"drftDocNo      ='" + drftDocNo     + "'" +
        		"drftDocTtlNm   ='" + drftDocTtlNm  + "'" +
                '}';    	
    }

	public String getDrftDocNo() {
		return drftDocNo;
	}

	public void setDrftDocNo(String drftDocNo) {
		this.drftDocNo = drftDocNo;
	}

	public String getDrftDocTtlNm() {
		return drftDocTtlNm;
	}

	public void setDrftDocTtlNm(String drftDocTtlNm) {
		this.drftDocTtlNm = drftDocTtlNm;
	}

	public String getAprvYn() {
		return aprvYn;
	}

	public void setAprvYn(String aprvYn) {
		this.aprvYn = aprvYn;
	}

	public String getDocNoNm() {
		return docNoNm;
	}

	public void setDocNoNm(String docNoNm) {
		this.docNoNm = docNoNm;
	}

	public String getAprvDttm() {
		return aprvDttm;
	}

	public void setAprvDttm(String aprvDttm) {
		this.aprvDttm = aprvDttm;
	}

	public String getRegiEpno() {
		return regiEpno;
	}

	public void setRegiEpno(String regiEpno) {
		this.regiEpno = regiEpno;
	}

	public String getRegiOrzCd() {
		return regiOrzCd;
	}

	public void setRegiOrzCd(String regiOrzCd) {
		this.regiOrzCd = regiOrzCd;
	}

	public String getRegiDttm() {
		return regiDttm;
	}

	public void setRegiDttm(String regiDttm) {
		this.regiDttm = regiDttm;
	}

	public String getRslnCnt() {
		return rslnCnt;
	}

	public void setRslnCnt(String rslnCnt) {
		this.rslnCnt = rslnCnt;
	}

	public String getCnclYn() {
		return cnclYn;
	}

	public void setCnclYn(String cnclYn) {
		this.cnclYn = cnclYn;
	}

	public String getCnclDt() {
		return cnclDt;
	}

	public void setCnclDt(String cnclDt) {
		this.cnclDt = cnclDt;
	}

	public String getCnclRsnCn() {
		return cnclRsnCn;
	}

	public void setCnclRsnCn(String cnclRsnCn) {
		this.cnclRsnCn = cnclRsnCn;
	}

	public String getJbfDrftDocNo() {
		return jbfDrftDocNo;
	}

	public void setJbfDrftDocNo(String jbfDrftDocNo) {
		this.jbfDrftDocNo = jbfDrftDocNo;
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

	public String getDrftDocSnrTcd() {
		return drftDocSnrTcd;
	}

	public void setDrftDocSnrTcd(String drftDocSnrTcd) {
		this.drftDocSnrTcd = drftDocSnrTcd;
	}
    
    
		
}
