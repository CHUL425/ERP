package com.miraeasset.biz.rq.cr.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQCR1000U02VO extends BaseVO {
	
	@ApiModelProperty(notes = "접수번호")
	private String rctNo; /* 접수번호 */
	
	@ApiModelProperty(notes = "공사조직코드")
	private String pbcoOrzCd; /* 공사조직코드 */
	
	@ApiModelProperty(notes = "공사위치명")
	private String pbcoLocNm; /* 공사위치명 */
	
	@ApiModelProperty(notes = "공사상세위치명")
	private String pbcoDlLocNm; /* 공사상세위치명 */
	
	@ApiModelProperty(notes= "파일번호")
    private String fileNo		   ; /* 파일번호 2023.09.11 */
	
	@ApiModelProperty(notes= "조작자ID")
    private String optrId         ;    /* 조작자ID */
    @ApiModelProperty(notes= "조작채널코드")
    private String oprtChnlCd     ;    /* 조작채널코드 */
    @ApiModelProperty(notes= "조작조직코드")
    private String oprtOrzCd      ;    /* 조작조직코드 */
    @ApiModelProperty(notes= "조작IP주소")
    private String oprtIpAdr      ;    /* 조작IP주소 */
    
	public String getRctNo() {
		return rctNo;
	}
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	public String getPbcoOrzCd() {
		return pbcoOrzCd;
	}
	public void setPbcoOrzCd(String pbcoOrzCd) {
		this.pbcoOrzCd = pbcoOrzCd;
	}
	public String getPbcoLocNm() {
		return pbcoLocNm;
	}
	public void setPbcoLocNm(String pbcoLocNm) {
		this.pbcoLocNm = pbcoLocNm;
	}
	public String getPbcoDlLocNm() {
		return pbcoDlLocNm;
	}
	public void setPbcoDlLocNm(String pbcoDlLocNm) {
		this.pbcoDlLocNm = pbcoDlLocNm;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getOptrId() {
		return optrId;
	}
	public void setOptrId(String optrId) {
		this.optrId = optrId;
	}
	public String getOprtChnlCd() {
		return oprtChnlCd;
	}
	public void setOprtChnlCd(String oprtChnlCd) {
		this.oprtChnlCd = oprtChnlCd;
	}
	public String getOprtOrzCd() {
		return oprtOrzCd;
	}
	public void setOprtOrzCd(String oprtOrzCd) {
		this.oprtOrzCd = oprtOrzCd;
	}
	public String getOprtIpAdr() {
		return oprtIpAdr;
	}
	public void setOprtIpAdr(String oprtIpAdr) {
		this.oprtIpAdr = oprtIpAdr;
	}
	
}
