/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS5000U0In03VO.java
*	04. 작  성  일  자	: 2023.09.06
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 화면관리 신규/슈정/삭제 다건 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.bs.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.meta.vo.GA09N204VO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SSBS5000U0In03VO {

	@ApiModelProperty(notes= "신청조직코드(로그인조직코드) 입력세팅안해도됨" , required = true)
	private String rqsOrzCd        ; /*신청조직코드     */
	@ApiModelProperty(notes= "신청사원번호(로그인사번) 입력세팅안해도됨" , required = true)
	private String rqsEpno         ; /*신청사원번호     */

	@ApiModelProperty(notes= "화면관리 다건내역")
	List<GA09N204VO> gridGA09N204;    /* 화면관리 다건내역 */

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

	public List<GA09N204VO> getGridGA09N204() {
		return gridGA09N204;
	}

	public void setGridGA09N204(List<GA09N204VO> gridGA09N204) {
		this.gridGA09N204 = gridGA09N204;
	}

	
}

    
