package com.miraeasset.biz.common.basic.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class BasicUser00Out00VO {

	@ApiModelProperty(notes= "순번", example="0")          
	private BigDecimal rnum        ; /* 순번              */                                           
	@ApiModelProperty(notes= "전체건수", example="0")          
	private BigDecimal alCnt       ; /* 전체건수               */                                                                       
	@ApiModelProperty(notes= "사원번호")          
	private String epno            ; /* 사원번호               */               
	@ApiModelProperty(notes= "사원명")          
	private String epNm            ; /* 사원명                 */               
	@ApiModelProperty(notes= "소속조직코드")          
	private String blngOrzCd       ; /* 소속조직코드           */               
	@ApiModelProperty(notes= "소속조직명")          
	private String blngOrzNm       ; /* 소속조직명             */               
	@ApiModelProperty(notes= "현재근무지조직코드")          
	private String nowWrkpOrzCd    ; /* 현재근무지조직코드     */               
	@ApiModelProperty(notes= "현재근무지조직명")          
	private String nowWrkpOrzNm    ; /* 현재근무지조직명       */               
	@ApiModelProperty(notes= "인사직책코드")          
	private String hrOsdtCd        ; /* 인사직책코드           */               
	@ApiModelProperty(notes= "인사직책명")          
	private String hrOsdtNm        ; /* 인사직책명             */               
	@ApiModelProperty(notes= "인사재직코드")          
	private String hrHldoCd        ; /* 인사재직코드           */               
	@ApiModelProperty(notes= "인사재직명")          
	private String hrHldoNm        ; /* 인사재직명             */               
	@ApiModelProperty(notes= "전화번호")          
	private String tlno            ; /* 전화번호               */               
	@ApiModelProperty(notes= "휴대폰전화번호")          
	private String hndpTlno        ; /* 휴대폰전화번호         */               
	@ApiModelProperty(notes= "임직원식별번호암호화값")          
	private String xempIdfyNoEcpVl ; /* 임직원식별번호암호화값 */   
	
    @Override
    public String toString() {
        return  "  BasicUser00Out00VO{ "+
        		", alCnt           = '" + alCnt           + "'" +
        		", epno            = '" + epno            + "'" +
        		", epNm            = '" + epNm            + "'" +
        		", blngOrzCd       = '" + blngOrzCd       + "'" +
        		", blngOrzNm       = '" + blngOrzNm       + "'" +
        		", nowWrkpOrzCd    = '" + nowWrkpOrzCd    + "'" +
        		", nowWrkpOrzNm    = '" + nowWrkpOrzNm    + "'" +
        		", hrOsdtCd        = '" + hrOsdtCd        + "'" +
        		", hrOsdtNm        = '" + hrOsdtNm        + "'" +
        		", hrHldoCd        = '" + hrHldoCd        + "'" +
        		", hrHldoNm        = '" + hrHldoNm        + "'" +
        		", tlno            = '" + tlno            + "'" +
        		", hndpTlno        = '" + hndpTlno        + "'" +
        		", xempIdfyNoEcpVl = '" + xempIdfyNoEcpVl + "'" +
        		"}";
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

	public String getEpno() {
		return epno;
	}

	public void setEpno(String epno) {
		this.epno = epno;
	}

	public String getEpNm() {
		return epNm;
	}

	public void setEpNm(String epNm) {
		this.epNm = epNm;
	}

	public String getBlngOrzCd() {
		return blngOrzCd;
	}

	public void setBlngOrzCd(String blngOrzCd) {
		this.blngOrzCd = blngOrzCd;
	}

	public String getBlngOrzNm() {
		return blngOrzNm;
	}

	public void setBlngOrzNm(String blngOrzNm) {
		this.blngOrzNm = blngOrzNm;
	}

	public String getNowWrkpOrzCd() {
		return nowWrkpOrzCd;
	}

	public void setNowWrkpOrzCd(String nowWrkpOrzCd) {
		this.nowWrkpOrzCd = nowWrkpOrzCd;
	}

	public String getNowWrkpOrzNm() {
		return nowWrkpOrzNm;
	}

	public void setNowWrkpOrzNm(String nowWrkpOrzNm) {
		this.nowWrkpOrzNm = nowWrkpOrzNm;
	}

	public String getHrOsdtCd() {
		return hrOsdtCd;
	}

	public void setHrOsdtCd(String hrOsdtCd) {
		this.hrOsdtCd = hrOsdtCd;
	}

	public String getHrOsdtNm() {
		return hrOsdtNm;
	}

	public void setHrOsdtNm(String hrOsdtNm) {
		this.hrOsdtNm = hrOsdtNm;
	}

	public String getHrHldoCd() {
		return hrHldoCd;
	}

	public void setHrHldoCd(String hrHldoCd) {
		this.hrHldoCd = hrHldoCd;
	}

	public String getHrHldoNm() {
		return hrHldoNm;
	}

	public void setHrHldoNm(String hrHldoNm) {
		this.hrHldoNm = hrHldoNm;
	}

	public String getTlno() {
		return tlno;
	}

	public void setTlno(String tlno) {
		this.tlno = tlno;
	}

	public String getHndpTlno() {
		return hndpTlno;
	}

	public void setHndpTlno(String hndpTlno) {
		this.hndpTlno = hndpTlno;
	}

	public String getXempIdfyNoEcpVl() {
		return xempIdfyNoEcpVl;
	}

	public void setXempIdfyNoEcpVl(String xempIdfyNoEcpVl) {
		this.xempIdfyNoEcpVl = xempIdfyNoEcpVl;
	}
    
    

}
