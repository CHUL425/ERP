package com.miraeasset.biz.rq.nr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.meta.vo.AprvWrrptInVO;
import com.miraeasset.biz.common.meta.vo.GA03N102VO;
import com.miraeasset.biz.common.meta.vo.GA03N105VO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQNR1000U0In01VO {
	
	@ApiModelProperty(notes= "처리구분: 00-임시저장 01-상신 ", required = true,example = "00")
	private String prcTp; 
	@ApiModelProperty(notes= "접수번호")
	private String rctNo;
	@ApiModelProperty(notes= "신청유형코드 공사/구매/렌탈...")
    private String unifRqsPcd; 
	@ApiModelProperty(notes= "신청조직코드")
	private String rqsOrzCd;
	@ApiModelProperty(notes= "신청사원번호")
	private String rqsEpno; 
	@ApiModelProperty(notes= "신청제목명")
	private String rqsTtlNm; 
	
    @ApiModelProperty(notes = "입고조직코드")
	private String inqOrzCd;
	@ApiModelProperty(notes = "입고위치명")
	private String inqLocNm; 
	@ApiModelProperty(notes = "입고상세위치명")
	private String inqDlLocNm;
	
	@ApiModelProperty(notes= "명함신청_명함신청내역")
	List<GA03N102VO> gridGA03N102;
	@ApiModelProperty(notes= "명함신청_명함상세")
	List<GA03N105VO> gridGA03N105;
	@ApiModelProperty(notes = "결재선리스트")
    List<AprvWrrptInVO> aprvl;
	public String getPrcTp() {
		return prcTp;
	}
	public void setPrcTp(String prcTp) {
		this.prcTp = prcTp;
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
	public String getInqOrzCd() {
		return inqOrzCd;
	}
	public void setInqOrzCd(String inqOrzCd) {
		this.inqOrzCd = inqOrzCd;
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
	public List<GA03N102VO> getGridGA03N102() {
		return gridGA03N102;
	}
	public void setGridGA03N102(List<GA03N102VO> gridGA03N102) {
		this.gridGA03N102 = gridGA03N102;
	}
	public List<GA03N105VO> getGridGA03N105() {
		return gridGA03N105;
	}
	public void setGridGA03N105(List<GA03N105VO> gridGA03N105) {
		this.gridGA03N105 = gridGA03N105;
	}
	public List<AprvWrrptInVO> getAprvl() {
		return aprvl;
	}
	public void setAprvl(List<AprvWrrptInVO> aprvl) {
		this.aprvl = aprvl;
	}
}
