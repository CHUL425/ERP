package com.miraeasset.biz.rq.rr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQRR1000U0In12VO {

    @ApiModelProperty(notes= "접수번호", required = true)
    private String rctNo;            // 접수번호
    @ApiModelProperty(notes= "접수상세번호", required = true)
    private String rctDlNo;          // 접수상세번호
    @ApiModelProperty(notes= "장비구분코드")
    private String eqmtTcd       ;  /*장비구분코드    */
    @ApiModelProperty(notes= "임대계약번호")
    private String rentCntcNo    ;  /*임대계약번호    */
    @ApiModelProperty(notes= "제품명")
    private String gdsNm         ;  /*제품명          */
    @ApiModelProperty(notes= "신청요청사항내용 ")
    private String rqsRqmPtcrCn  ;  /*신청요청사항내용   */
    @ApiModelProperty(notes= "조작자ID")
    private String optrId        ;  /*조작자ID        */
    @ApiModelProperty(notes= "조작채널코드")
    private String oprtChnlCd    ;  /*조작채널코드    */
    @ApiModelProperty(notes= "조작조직코드")
    private String oprtOrzCd     ;  /*조작조직코드    */
    @ApiModelProperty(notes= "조작IP주소")
    private String oprtIpAdr     ;  /*조작IP주소      */
    
    @Override
    public String toString() {
        return "RENT11In02VO{" +
                "rctNo       = '" + rctNo        + "'"+
                "rctDlNo     = '" + rctDlNo      + "'"+
                "eqmtTcd     = '" + eqmtTcd      + "'"+
                "rentCntcNo  = '" + rentCntcNo   + "'"+
                "gdsNm       = '" + gdsNm        + "'"+
                "rqsRqmPtcrCn  = '" + rqsRqmPtcrCn   + "'"+
                '}';    	
    }

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public String getRctDlNo() {
		return rctDlNo;
	}

	public void setRctDlNo(String rctDlNo) {
		this.rctDlNo = rctDlNo;
	}

	public String getEqmtTcd() {
		return eqmtTcd;
	}

	public void setEqmtTcd(String eqmtTcd) {
		this.eqmtTcd = eqmtTcd;
	}

	public String getRentCntcNo() {
		return rentCntcNo;
	}

	public void setRentCntcNo(String rentCntcNo) {
		this.rentCntcNo = rentCntcNo;
	}

	public String getGdsNm() {
		return gdsNm;
	}

	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}

	public String getRqsRqmPtcrCn() {
		return rqsRqmPtcrCn;
	}

	public void setRqsRqmPtcrCn(String rqsRqmPtcrCn) {
		this.rqsRqmPtcrCn = rqsRqmPtcrCn;
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
    
	
}
