package com.miraeasset.biz.common.code.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class Code00Out00VO {

	private BigDecimal rnum       ; /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수             */       
	
    @ApiModelProperty(notes= "공통코드")
	private String cmnCd          ;    /* T1.공통코드 */                    
    @ApiModelProperty(notes= "공통코드명")
	private String cmnCdNm        ;    /* T1.공통코드명 */                  
    @ApiModelProperty(notes= "공통코드값길이")
	private String cmnCdVlLen     ;    /* T1.공통코드값길이 */              
    @ApiModelProperty(notes= "공통코드사용구분")
	private String cmnCdUseTp     ;    /* [출력]공통코드사용구분 */         
    @ApiModelProperty(notes= "상위공통코드")
	private String hrkCmnCd       ;    /* T1.상위공통코드 */                
    @ApiModelProperty(notes= "공통코드명(상위)")
	private String hrkCmnCdNm     ;    /* T2.공통코드명(상위) */            
    @ApiModelProperty(notes= "공통코드값길이(상위)")
	private String hrkCmnCdVlLen  ;    /* T2.공통코드값길이(상위) */        
    @ApiModelProperty(notes= "상위공통코드사용구분")
	private String hrkCmnCdUseTp  ;    /* [출력]상위공통코드사용구분 */      
	
    @Override
    public String toString() {
        return  "  BasicCode00Out00VO{ "+
                ", rnum           = '" + rnum          + "'" +
                ", alCnt          = '" + alCnt         + "'" +
                ", cmnCd          = '" + cmnCd         + "'" +
                ", cmnCdNm        = '" + cmnCdNm       + "'" +
                ", cmnCdVlLen     = '" + cmnCdVlLen    + "'" +
                ", cmnCdUseTp     = '" + cmnCdUseTp    + "'" +
                ", hrkCmnCd       = '" + hrkCmnCd      + "'" +
                ", hrkCmnCdNm     = '" + hrkCmnCdNm    + "'" +
                ", hrkCmnCdVlLen  = '" + hrkCmnCdVlLen + "'" +
                ", hrkCmnCdUseTp  = '" + hrkCmnCdUseTp + "'" +
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


	public String getCmnCd() {
		return cmnCd;
	}

	public void setCmnCd(String cmnCd) {
		this.cmnCd = cmnCd;
	}

	public String getCmnCdNm() {
		return cmnCdNm;
	}

	public void setCmnCdNm(String cmnCdNm) {
		this.cmnCdNm = cmnCdNm;
	}

	public String getCmnCdVlLen() {
		return cmnCdVlLen;
	}

	public void setCmnCdVlLen(String cmnCdVlLen) {
		this.cmnCdVlLen = cmnCdVlLen;
	}

	public String getCmnCdUseTp() {
		return cmnCdUseTp;
	}

	public void setCmnCdUseTp(String cmnCdUseTp) {
		this.cmnCdUseTp = cmnCdUseTp;
	}

	public String getHrkCmnCd() {
		return hrkCmnCd;
	}

	public void setHrkCmnCd(String hrkCmnCd) {
		this.hrkCmnCd = hrkCmnCd;
	}

	public String getHrkCmnCdNm() {
		return hrkCmnCdNm;
	}

	public void setHrkCmnCdNm(String hrkCmnCdNm) {
		this.hrkCmnCdNm = hrkCmnCdNm;
	}

	public String getHrkCmnCdVlLen() {
		return hrkCmnCdVlLen;
	}

	public void setHrkCmnCdVlLen(String hrkCmnCdVlLen) {
		this.hrkCmnCdVlLen = hrkCmnCdVlLen;
	}

	public String getHrkCmnCdUseTp() {
		return hrkCmnCdUseTp;
	}

	public void setHrkCmnCdUseTp(String hrkCmnCdUseTp) {
		this.hrkCmnCdUseTp = hrkCmnCdUseTp;
	}
    
    

}
