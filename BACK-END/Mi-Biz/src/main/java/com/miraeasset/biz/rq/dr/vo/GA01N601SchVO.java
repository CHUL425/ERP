package com.miraeasset.biz.rq.dr.vo;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.util.CryptoUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

import com.miraeasset.biz.common.vo.BaseVO;

import java.util.List;

@Component
public class GA01N601SchVO extends BaseVO {



	@ApiModelProperty(notes= "신청일자 시작일")
	private String rqsDtSt ; /* 신청일자 시작일 */

	@ApiModelProperty(notes= "신청일자 종료일")
	private String rqsDtEd ; /* 신청일자 종료일 */

	@ApiModelProperty(notes= "통합신청유형코드")
	private String unifRqsPcd ; /* 통합신청유형코드 */

	@ApiModelProperty(notes= "페이지번호")
	private long pageNum ; /* 페이지번호 */

	@ApiModelProperty(notes= "페이징크기")
	private long pageSize ; /* 페이징크기 */

	@ApiModelProperty(notes= "총건수")
	private long totCnt ; /* 총건수 */


	@ApiModelProperty(notes= "문서박스시퀀스번호")
	private long docRqsSqncNo ; /* 문서박스시퀀스번호 */
	@ApiModelProperty(notes= "접수번호")
	private String rctNo ; /* 접수번호 */
	@ApiModelProperty(notes= "통합신청상세유형코드Key")
	private String unifRqsDlPcd ; /* 신청구분코드Key */
	@ApiModelProperty(notes= "통합신청상세유형코드Val")
	private String unifRqsDlPcdNm ; /* 신청구분코드Val */
	@ApiModelProperty(notes= "통합신청구분코드Key")
	private String unifRqsTcd ; /* 유형코드Key */
	@ApiModelProperty(notes= "통합신청구분코드Val")
	private String unifRqsTcdNm ; /* 유형코드Val */
	@ApiModelProperty(notes= "신청제목명")
	private String rqsTtlNm ; /* 신청제목명 */
	@ApiModelProperty(notes= "BOX 건수")
	private long boxCnt ; /* BOX 건수 */
	@ApiModelProperty(notes= "신청조직코드Key")
	private String rqsOrzCd ; /* 신청조직코드Key */
	@ApiModelProperty(notes= "신청조직코드Val")
	private String rqsOrzCdNm ; /* 신청조직코드Val */
	@ApiModelProperty(notes= "신청사원번호")
	private String rqsEpno ; /* 신청사원번호 */
	@ApiModelProperty(notes= "신청사원명")
	private String rqsEpnoNm ; /* 신청사원명 */
	@ApiModelProperty(notes= "신청일자")
	private String rqsDt ; /* 신청일자 */
	@ApiModelProperty(notes= "신청상태코드Key")
	private String rqsScd ; /* 신청상태코드Key */
	@ApiModelProperty(notes= "신청상태코드Val")
	private String rqsScdNm ; /* 신청상태코드Val */

	@ApiModelProperty(notes= "직원이메일", example="직원이메일")
	private String	empEmalAdrEcpVl		 ; /* 	직원이메일 */


	@ApiModelProperty(notes= "계좌번호암호화값", example="계좌번호암호화값")
	private String	acnoEcpVl;		/* 	계좌번호암호화값 */

	@ApiModelProperty(notes= "신청사유내용", example="신청사유")
	private String rqsRsnCn      ; /*신청사유내용 */

	@ApiModelProperty(notes= "희망일자", example="20230929")
	private String hopeDt        ; /*희망일자        */

	@ApiModelProperty(notes= "완료일자", example="20230929")
	private String cmpnDt        ; /*완료일자        */


	@ApiModelProperty(notes= "작성일자", example="20230905")
	private String	madeDt		 ; /* 	작성일자	 */

	@ApiModelProperty(hidden=true)
	private String	csNm		 ; /* 	고객명	 */

	@ApiModelProperty(hidden=true)
	private String	rqsDocNm		 ; /* 	신청문서명	 */

	@ApiModelProperty(hidden=true)
	private String rqsHndpTlno; /* 	신청자 폰번호	 */


	@ApiModelProperty(hidden=true)
	private String	rqsAdr		 ; /* 	신청주소	 */

	@ApiModelProperty(hidden=true)
	private String	dlLocDesc		 ; /* 	상세위치설명	 */

	@ApiModelProperty(hidden=true)
	private String	etcCn		 ; /* 	기타내용	 */


	@ApiModelProperty(hidden=true)
	private String	nteCn		 ; /* 	비고내용	 */

	@ApiModelProperty(hidden=true)
	private List<String> arrRqsScd; /* 신청상태코드_배열 */


	@ApiModelProperty(hidden=true)
	private long aprvWrrptMtNo;		/*결재상신관리번호 */


	public String getRqsDtSt() {return rqsDtSt;}public void setRqsDtSt(String rqsDtSt) {this.rqsDtSt = rqsDtSt;}
	public String getRqsDtEd() {return rqsDtEd;}public void setRqsDtEd(String rqsDtEd) {this.rqsDtEd = rqsDtEd;}
	public String getUnifRqsPcd() {return unifRqsPcd;}public void setUnifRqsPcd(String unifRqsPcd) {this.unifRqsPcd = unifRqsPcd;}
	public long getPageNum() {return pageNum;}public void setPageNum(long pageNum) {this.pageNum = pageNum;}
	public long getPageSize() {return pageSize;}public void setPageSize(long pageSize) {this.pageSize = pageSize;}
	public long getTotCnt() {return totCnt;}public void setTotCnt(long totCnt) {this.totCnt = totCnt;}


