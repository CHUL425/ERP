package com.miraeasset.biz.ss.bs.vo;

import io.swagger.annotations.ApiModelProperty;

import org.springframework.stereotype.Component;

@Component
public class SSBS4000V0Out00VO {

    @ApiModelProperty(notes= "메뉴ID")
    private String menuId		;        /* 메뉴ID */
    @ApiModelProperty(notes= "메뉴명")
    private String menuNm		;        /* 메뉴명 */
    @ApiModelProperty(notes= "상위메뉴ID")
    private String hrkMenuId	;        /* 상위메뉴ID */
    @ApiModelProperty(notes= "URL주소")
    private String urlAdr		;        /* URL주소 */
    @ApiModelProperty(notes= "사용여부")
    private String useYn		;        /* 사용여부 */
    @ApiModelProperty(notes= "화면출력순서")
    private String scrnOputSqn	;        /* 화면출력순서 */
    @ApiModelProperty(notes= "조작자ID")
    private String optrId       ;	     /* 조작자ID */
    @ApiModelProperty(notes= "조작채널코드")
    private String oprtChnlCd   ;        /* 조작채널코드 */
    @ApiModelProperty(notes= "조작조직코드")
    private String oprtOrzCd    ;        /* 조작조직코드 */
    @ApiModelProperty(notes= "조작IP주소")
    private String oprtIpAdr    ;        /* 조작IP주소 */
    @ApiModelProperty(notes= "조작일시")
    private String oprtDttm         ;    /* 조작일시 */
    
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuNm() {
		return menuNm;
	}
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	public String getHrkMenuId() {
		return hrkMenuId;
	}
	public void setHrkMenuId(String hrkMenuId) {
		this.hrkMenuId = hrkMenuId;
	}
	public String getUrlAdr() {
		return urlAdr;
	}
	public void setUrlAdr(String urlAdr) {
		this.urlAdr = urlAdr;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getScrnOputSqn() {
		return scrnOputSqn;
	}
	public void setScrnOputSqn(String scrnOputSqn) {
		this.scrnOputSqn = scrnOputSqn;
	}
	public String getOptrId() {
		return optrId;
	}
	public void setOptrId(String optrId) {
		this.optrId = optrId;
	}
	public String getOprtChnlCd() {
		return oprtChnlCd;
	}
	public void setOprtChnlCd(String oprtChnlCd) {
		this.oprtChnlCd = oprtChnlCd;
	}
	public String getOprtOrzCd() {
		return oprtOrzCd;
	}
	public void setOprtOrzCd(String oprtOrzCd) {
		this.oprtOrzCd = oprtOrzCd;
	}
	public String getOprtIpAdr() {
		return oprtIpAdr;
	}
	public void setOprtIpAdr(String oprtIpAdr) {
		this.oprtIpAdr = oprtIpAdr;
	}
	public String getOprtDttm() {
		return oprtDttm;
	}
	public void setOprtDttm(String oprtDttm) {
		this.oprtDttm = oprtDttm;
	}
	
	@Override
	public String toString() {
		return "SSBS4000V0Out00VO [menuId=" + menuId + ", menuNm=" + menuNm + ", hrkMenuId=" + hrkMenuId + ", urlAdr="
				+ urlAdr + ", useYn=" + useYn + ", scrnOputSqn=" + scrnOputSqn + ", optrId=" + optrId + ", oprtChnlCd="
				+ oprtChnlCd + ", oprtOrzCd=" + oprtOrzCd + ", oprtIpAdr=" + oprtIpAdr + ", oprtDttm=" + oprtDttm + "]";
	}
    
}
