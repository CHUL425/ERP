/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GASM1000U0In03VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: RE100계약관리 신규등록 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.sm.vo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.meta.vo.GA01N306VO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GASM1000U0In03VO {

	@ApiModelProperty(notes= "계약서관리번호 입력불가")
	private String cnrtMtNo        	; /*계약서관리번호 */

    @ApiModelProperty(notes= "거래처코드")
    private String delpCd           ; /*거래처코드              */

	@ApiModelProperty(notes= "계약용량")
	private BigDecimal cntcCapa     ; /*계약용량    */
	@ApiModelProperty(notes= "계약방법내용")
	private String cntcMthdCn   ; /*계약방법내용*/
	@ApiModelProperty(notes= "계약기준가")
	private BigDecimal cntcBpr      ; /*계약기준가  */
	@ApiModelProperty(notes= "계약시작일자")
	private String cntcStrtDt   ; /*계약시작일자*/
	@ApiModelProperty(notes= "계약종료일자")
	private String cntcEndDt    ; /*계약종료일자*/
	@ApiModelProperty(notes= "비고내용")
	private String nteCn        ; /*비고내용    */


    @ApiModelProperty(notes= "조작자ID ")
    private String optrId            ; /*조작자ID                */
    @ApiModelProperty(notes= "조작채널코드")
    private String oprtChnlCd        ; /*조작채널코드            */
    @ApiModelProperty(notes= "조작조직코드")
    private String oprtOrzCd         ; /*조작조직코드            */
    @ApiModelProperty(notes= "조작IP주소")
    private String oprtIpAdr         ; /*조작IP주소              */
    @ApiModelProperty(notes= "조작일시")
    private String oprtDttm          ; /*조작일시                */
    
	@ApiModelProperty(notes= "기안문서 다건내역")
    List<GA01N306VO> gridGA01N306;    // 기안문서 다건내역		    

	public String getCnrtMtNo() {
		return cnrtMtNo;
	}

	public void setCnrtMtNo(String cnrtMtNo) {
		this.cnrtMtNo = cnrtMtNo;
	}

	public String getDelpCd() {
		return delpCd;
	}

	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}

	public BigDecimal getCntcCapa() {
		return cntcCapa;
	}

	public void setCntcCapa(BigDecimal cntcCapa) {
		this.cntcCapa = cntcCapa;
	}

	public String getCntcMthdCn() {
		return cntcMthdCn;
	}

	public void setCntcMthdCn(String cntcMthdCn) {
		this.cntcMthdCn = cntcMthdCn;
	}

	public BigDecimal getCntcBpr() {
		return cntcBpr;
	}

	public void setCntcBpr(BigDecimal cntcBpr) {
		this.cntcBpr = cntcBpr;
	}

	public String getCntcStrtDt() {
		return cntcStrtDt;
	}

	public void setCntcStrtDt(String cntcStrtDt) {
		this.cntcStrtDt = cntcStrtDt;
	}

	public String getCntcEndDt() {
		return cntcEndDt;
	}

	public void setCntcEndDt(String cntcEndDt) {
		this.cntcEndDt = cntcEndDt;
	}

	public String getNteCn() {
		return nteCn;
	}

	public void setNteCn(String nteCn) {
		this.nteCn = nteCn;
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

	public String getOprtDttm() {
		return oprtDttm;
	}

	public void setOprtDttm(String oprtDttm) {
		this.oprtDttm = oprtDttm;
	}

	public List<GA01N306VO> getGridGA01N306() {
		return gridGA01N306;
	}

	public void setGridGA01N306(List<GA01N306VO> gridGA01N306) {
		this.gridGA01N306 = gridGA01N306;
	}
    


}

    
