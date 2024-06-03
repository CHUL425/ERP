package com.miraeasset.biz.ga.rm.vo;

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
public class GARM1000V0Out00VO {
	
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ;    /* 전체건수 */
	
	@ExcelColumnInfo(notes= "정산년월")
    @ApiModelProperty(notes= "정산년월")
    private String exccYm         ;    /* 정산년월 */
    
	@ExcelColumnInfo(notes= "장비구분명")
    @ApiModelProperty(notes= "장비구분명")
    private String eqmtTcdNm      ;    /* 장비구분명 */
	
	@ExcelColumnInfo(notes= "장비구분코드")
    @ApiModelProperty(notes= "장비구분코드")
    private String eqmtTcd        ;    /* 장비구분코드 */
	
	@ExcelColumnInfo(notes= "거래처명")
    @ApiModelProperty(notes= "거래처명")
    private String delpCdNm       ;    /* 거래처명 */
	
	@ExcelColumnInfo(notes= "거래처코드")
    @ApiModelProperty(notes= "거래처코드")
    private String delpCd         ;    /* 거래처코드 */
	
	@ExcelColumnInfo(notes= "관리조직명")
    @ApiModelProperty(notes= "관리조직명")
    private String mtOrzNm        ;    /* 관리조직명 */
	
	@ExcelColumnInfo(notes= "관리조직코드 ")
    @ApiModelProperty(notes= "관리조직코드 ")
    private String mtOrzCd        ;    /* 관리조직코드  */
	
    @ExcelColumnInfo(notes= "임대계약번호")
    @ApiModelProperty(notes= "임대계약번호")
    private String rentCntcNo     ;    /* 임대계약번호 */
    
    @ExcelColumnInfo(notes= "제품명")
    @ApiModelProperty(notes= "제품명")
    private String gdsNm          ;    /* 제품명 */
    
    @ExcelColumnInfo(notes= "월간임대료")
    @ApiModelProperty(notes= "월간임대료")
    private String mlyRentc       ;    /* 월간임대료 */
    
    @ExcelColumnInfo(notes= "설치일자")
    @ApiModelProperty(notes= "설치일자")
    private String istDt          ;    /* 설치일자 */
    
    @ExcelColumnInfo(notes= "의무사용일자")
    @ApiModelProperty(notes= "의무사용일자")
    private String dutyUseDt      ;    /* 의무사용일자 */
    
    @ExcelColumnInfo(notes= "설치장소명")
    @ApiModelProperty(notes= "설치장소명")
    private String istPlcNm       ;    /* 설치장소명 */
    
    @ExcelColumnInfo(notes= "설치장소상세명")
    @ApiModelProperty(notes= "설치장소상세명")
    private String istPlcDlNm     ;    /* 설치장소상세명 */
    
    @ApiModelProperty(notes= "조작자ID")
    private String optrId         ;    /* 조작자ID */
    @ApiModelProperty(notes= "조작채널코드")
    private String oprtChnlCd     ;    /* 조작채널코드 */
    @ApiModelProperty(notes= "조작조직코드")
    private String oprtOrzCd      ;    /* 조작조직코드 */
    @ApiModelProperty(notes= "조작IP주소")
    private String oprtIpAdr      ;    /* 조작IP주소 */
    @ApiModelProperty(notes= "조작일시")
    private String oprtDttm       ;    /* 조작일시 */
    
	public BigDecimal getAlCnt() {
		return alCnt;
	}
	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}
	public String getExccYm() {
		return exccYm;
	}
	public void setExccYm(String exccYm) {
		this.exccYm = exccYm;
	}
	public String getRentCntcNo() {
		return rentCntcNo;
	}
	public void setRentCntcNo(String rentCntcNo) {
		this.rentCntcNo = rentCntcNo;
	}
	public String getEqmtTcd() {
		return eqmtTcd;
	}
	public void setEqmtTcd(String eqmtTcd) {
		this.eqmtTcd = eqmtTcd;
	}
	public String getEqmtTcdNm() {
		return eqmtTcdNm;
	}
	public void setEqmtTcdNm(String eqmtTcdNm) {
		this.eqmtTcdNm = eqmtTcdNm;
	}
	public String getDelpCd() {
		return delpCd;
	}
	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}
	public String getDelpCdNm() {
		return delpCdNm;
	}
	public void setDelpCdNm(String delpCdNm) {
		this.delpCdNm = delpCdNm;
	}
	public String getMtOrzCd() {
		return mtOrzCd;
	}
	public void setMtOrzCd(String mtOrzCd) {
		this.mtOrzCd = mtOrzCd;
	}
	public String getMtOrzNm() {
		return mtOrzNm;
	}
	public void setMtOrzNm(String mtOrzNm) {
		this.mtOrzNm = mtOrzNm;
	}
	public String getGdsNm() {
		return gdsNm;
	}
	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}
	public String getMlyRentc() {
		return mlyRentc;
	}
	public void setMlyRentc(String mlyRentc) {
		this.mlyRentc = mlyRentc;
	}
	public String getIstDt() {
		return istDt;
	}
	public void setIstDt(String istDt) {
		this.istDt = istDt;
	}
	public String getDutyUseDt() {
		return dutyUseDt;
	}
	public void setDutyUseDt(String dutyUseDt) {
		this.dutyUseDt = dutyUseDt;
	}
	public String getIstPlcNm() {
		return istPlcNm;
	}
	public void setIstPclNm(String istPlcNm) {
		this.istPlcNm = istPlcNm;
	}
	public String getIstPclDlNm() {
		return istPlcDlNm;
	}
	public void setIstPclDlNm(String istPlcDlNm) {
		this.istPlcDlNm = istPlcDlNm;
	}
	public String getOptrId() {
		return optrId;
	}
	public void setOptrId(String optrId) {
		this.optrId = optrId;
	}
	public String getOprtChnlCd() {
		return oprtChnlCd;
	}
	public void setOprtChnlCd(String oprtChnlCd) {
		this.oprtChnlCd = oprtChnlCd;
	}
	public String getOprtOrzCd() {
		return oprtOrzCd;
	}
	public void setOprtOrzCd(String oprtOrzCd) {
		this.oprtOrzCd = oprtOrzCd;
	}
	public String getOprtIpAdr() {
		return oprtIpAdr;
	}
	public void setOprtIpAdr(String oprtIpAdr) {
		this.oprtIpAdr = oprtIpAdr;
	}
	public String getOprtDttm() {
		return oprtDttm;
	}
	public void setOprrDttm(String oprtDttm) {
		this.oprtDttm = oprtDttm;
	}
	
	@Override
	public String toString() {
		return "GARM1000V0Out00VO [alCnt=" + alCnt + ", exccYm=" + exccYm + ", rentCntcNo=" + rentCntcNo + ", eqmtTcd="
				+ eqmtTcd + ", eqmtTcdNm=" + eqmtTcdNm + ", delpCd=" + delpCd + ", delpCdNm=" + delpCdNm + ", mtOrzCd="
				+ mtOrzCd + ", mtOrzNm=" + mtOrzNm + ", gdsNm=" + gdsNm + ", mlyRentc=" + mlyRentc + ", istDt=" + istDt
				+ ", dutyUseDt=" + dutyUseDt + ", istPlcNm=" + istPlcNm + ", istPlcDlNm=" + istPlcDlNm + ", optrId="
				+ optrId + ", oprtChnlCd=" + oprtChnlCd + ", oprtOrzCd=" + oprtOrzCd + ", oprtIpAdr=" + oprtIpAdr
				+ ", oprtDttm=" + oprtDttm + "]";
	}
    
}
