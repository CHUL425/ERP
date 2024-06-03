/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0Out01VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인감날인신청 상세조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.meta.vo.GA01N109VO;
import com.miraeasset.biz.common.meta.vo.GA01N504VO;
import com.miraeasset.biz.common.meta.vo.GA01N505VO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0Out01VO {

	@ApiModelProperty(notes= "신청사원번호")
	private String rqsEpno         ; /*신청사원번호        */
	@ApiModelProperty(notes= "신청사원명")
	private String rqsEpNm         ; /*신청사원명         */
	@ApiModelProperty(notes= "신청사원 직위명")
	private String hrPstNm         ; /*직위명*/   	
	@ApiModelProperty(notes= "접수번호")
	private String rctNo           ; /*접수번호            */ 
	@ApiModelProperty(notes= "신청제목명")
	private String rqsTtlNm        ; /*신청제목명          */    
	@ApiModelProperty(notes= "통합신청상세유형코드")
	private String unifRqsDlPcd    ; /*통합신청상세유형코드     */       
	@ApiModelProperty(notes= "통합신청상세유형명")
	private String unifRqsDlPcdNm    ; /*통합신청상세유형명     */       
	@ApiModelProperty(notes= "통합신청구분코드")
	private String unifRqsTcd      ; /*통합신청구분코드 */       
	@ApiModelProperty(notes= "통합신청구분명")
	private String unifRqsTcdNm      ; /*통합신청구분명 */       

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
	
	@ApiModelProperty(notes= "결재상신관리번호")
    private String aprvWrrptMtNo   ; /*결재상신관리번호  */
    @ApiModelProperty(notes= "모바일용-사유")
    private String aprvRsnCn;
    
	@ApiModelProperty(notes= "인장신청_인감날인신청 다건내역")
	List<GA01N504VO> gridGA01N504;    /* 인장신청_인감날인신청 다건내역 */
	@ApiModelProperty(notes= "인장신청_인감증명서신청 다건내역")
	List<GA01N505VO> gridGA01N505;    /* 인장신청_인감증명서신청 다건내역 */
	@ApiModelProperty(notes= "기안문서 다건내역")
	List<GA01N109VO> gridGA01N109;    /* 기안문서 다건내역  */
	
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
	public String getHrPstNm() {
		return hrPstNm;
	}
	public void setHrPstNm(String hrPstNm) {
		this.hrPstNm = hrPstNm;
	}
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	public String getRqsTtlNm() {
		return rqsTtlNm;
	}
	public void setRqsTtlNm(String rqsTtlNm) {
		this.rqsTtlNm = rqsTtlNm;
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
	public String getAprvWrrptMtNo() {
		return aprvWrrptMtNo;
	}
	public void setAprvWrrptMtNo(String aprvWrrptMtNo) {
		this.aprvWrrptMtNo = aprvWrrptMtNo;
	}
	public List<GA01N504VO> getGridGA01N504() {
		return gridGA01N504;
	}
	public void setGridGA01N504(List<GA01N504VO> gridGA01N504) {
		this.gridGA01N504 = gridGA01N504;
	}
	public List<GA01N505VO> getGridGA01N505() {
		return gridGA01N505;
	}
	public void setGridGA01N505(List<GA01N505VO> gridGA01N505) {
		this.gridGA01N505 = gridGA01N505;
	}
	public List<GA01N109VO> getGridGA01N109() {
		return gridGA01N109;
	}
	public void setGridGA01N109(List<GA01N109VO> gridGA01N109) {
		this.gridGA01N109 = gridGA01N109;
	}
	public String getAprvRsnCn() {
		return aprvRsnCn;
	}
	public void setAprvRsnCn(String aprvRsnCn) {
		this.aprvRsnCn = aprvRsnCn;
	}
}
