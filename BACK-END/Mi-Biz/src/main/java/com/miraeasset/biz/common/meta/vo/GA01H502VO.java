/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA01N501VO.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인장조제관리 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;


@Component
public class GA01H502VO extends BaseVO {

	@ApiModelProperty(notes= "인장관리번호")
	private String salMtNo        ; /*인장관리번호  */ 
	@ApiModelProperty(notes= "본지점구분코드")
	private String hobrTcd        ; /*본지점구분코드*/ 
	@ApiModelProperty(notes= "본지점구분코드명")
	private String hobrTcdNm      ; /*본지점구분코드명*/
	@ApiModelProperty(notes= "인장구분코드")
	private String salTcd         ; /*인장구분코드  */ 
	@ApiModelProperty(notes= "인장구분코드명")
	private String salTcdNm       ; /*인장구분코드명*/ 
	@ApiModelProperty(notes= "인장유형코드")
	private String salPcd         ; /*인장유형코드  */ 
	@ApiModelProperty(notes= "인장유형코드명")
	private String salPcdNm       ; /*인장유형코드명*/ 
	@ApiModelProperty(notes= "인장명")
	private String salNm          ; /*인장명        */ 
	@ApiModelProperty(notes= "인장상세명")
	private String salDlNm        ; /*인장상세명    */ 
	@ApiModelProperty(notes= "파일번호")
	private String fileNo         ; /*파일번호      */ 
	@ApiModelProperty(notes= "관리조직코드")
	private String mtOrzCd        ; /*관리조직코드  */ 
	@ApiModelProperty(notes= "관리조직명")
	private String mtOrzNm        ; /*관리조직명  */   
	@ApiModelProperty(notes= "관리사원번호")
	private String mtEpno         ; /*관리사원번호  */ 
	@ApiModelProperty(notes= "관리사원명")
	private String mtEpNm         ; /*관리사원명  */   
	@ApiModelProperty(notes= "제작일자")
	private String makgDt         ; /*제작일자      */ 
	@ApiModelProperty(notes= "제작사유내용")
	private String salMakgRsnCn      ; /*제작사유내용  */ 
	@ApiModelProperty(notes= "회수일자")
	private String wtdwDt         ; /*회수일자      */ 
	@ApiModelProperty(notes= "회수사유내용")
	private String salWtdwRsnCn      ; /*회수사유내용  */ 

	@ApiModelProperty(notes= "폐기일자")
	private String dsusDt         ; /*폐기일자      */ 
	@ApiModelProperty(notes= "변경일자")
	private String chngDt         ; /*변경일자      */ 
	@ApiModelProperty(notes= "변경사유내용")
	private String salChngRsnCn      ; /*변경사유내용  */ 
	@ApiModelProperty(notes= "인감상태코드")
	private String sealScd        ; /*인감상태코드  */ 
	@ApiModelProperty(notes= "인감상태코드명")
	private String sealScdNm      ; /*인감상태코드명 */
	
	@ApiModelProperty(notes= "접수번호", hidden = true)
	private String rctNo             ; /*접수번호*/
	@ApiModelProperty(notes= "인장메모내용")
	private String salMemoCn      ; /*인장메모내용 */
	
	@ApiModelProperty(notes= "이력순번")
	private Long hstSeq      ; /*이력순번 */
	
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
	public String getHobrTcdNm() {
		return hobrTcdNm;
	}
	public void setHobrTcdNm(String hobrTcdNm) {
		this.hobrTcdNm = hobrTcdNm;
	}
	public String getSalTcd() {
		return salTcd;
	}
	public void setSalTcd(String salTcd) {
		this.salTcd = salTcd;
	}
	public String getSalTcdNm() {
		return salTcdNm;
	}
	public void setSalTcdNm(String salTcdNm) {
		this.salTcdNm = salTcdNm;
	}
	public String getSalPcd() {
		return salPcd;
	}
	public void setSalPcd(String salPcd) {
		this.salPcd = salPcd;
	}
	public String getSalPcdNm() {
		return salPcdNm;
	}
	public void setSalPcdNm(String salPcdNm) {
		this.salPcdNm = salPcdNm;
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
	public String getMtOrzNm() {
		return mtOrzNm;
	}
	public void setMtOrzNm(String mtOrzNm) {
		this.mtOrzNm = mtOrzNm;
	}
	public String getMtEpno() {
		return mtEpno;
	}
	public void setMtEpno(String mtEpno) {
		this.mtEpno = mtEpno;
	}
	public String getMtEpNm() {
		return mtEpNm;
	}
	public void setMtEpNm(String mtEpNm) {
		this.mtEpNm = mtEpNm;
	}
	public String getMakgDt() {
		return makgDt;
	}
	public void setMakgDt(String makgDt) {
		this.makgDt = makgDt;
	}
	public String getWtdwDt() {
		return wtdwDt;
	}
	public void setWtdwDt(String wtdwDt) {
		this.wtdwDt = wtdwDt;
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
	public String getSealScd() {
		return sealScd;
	}
	public void setSealScd(String sealScd) {
		this.sealScd = sealScd;
	}
	public String getSealScdNm() {
		return sealScdNm;
	}
	public void setSealScdNm(String sealScdNm) {
		this.sealScdNm = sealScdNm;
	}
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public String getSalMakgRsnCn() {
		return salMakgRsnCn;
	}
	public void setSalMakgRsnCn(String salMakgRsnCn) {
		this.salMakgRsnCn = salMakgRsnCn;
	}
	public String getSalWtdwRsnCn() {
		return salWtdwRsnCn;
	}
	public void setSalWtdwRsnCn(String salWtdwRsnCn) {
		this.salWtdwRsnCn = salWtdwRsnCn;
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
	public Long getHstSeq() {
		return hstSeq;
	}
	public void setHstSeq(Long hstSeq) {
		this.hstSeq = hstSeq;
	}
	
}
