package com.miraeasset.biz.br.er.vo;

import java.math.BigDecimal;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.dao.ExcelColumnStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultBodyStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultExcelCellStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultHeaderStyle;
import com.miraeasset.biz.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

@DefaultHeaderStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "GREY_HEADER"))
@DefaultBodyStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BODY"))
public class BRER3000U0Out00VO extends BaseVO {
	
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수 */
	@ApiModelProperty(notes = "순번", example = "0")
	private BigDecimal rnum; /* 순번            */
    @ApiModelProperty(notes= "조직코드")
	@ExcelColumnInfo(notes = "조직코드")
    private String orzCd;            // 조직코드
    @ApiModelProperty(notes= "조직명")
	@ExcelColumnInfo(notes = "조직명")
	private String orzNm;            // 지점명
    @ApiModelProperty(notes= "구분명")
	@ExcelColumnInfo(notes = "구분명")
    private String tpNm;             // 구분명
    @ApiModelProperty(notes= "거래처코드")
	@ExcelColumnInfo(notes = "거래처코드")
    private String delpCd;            // 거래처코드
    @ApiModelProperty(notes= "관리업체")
	@ExcelColumnInfo(notes = "관리업체")
    private String delpNm;            // 관리업체    
    @ApiModelProperty(notes= "임대계약번호")
	@ExcelColumnInfo(notes = "임대계약번호")
    private String rentCntcNo;            //임대계약번호 
    @ApiModelProperty(notes= "공사비")
	@ExcelColumnInfo(notes = "공사비")
    private BigDecimal pbcoA;            //공사비
    @ApiModelProperty(notes= "월비용")
	@ExcelColumnInfo(notes = "월비용")
    private BigDecimal mnCt;            //월비용
    @ApiModelProperty(notes= "주소")
	@ExcelColumnInfo(notes = "주소")
    private String adr;            //주소
    @ApiModelProperty(notes= "비고")
	@ExcelColumnInfo(notes = "비고")
    private String nteCn;            //비고

	public BigDecimal getAlCnt() {
		return alCnt;
	}

	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}

	public BigDecimal getRnum() {
		return rnum;
	}

	public void setRnum(BigDecimal rnum) {
		this.rnum = rnum;
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

	public String getTpNm() {
		return tpNm;
	}

	public void setTpNm(String tpNm) {
		this.tpNm = tpNm;
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

	public String getRentCntcNo() {
		return rentCntcNo;
	}

	public void setRentCntcNo(String rentCntcNo) {
		this.rentCntcNo = rentCntcNo;
	}

	public BigDecimal getPbcoA() {
		return pbcoA;
	}

	public void setPbcoA(BigDecimal pbcoA) {
		this.pbcoA = pbcoA;
	}

	public BigDecimal getMnCt() {
		return mnCt;
	}

	public void setMnCt(BigDecimal mnCt) {
		this.mnCt = mnCt;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	public String getNteCn() {
		return nteCn;
	}

	public void setNteCn(String nteCn) {
		this.nteCn = nteCn;
	}
}
    
