package com.miraeasset.biz.ga.rm.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GARM2000V0Out01VO {
	
    @ApiModelProperty(notes= "총정산금액")
    private String totalExccA       ;    /* 총정산금액 */
    @ApiModelProperty(notes= "기본요금")
    private String baseCrga         ;    /* 기본요금 */
    @ApiModelProperty(notes= "추가요금")
    private String adCrga           ;    /* 추가요금 */
    
	public String getTotalExccA() {
		return totalExccA;
	}
	public void setTotalExccA(String totalExccA) {
		this.totalExccA = totalExccA;
	}
	public String getBaseCrga() {
		return baseCrga;
	}
	public void setBaseCrga(String baseCrga) {
		this.baseCrga = baseCrga;
	}
	public String getAdCrga() {
		return adCrga;
	}
	public void setAdCrga(String adCrga) {
		this.adCrga = adCrga;
	}
	
	@Override
	public String toString() {
		return "GARM2000V0Out01VO [totalExccA=" + totalExccA + ", baseCrga=" + baseCrga + ", adCrga=" + adCrga + "]";
	}
    
}
