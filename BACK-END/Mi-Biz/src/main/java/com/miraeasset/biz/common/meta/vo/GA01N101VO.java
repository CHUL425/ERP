/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA01N101VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA01N101	신청관리 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA01N101VO extends BaseVO {
	
    @ApiModelProperty(notes= "접수번호")
    private String rctNo         ; // 접수번호
    @ApiModelProperty(notes= "신청일자")
    private String rqsDt         ; /*신청일자        */

	@ApiModelProperty(notes= "신청구분코드 신규/이전/AS ")
    private String unifRqsTcd        ; // 신청구분코드 
	@ApiModelProperty(notes= "신청구분코드명 ")
    private String unifRqsTcdNm      ; // 신청구분코드명     

    @ApiModelProperty(notes= "신청유형코드 공사/구매/렌탈...")
    private String unifRqsPcd        ; /*신청유형코드    */
    @ApiModelProperty(notes= "신청유형코드명")
    private String unifRqsPcdNm      ; /*신청유형코드명    */

    @ApiModelProperty(notes= "신청상세유형코드 정수기외/복합기")
    private String unifRqsDlPcd     ; /*신청상세유형코드    */
    @ApiModelProperty(notes= "신청상세유형코드명")
    private String unifRqsDlPcdNm   ; /*신청상세유형코드명    */
    
    @ApiModelProperty(notes= "신청조직코드")
    private String rqsOrzCd      ; /*신청조직코드    */
    @ApiModelProperty(notes= "신청조직명")
    private String rqsOrzNm      ; /*신청조직명    */
    @ApiModelProperty(notes= "신청사원번호")
    private String rqsEpno       ; /*신청사원번호    */
    @ApiModelProperty(notes= "신청사원명")
    private String rqsEpNm       ; /*신청사원명    */
	@ApiModelProperty(notes= "신청사원 직위명")
	private String hrPstNm       ; /*직위명*/   	
    @ApiModelProperty(notes= "신청제목명")
    private String rqsTtlNm      ; /*신청제목명      */
    @ApiModelProperty(notes= "설치장소명")
    private String istPlcNm      ; /*설치장소명      */
    @ApiModelProperty(notes= "신청사유내용 ")
    private String rqsRsnCn      ; /*신청사유내용 */
    @ApiModelProperty(notes= "희망일자")
    private String hopeDt        ; /*희망일자        */
    @ApiModelProperty(notes= "완료일자")
    private String cmpnDt        ; /*완료일자        */    
    @ApiModelProperty(notes= "결재상신관리번호")
    private String aprvWrrptMtNo   ; /*결재상신관리번호    */
    @ApiModelProperty(notes= "신청상태코드")
    private String rqsScd        ; /*신청상태코드    */
    @ApiModelProperty(notes= "신청상태코드명")
    private String rqsScdNm      ; /*신청상태코드명    */
    @ApiModelProperty(notes= "모바일용-사유")
    private String aprvRsnCn      ;
    @ApiModelProperty(notes= "모바일용-로그인사번")
    private String epno      ;
    
//    @ApiModelProperty(notes= "조작자ID")
//    private String optrId        ; /*조작자ID        */
//    @ApiModelProperty(notes= "조작채널코드")
//    private String oprtChnlCd    ; /*조작채널코드    */
//    @ApiModelProperty(notes= "조작조직코드")
//    private String oprtOrzCd     ; /*조작조직코드    */
//    @ApiModelProperty(notes= "조작IP주소")
//    private String oprtIpAdr     ; /*조작IP주소      */
    
    @ApiModelProperty(notes= "신청자휴대전화번호")
    private String rqsEpHndpTlno     ; /*신청자휴대전화번호 */
    
    @ApiModelProperty(notes= "접수상세번호", required = true)
    private String rctDlNo;          // 접수상세번호
    @ApiModelProperty(notes= "장비구분코드")
    private String eqmtTcd       ;  /*장비구분코드    */
    @ApiModelProperty(notes= "장비구분코드명")
    private String eqmtTcdNm     ;  /*장비구분코드명   */
    
    @ApiModelProperty(notes= "임대계약번호")
    private String rentCntcNo    ;  /*임대계약번호    */
    @ApiModelProperty(notes= "제품명")
    private String gdsNm         ;  /*제품명          */
    @ApiModelProperty(notes= "신청요청사항내용 ")
    private String rqsRqmPtcrCn  ;  /*신청요청사항내용   */

    
    @Override
    public String toString() {
        return "GA01N003VO{" +
        		"rctNo          ='" + rctNo        + "'" +
        		        		
        		"unifRqsPcd         ='" + unifRqsPcd       + "'" +
        		"unifRqsPcdNm       ='" + unifRqsPcdNm     + "'" +
        		"rqsOrzCd       ='" + rqsOrzCd     + "'" +
        		"rqsOrzNm       ='" + rqsOrzNm     + "'" +
        		"rqsEpno        ='" + rqsEpno      + "'" +
        		"rqsEpNm        ='" + rqsEpNm      + "'" +
        		"rqsTtlNm       ='" + rqsTtlNm     + "'" +
        		"istPlcNm       ='" + istPlcNm     + "'" +
        		"rqsRsnCn       ='" + rqsRsnCn     + "'" +
        		"hopeDt         ='" + hopeDt       + "'" +
        		"rqsDt          ='" + rqsDt        + "'" +
        		"cmpnDt         ='" + cmpnDt       + "'" +
        		"aprvWrrptMtNo  ='" + aprvWrrptMtNo  + "'" +
        		"rqsScd         ='" + rqsScd       + "'" +
        		"rqsScdNm       ='" + rqsScdNm     + "'" +
                '}';    	
    }


	public String getRctNo() {
		return rctNo;
	}


	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}


	public String getRqsDt() {
		return rqsDt;
	}


	public void setRqsDt(String rqsDt) {
		this.rqsDt = rqsDt;
	}


	public String getUnifRqsTcd() {
		return unifRqsTcd;
	}


	public void setUnifRqsTcd(String unifRqsTcd) {
		this.unifRqsTcd = unifRqsTcd;
	}


	public String getUnifRqsTcdNm() {
		return unifRqsTcdNm;
	}


	public void setUnifRqsTcdNm(String unifRqsTcdNm) {
		this.unifRqsTcdNm = unifRqsTcdNm;
	}


	public String getUnifRqsPcd() {
		return unifRqsPcd;
	}


	public void setUnifRqsPcd(String unifRqsPcd) {
		this.unifRqsPcd = unifRqsPcd;
	}


	public String getUnifRqsPcdNm() {
		return unifRqsPcdNm;
	}


	public void setUnifRqsPcdNm(String unifRqsPcdNm) {
		this.unifRqsPcdNm = unifRqsPcdNm;
	}


	public String getUnifRqsDlPcd() {
		return unifRqsDlPcd;
	}


	public void setUnifRqsDlPcd(String unifRqsDlPcd) {
		this.unifRqsDlPcd = unifRqsDlPcd;
	}


	public String getUnifRqsDlPcdNm() {
		return unifRqsDlPcdNm;
	}


	public void setUnifRqsDlPcdNm(String unifRqsDlPcdNm) {
		this.unifRqsDlPcdNm = unifRqsDlPcdNm;
	}


	public String getRqsOrzCd() {
		return rqsOrzCd;
	}


	public void setRqsOrzCd(String rqsOrzCd) {
		this.rqsOrzCd = rqsOrzCd;
	}


	public String getRqsOrzNm() {
		return rqsOrzNm;
	}


	public void setRqsOrzNm(String rqsOrzNm) {
		this.rqsOrzNm = rqsOrzNm;
	}


	public String getRqsEpno() {
		return rqsEpno;
	}


	public void setRqsEpno(String rqsEpno) {
		this.rqsEpno = rqsEpno;
	}


	public String getRqsEpNm() {
		return rqsEpNm;
	}


	public void setRqsEpNm(String rqsEpNm) {
		this.rqsEpNm = rqsEpNm;
	}


	public String getHrPstNm() {
		return hrPstNm;
	}


	public void setHrPstNm(String hrPstNm) {
		this.hrPstNm = hrPstNm;
	}


	public String getRqsTtlNm() {
		return rqsTtlNm;
	}


	public void setRqsTtlNm(String rqsTtlNm) {
		this.rqsTtlNm = rqsTtlNm;
	}


	public String getIstPlcNm() {
		return istPlcNm;
	}


	public void setIstPlcNm(String istPlcNm) {
		this.istPlcNm = istPlcNm;
	}


	public String getRqsRsnCn() {
		return rqsRsnCn;
	}


	public void setRqsRsnCn(String rqsRsnCn) {
		this.rqsRsnCn = rqsRsnCn;
	}


	public String getHopeDt() {
		return hopeDt;
	}


	public void setHopeDt(String hopeDt) {
		this.hopeDt = hopeDt;
	}


	public String getCmpnDt() {
		return cmpnDt;
	}


	public void setCmpnDt(String cmpnDt) {
		this.cmpnDt = cmpnDt;
	}


	public String getAprvWrrptMtNo() {
		return aprvWrrptMtNo;
	}


	public void setAprvWrrptMtNo(String aprvWrrptMtNo) {
		this.aprvWrrptMtNo = aprvWrrptMtNo;
	}


	public String getRqsScd() {
		return rqsScd;
	}


	public void setRqsScd(String rqsScd) {
		this.rqsScd = rqsScd;
	}


	public String getRqsScdNm() {
		return rqsScdNm;
	}


	public void setRqsScdNm(String rqsScdNm) {
		this.rqsScdNm = rqsScdNm;
	}


	public String getRqsEpHndpTlno() {
		return rqsEpHndpTlno;
	}


	public void setRqsEpHndpTlno(String rqsEpHndpTlno) {
		this.rqsEpHndpTlno = rqsEpHndpTlno;
	}


	public String getRctDlNo() {
		return rctDlNo;
	}


	public void setRctDlNo(String rctDlNo) {
		this.rctDlNo = rctDlNo;
	}


	public String getEqmtTcd() {
		return eqmtTcd;
	}


	public void setEqmtTcd(String eqmtTcd) {
		this.eqmtTcd = eqmtTcd;
	}


	public String getEqmtTcdNm() {
		return eqmtTcdNm;
	}


	public void setEqmtTcdNm(String eqmtTcdNm) {
		this.eqmtTcdNm = eqmtTcdNm;
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


	public String getRqsRqmPtcrCn() {
		return rqsRqmPtcrCn;
	}


	public void setRqsRqmPtcrCn(String rqsRqmPtcrCn) {
		this.rqsRqmPtcrCn = rqsRqmPtcrCn;
	}


	public String getAprvRsnCn() {
		return aprvRsnCn;
	}


	public void setAprvRsnCn(String aprvRsnCn) {
		this.aprvRsnCn = aprvRsnCn;
	}


	public String getEpno() {
		return epno;
	}


	public void setEpno(String epno) {
		this.epno = epno;
	}

}
