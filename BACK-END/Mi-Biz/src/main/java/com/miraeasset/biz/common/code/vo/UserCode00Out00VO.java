package com.miraeasset.biz.common.code.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class UserCode00Out00VO {
	
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt    ;    /* 전체건수 */       
	
    @ApiModelProperty(notes= "팀점코드")
	private String orzCd        ;    /* 팀점코드 */                    
    @ApiModelProperty(notes= "팀점명")
	private String orzNm        ;    /* 팀점명 */                  
    @ApiModelProperty(notes= "사원코드")
	private String epNO         ;    /* 사원코드 */              
    @ApiModelProperty(notes= "사원명")
	private String epNm         ;    /* 사원명 */
    
	public BigDecimal getAlCnt() {
		return alCnt;
	}
	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
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
	public String getEpNO() {
		return epNO;
	}
	public void setEpNO(String epNO) {
		this.epNO = epNO;
	}
	public String getEpNm() {
		return epNm;
	}
	public void setEpNm(String epNm) {
		this.epNm = epNm;
	}
	
	@Override
	public String toString() {
		return "UserCode00Out00VO [alCnt=" + alCnt + ", orzCd=" + orzCd + ", orzNm=" + orzNm + ", epNO=" + epNO
				+ ", epNm=" + epNm + "]";
	}
}
