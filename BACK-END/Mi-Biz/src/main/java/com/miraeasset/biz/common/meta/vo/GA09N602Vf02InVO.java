package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N602Vf02InVO {
	
	@ApiModelProperty(notes= "화면번호")
	private String scrnNo           ; /* 화면번호 */
	@ApiModelProperty(notes= "사원번호")
	private String epno        		; /* 사원번호 */
	@ApiModelProperty(notes= "본지점구분", example = "01:본점, 02:지점")
	private String hobrTcd    		; /* 본지점구분 */
	@ApiModelProperty(notes= "조직코드")
	private String orzCd    		; /* 조직코드 */
	
	@ApiModelProperty(notes= "접수번호", hidden = true)
    private String rctNo              ; /*접수번호*/
	
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	
	public String getScrnNo() {
		return scrnNo;
	}
	public void setScrnNo(String scrnNo) {
		this.scrnNo = scrnNo;
	}
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getHobrTcd() {
		return hobrTcd;
	}
	public void setHobrTcd(String hobrTcd) {
		this.hobrTcd = hobrTcd;
	}
	public String getOrzCd() {
		return orzCd;
	}
	public void setOrzCd(String orzCd) {
		this.orzCd = orzCd;
	}
}
