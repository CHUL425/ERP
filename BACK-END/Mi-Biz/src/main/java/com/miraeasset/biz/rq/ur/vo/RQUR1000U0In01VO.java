package com.miraeasset.biz.rq.ur.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.meta.vo.AprvWrrptInVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQUR1000U0In01VO {

	@ApiModelProperty(notes= "처리구분: 00-임시저장 01-상신 ", required = true,example = "00")
	private String prcTp           ; /*처리구분         */
	@ApiModelProperty(notes= "접수번호")
	private String rctNo           ; /*접수번호         */
	
	@ApiModelProperty(notes= "신청유형코드 공사/구매/렌탈")
	private String unifRqsPcd          ; /*신청유형코드     */

	@ApiModelProperty(notes= "신청상세유형코드 정수기외/복합기")
	private String unifRqsDlPcd       ; /*신청상세유형코드     */

	@ApiModelProperty(notes= "신청구분코드 신규/이전/AS")
	private String unifRqsTcd          ; /*신청구분코드     */
	
	@ApiModelProperty(notes= "신청조직코드")
	private String rqsOrzCd        ; /*신청조직코드     */
	@ApiModelProperty(notes= "신청사원번호")
	private String rqsEpno         ; /*신청사원번호     */

	@ApiModelProperty(notes= "신청제목명")
	private String rqsTtlNm        ; /*신청제목명       */
	@ApiModelProperty(notes= "설치장소명")
	private String istPlcNm        ; /*설치장소명       */
	@ApiModelProperty(notes= "신청사유내용 ")
	private String rqsRsnCn        ; /*신청사유내용  */
	@ApiModelProperty(notes= "희망일자")
	private String hopeDt          ; /*희망일자         */

	@ApiModelProperty(notes= "신청상태코드")
	private String rqsScd          ; /*신청상태코드     */

	@ApiModelProperty(notes= "렌탈신청 제품정보")
    List<RQUR1000U0In11VO> grid12;    // 렌탈신청 제품정보
	
	/* 2023.09.12 결재선 리스트 */
	@ApiModelProperty(notes = "결재선리스트")
    List<AprvWrrptInVO> aprvl;
	
    public List<AprvWrrptInVO> getAprvl() {
		return aprvl;
	}

	public void setAprvl(List<AprvWrrptInVO> aprvl) {
		this.aprvl = aprvl;
	}

	@Override
    public String toString() {
        return "RQUR1000U0In01VO{" +
        		"prcTp          ='" + prcTp        + "'" +
        		"rctNo          ='" + rctNo        + "'" +
        		"unifRqsPcd          ='" + unifRqsPcd        + "'" +
        		"rqsTtlNm          ='" + rqsTtlNm        + "'" +
        		"istPlcNm          ='" + istPlcNm        + "'" +
        		"hopeDt          ='" + hopeDt        + "'" +
        		"rqsScd          ='" + rqsScd        + "'" +
                '}';    	
    }

	public String getPrcTp() {
		return prcTp;
	}

	public void setPrcTp(String prcTp) {
		this.prcTp = prcTp;
	}

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public String getUnifRqsPcd() {
		return unifRqsPcd;
	}

	public void setUnifRqsPcd(String unifRqsPcd) {
		this.unifRqsPcd = unifRqsPcd;
	}

	public String getUnifRqsDlPcd() {
		return unifRqsDlPcd;
	}

	public void setUnifRqsDlPcd(String unifRqsDlPcd) {
		this.unifRqsDlPcd = unifRqsDlPcd;
	}

	public String getUnifRqsTcd() {
		return unifRqsTcd;
	}

	public void setUnifRqsTcd(String unifRqsTcd) {
		this.unifRqsTcd = unifRqsTcd;
	}

	public String getRqsOrzCd() {
		return rqsOrzCd;
	}

	public void setRqsOrzCd(String rqsOrzCd) {
		this.rqsOrzCd = rqsOrzCd;
	}

	public String getRqsEpno() {
		return rqsEpno;
	}

	public void setRqsEpno(String rqsEpno) {
		this.rqsEpno = rqsEpno;
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

	public String getRqsScd() {
		return rqsScd;
	}

	public void setRqsScd(String rqsScd) {
		this.rqsScd = rqsScd;
	}

	public List<RQUR1000U0In11VO> getGrid12() {
		return grid12;
	}

	public void setGrid12(List<RQUR1000U0In11VO> grid12) {
		this.grid12 = grid12;
	}

    
}
