package com.miraeasset.biz.ga.vm.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAVM1010U0In00VO {
	
	@ApiModelProperty(notes = "계약시작일자", required = true, example = "20200227")
    private String qryStrtDt;         // 계약시작일자
    @ApiModelProperty(notes = "계약만기일자", required = true, example = "20230227")
    private String qryEndDt;          // 계약만기일자
    
    @ApiModelProperty(notes = "차량번호", required = true, example = "178허1167")
    private String vhcNo;             // 차량번호
    
    @ApiModelProperty(notes = "해지예상일자", required = true, example = "20220227")
    private String cclcFrcsDt; /* 해지예상일자 */
    
	public String getQryStrtDt() {
		return qryStrtDt;
	}

	public void setQryStrtDt(String qryStrtDt) {
		this.qryStrtDt = qryStrtDt;
	}

	public String getQryEndDt() {
		return qryEndDt;
	}

	public void setQryEndDt(String qryEndDt) {
		this.qryEndDt = qryEndDt;
	}

	public String getVhcNo() {
		return vhcNo;
	}

	public void setVhcNo(String vhcNo) {
		this.vhcNo = vhcNo;
	}

	public String getCclcFrcsDt() {
		return cclcFrcsDt;
	}

	public void setCclcFrcsDt(String cclcFrcsDt) {
		this.cclcFrcsDt = cclcFrcsDt;
	}
    
}
