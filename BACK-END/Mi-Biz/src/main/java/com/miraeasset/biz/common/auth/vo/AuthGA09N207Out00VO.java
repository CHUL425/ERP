package com.miraeasset.biz.common.auth.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class AuthGA09N207Out00VO {
	
	@ApiModelProperty(notes= "포털사이트메뉴ID")
    private String psitMenuId	;            // 포털사이트메뉴ID
	@ApiModelProperty(notes= "화면명")
	private String scrnNm		;            // 화면명
	@ApiModelProperty(notes= "정렬순서")
	private String sortSqn		;            // 정렬순서
	@ApiModelProperty(notes= "화면유형코드")
	private String scrnPcd		;            // 화면유형코드
	@ApiModelProperty(notes= "URL주소")
	private String urlAdr		;            // URL주소
	
	public String getPsitMenuId() {
		return psitMenuId;
	}
	public void setPsitMenuId(String psitMenuId) {
		this.psitMenuId = psitMenuId;
	}
	public String getScrnNm() {
		return scrnNm;
	}
	public void setScrnNm(String scrnNm) {
		this.scrnNm = scrnNm;
	}
	public String getSortSqn() {
		return sortSqn;
	}
	public void setSortSqn(String sortSqn) {
		this.sortSqn = sortSqn;
	}
	public String getScrnPcd() {
		return scrnPcd;
	}
	public void setScrnPcd(String scrnPcd) {
		this.scrnPcd = scrnPcd;
	}
	public String getUrlAdr() {
		return urlAdr;
	}
	public void setUrlAdr(String urlAdr) {
		this.urlAdr = urlAdr;
	}
	
}
