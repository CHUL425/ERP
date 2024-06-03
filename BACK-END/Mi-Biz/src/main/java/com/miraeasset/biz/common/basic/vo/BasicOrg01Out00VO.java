package com.miraeasset.biz.common.basic.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class BasicOrg01Out00VO {

    @ApiModelProperty(notes= "조직코드")
    private String orzCd         ; /* 조직코드           */
	@ApiModelProperty(notes= "조직명")
	private String orzNm          ; /* 조직명               */        

    @ApiModelProperty(notes= "사업자등록번호")
    private String blno          ; /* 사업자등록번호     */
    @ApiModelProperty(notes= "구사업자등록번호")
    private String bblno         ; /* 구사업자등록번호   */
    @ApiModelProperty(notes= "국가전화번호")
    private String ctno          ; /* 국가전화번호       */
    @ApiModelProperty(notes= "지역전화번호")
    private String rtn           ; /* 지역전화번호       */
    @ApiModelProperty(notes= "국전화번호")
    private String mtno          ; /* 국전화번호         */
    @ApiModelProperty(notes= "개별전화번호")
    private String itno          ; /* 개별전화번호       */
    @ApiModelProperty(notes= "팩스지역전화번호")
    private String faxRtn        ; /* 팩스지역전화번호   */
    @ApiModelProperty(notes= "팩스국전화번호")
    private String faxMtno       ; /* 팩스국전화번호     */
    @ApiModelProperty(notes= "팩스개별전화번호")
    private String faxItno       ; /* 팩스개별전화번호   */
    @ApiModelProperty(notes= "우편번호")
    private String zpcd          ; /* 우편번호           */
    @ApiModelProperty(notes= "주소")
    private String adr           ; /* 주소               */
    @ApiModelProperty(notes= "영문주소")
    private String engAdr        ; /* 영문주소           */
    @ApiModelProperty(notes= "인사최종수정일자")
    private String hrLstAltrDt   ; /* 인사최종수정일자   */
    @ApiModelProperty(notes= "인사반영일자")
    private String hrRflcDt      ; /* 인사반영일자       */
    
    @ApiModelProperty(notes= "조직약어명")
    private String orzAbrvNm  ; /*조직약어명     */
    @ApiModelProperty(notes= "조직영문명")
    private String orzEngNm   ; /*조직영문명     */
    @ApiModelProperty(notes= "상위조직코드")
    private String hrkOrzCd   ; /*상위조직코드   */
    @ApiModelProperty(notes= "본지점구분코드")
    private String hobrTcd    ; /*본지점구분코드 */
    @ApiModelProperty(notes= "조직레벨값")
    private String orzLevlVl  ; /*조직레벨값     */
    
    
	public String getOrzCd() {
		return orzCd;
	}
	public void setOrzCd(String orzCd) {
		this.orzCd = orzCd;
	}
	public String getBlno() {
		return blno;
	}
	public void setBlno(String blno) {
		this.blno = blno;
	}
	public String getBblno() {
		return bblno;
	}
	public void setBblno(String bblno) {
		this.bblno = bblno;
	}
	public String getCtno() {
		return ctno;
	}
	public void setCtno(String ctno) {
		this.ctno = ctno;
	}
	public String getRtn() {
		return rtn;
	}
	public void setRtn(String rtn) {
		this.rtn = rtn;
	}
	public String getMtno() {
		return mtno;
	}
	public void setMtno(String mtno) {
		this.mtno = mtno;
	}
	public String getItno() {
		return itno;
	}
	public void setItno(String itno) {
		this.itno = itno;
	}
	public String getFaxRtn() {
		return faxRtn;
	}
	public void setFaxRtn(String faxRtn) {
		this.faxRtn = faxRtn;
	}
	public String getFaxMtno() {
		return faxMtno;
	}
	public void setFaxMtno(String faxMtno) {
		this.faxMtno = faxMtno;
	}
	public String getFaxItno() {
		return faxItno;
	}
	public void setFaxItno(String faxItno) {
		this.faxItno = faxItno;
	}
	public String getZpcd() {
		return zpcd;
	}
	public void setZpcd(String zpcd) {
		this.zpcd = zpcd;
	}
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}
	public String getEngAdr() {
		return engAdr;
	}
	public void setEngAdr(String engAdr) {
		this.engAdr = engAdr;
	}
	public String getHrLstAltrDt() {
		return hrLstAltrDt;
	}
	public void setHrLstAltrDt(String hrLstAltrDt) {
		this.hrLstAltrDt = hrLstAltrDt;
	}
	public String getHrRflcDt() {
		return hrRflcDt;
	}
	public void setHrRflcDt(String hrRflcDt) {
		this.hrRflcDt = hrRflcDt;
	}
	public String getOrzNm() {
		return orzNm;
	}
	public void setOrzNm(String orzNm) {
		this.orzNm = orzNm;
	}
	public String getOrzAbrvNm() {
		return orzAbrvNm;
	}
	public void setOrzAbrvNm(String orzAbrvNm) {
		this.orzAbrvNm = orzAbrvNm;
	}
	public String getOrzEngNm() {
		return orzEngNm;
	}
	public void setOrzEngNm(String orzEngNm) {
		this.orzEngNm = orzEngNm;
	}
	public String getHrkOrzCd() {
		return hrkOrzCd;
	}
	public void setHrkOrzCd(String hrkOrzCd) {
		this.hrkOrzCd = hrkOrzCd;
	}
	public String getHobrTcd() {
		return hobrTcd;
	}
	public void setHobrTcd(String hobrTcd) {
		this.hobrTcd = hobrTcd;
	}
	public String getOrzLevlVl() {
		return orzLevlVl;
	}
	public void setOrzLevlVl(String orzLevlVl) {
		this.orzLevlVl = orzLevlVl;
	} 
	

}
