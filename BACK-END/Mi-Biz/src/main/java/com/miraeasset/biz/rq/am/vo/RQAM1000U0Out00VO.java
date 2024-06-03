package com.miraeasset.biz.rq.am.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQAM1000U0Out00VO {

	@ApiModelProperty(notes= "결재상신관리번호")
	private String aprvWrrptMtNo       ; /*결재상신관리번호 */
	@ApiModelProperty(notes= "결재상태코드")
	private String aprvScd           ; /*결재상태코드 */
	@ApiModelProperty(notes= "결재상태코드명")
	private String aprvScdNm           ; /*결재상태코드명 */
	
	@ApiModelProperty(notes= "접수번호")
	private String rctNo             ; /*접수번호*/
	@ApiModelProperty(notes= "결재유형코드")
	private String aprvPcd           ; /*결재유형코드 */
	@ApiModelProperty(notes= "결재유형코드명")
	private String aprvPcdNm         ; /*결재유형코드명 */
	
	@ApiModelProperty(notes= "업무구분코드")
	private String bizTcd            ; /*업무구분코드*/
	@ApiModelProperty(notes= "업무구분코드명")
	private String bizTcdNm          ; /*업무구분코드명*/
	@ApiModelProperty(notes= "신청제목명")
	private String rqsTtlNm          ; /*신청제목명*/
	@ApiModelProperty(notes= "신청명")
	private String rqsRsnCn          ; /*신청사유내용*/
	@ApiModelProperty(notes= "결재상신조직코드")
	private String aprvWrrptOrzCd    ; /*결재상신조직코드 */
	@ApiModelProperty(notes= "결재상신조직코드명")
	private String aprvWrrptOrzNm    ; /*결재상신조직코드명 */
	@ApiModelProperty(notes= "상신사원번호")
	private String wrrptEpno         ; /*상신사원번호 */
	
	@ApiModelProperty(notes= "상신사원명")
	private String wrrptEpNm         ; /*상신사원명 */
	@ApiModelProperty(notes= "상신일자")
	private String wrrptDt           ; /*상신일자*/

	@ApiModelProperty(notes= "결재순위")
	private String aprvRnk       ; /*결재순위 */
	@ApiModelProperty(notes= "결재상세순위")
	private String aprvDlRnk     ; /*결재상세순위 */
	
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
	public String getAprvWrrptMtNo() {
		return aprvWrrptMtNo;
	}
	public void setAprvWrrptMtNo(String aprvWrrptMtNo) {
		this.aprvWrrptMtNo = aprvWrrptMtNo;
	}
	public String getAprvScd() {
		return aprvScd;
	}
	public void setAprvScd(String aprvScd) {
		this.aprvScd = aprvScd;
	}
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	public String getAprvPcd() {
		return aprvPcd;
	}
	public void setAprvPcd(String aprvPcd) {
		this.aprvPcd = aprvPcd;
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
	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}
	public void setAprvWrrptOrzCd(String aprvWrrptOrzCd) {
		this.aprvWrrptOrzCd = aprvWrrptOrzCd;
	}
	public String getAprvWrrptOrzNm() {
		return aprvWrrptOrzNm;
	}
	public void setAprvWrrptOrzNm(String aprvWrrptOrzNm) {
		this.aprvWrrptOrzNm = aprvWrrptOrzNm;
	}
	public String getWrrptEpno() {
		return wrrptEpno;
	}
	public void setWrrptEpno(String wrrptEpno) {
		this.wrrptEpno = wrrptEpno;
	}
	public String getWrrptEpNm() {
		return wrrptEpNm;
	}
	public void setWrrptEpNm(String wrrptEpNm) {
		this.wrrptEpNm = wrrptEpNm;
	}
	public String getWrrptDt() {
		return wrrptDt;
	}
	public void setWrrptDt(String wrrptDt) {
		this.wrrptDt = wrrptDt;
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
	public String getAprvScdNm() {
		return aprvScdNm;
	}
	public void setAprvScdNm(String aprvScdNm) {
		this.aprvScdNm = aprvScdNm;
	}
	public String getAprvPcdNm() {
		return aprvPcdNm;
	}
	public void setAprvPcdNm(String aprvPcdNm) {
		this.aprvPcdNm = aprvPcdNm;
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
	public String getRqsRsnCn() {
		return rqsRsnCn;
	}
	public void setRqsRsnCn(String rqsRsnCn) {
		this.rqsRsnCn = rqsRsnCn;
	}
	
	
	
}
