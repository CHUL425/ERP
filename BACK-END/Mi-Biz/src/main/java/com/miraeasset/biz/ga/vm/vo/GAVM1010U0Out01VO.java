package com.miraeasset.biz.ga.vm.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAVM1010U0Out01VO {
	
	@ApiModelProperty(notes = "플래그")
	private String flg			; /* 플래그 */
	
	@ApiModelProperty(notes = "처리일자")
	private String prcDt		; /* 처리일자 */
	
	@ApiModelProperty(notes = "일련번호")
	private String srno;
	
	@ApiModelProperty(notes = "주유카드암호화값")
    private String reflCardEcpVl; /* 주유카드암호화값 */
    
	@ApiModelProperty(notes = "특이사항내용")
	private String pclrPtcrCn	; /* 특이사항내용 */

	public String getFlg() {
		return flg;
	}

	public void setFlg(String flg) {
		this.flg = flg;
	}

	public String getPrcDt() {
		return prcDt;
	}

	public void setPrcDt(String prcDt) {
		this.prcDt = prcDt;
	}

	public String getSrno() {
		return srno;
	}

	public void setSrno(String srno) {
		this.srno = srno;
	}

	public String getReflCardEcpVl() {
		return reflCardEcpVl;
	}

	public void setReflCardEcpVl(String reflCardEcpVl) {
		this.reflCardEcpVl = reflCardEcpVl;
	}

	public String getPclrPtcrCn() {
		return pclrPtcrCn;
	}

	public void setPclrPtcrCn(String pclrPtcrCn) {
		this.pclrPtcrCn = pclrPtcrCn;
	}

	@Override
	public String toString() {
		return "GAVM1010U0Out01VO [flg=" + flg + ", prcDt=" + prcDt + ", srno=" + srno + ", reflCardEcpVl="
				+ reflCardEcpVl + ", pclrPtcrCn=" + pclrPtcrCn + "]";
	}
	
}
