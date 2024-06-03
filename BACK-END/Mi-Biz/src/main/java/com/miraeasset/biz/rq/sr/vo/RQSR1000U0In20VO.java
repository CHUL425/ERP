/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0In20VO.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인감날인증명서신청 승인완료 내역조회 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0In20VO {
	
	@ApiModelProperty(notes= "조회시작일자")
	private String qryStrtDt          ; /* 조회시작일자     */
	@ApiModelProperty(notes= "조회종료일자")
	private String qryEndDt           ; /* 조회종료일자     */
	@ApiModelProperty(notes= "구분", example=" 공백값:전체, 01:승인/협조, 09:사전참조 ")
	private String dcfcPcd           ; /* 조회종료일자     */
	@ApiModelProperty(notes= "신청조직코드")
	private String rqsOrzCd           ; /* 신청조직코드     */
    @ApiModelProperty(notes= "신청제목명")
    private String rqsTtlNm           ; /*신청제목명      */
    @ApiModelProperty(notes= "구분")
    private String unifRqsDlPcd; 
    
	@ApiModelProperty(notes= "신청상태코드(버튼식 멀티 선택가능)")
	private String rqsScd             ; /* 신청상태코드     */
	
	@ApiModelProperty(notes= "총건수")
	private long totCnt ;

    @ApiModelProperty(hidden=true)
    private List<String> arrRqsScd; /* 신청상태코드_배열 */
    @ApiModelProperty(hidden=true)
    private String aprvEpno           ; /*로그인사번      */



	@ApiModelProperty(notes= "페이지번호")
	private long pageNum ; /* 페이지번호 */

	@ApiModelProperty(notes= "페이징크기")
	private long pageSize ; /* 페이징크기 */


	@ApiModelProperty(notes= "모바일 조회 타입")
	private String mobSelTyp;

	@ApiModelProperty(notes= "모바일 조회 텍스트")
	private String mobSelTxt;


	public String getMobSelTyp() { return mobSelTyp; } public void setMobSelTyp(String mobSelTyp) { this.mobSelTyp = mobSelTyp; }
	public String getMobSelTxt() { return mobSelTxt; } public void setMobSelTxt(String mobSelTxt) { this.mobSelTxt = mobSelTxt; }

	public long getPageNum() {return pageNum;}public void setPageNum(long pageNum) {this.pageNum = pageNum;}
	public long getPageSize() {return pageSize;}public void setPageSize(long pageSize) {this.pageSize = pageSize;}


	public String getRqsScd() {
		return rqsScd;
	}
	public void setRqsScd(String rqsScd) {
		this.rqsScd = rqsScd;
	}
	public String getRqsOrzCd() {
		return rqsOrzCd;
	}
	public void setRqsOrzCd(String rqsOrzCd) {
		this.rqsOrzCd = rqsOrzCd;
	}
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
	public String getRqsTtlNm() {
		return rqsTtlNm;
	}
	public void setRqsTtlNm(String rqsTtlNm) {
		this.rqsTtlNm = rqsTtlNm;
	}
	public List<String> getArrRqsScd() {
		return arrRqsScd;
	}
	public void setArrRqsScd(List<String> arrRqsScd) {
		this.arrRqsScd = arrRqsScd;
	}
	public String getAprvEpno() {
		return aprvEpno;
	}
	public void setAprvEpno(String aprvEpno) {
		this.aprvEpno = aprvEpno;
	}
	public String getDcfcPcd() {
		return dcfcPcd;
	}
	public void setDcfcPcd(String dcfcPcd) {
		this.dcfcPcd = dcfcPcd;
	}
	public long getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(long totCnt) {
		this.totCnt = totCnt;
	}
	public String getUnifRqsDlPcd() {
		return unifRqsDlPcd;
	}
	public void setUnifRqsDlPcd(String unifRqsDlPcd) {
		this.unifRqsDlPcd = unifRqsDlPcd;
	}
}

    
