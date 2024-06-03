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

import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N607VO extends BaseVO {
	
	@ApiModelProperty(notes= "상신관리번호")
	private String aprvWrrptMtNoOut;
	
	public String getAprvWrrptMtNoOut() {
		return aprvWrrptMtNoOut;
	}
	public void setAprvWrrptMtNoOut(String aprvWrrptMtNoOut) {
		this.aprvWrrptMtNoOut = aprvWrrptMtNoOut;
	}
	
	@ApiModelProperty(notes = "포털사이트메뉴ID ")
	private String psitMenuId; /* 포털사이트메뉴ID  */
	
	public String getPsitMenuId() {
		return psitMenuId;
	}
	public void setPsitMenuId(String psitMenuId) {
		this.psitMenuId = psitMenuId;
	}

	@ApiModelProperty(notes= "신청상태코드")
	private String rqsScd;
	
	public String getRqsScd() {
		return rqsScd;
	}
	public void setRqsScd(String rqsScd) {
		this.rqsScd = rqsScd;
	}


	@ApiModelProperty(notes= "결재선관리번호 ")
	private String aprvMtNo           ; /*결재선관리번호   */
	
    public String getAprvMtNo() {
		return aprvMtNo;
	}
	public void setAprvMtNo(String aprvMtNo) {
		this.aprvMtNo = aprvMtNo;
	}
	
	
	@ApiModelProperty(notes= "결재상태코드")
    private String aprvScd            ; /*결재상태코드  */
    @ApiModelProperty(notes= "상신사원번호")
    private String wrrptEpno          ; /*상신사원번호  */
    @ApiModelProperty(notes= "상신일자")
    private String wrrptDt            ; /*상신일자      */
    @ApiModelProperty(notes= "결재유형코드")
    private String aprvPcd            ; /*결재유형코드  */

    public String getAprvScd() {
		return aprvScd;
	}

	public void setAprvScd(String aprvScd) {
		this.aprvScd = aprvScd;
	}

	public String getWrrptEpno() {
		return wrrptEpno;
	}

	public void setWrrptEpno(String wrrptEpno) {
		this.wrrptEpno = wrrptEpno;
	}

	public String getWrrptDt() {
		return wrrptDt;
	}

	public void setWrrptDt(String wrrptDt) {
		this.wrrptDt = wrrptDt;
	}

	public String getAprvPcd() {
		return aprvPcd;
	}

	public void setAprvPcd(String aprvPcd) {
		this.aprvPcd = aprvPcd;
	}
	

	@ApiModelProperty(notes= "결재상신관리번호", required = true)
    private String aprvWrrptMtNo        ; /*결재상신관리번호  */
    @ApiModelProperty(notes= "결재상신조직코드", required = true)
    private String aprvWrrptOrzCd ; /*결재상신조직코드  */
    @ApiModelProperty(notes= "결재순위", required = true)
    private String aprvRnk        ; /*결재순위          */
    @ApiModelProperty(notes= "결재상세순위", required = true)
    private String aprvDlRnk      ; /*결재상세순위      */
    @ApiModelProperty(notes= "결재상신구분코드")
    private String aprvWrrptTcd   ; /*결재상신구분코드  */
    @ApiModelProperty(notes= "결재상신구분코드명")
    private String aprvWrrptTcdNm   ; /*결재상신구분코드명  */

    
    @ApiModelProperty(notes= "결재반려구분코드")
    private String aprvRtrnTcd    ; /*결재반려구분코드  */
    @ApiModelProperty(notes= "결재반려구분코드")
    private String aprvRtrnTcdNm  ; /*결재반려구분코드명  */

    
    @ApiModelProperty(notes= "결재자유형코드")
    private String dcfcPcd        ; /*결재자유형코드    */
    @ApiModelProperty(notes= "결재자유형코드명")
    private String dcfcPcdNm      ; /*결재자유형코드명    */
    
    /* 2023.08.21 추가 */
    @ApiModelProperty(notes= "결재단위구분코드")
    private String aprvUnitTcd	  ; /* 결재단위구분코드 */
    @ApiModelProperty(notes= "결재단위인사직책코드")
    private String aprvUnitHrOsdtCd ; /* 결재단위인사직책코드 */
    @ApiModelProperty(notes= "결재단위그룹코드")
	private String aprvUnitGrpCd    ; /* 결재단위그룹코드    */
	@ApiModelProperty(notes= "결재단위상세값")
	private String aprvUnitDlVl     ; /* 결재단위상세값      */
    
    @ApiModelProperty(notes= "결재조직코드")
    private String aprvOrzCd      ; /*결재조직코드      */
    @ApiModelProperty(notes= "결재사원번호")
    private String aprvEpno       ; /*결재사원번호      */
    @ApiModelProperty(notes= "결재일시")
    private String aprvDttm       ; /*결재일시          */
    @ApiModelProperty(notes= "결재사유내용")
    private String aprvRsnCn      ; /*결재사유내용      */
    @ApiModelProperty(notes= "대결여부")
    private String sbapYn         ; /*대결여부          */
    @ApiModelProperty(notes= "대결사원번호")
    private String sbapEpno       ; /*대결사원번호      */
    @ApiModelProperty(notes= "대결확인여부")
    private String sbapCfmtYn     ; /*대결확인여부      */
//    @ApiModelProperty(notes= "조작자ID")
//    private String optrId         ; /*조작자ID          */
//    @ApiModelProperty(notes= "조작채널코드")
//    private String oprtChnlCd     ; /*조작채널코드      */
//    @ApiModelProperty(notes= "조작조직코드")
//    private String oprtOrzCd      ; /*조작조직코드      */
//    @ApiModelProperty(notes= "조작IP주소")
//    private String oprtIpAdr      ; /*조작IP주소        */
//    @ApiModelProperty(notes= "조작일시")
//    private String oprtDttm       ; /*조작일시          */
    
    @ApiModelProperty(notes= "접수번호")
    private String rctNo              ; /*접수번호*/                 

	@ApiModelProperty(notes= "신청구분코드 신규/이전/AS ")
    private String unifRqsTcd        ; // 신청구분코드 
	@ApiModelProperty(notes= "신청구분코드명 ")
    private String unifRqsTcdNm      ; // 신청구분코드명     

    @ApiModelProperty(notes= "신청유형코드 공사/구매/렌탈...")
    private String unifRqsPcd        ; /*신청유형코드    */
    @ApiModelProperty(notes= "신청유형코드명")
    private String unifRqsPcdNm      ; /*신청유형코드명    */

    @ApiModelProperty(notes= "신청상세유형코드")
    private String unifRqsDlPcd     ; /*신청상세유형코드    */
    @ApiModelProperty(notes= "신청상세유형코드명")
    private String unifRqsDlPcdNm   ; /*신청상세유형코드명    */
    
    @ApiModelProperty(notes= "신청제목명")
    private String rqsTtlNm           ; /*신청제목명*/
    @ApiModelProperty(notes= "신청사유내용")
    private String rqsRsnCn           ; /*신청사유내용*/
    @ApiModelProperty(notes= "설치장소명")
    private String istPlcNm           ; /*설치장소명*/
    @ApiModelProperty(notes= "신청사원번호")
    private String rqsEpno            ; /*신청사원번호*/
    @ApiModelProperty(notes= "신청사원명")
    private String rqsEpNm            ; /*신청사원명*/
    @ApiModelProperty(notes= "신청직급")
    private String rqsHrPstNm         ; /*신청직급*/
    @ApiModelProperty(notes= "신청일자")
    private String rqsDt              ; /*신청일자*/
    @ApiModelProperty(notes= "희망일자")
    private String hopeDt             ; /*희망일자*/
    @ApiModelProperty(notes= "완료일자")
    private String cmpnDt             ; /*완료일자*/
    
    @Override
    public String toString() {
        return "GA09N607VO{" +
        		"aprvWrrptMtNo      ='" + aprvWrrptMtNo    + "'" +
        		"aprvWrrptOrzCd     ='" + aprvWrrptOrzCd   + "'" +
        		"aprvRnk            ='" + aprvRnk          + "'" +
        		"aprvDlRnk          ='" + aprvDlRnk        + "'" +
        		"dcfcPcd            ='" + dcfcPcd          + "'" +
        		
                '}';    	
    }

	public String getAprvWrrptMtNo() {
		return aprvWrrptMtNo;
	}

	public void setAprvWrrptMtNo(String aprvWrrptMtNo) {
		this.aprvWrrptMtNo = aprvWrrptMtNo;
	}

	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}

	public void setAprvWrrptOrzCd(String aprvWrrptOrzCd) {
		this.aprvWrrptOrzCd = aprvWrrptOrzCd;
	}

	public String getAprvRnk() {
		return aprvRnk;
	}

	public void setAprvRnk(String aprvRnk) {
		this.aprvRnk = aprvRnk;
	}

	public String getAprvDlRnk() {
		return aprvDlRnk;
	}

	public void setAprvDlRnk(String aprvDlRnk) {
		this.aprvDlRnk = aprvDlRnk;
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

	public String getAprvUnitHrOsdtCd() {
		return aprvUnitHrOsdtCd;
	}

	public void setAprvUnitHrOsdtCd(String aprvUnitHrOsdtCd) {
		this.aprvUnitHrOsdtCd = aprvUnitHrOsdtCd;
	}

	public String getAprvUnitGrpCd() {
		return aprvUnitGrpCd;
	}

	public void setAprvUnitGrpCd(String aprvUnitGrpCd) {
		this.aprvUnitGrpCd = aprvUnitGrpCd;
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

	public String getAprvEpno() {
		return aprvEpno;
	}

	public void setAprvEpno(String aprvEpno) {
		this.aprvEpno = aprvEpno;
	}

	public String getAprvDttm() {
		return aprvDttm;
	}

	public void setAprvDttm(String aprvDttm) {
		this.aprvDttm = aprvDttm;
	}

	public String getAprvRsnCn() {
		return aprvRsnCn;
	}

	public void setAprvRsnCn(String aprvRsnCn) {
		this.aprvRsnCn = aprvRsnCn;
	}

	public String getSbapYn() {
		return sbapYn;
	}

	public void setSbapYn(String sbapYn) {
		this.sbapYn = sbapYn;
	}

	public String getSbapEpno() {
		return sbapEpno;
	}

	public void setSbapEpno(String sbapEpno) {
		this.sbapEpno = sbapEpno;
	}

	public String getSbapCfmtYn() {
		return sbapCfmtYn;
	}

	public void setSbapCfmtYn(String sbapCfmtYn) {
		this.sbapCfmtYn = sbapCfmtYn;
	}

//	public String getOptrId() {
//		return optrId;
//	}
//
//	public void setOptrId(String optrId) {
//		this.optrId = optrId;
//	}
//
//	public String getOprtChnlCd() {
//		return oprtChnlCd;
//	}
//
//	public void setOprtChnlCd(String oprtChnlCd) {
//		this.oprtChnlCd = oprtChnlCd;
//	}
//
//	public String getOprtOrzCd() {
//		return oprtOrzCd;
//	}
//
//	public void setOprtOrzCd(String oprtOrzCd) {
//		this.oprtOrzCd = oprtOrzCd;
//	}
//
//	public String getOprtIpAdr() {
//		return oprtIpAdr;
//	}
//
//	public void setOprtIpAdr(String oprtIpAdr) {
//		this.oprtIpAdr = oprtIpAdr;
//	}
//
//	public String getOprtDttm() {
//		return oprtDttm;
//	}
//
//	public void setOprtDttm(String oprtDttm) {
//		this.oprtDttm = oprtDttm;
//	}

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
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

	public String getRqsTtlNm() {
		return rqsTtlNm;
	}

	public void setRqsTtlNm(String rqsTtlNm) {
		this.rqsTtlNm = rqsTtlNm;
	}

	public String getRqsRsnCn() {
		return rqsRsnCn;
	}

	public void setRqsRsnCn(String rqsRsnCn) {
		this.rqsRsnCn = rqsRsnCn;
	}

	public String getIstPlcNm() {
		return istPlcNm;
	}

	public void setIstPlcNm(String istPlcNm) {
		this.istPlcNm = istPlcNm;
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

	public String getRqsHrPstNm() {
		return rqsHrPstNm;
	}

	public void setRqsHrPstNm(String rqsHrPstNm) {
		this.rqsHrPstNm = rqsHrPstNm;
	}

	public String getRqsDt() {
		return rqsDt;
	}

	public void setRqsDt(String rqsDt) {
		this.rqsDt = rqsDt;
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

}
