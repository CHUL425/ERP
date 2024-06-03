/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GASR1000U0In00VO.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인장조제관리 목록조회 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.sr.vo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GASR1000U0In00VO {

	@ApiModelProperty(notes= "본지점구분코드")
    private String hobrTcd         ; /*본지점구분코드   */
    @ApiModelProperty(notes= "인장유형코드")
    private String salPcd        ; /*인장유형코드    */
    @ApiModelProperty(notes= "관리조직코드")
    private String mtOrzCd         ; /*관리조직코드     */
    @ApiModelProperty(notes= "인감상태코드")
    private String sealScd         ; /*인감상태코드     */
    
	@ApiModelProperty(notes= "인감상태코드-멀티선택가능", example="02,05")
	private String strArrSealScd; 
	
    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;      // 페이지사이즈
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;     // 페이지순번
	@ApiModelProperty(notes= "총건수-결과값세팅용")
	private long totCnt ; /* 총건수 */

    @ApiModelProperty(hidden=true)
    private List<String> arrSalPcd; /* 인장유형코드 배열 */
    
	@ApiModelProperty(hidden=true)
	private List<String> arrSealScd; /* 인감상태코드 배열 */

	public String getHobrTcd() {
		return hobrTcd;
	}

	public void setHobrTcd(String hobrTcd) {
		this.hobrTcd = hobrTcd;
	}

	public String getSalPcd() {
		return salPcd;
	}

	public void setSalPcd(String salPcd) {
		this.salPcd = salPcd;
	}

	public String getMtOrzCd() {
		return mtOrzCd;
	}

	public void setMtOrzCd(String mtOrzCd) {
		this.mtOrzCd = mtOrzCd;
	}

	public String getStrArrSealScd() {
		return strArrSealScd;
	}

	public void setStrArrSealScd(String strArrSealScd) {
		this.strArrSealScd = strArrSealScd;
	}

	public String getSealScd() {
		return sealScd;
	}

	public void setSealScd(String sealScd) {
		this.sealScd = sealScd;
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

	public List<String> getArrSalPcd() {
		return arrSalPcd;
	}

	public void setArrSalPcd(List<String> arrSalPcd) {
		this.arrSalPcd = arrSalPcd;
	}

	public List<String> getArrSealScd() {
		return arrSealScd;
	}

	public void setArrSealScd(List<String> arrSealScd) {
		this.arrSealScd = arrSealScd;
	}

	public long getTotCnt() {
		return totCnt;
	}

	public void setTotCnt(long totCnt) {
		this.totCnt = totCnt;
	}

}

    
