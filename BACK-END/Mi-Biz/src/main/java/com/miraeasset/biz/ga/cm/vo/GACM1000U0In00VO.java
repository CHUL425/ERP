/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GACM1000U0In00VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 계약서관리 목록조회 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.cm.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GACM1000U0In00VO {

    @ApiModelProperty(notes= "조회시작일자", required = true)
    private String qryStrtDt;            // 조회시작일자
    @ApiModelProperty(notes= "조회종료일자", required = true)
    private String qryEndDt;            // 조회종료일자

	@ApiModelProperty(notes= "계약구분코드")
	private String cntcTcd          ; /*계약구분코드 */
	
	@ApiModelProperty(notes= "업체선정방법코드")
	private String entpSeltMcd      ; /*업체선정방법코드 */

    @ApiModelProperty(notes= "업체코드" )
    private String delpCd;            // 업체코드
    @ApiModelProperty(notes= "계약명" )
    private String cntcNm;            // 계약명
	@ApiModelProperty(notes= "계정코드")
	private String actgAcsjCd       ; /*계정코드*/    
    
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
	public String getCntcTcd() {
		return cntcTcd;
	}
	public void setCntcTcd(String cntcTcd) {
		this.cntcTcd = cntcTcd;
	}
	public String getEntpSeltMcd() {
		return entpSeltMcd;
	}
	public void setEntpSeltMcd(String entpSeltMcd) {
		this.entpSeltMcd = entpSeltMcd;
	}
	public String getDelpCd() {
		return delpCd;
	}
	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}
	public String getCntcNm() {
		return cntcNm;
	}
	public void setCntcNm(String cntcNm) {
		this.cntcNm = cntcNm;
	}
	public String getActgAcsjCd() {
		return actgAcsjCd;
	}
	public void setActgAcsjCd(String actgAcsjCd) {
		this.actgAcsjCd = actgAcsjCd;
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
    
