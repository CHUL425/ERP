package com.miraeasset.biz.rq.rr.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQRR1000U0In00VO {
	
    @ApiModelProperty(notes= "조회시작일자", required = true)
    private String qryStrtDt;            // 조회시작일자
    @ApiModelProperty(notes= "조회종료일자", required = true)
    private String qryEndDt;            // 조회종료일자

    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;      // 페이지사이즈
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;     // 페이지순번
    
    @ApiModelProperty(notes= "접수번호")
    private String rctNo         ; // 접수번호
    @ApiModelProperty(notes= "신청유형코드")
    private String unifRqsPcd        ; /*신청유형코드    */
    @ApiModelProperty(notes= "신청유형코드명")
    private String unifRqsPcdNm      ; /*신청유형코드명    */
    @ApiModelProperty(notes= "신청조직코드")
    private String rqsOrzCd      ; /*신청조직코드    */
    @ApiModelProperty(notes= "신청조직명")
    private String rqsOrzNm      ; /*신청조직명    */
    @ApiModelProperty(notes= "신청사원번호")
    private String rqsEpno       ; /*신청사원번호    */
    @ApiModelProperty(notes= "신청사원명")
    private String rqsEpNm       ; /*신청사원명    */
    @ApiModelProperty(notes= "신청제목명")
    private String rqsTtlNm      ; /*신청제목명      */
    @ApiModelProperty(notes= "설치장소명")
    private String istPlcNm      ; /*설치장소명      */
    @ApiModelProperty(notes= "신청사유내용 ")
    private String rqsRsnCn      ; /*신청사유내용 */
    @ApiModelProperty(notes= "희망일자")
    private String hopeDt        ; /*희망일자        */
    @ApiModelProperty(notes= "신청일자")
    private String rqsDt         ; /*신청일자        */
    @ApiModelProperty(notes= "결재상신관리번호")
    private String aprvWrrptMtNo    ; /*결재상신관리번호      */
    @ApiModelProperty(notes= "신청상태코드")
    private String rqsScd        ; /*신청상태코드    */
    @ApiModelProperty(notes= "신청상태코드명")
    private String rqsScdNm      ; /*신청상태코드명    */ 
    
    @ApiModelProperty(notes= "접수상세번호")
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
	public String getQryStrtDt() {
		return qryStrtDt;
	}
	public void setQryStrtDt(String qryStrtDt) {
		this.qryStrtDt = qryStrtDt;
	}
	public String getQryEndDt() {
		return qryEndDt;
	}
	public void setQryEndDt(String qryEndDt) {
		this.qryEndDt = qryEndDt;
	}
	public BigDecimal getPageSize() {
		return pageSize;
	}
	public void setPageSize(BigDecimal pageSize) {
		this.pageSize = pageSize;
	}
	public BigDecimal getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(BigDecimal pageIndex) {
		this.pageIndex = pageIndex;
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
	public String getUnifRqsPcdNm() {
		return unifRqsPcdNm;
	}
	public void setUnifRqsPcdNm(String unifRqsPcdNm) {
		this.unifRqsPcdNm = unifRqsPcdNm;
	}
	public String getRqsOrzCd() {
		return rqsOrzCd;
	}
	public void setRqsOrzCd(String rqsOrzCd) {
		this.rqsOrzCd = rqsOrzCd;
	}
	public String getRqsOrzNm() {
		return rqsOrzNm;
	}
	public void setRqsOrzNm(String rqsOrzNm) {
		this.rqsOrzNm = rqsOrzNm;
	}
	public String getRqsEpno() {
		return rqsEpno;
	}
	public void setRqsEpno(String rqsEpno) {
		this.rqsEpno = rqsEpno;
	}
	public String getRqsEpNm() {
		return rqsEpNm;
	}
	public void setRqsEpNm(String rqsEpNm) {
		this.rqsEpNm = rqsEpNm;
	}
	public String getRqsTtlNm() {
		return rqsTtlNm;
	}
	public void setRqsTtlNm(String rqsTtlNm) {
		this.rqsTtlNm = rqsTtlNm;
	}
	public String getIstPlcNm() {
		return istPlcNm;
	}
	public void setIstPlcNm(String istPlcNm) {
		this.istPlcNm = istPlcNm;
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
	public String getRqsDt() {
		return rqsDt;
	}
	public void setRqsDt(String rqsDt) {
		this.rqsDt = rqsDt;
	}
	public String getAprvWrrptMtNo() {
		return aprvWrrptMtNo;
	}
	public void setAprvWrrptMtNo(String aprvWrrptMtNo) {
		this.aprvWrrptMtNo = aprvWrrptMtNo;
	}
	public String getRqsScd() {
		return rqsScd;
	}
	public void setRqsScd(String rqsScd) {
		this.rqsScd = rqsScd;
	}
	public String getRqsScdNm() {
		return rqsScdNm;
	}
	public void setRqsScdNm(String rqsScdNm) {
		this.rqsScdNm = rqsScdNm;
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
