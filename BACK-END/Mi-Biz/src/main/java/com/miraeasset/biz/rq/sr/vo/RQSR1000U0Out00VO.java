/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0Out00VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인감날인증명서신청 목록조회 OUT
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
public class RQSR1000U0Out00VO {

	@ExcelColumnInfo(notes= "신청번호")
	@ApiModelProperty(notes= "신청번호")
	private String rctNo                ; 
	@ExcelColumnInfo(notes= "신청제목명")
	@ApiModelProperty(notes= "신청제목명")
	private String rqsTtlNm             ; /*신청제목명*/
	@ApiModelProperty(notes= "통합신청유형코드")
	private String unifRqsPcd           ; /*통합신청유형코드*/
	@ApiModelProperty(notes= "통합신청유형명")
	private String unifRqsPcdNm         ; /*통합신청유형명*/
	@ApiModelProperty(notes= "통합신청상세유형코드")
	private String unifRqsDlPcd         ; /*통합신청상세유형코드*/
	@ApiModelProperty(notes= "통합신청상세유형명")
	private String unifRqsDlPcdNm       ; /*통합신청상세유형명*/
	@ApiModelProperty(notes= "통합신청구분코드")
	private String unifRqsTcd           ; /*통합신청구분코드*/
	@ApiModelProperty(notes= "통합신청구분명")
	private String unifRqsTcdNm         ; /*통합신청구분명*/
	@ExcelColumnInfo(notes= "인감날인부수")
	@ApiModelProperty(notes= "인감날인부수", example="0")
	private BigDecimal sealSalgCnt      ; /*인감날인부수*/
	@ExcelColumnInfo(notes= "인감증명서부수")
	@ApiModelProperty(notes= "인감증명서부수", example="0")
	private BigDecimal sealDocCnt       ; /*인감증명서부수*/
	@ExcelColumnInfo(notes= "등기부등본부수")
	@ApiModelProperty(notes= "등기부등본부수", example="0")
	private BigDecimal certDocCnt       ; /*등기부등본부수*/
	@ExcelColumnInfo(notes= "신청조직코드")
	@ApiModelProperty(notes= "신청조직코드")
	private String rqsOrzCd             ; /*신청조직코드*/
	@ExcelColumnInfo(notes= "신청조직명")
	@ApiModelProperty(notes= "신청조직명")
	private String rqsOrzNm             ; /*신청조직명*/
	@ExcelColumnInfo(notes= "신청사원번호")
	@ApiModelProperty(notes= "신청사원번호")
	private String rqsEpno              ; /*신청사원번호*/ 
	@ExcelColumnInfo(notes= "신청사원명")
	@ApiModelProperty(notes= "신청사원명")
	private String rqsEpNm              ; /*신청사원명*/
	@ExcelColumnInfo(notes= "신청사원핸드폰번호")
	@ApiModelProperty(notes= "신청사원핸드폰번호")
	private String rqsEpHndpTlno			  ; /*신청사원핸드폰번호*/
	@ExcelColumnInfo(notes= "신청사유내용")
	@ApiModelProperty(notes= "신청사유내용")
	private String rqsRsnCn             ; /*신청사유내용*/
	@ApiModelProperty(notes= "희망일자")
	private String hopeDt               ; /*희망일자*/ 
	@ExcelColumnInfo(notes= "신청일자")
	@ApiModelProperty(notes= "신청일자")
	private String rqsDt                ; /*신청일자*/ 
	
	@ApiModelProperty(notes= "결재상신관리번호")
	private String aprvWrrptMtNo        ; /*결재상신관리번호*/
	@ApiModelProperty(notes= "결재상신조직코드")
	private String aprvWrrptOrzCd		; /*결재상신조직코드*/ 
	@ExcelColumnInfo(notes= "사전참조확인일자")
	@ApiModelProperty(notes= "사전참조확인일자")
	private String refDt		; /*사전참조확인일자*/ 
	@ExcelColumnInfo(notes= "신청상태코드")
	@ApiModelProperty(notes= "신청상태코드")
	private String rqsScd               ; /*신청상태코드*/ 
	@ExcelColumnInfo(notes= "신청상태코드명")
	@ApiModelProperty(notes= "신청상태코드명")
	private String rqsScdNm             ; /*신청상태코드명*/
	
