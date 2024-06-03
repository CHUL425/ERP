/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GACM1000U0In02VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 계약서관리 상세정보수정 IN(계정과목코드 다건)
*	07. 주  요  사  항	: 키값 조회, 계정과목코드 delete insert 처리
*******************************************************************************************************/
package com.miraeasset.biz.ga.cm.vo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.meta.vo.GA01N304VO;
import com.miraeasset.biz.common.meta.vo.GA01N306VO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GACM1000U0In02VO {

	@ApiModelProperty(notes= "계약서관리번호", required = true)
	private String cnrtMtNo        	; /*계약서관리번호 */
    @ApiModelProperty(notes= "업체코드" )
    private String delpCd;            // 업체코드
    @ApiModelProperty(notes= "계약구분코드")
    private String cntcTcd        ; /*계약구분코드 */
    @ApiModelProperty(notes= "계약명")
    private String cntcNm         ; /*계약명 */
    @ApiModelProperty(notes= "계약금액")
    private BigDecimal cntcA          ; /*계약금액 */
    @ApiModelProperty(notes= "계약시작일자")
    private String cntcStrtDt     ; /*계약시작일자 */
    @ApiModelProperty(notes= "계약종료일자")
    private String cntcEndDt      ; /*계약종료일자 */
    @ApiModelProperty(notes= "업체선정방법코드")
    private String entpSeltMcd    ; /*업체선정방법코드 */
    @ApiModelProperty(notes= "비고내용")
    private String nteCn          ; /*비고내용 */
    
	@ApiModelProperty(notes= "계정과목 다건내역")
    List<GA01N304VO> gridGA01N304;    // 계정과목 다건내역        
	
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

	public String getCntcTcd() {
		return cntcTcd;
	}

	public void setCntcTcd(String cntcTcd) {
		this.cntcTcd = cntcTcd;
	}

	public String getCntcNm() {
		return cntcNm;
	}

	public void setCntcNm(String cntcNm) {
		this.cntcNm = cntcNm;
	}

	public BigDecimal getCntcA() {
		return cntcA;
	}

	public void setCntcA(BigDecimal cntcA) {
		this.cntcA = cntcA;
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

	public String getEntpSeltMcd() {
		return entpSeltMcd;
	}

	public void setEntpSeltMcd(String entpSeltMcd) {
		this.entpSeltMcd = entpSeltMcd;
	}

	public String getNteCn() {
		return nteCn;
	}

	public void setNteCn(String nteCn) {
		this.nteCn = nteCn;
	}

	public List<GA01N304VO> getGridGA01N304() {
		return gridGA01N304;
	}

	public void setGridGA01N304(List<GA01N304VO> gridGA01N304) {
		this.gridGA01N304 = gridGA01N304;
	}

	public List<GA01N306VO> getGridGA01N306() {
		return gridGA01N306;
	}

	public void setGridGA01N306(List<GA01N306VO> gridGA01N306) {
		this.gridGA01N306 = gridGA01N306;
	}

}
    
