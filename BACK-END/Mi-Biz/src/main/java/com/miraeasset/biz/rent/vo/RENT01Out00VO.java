package com.miraeasset.biz.rent.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RENT01Out00VO {
	
    @ApiModelProperty(notes= "총렌탈료")
	private String totalRentc    ;    /* 총렌탈료 */
    @ApiModelProperty(notes= "정수기")
	private String rentc01       ;    /* 정수기 */
    @ApiModelProperty(notes= "공기청정기")
    private String rentc02       ;    /* 공기청정기 */
    @ApiModelProperty(notes= "비데")
    private String rentc03       ;    /* 비데 */
    @ApiModelProperty(notes= "클린워셔")
    private String rentc04       ;    /* 클린워셔 */
    
	public String getTotalRentc() {
		return totalRentc;
	}
	public void setTotalRentc(String totalRentc) {
		this.totalRentc = totalRentc;
	}
	public String getRentc01() {
		return rentc01;
	}
	public void setRentc01(String rentc01) {
		this.rentc01 = rentc01;
	}
	public String getRentc02() {
		return rentc02;
	}
	public void setRentc02(String rentc02) {
		this.rentc02 = rentc02;
	}
	public String getRentc03() {
		return rentc03;
	}
	public void setRentc03(String rentc03) {
		this.rentc03 = rentc03;
	}
	public String getRentc04() {
		return rentc04;
	}
	public void setRentc04(String rentc04) {
		this.rentc04 = rentc04;
	}
	
	@Override
	public String toString() {
		return "RENT01Out00VO [totalRentc=" + totalRentc + ", rentc01=" + rentc01 + ", rentc02=" + rentc02
				+ ", rentc03=" + rentc03 + ", rentc04=" + rentc04 + "]";
	}
}
