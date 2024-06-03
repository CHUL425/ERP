/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: BM
*	03. 파    일   명	: GA01N504VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA01N504VO 인장신청_인감날인신청 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;


@Component
public class GA01N504VO extends BaseVO {

	@ApiModelProperty(notes= "인감날인신청시퀀스번호 ")
	private String sealSalgRqsSqncNo ; /*인감날인신청시퀀스번호     */
	//@ApiModelProperty(notes= "신청일자")
	//private String rqsDt      ; /*신청일자    */
	@ApiModelProperty(notes= "접수번호")
	private String rctNo      ; /*접수번호    */
	@ApiModelProperty(notes= "접수상세번호")
	private String rctDlNo    ; /*접수상세번호*/
	@ApiModelProperty(notes= "사용인감여부")
	private String useSealYn  ; /*사용인감여부*/
	@ApiModelProperty(notes= "신청사유내용")
	private String rqsRsnCn   ; /*신청사유내용*/
	@ApiModelProperty(notes= "제출처내용")
	private String smitpCn    ; /*제출처내용  */
	@ApiModelProperty(notes= "인장관리번호")
	private String salMtNo    ; /*인장관리번호*/
	@ApiModelProperty(notes= "신청수량", example="0")
	private BigDecimal rqsQ   ; /*신청수량    */
	@ApiModelProperty(notes= "파일번호")
	private String fileNo     ; /*파일번호    */

	@ApiModelProperty(notes= "인감관리명")
	private String salMtNm          ;  /*인감관리명*/
	
	List<GA09N411VO> gridGA09N411;    /* 첨부파일 다건내역 */
	
	public String getSealSalgRqsSqncNo() {
		return sealSalgRqsSqncNo;
	}
	public void setSealSalgRqsSqncNo(String sealSalgRqsSqncNo) {
		this.sealSalgRqsSqncNo = sealSalgRqsSqncNo;
	}
//	public String getRqsDt() {
//		return rqsDt;
//	}
//	public void setRqsDt(String rqsDt) {
//		this.rqsDt = rqsDt;
//	}
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
	public String getUseSealYn() {
		return useSealYn;
	}
	public void setUseSealYn(String useSealYn) {
		this.useSealYn = useSealYn;
	}
	public String getRqsRsnCn() {
		return rqsRsnCn;
	}
	public void setRqsRsnCn(String rqsRsnCn) {
		this.rqsRsnCn = rqsRsnCn;
	}
	public String getSmitpCn() {
		return smitpCn;
	}
	public void setSmitpCn(String smitpCn) {
		this.smitpCn = smitpCn;
	}
	public String getSalMtNo() {
		return salMtNo;
	}
	public void setSalMtNo(String salMtNo) {
		this.salMtNo = salMtNo;
	}
	public BigDecimal getRqsQ() {
		return rqsQ;
	}
	public void setRqsQ(BigDecimal rqsQ) {
		this.rqsQ = rqsQ;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public List<GA09N411VO> getGridGA09N411() {
		return gridGA09N411;
	}
	public void setGridGA09N411(List<GA09N411VO> gridGA09N411) {
		this.gridGA09N411 = gridGA09N411;
	}
	public String getSalMtNm() {
		return salMtNm;
	}
	public void setSalMtNm(String salMtNm) {
		this.salMtNm = salMtNm;
	}

	
}
