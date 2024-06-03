/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GAEM1000U0In02VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 업체관리 수정(PK)
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.em.vo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.util.CryptoUtil;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAEM1000U0In02VO {
	
    @ApiModelProperty(notes= "거래처코드")
    private String delpCd            ; /*거래처코드              */

	@ApiModelProperty(notes= "업체명")
	private String delpNm                ; /*업체명*/                     
	@ApiModelProperty(notes= "사업자등록번호")
	private String blno                  ; /*사업자등록번호 */            
    
    
    @ApiModelProperty(notes= "업종구분코드")
    private String bztpTcd           ; /*업종구분코드            */

    @ApiModelProperty(notes= "업종상세구분코드")
    private String bztpDlTcd         ; /*업종상세구분코드        */

    @ApiModelProperty(notes= "업체담당자명")
    private String entpChprNm        ; /*업체담당자명            */
    
    @ApiModelProperty(notes= "담당자전화번호")
    private String chprTlno     ; /*담당자전화번호  */
    @ApiModelProperty(notes= "담당자이메일주소")
    private String chprEmalAdr  ; /*담당자이메일주소*/
    
    @ApiModelProperty(notes= "프로젝트관리업체명")
    private String prjtMtEntpNm  ; /*프로젝트관리업체명*/    
    
    @ApiModelProperty(notes= "최초계약일자")
    private String fstCntcDt         ; /*최초계약일자            */
    @ApiModelProperty(notes= "조작자ID ")
    private String optrId            ; /*조작자ID                */
    @ApiModelProperty(notes= "조작채널코드")
    private String oprtChnlCd        ; /*조작채널코드            */
    @ApiModelProperty(notes= "조작조직코드")
    private String oprtOrzCd         ; /*조작조직코드            */
    @ApiModelProperty(notes= "조작IP주소")
    private String oprtIpAdr         ; /*조작IP주소              */
    @ApiModelProperty(notes= "조작일시")
    private String oprtDttm          ; /*조작일시                */    

    @Override
    public String toString() {
        return "GAEM1000U0In02VO{" +
        		"delpCd      ='" + delpCd        + "'" +
        		"bztpTcd     ='" + bztpTcd   + "'" +
        		"bztpDlTcd   ='" + bztpDlTcd + "'" +
                '}';    	
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

	public String getBztpDlTcd() {
		return bztpDlTcd;
	}

	public void setBztpDlTcd(String bztpDlTcd) {
		this.bztpDlTcd = bztpDlTcd;
	}

	public String getEntpChprNm() {
		return entpChprNm;
	}

	public void setEntpChprNm(String entpChprNm) {
		this.entpChprNm = entpChprNm;
	}

	public String getChprTlno() {
		return chprTlno;
	}

	public void setChprTlno(String chprTlno) {
		this.chprTlno = chprTlno;
	}

	public String getChprEmalAdr() {
		return chprEmalAdr;
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

	public void setOprtDttm(String oprtDttm) {
		this.oprtDttm = oprtDttm;
	}


    
}
