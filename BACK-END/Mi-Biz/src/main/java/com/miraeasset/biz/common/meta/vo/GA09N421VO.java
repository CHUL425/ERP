/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: BM
*	03. 파    일   명	: GA09N421VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA09N421 공지사항 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;


@Component
public class GA09N421VO extends BaseVO {

	@ApiModelProperty(notes= "작성일자")
	private String madeDt           ; /*작성일자            */
	@ApiModelProperty(notes= "일련번호")
	private BigDecimal srno             ; /*일련번호            */
	@ApiModelProperty(notes= "공지구분코드")
	private String cmklTcd          ; /*공지구분코드        */
	@ApiModelProperty(notes= "게시물고정여부")
	private String pstgFxdYn        ; /*게시물고정여부      */
	@ApiModelProperty(notes= "작성사원번호")
	private String madeEpno         ; /*작성사원번호        */
	@ApiModelProperty(notes= "제목명")
	private String ttlNm            ; /*제목명              */
	@ApiModelProperty(notes= "공지사항내용")
	private String cmklPtcrCn       ; /*공지사항내용        */
	@ApiModelProperty(notes= "게시시작일자")
	private String pstupStrtDt      ; /*게시시작일자        */
	@ApiModelProperty(notes= "게시종료일자")
	private String pstupEndDt       ; /*게시종료일자        */
	@ApiModelProperty(notes= "파일번호")
	private String fileNo           ; /*파일번호            */
	
	@ApiModelProperty(notes= "고객지원팀장알림여부")
	private String csSptTmlIprtYn  ;  /*고객지원팀장알림여부*/
	@ApiModelProperty(notes= "WM팀장알림여부")
	private String wmTmlIprtYn     ;  /*WM팀장알림여부      */
	@ApiModelProperty(notes= "지점장알림여부")
	private String brmgIprtYn      ;  /*지점장알림여부      */
	@ApiModelProperty(notes= "지점알림여부")
	private String brIprtYn        ;  /*지점알림여부        */
	@ApiModelProperty(notes= "팀장알림여부")
	private String tmlIprtYn       ;  /*팀장알림여부        */
	@ApiModelProperty(notes= "본부장알림여부")
	private String hqmgIprtYn      ;  /*본부장알림여부      */
	@ApiModelProperty(notes= "본사알림여부")
	private String hoIprtYn        ;  /*본사알림여부        */   
	
	@ApiModelProperty(notes= "조회건수")
	private BigDecimal qryCnt           ; /*조회건수            */
	@ApiModelProperty(notes= "삭제여부")
	private String delYn            ; /*삭제여부            */
	
	@ApiModelProperty(notes= "게시판이미지파일번호")
	private String blbdImgFileNo   ;
	
	public String getMadeDt() {
		return madeDt;
	}
	public void setMadeDt(String madeDt) {
		this.madeDt = madeDt;
	}
	public BigDecimal getSrno() {
		return srno;
	}
	public void setSrno(BigDecimal srno) {
		this.srno = srno;
	}
	public String getCmklTcd() {
		return cmklTcd;
	}
	public void setCmklTcd(String cmklTcd) {
		this.cmklTcd = cmklTcd;
	}
	public String getPstgFxdYn() {
		return pstgFxdYn;
	}
	public void setPstgFxdYn(String pstgFxdYn) {
		this.pstgFxdYn = pstgFxdYn;
	}
	public String getMadeEpno() {
		return madeEpno;
	}
	public void setMadeEpno(String madeEpno) {
		this.madeEpno = madeEpno;
	}
	public String getTtlNm() {
		return ttlNm;
	}
	public void setTtlNm(String ttlNm) {
		this.ttlNm = ttlNm;
	}
	public String getCmklPtcrCn() {
		return cmklPtcrCn;
	}
	public void setCmklPtcrCn(String cmklPtcrCn) {
		this.cmklPtcrCn = cmklPtcrCn;
	}
	public String getPstupStrtDt() {
		return pstupStrtDt;
	}
	public void setPstupStrtDt(String pstupStrtDt) {
		this.pstupStrtDt = pstupStrtDt;
	}
	public String getPstupEndDt() {
		return pstupEndDt;
	}
	public void setPstupEndDt(String pstupEndDt) {
		this.pstupEndDt = pstupEndDt;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getCsSptTmlIprtYn() {
		return csSptTmlIprtYn;
	}
	public void setCsSptTmlIprtYn(String csSptTmlIprtYn) {
		this.csSptTmlIprtYn = csSptTmlIprtYn;
	}
	public String getWmTmlIprtYn() {
		return wmTmlIprtYn;
	}
	public void setWmTmlIprtYn(String wmTmlIprtYn) {
		this.wmTmlIprtYn = wmTmlIprtYn;
	}
	public String getBrmgIprtYn() {
		return brmgIprtYn;
	}
	public void setBrmgIprtYn(String brmgIprtYn) {
		this.brmgIprtYn = brmgIprtYn;
	}
	public String getBrIprtYn() {
		return brIprtYn;
	}
	public void setBrIprtYn(String brIprtYn) {
		this.brIprtYn = brIprtYn;
	}
	public String getTmlIprtYn() {
		return tmlIprtYn;
	}
	public void setTmlIprtYn(String tmlIprtYn) {
		this.tmlIprtYn = tmlIprtYn;
	}
	public String getHqmgIprtYn() {
		return hqmgIprtYn;
	}
	public void setHqmgIprtYn(String hqmgIprtYn) {
		this.hqmgIprtYn = hqmgIprtYn;
	}
	public String getHoIprtYn() {
		return hoIprtYn;
	}
	public void setHoIprtYn(String hoIprtYn) {
		this.hoIprtYn = hoIprtYn;
	}
	public BigDecimal getQryCnt() {
		return qryCnt;
	}
	public void setQryCnt(BigDecimal qryCnt) {
		this.qryCnt = qryCnt;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getBlbdImgFileNo() {
		return blbdImgFileNo;
	}
	public void setBlbdImgFileNo(String blbdImgFileNo) {
		this.blbdImgFileNo = blbdImgFileNo;
	}
}
