package com.miraeasset.biz.rq.dr.vo;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

import com.miraeasset.biz.common.vo.BaseVO;

import java.util.List;

@Component
public class GA01N602SchVO extends BaseVO {


	@ApiModelProperty(notes= "조회타입")
	private String selTyp;

	@ApiModelProperty(notes= "조회 시작일")
	private String selDtSt;

	@ApiModelProperty(notes= "조회 종료일")
	private String selDtEd;

	@ApiModelProperty(notes= "생산조직명")
	private String prdtOrzCdNm; /* 생산조직명 */

	@ApiModelProperty(notes= "관리조직명")
	private String mtOrzCdNm; /* 관리조직명 */

	@ApiModelProperty(notes= "페이지번호")
	private long pageNum ; /* 페이지번호 */

	@ApiModelProperty(notes= "페이징크기")
	private long pageSize ; /* 페이징크기 */

	@ApiModelProperty(notes= "총건수")
	private long totCnt ; /* 총건수 */


	// GA01N602
	@ApiModelProperty(notes= "보관장소내용")private String cstdPlcCn ; /* 보관장소내용 */
	@ApiModelProperty(notes= "디바이스번호")private String dvceNo ; /* 디바이스번호 */
	@ApiModelProperty(notes= "바코드번호")private String bcdNo ; /* 바코드번호 */

	@ApiModelProperty(notes= "생산조직코드")
	private String prdtOrzCd ; /* 생산조직코드 */

	@ApiModelProperty(notes= "문서박스명")private String docBoxNm ; /* 문서박스명 */

	@ApiModelProperty(notes= "박스문서내용")private String boxDocCn ; /* 박스문서내용 */

	@ApiModelProperty(notes= "생산시작일자")private String prdtStrtDt ; /* 생산시작일자 */

	@ApiModelProperty(notes= "생산종료일자")private String prdtEndDt ; /* 생산종료일자 */

	@ApiModelProperty(notes= "폐기년도")private String dsusYr ; /* 폐기년도 */

	@ApiModelProperty(notes= "이관일자")private String mvoutDt ; /* 이관일자 */

	@ApiModelProperty(notes= "대출일자")private String lnDt ; /* 대출일자 */

	@ApiModelProperty(notes= "회수일자")private String wtdwDt ; /* 회수일자 */

	@ApiModelProperty(notes= "법인명")private String corpNm ; /* 법인명 */

	@ApiModelProperty(notes= "비고내용")private String nteCn ; /* 비고내용 */

	@ApiModelProperty(notes= "관리조직코드")
	private String mtOrzCd ; /* 관리조직코드 */

	@ApiModelProperty(notes= "문서박스상태코드")
	private String docBoxScd; /* 문서박스상태코드 */

	@ApiModelProperty(notes= "폐기일자")private String dsusDt ; /* 폐기일자 */

	@ApiModelProperty(notes= "문서신청시퀀스번호")private long docRqsSqncNo ; /* 문서신청시퀀스번호 */


	@ApiModelProperty(notes= "문서박스시퀀스번호")
	private long docBoxSqncNo ; /* 문서박스시퀀스번호 */


	@ApiModelProperty(hidden=true)
	private List<String> arrDocBoxScd; /* 문서박스상태코드_배열 */

	@ApiModelProperty(hidden=true)
	private String rctNo ; /* 접수번호 */


	@ApiModelProperty(hidden=true)
	private String notDocBoxScd; /* 문서박스상태코드_NotIn */

	@ApiModelProperty(hidden=true)
	private List<String> arrNotDocBoxScd; /* 문서박스상태코드_NotIn_배열 */

	@ApiModelProperty(notes= "보존년한")
	private String prsvYrVl ; /* 보존년한 */

	@ApiModelProperty(hidden=true)
	private List<Long> arrDocBoxSqncNo; /* 문서박스시퀀스번호, 스트링 배열 */

	@ApiModelProperty(hidden=true)
	private String strArrDocBoxSqncNo; /* 문서박스시퀀스번호, 스트링 배열 */


	@ApiModelProperty(notes= "문서 신청 구분 코드 - 10:신청중, 20:미신청")
	private String docRqsCd;


	public String getDocRqsCd() { return docRqsCd; } public void setDocRqsCd(String docRqsCd) { this.docRqsCd = docRqsCd; }

	public List<Long> getArrDocBoxSqncNo() { return arrDocBoxSqncNo; } public void setArrDocBoxSqncNo(List<Long> arrDocBoxSqncNo) { this.arrDocBoxSqncNo = arrDocBoxSqncNo; }
	public String getStrArrDocBoxSqncNo() { return strArrDocBoxSqncNo; } public void setStrArrDocBoxSqncNo(String strArrDocBoxSqncNo) { this.strArrDocBoxSqncNo = strArrDocBoxSqncNo; }

