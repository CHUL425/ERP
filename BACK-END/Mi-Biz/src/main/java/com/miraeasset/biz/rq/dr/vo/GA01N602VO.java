package com.miraeasset.biz.rq.dr.vo;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.dao.ExcelColumnStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultBodyStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultExcelCellStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultHeaderStyle;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

import com.miraeasset.biz.common.vo.BaseVO;

@Component
@DefaultHeaderStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "GREY_HEADER"))
@DefaultBodyStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "LEFT"))
public class GA01N602VO extends BaseVO {

	// GA01N602

	@ExcelColumnInfo(notes= "문서박스시퀀스번호")
	@ApiModelProperty(notes= "문서박스시퀀스번호")
	private long docBoxSqncNo ; /* 문서박스시퀀스번호 */

	@ExcelColumnInfo(notes= "문서박스상태코드")
	@ApiModelProperty(notes= "문서박스상태코드")private String docBoxScd ; /* 문서박스상태코드 */

	@ExcelColumnInfo(notes= "보관장소내용")
	@ApiModelProperty(notes= "보관장소내용")private String cstdPlcCn ; /* 보관장소내용 */

	@ExcelColumnInfo(notes= "디바이스번호")
	@ApiModelProperty(notes= "디바이스번호")private String dvceNo ; /* 디바이스번호 */

	@ExcelColumnInfo(notes= "바코드번호")
	@ApiModelProperty(notes= "바코드번호")private String bcdNo ; /* 바코드번호 */

	@ExcelColumnInfo(notes= "생산조직코드")
	@ApiModelProperty(notes= "생산조직코드")private String prdtOrzCd ; /* 생산조직코드 */

	@ExcelColumnInfo(notes= "관리조직코드")
	@ApiModelProperty(notes= "관리조직코드")private String mtOrzCd ; /* 관리조직코드 */


	@ExcelColumnInfo(notes= "문서박스명")
	@ApiModelProperty(notes= "문서박스명")private String docBoxNm ; /* 문서박스명 */


	@ExcelColumnInfo(notes= "박스문서내용")
	@ApiModelProperty(notes= "박스문서내용")private String boxDocCn ; /* 박스문서내용 */



	@ExcelColumnInfo(notes= "생산시작일자")
	@ApiModelProperty(notes= "생산시작일자")private String prdtStrtDt ; /* 보관시작일자 */

	@ExcelColumnInfo(notes= "생산종료일자")
	@ApiModelProperty(notes= "생산종료일자")private String prdtEndDt ; /* 보관종료일자 */

	@ExcelColumnInfo(notes= "보존년한")
	@ApiModelProperty(notes= "보존년한")  private String prsvYrVl ; /* 보전년도값 */

	@ExcelColumnInfo(notes= "폐기년도")
	@ApiModelProperty(notes= "폐기년도")private String dsusYr ; /* 폐기년도 */

	@ExcelColumnInfo(notes= "이관일자")
	@ApiModelProperty(notes= "이관일자")private String mvoutDt ; /* 이관일자 */

	@ExcelColumnInfo(notes= "대출일자")
	@ApiModelProperty(notes= "대출일자")private String lnDt ; /* 대출일자 */

	@ExcelColumnInfo(notes= "회수일자")
	@ApiModelProperty(notes= "회수일자")private String wtdwDt ; /* 회수일자 */

	@ExcelColumnInfo(notes= "법인명")
	@ApiModelProperty(notes= "법인명")private String corpNm ; /* 법인명 */

	@ExcelColumnInfo(notes= "비고내용")
	@ApiModelProperty(notes= "비고내용")private String nteCn ; /* 비고내용 */


	@ApiModelProperty(notes= "폐기일자")private String dsusDt ; /* 폐기일자 */

	@ApiModelProperty(notes= "문서신청시퀀스번호")
	private long docRqsSqncNo ; /* 문서신청시퀀스번호 */

	@ApiModelProperty(notes= "접수번호", example="20230831-09-00000007")
	private String	rctNo;		/* 	접수번호	 */


	@ApiModelProperty(hidden=true)
	private String cmpnDt        ; /*완료일자        */


	@ApiModelProperty(hidden=true)
	private String unifRqsTcd ; /* 유형코드Key */


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

	public String getRctNo() { return rctNo; } public void setRctNo(String rctNo) { this.rctNo = rctNo; }

	public String getCmpnDt() { return cmpnDt; } public void setCmpnDt(String cmpnDt) { this.cmpnDt = cmpnDt; }

	public String getUnifRqsTcd() { return unifRqsTcd; } public void setUnifRqsTcd(String unifRqsTcd) { this.unifRqsTcd = unifRqsTcd; }

}
