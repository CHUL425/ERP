/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: SSBS7000U0In04VO.java
*	04. 작  성  일  자	: 2023.09.06
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹_화면 상신 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.bs.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SSBS7000U0In04VO {

	@ApiModelProperty(notes= "처리구분: 00-임시저장 01-상신 ", required = true,example = "00")
	private String prcTp           ; /*처리구분         */

	@ApiModelProperty(notes= "신청조직코드(로그인조직코드) 입력세팅안해도됨" , required = true)
	private String rqsOrzCd        ; /*신청조직코드     */
	@ApiModelProperty(notes= "신청사원번호(로그인사번) 입력세팅안해도됨" , required = true)
	private String rqsEpno         ; /*신청사원번호     */

    @ApiModelProperty(notes = "사용자그룹코드")
    private String userGrpCd     ;  /*사용자그룹코드*/      
    @ApiModelProperty(notes = "포털사이트메뉴ID")
    private String psitMenuId    ;  /*포털사이트메뉴ID*/ 
    @ApiModelProperty(notes = "처리가능여부")
    private String prcAblYn      ;  /*처리가능여부*/ 
    @ApiModelProperty(notes = "전사접근가능여부")
    private String enpAccsAblYn  ;  /*전사접근가능여부*/
    @ApiModelProperty(notes= "기안문서번호" )
    private String drftDocNo;        // 기안문서번호
	public String getPrcTp() {
		return prcTp;
	}
	public void setPrcTp(String prcTp) {
		this.prcTp = prcTp;
	}
	public String getRqsOrzCd() {
		return rqsOrzCd;
	}
	public void setRqsOrzCd(String rqsOrzCd) {
		this.rqsOrzCd = rqsOrzCd;
	}
	public String getRqsEpno() {
		return rqsEpno;
	}
	public void setRqsEpno(String rqsEpno) {
		this.rqsEpno = rqsEpno;
	}
	public String getUserGrpCd() {
		return userGrpCd;
	}
	public void setUserGrpCd(String userGrpCd) {
		this.userGrpCd = userGrpCd;
	}
	public String getPsitMenuId() {
		return psitMenuId;
	}
	public void setPsitMenuId(String psitMenuId) {
		this.psitMenuId = psitMenuId;
	}
	public String getPrcAblYn() {
		return prcAblYn;
	}
	public void setPrcAblYn(String prcAblYn) {
		this.prcAblYn = prcAblYn;
	}
	public String getEnpAccsAblYn() {
		return enpAccsAblYn;
	}
	public void setEnpAccsAblYn(String enpAccsAblYn) {
		this.enpAccsAblYn = enpAccsAblYn;
	}
	public String getDrftDocNo() {
		return drftDocNo;
	}
	public void setDrftDocNo(String drftDocNo) {
		this.drftDocNo = drftDocNo;
	}

    
}

    
