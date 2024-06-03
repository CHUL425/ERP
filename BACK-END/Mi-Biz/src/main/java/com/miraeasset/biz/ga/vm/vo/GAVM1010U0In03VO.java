package com.miraeasset.biz.ga.vm.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAVM1010U0In03VO extends BaseVO {
	
	@ApiModelProperty(notes = "처리일자", required = true)
	private String prcDt;
	@ApiModelProperty(notes = "일련번호", required = true)
	private String srno;
	@ApiModelProperty(notes = "차량번호", required = true)
	private String vhcNo;
	
//	@ApiModelProperty(notes= "조작자ID")
//    private String optrId         ;    /* 조작자ID */
//    @ApiModelProperty(notes= "조작채널코드")
//    private String oprtChnlCd     ;    /* 조작채널코드 */
//    @ApiModelProperty(notes= "조작조직코드")
//    private String oprtOrzCd      ;    /* 조작조직코드 */
//    @ApiModelProperty(notes= "조작IP주소")
//    private String oprtIpAdr      ;    /* 조작IP주소 */
	
	public String getPrcDt() {
		return prcDt;
	}
	public void setPrcDt(String prcDt) {
		this.prcDt = prcDt;
	}
	public String getSrno() {
		return srno;
	}
	public void setSrno(String srno) {
		this.srno = srno;
	}
	public String getVhcNo() {
		return vhcNo;
	}
	public void setVhcNo(String vhcNo) {
		this.vhcNo = vhcNo;
	}
//	public String getOptrId() {
//		return optrId;
//	}
//	public void setOptrId(String optrId) {
//		this.optrId = optrId;
//	}
//	public String getOprtChnlCd() {
//		return oprtChnlCd;
//	}
//	public void setOprtChnlCd(String oprtChnlCd) {
//		this.oprtChnlCd = oprtChnlCd;
//	}
//	public String getOprtOrzCd() {
//		return oprtOrzCd;
//	}
//	public void setOprtOrzCd(String oprtOrzCd) {
//		this.oprtOrzCd = oprtOrzCd;
//	}
//	public String getOprtIpAdr() {
//		return oprtIpAdr;
//	}
//	public void setOprtIpAdr(String oprtIpAdr) {
//		this.oprtIpAdr = oprtIpAdr;
//	}
	
}
