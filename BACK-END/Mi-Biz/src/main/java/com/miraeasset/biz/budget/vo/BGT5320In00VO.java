package com.miraeasset.biz.budget.vo;

import com.miraeasset.biz.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@Component
public class BGT5320In00VO extends BaseVO {

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
}
