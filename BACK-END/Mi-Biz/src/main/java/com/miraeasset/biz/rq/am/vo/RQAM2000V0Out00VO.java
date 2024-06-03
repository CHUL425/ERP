package com.miraeasset.biz.rq.am.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQAM2000V0Out00VO {
	
	@ApiModelProperty(notes= "접수번호")
	private String rctNo           ; /*접수번호         */
	
	@ApiModelProperty(notes= "신청상태코드")
	private String rqsScd          ; /*신청상태코드     */
	@ApiModelProperty(notes= "신청상태코드명")
	private String rqsScdNm        ; /*신청상태코드명   */
	
	@ApiModelProperty(notes= "구분코드")
	private String bizTcd        ; /*업무구분코드   */
	@ApiModelProperty(notes= "구분코드명")
	private String bizTcdNm        ; /*업무구분코드명   */
	
	@ApiModelProperty(notes= "승인상태명")
	private String aprvInfo        ; /*승인상태명   */
	
	@ApiModelProperty(notes= "승인반려구분코드 1,3:승인 2:반려")
	private String aprvRtrnTcd        ; /*승인반려구분코드   */
	
	@ApiModelProperty(notes= "신청제목명")
	private String rqsTtlNm        ; /*신청제목명       */

	@ApiModelProperty(notes= "신청명")
	private String rqsRsnCn         ; /*신청사유내용       */

	
	@ApiModelProperty(notes= "신청부서코드")
	private String rqsOrzCd        ; /*신청조직코드     */
	@ApiModelProperty(notes= "신청부서명")
	private String rqsOrzNm        ; /*신청조직명       */	

	@ApiModelProperty(notes= "신청자사원번호")
	private String rqsEpno         ; /*신청사원번호     */
	@ApiModelProperty(notes= "신청자명")
	private String rqsEpNm         ; /*신청사원명       */

	@ApiModelProperty(notes= "신청일자")
	private String rqsDt           ; /*신청일자         */

	@ApiModelProperty(notes= "승인일자")
	private String aprvDt           ; /*승인일자         */	

	@ApiModelProperty(notes= "결재상신관리번호")
	private String aprvWrrptMtNo      ; /*결재상신관리번호 */
	@ApiModelProperty(notes= "결재상신조직코드")
	private String aprvWrrptOrzCd   ; /*결재상신조직코드*/
	@ApiModelProperty(notes= "결재순위")
	private String aprvRnk          ; /*결재순위*/
	@ApiModelProperty(notes= "결재상세순위")
	private String aprvDlRnk        ; /*결재상세순위*/
	
	
	@ApiModelProperty(notes= "순번", example="0")
	private BigDecimal rnum       ; /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수             */
	
	@ApiModelProperty(notes= "신청구분코드")
    private String unifRqsTcd        ; // 신청구분코드 
	@ApiModelProperty(notes= "신청구분코드명 ")
    private String unifRqsTcdNm      ; // 신청구분코드명
	
	public String getUnifRqsTcd() {
		return unifRqsTcd;
	}
	public void setUnifRqsTcd(String unifRqsTcd) {
		this.unifRqsTcd = unifRqsTcd;
	}
	public String getUnifRqsTcdNm() {
		return unifRqsTcdNm;
	}
	public void setUnifRqsTcdNm(String unifRqsTcdNm) {
		this.unifRqsTcdNm = unifRqsTcdNm;
	}
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
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
	public String getBizTcd() {
		return bizTcd;
	}
	public void setBizTcd(String bizTcd) {
		this.bizTcd = bizTcd;
	}
	public String getBizTcdNm() {
		return bizTcdNm;
	}
	public void setBizTcdNm(String bizTcdNm) {
		this.bizTcdNm = bizTcdNm;
	}
	public String getRqsTtlNm() {
		return rqsTtlNm;
	}
	public void setRqsTtlNm(String rqsTtlNm) {
		this.rqsTtlNm = rqsTtlNm;
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
	public String getRqsDt() {
		return rqsDt;
	}
	public void setRqsDt(String rqsDt) {
		this.rqsDt = rqsDt;
	}
	public String getAprvDt() {
		return aprvDt;
	}
	public void setAprvDt(String aprvDt) {
		this.aprvDt = aprvDt;
	}
	public BigDecimal getRnum() {
		return rnum;
	}
	public void setRnum(BigDecimal rnum) {
		this.rnum = rnum;
	}
	public BigDecimal getAlCnt() {
		return alCnt;
	}
	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}
	public String getAprvInfo() {
		return aprvInfo;
	}
	public void setAprvInfo(String aprvInfo) {
		this.aprvInfo = aprvInfo;
	}
	public String getAprvRtrnTcd() {
		return aprvRtrnTcd;
	}
	public void setAprvRtrnTcd(String aprvRtrnTcd) {
		this.aprvRtrnTcd = aprvRtrnTcd;
	}
	public String getRqsRsnCn() {
		return rqsRsnCn;
	}
	public void setRqsRsnCn(String rqsRsnCn) {
		this.rqsRsnCn = rqsRsnCn;
	}
	public String getAprvWrrptMtNo() { return aprvWrrptMtNo; }
	public void setAprvWrrptMtNo(String aprvWrrptMtNo) { this.aprvWrrptMtNo = aprvWrrptMtNo; }
	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}
	public void setAprvWrrptOrzCd(String aprvWrrptOrzCd) {
		this.aprvWrrptOrzCd = aprvWrrptOrzCd;
	}
	public String getAprvRnk() {
		return aprvRnk;
	}
	public void setAprvRnk(String aprvRnk) {
		this.aprvRnk = aprvRnk;
	}
	public String getAprvDlRnk() {
		return aprvDlRnk;
	}
	public void setAprvDlRnk(String aprvDlRnk) {
		this.aprvDlRnk = aprvDlRnk;
	}
	
	
	
}
