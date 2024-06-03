package com.miraeasset.biz.common.cm.ds.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CMDS1000V0Out00VO {
	
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal totCnt   ;    	 /* 전체건수 */
	
    @ApiModelProperty(notes= "기안조직코드")
    private String drftOrzCd	;        /* 기안조직코드 */
    @ApiModelProperty(notes= "기안조직명")
    private String drftOrzNm	;        /* 기안조직명 */
    @ApiModelProperty(notes= "기안문서번호")
    private String drftDocNo	;        /* 기안문서번호 */
    @ApiModelProperty(notes= "문서번호명")
    private String docNoNm		;        /* 문서번호명 */
    @ApiModelProperty(notes= "기안문서제목명")
    private String drftDocTtlNm	;        /* 기안문서제목명 */
    @ApiModelProperty(notes= "기안자사원번호")
    private String drftrEpno	;        /* 기안자사원번호 */
    @ApiModelProperty(notes= "기안자사원명")
    private String drftrEpNm	;        /* 기안자사원명 */
    @ApiModelProperty(notes= "기안일자")
    private String drftDt   	;	     /* 기안일자 */
    @ApiModelProperty(notes= "승인일자")
    private String aprvDt 		;        /* 승인일자 */
	@ApiModelProperty(notes = "기안문서URL")
	private String drftDocUrl;
//    @ApiModelProperty(notes= "조작자ID")
//    private String optrId       ;	     /* 조작자ID */
//    @ApiModelProperty(notes= "조작채널코드")
//    private String oprtChnlCd   ;        /* 조작채널코드 */
//    @ApiModelProperty(notes= "조작조직코드")
//    private String oprtOrzCd    ;        /* 조작조직코드 */
//    @ApiModelProperty(notes= "조작IP주소")
//    private String oprtIpAdr    ;        /* 조작IP주소 */
//    @ApiModelProperty(notes= "조작일시")
//    private String oprtDttm         ;    /* 조작일시 */
    
	public BigDecimal getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(BigDecimal totCnt) {
		this.totCnt = totCnt;
	}
	public String getDrftOrzCd() {
		return drftOrzCd;
	}
	public void setDrftOrzCd(String drftOrzCd) {
		this.drftOrzCd = drftOrzCd;
	}
	public String getDrftOrzNm() {
		return drftOrzNm;
	}
	public void setDrftOrzNm(String drftOrzNm) {
		this.drftOrzNm = drftOrzNm;
	}
	public String getDrftDocNo() {
		return drftDocNo;
	}
	public void setDrftDocNo(String drftDocNo) {
		this.drftDocNo = drftDocNo;
	}
	public String getDocNoNm() {
		return docNoNm;
	}
	public void setDocNoNm(String docNoNm) {
		this.docNoNm = docNoNm;
	}
	public String getDrftDocTtlNm() {
		return drftDocTtlNm;
	}
	public void setDrftDocTtlNm(String drftDocTtlNm) {
		this.drftDocTtlNm = drftDocTtlNm;
	}
	public String getDrftrEpno() {
		return drftrEpno;
	}
	public void setDrftrEpno(String drftrEpno) {
		this.drftrEpno = drftrEpno;
	}
	public String getDrftDt() {
		return drftDt;
	}
	public void setDrftDt(String drftDt) {
		this.drftDt = drftDt;
	}
	public String getAprvDt() {
		return aprvDt;
	}
	public void setAprvDt(String aprvDt) {
		this.aprvDt = aprvDt;
	}

	public String getDrftDocUrl() {
		return drftDocUrl;
	}

	public void setDrftDocUrl(String drftDocUrl) {
		this.drftDocUrl = drftDocUrl;
	}
	

	public String getDrftrEpNm() {
		return drftrEpNm;
	}
	public void setDrftrEpNm(String drftrEpNm) {
		this.drftrEpNm = drftrEpNm;
	}
	@Override
	public String toString() {
		return "CMDS1000V0Out00VO [totCnt=" + totCnt + ", drftOrzCd=" + drftOrzCd + ", drftOrzNm=" + drftOrzNm
				+ ", drftDocNo=" + drftDocNo + ", docNoNm=" + docNoNm + ", drftDocTtlNm=" + drftDocTtlNm
				+ ", drftrEpno=" + drftrEpno + ", drftDt=" + drftDt + ", aprvDt=" + aprvDt
				+ ", drftDocUlr=" + drftDocUrl;
				//+ ", optrId=" + optrId + ", oprtChnlCd=" + oprtChnlCd + ", oprtOrzCd=" + oprtOrzCd + ", oprtIpAdr=" + oprtIpAdr + ", oprtDttm=" + oprtDttm + "]";
	}
    
}
