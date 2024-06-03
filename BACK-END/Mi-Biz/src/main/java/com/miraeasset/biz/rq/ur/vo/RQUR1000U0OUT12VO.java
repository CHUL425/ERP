package com.miraeasset.biz.rq.ur.vo;

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
public class RQUR1000U0OUT12VO {

	@ExcelColumnInfo(notes= "접수번호")
    @ApiModelProperty(notes= "접수번호")
    private String rctNo;            // 접수번호
	@ExcelColumnInfo(notes= "접수상세번호")
    @ApiModelProperty(notes= "접수상세번호")
    private String rctDlNo;          // 접수상세번호

    @ApiModelProperty(notes= "장비구분코드")
    private String eqmtTcd       ;  /*장비구분코드    */
	@ExcelColumnInfo(notes= "제품유형")
    @ApiModelProperty(notes= "장비구분코드명")
    private String eqmtTcdNm     ;  /*장비구분코드명    */
	@ExcelColumnInfo(notes= "주문번호")
    @ApiModelProperty(notes= "임대계약번호")
    private String rentCntcNo    ;  /*임대계약번호    */
    @ApiModelProperty(notes= "제품명")
    private String gdsNm         ;  /*제품명          */
	@ExcelColumnInfo(notes= "설치위치")
	@ApiModelProperty(notes= "설치장소명")
	private String istPlcNm      ; /*설치장소명      */
	@ExcelColumnInfo(notes= "상세요청")
    @ApiModelProperty(notes= "신청요청사항내용 ")
    private String rqsRqmPtcrCn  ;  /*신청요청사항내용   */

    
    @Override
    public String toString() {
        return "RQUR1000U0OUT12VO{" +
                "rctNo       = '" + rctNo        + "'"+
                "rctDlNo     = '" + rctDlNo      + "'"+
                "eqmtTcd     = '" + eqmtTcd      + "'"+
                "eqmtTcdNm   = '" + eqmtTcdNm    + "'"+
                "rentCntcNo  = '" + rentCntcNo   + "'"+
                "gdsNm       = '" + gdsNm        + "'"+
                "rqsRqmPtcrCn  = '" + rqsRqmPtcrCn   + "'"+
                '}';    	
    }

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public String getRctDlNo() {
		return rctDlNo;
	}

	public void setRctDlNo(String rctDlNo) {
		this.rctDlNo = rctDlNo;
	}

	public String getEqmtTcd() {
		return eqmtTcd;
	}

	public void setEqmtTcd(String eqmtTcd) {
		this.eqmtTcd = eqmtTcd;
	}

	public String getRentCntcNo() {
		return rentCntcNo;
	}

	public void setRentCntcNo(String rentCntcNo) {
		this.rentCntcNo = rentCntcNo;
	}

	public String getGdsNm() {
		return gdsNm;
	}

	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}

	public String getRqsRqmPtcrCn() {
		return rqsRqmPtcrCn;
	}

	public void setRqsRqmPtcrCn(String rqsRqmPtcrCn) {
		this.rqsRqmPtcrCn = rqsRqmPtcrCn;
	}

	public String getEqmtTcdNm() {
		return eqmtTcdNm;
	}

	public void setEqmtTcdNm(String eqmtTcdNm) {
		this.eqmtTcdNm = eqmtTcdNm;
	}


	public String getIstPlcNm() {
		return istPlcNm;
	} public void setIstPlcNm(String istPlcNm) {
		this.istPlcNm = istPlcNm;
	}

}
