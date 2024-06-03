/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GASM1000U0Out00VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: RE100계약관리 목록조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.sm.vo;

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
public class GASM1000U0Out00VO {

	@ExcelColumnInfo(notes= "계약서관리번호")
	@ApiModelProperty(notes= "계약서관리번호")
	private String cnrtMtNo     ; /*계약서관리번호 */			

	@ExcelColumnInfo(notes= "거래처코드")
	@ApiModelProperty(notes= "거래처코드")
    private String delpCd       ; /*거래처코드              */

	@ExcelColumnInfo(notes= "업체명")
	@ApiModelProperty(notes= "업체명")
	private String delpNm       ; /*업체명*/
	
	@ExcelColumnInfo(notes= "계약용량")
	@ApiModelProperty(notes= "계약용량")
	private String cntcCapa; 
	@ExcelColumnInfo(notes= "계약방법내용")
	@ApiModelProperty(notes= "계약방법내용")
	private String cntcMthdCn   ; /*계약방법내용*/
	@ExcelColumnInfo(notes= "계약기준가")
	@ApiModelProperty(notes= "계약기준가")
	private String cntcBpr; 
	@ExcelColumnInfo(notes= "계약시작일자")
	@ApiModelProperty(notes= "계약시작일자")
	private String cntcStrtDt   ; /*계약시작일자*/
	@ExcelColumnInfo(notes= "계약종료일자")
	@ApiModelProperty(notes= "계약종료일자")
	private String cntcEndDt    ; /*계약종료일자*/
	@ExcelColumnInfo(notes= "비고내용")
	@ApiModelProperty(notes= "비고내용")
	private String nteCn        ; /*비고내용    */
	@ExcelColumnInfo(notes= "삭제여부")
	@ApiModelProperty(notes= "삭제여부")
	private String delYn        ; /*삭제여부    */
	
	@ExcelColumnInfo(notes= "기안문서건수")
	@ApiModelProperty(notes= "기안문서건수")
	private BigDecimal drftDocCnt; /*기안문서건수*/
	
	@ApiModelProperty(notes= "순번", example="0")
	private BigDecimal rnum       ; /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수             */
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
	public String getCnrtMtNo() {
		return cnrtMtNo;
	}
	public void setCnrtMtNo(String cnrtMtNo) {
		this.cnrtMtNo = cnrtMtNo;
	}

	public String getCntcCapa() {
		return cntcCapa;
	}
	public void setCntcCapa(String cntcCapa) {
		this.cntcCapa = cntcCapa;
	}
	public String getCntcBpr() {
		return cntcBpr;
	}
	public void setCntcBpr(String cntcBpr) {
		this.cntcBpr = cntcBpr;
	}
	public String getCntcMthdCn() {
		return cntcMthdCn;
	}
	public void setCntcMthdCn(String cntcMthdCn) {
		this.cntcMthdCn = cntcMthdCn;
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
	public String getNteCn() {
		return nteCn;
	}
	public void setNteCn(String nteCn) {
		this.nteCn = nteCn;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public BigDecimal getDrftDocCnt() {
		return drftDocCnt;
	}
	public void setDrftDocCnt(BigDecimal drftDocCnt) {
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
