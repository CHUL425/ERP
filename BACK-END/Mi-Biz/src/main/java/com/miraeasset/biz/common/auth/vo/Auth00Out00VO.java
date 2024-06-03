package com.miraeasset.biz.common.auth.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class Auth00Out00VO {

	@ApiModelProperty(notes= "현재근무조직코드")
	private String nowWrkpOrzCd  ; /* 현재근무조직코드 */
	@ApiModelProperty(notes= "사번")
	private String epno          ; /* 사번 */
	@ApiModelProperty(notes= "화면번호")
	private String scrnNo        ; /* 화면번호 */
	@ApiModelProperty(notes= "처리가능여부")
	private String prcAblYn      ; /* 처리가능여부 */
	@ApiModelProperty(notes= "화면명")
	private String scrnNm        ; /* 화면명 */
	@ApiModelProperty(notes= "메뉴id")
	private String menuId        ; /* 메뉴id */
	@ApiModelProperty(notes= "url주소")
	private String urlAdr        ; /* url주소 */
	public String getNowWrkpOrzCd() {
		return nowWrkpOrzCd;
	}
	public void setNowWrkpOrzCd(String nowWrkpOrzCd) {
		this.nowWrkpOrzCd = nowWrkpOrzCd;
	}
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getScrnNo() {
		return scrnNo;
	}
	public void setScrnNo(String scrnNo) {
		this.scrnNo = scrnNo;
	}
	public String getPrcAblYn() {
		return prcAblYn;
	}
	public void setPrcAblYn(String prcAblYn) {
		this.prcAblYn = prcAblYn;
	}
	public String getScrnNm() {
		return scrnNm;
	}
	public void setScrnNm(String scrnNm) {
		this.scrnNm = scrnNm;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getUrlAdr() {
		return urlAdr;
	}
	public void setUrlAdr(String urlAdr) {
		this.urlAdr = urlAdr;
	}
	
    

}
