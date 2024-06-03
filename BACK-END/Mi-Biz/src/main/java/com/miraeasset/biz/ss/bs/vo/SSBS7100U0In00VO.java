/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS7100U0In00VO.java
*	04. 작  성  일  자	: 2023.09.12
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹_사용자관리 목록조회 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.bs.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SSBS7100U0In00VO {
	
    @ApiModelProperty(notes= "조회시작일자", required = true)
    private String qryStrtDt;            // 조회시작일자
    @ApiModelProperty(notes= "조회종료일자", required = true)
    private String qryEndDt;            // 조회종료일자
    
    @ApiModelProperty(notes= "사원조직구분코드 01:사원 02:조직", required = true)
    private String empOrzTcd  ;  /* 사원조직구분코드  */
    
    @ApiModelProperty(notes= "사용자그룹코드")
    private String userGrpCd  ;  /* 사용자그룹코드  */
    @ApiModelProperty(notes= "조직코드")
    private String orzCd      ;  /* 조직코드   */     
    @ApiModelProperty(notes= "사원번호")
    private String epno       ;  /* 사원번호    */    
    @ApiModelProperty(notes= "신청상태코드")
    private String rqsScd	  ;  /* 신청상태코드 */     
    
    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;      // 페이지사이즈
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;     // 페이지순번
	public String getQryStrtDt() {
		return qryStrtDt;
	}
	public void setQryStrtDt(String qryStrtDt) {
		this.qryStrtDt = qryStrtDt;
	}
	public String getQryEndDt() {
		return qryEndDt;
	}
	public void setQryEndDt(String qryEndDt) {
		this.qryEndDt = qryEndDt;
	}
	public String getEmpOrzTcd() {
		return empOrzTcd;
	}
	public void setEmpOrzTcd(String empOrzTcd) {
		this.empOrzTcd = empOrzTcd;
	}
	public String getUserGrpCd() {
		return userGrpCd;
	}
	public void setUserGrpCd(String userGrpCd) {
		this.userGrpCd = userGrpCd;
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
	public BigDecimal getPageSize() {
		return pageSize;
	}
	public void setPageSize(BigDecimal pageSize) {
		this.pageSize = pageSize;
	}
	public BigDecimal getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(BigDecimal pageIndex) {
		this.pageIndex = pageIndex;
	}
    

    
}

    
