/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0Out20VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인감날인증명서신청 승인대기 내역조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.dao.ExcelColumnStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultBodyStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultExcelCellStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultHeaderStyle;

import io.swagger.annotations.ApiModelProperty;

@DefaultHeaderStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "GREY_HEADER"))
@DefaultBodyStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BODY"))
@Component
public class RQSR1000U0Out21VO {

	@ExcelColumnInfo(notes= "접수번호")
	@ApiModelProperty(notes= "접수번호")
	private String rctNo            ;  /*접수번호*/
	@ExcelColumnInfo(notes= "신청제목명")
	@ApiModelProperty(notes= "신청제목명")
	private String rqsTtlNm         ;  /*신청제목명*/
	
	@ExcelColumnInfo(notes= "신청조직코드")
	@ApiModelProperty(notes= "신청조직코드")
	private String rqsOrzCd         ;  /*신청조직코드*/
	@ExcelColumnInfo(notes= "신청조직명")
	@ApiModelProperty(notes= "신청조직명")
	private String rqsOrzNm         ;  /*신청조직명*/
	@ExcelColumnInfo(notes= "신청사원번호")
	@ApiModelProperty(notes= "신청사원번호")
	private String rqsEpno          ;  /*신청사원번호*/
	@ExcelColumnInfo(notes= "신청사원명")
	@ApiModelProperty(notes= "신청사원명")
	private String rqsEpNm          ;  /*신청사원명*/
	
	@ExcelColumnInfo(notes= "날인부수")
	@ApiModelProperty(notes= "날인부수")
	private BigDecimal sealSalgCnt  ;  /*날인부수*/
	@ExcelColumnInfo(notes= "인감증명서부수")
	@ApiModelProperty(notes= "인감증명서부수")
	private BigDecimal sealDocCnt   ;  /*인감증명서부수*/
	@ExcelColumnInfo(notes= "등기부등본부수")
	@ApiModelProperty(notes= "등기부등본부수")
	private BigDecimal certDocCnt   ;  /*등기부등본부수*/

	@ExcelColumnInfo(notes= "신청상태코드")
	@ApiModelProperty(notes= "신청상태코드")
	private String rqsScd 	        ;  /*신청상태코드*/
	@ExcelColumnInfo(notes= "신청상태명")
	@ApiModelProperty(notes= "신청상태명")
	private String rqsScdNm	        ;  /*신청상태명*/
	@ExcelColumnInfo(notes= "신청일자")
	@ApiModelProperty(notes= "신청일자")
	private String rqsDt           ;  /*신청일자*/
	@ExcelColumnInfo(notes= "사전참조일자")
	@ApiModelProperty(notes= "사전참조일자")
	private String refDt           ;  /*사전참조일자*/

	@ExcelColumnInfo(notes= "승인일자")
    @ApiModelProperty(notes= "승인일자")
    private String aprvDt 		;        /* 승인일자 */
	
	@ApiModelProperty(notes= "결재상신관리번호")
	private String aprvWrrptMtNo    ;  /*결재상신관리번호*/
    @ApiModelProperty(notes= "결재순위")
    private String aprvRnk        ; /*결재순위 */
    @ApiModelProperty(notes= "결재상세순위")
    private String aprvDlRnk      ; /*결재상세순위 */ 
    @ApiModelProperty(notes= "신청유형코드 ")
    private String aprvPcd      ; /*신청유형코드  */ 
    @ApiModelProperty(notes= "결재조직코드 ")
    private String aprvOrzCd      ;
    
	@ApiModelProperty(notes= "순번", example="0")
	private BigDecimal rnum       ; /* 순번  */ 
	
	@ApiModelProperty(notes= "총건수")
	private long totCnt ;
	
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	public String getRqsTtlNm() {
		return rqsTtlNm;
	}
	public void setRqsTtlNm(String rqsTtlNm) {
		this.rqsTtlNm = rqsTtlNm;
	}
	public BigDecimal getSealSalgCnt() {
		return sealSalgCnt;
	}
	public void setSealSalgCnt(BigDecimal sealSalgCnt) {
		this.sealSalgCnt = sealSalgCnt;
	}
	public BigDecimal getCertDocCnt() {
		return certDocCnt;
	}
	public void setCertDocCnt(BigDecimal certDocCnt) {
		this.certDocCnt = certDocCnt;
	}
	public BigDecimal getSealDocCnt() {
		return sealDocCnt;
	}
	public void setSealDocCnt(BigDecimal sealDocCnt) {
		this.sealDocCnt = sealDocCnt;
	}
	public String getRqsOrzCd() {
		return rqsOrzCd;
	}
	public void setRqsOrzCd(String rqsOrzCd) {
		this.rqsOrzCd = rqsOrzCd;
	}
	public String getRqsOrzNm() {
		return rqsOrzNm;
	}
	public void setRqsOrzNm(String rqsOrzNm) {
		this.rqsOrzNm = rqsOrzNm;
	}
	public String getRqsEpno() {
		return rqsEpno;
	}
	public void setRqsEpno(String rqsEpno) {
		this.rqsEpno = rqsEpno;
	}
	public String getRqsEpNm() {
		return rqsEpNm;
	}
	public void setRqsEpNm(String rqsEpNm) {
		this.rqsEpNm = rqsEpNm;
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
	public String getAprvWrrptMtNo() {
		return aprvWrrptMtNo;
	}
	public void setAprvWrrptMtNo(String aprvWrrptMtNo) {
		this.aprvWrrptMtNo = aprvWrrptMtNo;
	}
	public String getAprvRnk() {
		return aprvRnk;
	}
	public void setAprvRnk(String aprvRnk) {
		this.aprvRnk = aprvRnk;
	}
	public String getAprvDlRnk() {
		return aprvDlRnk;
	}
	public void setAprvDlRnk(String aprvDlRnk) {
		this.aprvDlRnk = aprvDlRnk;
	}
	public String getRqsDt() {
		return rqsDt;
	}
	public void setRqsDt(String rqsDt) {
		this.rqsDt = rqsDt;
	}
	public BigDecimal getRnum() {
		return rnum;
	}
	public void setRnum(BigDecimal rnum) {
		this.rnum = rnum;
	}
	public String getRefDt() {
		return refDt;
	}
	public void setRefDt(String refDt) {
		this.refDt = refDt;
	}
	public String getAprvPcd() {
		return aprvPcd;
	}
	public void setAprvPcd(String aprvPcd) {
		this.aprvPcd = aprvPcd;
	}
	public String getAprvDt() {
		return aprvDt;
	}
	public void setAprvDt(String aprvDt) {
		this.aprvDt = aprvDt;
	}
	public long getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(long totCnt) {
		this.totCnt = totCnt;
	}
	public String getAprvOrzCd() {
		return aprvOrzCd;
	}
	public void setAprvOrzCd(String aprvOrzCd) {
		this.aprvOrzCd = aprvOrzCd;
	}
	
}
