package com.miraeasset.biz.in.in.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ININ1000V0Out05VO {
	
	@ApiModelProperty(notes= "계약명")
	private String cntcNm           ; /*계약명 */
	
	@ApiModelProperty(notes= "계약시작일자")
	private String cntcStrtDt       ; /*계약시작일자 */

	public String getCntcNm() {
		return cntcNm;
	}

	public void setCntcNm(String cntcNm) {
		this.cntcNm = cntcNm;
	}

	public String getCntcStrtDt() {
		return cntcStrtDt;
	}

	public void setCntcStrtDt(String cntcStrtDt) {
		this.cntcStrtDt = cntcStrtDt;
	}
}