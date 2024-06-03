package com.miraeasset.biz.ga.vm.vo;

import com.miraeasset.biz.common.vo.BaseVO;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAVM1010U0In02VO extends BaseVO {
	
	@ApiModelProperty(notes = "처리일자")
	private String prcDt;
	@ApiModelProperty(notes = "일련번호", example = "등록시 자동채번")
	private String srno;
	@ApiModelProperty(notes = "차량번호")
	private String vhcNo;
	@ApiModelProperty(notes = "주유카드")
	private String reflCardEcpVl;
	@ApiModelProperty(notes = "특이사항")
	private String pclrPtcrCn;
//
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
	public String getReflCardEcpVl() {
		return reflCardEcpVl;
	}
	public void setReflCardEcpVl(String reflCardEcpVl) {
		this.reflCardEcpVl = reflCardEcpVl;
	}
	public String getPclrPtcrCn() {
		return pclrPtcrCn;
	}
	public void setPclrPtcrCn(String pclrPtcrCn) {
		this.pclrPtcrCn = pclrPtcrCn;
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
//
//	@Override
//	public String toString() {
//		return "GAVM1010U0In02VO [prcDt=" + prcDt + ", srno=" + srno + ", vhcNo=" + vhcNo + ", reflCardEcpVl="
//				+ reflCardEcpVl + ", pclrPtcrCn=" + pclrPtcrCn + ", optrId=" + optrId + ", oprtChnlCd=" + oprtChnlCd
//				+ ", oprtOrzCd=" + oprtOrzCd + ", oprtIpAdr=" + oprtIpAdr + "]";
//	}
    
}
