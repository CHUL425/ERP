package com.miraeasset.biz.budget.vo;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@Component
public class BGT53200Out00VO {

    @ApiModelProperty(notes= "회기", required = true, example ="49")
    private String sesnTcd;             // 회기
    @ApiModelProperty(notes= "예산팀점코드", required = true, example ="S03001")
    private String bdgtOrzCd;           // 예산팀점코드
    @ApiModelProperty(notes= "예산년월")
    private String bdgtYm;              // 예산년월
    @ApiModelProperty(notes= "누젹어부")
    private String accmYn;              // 누적여부
    @ApiModelProperty(notes= "조회_예산년월시작")
    private String bdgtYmFr;            // 예산년월
    @ApiModelProperty(notes= "조회_예산년월종료")
    private String bdgtYmTo;            // 예산년월
    @ApiModelProperty(notes= "조회_조회구분", example ="1")
    private String qryTp;               // 조회구분


    @ApiModelProperty(notes= "예산계정과목구분코드")
    private String bdgtAcsjCd; 	/* 예산계정과목코드 */
    @ApiModelProperty(notes= "예산계정과목코드명")
    private String bdgtAcsjCdNm;	/* 예산계정과목코드명 */
    @ApiModelProperty(notes= "예산통제여부")
    private String bdgtCtrlYn; 	/* 예산통제여부 */
    @ApiModelProperty(notes= "기초배정금액")
    private String basAssnP; 		/* 기초배정금액 */
    @ApiModelProperty(notes= "조정금액")
    private String adjtA; 			/* 조정금액 */
    @ApiModelProperty(notes= "전용금액")
    private String onlyA; 			/* 전용금액 */
    @ApiModelProperty(notes= "추가배정금액")
    private String adAsnA; 		/* 추가배정금액 */
    @ApiModelProperty(notes= "예산삭감금액")
    private String bdgtCutbA; 	/* 예산삭감금액 */
    @ApiModelProperty(notes= "조기금액")
    private String vanP; 			/* 조기금액 */
    @ApiModelProperty(notes= "이월금액")
    private String trnsP; 			/* 이월금액 */
    @ApiModelProperty(notes= "대체금액")
    private String altA; 			/* 대체금액 */
    @ApiModelProperty(notes= "조정예산금액")
    private String adjtBgtP; 		/* 조정예산금액 */
    @ApiModelProperty(notes= "결의실적금액")
    private String rslnRstsA; 	/* 결의실적금액 */
    @ApiModelProperty(notes= "결의승인금액")
    private String rslnApvA; 		/* 결의승인금액 */
    @ApiModelProperty(notes= "결의잔액")
    private String dcsRmp; 		/* 결의잔액 */
    @ApiModelProperty(notes= "승인잔액")
    private String admsRmp; 		/* 승인잔액 */
    @ApiModelProperty(notes= "결의집행율", example = "0")
    private double dcsExer; 		/* 결의집행율 */
    @ApiModelProperty(notes= "승인집행율", example = "0")
    private double admsExer; 		/* 승인집행율 */
    @ApiModelProperty(notes= "편성대비승인집행율", example = "0")
    private double fmtnAdmsExer;		/*	편성대비승인집행율		*/
    @ApiModelProperty(notes= "배정대비승인집행율", example = "0")
    private double ansAdmsExer;		/*	배정대비승인집행율		*/
    @ApiModelProperty(notes= "예산편성금액")
    private String bdgtFmtnA; 		/* 예산편성금액 */


    @Override
    public String toString() {
        return "Main00VO{" +
                "sesnTcd='" + sesnTcd + '\'' +
                ", bdgtOrzCd='" + bdgtOrzCd + '\'' +
                ", bdgtYm='" + bdgtYm + '\'' +
                ", accmYn='" + accmYn + '\'' +
                ", bdgtYmFr='" + bdgtYmFr + '\'' +
                ", bdgtYmTo='" + bdgtYmTo + '\'' +
                ", qryTp='" + qryTp + '\'' +
                ", bdgtAcsjCd='" + bdgtAcsjCd + '\'' +
                ", bdgtAcsjCdNm='" + bdgtAcsjCdNm + '\'' +
                ", bdgtCtrlYn='" + bdgtCtrlYn + '\'' +
                ", basAssnP='" + basAssnP + '\'' +
                ", adjtA='" + adjtA + '\'' +
                ", onlyA='" + onlyA + '\'' +
                ", adAsnA='" + adAsnA + '\'' +
                ", bdgtCutbA='" + bdgtCutbA + '\'' +
                ", vanP='" + vanP + '\'' +
                ", trnsP='" + trnsP + '\'' +
                ", altA='" + altA + '\'' +
                ", adjtBgtP='" + adjtBgtP + '\'' +
                ", rslnRstsA='" + rslnRstsA + '\'' +
                ", rslnApvA='" + rslnApvA + '\'' +
                ", dcsRmp='" + dcsRmp + '\'' +
                ", admsRmp='" + admsRmp + '\'' +
                ", dcsExer=" + dcsExer +
                ", admsExer=" + admsExer +
                ", fmtnAdmsExer=" + fmtnAdmsExer +
                ", ansAdmsExer=" + ansAdmsExer +
                ", bdgtFmtnA='" + bdgtFmtnA + '\'' +
                '}';
    }

