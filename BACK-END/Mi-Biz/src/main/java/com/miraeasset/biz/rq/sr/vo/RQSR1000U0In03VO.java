/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0In03VO.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인감날인신청 신청등록/수정 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.meta.vo.AprvWrrptInVO;
import com.miraeasset.biz.common.meta.vo.GA01N109VO;
import com.miraeasset.biz.common.meta.vo.GA01N504VO;
import com.miraeasset.biz.common.meta.vo.GA01N505VO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0In11VO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0In03VO {

	@ApiModelProperty(notes= "처리구분: 00-임시저장 01-상신 ", required = true,example = "00")
	private String prcTp           ; /*처리구분         */
	@ApiModelProperty(notes= "접수번호:기데이터 수정일경우 필수입력")
	private String rctNo           ; /*접수번호         */
	
	@ApiModelProperty(notes= "신청유형코드 05-인감날인신청", required = true)
	private String unifRqsPcd          ; /*신청유형코드     */

	@ApiModelProperty(notes= "신청조직코드" , required = true)
	private String rqsOrzCd        ; /*신청조직코드     */
	@ApiModelProperty(notes= "신청사원번호" , required = true)
	private String rqsEpno         ; /*신청사원번호     */

	@ApiModelProperty(notes= "신청제목명", required = true)
	private String rqsTtlNm        ; /*신청제목명       */

	@ApiModelProperty(notes= "인장신청_인감날인신청 다건내역")
	List<GA01N504VO> gridGA01N504;    /* 인장신청_인감날인신청 다건내역 */
	@ApiModelProperty(notes= "인장신청_인감증명서신청 다건내역")
	List<GA01N505VO> gridGA01N505;    /* 인장신청_인감증명서신청 다건내역 */
	@ApiModelProperty(notes= "기안문서 다건내역")
	List<GA01N109VO> gridGA01N109;    /* 기안문서 다건내역  */
	
	/* 2023.09.18 결재선 리스트 */
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
	public List<AprvWrrptInVO> getAprvl() {
		return aprvl;
	}
	public void setAprvl(List<AprvWrrptInVO> aprvl) {
		this.aprvl = aprvl;
	}

	
}

    
