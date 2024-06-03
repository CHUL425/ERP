package com.miraeasset.biz.ss.bs.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class SSBS8000U0In00VO {
    @ApiModelProperty(notes = "코드종류번호", example = "UNIF_RQS_PCD")
    private String cdKndNo;
    @ApiModelProperty(notes = "코드종류명", example = "통합신청유형코드")
    private String cdKndNm;
    @ApiModelProperty(notes= "페이지사이즈", example="0")
    private BigDecimal pageSize = BigDecimal.valueOf(0);      // 페이지사이즈
    @ApiModelProperty(notes= "페이지순번", example="0")
    private BigDecimal pageIndex = BigDecimal.valueOf(0);     // 페이지순번

    public String getCdKndNo() {
        return cdKndNo;
    }

    public void setCdKndNo(String cdKndNo) {
        this.cdKndNo = cdKndNo;
    }

    public String getCdKndNm() {
        return cdKndNm;
    }

    public void setCdKndNm(String cdKndNm) {
        this.cdKndNm = cdKndNm;
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
}
