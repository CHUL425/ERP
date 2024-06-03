package com.miraeasset.biz.common.util.altok.vo;

import java.util.Date;

public class AltokOut01VO extends AltokIn01VO {
    private String altokRefSeq;
    private String sndRscdVl;
    private String sndRsltMsgCn;
    private Date sndCfmtTmd;
    private String castPrcYn;
    private String eaiDataOccrDttm;
    private String eaiDataPrcScd;
    private String eaiProcPrcDttm;
    private String eaiProcTcd;

    public String getAltokRefSeq() {
        return altokRefSeq;
    }

    public void setAltokRefSeq(String altokRefSeq) {
        this.altokRefSeq = altokRefSeq;
    }

    public String getSndRscdVl() {
        return sndRscdVl;
    }

    public void setSndRscdVl(String sndRscdVl) {
        this.sndRscdVl = sndRscdVl;
    }

    public String getSndRsltMsgCn() {
        return sndRsltMsgCn;
    }

    public void setSndRsltMsgCn(String sndRsltMsgCn) {
        this.sndRsltMsgCn = sndRsltMsgCn;
    }

    public Date getSndCfmtTmd() {
        return sndCfmtTmd;
    }

    public void setSndCfmtTmd(Date sndCfmtTmd) {
        this.sndCfmtTmd = sndCfmtTmd;
    }

    public String getCastPrcYn() {
        return castPrcYn;
    }

    public void setCastPrcYn(String castPrcYn) {
        this.castPrcYn = castPrcYn;
    }

    public String getEaiDataOccrDttm() {
        return eaiDataOccrDttm;
    }

    public void setEaiDataOccrDttm(String eaiDataOccrDttm) {
        this.eaiDataOccrDttm = eaiDataOccrDttm;
    }

    public String getEaiDataPrcScd() {
        return eaiDataPrcScd;
    }

    public void setEaiDataPrcScd(String eaiDataPrcScd) {
        this.eaiDataPrcScd = eaiDataPrcScd;
    }

    public String getEaiProcPrcDttm() {
        return eaiProcPrcDttm;
    }

    public void setEaiProcPrcDttm(String eaiProcPrcDttm) {
        this.eaiProcPrcDttm = eaiProcPrcDttm;
    }

    public String getEaiProcTcd() {
        return eaiProcTcd;
    }

    public void setEaiProcTcd(String eaiProcTcd) {
        this.eaiProcTcd = eaiProcTcd;
    }
}
