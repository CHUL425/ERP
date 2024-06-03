package com.miraeasset.biz.common.code.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GaCode00Out00VO {

	private BigDecimal rnum       ;    /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ;    /* 전체건수             */       
    @ApiModelProperty(notes= "코드종류번호")
	private String cdKndNo        ;    /* 코드종류번호 */                    
    @ApiModelProperty(notes= "코드종류명")
	private String cdKndNm        ;    /* 코드종류명 */                  
    @ApiModelProperty(notes= "공통코드정의내용")
	private String cmnCdDefCn     ;    /* 공통코드정의내용 */
    @ApiModelProperty(notes= "사용여부")
	private String useYn          ;    /* 사용여부 */                

	
    @Override
    public String toString() {
        return  "  BasicCode00Out00VO{ "+
                ", rnum           = '" + rnum          + "'" +
                ", alCnt          = '" + alCnt         + "'" +
                ", cdKndNo        = '" + cdKndNo       + "'" +
                ", cdKndNm        = '" + cdKndNm       + "'" +
                ", cmnCdDefCn     = '" + cmnCdDefCn    + "'" +
                ", useYn          = '" + useYn         + "'" +
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


	public String getCdKndNm() {
		return cdKndNm;
	}


	public void setCdKndNm(String cdKndNm) {
		this.cdKndNm = cdKndNm;
	}


	public String getCmnCdDefCn() {
		return cmnCdDefCn;
	}


	public void setCmnCdDefCn(String cmnCdDefCn) {
		this.cmnCdDefCn = cmnCdDefCn;
	}


	public String getUseYn() {
		return useYn;
	}


	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

    

}
