package com.miraeasset.biz.common.auth.vo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class AuthGA09N502In00VO extends BaseVO {
	
	@ApiModelProperty(notes= "사원번호", hidden = true)
    private String epno				; /* 로그인 사원번호 */ 
	
	@ApiModelProperty(notes= "메시지발송일련번호", example = "단건읽음변경처리시사용")
	private String 	msgSndSrno		; /* 메시지발송일련번호 */
	
	@ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize		; /* 페이지사이즈 */
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex	; /* 페이지순번 */
    
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getMsgSndSrno() {
		return msgSndSrno;
	}
	public void setMsgSndSrno(String msgSndSrno) {
		this.msgSndSrno = msgSndSrno;
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
