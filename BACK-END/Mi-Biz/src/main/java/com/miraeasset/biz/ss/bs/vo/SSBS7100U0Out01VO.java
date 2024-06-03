/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS7100U0Out01VO.java
*	04. 작  성  일  자	: 2023.09.27
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹_사용자관리 상세조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.bs.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class SSBS7100U0Out01VO {
	
    @ApiModelProperty(notes = "사용자그룹코드")
    private String userGrpCd     ;  /*사용자그룹코드*/      

    @ApiModelProperty(notes = "그룹명")
    private String grpNm         ;  /*그룹명*/
    @ApiModelProperty(notes = "직원조직구분코드")
    private String empOrzTcd     ;  /*직원조직구분코드 */
    @ApiModelProperty(notes = "직원조직구분코드명")
    private String empOrzTcdNm   ;  /*직원조직구분코드명 */
    @ApiModelProperty(notes = "조직코드")
    private String orzCd         ;  /*조직코드 */
    @ApiModelProperty(notes = "조직명")
    private String orzCdNm       ;  /*조직명*/
    @ApiModelProperty(notes = "사원번호")
    private String epno          ;  /*사원번호 */ 
    @ApiModelProperty(notes = "사원명")
    private String epNm          ;  /*사원명 */ 
    @ApiModelProperty(notes = "신청상태코드")
    private String rqsScd        ;  /*신청상태코드 */
    @ApiModelProperty(notes = "신청상태코드명")
    private String rqsScdNm      ;  /*신청상태코드명 */
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
    
    @ApiModelProperty(notes = "기안문서명")
    private String drftDocTtlNm  ;  /*기안문서명 */
        
    
	@ApiModelProperty(notes= "결재순위")
	private String aprvRnk        ; /*결재순위          */
	
	@ApiModelProperty(notes= "결재상신관리번호")
	private String aprvWrrptMtNo;

	public String getUserGrpCd() {
		return userGrpCd;
	}

	public void setUserGrpCd(String userGrpCd) {
		this.userGrpCd = userGrpCd;
	}

	public String getGrpNm() {
		return grpNm;
	}

	public void setGrpNm(String grpNm) {
		this.grpNm = grpNm;
	}

	public String getEmpOrzTcd() {
		return empOrzTcd;
	}

	public void setEmpOrzTcd(String empOrzTcd) {
		this.empOrzTcd = empOrzTcd;
	}

	public String getEmpOrzTcdNm() {
		return empOrzTcdNm;
	}

	public void setEmpOrzTcdNm(String empOrzTcdNm) {
		this.empOrzTcdNm = empOrzTcdNm;
	}

	public String getOrzCd() {
		return orzCd;
	}

	public void setOrzCd(String orzCd) {
		this.orzCd = orzCd;
	}

	public String getOrzCdNm() {
		return orzCdNm;
	}

	public void setOrzCdNm(String orzCdNm) {
		this.orzCdNm = orzCdNm;
	}

	public String getEpno() {
		return epno;
	}

	public void setEpno(String epno) {
		this.epno = epno;
	}

	public String getEpNm() {
		return epNm;
	}

	public void setEpNm(String epNm) {
		this.epNm = epNm;
	}

	public String getRqsScd() {
		return rqsScd;
	}

	public void setRqsScd(String rqsScd) {
		this.rqsScd = rqsScd;
	}

	public String getRqsScdNm() {
		return rqsScdNm;
	}

	public void setRqsScdNm(String rqsScdNm) {
		this.rqsScdNm = rqsScdNm;
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

	public String getDrftDocTtlNm() {
		return drftDocTtlNm;
	}

	public void setDrftDocTtlNm(String drftDocTtlNm) {
		this.drftDocTtlNm = drftDocTtlNm;
	}

	public String getAprvRnk() {
		return aprvRnk;
	}

	public void setAprvRnk(String aprvRnk) {
		this.aprvRnk = aprvRnk;
	}

	public String getAprvWrrptMtNo() {
		return aprvWrrptMtNo;
	}

	public void setAprvWrrptMtNo(String aprvWrrptMtNo) {
		this.aprvWrrptMtNo = aprvWrrptMtNo;
	}	
    

    
}
