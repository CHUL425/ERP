package com.miraeasset.biz.rq.dr.vo;

import java.util.List;

import com.miraeasset.biz.common.dao.ExcelColumnStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultBodyStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultExcelCellStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultHeaderStyle;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiModelProperty;

import com.miraeasset.biz.common.vo.BaseVO;
import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.ga.bm.vo.GABM1000U0In01VO;
import com.miraeasset.biz.common.meta.vo.AprvWrrptInVO;
import com.miraeasset.biz.common.util.CryptoUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@DefaultHeaderStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "GREY_HEADER"))
@DefaultBodyStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "LEFT"))
public class GA01N601VO extends BaseVO {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	// GA01N601
	@ApiModelProperty(notes= "문서신청시퀀스번호")
	private long 	docRqsSqncNo		 ; /* 	문서신청시퀀스번호	 */

	@ExcelColumnInfo(notes= "접수번호")
	@ApiModelProperty(notes= "접수번호", example="20230831-09-00000007")
	private String	rctNo		 ; /* 	접수번호	 */


	@ExcelColumnInfo(notes= "구분")
	@ApiModelProperty(notes= "통합신청상세유형코드Val")
	private String unifRqsDlPcdNm ; /* 신청구분코드Val */


	@ExcelColumnInfo(notes= "유형")
	@ApiModelProperty(notes= "통합신청구분코드Val")
	private String unifRqsTcdNm ; /* 유형코드Val */

	@ExcelColumnInfo(notes= "신청제목")
	@ApiModelProperty(notes= "신청제목명", example="신청제목")
	private String rqsTtlNm      ; /*신청제목명      */

	@ExcelColumnInfo(notes= "박스갯수")
	@ApiModelProperty(notes= "BOX 건수")
	private long boxCnt ; /* BOX 건수 */


	@ExcelColumnInfo(notes= "신청부서")
	@ApiModelProperty(notes= "신청조직코드Val")
	private String rqsOrzCdNm ; /* 신청조직코드Val */


	@ExcelColumnInfo(notes= "신청자")
	@ApiModelProperty(notes= "신청사원명")
	private String rqsEpnoNm ; /* 신청사원명 */

	@ExcelColumnInfo(notes= "신청일자")
	@ApiModelProperty(notes= "신청일자", example="20230905")
	private String	rqsDt		 ; /* 	신청일자	 */


	@ExcelColumnInfo(notes= "신청상태")
	@ApiModelProperty(notes= "신청상태명")
	private String rqsScdNm ; /* 신청상태코드Val */

	@ApiModelProperty(notes= "문서신청상태코드", example="")
	private String	docRqsScd		 ; /* 	문서신청상태코드	 */

	@ApiModelProperty(notes= "신청주소", example="신청주소")
	private String	rqsAdr		 ; /* 	신청주소	 */

	@ApiModelProperty(notes= "상세위치설명", example="상세위치설명")
	private String	dlLocDesc		 ; /* 	상세위치설명	 */

	@ApiModelProperty(notes= "기타내용", example="기타")
	private String	etcCn		 ; /* 	기타내용	 */

	@ApiModelProperty(notes= "신청문서명", example="신청문서명1/|/신청문서명2/|/신청문서명3/|/신청문서명4")
	private String	rqsDocNm		 ; /* 	신청문서명	 */

	@ApiModelProperty(notes= "작성일자", example="20230905")
	private String	madeDt		 ; /* 	작성일자	 */

	@ApiModelProperty(notes= "고객명", example="고객명")
	private String	csNm		 ; /* 	고객명	 */

	@ApiModelProperty(notes= "직원이메일", example="직원이메일")
	private String	empEmalAdrEcpVl		 ; /* 	직원이메일 */

	@ApiModelProperty(notes= "계좌번호암호화값", example="계좌번호암호화값")
	private String	acnoEcpVl;		/* 	계좌번호암호화값 */

	@ApiModelProperty(notes= "비고내용", example="비고내용")
	private String	nteCn		 ; /* 	비고내용	 */

	@ApiModelProperty(notes= "문서박스시퀀스번호")
	private long 	docBoxSqncNo		 ; /* 	문서박스시퀀스번호	 */

	@ApiModelProperty(notes= "관리요약내용", example="관리요약내용")
	private String	mtSmarCn		 ; /* 	관리요약내용	 */

