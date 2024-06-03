/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA01N304VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA01N304	계약서별계정과목코드 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA01N304VO extends BaseVO {
	
    
	@ApiModelProperty(notes= "계약서관리번호")
	private String cnrtMtNo        	; /*계약서관리번호 */	    
    
	@ApiModelProperty(notes= "계약서종류코드 ")
	private String cnrtKcd        	; /*계약서종류코드  */	    
	
    @ApiModelProperty(notes= "회계계정과목코드")
    private String actgAcsjCd     ; /*회계계정과목코드 */
    
    @ApiModelProperty(notes= "계정과목코드명")
    private String acsjCdNm       ; /*계정과목코드명 */

//    @ApiModelProperty(notes= "조작자ID ")
//    private String optrId            ; /*조작자ID                */
//    @ApiModelProperty(notes= "조작채널코드")
//    private String oprtChnlCd        ; /*조작채널코드            */
//    @ApiModelProperty(notes= "조작조직코드")
//    private String oprtOrzCd         ; /*조작조직코드            */
//    @ApiModelProperty(notes= "조작IP주소")
//    private String oprtIpAdr         ; /*조작IP주소              */
//    @ApiModelProperty(notes= "조작일시")
//    private String oprtDttm          ; /*조작일시                */    

    @Override
    public String toString() {
        return "GA01N304VO{" +
        		"cnrtMtNo    ='" + cnrtMtNo   + "'" +
        		"cnrtKcd     ='" + cnrtKcd    + "'" +
        		"actgAcsjCd  ='" + actgAcsjCd + "'" +
                '}';    	
    }

	public String getCnrtMtNo() {
		return cnrtMtNo;
	}

	public void setCnrtMtNo(String cnrtMtNo) {
		this.cnrtMtNo = cnrtMtNo;
	}

	public String getCnrtKcd() {
		return cnrtKcd;
	}

	public void setCnrtKcd(String cnrtKcd) {
		this.cnrtKcd = cnrtKcd;
	}

	public String getActgAcsjCd() {
		return actgAcsjCd;
	}

	public void setActgAcsjCd(String actgAcsjCd) {
		this.actgAcsjCd = actgAcsjCd;
	}

	public String getAcsjCdNm() {
		return acsjCdNm;
	}

	public void setAcsjCdNm(String acsjCdNm) {
		this.acsjCdNm = acsjCdNm;
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
		
}
