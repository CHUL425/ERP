package com.miraeasset.biz.rq.cr.vo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQCR1000U0In00VO {
	
	@ApiModelProperty(notes = "조회시작일자")
	private String qryStrtDt		; /* 신청일 >= 시작일자 */
	
	@ApiModelProperty(notes = "조회종료일자")
	private String qryEndDt			; /* 신청일 <= 종료일자 */
	
	@ApiModelProperty(notes= "접수번호")
    private String rctNo;           /* 접수번호 */ 
	
	/* 신청구분코드(분류 전체(default) /인테리어(유지보수) / 조명/전등 / 냉난방기구류 / 간판류(사인물) / 전자제품류 / 가구류 / 기타) */
	@ApiModelProperty(notes = "신청구분")
	private String unifRqsDlPcd			; 
	
	@ApiModelProperty(notes= "신청상태코드")
	private String rqsScd          ; /* 신청상태코드 */
	
	@ApiModelProperty(notes = "유형")
	private String unifRqsTcd			; /* 신청구분코드(신규/AS/철거/기타) */
	
	@ApiModelProperty(notes = "신청부서")
	private String rqsOrzNm			; /* 부서코드, 부서명  */
	
	@ApiModelProperty(notes = "신청부서")
	private String rqsEpNm			; /* 신청사번, 신청자명  */
	
	@ApiModelProperty(notes = "신청명")
	private String rqsTtlNm			; /* 신청제목명-신청명  */

	@ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;      // 페이지사이즈
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;     // 페이지순번
    
    @ApiModelProperty(hidden=true)
    private List<String> arrRqsScd; /* 신청상태코드_배열 */
    
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
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	public String getUnifRqsDlPcd() {
		return unifRqsDlPcd;
	}
	public void setUnifRqsDlPcd(String unifRqsDlPcd) {
		this.unifRqsDlPcd = unifRqsDlPcd;
	}
	public String getRqsScd() {
		return rqsScd;
	}
	public void setRqsScd(String rqsScd) {
		this.rqsScd = rqsScd;
	}
	public String getUnifRqsTcd() {
		return unifRqsTcd;
	}
	public void setUnifRqsTcd(String unifRqsTcd) {
		this.unifRqsTcd = unifRqsTcd;
	}
	public String getRqsOrzNm() {
		return rqsOrzNm;
	}
	public void setRqsOrzNm(String rqsOrzNm) {
		this.rqsOrzNm = rqsOrzNm;
	}
	public String getRqsEpNm() {
		return rqsEpNm;
	}
	public void setRqsEpNm(String rqsEpNm) {
		this.rqsEpNm = rqsEpNm;
	}
	public String getRqsTtlNm() {
		return rqsTtlNm;
	}
	public void setRqsTtlNm(String rqsTtlNm) {
		this.rqsTtlNm = rqsTtlNm;
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
	
	public List<String> getArrRqsScd() {
		return arrRqsScd;
	}
	public void setArrRqsScd(List<String> arrRqsScd) {
		this.arrRqsScd = arrRqsScd;
	}
	
}
