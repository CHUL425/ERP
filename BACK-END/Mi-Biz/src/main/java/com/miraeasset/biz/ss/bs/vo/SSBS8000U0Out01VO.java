package com.miraeasset.biz.ss.bs.vo;

import com.miraeasset.biz.common.vo.BaseVO;

public class SSBS8000U0Out01VO extends BaseVO {
    private String cdKndNo;
    private String cmnCdVl;
    private String cmnCdVlDefCn;
    private String cdDesc;
    private String useYn;
    private int sortSqn;
    private String userDefVl1;
    private String userDefVl2;

    public void setCdKndNo(String cdKndNo) {
        this.cdKndNo = cdKndNo;
    }

    public String getCmnCdVl() {
        return cmnCdVl;
    }

    public String getCdKndNo() {
        return cdKndNo;
    }

    public void setCmnCdVl(String cmnCdVl) {
        this.cmnCdVl = cmnCdVl;
    }

    public String getCmnCdVlDefCn() {
        return cmnCdVlDefCn;
    }

    public void setCmnCdVlDefCn(String cmnCdVlDefCn) {
        this.cmnCdVlDefCn = cmnCdVlDefCn;
    }

    public String getCdDesc() {
        return cdDesc;
    }

    public void setCdDesc(String cdDesc) {
        this.cdDesc = cdDesc;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    public int getSortSqn() {
        return sortSqn;
    }

    public void setSortSqn(int sortSqn) {
        this.sortSqn = sortSqn;
    }

    public String getUserDefVl1() {
        return userDefVl1;
    }

    public void setUserDefVl1(String userDefVl1) {
        this.userDefVl1 = userDefVl1;
    }

    public String getUserDefVl2() {
        return userDefVl2;
    }

    public void setUserDefVl2(String userDefVl2) {
        this.userDefVl2 = userDefVl2;
    }
}
