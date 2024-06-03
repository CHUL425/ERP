package com.miraeasset.biz.common.auth.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class AuthGA09N200Out00VO {

    @ApiModelProperty(notes= "사용자그룹코드",  required = true)
    private String userGrpCd    ; /* 사용자그룹코드*/
    @ApiModelProperty(notes= "그룹명" )
    private String grpNm        ; /* 그룹명        */
    @ApiModelProperty(notes= "관리그룹여부" )
    private String mtGrpYn      ; /* 관리그룹여부  */
    @ApiModelProperty(notes= "조작자ID" )
    private String optrId       ; /* 조작자ID      */
    @ApiModelProperty(notes= "조작채널코드" )
    private String oprtChnlCd   ; /* 조작채널코드  */
    @ApiModelProperty(notes= "조작조직코드" )
    private String oprtOrzCd    ; /* 조작조직코드  */
    @ApiModelProperty(notes= "조작IP주소" )
    private String oprtIpAdr    ; /* 조작IP주소    */
    @ApiModelProperty(notes= "조작일시" )
    private String oprtDttm     ; /* 조작일시      */
	@ApiModelProperty(notes= "순번", example="0")
	private BigDecimal rnum     ; /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt    ; /* 전체건수             */        
    
	public String getUserGrpCd() {
		return userGrpCd;
	}
	public void setUserGrpCd(String userGrpCd) {
		this.userGrpCd = userGrpCd;
	}
	public String getGrpNm() {
		return grpNm;
	}
	public void setGrpNm(String grpNm) {
		this.grpNm = grpNm;
	}
	public String getMtGrpYn() {
		return mtGrpYn;
	}
	public void setMtGrpYn(String mtGrpYn) {
		this.mtGrpYn = mtGrpYn;
	}
	public String getOptrId() {
		return optrId;
	}
	public void setOptrId(String optrId) {
		this.optrId = optrId;
	}
	public String getOprtChnlCd() {
		return oprtChnlCd;
	}
	public void setOprtChnlCd(String oprtChnlCd) {
		this.oprtChnlCd = oprtChnlCd;
	}
	public String getOprtOrzCd() {
		return oprtOrzCd;
	}
	public void setOprtOrzCd(String oprtOrzCd) {
		this.oprtOrzCd = oprtOrzCd;
	}
	public String getOprtIpAdr() {
		return oprtIpAdr;
	}
	public void setOprtIpAdr(String oprtIpAdr) {
		this.oprtIpAdr = oprtIpAdr;
	}
	public String getOprtDttm() {
		return oprtDttm;
	}
	public void setOprtDttm(String oprtDttm) {
		this.oprtDttm = oprtDttm;
	}
	public BigDecimal getRnum() {
		return rnum;
	}
	public void setRnum(BigDecimal rnum) {
		this.rnum = rnum;
	}
	public BigDecimal getAlCnt() {
		return alCnt;
	}
	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}
	
	

}
