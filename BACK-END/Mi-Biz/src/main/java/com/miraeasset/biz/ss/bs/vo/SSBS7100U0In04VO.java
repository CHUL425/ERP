/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS7100U0In04VO.java
*	04. 작  성  일  자	: 2023.09.06
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹_사용자관리 임시저정/상신 단건 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.bs.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SSBS7100U0In04VO {

	@ApiModelProperty(notes= "처리구분: 00-임시저장 01-상신 ", required = true,example = "00")
	private String prcTp           ; /*처리구분         */

	@ApiModelProperty(notes= "신청조직코드(로그인조직코드) 입력세팅안해도됨" , required = true)
	private String rqsOrzCd        ; /*신청조직코드     */
	@ApiModelProperty(notes= "신청사원번호(로그인사번) 입력세팅안해도됨" , required = true)
	private String rqsEpno         ; /*신청사원번호     */

    @ApiModelProperty(notes = "사용자그룹코드")
    private String userGrpCd     ;  /*사용자그룹코드*/      
    @ApiModelProperty(notes = "직원조직구분코드")
    private String empOrzTcd     ;  /*직원조직구분코드 */
    @ApiModelProperty(notes = "조직코드")
    private String orzCd         ;  /*조직코드 */
    @ApiModelProperty(notes = "사원번호")
    private String epno          ;  /*사원번호 */ 
    @ApiModelProperty(notes = "신청상태코드")
    private String rqsScd        ;  /*신청상태코드 */
    @ApiModelProperty(notes = "접수번호")
    private String rctNo         ;  /*접수번호 */
    @ApiModelProperty(notes = "신청일자")
    private String rqsDt         ;  /*신청일자 */
    @ApiModelProperty(notes = "시작일자")
    private String strtDt        ;  /*시작일자 */
    @ApiModelProperty(notes = "종료일자")
    private String endDt         ;  /*종료일자 */
    
    @ApiModelProperty(notes = "기안문서번호")
    private String drftDocNo     ;  /*기안문서번호 */

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

	public String getEmpOrzTcd() {
		return empOrzTcd;
	}

	public void setEmpOrzTcd(String empOrzTcd) {
		this.empOrzTcd = empOrzTcd;
	}

	public String getOrzCd() {
		return orzCd;
	}

	public void setOrzCd(String orzCd) {
		this.orzCd = orzCd;
	}

	public String getEpno() {
		return epno;
	}

	public void setEpno(String epno) {
		this.epno = epno;
	}

	public String getRqsScd() {
		return rqsScd;
	}

	public void setRqsScd(String rqsScd) {
		this.rqsScd = rqsScd;
	}

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public String getRqsDt() {
		return rqsDt;
	}

	public void setRqsDt(String rqsDt) {
		this.rqsDt = rqsDt;
	}

	public String getStrtDt() {
		return strtDt;
	}

	public void setStrtDt(String strtDt) {
		this.strtDt = strtDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getDrftDocNo() {
		return drftDocNo;
	}

	public void setDrftDocNo(String drftDocNo) {
		this.drftDocNo = drftDocNo;
	}
    
    
    
}

    
