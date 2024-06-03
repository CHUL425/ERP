package com.miraeasset.biz.rq.pr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQPR2000U0Out00VO {

	@ApiModelProperty(notes= "접수번호")
	private String rctNo           ; /*접수번호            */ 
	@ApiModelProperty(notes= "신청물품")
	private String atclNm           ;
	
	@ApiModelProperty(notes= "통합신청유형코드")
	private String unifRqsPcd           ;
	
	@ApiModelProperty(notes= "신청일자")
	private String rqsDt           ; /*신청일자            */ 
	@ApiModelProperty(notes= "신청조직코드")
	private String rqsOrzCd        ; /*신청조직코드        */ 
	@ApiModelProperty(notes= "신청조직명")
	private String rqsOrzNm        ; /*신청조직명        */ 
	@ApiModelProperty(notes= "완료일자")
	private String cmpnDt          ; /*완료일자            */ 
	@ApiModelProperty(notes= "신청상태코드")
	private String rqsScd          ; /*신청상태코드        */   
	@ApiModelProperty(notes= "신청상태명")
	private String rqsScdNm        ; /*신청상태명        */   
	@ApiModelProperty(notes= "신청사원번호")
	private String rqsEpno         ; /*신청사원번호        */
	@ApiModelProperty(notes= "신청사원명")
	private String rqsEpNm         ; /*신청사원명         */
	@ApiModelProperty(notes= "신청자휴대전화번호")
    private String rqsEpHndpTlno     ; /*신청자휴대전화번호 */
	
    @ApiModelProperty(notes = "입고조직코드")
	private String inqOrzCd;
    @ApiModelProperty(notes = "입고부서")
   	private String inqOrzNm;
	@ApiModelProperty(notes = "입고위치명")
	private String inqLocNm; 
	@ApiModelProperty(notes = "입고상세위치명")
	private String inqDlLocNm;
	
	@ApiModelProperty(notes= "결재상신관리번호")
    private String aprvWrrptMtNo;
	@ApiModelProperty(notes= "결재조직코드")
    private String aprvWrrptOrzCd;
	
	@ApiModelProperty(notes= "주문내역")
	List<RQPR2000U0Out01VO> gridGA03N102;

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

	public String getRqsEpHndpTlno() {
		return rqsEpHndpTlno;
	}

	public void setRqsEpHndpTlno(String rqsEpHndpTlno) {
		this.rqsEpHndpTlno = rqsEpHndpTlno;
	}

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public String getAtclNm() {
		return atclNm;
	}

	public void setAtclNm(String atclNm) {
		this.atclNm = atclNm;
	}

	public String getRqsDt() {
		return rqsDt;
	}

	public void setRqsDt(String rqsDt) {
		this.rqsDt = rqsDt;
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

	public String getCmpnDt() {
		return cmpnDt;
	}

	public void setCmpnDt(String cmpnDt) {
		this.cmpnDt = cmpnDt;
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

	public String getInqOrzCd() {
		return inqOrzCd;
	}

	public void setInqOrzCd(String inqOrzCd) {
		this.inqOrzCd = inqOrzCd;
	}

	public String getInqOrzNm() {
		return inqOrzNm;
	}

	public void setInqOrzNm(String inqOrzNm) {
		this.inqOrzNm = inqOrzNm;
	}

	public String getInqLocNm() {
		return inqLocNm;
	}

	public void setInqLocNm(String inqLocNm) {
		this.inqLocNm = inqLocNm;
	}

	public String getInqDlLocNm() {
		return inqDlLocNm;
	}

	public void setInqDlLocNm(String inqDlLocNm) {
		this.inqDlLocNm = inqDlLocNm;
	}

	public String getAprvWrrptMtNo() {
		return aprvWrrptMtNo;
	}

	public void setAprvWrrptMtNo(String aprvWrrptMtNo) {
		this.aprvWrrptMtNo = aprvWrrptMtNo;
	}

	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}

	public void setAprvWrrptOrzCd(String aprvWrrptOrzCd) {
		this.aprvWrrptOrzCd = aprvWrrptOrzCd;
	}

	public String getUnifRqsPcd() {
		return unifRqsPcd;
	}

	public void setUnifRqsPcd(String unifRqsPcd) {
		this.unifRqsPcd = unifRqsPcd;
	}

	public List<RQPR2000U0Out01VO> getGridGA03N102() {
		return gridGA03N102;
	}

	public void setGridGA03N102(List<RQPR2000U0Out01VO> gridGA03N102) {
		this.gridGA03N102 = gridGA03N102;
	}
	
}
