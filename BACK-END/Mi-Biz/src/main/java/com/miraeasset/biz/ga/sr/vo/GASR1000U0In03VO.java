/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GASR1000U0In03VO.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인장조제관리 접수/신청 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.sr.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GASR1000U0In03VO extends BaseVO {

	@ApiModelProperty(notes= "본지점구분코드-접수시 필수")
	private String hobrTcd        ; /*본지점구분코드*/ 
	@ApiModelProperty(notes= "인장구분코드-접수시 필수")
	private String salTcd         ; /*인장구분코드  */ 
	@ApiModelProperty(notes= "인장유형코드-접수시 필수")
	private String salPcd         ; /*인장유형코드  */ 
	@ApiModelProperty(notes= "관리조직코드-접수시 필수")
	private String mtOrzCd        ; /*관리조직코드  */
	@ApiModelProperty(notes= "파일번호-접수시 필수")
	private String fileNo         ; /*파일번호      */	
	@ApiModelProperty(notes= "접수일자-접수시 필수")
	private String rctDt         ; /*제작일자      */ 
	
	@ApiModelProperty(notes= "인장명-신청시 필수")
	private String salNm          ; /*인장명        */ 
	@ApiModelProperty(notes= "인장상세명-신청시 필수")
	private String salDlNm        ; /*인장상세명    */ 
	@ApiModelProperty(notes= "제작일자-신청시 필수")
	private String makgDt         ; /*제작일자      */ 
	@ApiModelProperty(notes= "제작사유내용-신청시 필수")
	private String salMakgRsnCn      ; /*제작사유내용  */ 
	
	@ApiModelProperty(notes= "신청조직코드 - 로그인정보")
	private String rqsOrzCd        ; /*신청조직코드     */
	@ApiModelProperty(notes= "신청사원번호 - 로그인정보")
	private String rqsEpno         ; /*신청사원번호     */
	
	@ApiModelProperty(notes= "인영번호")
	private String salMtNo         ; /*인영번호     */
	@ApiModelProperty(notes= "인장메모내용")
	private String salMemoCn         ; /*인장메모내용*/
	
	@ApiModelProperty(notes= "협조문서")
	private String rctDrftDocNo         ; /*협조문서*/
	@ApiModelProperty(notes= "조제기안문")
	private String regDrftDocNo         ; /*조제기안문*/
	
	public String getHobrTcd() {
		return hobrTcd;
	}
	public void setHobrTcd(String hobrTcd) {
		this.hobrTcd = hobrTcd;
	}
	public String getSalTcd() {
		return salTcd;
	}
	public void setSalTcd(String salTcd) {
		this.salTcd = salTcd;
	}
	public String getSalPcd() {
		return salPcd;
	}
	public void setSalPcd(String salPcd) {
		this.salPcd = salPcd;
	}
	public String getSalNm() {
		return salNm;
	}
	public void setSalNm(String salNm) {
		this.salNm = salNm;
	}
	public String getSalDlNm() {
		return salDlNm;
	}
	public void setSalDlNm(String salDlNm) {
		this.salDlNm = salDlNm;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getMtOrzCd() {
		return mtOrzCd;
	}
	public void setMtOrzCd(String mtOrzCd) {
		this.mtOrzCd = mtOrzCd;
	}
	public String getMakgDt() {
		return makgDt;
	}
	public void setMakgDt(String makgDt) {
		this.makgDt = makgDt;
	}
	
	public String getSalMakgRsnCn() {
		return salMakgRsnCn;
	}
	public void setSalMakgRsnCn(String salMakgRsnCn) {
		this.salMakgRsnCn = salMakgRsnCn;
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
	public String getSalMtNo() {
		return salMtNo;
	}
	public void setSalMtNo(String salMtNo) {
		this.salMtNo = salMtNo;
	}
	public String getSalMemoCn() {
		return salMemoCn;
	}
	public void setSalMemoCn(String salMemoCn) {
		this.salMemoCn = salMemoCn;
	}
	public String getRctDrftDocNo() {
		return rctDrftDocNo;
	}
	public void setRctDrftDocNo(String rctDrftDocNo) {
		this.rctDrftDocNo = rctDrftDocNo;
	}
	public String getRegDrftDocNo() {
		return regDrftDocNo;
	}
	public void setRegDrftDocNo(String regDrftDocNo) {
		this.regDrftDocNo = regDrftDocNo;
	}
	public String getRctDt() {
		return rctDt;
	}
	public void setRctDt(String rctDt) {
		this.rctDt = rctDt;
	}
}

    
