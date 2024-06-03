/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0In21VO.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인감날인증명서신청 승인대기 내역조회 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0In21VO {

//	@ApiModelProperty(notes= "로그인사번 입력세팅안해도됨 ")
//	private String lginEpno           ; /* 로그인사번     */
//	@ApiModelProperty(notes= "로그인조직코드 입력세팅안해도됨")
//	private String lginOrzCd           ; /* 로그인조직코드     */
//	@ApiModelProperty(notes= "로그인직책코드 입력세팅안해도됨")
//	private String hrOsdtCd            ; /* 로그인직책코드     */
	@ApiModelProperty(notes= "로그인사번 입력세팅안해도됨 ")
	private String epno           ; /* 로그인사번     */
	
	@ApiModelProperty(notes= "결재상신조직코드")
	private String aprvWrrptOrzCd           ; /* 결재상신조직코드     */
	@ApiModelProperty(notes= "신청제목명")
	private String rqsTtlNm           ; /* 신청제목명     */

    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;      // 페이지사이즈
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;     // 페이지순번
    
	@ApiModelProperty(notes= "결재유형코드", example = "01.공사신청, 02.구매신청, 03.렌탈신청, 04.명함신청, 05.인감날인, 06.인감조제, 09.문서신청, 91.사용자그룹, 92.화면권한")
    private String bizTcd          ; /* 업무구분 */
    @ApiModelProperty(notes= "화면구분", example="rqsr")
    private String selTyp          ; /* 화면구분 */
    @ApiModelProperty(notes= "결재자유형코드 ", example="09")
    private String dcfcPcd          ; /* 결재자유형코드 */
    
	@ApiModelProperty(notes= "페이지번호")
	private long pageNum;
	
//	public String getLginEpno() {
//		return lginEpno;
//	}
//	public void setLginEpno(String lginEpno) {
//		this.lginEpno = lginEpno;
//	}
//	public String getLginOrzCd() {
//		return lginOrzCd;
//	}
//	public void setLginOrzCd(String lginOrzCd) {
//		this.lginOrzCd = lginOrzCd;
//	}
//	public String getHrOsdtCd() {
//		return hrOsdtCd;
//	}
//	public void setHrOsdtCd(String hrOsdtCd) {
//		this.hrOsdtCd = hrOsdtCd;
//	}
	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}
	public void setAprvWrrptOrzCd(String aprvWrrptOrzCd) {
		this.aprvWrrptOrzCd = aprvWrrptOrzCd;
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
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getBizTcd() {
		return bizTcd;
	}
	public void setBizTcd(String bizTcd) {
		this.bizTcd = bizTcd;
	}
	public String getSelTyp() {
		return selTyp;
	}
	public void setSelTyp(String selTyp) {
		this.selTyp = selTyp;
	}
	public String getDcfcPcd() {
		return dcfcPcd;
	}
	public void setDcfcPcd(String dcfcPcd) {
		this.dcfcPcd = dcfcPcd;
	}
	public long getPageNum() {
		return pageNum;
	}
	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}
	
}

    