	public long getDocRqsSqncNo() { return docRqsSqncNo; } public void setDocRqsSqncNo(long docRqsSqncNo) { this.docRqsSqncNo = docRqsSqncNo; }
	public String getRctNo() { return rctNo; } public void setRctNo(String rctNo) { this.rctNo = rctNo; }
	public String getUnifRqsDlPcd() { return unifRqsDlPcd; } public void setUnifRqsDlPcd(String unifRqsDlPcd) { this.unifRqsDlPcd = unifRqsDlPcd; }
	public String getUnifRqsDlPcdNm() { return unifRqsDlPcdNm; } public void setUnifRqsDlPcdNm(String unifRqsDlPcdNm) { this.unifRqsDlPcdNm = unifRqsDlPcdNm; }
	public String getUnifRqsTcd() { return unifRqsTcd; } public void setUnifRqsTcd(String unifRqsTcd) { this.unifRqsTcd = unifRqsTcd; }
	public String getUnifRqsTcdNm() { return unifRqsTcdNm; } public void setUnifRqsTcdNm(String unifRqsTcdNm) { this.unifRqsTcdNm = unifRqsTcdNm; }
	public String getRqsTtlNm() { return rqsTtlNm; } public void setRqsTtlNm(String rqsTtlNm) { this.rqsTtlNm = rqsTtlNm; }
	public long getBoxCnt() { return boxCnt; } public void setBoxCnt(long boxCnt) { this.boxCnt = boxCnt; }
	public String getRqsOrzCd() { return rqsOrzCd; } public void setRqsOrzCd(String rqsOrzCd) { this.rqsOrzCd = rqsOrzCd; }
	public String getRqsOrzCdNm() { return rqsOrzCdNm; } public void setRqsOrzCdNm(String rqsOrzCdNm) { this.rqsOrzCdNm = rqsOrzCdNm; }
	public String getRqsEpno() { return rqsEpno; } public void setRqsEpno(String rqsEpno) { this.rqsEpno = rqsEpno; }
	public String getRqsEpnoNm() { return rqsEpnoNm; } public void setRqsEpnoNm(String rqsEpnoNm) { this.rqsEpnoNm = rqsEpnoNm; }
	public String getRqsDt() { return rqsDt; } public void setRqsDt(String rqsDt) { this.rqsDt = rqsDt; }
	public String getRqsScd() { return rqsScd; } public void setRqsScd(String rqsScd) { this.rqsScd = rqsScd; }
	public String getRqsScdNm() { return rqsScdNm; } public void setRqsScdNm(String rqsScdNm) { this.rqsScdNm = rqsScdNm; }

	public String getEmpEmalAdrEcpVl() {
		if(!StringUtils.isBlank(empEmalAdrEcpVl)){
			return CryptoUtil.getDecryption(empEmalAdrEcpVl);
		}
		else{
			return empEmalAdrEcpVl;
		}
	}
	public void setEmpEmalAdrEcpVl(String empEmalAdrEcpVl) { this.empEmalAdrEcpVl = empEmalAdrEcpVl; }

	public String getAcnoEcpVl() {
		if(!StringUtils.isBlank(acnoEcpVl)){
			return CryptoUtil.getDecryption(acnoEcpVl);
		}
		else{
			return acnoEcpVl;
		}
	}
	public void setAcnoEcpVl(String acnoEcpVl) { this.acnoEcpVl = acnoEcpVl; }


	public List<String> getArrRqsScd() { return arrRqsScd; } public void setArrRqsScd(List<String> arrRqsScd) { this.arrRqsScd = arrRqsScd; }


	public String getRqsAdr() { return rqsAdr; } public void setRqsAdr(String rqsAdr) { this.rqsAdr = rqsAdr; }
	public String getDlLocDesc() { return dlLocDesc; } public void setDlLocDesc(String dlLocDesc) { this.dlLocDesc = dlLocDesc; }
	public String getEtcCn() { return etcCn; } public void setEtcCn(String etcCn) { this.etcCn = etcCn; }
	public String getRqsDocNm() { return rqsDocNm; } public void setRqsDocNm(String rqsDocNm) { this.rqsDocNm = rqsDocNm; }
	public String getCsNm() { return csNm; } public void setCsNm(String csNm) { this.csNm = csNm; }
	public String getNteCn() { return nteCn; } public void setNteCn(String nteCn) { this.nteCn = nteCn; }

	public String getRqsRsnCn()
	{
		if(rqsRsnCn == null){ rqsRsnCn = ""; }
		return rqsRsnCn;
	}
	public void setRqsRsnCn(String rqsRsnCn) { this.rqsRsnCn = rqsRsnCn; }

	public String getHopeDt() { return hopeDt; } public void setHopeDt(String hopeDt) { this.hopeDt = hopeDt; }
	public String getCmpnDt() { return cmpnDt; } public void setCmpnDt(String cmpnDt) { this.cmpnDt = cmpnDt; }
	public String getRqsHndpTlno() { return rqsHndpTlno; } public void setRqsHndpTlno(String rqsHndpTlno) { this.rqsHndpTlno = rqsHndpTlno; }

	public String getMadeDt() { return madeDt; } public void setMadeDt(String madeDt) { this.madeDt = madeDt; }

	public long getAprvWrrptMtNo() { return aprvWrrptMtNo; } public void setAprvWrrptMtNo(long aprvWrrptMtNo) { this.aprvWrrptMtNo = aprvWrrptMtNo; }
}
