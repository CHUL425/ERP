/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GAEM1000U0Out11VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 업체관리 업체계약현황 팝업 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.em.vo;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.util.CryptoUtil;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAEM1000U0Out11VO {
	
    @ApiModelProperty(notes= "거래처코드")
    private String delpCd            ; /*거래처코드              */

	@ApiModelProperty(notes= "업체명")
	private String delpNm                ; /*업체명*/                     
	@ApiModelProperty(notes= "사업자등록번호")
	private String blno                  ; /*사업자등록번호 */            
    
    
    @ApiModelProperty(notes= "업종구분코드")
    private String bztpTcd           ; /*업종구분코드            */
    @ApiModelProperty(notes= "업종구분코드명")
    private String bztpTcdNm         ; /*업종구분코드명            */

    @ApiModelProperty(notes= "업종상세구분코드")
    private String bztpDlTcd         ; /*업종상세구분코드        */
    @ApiModelProperty(notes= "업종상세구분코드명")
    private String bztpDlTcdNm       ; /*업종상세구분코드명        */

    @ApiModelProperty(notes= "업체담당자명")
    private String entpChprNm        ; /*업체담당자명            */
    
    @ApiModelProperty(notes= "담당자전화번호")
    private String chprTlno     ; /*담당자전화번호  */
    @ApiModelProperty(notes= "담당자이메일주소")
    private String chprEmalAdr  ; /*담당자이메일주소*/
    
    @ApiModelProperty(notes= "프로젝트관리업체명")
    private String prjtMtEntpNm  ; /*프로젝트관리업체명*/
    
	@ApiModelProperty(notes= "최초계약일자")
	private String fstCntcDt             ; /*최초계약일자 */    
	
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
			return CryptoUtil.getDecryption(chprEmalAdr);
		}
		else{
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