	@ApiModelProperty(notes= "유효기간경과여부")
	private String valdTermPasYn;
	
	@ApiModelProperty(notes= "순번", example="0")
	private BigDecimal rnum       ; /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수             */
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	public String getUnifRqsTcd() {
		return unifRqsTcd;
	}
	public void setUnifRqsTcd(String unifRqsTcd) {
		this.unifRqsTcd = unifRqsTcd;
	}
	public String getUnifRqsTcdNm() {
		return unifRqsTcdNm;
	}
	public void setUnifRqsTcdNm(String unifRqsTcdNm) {
		this.unifRqsTcdNm = unifRqsTcdNm;
	}
	public String getUnifRqsPcd() {
		return unifRqsPcd;
	}
	public void setUnifRqsPcd(String unifRqsPcd) {
		this.unifRqsPcd = unifRqsPcd;
	}
	public String getUnifRqsPcdNm() {
		return unifRqsPcdNm;
	}
	public void setUnifRqsPcdNm(String unifRqsPcdNm) {
		this.unifRqsPcdNm = unifRqsPcdNm;
	}
	public String getUnifRqsDlPcd() {
		return unifRqsDlPcd;
	}
	public void setUnifRqsDlPcd(String unifRqsDlPcd) {
		this.unifRqsDlPcd = unifRqsDlPcd;
	}
	public String getUnifRqsDlPcdNm() {
		return unifRqsDlPcdNm;
	}
	public void setUnifRqsDlPcdNm(String unifRqsDlPcdNm) {
		this.unifRqsDlPcdNm = unifRqsDlPcdNm;
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
	public String getRqsEpHndpTlno() {
		return rqsEpHndpTlno;
	}
	public void setRqsEpHndpTlno(String rqsEpHndpTlno) {
		this.rqsEpHndpTlno = rqsEpHndpTlno;
	}
	public String getRqsTtlNm() {
		return rqsTtlNm;
	}
	public void setRqsTtlNm(String rqsTtlNm) {
		this.rqsTtlNm = rqsTtlNm;
	}
	public String getRqsRsnCn() {
		return rqsRsnCn;
	}
	public void setRqsRsnCn(String rqsRsnCn) {
		this.rqsRsnCn = rqsRsnCn;
	}
	public String getHopeDt() {
		return hopeDt;
	}
	public void setHopeDt(String hopeDt) {
		this.hopeDt = hopeDt;
	}
	public String getRqsDt() {
		return rqsDt;
	}
	public void setRqsDt(String rqsDt) {
		this.rqsDt = rqsDt;
	}
	public String getAprvWrrptMtNo() {
		return aprvWrrptMtNo;
	}
	public void setAprvWrrptMtNo(String aprvWrrptMtNo) {
		this.aprvWrrptMtNo = aprvWrrptMtNo;
	}
	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}
	public void setAprvWrrptOrzCd(String aprvWrrptOrzCd) {
		this.aprvWrrptOrzCd = aprvWrrptOrzCd;
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
	public BigDecimal getSealSalgCnt() {
		return sealSalgCnt;
	}
	public void setSealSalgCnt(BigDecimal sealSalgCnt) {
		this.sealSalgCnt = sealSalgCnt;
	}
	public BigDecimal getSealDocCnt() {
		return sealDocCnt;
	}
	public void setSealDocCnt(BigDecimal sealDocCnt) {
		this.sealDocCnt = sealDocCnt;
	}
	public BigDecimal getCertDocCnt() {
		return certDocCnt;
	}
	public void setCertDocCnt(BigDecimal certDocCnt) {
		this.certDocCnt = certDocCnt;
	}
	public BigDecimal getRnum() {
		return rnum;
	}
	public void setRnum(BigDecimal rnum) {
		this.rnum = rnum;
	}
	public BigDecimal getAlCnt() {
		return alCnt;
	}
	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}
	public String getRefDt() {
		return refDt;
	}
	public void setRefDt(String refDt) {
		this.refDt = refDt;
	}
	public String getValdTermPasYn() {
		return valdTermPasYn;
	}
	public void setValdTermPasYn(String valdTermPasYn) {
		this.valdTermPasYn = valdTermPasYn;
	}
}
