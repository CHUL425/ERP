package com.miraeasset.biz.rq.dr.vo;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

import com.miraeasset.biz.common.vo.BaseVO;

@Component
public class GA01N602ModVO extends BaseVO {

	@ApiModelProperty(notes= "문서신청시퀀스번호")
	private long docRqsSqncNo ; /* 문서신청시퀀스번호 */

	// GA01N602
	@ApiModelProperty(notes= "문서박스시퀀스번호")
	private long docBoxSqncNo ; /* 문서박스시퀀스번호 */


	@ApiModelProperty(notes= "보관시작일자", example="20230905")
	private String prdtStrtDt ; /* 보관시작일자 */

	@ApiModelProperty(notes= "보관종료일자", example="20330905")
	private String prdtEndDt ; /* 보관종료일자 */

	@ApiModelProperty(notes= "폐기년도", example="2033")
	private String dsusYr ; /* 폐기년도 */

	@ApiModelProperty(notes= "회수일자", example="20231005")
	private String wtdwDt ; /* 회수일자 */

	@ApiModelProperty(notes= "보존년한")
	private String prsvYrVl ; /* 보전년도값 */

	@ApiModelProperty(notes= "관리조직코드")
	private String mtOrzCd ; /* 관리조직코드 */


	public String getPrsvYrVl() { return prsvYrVl; } public void setPrsvYrVl(String prsvYrVl) { this.prsvYrVl = prsvYrVl; }
	public String getMtOrzCd() { return mtOrzCd; } public void setMtOrzCd(String mtOrzCd) { this.mtOrzCd = mtOrzCd; }

	public long getDocBoxSqncNo() { return docBoxSqncNo; } public void setDocBoxSqncNo(long docBoxSqncNo) { this.docBoxSqncNo = docBoxSqncNo; }
	public String getPrdtStrtDt() { return prdtStrtDt; } public void setPrdtStrtDt(String prdtStrtDt) { this.prdtStrtDt = prdtStrtDt; }
	public String getPrdtEndDt() { return prdtEndDt; } public void setPrdtEndDt(String prdtEndDt) { this.prdtEndDt = prdtEndDt; }
	public String getDsusYr() { return dsusYr; } public void setDsusYr(String dsusYr) { this.dsusYr = dsusYr; }
	public String getWtdwDt() { return wtdwDt; } public void setWtdwDt(String wtdwDt) { this.wtdwDt = wtdwDt; }
	public long getDocRqsSqncNo() { return docRqsSqncNo; } public void setDocRqsSqncNo(long docRqsSqncNo) { this.docRqsSqncNo = docRqsSqncNo; }

	
}
