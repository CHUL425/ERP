/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: SSBS7000U0In03VO.java
*	04. 작  성  일  자	: 2023.09.06
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹_화면 상신 다건 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.bs.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.meta.vo.GA09N205VO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SSBS7000U0In03VO {

	@ApiModelProperty(notes= "처리구분: 00-임시저장 01-상신 ", required = true,example = "00")
	private String prcTp           ; /*처리구분         */

	@ApiModelProperty(notes= "신청조직코드(로그인조직코드) 입력세팅안해도됨" , required = true)
	private String rqsOrzCd        ; /*신청조직코드     */
	@ApiModelProperty(notes= "신청사원번호(로그인사번) 입력세팅안해도됨" , required = true)
	private String rqsEpno         ; /*신청사원번호     */

	
	@ApiModelProperty(notes= "사용자그룹_화면 다건내역")
	List<GA09N205VO> gridGA09N205;    /* 사용자그룹_화면 다건내역 */

	public String getPrcTp() {
		return prcTp;
	}

	public void setPrcTp(String prcTp) {
		this.prcTp = prcTp;
	}

	public List<GA09N205VO> getGridGA09N205() {
		return gridGA09N205;
	}

	public void setGridGA09N205(List<GA09N205VO> gridGA09N205) {
		this.gridGA09N205 = gridGA09N205;
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
	

	
}

    
