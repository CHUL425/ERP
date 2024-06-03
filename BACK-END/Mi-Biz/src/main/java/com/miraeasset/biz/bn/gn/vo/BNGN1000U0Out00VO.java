/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: BM
*	03. 파    일   명	: BNGN1000U0Out00VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 총무공지 목록조회 OUT
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.bn.gn.vo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.dao.ExcelColumnStyle;
import com.miraeasset.biz.common.meta.vo.GA09N411VO;
import com.miraeasset.biz.common.util.excel.style.DefaultBodyStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultExcelCellStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultHeaderStyle;

import io.swagger.annotations.ApiModelProperty;

@DefaultHeaderStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "GREY_HEADER"))
@DefaultBodyStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BODY"))
@Component
public class BNGN1000U0Out00VO {

	@ExcelColumnInfo(notes= "작성일자")
	@ApiModelProperty(notes= "작성일자")
	private String madeDt           ; /*작성일자            */
	@ExcelColumnInfo(notes= "일련번호")
	@ApiModelProperty(notes= "일련번호")
	private BigDecimal srno             ; /*일련번호            */
	@ExcelColumnInfo(notes= "공지구분코드")
	@ApiModelProperty(notes= "공지구분코드")
	private String cmklTcd          ; /*공지구분코드        */
	@ExcelColumnInfo(notes= "공지구분코드명")
	@ApiModelProperty(notes= "공지구분코드명")
	private String cmklTcdNm        ; /*공지구분코드명        */
	@ExcelColumnInfo(notes= "게시물고정여부")
	@ApiModelProperty(notes= "게시물고정여부")
	private String pstgFxdYn        ; /*게시물고정여부      */
	@ExcelColumnInfo(notes= "작성사원번호")
	@ApiModelProperty(notes= "작성사원번호")
	private String madeEpno         ; /*작성사원번호        */

	@ExcelColumnInfo(notes= "작성사원명")
	@ApiModelProperty(notes= "작성사원명")
	private String madeEpNm         ; /*작성사원명        */
	
	@ExcelColumnInfo(notes= "제목명")
	@ApiModelProperty(notes= "제목명")
	private String ttlNm            ; /*제목명              */
	@ExcelColumnInfo(notes= "공지사항내용")
	@ApiModelProperty(notes= "공지사항내용")
	private String cmklPtcrCn       ; /*공지사항내용        */
	@ExcelColumnInfo(notes= "게시시작일자")
	@ApiModelProperty(notes= "게시시작일자")
	private String pstupStrtDt      ; /*게시시작일자        */
	@ExcelColumnInfo(notes= "게시종료일자")
	@ApiModelProperty(notes= "게시종료일자")
	private String pstupEndDt       ; /*게시종료일자        */
	@ExcelColumnInfo(notes= "파일번호")
	@ApiModelProperty(notes= "파일번호")
	private String fileNo           ; /*파일번호            */
	
	@ExcelColumnInfo(notes= "고객지원팀장알림여부")
	@ApiModelProperty(notes= "고객지원팀장알림여부")
	private String csSptTmlIprtYn  ;  /*고객지원팀장알림여부*/
	@ExcelColumnInfo(notes= "WM팀장알림여부")
	@ApiModelProperty(notes= "WM팀장알림여부")
	private String wmTmlIprtYn     ;  /*WM팀장알림여부      */
	@ExcelColumnInfo(notes= "지점장알림여부")
	@ApiModelProperty(notes= "지점장알림여부")
	private String brmgIprtYn      ;  /*지점장알림여부      */
	@ExcelColumnInfo(notes= "지점알림여부")
	@ApiModelProperty(notes= "지점알림여부")
	private String brIprtYn        ;  /*지점알림여부        */
	@ExcelColumnInfo(notes= "팀장알림여부")
	@ApiModelProperty(notes= "팀장알림여부")
	private String tmlIprtYn       ;  /*팀장알림여부        */
	@ExcelColumnInfo(notes= "본부장알림여부")
	@ApiModelProperty(notes= "본부장알림여부")
	private String hqmgIprtYn      ;  /*본부장알림여부      */
	@ExcelColumnInfo(notes= "본사알림여부")
	@ApiModelProperty(notes= "본사알림여부")
	private String hoIprtYn        ;  /*본사알림여부        */   
	
	@ExcelColumnInfo(notes= "조회건수")
	@ApiModelProperty(notes= "조회건수")
	private BigDecimal qryCnt           ; /*조회건수            */
	@ExcelColumnInfo(notes= "삭제여부")
	@ApiModelProperty(notes= "삭제여부")
	private String delYn            ; /*삭제여부            */    	
	
