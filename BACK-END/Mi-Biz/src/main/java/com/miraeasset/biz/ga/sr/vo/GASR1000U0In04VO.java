/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GASR1000U0In04VO.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인장조제관리 폐기신청 일괄 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.sr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.meta.vo.GA01N501Vs01InVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GASR1000U0In04VO {

	@ApiModelProperty(notes= "폐기일자")
	private String dsusDt         ; /*폐기일자      */ 
	@ApiModelProperty(notes= "폐기기안문서")
	private String dsusDrftDocNo         ; /*폐기기안문서*/

	@ApiModelProperty(notes= "폐기신청 다건내역")
    List<GA01N501Vs01InVO> gridGA01N501;    /* 폐기신청 다건내역 */

	@ApiModelProperty(notes= "신청조직코드 - 로그인정보")
	private String rqsOrzCd        ; /*신청조직코드     */
	@ApiModelProperty(notes= "신청사원번호 - 로그인정보")
	private String rqsEpno         ; /*신청사원번호     */
	
	public String getDsusDt() {
		return dsusDt;
	}

	public void setDsusDt(String dsusDt) {
		this.dsusDt = dsusDt;
	}

	public List<GA01N501Vs01InVO> getGridGA01N501() {
		return gridGA01N501;
	}

	public void setGridGA01N501(List<GA01N501Vs01InVO> gridGA01N501) {
		this.gridGA01N501 = gridGA01N501;
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

	public String getDsusDrftDocNo() {
		return dsusDrftDocNo;
	}

	public void setDsusDrftDocNo(String dsusDrftDocNo) {
		this.dsusDrftDocNo = dsusDrftDocNo;
	}
	
}

    
