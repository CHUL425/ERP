/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: AT01C001VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: AT01C001	계정과목코드 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class AT01C001VO {
	
    @ApiModelProperty(notes= "회사코드")
    private String coCd               ; /*회사코드        */   
    @ApiModelProperty(notes= "계정과목코드")
    private String acsjCd             ; /*계정과목코드    */
    @ApiModelProperty(notes= "회계기준코드")
    private String actgBasCd          ; /*회계기준코드    */
    @ApiModelProperty(notes= "계정과목코드명")
    private String acsjCdNm           ; /*계정과목코드명  */
    @ApiModelProperty(notes= "계정과목영문명")
    private String acsjEngNm          ; /*계정과목영문명  */
    @ApiModelProperty(notes= "계정과목약어명")
    private String acsjAbrvNm         ; /*계정과목약어명  */
    @ApiModelProperty(notes= "상위계정과목코드")
    private String hrkAcsjCd          ; /*상위계정과목코드*/
    @ApiModelProperty(notes= "상위가감구분코드")
    private String hrkAnsTcd          ; /*상위가감구분코드*/
    @ApiModelProperty(notes= "정렬계정과목코드")
    private String sortAcsjCd         ; /*정렬계정과목코드*/
    @ApiModelProperty(notes= "계정유형코드")
    private String acctPcd            ; /*계정유형코드    */
    @ApiModelProperty(notes= "차대구분코드")
    private String dncTcd             ; /*차대구분코드    */
    @ApiModelProperty(notes= "기표여부")
    private String fbltYn             ; /*기표여부        */
    @ApiModelProperty(notes= "자산유형구분코드")
    private String astPtnTcd          ; /*자산유형구분코드*/
    @ApiModelProperty(notes= "계정과목등급코드")
    private String acsjGcd            ; /*계정과목등급코드*/
    @ApiModelProperty(notes= "예산계정과목코드")
    private String bdgtAcsjCd         ; /*예산계정과목코드*/
    @ApiModelProperty(notes= "본사결의여부")
    private String hoRslnYn           ; /*본사결의여부    */
    @ApiModelProperty(notes= "본사수기여부")
    private String hoHwYn             ; /*본사수기여부    */
    @ApiModelProperty(notes= "지점결의여부")
    private String brRslnYn           ; /*지점결의여부    */
    @ApiModelProperty(notes= "지점수기여부")
    private String brHwYn             ; /*지점수기여부    */
    @ApiModelProperty(notes= "적요처리여부")
    private String smryPrcYn          ; /*적요처리여부    */
    @ApiModelProperty(notes= "계정사용여부")
    private String acctUseYn          ; /*계정사용여부    */
    @ApiModelProperty(notes= "본사정산결의여부")
    private String hoExccRslnYn       ; /*본사정산결의여부*/
    @ApiModelProperty(notes= "지점정산결의여부")
    private String brExccRslnYn       ; /*지점정산결의여부*/
    @ApiModelProperty(notes= "조작자ID")
    private String optrId             ; /*조작자ID        */
    @ApiModelProperty(notes= "조작채널코드")
    private String oprtChnlCd         ; /*조작채널코드    */
    @ApiModelProperty(notes= "조작조직코드")
    private String oprtOrzCd          ; /*조작조직코드    */
    @ApiModelProperty(notes= "조작IP주소 ")
    private String oprtIpAdr          ; /*조작IP주소      */
    @ApiModelProperty(notes= "조작일시")
    private String oprtDttm           ; /*조작일시        */
	public String getCoCd() {
		return coCd;
	}
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	public String getAcsjCd() {
		return acsjCd;
	}
	public void setAcsjCd(String acsjCd) {
		this.acsjCd = acsjCd;
	}
	public String getActgBasCd() {
		return actgBasCd;
	}
	public void setActgBasCd(String actgBasCd) {
		this.actgBasCd = actgBasCd;
	}
	public String getAcsjCdNm() {
		return acsjCdNm;
	}
	public void setAcsjCdNm(String acsjCdNm) {
		this.acsjCdNm = acsjCdNm;
	}
	public String getAcsjEngNm() {
		return acsjEngNm;
	}
	public void setAcsjEngNm(String acsjEngNm) {
		this.acsjEngNm = acsjEngNm;
	}
	public String getAcsjAbrvNm() {
		return acsjAbrvNm;
	}
	public void setAcsjAbrvNm(String acsjAbrvNm) {
		this.acsjAbrvNm = acsjAbrvNm;
	}
	public String getHrkAcsjCd() {
		return hrkAcsjCd;
	}
	public void setHrkAcsjCd(String hrkAcsjCd) {
		this.hrkAcsjCd = hrkAcsjCd;
	}
	public String getHrkAnsTcd() {
		return hrkAnsTcd;
	}
	public void setHrkAnsTcd(String hrkAnsTcd) {
		this.hrkAnsTcd = hrkAnsTcd;
	}
	public String getSortAcsjCd() {
		return sortAcsjCd;
	}
	public void setSortAcsjCd(String sortAcsjCd) {
		this.sortAcsjCd = sortAcsjCd;
	}
	public String getAcctPcd() {
		return acctPcd;
	}
	public void setAcctPcd(String acctPcd) {
		this.acctPcd = acctPcd;
	}
	public String getDncTcd() {
		return dncTcd;
	}
	public void setDncTcd(String dncTcd) {
		this.dncTcd = dncTcd;
	}
	public String getFbltYn() {
		return fbltYn;
	}
	public void setFbltYn(String fbltYn) {
		this.fbltYn = fbltYn;
	}
	public String getAstPtnTcd() {
		return astPtnTcd;
	}
	public void setAstPtnTcd(String astPtnTcd) {
		this.astPtnTcd = astPtnTcd;
	}
	public String getAcsjGcd() {
		return acsjGcd;
	}
	public void setAcsjGcd(String acsjGcd) {
		this.acsjGcd = acsjGcd;
	}
	public String getBdgtAcsjCd() {
		return bdgtAcsjCd;
	}
	public void setBdgtAcsjCd(String bdgtAcsjCd) {
		this.bdgtAcsjCd = bdgtAcsjCd;
	}
	public String getHoRslnYn() {
		return hoRslnYn;
	}
	public void setHoRslnYn(String hoRslnYn) {
		this.hoRslnYn = hoRslnYn;
	}
	public String getHoHwYn() {
		return hoHwYn;
	}
	public void setHoHwYn(String hoHwYn) {
		this.hoHwYn = hoHwYn;
	}
	public String getBrRslnYn() {
		return brRslnYn;
	}
	public void setBrRslnYn(String brRslnYn) {
		this.brRslnYn = brRslnYn;
	}
	public String getBrHwYn() {
		return brHwYn;
	}
	public void setBrHwYn(String brHwYn) {
		this.brHwYn = brHwYn;
	}
	public String getSmryPrcYn() {
		return smryPrcYn;
	}
	public void setSmryPrcYn(String smryPrcYn) {
		this.smryPrcYn = smryPrcYn;
	}
	public String getAcctUseYn() {
		return acctUseYn;
	}
	public void setAcctUseYn(String acctUseYn) {
		this.acctUseYn = acctUseYn;
	}
	public String getHoExccRslnYn() {
		return hoExccRslnYn;
	}
	public void setHoExccRslnYn(String hoExccRslnYn) {
		this.hoExccRslnYn = hoExccRslnYn;
	}
	public String getBrExccRslnYn() {
		return brExccRslnYn;
	}
	public void setBrExccRslnYn(String brExccRslnYn) {
		this.brExccRslnYn = brExccRslnYn;
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
