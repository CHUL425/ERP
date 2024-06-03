package com.miraeasset.biz.rq.cr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.meta.vo.AprvWrrptInVO;
import com.miraeasset.biz.common.meta.vo.GA09N607aprvVO;
import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQCR1000UVO extends BaseVO {
	
	@ApiModelProperty(notes= "처리구분: 00-임시저장 01-상신 ", required = true,example = "00")
	private String prcTp           ; /*처리구분         */
	
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
	private long aprvWrrptMtNo   ; /* 결재상신관리번호 */
    @ApiModelProperty(notes= "결재상신조직코드")
    private String aprvWrrptOrzCd  ; /* 결재상신조직코드 */
    @ApiModelProperty(notes= "신청상태코드")
	private String rqsScd          ; /* 신청상태코드 */
    
    @ApiModelProperty(notes = "공사조직코드")
	private String pbcoOrzCd; /* 공사조직코드 */
	
	@ApiModelProperty(notes = "공사위치명")
	private String pbcoLocNm; /* 공사위치명 */
	
	@ApiModelProperty(notes = "공사상세위치명")
	private String pbcoDlLocNm; /* 공사상세위치명 */
	
	@ApiModelProperty(notes= "파일번호")
	private String fileNo     ; /*파일번호 2023.09.07  */ 
	
	/* 2023.09.12 결재선 리스트 */
	@ApiModelProperty(notes = "결재선리스트")
    List<AprvWrrptInVO> aprvl;
	
	public List<AprvWrrptInVO> getAprvl() {
		return aprvl;
	}
	public void setAprvl(List<AprvWrrptInVO> aprvl) {
		this.aprvl = aprvl;
	}
	
	public String getPrcTp() {
		return prcTp;
	}
	public void setPrcTp(String prcTp) {
		this.prcTp = prcTp;
	}
	
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
	public String getPbcoOrzCd() {
		return pbcoOrzCd;
	}
	public void setPbcoOrzCd(String pbcoOrzCd) {
		this.pbcoOrzCd = pbcoOrzCd;
	}
	public String getPbcoLocNm() {
		return pbcoLocNm;
	}
	public void setPbcoLocNm(String pbcoLocNm) {
		this.pbcoLocNm = pbcoLocNm;
	}
	public String getPbcoDlLocNm() {
		return pbcoDlLocNm;
	}
	public void setPbcoDlLocNm(String pbcoDlLocNm) {
		this.pbcoDlLocNm = pbcoDlLocNm;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
}
