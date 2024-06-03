/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GACM1000U0In01VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 계약서관리 상세정보(PK) IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.bm.vo;

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
public class GABM1000U0Out00VO {
	
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수 */
	
	@ExcelColumnInfo(notes = "대계정코드")
	@ApiModelProperty(notes= "대계정코드")
	private String lAcsjCd		  ; /* 대계정코드 */
	@ExcelColumnInfo(notes = "대계정명")
	@ApiModelProperty(notes= "대계정명")
	private String lAcsjNm		  ; /* 대계정명 */
	
	@ExcelColumnInfo(notes = "중계정코드")
	@ApiModelProperty(notes= "중계정코드")
	private String mAcsjCd		  ; /* 중계정코드 */
	@ExcelColumnInfo(notes = "중계정명")
	@ApiModelProperty(notes= "중계정명")
	private String mAcsjNm		  ; /* 중계정명 */
	
	@ExcelColumnInfo(notes = "소계정코드")
	@ApiModelProperty(notes= "소계정코드")
	private String sAcsjCd		  ; /* 소계정코드 */
	@ExcelColumnInfo(notes = "소계정명")
	@ApiModelProperty(notes= "소계정명")
	private String sAcsjNm		  ; /* 소계정명 */
	
	@ExcelColumnInfo(notes = "조직코드")
	@ApiModelProperty(notes= "조직코드")
	private String orzCd		  ; /* 조직코드 */
	@ExcelColumnInfo(notes = "조직명")
	@ApiModelProperty(notes= "조직명")
	private String orzNm		  ; /* 조직명 */
	
	@ExcelColumnInfo(notes = "전년도집행금액"
			,bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
	@ApiModelProperty(notes= "전년도집행금액")
	private long yrbfEnfcA	  ; /* 전년도집행금액 */
	
	@ExcelColumnInfo(notes = "집행금액"
			,bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
	@ApiModelProperty(notes= "집행금액")
	private long enfcA	      ; /* 집행금액 */
	
	@ExcelColumnInfo(notes = "편성금액"
			,bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
	@ApiModelProperty(notes= "편성금액")
	private long bdgtFmtnA	  ; /* 편성금액 */ 
    
	@ExcelColumnInfo(notes = "집행률")
	@ApiModelProperty(notes= "집행률")
	private String enfcr	      ; /* 집행률 */

	public BigDecimal getAlCnt() {
		return alCnt;
	}

	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}

	public String getlAcsjCd() {
		return lAcsjCd;
	}

	public void setlAcsjCd(String lAcsjCd) {
		this.lAcsjCd = lAcsjCd;
	}

	public String getlAcsjNm() {
		return lAcsjNm;
	}

	public void setlAcsjNm(String lAcsjNm) {
		this.lAcsjNm = lAcsjNm;
	}

	public String getmAcsjCd() {
		return mAcsjCd;
	}

	public void setmAcsjCd(String mAcsjCd) {
		this.mAcsjCd = mAcsjCd;
	}

	public String getmAcsjNm() {
		return mAcsjNm;
	}

	public void setmAcsjNm(String mAcsjNm) {
		this.mAcsjNm = mAcsjNm;
	}

	public String getsAcsjCd() {
		return sAcsjCd;
	}

	public void setsAcsjCd(String sAcsjCd) {
		this.sAcsjCd = sAcsjCd;
	}

	public String getsAcsjNm() {
		return sAcsjNm;
	}

	public void setsAcsjNm(String sAcsjNm) {
		this.sAcsjNm = sAcsjNm;
	}

	public String getOrzCd() {
		return orzCd;
	}

	public void setOrzCd(String orzCd) {
		this.orzCd = orzCd;
	}

	public String getOrzNm() {
		return orzNm;
	}

	public void setOrzNm(String orzNm) {
		this.orzNm = orzNm;
	}

	public long getYrbfEnfcA() {
		return yrbfEnfcA;
	}

	public void setYrbfEnfcA(long yrbfEnfcA) {
		this.yrbfEnfcA = yrbfEnfcA;
	}

	public long getEnfcA() {
		return enfcA;
	}

	public void setEnfcA(long enfcA) {
		this.enfcA = enfcA;
	}

	public long getBdgtFmtnA() {
		return bdgtFmtnA;
	}

	public void setBdgtFmtnA(long bdgtFmtnA) {
		this.bdgtFmtnA = bdgtFmtnA;
	}

	public String getEnfcr() {
		return enfcr;
	}

	public void setEnfcr(String enfcr) {
		this.enfcr = enfcr;
	}

	@Override
	public String toString() {
		return "GABM1000V0Out00VO [alCnt=" + alCnt + ", lAcsjCd=" + lAcsjCd + ", lAcsjNm=" + lAcsjNm + ", mAcsjCd="
				+ mAcsjCd + ", mAcsjNm=" + mAcsjNm + ", sAcsjCd=" + sAcsjCd + ", sAcsjNm=" + sAcsjNm + ", orzCd="
				+ orzCd + ", orzNm=" + orzNm + ", yrbfEnfcA=" + yrbfEnfcA + ", enfcA=" + enfcA + ", bdgtFmtnA="
				+ bdgtFmtnA + ", enfcr=" + enfcr + "]";
	}
    
}
    
