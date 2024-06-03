package com.miraeasset.biz.common.code.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class TeamCode01Out00VO {
	
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수 */       
	
    @ApiModelProperty(notes= "조직코드")
	private String orzCd          ;    /* 조직코드 */                    
    @ApiModelProperty(notes= "조직명")
	private String orzNm        ;    /* 조직명 */                  
    
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
	
	@Override
	public String toString() {
		return "TeamCode01Out00VO [alCnt=" + alCnt + ", orzCd=" + orzCd + ", orzNm=" + orzNm + "]";
	}         
    
}
