package com.miraeasset.biz.common.basic.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class BasicOrg00Out00VO {

	@ApiModelProperty(notes= "조직코드", required = true, example ="000000")
	private String orzCd          ; /* 조직코드             */        
	@ApiModelProperty(notes= "조직명")
	private String orzNm          ; /* 조직명               */        
	@ApiModelProperty(notes= "조직약어명")
	private String orzAbrvNm      ; /* 조직약어명           */        
	@ApiModelProperty(notes= "조직영문명")
	private String orzEngNm       ; /* 조직영문명           */   
	@ApiModelProperty(notes= "상위조직코드")
	private String hrkOrzCd       ; /* 상위조직코드         */        
	@ApiModelProperty(notes= "조직명(상위조직명)")
	private String hrkOrzNm       ; /* 조직명(상위조직명)   */   
	@ApiModelProperty(notes= "본지점구분코드")
	private String hobrTcd        ; /* 본지점구분코드       */        
	@ApiModelProperty(notes= "본지점구분명")
	private String hobrTpNm       ; /* 본지점구분명         */ 
	@ApiModelProperty(notes= "조직레벨값")
	private String orzLevlVl      ; /* 조직레벨값           */        
	@ApiModelProperty(notes= "조직레벨값명")
	private String orzLevlVlNm    ; /* 조직레벨값명         */      
	@ApiModelProperty(notes= "사업자등록번호")
	private String blno           ; /* 사업자등록번호       */        
	@ApiModelProperty(notes= "국가전화번호")
	private String ctno           ; /* 국가전화번호         */        
	@ApiModelProperty(notes= "지역전화번호")
	private String rtn            ; /* 지역전화번호         */        
	@ApiModelProperty(notes= "국전화번호")
	private String mtno           ; /* 국전화번호           */  
	@ApiModelProperty(notes= "개별전화번호")
	private String itno           ; /* 개별전화번호         */       
	@ApiModelProperty(notes= "팩스지역전화번호")
	private String faxRtn         ; /* 팩스지역전화번호     */        
	@ApiModelProperty(notes= "팩스국전화번호")
	private String faxMtno        ; /* 팩스국전화번호       */     
	@ApiModelProperty(notes= "팩스개별전화번호")
	private String faxItno        ; /* 팩스개별전화번호     */        
	@ApiModelProperty(notes= "우편번호")
	private String zpcd           ; /* 우편번호             */        
	@ApiModelProperty(notes= "주소")
	private String adr            ; /* 주소                 */        
	@ApiModelProperty(notes= "조직사용여부")
	private String orzUseYn       ; /* 조직사용여부         */        
	@ApiModelProperty(notes= "개설일자")
	private String opnDt          ; /* 개설일자             */        
	@ApiModelProperty(notes= "순번", example="0")
	private BigDecimal rnum       ; /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수             */        
	
    @Override
    public String toString() {
        return  "  BasicOrg00Out00VO{ "+
        		", orzCd        = '" + orzCd       + "'" +
        		", orzNm        = '" + orzNm       + "'" +
        		", orzAbrvNm    = '" + orzAbrvNm   + "'" +
        		", orzEngNm     = '" + orzEngNm    + "'" +
        		", hrkOrzCd     = '" + hrkOrzCd    + "'" +
        		", hrkOrzNm     = '" + hrkOrzNm    + "'" +
        		", hobrTcd      = '" + hobrTcd     + "'" +
        		", hobrTpNm     = '" + hobrTpNm    + "'" +
        		", orzLevlVl    = '" + orzLevlVl   + "'" +
        		", orzLevlVlNm  = '" + orzLevlVlNm + "'" +
        		", blno         = '" + blno        + "'" +
        		", ctno         = '" + ctno        + "'" +
        		", rtn          = '" + rtn         + "'" +
        		", mtno         = '" + mtno        + "'" +
        		", itno         = '" + itno        + "'" +
        		", faxRtn       = '" + faxRtn      + "'" +
        		", faxMtno      = '" + faxMtno     + "'" +
        		", faxItno      = '" + faxItno     + "'" +
        		", zpcd         = '" + zpcd        + "'" +
        		", adr          = '" + adr         + "'" +
        		", orzUseYn     = '" + orzUseYn    + "'" +
        		", opnDt        = '" + opnDt       + "'" + 
        		"}";
    }

	public String getOrzCd() {
		return orzCd;
	}

	public void setOrzCd(String orzCd) {
		this.orzCd = orzCd;
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

	public String getHrkOrzNm() {
		return hrkOrzNm;
	}

	public void setHrkOrzNm(String hrkOrzNm) {
		this.hrkOrzNm = hrkOrzNm;
	}

	public String getHobrTcd() {
		return hobrTcd;
	}

	public void setHobrTcd(String hobrTcd) {
		this.hobrTcd = hobrTcd;
	}

	public String getHobrTpNm() {
		return hobrTpNm;
	}

	public void setHobrTpNm(String hobrTpNm) {
		this.hobrTpNm = hobrTpNm;
	}

	public String getOrzLevlVl() {
		return orzLevlVl;
	}

	public void setOrzLevlVl(String orzLevlVl) {
		this.orzLevlVl = orzLevlVl;
	}

	public String getOrzLevlVlNm() {
		return orzLevlVlNm;
	}

	public void setOrzLevlVlNm(String orzLevlVlNm) {
		this.orzLevlVlNm = orzLevlVlNm;
	}

	public String getBlno() {
		return blno;
	}

	public void setBlno(String blno) {
		this.blno = blno;
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

	public String getOrzUseYn() {
		return orzUseYn;
	}

	public void setOrzUseYn(String orzUseYn) {
		this.orzUseYn = orzUseYn;
	}

	public String getOpnDt() {
		return opnDt;
	}

	public void setOpnDt(String opnDt) {
		this.opnDt = opnDt;
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