	@ApiModelProperty(notes= "파일정보 파일정보")
    private List<GA09N411VO> gridGA09N411;    // 파일정보 다건내역    	
	
	@ApiModelProperty(notes= "순번", example="0")
	private BigDecimal rnum       ; /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수             */
	public String getMadeDt() {
		return madeDt;
	}
	public void setMadeDt(String madeDt) {
		this.madeDt = madeDt;
	}
	public BigDecimal getSrno() {
		return srno;
	}
	public void setSrno(BigDecimal srno) {
		this.srno = srno;
	}
	public String getCmklTcd() {
		return cmklTcd;
	}
	public void setCmklTcd(String cmklTcd) {
		this.cmklTcd = cmklTcd;
	}
	public String getCmklTcdNm() {
		return cmklTcdNm;
	}
	public void setCmklTcdNm(String cmklTcdNm) {
		this.cmklTcdNm = cmklTcdNm;
	}
	public String getPstgFxdYn() {
		return pstgFxdYn;
	}
	public void setPstgFxdYn(String pstgFxdYn) {
		this.pstgFxdYn = pstgFxdYn;
	}
	public String getMadeEpno() {
		return madeEpno;
	}
	public void setMadeEpno(String madeEpno) {
		this.madeEpno = madeEpno;
	}
	public String getMadeEpNm() {
		return madeEpNm;
	}
	public void setMadeEpNm(String madeEpNm) {
		this.madeEpNm = madeEpNm;
	}
	public String getTtlNm() {
		return ttlNm;
	}
	public void setTtlNm(String ttlNm) {
		this.ttlNm = ttlNm;
	}
	public String getCmklPtcrCn() {
		return cmklPtcrCn;
	}
	public void setCmklPtcrCn(String cmklPtcrCn) {
		this.cmklPtcrCn = cmklPtcrCn;
	}
	public String getPstupStrtDt() {
		return pstupStrtDt;
	}
	public void setPstupStrtDt(String pstupStrtDt) {
		this.pstupStrtDt = pstupStrtDt;
	}
	public String getPstupEndDt() {
		return pstupEndDt;
	}
	public void setPstupEndDt(String pstupEndDt) {
		this.pstupEndDt = pstupEndDt;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getCsSptTmlIprtYn() {
		return csSptTmlIprtYn;
	}
	public void setCsSptTmlIprtYn(String csSptTmlIprtYn) {
		this.csSptTmlIprtYn = csSptTmlIprtYn;
	}
	public String getWmTmlIprtYn() {
		return wmTmlIprtYn;
	}
	public void setWmTmlIprtYn(String wmTmlIprtYn) {
		this.wmTmlIprtYn = wmTmlIprtYn;
	}
	public String getBrmgIprtYn() {
		return brmgIprtYn;
	}
	public void setBrmgIprtYn(String brmgIprtYn) {
		this.brmgIprtYn = brmgIprtYn;
	}
	public String getBrIprtYn() {
		return brIprtYn;
	}
	public void setBrIprtYn(String brIprtYn) {
		this.brIprtYn = brIprtYn;
	}
	public String getTmlIprtYn() {
		return tmlIprtYn;
	}
	public void setTmlIprtYn(String tmlIprtYn) {
		this.tmlIprtYn = tmlIprtYn;
	}
	public String getHqmgIprtYn() {
		return hqmgIprtYn;
	}
	public void setHqmgIprtYn(String hqmgIprtYn) {
		this.hqmgIprtYn = hqmgIprtYn;
	}
	public String getHoIprtYn() {
		return hoIprtYn;
	}
	public void setHoIprtYn(String hoIprtYn) {
		this.hoIprtYn = hoIprtYn;
	}
	public BigDecimal getQryCnt() {
		return qryCnt;
	}
	public void setQryCnt(BigDecimal qryCnt) {
		this.qryCnt = qryCnt;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public List<GA09N411VO> getGridGA09N411() {
		return gridGA09N411;
	}
	public void setGridGA09N411(List<GA09N411VO> gridGA09N411) {
		this.gridGA09N411 = gridGA09N411;
	}
	public BigDecimal getRnum() {
		return rnum;
	}
	public void setRnum(BigDecimal rnum) {
		this.rnum = rnum;
	}
	public BigDecimal getAlCnt() {
		return alCnt;
	}
	public void setAlCnt(BigDecimal alCnt) {
		this.alCnt = alCnt;
	}
	
	

	
}
