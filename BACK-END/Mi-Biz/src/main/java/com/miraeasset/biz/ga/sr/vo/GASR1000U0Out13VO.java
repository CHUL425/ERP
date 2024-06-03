/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GASR1000U0Out13VO.java
*	04. 작  성  일  자	: 2023.08.10
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인장조제관리 인장유형 통계정보조회  OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ga.sr.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GASR1000U0Out13VO {
	
	@ApiModelProperty(notes= "접수중 인감상태 총합계")	
	private BigDecimal rctSealScdCnt   ;  
	@ApiModelProperty(notes= "조제등록중 인감상태 총합계")	
	private BigDecimal regSealScdCnt   ; 
	@ApiModelProperty(notes= "사용중 인감상태 합계")	
	private BigDecimal usedSealScdCnt  ;  
	@ApiModelProperty(notes= "회수신청중 인감상태 합계")	
	private BigDecimal wdralIngSealScdCnt  ;  
	@ApiModelProperty(notes= "회수 인감상태 합계")	
	private BigDecimal wdralSealScdCnt  ; 
	@ApiModelProperty(notes= "폐기신청중 인감상태 합계")	
	private BigDecimal dsusIngSealScdCnt  ; 
	@ApiModelProperty(notes= "폐기 인감상태 합계 ")	
	private BigDecimal dsusSealScdCnt  ;  
	@ApiModelProperty(notes= "내용수정중 인감상태 합계")	
	private BigDecimal chngSealScdCnt  ;  
	@ApiModelProperty(notes= "담당자취소 인감상태 합계 ")	
	private BigDecimal cnclSealScdCnt  ;
	
	public BigDecimal getRctSealScdCnt() {
		return rctSealScdCnt;
	}
	public void setRctSealScdCnt(BigDecimal rctSealScdCnt) {
		this.rctSealScdCnt = rctSealScdCnt;
	}
	public BigDecimal getRegSealScdCnt() {
		return regSealScdCnt;
	}
	public void setRegSealScdCnt(BigDecimal regSealScdCnt) {
		this.regSealScdCnt = regSealScdCnt;
	}
	public BigDecimal getUsedSealScdCnt() {
		return usedSealScdCnt;
	}
	public void setUsedSealScdCnt(BigDecimal usedSealScdCnt) {
		this.usedSealScdCnt = usedSealScdCnt;
	}
	public BigDecimal getWdralIngSealScdCnt() {
		return wdralIngSealScdCnt;
	}
	public void setWdralIngSealScdCnt(BigDecimal wdralIngSealScdCnt) {
		this.wdralIngSealScdCnt = wdralIngSealScdCnt;
	}
	public BigDecimal getWdralSealScdCnt() {
		return wdralSealScdCnt;
	}
	public void setWdralSealScdCnt(BigDecimal wdralSealScdCnt) {
		this.wdralSealScdCnt = wdralSealScdCnt;
	}
	public BigDecimal getDsusIngSealScdCnt() {
		return dsusIngSealScdCnt;
	}
	public void setDsusIngSealScdCnt(BigDecimal dsusIngSealScdCnt) {
		this.dsusIngSealScdCnt = dsusIngSealScdCnt;
	}
	public BigDecimal getDsusSealScdCnt() {
		return dsusSealScdCnt;
	}
	public void setDsusSealScdCnt(BigDecimal dsusSealScdCnt) {
		this.dsusSealScdCnt = dsusSealScdCnt;
	}
	public BigDecimal getChngSealScdCnt() {
		return chngSealScdCnt;
	}
	public void setChngSealScdCnt(BigDecimal chngSealScdCnt) {
		this.chngSealScdCnt = chngSealScdCnt;
	}
	public BigDecimal getCnclSealScdCnt() {
		return cnclSealScdCnt;
	}
	public void setCnclSealScdCnt(BigDecimal cnclSealScdCnt) {
		this.cnclSealScdCnt = cnclSealScdCnt;
	} 
}