    public String getSesnTcd() {
        return sesnTcd;
    }

    public void setSesnTcd(String sesnTcd) {
        this.sesnTcd = sesnTcd;
    }

    public String getBdgtOrzCd() {
        return bdgtOrzCd;
    }

    public void setBdgtOrzCd(String bdgtOrzCd) {
        this.bdgtOrzCd = bdgtOrzCd;
    }

    public String getBdgtYm() {
        return bdgtYm;
    }

    public void setBdgtYm(String bdgtYm) {
        this.bdgtYm = bdgtYm;
    }

    public String getAccmYn() {
        return accmYn;
    }

    public void setAccmYn(String accmYn) {
        this.accmYn = accmYn;
    }

    public String getBdgtYmFr() {
        return bdgtYmFr;
    }

    public void setBdgtYmFr(String bdgtYmFr) {
        this.bdgtYmFr = bdgtYmFr;
    }

    public String getBdgtYmTo() {
        return bdgtYmTo;
    }

    public void setBdgtYmTo(String bdgtYmTo) {
        this.bdgtYmTo = bdgtYmTo;
    }

    public String getQryTp() {
        return qryTp;
    }

    public void setQryTp(String qryTp) {
        this.qryTp = qryTp;
    }

    public String getBdgtAcsjCd() {
        return bdgtAcsjCd;
    }

    public void setBdgtAcsjCd(String bdgtAcsjCd) {
        this.bdgtAcsjCd = bdgtAcsjCd;
    }

    public String getBdgtAcsjCdNm() {
        return bdgtAcsjCdNm;
    }

    public void setBdgtAcsjCdNm(String bdgtAcsjCdNm) {
        this.bdgtAcsjCdNm = bdgtAcsjCdNm;
    }

    public String getBdgtCtrlYn() {
        return bdgtCtrlYn;
    }

    public void setBdgtCtrlYn(String bdgtCtrlYn) {
        this.bdgtCtrlYn = bdgtCtrlYn;
    }

    public String getBasAssnP() {
        return basAssnP;
    }

    public void setBasAssnP(String basAssnP) {
        this.basAssnP = basAssnP;
    }

    public String getAdjtA() {
        return adjtA;
    }

    public void setAdjtA(String adjtA) {
        this.adjtA = adjtA;
    }

    public String getOnlyA() {
        return onlyA;
    }

    public void setOnlyA(String onlyA) {
        this.onlyA = onlyA;
    }

    public String getAdAsnA() {
        return adAsnA;
    }

    public void setAdAsnA(String adAsnA) {
        this.adAsnA = adAsnA;
    }

    public String getBdgtCutbA() {
        return bdgtCutbA;
    }

    public void setBdgtCutbA(String bdgtCutbA) {
        this.bdgtCutbA = bdgtCutbA;
    }

    public String getVanP() {
        return vanP;
    }

    public void setVanP(String vanP) {
        this.vanP = vanP;
    }

    public String getTrnsP() {
        return trnsP;
    }

    public void setTrnsP(String trnsP) {
        this.trnsP = trnsP;
    }

    public String getAltA() {
        return altA;
    }

    public void setAltA(String altA) {
        this.altA = altA;
    }

    public String getAdjtBgtP() {
        return adjtBgtP;
    }

    public void setAdjtBgtP(String adjtBgtP) {
        this.adjtBgtP = adjtBgtP;
    }

    public String getRslnRstsA() {
        return rslnRstsA;
    }

    public void setRslnRstsA(String rslnRstsA) {
        this.rslnRstsA = rslnRstsA;
    }

    public String getRslnApvA() {
        return rslnApvA;
    }

    public void setRslnApvA(String rslnApvA) {
        this.rslnApvA = rslnApvA;
    }

    public String getDcsRmp() {
        return dcsRmp;
    }

    public void setDcsRmp(String dcsRmp) {
        this.dcsRmp = dcsRmp;
    }

    public String getAdmsRmp() {
        return admsRmp;
    }

    public void setAdmsRmp(String admsRmp) {
        this.admsRmp = admsRmp;
    }

    public double getDcsExer() {
        return dcsExer;
    }

    public void setDcsExer(double dcsExer) {
        this.dcsExer = dcsExer;
    }

    public double getAdmsExer() {
        return admsExer;
    }

    public void setAdmsExer(double admsExer) {
        this.admsExer = admsExer;
    }

    public double getFmtnAdmsExer() {
        return fmtnAdmsExer;
    }

    public void setFmtnAdmsExer(double fmtnAdmsExer) {
        this.fmtnAdmsExer = fmtnAdmsExer;
    }

    public double getAnsAdmsExer() {
        return ansAdmsExer;
    }

    public void setAnsAdmsExer(double ansAdmsExer) {
        this.ansAdmsExer = ansAdmsExer;
    }

    public String getBdgtFmtnA() {
        return bdgtFmtnA;
    }

    public void setBdgtFmtnA(String bdgtFmtnA) {
        this.bdgtFmtnA = bdgtFmtnA;
    }
}
