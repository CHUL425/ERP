package com.miraeasset.biz.common.auth.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class AuthGA09N207In00VO extends BaseVO {
	
	@ApiModelProperty(notes= "사원번호", required = true)
    private String epno			;            // 사원번호
	@ApiModelProperty(notes= "화면번호", required = true, example = "등록, 삭제처리시 필수")
	private String psitMenuId	;            // 포털사이트메뉴ID 
//	@ApiModelProperty(notes= "정렬순서")
//	private String sortSqn		;            // 정렬순서
//	@ApiModelProperty(notes= "조작자사번")
//	private String optrId		;            // 조작자사번
//	@ApiModelProperty(notes= "조작채널코드")
//	private String oprtChnlCd	;            // 조작채널코드
//	@ApiModelProperty(notes= "조작조직코드")
//	private String oprtOrzCd	;            // 조작조직코드
//	@ApiModelProperty(notes= "조작IP주소")
//	private String oprtIpAdr	;            // 조작IP주소
	
	@ApiModelProperty(notes= "정렬순서 ")
	private long 	sortSqn		; /* 	정렬순서 	 */

	
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getPsitMenuId() {
		return psitMenuId;
	}
	public void setPsitMenuId(String psitMenuId) {
		this.psitMenuId = psitMenuId;
	}
	public long getSortSqn() {
		return sortSqn;
	}
	public void setSortSqn(long sortSqn) {
		this.sortSqn = sortSqn;
	}
	
}
