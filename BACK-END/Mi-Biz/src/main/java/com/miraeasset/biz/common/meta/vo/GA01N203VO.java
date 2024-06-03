/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA01N203VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA01N203 정기주차권관리 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA01N203VO extends BaseVO {
	
	@ApiModelProperty(notes= "건물명")
	private String blddNm    ; /*건물명 */      
	@ApiModelProperty(notes= "차량번호")
	private String vhcNo       ; /*차량번호 */
	
	@ApiModelProperty(notes= "유무료구분코드")
	private String chfTcd     ; /* 유무료구분코드 */		
	@ApiModelProperty(notes= "유무료구분코드명")
	private String chfTcdNm   ; /* 유무료구분코드명 */	
	
	@ApiModelProperty(notes= "차량유형코드")
	private String vhcPcd      ; /*차량유형코드 */       
	@ApiModelProperty(notes= "차량유형코드명")
	private String vhcPcdNm    ; /*차량유형코드명 */      
	@ApiModelProperty(notes= "사용자사원번호")
	private String userEpno    ; /*사용자사원번호 */       
	@ApiModelProperty(notes= "사용자사원명")
	private String userEpNm    ; /*사용자사원명 */
	@ApiModelProperty(notes= "사용자조직코드")
	private String userOrzCd   ; /*사용자조직코드 */      
	@ApiModelProperty(notes= "사용자조직명")
	private String userOrzNm   ; /*사용자조직명 */      
	@ApiModelProperty(notes= "인사직위명")
	private String hrPstNm     ; /*인사직위명*/      
	@ApiModelProperty(notes= "비고내용")
	private String nteCn       ; /*비고내용 */      
    

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
        return "GA01N203VO{" +
        		"vhcNo      ='" + vhcNo      + "'" +
        		"blddNm     ='" + blddNm     + "'" +
        		"chfTcd     ='" + chfTcd     + "'" +
        		"userEpno   ='" + userEpno   + "'" +
        		"userOrzCd  ='" + userOrzCd  + "'" +
        		"nteCn      ='" + nteCn      + "'" +
                '}';    	
    }


	public String getBlddNm() {
		return blddNm;
	}


	public void setBlddNm(String blddNm) {
		this.blddNm = blddNm;
	}


	public String getVhcNo() {
		return vhcNo;
	}


	public void setVhcNo(String vhcNo) {
		this.vhcNo = vhcNo;
	}


	public String getChfTcd() {
		return chfTcd;
	}


	public void setChfTcd(String chfTcd) {
		this.chfTcd = chfTcd;
	}


	public String getChfTcdNm() {
		return chfTcdNm;
	}


	public void setChfTcdNm(String chfTcdNm) {
		this.chfTcdNm = chfTcdNm;
	}


	public String getVhcPcd() {
		return vhcPcd;
	}


	public void setVhcPcd(String vhcPcd) {
		this.vhcPcd = vhcPcd;
	}


	public String getVhcPcdNm() {
		return vhcPcdNm;
	}


	public void setVhcPcdNm(String vhcPcdNm) {
		this.vhcPcdNm = vhcPcdNm;
	}


	public String getUserEpno() {
		return userEpno;
	}


	public void setUserEpno(String userEpno) {
		this.userEpno = userEpno;
	}


	public String getUserEpNm() {
		return userEpNm;
	}


	public void setUserEpNm(String userEpNm) {
		this.userEpNm = userEpNm;
	}


	public String getUserOrzCd() {
		return userOrzCd;
	}


	public void setUserOrzCd(String userOrzCd) {
		this.userOrzCd = userOrzCd;
	}


	public String getUserOrzNm() {
		return userOrzNm;
	}


	public void setUserOrzNm(String userOrzNm) {
		this.userOrzNm = userOrzNm;
	}


	public String getHrPstNm() {
		return hrPstNm;
	}


	public void setHrPstNm(String hrPstNm) {
		this.hrPstNm = hrPstNm;
	}


	public String getNteCn() {
		return nteCn;
	}


	public void setNteCn(String nteCn) {
		this.nteCn = nteCn;
	}


}
