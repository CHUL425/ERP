package com.miraeasset.biz.common.basic.vo;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@Component
public class BasicLoginHisOutVO {

    @ApiModelProperty(notes= "사원번호", required = true, example ="112345")
    private String epno        ; /*사원번호    */
    @ApiModelProperty(notes= "사원명")
    private String epNm        ; /*사원명    */
    @ApiModelProperty(notes= "로그인일시" )
    private String lginDttm    ; /*로그인일시  */
    @ApiModelProperty(notes= "로그아웃일시" )
    private String lgotDttm    ; /*로그아웃일시*/
    @ApiModelProperty(notes= "조작자ID" )
    private String optrId      ; /*조작자ID    */
    @ApiModelProperty(notes= "조작채널코드" )
    private String oprtChnlCd  ; /*조작채널코드*/
    @ApiModelProperty(notes= "조작채널명" )
    private String oprtChnlNm  ; /*조작채널명*/
    @ApiModelProperty(notes= "조작조직코드" )
    private String oprtOrzCd   ; /*조작조직코드*/
    @ApiModelProperty(notes= "조작IP주소 " )
    private String oprtIpAdr   ; /*조작IP주소  */
    @ApiModelProperty(notes= "조작일시" )
    private String oprtDttm    ; /*조작일시    */
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getLginDttm() {
		return lginDttm;
	}
	public void setLginDttm(String lginDttm) {
		this.lginDttm = lginDttm;
	}
	public String getLgotDttm() {
		return lgotDttm;
	}
	public void setLgotDttm(String lgotDttm) {
		this.lgotDttm = lgotDttm;
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
	public String getEpNm() {
		return epNm;
	}
	public void setEpNm(String epNm) {
		this.epNm = epNm;
	}
	public String getOprtChnlNm() {
		return oprtChnlNm;
	}
	public void setOprtChnlNm(String oprtChnlNm) {
		this.oprtChnlNm = oprtChnlNm;
	}

    
}
