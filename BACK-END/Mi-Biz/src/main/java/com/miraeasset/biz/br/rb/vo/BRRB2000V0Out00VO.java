package com.miraeasset.biz.br.rb.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BRRB2000V0Out00VO {

    public BRRB2000V0Out00VO() {

    }

    public BRRB2000V0Out00VO(int rank, int sortSqn, String acsjCdNm) {
        this.rank = rank;
        this.sortSqn = sortSqn;
        this.acsjCdNm = acsjCdNm;
    }

    public BRRB2000V0Out00VO(int rank, int sortSqn, String acsjCdNm, BigDecimal sumA) {
        this.rank = rank;
        this.sortSqn = sortSqn;
        this.acsjCdNm = acsjCdNm;
        this.sumA = sumA;
    }

    @ApiModelProperty(notes = "계정명")
    private String acsjCdNm;
    @ApiModelProperty(notes = "합계금액")
    private BigDecimal sumA = BigDecimal.valueOf(0);
    @ApiModelProperty(notes = "순위", example = "0")
    private int rank;
    @ApiModelProperty(notes = "자식계정리스트")
    private List<BRRB2000V0Out00VO> childAcsjList = new ArrayList<>();
    @ApiModelProperty(notes = "정렬순서", example = "0")
    private int sortSqn;

    public String getAcsjCdNm() {
        return acsjCdNm;
    }

    public void setAcsjCdNm(String acsjCdNm) {
        this.acsjCdNm = acsjCdNm;
    }

    public BigDecimal getSumA() {
        return sumA;
    }

    public void setSumA(BigDecimal sumA) {
        this.sumA = sumA;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSortSqn() {
        return sortSqn;
    }

    public void setSortSqn(int sortSqn) {
        this.sortSqn = sortSqn;
    }

    public List<BRRB2000V0Out00VO> getChildAcsjList() {
        return childAcsjList;
    }

    public void setChildAcsjList(List<BRRB2000V0Out00VO> childAcsjList) {
        this.childAcsjList = childAcsjList;
    }

    public void addChildAcsjList(BRRB2000V0Out00VO childAcsj) {
        this.childAcsjList.add(childAcsj);
    }

    public BigDecimal getChildSumA() {
        BigDecimal sumA = BigDecimal.valueOf(0);

        List<BRRB2000V0Out00VO> childQueue = new ArrayList<>();
        for(BRRB2000V0Out00VO childAcsj : this.childAcsjList) {
            childQueue.add(childAcsj);
        }

        while(childQueue.size() > 0) {
            BRRB2000V0Out00VO childAcsj = childQueue.remove(0);

            if(childAcsj.getChildAcsjList() == null || childAcsj.getChildAcsjList().size() == 0) {
                if(childAcsj.sumA != null) {
                    sumA = sumA.add(childAcsj.getSumA());
                }
            } else {
                childQueue.addAll(childAcsj.getChildAcsjList());
            }
        }

        return sumA;
    }
}
