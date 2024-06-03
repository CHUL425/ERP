package com.miraeasset.biz.rq.cr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.dao.ExcelColumnStyle;
import com.miraeasset.biz.common.meta.vo.GA09N411VO;
import com.miraeasset.biz.common.util.excel.style.DefaultExcelCellStyle;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQCR1000U0Out02VO {
	
	@ApiModelProperty(notes= "접수번호")
	private String rctNo           ; /*접수번호 */
	@ApiModelProperty(notes= "신청상태코드")
	private String rqsScd          ; /* 신청상태코드 */
	@ApiModelProperty(notes= "신청상태코드명")
	private String rqsScdNm        ; /* 신청상태코드명 */
	
	@ApiModelProperty(notes= "신청유형코드 공사/구매/렌탈...")
	private String unifRqsPcd          ; /* 신청유형코드    */
	@ApiModelProperty(notes= "신청유형코드명")
	private String unifRqsPcdNm        ; /* 신청유형코드명    */
	
	@ApiModelProperty(notes= "구분코드")
	private String unifRqsDlPcd		   ; /* 신청상세유형코드 */
	@ApiModelProperty(notes= "구분명")
	private String unifRqsDlPcdNm	   ; /* 신청상세유형코드명 */	
	
	@ApiModelProperty(notes= "유형코드 ")
	private String unifRqsTcd          ; /* 신청구분코드 */	
	@ApiModelProperty(notes= "유형코드명 신규/AS/철거/기타")
	private String unifRqsTcdNm        ; /* 신청구분코드명 */
	
	@ApiModelProperty(notes= "신청제목명")
	private String rqsTtlNm        ; /* 신청제목명 */
    @ApiModelProperty(notes= "공사위치명")
    private String pbcoLocNm       ; /* 공사위치명 */
    @ApiModelProperty(notes= "공사위치상세명")
    private String pbcoDlLocNm     ; /* 공사위치상세명 */
    
    @ApiModelProperty(notes= "공사조직코드")
    private String pbcoOrzCd	   ; /* 공사조직코드 */
    
    @ApiModelProperty(notes= "공사조직이름")
    private String pbcoOrzCdNm	   ; /* 공사조직이름 */  
    
    @ApiModelProperty(notes= "신청사유내용")
	private String rqsRsnCn        ; /* 신청사유내용 */
    
    @ApiModelProperty(notes= "파일번호")
    private String fileNo		   ; /* 파일번호 2023.09.11 */
    
    @ApiModelProperty(notes= "희망일자")
	private String hopeDt          ; /* 희망일자 */
    @ApiModelProperty(notes= "신청조직코드")
	private String rqsOrzCd        ; /* 신청조직코드 */
	@ApiModelProperty(notes= "신청조직명")
	private String rqsOrzNm        ; /* 신청조직명 */
	
	@ApiModelProperty(notes= "신청사원번호")
	private String rqsEpno         ; /* 신청사원번호 */
	@ApiModelProperty(notes= "신청사원명")
	private String rqsEpNm         ; /* 신청사원명 */
    @ApiModelProperty(notes= "신청사원휴대전화번호")
    private String rqsEpHndpTlno   ; /* 신청사원휴대전화번호 */
    
    @ApiModelProperty(notes= "신청일자")
	private String rqsDt           ; /* 신청일자 */
    @ApiModelProperty(notes= "완료일자")
    private String cmpnDt          ; /* 완료일자 */
    
    @ApiModelProperty(notes= "결재상신관리번호")
    private String aprvWrrptMtNo   ; /*결재상신관리번호    */
    @ApiModelProperty(notes= "결재상신조직코드")
    private String aprvWrrptOrzCd  ; /* 결재상신조직코드 */
    
    List<GA09N411VO> fileList;    /* 첨부파일 다건내역 */
    
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
	public String getRqsTtlNm() {
		return rqsTtlNm;
	}
	public void setRqsTtlNm(String rqsTtlNm) {
		this.rqsTtlNm = rqsTtlNm;
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
	public String getRqsRsnCn() {
		return rqsRsnCn;
	}
	public void setRqsRsnCn(String rqsRsnCn) {
		this.rqsRsnCn = rqsRsnCn;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getHopeDt() {
		return hopeDt;
	}
	public void setHopeDt(String hopeDt) {
		this.hopeDt = hopeDt;
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
	public String getRqsEpHndpTlno() {
		return rqsEpHndpTlno;
	}
	public void setRqsEpHndpTlno(String rqsEpHndpTlno) {
		this.rqsEpHndpTlno = rqsEpHndpTlno;
	}
	public String getRqsDt() {
		return rqsDt;
	}
	public void setRqsDt(String rqsDt) {
		this.rqsDt = rqsDt;
	}
	public String getCmpnDt() {
		return cmpnDt;
	}
	public void setCmpnDt(String cmpnDt) {
		this.cmpnDt = cmpnDt;
	}
	
	public List<GA09N411VO> getFileList() {
		return fileList;
	}
	public void setFileList(List<GA09N411VO> fileList) {
		this.fileList = fileList;
	}
	
	/* 2023.10.17 추가 */
	public String getPbcoOrzCd() {
		return pbcoOrzCd;
	}
	public void setPbcoOrzCd(String pbcoOrzCd) {
		this.pbcoOrzCd = pbcoOrzCd;
	}
	public String getPbcoOrzCdNm() {
		return pbcoOrzCdNm;
	}
	public void setPbcoOrzCdNm(String pbcoOrzCdNm) {
		this.pbcoOrzCdNm = pbcoOrzCdNm;
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
	public String getUnifRqsPcdNm() {
		return unifRqsPcdNm;
	}
	public void setUnifRqsPcdNm(String unifRqsPcdNm) {
		this.unifRqsPcdNm = unifRqsPcdNm;
	}
	public String getUnifRqsDlPcd() {
		return unifRqsDlPcd;
	}
	public void setUnifRqsDlPcd(String unifRqsDlPcd) {
		this.unifRqsDlPcd = unifRqsDlPcd;
	}
	public String getUnifRqsDlPcdNm() {
		return unifRqsDlPcdNm;
	}
	public void setUnifRqsDlPcdNm(String unifRqsDlPcdNm) {
		this.unifRqsDlPcdNm = unifRqsDlPcdNm;
	}
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
}
