/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA09N607VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA09N607	결재정보상세 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.login.vo.LoginOutVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N607aprvVO {
	
	@ApiModelProperty(notes= "접수번호", required = true, example = "디폴트 조회시 필수 InputIO - 임시저장일경우")
    private String rctNo              ; /*접수번호*/
	
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	
	private String aprvWrrptMtNo; /* 결재상신관리번호 */
	
	public String getAprvWrrptMtNo() {
		return aprvWrrptMtNo;
	}
	public void setAprvWrrptMtNo(String aprvWrrptMtNo) {
		this.aprvWrrptMtNo = aprvWrrptMtNo;
	}

	@ApiModelProperty(notes= "통합신청유형코드", example = "디폴트 조회시 필수 InputIO")
	private String unifRqsPcd; /* 통합신청유형코드  */
	
	public String getUnifRqsPcd() {
		return unifRqsPcd;
	}
	public void setUnifRqsPcd(String unifRqsPcd) {
		this.unifRqsPcd = unifRqsPcd;
	}
	
	@ApiModelProperty(notes= "통합신청구분코드", example = "디폴트 조회시 필수 InputIO")
	private String unifRqsTcd; /* 통합신청구분코드  */
	
	public String getUnifRqsTcd() {
		return unifRqsTcd;
	}
	public void setUnifRqsTcd(String unifRqsTcd) {
		this.unifRqsTcd = unifRqsTcd;
	}

	@ApiModelProperty(notes= "사용인감계여부", example = "디폴트 인감날인 조회시 필수 InputIO")
	private String useSealYn; /* 사용인감계여부 */
	
	public String getUseSealYn() {
		return useSealYn;
	}
	public void setUseSealYn(String useSealYn) {
		this.useSealYn = useSealYn;
	}

	private String epno;
	private String blngOrzCd;
	private String hobrTcd;
	
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getBlngOrzCd() {
		return blngOrzCd;
	}
	public void setBlngOrzCd(String blngOrzCd) {
		this.blngOrzCd = blngOrzCd;
	}
	public String getHobrTcd() {
		return hobrTcd;
	}
	public void setHobrTcd(String hobrTcd) {
		this.hobrTcd = hobrTcd;
	}

	
	@ApiModelProperty(notes= "결재선 관리번호", hidden = true)
	private String aprvlMtNo;
	
	@ApiModelProperty(notes= "결재순위", required = true, example = "InputIO - 참조자일경우 90부터")
	private String aprvRnk        ; /*결재순위          */
	
	@ApiModelProperty(notes= "결재상신조직코드", example = "InputIO")
    private String aprvWrrptOrzCd ; /*결재상신조직코드  */
	@ApiModelProperty(notes= "결재상신조직명")
	private String aprvWrrptOrzNm ; /*결재상신조직명  */
	
	@ApiModelProperty(notes= "결재상신구분코드", example = "InputIO")
    private String aprvWrrptTcd   ; /*결재상신구분코드  */
    @ApiModelProperty(notes= "결재상신구분명")
    private String aprvWrrptTcdNm   ; /*결재상신구분명  */
    
    @ApiModelProperty(notes= "결재반려구분코드", example = "InputIO - 작성자만 1로 셋팅 그외 null")
    private String aprvRtrnTcd    ; /*결재반려구분코드  */
    @ApiModelProperty(notes= "결재반려구분명")
    private String aprvRtrnTcdNm  ; /*결재반려구분명  */
    
    @ApiModelProperty(notes= "결재자유형코드", example = "InputIO - 00:상신, 01:결재, 02:참조")
    private String dcfcPcd        ; /*결재자유형코드    */
    @ApiModelProperty(notes= "결재자유형코드명")
    private String dcfcPcdNm      ; /*결재자유형코드명    */
    
    @ApiModelProperty(notes= "결재단위구분코드", example = "InputIO시 90고정")
    private String aprvUnitTcd	  ; /* 결재단위구분코드 */
    @ApiModelProperty(notes= "결재단위구분명")
    private String aprvUnitTcdNm	  ; /* 결재단위구분명 */
    
    @ApiModelProperty(notes= "결재단위그룹코드", example = "InputIO")
	private String aprvUnitGrpCd    ; /* 결재단위그룹코드    */
    @ApiModelProperty(notes= "결재단위인사직책명")
    private String aprvUnitGrpNm	  ; /* 결재단위인사직책명 */
    
    @ApiModelProperty(notes= "결재단위인사직책코드", example = "InputIO")
    private String aprvUnitHrOsdtCd ; /* 결재단위인사직책코드 */
    
	@ApiModelProperty(notes= "결재단위상세값")
	private String aprvUnitDlVl     ; /* 결재단위상세값      */
	
	@ApiModelProperty(notes= "결재조직코드", example = "InputIO")
	private String aprvOrzCd      ; /*결재조직코드      */
	@ApiModelProperty(notes= "결재조직명")
    private String aprvOrzNm	  ; /* 결재조직명 */
	
	@ApiModelProperty(notes= "결재사원번호", example = "InputIO")
	private String aprvEpno       ; /*결재사원번호      */
	
	@ApiModelProperty(notes= "결재사원명")
	private String aprvOrzOsdtCdEpnm;
	
	@ApiModelProperty(notes= "결재사원직책명")
	private String aprvOrzOsdtCdNm;

	public String getAprvlMtNo() {
		return aprvlMtNo;
	}
	public void setAprvlMtNo(String aprvlMtNo) {
		this.aprvlMtNo = aprvlMtNo;
	}
	public String getAprvRnk() {
		return aprvRnk;
	}
	public void setAprvRnk(String aprvRnk) {
		this.aprvRnk = aprvRnk;
	}
	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}
	public void setAprvWrrptOrzCd(String aprvWrrptOrzCd) {
		this.aprvWrrptOrzCd = aprvWrrptOrzCd;
	}
	public String getAprvWrrptOrzNm() {
		return aprvWrrptOrzNm;
	}
	public void setAprvWrrptOrzNm(String aprvWrrptOrzNm) {
		this.aprvWrrptOrzNm = aprvWrrptOrzNm;
	}
	public String getAprvWrrptTcd() {
		return aprvWrrptTcd;
	}
	public void setAprvWrrptTcd(String aprvWrrptTcd) {
		this.aprvWrrptTcd = aprvWrrptTcd;
	}
	public String getAprvWrrptTcdNm() {
		return aprvWrrptTcdNm;
	}
	public void setAprvWrrptTcdNm(String aprvWrrptTcdNm) {
		this.aprvWrrptTcdNm = aprvWrrptTcdNm;
	}
	public String getAprvRtrnTcd() {
		return aprvRtrnTcd;
	}
	public void setAprvRtrnTcd(String aprvRtrnTcd) {
		this.aprvRtrnTcd = aprvRtrnTcd;
	}
	public String getAprvRtrnTcdNm() {
		return aprvRtrnTcdNm;
	}
	public void setAprvRtrnTcdNm(String aprvRtrnTcdNm) {
		this.aprvRtrnTcdNm = aprvRtrnTcdNm;
	}
	public String getDcfcPcd() {
		return dcfcPcd;
	}
	public void setDcfcPcd(String dcfcPcd) {
		this.dcfcPcd = dcfcPcd;
	}
	public String getDcfcPcdNm() {
		return dcfcPcdNm;
	}
	public void setDcfcPcdNm(String dcfcPcdNm) {
		this.dcfcPcdNm = dcfcPcdNm;
	}
	public String getAprvUnitTcd() {
		return aprvUnitTcd;
	}
	public void setAprvUnitTcd(String aprvUnitTcd) {
		this.aprvUnitTcd = aprvUnitTcd;
	}
	public String getAprvUnitTcdNm() {
		return aprvUnitTcdNm;
	}
	public void setAprvUnitTcdNm(String aprvUnitTcdNm) {
		this.aprvUnitTcdNm = aprvUnitTcdNm;
	}
	public String getAprvUnitGrpCd() {
		return aprvUnitGrpCd;
	}
	public void setAprvUnitGrpCd(String aprvUnitGrpCd) {
		this.aprvUnitGrpCd = aprvUnitGrpCd;
	}
	public String getAprvUnitGrpNm() {
		return aprvUnitGrpNm;
	}
	public void setAprvUnitGrpNm(String aprvUnitGrpNm) {
		this.aprvUnitGrpNm = aprvUnitGrpNm;
	}
	public String getAprvUnitHrOsdtCd() {
		return aprvUnitHrOsdtCd;
	}
	public void setAprvUnitHrOsdtCd(String aprvUnitHrOsdtCd) {
		this.aprvUnitHrOsdtCd = aprvUnitHrOsdtCd;
	}
	public String getAprvUnitDlVl() {
		return aprvUnitDlVl;
	}
	public void setAprvUnitDlVl(String aprvUnitDlVl) {
		this.aprvUnitDlVl = aprvUnitDlVl;
	}
	public String getAprvOrzCd() {
		return aprvOrzCd;
	}
	public void setAprvOrzCd(String aprvOrzCd) {
		this.aprvOrzCd = aprvOrzCd;
	}
	public String getAprvOrzNm() {
		return aprvOrzNm;
	}
	public void setAprvOrzNm(String aprvOrzNm) {
		this.aprvOrzNm = aprvOrzNm;
	}
	public String getAprvEpno() {
		return aprvEpno;
	}
	public void setAprvEpno(String aprvEpno) {
		this.aprvEpno = aprvEpno;
	}
	public String getAprvOrzOsdtCdEpnm() {
		return aprvOrzOsdtCdEpnm;
	}
	public void setAprvOrzOsdtCdEpnm(String aprvOrzOsdtCdEpnm) {
		this.aprvOrzOsdtCdEpnm = aprvOrzOsdtCdEpnm;
	}
	public String getAprvOrzOsdtCdNm() {
		return aprvOrzOsdtCdNm;
	}
	public void setAprvOrzOsdtCdNm(String aprvOrzOsdtCdNm) {
		this.aprvOrzOsdtCdNm = aprvOrzOsdtCdNm;
	}
	
}
