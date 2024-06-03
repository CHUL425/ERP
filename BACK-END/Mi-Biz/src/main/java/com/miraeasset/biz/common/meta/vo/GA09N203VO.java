/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA09N203VO.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA09N203	메뉴 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N203VO extends BaseVO {
	
	@ApiModelProperty(notes= "매뉴ID")
	private String psitMenuId    ; /*매뉴ID*/
	@ApiModelProperty(notes= "매뉴명")
	private String menuNm        ; /*매뉴명*/
	@ApiModelProperty(notes= "화면ID")
	private String psitScrnId    ; /*화면ID */
	@ApiModelProperty(notes= "화면명")
	private String scrnNm        ; /*화면명*/
	@ApiModelProperty(notes= "화면출력순서")
	private String scrnOputSqn   ; /*화면출력순서 */
	@ApiModelProperty(notes= "메뉴깊이값")
	private String menuDpthVl    ; /*메뉴깊이값 */
	@ApiModelProperty(notes= "상위메뉴ID")
	private String hrkMenuId     ; /*상위메뉴ID */
	@ApiModelProperty(notes= "URL주소")
	private String urlAdr        ; /*URL주소 */
	@ApiModelProperty(notes= "사용여부")
	private String useYn			   ; /*사용여부 */
	
	@ApiModelProperty(notes= "상위화면출력순서")
	private String upScrnOputSqn  ;  /*상위화면출력순서    */

	@ApiModelProperty(notes= "하위화면출력순서")
	private String downScrnOputSqn  ;  /*하위화면출력순서    */
	
	@ApiModelProperty(notes= "시작전화면출력순서")
	private String strtScrnOputSqn  ;  /*시작전화면출력순서    */
	
	@ApiModelProperty(notes= "종료후화면출력순서")
	private String endScrnOputSqn  ; /*종료후화면출력순서    */

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

	public String getPsitScrnId() {
		return psitScrnId;
	}

	public void setPsitScrnId(String psitScrnId) {
		this.psitScrnId = psitScrnId;
	}

	public String getScrnNm() {
		return scrnNm;
	}

	public void setScrnNm(String scrnNm) {
		this.scrnNm = scrnNm;
	}

	public String getScrnOputSqn() {
		return scrnOputSqn;
	}

	public void setScrnOputSqn(String scrnOputSqn) {
		this.scrnOputSqn = scrnOputSqn;
	}

	public String getMenuDpthVl() {
		return menuDpthVl;
	}

	public void setMenuDpthVl(String menuDpthVl) {
		this.menuDpthVl = menuDpthVl;
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

	public String getUpScrnOputSqn() {
		return upScrnOputSqn;
	}

	public void setUpScrnOputSqn(String upScrnOputSqn) {
		this.upScrnOputSqn = upScrnOputSqn;
	}

	public String getDownScrnOputSqn() {
		return downScrnOputSqn;
	}

	public void setDownScrnOputSqn(String downScrnOputSqn) {
		this.downScrnOputSqn = downScrnOputSqn;
	}

	public String getStrtScrnOputSqn() {
		return strtScrnOputSqn;
	}

	public void setStrtScrnOputSqn(String strtScrnOputSqn) {
		this.strtScrnOputSqn = strtScrnOputSqn;
	}

	public String getEndScrnOputSqn() {
		return endScrnOputSqn;
	}

	public void setEndScrnOputSqn(String endScrnOputSqn) {
		this.endScrnOputSqn = endScrnOputSqn;
	}
	
	

	
	
}
