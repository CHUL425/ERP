/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SH
*	03. 파    일   명	: SHAN3000U0Out01VO.java
*	04. 작  성  일  자	: 2024.02.07
*	05. 작   성   자	: CHS
*	06. 관 련 기 능	: 안전보건공지 확인 상세조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.sh.an.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SHAN3000U0Out01VO {
	
	@ApiModelProperty(notes= "작성일자")
	private String madeDt; 
	@ApiModelProperty(notes= "일련번호")
	private BigDecimal srno; 
	@ApiModelProperty(notes= "공지구분코드")
	private String cmklTcd; 
	@ApiModelProperty(notes= "제목명")
	private String ttlNm;
	@ApiModelProperty(notes= "공지사항내용")
	private String cmklPtcrCn;
	
	@ApiModelProperty(notes= "파일번호")
	private String fileNo;
	@ApiModelProperty(notes= "게시판이미지파일번호")
	private String blbdImgFileNo;
	
	@ApiModelProperty(notes= "작성사원번호")
    private String madeEpno;
	@ApiModelProperty(notes= "작성사원명")
    private String madeEpnm;
	
	public String getMadeDt() {
		return madeDt;
	}
	public void setMadeDt(String madeDt) {
		this.madeDt = madeDt;
	}
	public BigDecimal getSrno() {
		return srno;
	}
	public void setSrno(BigDecimal srno) {
		this.srno = srno;
	}
	public String getTtlNm() {
		return ttlNm;
	}
	public void setTtlNm(String ttlNm) {
		this.ttlNm = ttlNm;
	}
	
	public String getBlbdImgFileNo() {
		return blbdImgFileNo;
	}
	public void setBlbdImgFileNo(String blbdImgFileNo) {
		this.blbdImgFileNo = blbdImgFileNo;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getCmklTcd() {
		return cmklTcd;
	}
	public void setCmklTcd(String cmklTcd) {
		this.cmklTcd = cmklTcd;
	}
	public String getMadeEpno() {
		return madeEpno;
	}
	public void setMadeEpno(String madeEpno) {
		this.madeEpno = madeEpno;
	}
	public String getMadeEpnm() {
		return madeEpnm;
	}
	public void setMadeEpnm(String madeEpnm) {
		this.madeEpnm = madeEpnm;
	}
	public String getCmklPtcrCn() {
		return cmklPtcrCn;
	}
	public void setCmklPtcrCn(String cmklPtcrCn) {
		this.cmklPtcrCn = cmklPtcrCn;
	}
}
