package com.miraeasset.biz.ga.em.vo;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.dao.ExcelColumnStyle;
import com.miraeasset.biz.common.util.CryptoUtil;
import com.miraeasset.biz.common.util.excel.style.DefaultBodyStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultExcelCellStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultHeaderStyle;

import io.swagger.annotations.ApiModelProperty;

@DefaultHeaderStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "GREY_HEADER"))
@DefaultBodyStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BODY"))
@Component
public class GAEM1000U0Out00VO {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@ExcelColumnInfo(notes= "거래처코드")
	@ApiModelProperty(notes= "거래처코드")
    private String delpCd       ; /*거래처코드 */
	@ExcelColumnInfo(notes= "업체명")
	@ApiModelProperty(notes= "업체명")
	private String delpNm                ; /*업체명*/                     
	@ExcelColumnInfo(notes= "사업자등록번호")
	@ApiModelProperty(notes= "사업자등록번호")
	private String blno                  ; /*사업자등록번호 */            
	@ExcelColumnInfo(notes= "업종구분코드")
	@ApiModelProperty(notes= "업종구분코드")
	private String bztpTcd               ; /*업종구분코드 */              
	@ExcelColumnInfo(notes= "업종구분코드명")
	@ApiModelProperty(notes= "업종구분코드명")
	private String bztpTcdNm             ; /*업종구분코드명*/             
	@ExcelColumnInfo(notes= "업종상세구분코드")
	@ApiModelProperty(notes= "업종상세구분코드")
	private String bztpDlTcd             ; /*업종상세구분코드 */          
	@ExcelColumnInfo(notes= "업종상세구분코드명")
	@ApiModelProperty(notes= "업종상세구분코드명")
	private String bztpDlTcdNm           ; /*업종상세구분코드명*/         
	@ExcelColumnInfo(notes= "업체담당자명")
	@ApiModelProperty(notes= "업체담당자명")
	private String entpChprNm            ; /*업체담당자명 */              
	@ExcelColumnInfo(notes= "담당자전화번호")
	@ApiModelProperty(notes= "담당자전화번호")
	private String chprTlno              ; /*담당자전화번호 */    
	@ExcelColumnInfo(notes= "담당자이메일주소")
	@ApiModelProperty(notes= "담당자이메일주소")
	private String chprEmalAdr           ; /*담당자이메일주소 */
	
	@ExcelColumnInfo(notes= "프로젝트관리업체명")
    @ApiModelProperty(notes= "프로젝트관리업체명")
    private String prjtMtEntpNm  ; /*프로젝트관리업체명*/
    
	@ExcelColumnInfo(notes= "최초계약일자")
	@ApiModelProperty(notes= "최초계약일자")
	private String fstCntcDt             ; /*최초계약일자 */              
	@ExcelColumnInfo(notes= "메모건수")
	@ApiModelProperty(notes= "메모건수")
	private String memoCnt               ; /*메모건수*/         

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
	public String getBlno() {
		return blno;
	}
	public void setBlno(String blno) {
		this.blno = blno;
	}
	public String getBztpTcd() {
		return bztpTcd;
	}
	public void setBztpTcd(String bztpTcd) {
		this.bztpTcd = bztpTcd;
	}
	public String getBztpTcdNm() {
		return bztpTcdNm;
	}
	public void setBztpTcdNm(String bztpTcdNm) {
		this.bztpTcdNm = bztpTcdNm;
	}
	public String getBztpDlTcd() {
		return bztpDlTcd;
	}
	public void setBztpDlTcd(String bztpDlTcd) {
		this.bztpDlTcd = bztpDlTcd;
	}
	public String getBztpDlTcdNm() {
		return bztpDlTcdNm;
	}
	public void setBztpDlTcdNm(String bztpDlTcdNm) {
		this.bztpDlTcdNm = bztpDlTcdNm;
	}
	public String getEntpChprNm() {
		return entpChprNm;
	}
	public void setEntpChprNm(String entpChprNm) {
		this.entpChprNm = entpChprNm;
	}
	public String getChprTlno() {

		if(!StringUtils.isBlank(chprTlno)){
			//log.info("chprTlno["+chprTlno+"["+CryptoUtil.getDecryption(chprTlno)+"]");			
			return CryptoUtil.getDecryption(chprTlno);
		}
		else{
			return chprTlno;
		}			
	}
	public void setChprTlno(String chprTlno) {
		this.chprTlno = chprTlno;
	}
	public String getChprEmalAdr() {
		if(!StringUtils.isBlank(chprEmalAdr)){
			//log.info("chprEmalAdr["+chprEmalAdr+"["+CryptoUtil.getDecryption(chprEmalAdr)+"]");			
			
			return CryptoUtil.getDecryption(chprEmalAdr);
		}
		else{
			//log.info("chprEmalAdr isBlank");			

			return chprEmalAdr;
		}			
	}
	
	public void setChprEmalAdr(String chprEmalAdr) {
		this.chprEmalAdr = chprEmalAdr;
	}
	
	public String getPrjtMtEntpNm() {
		return prjtMtEntpNm;
	}
	public void setPrjtMtEntpNm(String prjtMtEntpNm) {
		this.prjtMtEntpNm = prjtMtEntpNm;
	}
	public String getFstCntcDt() {
		return fstCntcDt;
	}
	public void setFstCntcDt(String fstCntcDt) {
		this.fstCntcDt = fstCntcDt;
	}
	public String getMemoCnt() {
		return memoCnt;
	}
	public void setMemoCnt(String memoCnt) {
		this.memoCnt = memoCnt;
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
