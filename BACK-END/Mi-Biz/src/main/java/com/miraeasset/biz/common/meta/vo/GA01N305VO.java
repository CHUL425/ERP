/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA01N305VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA01N305	RE100계약관리 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA01N305VO extends BaseVO {
	
	@ApiModelProperty(notes= "계약서관리번호")
	private String cnrtMtNo        	; /*계약서관리번호 */	    	
	
    @ApiModelProperty(notes= "거래처코드")
    private String delpCd            ; /*계약서관리번호              */

	@ApiModelProperty(notes= "업체명")
	private String delpNm                ; /*업체명*/
	
	@ApiModelProperty(notes= "계약용량")
	private BigDecimal cntcCapa     ; /*계약용량    */
	@ApiModelProperty(notes= "계약방법내용")
	private String cntcMthdCn   ; /*계약방법내용*/
	@ApiModelProperty(notes= "계약기준가")
	private BigDecimal cntcBpr      ; /*계약기준가  */
	@ApiModelProperty(notes= "계약시작일자")
	private String cntcStrtDt   ; /*계약시작일자*/
	@ApiModelProperty(notes= "계약종료일자")
	private String cntcEndDt    ; /*계약종료일자*/
	@ApiModelProperty(notes= "비고내용")
	private String nteCn        ; /*비고내용    */
	@ApiModelProperty(notes= "삭제여부")
	private String delYn        ; /*삭제여부    */
	

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
        return "GA01N305VO{" +
        		"cnrtMtNo    ='" + cnrtMtNo    + "'" +
        		"delpCd      ='" + delpCd      + "'" +
        		"cntcCapa    ='" + cntcCapa    + "'" +
        		"cntcBpr     ='" + cntcBpr     + "'" +
                '}';    	
    }

	public String getCnrtMtNo() {
		return cnrtMtNo;
	}

	public void setCnrtMtNo(String cnrtMtNo) {
		this.cnrtMtNo = cnrtMtNo;
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

	public BigDecimal getCntcCapa() {
		return cntcCapa;
	}

	public void setCntcCapa(BigDecimal cntcCapa) {
		this.cntcCapa = cntcCapa;
	}

	public String getCntcMthdCn() {
		return cntcMthdCn;
	}

	public void setCntcMthdCn(String cntcMthdCn) {
		this.cntcMthdCn = cntcMthdCn;
	}

	public BigDecimal getCntcBpr() {
		return cntcBpr;
	}

	public void setCntcBpr(BigDecimal cntcBpr) {
		this.cntcBpr = cntcBpr;
	}

	public String getCntcStrtDt() {
		return cntcStrtDt;
	}

	public void setCntcStrtDt(String cntcStrtDt) {
		this.cntcStrtDt = cntcStrtDt;
	}

	public String getCntcEndDt() {
		return cntcEndDt;
	}

	public void setCntcEndDt(String cntcEndDt) {
		this.cntcEndDt = cntcEndDt;
	}

	public String getNteCn() {
		return nteCn;
	}

	public void setNteCn(String nteCn) {
		this.nteCn = nteCn;
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
