package com.miraeasset.biz.br.fb.vo;


import com.miraeasset.biz.br.er.vo.BRER1000U0Out00VO;
import com.miraeasset.biz.br.er.vo.BRER2000U0Out00VO;
import com.miraeasset.biz.br.er.vo.BRER3000U0Out00VO;
import com.miraeasset.biz.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * 지점개요 - 지점상세조회
 * */
public class BRFB1000U0Out01VO extends BaseVO {
    @ApiModelProperty(notes = "조직코드", required = true)
    private String orzCd;
    @ApiModelProperty(notes = "임차유형코드(01:임차 / 02:사옥)", required = true)
    private String leasPcd;
    @ApiModelProperty(notes = "지도 파일번호")
    private String fileNo1;
    @ApiModelProperty(notes = "도면 파일번호")
    private String fileNo2;
    @ApiModelProperty(notes = "쇼룸 파일번호")
    private String fileNo3;
    @ApiModelProperty(notes = "옥외광고물 파일번호")
    private String fileNo4;

    public String getOrzCd() {
        return orzCd;
    }

    public void setOrzCd(String orzCd) {
        this.orzCd = orzCd;
    }

    public String getLeasPcd() {
        return leasPcd;
    }

    public void setLeasPcd(String leasPcd) {
        this.leasPcd = leasPcd;
    }

    public String getFileNo1() {
        return fileNo1;
    }

    public void setFileNo1(String fileNo1) {
        this.fileNo1 = fileNo1;
    }

    public String getFileNo2() {
        return fileNo2;
    }

    public void setFileNo2(String fileNo2) {
        this.fileNo2 = fileNo2;
    }

    public String getFileNo3() {
        return fileNo3;
    }

    public void setFileNo3(String fileNo3) {
        this.fileNo3 = fileNo3;
    }

    public String getFileNo4() {
        return fileNo4;
    }

    public void setFileNo4(String fileNo4) {
        this.fileNo4 = fileNo4;
    }
}