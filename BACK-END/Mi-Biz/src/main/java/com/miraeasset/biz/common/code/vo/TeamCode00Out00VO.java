package com.miraeasset.biz.common.code.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class TeamCode00Out00VO {
	
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수             */       
	
    @ApiModelProperty(notes= "조직코드")
	private String orzCd          ;    /* 조직코드 */                    
    @ApiModelProperty(notes= "조직명")
	private String orzNm        ;    /* 조직명 */                  
    @ApiModelProperty(notes= "상위조직코드")
	private String hrkOrzCd     ;    /* 상위조직코드 */              
    @ApiModelProperty(notes= "상위조직명")
	private String hrkOrzNm     ;    /* 상위조직명 */
    @ApiModelProperty(notes= "건물구분코드")
    private String bldTcd		;	 /* 건물구분코드 */
    @ApiModelProperty(notes= "건물구분코드명")
    private String bldTcdNm		;	 /* 건물구분코드명 */
    @ApiModelProperty(notes= "건물층번호")
    private String bldflrNo		;	 /* 건물층번호 */
	@ApiModelProperty(notes = "본지점구분코드")
	private String hobrTcd;
	public BigDecimal getAlCnt() {
		return alCnt;
	}
	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}
	public String getOrzCd() {
		return orzCd;
	}
	public void setOrzCd(String orzCd) {
		this.orzCd = orzCd;
	}
	public String getOrzNm() {
		return orzNm;
	}
	public void setOrzNm(String orzNm) {
		this.orzNm = orzNm;
	}
	public String getHrkOrzCd() {
		return hrkOrzCd;
	}
	public void setHrkOrzCd(String hrkOrzCd) {
		this.hrkOrzCd = hrkOrzCd;
	}
	public String getHrkOrzNm() {
		return hrkOrzNm;
	}
	public void setHrkOrzNm(String hrkOrzNm) {
		this.hrkOrzNm = hrkOrzNm;
	}
	public String getBldTcd() {
		return bldTcd;
	}
	public void setBldTcd(String bldTcd) {
		this.bldTcd = bldTcd;
	}
	public String getBldTcdNm() {
		return bldTcdNm;
	}
	public void setBldTcdNm(String bldTcdNm) {
		this.bldTcdNm = bldTcdNm;
	}
	public String getBldflrNo() {
		return bldflrNo;
	}
	public void setBldflrNo(String bldflrNo) {
		this.bldflrNo = bldflrNo;
	}

	public String getHobrTcd() {
		return hobrTcd;
	}

	public void setHobrTcd(String hobrTcd) {
		this.hobrTcd = hobrTcd;
	}

	@Override
	public String toString() {
		return "TeamCode00Out00VO [alCnt=" + alCnt + ", orzCd=" + orzCd + ", orzNm=" + orzNm + ", hrkOrzCd=" + hrkOrzCd
				+ ", hrkOrzNm=" + hrkOrzNm + ", bldTcd=" + bldTcd + ", bldTcdNm=" + bldTcdNm + ", bldflrNo=" + bldflrNo
				+ ", hobrTcd=" + hobrTcd
				+ "]";
	}
    
}
