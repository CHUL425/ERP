package com.miraeasset.biz.rq.nr.vo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQNR2000U0In00VO {
	
	@ApiModelProperty(notes= "신청유형코드 02:구매, 04:명함", required = true)
    private String unifRqsPcd;            // 조회시작일자
    @ApiModelProperty(notes= "조회시작일자", required = true)
    private String qryStrtDt;            // 조회시작일자
    @ApiModelProperty(notes= "조회종료일자", required = true)
    private String qryEndDt;            // 조회종료일자
    @ApiModelProperty(notes= "신청조직코드")
    private String rqsOrzCd      ; /*신청조직코드    */
    @ApiModelProperty(notes= "신청사원번호")
    private String rqsEpno       ; /*신청사원번호    */
    //@ApiModelProperty(notes= "신청제목명(삭제가능성있음)")
    //private String rqsTtlNm      ; /*신청제목명      */
    //@ApiModelProperty(notes= "조직대표자여부(Y/N)")
    //private String orzRptvYn; 
	@ApiModelProperty(notes= "신청상태코드")
	private String rqsScd        ; /*신청상태코드*/ 
    
    @ApiModelProperty(notes= "로그인사번")
    private String epno;
    
    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;      // 페이지사이즈
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;     // 페이지순번
    
    @ApiModelProperty(hidden=true)
    private List<String> arrRqsScd; /* 신청상태코드_배열 */
    
	public String getUnifRqsPcd() {
		return unifRqsPcd;
	}
	public void setUnifRqsPcd(String unifRqsPcd) {
		this.unifRqsPcd = unifRqsPcd;
	}
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
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
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
	public String getRqsScd() {
		return rqsScd;
	}
	public void setRqsScd(String rqsScd) {
		this.rqsScd = rqsScd;
	} 
}
