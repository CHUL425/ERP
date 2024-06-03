package com.miraeasset.biz.common.auth.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class AuthGA09N208Out00VO {
	
	@ApiModelProperty(notes= "화면명")
	private String scrnNm		;            // 화면명
	
	@ApiModelProperty(notes= "포털사이트메뉴ID")
    private String psitMenuId	;            // 포털사이트메뉴ID
	
	@ApiModelProperty(notes= "태그")
	private String tag		;            // 태그

	public String getScrnNm() {
		return scrnNm;
	}

	public void setScrnNm(String scrnNm) {
		this.scrnNm = scrnNm;
	}

	public String getPsitMenuId() {
		return psitMenuId;
	}

	public void setPsitMenuId(String psitMenuId) {
		this.psitMenuId = psitMenuId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
}
