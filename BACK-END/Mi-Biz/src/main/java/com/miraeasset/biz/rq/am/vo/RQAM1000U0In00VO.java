package com.miraeasset.biz.rq.am.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.login.vo.LoginOutVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQAM1000U0In00VO extends LoginOutVO {

    @ApiModelProperty(notes= "결재유형코드", example = "01.공사신청, 02.구매신청, 03.렌탈신청, 04.명함신청, 05.인감날인, 06.인감조제, 09.문서신청, 91.사용자그룹, 92.화면권한")
    private String bizTcd          ; /* 업무구분 */

    @ApiModelProperty(notes= "신청명")
    private String rqsTtlNm          ; /* 신청명 */
    
    @ApiModelProperty(notes= "신청사유내용")
    private String rqsRsnCn          ; /* 신청사유내용 */
    
    @ApiModelProperty(notes= "상신자사원번호")
    private String wrrptEpno          ; /* 상신자사원번호 */

    @ApiModelProperty(notes= "상신자명")
    private String wrrptEpNm          ; /* 상신자명 */
    
    
    @ApiModelProperty(notes= "결재상신조직코드")
    private String aprvWrrptOrzCd          ; /* 결재상신조직코드 */
    
    @ApiModelProperty(notes= "결재자사원번호")
    private String aprvEpno          ; /* 결재자사원번호 */
    
    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;      // 페이지사이즈

    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;     // 페이지순번


	@ApiModelProperty(notes= "페이지번호")
	private long pageNum;


	@ApiModelProperty(notes= "결재자유형코드", example = " '':참조 외, 00:상신, 01:결재, 02:협조, 09:참조")
	private String dcfcPcd;


	@ApiModelProperty(notes= "조회타입", example = " '':전체, rqam:승인관리, rqsr:인감")
	private String selTyp;
	
	@ApiModelProperty(notes= "인감 총건수-결과값세팅용")
	private long totCnt ; 

	public long getPageNum() {return pageNum;}public void setPageNum(long pageNum) {this.pageNum = pageNum;}

	public String getDcfcPcd() { return dcfcPcd; } public void setDcfcPcd(String dcfcPcd) { this.dcfcPcd = dcfcPcd; }
	public String getSelTyp() { return selTyp; } public void setSelTyp(String selTyp) { this.selTyp = selTyp; }

	public String getBizTcd() {
		return bizTcd;
	}
	public void setBizTcd(String bizTcd) {
		this.bizTcd = bizTcd;
	}
	public String getWrrptEpNm() {
		return wrrptEpNm;
	}
	public void setWrrptEpNm(String wrrptEpNm) {
		this.wrrptEpNm = wrrptEpNm;
	}
	public String getWrrptEpno() {
		return wrrptEpno;
	}
	public void setWrrptEpno(String wrrptEpno) {
		this.wrrptEpno = wrrptEpno;
	}
	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}
	public void setAprvWrrptOrzCd(String aprvWrrptOrzCd) {
		this.aprvWrrptOrzCd = aprvWrrptOrzCd;
	}
	public String getAprvEpno() {
		return aprvEpno;
	}
	public void setAprvEpno(String aprvEpno) {
		this.aprvEpno = aprvEpno;
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
	public String getRqsRsnCn() {
		return rqsRsnCn;
	}
	public void setRqsRsnCn(String rqsRsnCn) {
		this.rqsRsnCn = rqsRsnCn;
	}
	public String getRqsTtlNm() {
		return rqsTtlNm;
	}
	public void setRqsTtlNm(String rqsTtlNm) {
		this.rqsTtlNm = rqsTtlNm;
	}

	public long getTotCnt() {
		return totCnt;
	}

	public void setTotCnt(long totCnt) {
		this.totCnt = totCnt;
	}

}
    
