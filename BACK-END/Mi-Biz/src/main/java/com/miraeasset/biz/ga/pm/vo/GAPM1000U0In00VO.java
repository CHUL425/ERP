/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GAPM1000U0In00VO.java
*	04. 작  성  일  자	: 2023.07.03
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 정기주차권관리 목록조회 in
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.pm.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAPM1000U0In00VO {

	@ApiModelProperty(notes= "유무료구분코드 01:무료 02:유료")
	private String chfTcd     ; /* 유무료구분코드 */			 
	@ApiModelProperty(notes= "사용자조직코드")
	private String userOrzCd  ; /* 사용자조직코드 */		
	@ApiModelProperty(notes= "사용자사원번호")
	private String userEpno   ; /* 사용자사원번호 */		
	@ApiModelProperty(notes= "차량번호")
	private String vhcNo      ; /* 차량번호 */		   

    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;      // 페이지사이즈
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;     // 페이지순번
	public String getChfTcd() {
		return chfTcd;
	}
	public void setChfTcd(String chfTcd) {
		this.chfTcd = chfTcd;
	}
	public String getUserOrzCd() {
		return userOrzCd;
	}
	public void setUserOrzCd(String userOrzCd) {
		this.userOrzCd = userOrzCd;
	}
	public String getUserEpno() {
		return userEpno;
	}
	public void setUserEpno(String userEpno) {
		this.userEpno = userEpno;
	}
	public String getVhcNo() {
		return vhcNo;
	}
	public void setVhcNo(String vhcNo) {
		this.vhcNo = vhcNo;
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
    
