package com.miraeasset.biz.rent.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RENT12Out01VO {
	
	@ApiModelProperty(notes= "신청상태코드00")
	private String rqsScd00          ; /*신청상태코드00     */
	@ApiModelProperty(notes= "신청상태코드01")
	private String rqsScd01          ; /*신청상태코드01     */
	@ApiModelProperty(notes= "신청상태코드02")
	private String rqsScd02          ; /*신청상태코드02     */
	@ApiModelProperty(notes= "신청상태코드03")
	private String rqsScd03          ; /*신청상태코드03     */
	@ApiModelProperty(notes= "신청상태코드04")
	private String rqsScd04          ; /*신청상태코드04     */
	@ApiModelProperty(notes= "신청상태코드05")
	private String rqsScd05          ; /*신청상태코드05     */
	@ApiModelProperty(notes= "신청상태코드06")
	private String rqsScd06          ; /*신청상태코드06     */
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
	public String getRqsScd05() {
		return rqsScd05;
	}
	public void setRqsScd05(String rqsScd05) {
		this.rqsScd05 = rqsScd05;
	}
	public String getRqsScd06() {
		return rqsScd06;
	}
	public void setRqsScd06(String rqsScd06) {
		this.rqsScd06 = rqsScd06;
	}

}
