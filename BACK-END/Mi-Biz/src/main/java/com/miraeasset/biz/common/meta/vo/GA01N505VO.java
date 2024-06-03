/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: BM
*	03. 파    일   명	: GA01N505VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA01N505 인장신청_인감증명서신청 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;


@Component
public class GA01N505VO extends BaseVO {
	
	@ApiModelProperty(notes= "인감증명서신청시퀀스번호 ")
	private String sealCtfwRqsSqncNo ; /*인감증명서신청시퀀스번호     */
	@ApiModelProperty(notes= "접수번호")
	private String rctNo      ; /*접수번호    */
	@ApiModelProperty(notes= "접수상세번호")
	private String rctDlNo    ; /*접수상세번호*/
	@ApiModelProperty(notes= "제출처내용")
	private String smitpCn    ; /*제출처내용  */
	@ApiModelProperty(notes= "제출용도내용")
	private String smitUsgeCn ; /*제출용도내용*/
	@ApiModelProperty(notes= "인장관리번호")
	private String salMtNo    ; /*인장관리번호*/
	@ApiModelProperty(notes= "폐기일자") 
	private String dsusDt     ; /*폐기일자    */
	
	@ApiModelProperty(notes= "인감증명서구분코드") 
	private String sealCtfwTcd     ;
	@ApiModelProperty(notes= "신청수량") 
	private BigDecimal rqsQ        ; 
	@ApiModelProperty(notes= "인감증명서부수", example="0")
	private BigDecimal sealDocCnt  ;
	@ApiModelProperty(notes= "등기부등본부수", example="0")
	private BigDecimal certDocCnt  ; 
	
	@ApiModelProperty(notes= "인영명")
	private String salMtNm    ; /*인영명*/
	
//	@ApiModelProperty(notes= "신청수량1", example="0")
//	private BigDecimal rqsQ1  ; /*신청수량1   */
//	@ApiModelProperty(notes= "신청수량2", example="0")
//	private BigDecimal rqsQ2  ; /*신청수량2   */
//	@ApiModelProperty(notes= "인감관리명")
//	private String salMtNm          ;  /*인감관리명*/
//	@ApiModelProperty(notes= "사용기간")
//	private String useTerm     ; /*사용기간    */

	/* 내부 변수 세팅 */
	private BigDecimal lastNo1     ; /*죄종출고출력물번호1(인감증명서) 순환   */
	private BigDecimal lastNo2     ; /*죄종출고출력물번호2(등기부등본) 순환   */
	
	private BigDecimal rlLastNo1   ; /*죄종출고출력물번호1(인감증명서) 100이상   */
	private BigDecimal rlLastNo2   ; /*죄종출고출력물번호2(등기부등본) 100이상   */

	
	public String getSealCtfwRqsSqncNo() {
		return sealCtfwRqsSqncNo;
	}
	public void setSealCtfwRqsSqncNo(String sealCtfwRqsSqncNo) {
		this.sealCtfwRqsSqncNo = sealCtfwRqsSqncNo;
	}
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	public String getRctDlNo() {
		return rctDlNo;
	}
	public void setRctDlNo(String rctDlNo) {
		this.rctDlNo = rctDlNo;
	}
	public String getSmitpCn() {
		return smitpCn;
	}
	public void setSmitpCn(String smitpCn) {
		this.smitpCn = smitpCn;
	}
	public String getSmitUsgeCn() {
		return smitUsgeCn;
	}
	public void setSmitUsgeCn(String smitUsgeCn) {
		this.smitUsgeCn = smitUsgeCn;
	}
	public String getSalMtNo() {
		return salMtNo;
	}
	public void setSalMtNo(String salMtNo) {
		this.salMtNo = salMtNo;
	}
	public String getDsusDt() {
		return dsusDt;
	}
	public void setDsusDt(String dsusDt) {
		this.dsusDt = dsusDt;
	}
	public BigDecimal getLastNo2() {
		return lastNo2;
	}
	public void setLastNo2(BigDecimal lastNo2) {
		this.lastNo2 = lastNo2;
	}
	public BigDecimal getLastNo1() {
		return lastNo1;
	}
	public void setLastNo1(BigDecimal lastNo1) {
		this.lastNo1 = lastNo1;
	}
	public BigDecimal getRlLastNo1() {
		return rlLastNo1;
	}
	public void setRlLastNo1(BigDecimal rlLastNo1) {
		this.rlLastNo1 = rlLastNo1;
	}
	public BigDecimal getRlLastNo2() {
		return rlLastNo2;
	}
	public void setRlLastNo2(BigDecimal rlLastNo2) {
		this.rlLastNo2 = rlLastNo2;
	}
	public BigDecimal getSealDocCnt() {
		return sealDocCnt;
	}
	public void setSealDocCnt(BigDecimal sealDocCnt) {
		this.sealDocCnt = sealDocCnt;
	}
	public BigDecimal getCertDocCnt() {
		return certDocCnt;
	}
	public void setCertDocCnt(BigDecimal certDocCnt) {
		this.certDocCnt = certDocCnt;
	}
	public String getSealCtfwTcd() {
		return sealCtfwTcd;
	}
	public void setSealCtfwTcd(String sealCtfwTcd) {
		this.sealCtfwTcd = sealCtfwTcd;
	}
	public BigDecimal getRqsQ() {
		return rqsQ;
	}
	public void setRqsQ(BigDecimal rqsQ) {
		this.rqsQ = rqsQ;
	}
	public String getSalMtNm() {
		return salMtNm;
	}
	public void setSalMtNm(String salMtNm) {
		this.salMtNm = salMtNm;
	}
	
}
