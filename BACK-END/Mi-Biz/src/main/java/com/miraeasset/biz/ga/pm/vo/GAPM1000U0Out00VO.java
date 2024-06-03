/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GAPM1000U0Out00VO.java
*	04. 작  성  일  자	: 2023.07.03
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 정기주차권관리 목록조회 out
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ga.pm.vo;

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
public class GAPM1000U0Out00VO {

	@ExcelColumnInfo(notes= "유무료구분코드")
	@ApiModelProperty(notes= "유무료구분코드")
	private String chfTcd     ; /* 유무료구분코드 */		
	@ExcelColumnInfo(notes= "차량번호")
	@ApiModelProperty(notes= "차량번호")
	private String vhcNo       ; /*차량번호 */     
	@ExcelColumnInfo(notes= "차량유형구분코드")
	@ApiModelProperty(notes= "차량유형코드")
	private String vhcPcd      ; /*차량유형코드 */       
	@ExcelColumnInfo(notes= "조직코드")
	@ApiModelProperty(notes= "사용자조직코드")
	private String userOrzCd   ; /*사용자조직코드 */      
	@ExcelColumnInfo(notes= "성명")
	@ApiModelProperty(notes= "사용자사원명")
	private String userEpNm    ; /*사용자사원명 */
	@ExcelColumnInfo(notes= "사번")
	@ApiModelProperty(notes= "사용자사원번호")
	private String userEpno    ; /*사용자사원번호 */       
	@ExcelColumnInfo(notes= "직위")
	@ApiModelProperty(notes= "인사직위명")
	private String hrPstNm     ; /*인사직위명*/      
	@ExcelColumnInfo(notes= "근무위치(층)")
	@ApiModelProperty(notes= "건물명")
	private String bldNm    ; /*건물명 */    
	@ExcelColumnInfo(notes= "특이사항")
	@ApiModelProperty(notes= "비고내용")
	private String nteCn       ; /*비고내용 */      

	@ApiModelProperty(notes= "유무료구분코드명")
	private String chfTcdNm   ; /* 유무료구분코드명 */		
	@ApiModelProperty(notes= "차량유형코드명")
	private String vhcPcdNm    ; /*차량유형코드명 */      
	@ApiModelProperty(notes= "사용자조직명")
	private String userOrzNm   ; /*사용자조직명 */      
	@ApiModelProperty(notes= "순번", example="0")
	private BigDecimal rnum       ; /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수             */
	public String getBldNm() {
		return bldNm;
	}
	public void setBldNm(String bldNm) {
		this.bldNm = bldNm;
	}
	public String getVhcNo() {
		return vhcNo;
	}
	public void setVhcNo(String vhcNo) {
		this.vhcNo = vhcNo;
	}
	public String getChfTcd() {
		return chfTcd;
	}
	public void setChfTcd(String chfTcd) {
		this.chfTcd = chfTcd;
	}
	public String getChfTcdNm() {
		return chfTcdNm;
	}
	public void setChfTcdNm(String chfTcdNm) {
		this.chfTcdNm = chfTcdNm;
	}
	public String getVhcPcd() {
		return vhcPcd;
	}
	public void setVhcPcd(String vhcPcd) {
		this.vhcPcd = vhcPcd;
	}
	public String getVhcPcdNm() {
		return vhcPcdNm;
	}
	public void setVhcPcdNm(String vhcPcdNm) {
		this.vhcPcdNm = vhcPcdNm;
	}
	public String getUserEpno() {
		return userEpno;
	}
	public void setUserEpno(String userEpno) {
		this.userEpno = userEpno;
	}
	public String getUserEpNm() {
		return userEpNm;
	}
	public void setUserEpNm(String userEpNm) {
		this.userEpNm = userEpNm;
	}
	public String getUserOrzCd() {
		return userOrzCd;
	}
	public void setUserOrzCd(String userOrzCd) {
		this.userOrzCd = userOrzCd;
	}
	public String getUserOrzNm() {
		return userOrzNm;
	}
	public void setUserOrzNm(String userOrzNm) {
		this.userOrzNm = userOrzNm;
	}
	public String getHrPstNm() {
		return hrPstNm;
	}
	public void setHrPstNm(String hrPstNm) {
		this.hrPstNm = hrPstNm;
	}
	public String getNteCn() {
		return nteCn;
	}
	public void setNteCn(String nteCn) {
		this.nteCn = nteCn;
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
