/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GASR1000U0In02VO.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인장조제관리 수정 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.sr.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GASR1000U0In02VO {
	@ApiModelProperty(notes= "거래구분코드 C:내용수정(접수단계) W:회수 D:폐기 CNCL:담당자취소, CHNG:내용변경(신청후)", required = true)
	private String  trTcd       ; /*거래구분코드 C:변경 W:회수  D:폐기 */ 	
	
	@ApiModelProperty(notes= "인장관리번호", required = true)
	private String salMtNo        ; /*인장관리번호  */ 
	@ApiModelProperty(notes= "본지점구분코드")
	private String hobrTcd        ; /*본지점구분코드*/ 
	@ApiModelProperty(notes= "인장구분코드-접수시 필수")
	private String salTcd         ; /*인장구분코드  */ 
	@ApiModelProperty(notes= "인장유형코드")
    private String salPcd        ; /*인장유형코드    */
	@ApiModelProperty(notes= "인장명")
	private String salNm          ; /*인장명        */ 
	@ApiModelProperty(notes= "인장상세명")
	private String salDlNm        ; /*인장상세명    */ 
	@ApiModelProperty(notes= "파일번호")
	private String fileNo         ; /*파일번호      */ 
	@ApiModelProperty(notes= "관리조직코드")
	private String mtOrzCd        ; /*관리조직코드  */ 
	@ApiModelProperty(notes= "관리사원번호")
	private String mtEpno         ; /*관리사원번호  */ 
	@ApiModelProperty(notes= "인장메모내용")
	private String salMemoCn         ; /*인장메모내용*/
	
	@ApiModelProperty(notes= "제작일자-신청시 필수")
	private String makgDt         ; /*제작일자      */ 
	@ApiModelProperty(notes= "제작사유내용-신청시 필수")
	private String salMakgRsnCn      ; /*제작사유내용  */ 
	
	@ApiModelProperty(notes= "회수일자 - 거래구분 W:회수시 세팅")
	private String wtdwDt         ; /*회수일자      */ 
	@ApiModelProperty(notes= "회수사유내용 - 거래구분 W:회수시 세팅")
	private String salWtdwRsnCn   ; /*회수사유내용  */ 
	
	@ApiModelProperty(notes= "폐기일자 - 거래구분 D:폐기시 세팅")
	private String dsusDt         ; /*폐기일자      */ 
	
	@ApiModelProperty(notes= "변경일자 - 거래구분 C:내용시 세팅")
	private String chngDt         ; /*변경일자      */ 
	@ApiModelProperty(notes= "인장변경사유내용 - 거래구분 C:변경시 세팅")
	private String salChngRsnCn      ; /*인장변경사유내용  */
	
	@ApiModelProperty(notes= "신청조직코드 - 로그인정보")
	private String rqsOrzCd        ; /*신청조직코드     */
	@ApiModelProperty(notes= "신청사원번호 - 로그인정보")
	private String rqsEpno         ; /*신청사원번호     */
	
	@ApiModelProperty(notes= "협조문서")
	private String rctDrftDocNo         ; /*협조문서*/
	@ApiModelProperty(notes= "조제기안문서")
	private String regDrftDocNo         ; /*조제기안문서*/
	@ApiModelProperty(notes= "회수기안문서")
	private String wtdwDrftDocNo         ; /*회수기안문서*/
	@ApiModelProperty(notes= "폐기기안문서")
	private String dsusDrftDocNo         ; /*폐기기안문서*/
	
	@ApiModelProperty(notes= "접수번호")
	private String rctNo        ; /*접수번호*/ 
	
	public String getTrTcd() {
		return trTcd;
	}
	public void setTrTcd(String trTcd) {
		this.trTcd = trTcd;
	}
	public String getSalMtNo() {
		return salMtNo;
	}
	public void setSalMtNo(String salMtNo) {
		this.salMtNo = salMtNo;
	}
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
	public String getMtEpno() {
		return mtEpno;
	}
	public void setMtEpno(String mtEpno) {
		this.mtEpno = mtEpno;
	}
	public String getWtdwDt() {
		return wtdwDt;
	}
	public void setWtdwDt(String wtdwDt) {
		this.wtdwDt = wtdwDt;
	}

	public String getSalWtdwRsnCn() {
		return salWtdwRsnCn;
	}
	public void setSalWtdwRsnCn(String salWtdwRsnCn) {
		this.salWtdwRsnCn = salWtdwRsnCn;
	}
	public String getDsusDt() {
		return dsusDt;
	}
	public void setDsusDt(String dsusDt) {
		this.dsusDt = dsusDt;
	}
	public String getChngDt() {
		return chngDt;
	}
	public void setChngDt(String chngDt) {
		this.chngDt = chngDt;
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
	public String getSalChngRsnCn() {
		return salChngRsnCn;
	}
	public void setSalChngRsnCn(String salChngRsnCn) {
		this.salChngRsnCn = salChngRsnCn;
	}
	public String getSalMemoCn() {
		return salMemoCn;
	}
	public void setSalMemoCn(String salMemoCn) {
		this.salMemoCn = salMemoCn;
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
	public String getWtdwDrftDocNo() {
		return wtdwDrftDocNo;
	}
	public void setWtdwDrftDocNo(String wtdwDrftDocNo) {
		this.wtdwDrftDocNo = wtdwDrftDocNo;
	}
	public String getDsusDrftDocNo() {
		return dsusDrftDocNo;
	}
	public void setDsusDrftDocNo(String dsusDrftDocNo) {
		this.dsusDrftDocNo = dsusDrftDocNo;
	}
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
}

    
