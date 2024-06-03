package com.miraeasset.biz.common.util.altok.vo;

import com.miraeasset.biz.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

public class AltokIn00VO extends BaseVO {
    @ApiModelProperty(notes = "발송일자")
    private String sndDt;
    @ApiModelProperty(notes = "발송ID")
    private String sndId;
    @ApiModelProperty(notes = "문자메시지코드(CS02C071)")
    private String letrMsgCd;
    @ApiModelProperty(notes = "문자메시지일련번호(CS02C071)")
    private String letrMsgSrno;
    @ApiModelProperty(notes = "알림톡전송내용(CS02C071)")
    private String altokFwdCn;
    @ApiModelProperty(notes = "발신대상전화번호")
    private String dpmsgObjTlno;
    @ApiModelProperty(notes = "수신대상전화번호")
    private String rvObjTlno;

    public String getSndDt() {
        return sndDt;
    }

    public void setSndDt(String sndDt) {
        this.sndDt = sndDt;
    }

    public String getSndId() {
        return sndId;
    }

    public void setSndId(String sndId) {
        this.sndId = sndId;
    }

    public String getLetrMsgCd() {
        return letrMsgCd;
    }

    public void setLetrMsgCd(String letrMsgCd) {
        this.letrMsgCd = letrMsgCd;
    }

    public String getLetrMsgSrno() {
        return letrMsgSrno;
    }

    public void setLetrMsgSrno(String letrMsgSrno) {
        this.letrMsgSrno = letrMsgSrno;
    }

    public String getAltokFwdCn() {
        return altokFwdCn;
    }

    public void setAltokFwdCn(String altokFwdCn) {
        this.altokFwdCn = altokFwdCn;
    }

    public String getDpmsgObjTlno() {
        return dpmsgObjTlno;
    }

    public void setDpmsgObjTlno(String dpmsgObjTlno) {
        this.dpmsgObjTlno = dpmsgObjTlno;
    }

    public String getRvObjTlno() {
        return rvObjTlno;
    }

    public void setRvObjTlno(String rvObjTlno) {
        this.rvObjTlno = rvObjTlno;
    }
}

/***
 * 참고용 쿼리
 -- 발송ID 획득 SQ
 SELECT 'K' || '' || LPAD(SQ_FW04N904_01.NEXTVAL, 8, '0') "snd_id"
   FROM DUAL;

 -- 알림톡 발송
 INSERT INTO FW04N904
 (
     SND_DT,
     SND_ID,
     BZ_CD,
     CS_NO,
     ACNO,
     PGM_TCD,
     PGM_ID,
     LETR_MSG_CD,
     LETR_MSG_SRNO,
     RPT_FILE_NM,
     SND_RQM_DTTM,
     FWD_PRI_VL,
     ALTOK_FWD_CN,
     DPMSG_OBJ_TLNO ,
     RV_OBJ_TLNO ,
     SND_MDA_CTRY_CD ,
     EAI_DATA_OCCR_DTTM ,
     EAI_DATA_PRC_SCD ,
     EAI_PROC_PRC_DTTM ,
     EAI_PROC_TCD ,
     OPTR_ID ,
     OPRT_CHNL_CD ,
     OPRT_ORZ_CD ,
     OPRT_IP_ADR ,
     OPRT_DTTM ,
     DPMSG_KEY_CD ,
     CAST_PRC_YN
     ) VALUES (
     TO_CHAR(SYSDATE, 'YYYYMMDD'),
     :SND_ID,
     'GA',
     '',
     '',
     '01',
     'X',
     'GA001',
     '3',
     '',
     TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS'),
     'F',
     (SELECT REPLACE(REPLACE(REPLACE(SMS_LSM_CN, '#{신청자명}', '이정준'), '#{직위명}', '매니저'), '#{메뉴}', '테스트메뉴') AS SMS_LSM_CN
     FROM CS02C071
     WHERE LETR_MSG_CD = 'GA001'
     AND LETR_MSG_SRNO = '3'
     AND LETR_MSG_DL_SRNO = '3'),
     '24+hyt30tLRDNKChwdhq6A==',
     '24+hyt30tLRDNKChwdhq6A==',
     '82',
     TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS'),
     'N',
     NULL,
     NULL,
     '3360135',
     '000',
     'F04001',
     '0.0.0.0',
     SYSDATE,
     '6e1acc76d28f471125776b34ce8dace46870cc9d',
     'N'
 );
 ***/