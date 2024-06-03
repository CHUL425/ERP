/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS5000U0Out01VO.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 화면관리 상세조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.bs.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class SSBS5000U0Out01VO {
	
    @ApiModelProperty(notes= "포털사이트메뉴ID")
    private String psitMenuId  ;  /*포털사이트메뉴ID*/
    @ApiModelProperty(notes= "화면명")
    private String scrnNm      ;  /*화면명          */
    @ApiModelProperty(notes= "화면유형코드")
    private String scrnPcd     ;  /*화면유형코드    */
    @ApiModelProperty(notes= "URL주소 ")
    private String urlAdr      ;  /*URL주소         */
    @ApiModelProperty(notes= "사용여부")
    private String useYn       ;  /*사용여부        */
    @ApiModelProperty(notes= "화면출력순서")
    private String scrnOputSqn ;  /*화면출력순서    */

    @ApiModelProperty(notes= "화면담당자1")
    private String epno1 ;  /*화면담당자1    */
    @ApiModelProperty(notes= "화면담당자명1")
    private String epNm1 ;  /*화면담당자명1    */
    @ApiModelProperty(notes= "정담당자여부1")
    private String mchprYn1 ;  /*정담당자여부1    */
    @ApiModelProperty(notes= "직위명1")
    private String hrPstNm1       ;  /*직위명1*/            
    @ApiModelProperty(notes= "내선번호1")
    private String intaTlno1    ;  /*내선번호1*/ 
    @ApiModelProperty(notes= "조직명1")
    private String orzNm1         ;  /*조직명1*/      

    @ApiModelProperty(notes= "화면담당자2")
    private String epno2 ;  /*화면담당자2    */
    @ApiModelProperty(notes= "화면담당자명2")
    private String epNm2 ;  /*화면담당자명2    */
    @ApiModelProperty(notes= "정담당자여부2")
    private String mchprYn2 ;  /*정담당자여부2    */
    @ApiModelProperty(notes= "직위명2")
    private String hrPstNm2       ;  /*직위명2*/            
    @ApiModelProperty(notes= "내선번호2")
    private String intaTlno2    ;  /*내선번호2*/ 
    @ApiModelProperty(notes= "조직명2")
    private String orzNm2         ;  /*조직명2*/       

    @ApiModelProperty(notes= "화면담당자3")
    private String epno3 ;  /*화면담당자3    */
    @ApiModelProperty(notes= "화면담당자명3")
    private String epNm3 ;  /*화면담당자명3    */
    @ApiModelProperty(notes= "정담당자여부3")
    private String mchprYn3 ;  /*정담당자여부3    */
    @ApiModelProperty(notes= "직위명3")
    private String hrPstNm3       ;  /*직위명3*/            
    @ApiModelProperty(notes= "내선번호3")
    private String intaTlno3    ;  /*내선번호3*/ 
    @ApiModelProperty(notes= "조직명3")
    private String orzNm3         ;  /*조직명3*/       
    
    @ApiModelProperty(notes= "태그")
    private String kwrdCn ;  /*키워드내용    */

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

	public String getEpno1() {
		return epno1;
	}

	public void setEpno1(String epno1) {
		this.epno1 = epno1;
	}

	public String getEpNm1() {
		return epNm1;
	}

	public void setEpNm1(String epNm1) {
		this.epNm1 = epNm1;
	}

	public String getMchprYn1() {
		return mchprYn1;
	}

	public void setMchprYn1(String mchprYn1) {
		this.mchprYn1 = mchprYn1;
	}

	public String getHrPstNm1() {
		return hrPstNm1;
	}

	public void setHrPstNm1(String hrPstNm1) {
		this.hrPstNm1 = hrPstNm1;
	}

	public String getIntaTlno1() {
		return intaTlno1;
	}

	public void setIntaTlno1(String intaTlno1) {
		this.intaTlno1 = intaTlno1;
	}

	public String getOrzNm1() {
		return orzNm1;
	}

	public void setOrzNm1(String orzNm1) {
		this.orzNm1 = orzNm1;
	}

	public String getEpno2() {
		return epno2;
	}

	public void setEpno2(String epno2) {
		this.epno2 = epno2;
	}

	public String getEpNm2() {
		return epNm2;
	}

	public void setEpNm2(String epNm2) {
		this.epNm2 = epNm2;
	}

	public String getMchprYn2() {
		return mchprYn2;
	}

	public void setMchprYn2(String mchprYn2) {
		this.mchprYn2 = mchprYn2;
	}

	public String getHrPstNm2() {
		return hrPstNm2;
	}

	public void setHrPstNm2(String hrPstNm2) {
		this.hrPstNm2 = hrPstNm2;
	}

	public String getIntaTlno2() {
		return intaTlno2;
	}

	public void setIntaTlno2(String intaTlno2) {
		this.intaTlno2 = intaTlno2;
	}

	public String getOrzNm2() {
		return orzNm2;
	}

	public void setOrzNm2(String orzNm2) {
		this.orzNm2 = orzNm2;
	}

	public String getEpno3() {
		return epno3;
	}

	public void setEpno3(String epno3) {
		this.epno3 = epno3;
	}

	public String getEpNm3() {
		return epNm3;
	}

	public void setEpNm3(String epNm3) {
		this.epNm3 = epNm3;
	}

	public String getMchprYn3() {
		return mchprYn3;
	}

	public void setMchprYn3(String mchprYn3) {
		this.mchprYn3 = mchprYn3;
	}

	public String getHrPstNm3() {
		return hrPstNm3;
	}

	public void setHrPstNm3(String hrPstNm3) {
		this.hrPstNm3 = hrPstNm3;
	}

	public String getIntaTlno3() {
		return intaTlno3;
	}

	public void setIntaTlno3(String intaTlno3) {
		this.intaTlno3 = intaTlno3;
	}

	public String getOrzNm3() {
		return orzNm3;
	}

	public void setOrzNm3(String orzNm3) {
		this.orzNm3 = orzNm3;
	}

	public String getKwrdCn() {
		return kwrdCn;
	}

	public void setKwrdCn(String kwrdCn) {
		this.kwrdCn = kwrdCn;
	}
    
    
	
}