	@ApiModelProperty(notes= "엑셀파일")		private MultipartFile fileExcel		 ; /* 	엑셀파일	 */


	// GA01N101
	@ApiModelProperty(notes= "신청유형코드", example="09")
	private String unifRqsPcd        ; /*신청유형코드    */

	@ApiModelProperty(notes= "신청상세유형코드(0901 : 입고, 0902 : 출고, 0903 : 박스정보정정, 0904 : 신청정정, 0905 : 폐기)"
			, example="0903")
	private String unifRqsDlPcd     ; /*신청상세유형코드    */

	@ApiModelProperty(notes= "신청구분코드(090101 : 입고, 090102 : 재입고, 090201 : 스캔출고, 090202 : 박스출고, 090301 : 박스정보정정, 090401 : 입고정정, 090402 : 폐기정정, 090403 : 연장신청, 090501 : 폐기, 090502 : 입고 후 폐기)"
			, example="090301")
	private String unifRqsTcd        ; // 신청구분코드


	@ApiModelProperty(notes= "신청사유내용", example="신청사유")
	private String rqsRsnCn      ; /*신청사유내용 */

	@ApiModelProperty(notes= "희망일자", example="20230929")
	private String hopeDt        ; /*희망일자        */

	@ApiModelProperty(notes= "완료일자", example="20230929")
	private String cmpnDt        ; /*완료일자        */

	@ApiModelProperty(notes= "신청상태코드(00 : 임시저장, 05 : 승인중, 10 : 승인완료, 30 : 반려, 15 : 메일전송완료, 35 : 철회, 99 : 완료)", example="05")
	private String rqsScd        ; /*신청상태코드    */

	@ApiModelProperty(hidden=true)
	private String rqsEpno       ; /*신청사원번호    */

	@ApiModelProperty(hidden=true)
	private String rqsOrzCd      ; /*신청조직코드    */

	@ApiModelProperty(hidden=true)
	private List<Long> arrDocBoxSqncNo; /* 문서박스시퀀스번호, 스트링 배열 */

	@ApiModelProperty(notes= "문서박스시퀀스번호(,)(String Array)", example="")
	private String strArrDocBoxSqncNo; /* 문서박스시퀀스번호, 스트링 배열 */


	@ApiModelProperty(notes = "문서신청_박스관리(Box Grid)")
	List<GA01N602ModVO> inputGrd;


	/* 2023.09.12 결재선 리스트 */
	@ApiModelProperty(notes = "결재선리스트")
	List<AprvWrrptInVO> aprvl;


	public long getDocRqsSqncNo() { return docRqsSqncNo; } public void setDocRqsSqncNo(long docRqsSqncNo) { this.docRqsSqncNo = docRqsSqncNo; }
	public String getRqsDt() { return rqsDt; } public void setRqsDt(String rqsDt) { this.rqsDt = rqsDt; }
	public String getRctNo() { return rctNo; } public void setRctNo(String rctNo) { this.rctNo = rctNo; }
	public String getDocRqsScd() { return docRqsScd; } public void setDocRqsScd(String docRqsScd) { this.docRqsScd = docRqsScd; }
	public String getRqsAdr() { return rqsAdr; } public void setRqsAdr(String rqsAdr) { this.rqsAdr = rqsAdr; }
	public String getDlLocDesc() { return dlLocDesc; } public void setDlLocDesc(String dlLocDesc) { this.dlLocDesc = dlLocDesc; }
	public String getEtcCn() { return etcCn; } public void setEtcCn(String etcCn) { this.etcCn = etcCn; }
	public String getRqsDocNm() { return rqsDocNm; } public void setRqsDocNm(String rqsDocNm) { this.rqsDocNm = rqsDocNm; }
	public String getMadeDt() { return madeDt; } public void setMadeDt(String madeDt) { this.madeDt = madeDt; }
	public String getCsNm() { return csNm; } public void setCsNm(String csNm) { this.csNm = csNm; }

	public String getNteCn() { return nteCn; } public void setNteCn(String nteCn) { this.nteCn = nteCn; }
	public long getDocBoxSqncNo() { return docBoxSqncNo; } public void setDocBoxSqncNo(long docBoxSqncNo) { this.docBoxSqncNo = docBoxSqncNo; }
	public String getMtSmarCn() { return mtSmarCn; } public void setMtSmarCn(String mtSmarCn) { this.mtSmarCn = mtSmarCn; }
	public MultipartFile getFileExcel() { return fileExcel; } public void setFileExcel(MultipartFile fileExcel) { this.fileExcel = fileExcel; }


