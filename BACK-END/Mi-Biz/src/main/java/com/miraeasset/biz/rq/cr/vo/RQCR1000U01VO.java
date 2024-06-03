package com.miraeasset.biz.rq.cr.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQCR1000U01VO extends BaseVO {
	
	@ApiModelProperty(notes= "신청일자", required = true)
	private String rqsDt           ; /* 신청일자 */
	@ApiModelProperty(notes= "접수번호", required = true)
    private String rctNo;            // 접수번호
	@ApiModelProperty(notes= "신청유형코드 공사/구매/렌탈...")
    private String unifRqsPcd          ; /* 신청유형코드    */
	@ApiModelProperty(notes= "구분코드")
    private String unifRqsDlPcd		   ; /* 신청상세유형코드 */
	@ApiModelProperty(notes= "유형코드 ")
    private String unifRqsTcd          ; /* 신청구분코드 */
	@ApiModelProperty(notes= "신청조직코드")
	private String rqsOrzCd        ; /* 신청조직코드 */
	@ApiModelProperty(notes= "신청사원번호")
	private String rqsEpno         ; /* 신청사원번호 */
	@ApiModelProperty(notes= "신청제목명")
	private String rqsTtlNm        ; /* 신청제목명 */
	@ApiModelProperty(notes= "신청사유내용")
	private String rqsRsnCn        ; /* 신청사유내용 */
	@ApiModelProperty(notes= "희망일자")
	private String hopeDt          ; /* 희망일자 */
	@ApiModelProperty(notes= "완료일자")
    private String cmpnDt          ; /* 완료일자 */
	@ApiModelProperty(notes= "결재상신관리번호")
	private long aprvWrrptMtNo     ; /* 결재상신관리번호 */
    @ApiModelProperty(notes= "결재상신조직코드")
    private String aprvWrrptOrzCd  ; /* 결재상신조직코드 */
    @ApiModelProperty(notes= "신청상태코드")
	private String rqsScd          ; /* 신청상태코드 */
    
//    @ApiModelProperty(notes= "조작자ID")
//    private String optrId         ;    /* 조작자ID */
//    @ApiModelProperty(notes= "조작채널코드")
//    private String oprtChnlCd     ;    /* 조작채널코드 */
//    @ApiModelProperty(notes= "조작조직코드")
//    private String oprtOrzCd      ;    /* 조작조직코드 */
//    @ApiModelProperty(notes= "조작IP주소")
//    private String oprtIpAdr      ;    /* 조작IP주소 */
    
	public String getRqsDt() {
		return rqsDt;
	}
	public void setRqsDt(String rqsDt) {
		this.rqsDt = rqsDt;
	}
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	public String getUnifRqsPcd() {
		return unifRqsPcd;
	}
	public void setUnifRqsPcd(String unifRqsPcd) {
		this.unifRqsPcd = unifRqsPcd;
	}
	public String getUnifRqsDlPcd() {
		return unifRqsDlPcd;
	}
	public void setUnifRqsDlPcd(String unifRqsDlPcd) {
		this.unifRqsDlPcd = unifRqsDlPcd;
	}
	public String getUnifRqsTcd() {
		return unifRqsTcd;
	}
	public void setUnifRqsTcd(String unifRqsTcd) {
		this.unifRqsTcd = unifRqsTcd;
	}
	public String getRqsOrzCd() {
		return rqsOrzCd;
	}
	public void setRqsOrzCd(String rqsOrzCd) {
		this.rqsOrzCd = rqsOrzCd;
	}
	public String getRqsEpno() {
		return rqsEpno;
	}
	public void setRqsEpno(String rqsEpno) {
		this.rqsEpno = rqsEpno;
	}
	public String getRqsTtlNm() {
		return rqsTtlNm;
	}
	public void setRqsTtlNm(String rqsTtlNm) {
		this.rqsTtlNm = rqsTtlNm;
	}
	public String getRqsRsnCn() {
		return rqsRsnCn;
	}
	public void setRqsRsnCn(String rqsRsnCn) {
		this.rqsRsnCn = rqsRsnCn;
	}
	public String getHopeDt() {
		return hopeDt;
	}
	public void setHopeDt(String hopeDt) {
		this.hopeDt = hopeDt;
	}
	public String getCmpnDt() {
		return cmpnDt;
	}
	public void setCmpnDt(String cmpnDt) {
		this.cmpnDt = cmpnDt;
	}
	public long getAprvWrrptMtNo() {
		return aprvWrrptMtNo;
	}
	public void setAprvWrrptMtNo(long aprvWrrptMtNo) {
		this.aprvWrrptMtNo = aprvWrrptMtNo;
	}
	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}
	public void setAprvWrrptOrzCd(String aprvWrrptOrzCd) {
		this.aprvWrrptOrzCd = aprvWrrptOrzCd;
	}
	public String getRqsScd() {
		return rqsScd;
	}
	public void setRqsScd(String rqsScd) {
		this.rqsScd = rqsScd;
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
