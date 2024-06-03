package com.miraeasset.biz.rq.rr.vo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.vo.BaseVO;
import com.miraeasset.biz.rq.ur.vo.RQUR1000U0In11VO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQRR1000U0VO extends BaseVO {
	
    @ApiModelProperty(notes= "조회시작일자", required = true)
    private String qryStrtDt;            // 조회시작일자
    @ApiModelProperty(notes= "조회종료일자", required = true)
    private String qryEndDt;            // 조회종료일자

    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize;      // 페이지사이즈
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex;     // 페이지순번
    
	@ApiModelProperty(notes= "순번", example="0")
	private BigDecimal rnum       ; /* 순번            */        
	@ApiModelProperty(notes= "전체건수", example="0")
	private BigDecimal alCnt      ; /* 전체건수             */
	
	@ApiModelProperty(notes= "처리구분")
	private String prcTp           ; /*처리구분         */
	
	@ApiModelProperty(notes= "접수번호")
    private String rctNo         ; // 접수번호
	
    @ApiModelProperty(notes= "신청조직코드")
    private String rqsOrzCd      ; /*신청조직코드    */
    @ApiModelProperty(notes= "신청조직명")
    private String rqsOrzNm      ; /*신청조직명    */
    @ApiModelProperty(notes= "신청사원번호")
    private String rqsEpno       ; /*신청사원번호    */
    @ApiModelProperty(notes= "신청사원명")
    private String rqsEpNm       ; /*신청사원명    */
    @ApiModelProperty(notes= "신청사원휴대전화번호")
    private String rqsEpHndpTlno ; /*신청사원휴대전화번호    */
    @ApiModelProperty(notes= "신청제목명")
    private String rqsTtlNm      ; /*신청제목명      */

	@ApiModelProperty(notes= "설치장소명")
	private String istPlcNm      ; /*설치장소명      */

    @ApiModelProperty(notes= "신청사유내용 ")
    private String rqsRsnCn      ; /*신청사유내용 */
    @ApiModelProperty(notes= "희망일자")
    private String hopeDt        ; /*희망일자        */
    @ApiModelProperty(notes= "신청일자")
    private String rqsDt         ; /*신청일자        */

    @ApiModelProperty(notes= "완료일자")
    private String cmpnDt        ; /*완료일자        */
    
	@ApiModelProperty(notes= "신청구분코드 신규/이전/AS ")
    private String unifRqsTcd        ; // 신청구분코드 
	@ApiModelProperty(notes= "신청구분코드명 ")
    private String unifRqsTcdNm      ; // 신청구분코드명     

	
    @ApiModelProperty(notes= "신청유형코드 공사/구매/렌탈...")
    private String unifRqsPcd        ; /*신청유형코드    */
    @ApiModelProperty(notes= "신청유형코드명")
    private String unifRqsPcdNm      ; /*신청유형코드명    */

    @ApiModelProperty(notes= "신청상세유형코드")
    private String unifRqsDlPcd     ; /*신청상세유형코드  정수기외/복합기  */
    @ApiModelProperty(notes= "신청상세유형코드명")
    private String unifRqsDlPcdNm   ; /*신청상세유형코드명    */

    @ApiModelProperty(notes= "결재상신관리번호")
    private String aprvWrrptMtNo   ; /*결재상신관리번호    */
    @ApiModelProperty(notes= "결재상신조직코드")
    private String aprvWrrptOrzCd  ; /* 결재상신조직코드 */
    
    @ApiModelProperty(notes= "신청상태코드")
    private String rqsScd        ; /*신청상태코드    */
    @ApiModelProperty(notes= "신청상태코드명")
    private String rqsScdNm      ; /*신청상태코드명    */ 
    @ApiModelProperty(notes= "접수상세번호")
    private String rctDlNo;          // 접수상세번호
    @ApiModelProperty(notes= "장비구분코드")
    private String eqmtTcd       ;  /*장비구분코드    */
	@ApiModelProperty(notes= "장비구분코드명")
	private String eqmtTcdNm     ; /*장비구분코드명   */
    @ApiModelProperty(notes= "임대계약번호")
    private String rentCntcNo    ;  /*임대계약번호    */
    @ApiModelProperty(notes= "제품명")
    private String gdsNm         ;  /*제품명          */
    @ApiModelProperty(notes= "신청요청사항내용 ")
    private String rqsRqmPtcrCn  ;  /*신청요청사항내용   */
    
	@ApiModelProperty(notes= "신청상태코드00")
	private String rqsScd00          ; /*신청상태코드00     */
	@ApiModelProperty(notes= "신청상태코드01")
	private String rqsScd01          ; /*신청상태코드01     */
	@ApiModelProperty(notes= "신청상태코드02")
	private String rqsScd02          ; /*신청상태코드02     */
	@ApiModelProperty(notes= "신청상태코드03")
	private String rqsScd03          ; /*신청상태코드03     */
	@ApiModelProperty(notes= "신청상태코드04")
	private String rqsScd04          ; /*신청상태코드04     */
	@ApiModelProperty(notes= "신청상태코드05")
	private String rqsScd05          ; /*신청상태코드05     */
	@ApiModelProperty(notes= "신청상태코드06")
	private String rqsScd06          ; /*신청상태코드06     */
	
//    @ApiModelProperty(notes= "조작자ID")
//    private String optrId        ;  /*조작자ID        */
//    @ApiModelProperty(notes= "조작채널코드")
//    private String oprtChnlCd    ;  /*조작채널코드    */
//    @ApiModelProperty(notes= "조작조직코드")
//    private String oprtOrzCd     ;  /*조작조직코드    */
//    @ApiModelProperty(notes= "조작IP주소")
//    private String oprtIpAdr     ;  /*조작IP주소      */
    
	
	@ApiModelProperty(hidden=true)
    private List<String> arrRqsScd; /* 신청상태코드_배열 */
	
    public List<String> getArrRqsScd() {
		return arrRqsScd;
	}

	public void setArrRqsScd(List<String> arrRqsScd) {
		this.arrRqsScd = arrRqsScd;
	}

	@ApiModelProperty(notes= "삭제대상 렌탈신청목록")
    List<RQRR1000U0In03VO> grid;    // 삭제대상 렌탈신청목록

    @ApiModelProperty(notes= "완료대상 렌탈신청목록")
    List<RQRR1000U0In05VO> grid5;    // 완료대상 렌탈신청목록
    
	@ApiModelProperty(notes= "렌탈신청 제품정보")
    List<RQUR1000U0In11VO> grid12;    // 렌탈신청 제품정보    

	public String getQryStrtDt() {
		return qryStrtDt;
	}

	public void setQryStrtDt(String qryStrtDt) {
		this.qryStrtDt = qryStrtDt;
	}

	public String getQryEndDt() {
		return qryEndDt;
	}

	public void setQryEndDt(String qryEndDt) {
		this.qryEndDt = qryEndDt;
	}

	public BigDecimal getPageSize() {
		return pageSize;
	}

	public void setPageSize(BigDecimal pageSize) {
		this.pageSize = pageSize;
	}

	public BigDecimal getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(BigDecimal pageIndex) {
		this.pageIndex = pageIndex;
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

	public String getPrcTp() {
		return prcTp;
	}

	public void setPrcTp(String prcTp) {
		this.prcTp = prcTp;
	}

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public String getRqsOrzCd() {
		return rqsOrzCd;
	}

	public void setRqsOrzCd(String rqsOrzCd) {
		this.rqsOrzCd = rqsOrzCd;
	}

	public String getRqsOrzNm() {
		return rqsOrzNm;
	}

	public void setRqsOrzNm(String rqsOrzNm) {
		this.rqsOrzNm = rqsOrzNm;
	}

	public String getRqsEpno() {
		return rqsEpno;
	}

	public void setRqsEpno(String rqsEpno) {
		this.rqsEpno = rqsEpno;
	}

	public String getRqsEpNm() {
		return rqsEpNm;
	}

	public void setRqsEpNm(String rqsEpNm) {
		this.rqsEpNm = rqsEpNm;
	}

	public String getRqsEpHndpTlno() {
		return rqsEpHndpTlno;
	}

	public void setRqsEpHndpTlno(String rqsEpHndpTlno) {
		this.rqsEpHndpTlno = rqsEpHndpTlno;
	}

	public String getRqsTtlNm() {
		return rqsTtlNm;
	}

	public void setRqsTtlNm(String rqsTtlNm) {
		this.rqsTtlNm = rqsTtlNm;
	}

	public String getRqsRsnCn() {
		return rqsRsnCn;
	}

	public void setRqsRsnCn(String rqsRsnCn) {
		this.rqsRsnCn = rqsRsnCn;
	}

	public String getHopeDt() {
		return hopeDt;
	}

	public void setHopeDt(String hopeDt) {
		this.hopeDt = hopeDt;
	}

	public String getRqsDt() {
		return rqsDt;
	}

	public void setRqsDt(String rqsDt) {
		this.rqsDt = rqsDt;
	}

	public String getCmpnDt() {
		return cmpnDt;
	}

	public void setCmpnDt(String cmpnDt) {
		this.cmpnDt = cmpnDt;
	}

	public String getUnifRqsTcd() {
		return unifRqsTcd;
	}

	public void setUnifRqsTcd(String unifRqsTcd) {
		this.unifRqsTcd = unifRqsTcd;
	}

	public String getUnifRqsTcdNm() {
		return unifRqsTcdNm;
	}

	public void setUnifRqsTcdNm(String unifRqsTcdNm) {
		this.unifRqsTcdNm = unifRqsTcdNm;
	}

	public String getUnifRqsPcd() {
		return unifRqsPcd;
	}

	public void setUnifRqsPcd(String unifRqsPcd) {
		this.unifRqsPcd = unifRqsPcd;
	}

	public String getUnifRqsPcdNm() {
		return unifRqsPcdNm;
	}

	public void setUnifRqsPcdNm(String unifRqsPcdNm) {
		this.unifRqsPcdNm = unifRqsPcdNm;
	}

	public String getUnifRqsDlPcd() {
		return unifRqsDlPcd;
	}

	public void setUnifRqsDlPcd(String unifRqsDlPcd) {
		this.unifRqsDlPcd = unifRqsDlPcd;
	}

	public String getUnifRqsDlPcdNm() {
		return unifRqsDlPcdNm;
	}

	public void setUnifRqsDlPcdNm(String unifRqsDlPcdNm) {
		this.unifRqsDlPcdNm = unifRqsDlPcdNm;
	}

	public String getAprvWrrptMtNo() {
		return aprvWrrptMtNo;
	}

	public void setAprvWrrptMtNo(String aprvWrrptMtNo) {
		this.aprvWrrptMtNo = aprvWrrptMtNo;
	}

	public String getRqsScd() {
		return rqsScd;
	}

	public void setRqsScd(String rqsScd) {
		this.rqsScd = rqsScd;
	}

	public String getRqsScdNm() {
		return rqsScdNm;
	}

	public void setRqsScdNm(String rqsScdNm) {
		this.rqsScdNm = rqsScdNm;
	}

	public String getRctDlNo() {
		return rctDlNo;
	}

	public void setRctDlNo(String rctDlNo) {
		this.rctDlNo = rctDlNo;
	}

	public String getEqmtTcd() {
		return eqmtTcd;
	}

	public void setEqmtTcd(String eqmtTcd) {
		this.eqmtTcd = eqmtTcd;
	}

	public String getEqmtTcdNm() {
		return eqmtTcdNm;
	}

	public void setEqmtTcdNm(String eqmtTcdNm) {
		this.eqmtTcdNm = eqmtTcdNm;
	}

	public String getRentCntcNo() {
		return rentCntcNo;
	}

	public void setRentCntcNo(String rentCntcNo) {
		this.rentCntcNo = rentCntcNo;
	}

	public String getGdsNm() {
		return gdsNm;
	}

	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}

	public String getRqsRqmPtcrCn() {
		return rqsRqmPtcrCn;
	}

	public void setRqsRqmPtcrCn(String rqsRqmPtcrCn) {
		this.rqsRqmPtcrCn = rqsRqmPtcrCn;
	}

	public String getRqsScd00() {
		return rqsScd00;
	}

	public void setRqsScd00(String rqsScd00) {
		this.rqsScd00 = rqsScd00;
	}

	public String getRqsScd01() {
		return rqsScd01;
	}

	public void setRqsScd01(String rqsScd01) {
		this.rqsScd01 = rqsScd01;
	}

	public String getRqsScd02() {
		return rqsScd02;
	}

	public void setRqsScd02(String rqsScd02) {
		this.rqsScd02 = rqsScd02;
	}

	public String getRqsScd03() {
		return rqsScd03;
	}

	public void setRqsScd03(String rqsScd03) {
		this.rqsScd03 = rqsScd03;
	}

	public String getRqsScd04() {
		return rqsScd04;
	}

	public void setRqsScd04(String rqsScd04) {
		this.rqsScd04 = rqsScd04;
	}

	public String getRqsScd05() {
		return rqsScd05;
	}

	public void setRqsScd05(String rqsScd05) {
		this.rqsScd05 = rqsScd05;
	}

	public String getRqsScd06() {
		return rqsScd06;
	}

	public void setRqsScd06(String rqsScd06) {
		this.rqsScd06 = rqsScd06;
	}

	public String getIstPlcNm() {
		return istPlcNm;
	} public void setIstPlcNm(String istPlcNm) {
		this.istPlcNm = istPlcNm;
	}
	public String getAprvWrrptOrzCd() {
		return aprvWrrptOrzCd;
	}
	
	public void setAprvWrrptOrzCd(String aprvWrrptOrzCd) {
		this.aprvWrrptOrzCd = aprvWrrptOrzCd;
	}

//	public String getOptrId() {
//		return optrId;
//	}
//
//	public void setOptrId(String optrId) {
//		this.optrId = optrId;
//	}
//
//	public String getOprtChnlCd() {
//		return oprtChnlCd;
//	}
//
//	public void setOprtChnlCd(String oprtChnlCd) {
//		this.oprtChnlCd = oprtChnlCd;
//	}
//
//	public String getOprtOrzCd() {
//		return oprtOrzCd;
//	}
//
//	public void setOprtOrzCd(String oprtOrzCd) {
//		this.oprtOrzCd = oprtOrzCd;
//	}
//
//	public String getOprtIpAdr() {
//		return oprtIpAdr;
//	}
//
//	public void setOprtIpAdr(String oprtIpAdr) {
//		this.oprtIpAdr = oprtIpAdr;
//	}


	public List<RQRR1000U0In03VO> getGrid() {
		return grid;
	}

	public void setGrid(List<RQRR1000U0In03VO> grid) {
		this.grid = grid;
	}

	public List<RQRR1000U0In05VO> getGrid5() {
		return grid5;
	}

	public void setGrid5(List<RQRR1000U0In05VO> grid5) {
		this.grid5 = grid5;
	}

	public List<RQUR1000U0In11VO> getGrid12() {
		return grid12;
	}

	public void setGrid12(List<RQUR1000U0In11VO> grid12) {
		this.grid12 = grid12;
	}

	
	
	
}
