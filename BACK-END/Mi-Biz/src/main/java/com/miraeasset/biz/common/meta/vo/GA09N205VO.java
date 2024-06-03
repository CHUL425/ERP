/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA09N205VO.java
*	04. 작  성  일  자	: 2023.09.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA09N205	사용자그룹_화면 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N205VO extends BaseVO {
	
    @ApiModelProperty(notes = "사용자그룹코드")
    private String userGrpCd     ;  /*사용자그룹코드*/      
    @ApiModelProperty(notes = "그룹명 출력용")
    private String grpNm         ;  /*그룹명 */  
    @ApiModelProperty(notes = "포털사이트메뉴ID")
    private String psitMenuId    ;  /*포털사이트메뉴ID*/ 
    @ApiModelProperty(notes = "화면명 출력용")
    private String scrnNm        ;  /*화면명 */  
    @ApiModelProperty(notes = "처리가능여부")
    private String prcAblYn      ;  /*처리가능여부*/ 
    @ApiModelProperty(notes = "전사접근가능여부")
    private String enpAccsAblYn  ;  /*전사접근가능여부*/
    @ApiModelProperty(notes = "신청상태코드")
    private String rqsScd        ;  /*신청상태코드*/  
    @ApiModelProperty(notes = "신청상태코드명 출력용")
    private String rqsScdNm      ;  /*신청상태코드명*/  
    @ApiModelProperty(notes = "접수번호")
    private String rctNo         ;  /*접수번호*/   
    @ApiModelProperty(notes = "접수일자")
    private String rqsDt         ;  /*접수일자*/
    
    @ApiModelProperty(notes = "기안문서번호")
    private String drftDocNo     ;  /*기안문서번호 */
    
    @ApiModelProperty(notes = "기안문서명")
    private String drftDocTtlNm  ;  /*기안문서명 */
    
    

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
    

    
    
}
