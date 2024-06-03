/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA03N101.java
*	04. 작  성  일  자	: 2024.05.22
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 구매물품관리
*	07. 주  요  사  항	: 
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA03N101VO extends BaseVO {
	
	@ApiModelProperty(notes= "물품구분코드")
	private String atclTcd;
	@ApiModelProperty(notes= "물품코드")
	private String atclCd;
	@ApiModelProperty(notes= "물품명")
	private String atclNm;
	@ApiModelProperty(notes= "거래처코드")
	private String delpCd;
	
	@ApiModelProperty(notes= "물품공급가액")
	private BigDecimal atclSupa;
	@ApiModelProperty(notes= "물품세액")
	private BigDecimal atclTa;
	@ApiModelProperty(notes= "물품가격금액")
	private BigDecimal atclPrA;
	
	@ApiModelProperty(notes= "최소신청단위수량")
	private int minRqsUnitQ;
	@ApiModelProperty(notes= "최소구매신청수량")
	private int minPchRqsQ;
	@ApiModelProperty(notes= "최대구매신청수량")
	private int maxPchRqsQ;
	
	@ApiModelProperty(notes= "규격내용")
	private String specCn;
	@ApiModelProperty(notes= "신청구분코드")
	private String rqsTcd;
	@ApiModelProperty(notes= "필수요청여부")
	private String essnRqmYn;
	@ApiModelProperty(notes= "신청요청사항내용")
	private String rqsRqmPtcrCn;
	@ApiModelProperty(notes= "손익보전여부")
	private String plPrsvYn;
	@ApiModelProperty(notes= "계정과목코드")
	private String acsjCd;
	@ApiModelProperty(notes= "계약시작일자")
	private String cntcStrtDt;
	@ApiModelProperty(notes= "계약종료일자")
	private String cntcEndDt;
	@ApiModelProperty(notes= "사용여부")
	private String useYn;
	@ApiModelProperty(notes= "물품이미지파일번호")
	private String atclImgFileNo;
	
	@ApiModelProperty(notes= "사용자입력여부")
	private String userInptYn;
	
	@ApiModelProperty(notes= "총건수")
	private long totCnt ;
    
	public String getAtclTcd() {
		return atclTcd;
	}
	public void setAtclTcd(String atclTcd) {
		this.atclTcd = atclTcd;
	}
	public String getAtclCd() {
		return atclCd;
	}
	public void setAtclCd(String atclCd) {
		this.atclCd = atclCd;
	}
	public String getDelpCd() {
		return delpCd;
	}
	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}
	public BigDecimal getAtclSupa() {
		return atclSupa;
	}
	public void setAtclSupa(BigDecimal atclSupa) {
		this.atclSupa = atclSupa;
	}
	public BigDecimal getAtclTa() {
		return atclTa;
	}
	public void setAtclTa(BigDecimal atclTa) {
		this.atclTa = atclTa;
	}
	public BigDecimal getAtclPrA() {
		return atclPrA;
	}
	public void setAtclPrA(BigDecimal atclPrA) {
		this.atclPrA = atclPrA;
	}
	public int getMinRqsUnitQ() {
		return minRqsUnitQ;
	}
	public void setMinRqsUnitQ(int minRqsUnitQ) {
		this.minRqsUnitQ = minRqsUnitQ;
	}
	public int getMinPchRqsQ() {
		return minPchRqsQ;
	}
	public void setMinPchRqsQ(int minPchRqsQ) {
		this.minPchRqsQ = minPchRqsQ;
	}
	public int getMaxPchRqsQ() {
		return maxPchRqsQ;
	}
	public void setMaxPchRqsQ(int maxPchRqsQ) {
		this.maxPchRqsQ = maxPchRqsQ;
	}
	public String getSpecCn() {
		return specCn;
	}
	public void setSpecCn(String specCn) {
		this.specCn = specCn;
	}
	public String getRqsTcd() {
		return rqsTcd;
	}
	public void setRqsTcd(String rqsTcd) {
		this.rqsTcd = rqsTcd;
	}
	public String getEssnRqmYn() {
		return essnRqmYn;
	}
	public void setEssnRqmYn(String essnRqmYn) {
		this.essnRqmYn = essnRqmYn;
	}
	public String getRqsRqmPtcrCn() {
		return rqsRqmPtcrCn;
	}
	public void setRqsRqmPtcrCn(String rqsRqmPtcrCn) {
		this.rqsRqmPtcrCn = rqsRqmPtcrCn;
	}
	public String getPlPrsvYn() {
		return plPrsvYn;
	}
	public void setPlPrsvYn(String plPrsvYn) {
		this.plPrsvYn = plPrsvYn;
	}
	public String getAcsjCd() {
		return acsjCd;
	}
	public void setAcsjCd(String acsjCd) {
		this.acsjCd = acsjCd;
	}
	public String getCntcStrtDt() {
		return cntcStrtDt;
	}
	public void setCntcStrtDt(String cntcStrtDt) {
		this.cntcStrtDt = cntcStrtDt;
	}
	public String getCntcEndDt() {
		return cntcEndDt;
	}
	public void setCntcEndDt(String cntcEndDt) {
		this.cntcEndDt = cntcEndDt;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getAtclImgFileNo() {
		return atclImgFileNo;
	}
	public void setAtclImgFileNo(String atclImgFileNo) {
		this.atclImgFileNo = atclImgFileNo;
	}
	public String getAtclNm() {
		return atclNm;
	}
	public void setAtclNm(String atclNm) {
		this.atclNm = atclNm;
	}
	public String getUserInptYn() {
		return userInptYn;
	}
	public void setUserInptYn(String userInptYn) {
		this.userInptYn = userInptYn;
	}
	public long getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(long totCnt) {
		this.totCnt = totCnt;
	}	
}
