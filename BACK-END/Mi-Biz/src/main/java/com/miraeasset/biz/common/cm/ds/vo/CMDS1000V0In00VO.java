package com.miraeasset.biz.common.cm.ds.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CMDS1000V0In00VO {

    @ApiModelProperty(notes= "조직코드/명")
	private String drftOrzCd	; 			 /* 조직코드/명 */
    @ApiModelProperty(notes= "사원번호/명")
	private String regiEpno		; 			 /* 사원번호/명 */
    @ApiModelProperty(notes= "승인시작일자")
	private String aprvStrtDt	; 			 /* 승인시작일자 */
    @ApiModelProperty(notes= "승인종료일자")
	private String aprvEndDt	; 			 /* 승인종료일자 */
    @ApiModelProperty(notes= "기안문서번호/명")
	private String drftDocNo	;			 /* 기안문서번호/명 */
	
    @ApiModelProperty(notes= "페이지사이즈", example="0")
	private BigDecimal pageSize	; 			 /* 페이지사이즈 */
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;            /* 페이지순번 */
    
	public String getDrftOrzCd() {
		return drftOrzCd;
	}
	public void setDrftOrzCd(String drftOrzCd) {
		this.drftOrzCd = drftOrzCd;
	}
	public String getRegiEpno() {
		return regiEpno;
	}
	public void setRegiEpno(String regiEpno) {
		this.regiEpno = regiEpno;
	}
	public String getAprvStrtDt() {
		return aprvStrtDt;
	}
	public void setAprvStrtDt(String aprvStrtDt) {
		this.aprvStrtDt = aprvStrtDt;
	}
	public String getAprvEndDt() {
		return aprvEndDt;
	}
	public void setAprvEndDt(String aprvEndDt) {
		this.aprvEndDt = aprvEndDt;
	}
	public String getDrftDocNo() {
		return drftDocNo;
	}
	public void setDrftDocNo(String drftDocNo) {
		this.drftDocNo = drftDocNo;
	}
	public BigDecimal getPageSize() {
		return pageSize;
	}
	public void setPageSize(BigDecimal pageSize) {
		this.pageSize = pageSize;
	}
	public BigDecimal getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(BigDecimal pageIndex) {
		this.pageIndex = pageIndex;
	}
    
}
