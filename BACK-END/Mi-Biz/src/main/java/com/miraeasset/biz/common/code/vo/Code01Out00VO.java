package com.miraeasset.biz.common.code.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class Code01Out00VO {

	private BigDecimal rnum       ; /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수             */       
	
	@ApiModelProperty(notes= "공통코드")
	private String cmnCd               ;  /* V1.공통코드 */                    
	@ApiModelProperty(notes= "공통코드명")
	private String cmnCdNm             ;  /* V1.공통코드명 */                  
	@ApiModelProperty(notes= "공통코드값")
	private String cmnCdVl             ;  /* V1.공통코드값 */                  
	@ApiModelProperty(notes= "공통코드값명")
	private String cmnCdVlNm           ;  /* V1.공통코드값명 */                
	@ApiModelProperty(notes= "공통코드값표준명")
	private String cmnCdVlStdNm        ;  /* V1.공통코드값표준명 */            
	@ApiModelProperty(notes= "공통코드값영문명")
	private String cmnCdVlEngNm        ;  /* V1.공통코드값영문명 */            
	@ApiModelProperty(notes= "공통코드값영문약어명")
	private String cmnCdVlEabrvNm      ;  /* V1.공통코드값영문약어명 */        
	@ApiModelProperty(notes= "사용자정의값1")
	private String userDefVl1          ;  /* V1.사용자정의값1 */               
	@ApiModelProperty(notes= "사용자정의값2")
	private String userDefVl2          ;  /* V1.사용자정의값2 */               
	@ApiModelProperty(notes= "공통코드값사용구분")
	private String cmnCdVlUseTp        ;  /* V1.공통코드값사용구분 */          
	@ApiModelProperty(notes= "상위공통코드")
	private String hrkCmnCd            ;  /* V1.상위공통코드 */                
	@ApiModelProperty(notes= "상위공통코드명")
	private String hrkCmnCdNm          ;  /* V1.상위공통코드명 */              
	@ApiModelProperty(notes= "상위공통코드값")
	private String hrkCmnCdVl          ;  /* V1.상위공통코드값 */              
	@ApiModelProperty(notes= "공통코드값명(상위)")
	private String hrkCmnCdVlNm        ;  /* T1.공통코드값명(상위) */          
	@ApiModelProperty(notes= "공통코드값표준명(상위)")
	private String hrkCmnCdVlStdNm     ;  /* T1.공통코드값표준명(상위) */      
	@ApiModelProperty(notes= "공통코드값영문명(상위)")
	private String hrkCmnCdVlEngNm     ;  /* T1.공통코드값영문명(상위) */      
	@ApiModelProperty(notes= "공통코드값영문약어명(상위)")
	private String hrkCmnCdVlEabrvNm   ;  /* T1.공통코드값영문약어명(상위) */  
	@ApiModelProperty(notes= "사용자정의값1(상위)")
	private String hrkUserDefVl1       ;  /* T1.사용자정의값1(상위) */         
	@ApiModelProperty(notes= "사용자정의값2(상위)")
	private String hrkUserDefVl2       ;  /* T1.사용자정의값2(상위) */         
	@ApiModelProperty(notes= "상위공통코드값사용구분")
	private String hrkCmnCdVlUseTp     ;  /* [출력]상위공통코드값사용구분 */     
	
    @Override
    public String toString() {
        return  "  BasicCode00Out00VO{ "+
                ", rnum                = '" + rnum              + "'" +
                ", alCnt               = '" + alCnt             + "'" +
                ", cmnCd               = '" + cmnCd             + "'" +
                ", cmnCdNm             = '" + cmnCdNm           + "'" +
                ", cmnCdVl             = '" + cmnCdVl           + "'" +
                ", cmnCdVlNm           = '" + cmnCdVlNm         + "'" +
                ", cmnCdVlStdNm        = '" + cmnCdVlStdNm      + "'" +
                ", cmnCdVlEngNm        = '" + cmnCdVlEngNm      + "'" +
                ", cmnCdVlEabrvNm      = '" + cmnCdVlEabrvNm    + "'" +
                ", userDefVl1          = '" + userDefVl1        + "'" +
                ", userDefVl2          = '" + userDefVl2        + "'" +
                ", cmnCdVlUseTp        = '" + cmnCdVlUseTp      + "'" +
                ", hrkCmnCd            = '" + hrkCmnCd          + "'" +
                ", hrkCmnCdNm          = '" + hrkCmnCdNm        + "'" +
                ", hrkCmnCdVl          = '" + hrkCmnCdVl        + "'" +
                ", hrkCmnCdVlNm        = '" + hrkCmnCdVlNm      + "'" +
                ", hrkCmnCdVlStdNm     = '" + hrkCmnCdVlStdNm   + "'" +
                ", hrkCmnCdVlEngNm     = '" + hrkCmnCdVlEngNm   + "'" +
                ", hrkCmnCdVlEabrvNm   = '" + hrkCmnCdVlEabrvNm + "'" +
                ", hrkUserDefVl1       = '" + hrkUserDefVl1     + "'" +
                ", hrkUserDefVl2       = '" + hrkUserDefVl2     + "'" +
                ", hrkCmnCdVlUseTp     = '" + hrkCmnCdVlUseTp   + "'" +

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

	public String getCmnCdVl() {
		return cmnCdVl;
	}

	public void setCmnCdVl(String cmnCdVl) {
		this.cmnCdVl = cmnCdVl;
	}

	public String getCmnCdVlNm() {
		return cmnCdVlNm;
	}

	public void setCmnCdVlNm(String cmnCdVlNm) {
		this.cmnCdVlNm = cmnCdVlNm;
	}

	public String getCmnCdVlStdNm() {
		return cmnCdVlStdNm;
	}

	public void setCmnCdVlStdNm(String cmnCdVlStdNm) {
		this.cmnCdVlStdNm = cmnCdVlStdNm;
	}

	public String getCmnCdVlEngNm() {
		return cmnCdVlEngNm;
	}

	public void setCmnCdVlEngNm(String cmnCdVlEngNm) {
		this.cmnCdVlEngNm = cmnCdVlEngNm;
	}

	public String getCmnCdVlEabrvNm() {
		return cmnCdVlEabrvNm;
	}

	public void setCmnCdVlEabrvNm(String cmnCdVlEabrvNm) {
		this.cmnCdVlEabrvNm = cmnCdVlEabrvNm;
	}

	public String getUserDefVl1() {
		return userDefVl1;
	}

	public void setUserDefVl1(String userDefVl1) {
		this.userDefVl1 = userDefVl1;
	}

	public String getUserDefVl2() {
		return userDefVl2;
	}

	public void setUserDefVl2(String userDefVl2) {
		this.userDefVl2 = userDefVl2;
	}

	public String getCmnCdVlUseTp() {
		return cmnCdVlUseTp;
	}

	public void setCmnCdVlUseTp(String cmnCdVlUseTp) {
		this.cmnCdVlUseTp = cmnCdVlUseTp;
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

	public String getHrkCmnCdVl() {
		return hrkCmnCdVl;
	}

	public void setHrkCmnCdVl(String hrkCmnCdVl) {
		this.hrkCmnCdVl = hrkCmnCdVl;
	}

	public String getHrkCmnCdVlNm() {
		return hrkCmnCdVlNm;
	}

	public void setHrkCmnCdVlNm(String hrkCmnCdVlNm) {
		this.hrkCmnCdVlNm = hrkCmnCdVlNm;
	}

	public String getHrkCmnCdVlStdNm() {
		return hrkCmnCdVlStdNm;
	}

	public void setHrkCmnCdVlStdNm(String hrkCmnCdVlStdNm) {
		this.hrkCmnCdVlStdNm = hrkCmnCdVlStdNm;
	}

	public String getHrkCmnCdVlEngNm() {
		return hrkCmnCdVlEngNm;
	}

	public void setHrkCmnCdVlEngNm(String hrkCmnCdVlEngNm) {
		this.hrkCmnCdVlEngNm = hrkCmnCdVlEngNm;
	}

	public String getHrkCmnCdVlEabrvNm() {
		return hrkCmnCdVlEabrvNm;
	}

	public void setHrkCmnCdVlEabrvNm(String hrkCmnCdVlEabrvNm) {
		this.hrkCmnCdVlEabrvNm = hrkCmnCdVlEabrvNm;
	}

	public String getHrkUserDefVl1() {
		return hrkUserDefVl1;
	}

	public void setHrkUserDefVl1(String hrkUserDefVl1) {
		this.hrkUserDefVl1 = hrkUserDefVl1;
	}

	public String getHrkUserDefVl2() {
		return hrkUserDefVl2;
	}

	public void setHrkUserDefVl2(String hrkUserDefVl2) {
		this.hrkUserDefVl2 = hrkUserDefVl2;
	}

	public String getHrkCmnCdVlUseTp() {
		return hrkCmnCdVlUseTp;
	}

	public void setHrkCmnCdVlUseTp(String hrkCmnCdVlUseTp) {
		this.hrkCmnCdVlUseTp = hrkCmnCdVlUseTp;
	}
    
    
}
