/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0In23VO.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인감날인증명서신청 사전참조 확인 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.meta.vo.GA09N607VO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQSR1000U0In23VO {

	@ApiModelProperty(notes= "결재정보상세 다건내역 (PK만 세팅 aprvWrrptMtNo,aprvRnk,aprvDlRnk)")
	List<GA09N607VO> gridGA09N607;    /*  결재정보상세 다건내역 */

	public List<GA09N607VO> getGridGA09N607() {
		return gridGA09N607;
	}

	public void setGridGA09N607(List<GA09N607VO> gridGA09N607) {
		this.gridGA09N607 = gridGA09N607;
	}

	
}

    
