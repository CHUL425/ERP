/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GAEM1000U0Out12VO.java
*	04. 작  성  일  자	: 2023.06.21
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 업체관리 업체메모 팝업 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.em.vo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.meta.vo.GA01N302VO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAEM1000U0Out12VO {
	
    @ApiModelProperty(notes= "거래처코드")
    private String delpCd            ; /*거래처코드              */

	@ApiModelProperty(notes= "업체명")
	private String delpNm                ; /*업체명*/                     
	@ApiModelProperty(notes= "사업자등록번호")
	private String blno                  ; /*사업자등록번호 */            
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수             */
	
	@ApiModelProperty(notes= "메모 다건내역")
    List<GA01N302VO> gridGA01N302;    // 메모 다건내역	

	public String getDelpCd() {
		return delpCd;
	}

	public void setDelpCd(String delpCd) {
		this.delpCd = delpCd;
	}

	public String getDelpNm() {
		return delpNm;
	}

	public void setDelpNm(String delpNm) {
		this.delpNm = delpNm;
	}

	public String getBlno() {
		return blno;
	}

	public void setBlno(String blno) {
		this.blno = blno;
	}

	public BigDecimal getAlCnt() {
		return alCnt;
	}

	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}

	public List<GA01N302VO> getGridGA01N302() {
		return gridGA01N302;
	}

	public void setGridGA01N302(List<GA01N302VO> gridGA01N302) {
		this.gridGA01N302 = gridGA01N302;
	}

	
}
