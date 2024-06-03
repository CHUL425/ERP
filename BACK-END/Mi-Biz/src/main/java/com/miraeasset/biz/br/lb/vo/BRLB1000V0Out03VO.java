/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: BR
*	03. 파    일   명	: BRLB1000V0Out03VO.java
*	04. 작  성  일  자	: 2024.03.06
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 지점임차비용 비교 조회결과 OUT
*	07. 주  요  사  항	: 세로 값을 나열한 형식 및 엑셀다운로드
*******************************************************************************************************/
package com.miraeasset.biz.br.lb.vo;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.dao.ExcelColumnStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultBodyStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultExcelCellStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultHeaderStyle;

import io.swagger.annotations.ApiModelProperty;

@DefaultHeaderStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "GREY_HEADER"))
@DefaultBodyStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BODY"))
public class BRLB1000V0Out03VO {

	@ExcelColumnInfo(notes= "제목1")
    @ApiModelProperty(notes = "타이틀")
    private String orzTitle;
	@ExcelColumnInfo(notes= "제목2")
    @ApiModelProperty(notes = "타이틀")
    private String orzNm0;
	@ExcelColumnInfo(notes= "첫번째 조직")
    @ApiModelProperty(notes = "첫번째 Row")
    private String orzNm1;
	@ExcelColumnInfo(notes= "두번째 조직")
    @ApiModelProperty(notes = "두번째 Row")
    private String orzNm2;
	@ExcelColumnInfo(notes= "세번째 조직")
    @ApiModelProperty(notes = "세번째 Row")
    private String orzNm3;
	
	public String getOrzNm0() {
		return orzNm0;
	}
	public void setOrzNm0(String orzNm0) {
		this.orzNm0 = orzNm0;
	}
	public String getOrzNm1() {
		return orzNm1;
	}
	public void setOrzNm1(String orzNm1) {
		this.orzNm1 = orzNm1;
	}
	public String getOrzNm2() {
		return orzNm2;
	}
	public void setOrzNm2(String orzNm2) {
		this.orzNm2 = orzNm2;
	}
	public String getOrzNm3() {
		return orzNm3;
	}
	public void setOrzNm3(String orzNm3) {
		this.orzNm3 = orzNm3;
	}
	public String getOrzTitle() {
		return orzTitle;
	}
	public void setOrzTitle(String orzTitle) {
		this.orzTitle = orzTitle;
	}
	
}
