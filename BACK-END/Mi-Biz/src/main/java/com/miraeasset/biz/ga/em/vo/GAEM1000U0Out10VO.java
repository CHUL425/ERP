/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GAEM1000U0Out10VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 거래처조회 팝업(ERP) OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.em.vo;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.util.CryptoUtil;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAEM1000U0Out10VO {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@ApiModelProperty(notes= "거래처코드")
    private String delpCd       ; /*거래처코드 */
	@ApiModelProperty(notes= "거래처명")
    private String delpNm       ; /*거래처명 */
	@ApiModelProperty(notes= "사업자등록번호")
    private String blno         ; /*사업자등록번호 */
	@ApiModelProperty(notes= "거래처대표자명")
    private String delpRptvNm   ; /*거래처대표자명 */
	@ApiModelProperty(notes= "거래처이메일")
    private String emalAdr      ; /*거래처이메일*/
	@ApiModelProperty(notes= "법인등록번호")
    private String cono         ; /*법인등록번호 */
	@ApiModelProperty(notes= "거래처구분코드")
    private String delpTcd      ; /*거래처구분코드 */
	@ApiModelProperty(notes= "거래처구분코드명")
    private String delpTcdNm    ; /*거래처구분코드명 */
    

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
	public String getDelpRptvNm() {
		return delpRptvNm;
	}
	public void setDelpRptvNm(String delpRptvNm) {
		this.delpRptvNm = delpRptvNm;
	}
	public String getEmalAdr() {
		//log.info("emalAdr["+emalAdr+"]");
		
		if(!StringUtils.isBlank(emalAdr)){
			//log.info("emalAdr org ["+emalAdr+"]");

			//log.info("emalAdr dec1["+CryptoUtil.getDecryption(emalAdr)+"]");

			//log.info("emalAdr dec2["+CryptoUtil.getDecryption2(emalAdr)+"]");

			return CryptoUtil.getDecryption(emalAdr);
		}
		else{
			
			return emalAdr;
		}		
	}
	
	public void setEmalAdr(String emalAdr) {
		this.emalAdr = emalAdr;
	}
	
	public String getCono() {
		return cono;
	}
	public void setCono(String cono) {
		this.cono = cono;
	}
	public String getDelpTcd() {
		return delpTcd;
	}
	public void setDelpTcd(String delpTcd) {
		this.delpTcd = delpTcd;
	}
	public String getDelpTcdNm() {
		return delpTcdNm;
	}
	public void setDelpTcdNm(String delpTcdNm) {
		this.delpTcdNm = delpTcdNm;
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
