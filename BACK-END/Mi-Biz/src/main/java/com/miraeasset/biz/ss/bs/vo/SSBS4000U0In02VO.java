/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS4000U0In02VO.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 메뉴관리 신규등록/수정 in
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.bs.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SSBS4000U0In02VO {
	    
	@ApiModelProperty(notes= "매뉴ID 자동채번")
	private String psitMenuId   ;  /*포털사이트메뉴ID*/
	@ApiModelProperty(notes= "메뉴명")
	private String menuNm       ;  /*메뉴명          */
	@ApiModelProperty(notes= "상위메뉴ID")
	private String hrkMenuId    ;  /*상위메뉴ID      */
	@ApiModelProperty(notes= "URL주소")
	private String urlAdr       ;  /*URL주소         */
	@ApiModelProperty(notes= "사용여부")
	private String useYn        ;  /*사용여부        */
	@ApiModelProperty(notes= "화면출력순서")
	private String scrnOputSqn  ;  /*화면출력순서    */

	@ApiModelProperty(notes= "화면id")
	private String psitScrnId   ;   /*화면id*/

	public String getPsitMenuId() {
		return psitMenuId;
	}

	public void setPsitMenuId(String psitMenuId) {
		this.psitMenuId = psitMenuId;
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

	public String getPsitScrnId() {
		return psitScrnId;
	}

	public void setPsitScrnId(String psitScrnId) {
		this.psitScrnId = psitScrnId;
	}

	


    
}
