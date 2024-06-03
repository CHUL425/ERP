package com.miraeasset.biz.common.code.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GaCode01Out00VO {

	private BigDecimal rnum       ;    /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ;    /* 전체건수             */       
    @ApiModelProperty(notes= "코드종류번호")
	private String cdKndNo        ;    /* 코드종류번호 */                    
    @ApiModelProperty(notes= "공통코드값")
	private String cmnCdVl        ;    /* 공통코드값 */                  
    @ApiModelProperty(notes= "공통코드값정의내용")
	private String cmnCdVlDefCn   ;    /* 공통코드값정의내용 */
    
    @ApiModelProperty(notes= "코드설명 ")
    private String cdDesc	      ;	   /* 코드설명 */ 
    
    @ApiModelProperty(notes= "사용여부")
	private String useYn          ;    /* 사용여부 */                
    @ApiModelProperty(notes= "정렬순서")
	private BigDecimal sortSqn    ;    /* 정렬순서 */                

    @ApiModelProperty(notes= "신규번호")
	private String newNo        ;    /* 신규번호-업무별 채번 */                    

    @ApiModelProperty(notes= "업무관리코드값")
	private String bzMtCdVl      ;    /* 업무관리코드값 */                    
    
    @Override
    public String toString() {
        return  "  BasicCode00Out00VO{ "+
                ", rnum                = '" + rnum              + "'" +
                ", alCnt               = '" + alCnt             + "'" +
                ", cdKndNo             = '" + cdKndNo           + "'" +
                ", cmnCdVl             = '" + cmnCdVl           + "'" +
                ", cmnCdVlDefCn        = '" + cmnCdVlDefCn      + "'" +
                ", bzMtCdVl            = '" + bzMtCdVl          + "'" +
                ", useYn               = '" + useYn             + "'" +
        		"}";
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

	public String getCdKndNo() {
		return cdKndNo;
	}

	public void setCdKndNo(String cdKndNo) {
		this.cdKndNo = cdKndNo;
	}

	public String getCmnCdVl() {
		return cmnCdVl;
	}

	public void setCmnCdVl(String cmnCdVl) {
		this.cmnCdVl = cmnCdVl;
	}

	public String getCmnCdVlDefCn() {
		return cmnCdVlDefCn;
	}

	public void setCmnCdVlDefCn(String cmnCdVlDefCn) {
		this.cmnCdVlDefCn = cmnCdVlDefCn;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public BigDecimal getSortSqn() {
		return sortSqn;
	}

	public void setSortSqn(BigDecimal sortSqn) {
		this.sortSqn = sortSqn;
	}

	public String getNewNo() {
		return newNo;
	}

	public void setNewNo(String newNo) {
		this.newNo = newNo;
	}

	public String getBzMtCdVl() {
		return bzMtCdVl;
	}

	public void setBzMtCdVl(String bzMtCdVl) {
		this.bzMtCdVl = bzMtCdVl;
	}

	public String getCdDesc() {
		return cdDesc;
	}

	public void setCdDesc(String cdDesc) {
		this.cdDesc = cdDesc;
	}
	
}
