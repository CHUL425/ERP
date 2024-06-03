package com.miraeasset.biz.common.vo;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@Component
public class GA09N502VO {

	// GA09N502
	private String msgSndSrno ; /* 메시지발송일련번호 */
	private String iprtMsgCd ; /* 알림메시지코드 */
	private String msgSndCn ; /* 메시지발송내용 */
	private String smsSndDt ; /* SMS발송일자 */
	private String smsSndTmd ; /* SMS발송시각 */
	private String orzCd ; /* 조직코드 */
	private String epno ; /* 사원번호 */
	private String delpCd ; /* 거래처코드 */
	private String bztpTcd ; /* 업종구분코드 */
	private String bztpDlTcd ; /* 업종상세구분코드 */
	private String tlnoEcpVl ; /* 전화번호암호화값 */
	private String emalAdrEcpVl ; /* 이메일주소암호화값 */
	private String rctNo ; /* 접수번호 */
	private String msgSndRespCn ; /* 메시지발송응답내용 */
	private String cfmtYn ; /* 확인여부 */


	private String optrId            ; /*조작자ID                */
	private String oprtChnlCd        ; /*조작채널코드            */
	private String oprtOrzCd         ; /*조작조직코드            */
	private String oprtIpAdr         ; /*조작IP주소              */


	public String getMsgSndSrno() { 		return msgSndSrno; 	} 	public void setMsgSndSrno(String msgSndSrno) { 		this.msgSndSrno = msgSndSrno; 	}
	public String getIprtMsgCd() { 		return iprtMsgCd; 	} 	public void setIprtMsgCd(String iprtMsgCd) { 		this.iprtMsgCd = iprtMsgCd; 	}
	public String getMsgSndCn() { 		return msgSndCn; 	} 	public void setMsgSndCn(String msgSndCn) { 		this.msgSndCn = msgSndCn; 	}
	public String getSmsSndDt() { 		return smsSndDt; 	} 	public void setSmsSndDt(String smsSndDt) { 		this.smsSndDt = smsSndDt; 	}
	public String getSmsSndTmd() { 		return smsSndTmd; 	} 	public void setSmsSndTmd(String smsSndTmd) { 		this.smsSndTmd = smsSndTmd; 	}
	public String getOrzCd() { 		return orzCd; 	} 	public void setOrzCd(String orzCd) { 		this.orzCd = orzCd; 	}
	public String getEpno() { 		return epno; 	} 	public void setEpno(String epno) { 		this.epno = epno; 	}
	public String getDelpCd() { 		return delpCd; 	} 	public void setDelpCd(String delpCd) { 		this.delpCd = delpCd; 	}
	public String getBztpTcd() { 		return bztpTcd; 	} 	public void setBztpTcd(String bztpTcd) { 		this.bztpTcd = bztpTcd; 	}
	public String getBztpDlTcd() { 		return bztpDlTcd; 	} 	public void setBztpDlTcd(String bztpDlTcd) { 		this.bztpDlTcd = bztpDlTcd; 	}
	public String getTlnoEcpVl() { 		return tlnoEcpVl; 	} 	public void setTlnoEcpVl(String tlnoEcpVl) { 		this.tlnoEcpVl = tlnoEcpVl; 	}
	public String getEmalAdrEcpVl() { 		return emalAdrEcpVl; 	} 	public void setEmalAdrEcpVl(String emalAdrEcpVl) { 		this.emalAdrEcpVl = emalAdrEcpVl; 	}
	public String getRctNo() { 		return rctNo; 	} 	public void setRctNo(String rctNo) { 		this.rctNo = rctNo; 	}
	public String getMsgSndRespCn() { 		return msgSndRespCn; 	} 	public void setMsgSndRespCn(String msgSndRespCn) { 		this.msgSndRespCn = msgSndRespCn; 	}
	public String getCfmtYn() { 		return cfmtYn; 	} 	public void setCfmtYn(String cfmtYn) { 		this.cfmtYn = cfmtYn; 	}


	public String getOptrId() { return optrId; } public void setOptrId(String optrId) { this.optrId = optrId; }
	public String getOprtChnlCd() { return oprtChnlCd; } public void setOprtChnlCd(String oprtChnlCd) { this.oprtChnlCd = oprtChnlCd; }
	public String getOprtOrzCd() { return oprtOrzCd; } public void setOprtOrzCd(String oprtOrzCd) { this.oprtOrzCd = oprtOrzCd; }
	public String getOprtIpAdr() { return oprtIpAdr; } public void setOprtIpAdr(String oprtIpAdr) { this.oprtIpAdr = oprtIpAdr; }


}
