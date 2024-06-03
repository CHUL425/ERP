package com.miraeasset.biz.rq.cr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQCR1000U0Out01VO {
	
	@ApiModelProperty(notes= "임시저장")
	private String rqsScd00          ; /* 임시저장 */
	@ApiModelProperty(notes= "승인대기")
	private String rqsScd01          ; /* 승인대기 */
	@ApiModelProperty(notes= "승인중")
	private String rqsScd02          ; /* 승인중 */
	@ApiModelProperty(notes= "승인완료")
	private String rqsScd03          ; /* 승인완료 */
	@ApiModelProperty(notes= "완료")
	private String rqsScd04          ; /* 완료 */
	@ApiModelProperty(notes= "철회/반려")
	private String rqsScd0506        ; /* 철회/반려 */
	
	public String getRqsScd00() {
		return rqsScd00;
	}
	public void setRqsScd00(String rqsScd00) {
		this.rqsScd00 = rqsScd00;
	}
	public String getRqsScd01() {
		return rqsScd01;
	}
	public void setRqsScd01(String rqsScd01) {
		this.rqsScd01 = rqsScd01;
	}
	public String getRqsScd02() {
		return rqsScd02;
	}
	public void setRqsScd02(String rqsScd02) {
		this.rqsScd02 = rqsScd02;
	}
	public String getRqsScd03() {
		return rqsScd03;
	}
	public void setRqsScd03(String rqsScd03) {
		this.rqsScd03 = rqsScd03;
	}
	public String getRqsScd04() {
		return rqsScd04;
	}
	public void setRqsScd04(String rqsScd04) {
		this.rqsScd04 = rqsScd04;
	}
	public String getRqsScd0506() {
		return rqsScd0506;
	}
	public void setRqsScd0506(String rqsScd0506) {
		this.rqsScd0506 = rqsScd0506;
	}
	
	@Override
	public String toString() {
		return "RQCR1000U0Out01VO [rqsScd00=" + rqsScd00 + ", rqsScd01=" + rqsScd01 + ", rqsScd02=" + rqsScd02
				+ ", rqsScd03=" + rqsScd03 + ", rqsScd04=" + rqsScd04 + ", rqsScd0506=" + rqsScd0506 + "]";
	}
	
}