	public String getUnifRqsPcd() { return unifRqsPcd; } public void setUnifRqsPcd(String unifRqsPcd) { this.unifRqsPcd = unifRqsPcd; }
	public String getUnifRqsDlPcd() { return unifRqsDlPcd; } public void setUnifRqsDlPcd(String unifRqsDlPcd) { this.unifRqsDlPcd = unifRqsDlPcd; }
	public String getUnifRqsTcd() { return unifRqsTcd; } public void setUnifRqsTcd(String unifRqsTcd) { this.unifRqsTcd = unifRqsTcd; }
	public String getRqsTtlNm() { return rqsTtlNm; } public void setRqsTtlNm(String rqsTtlNm) { this.rqsTtlNm = rqsTtlNm; }
	public String getRqsRsnCn() { return rqsRsnCn; } public void setRqsRsnCn(String rqsRsnCn) { this.rqsRsnCn = rqsRsnCn; }
	public String getHopeDt() { return hopeDt; } public void setHopeDt(String hopeDt) { this.hopeDt = hopeDt; }
	public String getCmpnDt() { return cmpnDt; } public void setCmpnDt(String cmpnDt) { this.cmpnDt = cmpnDt; }
	public String getRqsScd() { return rqsScd; } public void setRqsScd(String rqsScd) { this.rqsScd = rqsScd; }
	public String getRqsEpno() { return rqsEpno; } public void setRqsEpno(String rqsEpno) { this.rqsEpno = rqsEpno; }
	public String getRqsOrzCd() { return rqsOrzCd; }   public void setRqsOrzCd(String rqsOrzCd) { this.rqsOrzCd = rqsOrzCd; }


	/*
	public String getEmpEmalAdrEcpVl() {
		if(!StringUtils.isBlank(empEmalAdrEcpVl)){
			return CryptoUtil.getDecryption(empEmalAdrEcpVl);
		}
		else{
			return empEmalAdrEcpVl;
		}
	}
	*/


	public String getEmpEmalAdrEcpVlDec() {
		if(!StringUtils.isBlank(empEmalAdrEcpVl)){
			return CryptoUtil.getDecryption(empEmalAdrEcpVl);
		}
		else{
			return empEmalAdrEcpVl;
		}
	}


	public String getEmpEmalAdrEcpVl() {
		return empEmalAdrEcpVl;
	}

	public void setEmpEmalAdrEcpVl(String empEmalAdrEcpVl) {
		if(!StringUtils.isBlank(empEmalAdrEcpVl)){
			this.empEmalAdrEcpVl = CryptoUtil.getEncryption(empEmalAdrEcpVl);
		}
		else {
			this.empEmalAdrEcpVl = empEmalAdrEcpVl;
		}
	}


	public String getAcnoEcpVlDec() {
		if(!StringUtils.isBlank(acnoEcpVl)){
			return CryptoUtil.getDecryption(acnoEcpVl);
		}
		else{
			return acnoEcpVl;
		}
	}

	public String getAcnoEcpVl() {
		return acnoEcpVl;
	}

	public void setAcnoEcpVl(String acnoEcpVl) {
		if(!StringUtils.isBlank(acnoEcpVl)){
			this.acnoEcpVl = CryptoUtil.getEncryption(acnoEcpVl);
		}
		else {
			this.acnoEcpVl = acnoEcpVl;
		}
	}

	public List<Long> getArrDocBoxSqncNo() { return arrDocBoxSqncNo; } public void setArrDocBoxSqncNo(List<Long> arrDocBoxSqncNo) { this.arrDocBoxSqncNo = arrDocBoxSqncNo; }
	public String getStrArrDocBoxSqncNo() { return strArrDocBoxSqncNo; } public void setStrArrDocBoxSqncNo(String strArrDocBoxSqncNo) { this.strArrDocBoxSqncNo = strArrDocBoxSqncNo; }

	public List<GA01N602ModVO> getInputGrd() { return inputGrd; } public void setInputGrd(List<GA01N602ModVO> inputGrd) { this.inputGrd = inputGrd; }

	public List<AprvWrrptInVO> getAprvl() {
		return aprvl;
	} public void setAprvl(List<AprvWrrptInVO> aprvl) {
		this.aprvl = aprvl;
	}

}
