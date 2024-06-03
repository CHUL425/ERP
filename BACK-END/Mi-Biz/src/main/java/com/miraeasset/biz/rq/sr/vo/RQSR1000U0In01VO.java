/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0In01VO.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인감날인신청 상세조회 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In05VO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0In01VO {

	@ApiModelProperty(notes= "접수번호")
	private String rctNo           ; /*접수번호            */
	
	@ApiModelProperty(notes= "신청상태", example = "90.사용처제출, 91.원본폐기시 사용")
	private String rqsScd		   ; /*신청상태			*/
	
	@ApiModelProperty(notes= "유형 - 백앤드에서 설정")
	private String sealCtfwDlScd ; 
	
	@ApiModelProperty(notes= "완료대상 인장신청목록", example = "완료대상건 처리시 사용")
    List<RQRR1000U0In05VO> grid5;    // 완료대상 인장신청목록
	
	@ApiModelProperty(notes= "로그인사번-모바일용", hidden=true)
	private String epno           ; 
	
	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public String getRqsScd() {
		return rqsScd;
	}

	public void setRqsScd(String rqsScd) {
		this.rqsScd = rqsScd;
	}

	public List<RQRR1000U0In05VO> getGrid5() {
		return grid5;
	}

	public void setGrid5(List<RQRR1000U0In05VO> grid5) {
		this.grid5 = grid5;
	}

	public String getSealCtfwDlScd() {
		return sealCtfwDlScd;
	}

	public void setSealCtfwDlScd(String sealCtfwDlScd) {
		this.sealCtfwDlScd = sealCtfwDlScd;
	}

	public String getEpno() {
		return epno;
	}

	public void setEpno(String epno) {
		this.epno = epno;
	} 
}

    
