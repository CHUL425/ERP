package com.miraeasset.biz.ga.rm.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GARM1000ExcelVO extends BaseVO {
	
	@ExcelColumnInfo(notes= "정산년월")
    @ApiModelProperty(notes= "정산년월")
    private String exccYm         ;    /* 정산년월 */

	@ExcelColumnInfo(notes= "장비구분코드")
    @ApiModelProperty(notes= "장비구분코드")
    private String eqmtTcd        ;    /* 장비구분코드 */
    
	@ExcelColumnInfo(notes= "관리업체코드")
    @ApiModelProperty(notes= "관리업체코드")
    private String delpCd         ;    /* 거래처코드 */
    
	@ExcelColumnInfo(notes= "조직코드")
    @ApiModelProperty(notes= "조직코드")
	private String mtOrzCd        ;    /* 조직코드 */
	
	@ExcelColumnInfo(notes= "계약번호")
	@ApiModelProperty(notes= "계약번호")
    private String rentCntcNo     ;    /* 임대계약번호 */
    
	@ExcelColumnInfo(notes= "제품명")
	@ApiModelProperty(notes= "제품명")
    private String gdsNm          ;    /* 제품명 */
	
	@ExcelColumnInfo(notes= "렌탈료")
    @ApiModelProperty(notes= "렌탈료")
    private String mlyRentc       ;    /* 월간임대료 */

	@ExcelColumnInfo(notes= "설치일자")
    @ApiModelProperty(notes= "설치일자")
    private String istDt          ;    /* 설치일자 */
    
	@ExcelColumnInfo(notes= "의무사용일자")
    @ApiModelProperty(notes= "의무사용일자")
    private String dutyUseDt      ;    /* 의무사용일자 */
    
	@ExcelColumnInfo(notes= "설치주소")
    @ApiModelProperty(notes= "설치주소")
    private String istPlcNm       ;    /* 설치장소명 */
    
	@ExcelColumnInfo(notes= "상세위치")
    @ApiModelProperty(notes= "상세위치")
    private String istPlcDlNm     ;    /* 설치장소상세명 */

	public String getExccYm() {
		return exccYm;
	}

	public void setExccYm(String exccYm) {
		this.exccYm = exccYm;
	}

	public String getEqmtTcd() {
		return eqmtTcd;
	}

	public void setEqmtTcd(String eqmtTcd) {
		this.eqmtTcd = eqmtTcd;
	}

	public String getDelpCd() {
		return delpCd;
	}

	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}

	public String getMtOrzCd() {
		return mtOrzCd;
	}

	public void setMtOrzCd(String mtOrzCd) {
		this.mtOrzCd = mtOrzCd;
	}

	public String getRentCntcNo() {
		return rentCntcNo;
	}

	public void setRentCntcNo(String rentCntcNo) {
		this.rentCntcNo = rentCntcNo;
	}

	public String getGdsNm() {
		return gdsNm;
	}

	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}

	public String getMlyRentc() {
		return mlyRentc;
	}

	public void setMlyRentc(String mlyRentc) {
		this.mlyRentc = mlyRentc;
	}

	public String getIstDt() {
		return istDt;
	}

	public void setIstDt(String istDt) {
		this.istDt = istDt;
	}

	public String getDutyUseDt() {
		return dutyUseDt;
	}

	public void setDutyUseDt(String dutyUseDt) {
		this.dutyUseDt = dutyUseDt;
	}

	public String getIstPlcNm() {
		return istPlcNm;
	}

	public void setIstPlcNm(String istPlcNm) {
		this.istPlcNm = istPlcNm;
	}

	public String getIstPlcDlNm() {
		return istPlcDlNm;
	}

	public void setIstPlcDlNm(String istPlcDlNm) {
		this.istPlcDlNm = istPlcDlNm;
	}
    
}
