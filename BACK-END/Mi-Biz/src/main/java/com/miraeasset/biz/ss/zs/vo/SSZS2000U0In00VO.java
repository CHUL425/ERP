/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSZS2000U0In00VO.java
*	04. 작  성  일  자	: 2023.10.16
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 알림관리 목록조회 in
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.zs.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SSZS2000U0In00VO {
	    
    @ApiModelProperty(notes= "조회구분코드 00:전체 01:알림코드 02:알림제목 03:구분 04:사용여부 05:알림내용 06:매체구분코드 ")
    private String srchTcd    ;  /*조회구분코드   */    

    @ApiModelProperty(notes= "조회조건값")
    private String srchVl   		;  /*조회조건값      */
    
    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;      // 페이지사이즈
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;     // 페이지순번
    

	public String getSrchTcd() {
		return srchTcd;
	}

	public void setSrchTcd(String srchTcd) {
		this.srchTcd = srchTcd;
	}

	public String getSrchVl() {
		return srchVl;
	}

	public void setSrchVl(String srchVl) {
		this.srchVl = srchVl;
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
