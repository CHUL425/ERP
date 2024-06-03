package com.miraeasset.biz.ss.bs.vo;

import io.swagger.annotations.ApiModelProperty;

import org.springframework.stereotype.Component;

@Component
public class SSBS4100V0Out00VO {

	@ApiModelProperty(notes= "상위메뉴ID")
	private String hrkMenuId	;        /* 상위메뉴ID */
	@ApiModelProperty(notes= "상위메뉴명")
	private String hrkMenuNm	;        /* 상위메뉴명 */
    @ApiModelProperty(notes= "메뉴ID")
    private String menuId		;        /* 메뉴ID */
    @ApiModelProperty(notes= "화면번호")
    private String scrnNo		; 		 /* 화면번호 */
    @ApiModelProperty(notes= "화면명")
    private String scrnNm		; 		 /* 화면명 */
    @ApiModelProperty(notes= "URL주소")
    private String urlAdr		;        /* URL주소 */
    @ApiModelProperty(notes= "처리가능여부")
    private String prcAblYn 	;		 /* 처리가능여부 */
    
	public String getHrkMenuId() {
		return hrkMenuId;
	}
	public void setHrkMenuId(String hrkMenuId) {
		this.hrkMenuId = hrkMenuId;
	}
	public String getHrkMenuNm() {
		return hrkMenuNm;
	}
	public void setHrkMenuNm(String hrkMenuNm) {
		this.hrkMenuNm = hrkMenuNm;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getScrnNo() {
		return scrnNo;
	}
	public void setScrnNo(String scrnNo) {
		this.scrnNo = scrnNo;
	}
	public String getScrnNm() {
		return scrnNm;
	}
	public void setScrnNm(String scrnNm) {
		this.scrnNm = scrnNm;
	}
	public String getUrlAdr() {
		return urlAdr;
	}
	public void setUrlAdr(String urlAdr) {
		this.urlAdr = urlAdr;
	}
	public String getPrcAblYn() {
		return prcAblYn;
	}
	public void setPrcAblYn(String prcAblYn) {
		this.prcAblYn = prcAblYn;
	}
	
	@Override
	public String toString() {
		return "SSBS4100V0Out00VO [hrkMenuId=" + hrkMenuId + ", hrkMenuNm=" + hrkMenuNm + ", menuId=" + menuId
				+ ", scrnNo=" + scrnNo + ", scrnNm=" + scrnNm + ", urlAdr=" + urlAdr + ", prcAblYn=" + prcAblYn
				+ ", getHrkMenuId()=" + getHrkMenuId() + ", getHrkMenuNm()=" + getHrkMenuNm() + ", getMenuId()="
				+ getMenuId() + ", getScrnNo()=" + getScrnNo() + ", getScrnNm()=" + getScrnNm() + ", getUrlAdr()="
				+ getUrlAdr() + ", getPrcAblYn()=" + getPrcAblYn() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
    
}