	public String getPrsvYrVl() { return prsvYrVl; } public void setPrsvYrVl(String prsvYrVl) { this.prsvYrVl = prsvYrVl; }

	public long getDocBoxSqncNo() { return docBoxSqncNo; } public void setDocBoxSqncNo(long docBoxSqncNo) { this.docBoxSqncNo = docBoxSqncNo; }
	public String getDocBoxNm() { return docBoxNm; } public void setDocBoxNm(String docBoxNm) { this.docBoxNm = docBoxNm; }
	public String getPrdtOrzCd() { return prdtOrzCd; } public void setPrdtOrzCd(String prdtOrzCd) { this.prdtOrzCd = prdtOrzCd; }
	public String getMtOrzCd() { return mtOrzCd; } public void setMtOrzCd(String mtOrzCd) { this.mtOrzCd = mtOrzCd; }
	public String getBoxDocCn() { return boxDocCn; } public void setBoxDocCn(String boxDocCn) { this.boxDocCn = boxDocCn; }
	public String getCstdPlcCn() { return cstdPlcCn; } public void setCstdPlcCn(String cstdPlcCn) { this.cstdPlcCn = cstdPlcCn; }
	public String getDvceNo() { return dvceNo; } public void setDvceNo(String dvceNo) { this.dvceNo = dvceNo; }
	public String getBcdNo() { return bcdNo; } public void setBcdNo(String bcdNo) { this.bcdNo = bcdNo; }
	public String getDocBoxScd() { return docBoxScd; } public void setDocBoxScd(String docBoxScd) { this.docBoxScd = docBoxScd; }
	public String getPrdtStrtDt() { return prdtStrtDt; } public void setPrdtStrtDt(String prdtStrtDt) { this.prdtStrtDt = prdtStrtDt; }
	public String getPrdtEndDt() { return prdtEndDt; } public void setPrdtEndDt(String prdtEndDt) { this.prdtEndDt = prdtEndDt; }
	public String getDsusYr() { return dsusYr; } public void setDsusYr(String dsusYr) { this.dsusYr = dsusYr; }
	public String getMvoutDt() { return mvoutDt; } public void setMvoutDt(String mvoutDt) { this.mvoutDt = mvoutDt; }
	public String getLnDt() { return lnDt; } public void setLnDt(String lnDt) { this.lnDt = lnDt; }
	public String getWtdwDt() { return wtdwDt; } public void setWtdwDt(String wtdwDt) { this.wtdwDt = wtdwDt; }
	public String getDsusDt() { return dsusDt; } public void setDsusDt(String dsusDt) { this.dsusDt = dsusDt; }
	public String getCorpNm() { return corpNm; } public void setCorpNm(String corpNm) { this.corpNm = corpNm; }
	public String getNteCn() { return nteCn; } public void setNteCn(String nteCn) { this.nteCn = nteCn; }
	public long getDocRqsSqncNo() { return docRqsSqncNo; } public void setDocRqsSqncNo(long docRqsSqncNo) { this.docRqsSqncNo = docRqsSqncNo; }


	public String getSelTyp() { return selTyp; } public void setSelTyp(String selTyp) { this.selTyp = selTyp; }
	public String getSelDtSt() { return selDtSt; } public void setSelDtSt(String selDtSt) { this.selDtSt = selDtSt; }
	public String getSelDtEd() { return selDtEd; } public void setSelDtEd(String selDtEd) { this.selDtEd = selDtEd; }

	public String getPrdtOrzCdNm() { return prdtOrzCdNm; } public void setPrdtOrzCdNm(String prdtOrzCdNm) { this.prdtOrzCdNm = prdtOrzCdNm; }
	public String getMtOrzCdNm() {return mtOrzCdNm;} public void setMtOrzCdNm(String mtOrzCdNm) { this.mtOrzCdNm = mtOrzCdNm; }

	public long getPageNum() {return pageNum;}public void setPageNum(long pageNum) {this.pageNum = pageNum;}
	public long getPageSize() {return pageSize;}public void setPageSize(long pageSize) {this.pageSize = pageSize;}
	public long getTotCnt() {return totCnt;}public void setTotCnt(long totCnt) {this.totCnt = totCnt;}

	public List<String> getArrDocBoxScd() { return arrDocBoxScd; } public void setArrDocBoxScd(List<String> arrDocBoxScd) { this.arrDocBoxScd = arrDocBoxScd; }

	public String getRctNo() { return rctNo; } public void setRctNo(String rctNo) { this.rctNo = rctNo; }

	public String getNotDocBoxScd() { return notDocBoxScd; } public void setNotDocBoxScd(String notDocBoxScd) { this.notDocBoxScd = notDocBoxScd; }
	public List<String> getArrNotDocBoxScd() { return arrNotDocBoxScd; } public void setArrNotDocBoxScd(List<String> arrNotDocBoxScd) {this.arrNotDocBoxScd = arrNotDocBoxScd;  }

}
