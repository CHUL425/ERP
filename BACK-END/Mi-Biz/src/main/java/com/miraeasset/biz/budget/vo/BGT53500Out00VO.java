package com.miraeasset.biz.budget.vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class BGT53500Out00VO {

    @ApiModelProperty(notes= "결의팀점코드")
    private String rslnOrzCd       ;  /* 결의팀점코드 */          
    @ApiModelProperty(notes= "결의팀점코드명")
    private String dcsTmpCdn       ;  /* 결의팀점코드명 */        
    @ApiModelProperty(notes= "결의일")
    private String rslnDt          ;  /* 결의일 */                
    @ApiModelProperty(notes= "결의일련번호")
    private BigDecimal rslnSrno    ;  /* 결의일련번호 */          
    @ApiModelProperty(notes= "결의번호")
    private BigDecimal dcsNo       ;  /* 결의번호 */              
    @ApiModelProperty(notes= "예산계정과목코드")
    private String bdgtAcsjCd      ;  /* 예산계정과목코드 */      
    @ApiModelProperty(notes= "예산계정과목코드명")
    private String bdgtAcsjCdNm    ;  /* 예산계정과목코드명 */    
    @ApiModelProperty(notes= "상대계정과목코드")
    private String oppAcsjCd       ;  /* 상대계정과목코드 */      
    @ApiModelProperty(notes= "상대계정과목코드명")
    private String oppAcSbjCdn     ;  /* 상대계정과목코드명 */    
    @ApiModelProperty(notes= "상세적요")
    private String dlSmryCn        ;  /* 상세적요 */              
    @ApiModelProperty(notes= "대체금액")
    private BigDecimal rslnUseA    ;  /* 대체금액 */              
    @ApiModelProperty(notes= "거래처코드")
    private String delpCd          ;  /* 거래처코드 */            
    @ApiModelProperty(notes= "거래처명")
    private String delpNm          ;  /* 거래처명 */              
    @ApiModelProperty(notes= "상위계정과목코드명")
    private String hrkAcsjCd       ;  /* 상위계정과목코드명 */    
    @ApiModelProperty(notes= "상위계정과목코드명")
    private String hrkAcsjCdNm     ;  /* 상위계정과목코드명 */    
    @ApiModelProperty(notes= "전표일자")
    private String spDt            ;  /* 전표일자 */              
    @ApiModelProperty(notes= "결의상세번호")
    private BigDecimal rslnDlNo    ;  /* 결의상세번호 */          
    @ApiModelProperty(notes= "결의구분코드")
    private String rslnTcd         ;  /*  결의구분코드  */        
    @ApiModelProperty(notes= "발생계정과목코드")
    private String occrAcsjCd      ;  /* 발생계정과목코드 */      
    @ApiModelProperty(notes= "예산사용구분코드")
    private String bdgtUseTcd      ;  /* 예산사용구분코드 */      
    @ApiModelProperty(notes= "예산조직코드")
    private String bdgtOrzCd       ;  /* 예산조직코드 */          
    @ApiModelProperty(notes= "예산년월")
    private String bdgtYm          ;  /* 예산년월 */              
    @ApiModelProperty(notes= "사용일련번호")
    private BigDecimal useSrno     ;  /* 사용일련번호 */          
	@ApiModelProperty(notes= "순번", example="0")
	private BigDecimal rnum       ; /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수             */        


    @Override
    public String toString() {
        return "Main00VO{" +
                "rslnOrzCd     ='" + rslnOrzCd    + "'" +
                "dcsTmpCdn     ='" + dcsTmpCdn    + "'" +
                "rslnDt        ='" + rslnDt       + "'" +
                "rslnSrno      ='" + rslnSrno     + "'" +
                "dcsNo         ='" + dcsNo        + "'" +
                "bdgtAcsjCd    ='" + bdgtAcsjCd   + "'" +
                "bdgtAcsjCdNm  ='" + bdgtAcsjCdNm + "'" +
                "oppAcsjCd     ='" + oppAcsjCd    + "'" +
                "oppAcSbjCdn   ='" + oppAcSbjCdn  + "'" +
                "dlSmryCn      ='" + dlSmryCn     + "'" +
                "rslnUseA      ='" + rslnUseA     + "'" +
                "delpCd        ='" + delpCd       + "'" +
                "delpNm        ='" + delpNm       + "'" +
                "hrkAcsjCd     ='" + hrkAcsjCd    + "'" +
                "hrkAcsjCdNm   ='" + hrkAcsjCdNm  + "'" +
                "spDt          ='" + spDt         + "'" +
                "rslnDlNo      ='" + rslnDlNo     + "'" +
                "rslnTcd       ='" + rslnTcd      + "'" +
                "occrAcsjCd    ='" + occrAcsjCd   + "'" +
                "bdgtUseTcd    ='" + bdgtUseTcd   + "'" +
                "bdgtOrzCd     ='" + bdgtOrzCd    + "'" +
                "bdgtYm        ='" + bdgtYm       + "'" +
                "useSrno       ='" + useSrno      + "'" +

                '}';
    }

	public String getRslnOrzCd() {
		return rslnOrzCd;
	}


	public void setRslnOrzCd(String rslnOrzCd) {
		this.rslnOrzCd = rslnOrzCd;
	}


	public String getDcsTmpCdn() {
		return dcsTmpCdn;
	}


	public void setDcsTmpCdn(String dcsTmpCdn) {
		this.dcsTmpCdn = dcsTmpCdn;
	}


	public String getRslnDt() {
		return rslnDt;
	}


	public void setRslnDt(String rslnDt) {
		this.rslnDt = rslnDt;
	}


	public BigDecimal getRslnSrno() {
		return rslnSrno;
	}


	public void setRslnSrno(BigDecimal rslnSrno) {
		this.rslnSrno = rslnSrno;
	}


	public BigDecimal getDcsNo() {
		return dcsNo;
	}


	public void setDcsNo(BigDecimal dcsNo) {
		this.dcsNo = dcsNo;
	}


	public String getBdgtAcsjCd() {
		return bdgtAcsjCd;
	}


	public void setBdgtAcsjCd(String bdgtAcsjCd) {
		this.bdgtAcsjCd = bdgtAcsjCd;
	}


	public String getBdgtAcsjCdNm() {
		return bdgtAcsjCdNm;
	}


	public void setBdgtAcsjCdNm(String bdgtAcsjCdNm) {
		this.bdgtAcsjCdNm = bdgtAcsjCdNm;
	}


	public String getOppAcsjCd() {
		return oppAcsjCd;
	}


	public void setOppAcsjCd(String oppAcsjCd) {
		this.oppAcsjCd = oppAcsjCd;
	}


	public String getOppAcSbjCdn() {
		return oppAcSbjCdn;
	}


	public void setOppAcSbjCdn(String oppAcSbjCdn) {
		this.oppAcSbjCdn = oppAcSbjCdn;
	}


	public String getDlSmryCn() {
		return dlSmryCn;
	}


	public void setDlSmryCn(String dlSmryCn) {
		this.dlSmryCn = dlSmryCn;
	}


	public BigDecimal getRslnUseA() {
		return rslnUseA;
	}


	public void setRslnUseA(BigDecimal rslnUseA) {
		this.rslnUseA = rslnUseA;
	}


	public String getDelpCd() {
		return delpCd;
	}


	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}


	public String getDelpNm() {
		return delpNm;
	}


	public void setDelpNm(String delpNm) {
		this.delpNm = delpNm;
	}


	public String getHrkAcsjCd() {
		return hrkAcsjCd;
	}


	public void setHrkAcsjCd(String hrkAcsjCd) {
		this.hrkAcsjCd = hrkAcsjCd;
	}


	public String getHrkAcsjCdNm() {
		return hrkAcsjCdNm;
	}


	public void setHrkAcsjCdNm(String hrkAcsjCdNm) {
		this.hrkAcsjCdNm = hrkAcsjCdNm;
	}


	public String getSpDt() {
		return spDt;
	}


	public void setSpDt(String spDt) {
		this.spDt = spDt;
	}


	public BigDecimal getRslnDlNo() {
		return rslnDlNo;
	}


	public void setRslnDlNo(BigDecimal rslnDlNo) {
		this.rslnDlNo = rslnDlNo;
	}


	public String getRslnTcd() {
		return rslnTcd;
	}


	public void setRslnTcd(String rslnTcd) {
		this.rslnTcd = rslnTcd;
	}


	public String getOccrAcsjCd() {
		return occrAcsjCd;
	}


	public void setOccrAcsjCd(String occrAcsjCd) {
		this.occrAcsjCd = occrAcsjCd;
	}


	public String getBdgtUseTcd() {
		return bdgtUseTcd;
	}


	public void setBdgtUseTcd(String bdgtUseTcd) {
		this.bdgtUseTcd = bdgtUseTcd;
	}


	public String getBdgtOrzCd() {
		return bdgtOrzCd;
	}


	public void setBdgtOrzCd(String bdgtOrzCd) {
		this.bdgtOrzCd = bdgtOrzCd;
	}


	public String getBdgtYm() {
		return bdgtYm;
	}


	public void setBdgtYm(String bdgtYm) {
		this.bdgtYm = bdgtYm;
	}


	public BigDecimal getUseSrno() {
		return useSrno;
	}


	public void setUseSrno(BigDecimal useSrno) {
		this.useSrno = useSrno;
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
