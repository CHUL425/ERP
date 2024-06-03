/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: SSBS6000U0Out00VO.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹_화면 목록조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.bs.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class SSBS7000U0Out00VO {
	
    @ApiModelProperty(notes = "사용자그룹코드")
    private String userGrpCd     ;  /*사용자그룹코드*/      
    @ApiModelProperty(notes = "그룹명")
    private String grpNm         ;  /*그룹명 */  
    @ApiModelProperty(notes = "포털사이트메뉴ID")
    private String psitMenuId    ;  /*포털사이트메뉴ID*/ 
    @ApiModelProperty(notes = "화면명")
    private String scrnNm        ;  /*화면명 */  
    @ApiModelProperty(notes = "처리가능여부")
    private String prcAblYn      ;  /*처리가능여부*/ 
    @ApiModelProperty(notes = "전사접근가능여부")
    private String enpAccsAblYn  ;  /*전사접근가능여부*/
    @ApiModelProperty(notes = "신청상태코드")
    private String rqsScd        ;  /*신청상태코드*/  
    @ApiModelProperty(notes = "신청상태코드명")
    private String rqsScdNm      ;  /*신청상태코드명*/  
    @ApiModelProperty(notes = "접수번호")
    private String rctNo         ;  /*접수번호*/   
    @ApiModelProperty(notes = "접수일자")
    private String rqsDt         ;  /*접수일자*/   
    
    @ApiModelProperty(notes = "기안문서번호")
    private String drftDocNo     ;  /*기안문서번호 */
    
    @ApiModelProperty(notes = "기안문서명")
    private String drftDocTtlNm  ;  /*기안문서명 */
    
	@ApiModelProperty(notes= "결재순위")
	private String aprvRnk        ; /*결재순위          */
	
	@ApiModelProperty(notes= "결재상신관리번호")
	private String aprvWrrptMtNo;	
    
	@ApiModelProperty(notes= "결재유형코드 ")
	private String aprvPcd;	
	
	@ApiModelProperty(notes= "순번", example="0")
	private BigDecimal rnum       ; /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수             */
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
	public BigDecimal getRnum() {
		return rnum;
	}
	public void setRnum(BigDecimal rnum) {
		this.rnum = rnum;
	}
	public BigDecimal getAlCnt() {
		return alCnt;
	}
	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
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
	public String getAprvPcd() {
		return aprvPcd;
	}
	public void setAprvPcd(String aprvPcd) {
		this.aprvPcd = aprvPcd;
	}
	
	
    
}
