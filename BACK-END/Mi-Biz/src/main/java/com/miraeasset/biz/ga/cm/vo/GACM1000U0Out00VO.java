/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GACM1000U0Out00VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 계약서관리 목록조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.cm.vo;

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
public class GACM1000U0Out00VO {
	
	@ExcelColumnInfo(notes= "계약서관리번호")
	@ApiModelProperty(notes= "계약서관리번호")
	private String cnrtMtNo        	; /*계약서관리번호 */			     
	@ExcelColumnInfo(notes= "거래처코드")
	@ApiModelProperty(notes= "거래처코드")
	private String delpCd           ; /*거래처코드 */
	@ExcelColumnInfo(notes= "거래처명")
	@ApiModelProperty(notes= "거래처명")
	private String delpNm           ; /*거래처명*/
	@ExcelColumnInfo(notes= "계약구분코드")
	@ApiModelProperty(notes= "계약구분코드")
	private String cntcTcd          ; /*계약구분코드 */
	@ExcelColumnInfo(notes= "계약구분코드명")
	@ApiModelProperty(notes= "계약구분코드명")
	private String cntcTcdNm        ; /*계약구분코드명*/
	@ExcelColumnInfo(notes= "계약명")
	@ApiModelProperty(notes= "계약명")
	private String cntcNm           ; /*계약명 */
	@ExcelColumnInfo(notes= "계약금액")
	@ApiModelProperty(notes= "계약금액")
	private BigDecimal cntcA        ; /*계약금액 */
	@ExcelColumnInfo(notes= "계약시작일자")
	@ApiModelProperty(notes= "계약시작일자")
	private String cntcStrtDt       ; /*계약시작일자 */
	@ExcelColumnInfo(notes= "계약종료일자")
	@ApiModelProperty(notes= "계약종료일자")
	private String cntcEndDt        ; /*계약종료일자 */
	@ExcelColumnInfo(notes= "업체선정방법코드")
	@ApiModelProperty(notes= "업체선정방법코드")
	private String entpSeltMcd      ; /*업체선정방법코드 */
	@ExcelColumnInfo(notes= "업체선정방법코드명")
	@ApiModelProperty(notes= "업체선정방법코드명")
	private String entpSeltMcdNm    ; /*업체선정방법코드명*/
	@ExcelColumnInfo(notes= "비고내용")
	@ApiModelProperty(notes= "비고내용")
	private String nteCn            ; /*비고내용 */
	@ExcelColumnInfo(notes= "계정코드")
	@ApiModelProperty(notes= "계정코드")
	private String actgAcsjCd       ; /*계정코드*/
	@ExcelColumnInfo(notes= "계정명")
	@ApiModelProperty(notes= "계정명")
	private String acsjCdNm         ; /*계정명*/
	@ExcelColumnInfo(notes= "기안문서건수")
	@ApiModelProperty(notes= "기안문서건수")
	private String drftDocCnt       ; /*기안문서건수*/

	@ApiModelProperty(notes= "순번", example="0")
	private BigDecimal rnum       ; /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수             */
	public String getCnrtMtNo() {
		return cnrtMtNo;
	}
	public void setCnrtMtNo(String cnrtMtNo) {
		this.cnrtMtNo = cnrtMtNo;
	}
	public String getDelpCd() {
		return delpCd;
	}
	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}
	public String getDelpNm() {
		return delpNm;
	}
	public void setDelpNm(String delpNm) {
		this.delpNm = delpNm;
	}
	public String getCntcTcd() {
		return cntcTcd;
	}
	public void setCntcTcd(String cntcTcd) {
		this.cntcTcd = cntcTcd;
	}
	public String getCntcTcdNm() {
		return cntcTcdNm;
	}
	public void setCntcTcdNm(String cntcTcdNm) {
		this.cntcTcdNm = cntcTcdNm;
	}
	public String getCntcNm() {
		return cntcNm;
	}
	public void setCntcNm(String cntcNm) {
		this.cntcNm = cntcNm;
	}
	public BigDecimal getCntcA() {
		return cntcA;
	}
	public void setCntcA(BigDecimal cntcA) {
		this.cntcA = cntcA;
	}
	public String getCntcStrtDt() {
		return cntcStrtDt;
	}
	public void setCntcStrtDt(String cntcStrtDt) {
		this.cntcStrtDt = cntcStrtDt;
	}
	public String getCntcEndDt() {
		return cntcEndDt;
	}
	public void setCntcEndDt(String cntcEndDt) {
		this.cntcEndDt = cntcEndDt;
	}
	public String getEntpSeltMcd() {
		return entpSeltMcd;
	}
	public void setEntpSeltMcd(String entpSeltMcd) {
		this.entpSeltMcd = entpSeltMcd;
	}
	public String getEntpSeltMcdNm() {
		return entpSeltMcdNm;
	}
	public void setEntpSeltMcdNm(String entpSeltMcdNm) {
		this.entpSeltMcdNm = entpSeltMcdNm;
	}
	public String getNteCn() {
		return nteCn;
	}
	public void setNteCn(String nteCn) {
		this.nteCn = nteCn;
	}
	public String getActgAcsjCd() {
		return actgAcsjCd;
	}
	public void setActgAcsjCd(String actgAcsjCd) {
		this.actgAcsjCd = actgAcsjCd;
	}
	public String getAcsjCdNm() {
		return acsjCdNm;
	}
	public void setAcsjCdNm(String acsjCdNm) {
		this.acsjCdNm = acsjCdNm;
	}
	public String getDrftDocCnt() {
		return drftDocCnt;
	}
	public void setDrftDocCnt(String drftDocCnt) {
		this.drftDocCnt = drftDocCnt;
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
	

}
