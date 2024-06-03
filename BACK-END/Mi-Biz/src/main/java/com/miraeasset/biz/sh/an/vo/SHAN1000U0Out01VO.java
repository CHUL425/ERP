/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SH
*	03. 파    일   명	: SHAN1000U0Out01VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 안전보건공지 목록조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.sh.an.vo;

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
public class SHAN1000U0Out01VO {

	@ExcelColumnInfo(notes= "일련번호")
	@ApiModelProperty(notes= "일련번호")
	private BigDecimal srno             ; /*일련번호         */
	@ExcelColumnInfo(notes= "공지구분코드")
	@ApiModelProperty(notes= "공지구분코드")
	private String cmklTcd          ; /*공지구분코드        */
	@ExcelColumnInfo(notes= "제목명")
	@ApiModelProperty(notes= "제목명")
	private String ttlNm            ; /*제목명              */
	@ExcelColumnInfo(notes= "게시시작일자")
	@ApiModelProperty(notes= "게시시작일자")
	private String pstupStrtDt      ; /*게시시작일자        */
	@ExcelColumnInfo(notes= "게시종료일자")
	@ApiModelProperty(notes= "게시종료일자")
	private String pstupEndDt       ; /*게시종료일자        */
	@ExcelColumnInfo(notes= "작성사원번호")
	@ApiModelProperty(notes= "작성사원번호")
	private String madeEpno         ; /*작성사원번호        */
	@ExcelColumnInfo(notes= "작성사원명")
	@ApiModelProperty(notes= "작성사원명")
	private String madeEpNm         ; /*작성사원명        */
	@ExcelColumnInfo(notes= "작성일자")
	@ApiModelProperty(notes= "작성일자")
	private String madeDt           ; /*작성일자            */
	@ExcelColumnInfo(notes= "조회건수")
	@ApiModelProperty(notes= "조회건수")
	private BigDecimal qryCnt       ; /*조회건수          */
 	
	public String getMadeDt() {
		return madeDt;
	}
	public void setMadeDt(String madeDt) {
		this.madeDt = madeDt;
	}
	public BigDecimal getSrno() {
		return srno;
	}
	public void setSrno(BigDecimal srno) {
		this.srno = srno;
	}
	public String getCmklTcd() {
		return cmklTcd;
	}
	public void setCmklTcd(String cmklTcd) {
		this.cmklTcd = cmklTcd;
	}
	public String getMadeEpno() {
		return madeEpno;
	}
	public void setMadeEpno(String madeEpno) {
		this.madeEpno = madeEpno;
	}
	public String getMadeEpNm() {
		return madeEpNm;
	}
	public void setMadeEpNm(String madeEpNm) {
		this.madeEpNm = madeEpNm;
	}
	public String getTtlNm() {
		return ttlNm;
	}
	public void setTtlNm(String ttlNm) {
		this.ttlNm = ttlNm;
	}
	public String getPstupStrtDt() {
		return pstupStrtDt;
	}
	public void setPstupStrtDt(String pstupStrtDt) {
		this.pstupStrtDt = pstupStrtDt;
	}
	public String getPstupEndDt() {
		return pstupEndDt;
	}
	public void setPstupEndDt(String pstupEndDt) {
		this.pstupEndDt = pstupEndDt;
	}
	public BigDecimal getQryCnt() {
		return qryCnt;
	}
	public void setQryCnt(BigDecimal qryCnt) {
		this.qryCnt = qryCnt;
	}
}
