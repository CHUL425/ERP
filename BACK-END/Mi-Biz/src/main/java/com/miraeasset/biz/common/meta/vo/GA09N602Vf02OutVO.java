package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N602Vf02OutVO {
	
	@ApiModelProperty(notes= "결재선구분값2 ", hidden = true)
	private String aprvlTpVl2;
	
	public String getAprvlTpVl2() {
		return aprvlTpVl2;
	}
	public void setAprvlTpVl2(String aprvlTpVl2) {
		this.aprvlTpVl2 = aprvlTpVl2;
	}

	@ApiModelProperty(notes= "본지점구분", example = "01:본점, 02:지점")
	private String hobrTcd    		; /* 본지점구분 */
	@ApiModelProperty(notes= "본지점구분명")
	private String hobrTcdNm   		; /* 본지점구분명 */
	@ApiModelProperty(notes= "조직코드")
	private String orzCd    		; /* 조직코드 */
	@ApiModelProperty(notes= "조직명")
	private String orzNm    		; /* 조직명 */
	@ApiModelProperty(notes= "사원번호")
	private String epno        		; /* 사원번호 */
	@ApiModelProperty(notes= "사원명")
	private String epNm        		; /* 사원명 */
	@ApiModelProperty(notes= "인사직책코드")
	private String hrOsdtCd    		; /* 인사직책코드 */
	@ApiModelProperty(notes= "인사직책명")
	private String hrOsdtNm    		; /* 인사직책명 */
	@ApiModelProperty(notes= "업무담당여부")
	private String bzChprYn    		; /* 업무담당여부 */
	
	@ApiModelProperty(notes= "업무권한여부")
	private String bzAuthYn    		; /* 업무권한여부 */
	
	@ApiModelProperty(notes= "접수번호", hidden = true)
    private String rctNo              ; /*접수번호*/
	
	@ApiModelProperty(notes= "통합신청유형코드", hidden = true)
	private String unifRqsPcd; /* 통합신청유형코드  */
	
	@ApiModelProperty(notes= "통합신청구분코드", hidden = true)
	private String unifRqsTcd; /* 통합신청구분코드 */ 
	
	@ApiModelProperty(notes= "사용인감계여부", hidden = true)
	private String useSealYn; /* 사용인감계여부 */ 
	
	public String getUnifRqsPcd() {
		return unifRqsPcd;
	}
	public void setUnifRqsPcd(String unifRqsPcd) {
		this.unifRqsPcd = unifRqsPcd;
	}
	
	public String getUnifRqsTcd() {
		return unifRqsTcd;
	}
	public void setUnifRqsTcd(String unifRqsTcd) {
		this.unifRqsTcd = unifRqsTcd;
	}
	
	public String getUseSealYn() {
		return useSealYn;
	}
	public void setUseSealYn(String useSealYn) {
		this.useSealYn = useSealYn;
	}
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	
	
	@ApiModelProperty(notes= "결재선 관리번호", hidden = true)
	private String aprvlMtNo;
	
	public String getAprvlMtNo() {
		return aprvlMtNo;
	}
	public void setAprvlMtNo(String aprvlMtNo) {
		this.aprvlMtNo = aprvlMtNo;
	}
	
	public String getHobrTcd() {
		return hobrTcd;
	}
	public void setHobrTcd(String hobrTcd) {
		this.hobrTcd = hobrTcd;
	}
	public String getHobrTcdNm() {
		return hobrTcdNm;
	}
	public void setHobrTcdNm(String hobrTcdNm) {
		this.hobrTcdNm = hobrTcdNm;
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
	public String getEpno() {
		return epno;
	}
	public void setEpno(String epno) {
		this.epno = epno;
	}
	public String getEpNm() {
		return epNm;
	}
	public void setEpNm(String epNm) {
		this.epNm = epNm;
	}
	public String getHrOsdtCd() {
		return hrOsdtCd;
	}
	public void setHrOsdtCd(String hrOsdtCd) {
		this.hrOsdtCd = hrOsdtCd;
	}
	public String getHrOsdtNm() {
		return hrOsdtNm;
	}
	public void setHrOsdtNm(String hrOsdtNm) {
		this.hrOsdtNm = hrOsdtNm;
	}
	public String getBzChprYn() {
		return bzChprYn;
	}
	public void setBzChprYn(String bzChprYn) {
		this.bzChprYn = bzChprYn;
	}
	public String getBzAuthYn() {
		return bzAuthYn;
	}
	public void setBzAuthYn(String bzAuthYn) {
		this.bzAuthYn = bzAuthYn;
	}
	
}
