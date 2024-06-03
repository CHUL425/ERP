/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: BM
*	03. 파    일   명	: GA01N506VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA01N506 인장승인관리_인감증명서신청별출고 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;


@Component
public class GA01N506VO extends BaseVO {

	@ApiModelProperty(notes= "접수번호")
	private String     rctNo      ; /*접수번호    */   
	@ApiModelProperty(notes= "접수상세번호")
	private String     rctDlNo    ; /*접수상세번호*/   
	@ApiModelProperty(notes= "출고수량1")
	private BigDecimal outqQ1     ; /*출고수량1   */   
	@ApiModelProperty(notes= "시작번호1 ")
	private BigDecimal strtNo1    ; /*시작번호1   */   
	@ApiModelProperty(notes= "끝번호1")
	private BigDecimal lastNo1    ; /*끝번호1     */   
	@ApiModelProperty(notes= "출고수량2 ")
	private BigDecimal outqQ2     ; /*출고수량2   */   
	@ApiModelProperty(notes= "시작번호2")
	private BigDecimal strtNo2    ; /*시작번호2   */   
	@ApiModelProperty(notes= "끝번호2 ")
	private BigDecimal lastNo2    ; /*끝번호2     */
	
    public String toString() {
        return "GA01N506VO{" +
        		"rctNo      ='" + rctNo   + "'" +
        		"rctDlNo    ='" + rctDlNo + "'" +
        		"outqQ1     ='" + outqQ1   + "'" +
        		"strtNo1    ='" + strtNo1   + "'" +
        		"outqQ2     ='" + outqQ2   + "'" +
        		"strtNo2    ='" + strtNo2   + "'" +
                '}';    	
    }
    
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
	public BigDecimal getOutqQ1() {
		return outqQ1;
	}
	public void setOutqQ1(BigDecimal outqQ1) {
		this.outqQ1 = outqQ1;
	}
	public BigDecimal getStrtNo1() {
		return strtNo1;
	}
	public void setStrtNo1(BigDecimal strtNo1) {
		this.strtNo1 = strtNo1;
	}
	public BigDecimal getLastNo1() {
		return lastNo1;
	}
	public void setLastNo1(BigDecimal lastNo1) {
		this.lastNo1 = lastNo1;
	}
	public BigDecimal getOutqQ2() {
		return outqQ2;
	}
	public void setOutqQ2(BigDecimal outqQ2) {
		this.outqQ2 = outqQ2;
	}
	public BigDecimal getStrtNo2() {
		return strtNo2;
	}
	public void setStrtNo2(BigDecimal strtNo2) {
		this.strtNo2 = strtNo2;
	}
	public BigDecimal getLastNo2() {
		return lastNo2;
	}
	public void setLastNo2(BigDecimal lastNo2) {
		this.lastNo2 = lastNo2;
	}   

	
	
}
